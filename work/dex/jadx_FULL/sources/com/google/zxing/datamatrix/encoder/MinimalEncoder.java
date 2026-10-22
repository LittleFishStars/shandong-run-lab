package com.google.zxing.datamatrix.encoder;

import com.aliyun.vod.common.utils.IOUtils;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.zxing.oned.rss.expanded.decoders.g;
import com.zj.adlib.dv9;
import com.zj.adlib.hs5;
import com.zj.adlib.qp5;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class MinimalEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f32507a = {'!', '\"', '#', g.b, '%', dv9.d, '\'', '(', ')', '*', '+', ',', '-', '.', '/', com.google.common.net.c.b, dv9.e, dv9.f41283a, com.alipay.sdk.m.p.a.h, dv9.b, '?', '@', '[', IOUtils.DIR_SEPARATOR_WINDOWS, ']', '^', '_'};

    public enum Mode {
        ASCII,
        C40,
        TEXT,
        X12,
        EDF,
        B256
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32508a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[SymbolShapeHint.values().length];
            b = iArr;
            try {
                iArr[SymbolShapeHint.FORCE_SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[SymbolShapeHint.FORCE_RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            f32508a = iArr2;
            try {
                iArr2[Mode.ASCII.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32508a[Mode.B256.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32508a[Mode.C40.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32508a[Mode.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32508a[Mode.X12.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32508a[Mode.EDF.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ boolean f32509a = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final int[] f6729a = {3, 5, 8, 10, 12, 16, 18, 22, 30, 32, 36, 44, 49, 62, 86, 114, 144, 174, 204, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, hs5.f, 696, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, 1050, 1304, 1558};
        public static final int[] b = {3, 5, 8, 12, 18, 22, 30, 36, 44, 62, 86, 114, 144, 174, 204, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, hs5.f, 696, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, 1050, 1304, 1558};
        public static final int[] c = {5, 10, 16, 33, 32, 49};

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f6730a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Mode f6731a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final b f6732a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final c f6733a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final int f6734b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final int f6735c;

        public /* synthetic */ b(c cVar, Mode mode, int i, int i2, b bVar, a aVar) {
            this(cVar, mode, i, i2, bVar);
        }

        public static byte[] h(int i) {
            return new byte[]{(byte) i};
        }

        public static byte[] i(int i, int i2) {
            return new byte[]{(byte) i, (byte) i2};
        }

        public static int j(boolean z, int i, char c2, int i2) {
            if (c2 == i2) {
                return 27;
            }
            if (z) {
                if (c2 <= 31) {
                    return c2;
                }
                if (c2 == ' ') {
                    return 3;
                }
                if (c2 <= '/') {
                    return c2 - '!';
                }
                if (c2 <= '9') {
                    return c2 - ',';
                }
                if (c2 <= '@') {
                    return c2 - '+';
                }
                if (c2 <= 'Z') {
                    return c2 - '3';
                }
                if (c2 <= '_') {
                    return c2 - 'E';
                }
                return c2 <= 127 ? c2 - '`' : c2;
            }
            if (c2 != 0) {
                if (i == 0 && c2 <= 3) {
                    return c2 - 1;
                }
                if (i == 1 && c2 <= 31) {
                    return c2;
                }
                if (c2 == ' ') {
                    return 3;
                }
                if (c2 >= '!' && c2 <= '/') {
                    return c2 - '!';
                }
                if (c2 >= '0' && c2 <= '9') {
                    return c2 - ',';
                }
                if (c2 >= ':' && c2 <= '@') {
                    return c2 - '+';
                }
                if (c2 >= 'A' && c2 <= 'Z') {
                    return c2 - '@';
                }
                if (c2 >= '[' && c2 <= '_') {
                    return c2 - 'E';
                }
                if (c2 != '`') {
                    if (c2 < 'a' || c2 > 'z') {
                        return (c2 < '{' || c2 > 127) ? c2 : c2 - '`';
                    }
                    return c2 - 'S';
                }
            }
            return 0;
        }

        public static int v(char c2, boolean z, int i) {
            if (!(z && MinimalEncoder.m(c2)) && (z || !MinimalEncoder.o(c2))) {
                return (!(z && MinimalEncoder.n(c2, i)) && (z || !MinimalEncoder.p(c2, i))) ? 2 : 1;
            }
            return 0;
        }

        public static int w(char c2) {
            if (c2 == '\r') {
                return 0;
            }
            if (c2 == '*') {
                return 1;
            }
            if (c2 == '>') {
                return 2;
            }
            if (c2 == ' ') {
                return 3;
            }
            if (c2 < '0' || c2 > '9') {
                return (c2 < 'A' || c2 > 'Z') ? c2 : c2 - '3';
            }
            return c2 - ',';
        }

        public static void y(byte[] bArr, int i, int i2, int i3, int i4) {
            int i5 = ((i2 & 255) * 1600) + ((i3 & 255) * 40) + (i4 & 255) + 1;
            bArr[i] = (byte) (i5 / 256);
            bArr[i + 1] = (byte) (i5 % 256);
        }

        public int g() {
            int i = 0;
            for (b bVar = this; bVar != null && bVar.f6731a == Mode.B256 && i <= 250; bVar = bVar.f6732a) {
                i++;
            }
            return i;
        }

        public byte[] k(boolean z, int i) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f6734b; i2++) {
                char cCharAt = this.f6733a.charAt(this.f6730a + i2);
                if ((z && e.j(cCharAt)) || (!z && e.l(cCharAt))) {
                    arrayList.add(Byte.valueOf((byte) j(z, 0, cCharAt, i)));
                } else if (MinimalEncoder.l(cCharAt, i)) {
                    char c2 = (char) ((cCharAt & 255) + com.alipay.sdk.m.p.a.g);
                    if (!(z && e.j(c2)) && (z || !e.l(c2))) {
                        arrayList.add((byte) 1);
                        arrayList.add(Byte.valueOf(com.google.common.base.a.H));
                        int iV = v(c2, z, i);
                        arrayList.add(Byte.valueOf((byte) iV));
                        arrayList.add(Byte.valueOf((byte) j(z, iV, c2, i)));
                    } else {
                        arrayList.add((byte) 1);
                        arrayList.add(Byte.valueOf(com.google.common.base.a.H));
                        arrayList.add(Byte.valueOf((byte) j(z, 0, c2, i)));
                    }
                } else {
                    int iV2 = v(cCharAt, z, i);
                    arrayList.add(Byte.valueOf((byte) iV2));
                    arrayList.add(Byte.valueOf((byte) j(z, iV2, cCharAt, i)));
                }
            }
            if (arrayList.size() % 3 != 0) {
                arrayList.add((byte) 0);
            }
            byte[] bArr = new byte[(arrayList.size() / 3) * 2];
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4 += 3) {
                y(bArr, i3, ((Byte) arrayList.get(i4)).byteValue() & 255, ((Byte) arrayList.get(i4 + 1)).byteValue() & 255, ((Byte) arrayList.get(i4 + 2)).byteValue() & 255);
                i3 += 2;
            }
            return bArr;
        }

        public int l(int i) {
            return r(i) - i;
        }

        public byte[] m() {
            switch (a.f32508a[this.f6731a.ordinal()]) {
                case 1:
                    if (this.f6733a.b(this.f6730a)) {
                        return i(241, this.f6733a.c(this.f6730a) + 1);
                    }
                    if (MinimalEncoder.l(this.f6733a.charAt(this.f6730a), this.f6733a.g())) {
                        return i(235, this.f6733a.charAt(this.f6730a) - 127);
                    }
                    if (this.f6734b == 2) {
                        return h(((((this.f6733a.charAt(this.f6730a) - '0') * 10) + this.f6733a.charAt(this.f6730a + 1)) - 48) + 130);
                    }
                    return this.f6733a.h(this.f6730a) ? h(232) : h(this.f6733a.charAt(this.f6730a) + 1);
                case 2:
                    return h(this.f6733a.charAt(this.f6730a));
                case 3:
                    return k(true, this.f6733a.g());
                case 4:
                    return k(false, this.f6733a.g());
                case 5:
                    return x();
                case 6:
                    return n();
                default:
                    return new byte[0];
            }
        }

        public byte[] n() {
            int iCeil = (int) Math.ceil(((double) this.f6734b) / 4.0d);
            byte[] bArr = new byte[iCeil * 3];
            int i = this.f6730a;
            int iMin = Math.min((this.f6734b + i) - 1, this.f6733a.length() - 1);
            for (int i2 = 0; i2 < iCeil; i2 += 3) {
                int[] iArr = new int[4];
                for (int i3 = 0; i3 < 4; i3++) {
                    if (i <= iMin) {
                        iArr[i3] = this.f6733a.charAt(i) & '?';
                        i++;
                    } else {
                        iArr[i3] = i == iMin + 1 ? 31 : 0;
                    }
                }
                int i4 = (iArr[0] << 18) | (iArr[1] << 12) | (iArr[2] << 6) | iArr[3];
                bArr[i2] = (byte) ((i4 >> 16) & 255);
                bArr[i2 + 1] = (byte) ((i4 >> 8) & 255);
                bArr[i2 + 2] = (byte) (i4 & 255);
            }
            return bArr;
        }

        public Mode o() {
            if (this.f6731a == Mode.EDF) {
                if (this.f6734b < 4) {
                    return Mode.ASCII;
                }
                int iP = p();
                if (iP > 0 && l(this.f6735c + iP) <= 2 - iP) {
                    return Mode.ASCII;
                }
            }
            Mode mode = this.f6731a;
            if (mode == Mode.C40 || mode == Mode.TEXT || mode == Mode.X12) {
                if (this.f6730a + this.f6734b >= this.f6733a.length() && l(this.f6735c) == 0) {
                    return Mode.ASCII;
                }
                if (p() == 1 && l(this.f6735c + 1) == 0) {
                    return Mode.ASCII;
                }
            }
            return this.f6731a;
        }

        public int p() {
            int length = this.f6733a.length();
            int i = this.f6730a + this.f6734b;
            int i2 = length - i;
            if (i2 <= 4 && i < length) {
                if (i2 == 1) {
                    return MinimalEncoder.l(this.f6733a.charAt(i), this.f6733a.g()) ? 0 : 1;
                }
                if (i2 == 2) {
                    if (!MinimalEncoder.l(this.f6733a.charAt(i), this.f6733a.g())) {
                        int i3 = i + 1;
                        if (!MinimalEncoder.l(this.f6733a.charAt(i3), this.f6733a.g())) {
                            return (e.h(this.f6733a.charAt(i)) && e.h(this.f6733a.charAt(i3))) ? 1 : 2;
                        }
                    }
                    return 0;
                }
                if (i2 == 3) {
                    if (e.h(this.f6733a.charAt(i)) && e.h(this.f6733a.charAt(i + 1)) && !MinimalEncoder.l(this.f6733a.charAt(i + 2), this.f6733a.g())) {
                        return 2;
                    }
                    return (e.h(this.f6733a.charAt(i + 1)) && e.h(this.f6733a.charAt(i + 2)) && !MinimalEncoder.l(this.f6733a.charAt(i), this.f6733a.g())) ? 2 : 0;
                }
                if (e.h(this.f6733a.charAt(i)) && e.h(this.f6733a.charAt(i + 1)) && e.h(this.f6733a.charAt(i + 2)) && e.h(this.f6733a.charAt(i + 3))) {
                    return 2;
                }
            }
            return 0;
        }

        public byte[] q() {
            int[] iArr = a.f32508a;
            switch (iArr[t().ordinal()]) {
                case 1:
                case 2:
                    int i = iArr[this.f6731a.ordinal()];
                    if (i == 2) {
                        return h(231);
                    }
                    if (i == 3) {
                        return h(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT);
                    }
                    if (i == 4) {
                        return h(239);
                    }
                    if (i == 5) {
                        return h(MatroskaExtractor.T);
                    }
                    if (i == 6) {
                        return h(240);
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    if (this.f6731a != t()) {
                        switch (iArr[this.f6731a.ordinal()]) {
                            case 1:
                                return h(254);
                            case 2:
                                return i(254, 231);
                            case 3:
                                return i(254, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT);
                            case 4:
                                return i(254, 239);
                            case 5:
                                return i(254, MatroskaExtractor.T);
                            case 6:
                                return i(254, 240);
                        }
                    }
                    break;
            }
            return new byte[0];
        }

        public int r(int i) {
            int i2 = a.b[this.f6733a.l().ordinal()];
            if (i2 == 1) {
                for (int i3 : b) {
                    if (i3 >= i) {
                        return i3;
                    }
                }
            } else if (i2 == 2) {
                for (int i4 : c) {
                    if (i4 >= i) {
                        return i4;
                    }
                }
            }
            for (int i5 : f6729a) {
                if (i5 >= i) {
                    return i5;
                }
            }
            int[] iArr = f6729a;
            return iArr[iArr.length - 1];
        }

        public Mode s() {
            return this.f6731a;
        }

        public Mode t() {
            b bVar = this.f6732a;
            return bVar == null ? Mode.ASCII : bVar.o();
        }

        public Mode u() {
            b bVar = this.f6732a;
            return bVar == null ? Mode.ASCII : bVar.f6731a;
        }

        public byte[] x() {
            int i = (this.f6734b / 3) * 2;
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2 += 2) {
                int i3 = (i2 / 2) * 3;
                y(bArr, i2, w(this.f6733a.charAt(this.f6730a + i3)), w(this.f6733a.charAt(this.f6730a + i3 + 1)), w(this.f6733a.charAt(this.f6730a + i3 + 2)));
            }
            return bArr;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x003c A[PHI: r10
          0x003c: PHI (r10v15 int) = 
          (r10v8 int)
          (r10v8 int)
          (r10v8 int)
          (r10v11 int)
          (r10v11 int)
          (r10v11 int)
          (r10v17 int)
          (r10v17 int)
          (r10v17 int)
         binds: [B:51:0x0089, B:53:0x008d, B:55:0x0091, B:36:0x0067, B:38:0x006b, B:39:0x006d, B:15:0x0032, B:17:0x0036, B:19:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:21:0x0040 A[PHI: r10
          0x0040: PHI (r10v13 int) = (r10v6 int), (r10v6 int), (r10v6 int), (r10v8 int), (r10v11 int), (r10v11 int), (r10v17 int), (r10v17 int) binds: [B:63:0x00ae, B:65:0x00b2, B:67:0x00b6, B:48:0x0084, B:30:0x005c, B:32:0x0060, B:10:0x0029, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        public b(c cVar, Mode mode, int i, int i2, b bVar) {
            this.f6733a = cVar;
            this.f6731a = mode;
            this.f6730a = i;
            this.f6734b = i2;
            this.f6732a = bVar;
            int iK = bVar != null ? bVar.f6735c : 0;
            Mode modeT = t();
            switch (a.f32508a[mode.ordinal()]) {
                case 1:
                    iK++;
                    iK = (cVar.b(i) || MinimalEncoder.l(cVar.charAt(i), cVar.g())) ? iK + 1 : iK;
                    if (modeT == Mode.C40 || modeT == Mode.TEXT || modeT == Mode.X12) {
                        iK++;
                    }
                    break;
                case 2:
                    iK++;
                    iK = (modeT != Mode.B256 || g() == 250) ? iK + 1 : iK;
                    if (modeT == Mode.ASCII) {
                        iK++;
                    } else if (modeT == Mode.C40 || modeT == Mode.TEXT || modeT == Mode.X12) {
                        iK += 2;
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    Mode mode2 = Mode.X12;
                    if (mode == mode2) {
                        iK += 2;
                    } else {
                        iK += MinimalEncoder.k(cVar, i, mode == Mode.C40, new int[1]) * 2;
                    }
                    if (modeT == Mode.ASCII || modeT == Mode.B256) {
                        iK++;
                    } else if (modeT != mode && (modeT == Mode.C40 || modeT == Mode.TEXT || modeT == mode2)) {
                        iK += 2;
                    }
                    break;
                case 6:
                    iK += 3;
                    if (modeT == Mode.ASCII || modeT == Mode.B256) {
                        iK++;
                    } else if (modeT == Mode.C40 || modeT == Mode.TEXT || modeT == Mode.X12) {
                        iK += 2;
                    }
                    break;
            }
            this.f6735c = iK;
        }
    }

    public static final class c extends qp5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SymbolShapeHint f32510a;
        public final int c;

        public /* synthetic */ c(String str, Charset charset, int i, SymbolShapeHint symbolShapeHint, int i2, a aVar) {
            this(str, charset, i, symbolShapeHint, i2);
        }

        public final int k() {
            return this.c;
        }

        public final SymbolShapeHint l() {
            return this.f32510a;
        }

        public c(String str, Charset charset, int i, SymbolShapeHint symbolShapeHint, int i2) {
            super(str, charset, i);
            this.f32510a = symbolShapeHint;
            this.c = i2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f32511a;

        public d(b bVar) {
            int i;
            c cVar = bVar.f6733a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i2 = 0;
            int iC = ((bVar.f6731a == Mode.C40 || bVar.f6731a == Mode.TEXT || bVar.f6731a == Mode.X12) && bVar.o() != Mode.ASCII) ? c(b.h(254), arrayList) + 0 : 0;
            for (b bVar2 = bVar; bVar2 != null; bVar2 = bVar2.f6732a) {
                iC += c(bVar2.m(), arrayList);
                if (bVar2.f6732a == null || bVar2.u() != bVar2.s()) {
                    if (bVar2.s() == Mode.B256) {
                        if (iC <= 249) {
                            arrayList.add(0, Byte.valueOf((byte) iC));
                            i = iC + 1;
                        } else {
                            arrayList.add(0, Byte.valueOf((byte) (iC % 250)));
                            arrayList.add(0, Byte.valueOf((byte) ((iC / 250) + 249)));
                            i = iC + 2;
                        }
                        arrayList2.add(Integer.valueOf(arrayList.size()));
                        arrayList3.add(Integer.valueOf(i));
                    }
                    c(bVar2.q(), arrayList);
                    iC = 0;
                }
            }
            if (cVar.k() == 5) {
                c(b.h(236), arrayList);
            } else if (cVar.k() == 6) {
                c(b.h(237), arrayList);
            }
            if (cVar.g() > 0) {
                c(b.h(232), arrayList);
            }
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                a(arrayList, arrayList.size() - ((Integer) arrayList2.get(i3)).intValue(), ((Integer) arrayList3.get(i3)).intValue());
            }
            int iR = bVar.r(arrayList.size());
            if (arrayList.size() < iR) {
                arrayList.add((byte) -127);
            }
            while (arrayList.size() < iR) {
                arrayList.add(Byte.valueOf((byte) d(arrayList.size() + 1)));
            }
            this.f32511a = new byte[arrayList.size()];
            while (true) {
                byte[] bArr = this.f32511a;
                if (i2 >= bArr.length) {
                    return;
                }
                bArr[i2] = ((Byte) arrayList.get(i2)).byteValue();
                i2++;
            }
        }

        public static void a(List<Byte> list, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i + i3;
                int iByteValue = (list.get(i4).byteValue() & 255) + (((i4 + 1) * 149) % 255) + 1;
                if (iByteValue > 255) {
                    iByteValue -= 256;
                }
                list.set(i4, Byte.valueOf((byte) iByteValue));
            }
        }

        public static int c(byte[] bArr, List<Byte> list) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                list.add(0, Byte.valueOf(bArr[length]));
            }
            return bArr.length;
        }

        public static int d(int i) {
            int i2 = ((i * 149) % 253) + 1 + 129;
            return i2 <= 254 ? i2 : i2 + UIMsg.m_AppUI.V_WM_LISTLISTUPDATE;
        }

        public byte[] b() {
            return this.f32511a;
        }
    }

    public static void e(b[][] bVarArr, b bVar) {
        int i = bVar.f6730a + bVar.f6734b;
        if (bVarArr[i][bVar.o().ordinal()] == null || bVarArr[i][bVar.o().ordinal()].f6735c > bVar.f6735c) {
            bVarArr[i][bVar.o().ordinal()] = bVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(c cVar, b[][] bVarArr, int i, b bVar) {
        if (cVar.b(i)) {
            e(bVarArr, new b(cVar, Mode.ASCII, i, 1, bVar, null));
            return;
        }
        char cCharAt = cVar.charAt(i);
        char c2 = 0;
        if (bVar == null || bVar.o() != Mode.EDF) {
            if (e.h(cCharAt) && cVar.a(i, 2) && e.h(cVar.charAt(i + 1))) {
                e(bVarArr, new b(cVar, Mode.ASCII, i, 2, bVar, null));
            } else {
                e(bVarArr, new b(cVar, Mode.ASCII, i, 1, bVar, null));
            }
            Mode[] modeArr = {Mode.C40, Mode.TEXT};
            int i2 = 0;
            while (i2 < 2) {
                Mode mode = modeArr[i2];
                int[] iArr = new int[1];
                if (k(cVar, i, mode == Mode.C40 ? 1 : c2, iArr) > 0) {
                    e(bVarArr, new b(cVar, mode, i, iArr[c2], bVar, null));
                }
                i2++;
                c2 = 0;
            }
            if (cVar.a(i, 3) && e.m(cVar.charAt(i)) && e.m(cVar.charAt(i + 1)) && e.m(cVar.charAt(i + 2))) {
                e(bVarArr, new b(cVar, Mode.X12, i, 3, bVar, null));
            }
            e(bVarArr, new b(cVar, Mode.B256, i, 1, bVar, null));
        }
        int i3 = 0;
        while (i3 < 3) {
            int i4 = i + i3;
            if (!cVar.a(i4, 1) || !e.k(cVar.charAt(i4))) {
                break;
            }
            i3++;
            e(bVarArr, new b(cVar, Mode.EDF, i, i3, bVar, null));
        }
        if (i3 == 3 && cVar.a(i, 4) && e.k(cVar.charAt(i + 3))) {
            e(bVarArr, new b(cVar, Mode.EDF, i, 4, bVar, null));
        }
    }

    public static byte[] g(String str, Charset charset, int i, SymbolShapeHint symbolShapeHint, int i2) {
        return j(new c(str, charset, i, symbolShapeHint, i2, null)).b();
    }

    public static String h(String str) {
        return i(str, null, -1, SymbolShapeHint.FORCE_NONE);
    }

    public static String i(String str, Charset charset, int i, SymbolShapeHint symbolShapeHint) {
        int i2;
        if (str.startsWith(e.f6737a) && str.endsWith(e.f6741c)) {
            str = str.substring(7, str.length() - 2);
            i2 = 5;
        } else if (str.startsWith(e.f6739b) && str.endsWith(e.f6741c)) {
            str = str.substring(7, str.length() - 2);
            i2 = 6;
        } else {
            i2 = 0;
        }
        return new String(g(str, charset, i, symbolShapeHint, i2), StandardCharsets.ISO_8859_1);
    }

    public static d j(c cVar) {
        int length = cVar.length();
        int i = 0;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, 6);
        f(cVar, bVarArr, 0, null);
        for (int i2 = 1; i2 <= length; i2++) {
            for (int i3 = 0; i3 < 6; i3++) {
                b bVar = bVarArr[i2][i3];
                if (bVar != null && i2 < length) {
                    f(cVar, bVarArr, i2, bVar);
                }
            }
            for (int i4 = 0; i4 < 6; i4++) {
                bVarArr[i2 - 1][i4] = null;
            }
        }
        int i5 = -1;
        int i6 = Integer.MAX_VALUE;
        while (i < 6) {
            b bVar2 = bVarArr[length][i];
            if (bVar2 != null) {
                int i7 = (i < 1 || i > 3) ? bVar2.f6735c : bVar2.f6735c + 1;
                if (i7 < i6) {
                    i5 = i;
                    i6 = i7;
                }
            }
            i++;
        }
        if (i5 >= 0) {
            return new d(bVarArr[length][i5]);
        }
        throw new RuntimeException("Internal error: failed to encode \"" + cVar + "\"");
    }

    public static int k(c cVar, int i, boolean z, int[] iArr) {
        int i2 = 0;
        for (int i3 = i; i3 < cVar.length(); i3++) {
            if (cVar.b(i3)) {
                iArr[0] = 0;
                return 0;
            }
            char cCharAt = cVar.charAt(i3);
            if ((z && e.j(cCharAt)) || (!z && e.l(cCharAt))) {
                i2++;
            } else if (l(cCharAt, cVar.g())) {
                int i4 = cCharAt & 255;
                i2 = (i4 < 128 || (!(z && e.j((char) (i4 + com.alipay.sdk.m.p.a.g))) && (z || !e.l((char) (i4 + com.alipay.sdk.m.p.a.g))))) ? i2 + 4 : i2 + 3;
            } else {
                i2 += 2;
            }
            if (i2 % 3 == 0 || ((i2 - 2) % 3 == 0 && i3 + 1 == cVar.length())) {
                iArr[0] = (i3 - i) + 1;
                return (int) Math.ceil(((double) i2) / 3.0d);
            }
        }
        iArr[0] = 0;
        return 0;
    }

    public static boolean l(char c2, int i) {
        return c2 != i && c2 >= 128 && c2 <= 255;
    }

    public static boolean m(char c2) {
        return c2 <= 31;
    }

    public static boolean n(char c2, int i) {
        for (char c3 : f32507a) {
            if (c3 == c2) {
                return true;
            }
        }
        return c2 == i;
    }

    public static boolean o(char c2) {
        return m(c2);
    }

    public static boolean p(char c2, int i) {
        return n(c2, i);
    }
}
