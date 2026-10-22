package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class g0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f32648a;
    public Bundle b;
    public Context c;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("MessengerSrvConnection", "onServiceConnected");
        this.f32648a = new Messenger(iBinder);
        Message messageObtain = Message.obtain();
        messageObtain.setData(this.b);
        try {
            this.f32648a.send(messageObtain);
        } catch (Exception e) {
            e.getMessage();
        }
        Log.i("MessengerSrvConnection", "start unbind service.");
        try {
            this.c.unbindService(this);
            Log.i("MessengerSrvConnection", "unbind service end.");
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("MessengerSrvConnection", "onServiceDisconnected");
        this.f32648a = null;
        this.b = null;
        this.c = null;
    }
}
