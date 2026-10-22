package com.ipd.dsp.internal.s1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.open.IPDGlideHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class a extends LinearLayout {
    public int f;
    public int g;
    public int h;
    public TextView i;
    public ImageView j;

    public a(Context context) {
        this(context, a("#90CCCCCC", 0));
    }

    public final void a(Context context) {
        int iA = (int) s.a(context, 1.0f);
        int iA2 = (int) s.a(context, 2.0f);
        int iA3 = (int) s.a(context, 12.0f);
        setPadding(iA2, iA, iA2, iA);
        setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        setLayoutParams(layoutParams);
        this.j = new ImageView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA3, iA3);
        layoutParams2.setMargins(iA2, iA2, iA2, iA2);
        this.j.setLayoutParams(layoutParams2);
        this.j.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.j);
        this.i = new TextView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(iA2, iA2, iA2, iA2);
        this.i.setLayoutParams(layoutParams3);
        this.i.setTextColor(this.g);
        this.i.setTextSize(8.0f);
        this.i.setGravity(17);
        addView(this.i);
    }

    public void setCornerRadius(int i) {
        this.h = i;
    }

    public a(Context context, int i) {
        this(context, i, a("#FF999999", 0));
    }

    public a(Context context, int i, int i2) {
        super(context);
        this.h = (int) s.a(getContext(), 8.0f);
        setOrientation(0);
        this.f = i;
        this.g = i2;
        a(context);
    }

    public void a(com.ipd.dsp.internal.e1.h hVar) {
        if (o.c(hVar.g)) {
            this.f = a(hVar.g, this.f);
        }
        setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(this.h).a(this.f).a());
        if (o.c(hVar.i)) {
            int iA = a(hVar.i, this.g);
            this.g = iA;
            this.i.setTextColor(iA);
        }
        if (hVar.f != 1) {
            if (o.c(hVar.j)) {
                IPDGlideHelper.loadImage(getContext(), this.j, hVar.j);
            } else {
                this.j.setImageResource(R.drawable.ipd_dsp_icon);
            }
        } else {
            this.j.setVisibility(8);
        }
        if (hVar.f != 2) {
            this.i.setText(hVar.h);
        } else {
            this.i.setVisibility(8);
        }
    }

    public static int a(String str, int i) {
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            return i;
        }
    }
}
