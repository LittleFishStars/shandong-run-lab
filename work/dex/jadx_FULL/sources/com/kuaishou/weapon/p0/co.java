package com.kuaishou.weapon.p0;

import android.os.Build;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class co {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static co f40090a;
    static co b;
    static co c;
    private long d;
    private a e;

    public enum a {
        DWORD(4),
        QWORD(8);

        int c;

        a(int i) {
            this.c = i;
        }
    }

    static {
        c();
    }

    private static void c() {
        f40090a = new co();
        b = new co();
        c = new co();
        co coVar = b;
        a aVar = a.DWORD;
        coVar.a(aVar);
        int i = Build.VERSION.SDK_INT;
        if (!cp.a()) {
            f40090a.a(aVar);
            c.a(aVar);
            switch (i) {
                case 26:
                case 27:
                    f40090a.a(28L);
                    c.a(24L);
                    b.a(4L);
                    return;
                case 28:
                case 29:
                    f40090a.a(24L);
                    c.a(20L);
                    b.a(4L);
                    return;
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
            }
        }
        co coVar2 = f40090a;
        a aVar2 = a.QWORD;
        coVar2.a(aVar2);
        c.a(aVar2);
        switch (i) {
            case 26:
            case 27:
                f40090a.a(40L);
                c.a(32L);
                b.a(4L);
                return;
            case 28:
            case 29:
                f40090a.a(32L);
                c.a(24L);
                b.a(4L);
                return;
            default:
                throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
        }
    }

    public long a() {
        return this.d;
    }

    public a b() {
        return this.e;
    }

    public void a(long j) {
        this.d = j;
    }

    public void a(a aVar) {
        this.e = aVar;
    }
}
