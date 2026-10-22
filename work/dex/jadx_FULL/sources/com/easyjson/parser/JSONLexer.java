package com.easyjson.parser;

import androidx.camera.video.AudioStats;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.vod.common.utils.IOUtils;
import com.easyjson.JSON;
import com.easyjson.JSONException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class JSONLexer {
    public static final char[] CA;
    public static final int END = 4;
    public static final char EOI = 26;
    static final int[] IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    private static boolean V6 = false;
    public static final int VALUE = 3;
    protected static final int[] digits;
    public static final boolean[] firstIdentifierFlags;
    public static final boolean[] identifierFlags;
    private static final ThreadLocal<char[]> sbufLocal;
    protected int bp;
    protected Calendar calendar;
    protected char ch;
    public boolean disableCircularReferenceDetect;
    protected int eofPos;
    public int features;
    protected boolean hasSpecial;
    protected final int len;
    public Locale locale;
    public int matchStat;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected final String text;
    public TimeZone timeZone;
    protected int token;

    static {
        int i;
        char c;
        char c2;
        try {
            i = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
            while (true) {
                boolean[] zArr = firstIdentifierFlags;
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
                boolean[] zArr2 = identifierFlags;
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
        V6 = i >= 23;
        sbufLocal = new ThreadLocal<>();
        digits = new int[103];
        for (int i2 = 48; i2 <= 57; i2++) {
            digits[i2] = i2 - 48;
        }
        for (int i3 = 97; i3 <= 102; i3++) {
            digits[i3] = (i3 - 97) + 10;
        }
        for (int i4 = 65; i4 <= 70; i4++) {
            digits[i4] = (i4 - 65) + 10;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i5 = 0; i5 < length; i5++) {
            IA[CA[i5]] = i5;
        }
        IA[61] = 0;
        firstIdentifierFlags = new boolean[256];
        c2 = 0;
        identifierFlags = new boolean[256];
    }

    public JSONLexer(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(String str, int i) {
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i;
        this.text = str;
        int length = str.length();
        this.len = length;
        int i2 = (-1) + 1;
        this.bp = i2;
        char cCharAt = i2 >= length ? (char) 26 : str.charAt(i2);
        this.ch = cCharAt;
        if (cCharAt == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i) != 0 ? "" : null;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i) != 0;
    }

    public JSONLexer(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    private boolean charArrayCompare(char[] cArr) {
        int length = cArr.length;
        if (this.bp + length > this.len) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (cArr[i] != this.text.charAt(this.bp + i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if ((c == '1' || c == '2') && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
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

    public static boolean checkTime(char c, char c2, char c3, char c4, char c5, char c6) {
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

    public static final byte[] decodeFast(String str) {
        int i;
        int i2;
        int length = str.length();
        int i3 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i4 = length - 1;
        int i5 = 0;
        while (i5 < i4 && IA[str.charAt(i5) & 255] < 0) {
            i5++;
        }
        while (i4 > 0 && IA[str.charAt(i4) & 255] < 0) {
            i4--;
        }
        if (str.charAt(i4) == '=') {
            i = str.charAt(i4 + (-1)) == '=' ? 2 : 1;
        } else {
            i = 0;
        }
        int i6 = (i4 - i5) + 1;
        if (length > 76) {
            i2 = (str.charAt(76) == '\r' ? i6 / 78 : 0) << 1;
        } else {
            i2 = 0;
        }
        int i7 = (((i6 - i2) * 6) >> 3) - i;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int[] iArr = IA;
            int i11 = i5 + 1;
            int i12 = i11 + 1;
            int i13 = (iArr[str.charAt(i5)] << 18) | (iArr[str.charAt(i11)] << 12);
            int i14 = i12 + 1;
            int i15 = i13 | (iArr[str.charAt(i12)] << 6);
            int i16 = i14 + 1;
            int i17 = i15 | iArr[str.charAt(i14)];
            int i18 = i9 + 1;
            bArr[i9] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            i9 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i2 <= 0 || (i10 = i10 + 1) != 19) {
                i5 = i16;
            } else {
                i5 = i16 + 2;
                i10 = 0;
            }
        }
        if (i9 < i7) {
            int i20 = 0;
            while (i5 <= i4 - i) {
                i3 |= IA[str.charAt(i5)] << (18 - (i20 * 6));
                i20++;
                i5++;
            }
            int i21 = 16;
            while (i9 < i7) {
                bArr[i9] = (byte) (i3 >> i21);
                i21 -= 8;
                i9++;
            }
        }
        return bArr;
    }

    public static final byte[] decodeFast(String str, int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i6 = (i + i2) - 1;
        while (i < i6 && IA[str.charAt(i)] < 0) {
            i++;
        }
        while (i6 > 0 && IA[str.charAt(i6)] < 0) {
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
            int[] iArr = IA;
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
                i5 |= IA[str.charAt(i)] << (18 - (i21 * 6));
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

    public static final byte[] decodeFast(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i6 = (i + i2) - 1;
        while (i < i6 && IA[cArr[i]] < 0) {
            i++;
        }
        while (i6 > 0 && IA[cArr[i6]] < 0) {
            i6--;
        }
        if (cArr[i6] == '=') {
            i3 = cArr[i6 + (-1)] == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i7 = (i6 - i) + 1;
        if (i2 > 76) {
            i4 = (cArr[76] == '\r' ? i7 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i8 = (((i7 - i4) * 6) >> 3) - i3;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int[] iArr = IA;
            int i12 = i + 1;
            int i13 = i12 + 1;
            int i14 = (iArr[cArr[i]] << 18) | (iArr[cArr[i12]] << 12);
            int i15 = i13 + 1;
            int i16 = i14 | (iArr[cArr[i13]] << 6);
            int i17 = i15 + 1;
            int i18 = i16 | iArr[cArr[i15]];
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
                i5 |= IA[cArr[i]] << (18 - (i21 * 6));
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

    /* JADX WARN: Code duplicated, block: B:46:0x00ed  */
    private static String readString(char[] cArr, int i) {
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
                                    throw new JSONException("unclosed.str.lit");
                            }
                            break;
                    }
                } else {
                    i2 = i4 + 1;
                    int[] iArr = digits;
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

    private void scanFalse() {
        if (this.text.startsWith(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE, this.bp)) {
            int i = this.bp + 5;
            this.bp = i;
            char cCharAt = charAt(i);
            this.ch = cCharAt;
            if (cCharAt == ' ' || cCharAt == ',' || cCharAt == '}' || cCharAt == ']' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == 26 || cCharAt == '\f' || cCharAt == '\b' || cCharAt == ':') {
                this.token = 7;
                return;
            }
        }
        throw new JSONException("scan false error");
    }

    private void scanIdent() {
        int i;
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String strStringVal = stringVal();
        if (strStringVal.equals("null")) {
            i = 8;
        } else if (strStringVal.equals("true")) {
            i = 6;
        } else if (strStringVal.equals(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            i = 7;
        } else if (strStringVal.equals("new")) {
            i = 9;
        } else if (strStringVal.equals("undefined")) {
            i = 23;
        } else if (strStringVal.equals("Set")) {
            i = 21;
        } else {
            i = strStringVal.equals("TreeSet") ? 22 : 18;
        }
        this.token = i;
    }

    private void scanNullOrNew() {
        int i;
        if (this.text.startsWith("null", this.bp)) {
            this.bp += 4;
            i = 8;
        } else if (this.text.startsWith("new", this.bp)) {
            this.bp += 3;
            i = 9;
        } else {
            i = 0;
        }
        if (i != 0) {
            char cCharAt = charAt(this.bp);
            this.ch = cCharAt;
            if (cCharAt == ' ' || cCharAt == ',' || cCharAt == '}' || cCharAt == ']' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == 26 || cCharAt == '\f' || cCharAt == '\b') {
                this.token = i;
                return;
            }
        }
        throw new JSONException("scan null/new error");
    }

    private void scanTrue() {
        if (this.text.startsWith("true", this.bp)) {
            int i = this.bp + 4;
            this.bp = i;
            char cCharAt = charAt(i);
            this.ch = cCharAt;
            if (cCharAt == ' ' || cCharAt == ',' || cCharAt == '}' || cCharAt == ']' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == 26 || cCharAt == '\f' || cCharAt == '\b' || cCharAt == ':') {
                this.token = 6;
                return;
            }
        }
        throw new JSONException("scan true error");
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    private final String subString(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i + i2, cArr, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return new String(cArr2);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.np + 1, this.sp);
    }

    public char charAt(int i) {
        if (i >= this.len) {
            return (char) 26;
        }
        return this.text.charAt(i);
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final void config(Feature feature, boolean z) {
        int i = this.features;
        int i2 = feature.mask;
        this.features = z ? i | i2 : i & (~i2);
        if (feature == Feature.InitStringFieldAsEmpty) {
            this.stringDefaultValue = z ? "" : null;
        }
        this.disableCircularReferenceDetect = (this.features & Feature.DisableCircularReferenceDetect.mask) != 0;
    }

    public final Number decimalValue(boolean z) {
        char cCharAt = charAt((this.np + this.sp) - 1);
        try {
            if (cCharAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (cCharAt != 'D' && z) {
                return decimalValue();
            }
            return Double.valueOf(Double.parseDouble(numberString()));
        } catch (NumberFormatException e) {
            throw new JSONException(e.getMessage() + ", " + info());
        }
    }

    public final BigDecimal decimalValue() {
        return new BigDecimal(numberString());
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", json : ");
        sb.append(this.text.length() < 65536 ? this.text : this.text.substring(0, 65536));
        return sb.toString();
    }

    public final int intValue() {
        int i;
        boolean z;
        int i2 = this.np;
        int i3 = this.sp + i2;
        int i4 = 0;
        if (charAt(i2) == '-') {
            i2++;
            i = Integer.MIN_VALUE;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i2 < i3) {
            i4 = -(charAt(i2) - '0');
            i2++;
        }
        while (i2 < i3) {
            int i5 = i2 + 1;
            char cCharAt = charAt(i2);
            if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B') {
                i2 = i5;
                break;
            }
            int i6 = cCharAt - '0';
            if (i4 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i7 = i4 * 10;
            if (i7 < i + i6) {
                throw new NumberFormatException(numberString());
            }
            i4 = i7 - i6;
            i2 = i5;
        }
        if (!z) {
            return -i4;
        }
        if (i2 > this.np + 1) {
            return i4;
        }
        throw new NumberFormatException(numberString());
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0051  */
    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0076  */
    /* JADX WARN: Code duplicated, block: B:27:0x0080  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0080 -> B:16:0x004b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Number integerValue() {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easyjson.parser.JSONLexer.integerValue():java.lang.Number");
    }

    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char cCharAt = charAt(i);
            boolean z = true;
            if (cCharAt == 26) {
                return true;
            }
            if (cCharAt > ' ' || (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t' && cCharAt != '\f' && cCharAt != '\b')) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    public final boolean isRef() {
        return this.sp == 4 && this.text.startsWith("$ref", this.np + 1);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    /* JADX WARN: Code duplicated, block: B:33:0x0077  */
    /* JADX WARN: Code duplicated, block: B:35:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x007d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:8:0x0027). Please report as a decompilation issue!!! */
    public final long longValue() {
        boolean z;
        long j;
        long j2;
        int i;
        char cCharAt;
        int i2 = this.np;
        int i3 = this.sp + i2;
        if (charAt(i2) == '-') {
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
                if (i2 >= this.len) {
                    cCharAt = 26;
                } else {
                    cCharAt = this.text.charAt(i2);
                }
                if (cCharAt != 'L' || cCharAt == 'S' || cCharAt == 'B') {
                    i2 = i;
                } else {
                    int i4 = cCharAt - '0';
                    if (j2 < com.airbnb.lottie.parser.moshi.a.b) {
                        throw new NumberFormatException(numberString());
                    }
                    long j3 = j2 * 10;
                    long j4 = i4;
                    if (j3 < j + j4) {
                        throw new NumberFormatException(numberString());
                    }
                    j2 = j3 - j4;
                }
            }
            if (z) {
                return -j2;
            }
            if (i2 > this.np + 1) {
                return j2;
            }
            throw new NumberFormatException(numberString());
        }
        i = i2 + 1;
        j2 = -(charAt(i2) - '0');
        i2 = i;
        if (i2 < i3) {
            i = i2 + 1;
            if (i2 >= this.len) {
                cCharAt = 26;
            } else {
                cCharAt = this.text.charAt(i2);
            }
            if (cCharAt != 'L') {
            }
            i2 = i;
        }
        if (z) {
            return -j2;
        }
        if (i2 > this.np + 1) {
            return j2;
        }
        throw new NumberFormatException(numberString());
    }

    public boolean matchField(char[] cArr) {
        int i;
        if (!charArrayCompare(cArr)) {
            return false;
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        if (length >= this.len) {
            throw new JSONException("unclosed str, " + info());
        }
        char cCharAt = this.text.charAt(length);
        this.ch = cCharAt;
        if (cCharAt != '{') {
            if (cCharAt == '[') {
                int i2 = this.bp + 1;
                this.bp = i2;
                this.ch = i2 < this.len ? this.text.charAt(i2) : (char) 26;
                i = 14;
            } else {
                nextToken();
            }
            return true;
        }
        int i3 = this.bp + 1;
        this.bp = i3;
        this.ch = i3 < this.len ? this.text.charAt(i3) : (char) 26;
        i = 12;
        this.token = i;
        return true;
    }

    public char next() {
        int i = this.bp + 1;
        this.bp = i;
        char cCharAt = i >= this.len ? (char) 26 : this.text.charAt(i);
        this.ch = cCharAt;
        return cCharAt;
    }

    public final void nextIdent() {
        char c;
        while (true) {
            c = this.ch;
            if (!(c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b'))) {
                break;
            } else {
                next();
            }
        }
        if (c == '_' || Character.isLetter(c)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    public final void nextToken() {
        this.sp = 0;
        while (true) {
            int i = this.bp;
            this.pos = i;
            char c = this.ch;
            if (c == '/') {
                skipComment();
            } else {
                if (c == '\"') {
                    scanString();
                    return;
                }
                if ((c >= '0' && c <= '9') || c == '-') {
                    scanNumber();
                    return;
                }
                if (c == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (c != '\f' && c != '\r' && c != ' ') {
                    if (c == ':') {
                        next();
                        this.token = 17;
                        return;
                    }
                    if (c == '[') {
                        int i2 = i + 1;
                        this.bp = i2;
                        this.ch = i2 < this.len ? this.text.charAt(i2) : (char) 26;
                        this.token = 14;
                        return;
                    }
                    if (c == ']') {
                        next();
                        this.token = 15;
                        return;
                    }
                    if (c == 'f') {
                        scanFalse();
                        return;
                    }
                    if (c == 'n') {
                        scanNullOrNew();
                        return;
                    }
                    if (c == '{') {
                        int i3 = i + 1;
                        this.bp = i3;
                        this.ch = i3 < this.len ? this.text.charAt(i3) : (char) 26;
                        this.token = 12;
                        return;
                    }
                    if (c == '}') {
                        int i4 = i + 1;
                        this.bp = i4;
                        this.ch = i4 < this.len ? this.text.charAt(i4) : (char) 26;
                        this.token = 13;
                        return;
                    }
                    if (c != 'S' && c != 'T') {
                        if (c == 't') {
                            scanTrue();
                            return;
                        }
                        if (c != 'u') {
                            switch (c) {
                                default:
                                    switch (c) {
                                        case '\'':
                                            if ((this.features & Feature.AllowSingleQuotes.mask) == 0) {
                                                throw new JSONException("Feature.AllowSingleQuotes is false");
                                            }
                                            scanString();
                                            return;
                                        case '(':
                                            next();
                                            this.token = 10;
                                            return;
                                        case ')':
                                            next();
                                            this.token = 11;
                                            return;
                                        default:
                                            int i5 = this.len;
                                            if (i == i5 || (c == 26 && i + 1 == i5)) {
                                                if (this.token == 20) {
                                                    throw new JSONException("EOF error");
                                                }
                                                this.token = 20;
                                                int i6 = this.eofPos;
                                                this.bp = i6;
                                                this.pos = i6;
                                                return;
                                            }
                                            if (c > 31 && c != 127) {
                                                this.token = 1;
                                                next();
                                                return;
                                            }
                                            break;
                                    }
                                case '\b':
                                case '\t':
                                case '\n':
                                    next();
                                    break;
                            }
                        }
                    }
                    scanIdent();
                    return;
                }
                next();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:124:0x00a3 A[SYNTHETIC] */
    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i == 2) {
                char c = this.ch;
                if (c >= '0' && c <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                if (c == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c2 = this.ch;
                if (c2 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c2 >= '0' && c2 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c2 == '{') {
                    this.token = 12;
                    int i2 = this.bp + 1;
                    this.bp = i2;
                    this.ch = i2 < this.len ? this.text.charAt(i2) : (char) 26;
                    return;
                }
            } else if (i == 12) {
                char c3 = this.ch;
                if (c3 == '{') {
                    this.token = 12;
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    this.ch = i3 < this.len ? this.text.charAt(i3) : (char) 26;
                    return;
                }
                if (c3 == '[') {
                    this.token = 14;
                    int i4 = this.bp + 1;
                    this.bp = i4;
                    this.ch = i4 < this.len ? this.text.charAt(i4) : (char) 26;
                    return;
                }
            } else {
                if (i == 18) {
                    nextIdent();
                    return;
                }
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c4 = this.ch;
                            if (c4 == '[') {
                                this.token = 14;
                                next();
                            } else if (c4 == '{') {
                                this.token = 12;
                                next();
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                            }
                            if (this.ch == 26) {
                                this.token = 20;
                            }
                            break;
                        case 16:
                            char c5 = this.ch;
                            if (c5 == ',') {
                                this.token = 16;
                                int i5 = this.bp + 1;
                                this.bp = i5;
                                this.ch = i5 < this.len ? this.text.charAt(i5) : (char) 26;
                            } else if (c5 == '}') {
                                this.token = 13;
                                int i6 = this.bp + 1;
                                this.bp = i6;
                                this.ch = i6 < this.len ? this.text.charAt(i6) : (char) 26;
                            } else if (c5 == ']') {
                                this.token = 15;
                                int i7 = this.bp + 1;
                                this.bp = i7;
                                this.ch = i7 < this.len ? this.text.charAt(i7) : (char) 26;
                            } else if (c5 == 26) {
                                this.token = 20;
                            }
                            break;
                    }
                    return;
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            }
            char c6 = this.ch;
            if (c6 != ' ' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != '\f' && c6 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    public final void nextTokenWithChar(char c) {
        this.sp = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 == c) {
                int i = this.bp + 1;
                this.bp = i;
                this.ch = i >= this.len ? (char) 26 : this.text.charAt(i);
                nextToken();
                return;
            }
            if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                throw new JSONException("not match " + c + " - " + this.ch);
            }
            next();
        }
    }

    public final String numberString() {
        char cCharAt = this.text.charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    public boolean scanBoolean() {
        int i;
        boolean z = false;
        if (this.text.startsWith(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE, this.bp)) {
            i = 5;
        } else if (this.text.startsWith("true", this.bp)) {
            i = 4;
            z = true;
        } else {
            char c = this.ch;
            if (c == '1') {
                i = 1;
                z = true;
            } else {
                if (c != '0') {
                    this.matchStat = -1;
                    return false;
                }
                i = 1;
            }
        }
        int i2 = this.bp + i;
        this.bp = i2;
        this.ch = charAt(i2);
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0063  */
    /* JADX WARN: Code duplicated, block: B:25:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x007d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    /* JADX WARN: Code duplicated, block: B:32:0x008c  */
    /* JADX WARN: Code duplicated, block: B:35:0x009a  */
    /* JADX WARN: Code duplicated, block: B:37:0x009e  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c0 A[PHI: r12
      0x00c0: PHI (r12v22 int) = (r12v17 int), (r12v21 int), (r12v25 int) binds: [B:42:0x00bd, B:38:0x00ab, B:33:0x0097] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00dc  */
    public boolean scanFieldBoolean(char[] cArr) {
        int i;
        boolean z;
        int i2;
        char cCharAt;
        char cCharAt2;
        int i3;
        char cCharAt3;
        int i4;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        if (!this.text.startsWith(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE, this.bp + length)) {
            if (this.text.startsWith("true", this.bp + length)) {
                i = length + 4;
            } else if (this.text.startsWith("\"false\"", this.bp + length)) {
                i = length + 7;
            } else {
                if (!this.text.startsWith("\"true\"", this.bp + length)) {
                    this.matchStat = -1;
                    return false;
                }
                i = length + 6;
            }
            z = true;
            i2 = i + 1;
            cCharAt = charAt(this.bp + i);
            cCharAt2 = 26;
            if (cCharAt == ',') {
                int i5 = this.bp + (i2 - 1) + 1;
                this.bp = i5;
                this.ch = i5 < this.len ? this.text.charAt(i5) : (char) 26;
                this.matchStat = 3;
                this.token = 16;
                return z;
            }
            if (cCharAt == '}') {
                this.matchStat = -1;
                return false;
            }
            i3 = i2 + 1;
            cCharAt3 = charAt(this.bp + i2);
            if (cCharAt3 == ',') {
                this.token = 16;
                i4 = this.bp + (i3 - 1) + 1;
                this.bp = i4;
                if (i4 < this.len) {
                    cCharAt2 = this.text.charAt(i4);
                }
            } else if (cCharAt3 == ']') {
                this.token = 15;
                i4 = this.bp + (i3 - 1) + 1;
                this.bp = i4;
                if (i4 < this.len) {
                    cCharAt2 = this.text.charAt(i4);
                }
            } else if (cCharAt3 == '}') {
                this.token = 13;
                i4 = this.bp + (i3 - 1) + 1;
                this.bp = i4;
                if (i4 < this.len) {
                    cCharAt2 = this.text.charAt(i4);
                }
            } else {
                if (cCharAt3 == 26) {
                    this.matchStat = -1;
                    return false;
                }
                this.token = 20;
                this.bp += i3 - 1;
            }
            this.ch = cCharAt2;
            this.matchStat = 4;
            return z;
        }
        i = length + 5;
        z = false;
        i2 = i + 1;
        cCharAt = charAt(this.bp + i);
        cCharAt2 = 26;
        if (cCharAt == ',') {
            int i6 = this.bp + (i2 - 1) + 1;
            this.bp = i6;
            this.ch = i6 < this.len ? this.text.charAt(i6) : (char) 26;
            this.matchStat = 3;
            this.token = 16;
            return z;
        }
        if (cCharAt == '}') {
            this.matchStat = -1;
            return false;
        }
        i3 = i2 + 1;
        cCharAt3 = charAt(this.bp + i2);
        if (cCharAt3 == ',') {
            this.token = 16;
            i4 = this.bp + (i3 - 1) + 1;
            this.bp = i4;
            if (i4 < this.len) {
                cCharAt2 = this.text.charAt(i4);
            }
        } else if (cCharAt3 == ']') {
            this.token = 15;
            i4 = this.bp + (i3 - 1) + 1;
            this.bp = i4;
            if (i4 < this.len) {
                cCharAt2 = this.text.charAt(i4);
            }
        } else if (cCharAt3 == '}') {
            this.token = 13;
            i4 = this.bp + (i3 - 1) + 1;
            this.bp = i4;
            if (i4 < this.len) {
                cCharAt2 = this.text.charAt(i4);
            }
        } else {
            if (cCharAt3 == 26) {
                this.matchStat = -1;
                return false;
            }
            this.token = 20;
            this.bp += i3 - 1;
        }
        this.ch = cCharAt2;
        this.matchStat = 4;
        return z;
    }

    public final double scanFieldDouble(char[] cArr) {
        int i;
        char cCharAt;
        int i2;
        JSONLexer jSONLexer;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        while (true) {
            i = i3 + 1;
            cCharAt = charAt(this.bp + i3);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i3 = i;
        }
        if (cCharAt == '.') {
            int i4 = i + 1;
            char cCharAt3 = charAt(this.bp + i);
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                this.matchStat = -1;
                return AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            while (true) {
                i = i4 + 1;
                cCharAt = charAt(this.bp + i4);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i4 = i;
            }
        }
        if (cCharAt == 'e' || cCharAt == 'E') {
            int i5 = i + 1;
            cCharAt = charAt(this.bp + i);
            if (cCharAt == '+' || cCharAt == '-') {
                i2 = i5 + 1;
                char cCharAt4 = charAt(this.bp + i5);
                jSONLexer = this;
                cCharAt = cCharAt4;
            } else {
                i2 = i5;
                jSONLexer = this;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                JSONLexer jSONLexer2 = jSONLexer;
                int i6 = i2;
                i2 = i6 + 1;
                char cCharAt5 = jSONLexer2.charAt(jSONLexer2.bp + i6);
                jSONLexer = jSONLexer2;
                cCharAt = cCharAt5;
            }
            i = i2;
        } else {
            jSONLexer = this;
        }
        int i7 = jSONLexer.bp;
        int length2 = cArr.length + i7;
        double d = Double.parseDouble(jSONLexer.subString(length2, ((i7 + i) - length2) - 1));
        int i8 = 16;
        if (cCharAt == ',') {
            jSONLexer.bp += i - 1;
            jSONLexer.next();
            jSONLexer.matchStat = 3;
            jSONLexer.token = 16;
            return d;
        }
        if (cCharAt != '}') {
            jSONLexer.matchStat = -1;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int i9 = i + 1;
        char cCharAt6 = jSONLexer.charAt(jSONLexer.bp + i);
        if (cCharAt6 != ',') {
            if (cCharAt6 == ']') {
                i8 = 15;
            } else if (cCharAt6 == '}') {
                i8 = 13;
            } else {
                if (cCharAt6 != 26) {
                    jSONLexer.matchStat = -1;
                    return AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                jSONLexer.token = 20;
                jSONLexer.bp += i9 - 1;
                jSONLexer.ch = (char) 26;
            }
            jSONLexer.token = i8;
            jSONLexer.bp += i9 - 1;
            jSONLexer.next();
        } else {
            jSONLexer.token = i8;
            jSONLexer.bp += i9 - 1;
            jSONLexer.next();
        }
        jSONLexer.matchStat = 4;
        return d;
    }

    public final float scanFieldFloat(char[] cArr) {
        int i;
        char cCharAt;
        int i2;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        while (true) {
            i = i3 + 1;
            cCharAt = charAt(this.bp + i3);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i3 = i;
        }
        if (cCharAt == '.') {
            int i4 = i + 1;
            char cCharAt3 = charAt(this.bp + i);
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            while (true) {
                i = i4 + 1;
                cCharAt = charAt(this.bp + i4);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i4 = i;
            }
        }
        int i5 = this.bp;
        int length2 = cArr.length + i5;
        float f = Float.parseFloat(subString(length2, ((i5 + i) - length2) - 1));
        if (cCharAt == ',') {
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return f;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i6 = i + 1;
        char cCharAt4 = charAt(this.bp + i);
        if (cCharAt4 == ',') {
            this.token = 16;
        } else {
            if (cCharAt4 != ']') {
                if (cCharAt4 == '}') {
                    i2 = 13;
                } else {
                    if (cCharAt4 != 26) {
                        this.matchStat = -1;
                        return 0.0f;
                    }
                    this.bp += i6 - 1;
                    this.token = 20;
                    this.ch = (char) 26;
                }
                this.matchStat = 4;
                return f;
            }
            i2 = 15;
            this.token = i2;
        }
        this.bp += i6 - 1;
        next();
        this.matchStat = 4;
        return f;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00db A[PHI: r0
      0x00db: PHI (r0v13 int) = (r0v7 int), (r0v11 int), (r0v16 int) binds: [B:60:0x00d8, B:56:0x00c6, B:51:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    public int scanFieldInt(char[] cArr) {
        boolean z;
        int i;
        char cCharAt;
        int i2;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        char cCharAt3 = 26;
        if (cCharAt2 == '\"') {
            int i4 = i3 + 1;
            int i5 = this.bp + i3;
            cCharAt2 = i5 >= this.len ? (char) 26 : this.text.charAt(i5);
            i3 = i4;
            z = true;
        } else {
            z = false;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i6 = cCharAt2 - '0';
        while (true) {
            i = i3 + 1;
            cCharAt = charAt(this.bp + i3);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i6 = (i6 * 10) + (cCharAt - '0');
            i3 = i;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (cCharAt == '\"') {
            if (!z) {
                this.matchStat = -1;
                return 0;
            }
            int i7 = i + 1;
            int i8 = this.bp + i;
            if (i8 >= this.len) {
                i = i7;
                cCharAt = 26;
            } else {
                i = i7;
                cCharAt = this.text.charAt(i8);
            }
        }
        if (i6 < 0) {
            this.matchStat = -1;
            return 0;
        }
        if (cCharAt == ',') {
            int i9 = this.bp + (i - 1) + 1;
            this.bp = i9;
            this.ch = i9 < this.len ? this.text.charAt(i9) : (char) 26;
            this.matchStat = 3;
            this.token = 16;
            return i6;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0;
        }
        int i10 = i + 1;
        char cCharAt4 = charAt(this.bp + i);
        if (cCharAt4 == ',') {
            this.token = 16;
            i2 = this.bp + (i10 - 1) + 1;
            this.bp = i2;
            if (i2 < this.len) {
                cCharAt3 = this.text.charAt(i2);
            }
        } else if (cCharAt4 == ']') {
            this.token = 15;
            i2 = this.bp + (i10 - 1) + 1;
            this.bp = i2;
            if (i2 < this.len) {
                cCharAt3 = this.text.charAt(i2);
            }
        } else if (cCharAt4 == '}') {
            this.token = 13;
            i2 = this.bp + (i10 - 1) + 1;
            this.bp = i2;
            if (i2 < this.len) {
                cCharAt3 = this.text.charAt(i2);
            }
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return 0;
            }
            this.token = 20;
            this.bp += i10 - 1;
        }
        this.ch = cCharAt3;
        this.matchStat = 4;
        return i6;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ff A[PHI: r1
      0x00ff: PHI (r1v15 int) = (r1v9 int), (r1v13 int), (r1v18 int) binds: [B:66:0x00fa, B:62:0x00e8, B:57:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    public long scanFieldLong(char[] cArr) {
        int i;
        char cCharAt;
        int i2;
        char cCharAt2;
        boolean z = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i3 = length + 1;
        int i4 = this.bp + length;
        char cCharAt3 = i4 >= this.len ? (char) 26 : this.text.charAt(i4);
        if (cCharAt3 == '\"') {
            int i5 = i3 + 1;
            int i6 = this.bp + i3;
            if (i6 >= this.len) {
                i3 = i5;
                z = true;
                cCharAt3 = 26;
            } else {
                i3 = i5;
                cCharAt3 = this.text.charAt(i6);
                z = true;
            }
        }
        if (cCharAt3 < '0' || cCharAt3 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = cCharAt3 - '0';
        while (true) {
            i = i3 + 1;
            int i7 = this.bp + i3;
            cCharAt = i7 >= this.len ? (char) 26 : this.text.charAt(i7);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j = (j * 10) + ((long) (cCharAt - '0'));
            i3 = i;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (cCharAt == '\"') {
            if (!z) {
                this.matchStat = -1;
                return 0L;
            }
            int i8 = i + 1;
            int i9 = this.bp + i;
            if (i9 >= this.len) {
                i = i8;
                cCharAt = 26;
            } else {
                i = i8;
                cCharAt = this.text.charAt(i9);
            }
        }
        if (j < 0) {
            this.matchStat = -1;
            return 0L;
        }
        if (cCharAt == ',') {
            int i10 = this.bp + (i - 1) + 1;
            this.bp = i10;
            this.ch = i10 >= this.len ? (char) 26 : this.text.charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            return j;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0L;
        }
        int i11 = i + 1;
        char cCharAt4 = charAt(this.bp + i);
        if (cCharAt4 == ',') {
            this.token = 16;
            i2 = this.bp + (i11 - 1) + 1;
            this.bp = i2;
            if (i2 >= this.len) {
                cCharAt2 = 26;
            } else {
                cCharAt2 = this.text.charAt(i2);
            }
            this.ch = cCharAt2;
        } else if (cCharAt4 == ']') {
            this.token = 15;
            i2 = this.bp + (i11 - 1) + 1;
            this.bp = i2;
            if (i2 >= this.len) {
                cCharAt2 = 26;
            } else {
                cCharAt2 = this.text.charAt(i2);
            }
            this.ch = cCharAt2;
        } else if (cCharAt4 == '}') {
            this.token = 13;
            i2 = this.bp + (i11 - 1) + 1;
            this.bp = i2;
            if (i2 >= this.len) {
                cCharAt2 = 26;
            } else {
                cCharAt2 = this.text.charAt(i2);
            }
            this.ch = cCharAt2;
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return 0L;
            }
            this.token = 20;
            this.bp += i11 - 1;
            this.ch = (char) 26;
        }
        this.matchStat = 4;
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007a  */
    public String scanFieldString(char[] cArr) {
        String str;
        int i;
        this.matchStat = 0;
        if (charArrayCompare(cArr)) {
            int length = cArr.length;
            int i2 = length + 1;
            int i3 = this.bp + length;
            if (i3 >= this.len) {
                throw new JSONException("unclosed str, " + info());
            }
            if (this.text.charAt(i3) == '\"') {
                int i4 = this.bp + i2;
                int iIndexOf = this.text.indexOf(34, i4);
                if (iIndexOf == -1) {
                    throw new JSONException("unclosed str, " + info());
                }
                if (V6) {
                    str = this.text.substring(i4, iIndexOf);
                } else {
                    int i5 = iIndexOf - i4;
                    str = new String(sub_chars(this.bp + i2, i5), 0, i5);
                }
                if (str.indexOf(92) != -1) {
                    boolean z = false;
                    while (true) {
                        int i6 = iIndexOf - 1;
                        int i7 = 0;
                        while (i6 >= 0 && this.text.charAt(i6) == '\\') {
                            i7++;
                            i6--;
                            z = true;
                        }
                        if (i7 % 2 == 0) {
                            break;
                        }
                        iIndexOf = this.text.indexOf(34, iIndexOf + 1);
                    }
                    int i8 = iIndexOf - i4;
                    char[] cArrSub_chars = sub_chars(this.bp + i2, i8);
                    if (z) {
                        str = readString(cArrSub_chars, i8);
                    } else {
                        str = new String(cArrSub_chars, 0, i8);
                        if (str.indexOf(92) != -1) {
                            str = readString(cArrSub_chars, i8);
                        }
                    }
                }
                int i9 = iIndexOf + 1;
                char cCharAt = i9 >= this.len ? (char) 26 : this.text.charAt(i9);
                if (cCharAt == ',') {
                    int i10 = i9 + 1;
                    this.bp = i10;
                    this.ch = i10 < this.len ? this.text.charAt(i10) : (char) 26;
                    this.matchStat = 3;
                    this.token = 16;
                    return str;
                }
                if (cCharAt == '}') {
                    int i11 = i9 + 1;
                    char cCharAt2 = charAt(i11);
                    if (cCharAt2 == ',') {
                        this.token = 16;
                    } else {
                        if (cCharAt2 != ']') {
                            if (cCharAt2 == '}') {
                                i = 13;
                            } else if (cCharAt2 == 26) {
                                this.token = 20;
                                this.bp = i11;
                                this.ch = (char) 26;
                            }
                            this.matchStat = 4;
                            return str;
                        }
                        i = 15;
                        this.token = i;
                    }
                    this.bp = i11;
                    next();
                    this.matchStat = 4;
                    return str;
                }
            }
            this.matchStat = -1;
        } else {
            this.matchStat = -2;
        }
        return this.stringDefaultValue;
    }

    public String scanFieldSymbol(char[] cArr, SymbolTable symbolTable) {
        int i;
        int i2;
        int i3 = 0;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return null;
        }
        while (true) {
            int i5 = i4 + 1;
            char cCharAt = charAt(this.bp + i4);
            if (cCharAt == '\"') {
                int i6 = this.bp;
                int length2 = cArr.length + i6 + 1;
                String strAddSymbol = symbolTable.addSymbol(this.text, length2, ((i6 + i5) - length2) - 1, i3);
                int i7 = i5 + 1;
                char cCharAt2 = charAt(this.bp + i5);
                if (cCharAt2 == ',') {
                    int i8 = this.bp + (i7 - 1) + 1;
                    this.bp = i8;
                    this.ch = i8 < this.len ? this.text.charAt(i8) : (char) 26;
                    i2 = 3;
                } else {
                    if (cCharAt2 != '}') {
                        this.matchStat = -1;
                        return null;
                    }
                    int i9 = i7 + 1;
                    char cCharAt3 = charAt(this.bp + i7);
                    if (cCharAt3 == ',') {
                        i = 16;
                    } else if (cCharAt3 == ']') {
                        i = 15;
                    } else {
                        if (cCharAt3 == '}') {
                            i = 13;
                        } else {
                            if (cCharAt3 != 26) {
                                this.matchStat = -1;
                                return null;
                            }
                            this.token = 20;
                            this.bp += i9 - 1;
                            this.ch = (char) 26;
                        }
                        i2 = 4;
                    }
                    this.token = i;
                    this.bp += i9 - 1;
                    next();
                    i2 = 4;
                }
                this.matchStat = i2;
                return strAddSymbol;
            }
            i3 = (i3 * 31) + cCharAt;
            if (cCharAt == '\\') {
                this.matchStat = -1;
                return null;
            }
            i4 = i5;
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        int i;
        int i2;
        int i3;
        char c;
        char cCharAt;
        int i4;
        char cCharAt2;
        int i5;
        int i6;
        char cCharAt3;
        int length = this.text.length();
        int i7 = this.bp;
        int i8 = length - i7;
        if (!z && i8 > 13 && this.text.startsWith("/Date(", i7) && charAt((this.bp + i8) - 1) == '/' && charAt((this.bp + i8) - 2) == ')') {
            int i9 = -1;
            for (int i10 = 6; i10 < i8; i10++) {
                char cCharAt4 = charAt(this.bp + i10);
                if (cCharAt4 != '+') {
                    if (cCharAt4 < '0' || cCharAt4 > '9') {
                        break;
                    }
                } else {
                    i9 = i10;
                }
            }
            if (i9 == -1) {
                return false;
            }
            int i11 = this.bp + 6;
            long j = Long.parseLong(subString(i11, i9 - i11));
            Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
            this.calendar = calendar;
            calendar.setTimeInMillis(j);
            this.token = 5;
            return true;
        }
        if (i8 == 8 || i8 == 14 || i8 == 17) {
            int i12 = 0;
            if (z) {
                return false;
            }
            char cCharAt5 = charAt(this.bp);
            char cCharAt6 = charAt(this.bp + 1);
            char cCharAt7 = charAt(this.bp + 2);
            char cCharAt8 = charAt(this.bp + 3);
            char cCharAt9 = charAt(this.bp + 4);
            char cCharAt10 = charAt(this.bp + 5);
            char cCharAt11 = charAt(this.bp + 6);
            char cCharAt12 = charAt(this.bp + 7);
            if (!checkDate(cCharAt5, cCharAt6, cCharAt7, cCharAt8, cCharAt9, cCharAt10, cCharAt11, cCharAt12)) {
                return false;
            }
            setCalendar(cCharAt5, cCharAt6, cCharAt7, cCharAt8, cCharAt9, cCharAt10, cCharAt11, cCharAt12);
            if (i8 != 8) {
                char cCharAt13 = charAt(this.bp + 8);
                char cCharAt14 = charAt(this.bp + 9);
                char cCharAt15 = charAt(this.bp + 10);
                char cCharAt16 = charAt(this.bp + 11);
                char cCharAt17 = charAt(this.bp + 12);
                char cCharAt18 = charAt(this.bp + 13);
                if (!checkTime(cCharAt13, cCharAt14, cCharAt15, cCharAt16, cCharAt17, cCharAt18)) {
                    return false;
                }
                if (i8 == 17) {
                    char cCharAt19 = charAt(this.bp + 14);
                    char cCharAt20 = charAt(this.bp + 15);
                    char cCharAt21 = charAt(this.bp + 16);
                    c = '0';
                    if (cCharAt19 < '0' || cCharAt19 > '9' || cCharAt20 < '0' || cCharAt20 > '9' || cCharAt21 < '0' || cCharAt21 > '9') {
                        return false;
                    }
                    i12 = ((cCharAt19 - '0') * 100) + ((cCharAt20 - '0') * 10) + (cCharAt21 - '0');
                } else {
                    c = '0';
                }
                i3 = (cCharAt14 - c) + ((cCharAt13 - c) * 10);
                i2 = ((cCharAt17 - '0') * 10) + (cCharAt18 - '0');
                int i13 = i12;
                i12 = ((cCharAt15 - c) * 10) + (cCharAt16 - c);
                i = i13;
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
            }
            this.calendar.set(11, i3);
            this.calendar.set(12, i12);
            this.calendar.set(13, i2);
            this.calendar.set(14, i);
            this.token = 5;
            return true;
        }
        if (i8 < 10 || charAt(this.bp + 4) != '-' || charAt(this.bp + 7) != '-') {
            return false;
        }
        char cCharAt22 = charAt(this.bp);
        char cCharAt23 = charAt(this.bp + 1);
        char cCharAt24 = charAt(this.bp + 2);
        char cCharAt25 = charAt(this.bp + 3);
        char cCharAt26 = charAt(this.bp + 5);
        char cCharAt27 = charAt(this.bp + 6);
        char cCharAt28 = charAt(this.bp + 8);
        char cCharAt29 = charAt(this.bp + 9);
        if (!checkDate(cCharAt22, cCharAt23, cCharAt24, cCharAt25, cCharAt26, cCharAt27, cCharAt28, cCharAt29)) {
            return false;
        }
        setCalendar(cCharAt22, cCharAt23, cCharAt24, cCharAt25, cCharAt26, cCharAt27, cCharAt28, cCharAt29);
        char cCharAt30 = charAt(this.bp + 10);
        if (cCharAt30 != 'T' && (cCharAt30 != ' ' || z)) {
            if (cCharAt30 != '\"' && cCharAt30 != 26) {
                return false;
            }
            this.calendar.set(11, 0);
            this.calendar.set(12, 0);
            this.calendar.set(13, 0);
            this.calendar.set(14, 0);
            int i14 = this.bp + 10;
            this.bp = i14;
            this.ch = charAt(i14);
            this.token = 5;
            return true;
        }
        if (i8 < 19 || charAt(this.bp + 13) != ':' || charAt(this.bp + 16) != ':') {
            return false;
        }
        char cCharAt31 = charAt(this.bp + 11);
        char cCharAt32 = charAt(this.bp + 12);
        char cCharAt33 = charAt(this.bp + 14);
        char cCharAt34 = charAt(this.bp + 15);
        char cCharAt35 = charAt(this.bp + 17);
        char cCharAt36 = charAt(this.bp + 18);
        if (!checkTime(cCharAt31, cCharAt32, cCharAt33, cCharAt34, cCharAt35, cCharAt36)) {
            return false;
        }
        this.calendar.set(11, ((cCharAt31 - '0') * 10) + (cCharAt32 - '0'));
        this.calendar.set(12, ((cCharAt33 - '0') * 10) + (cCharAt34 - '0'));
        this.calendar.set(13, ((cCharAt35 - '0') * 10) + (cCharAt36 - '0'));
        char cCharAt37 = charAt(this.bp + 19);
        if (cCharAt37 != '.') {
            this.calendar.set(14, 0);
            int i15 = this.bp + 19;
            this.bp = i15;
            this.ch = charAt(i15);
            this.token = 5;
            if (cCharAt37 == 'Z' && this.calendar.getTimeZone().getRawOffset() != 0) {
                String[] availableIDs = TimeZone.getAvailableIDs(0);
                if (availableIDs.length > 0) {
                    this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                }
            }
            return true;
        }
        if (i8 >= 23 && (cCharAt = charAt(this.bp + 20)) >= '0' && cCharAt <= '9') {
            int[] iArr = digits;
            int i16 = iArr[cCharAt];
            char cCharAt38 = charAt(this.bp + 21);
            if (cCharAt38 < '0' || cCharAt38 > '9') {
                i4 = 1;
            } else {
                i16 = (i16 * 10) + iArr[cCharAt38];
                i4 = 2;
            }
            if (i4 == 2 && (cCharAt3 = charAt(this.bp + 22)) >= '0' && cCharAt3 <= '9') {
                i16 = (i16 * 10) + iArr[cCharAt3];
                i4 = 3;
            }
            this.calendar.set(14, i16);
            char cCharAt39 = charAt(this.bp + 20 + i4);
            if (cCharAt39 == '+' || cCharAt39 == '-') {
                char cCharAt40 = charAt(this.bp + 20 + i4 + 1);
                if (cCharAt40 >= '0' && cCharAt40 <= '1' && (cCharAt2 = charAt(this.bp + 20 + i4 + 2)) >= '0' && cCharAt2 <= '9') {
                    char cCharAt41 = charAt(this.bp + 20 + i4 + 3);
                    if (cCharAt41 == ':') {
                        if (charAt(this.bp + 20 + i4 + 4) != '0' || charAt(this.bp + 20 + i4 + 5) != '0') {
                            return false;
                        }
                        i5 = 6;
                    } else if (cCharAt41 != '0') {
                        i5 = 3;
                    } else {
                        if (charAt(this.bp + 20 + i4 + 4) != '0') {
                            return false;
                        }
                        i5 = 5;
                    }
                    int i17 = ((iArr[cCharAt40] * 10) + iArr[cCharAt2]) * 3600 * 1000;
                    if (cCharAt39 == '-') {
                        i17 = -i17;
                    }
                    if (this.calendar.getTimeZone().getRawOffset() != i17) {
                        String[] availableIDs2 = TimeZone.getAvailableIDs(i17);
                        if (availableIDs2.length > 0) {
                            this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                        }
                    }
                    i6 = i5;
                }
            } else if (cCharAt39 == 'Z') {
                if (this.calendar.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs3 = TimeZone.getAvailableIDs(0);
                    if (availableIDs3.length > 0) {
                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs3[0]));
                    }
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            int i18 = i4 + 20 + i6;
            char cCharAt42 = charAt(this.bp + i18);
            if (cCharAt42 != 26 && cCharAt42 != '\"') {
                return false;
            }
            int i19 = this.bp + i18;
            this.bp = i19;
            this.ch = charAt(i19);
            this.token = 5;
            return true;
        }
        return false;
    }

    public final long scanLongValue() {
        long j;
        boolean z = false;
        this.np = 0;
        if (this.ch == '-') {
            this.np = 0 + 1;
            int i = this.bp + 1;
            this.bp = i;
            if (i >= this.len) {
                throw new JSONException("syntax error, " + info());
            }
            this.ch = this.text.charAt(i);
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j2 = 0;
        while (true) {
            char c = this.ch;
            if (c < '0' || c > '9') {
                break;
            }
            int i2 = c - '0';
            if (j2 < com.airbnb.lottie.parser.moshi.a.b) {
                throw new JSONException("error long value, " + j2 + ", " + info());
            }
            long j3 = j2 * 10;
            long j4 = i2;
            if (j3 < j + j4) {
                throw new JSONException("error long value, " + j3 + ", " + info());
            }
            j2 = j3 - j4;
            this.np++;
            int i3 = this.bp + 1;
            this.bp = i3;
            this.ch = i3 >= this.len ? (char) 26 : this.text.charAt(i3);
        }
        return !z ? -j2 : j2;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:19:0x0046  */
    /* JADX WARN: Code duplicated, block: B:21:0x0054  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056 A[LOOP:0: B:23:0x005c->B:22:0x0056, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0062 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    /* JADX WARN: Code duplicated, block: B:34:0x007d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0086  */
    /* JADX WARN: Code duplicated, block: B:43:0x0094  */
    /* JADX WARN: Code duplicated, block: B:45:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d9 A[PHI: r1
      0x00d9: PHI (r1v21 int) = (r1v18 int), (r1v27 int) binds: [B:60:0x00d6, B:68:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:69:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:74:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:75:0x0100  */
    /* JADX WARN: Code duplicated, block: B:81:0x0073 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x005c, code lost:
    
        r1 = r0.text.charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00df, code lost:
    
        r1 = 26;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0035 -> B:14:0x0037). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0070 -> B:21:0x0054). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x00f3 -> B:62:0x00d9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void scanNumber() {
        JSONLexer jSONLexer;
        char c;
        boolean z;
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
        int i5;
        char cCharAt4;
        int i6 = this.bp;
        this.np = i6;
        boolean z2 = true;
        if (this.ch != '-') {
            jSONLexer = this;
            c = jSONLexer.ch;
            if (c < '0') {
            }
            if (c == '.') {
                jSONLexer.sp++;
                i4 = jSONLexer.bp + 1;
                jSONLexer.bp = i4;
                if (i4 >= jSONLexer.len) {
                    cCharAt3 = 26;
                } else {
                    cCharAt3 = jSONLexer.text.charAt(i5);
                }
                while (true) {
                    jSONLexer.ch = cCharAt3;
                    c4 = jSONLexer.ch;
                    if (c4 < '0') {
                    }
                    z = true;
                    cCharAt3 = jSONLexer.text.charAt(i5);
                }
            } else {
                z = false;
            }
            c2 = jSONLexer.ch;
            if (c2 == 'L') {
                jSONLexer.sp++;
                jSONLexer.next();
                z2 = z;
            } else if (c2 != 'F') {
                jSONLexer.sp++;
                jSONLexer.next();
            } else {
                if (c2 != 'e') {
                }
                jSONLexer.sp++;
                i2 = jSONLexer.bp + 1;
                jSONLexer.bp = i2;
                if (i2 >= jSONLexer.len) {
                    cCharAt = 26;
                } else {
                    cCharAt = jSONLexer.text.charAt(i2);
                }
                jSONLexer.ch = cCharAt;
                if (cCharAt != '+') {
                }
                jSONLexer.sp++;
                i3 = jSONLexer.bp + 1;
                jSONLexer.bp = i3;
                if (i3 >= jSONLexer.len) {
                    cCharAt2 = 26;
                } else {
                    cCharAt2 = jSONLexer.text.charAt(i3);
                }
                jSONLexer.ch = cCharAt2;
                c3 = jSONLexer.ch;
                if (c3 < '0') {
                }
                if (c3 != 'D') {
                    jSONLexer.sp++;
                    jSONLexer.next();
                } else {
                    jSONLexer.sp++;
                    jSONLexer.next();
                }
            }
            if (z2) {
                i = 3;
            } else {
                i = 2;
            }
            jSONLexer.token = i;
        }
        this.sp++;
        int i7 = i6 + 1;
        this.bp = i7;
        if (i7 < this.len) {
            jSONLexer = this;
            cCharAt4 = jSONLexer.text.charAt(i7);
            jSONLexer.ch = cCharAt4;
            c = jSONLexer.ch;
            if (c < '0' && c <= '9') {
                jSONLexer.sp++;
                int i8 = jSONLexer.bp + 1;
                jSONLexer.bp = i8;
                if (i8 < jSONLexer.len) {
                    cCharAt4 = jSONLexer.text.charAt(i8);
                }
                jSONLexer.ch = cCharAt4;
                c = jSONLexer.ch;
                if (c < '0') {
                }
                if (c == '.') {
                    jSONLexer.sp++;
                    i4 = jSONLexer.bp + 1;
                    jSONLexer.bp = i4;
                    if (i4 >= jSONLexer.len) {
                        cCharAt3 = 26;
                    } else {
                        cCharAt3 = jSONLexer.text.charAt(i5);
                    }
                    while (true) {
                        jSONLexer.ch = cCharAt3;
                        c4 = jSONLexer.ch;
                        if (c4 < '0') {
                        }
                        z = true;
                        cCharAt3 = jSONLexer.text.charAt(i5);
                    }
                } else {
                    z = false;
                }
                c2 = jSONLexer.ch;
                if (c2 == 'L') {
                    jSONLexer.sp++;
                    jSONLexer.next();
                    z2 = z;
                } else if (c2 != 'F') {
                    jSONLexer.sp++;
                    jSONLexer.next();
                } else {
                    if (c2 != 'e') {
                    }
                    jSONLexer.sp++;
                    i2 = jSONLexer.bp + 1;
                    jSONLexer.bp = i2;
                    if (i2 >= jSONLexer.len) {
                        cCharAt = 26;
                    } else {
                        cCharAt = jSONLexer.text.charAt(i2);
                    }
                    jSONLexer.ch = cCharAt;
                    if (cCharAt != '+') {
                    }
                    jSONLexer.sp++;
                    i3 = jSONLexer.bp + 1;
                    jSONLexer.bp = i3;
                    if (i3 >= jSONLexer.len) {
                        cCharAt2 = 26;
                    } else {
                        cCharAt2 = jSONLexer.text.charAt(i3);
                    }
                    jSONLexer.ch = cCharAt2;
                    c3 = jSONLexer.ch;
                    if (c3 < '0') {
                    }
                    if (c3 != 'D') {
                        jSONLexer.sp++;
                        jSONLexer.next();
                    } else {
                        jSONLexer.sp++;
                        jSONLexer.next();
                    }
                }
                if (z2) {
                    i = 3;
                } else {
                    i = 2;
                }
                jSONLexer.token = i;
            }
            if (c == '.') {
                jSONLexer.sp++;
                i4 = jSONLexer.bp + 1;
                jSONLexer.bp = i4;
                if (i4 >= jSONLexer.len) {
                    cCharAt3 = 26;
                } else {
                    cCharAt3 = jSONLexer.text.charAt(i5);
                }
                while (true) {
                    jSONLexer.ch = cCharAt3;
                    c4 = jSONLexer.ch;
                    if (c4 < '0' && c4 <= '9') {
                        jSONLexer.sp++;
                        i5 = jSONLexer.bp + 1;
                        jSONLexer.bp = i5;
                        if (i5 >= jSONLexer.len) {
                            cCharAt3 = 26;
                        } else {
                            cCharAt3 = jSONLexer.text.charAt(i5);
                        }
                        jSONLexer.ch = cCharAt3;
                        c4 = jSONLexer.ch;
                        if (c4 < '0') {
                        }
                    }
                    z = true;
                }
            } else {
                z = false;
            }
            c2 = jSONLexer.ch;
            if (c2 == 'L' && c2 != 'S' && c2 != 'B') {
                if (c2 != 'F' || c2 == 'D') {
                    jSONLexer.sp++;
                    jSONLexer.next();
                } else if (c2 != 'e' || c2 == 'E') {
                    jSONLexer.sp++;
                    i2 = jSONLexer.bp + 1;
                    jSONLexer.bp = i2;
                    if (i2 >= jSONLexer.len) {
                        cCharAt = 26;
                    } else {
                        cCharAt = jSONLexer.text.charAt(i2);
                    }
                    jSONLexer.ch = cCharAt;
                    if (cCharAt != '+' || cCharAt == '-') {
                        jSONLexer.sp++;
                        i3 = jSONLexer.bp + 1;
                        jSONLexer.bp = i3;
                        if (i3 >= jSONLexer.len) {
                            cCharAt2 = 26;
                        } else {
                            cCharAt2 = jSONLexer.text.charAt(i3);
                        }
                        jSONLexer.ch = cCharAt2;
                        c3 = jSONLexer.ch;
                        if (c3 < '0' && c3 <= '9') {
                            jSONLexer.sp++;
                            i3 = jSONLexer.bp + 1;
                            jSONLexer.bp = i3;
                            if (i3 >= jSONLexer.len) {
                                cCharAt2 = 26;
                            } else {
                                cCharAt2 = jSONLexer.text.charAt(i3);
                            }
                            jSONLexer.ch = cCharAt2;
                            c3 = jSONLexer.ch;
                            if (c3 < '0') {
                            }
                            if (c3 != 'D') {
                                jSONLexer.sp++;
                                jSONLexer.next();
                            } else {
                                jSONLexer.sp++;
                                jSONLexer.next();
                            }
                        } else if (c3 != 'D' || c3 == 'F') {
                            jSONLexer.sp++;
                            jSONLexer.next();
                        }
                    } else {
                        c3 = jSONLexer.ch;
                        if (c3 < '0') {
                        }
                        if (c3 != 'D') {
                            jSONLexer.sp++;
                            jSONLexer.next();
                        } else {
                            jSONLexer.sp++;
                            jSONLexer.next();
                        }
                    }
                }
                if (z2) {
                    i = 3;
                } else {
                    i = 2;
                }
                jSONLexer.token = i;
            }
            jSONLexer.sp++;
            jSONLexer.next();
            z2 = z;
            if (z2) {
                i = 3;
            } else {
                i = 2;
            }
            jSONLexer.token = i;
        }
        jSONLexer = this;
        cCharAt4 = 26;
        jSONLexer.ch = cCharAt4;
        c = jSONLexer.ch;
        if (c < '0') {
        }
        if (c == '.') {
            jSONLexer.sp++;
            i4 = jSONLexer.bp + 1;
            jSONLexer.bp = i4;
            if (i4 >= jSONLexer.len) {
                cCharAt3 = 26;
            } else {
                cCharAt3 = jSONLexer.text.charAt(i5);
            }
            while (true) {
                jSONLexer.ch = cCharAt3;
                c4 = jSONLexer.ch;
                if (c4 < '0') {
                }
                z = true;
                cCharAt3 = jSONLexer.text.charAt(i5);
            }
        } else {
            z = false;
        }
        c2 = jSONLexer.ch;
        if (c2 == 'L') {
            jSONLexer.sp++;
            jSONLexer.next();
            z2 = z;
        } else if (c2 != 'F') {
            jSONLexer.sp++;
            jSONLexer.next();
        } else {
            if (c2 != 'e') {
            }
            jSONLexer.sp++;
            i2 = jSONLexer.bp + 1;
            jSONLexer.bp = i2;
            if (i2 >= jSONLexer.len) {
                cCharAt = 26;
            } else {
                cCharAt = jSONLexer.text.charAt(i2);
            }
            jSONLexer.ch = cCharAt;
            if (cCharAt != '+') {
            }
            jSONLexer.sp++;
            i3 = jSONLexer.bp + 1;
            jSONLexer.bp = i3;
            if (i3 >= jSONLexer.len) {
                cCharAt2 = 26;
            } else {
                cCharAt2 = jSONLexer.text.charAt(i3);
            }
            jSONLexer.ch = cCharAt2;
            c3 = jSONLexer.ch;
            if (c3 < '0') {
            }
            if (c3 != 'D') {
                jSONLexer.sp++;
                jSONLexer.next();
            } else {
                jSONLexer.sp++;
                jSONLexer.next();
            }
        }
        if (z2) {
            i = 3;
        } else {
            i = 2;
        }
        jSONLexer.token = i;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0101 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ee A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:76:0x014d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x015d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0162 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x0167  */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0147, code lost:
    
        r4 = 26;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00fc -> B:53:0x00fe). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x015b -> B:72:0x0141). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Number scanNumberValue() {
        long j;
        boolean z;
        char c;
        Number numberValueOf;
        JSONLexer jSONLexer;
        boolean z2;
        int i;
        char cCharAt;
        char c2;
        char c3;
        char c4;
        char cCharAt2;
        int i2;
        int i3 = this.bp;
        this.np = 0;
        boolean z3 = true;
        if (this.ch == '-') {
            this.np = 0 + 1;
            int i4 = i3 + 1;
            this.bp = i4;
            this.ch = i4 >= this.len ? (char) 26 : this.text.charAt(i4);
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        long j2 = 0;
        boolean z4 = false;
        while (true) {
            c = this.ch;
            if (c < '0' || c > '9') {
                break;
            }
            int i5 = c - '0';
            if (j2 < com.airbnb.lottie.parser.moshi.a.b) {
                z4 = true;
            }
            long j3 = j2 * 10;
            long j4 = i5;
            if (j3 < j + j4) {
                z4 = true;
            }
            j2 = j3 - j4;
            this.np++;
            int i6 = this.bp + 1;
            this.bp = i6;
            this.ch = i6 >= this.len ? (char) 26 : this.text.charAt(i6);
        }
        if (!z) {
            j2 = -j2;
        }
        if (c == 'L') {
            this.np++;
            next();
            numberValueOf = Long.valueOf(j2);
        } else if (c == 'S') {
            this.np++;
            next();
            numberValueOf = Short.valueOf((short) j2);
        } else if (c == 'B') {
            this.np++;
            next();
            numberValueOf = Byte.valueOf((byte) j2);
        } else if (c == 'F') {
            this.np++;
            next();
            numberValueOf = Float.valueOf(j2);
        } else if (c == 'D') {
            this.np++;
            next();
            numberValueOf = Double.valueOf(j2);
        } else {
            numberValueOf = null;
        }
        if (this.ch == '.') {
            this.np++;
            int i7 = this.bp + 1;
            this.bp = i7;
            if (i7 >= this.len) {
                jSONLexer = this;
            } else {
                jSONLexer = this;
                cCharAt2 = jSONLexer.text.charAt(i7);
                while (true) {
                    jSONLexer.ch = cCharAt2;
                    if (cCharAt2 < '0' && cCharAt2 <= '9') {
                        jSONLexer.np++;
                        i2 = jSONLexer.bp + 1;
                        jSONLexer.bp = i2;
                        if (i2 < jSONLexer.len) {
                            cCharAt2 = jSONLexer.text.charAt(i2);
                        }
                        jSONLexer.ch = cCharAt2;
                        if (cCharAt2 < '0') {
                        }
                    }
                    z2 = true;
                }
            }
            cCharAt2 = 26;
            while (true) {
                jSONLexer.ch = cCharAt2;
                if (cCharAt2 < '0') {
                }
                z2 = true;
                cCharAt2 = jSONLexer.text.charAt(i2);
            }
        } else {
            jSONLexer = this;
            z2 = false;
        }
        char c5 = jSONLexer.ch;
        if (c5 == 'e' || c5 == 'E') {
            jSONLexer.np++;
            int i8 = jSONLexer.bp + 1;
            jSONLexer.bp = i8;
            char cCharAt3 = i8 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i8);
            jSONLexer.ch = cCharAt3;
            if (cCharAt3 == '+' || cCharAt3 == '-') {
                jSONLexer.np++;
                i = jSONLexer.bp + 1;
                jSONLexer.bp = i;
                if (i >= jSONLexer.len) {
                    cCharAt = 26;
                }
                jSONLexer.ch = cCharAt;
                c2 = jSONLexer.ch;
                if (c2 >= '0' || c2 > '9') {
                    if (c2 != 'D' || c2 == 'F') {
                        jSONLexer.np++;
                        jSONLexer.next();
                        c3 = c2;
                    } else {
                        c3 = 0;
                    }
                    c4 = c3;
                } else {
                    jSONLexer.np++;
                    i = jSONLexer.bp + 1;
                    jSONLexer.bp = i;
                    if (i >= jSONLexer.len) {
                        cCharAt = 26;
                    }
                    jSONLexer.ch = cCharAt;
                    c2 = jSONLexer.ch;
                    if (c2 >= '0') {
                    }
                    if (c2 != 'D') {
                        jSONLexer.np++;
                        jSONLexer.next();
                        c3 = c2;
                    } else {
                        jSONLexer.np++;
                        jSONLexer.next();
                        c3 = c2;
                    }
                    c4 = c3;
                }
            } else {
                c2 = jSONLexer.ch;
                if (c2 >= '0') {
                }
                if (c2 != 'D') {
                    jSONLexer.np++;
                    jSONLexer.next();
                    c3 = c2;
                } else {
                    jSONLexer.np++;
                    jSONLexer.next();
                    c3 = c2;
                }
                c4 = c3;
            }
            cCharAt = jSONLexer.text.charAt(i);
            jSONLexer.ch = cCharAt;
            c2 = jSONLexer.ch;
            if (c2 >= '0') {
            }
            if (c2 != 'D') {
                jSONLexer.np++;
                jSONLexer.next();
                c3 = c2;
            } else {
                jSONLexer.np++;
                jSONLexer.next();
                c3 = c2;
            }
            c4 = c3;
        } else {
            c4 = 0;
            z3 = false;
        }
        if (!z2 && !z3) {
            if (z4) {
                int i9 = jSONLexer.bp;
                char[] cArr = new char[i9 - i3];
                jSONLexer.text.getChars(i3, i9, cArr, 0);
                numberValueOf = new BigInteger(new String(cArr));
            }
            if (numberValueOf == null) {
                return (j2 <= -2147483648L || j2 >= 2147483647L) ? Long.valueOf(j2) : Integer.valueOf((int) j2);
            }
            return numberValueOf;
        }
        int i10 = jSONLexer.bp - i3;
        if (c4 != 0) {
            i10--;
        }
        char[] cArr2 = new char[i10];
        jSONLexer.text.getChars(i3, i10 + i3, cArr2, 0);
        if (!z3 && (jSONLexer.features & Feature.UseBigDecimal.mask) != 0) {
            return new BigDecimal(cArr2);
        }
        String str = new String(cArr2);
        try {
            return c4 == 'F' ? Float.valueOf(str) : Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            throw new JSONException(e.getMessage() + ", " + jSONLexer.info(), e);
        }
    }

    public final void scanString() {
        char c = this.ch;
        int i = this.bp + 1;
        int iIndexOf = this.text.indexOf(c, i);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + info());
        }
        int i2 = iIndexOf - i;
        char[] cArrSub_chars = sub_chars(this.bp + 1, i2);
        boolean z = false;
        while (i2 > 0 && cArrSub_chars[i2 - 1] == '\\') {
            int i3 = 1;
            for (int i4 = i2 - 2; i4 >= 0 && cArrSub_chars[i4] == '\\'; i4--) {
                i3++;
            }
            if (i3 % 2 == 0) {
                break;
            }
            int iIndexOf2 = this.text.indexOf(c, iIndexOf + 1);
            int i5 = (iIndexOf2 - iIndexOf) + i2;
            if (i5 >= cArrSub_chars.length) {
                int length = (cArrSub_chars.length * 3) / 2;
                if (length < i5) {
                    length = i5;
                }
                char[] cArr = new char[length];
                System.arraycopy(cArrSub_chars, 0, cArr, 0, cArrSub_chars.length);
                cArrSub_chars = cArr;
            }
            this.text.getChars(iIndexOf, iIndexOf2, cArrSub_chars, i2);
            iIndexOf = iIndexOf2;
            i2 = i5;
            z = true;
        }
        if (!z) {
            for (int i6 = 0; i6 < i2; i6++) {
                if (cArrSub_chars[i6] == '\\') {
                    z = true;
                }
            }
        }
        this.sbuf = cArrSub_chars;
        this.sp = i2;
        this.np = this.bp;
        this.hasSpecial = z;
        int i7 = iIndexOf + 1;
        this.bp = i7;
        this.ch = i7 >= this.len ? (char) 26 : this.text.charAt(i7);
        this.token = 4;
    }

    public String scanStringValue(char c) {
        String str;
        int i = this.bp + 1;
        int iIndexOf = this.text.indexOf(c, i);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + info());
        }
        if (V6) {
            str = this.text.substring(i, iIndexOf);
        } else {
            int i2 = iIndexOf - i;
            str = new String(sub_chars(this.bp + 1, i2), 0, i2);
        }
        if (str.indexOf(92) != -1) {
            while (true) {
                int i3 = 0;
                for (int i4 = iIndexOf - 1; i4 >= 0 && this.text.charAt(i4) == '\\'; i4--) {
                    i3++;
                }
                if (i3 % 2 == 0) {
                    break;
                }
                iIndexOf = this.text.indexOf(c, iIndexOf + 1);
            }
            int i5 = iIndexOf - i;
            str = readString(sub_chars(this.bp + 1, i5), i5);
        }
        int i6 = iIndexOf + 1;
        this.bp = i6;
        this.ch = i6 >= this.len ? (char) 26 : this.text.charAt(i6);
        return str;
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c;
        while (true) {
            c = this.ch;
            if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b') {
                break;
            }
            next();
        }
        if (c == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c == '\'') {
            if ((this.features & Feature.AllowSingleQuotes.mask) != 0) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        }
        if (c == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c == 26) {
            this.token = 20;
            return null;
        }
        if ((this.features & Feature.AllowUnQuotedFieldNames.mask) != 0) {
            return scanSymbolUnQuoted(symbolTable);
        }
        throw new JSONException("syntax error");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    public String scanSymbol(SymbolTable symbolTable, char c) {
        String string;
        int i = this.bp + 1;
        int iIndexOf = this.text.indexOf(c, i);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + info());
        }
        int i2 = iIndexOf - i;
        char[] cArrSub_chars = sub_chars(this.bp + 1, i2);
        boolean z = false;
        while (i2 > 0 && cArrSub_chars[i2 - 1] == '\\') {
            int i3 = 1;
            for (int i4 = i2 - 2; i4 >= 0 && cArrSub_chars[i4] == '\\'; i4--) {
                i3++;
            }
            if (i3 % 2 == 0) {
                break;
            }
            int iIndexOf2 = this.text.indexOf(c, iIndexOf + 1);
            int i5 = (iIndexOf2 - iIndexOf) + i2;
            if (i5 >= cArrSub_chars.length) {
                int length = (cArrSub_chars.length * 3) / 2;
                if (length < i5) {
                    length = i5;
                }
                char[] cArr = new char[length];
                System.arraycopy(cArrSub_chars, 0, cArr, 0, cArrSub_chars.length);
                cArrSub_chars = cArr;
            }
            this.text.getChars(iIndexOf, iIndexOf2, cArrSub_chars, i2);
            iIndexOf = iIndexOf2;
            i2 = i5;
            z = true;
        }
        if (z) {
            string = readString(cArrSub_chars, i2);
        } else {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                char c2 = cArrSub_chars[i7];
                i6 = (i6 * 31) + c2;
                if (c2 == '\\') {
                    z = true;
                }
            }
            if (z) {
                string = readString(cArrSub_chars, i2);
            } else {
                string = i2 < 20 ? symbolTable.addSymbol(cArrSub_chars, 0, i2, i6) : new String(cArrSub_chars, 0, i2);
            }
        }
        int i8 = iIndexOf + 1;
        this.bp = i8;
        this.ch = i8 >= this.len ? (char) 26 : this.text.charAt(i8);
        return string;
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i = this.ch;
        boolean[] zArr = firstIdentifierFlags;
        if (!(i >= zArr.length || zArr[i])) {
            throw new JSONException("illegal identifier : " + this.ch + ", " + info());
        }
        this.np = this.bp;
        this.sp = 1;
        while (true) {
            char next = next();
            boolean[] zArr2 = identifierFlags;
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i = (i * 31) + next;
            this.sp++;
        }
        this.ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && this.text.startsWith("null", this.np)) {
            return null;
        }
        return symbolTable.addSymbol(this.text, this.np, this.sp, i);
    }

    public void skipComment() {
        next();
        char c = this.ch;
        if (c == '/') {
            do {
                next();
            } while (this.ch != '\n');
            next();
        } else {
            if (c != '*') {
                throw new JSONException("invalid comment");
            }
            while (true) {
                next();
                while (true) {
                    char c2 = this.ch;
                    if (c2 == 26) {
                        return;
                    }
                    if (c2 == '*') {
                        next();
                        if (this.ch == '/') {
                            next();
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void skipWhitespace() {
        while (true) {
            char c = this.ch;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                next();
            } else if (c != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringVal() {
        return this.hasSpecial ? readString(this.sbuf, this.sp) : subString(this.np + 1, this.sp);
    }

    public final char[] sub_chars(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i2 + i, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i2];
        this.sbuf = cArr2;
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public final int token() {
        return this.token;
    }

    public final String tokenName() {
        return JSONToken.name(this.token);
    }
}
