package com.acse.ottn.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.e0;
import com.acse.ottn.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AutoScrollViewPager extends RelativeLayout {
    public static final String f = "right";
    public static final String g = "center";
    public static final int h = 0;
    public static final int i = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f22855a;
    public Context b;
    public LinearLayout c;
    public View d;
    public TextView e;

    public AutoScrollViewPager(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        this.b = context;
        t tVar = new t(context);
        this.f22855a = tVar;
        addView(tVar);
        View view = this.d;
        if (view != null) {
            this.e = (TextView) view.findViewById(R.id.subTitle);
            this.c = (LinearLayout) this.d.findViewById(R.id.pointLayout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            this.d.setLayoutParams(layoutParams);
            addView(this.d);
        }
    }

    public void b(int i2) {
        int childCount = this.c.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ImageView imageView = (ImageView) this.c.getChildAt(i3);
            if (i3 == i2) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }
        }
    }

    public void c() {
        t tVar = this.f22855a;
        if (tVar == null || tVar.c()) {
            return;
        }
        this.f22855a.g();
    }

    public TextView getSubTitle() {
        return this.e;
    }

    public t getViewPager() {
        return this.f22855a;
    }

    public void setAdapter(e0 e0Var) {
        t tVar = this.f22855a;
        if (tVar != null) {
            tVar.a(tVar, e0Var);
        }
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoScrollViewPager, i2, 0);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.AutoScrollViewPager_point_layout);
        string = string == null ? "center" : string;
        if (string.equals("center") || !string.equals("right")) {
            this.d = LayoutInflater.from(context).inflate(R.layout.point_center_text, (ViewGroup) null);
        } else {
            this.d = LayoutInflater.from(context).inflate(R.layout.point_right_text, (ViewGroup) null);
        }
        typedArrayObtainStyledAttributes.recycle();
        a(context);
    }

    public void b() {
        t tVar = this.f22855a;
        if (tVar != null) {
            tVar.f();
        }
    }

    public void a(int i2) {
        a(i2, 0);
    }

    public void a(int i2, int i3) {
        this.c.removeAllViews();
        for (int i4 = 0; i4 < i2; i4++) {
            View imageView = new ImageView(this.b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
            layoutParams.leftMargin = 8;
            imageView.setLayoutParams(layoutParams);
            if (i4 == i3) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }
            this.c.addView(imageView);
        }
    }

    public void a() {
        t tVar = this.f22855a;
        if (tVar != null) {
            tVar.d();
        }
    }
}
