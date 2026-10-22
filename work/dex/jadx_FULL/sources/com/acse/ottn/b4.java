package com.acse.ottn;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b4 {
    public static String m = "ScreenLock_Width";
    public static String n = "ScreenLock_Height";
    public static String o = "ScreenLock_PositionX";
    public static String p = "ScreenLock_PositionY";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22881a;
    public int b;
    public int c;
    public int d;
    public Context e;
    public DevicePolicyManager f;
    public SharedPreferences g;
    public WindowManager h;
    public DisplayMetrics i = new DisplayMetrics();
    public ImageView j;
    public WindowManager.LayoutParams k;
    public View l;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f22882a = System.currentTimeMillis();

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f22882a = System.currentTimeMillis();
        }
    }

    public b4(Context context) {
        this.e = context;
        this.f = (DevicePolicyManager) context.getSystemService("device_policy");
        this.h = (WindowManager) context.getSystemService("window");
        this.g = context.getSharedPreferences(context.getPackageName(), 0);
        this.h.getDefaultDisplay().getRealMetrics(this.i);
        this.f22881a = this.g.getInt(m, this.i.widthPixels / 20);
        this.b = this.g.getInt(n, this.i.widthPixels / 20);
        this.c = this.g.getInt(o, this.i.widthPixels - this.f22881a);
        this.d = this.g.getInt(p, this.i.heightPixels - this.b);
    }

    public void a() {
        if (this.j != null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.k = layoutParams;
        layoutParams.type = 2032;
        layoutParams.flags = 776;
        layoutParams.format = -2;
        layoutParams.gravity = 8388659;
        layoutParams.alpha = 0.5f;
        layoutParams.width = this.f22881a;
        layoutParams.height = this.b;
        layoutParams.x = this.c;
        layoutParams.y = this.d;
        ImageView imageView = new ImageView(this.e);
        this.j = imageView;
        imageView.setBackgroundColor(0);
        this.j.setOnClickListener(new a());
        this.h.addView(this.j, this.k);
    }
}
