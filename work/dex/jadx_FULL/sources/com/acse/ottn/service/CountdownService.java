package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.acse.ottn.h2;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.o0;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CountdownService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f23196a = "CountdownService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        o0.a().a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        o0.a().b(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra(ze1.k);
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                o0.a().b(this, accessiblityModel);
            }
        } catch (Exception e) {
            try {
                h2.a(f23196a, "Exception =" + e.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
