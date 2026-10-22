package com.google.common.xml;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.c;
import com.zj.adlib.dv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtCompatible
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f32445a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Escaper f6615a;
    public static final char b = 31;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Escaper f6616b;
    public static final Escaper c;

    static {
        c.C0740c c0740cB = c.b();
        c0740cB.d((char) 0, (char) 65533);
        c0740cB.e("�");
        for (char c2 = 0; c2 <= 31; c2 = (char) (c2 + 1)) {
            if (c2 != '\t' && c2 != '\n' && c2 != '\r') {
                c0740cB.b(c2, "�");
            }
        }
        c0740cB.b(dv9.d, "&amp;");
        c0740cB.b(dv9.f41283a, "&lt;");
        c0740cB.b(dv9.b, "&gt;");
        f6616b = c0740cB.c();
        c0740cB.b('\'', "&apos;");
        c0740cB.b('\"', "&quot;");
        f6615a = c0740cB.c();
        c0740cB.b('\t', "&#x9;");
        c0740cB.b('\n', "&#xA;");
        c0740cB.b('\r', "&#xD;");
        c = c0740cB.c();
    }

    public static Escaper a() {
        return c;
    }

    public static Escaper b() {
        return f6616b;
    }
}
