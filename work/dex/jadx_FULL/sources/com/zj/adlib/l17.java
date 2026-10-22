package com.zj.adlib;

import com.facebook.imagepipeline.memory.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class l17 {
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 16384;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ByteArrayPool f17852a;
    public int c = 0;
    public int b = 0;
    public int d = 0;
    public int f = 0;
    public int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42971a = 0;

    public l17(ByteArrayPool byteArrayPool) {
        this.f17852a = (ByteArrayPool) ax6.i(byteArrayPool);
    }

    public static boolean b(int i2) {
        if (i2 == 1) {
            return false;
        }
        return ((i2 >= 208 && i2 <= 215) || i2 == 217 || i2 == 216) ? false : true;
    }

    public final boolean a(InputStream inputStream) throws Throwable {
        int i2;
        int i3 = this.e;
        while (this.f42971a != 6 && (i2 = inputStream.read()) != -1) {
            try {
                int i4 = this.c + 1;
                this.c = i4;
                int i5 = this.f42971a;
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                if (i5 == 4) {
                                    this.f42971a = 5;
                                } else if (i5 != 5) {
                                    ax6.o(false);
                                } else {
                                    int i6 = ((this.b << 8) + i2) - 2;
                                    ks8.c(inputStream, i6);
                                    this.c += i6;
                                    this.f42971a = 2;
                                }
                            } else if (i2 == 255) {
                                this.f42971a = 3;
                            } else if (i2 == 0) {
                                this.f42971a = 2;
                            } else {
                                if (i2 == 218 || i2 == 217) {
                                    f(i4 - 2);
                                }
                                if (b(i2)) {
                                    this.f42971a = 4;
                                } else {
                                    this.f42971a = 2;
                                }
                            }
                        } else if (i2 == 255) {
                            this.f42971a = 3;
                        }
                    } else if (i2 == 216) {
                        this.f42971a = 2;
                    } else {
                        this.f42971a = 6;
                    }
                } else if (i2 == 255) {
                    this.f42971a = 1;
                } else {
                    this.f42971a = 6;
                }
                this.b = i2;
            } catch (IOException e) {
                i69.d(e);
            }
        }
        return (this.f42971a == 6 || this.e == i3) ? false : true;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return this.c > 1 && this.f42971a != 6;
    }

    public final void f(int i2) {
        int i3 = this.d;
        if (i3 > 0) {
            this.f = i2;
        }
        this.d = i3 + 1;
        this.e = i3;
    }

    public boolean g(q13 q13Var) {
        if (this.f42971a == 6 || q13Var.v() <= this.c) {
            return false;
        }
        ou6 ou6Var = new ou6(q13Var.q(), this.f17852a.get(16384), this.f17852a);
        try {
            ks8.c(ou6Var, this.c);
            return a(ou6Var);
        } catch (IOException e) {
            i69.d(e);
            return false;
        } finally {
            tm1.b(ou6Var);
        }
    }
}
