package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.acse.ottn.R;
import com.acse.ottn.h2;
import com.acse.ottn.x0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TransparentService extends Service {
    public static View f = null;
    public static WindowManager g = null;
    public static String h = "MainService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f23207a;
    public RelativeLayout b;
    public ImageView c;
    public ImageView d;
    public String e;

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a() {
        this.f23207a = new WindowManager.LayoutParams();
        g = (WindowManager) getApplication().getSystemService("window");
        WindowManager.LayoutParams layoutParams = this.f23207a;
        layoutParams.type = 2038;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = x0.a((Context) this, 1.0f);
        this.f23207a.height = x0.a((Context) this, 1.0f);
    }

    public void b() {
        try {
            View view = f;
            if (view != null) {
                view.setVisibility(8);
            }
            g.removeView(f);
            stopSelf();
        } catch (Throwable unused) {
        }
    }

    public void c() {
        a(R.layout.transparent_background);
        this.b = (RelativeLayout) f.findViewById(R.id.treasure_box);
        this.d = (ImageView) f.findViewById(R.id.image);
        try {
            g.addView(f, this.f23207a);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            this.e = intent.getStringExtra("deeplink");
            c();
        } catch (Exception e) {
            try {
                h2.a(h, "Exception =" + e.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    public final void a(int i) {
        try {
            View viewInflate = LayoutInflater.from(getApplication()).inflate(i, (ViewGroup) null);
            f = viewInflate;
            viewInflate.measure(0, 0);
        } catch (Throwable unused) {
        }
    }
}
