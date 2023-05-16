 package org.techtown.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Button1Clicked(View v){
        Toast.makeText(getApplicationContext(),"네이버 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    public void Button2Clicked(View v){
        Toast.makeText(getApplicationContext(),"전화 걸기 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-2734-1966"));
        startActivity(myIntent);
    }

    public void Button3Clicked(View v){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }
}
