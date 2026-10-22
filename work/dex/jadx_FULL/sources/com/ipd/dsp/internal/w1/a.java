package com.ipd.dsp.internal.w1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class a extends FrameLayout {
    public com.ipd.dsp.internal.s1.a f;
    public TextView g;
    public ImageView h;

    public a(Context context, int i, View.OnClickListener onClickListener) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        int iA = (int) s.a(context, 4.0f);
        int iA2 = (int) s.a(context, 12.0f);
        int iA3 = (int) s.a(context, 24.0f);
        setPadding(iA2, 0, iA2, 0);
        setBackgroundColor(-16777216);
        this.f = new com.ipd.dsp.internal.s1.a(context, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, iA3);
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(iA2);
        addView(this.f, layoutParams);
        this.g = new TextView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.g.setLayoutParams(layoutParams2);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setMaxLines(1);
        this.g.setTextColor(-1);
        this.g.setTextSize(20.0f);
        this.g.setGravity(17);
        addView(this.g);
        ImageView imageView = new ImageView(context);
        this.h = imageView;
        imageView.setBackgroundResource(R.drawable.ipd_bg_circle);
        this.h.setImageResource(R.drawable.ipd_close);
        this.h.setVisibility(4);
        this.h.setOnClickListener(onClickListener);
        this.h.setPadding(iA, iA, iA, iA);
        this.h.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA3, iA3);
        layoutParams3.gravity = 8388629;
        layoutParams3.setMarginEnd(iA2);
        addView(this.h, layoutParams3);
    }

    public void a(com.ipd.dsp.internal.e1.d dVar) {
        setTitle(dVar.k);
        com.ipd.dsp.internal.s1.a aVar = this.f;
        if (aVar != null) {
            aVar.a(dVar.t);
        }
    }

    public final boolean b() {
        ImageView imageView = this.h;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void c() {
        if (b()) {
            this.h.performClick();
        }
    }

    public void d() {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(int i) {
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "继续浏览%s秒完成任务", Integer.valueOf(i)));
        }
    }

    public void a() {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.h = null;
        }
        this.g = null;
        this.f = null;
    }
}
