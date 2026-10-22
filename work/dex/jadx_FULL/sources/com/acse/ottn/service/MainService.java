package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import com.acse.ottn.h2;
import com.acse.ottn.m2;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.r1;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MainService extends Service implements com.acse.ottn.service.a.u0 {
    public static View c = null;
    public static WindowManager d = null;
    public static String e = "MainService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f23205a;
    public AccessiblityModel b;

    public class a implements r1.j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23206a;

        public a(String str) {
            this.f23206a = str;
        }

        @Override // com.acse.ottn.r1.j0
        public void a(int i, int i2) {
            if (i != 1) {
                m2.a().b(MainService.this);
            } else {
                if (i2 != 1) {
                    m2.a().b(MainService.this);
                    return;
                }
                m2 m2VarA = m2.a();
                MainService mainService = MainService.this;
                m2VarA.a(mainService, this.f23206a, mainService);
            }
        }
    }

    @Override // com.acse.ottn.service.a.u0
    public void a(String str) {
        r1.c().a(str, new a(str));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b() {
        m2.a().a(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        h2.c(e, "MainService Created");
        b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            h2.c(e, "onDestroy ");
            com.acse.ottn.service.a.b();
            com.acse.ottn.service.a.d();
            m2.a().b(this);
        } catch (Exception e2) {
            h2.c(e, "onDestroy e=" + e2.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra(ze1.k);
            this.b = accessiblityModel;
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                if (this.b.getData().getService_control().equals("0")) {
                    m2.a().c(this, this.b, this);
                } else if (this.b.getData().getService_control().equals("1")) {
                    m2.a().a(this, this.b, this);
                }
            }
        } catch (Exception e2) {
            h2.a(e, "Exception =" + e2.getMessage());
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.acse.ottn.service.a.u0
    public void a() {
        m2.a().b(this);
    }
}
