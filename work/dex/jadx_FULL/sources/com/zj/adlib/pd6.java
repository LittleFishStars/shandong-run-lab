package com.zj.adlib;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.contrarywind.view.WheelView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class pd6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ar6 f43956a;

    public pd6(Context context, OnOptionsSelectListener onOptionsSelectListener) {
        ar6 ar6Var = new ar6(1);
        this.f43956a = ar6Var;
        ar6Var.f15346a = context;
        ar6Var.f15352a = onOptionsSelectListener;
    }

    public pd6 A(int i) {
        this.f43956a.q = i;
        return this;
    }

    public pd6 B(String str) {
        this.f43956a.f15378j = str;
        return this;
    }

    public pd6 C(int i) {
        this.f43956a.z = i;
        return this;
    }

    public pd6 D(@ColorInt int i) {
        this.f43956a.y = i;
        return this;
    }

    public pd6 E(int i, int i2, int i3) {
        ar6 ar6Var = this.f43956a;
        ar6Var.d = i;
        ar6Var.e = i2;
        ar6Var.f = i3;
        return this;
    }

    public pd6 F(int i) {
        this.f43956a.u = i;
        return this;
    }

    public pd6 G(int i) {
        this.f43956a.s = i;
        return this;
    }

    public pd6 H(int i) {
        this.f43956a.w = i;
        return this;
    }

    public pd6 I(String str) {
        this.f43956a.f15381l = str;
        return this;
    }

    public pd6 J(Typeface typeface) {
        this.f43956a.f15347a = typeface;
        return this;
    }

    public pd6 a(View.OnClickListener onClickListener) {
        this.f43956a.f15348a = onClickListener;
        return this;
    }

    public <T> rd6<T> b() {
        return new rd6<>(this.f43956a);
    }

    public pd6 c(boolean z) {
        this.f43956a.f15379j = z;
        return this;
    }

    public pd6 d(boolean z) {
        this.f43956a.f15377i = z;
        return this;
    }

    public pd6 e(boolean z) {
        this.f43956a.f15373g = z;
        return this;
    }

    public pd6 f(boolean z) {
        this.f43956a.f15367d = z;
        return this;
    }

    @Deprecated
    public pd6 g(int i) {
        this.f43956a.B = i;
        return this;
    }

    public pd6 h(int i) {
        this.f43956a.t = i;
        return this;
    }

    public pd6 i(int i) {
        this.f43956a.r = i;
        return this;
    }

    public pd6 j(String str) {
        this.f43956a.f15380k = str;
        return this;
    }

    public pd6 k(int i) {
        this.f43956a.x = i;
        return this;
    }

    public pd6 l(boolean z, boolean z2, boolean z3) {
        ar6 ar6Var = this.f43956a;
        ar6Var.f15358a = z;
        ar6Var.f15362b = z2;
        ar6Var.f15365c = z3;
        return this;
    }

    public pd6 m(ViewGroup viewGroup) {
        this.f43956a.f15349a = viewGroup;
        return this;
    }

    public pd6 n(@ColorInt int i) {
        this.f43956a.A = i;
        return this;
    }

    public pd6 o(WheelView.DividerType dividerType) {
        this.f43956a.f15355a = dividerType;
        return this;
    }

    public pd6 p(int i) {
        this.f43956a.C = i;
        return this;
    }

    public pd6 q(String str, String str2, String str3) {
        ar6 ar6Var = this.f43956a;
        ar6Var.f15356a = str;
        ar6Var.f15360b = str2;
        ar6Var.f15363c = str3;
        return this;
    }

    public pd6 r(int i, CustomListener customListener) {
        ar6 ar6Var = this.f43956a;
        ar6Var.o = i;
        ar6Var.f15350a = customListener;
        return this;
    }

    public pd6 s(float f) {
        this.f43956a.f40593a = f;
        return this;
    }

    public pd6 t(OnOptionsSelectChangeListener onOptionsSelectChangeListener) {
        this.f43956a.f15351a = onOptionsSelectChangeListener;
        return this;
    }

    public pd6 u(boolean z) {
        this.f43956a.f15375h = z;
        return this;
    }

    public pd6 v(int i) {
        this.f43956a.B = i;
        return this;
    }

    public pd6 w(int i) {
        this.f43956a.f15345a = i;
        return this;
    }

    public pd6 x(int i, int i2) {
        ar6 ar6Var = this.f43956a;
        ar6Var.f15345a = i;
        ar6Var.b = i2;
        return this;
    }

    public pd6 y(int i, int i2, int i3) {
        ar6 ar6Var = this.f43956a;
        ar6Var.f15345a = i;
        ar6Var.b = i2;
        ar6Var.c = i3;
        return this;
    }

    public pd6 z(int i) {
        this.f43956a.v = i;
        return this;
    }
}
