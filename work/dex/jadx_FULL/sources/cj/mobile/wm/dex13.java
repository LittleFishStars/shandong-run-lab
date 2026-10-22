package cj.mobile.wm;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.util.TypeUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.vod.common.utils.IOUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class dex13 {
    public static final boolean[] dex01;
    public static final boolean[] dex02;
    public static boolean dexv;
    public static final ThreadLocal<char[]> dexw;
    public static final int[] dexx;
    public static final char[] dexy;
    public static final int[] dexz;
    public int dexa;
    public int dexb;
    public int dexc;
    public char dexd;
    public int dexe;
    public int dexf;
    public char[] dexg;
    public int dexh;
    public boolean dexi;
    public boolean dexj;
    public int dexk;
    public boolean dexl;
    public TimeZone dexm;
    public Locale dexn;
    public Calendar dexo;
    public int dexp;
    public final String dexq;
    public final int dexr;
    public String dexs;
    public boolean dext;
    public long dexu;

    static {
        int i;
        char c;
        char c2;
        try {
            i = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
            while (true) {
                boolean[] zArr = dex01;
                if (c2 >= zArr.length) {
                    break;
                }
                if (c2 >= 'A' && c2 <= 'Z') {
                    zArr[c2] = true;
                } else if (c2 >= 'a' && c2 <= 'z') {
                    zArr[c2] = true;
                } else if (c2 == '_') {
                    zArr[c2] = true;
                }
                c2 = (char) (c2 + 1);
            }
            while (true) {
                boolean[] zArr2 = dex02;
                if (c >= zArr2.length) {
                    return;
                }
                if (c >= 'A' && c <= 'Z') {
                    zArr2[c] = true;
                } else if (c >= 'a' && c <= 'z') {
                    zArr2[c] = true;
                } else if (c == '_') {
                    zArr2[c] = true;
                } else if (c >= '0' && c <= '9') {
                    zArr2[c] = true;
                }
                c = (char) (c + 1);
            }
        } catch (Exception unused) {
            i = -1;
        }
        c = 0;
        dexv = i >= 23;
        dexw = new ThreadLocal<>();
        dexx = new int[103];
        for (int i2 = 48; i2 <= 57; i2++) {
            dexx[i2] = i2 - 48;
        }
        for (int i3 = 97; i3 <= 102; i3++) {
            dexx[i3] = (i3 - 97) + 10;
        }
        for (int i4 = 65; i4 <= 70; i4++) {
            dexx[i4] = (i4 - 65) + 10;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        dexy = charArray;
        int[] iArr = new int[256];
        dexz = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i5 = 0; i5 < length; i5++) {
            dexz[dexy[i5]] = i5;
        }
        dexz[61] = 0;
        dex01 = new boolean[256];
        c2 = 0;
        dex02 = new boolean[256];
    }

    public dex13(String str) {
        this(str, dex04.c);
    }

    public dex13(String str, int i) {
        this.dexc = dex04.c;
        this.dexi = false;
        this.dexj = false;
        this.dexm = dex04.f22670a;
        this.dexn = dex04.b;
        this.dexo = null;
        this.dexp = 0;
        char[] cArr = dexw.get();
        this.dexg = cArr;
        if (cArr == null) {
            this.dexg = new char[512];
        }
        this.dexc = i;
        this.dexq = str;
        int length = str.length();
        this.dexr = length;
        this.dexe = 0;
        char cCharAt = length <= 0 ? (char) 26 : str.charAt(0);
        this.dexd = cCharAt;
        if (cCharAt == 65279) {
            dexi();
        }
        this.dexs = (com.wangmai.insightvision.openadsdk.d.i.d.m.t & i) != 0 ? "" : null;
        this.dext = (com.wangmai.insightvision.openadsdk.d.i.d.l.t & i) != 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:46:0x00ee  */
    public static String dexa(char[] cArr, int i) throws com.wangmai.insightvision.openadsdk.d.d {
        int i2;
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            char c = cArr[i3];
            if (c != '\\') {
                cArr2[i4] = c;
                i4++;
            } else {
                i3++;
                char c2 = cArr[i3];
                if (c2 == '\"') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\"';
                } else if (c2 == '\'') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\'';
                } else if (c2 == 'F') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\f';
                } else if (c2 == '\\') {
                    i2 = i4 + 1;
                    cArr2[i4] = IOUtils.DIR_SEPARATOR_WINDOWS;
                } else if (c2 == 'b') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\b';
                } else if (c2 == 'f') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\f';
                } else if (c2 == 'n') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\n';
                } else if (c2 == 'r') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\r';
                } else if (c2 != 'x') {
                    switch (c2) {
                        case '/':
                            i2 = i4 + 1;
                            cArr2[i4] = '/';
                            break;
                        case '0':
                            i2 = i4 + 1;
                            cArr2[i4] = 0;
                            break;
                        case '1':
                            i2 = i4 + 1;
                            cArr2[i4] = 1;
                            break;
                        case '2':
                            i2 = i4 + 1;
                            cArr2[i4] = 2;
                            break;
                        case '3':
                            i2 = i4 + 1;
                            cArr2[i4] = 3;
                            break;
                        case '4':
                            i2 = i4 + 1;
                            cArr2[i4] = 4;
                            break;
                        case '5':
                            i2 = i4 + 1;
                            cArr2[i4] = 5;
                            break;
                        case '6':
                            i2 = i4 + 1;
                            cArr2[i4] = 6;
                            break;
                        case '7':
                            i2 = i4 + 1;
                            cArr2[i4] = 7;
                            break;
                        default:
                            switch (c2) {
                                case 't':
                                    i2 = i4 + 1;
                                    cArr2[i4] = '\t';
                                    break;
                                case 'u':
                                    i2 = i4 + 1;
                                    int i5 = i3 + 1;
                                    int i6 = i5 + 1;
                                    int i7 = i6 + 1;
                                    i3 = i7 + 1;
                                    cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                                    break;
                                case 'v':
                                    i2 = i4 + 1;
                                    cArr2[i4] = 11;
                                    break;
                                default:
                                    throw new com.wangmai.insightvision.openadsdk.d.d("unclosed.str.lit");
                            }
                            break;
                    }
                } else {
                    i2 = i4 + 1;
                    int[] iArr = dexx;
                    int i8 = i3 + 1;
                    int i9 = iArr[cArr[i8]] * 16;
                    i3 = i8 + 1;
                    cArr2[i4] = (char) (i9 + iArr[cArr[i3]]);
                }
                i4 = i2;
            }
            i3++;
        }
        return new String(cArr2, 0, i4);
    }

    private void dexa(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar calendar = Calendar.getInstance(this.dexm, this.dexn);
        this.dexo = calendar;
        calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.dexo.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.dexo.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    public static boolean dexa(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '1' && c <= '3' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (c5 != '1' || (c6 != '0' && c6 != '1' && c6 != '2')) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            }
            if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            }
            if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    public static final byte[] dexa(String str, int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i6 = (i + i2) - 1;
        while (i < i6 && dexz[str.charAt(i)] < 0) {
            i++;
        }
        while (i6 > 0 && dexz[str.charAt(i6)] < 0) {
            i6--;
        }
        if (str.charAt(i6) == '=') {
            i3 = str.charAt(i6 + (-1)) == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i7 = (i6 - i) + 1;
        if (i2 > 76) {
            i4 = (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i8 = (((i7 - i4) * 6) >> 3) - i3;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int[] iArr = dexz;
            int i12 = i + 1;
            int i13 = i12 + 1;
            int i14 = (iArr[str.charAt(i)] << 18) | (iArr[str.charAt(i12)] << 12);
            int i15 = i13 + 1;
            int i16 = i14 | (iArr[str.charAt(i13)] << 6);
            int i17 = i15 + 1;
            int i18 = i16 | iArr[str.charAt(i15)];
            int i19 = i10 + 1;
            bArr[i10] = (byte) (i18 >> 16);
            int i20 = i19 + 1;
            bArr[i19] = (byte) (i18 >> 8);
            i10 = i20 + 1;
            bArr[i20] = (byte) i18;
            if (i4 <= 0 || (i11 = i11 + 1) != 19) {
                i = i17;
            } else {
                i = i17 + 2;
                i11 = 0;
            }
        }
        if (i10 < i8) {
            int i21 = 0;
            while (i <= i6 - i3) {
                i5 |= dexz[str.charAt(i)] << (18 - (i21 * 6));
                i21++;
                i++;
            }
            int i22 = 16;
            while (i10 < i8) {
                bArr[i10] = (byte) (i5 >> i22);
                i22 -= 8;
                i10++;
            }
        }
        return bArr;
    }

    private final String dexb(int i, int i2) {
        char[] cArr = this.dexg;
        if (i2 < cArr.length) {
            this.dexq.getChars(i, i + i2, cArr, 0);
            return new String(this.dexg, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.dexq.getChars(i, i2 + i, cArr2, 0);
        return new String(cArr2);
    }

    public static boolean dexb(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else {
            if (c != '1') {
                if (c == '2' && c2 >= '0' && c2 <= '4') {
                }
                return false;
            }
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        }
        if (c3 < '0' || c3 > '5') {
            if (c3 != '6' || c4 != '0') {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        if (c5 < '0' || c5 > '5') {
            return c5 == '6' && c6 == '0';
        }
        return c6 >= '0' && c6 <= '9';
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0060 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:73:0x007f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0079 -> B:41:0x007a). Please report as a decompilation issue!!! */
    private int dexo(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var;
        char cCharAt;
        char cCharAt2 = this.dexd;
        int i = 1;
        while (cCharAt2 != '\"' && cCharAt2 != '\'') {
            if (cCharAt2 != ' ' && cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != '\t' && cCharAt2 != '\f' && cCharAt2 != '\b') {
                this.dexu = 0L;
                this.dexp = -2;
                return 0;
            }
            i++;
            int i2 = this.dexe + i;
            cCharAt2 = i2 >= this.dexr ? (char) 26 : this.dexq.charAt(i2);
        }
        long j2 = TypeUtils.fnv1a_64_magic_hashcode;
        for (int i3 = this.dexe + i; i3 < this.dexr; i3++) {
            char cCharAt3 = this.dexq.charAt(i3);
            if (cCharAt3 == cCharAt2) {
                i += (i3 - this.dexe) - i;
                break;
            }
            j2 = TypeUtils.fnv1a_64_magic_prime * (((long) cCharAt3) ^ j2);
        }
        if (j2 != j) {
            this.dexu = j2;
            this.dexp = -2;
            return 0;
        }
        int i4 = i + 1;
        int i5 = this.dexe + i4;
        if (i5 < this.dexr) {
            dex13Var = this;
            cCharAt = dex13Var.dexq.charAt(i5);
            while (cCharAt != ':') {
                if (cCharAt > ' ' && (cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\f' || cCharAt == '\b')) {
                    int i6 = i4 + 1;
                    int i7 = dex13Var.dexe + i4;
                    if (i7 >= dex13Var.dexr) {
                        i4 = i6;
                    } else {
                        i4 = i6;
                        cCharAt = dex13Var.dexq.charAt(i7);
                    }
                    while (cCharAt != ':') {
                        if (cCharAt > ' ') {
                        }
                    }
                }
                throw new com.wangmai.insightvision.openadsdk.d.d("match feild error expect ':'");
            }
            return i4 + 1;
        }
        dex13Var = this;
        cCharAt = 26;
        while (cCharAt != ':') {
            if (cCharAt > ' ') {
            }
            throw new com.wangmai.insightvision.openadsdk.d.d("match feild error expect ':'");
        }
        return i4 + 1;
    }

    private void dexv() {
        int i;
        this.dexk = this.dexe - 1;
        this.dexl = false;
        do {
            this.dexh++;
            dexi();
        } while (Character.isLetterOrDigit(this.dexd));
        String strDext = dext();
        if (strDext.equals("null")) {
            i = 8;
        } else if (strDext.equals("true")) {
            i = 6;
        } else if (strDext.equals(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            i = 7;
        } else if (strDext.equals("new")) {
            i = 9;
        } else if (strDext.equals("undefined")) {
            i = 23;
        } else if (strDext.equals("Set")) {
            i = 21;
        } else {
            i = strDext.equals("TreeSet") ? 22 : 18;
        }
        this.dexa = i;
    }

    public char dexa(int i) {
        if (i >= this.dexr) {
            return (char) 26;
        }
        return this.dexq.charAt(i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:46:0x009d A[Catch: NumberFormatException -> 0x0025, TryCatch #0 {NumberFormatException -> 0x0025, blocks: (B:8:0x0018, B:14:0x002c, B:17:0x003b, B:19:0x0040, B:28:0x0060, B:30:0x0068, B:34:0x0080, B:36:0x0084, B:38:0x008a, B:44:0x0099, B:46:0x009d, B:52:0x00ae, B:49:0x00a5, B:51:0x00ac, B:53:0x00b1, B:56:0x00b7, B:41:0x0092, B:58:0x00bc, B:31:0x0072, B:27:0x005e), top: B:62:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5 A[Catch: NumberFormatException -> 0x0025, TryCatch #0 {NumberFormatException -> 0x0025, blocks: (B:8:0x0018, B:14:0x002c, B:17:0x003b, B:19:0x0040, B:28:0x0060, B:30:0x0068, B:34:0x0080, B:36:0x0084, B:38:0x008a, B:44:0x0099, B:46:0x009d, B:52:0x00ae, B:49:0x00a5, B:51:0x00ac, B:53:0x00b1, B:56:0x00b7, B:41:0x0092, B:58:0x00bc, B:31:0x0072, B:27:0x005e), top: B:62:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac A[Catch: NumberFormatException -> 0x0025, TryCatch #0 {NumberFormatException -> 0x0025, blocks: (B:8:0x0018, B:14:0x002c, B:17:0x003b, B:19:0x0040, B:28:0x0060, B:30:0x0068, B:34:0x0080, B:36:0x0084, B:38:0x008a, B:44:0x0099, B:46:0x009d, B:52:0x00ae, B:49:0x00a5, B:51:0x00ac, B:53:0x00b1, B:56:0x00b7, B:41:0x0092, B:58:0x00bc, B:31:0x0072, B:27:0x005e), top: B:62:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ae A[SYNTHETIC] */
    public final Number dexa(boolean z) throws com.wangmai.insightvision.openadsdk.d.d {
        char[] cArr;
        int i;
        boolean z2;
        int i2;
        double d;
        char c;
        int i3 = (this.dexk + this.dexh) - 1;
        char cCharAt = i3 >= this.dexr ? (char) 26 : this.dexq.charAt(i3);
        try {
            if (cCharAt == 'F') {
                return Float.valueOf(Float.parseFloat(dexl()));
            }
            if (cCharAt == 'D') {
                return Double.valueOf(Double.parseDouble(dexl()));
            }
            if (z) {
                return dexc();
            }
            char cCharAt2 = this.dexq.charAt((this.dexk + this.dexh) - 1);
            int i4 = this.dexh;
            if (cCharAt2 == 'L' || cCharAt2 == 'S' || cCharAt2 == 'B' || cCharAt2 == 'F' || cCharAt2 == 'D') {
                i4--;
            }
            int i5 = this.dexk;
            char[] cArr2 = this.dexg;
            int i6 = 0;
            if (i4 < cArr2.length) {
                this.dexq.getChars(i5, i5 + i4, cArr2, 0);
                cArr = this.dexg;
            } else {
                char[] cArr3 = new char[i4];
                this.dexq.getChars(i5, i5 + i4, cArr3, 0);
                cArr = cArr3;
            }
            if (i4 > 9 || this.dexi) {
                return Double.valueOf(Double.parseDouble(new String(cArr, 0, i4)));
            }
            char c2 = cArr[0];
            if (c2 != '-') {
                if (c2 == '+') {
                    c2 = cArr[1];
                    z2 = false;
                } else {
                    i = 1;
                    z2 = false;
                }
                i2 = c2 - '0';
                while (i < i4) {
                    c = cArr[i];
                    if (c == '.') {
                        i6 = 1;
                    } else {
                        i2 = (i2 * 10) + (c - '0');
                        if (i6 != 0) {
                            i6 *= 10;
                        }
                    }
                    i++;
                }
                d = ((double) i2) / ((double) i6);
                if (z2) {
                    d = -d;
                }
                return Double.valueOf(d);
            }
            c2 = cArr[1];
            z2 = true;
            i = 2;
            i2 = c2 - '0';
            while (i < i4) {
                c = cArr[i];
                if (c == '.') {
                    i6 = 1;
                } else {
                    i2 = (i2 * 10) + (c - '0');
                    if (i6 != 0) {
                        i6 *= 10;
                    }
                }
                i++;
            }
            d = ((double) i2) / ((double) i6);
            if (z2) {
                d = -d;
            }
            return Double.valueOf(d);
        } catch (NumberFormatException e) {
            throw new com.wangmai.insightvision.openadsdk.d.d(e.getMessage() + ", " + dexd());
        }
    }

    public final String dexa(c cVar) {
        char c;
        while (true) {
            c = this.dexd;
            if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b') {
                break;
            }
            dexi();
        }
        if (c == '\"') {
            return dexa(cVar, '\"');
        }
        if (c == '\'') {
            return dexa(cVar, '\'');
        }
        if (c == '}') {
            dexi();
            this.dexa = 13;
            return null;
        }
        if (c == ',') {
            dexi();
            this.dexa = 16;
            return null;
        }
        if (c != 26) {
            return dexb(cVar);
        }
        this.dexa = 20;
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    public String dexa(c cVar, char c) throws com.wangmai.insightvision.openadsdk.d.d {
        String strDexa;
        int i = this.dexe + 1;
        int iIndexOf = this.dexq.indexOf(c, i);
        if (iIndexOf == -1) {
            throw new com.wangmai.insightvision.openadsdk.d.d("unclosed str, " + dexd());
        }
        int i2 = iIndexOf - i;
        char[] cArrDexa = dexa(this.dexe + 1, i2);
        boolean z = false;
        while (i2 > 0 && cArrDexa[i2 - 1] == '\\') {
            int i3 = 1;
            for (int i4 = i2 - 2; i4 >= 0 && cArrDexa[i4] == '\\'; i4--) {
                i3++;
            }
            if (i3 % 2 == 0) {
                break;
            }
            int iIndexOf2 = this.dexq.indexOf(c, iIndexOf + 1);
            int i5 = (iIndexOf2 - iIndexOf) + i2;
            if (i5 >= cArrDexa.length) {
                int length = (cArrDexa.length * 3) / 2;
                if (length < i5) {
                    length = i5;
                }
                char[] cArr = new char[length];
                System.arraycopy(cArrDexa, 0, cArr, 0, cArrDexa.length);
                cArrDexa = cArr;
            }
            this.dexq.getChars(iIndexOf, iIndexOf2, cArrDexa, i2);
            iIndexOf = iIndexOf2;
            i2 = i5;
            z = true;
        }
        if (z) {
            strDexa = dexa(cArrDexa, i2);
        } else {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                char c2 = cArrDexa[i7];
                i6 = (i6 * 31) + c2;
                if (c2 == '\\') {
                    z = true;
                }
            }
            if (z) {
                strDexa = dexa(cArrDexa, i2);
            } else {
                strDexa = i2 < 20 ? cVar.dexa(cArrDexa, 0, i2, i6) : new String(cArrDexa, 0, i2);
            }
        }
        int i8 = iIndexOf + 1;
        this.dexe = i8;
        this.dexd = i8 >= this.dexr ? (char) 26 : this.dexq.charAt(i8);
        return strDexa;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexa(char c) throws com.wangmai.insightvision.openadsdk.d.d {
        this.dexh = 0;
        while (true) {
            char c2 = this.dexd;
            if (c2 == c) {
                int i = this.dexe + 1;
                this.dexe = i;
                this.dexd = i >= this.dexr ? (char) 26 : this.dexq.charAt(i);
                dexk();
                return;
            }
            if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                throw new com.wangmai.insightvision.openadsdk.d.d("not match " + c + " - " + this.dexd);
            }
            dexi();
        }
    }

    public void dexa(char c, char c2, char c3) {
        int i = (((c2 - '0') * 10) + (c3 - '0')) * 3600 * 1000;
        if (c == '-') {
            i = -i;
        }
        if (this.dexo.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.dexo.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    public void dexa(char c, char c2, char c3, char c4, char c5, char c6) {
        this.dexo.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.dexo.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.dexo.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0064  */
    /* JADX WARN: Code duplicated, block: B:29:0x0067  */
    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0078  */
    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0091  */
    /* JADX WARN: Code duplicated, block: B:42:0x0094  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:95:0x00da A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x005d A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x00d3 -> B:63:0x00d4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:50:0x00b6
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public boolean dexa(long r18) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dex13.dexa(long):boolean");
    }

    public final boolean dexa(com.wangmai.insightvision.openadsdk.d.i.d dVar) {
        return (dVar.t & this.dexc) != 0;
    }

    /* JADX WARN: Failed to calculate best type for var: r0v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v10 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v10 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v31 int
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v31 int, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v3 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v4 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v5 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v9 int
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v9 int, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r26v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r26v1 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r28v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r28v0 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r29v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r29v0 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r29v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r29v1 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v10 int
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v10 int, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v6 int
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v6 int, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r35v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r35v0 'this'  ??, new type: cj.mobile.wm.dex13
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v31 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v31 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v32 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v11 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v2 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v3 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v13 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v3 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v4 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v9 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v3 ??, new type: char
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r35v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r35v0 'this'  ??, new type: cj.mobile.wm.dex13
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v10 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public boolean dexa(boolean r36, int r37) {
        /*
            Method dump skipped, instruction units count: 1610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dex13.dexa(boolean, int):boolean");
    }

    public byte[] dexa() {
        return dexa(this.dexq, this.dexk + 1, this.dexh);
    }

    public final char[] dexa(int i, int i2) {
        char[] cArr = this.dexg;
        if (i2 < cArr.length) {
            this.dexq.getChars(i, i2 + i, cArr, 0);
            return this.dexg;
        }
        char[] cArr2 = new char[i2];
        this.dexg = cArr2;
        this.dexq.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public String dexb(char c) throws com.wangmai.insightvision.openadsdk.d.d {
        String str;
        int i = this.dexe + 1;
        int iIndexOf = this.dexq.indexOf(c, i);
        if (iIndexOf == -1) {
            throw new com.wangmai.insightvision.openadsdk.d.d("unclosed str, " + dexd());
        }
        if (dexv) {
            str = this.dexq.substring(i, iIndexOf);
        } else {
            int i2 = iIndexOf - i;
            str = new String(dexa(this.dexe + 1, i2), 0, i2);
        }
        if (str.indexOf(92) != -1) {
            while (true) {
                int i3 = 0;
                for (int i4 = iIndexOf - 1; i4 >= 0 && this.dexq.charAt(i4) == '\\'; i4--) {
                    i3++;
                }
                if (i3 % 2 == 0) {
                    break;
                }
                iIndexOf = this.dexq.indexOf(c, iIndexOf + 1);
            }
            int i5 = iIndexOf - i;
            str = dexa(dexa(this.dexe + 1, i5), i5);
        }
        int i6 = iIndexOf + 1;
        this.dexe = i6;
        this.dexd = i6 >= this.dexr ? (char) 26 : this.dexq.charAt(i6);
        return str;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final String dexb(c cVar) throws com.wangmai.insightvision.openadsdk.d.d {
        int i = this.dexd;
        boolean[] zArr = dex01;
        if (!(i >= zArr.length || zArr[i])) {
            throw new com.wangmai.insightvision.openadsdk.d.d("illegal identifier : " + this.dexd + ", " + dexd());
        }
        this.dexk = this.dexe;
        this.dexh = 1;
        while (true) {
            char cDexi = dexi();
            boolean[] zArr2 = dex02;
            if (cDexi < zArr2.length && !zArr2[cDexi]) {
                break;
            }
            i = (i * 31) + cDexi;
            this.dexh++;
        }
        this.dexd = dexa(this.dexe);
        this.dexa = 18;
        if (this.dexh == 4 && this.dexq.startsWith("null", this.dexk)) {
            return null;
        }
        return cVar.dexa(this.dexq, this.dexk, this.dexh, i);
    }

    public void dexb() {
        char[] cArr = this.dexg;
        if (cArr.length <= 8196) {
            dexw.set(cArr);
        }
        this.dexg = null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:124:0x00a3 A[SYNTHETIC] */
    public final void dexb(int i) throws com.wangmai.insightvision.openadsdk.d.d {
        this.dexh = 0;
        while (true) {
            if (i == 2) {
                char c = this.dexd;
                if (c >= '0' && c <= '9') {
                    this.dexb = this.dexe;
                    dexo();
                    return;
                }
                if (c == '\"') {
                    this.dexb = this.dexe;
                    dexq();
                    return;
                } else if (c == '[') {
                    this.dexa = 14;
                    dexi();
                    return;
                } else if (c == '{') {
                    this.dexa = 12;
                    dexi();
                    return;
                }
            } else if (i == 4) {
                char c2 = this.dexd;
                if (c2 == '\"') {
                    this.dexb = this.dexe;
                    dexq();
                    return;
                } else if (c2 >= '0' && c2 <= '9') {
                    this.dexb = this.dexe;
                    dexo();
                    return;
                } else if (c2 == '{') {
                    this.dexa = 12;
                    int i2 = this.dexe + 1;
                    this.dexe = i2;
                    this.dexd = i2 < this.dexr ? this.dexq.charAt(i2) : (char) 26;
                    return;
                }
            } else if (i == 12) {
                char c3 = this.dexd;
                if (c3 == '{') {
                    this.dexa = 12;
                    int i3 = this.dexe + 1;
                    this.dexe = i3;
                    this.dexd = i3 < this.dexr ? this.dexq.charAt(i3) : (char) 26;
                    return;
                }
                if (c3 == '[') {
                    this.dexa = 14;
                    int i4 = this.dexe + 1;
                    this.dexe = i4;
                    this.dexd = i4 < this.dexr ? this.dexq.charAt(i4) : (char) 26;
                    return;
                }
            } else {
                if (i == 18) {
                    dexj();
                    return;
                }
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c4 = this.dexd;
                            if (c4 == '[') {
                                this.dexa = 14;
                                dexi();
                            } else if (c4 == '{') {
                                this.dexa = 12;
                                dexi();
                            }
                            break;
                        case 15:
                            if (this.dexd == ']') {
                                this.dexa = 15;
                                dexi();
                            }
                            if (this.dexd == 26) {
                                this.dexa = 20;
                            }
                            break;
                        case 16:
                            char c5 = this.dexd;
                            if (c5 == ',') {
                                this.dexa = 16;
                                int i5 = this.dexe + 1;
                                this.dexe = i5;
                                this.dexd = i5 < this.dexr ? this.dexq.charAt(i5) : (char) 26;
                            } else if (c5 == '}') {
                                this.dexa = 13;
                                int i6 = this.dexe + 1;
                                this.dexe = i6;
                                this.dexd = i6 < this.dexr ? this.dexq.charAt(i6) : (char) 26;
                            } else if (c5 == ']') {
                                this.dexa = 15;
                                int i7 = this.dexe + 1;
                                this.dexe = i7;
                                this.dexd = i7 < this.dexr ? this.dexq.charAt(i7) : (char) 26;
                            } else if (c5 == 26) {
                                this.dexa = 20;
                            }
                            break;
                    }
                    return;
                }
                if (this.dexd == 26) {
                    this.dexa = 20;
                    return;
                }
            }
            char c6 = this.dexd;
            if (c6 != ' ' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != '\f' && c6 != '\b') {
                dexk();
                return;
            }
            dexi();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:33:0x0098  */
    /* JADX WARN: Code duplicated, block: B:34:0x009a  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:68:0x0105  */
    /* JADX WARN: Code duplicated, block: B:70:0x0109  */
    /* JADX WARN: Code duplicated, block: B:73:0x0119 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x011b  */
    /* JADX WARN: Code duplicated, block: B:77:0x0129 A[PHI: r0
      0x0129: PHI (r0v14 int) = (r0v9 int), (r0v13 int), (r0v17 int) binds: [B:75:0x0126, B:71:0x0116, B:66:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:79:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0134  */
    /* JADX WARN: Code duplicated, block: B:83:0x0142  */
    /* JADX WARN: Code duplicated, block: B:85:0x0145  */
    /* JADX WARN: Code duplicated, block: B:90:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00ea A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00e5 -> B:60:0x00e6). Please report as a decompilation issue!!! */
    public boolean dexb(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        boolean z;
        int i2;
        int i3;
        char cCharAt;
        dex13 dex13Var;
        char cCharAt2;
        int i4;
        char cDexa;
        int i5;
        int i6;
        this.dexp = 0;
        int iDexo = dexo(j);
        if (iDexo == 0) {
            return false;
        }
        if (this.dexq.startsWith(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE, this.dexe + iDexo)) {
            i = iDexo + 5;
        } else {
            if (this.dexq.startsWith("true", this.dexe + iDexo)) {
                i = iDexo + 4;
            } else if (this.dexq.startsWith("\"false\"", this.dexe + iDexo)) {
                i = iDexo + 7;
            } else if (this.dexq.startsWith("\"true\"", this.dexe + iDexo)) {
                i = iDexo + 6;
            } else if (this.dexq.charAt(this.dexe + iDexo) == '1') {
                i = iDexo + 1;
            } else if (this.dexq.charAt(this.dexe + iDexo) == '0') {
                i = iDexo + 1;
            } else if (this.dexq.startsWith("\"1\"", this.dexe + iDexo)) {
                i = iDexo + 3;
            } else {
                if (!this.dexq.startsWith("\"0\"", this.dexe + iDexo)) {
                    this.dexp = -1;
                    return false;
                }
                i = iDexo + 3;
            }
            z = true;
            i2 = i + 1;
            i3 = this.dexe + i;
            cCharAt = 26;
            if (i3 < this.dexr) {
                dex13Var = this;
                cCharAt2 = dex13Var.dexq.charAt(i3);
                while (true) {
                    if (cCharAt2 == ',') {
                        int i7 = dex13Var.dexe + (i2 - 1) + 1;
                        dex13Var.dexe = i7;
                        dex13Var.dexd = i7 < dex13Var.dexr ? dex13Var.dexq.charAt(i7) : (char) 26;
                        dex13Var.dexp = 3;
                        dex13Var.dexa = 16;
                        return z;
                    }
                    if (cCharAt2 == '}' && (cCharAt2 == ' ' || cCharAt2 == '\n' || cCharAt2 == '\r' || cCharAt2 == '\t' || cCharAt2 == '\f' || cCharAt2 == '\b')) {
                        int i8 = i2 + 1;
                        i6 = dex13Var.dexe + i2;
                        if (i6 >= dex13Var.dexr) {
                            i2 = i8;
                            break;
                        }
                        i2 = i8;
                        cCharAt2 = dex13Var.dexq.charAt(i6);
                        if (cCharAt2 == ',') {
                            int i9 = dex13Var.dexe + (i2 - 1) + 1;
                            dex13Var.dexe = i9;
                            dex13Var.dexd = i9 < dex13Var.dexr ? dex13Var.dexq.charAt(i9) : (char) 26;
                            dex13Var.dexp = 3;
                            dex13Var.dexa = 16;
                            return z;
                        }
                        if (cCharAt2 == '}') {
                        }
                    }
                    if (cCharAt2 == '}') {
                        dex13Var.dexp = -1;
                        return false;
                    }
                    i4 = i2 + 1;
                    cDexa = dex13Var.dexa(dex13Var.dexe + i2);
                    if (cDexa == ',') {
                        dex13Var.dexa = 16;
                        i5 = dex13Var.dexe + (i4 - 1) + 1;
                        dex13Var.dexe = i5;
                        if (i5 < dex13Var.dexr) {
                            cCharAt = dex13Var.dexq.charAt(i5);
                        }
                    } else if (cDexa == ']') {
                        dex13Var.dexa = 15;
                        i5 = dex13Var.dexe + (i4 - 1) + 1;
                        dex13Var.dexe = i5;
                        if (i5 < dex13Var.dexr) {
                            cCharAt = dex13Var.dexq.charAt(i5);
                        }
                    } else if (cDexa == '}') {
                        dex13Var.dexa = 13;
                        i5 = dex13Var.dexe + (i4 - 1) + 1;
                        dex13Var.dexe = i5;
                        if (i5 < dex13Var.dexr) {
                            cCharAt = dex13Var.dexq.charAt(i5);
                        }
                    } else {
                        if (cDexa == 26) {
                            dex13Var.dexp = -1;
                            return false;
                        }
                        dex13Var.dexa = 20;
                        dex13Var.dexe += i4 - 1;
                    }
                    dex13Var.dexd = cCharAt;
                    dex13Var.dexp = 4;
                    return z;
                }
            }
            dex13Var = this;
            cCharAt2 = 26;
            while (true) {
                if (cCharAt2 == ',') {
                    int i10 = dex13Var.dexe + (i2 - 1) + 1;
                    dex13Var.dexe = i10;
                    dex13Var.dexd = i10 < dex13Var.dexr ? dex13Var.dexq.charAt(i10) : (char) 26;
                    dex13Var.dexp = 3;
                    dex13Var.dexa = 16;
                    return z;
                }
                if (cCharAt2 == '}') {
                }
                if (cCharAt2 == '}') {
                    dex13Var.dexp = -1;
                    return false;
                }
                i4 = i2 + 1;
                cDexa = dex13Var.dexa(dex13Var.dexe + i2);
                if (cDexa == ',') {
                    dex13Var.dexa = 16;
                    i5 = dex13Var.dexe + (i4 - 1) + 1;
                    dex13Var.dexe = i5;
                    if (i5 < dex13Var.dexr) {
                        cCharAt = dex13Var.dexq.charAt(i5);
                    }
                } else if (cDexa == ']') {
                    dex13Var.dexa = 15;
                    i5 = dex13Var.dexe + (i4 - 1) + 1;
                    dex13Var.dexe = i5;
                    if (i5 < dex13Var.dexr) {
                        cCharAt = dex13Var.dexq.charAt(i5);
                    }
                } else if (cDexa == '}') {
                    dex13Var.dexa = 13;
                    i5 = dex13Var.dexe + (i4 - 1) + 1;
                    dex13Var.dexe = i5;
                    if (i5 < dex13Var.dexr) {
                        cCharAt = dex13Var.dexq.charAt(i5);
                    }
                } else {
                    if (cDexa == 26) {
                        dex13Var.dexp = -1;
                        return false;
                    }
                    dex13Var.dexa = 20;
                    dex13Var.dexe += i4 - 1;
                }
                dex13Var.dexd = cCharAt;
                dex13Var.dexp = 4;
                return z;
                cCharAt2 = dex13Var.dexq.charAt(i6);
            }
        }
        z = false;
        i2 = i + 1;
        i3 = this.dexe + i;
        cCharAt = 26;
        if (i3 < this.dexr) {
            dex13Var = this;
        } else {
            dex13Var = this;
            cCharAt2 = dex13Var.dexq.charAt(i3);
            while (true) {
                if (cCharAt2 == ',') {
                    int i11 = dex13Var.dexe + (i2 - 1) + 1;
                    dex13Var.dexe = i11;
                    dex13Var.dexd = i11 < dex13Var.dexr ? dex13Var.dexq.charAt(i11) : (char) 26;
                    dex13Var.dexp = 3;
                    dex13Var.dexa = 16;
                    return z;
                }
                if (cCharAt2 == '}') {
                }
                if (cCharAt2 == '}') {
                    dex13Var.dexp = -1;
                    return false;
                }
                i4 = i2 + 1;
                cDexa = dex13Var.dexa(dex13Var.dexe + i2);
                if (cDexa == ',') {
                    dex13Var.dexa = 16;
                    i5 = dex13Var.dexe + (i4 - 1) + 1;
                    dex13Var.dexe = i5;
                    if (i5 < dex13Var.dexr) {
                        cCharAt = dex13Var.dexq.charAt(i5);
                    }
                } else if (cDexa == ']') {
                    dex13Var.dexa = 15;
                    i5 = dex13Var.dexe + (i4 - 1) + 1;
                    dex13Var.dexe = i5;
                    if (i5 < dex13Var.dexr) {
                        cCharAt = dex13Var.dexq.charAt(i5);
                    }
                } else if (cDexa == '}') {
                    dex13Var.dexa = 13;
                    i5 = dex13Var.dexe + (i4 - 1) + 1;
                    dex13Var.dexe = i5;
                    if (i5 < dex13Var.dexr) {
                        cCharAt = dex13Var.dexq.charAt(i5);
                    }
                } else {
                    if (cDexa == 26) {
                        dex13Var.dexp = -1;
                        return false;
                    }
                    dex13Var.dexa = 20;
                    dex13Var.dexe += i4 - 1;
                }
                dex13Var.dexd = cCharAt;
                dex13Var.dexp = 4;
                return z;
                cCharAt2 = dex13Var.dexq.charAt(i6);
            }
        }
        cCharAt2 = 26;
        while (true) {
            if (cCharAt2 == ',') {
                int i12 = dex13Var.dexe + (i2 - 1) + 1;
                dex13Var.dexe = i12;
                dex13Var.dexd = i12 < dex13Var.dexr ? dex13Var.dexq.charAt(i12) : (char) 26;
                dex13Var.dexp = 3;
                dex13Var.dexa = 16;
                return z;
            }
            if (cCharAt2 == '}') {
            }
            if (cCharAt2 == '}') {
                dex13Var.dexp = -1;
                return false;
            }
            i4 = i2 + 1;
            cDexa = dex13Var.dexa(dex13Var.dexe + i2);
            if (cDexa == ',') {
                dex13Var.dexa = 16;
                i5 = dex13Var.dexe + (i4 - 1) + 1;
                dex13Var.dexe = i5;
                if (i5 < dex13Var.dexr) {
                    cCharAt = dex13Var.dexq.charAt(i5);
                }
            } else if (cDexa == ']') {
                dex13Var.dexa = 15;
                i5 = dex13Var.dexe + (i4 - 1) + 1;
                dex13Var.dexe = i5;
                if (i5 < dex13Var.dexr) {
                    cCharAt = dex13Var.dexq.charAt(i5);
                }
            } else if (cDexa == '}') {
                dex13Var.dexa = 13;
                i5 = dex13Var.dexe + (i4 - 1) + 1;
                dex13Var.dexe = i5;
                if (i5 < dex13Var.dexr) {
                    cCharAt = dex13Var.dexq.charAt(i5);
                }
            } else {
                if (cDexa == 26) {
                    dex13Var.dexp = -1;
                    return false;
                }
                dex13Var.dexa = 20;
                dex13Var.dexe += i4 - 1;
            }
            dex13Var.dexd = cCharAt;
            dex13Var.dexp = 4;
            return z;
            cCharAt2 = dex13Var.dexq.charAt(i6);
        }
    }

    public boolean dexb(boolean z) {
        return dexa(z, this.dexr - this.dexe);
    }

    public final BigDecimal dexc() {
        char cCharAt = this.dexq.charAt((this.dexk + this.dexh) - 1);
        int i = this.dexh;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i--;
        }
        int i2 = this.dexk;
        char[] cArr = this.dexg;
        if (i < cArr.length) {
            this.dexq.getChars(i2, i2 + i, cArr, 0);
            return new BigDecimal(this.dexg, 0, i);
        }
        char[] cArr2 = new char[i];
        this.dexq.getChars(i2, i + i2, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:76:0x0127 A[PHI: r15
      0x0127: PHI (r15v13 int) = (r15v7 int), (r15v11 int), (r15v16 int) binds: [B:74:0x0124, B:70:0x0110, B:65:0x00fa] A[DONT_GENERATE, DONT_INLINE]] */
    public Date dexc(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        char cCharAt;
        char cCharAt2;
        int i2;
        Date date;
        int i3;
        this.dexp = 0;
        int iDexo = dexo(j);
        if (iDexo == 0) {
            return null;
        }
        int i4 = this.dexe;
        char c = this.dexd;
        int i5 = iDexo + 1;
        int i6 = iDexo + i4;
        char cCharAt3 = 26;
        char cCharAt4 = i6 >= this.dexr ? (char) 26 : this.dexq.charAt(i6);
        if (cCharAt4 == '\"') {
            int i7 = this.dexe + i5;
            int i8 = i5 + 1;
            if (i7 < this.dexr) {
                this.dexq.charAt(i7);
            }
            int iIndexOf = this.dexq.indexOf(34, this.dexe + i8);
            if (iIndexOf == -1) {
                throw new com.wangmai.insightvision.openadsdk.d.d("unclosed str");
            }
            int i9 = iIndexOf - i7;
            this.dexe = i7;
            if (dexa(false, i9)) {
                date = this.dexo.getTime();
                int i10 = i8 + i9;
                i2 = i10 + 1;
                cCharAt2 = dexa(i10 + i4);
                this.dexe = i4;
            } else {
                this.dexe = i4;
            }
            this.dexp = -1;
            return null;
        }
        if (cCharAt4 < '0' || cCharAt4 > '9') {
            this.dexp = -1;
            return null;
        }
        long j2 = cCharAt4 - '0';
        while (true) {
            i = i5 + 1;
            int i11 = this.dexe + i5;
            cCharAt = i11 >= this.dexr ? (char) 26 : this.dexq.charAt(i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j2 = (j2 * 10) + ((long) (cCharAt - '0'));
            i5 = i;
        }
        if (cCharAt == '.') {
            this.dexp = -1;
            return null;
        }
        if (cCharAt == '\"') {
            i2 = i + 1;
            int i12 = this.dexe + i;
            cCharAt2 = i12 >= this.dexr ? (char) 26 : this.dexq.charAt(i12);
        } else {
            cCharAt2 = cCharAt;
            i2 = i;
        }
        if (j2 < 0) {
            this.dexp = -1;
            return null;
        }
        date = new Date(j2);
        if (cCharAt2 == ',') {
            int i13 = this.dexe + (i2 - 1) + 1;
            this.dexe = i13;
            this.dexd = i13 < this.dexr ? this.dexq.charAt(i13) : (char) 26;
            this.dexp = 3;
            this.dexa = 16;
            return date;
        }
        if (cCharAt2 == '}') {
            int i14 = i2 + 1;
            char cDexa = dexa(this.dexe + i2);
            if (cDexa == ',') {
                this.dexa = 16;
                i3 = this.dexe + (i14 - 1) + 1;
                this.dexe = i3;
                if (i3 < this.dexr) {
                    cCharAt3 = this.dexq.charAt(i3);
                }
            } else if (cDexa == ']') {
                this.dexa = 15;
                i3 = this.dexe + (i14 - 1) + 1;
                this.dexe = i3;
                if (i3 < this.dexr) {
                    cCharAt3 = this.dexq.charAt(i3);
                }
            } else if (cDexa == '}') {
                this.dexa = 13;
                i3 = this.dexe + (i14 - 1) + 1;
                this.dexe = i3;
                if (i3 < this.dexr) {
                    cCharAt3 = this.dexq.charAt(i3);
                }
            } else if (cDexa == 26) {
                this.dexa = 20;
                this.dexe += i14 - 1;
            }
            this.dexd = cCharAt3;
            this.dexp = 4;
            return date;
        }
        this.dexe = i4;
        this.dexd = c;
        this.dexp = -1;
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final double dexd(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        char cDexa;
        int i2;
        int i3;
        dex13 dex13Var;
        double d;
        int i4;
        int i5;
        char cDexa2;
        this.dexp = 0;
        int iDexo = dexo(j);
        if (iDexo == 0) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int i6 = iDexo + 1;
        char cDexa3 = dexa(this.dexe + iDexo);
        int i7 = this.dexe + i6;
        int i8 = i7 - 1;
        boolean z = cDexa3 == '-';
        if (z) {
            i6++;
            cDexa3 = dexa(i7);
        }
        if (cDexa3 < '0' || cDexa3 > '9') {
            this.dexp = -1;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int i9 = cDexa3 - '0';
        while (true) {
            i = i6 + 1;
            cDexa = dexa(this.dexe + i6);
            if (cDexa < '0' || cDexa > '9') {
                break;
            }
            i9 = (i9 * 10) + (cDexa - '0');
            i6 = i;
        }
        if (cDexa == '.') {
            int i10 = i + 1;
            char cDexa4 = dexa(this.dexe + i);
            if (cDexa4 < '0' || cDexa4 > '9') {
                this.dexp = -1;
                return AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            i9 = (i9 * 10) + (cDexa4 - '0');
            int i11 = 10;
            while (true) {
                i5 = i10 + 1;
                cDexa2 = dexa(this.dexe + i10);
                if (cDexa2 < '0' || cDexa2 > '9') {
                    break;
                }
                i9 = (i9 * 10) + (cDexa2 - '0');
                i11 *= 10;
                i10 = i5;
            }
            i = i5;
            i2 = i11;
            cDexa = cDexa2;
        } else {
            i2 = 1;
        }
        boolean z2 = cDexa == 'e' || cDexa == 'E';
        if (z2) {
            int i12 = i + 1;
            cDexa = dexa(this.dexe + i);
            if (cDexa == '+' || cDexa == '-') {
                char cDexa5 = dexa(this.dexe + i12);
                i12++;
                dex13Var = this;
                cDexa = cDexa5;
                i3 = i8;
            } else {
                i3 = i8;
                dex13Var = this;
            }
            while (cDexa >= '0' && cDexa <= '9') {
                dex13 dex13Var2 = dex13Var;
                int i13 = i3;
                char cDexa6 = dex13Var2.dexa(dex13Var2.dexe + i12);
                i12++;
                dex13Var = dex13Var2;
                cDexa = cDexa6;
                i3 = i13;
            }
            i = i12;
        } else {
            i3 = i8;
            dex13Var = this;
        }
        int i14 = ((dex13Var.dexe + i) - i3) - 1;
        if (z2 || i14 >= 10) {
            d = Double.parseDouble(dex13Var.dexb(i3, i14));
        } else {
            d = ((double) i9) / ((double) i2);
            if (z) {
                d = -d;
            }
        }
        if (cDexa == ',') {
            dex13Var.dexe += i - 1;
            dex13Var.dexi();
            dex13Var.dexp = 3;
            dex13Var.dexa = 16;
            return d;
        }
        if (cDexa != '}') {
            dex13Var.dexp = -1;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int i15 = i + 1;
        char cDexa7 = dex13Var.dexa(dex13Var.dexe + i);
        if (cDexa7 == ',') {
            dex13Var.dexa = 16;
        } else {
            if (cDexa7 != ']') {
                if (cDexa7 == '}') {
                    i4 = 13;
                } else {
                    if (cDexa7 != 26) {
                        dex13Var.dexp = -1;
                        return AudioStats.AUDIO_AMPLITUDE_NONE;
                    }
                    dex13Var.dexe += i15 - 1;
                    dex13Var.dexa = 20;
                    dex13Var.dexd = (char) 26;
                }
                dex13Var.dexp = 4;
                return d;
            }
            i4 = 15;
            dex13Var.dexa = i4;
        }
        dex13Var.dexe += i15 - 1;
        dex13Var.dexi();
        dex13Var.dexp = 4;
        return d;
    }

    public String dexd() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.dexe);
        sb.append(", json : ");
        sb.append(this.dexr < 65536 ? this.dexq : this.dexq.substring(0, 65536));
        return sb.toString();
    }

    public final int dexe() {
        int i;
        boolean z;
        int i2 = this.dexk;
        int i3 = this.dexh + i2;
        int i4 = 0;
        if ((i2 >= this.dexr ? (char) 26 : this.dexq.charAt(i2)) == '-') {
            i2++;
            i = Integer.MIN_VALUE;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i2 < i3) {
            int i5 = i2 + 1;
            i4 = -((i2 >= this.dexr ? (char) 26 : this.dexq.charAt(i2)) - '0');
            i2 = i5;
        }
        while (i2 < i3) {
            int i6 = i2 + 1;
            char cCharAt = i2 >= this.dexr ? (char) 26 : this.dexq.charAt(i2);
            if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B') {
                i2 = i6;
                break;
            }
            int i7 = cCharAt - '0';
            if (i4 < -214748364) {
                throw new NumberFormatException(dexl());
            }
            int i8 = i4 * 10;
            if (i8 < i + i7) {
                throw new NumberFormatException(dexl());
            }
            i4 = i8 - i7;
            i2 = i6;
        }
        if (!z) {
            return -i4;
        }
        if (i2 > this.dexk + 1) {
            return i4;
        }
        throw new NumberFormatException(dexl());
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0109 A[LOOP:3: B:82:0x0112->B:81:0x0109, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0121 -> B:82:0x0112). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:82:0x0112
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final double[] dexe(long r19) {
        /*
            Method dump skipped, instruction units count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dex13.dexe(long):double[]");
    }

    public final Number dexf() {
        char c;
        boolean z;
        long j;
        long j2;
        int i = this.dexk;
        int i2 = this.dexh + i;
        int i3 = i2 - 1;
        char cCharAt = i3 >= this.dexr ? (char) 26 : this.dexq.charAt(i3);
        if (cCharAt == 'B') {
            i2--;
            c = 'B';
        } else if (cCharAt == 'L') {
            i2--;
            c = 'L';
        } else if (cCharAt != 'S') {
            c = ' ';
        } else {
            i2--;
            c = 'S';
        }
        int i4 = this.dexk;
        if ((i4 >= this.dexr ? (char) 26 : this.dexq.charAt(i4)) == '-') {
            i++;
            j = Long.MIN_VALUE;
            z = true;
        } else {
            z = false;
            j = -9223372036854775807L;
        }
        if (i < i2) {
            int i5 = i + 1;
            j2 = -((i >= this.dexr ? (char) 26 : this.dexq.charAt(i)) - '0');
            i = i5;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i6 = i + 1;
            int iCharAt = (i >= this.dexr ? (char) 26 : this.dexq.charAt(i)) - '0';
            if (j2 < com.airbnb.lottie.parser.moshi.a.b) {
                return new BigInteger(dexl());
            }
            long j3 = j2 * 10;
            long j4 = iCharAt;
            if (j3 < j + j4) {
                return new BigInteger(dexl());
            }
            j2 = j3 - j4;
            i = i6;
        }
        if (!z) {
            long j5 = -j2;
            if (j5 > 2147483647L || c == 'L') {
                return Long.valueOf(j5);
            }
            int i7 = (int) j5;
            if (c == 'S') {
                return Short.valueOf((short) i7);
            }
            return c == 'B' ? Byte.valueOf((byte) i7) : Integer.valueOf(i7);
        }
        if (i <= this.dexk + 1) {
            throw new NumberFormatException(dexl());
        }
        if (j2 < -2147483648L || c == 'L') {
            return Long.valueOf(j2);
        }
        if (c == 'S') {
            return Short.valueOf((short) j2);
        }
        int i8 = (int) j2;
        return c == 'B' ? Byte.valueOf((byte) i8) : Integer.valueOf(i8);
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0120 A[LOOP:4: B:85:0x0129->B:84:0x0120, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0138 -> B:85:0x0129). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:85:0x0129
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final double[][] dexf(long r21) {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dex13.dexf(long):double[][]");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final float dexg(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        char cDexa;
        int i2;
        int i3;
        dex13 dex13Var;
        float f;
        int i4;
        char cDexa2;
        this.dexp = 0;
        int iDexo = dexo(j);
        if (iDexo == 0) {
            return 0.0f;
        }
        int i5 = iDexo + 1;
        char cDexa3 = dexa(this.dexe + iDexo);
        int i6 = this.dexe + i5;
        int i7 = i6 - 1;
        boolean z = cDexa3 == '-';
        if (z) {
            i5++;
            cDexa3 = dexa(i6);
        }
        if (cDexa3 < '0' || cDexa3 > '9') {
            this.dexp = -1;
            return 0.0f;
        }
        int i8 = cDexa3 - '0';
        while (true) {
            i = i5 + 1;
            cDexa = dexa(this.dexe + i5);
            if (cDexa < '0' || cDexa > '9') {
                break;
            }
            i8 = (i8 * 10) + (cDexa - '0');
            i5 = i;
        }
        if (cDexa == '.') {
            int i9 = i + 1;
            char cDexa4 = dexa(this.dexe + i);
            if (cDexa4 < '0' || cDexa4 > '9') {
                this.dexp = -1;
                return 0.0f;
            }
            i8 = (i8 * 10) + (cDexa4 - '0');
            int i10 = 10;
            while (true) {
                i4 = i9 + 1;
                cDexa2 = dexa(this.dexe + i9);
                if (cDexa2 < '0' || cDexa2 > '9') {
                    break;
                }
                i8 = (i8 * 10) + (cDexa2 - '0');
                i10 *= 10;
                i9 = i4;
            }
            i = i4;
            i2 = i10;
            cDexa = cDexa2;
        } else {
            i2 = 1;
        }
        boolean z2 = cDexa == 'e' || cDexa == 'E';
        if (z2) {
            int i11 = i + 1;
            cDexa = dexa(this.dexe + i);
            if (cDexa == '+' || cDexa == '-') {
                char cDexa5 = dexa(this.dexe + i11);
                i11++;
                dex13Var = this;
                cDexa = cDexa5;
                i3 = i7;
            } else {
                i3 = i7;
                dex13Var = this;
            }
            while (cDexa >= '0' && cDexa <= '9') {
                dex13 dex13Var2 = dex13Var;
                int i12 = i3;
                char cDexa6 = dex13Var2.dexa(dex13Var2.dexe + i11);
                i11++;
                dex13Var = dex13Var2;
                cDexa = cDexa6;
                i3 = i12;
            }
            i = i11;
        } else {
            i3 = i7;
            dex13Var = this;
        }
        int i13 = ((dex13Var.dexe + i) - i3) - 1;
        if (z2 || i13 >= 10) {
            f = Float.parseFloat(dex13Var.dexb(i3, i13));
        } else {
            f = i8 / i2;
            if (z) {
                f = -f;
            }
        }
        int i14 = 16;
        if (cDexa == ',') {
            dex13Var.dexe += i - 1;
            dex13Var.dexi();
            dex13Var.dexp = 3;
            dex13Var.dexa = 16;
            return f;
        }
        if (cDexa != '}') {
            dex13Var.dexp = -1;
            return 0.0f;
        }
        int i15 = i + 1;
        char cDexa7 = dex13Var.dexa(dex13Var.dexe + i);
        if (cDexa7 != ',') {
            if (cDexa7 == ']') {
                i14 = 15;
            } else if (cDexa7 == '}') {
                i14 = 13;
            } else {
                if (cDexa7 != 26) {
                    dex13Var.dexp = -1;
                    return 0.0f;
                }
                dex13Var.dexe += i15 - 1;
                dex13Var.dexa = 20;
                dex13Var.dexd = (char) 26;
            }
            dex13Var.dexa = i14;
            dex13Var.dexe += i15 - 1;
            dex13Var.dexi();
        } else {
            dex13Var.dexa = i14;
            dex13Var.dexe += i15 - 1;
            dex13Var.dexi();
        }
        dex13Var.dexp = 4;
        return f;
    }

    public final boolean dexg() {
        int i = 0;
        while (true) {
            char cDexa = dexa(i);
            boolean z = true;
            if (cDexa == 26) {
                return true;
            }
            if (cDexa > ' ' || (cDexa != ' ' && cDexa != '\n' && cDexa != '\r' && cDexa != '\t' && cDexa != '\f' && cDexa != '\b')) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    /* JADX WARN: Code duplicated, block: B:33:0x0077  */
    /* JADX WARN: Code duplicated, block: B:35:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x007d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:8:0x0027). Please report as a decompilation issue!!! */
    public final long dexh() {
        boolean z;
        long j;
        long j2;
        int i;
        char cCharAt;
        int i2 = this.dexk;
        int i3 = this.dexh + i2;
        if (dexa(i2) == '-') {
            i2++;
            j = Long.MIN_VALUE;
            z = true;
        } else {
            z = false;
            j = -9223372036854775807L;
        }
        if (i2 >= i3) {
            j2 = 0;
            if (i2 < i3) {
                i = i2 + 1;
                if (i2 >= this.dexr) {
                    cCharAt = 26;
                } else {
                    cCharAt = this.dexq.charAt(i2);
                }
                if (cCharAt != 'L' || cCharAt == 'S' || cCharAt == 'B') {
                    i2 = i;
                } else {
                    int i4 = cCharAt - '0';
                    if (j2 < com.airbnb.lottie.parser.moshi.a.b) {
                        throw new NumberFormatException(dexl());
                    }
                    long j3 = j2 * 10;
                    long j4 = i4;
                    if (j3 < j + j4) {
                        throw new NumberFormatException(dexl());
                    }
                    j2 = j3 - j4;
                }
            }
            if (z) {
                return -j2;
            }
            if (i2 > this.dexk + 1) {
                return j2;
            }
            throw new NumberFormatException(dexl());
        }
        i = i2 + 1;
        j2 = -(dexa(i2) - '0');
        i2 = i;
        if (i2 < i3) {
            i = i2 + 1;
            if (i2 >= this.dexr) {
                cCharAt = 26;
            } else {
                cCharAt = this.dexq.charAt(i2);
            }
            if (cCharAt != 'L') {
            }
            i2 = i;
        }
        if (z) {
            return -j2;
        }
        if (i2 > this.dexk + 1) {
            return j2;
        }
        throw new NumberFormatException(dexl());
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0109 A[LOOP:3: B:82:0x0112->B:81:0x0109, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0121 -> B:82:0x0112). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:82:0x0112
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final float[] dexh(long r19) {
        /*
            Method dump skipped, instruction units count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dex13.dexh(long):float[]");
    }

    public char dexi() {
        int i = this.dexe + 1;
        this.dexe = i;
        char cCharAt = i >= this.dexr ? (char) 26 : this.dexq.charAt(i);
        this.dexd = cCharAt;
        return cCharAt;
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0120 A[LOOP:4: B:85:0x0129->B:84:0x0120, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0138 -> B:85:0x0129). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:85:0x0129
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final float[][] dexi(long r21) {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dex13.dexi(long):float[][]");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:98:0x0135 A[PHI: r13
      0x0135: PHI (r13v16 int) = (r13v10 int), (r13v14 int), (r13v19 int) binds: [B:96:0x0132, B:92:0x0122, B:87:0x010e] A[DONT_GENERATE, DONT_INLINE]] */
    public int dexj(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        char cCharAt;
        int i2;
        this.dexp = 0;
        int iDexo = dexo(j);
        if (iDexo == 0) {
            return 0;
        }
        int i3 = iDexo + 1;
        int i4 = this.dexe + iDexo;
        char cCharAt2 = 26;
        char cCharAt3 = i4 >= this.dexr ? (char) 26 : this.dexq.charAt(i4);
        boolean z = cCharAt3 == '\"';
        if (z) {
            int i5 = i3 + 1;
            int i6 = this.dexe + i3;
            cCharAt3 = i6 >= this.dexr ? (char) 26 : this.dexq.charAt(i6);
            i3 = i5;
            z = true;
        }
        boolean z2 = cCharAt3 == '-';
        if (z2) {
            int i7 = i3 + 1;
            int i8 = this.dexe + i3;
            cCharAt3 = i8 >= this.dexr ? (char) 26 : this.dexq.charAt(i8);
            i3 = i7;
        }
        if (cCharAt3 < '0' || cCharAt3 > '9') {
            this.dexp = -1;
            return 0;
        }
        int i9 = cCharAt3 - '0';
        while (true) {
            i = i3 + 1;
            int i10 = this.dexe + i3;
            cCharAt = i10 >= this.dexr ? (char) 26 : this.dexq.charAt(i10);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i9 = (i9 * 10) + (cCharAt - '0');
            i3 = i;
        }
        if (cCharAt == '.') {
            this.dexp = -1;
            return 0;
        }
        if (cCharAt == '\"') {
            if (!z) {
                this.dexp = -1;
                return 0;
            }
            int i11 = i + 1;
            int i12 = this.dexe + i;
            if (i12 >= this.dexr) {
                i = i11;
                cCharAt = 26;
            } else {
                i = i11;
                cCharAt = this.dexq.charAt(i12);
            }
        }
        if (i9 < 0) {
            this.dexp = -1;
            return 0;
        }
        while (cCharAt != ',') {
            if (cCharAt > ' ' || !(cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\f' || cCharAt == '\b')) {
                if (cCharAt != '}') {
                    this.dexp = -1;
                    return 0;
                }
                int i13 = i + 1;
                char cDexa = dexa(this.dexe + i);
                if (cDexa == ',') {
                    this.dexa = 16;
                    i2 = this.dexe + (i13 - 1) + 1;
                    this.dexe = i2;
                    if (i2 < this.dexr) {
                        cCharAt2 = this.dexq.charAt(i2);
                    }
                } else if (cDexa == ']') {
                    this.dexa = 15;
                    i2 = this.dexe + (i13 - 1) + 1;
                    this.dexe = i2;
                    if (i2 < this.dexr) {
                        cCharAt2 = this.dexq.charAt(i2);
                    }
                } else if (cDexa == '}') {
                    this.dexa = 13;
                    i2 = this.dexe + (i13 - 1) + 1;
                    this.dexe = i2;
                    if (i2 < this.dexr) {
                        cCharAt2 = this.dexq.charAt(i2);
                    }
                } else {
                    if (cDexa != 26) {
                        this.dexp = -1;
                        return 0;
                    }
                    this.dexa = 20;
                    this.dexe += i13 - 1;
                }
                this.dexd = cCharAt2;
                this.dexp = 4;
                return z2 ? -i9 : i9;
            }
            i++;
            int i14 = this.dexe + i;
            cCharAt = i14 >= this.dexr ? (char) 26 : this.dexq.charAt(i14);
        }
        int i15 = this.dexe + (i - 1) + 1;
        this.dexe = i15;
        this.dexd = i15 < this.dexr ? this.dexq.charAt(i15) : (char) 26;
        this.dexp = 3;
        this.dexa = 16;
        return z2 ? -i9 : i9;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexj() throws com.wangmai.insightvision.openadsdk.d.d {
        char c;
        while (true) {
            c = this.dexd;
            if (!(c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b'))) {
                break;
            } else {
                dexi();
            }
        }
        if (c == '_' || Character.isLetter(c)) {
            dexv();
        } else {
            dexk();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexk() throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        this.dexh = 0;
        while (true) {
            int i2 = this.dexe;
            this.dexb = i2;
            char c = this.dexd;
            if (c == '/') {
                dexr();
            } else {
                if (c == '\"') {
                    dexq();
                    return;
                }
                if ((c >= '0' && c <= '9') || c == '-') {
                    dexo();
                    return;
                }
                if (c == ',') {
                    dexi();
                    this.dexa = 16;
                    return;
                }
                if (c != '\f' && c != '\r' && c != ' ') {
                    if (c == ':') {
                        dexi();
                        this.dexa = 17;
                        return;
                    }
                    if (c == '[') {
                        int i3 = i2 + 1;
                        this.dexe = i3;
                        this.dexd = i3 < this.dexr ? this.dexq.charAt(i3) : (char) 26;
                        this.dexa = 14;
                        return;
                    }
                    if (c == ']') {
                        dexi();
                        this.dexa = 15;
                        return;
                    }
                    if (c == 'f') {
                        if (this.dexq.startsWith(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE, i2)) {
                            int i4 = this.dexe + 5;
                            this.dexe = i4;
                            char cDexa = dexa(i4);
                            this.dexd = cDexa;
                            if (cDexa == ' ' || cDexa == ',' || cDexa == '}' || cDexa == ']' || cDexa == '\n' || cDexa == '\r' || cDexa == '\t' || cDexa == 26 || cDexa == '\f' || cDexa == '\b' || cDexa == ':') {
                                this.dexa = 7;
                                return;
                            }
                        }
                        throw new com.wangmai.insightvision.openadsdk.d.d("scan false error");
                    }
                    if (c == 'n') {
                        if (this.dexq.startsWith("null", i2)) {
                            this.dexe += 4;
                            i = 8;
                        } else if (this.dexq.startsWith("new", this.dexe)) {
                            this.dexe += 3;
                            i = 9;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            char cDexa2 = dexa(this.dexe);
                            this.dexd = cDexa2;
                            if (cDexa2 == ' ' || cDexa2 == ',' || cDexa2 == '}' || cDexa2 == ']' || cDexa2 == '\n' || cDexa2 == '\r' || cDexa2 == '\t' || cDexa2 == 26 || cDexa2 == '\f' || cDexa2 == '\b') {
                                this.dexa = i;
                                return;
                            }
                        }
                        throw new com.wangmai.insightvision.openadsdk.d.d("scan null/new error");
                    }
                    if (c == '{') {
                        int i5 = i2 + 1;
                        this.dexe = i5;
                        this.dexd = i5 < this.dexr ? this.dexq.charAt(i5) : (char) 26;
                        this.dexa = 12;
                        return;
                    }
                    if (c == '}') {
                        int i6 = i2 + 1;
                        this.dexe = i6;
                        this.dexd = i6 < this.dexr ? this.dexq.charAt(i6) : (char) 26;
                        this.dexa = 13;
                        return;
                    }
                    if (c != 'S' && c != 'T') {
                        if (c == 't') {
                            if (this.dexq.startsWith("true", i2)) {
                                int i7 = this.dexe + 4;
                                this.dexe = i7;
                                char cDexa3 = dexa(i7);
                                this.dexd = cDexa3;
                                if (cDexa3 == ' ' || cDexa3 == ',' || cDexa3 == '}' || cDexa3 == ']' || cDexa3 == '\n' || cDexa3 == '\r' || cDexa3 == '\t' || cDexa3 == 26 || cDexa3 == '\f' || cDexa3 == '\b' || cDexa3 == ':') {
                                    this.dexa = 6;
                                    return;
                                }
                            }
                            throw new com.wangmai.insightvision.openadsdk.d.d("scan true error");
                        }
                        if (c != 'u') {
                            switch (c) {
                                default:
                                    switch (c) {
                                        case '\'':
                                            dexq();
                                            return;
                                        case '(':
                                            dexi();
                                            this.dexa = 10;
                                            return;
                                        case ')':
                                            dexi();
                                            this.dexa = 11;
                                            return;
                                        default:
                                            int i8 = this.dexr;
                                            if (i2 == i8 || (c == 26 && i2 + 1 == i8)) {
                                                if (this.dexa == 20) {
                                                    throw new com.wangmai.insightvision.openadsdk.d.d("EOF error");
                                                }
                                                this.dexa = 20;
                                                int i9 = this.dexf;
                                                this.dexe = i9;
                                                this.dexb = i9;
                                                return;
                                            }
                                            if (c > 31 && c != 127) {
                                                this.dexa = 1;
                                                dexi();
                                                return;
                                            }
                                            break;
                                    }
                                case '\b':
                                case '\t':
                                case '\n':
                                    dexi();
                                    break;
                            }
                        }
                    }
                    dexv();
                    return;
                }
                dexi();
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final int[] dexk(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        boolean z;
        int[] iArr;
        int i;
        char cCharAt;
        int i2;
        int i3;
        char cCharAt2;
        int[] iArr2;
        byte b;
        int i4;
        this.dexp = 0;
        int iDexo = dexo(j);
        int[] iArr3 = null;
        if (iDexo == 0) {
            return null;
        }
        int i5 = iDexo + 1;
        int i6 = this.dexe + iDexo;
        byte b2 = -1;
        if ((i6 >= this.dexr ? (char) 26 : this.dexq.charAt(i6)) != '[') {
            this.dexp = -1;
            return null;
        }
        int i7 = i5 + 1;
        int i8 = this.dexe + i5;
        char cCharAt3 = i8 >= this.dexr ? (char) 26 : this.dexq.charAt(i8);
        int[] iArr4 = new int[16];
        if (cCharAt3 != ']') {
            int i9 = 0;
            while (true) {
                if (cCharAt3 == '-') {
                    int i10 = i7 + 1;
                    int i11 = this.dexe + i7;
                    cCharAt3 = i11 >= this.dexr ? (char) 26 : this.dexq.charAt(i11);
                    i7 = i10;
                    z = true;
                } else {
                    z = false;
                }
                if (cCharAt3 < '0') {
                    iArr = iArr3;
                } else if (cCharAt3 <= '9') {
                    int i12 = cCharAt3 - '0';
                    while (true) {
                        i = i7 + 1;
                        int i13 = this.dexe + i7;
                        cCharAt = i13 >= this.dexr ? (char) 26 : this.dexq.charAt(i13);
                        if (cCharAt < '0' || cCharAt > '9') {
                            break;
                        }
                        i12 = (i12 * 10) + (cCharAt - '0');
                        i7 = i;
                    }
                    if (i9 >= iArr4.length) {
                        int[] iArr5 = new int[(iArr4.length * 3) / 2];
                        System.arraycopy(iArr4, 0, iArr5, 0, i9);
                        iArr4 = iArr5;
                    }
                    i2 = i9 + 1;
                    if (z) {
                        i12 = -i12;
                    }
                    iArr4[i9] = i12;
                    if (cCharAt != ',') {
                        if (cCharAt == ']') {
                            i3 = i + 1;
                            int i14 = this.dexe + i;
                            if (i14 < this.dexr) {
                                cCharAt2 = this.dexq.charAt(i14);
                                break;
                            }
                            cCharAt2 = 26;
                            break;
                        }
                    } else {
                        int i15 = i + 1;
                        int i16 = this.dexe + i;
                        if (i16 >= this.dexr) {
                            i = i15;
                            cCharAt = 26;
                        } else {
                            i = i15;
                            iArr2 = null;
                            cCharAt = this.dexq.charAt(i16);
                            b = -1;
                        }
                        i9 = i2;
                        iArr3 = iArr2;
                        b2 = b;
                        cCharAt3 = cCharAt;
                        i7 = i;
                    }
                    b = -1;
                    iArr2 = null;
                    i9 = i2;
                    iArr3 = iArr2;
                    b2 = b;
                    cCharAt3 = cCharAt;
                    i7 = i;
                } else {
                    iArr = null;
                }
                this.dexp = b2;
                return iArr;
            }
        }
        i3 = i7 + 1;
        int i17 = this.dexe + i7;
        cCharAt2 = i17 >= this.dexr ? (char) 26 : this.dexq.charAt(i17);
        i2 = 0;
        if (i2 != iArr4.length) {
            int[] iArr6 = new int[i2];
            System.arraycopy(iArr4, 0, iArr6, 0, i2);
            iArr4 = iArr6;
        }
        if (cCharAt2 == ',') {
            this.dexe += i3 - 1;
            dexi();
            this.dexp = 3;
            this.dexa = 16;
            return iArr4;
        }
        if (cCharAt2 != '}') {
            this.dexp = -1;
            return null;
        }
        int i18 = i3 + 1;
        char cDexa = dexa(this.dexe + i3);
        if (cDexa == ',') {
            this.dexa = 16;
        } else {
            if (cDexa != ']') {
                if (cDexa == '}') {
                    i4 = 13;
                } else {
                    if (cDexa != 26) {
                        this.dexp = -1;
                        return null;
                    }
                    this.dexe += i18 - 1;
                    this.dexa = 20;
                    this.dexd = (char) 26;
                }
                this.dexp = 4;
                return iArr4;
            }
            i4 = 15;
            this.dexa = i4;
        }
        this.dexe += i18 - 1;
        dexi();
        this.dexp = 4;
        return iArr4;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:79:0x0116  */
    /* JADX WARN: Code duplicated, block: B:80:0x0119 A[PHI: r2
      0x0119: PHI (r2v28 int) = (r2v22 int), (r2v26 int), (r2v31 int) binds: [B:78:0x0114, B:74:0x0102, B:69:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    public long dexl(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        char cCharAt;
        int i2;
        char cCharAt2;
        this.dexp = 0;
        int iDexo = dexo(j);
        if (iDexo == 0) {
            return 0L;
        }
        int i3 = iDexo + 1;
        int i4 = this.dexe + iDexo;
        char cCharAt3 = i4 >= this.dexr ? (char) 26 : this.dexq.charAt(i4);
        boolean z = cCharAt3 == '\"';
        if (z) {
            int i5 = i3 + 1;
            int i6 = this.dexe + i3;
            if (i6 >= this.dexr) {
                i3 = i5;
                cCharAt3 = 26;
            } else {
                cCharAt3 = this.dexq.charAt(i6);
                i3 = i5;
            }
        }
        boolean z2 = cCharAt3 == '-';
        if (z2) {
            int i7 = i3 + 1;
            int i8 = this.dexe + i3;
            if (i8 >= this.dexr) {
                i3 = i7;
                cCharAt3 = 26;
            } else {
                cCharAt3 = this.dexq.charAt(i8);
                i3 = i7;
            }
        }
        if (cCharAt3 < '0' || cCharAt3 > '9') {
            this.dexp = -1;
            return 0L;
        }
        long j2 = cCharAt3 - '0';
        while (true) {
            i = i3 + 1;
            int i9 = this.dexe + i3;
            cCharAt = i9 >= this.dexr ? (char) 26 : this.dexq.charAt(i9);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j2 = (j2 * 10) + ((long) (cCharAt - '0'));
            i3 = i;
        }
        if (cCharAt == '.') {
            this.dexp = -1;
            return 0L;
        }
        if (cCharAt == '\"') {
            if (!z) {
                this.dexp = -1;
                return 0L;
            }
            int i10 = i + 1;
            int i11 = this.dexe + i;
            if (i11 >= this.dexr) {
                i = i10;
                cCharAt = 26;
            } else {
                cCharAt = this.dexq.charAt(i11);
                i = i10;
            }
        }
        if (j2 < 0) {
            this.dexp = -1;
            return 0L;
        }
        if (cCharAt == ',') {
            int i12 = this.dexe + (i - 1) + 1;
            this.dexe = i12;
            this.dexd = i12 >= this.dexr ? (char) 26 : this.dexq.charAt(i12);
            this.dexp = 3;
            this.dexa = 16;
            return z2 ? -j2 : j2;
        }
        if (cCharAt != '}') {
            this.dexp = -1;
            return 0L;
        }
        int i13 = i + 1;
        char cDexa = dexa(this.dexe + i);
        if (cDexa == ',') {
            this.dexa = 16;
            i2 = this.dexe + (i13 - 1) + 1;
            this.dexe = i2;
            if (i2 >= this.dexr) {
                cCharAt2 = 26;
            } else {
                cCharAt2 = this.dexq.charAt(i2);
            }
            this.dexd = cCharAt2;
        } else if (cDexa == ']') {
            this.dexa = 15;
            i2 = this.dexe + (i13 - 1) + 1;
            this.dexe = i2;
            if (i2 >= this.dexr) {
                cCharAt2 = 26;
            } else {
                cCharAt2 = this.dexq.charAt(i2);
            }
            this.dexd = cCharAt2;
        } else if (cDexa == '}') {
            this.dexa = 13;
            i2 = this.dexe + (i13 - 1) + 1;
            this.dexe = i2;
            if (i2 >= this.dexr) {
                cCharAt2 = 26;
            } else {
                cCharAt2 = this.dexq.charAt(i2);
            }
            this.dexd = cCharAt2;
        } else {
            if (cDexa != 26) {
                this.dexp = -1;
                return 0L;
            }
            this.dexa = 20;
            this.dexe += i13 - 1;
            this.dexd = (char) 26;
        }
        this.dexp = 4;
        return z2 ? -j2 : j2;
    }

    public final String dexl() {
        char cCharAt = this.dexq.charAt((this.dexk + this.dexh) - 1);
        int i = this.dexh;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i--;
        }
        return dexb(this.dexk, i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:30:0x0078  */
    public String dexm(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        String str;
        int i;
        this.dexp = 0;
        int iDexo = dexo(j);
        if (iDexo == 0) {
            return null;
        }
        int i2 = iDexo + 1;
        int i3 = this.dexe + iDexo;
        if (i3 >= this.dexr) {
            throw new com.wangmai.insightvision.openadsdk.d.d("unclosed str, " + dexd());
        }
        if (this.dexq.charAt(i3) == '\"') {
            int i4 = this.dexe + i2;
            int iIndexOf = this.dexq.indexOf(34, i4);
            if (iIndexOf == -1) {
                throw new com.wangmai.insightvision.openadsdk.d.d("unclosed str, " + dexd());
            }
            if (dexv) {
                str = this.dexq.substring(i4, iIndexOf);
            } else {
                int i5 = iIndexOf - i4;
                str = new String(dexa(this.dexe + i2, i5), 0, i5);
            }
            if (str.indexOf(92) != -1) {
                boolean z = false;
                while (true) {
                    int i6 = iIndexOf - 1;
                    int i7 = 0;
                    while (i6 >= 0 && this.dexq.charAt(i6) == '\\') {
                        i7++;
                        i6--;
                        z = true;
                    }
                    if (i7 % 2 == 0) {
                        break;
                    }
                    iIndexOf = this.dexq.indexOf(34, iIndexOf + 1);
                }
                int i8 = iIndexOf - i4;
                char[] cArrDexa = dexa(this.dexe + i2, i8);
                if (z) {
                    str = dexa(cArrDexa, i8);
                } else {
                    str = new String(cArrDexa, 0, i8);
                    if (str.indexOf(92) != -1) {
                        str = dexa(cArrDexa, i8);
                    }
                }
            }
            int i9 = iIndexOf + 1;
            char cCharAt = i9 >= this.dexr ? (char) 26 : this.dexq.charAt(i9);
            if (cCharAt == ',') {
                int i10 = i9 + 1;
                this.dexe = i10;
                this.dexd = i10 < this.dexr ? this.dexq.charAt(i10) : (char) 26;
                this.dexp = 3;
                this.dexa = 16;
                return str;
            }
            if (cCharAt == '}') {
                int i11 = i9 + 1;
                char cCharAt2 = i11 >= this.dexr ? (char) 26 : this.dexq.charAt(i11);
                if (cCharAt2 == ',') {
                    this.dexa = 16;
                } else {
                    if (cCharAt2 != ']') {
                        if (cCharAt2 == '}') {
                            i = 13;
                        } else if (cCharAt2 == 26) {
                            this.dexa = 20;
                            this.dexe = i11;
                            this.dexd = (char) 26;
                        }
                        this.dexp = 4;
                        return str;
                    }
                    i = 15;
                    this.dexa = i;
                }
                this.dexe = i11;
                dexi();
                this.dexp = 4;
                return str;
            }
        }
        this.dexp = -1;
        return this.dexs;
    }

    public boolean dexm() {
        int i;
        boolean z = false;
        if (this.dexq.startsWith(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE, this.dexe)) {
            i = 5;
        } else if (this.dexq.startsWith("true", this.dexe)) {
            i = 4;
            z = true;
        } else {
            char c = this.dexd;
            if (c == '1') {
                i = 1;
                z = true;
            } else {
                if (c != '0') {
                    this.dexp = -1;
                    return false;
                }
                i = 1;
            }
        }
        int i2 = this.dexe + i;
        this.dexe = i2;
        this.dexd = dexa(i2);
        return z;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final long dexn() throws com.wangmai.insightvision.openadsdk.d.d {
        long j;
        boolean z = false;
        this.dexk = 0;
        if (this.dexd == '-') {
            this.dexk = 1;
            int i = this.dexe + 1;
            this.dexe = i;
            if (i >= this.dexr) {
                throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, " + dexd());
            }
            this.dexd = this.dexq.charAt(i);
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j2 = 0;
        while (true) {
            char c = this.dexd;
            if (c < '0' || c > '9') {
                break;
            }
            int i2 = c - '0';
            if (j2 < com.airbnb.lottie.parser.moshi.a.b) {
                throw new com.wangmai.insightvision.openadsdk.d.d("error long value, " + j2 + ", " + dexd());
            }
            long j3 = j2 * 10;
            long j4 = i2;
            if (j3 < j + j4) {
                throw new com.wangmai.insightvision.openadsdk.d.d("error long value, " + j3 + ", " + dexd());
            }
            j2 = j3 - j4;
            this.dexk++;
            int i3 = this.dexe + 1;
            this.dexe = i3;
            this.dexd = i3 >= this.dexr ? (char) 26 : this.dexq.charAt(i3);
        }
        return !z ? -j2 : j2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public long dexn(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        int i2;
        this.dexp = 0;
        int iDexo = dexo(j);
        if (iDexo == 0) {
            return 0L;
        }
        int i3 = iDexo + 1;
        int i4 = this.dexe + iDexo;
        if ((i4 >= this.dexr ? (char) 26 : this.dexq.charAt(i4)) != '\"') {
            this.dexp = -1;
            return 0L;
        }
        long j2 = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i5 = i3 + 1;
            int i6 = this.dexe + i3;
            char cCharAt = i6 >= this.dexr ? (char) 26 : this.dexq.charAt(i6);
            if (cCharAt == '\"') {
                int i7 = i5 + 1;
                int i8 = this.dexe + i5;
                char cCharAt2 = i8 >= this.dexr ? (char) 26 : this.dexq.charAt(i8);
                if (cCharAt2 == ',') {
                    int i9 = this.dexe + (i7 - 1) + 1;
                    this.dexe = i9;
                    this.dexd = i9 < this.dexr ? this.dexq.charAt(i9) : (char) 26;
                    i2 = 3;
                } else {
                    if (cCharAt2 != '}') {
                        this.dexp = -1;
                        return 0L;
                    }
                    int i10 = i7 + 1;
                    int i11 = this.dexe + i7;
                    char cCharAt3 = i11 >= this.dexr ? (char) 26 : this.dexq.charAt(i11);
                    if (cCharAt3 == ',') {
                        i = 16;
                    } else if (cCharAt3 == ']') {
                        i = 15;
                    } else {
                        if (cCharAt3 == '}') {
                            i = 13;
                        } else {
                            if (cCharAt3 != 26) {
                                this.dexp = -1;
                                return 0L;
                            }
                            this.dexa = 20;
                            this.dexe += i10 - 1;
                            this.dexd = (char) 26;
                        }
                        i2 = 4;
                    }
                    this.dexa = i;
                    this.dexe += i10 - 1;
                    dexi();
                    i2 = 4;
                }
                this.dexp = i2;
                return j2;
            }
            j2 = (j2 ^ ((long) cCharAt)) * TypeUtils.fnv1a_64_magic_prime;
            if (cCharAt == '\\') {
                this.dexp = -1;
                return 0L;
            }
            i3 = i5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0069 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:35:0x008b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0094  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:61:0x00e5 A[PHI: r1
      0x00e5: PHI (r1v23 int) = (r1v20 int), (r1v31 int) binds: [B:59:0x00e2, B:67:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:0x00f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:68:0x0101  */
    /* JADX WARN: Code duplicated, block: B:70:0x0105 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:71:0x0107  */
    /* JADX WARN: Code duplicated, block: B:76:0x0117  */
    /* JADX WARN: Code duplicated, block: B:77:0x0119  */
    /* JADX WARN: Code duplicated, block: B:82:0x0084 A[ADDED_TO_REGION, EDGE_INSN: B:82:0x0084->B:32:0x0084 BREAK  A[LOOP:0: B:24:0x0065->B:31:0x0081], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00eb, code lost:
    
        r1 = 26;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0038 -> B:14:0x003a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x00ff -> B:61:0x00e5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void dexo() {
        dex13 dex13Var;
        char c;
        char c2;
        int i;
        int i2;
        char cCharAt;
        int i3;
        char cCharAt2;
        char c3;
        int i4;
        char cCharAt3;
        char c4;
        char cCharAt4;
        int i5 = this.dexe;
        this.dexk = i5;
        this.dexi = false;
        if (this.dexd != '-') {
            dex13Var = this;
            c = dex13Var.dexd;
            if (c < '0') {
            }
            dex13Var.dexj = false;
            if (c == '.') {
                dex13Var.dexh++;
                i4 = dex13Var.dexe + 1;
                dex13Var.dexe = i4;
                if (i4 >= dex13Var.dexr) {
                    cCharAt3 = 26;
                } else {
                    cCharAt3 = dex13Var.dexq.charAt(i4);
                }
                dex13Var.dexd = cCharAt3;
                dex13Var.dexj = true;
                while (true) {
                    c4 = dex13Var.dexd;
                    if (c4 < '0') {
                        break;
                        break;
                    } else {
                        break;
                        break;
                    }
                    dex13Var.dexd = i >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i);
                }
            }
            c2 = dex13Var.dexd;
            if (c2 != 'L') {
                dex13Var.dexh++;
                dex13Var.dexi();
            } else if (c2 != 'F') {
                dex13Var.dexh++;
                dex13Var.dexi();
                dex13Var.dexj = true;
            } else {
                if (c2 != 'e') {
                }
                dex13Var.dexh++;
                i2 = dex13Var.dexe + 1;
                dex13Var.dexe = i2;
                if (i2 >= dex13Var.dexr) {
                    cCharAt = 26;
                } else {
                    cCharAt = dex13Var.dexq.charAt(i2);
                }
                dex13Var.dexd = cCharAt;
                if (cCharAt != '+') {
                }
                dex13Var.dexh++;
                i3 = dex13Var.dexe + 1;
                dex13Var.dexe = i3;
                if (i3 >= dex13Var.dexr) {
                    cCharAt2 = 26;
                } else {
                    cCharAt2 = dex13Var.dexq.charAt(i3);
                }
                dex13Var.dexd = cCharAt2;
                c3 = dex13Var.dexd;
                if (c3 >= '0') {
                }
                if (c3 != 'D') {
                    dex13Var.dexh++;
                    dex13Var.dexi();
                } else {
                    dex13Var.dexh++;
                    dex13Var.dexi();
                }
                dex13Var.dexi = true;
                dex13Var.dexj = true;
            }
            if (dex13Var.dexj) {
                i = 3;
            } else {
                i = 2;
            }
            dex13Var.dexa = i;
        }
        this.dexh++;
        int i6 = i5 + 1;
        this.dexe = i6;
        if (i6 < this.dexr) {
            dex13Var = this;
            cCharAt4 = dex13Var.dexq.charAt(i6);
            dex13Var.dexd = cCharAt4;
            c = dex13Var.dexd;
            if (c < '0' && c <= '9') {
                dex13Var.dexh++;
                int i7 = dex13Var.dexe + 1;
                dex13Var.dexe = i7;
                if (i7 < dex13Var.dexr) {
                    cCharAt4 = dex13Var.dexq.charAt(i7);
                }
                dex13Var.dexd = cCharAt4;
                c = dex13Var.dexd;
                if (c < '0') {
                }
                dex13Var.dexj = false;
                if (c == '.') {
                    dex13Var.dexh++;
                    i4 = dex13Var.dexe + 1;
                    dex13Var.dexe = i4;
                    if (i4 >= dex13Var.dexr) {
                        cCharAt3 = 26;
                    } else {
                        cCharAt3 = dex13Var.dexq.charAt(i4);
                    }
                    dex13Var.dexd = cCharAt3;
                    dex13Var.dexj = true;
                    while (true) {
                        c4 = dex13Var.dexd;
                        if (c4 < '0') {
                            break;
                        }
                        break;
                        break;
                        dex13Var.dexd = i >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i);
                    }
                }
                c2 = dex13Var.dexd;
                if (c2 != 'L') {
                    dex13Var.dexh++;
                    dex13Var.dexi();
                } else if (c2 != 'F') {
                    dex13Var.dexh++;
                    dex13Var.dexi();
                    dex13Var.dexj = true;
                } else {
                    if (c2 != 'e') {
                    }
                    dex13Var.dexh++;
                    i2 = dex13Var.dexe + 1;
                    dex13Var.dexe = i2;
                    if (i2 >= dex13Var.dexr) {
                        cCharAt = 26;
                    } else {
                        cCharAt = dex13Var.dexq.charAt(i2);
                    }
                    dex13Var.dexd = cCharAt;
                    if (cCharAt != '+') {
                    }
                    dex13Var.dexh++;
                    i3 = dex13Var.dexe + 1;
                    dex13Var.dexe = i3;
                    if (i3 >= dex13Var.dexr) {
                        cCharAt2 = 26;
                    } else {
                        cCharAt2 = dex13Var.dexq.charAt(i3);
                    }
                    dex13Var.dexd = cCharAt2;
                    c3 = dex13Var.dexd;
                    if (c3 >= '0') {
                    }
                    if (c3 != 'D') {
                        dex13Var.dexh++;
                        dex13Var.dexi();
                    } else {
                        dex13Var.dexh++;
                        dex13Var.dexi();
                    }
                    dex13Var.dexi = true;
                    dex13Var.dexj = true;
                }
                if (dex13Var.dexj) {
                    i = 3;
                } else {
                    i = 2;
                }
                dex13Var.dexa = i;
            }
            dex13Var.dexj = false;
            if (c == '.') {
                dex13Var.dexh++;
                i4 = dex13Var.dexe + 1;
                dex13Var.dexe = i4;
                if (i4 >= dex13Var.dexr) {
                    cCharAt3 = 26;
                } else {
                    cCharAt3 = dex13Var.dexq.charAt(i4);
                }
                dex13Var.dexd = cCharAt3;
                dex13Var.dexj = true;
                while (true) {
                    c4 = dex13Var.dexd;
                    if (c4 < '0' || c4 > '9') {
                        break;
                    }
                    dex13Var.dexh++;
                    int i8 = dex13Var.dexe + 1;
                    dex13Var.dexe = i8;
                    dex13Var.dexd = i8 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i8);
                }
            }
            c2 = dex13Var.dexd;
            if (c2 != 'L' || c2 == 'S' || c2 == 'B') {
                dex13Var.dexh++;
                dex13Var.dexi();
            } else {
                if (c2 != 'F' || c2 == 'D') {
                    dex13Var.dexh++;
                    dex13Var.dexi();
                } else if (c2 != 'e' || c2 == 'E') {
                    dex13Var.dexh++;
                    i2 = dex13Var.dexe + 1;
                    dex13Var.dexe = i2;
                    if (i2 >= dex13Var.dexr) {
                        cCharAt = 26;
                    } else {
                        cCharAt = dex13Var.dexq.charAt(i2);
                    }
                    dex13Var.dexd = cCharAt;
                    if (cCharAt != '+' || cCharAt == '-') {
                        dex13Var.dexh++;
                        i3 = dex13Var.dexe + 1;
                        dex13Var.dexe = i3;
                        if (i3 >= dex13Var.dexr) {
                            cCharAt2 = 26;
                        }
                        dex13Var.dexd = cCharAt2;
                        c3 = dex13Var.dexd;
                        if (c3 >= '0' || c3 > '9') {
                            if (c3 != 'D' || c3 == 'F') {
                                dex13Var.dexh++;
                                dex13Var.dexi();
                            }
                            dex13Var.dexi = true;
                        } else {
                            dex13Var.dexh++;
                            i3 = dex13Var.dexe + 1;
                            dex13Var.dexe = i3;
                            if (i3 >= dex13Var.dexr) {
                                cCharAt2 = 26;
                            }
                            dex13Var.dexd = cCharAt2;
                            c3 = dex13Var.dexd;
                            if (c3 >= '0') {
                            }
                            if (c3 != 'D') {
                                dex13Var.dexh++;
                                dex13Var.dexi();
                            } else {
                                dex13Var.dexh++;
                                dex13Var.dexi();
                            }
                            dex13Var.dexi = true;
                        }
                    } else {
                        c3 = dex13Var.dexd;
                        if (c3 >= '0') {
                        }
                        if (c3 != 'D') {
                            dex13Var.dexh++;
                            dex13Var.dexi();
                        } else {
                            dex13Var.dexh++;
                            dex13Var.dexi();
                        }
                        dex13Var.dexi = true;
                    }
                    cCharAt2 = dex13Var.dexq.charAt(i3);
                    dex13Var.dexd = cCharAt2;
                    c3 = dex13Var.dexd;
                    if (c3 >= '0') {
                    }
                    if (c3 != 'D') {
                        dex13Var.dexh++;
                        dex13Var.dexi();
                    } else {
                        dex13Var.dexh++;
                        dex13Var.dexi();
                    }
                    dex13Var.dexi = true;
                }
                dex13Var.dexj = true;
            }
            if (dex13Var.dexj) {
                i = 3;
            } else {
                i = 2;
            }
            dex13Var.dexa = i;
        }
        dex13Var = this;
        cCharAt4 = 26;
        dex13Var.dexd = cCharAt4;
        c = dex13Var.dexd;
        if (c < '0') {
        }
        dex13Var.dexj = false;
        if (c == '.') {
            dex13Var.dexh++;
            i4 = dex13Var.dexe + 1;
            dex13Var.dexe = i4;
            if (i4 >= dex13Var.dexr) {
                cCharAt3 = 26;
            } else {
                cCharAt3 = dex13Var.dexq.charAt(i4);
            }
            dex13Var.dexd = cCharAt3;
            dex13Var.dexj = true;
            while (true) {
                c4 = dex13Var.dexd;
                if (c4 < '0') {
                    break;
                    break;
                } else {
                    break;
                    break;
                }
                dex13Var.dexd = i8 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i8);
            }
        }
        c2 = dex13Var.dexd;
        if (c2 != 'L') {
            dex13Var.dexh++;
            dex13Var.dexi();
        } else if (c2 != 'F') {
            dex13Var.dexh++;
            dex13Var.dexi();
            dex13Var.dexj = true;
        } else {
            if (c2 != 'e') {
            }
            dex13Var.dexh++;
            i2 = dex13Var.dexe + 1;
            dex13Var.dexe = i2;
            if (i2 >= dex13Var.dexr) {
                cCharAt = 26;
            } else {
                cCharAt = dex13Var.dexq.charAt(i2);
            }
            dex13Var.dexd = cCharAt;
            if (cCharAt != '+') {
            }
            dex13Var.dexh++;
            i3 = dex13Var.dexe + 1;
            dex13Var.dexe = i3;
            if (i3 >= dex13Var.dexr) {
                cCharAt2 = 26;
            } else {
                cCharAt2 = dex13Var.dexq.charAt(i3);
            }
            dex13Var.dexd = cCharAt2;
            c3 = dex13Var.dexd;
            if (c3 >= '0') {
            }
            if (c3 != 'D') {
                dex13Var.dexh++;
                dex13Var.dexi();
            } else {
                dex13Var.dexh++;
                dex13Var.dexi();
            }
            dex13Var.dexi = true;
            dex13Var.dexj = true;
        }
        if (dex13Var.dexj) {
            i = 3;
        } else {
            i = 2;
        }
        dex13Var.dexa = i;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:114:0x01ce  */
    public final Number dexp() throws com.wangmai.insightvision.openadsdk.d.d {
        long j;
        boolean z;
        char c;
        char c2;
        boolean z2;
        boolean z3;
        int i;
        int i2;
        dex13 dex13Var;
        char c3;
        boolean z4;
        char[] cArr;
        int i3;
        int i4;
        char[] cArr2;
        char c4;
        boolean z5;
        long j2;
        long j3;
        long j4;
        long j5;
        int i5 = this.dexe;
        this.dexk = 0;
        if (this.dexd == '-') {
            this.dexk = 1;
            int i6 = i5 + 1;
            this.dexe = i6;
            this.dexd = i6 >= this.dexr ? (char) 26 : this.dexq.charAt(i6);
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        long j6 = 0;
        boolean z6 = false;
        int i7 = 1;
        while (true) {
            c = this.dexd;
            c2 = '9';
            if (c < '0' || c > '9') {
                break;
            }
            int i8 = c - '0';
            if (i7 < 18) {
                j4 = j6 * 10;
                j5 = i8;
            } else {
                if (j6 < com.airbnb.lottie.parser.moshi.a.b) {
                    z6 = true;
                }
                j4 = j6 * 10;
                j5 = i8;
                if (j4 < j + j5) {
                    z6 = true;
                }
            }
            j6 = j4 - j5;
            this.dexk++;
            int i9 = this.dexe + 1;
            this.dexe = i9;
            this.dexd = i9 >= this.dexr ? (char) 26 : this.dexq.charAt(i9);
            i7++;
        }
        Number numberValueOf = null;
        if (c == '.') {
            this.dexk++;
            int i10 = this.dexe + 1;
            this.dexe = i10;
            this.dexd = i10 >= this.dexr ? (char) 26 : this.dexq.charAt(i10);
            i = 0;
            while (true) {
                c4 = this.dexd;
                if (c4 < '0' || c4 > c2) {
                    break;
                }
                i++;
                int i11 = c4 - '0';
                if (i7 < 18) {
                    j2 = j6 * 10;
                    z5 = z;
                    j3 = i11;
                } else {
                    z5 = z;
                    if (j6 < com.airbnb.lottie.parser.moshi.a.b) {
                        z6 = true;
                    }
                    j2 = j6 * 10;
                    j3 = i11;
                    if (j2 < j + j3) {
                        z6 = true;
                    }
                }
                j6 = j2 - j3;
                this.dexk++;
                int i12 = this.dexe + 1;
                this.dexe = i12;
                this.dexd = i12 >= this.dexr ? (char) 26 : this.dexq.charAt(i12);
                i7++;
                z = z5;
                c2 = '9';
            }
            z2 = z;
            if (!z2) {
                j6 = -j6;
            }
            if (c4 == 'F' || c4 == 'D') {
                this.dexk++;
                dexi();
            }
            z3 = true;
        } else {
            z2 = z;
            if (!z2) {
                j6 = -j6;
            }
            if (c == 'L') {
                this.dexk++;
                dexi();
                numberValueOf = Long.valueOf(j6);
            } else if (c == 'S') {
                this.dexk++;
                dexi();
                numberValueOf = Short.valueOf((short) j6);
            } else if (c == 'B') {
                this.dexk++;
                dexi();
                numberValueOf = Byte.valueOf((byte) j6);
            } else if (c == 'F') {
                this.dexk++;
                dexi();
                numberValueOf = Float.valueOf(j6);
            } else if (c == 'D') {
                this.dexk++;
                dexi();
                numberValueOf = Double.valueOf(j6);
            }
            z3 = false;
            i = 0;
        }
        char c5 = this.dexd;
        if (c5 == 'e' || c5 == 'E') {
            this.dexk++;
            int i13 = this.dexe + 1;
            this.dexe = i13;
            char cCharAt = i13 >= this.dexr ? (char) 26 : this.dexq.charAt(i13);
            this.dexd = cCharAt;
            if (cCharAt == '+' || cCharAt == '-') {
                this.dexk++;
                i2 = this.dexe + 1;
                this.dexe = i2;
                if (i2 >= this.dexr) {
                    dex13Var = this;
                    dex13Var.dexd = (char) 26;
                } else {
                    dex13Var = this;
                }
                dex13Var.dexd = dex13Var.dexq.charAt(i2);
            } else {
                dex13Var = this;
            }
            c3 = dex13Var.dexd;
            if (c3 >= '0' || c3 > '9') {
                if (c3 != 'D' || c3 == 'F') {
                    dex13Var.dexk++;
                    dex13Var.dexi();
                } else {
                    c3 = 0;
                }
                z4 = true;
            } else {
                dex13Var.dexk++;
                i2 = dex13Var.dexe + 1;
                dex13Var.dexe = i2;
                if (i2 >= dex13Var.dexr) {
                    dex13Var.dexd = (char) 26;
                } else {
                    dex13Var.dexd = dex13Var.dexq.charAt(i2);
                }
                c3 = dex13Var.dexd;
                if (c3 >= '0') {
                }
                if (c3 != 'D') {
                    dex13Var.dexk++;
                    dex13Var.dexi();
                } else {
                    dex13Var.dexk++;
                    dex13Var.dexi();
                }
                z4 = true;
            }
        } else {
            dex13Var = this;
            c3 = 0;
            z4 = false;
        }
        if (!z3 && !z4) {
            if (z6) {
                int i14 = dex13Var.dexe;
                char[] cArr3 = new char[i14 - i5];
                dex13Var.dexq.getChars(i5, i14, cArr3, 0);
                numberValueOf = new BigInteger(new String(cArr3));
            }
            if (numberValueOf == null) {
                return (j6 <= -2147483648L || j6 >= 2147483647L) ? Long.valueOf(j6) : Integer.valueOf((int) j6);
            }
            return numberValueOf;
        }
        int i15 = dex13Var.dexe - i5;
        if (c3 != 0) {
            i15--;
        }
        if (!z4 && (dex13Var.dexc & com.wangmai.insightvision.openadsdk.d.i.d.h.t) != 0) {
            if (!z6) {
                return BigDecimal.valueOf(j6, i);
            }
            char[] cArr4 = dex13Var.dexg;
            if (i15 < cArr4.length) {
                i4 = 0;
                dex13Var.dexq.getChars(i5, i5 + i15, cArr4, 0);
                cArr2 = dex13Var.dexg;
            } else {
                i4 = 0;
                char[] cArr5 = new char[i15];
                dex13Var.dexq.getChars(i5, i5 + i15, cArr5, 0);
                cArr2 = cArr5;
            }
            return new BigDecimal(cArr2, i4, i15);
        }
        char[] cArr6 = dex13Var.dexg;
        if (i15 < cArr6.length) {
            dex13Var.dexq.getChars(i5, i5 + i15, cArr6, 0);
            cArr = dex13Var.dexg;
        } else {
            char[] cArr7 = new char[i15];
            dex13Var.dexq.getChars(i5, i5 + i15, cArr7, 0);
            cArr = cArr7;
        }
        try {
            if (i15 > 9 || z4) {
                String str = new String(cArr, 0, i15);
                return c3 == 'F' ? Float.valueOf(str) : Double.valueOf(Double.parseDouble(str));
            }
            char c6 = cArr[0];
            if (c6 == '-' || c6 == '+') {
                c6 = cArr[1];
                i3 = 2;
            } else {
                i3 = 1;
            }
            int i16 = c6 - '0';
            int i17 = 0;
            while (i3 < i15) {
                char c7 = cArr[i3];
                if (c7 == '.') {
                    i17 = 1;
                } else {
                    i16 = (i16 * 10) + (c7 - '0');
                    if (i17 != 0) {
                        i17 *= 10;
                    }
                }
                i3++;
            }
            if (c3 == 'F') {
                float f = i16 / i17;
                if (z2) {
                    f = -f;
                }
                return Float.valueOf(f);
            }
            double d = ((double) i16) / ((double) i17);
            if (z2) {
                d = -d;
            }
            return Double.valueOf(d);
        } catch (NumberFormatException e) {
            throw new com.wangmai.insightvision.openadsdk.d.d(e.getMessage() + ", " + dex13Var.dexd(), e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexq() throws com.wangmai.insightvision.openadsdk.d.d {
        char c = this.dexd;
        int i = this.dexe + 1;
        int iIndexOf = this.dexq.indexOf(c, i);
        if (iIndexOf == -1) {
            throw new com.wangmai.insightvision.openadsdk.d.d("unclosed str, " + dexd());
        }
        int i2 = iIndexOf - i;
        char[] cArrDexa = dexa(this.dexe + 1, i2);
        boolean z = false;
        while (i2 > 0 && cArrDexa[i2 - 1] == '\\') {
            int i3 = 1;
            for (int i4 = i2 - 2; i4 >= 0 && cArrDexa[i4] == '\\'; i4--) {
                i3++;
            }
            if (i3 % 2 == 0) {
                break;
            }
            int iIndexOf2 = this.dexq.indexOf(c, iIndexOf + 1);
            int i5 = (iIndexOf2 - iIndexOf) + i2;
            if (i5 >= cArrDexa.length) {
                int length = (cArrDexa.length * 3) / 2;
                if (length < i5) {
                    length = i5;
                }
                char[] cArr = new char[length];
                System.arraycopy(cArrDexa, 0, cArr, 0, cArrDexa.length);
                cArrDexa = cArr;
            }
            this.dexq.getChars(iIndexOf, iIndexOf2, cArrDexa, i2);
            iIndexOf = iIndexOf2;
            i2 = i5;
            z = true;
        }
        if (!z) {
            for (int i6 = 0; i6 < i2; i6++) {
                if (cArrDexa[i6] == '\\') {
                    z = true;
                }
            }
        }
        this.dexg = cArrDexa;
        this.dexh = i2;
        this.dexk = this.dexe;
        this.dexl = z;
        int i7 = iIndexOf + 1;
        this.dexe = i7;
        this.dexd = i7 >= this.dexr ? (char) 26 : this.dexq.charAt(i7);
        this.dexa = 4;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexr() throws com.wangmai.insightvision.openadsdk.d.d {
        dexi();
        char c = this.dexd;
        if (c == '/') {
            do {
                dexi();
            } while (this.dexd != '\n');
            dexi();
        } else {
            if (c != '*') {
                throw new com.wangmai.insightvision.openadsdk.d.d("invalid comment");
            }
            while (true) {
                dexi();
                while (true) {
                    char c2 = this.dexd;
                    if (c2 == 26) {
                        return;
                    }
                    if (c2 == '*') {
                        dexi();
                        if (this.dexd == '/') {
                            dexi();
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexs() throws com.wangmai.insightvision.openadsdk.d.d {
        while (true) {
            char c = this.dexd;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                dexi();
            } else if (c != '/') {
                return;
            } else {
                dexr();
            }
        }
    }

    public final String dext() {
        return this.dexl ? dexa(this.dexg, this.dexh) : dexb(this.dexk + 1, this.dexh);
    }

    public final int dexu() {
        return this.dexa;
    }
}
