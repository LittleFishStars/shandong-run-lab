package com.zj.adlib;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.a;
import com.google.common.net.c;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.oned.OneDReader;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ym1 extends OneDReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46065a = 148;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20885a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    public static final int[] b = {52, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 97, 352, 49, 304, 112, 37, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 100, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 73, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, 25, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 88, 13, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 76, 28, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 67, 322, 19, 274, 82, 7, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, 70, 22, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500, 193, 448, 145, 400, 208, 133, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 168, 162, 138, 42};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f20886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f20888a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f20889b;

    public ym1() {
        this(false);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    public static String e(CharSequence charSequence) throws FormatException {
        int i;
        char c;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                i2++;
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c = c.b;
                            }
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i = cCharAt2 + ' ';
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i = cCharAt2 - '&';
                    } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                        i = cCharAt2 + l82.f;
                    } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                        i = cCharAt2 + c25.e;
                    } else if (cCharAt2 >= 'P' && cCharAt2 <= 'T') {
                        i = cCharAt2 + '+';
                    } else if (cCharAt2 == 'U') {
                        c = 0;
                    } else if (cCharAt2 == 'V') {
                        c = '@';
                    } else if (cCharAt2 == 'W') {
                        c = '`';
                    } else {
                        if (cCharAt2 != 'X' && cCharAt2 != 'Y' && cCharAt2 != 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        c = a.f5941b;
                    }
                    sb.append(c);
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i = cCharAt2 - '@';
                }
                c = (char) i;
                sb.append(c);
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb.toString();
    }

    public static int[] f(qv0 qv0Var, int[] iArr) throws NotFoundException {
        int iS = qv0Var.s();
        int iP = qv0Var.p(0);
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        int i2 = iP;
        while (iP < iS) {
            if (qv0Var.m(iP) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i != length - 1) {
                    i++;
                } else {
                    if (h(iArr) == 148 && qv0Var.u(Math.max(0, i2 - ((iP - i2) / 2)), i2, false)) {
                        return new int[]{i2, iP};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i3 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            }
            iP++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static char g(int i) throws NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = b;
            if (i2 >= iArr.length) {
                if (i == 148) {
                    return '*';
                }
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i2] == i) {
                return f20885a.charAt(i2);
            }
            i2++;
        }
    }

    public static int h(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if (i10 * 2 >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            }
            if (i4 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArr = this.f20888a;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f20886a;
        sb.setLength(0);
        int[] iArrF = f(qv0Var, iArr);
        int iP = qv0Var.p(iArrF[1]);
        int iS = qv0Var.s();
        while (true) {
            OneDReader.recordPattern(qv0Var, iP, iArr);
            int iH = h(iArr);
            if (iH < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cG = g(iH);
            sb.append(cG);
            int i2 = iP;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iP2 = qv0Var.p(i2);
            if (cG == '*') {
                sb.setLength(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int i6 = (iP2 - iP) - i4;
                if (iP2 != iS && i6 * 2 < i4) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.f20887a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i7 = 0; i7 < length; i7++) {
                        iIndexOf += f20885a.indexOf(this.f20886a.charAt(i7));
                    }
                    if (sb.charAt(length) != f20885a.charAt(iIndexOf % 43)) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f = i;
                ug7 ug7Var = new ug7(this.f20889b ? e(sb) : sb.toString(), null, new xg7[]{new xg7((iArrF[1] + iArrF[0]) / 2.0f, f), new xg7(iP + (i4 / 2.0f), f)}, BarcodeFormat.CODE_39);
                ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]A0");
                return ug7Var;
            }
            iP = iP2;
        }
    }

    public ym1(boolean z) {
        this(z, false);
    }

    public ym1(boolean z, boolean z2) {
        this.f20887a = z;
        this.f20889b = z2;
        this.f20886a = new StringBuilder(20);
        this.f20888a = new int[9];
    }
}
