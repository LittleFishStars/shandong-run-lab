package com.google.zxing.oned.rss.expanded.decoders;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.zj.adlib.dv9;
import com.zj.adlib.ey0;
import com.zj.adlib.qv0;
import com.zj.adlib.sf3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qv0 f6773a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CurrentParsingState f32528a = new CurrentParsingState();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f6774a = new StringBuilder();

    public j(qv0 qv0Var) {
        this.f6773a = qv0Var;
    }

    public static int g(qv0 qv0Var, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (qv0Var.m(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public String a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            h hVarC = c(i, str);
            String strA = sf3.a(hVarC.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = hVarC.d() ? String.valueOf(hVarC.c()) : null;
            if (i == hVarC.a()) {
                return sb.toString();
            }
            i = hVarC.a();
            str = strValueOf;
        }
    }

    public final g b(int i) {
        char c;
        int iF = f(i, 5);
        if (iF == 15) {
            return new g(i + 5, g.b);
        }
        if (iF >= 5 && iF < 15) {
            return new g(i + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new g(i + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + iF2);
        }
        return new g(i + 6, c);
    }

    public h c(int i, String str) throws FormatException {
        this.f6774a.setLength(0);
        if (str != null) {
            this.f6774a.append(str);
        }
        this.f32528a.i(i);
        h hVarO = o();
        return (hVarO == null || !hVarO.d()) ? new h(this.f32528a.a(), this.f6774a.toString()) : new h(this.f32528a.a(), this.f6774a.toString(), hVarO.c());
    }

    public final g d(int i) throws FormatException {
        char c;
        int iF = f(i, 5);
        if (iF == 15) {
            return new g(i + 5, g.b);
        }
        if (iF >= 5 && iF < 15) {
            return new g(i + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new g(i + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new g(i + 7, (char) (iF2 + 7));
        }
        switch (f(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = dv9.d;
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case MatroskaExtractor.T /* 238 */:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                c = '-';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                c = '.';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE /* 244 */:
                c = '/';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR /* 245 */:
                c = com.google.common.net.c.b;
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT /* 246 */:
                c = dv9.e;
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT /* 247 */:
                c = dv9.f41283a;
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT /* 248 */:
                c = com.alipay.sdk.m.p.a.h;
                break;
            case 249:
                c = dv9.b;
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF /* 252 */:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new g(i + 8, c);
    }

    public final i e(int i) throws FormatException {
        int i2 = i + 7;
        if (i2 > this.f6773a.s()) {
            int iF = f(i, 4);
            return iF == 0 ? new i(this.f6773a.s(), 10, 10) : new i(this.f6773a.s(), iF - 1, 10);
        }
        int iF2 = f(i, 7) - 8;
        return new i(i2, iF2 / 11, iF2 % 11);
    }

    public int f(int i, int i2) {
        return g(this.f6773a, i, i2);
    }

    public final boolean h(int i) {
        int i2 = i + 3;
        if (i2 > this.f6773a.s()) {
            return false;
        }
        while (i < i2) {
            if (this.f6773a.m(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean i(int i) {
        int i2;
        if (i + 1 > this.f6773a.s()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.f6773a.s(); i3++) {
            if (i3 == 2) {
                if (!this.f6773a.m(i + 2)) {
                    return false;
                }
            } else if (this.f6773a.m(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i) {
        int i2;
        if (i + 1 > this.f6773a.s()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.f6773a.s(); i3++) {
            if (this.f6773a.m(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i) {
        int iF;
        if (i + 5 > this.f6773a.s()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i + 6 <= this.f6773a.s() && (iF = f(i, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    public final boolean l(int i) {
        int iF;
        if (i + 5 > this.f6773a.s()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i + 7 > this.f6773a.s()) {
            return false;
        }
        int iF3 = f(i, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i + 8 <= this.f6773a.s() && (iF = f(i, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    public final boolean m(int i) {
        if (i + 7 > this.f6773a.s()) {
            return i + 4 <= this.f6773a.s();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.f6773a.m(i3);
            }
            if (this.f6773a.m(i2)) {
                return true;
            }
            i2++;
        }
    }

    public final ey0 n() {
        while (k(this.f32528a.a())) {
            g gVarB = b(this.f32528a.a());
            this.f32528a.i(gVarB.a());
            if (gVarB.c()) {
                return new ey0(new h(this.f32528a.a(), this.f6774a.toString()), true);
            }
            this.f6774a.append(gVarB.b());
        }
        if (h(this.f32528a.a())) {
            this.f32528a.b(3);
            this.f32528a.h();
        } else if (i(this.f32528a.a())) {
            if (this.f32528a.a() + 5 < this.f6773a.s()) {
                this.f32528a.b(5);
            } else {
                this.f32528a.i(this.f6773a.s());
            }
            this.f32528a.g();
        }
        return new ey0();
    }

    public final h o() throws FormatException {
        ey0 ey0VarQ;
        boolean zB;
        do {
            int iA = this.f32528a.a();
            if (this.f32528a.c()) {
                ey0VarQ = n();
                zB = ey0VarQ.b();
            } else if (this.f32528a.d()) {
                ey0VarQ = p();
                zB = ey0VarQ.b();
            } else {
                ey0VarQ = q();
                zB = ey0VarQ.b();
            }
            if (!(iA != this.f32528a.a()) && !zB) {
                break;
            }
        } while (!zB);
        return ey0VarQ.a();
    }

    public final ey0 p() throws FormatException {
        while (l(this.f32528a.a())) {
            g gVarD = d(this.f32528a.a());
            this.f32528a.i(gVarD.a());
            if (gVarD.c()) {
                return new ey0(new h(this.f32528a.a(), this.f6774a.toString()), true);
            }
            this.f6774a.append(gVarD.b());
        }
        if (h(this.f32528a.a())) {
            this.f32528a.b(3);
            this.f32528a.h();
        } else if (i(this.f32528a.a())) {
            if (this.f32528a.a() + 5 < this.f6773a.s()) {
                this.f32528a.b(5);
            } else {
                this.f32528a.i(this.f6773a.s());
            }
            this.f32528a.f();
        }
        return new ey0();
    }

    public final ey0 q() throws FormatException {
        while (m(this.f32528a.a())) {
            i iVarE = e(this.f32528a.a());
            this.f32528a.i(iVarE.a());
            if (iVarE.e()) {
                return new ey0(iVarE.f() ? new h(this.f32528a.a(), this.f6774a.toString()) : new h(this.f32528a.a(), this.f6774a.toString(), iVarE.c()), true);
            }
            this.f6774a.append(iVarE.b());
            if (iVarE.f()) {
                return new ey0(new h(this.f32528a.a(), this.f6774a.toString()), true);
            }
            this.f6774a.append(iVarE.c());
        }
        if (j(this.f32528a.a())) {
            this.f32528a.f();
            this.f32528a.b(4);
        }
        return new ey0();
    }
}
