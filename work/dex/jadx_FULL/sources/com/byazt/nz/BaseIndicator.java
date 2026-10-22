package com.byazt.nz;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.byazt.nw.tt;
import com.byazt.zqa.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 817, 980})
public abstract class BaseIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28861a;
    public Context c;
    public float da;
    public int i;
    public int n;
    public float sl;
    public int sp;
    public String t;
    public int tt;
    public List<View> uj;
    public int ve;
    public boolean x;

    public BaseIndicator(Context context) {
        super(context);
        this.n = -65536;
        this.f28861a = -16776961;
        this.sp = 5;
        this.tt = 40;
        this.ve = 20;
        this.t = "row";
        this.c = context;
        this.uj = new ArrayList();
        setOrientation(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (frameLayout == null) {
            return;
        }
        float width = frameLayout.getWidth();
        float height = frameLayout.getHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        float width2 = getWidth();
        float height2 = getHeight();
        float f = this.sl;
        layoutParams.topMargin = (int) (((int) ((height * f) / 100.0f)) - ((height2 * f) / 100.0f));
        float f2 = this.da;
        layoutParams.leftMargin = (int) (((int) ((width * f2) / 100.0f)) - ((width2 * f2) / 100.0f));
        setLayoutParams(layoutParams);
    }

    public int getSize() {
        return this.uj.size();
    }

    public void setIndicatorDirection(String str) {
        this.t = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorHeight(int i) {
        this.ve = i;
    }

    public void setIndicatorWidth(int i) {
        this.tt = i;
    }

    public void setIndicatorX(float f) {
        this.da = f;
    }

    public void setIndicatorY(float f) {
        this.sl = f;
    }

    public void setLoop(boolean z) {
        this.x = z;
    }

    public void setSelectedColor(int i) {
        this.n = i;
    }

    public void setUnSelectedColor(int i) {
        this.f28861a = i;
    }

    public abstract Drawable tt(int i);

    public void tt() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.ve = this.tt;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.tt, this.ve);
        if (getOrientation() == 1) {
            int i = this.sp;
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = i;
        } else {
            int i2 = this.sp;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        }
        addView(view, layoutParams);
        view.setBackground(tt(this.f28861a));
        this.uj.add(view);
    }

    public void c(int i, int i2) {
        Iterator<View> it = this.uj.iterator();
        while (it.hasNext()) {
            it.next().setBackground(tt(this.f28861a));
        }
        if (i < 0 || i >= this.uj.size()) {
            i = 0;
        }
        if (this.uj.size() > 0) {
            this.uj.get(i).setBackground(tt(this.n));
            this.i = i2;
        }
    }

    public void c() {
        post(new Runnable() { // from class: com.byazt.nz.BaseIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseIndicator.this.ve();
            }
        });
    }

    public void c(int i) {
        if (this instanceof DotIndicator) {
            this.ve = this.tt;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.tt, this.ve);
        if (getOrientation() == 1) {
            int i2 = this.sp;
            layoutParams.topMargin = i2;
            layoutParams.bottomMargin = i2;
        } else {
            int i3 = this.sp;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.tt, this.ve);
        if (getOrientation() == 1) {
            int i4 = this.sp;
            layoutParams2.topMargin = i4;
            layoutParams2.bottomMargin = i4;
        } else {
            int i5 = this.sp;
            layoutParams2.leftMargin = i5;
            layoutParams2.rightMargin = i5;
        }
        int iC = tt.c(this.x, this.i, this.uj.size());
        int iC2 = tt.c(this.x, i, this.uj.size());
        if (this.uj.size() == 0) {
            iC2 = 0;
        }
        if (!this.uj.isEmpty() && tt.c(iC, this.uj) && tt.c(iC2, this.uj)) {
            this.uj.get(iC).setBackground(tt(this.f28861a));
            this.uj.get(iC).setLayoutParams(layoutParams2);
            this.uj.get(iC2).setBackground(tt(this.n));
            this.uj.get(iC2).setLayoutParams(layoutParams);
            this.i = i;
        }
    }
}
