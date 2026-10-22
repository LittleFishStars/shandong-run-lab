package com.acse.ottn.service;

import android.R;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.acse.ottn.activity.ExcessActivity;
import com.acse.ottn.h2;
import com.acse.ottn.model.AccessiblityModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExcessService extends Service {
    public static View e = null;
    public static WindowManager f = null;
    public static String g = "MainService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f23201a;
    public AccessiblityModel b;
    public int c = -1;
    public boolean d = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23202a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ int g;
        public final /* synthetic */ String h;

        public a(String str, String str2, String str3, int i, String str4, String str5, int i2, String str6) {
            this.f23202a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
            this.e = str4;
            this.f = str5;
            this.g = i2;
            this.h = str6;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(ExcessService.this, (Class<?>) ExcessActivity.class);
            intent.putExtra("password", this.f23202a);
            intent.putExtra("deeplink", this.b);
            intent.putExtra("link", this.c);
            intent.putExtra("time", this.d);
            intent.putExtra("name", this.e);
            intent.putExtra("origin_url", this.f);
            intent.putExtra("dissmiss_time", this.g);
            intent.putExtra("jump_type", this.h);
            intent.addFlags(268435456);
            ExcessService.this.startActivity(intent);
            ExcessService.this.b();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a() {
        this.f23201a = new WindowManager.LayoutParams();
        f = (WindowManager) getApplication().getSystemService("window");
        WindowManager.LayoutParams layoutParams = this.f23201a;
        layoutParams.type = 2038;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.windowAnimations = R.style.Animation.Translucent;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -2;
        layoutParams.height = -2;
    }

    public void b() {
        try {
            e.setVisibility(8);
            f.removeView(e);
        } catch (Exception e2) {
            h2.a(g, e2.getMessage());
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        h2.c(g, "MainService Created");
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            com.acse.ottn.service.a.b();
            com.acse.ottn.service.a.d();
            View view = e;
            if (view != null) {
                f.removeView(view);
            }
        } catch (Exception e2) {
            h2.c(g, "e=" + e2.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            a(intent);
            return 2;
        } catch (Exception e2) {
            h2.c(g, "onStartCommand e=" + e2.getMessage());
            return 2;
        }
    }

    public final void a(Intent intent) {
        if (intent == null) {
            return;
        }
        a(com.acse.ottn.R.layout.excess_view);
        try {
            String stringExtra = intent.getStringExtra("password");
            String stringExtra2 = intent.getStringExtra("deeplink");
            String stringExtra3 = intent.getStringExtra("link");
            String stringExtra4 = intent.getStringExtra("origin_url");
            String stringExtra5 = intent.getStringExtra("name");
            int intExtra = intent.getIntExtra("time", 100);
            int intExtra2 = intent.getIntExtra("dissmiss_time", 0);
            String stringExtra6 = intent.getStringExtra("jump_type");
            try {
                WindowManager windowManager = f;
                if (windowManager != null) {
                    windowManager.addView(e, this.f23201a);
                }
            } catch (Exception e2) {
                h2.a(g, "添加失败 e=" + e2.getMessage());
            }
            new Handler().postDelayed(new a(stringExtra, stringExtra2, stringExtra3, intExtra, stringExtra5, stringExtra4, intExtra2, stringExtra6), 0L);
        } catch (Exception e3) {
            h2.a(g, "startExcessActivity e=" + e3.getMessage());
        }
    }

    public final void a(int i) {
        try {
            View viewInflate = LayoutInflater.from(getApplication()).inflate(i, (ViewGroup) null);
            e = viewInflate;
            viewInflate.measure(0, 0);
        } catch (Exception e2) {
            h2.a(g, "setLayoutView e = " + e2.getMessage());
        }
    }
}
