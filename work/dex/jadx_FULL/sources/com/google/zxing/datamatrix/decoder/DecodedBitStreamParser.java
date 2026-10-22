package com.google.zxing.datamatrix.decoder;

import com.aliyun.vod.common.utils.IOUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.common.net.c;
import com.google.zxing.FormatException;
import com.google.zxing.datamatrix.encoder.e;
import com.google.zxing.oned.rss.expanded.decoders.g;
import com.zj.adlib.dv9;
import com.zj.adlib.gv2;
import com.zj.adlib.l82;
import com.zj.adlib.q82;
import com.zj.adlib.wv0;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class DecodedBitStreamParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f32505a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] b;
    public static final char[] c;
    public static final char[] d;
    public static final char[] e;

    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        ECI_ENCODE
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32506a;

        static {
            int[] iArr = new int[Mode.values().length];
            f32506a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32506a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32506a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32506a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32506a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32506a[Mode.ECI_ENCODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        char[] cArr = {'!', '\"', '#', g.b, '%', dv9.d, '\'', '(', ')', '*', '+', ',', '-', '.', '/', c.b, dv9.e, dv9.f41283a, com.alipay.sdk.m.p.a.h, dv9.b, '?', '@', '[', IOUtils.DIR_SEPARATOR_WINDOWS, ']', '^', '_'};
        b = cArr;
        c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        d = cArr;
        e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', com.google.common.base.a.f5941b};
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0069  */
    /* JADX WARN: Code duplicated, block: B:26:0x0070  */
    /* JADX WARN: Code duplicated, block: B:38:0x0096  */
    /* JADX WARN: Code duplicated, block: B:39:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c9  */
    public static q82 a(byte[] bArr) throws FormatException {
        int i;
        wv0 wv0Var = new wv0(bArr);
        gv2 gv2Var = new gv2(100);
        boolean z = false;
        StringBuilder sb = new StringBuilder(0);
        int i2 = 1;
        ArrayList arrayList = new ArrayList(1);
        Mode modeC = Mode.ASCII_ENCODE;
        HashSet hashSet = new HashSet();
        do {
            Mode mode = Mode.ASCII_ENCODE;
            if (modeC == mode) {
                modeC = c(wv0Var, gv2Var, sb, hashSet);
            } else {
                switch (a.f32506a[modeC.ordinal()]) {
                    case 1:
                        e(wv0Var, gv2Var, hashSet);
                        break;
                    case 2:
                        h(wv0Var, gv2Var, hashSet);
                        break;
                    case 3:
                        b(wv0Var, gv2Var);
                        break;
                    case 4:
                        g(wv0Var, gv2Var);
                        break;
                    case 5:
                        d(wv0Var, gv2Var, arrayList);
                        break;
                    case 6:
                        f(wv0Var, gv2Var);
                        z = true;
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
                modeC = mode;
            }
            if (modeC != Mode.PAD_ENCODE) {
            }
            if (sb.length() > 0) {
                gv2Var.e(sb);
            }
            if (z) {
                if (!hashSet.contains(0) || hashSet.contains(4)) {
                    i = 5;
                } else if (hashSet.contains(1) || hashSet.contains(5)) {
                    i2 = 6;
                } else {
                    i = 4;
                }
                String string = gv2Var.toString();
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                return new q82(bArr, string, arrayList, null, i);
            }
            if (!hashSet.contains(0) || hashSet.contains(4)) {
                i2 = 2;
            } else if (hashSet.contains(1) || hashSet.contains(5)) {
                i2 = 3;
            }
            i = i2;
            String string2 = gv2Var.toString();
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new q82(bArr, string2, arrayList, null, i);
        } while (wv0Var.a() > 0);
        if (sb.length() > 0) {
            gv2Var.e(sb);
        }
        if (z) {
            if (hashSet.contains(0)) {
                i = 5;
            } else {
                i = 5;
            }
            String string3 = gv2Var.toString();
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new q82(bArr, string3, arrayList, null, i);
        }
        if (hashSet.contains(0)) {
            i2 = 2;
        } else {
            i2 = 2;
        }
        i = i2;
        String string4 = gv2Var.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new q82(bArr, string4, arrayList, null, i);
    }

    public static void b(wv0 wv0Var, gv2 gv2Var) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        while (wv0Var.a() != 8 && (iD = wv0Var.d(8)) != 254) {
            i(iD, wv0Var.d(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    gv2Var.b('\r');
                } else if (i2 == 1) {
                    gv2Var.b('*');
                } else if (i2 == 2) {
                    gv2Var.b(dv9.b);
                } else if (i2 == 3) {
                    gv2Var.b(' ');
                } else if (i2 < 14) {
                    gv2Var.b((char) (i2 + 44));
                } else {
                    if (i2 >= 40) {
                        throw FormatException.getFormatInstance();
                    }
                    gv2Var.b((char) (i2 + 51));
                }
            }
            if (wv0Var.a() <= 0) {
                return;
            }
        }
    }

    public static Mode c(wv0 wv0Var, gv2 gv2Var, StringBuilder sb, Set<Integer> set) throws FormatException {
        boolean z = false;
        do {
            int iD = wv0Var.d(8);
            if (iD == 0) {
                throw FormatException.getFormatInstance();
            }
            if (iD > 128) {
                if (iD != 129) {
                    if (iD > 229) {
                        switch (iD) {
                            case MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT /* 230 */:
                                return Mode.C40_ENCODE;
                            case 231:
                                return Mode.BASE256_ENCODE;
                            case 232:
                                set.add(Integer.valueOf(gv2Var.i()));
                                gv2Var.b(l82.o);
                                break;
                            case 233:
                            case 234:
                                break;
                            case 235:
                                z = true;
                                break;
                            case 236:
                                gv2Var.d(e.f6737a);
                                sb.insert(0, e.f6741c);
                                break;
                            case 237:
                                gv2Var.d(e.f6739b);
                                sb.insert(0, e.f6741c);
                                break;
                            case MatroskaExtractor.T /* 238 */:
                                return Mode.ANSIX12_ENCODE;
                            case 239:
                                return Mode.TEXT_ENCODE;
                            case 240:
                                return Mode.EDIFACT_ENCODE;
                            case 241:
                                return Mode.ECI_ENCODE;
                            default:
                                if (iD != 254 || wv0Var.a() != 0) {
                                    throw FormatException.getFormatInstance();
                                }
                                break;
                        }
                    } else {
                        int i = iD - 130;
                        if (i < 10) {
                            gv2Var.b('0');
                        }
                        gv2Var.c(i);
                    }
                } else {
                    return Mode.PAD_ENCODE;
                }
            } else {
                if (z) {
                    iD += 128;
                }
                gv2Var.b((char) (iD - 1));
                return Mode.ASCII_ENCODE;
            }
        } while (wv0Var.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    public static void d(wv0 wv0Var, gv2 gv2Var, Collection<byte[]> collection) throws FormatException {
        int iC = wv0Var.c() + 1;
        int i = iC + 1;
        int iJ = j(wv0Var.d(8), iC);
        if (iJ == 0) {
            iJ = wv0Var.a() / 8;
        } else if (iJ >= 250) {
            iJ = ((iJ - 249) * 250) + j(wv0Var.d(8), i);
            i++;
        }
        if (iJ < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[iJ];
        int i2 = 0;
        while (i2 < iJ) {
            if (wv0Var.a() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i2] = (byte) j(wv0Var.d(8), i);
            i2++;
            i++;
        }
        collection.add(bArr);
        gv2Var.d(new String(bArr, StandardCharsets.ISO_8859_1));
    }

    public static void e(wv0 wv0Var, gv2 gv2Var, Set<Integer> set) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (wv0Var.a() != 8 && (iD = wv0Var.d(8)) != 254) {
            i(iD, wv0Var.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = b;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    gv2Var.b((char) (c2 + 128));
                                    z = false;
                                } else {
                                    gv2Var.b(c2);
                                }
                            } else if (i3 == 27) {
                                set.add(Integer.valueOf(gv2Var.i()));
                                gv2Var.b(l82.o);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                        } else {
                            if (i != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            if (z) {
                                gv2Var.b((char) (i3 + 224));
                                z = false;
                            } else {
                                gv2Var.b((char) (i3 + 96));
                            }
                        }
                    } else if (z) {
                        gv2Var.b((char) (i3 + 128));
                        z = false;
                    } else {
                        gv2Var.b((char) i3);
                    }
                    i = 0;
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr2 = f32505a;
                    if (i3 >= cArr2.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c3 = cArr2[i3];
                    if (z) {
                        gv2Var.b((char) (c3 + 128));
                        z = false;
                    } else {
                        gv2Var.b(c3);
                    }
                }
            }
            if (wv0Var.a() <= 0) {
                return;
            }
        }
    }

    public static void f(wv0 wv0Var, gv2 gv2Var) throws FormatException {
        if (wv0Var.a() < 8) {
            throw FormatException.getFormatInstance();
        }
        int iD = wv0Var.d(8);
        if (iD <= 127) {
            gv2Var.f(iD - 1);
        }
    }

    public static void g(wv0 wv0Var, gv2 gv2Var) {
        while (wv0Var.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int iD = wv0Var.d(6);
                if (iD == 31) {
                    int iB = 8 - wv0Var.b();
                    if (iB != 8) {
                        wv0Var.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                gv2Var.b((char) iD);
            }
            if (wv0Var.a() <= 0) {
                return;
            }
        }
    }

    public static void h(wv0 wv0Var, gv2 gv2Var, Set<Integer> set) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (wv0Var.a() != 8 && (iD = wv0Var.d(8)) != 254) {
            i(iD, wv0Var.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = d;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    gv2Var.b((char) (c2 + 128));
                                    z = false;
                                } else {
                                    gv2Var.b(c2);
                                }
                            } else if (i3 == 27) {
                                set.add(Integer.valueOf(gv2Var.i()));
                                gv2Var.b(l82.o);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                        } else {
                            if (i != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            char[] cArr2 = e;
                            if (i3 >= cArr2.length) {
                                throw FormatException.getFormatInstance();
                            }
                            char c3 = cArr2[i3];
                            if (z) {
                                gv2Var.b((char) (c3 + 128));
                                z = false;
                            } else {
                                gv2Var.b(c3);
                            }
                        }
                    } else if (z) {
                        gv2Var.b((char) (i3 + 128));
                        z = false;
                    } else {
                        gv2Var.b((char) i3);
                    }
                    i = 0;
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr3 = c;
                    if (i3 >= cArr3.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c4 = cArr3[i3];
                    if (z) {
                        gv2Var.b((char) (c4 + 128));
                        z = false;
                    } else {
                        gv2Var.b(c4);
                    }
                }
            }
            if (wv0Var.a() <= 0) {
                return;
            }
        }
    }

    public static void i(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    public static int j(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
