package com.zj.adlib;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class wm6 extends PasswordTransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static wm6 f45628a;

    public class a implements CharSequence {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CharSequence f20467a;

        public a(CharSequence source) {
            this.f20467a = source;
        }

        @Override // java.lang.CharSequence
        public char charAt(int index) {
            return '*';
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.f20467a.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int start, int end) {
            return this.f20467a.subSequence(start, end);
        }
    }

    public static wm6 a() {
        wm6 wm6Var = f45628a;
        if (wm6Var != null) {
            return wm6Var;
        }
        wm6 wm6Var2 = new wm6();
        f45628a = wm6Var2;
        return wm6Var2;
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence source, View view) {
        return new a(source);
    }
}
