package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.acse.ottn.h2;
import com.acse.ottn.i0;
import com.acse.ottn.model.AccessiblityModel;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CircleFlowService extends Service {
    public static String b = "MainService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AccessiblityModel f23195a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        i0.d().a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        i0.d().b(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra(ze1.k);
            this.f23195a = accessiblityModel;
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                i0.d().b(this, this.f23195a);
            }
        } catch (Exception e) {
            try {
                h2.a(b, "Exception =" + e.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
