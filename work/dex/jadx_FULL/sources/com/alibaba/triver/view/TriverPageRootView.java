package com.alibaba.triver.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverPageRootView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25278a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;

    public TriverPageRootView(Context context) {
        super(context);
        this.f25278a = "TriverPageRootView@";
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
    }

    public void a(Context context, boolean z) {
        String str = this.f25278a + hashCode();
        this.f25278a = str;
        if (z) {
            RVLogger.d(str, "disable mEnableNewAdjustInput by fullScreen.");
            this.b = false;
        }
        RVLogger.d(this.f25278a, "mEnableNewAdjustInput: " + this.b);
        if (this.b) {
            this.e = StatusBarUtils.getStatusBarHeight(context);
            setFitsSystemWindows(true);
            if (context instanceof Activity) {
                ((Activity) context).getWindow().setSoftInputMode(16);
            }
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (!this.b) {
            return super.onApplyWindowInsets(windowInsets);
        }
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop() - this.e;
        if (systemWindowInsetTop < 0) {
            systemWindowInsetTop = 0;
        }
        int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
        int systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
        int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
        this.d = systemWindowInsetBottom;
        WindowInsets windowInsetsReplaceSystemWindowInsets = windowInsets.replaceSystemWindowInsets(systemWindowInsetLeft, systemWindowInsetTop, systemWindowInsetRight, systemWindowInsetBottom);
        RVLogger.d(this.f25278a, "onApplyWindowInsets, before: " + windowInsets + ", after: " + windowInsetsReplaceSystemWindowInsets);
        return super.onApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b) {
            RVLogger.d(this.f25278a, "onAttachedToWindow mNeedRestoreWindowInsets: " + this.c);
            if (this.c) {
                a();
                this.c = false;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b) {
            RVLogger.d(this.f25278a, "onDetachedFromWindow mWindowInsetBottom: " + this.d);
            if (this.d > 0) {
                this.c = true;
            }
        }
    }

    public TriverPageRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25278a = "TriverPageRootView@";
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
    }

    private void a() {
        requestApplyInsets();
    }

    public TriverPageRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25278a = "TriverPageRootView@";
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
    }
}
