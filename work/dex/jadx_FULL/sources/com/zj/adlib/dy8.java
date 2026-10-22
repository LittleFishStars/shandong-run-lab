package com.zj.adlib;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class dy8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dy8[] f41306a;
    public static dy8[] b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f16162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16163a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f16164b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    static {
        dy8[] dy8VarArr = {new dy8(false, 3, 5, 8, 8, 1), new dy8(false, 5, 7, 10, 10, 1), new dy8(true, 5, 7, 16, 6, 1), new dy8(false, 8, 10, 12, 12, 1), new dy8(true, 10, 11, 14, 6, 2), new dy8(false, 12, 12, 14, 14, 1), new dy8(true, 16, 14, 24, 10, 1), new dy8(false, 18, 14, 16, 16, 1), new dy8(false, 22, 18, 18, 18, 1), new dy8(true, 22, 18, 16, 10, 2), new dy8(false, 30, 20, 20, 20, 1), new dy8(true, 32, 24, 16, 14, 2), new dy8(false, 36, 24, 22, 22, 1), new dy8(false, 44, 28, 24, 24, 1), new dy8(true, 49, 28, 22, 14, 2), new dy8(false, 62, 36, 14, 14, 4), new dy8(false, 86, 42, 16, 16, 4), new dy8(false, 114, 48, 18, 18, 4), new dy8(false, 144, 56, 20, 20, 4), new dy8(false, 174, 68, 22, 22, 4), new dy8(false, 204, 84, 24, 24, 4, 102, 42), new dy8(false, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 112, 14, 14, 16, 140, 56), new dy8(false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, 144, 16, 16, 16, 92, 36), new dy8(false, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 192, 18, 18, 16, 114, 48), new dy8(false, hs5.f, 224, 20, 20, 16, 144, 56), new dy8(false, 696, 272, 22, 22, 16, 174, 68), new dy8(false, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 24, 24, 16, 136, 56), new dy8(false, 1050, 408, 18, 18, 36, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 68), new dy8(false, 1304, 496, 20, 20, 36, 163, 62), new x62()};
        f41306a = dy8VarArr;
        b = dy8VarArr;
    }

    public dy8(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    public static dy8 m(int i) {
        return p(i, SymbolShapeHint.FORCE_NONE, true);
    }

    public static dy8 n(int i, SymbolShapeHint symbolShapeHint) {
        return p(i, symbolShapeHint, true);
    }

    public static dy8 o(int i, SymbolShapeHint symbolShapeHint, tn2 tn2Var, tn2 tn2Var2, boolean z) {
        for (dy8 dy8Var : b) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && dy8Var.f16163a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || dy8Var.f16163a) && ((tn2Var == null || (dy8Var.k() >= tn2Var.b() && dy8Var.j() >= tn2Var.a())) && ((tn2Var2 == null || (dy8Var.k() <= tn2Var2.b() && dy8Var.j() <= tn2Var2.a())) && i <= dy8Var.f16162a)))) {
                return dy8Var;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i);
    }

    public static dy8 p(int i, SymbolShapeHint symbolShapeHint, boolean z) {
        return o(i, symbolShapeHint, null, null, z);
    }

    public static dy8 q(int i, boolean z, boolean z2) {
        return p(i, z ? SymbolShapeHint.FORCE_NONE : SymbolShapeHint.FORCE_SQUARE, z2);
    }

    public static void r(dy8[] dy8VarArr) {
        b = dy8VarArr;
    }

    public int a() {
        return this.f16162a + this.f16164b;
    }

    public final int b() {
        return this.f16162a;
    }

    public int c(int i) {
        return this.f;
    }

    public final int d() {
        return this.f16164b;
    }

    public final int e(int i) {
        return this.g;
    }

    public final int f() {
        int i = this.e;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 4) {
                if (i == 16) {
                    return 4;
                }
                if (i == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i2;
    }

    public int g() {
        return this.f16162a / this.f;
    }

    public final int h() {
        return l() * this.d;
    }

    public final int i() {
        return f() * this.c;
    }

    public final int j() {
        return h() + (l() * 2);
    }

    public final int k() {
        return i() + (f() * 2);
    }

    public final int l() {
        int i = this.e;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f16163a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.c);
        sb.append('x');
        sb.append(this.d);
        sb.append(", symbol size ");
        sb.append(k());
        sb.append('x');
        sb.append(j());
        sb.append(", symbol data size ");
        sb.append(i());
        sb.append('x');
        sb.append(h());
        sb.append(", codewords ");
        sb.append(this.f16162a);
        sb.append('+');
        sb.append(this.f16164b);
        return sb.toString();
    }

    public dy8(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f16163a = z;
        this.f16162a = i;
        this.f16164b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
    }
}
