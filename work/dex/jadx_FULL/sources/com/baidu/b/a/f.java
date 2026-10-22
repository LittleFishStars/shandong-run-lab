package com.baidu.b.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f26256a = 5;
    public static int b = 40;
    private b c;

    public f() {
        b bVar = new b(b);
        this.c = bVar;
        bVar.a(0, b, true);
    }

    public void a(b bVar, int i, int i2, int i3) {
        b bVarC = this.c.c(i, i + i2);
        if (i3 == 0) {
            bVarC.a(bVar);
        } else if (i3 == 2) {
            bVarC.d(bVar);
        } else if (i3 != 3) {
            bVarC.c(bVar);
        } else {
            bVarC.b(bVar);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.c.a(i + i4, bVarC.c(i4));
        }
    }

    public byte[] a() {
        return this.c.a();
    }
}
