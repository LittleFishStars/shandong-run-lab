package com.alibaba.triver.open.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.alibctriver.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBCircularProgress extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25082a;
    private int b;
    private int c;
    private String d;
    private int e;
    private int f;
    private ImageView g;
    private TextView h;
    private i i;
    private float j;
    private Drawable k;

    public TBCircularProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 1.0f;
        i iVar = new i(-1, 16.0f);
        this.i = iVar;
        iVar.setCallback(this);
        View.inflate(context, R.layout.triver_circular_progress, this);
        this.g = (ImageView) findViewById(R.id.wml_circularProgress);
        this.h = (TextView) findViewById(R.id.triver_progressText);
        setOrientation(1);
        a(context, attributeSet, i);
        a();
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.f25082a = ContextCompat.getColor(getContext(), R.color.triver_ringColor);
        this.b = (int) getContext().getResources().getDimension(R.dimen.triver_ringWidth);
        this.c = (int) getContext().getResources().getDimension(R.dimen.triver_ringSize);
        this.e = (int) getContext().getResources().getDimension(R.dimen.triver_progressTextSize);
        this.f = ContextCompat.getColor(getContext(), R.color.triver_progressTextColor);
        this.j = 1.0f;
        if (this.k == null) {
            this.k = ContextCompat.getDrawable(getContext(), R.drawable.triver_shape_waitview);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i iVar = this.i;
        if (iVar != null) {
            iVar.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.i;
        if (iVar != null) {
            iVar.stop();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i.setBounds(0, 0, i, i2);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        i iVar = this.i;
        if (iVar != null) {
            if (i == 8 || i == 4) {
                iVar.stop();
            } else {
                iVar.start();
            }
        }
    }

    public void setProgressText(String str) {
        this.d = str;
        a();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.i || super.verifyDrawable(drawable);
    }

    private void a() {
        this.i.a(this.f25082a);
        this.i.c(this.b);
        this.g.getLayoutParams().width = this.c;
        this.g.getLayoutParams().height = this.c;
        this.g.setImageDrawable(this.i);
        String str = this.d;
        if (str != null) {
            this.h.setText(str);
        }
        this.h.setTextSize(0, this.e);
        this.h.setTextColor(this.f);
        setBackgroundDrawable(this.k);
        setAlpha(this.j);
    }

    public TBCircularProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TBCircularProgress(Context context) {
        this(context, null);
    }
}
