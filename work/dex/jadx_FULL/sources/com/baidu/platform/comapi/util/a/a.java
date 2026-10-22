package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.vi.VIContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26796a = -1;
    private int b = -1;
    private float c = -1.0f;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private double g = -1.0d;

    public void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        this.f26796a = i;
        int i2 = displayMetrics.heightPixels;
        this.b = i2;
        if (i <= 0 || i2 <= 0) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            this.f26796a = displayMetrics.widthPixels;
            this.b = displayMetrics.heightPixels;
        }
        this.c = displayMetrics.density;
        this.d = (int) displayMetrics.xdpi;
        this.e = (int) displayMetrics.ydpi;
        int i3 = displayMetrics.densityDpi;
        this.f = i3;
        if (i3 < 240) {
            this.f = i3;
        }
        if (this.f == 0) {
            this.f = 160;
        }
        this.g = ((double) this.f) / 240.0d;
    }

    public int b() {
        if (this.f == -1) {
            a(VIContext.getContext());
        }
        return this.f;
    }

    public int c() {
        if (this.b == -1) {
            a(VIContext.getContext());
        }
        return this.b;
    }

    public int d() {
        if (this.f26796a == -1) {
            a(VIContext.getContext());
        }
        return this.f26796a;
    }

    public float a() {
        if (this.c == -1.0f) {
            a(VIContext.getContext());
        }
        return this.c;
    }
}
