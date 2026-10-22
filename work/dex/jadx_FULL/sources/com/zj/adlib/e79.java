package com.zj.adlib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.contrarywind.view.WheelView;
import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e79 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ar6 f41364a;

    public e79(Context context, OnTimeSelectListener onTimeSelectListener) {
        ar6 ar6Var = new ar6(2);
        this.f41364a = ar6Var;
        ar6Var.f15346a = context;
        ar6Var.f15354a = onTimeSelectListener;
    }

    public e79 A(String str) {
        this.f41364a.f15378j = str;
        return this;
    }

    public e79 B(@ColorInt int i) {
        this.f41364a.z = i;
        return this;
    }

    public e79 C(@ColorInt int i) {
        this.f41364a.y = i;
        return this;
    }

    public e79 D(int i, int i2, int i3, int i4, int i5, int i6) {
        ar6 ar6Var = this.f41364a;
        ar6Var.i = i;
        ar6Var.j = i2;
        ar6Var.k = i3;
        ar6Var.l = i4;
        ar6Var.m = i5;
        ar6Var.n = i6;
        return this;
    }

    public e79 E(OnTimeSelectChangeListener onTimeSelectChangeListener) {
        this.f41364a.f15353a = onTimeSelectChangeListener;
        return this;
    }

    public e79 F(int i) {
        this.f41364a.u = i;
        return this;
    }

    public e79 G(int i) {
        this.f41364a.s = i;
        return this;
    }

    public e79 H(int i) {
        this.f41364a.w = i;
        return this;
    }

    public e79 I(String str) {
        this.f41364a.f15381l = str;
        return this;
    }

    public e79 J(boolean[] zArr) {
        this.f41364a.f15359a = zArr;
        return this;
    }

    public e79 a(View.OnClickListener onClickListener) {
        this.f41364a.f15348a = onClickListener;
        return this;
    }

    public f79 b() {
        return new f79(this.f41364a);
    }

    public e79 c(boolean z) {
        this.f41364a.f15379j = z;
        return this;
    }

    public e79 d(boolean z) {
        this.f41364a.f15377i = z;
        return this;
    }

    public e79 e(boolean z) {
        this.f41364a.f15369e = z;
        return this;
    }

    public e79 f(boolean z) {
        this.f41364a.f15373g = z;
        return this;
    }

    @Deprecated
    public e79 g(int i) {
        this.f41364a.B = i;
        return this;
    }

    public e79 h(int i) {
        this.f41364a.t = i;
        return this;
    }

    public e79 i(int i) {
        this.f41364a.r = i;
        return this;
    }

    public e79 j(String str) {
        this.f41364a.f15380k = str;
        return this;
    }

    public e79 k(int i) {
        this.f41364a.x = i;
        return this;
    }

    public e79 l(Calendar calendar) {
        this.f41364a.f15357a = calendar;
        return this;
    }

    public e79 m(ViewGroup viewGroup) {
        this.f41364a.f15349a = viewGroup;
        return this;
    }

    public e79 n(@ColorInt int i) {
        this.f41364a.A = i;
        return this;
    }

    public e79 o(WheelView.DividerType dividerType) {
        this.f41364a.f15355a = dividerType;
        return this;
    }

    public e79 p(int i) {
        this.f41364a.p = i;
        return this;
    }

    public e79 q(int i) {
        this.f41364a.C = i;
        return this;
    }

    public e79 r(String str, String str2, String str3, String str4, String str5, String str6) {
        ar6 ar6Var = this.f41364a;
        ar6Var.f15366d = str;
        ar6Var.f15368e = str2;
        ar6Var.f15370f = str3;
        ar6Var.f15372g = str4;
        ar6Var.f15374h = str5;
        ar6Var.f15376i = str6;
        return this;
    }

    public e79 s(int i, CustomListener customListener) {
        ar6 ar6Var = this.f41364a;
        ar6Var.o = i;
        ar6Var.f15350a = customListener;
        return this;
    }

    public e79 t(float f) {
        this.f41364a.f40593a = f;
        return this;
    }

    public e79 u(boolean z) {
        this.f41364a.f15371f = z;
        return this;
    }

    public e79 v(boolean z) {
        this.f41364a.f15375h = z;
        return this;
    }

    public e79 w(@ColorInt int i) {
        this.f41364a.B = i;
        return this;
    }

    public e79 x(Calendar calendar, Calendar calendar2) {
        ar6 ar6Var = this.f41364a;
        ar6Var.f15361b = calendar;
        ar6Var.f15364c = calendar2;
        return this;
    }

    public e79 y(int i) {
        this.f41364a.v = i;
        return this;
    }

    public e79 z(int i) {
        this.f41364a.q = i;
        return this;
    }
}
