package com.kwad.sdk.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class am extends bo {
    private int bpA;
    private int bpB;
    private int bpC;
    private int bpD;

    public am(int i, int i2) {
        super(i, i2);
    }

    private int VI() {
        return this.bpA;
    }

    private int VJ() {
        return this.bpB;
    }

    private int VK() {
        return this.bpC;
    }

    private int VL() {
        return this.bpD;
    }

    public static am a(int i, int i2, int i3, int i4, int i5, int i6) {
        am amVar = new am(i, i2);
        amVar.ga(0);
        amVar.gb(0);
        amVar.fY(i4);
        amVar.fZ(0);
        return amVar;
    }

    private void fZ(int i) {
        this.bpB = i;
    }

    public final am c(Context context, float f) {
        am amVar = new am(com.kwad.sdk.c.a.a.a(context, this.mWidth * f), com.kwad.sdk.c.a.a.a(context, this.mHeight * f));
        amVar.bpC = com.kwad.sdk.c.a.a.a(context, this.bpC * f);
        amVar.bpB = com.kwad.sdk.c.a.a.a(context, this.bpB * f);
        amVar.bpD = com.kwad.sdk.c.a.a.a(context, this.bpD * f);
        amVar.bpA = com.kwad.sdk.c.a.a.a(context, this.bpA * f);
        return amVar;
    }

    public final void fY(int i) {
        this.bpA = i;
    }

    public final void ga(int i) {
        this.bpC = i;
    }

    public final void gb(int i) {
        this.bpD = i;
    }

    public static void a(View view, am amVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (amVar.getHeight() > 0) {
            layoutParams.height = amVar.getHeight();
        }
        if (amVar.getWidth() > 0) {
            layoutParams.width = amVar.getWidth();
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (amVar.VK() > 0) {
                marginLayoutParams.leftMargin = amVar.VK();
            }
            if (amVar.VJ() > 0) {
                marginLayoutParams.bottomMargin = amVar.VJ();
            }
            if (amVar.VL() > 0) {
                marginLayoutParams.rightMargin = amVar.VL();
            }
            if (amVar.VI() > 0) {
                marginLayoutParams.topMargin = amVar.VI();
            }
        }
        view.setLayoutParams(layoutParams);
    }
}
