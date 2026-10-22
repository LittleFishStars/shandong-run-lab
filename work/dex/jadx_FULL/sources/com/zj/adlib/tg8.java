package com.zj.adlib;

import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class tg8 {
    public static final int d = -1;
    public static final int e = -2;
    public static final int f = -3;
    public static final int g = -5;
    public static final int h = -6;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Reader f19805a;
    public int c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f19804a = Integer.MIN_VALUE;
    public int b = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f19806a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuffer f19807a = new StringBuffer();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f19809a = new int[256];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19808a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char f44914a = 0;

    public tg8(Reader reader) throws IOException {
        char c = 0;
        this.f19805a = reader;
        while (true) {
            int[] iArr = this.f19809a;
            if (c >= iArr.length) {
                a();
                return;
            }
            if (('A' <= c && c <= 'Z') || (('a' <= c && c <= 'z') || c == '-')) {
                iArr[c] = -3;
            } else if ('0' <= c && c <= '9') {
                iArr[c] = -2;
            } else if (c < 0 || c > ' ') {
                iArr[c] = c;
            } else {
                iArr[c] = -5;
            }
            c = (char) (c + 1);
        }
    }

    public int a() throws IOException {
        int i;
        int i2;
        char c;
        boolean z;
        boolean z2;
        int i3;
        if (this.f19808a) {
            this.f19808a = false;
            return this.f19804a;
        }
        this.f19804a = this.c;
        do {
            boolean z3 = false;
            do {
                i = this.f19805a.read();
                if (i != -1) {
                    i2 = this.f19809a[i];
                } else {
                    if (this.f44914a != 0) {
                        throw new IOException("Unterminated quote");
                    }
                    i2 = -1;
                }
                c = this.f44914a;
                z = c == 0 && i2 == -5;
                z3 = z3 || z;
            } while (z);
            if (i2 == 39 || i2 == 34) {
                if (c == 0) {
                    this.f44914a = (char) i2;
                } else if (c == i2) {
                    this.f44914a = (char) 0;
                }
            }
            char c2 = this.f44914a;
            if (c2 != 0) {
                i2 = c2;
            }
            z2 = z3 || !(((i3 = this.f19804a) < -1 || i3 == 39 || i3 == 34) && i3 == i2);
            if (z2) {
                int i4 = this.f19804a;
                if (i4 == -3) {
                    this.f19806a = this.f19807a.toString();
                    this.f19807a.setLength(0);
                } else if (i4 == -2) {
                    this.b = Integer.parseInt(this.f19807a.toString());
                    this.f19807a.setLength(0);
                } else if (i4 == 34 || i4 == 39) {
                    this.f19806a = this.f19807a.toString().substring(1, this.f19807a.length() - 1);
                    this.f19807a.setLength(0);
                }
                if (i2 != -5) {
                    this.c = i2 == -6 ? i : i2;
                }
            }
            if (i2 == -3 || i2 == -2 || i2 == 34 || i2 == 39) {
                this.f19807a.append((char) i);
            }
        } while (!z2);
        return this.f19804a;
    }

    public void b(char c) {
        this.f19809a[c] = c;
    }

    public void c() {
        this.f19808a = true;
    }

    public void d(char c, char c2) {
        while (c <= c2) {
            this.f19809a[c] = -3;
            c = (char) (c + 1);
        }
    }

    public String toString() {
        int i = this.f19804a;
        if (i != -3) {
            if (i == -2) {
                return Integer.toString(this.b);
            }
            if (i == -1) {
                return "(EOF)";
            }
            if (i != 34) {
                if (i != 39) {
                    return "'" + ((char) this.f19804a) + "'";
                }
                return "'" + this.f19806a + "'";
            }
        }
        return "\"" + this.f19806a + "\"";
    }
}
