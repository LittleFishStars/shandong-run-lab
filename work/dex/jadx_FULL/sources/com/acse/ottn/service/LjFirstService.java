package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import com.acse.ottn.e2;
import com.acse.ottn.h2;
import com.acse.ottn.model.AccessiblityModel;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LjFirstService extends Service {
    public static View b = null;
    public static WindowManager c = null;
    public static String d = "LjFirstService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Intent f23204a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        e2.a().a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        e2.a().b(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra(ze1.k);
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                e2.a().a(this, accessiblityModel);
            }
        } catch (Exception e) {
            try {
                h2.a(d, "Exception =" + e.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
