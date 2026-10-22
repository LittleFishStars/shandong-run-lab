package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ControllerListener<INFO> {
    void a(String str, @Nullable INFO info, @Nullable Animatable animatable);

    void b(String str, Object obj);

    void c(String str);

    void d(String str, Throwable th);

    void e(String str, Throwable th);

    void f(String str, @Nullable INFO info);
}
