package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f6428b = "-._~!$'()*,;&=@:";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f6427a = "-_.*";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Escaper f32231a = new f(f6427a, true);
    public static final Escaper b = new f("-._~!$'()*,;&=@:+", false);
    public static final Escaper c = new f("-._~!$'()*,;&=@:+/?", false);

    public static Escaper a() {
        return f32231a;
    }

    public static Escaper b() {
        return c;
    }

    public static Escaper c() {
        return b;
    }
}
