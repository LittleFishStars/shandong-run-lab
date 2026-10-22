package com.kc.cw.ad;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f38714a = new b(320, 50, "320x50_mb");
    public static final b b = new b(468, 60, "468x60_as");
    public static final b c = new b(320, 100, "320x100_as");
    public static final b d = new b(728, 90, "728x90_as");
    public static final b e = new b(300, 250, "300x250_as");
    public static final b f = new b(160, 600, "160x600_as");
    public static final b g = new b(-1, -2, "smart_banner");
    public static final b h = new b(-3, -4, "fluid");
    public static final b i = new b(-3, 0, "search_v2");
    private final int j;
    private final int k;
    private final String l;

    public b(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2 == -1 ? "FULL" : String.valueOf(i2));
        sb.append("x");
        sb.append(i3 == -2 ? "AUTO" : String.valueOf(i3));
        sb.append("_as");
        this(i2, i3, sb.toString());
    }

    private b(int i2, int i3, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i2);
        }
        if (i3 >= 0 || i3 == -2 || i3 == -4) {
            this.j = i2;
            this.k = i3;
            this.l = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i3);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.j == bVar.j && this.k == bVar.k && this.l.equals(bVar.l);
    }

    public int hashCode() {
        return this.l.hashCode();
    }

    public String toString() {
        return this.l;
    }
}
