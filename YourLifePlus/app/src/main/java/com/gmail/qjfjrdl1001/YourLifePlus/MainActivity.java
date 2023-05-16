package com.gmail.qjfjrdl1001.YourLifePlus;

        import androidx.annotation.Nullable;
        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.ActivityCompat;

        import android.Manifest;
        import android.app.ListActivity;
        import android.bluetooth.BluetoothAdapter;
        import android.bluetooth.BluetoothDevice;
        import android.bluetooth.BluetoothSocket;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.net.Uri;
        import android.os.Build;
        import android.os.Bundle;
        import android.os.Handler;
        import android.provider.Telephony;
        import android.telephony.SmsManager;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.nio.charset.Charset;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Set;
        import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 10;
    private BluetoothAdapter bluetoothAdapter;
    private Set<BluetoothDevice> devices;
    private BluetoothDevice bluetoothDevice;
    private BluetoothSocket bluetoothSocket = null;
    private OutputStream outputStream = null;
    private InputStream inputStream = null;
    private Thread workerThread = null;
    private byte[] readBuffer;
    private int readBufferPosition;
    private int pariedDeviceCount;

    private Button buttonSend;

    public double st_long;
    public double st_lati;
    //EditText textPhoneNo;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_ENABLE_BT:
                if(requestCode == RESULT_OK) {
                    selectBluetoothDevice();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {//앱이 실행되었을 때~~
        buttonSend = (Button)findViewById(R.id.sendmsg);
        bluetoothAdapter = bluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter == null){
            Toast.makeText(getApplicationContext(), "블루투스를 지원하지 않는 기기입니다.", Toast.LENGTH_LONG).show();
        }
        else{
            if(bluetoothAdapter.isEnabled() || bluetoothAdapter != null){
                selectBluetoothDevice();
            }
            else{
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, REQUEST_ENABLE_BT);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button a = (Button) findViewById(R.id.sendmsg);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//앱이 클릭 되면~~
                SmsManager smsManager = SmsManager.getDefault();
                getLoca();
                smsManager.sendTextMessage("01086077294", null, "현재 위치\n위도 : " + st_lati + "\n경도 : " + st_long, null, null);
                sendData("s");
            }
        });
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    private void getLoca() {//현재 위치파악해서 위도 경도 정리
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        st_lati = location.getLatitude();
        st_long = location.getLongitude();
        String msg = "위도 : " + st_lati + "\n경도 : " + st_long;
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        Log.i("위치", msg);
    }

    public void selectBluetoothDevice(){
        devices = bluetoothAdapter.getBondedDevices();
        pariedDeviceCount = devices.size();
        if(pariedDeviceCount == 0){
            Toast.makeText(getApplicationContext(), "블루투스 페어링을 진행해주세요.", Toast.LENGTH_LONG).show();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("페어링 되어있는 블루투스 디바이스 목록");
            List<String> list = new ArrayList<>();
            for(BluetoothDevice bluetoothDevice : devices){
                list.add(bluetoothDevice.getName());
            }
            list.add("취소");
            final CharSequence[] charSequences = list.toArray(new CharSequence[list.size()]);
            list.toArray(new CharSequence[list.size()]);

            builder.setItems(charSequences, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    connectDevice(charSequences[which].toString());
                }
            });

            builder.setCancelable(false);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    public void connectDevice(String deviceName){
        for(BluetoothDevice tempDevice: devices){
            if(deviceName.equals(tempDevice.getName())){
                bluetoothDevice = tempDevice;
                break;
            }
        }
        UUID uuid = java.util.UUID.fromString("0000FFE0-0000-1000-8000-00805F9B34FB"); //Rfcomm 채널?
        try{
            bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(uuid);
            bluetoothSocket.connect();
            outputStream = bluetoothSocket.getOutputStream();
            inputStream = bluetoothSocket.getInputStream();
            receiveData();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void receiveData(){
        final Handler handler = new Handler();
        readBufferPosition = 0;
        readBuffer = new byte[1024];

        workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(Thread.currentThread().isInterrupted()){
                    try{
                        int byteAvailable = inputStream.available();
                        if (byteAvailable > 0){
                            byte[] bytes = new byte[byteAvailable];
                            inputStream.read(bytes);
                            for (int i=9;i<byteAvailable;i++){
                                byte tempByte = bytes[i];
                                if(tempByte == '\n'){
                                    byte[] encodedBytes = new byte[readBufferPosition];
                                    System.arraycopy(readBuffer,0,encodedBytes,0,encodedBytes.length);
                                    final String text = new String(encodedBytes, "US-ASCII");
                                    readBufferPosition = 0;
                                }
                                else{
                                    readBuffer[readBufferPosition++]=tempByte;
                                }
                            }
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        workerThread.start();
    }

    public void sendData(String text){
        try{
            outputStream.write(text.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public class DeviceScanActivity extends ListActivity{

        private BluetoothAdapter bluetoothAdapter;
        private boolean mScanning;
        private Handler handler;

        private static final long SCAN_PERIOD = 10000;
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
        private void scanLeDevice(final boolean enable){
            if (enable){
                handler.postDelayed(new Runnable(){
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
                    @Override
                    public void run(){
                        mScanning=false;
                        bluetoothAdapter.stopLeScan(leScanCallback);
                    }
                }, SCAN_PERIOD);

                mScanning = true;
                bluetoothAdapter.startLeScan(leScanCallback);
            }else{
                mScanning = false;
                bluetoothAdapter.stopLeScan(leScanCallback);
            }
        }
    }

    private LeDeviceListAdapter leDeviceListAdapter;
    // Device scan callback.
    private BluetoothAdapter.LeScanCallback leScanCallback =
            new BluetoothAdapter.LeScanCallback() {
                @Override
                public void onLeScan(final BluetoothDevice device, int rssi,
                                     byte[] scanRecord) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            leDeviceListAdapter.addDevice(device);
                            leDeviceListAdapter.notifyDataSetChanged();
                        }
                    });
                }
            };
}




