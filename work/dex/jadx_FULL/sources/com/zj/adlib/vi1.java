package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class vi1 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f20221a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45358a = 0;
    public int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20220a = true;

    public vi1(int i) {
        this.f20221a = new int[i];
    }

    public void a(char c) {
        c(c);
    }

    public void b(int i) {
        c(i + 65536);
    }

    public final void c(int i) {
        if (this.f20220a) {
            int[] iArr = this.f20221a;
            int i2 = this.f45358a;
            iArr[i2] = i;
            this.f45358a = (i2 + 1) % iArr.length;
            this.b++;
        }
    }

    public void d(String str) {
        for (char c : str.toCharArray()) {
            a(c);
        }
    }

    public void e() {
        this.f20220a = false;
    }

    public void f() {
        this.f20220a = true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f20221a.length * 11) / 10);
        int i = this.b;
        int[] iArr = this.f20221a;
        int length = i < iArr.length ? iArr.length - i : 0;
        while (true) {
            int[] iArr2 = this.f20221a;
            if (length >= iArr2.length) {
                return stringBuffer.toString();
            }
            int i2 = iArr2[(this.f45358a + length) % iArr2.length];
            if (i2 < 65536) {
                stringBuffer.append((char) i2);
            } else {
                stringBuffer.append(Integer.toString(i2 - 65536));
            }
            length++;
        }
    }
}
