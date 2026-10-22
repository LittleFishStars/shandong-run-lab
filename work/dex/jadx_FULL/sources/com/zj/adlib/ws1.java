package com.zj.adlib;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.huachenjie.base.widget.dialog.ConfirmBoxDialog;
import com.huachenjie.base.widget.dialog.OnConfirmListener;
import com.huachenjie.base.widget.dialog.OnViewCreateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ws1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f45678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f20514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f20515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnClickListener f20516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnConfirmListener f20517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f20518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f20519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference<Context> f20520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<OnViewCreateListener> f20521a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f20523b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f20524b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View.OnClickListener f20525b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f20526b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f20528c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f20529c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f20530d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20522a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f20527b = true;

    public ws1(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f20520a = new WeakReference<>(context);
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        this.f20520a = null;
    }

    public static ws1 Z(Context context) {
        return new ws1(context);
    }

    public ws1 A(Drawable cancelBackground) {
        this.f20515a = cancelBackground;
        return this;
    }

    public ws1 B(int cancelBackgroundColor) {
        this.g = cancelBackgroundColor;
        return this;
    }

    public ws1 C(View.OnClickListener cancelClickListener) {
        this.f20516a = cancelClickListener;
        return this;
    }

    public ws1 D(int cancelColor) {
        this.f = cancelColor;
        return this;
    }

    public ws1 E(float cancelSize) {
        this.c = cancelSize;
        return this;
    }

    public ws1 F(String cancelText) {
        this.f20526b = cancelText;
        return this;
    }

    public ws1 G(boolean cancellable) {
        this.f20522a = cancellable;
        return this;
    }

    public ws1 H(Drawable confirmBackground) {
        this.f20524b = confirmBackground;
        return this;
    }

    public ws1 I(int confirmBackgroundColor) {
        this.i = confirmBackgroundColor;
        return this;
    }

    public ws1 J(View.OnClickListener confirmClickListener) {
        this.f20525b = confirmClickListener;
        return this;
    }

    public ws1 K(int confirmColor) {
        this.h = confirmColor;
        return this;
    }

    public ws1 L(OnConfirmListener confirmListener) {
        this.f20517a = confirmListener;
        return this;
    }

    public ws1 M(float confirmSize) {
        this.d = confirmSize;
        return this;
    }

    public ws1 N(String confirmText) {
        this.f20529c = confirmText;
        return this;
    }

    public ws1 O(int contentColor) {
        this.e = contentColor;
        return this;
    }

    public ws1 P(float contentSize) {
        this.b = contentSize;
        return this;
    }

    public ws1 Q(CharSequence contentText) {
        this.f20518a = contentText;
        return this;
    }

    public ws1 R(int layoutId) {
        this.f20514a = layoutId;
        return this;
    }

    public ws1 S(int rotation) {
        this.f20528c = rotation;
        return this;
    }

    public ws1 T(boolean showContentScrollbar) {
        this.f20527b = showContentScrollbar;
        return this;
    }

    public ws1 U(int themeId) {
        this.f20523b = themeId;
        return this;
    }

    public ws1 V(int titleColor) {
        this.f20530d = titleColor;
        return this;
    }

    public ws1 W(float titleSize) {
        this.f45678a = titleSize;
        return this;
    }

    public ws1 X(String titleText) {
        this.f20519a = titleText;
        return this;
    }

    public Dialog Y() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        boolean z = context instanceof Activity;
        if (z && ((Activity) context).isFinishing()) {
            return null;
        }
        ConfirmBoxDialog confirmBoxDialog = t() == 0 ? new ConfirmBoxDialog(context, t(), this) : new ConfirmBoxDialog(context, this);
        if (z && !((Activity) context).isFinishing()) {
            confirmBoxDialog.show();
        }
        return confirmBoxDialog;
    }

    public ws1 a(OnViewCreateListener viewCreateListener) {
        if (this.f20521a == null) {
            this.f20521a = new ArrayList();
        }
        this.f20521a.add(viewCreateListener);
        return this;
    }

    public Drawable b() {
        return this.f20515a;
    }

    public int c() {
        return this.g;
    }

    public View.OnClickListener d() {
        return this.f20516a;
    }

    public int e() {
        return this.f;
    }

    public float f() {
        return this.c;
    }

    public String g() {
        return this.f20526b;
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.f20520a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Drawable h() {
        return this.f20524b;
    }

    public int i() {
        return this.i;
    }

    public View.OnClickListener j() {
        return this.f20525b;
    }

    public int k() {
        return this.h;
    }

    public OnConfirmListener l() {
        return this.f20517a;
    }

    public float m() {
        return this.d;
    }

    public String n() {
        return this.f20529c;
    }

    public int o() {
        return this.e;
    }

    public float p() {
        return this.b;
    }

    public CharSequence q() {
        return this.f20518a;
    }

    public int r() {
        return this.f20514a;
    }

    public int s() {
        return this.f20528c;
    }

    public int t() {
        return this.f20523b;
    }

    public int u() {
        return this.f20530d;
    }

    public float v() {
        return this.f45678a;
    }

    public String w() {
        return this.f20519a;
    }

    public List<OnViewCreateListener> x() {
        return this.f20521a;
    }

    public boolean y() {
        return this.f20522a;
    }

    public boolean z() {
        return this.f20527b;
    }
}
