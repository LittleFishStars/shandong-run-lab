package com.zj.adlib;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.base.a;
import com.google.common.net.c;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.oned.OneDReader;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class an1 extends OneDReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f15301a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char[] f15302a = f15301a.toCharArray();
    public static final int[] b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f15303a = new StringBuilder(20);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f15304a = new int[6];

    static {
        int[] iArr = {276, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 322, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 274, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, TypedValues.CycleType.TYPE_WAVE_OFFSET, 420, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 404, 402, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, 360, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY, 308, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 344, 332, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, 300, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 436, 434, 428, 422, 406, 410, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 310, 314, 302, 468, 466, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 474, 470, 306, 350};
        b = iArr;
        f40559a = iArr[47];
    }

    public static void e(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        f(charSequence, length - 2, 20);
        f(charSequence, length - 1, 15);
    }

    public static void f(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += f15301a.indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != f15302a[iIndexOf % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x002c  */
    public static String g(CharSequence charSequence) throws FormatException {
        int i;
        char c;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt >= 'a' && cCharAt <= 'd') {
                if (i2 >= length - 1) {
                    throw FormatException.getFormatInstance();
                }
                i2++;
                char cCharAt2 = charSequence.charAt(i2);
                switch (cCharAt) {
                    case 'a':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i = cCharAt2 - '@';
                        c = (char) i;
                        sb.append(c);
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i = cCharAt2 - '&';
                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                            i = cCharAt2 + l82.f;
                        } else if (cCharAt2 < 'K' || cCharAt2 > 'O') {
                            if (cCharAt2 >= 'P' && cCharAt2 <= 'T') {
                                i = cCharAt2 + '+';
                            } else if (cCharAt2 == 'U') {
                                c = 0;
                            } else if (cCharAt2 == 'V') {
                                c = '@';
                            } else if (cCharAt2 == 'W') {
                                c = '`';
                            } else {
                                if (cCharAt2 < 'X' || cCharAt2 > 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c = a.f5941b;
                            }
                            sb.append(c);
                        } else {
                            i = cCharAt2 + c25.e;
                        }
                        c = (char) i;
                        sb.append(c);
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i = cCharAt2 - ' ';
                            c = (char) i;
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            c = c.b;
                        }
                        sb.append(c);
                        break;
                    case 'd':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i = cCharAt2 + ' ';
                        c = (char) i;
                        sb.append(c);
                        break;
                    default:
                        c = 0;
                        sb.append(c);
                        break;
                }
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb.toString();
    }

    public static char i(int i) throws NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = b;
            if (i2 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i2] == i) {
                return f15302a[i2];
            }
            i2++;
        }
    }

    public static int j(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = Math.round((iArr[i4] * 9.0f) / i);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < iRound; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    @Override // com.google.zxing.oned.OneDReader
    public ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArrH = h(qv0Var);
        int iP = qv0Var.p(iArrH[1]);
        int iS = qv0Var.s();
        int[] iArr = this.f15304a;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f15303a;
        sb.setLength(0);
        while (true) {
            OneDReader.recordPattern(qv0Var, iP, iArr);
            int iJ = j(iArr);
            if (iJ < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cI = i(iJ);
            sb.append(cI);
            int i2 = iP;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iP2 = qv0Var.p(i2);
            if (cI == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                if (iP2 == iS || !qv0Var.m(iP2)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                e(sb);
                sb.setLength(sb.length() - 2);
                float f = i;
                ug7 ug7Var = new ug7(g(sb), null, new xg7[]{new xg7((iArrH[1] + iArrH[0]) / 2.0f, f), new xg7(iP + (i4 / 2.0f), f)}, BarcodeFormat.CODE_93);
                ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]G0");
                return ug7Var;
            }
            iP = iP2;
        }
    }

    public final int[] h(qv0 qv0Var) throws NotFoundException {
        int iS = qv0Var.s();
        int iP = qv0Var.p(0);
        Arrays.fill(this.f15304a, 0);
        int[] iArr = this.f15304a;
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
                    if (j(iArr) == f40559a) {
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
}
