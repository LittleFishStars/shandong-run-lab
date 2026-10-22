package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import com.kwad.sdk.utils.am;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private float Kg;
    private int Lt;
    private int Lu;
    private int Lv;
    private int Lw;
    private int Lx;
    private int Ly;
    private Context mContext;

    private a(Context context) {
        this.Lt = 24;
        this.Lu = 12;
        this.Lv = 16;
        this.Lw = 12;
        this.Lx = 6;
        this.Ly = 4;
        this.Kg = 1.0f;
        this.mContext = context;
    }

    public static a ai(Context context) {
        return new a(context);
    }

    public static a aj(Context context) {
        return new a(context, 17, 10, 12, 8, 4, 3);
    }

    public final void d(float f) {
        this.Kg = f;
    }

    public final int nU() {
        return (int) (((this.Lt - this.Lv) / 2) * this.Kg);
    }

    public final int nV() {
        return (int) (this.Lw * this.Kg);
    }

    public final am nW() {
        int iA = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.Lx) * this.Kg);
        int iA2 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.Ly) * this.Kg);
        am amVar = new am(0, 0);
        amVar.ga(iA);
        amVar.gb(iA2);
        return amVar;
    }

    public final int nX() {
        return (int) (com.kwad.sdk.c.a.a.b(this.mContext, this.Lu) * this.Kg);
    }

    public final float nY() {
        return (com.kwad.sdk.c.a.a.a(this.mContext, this.Lt) * this.Kg) / 2.0f;
    }

    public final am nZ() {
        int iA = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.Lv) * this.Kg);
        return new am(iA, iA);
    }

    public final am nx() {
        return new am(0, (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.Lt) * this.Kg));
    }

    private a(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        this.Kg = 1.0f;
        this.mContext = context;
        this.Lt = 17;
        this.Lu = 10;
        this.Lv = 12;
        this.Lw = 8;
        this.Lx = 4;
        this.Ly = 3;
    }
}
