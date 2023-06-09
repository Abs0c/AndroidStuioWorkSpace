package com.gmail.qjfjrdl1001.ylp2;

import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class LeDeviceListAdapter extends BaseAdapter {
    private ArrayList<BluetoothDevice> mLeDevices;
    private LayoutInflater mInflator;
    public LeDeviceListAdapter() {
        super();
        mLeDevices = new ArrayList<BluetoothDevice>();
        //mInflator = BluetoothLeService.this.getLayoutInflater();
    }
    public void addDevice(BluetoothDevice device) {
        if(!mLeDevices.contains(device)) {
            mLeDevices.add(device);
        }
    }
    public BluetoothDevice getDevice(int position) {
        return mLeDevices.get(position);
    }
    public void clear() {
        mLeDevices.clear();
    }
    @Override
    public int getCount() {
        return mLeDevices.size();
    }
    @Override
    public Object getItem(int i) {
        return mLeDevices.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
