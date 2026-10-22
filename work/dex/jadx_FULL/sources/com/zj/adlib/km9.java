package com.zj.adlib;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.FormatException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class km9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final km9[] f42856a = a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f17750a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42857a;
        public final int b;

        public int a() {
            return this.f42857a;
        }

        public int b() {
            return this.b;
        }

        public b(int i, int i2) {
            this.f42857a = i;
            this.b = i2;
        }
    }

    public km9(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.f17749a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f17750a = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.f = iA;
    }

    public static km9[] a() {
        int i = 48;
        int i2 = 8;
        int i3 = 1;
        int i4 = 5;
        int i5 = 7;
        int i6 = 12;
        int i7 = 18;
        int i8 = 36;
        int i9 = 62;
        int i10 = 42;
        int i11 = 56;
        b bVar = new b(i3, 10);
        b bVar2 = new b(i3, 16);
        int i12 = 32;
        int i13 = 38;
        return new km9[]{new km9(1, 10, 10, 8, 8, new c(i4, new b(i3, 3))), new km9(2, 12, 12, 10, 10, new c(i5, new b(i3, i4))), new km9(3, 14, 14, 12, 12, new c(10, new b(i3, i2))), new km9(4, 16, 16, 14, 14, new c(i6, new b(i3, i6))), new km9(5, 18, 18, 16, 16, new c(14, new b(i3, i7))), new km9(6, 20, 20, 18, 18, new c(i7, new b(i3, 22))), new km9(7, 22, 22, 20, 20, new c(20, new b(i3, 30))), new km9(8, 24, 24, 22, 22, new c(24, new b(i3, i8))), new km9(9, 26, 26, 24, 24, new c(28, new b(i3, 44))), new km9(10, 32, 32, 14, 14, new c(i8, new b(i3, i9))), new km9(11, 36, 36, 16, 16, new c(i10, new b(i3, 86))), new km9(12, 40, 40, 18, 18, new c(i, new b(i3, 114))), new km9(13, 44, 44, 20, 20, new c(i11, new b(i3, 144))), new km9(14, 48, 48, 22, 22, new c(68, new b(i3, 174))), new km9(15, 52, 52, 24, 24, new c(i10, new b(2, 102))), new km9(16, 64, 64, 14, 14, new c(i11, new b(2, 140))), new km9(17, 72, 72, 16, 16, new c(i8, new b(4, 92))), new km9(18, 80, 80, 18, 18, new c(i, new b(4, 114))), new km9(19, 88, 88, 20, 20, new c(i11, new b(4, 144))), new km9(20, 96, 96, 22, 22, new c(68, new b(4, 174))), new km9(21, 104, 104, 24, 24, new c(i11, new b(6, 136))), new km9(22, 120, 120, 18, 18, new c(68, new b(6, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED))), new km9(23, 132, 132, 20, 20, new c(i9, new b(i2, 163))), new km9(24, 144, 144, 22, 22, new c(i9, new b(i2, 156), new b(2, 155))), new km9(25, 8, 18, 6, 16, new c(i5, new b(i3, 5))), new km9(26, 8, 32, 6, 14, new c(11, bVar)), new km9(27, 12, 26, 10, 24, new c(14, bVar2)), new km9(28, 12, 36, 10, 16, new c(i7, new b(i3, 22))), new km9(29, 16, 36, 14, 16, new c(24, new b(i3, i12))), new km9(30, 16, 48, 14, 22, new c(28, new b(i3, 49))), new km9(31, 8, 48, 6, 22, new c(15, new b(i3, i7))), new km9(32, 8, 64, 6, 14, new c(i7, new b(i3, 24))), new km9(33, 8, 80, 6, 18, new c(22, new b(i3, i12))), new km9(34, 8, 96, 6, 22, new c(28, new b(i3, i13))), new km9(35, 8, 120, 6, 18, new c(i12, new b(i3, 49))), new km9(36, 8, 144, 6, 22, new c(i8, new b(i3, 63))), new km9(37, 12, 64, 10, 14, new c(27, new b(i3, 43))), new km9(38, 12, 88, 10, 20, new c(i8, new b(i3, 64))), new km9(39, 16, 64, 14, 14, new c(i8, new b(i3, i9))), new km9(40, 20, 36, 18, 16, new c(28, new b(i3, 44))), new km9(41, 20, 44, 18, 20, new c(34, new b(i3, i11))), new km9(42, 20, 64, 18, 14, new c(i10, new b(i3, 84))), new km9(43, 22, 48, 20, 22, new c(i13, new b(i3, 72))), new km9(44, 24, 48, 22, 22, new c(41, new b(i3, 80))), new km9(45, 24, 64, 22, 14, new c(46, new b(i3, 108))), new km9(46, 26, 40, 24, 18, new c(i13, new b(i3, 70))), new km9(47, 26, 48, 24, 22, new c(i10, new b(i3, 90))), new km9(48, 26, 64, 24, 14, new c(50, new b(i3, 118)))};
    }

    public static km9 h(int i, int i2) throws FormatException {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (km9 km9Var : f42856a) {
            if (km9Var.b == i && km9Var.c == i2) {
                return km9Var;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    public c d() {
        return this.f17750a;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.f;
    }

    public int i() {
        return this.f17749a;
    }

    public String toString() {
        return String.valueOf(this.f17749a);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42858a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final b[] f17751a;

        public b[] a() {
            return this.f17751a;
        }

        public int b() {
            return this.f42858a;
        }

        public c(int i, b bVar) {
            this.f42858a = i;
            this.f17751a = new b[]{bVar};
        }

        public c(int i, b bVar, b bVar2) {
            this.f42858a = i;
            this.f17751a = new b[]{bVar, bVar2};
        }
    }
}
