package com.google.common.html;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.c;
import com.zj.adlib.dv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Escaper f32146a = c.b().b('\"', "&quot;").b('\'', "&#39;").b(dv9.d, "&amp;").b(dv9.f41283a, "&lt;").b(dv9.b, "&gt;").c();

    public static Escaper a() {
        return f32146a;
    }
}
