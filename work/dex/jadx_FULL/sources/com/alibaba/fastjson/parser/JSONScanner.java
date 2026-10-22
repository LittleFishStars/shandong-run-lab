package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.common.net.c;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '0' && c <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
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

    private boolean checkTime(char c, char c2, char c3, char c4, char c5, char c6) {
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

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token != 26) {
            return !this.hasSpecial ? IOUtils.decodeBase64(this.text, this.np + 1, this.sp) : IOUtils.decodeBase64(new String(this.sbuf, 0, this.sp));
        }
        int i = this.np + 1;
        int i2 = this.sp;
        if (i2 % 2 != 0) {
            throw new JSONException("illegal state. " + i2);
        }
        int i3 = i2 / 2;
        byte[] bArr = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i4 * 2) + i;
            char cCharAt = this.text.charAt(i5);
            char cCharAt2 = this.text.charAt(i5 + 1);
            char c = '0';
            int i6 = cCharAt - (cCharAt <= '9' ? '0' : '7');
            if (cCharAt2 > '9') {
                c = '7';
            }
            bArr[i4] = (byte) ((i6 << 4) | (cCharAt2 - c));
        }
        return bArr;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        if (i >= this.len) {
            return (char) 26;
        }
        return this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char cCharAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i--;
        }
        if (i > 65535) {
            throw new JSONException("decimal overflow");
        }
        int i2 = this.np;
        char[] cArr = this.sbuf;
        if (i < cArr.length) {
            this.text.getChars(i2, i2 + i, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i, MathContext.UNLIMITED);
        }
        char[] cArr2 = new char[i];
        this.text.getChars(i2, i2 + i, cArr2, 0);
        return new BigDecimal(cArr2, 0, i, MathContext.UNLIMITED);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (i3 < this.bp) {
            if (this.text.charAt(i3) == '\n') {
                i++;
                i2 = 1;
            }
            i3++;
            i2++;
        }
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", line ");
        sb.append(i);
        sb.append(", column ");
        sb.append(i2);
        if (this.text.length() < 65535) {
            sb.append(this.text);
        } else {
            sb.append(this.text.substring(0, 65535));
        }
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int i = this.bp;
        int i2 = this.len;
        if (i != i2) {
            return this.ch == 26 && i + 1 >= i2;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        while (JSONLexerBase.isWhitespace(this.ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char cCharAt = this.text.charAt(length);
        while (JSONLexerBase.isWhitespace(cCharAt)) {
            cCharAt = this.text.charAt(i);
            i++;
        }
        if (cCharAt != ':') {
            this.matchStat = -2;
            return false;
        }
        this.bp = i;
        this.ch = charAt(i);
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        char cCharAt = i >= this.len ? (char) 26 : this.text.charAt(i);
        this.ch = cCharAt;
        return cCharAt;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char cCharAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c) {
        char cCharAt;
        long j;
        Date date;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c2 = this.ch;
        int i3 = i2 + 1;
        char cCharAt2 = charAt(i2);
        if (cCharAt2 == '\"') {
            int iIndexOf = indexOf('\"', i3);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.bp = i3;
            if (!scanISO8601DateIfMatch(false, iIndexOf - i3)) {
                this.bp = i2;
                this.ch = c2;
                this.matchStat = -1;
                return null;
            }
            date = this.calendar.getTime();
            cCharAt = charAt(iIndexOf + 1);
            this.bp = i2;
            while (cCharAt != ',' && cCharAt != ']') {
                if (!JSONLexerBase.isWhitespace(cCharAt)) {
                    this.bp = i2;
                    this.ch = c2;
                    this.matchStat = -1;
                    return null;
                }
                iIndexOf++;
                cCharAt = charAt(iIndexOf + 1);
            }
            this.bp = iIndexOf + 1;
            this.ch = cCharAt;
        } else {
            char c3 = '9';
            if (cCharAt2 != '-' && (cCharAt2 < '0' || cCharAt2 > '9')) {
                if (cCharAt2 == 'n') {
                    int i4 = i3 + 1;
                    if (charAt(i3) == 'u') {
                        int i5 = i4 + 1;
                        if (charAt(i4) == 'l') {
                            int i6 = i5 + 1;
                            if (charAt(i5) == 'l') {
                                cCharAt = charAt(i6);
                                this.bp = i6;
                                date = null;
                            }
                        }
                    }
                }
                this.bp = i2;
                this.ch = c2;
                this.matchStat = -1;
                return null;
            }
            if (cCharAt2 == '-') {
                cCharAt2 = charAt(i3);
                i3++;
                z = true;
            }
            if (cCharAt2 < '0' || cCharAt2 > '9') {
                cCharAt = cCharAt2;
                j = 0;
            } else {
                j = cCharAt2 - '0';
                while (true) {
                    i = i3 + 1;
                    cCharAt = charAt(i3);
                    if (cCharAt < '0' || cCharAt > c3) {
                        break;
                    }
                    j = (j * 10) + ((long) (cCharAt - '0'));
                    i3 = i;
                    c3 = '9';
                }
                if (cCharAt == ',' || cCharAt == ']') {
                    this.bp = i - 1;
                }
            }
            if (j < 0) {
                this.bp = i2;
                this.ch = c2;
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        }
        if (cCharAt == ',') {
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 3;
            return date;
        }
        int i8 = this.bp + 1;
        this.bp = i8;
        char cCharAt3 = charAt(i8);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else {
            if (cCharAt3 != 26) {
                this.bp = i2;
                this.ch = c2;
                this.matchStat = -1;
                return null;
            }
            this.ch = (char) 26;
            this.token = 20;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00c0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00c4 -> B:52:0x00b4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char r22) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanDouble(char):double");
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0166  */
    /* JADX WARN: Code duplicated, block: B:103:0x016c A[LOOP:0: B:78:0x00ed->B:103:0x016c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0163 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x014b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0104  */
    /* JADX WARN: Code duplicated, block: B:86:0x0121  */
    /* JADX WARN: Code duplicated, block: B:89:0x0135 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0147  */
    /* JADX WARN: Code duplicated, block: B:96:0x0153  */
    /* JADX WARN: Code duplicated, block: B:98:0x0159 A[LOOP:1: B:84:0x0111->B:98:0x0159, LOOP_END] */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean scanFieldBoolean(char[] cArr) {
        char cCharAt;
        boolean z;
        char cCharAt2;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int i = this.bp;
        int length = cArr.length + i;
        int i2 = length + 1;
        char cCharAt3 = charAt(length);
        boolean z2 = cCharAt3 == '\"';
        if (z2) {
            int i3 = i2 + 1;
            char cCharAt4 = charAt(i2);
            i2 = i3;
            cCharAt3 = cCharAt4;
        }
        if (cCharAt3 != 't') {
            if (cCharAt3 == 'f') {
                int i4 = i2 + 1;
                if (charAt(i2) != 'a') {
                    this.matchStat = -1;
                    return false;
                }
                int i5 = i4 + 1;
                if (charAt(i4) != 'l') {
                    this.matchStat = -1;
                    return false;
                }
                int i6 = i5 + 1;
                if (charAt(i5) != 's') {
                    this.matchStat = -1;
                    return false;
                }
                int i7 = i6 + 1;
                if (charAt(i6) != 'e') {
                    this.matchStat = -1;
                    return false;
                }
                if (z2) {
                    int i8 = i7 + 1;
                    if (charAt(i7) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i7 = i8;
                }
                this.bp = i7;
                cCharAt = charAt(i7);
            } else if (cCharAt3 == '1') {
                if (z2) {
                    int i9 = i2 + 1;
                    if (charAt(i2) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i2 = i9;
                }
                this.bp = i2;
                cCharAt = charAt(i2);
            } else {
                if (cCharAt3 != '0') {
                    this.matchStat = -1;
                    return false;
                }
                if (z2) {
                    int i10 = i2 + 1;
                    if (charAt(i2) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i2 = i10;
                }
                this.bp = i2;
                cCharAt = charAt(i2);
            }
            z = false;
            while (cCharAt != ',') {
                if (cCharAt == '}') {
                    int i11 = this.bp + 1;
                    this.bp = i11;
                    cCharAt2 = charAt(i11);
                    while (cCharAt2 != ',') {
                        if (cCharAt2 == ']') {
                            this.token = 15;
                            int i12 = this.bp + 1;
                            this.bp = i12;
                            this.ch = charAt(i12);
                        } else if (cCharAt2 == '}') {
                            this.token = 13;
                            int i13 = this.bp + 1;
                            this.bp = i13;
                            this.ch = charAt(i13);
                        } else if (cCharAt2 == 26) {
                            this.token = 20;
                        } else {
                            if (JSONLexerBase.isWhitespace(cCharAt2)) {
                                this.matchStat = -1;
                                return false;
                            }
                            int i14 = this.bp + 1;
                            this.bp = i14;
                            cCharAt2 = charAt(i14);
                        }
                        this.matchStat = 4;
                        return z;
                    }
                    this.token = 16;
                    int i15 = this.bp + 1;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    this.matchStat = 4;
                    return z;
                }
                if (JSONLexerBase.isWhitespace(cCharAt)) {
                    this.bp = i;
                    charAt(i);
                    this.matchStat = -1;
                    return false;
                }
                int i16 = this.bp + 1;
                this.bp = i16;
                cCharAt = charAt(i16);
            }
            int i17 = this.bp + 1;
            this.bp = i17;
            this.ch = charAt(i17);
            this.matchStat = 3;
            this.token = 16;
            return z;
        }
        int i18 = i2 + 1;
        if (charAt(i2) != 'r') {
            this.matchStat = -1;
            return false;
        }
        int i19 = i18 + 1;
        if (charAt(i18) != 'u') {
            this.matchStat = -1;
            return false;
        }
        int i20 = i19 + 1;
        if (charAt(i19) != 'e') {
            this.matchStat = -1;
            return false;
        }
        if (z2) {
            int i21 = i20 + 1;
            if (charAt(i20) != '\"') {
                this.matchStat = -1;
                return false;
            }
            i20 = i21;
        }
        this.bp = i20;
        cCharAt = charAt(i20);
        z = true;
        while (cCharAt != ',') {
            if (cCharAt == '}') {
                int i110 = this.bp + 1;
                this.bp = i110;
                cCharAt2 = charAt(i110);
                while (cCharAt2 != ',') {
                    if (cCharAt2 == ']') {
                        this.token = 15;
                        int i111 = this.bp + 1;
                        this.bp = i111;
                        this.ch = charAt(i111);
                    } else if (cCharAt2 == '}') {
                        this.token = 13;
                        int i112 = this.bp + 1;
                        this.bp = i112;
                        this.ch = charAt(i112);
                    } else if (cCharAt2 == 26) {
                        this.token = 20;
                    } else {
                        if (JSONLexerBase.isWhitespace(cCharAt2)) {
                            this.matchStat = -1;
                            return false;
                        }
                        int i113 = this.bp + 1;
                        this.bp = i113;
                        cCharAt2 = charAt(i113);
                    }
                    this.matchStat = 4;
                    return z;
                }
                this.token = 16;
                int i114 = this.bp + 1;
                this.bp = i114;
                this.ch = charAt(i114);
                this.matchStat = 4;
                return z;
            }
            if (JSONLexerBase.isWhitespace(cCharAt)) {
                this.bp = i;
                charAt(i);
                this.matchStat = -1;
                return false;
            }
            int i115 = this.bp + 1;
            this.bp = i115;
            cCharAt = charAt(i115);
        }
        int i116 = this.bp + 1;
        this.bp = i116;
        this.ch = charAt(i116);
        this.matchStat = 3;
        this.token = 16;
        return z;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        char cCharAt;
        long j;
        char cCharAt2;
        Date date;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char cCharAt3 = charAt(length);
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', i3);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.bp = i3;
            if (!scanISO8601DateIfMatch(false, iIndexOf - i3)) {
                this.bp = i2;
                this.matchStat = -1;
                return null;
            }
            date = this.calendar.getTime();
            cCharAt2 = charAt(iIndexOf + 1);
            this.bp = i2;
            while (cCharAt2 != ',' && cCharAt2 != '}') {
                if (!JSONLexerBase.isWhitespace(cCharAt2)) {
                    this.matchStat = -1;
                    return null;
                }
                iIndexOf++;
                cCharAt2 = charAt(iIndexOf + 1);
            }
            this.bp = iIndexOf + 1;
            this.ch = cCharAt2;
        } else {
            char c2 = '9';
            char c3 = '0';
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(i3);
                i3++;
                z = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                cCharAt = cCharAt3;
                j = 0;
            } else {
                j = cCharAt3 - '0';
                while (true) {
                    i = i3 + 1;
                    cCharAt = charAt(i3);
                    if (cCharAt < c3 || cCharAt > c2) {
                        break;
                    }
                    j = (j * 10) + ((long) (cCharAt - '0'));
                    i3 = i;
                    c2 = '9';
                    c3 = '0';
                }
                if (cCharAt == ',' || cCharAt == '}') {
                    this.bp = i - 1;
                }
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            cCharAt2 = cCharAt;
            date = new Date(j);
        }
        if (cCharAt2 == ',') {
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i5 = this.bp + 1;
        this.bp = i5;
        char cCharAt4 = charAt(i5);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i6 = this.bp + 1;
            this.bp = i6;
            this.ch = charAt(i6);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else {
            if (cCharAt4 != 26) {
                this.bp = i2;
                this.ch = c;
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] cArr) {
        int i;
        char cCharAt;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char cCharAt2 = charAt(length);
        boolean z = cCharAt2 == '\"';
        if (z) {
            cCharAt2 = charAt(i3);
            i3++;
        }
        boolean z2 = cCharAt2 == '-';
        if (z2) {
            cCharAt2 = charAt(i3);
            i3++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i4 = cCharAt2 - '0';
        while (true) {
            i = i3 + 1;
            cCharAt = charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            int i5 = i4 * 10;
            if (i5 < i4) {
                this.matchStat = -1;
                return 0;
            }
            i4 = i5 + (cCharAt - '0');
            i3 = i;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (i4 < 0) {
            this.matchStat = -1;
            return 0;
        }
        if (z) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            int i6 = i + 1;
            char cCharAt3 = charAt(i);
            i = i6;
            cCharAt = cCharAt3;
        }
        while (cCharAt != ',' && cCharAt != '}') {
            if (!JSONLexerBase.isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return 0;
            }
            int i7 = i + 1;
            char cCharAt4 = charAt(i);
            i = i7;
            cCharAt = cCharAt4;
        }
        int i8 = i - 1;
        this.bp = i8;
        if (cCharAt == ',') {
            int i9 = i8 + 1;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            this.token = 16;
            return z2 ? -i4 : i4;
        }
        if (cCharAt == '}') {
            int i10 = i8 + 1;
            this.bp = i10;
            char cCharAt5 = charAt(i10);
            while (true) {
                if (cCharAt5 == ',') {
                    this.token = 16;
                    int i11 = this.bp + 1;
                    this.bp = i11;
                    this.ch = charAt(i11);
                    break;
                }
                if (cCharAt5 == ']') {
                    this.token = 15;
                    int i12 = this.bp + 1;
                    this.bp = i12;
                    this.ch = charAt(i12);
                    break;
                }
                if (cCharAt5 == '}') {
                    this.token = 13;
                    int i13 = this.bp + 1;
                    this.bp = i13;
                    this.ch = charAt(i13);
                    break;
                }
                if (cCharAt5 == 26) {
                    this.token = 20;
                    break;
                }
                if (!JSONLexerBase.isWhitespace(cCharAt5)) {
                    this.bp = i2;
                    this.ch = c;
                    this.matchStat = -1;
                    return 0;
                }
                int i14 = this.bp + 1;
                this.bp = i14;
                cCharAt5 = charAt(i14);
            }
            this.matchStat = 4;
        }
        return z2 ? -i4 : i4;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char cCharAt;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char cCharAt2 = charAt(length);
        boolean z2 = cCharAt2 == '\"';
        if (z2) {
            cCharAt2 = charAt(i3);
            i3++;
        }
        if (cCharAt2 == '-') {
            z = true;
            cCharAt2 = charAt(i3);
            i3++;
        } else {
            z = false;
        }
        if (cCharAt2 >= '0') {
            char c2 = '9';
            if (cCharAt2 <= '9') {
                long j = cCharAt2 - '0';
                while (true) {
                    i = i3 + 1;
                    cCharAt = charAt(i3);
                    if (cCharAt < '0' || cCharAt > c2) {
                        break;
                    }
                    j = (j * 10) + ((long) (cCharAt - '0'));
                    i3 = i;
                    c2 = '9';
                }
                if (cCharAt == '.') {
                    this.matchStat = -1;
                    return 0L;
                }
                if (z2) {
                    if (cCharAt != '\"') {
                        this.matchStat = -1;
                        return 0L;
                    }
                    int i4 = i + 1;
                    char cCharAt3 = charAt(i);
                    i = i4;
                    cCharAt = cCharAt3;
                }
                if (cCharAt == ',' || cCharAt == '}') {
                    this.bp = i - 1;
                }
                if (!(j >= 0 || (j == Long.MIN_VALUE && z))) {
                    this.bp = i2;
                    this.ch = c;
                    this.matchStat = -1;
                    return 0L;
                }
                while (cCharAt != ',') {
                    if (cCharAt == '}') {
                        int i5 = this.bp + 1;
                        this.bp = i5;
                        char cCharAt4 = charAt(i5);
                        while (true) {
                            if (cCharAt4 == ',') {
                                this.token = 16;
                                int i6 = this.bp + 1;
                                this.bp = i6;
                                this.ch = charAt(i6);
                                break;
                            }
                            if (cCharAt4 == ']') {
                                this.token = 15;
                                int i7 = this.bp + 1;
                                this.bp = i7;
                                this.ch = charAt(i7);
                                break;
                            }
                            if (cCharAt4 == '}') {
                                this.token = 13;
                                int i8 = this.bp + 1;
                                this.bp = i8;
                                this.ch = charAt(i8);
                                break;
                            }
                            if (cCharAt4 == 26) {
                                this.token = 20;
                                break;
                            }
                            if (!JSONLexerBase.isWhitespace(cCharAt4)) {
                                this.bp = i2;
                                this.ch = c;
                                this.matchStat = -1;
                                return 0L;
                            }
                            int i9 = this.bp + 1;
                            this.bp = i9;
                            cCharAt4 = charAt(i9);
                        }
                        this.matchStat = 4;
                        return z ? -j : j;
                    }
                    if (!JSONLexerBase.isWhitespace(cCharAt)) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.bp = i;
                    int i10 = i + 1;
                    char cCharAt5 = charAt(i);
                    i = i10;
                    cCharAt = cCharAt5;
                }
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
                this.matchStat = 3;
                this.token = 16;
                return z ? -j : j;
            }
        }
        this.bp = i2;
        this.ch = c;
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.bp;
        char c = this.ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (!JSONLexerBase.isWhitespace(this.ch)) {
                this.matchStat = -2;
                return stringDefaultValue();
            }
            next();
            while (JSONLexerBase.isWhitespace(this.ch)) {
                next();
            }
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        char cCharAt = charAt(length);
        int i3 = 0;
        if (cCharAt != '\"') {
            while (JSONLexerBase.isWhitespace(cCharAt)) {
                i3++;
                int i4 = i2 + 1;
                char cCharAt2 = charAt(i2);
                i2 = i4;
                cCharAt = cCharAt2;
            }
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int iIndexOf = indexOf('\"', i2);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        String strSubString = subString(i2, iIndexOf - i2);
        if (strSubString.indexOf(92) != -1) {
            while (true) {
                int i5 = 0;
                for (int i6 = iIndexOf - 1; i6 >= 0 && charAt(i6) == '\\'; i6--) {
                    i5++;
                }
                if (i5 % 2 == 0) {
                    break;
                }
                iIndexOf = indexOf('\"', iIndexOf + 1);
            }
            int i7 = this.bp;
            int length2 = iIndexOf - (((cArr.length + i7) + 1) + i3);
            strSubString = JSONLexerBase.readString(sub_chars(i7 + cArr.length + 1 + i3, length2), length2);
        }
        if ((this.features & Feature.TrimStringFieldValue.mask) != 0) {
            strSubString = strSubString.trim();
        }
        char cCharAt3 = charAt(iIndexOf + 1);
        while (cCharAt3 != ',' && cCharAt3 != '}') {
            if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            iIndexOf++;
            cCharAt3 = charAt(iIndexOf + 1);
        }
        int i8 = iIndexOf + 1;
        this.bp = i8;
        this.ch = cCharAt3;
        if (cCharAt3 == ',') {
            int i9 = i8 + 1;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            return strSubString;
        }
        int i10 = i8 + 1;
        this.bp = i10;
        char cCharAt4 = charAt(i10);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.ch = charAt(i12);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i13 = this.bp + 1;
            this.bp = i13;
            this.ch = charAt(i13);
        } else {
            if (cCharAt4 != 26) {
                this.bp = i;
                this.ch = c;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.token = 20;
        }
        this.matchStat = 4;
        return strSubString;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        int i;
        int i2;
        char cCharAt;
        Collection<String> collection;
        char cCharAt2;
        char cCharAt3;
        int i3;
        this.matchStat = 0;
        while (true) {
            char c = this.ch;
            if (c != '\n' && c != ' ') {
                break;
            }
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = i4 >= this.len ? (char) 26 : this.text.charAt(i4);
        }
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> collectionNewCollectionByType = newCollectionByType(cls);
        int i5 = this.bp;
        char c2 = this.ch;
        int length = cArr.length + i5;
        int i6 = length + 1;
        int i7 = -1;
        if (charAt(length) == '[') {
            int i8 = i6 + 1;
            char cCharAt4 = charAt(i6);
            while (true) {
                if (cCharAt4 == '\"') {
                    int iIndexOf = indexOf('\"', i8);
                    if (iIndexOf == i7) {
                        throw new JSONException("unclosed str");
                    }
                    String strSubString = subString(i8, iIndexOf - i8);
                    if (strSubString.indexOf(92) != i7) {
                        while (true) {
                            int i9 = 0;
                            for (int i10 = iIndexOf - 1; i10 >= 0 && charAt(i10) == '\\'; i10--) {
                                i9++;
                            }
                            if (i9 % 2 == 0) {
                                break;
                            }
                            iIndexOf = indexOf('\"', iIndexOf + 1);
                        }
                        int i11 = iIndexOf - i8;
                        strSubString = JSONLexerBase.readString(sub_chars(i8, i11), i11);
                    }
                    int i12 = iIndexOf + 1;
                    i3 = i12 + 1;
                    cCharAt3 = charAt(i12);
                    collectionNewCollectionByType.add(strSubString);
                } else {
                    if (cCharAt4 != 'n' || !this.text.startsWith("ull", i8)) {
                        if (cCharAt4 != ']' || collectionNewCollectionByType.size() != 0) {
                            this.matchStat = -1;
                            return null;
                        }
                        i2 = i8 + 1;
                        cCharAt2 = charAt(i8);
                        break;
                    }
                    int i13 = i8 + 3;
                    cCharAt3 = charAt(i13);
                    collectionNewCollectionByType.add(null);
                    i3 = i13 + 1;
                }
                if (cCharAt3 != ',') {
                    if (cCharAt3 != ']') {
                        this.matchStat = -1;
                        return null;
                    }
                    i2 = i3 + 1;
                    cCharAt2 = charAt(i3);
                    while (JSONLexerBase.isWhitespace(cCharAt2)) {
                        int i14 = i2 + 1;
                        char cCharAt5 = charAt(i2);
                        i2 = i14;
                        cCharAt2 = cCharAt5;
                    }
                    break;
                }
                cCharAt4 = charAt(i3);
                i8 = i3 + 1;
                i7 = -1;
            }
            collection = collectionNewCollectionByType;
            cCharAt = cCharAt2;
            i = 3;
        } else {
            if (!this.text.startsWith("ull", i6)) {
                this.matchStat = -1;
                return null;
            }
            i = 3;
            int i15 = i6 + 3;
            i2 = i15 + 1;
            cCharAt = charAt(i15);
            collection = null;
        }
        this.bp = i2;
        if (cCharAt == ',') {
            this.ch = charAt(i2);
            this.matchStat = i;
            return collection;
        }
        if (cCharAt != '}') {
            this.ch = c2;
            this.bp = i5;
            this.matchStat = -1;
            return null;
        }
        char cCharAt6 = charAt(i2);
        while (cCharAt6 != ',') {
            if (cCharAt6 == ']') {
                this.token = 15;
                int i16 = this.bp + 1;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (cCharAt6 == '}') {
                this.token = 13;
                int i17 = this.bp + 1;
                this.bp = i17;
                this.ch = charAt(i17);
            } else if (cCharAt6 == 26) {
                this.token = 20;
                this.ch = cCharAt6;
            } else {
                boolean z = false;
                while (JSONLexerBase.isWhitespace(cCharAt6)) {
                    int i18 = i2 + 1;
                    char cCharAt7 = charAt(i2);
                    this.bp = i18;
                    z = true;
                    cCharAt6 = cCharAt7;
                    i2 = i18;
                }
                if (!z) {
                    this.matchStat = -1;
                    return null;
                }
            }
            this.matchStat = 4;
            return collection;
        }
        this.token = 16;
        int i19 = this.bp + 1;
        this.bp = i19;
        this.ch = charAt(i19);
        this.matchStat = 4;
        return collection;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (!JSONLexerBase.isWhitespace(this.ch)) {
                this.matchStat = -2;
                return 0L;
            }
            next();
            while (JSONLexerBase.isWhitespace(this.ch)) {
                next();
            }
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char cCharAt = charAt(length);
        if (cCharAt != '\"') {
            while (JSONLexerBase.isWhitespace(cCharAt)) {
                cCharAt = charAt(i);
                i++;
            }
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0L;
            }
        }
        long j = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i2 = i + 1;
            char cCharAt2 = charAt(i);
            if (cCharAt2 == '\"') {
                this.bp = i2;
                char cCharAt3 = charAt(i2);
                this.ch = cCharAt3;
                while (cCharAt3 != ',') {
                    if (cCharAt3 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            this.ch = charAt(i3);
                        } else if (current == ']') {
                            this.token = 15;
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            this.ch = charAt(i4);
                        } else if (current == '}') {
                            this.token = 13;
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                        } else {
                            if (current != 26) {
                                this.matchStat = -1;
                                return 0L;
                            }
                            this.token = 20;
                        }
                        this.matchStat = 4;
                        return j;
                    }
                    if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    int i6 = this.bp + 1;
                    this.bp = i6;
                    cCharAt3 = charAt(i6);
                }
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return j;
            }
            if (i2 > this.len) {
                this.matchStat = -1;
                return 0L;
            }
            j = (j ^ ((long) cCharAt2)) * TypeUtils.fnv1a_64_magic_prime;
            i = i2;
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char c) {
        int i;
        char cCharAt;
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char cCharAt2 = charAt(i2);
        while (JSONLexerBase.isWhitespace(cCharAt2)) {
            cCharAt2 = charAt(i3);
            i3++;
        }
        boolean z = cCharAt2 == '\"';
        if (z) {
            cCharAt2 = charAt(i3);
            i3++;
        }
        boolean z2 = cCharAt2 == '-';
        if (z2) {
            cCharAt2 = charAt(i3);
            i3++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 == 'n') {
                int i4 = i3 + 1;
                if (charAt(i3) == 'u') {
                    int i5 = i4 + 1;
                    if (charAt(i4) == 'l') {
                        int i6 = i5 + 1;
                        if (charAt(i5) == 'l') {
                            this.matchStat = 5;
                            int i7 = i6 + 1;
                            char cCharAt3 = charAt(i6);
                            if (z && cCharAt3 == '\"') {
                                int i8 = i7 + 1;
                                char cCharAt4 = charAt(i7);
                                i7 = i8;
                                cCharAt3 = cCharAt4;
                            }
                            while (cCharAt3 != ',') {
                                if (cCharAt3 == ']') {
                                    this.bp = i7;
                                    this.ch = charAt(i7);
                                    this.matchStat = 5;
                                    this.token = 15;
                                    return 0;
                                }
                                if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                                    this.matchStat = -1;
                                    return 0;
                                }
                                int i9 = i7 + 1;
                                char cCharAt5 = charAt(i7);
                                i7 = i9;
                                cCharAt3 = cCharAt5;
                            }
                            this.bp = i7;
                            this.ch = charAt(i7);
                            this.matchStat = 5;
                            this.token = 16;
                            return 0;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return 0;
        }
        int i10 = cCharAt2 - '0';
        while (true) {
            i = i3 + 1;
            cCharAt = charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            int i11 = i10 * 10;
            if (i11 < i10) {
                throw new JSONException("parseInt error : " + subString(i2, i - 1));
            }
            i10 = i11 + (cCharAt - '0');
            i3 = i;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (z) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            cCharAt = charAt(i);
            i++;
        }
        if (i10 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (cCharAt != c) {
            if (!JSONLexerBase.isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return z2 ? -i10 : i10;
            }
            cCharAt = charAt(i);
            i++;
        }
        this.bp = i;
        this.ch = charAt(i);
        this.matchStat = 3;
        this.token = 16;
        return z2 ? -i10 : i10;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        char cCharAt;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char cCharAt2 = charAt(i2);
        boolean z2 = cCharAt2 == '\"';
        if (z2) {
            int i4 = i3 + 1;
            char cCharAt3 = charAt(i3);
            i3 = i4;
            cCharAt2 = cCharAt3;
        }
        boolean z3 = cCharAt2 == '-';
        if (z3) {
            int i5 = i3 + 1;
            char cCharAt4 = charAt(i3);
            i3 = i5;
            cCharAt2 = cCharAt4;
        }
        char c2 = '0';
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            long j = cCharAt2 - '0';
            while (true) {
                i = i3 + 1;
                cCharAt = charAt(i3);
                if (cCharAt < c2 || cCharAt > '9') {
                    break;
                }
                j = (j * 10) + ((long) (cCharAt - '0'));
                i3 = i;
                c2 = '0';
            }
            if (cCharAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z2) {
                if (cCharAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                cCharAt = charAt(i);
                i++;
            }
            if (j >= 0 || (j == Long.MIN_VALUE && z3)) {
                z = true;
            }
            if (!z) {
                this.matchStat = -1;
                return 0L;
            }
            while (cCharAt != c) {
                if (!JSONLexerBase.isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    return j;
                }
                cCharAt = charAt(i);
                i++;
            }
            this.bp = i;
            this.ch = charAt(i);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -j : j;
        }
        if (cCharAt2 == 'n') {
            int i6 = i3 + 1;
            if (charAt(i3) == 'u') {
                int i7 = i6 + 1;
                if (charAt(i6) == 'l') {
                    int i8 = i7 + 1;
                    if (charAt(i7) == 'l') {
                        this.matchStat = 5;
                        int i9 = i8 + 1;
                        char cCharAt5 = charAt(i8);
                        if (z2 && cCharAt5 == '\"') {
                            int i10 = i9 + 1;
                            char cCharAt6 = charAt(i9);
                            i9 = i10;
                            cCharAt5 = cCharAt6;
                        }
                        while (cCharAt5 != ',') {
                            if (cCharAt5 == ']') {
                                this.bp = i9;
                                this.ch = charAt(i9);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0L;
                            }
                            if (!JSONLexerBase.isWhitespace(cCharAt5)) {
                                this.matchStat = -1;
                                return 0L;
                            }
                            int i11 = i9 + 1;
                            char cCharAt7 = charAt(i9);
                            i9 = i11;
                            cCharAt5 = cCharAt7;
                        }
                        this.bp = i9;
                        this.ch = charAt(i9);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0L;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable symbolTable) {
        int iIndexOf;
        if (!this.text.startsWith("\"@type\":\"", this.bp) || (iIndexOf = this.text.indexOf(34, this.bp + 9)) == -1) {
            return null;
        }
        int i = this.bp + 9;
        this.bp = i;
        int iCharAt = 0;
        while (i < iIndexOf) {
            iCharAt = (iCharAt * 31) + this.text.charAt(i);
            i++;
        }
        int i2 = this.bp;
        String strAddSymbol = addSymbol(i2, iIndexOf - i2, iCharAt, symbolTable);
        char cCharAt = this.text.charAt(iIndexOf + 1);
        if (cCharAt != ',' && cCharAt != ']') {
            return null;
        }
        int i3 = iIndexOf + 2;
        this.bp = i3;
        this.ch = this.text.charAt(i3);
        return strAddSymbol;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean seekArrayToItem(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index must > 0, but " + i);
        }
        int i2 = this.token;
        if (i2 == 20) {
            return false;
        }
        if (i2 != 14) {
            throw new UnsupportedOperationException();
        }
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= i) {
                nextToken();
                return true;
            }
            skipWhitespace();
            char c = this.ch;
            if (c == '\"' || c == '\'') {
                skipString();
                char c2 = this.ch;
                if (c2 != ',') {
                    if (c2 != ']') {
                        throw new JSONException("illegal json.");
                    }
                    next();
                    nextToken(16);
                    return false;
                }
                next();
            } else {
                if (c == '{') {
                    next();
                    this.token = 12;
                    skipObject(false);
                } else if (c == '[') {
                    next();
                    this.token = 14;
                    skipArray(false);
                } else {
                    int i4 = this.bp + 1;
                    while (true) {
                        if (i4 >= this.text.length()) {
                            z = false;
                            break;
                        }
                        char cCharAt = this.text.charAt(i4);
                        if (cCharAt == ',') {
                            int i5 = i4 + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                            break;
                        }
                        if (cCharAt == ']') {
                            int i6 = i4 + 1;
                            this.bp = i6;
                            this.ch = charAt(i6);
                            nextToken();
                            return false;
                        }
                        i4++;
                    }
                    if (!z) {
                        throw new JSONException("illegal json.");
                    }
                }
                int i7 = this.token;
                if (i7 != 16) {
                    if (i7 == 15) {
                        return false;
                    }
                    throw new UnsupportedOperationException();
                }
            }
            i3++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long j, boolean z) {
        char c;
        int i = this.token;
        int i2 = -1;
        if (i == 20) {
            return -1;
        }
        if (i != 13) {
            int i3 = 15;
            if (i != 15) {
                int i4 = 16;
                if (i != 12 && i != 16) {
                    throw new UnsupportedOperationException(JSONToken.name(this.token));
                }
                while (true) {
                    char c2 = this.ch;
                    if (c2 == '}') {
                        next();
                        nextToken();
                        return i2;
                    }
                    if (c2 == 26) {
                        return i2;
                    }
                    if (c2 != '\"') {
                        skipWhitespace();
                    }
                    if (this.ch != '\"') {
                        throw new UnsupportedOperationException();
                    }
                    int i5 = this.bp + 1;
                    long j2 = TypeUtils.fnv1a_64_magic_hashcode;
                    while (i5 < this.text.length()) {
                        char cCharAt = this.text.charAt(i5);
                        if (cCharAt == '\\') {
                            i5++;
                            if (i5 == this.text.length()) {
                                throw new JSONException("unclosed str, " + info());
                            }
                            cCharAt = this.text.charAt(i5);
                        }
                        if (cCharAt == '\"') {
                            int i6 = i5 + 1;
                            this.bp = i6;
                            this.ch = i6 >= this.text.length() ? (char) 26 : this.text.charAt(this.bp);
                            break;
                        }
                        j2 = (j2 ^ ((long) cCharAt)) * TypeUtils.fnv1a_64_magic_prime;
                        i5++;
                    }
                    if (j2 == j) {
                        if (this.ch != ':') {
                            skipWhitespace();
                        }
                        if (this.ch != ':') {
                            return 3;
                        }
                        int i7 = this.bp + 1;
                        this.bp = i7;
                        char cCharAt2 = i7 >= this.text.length() ? (char) 26 : this.text.charAt(i7);
                        this.ch = cCharAt2;
                        if (cCharAt2 == ',') {
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            this.ch = i8 >= this.text.length() ? (char) 26 : this.text.charAt(i8);
                            this.token = i4;
                            return 3;
                        }
                        if (cCharAt2 == ']') {
                            int i9 = this.bp + 1;
                            this.bp = i9;
                            this.ch = i9 >= this.text.length() ? (char) 26 : this.text.charAt(i9);
                            this.token = i3;
                            return 3;
                        }
                        if (cCharAt2 == '}') {
                            int i10 = this.bp + 1;
                            this.bp = i10;
                            this.ch = i10 >= this.text.length() ? (char) 26 : this.text.charAt(i10);
                            this.token = 13;
                            return 3;
                        }
                        if (cCharAt2 < '0' || cCharAt2 > '9') {
                            nextToken(2);
                            return 3;
                        }
                        this.sp = 0;
                        this.pos = this.bp;
                        scanNumber();
                        return 3;
                    }
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch != ':') {
                        throw new JSONException("illegal json, " + info());
                    }
                    int i11 = this.bp + 1;
                    this.bp = i11;
                    char cCharAt3 = i11 >= this.text.length() ? (char) 26 : this.text.charAt(i11);
                    this.ch = cCharAt3;
                    if (cCharAt3 != '\"' && cCharAt3 != '\'' && cCharAt3 != '{' && cCharAt3 != '[' && cCharAt3 != '0' && cCharAt3 != '1' && cCharAt3 != '2' && cCharAt3 != '3' && cCharAt3 != '4' && cCharAt3 != '5' && cCharAt3 != '6' && cCharAt3 != '7' && cCharAt3 != '8' && cCharAt3 != '9' && cCharAt3 != '+' && cCharAt3 != '-') {
                        skipWhitespace();
                    }
                    char c3 = this.ch;
                    if (c3 == '-' || c3 == '+' || (c3 >= '0' && c3 <= '9')) {
                        next();
                        while (true) {
                            c = this.ch;
                            if (c < '0' || c > '9') {
                                break;
                            }
                            next();
                        }
                        if (c == '.') {
                            next();
                            while (true) {
                                char c4 = this.ch;
                                if (c4 < '0' || c4 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        char c5 = this.ch;
                        if (c5 == 'E' || c5 == 'e') {
                            next();
                            char c6 = this.ch;
                            if (c6 == '-' || c6 == '+') {
                                next();
                            }
                            while (true) {
                                char c7 = this.ch;
                                if (c7 < '0' || c7 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        if (this.ch != ',') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c3 == '\"') {
                        skipString();
                        char c8 = this.ch;
                        if (c8 != ',' && c8 != '}') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c3 == 't') {
                        next();
                        if (this.ch == 'r') {
                            next();
                            if (this.ch == 'u') {
                                next();
                                if (this.ch == 'e') {
                                    next();
                                }
                            }
                        }
                        char c9 = this.ch;
                        if (c9 != ',' && c9 != '}') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c3 == 'n') {
                        next();
                        if (this.ch == 'u') {
                            next();
                            if (this.ch == 'l') {
                                next();
                                if (this.ch == 'l') {
                                    next();
                                }
                            }
                        }
                        char c10 = this.ch;
                        if (c10 != ',' && c10 != '}') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c3 == 'f') {
                        next();
                        if (this.ch == 'a') {
                            next();
                            if (this.ch == 'l') {
                                next();
                                if (this.ch == 's') {
                                    next();
                                    if (this.ch == 'e') {
                                        next();
                                    }
                                }
                            }
                        }
                        char c11 = this.ch;
                        if (c11 != ',' && c11 != '}') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c3 == '{') {
                        int i12 = this.bp + 1;
                        this.bp = i12;
                        this.ch = i12 >= this.text.length() ? (char) 26 : this.text.charAt(i12);
                        if (z) {
                            this.token = 12;
                            return 1;
                        }
                        skipObject(false);
                        if (this.token == 13) {
                            return -1;
                        }
                    } else {
                        if (c3 != '[') {
                            throw new UnsupportedOperationException();
                        }
                        next();
                        if (z) {
                            this.token = 14;
                            return 2;
                        }
                        skipArray(false);
                        if (this.token == 13) {
                            return -1;
                        }
                    }
                    i2 = -1;
                    i3 = 15;
                    i4 = 16;
                }
            }
        }
        nextToken();
        return -1;
    }

    public void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    public void setTimeZone(char c, char c2, char c3) {
        setTimeZone(c, c2, c3, '0', '0');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipArray() {
        skipArray(false);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject() {
        skipObject(false);
    }

    public final void skipString() {
        if (this.ch != '\"') {
            throw new UnsupportedOperationException();
        }
        int i = this.bp;
        while (true) {
            i++;
            if (i >= this.text.length()) {
                throw new JSONException("unclosed str");
            }
            char cCharAt = this.text.charAt(i);
            if (cCharAt == '\\') {
                if (i < this.len - 1) {
                    i++;
                }
            } else if (cCharAt == '\"') {
                String str = this.text;
                int i2 = i + 1;
                this.bp = i2;
                this.ch = str.charAt(i2);
                return;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        return !this.hasSpecial ? subString(this.np + 1, this.sp) : new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (!ASMUtils.IS_ANDROID) {
            return this.text.substring(i, i2 + i);
        }
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i + i2, cArr, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return new String(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i2 < cArr.length) {
                this.text.getChars(i, i2 + i, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    public void setTimeZone(char c, char c2, char c3, char c4, char c5) {
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * 3600 * 1000) + ((((c4 - '0') * 10) + (c5 - '0')) * 60 * 1000);
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            this.calendar.setTimeZone(new SimpleTimeZone(i, Integer.toString(i)));
        }
    }

    public final void skipArray(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char cCharAt = this.text.charAt(i);
            if (cCharAt == '\\') {
                if (i >= this.len - 1) {
                    this.ch = cCharAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
                i++;
            } else if (cCharAt == '\"') {
                z2 = !z2;
            } else if (cCharAt != '[') {
                if (cCharAt == '{' && z) {
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    this.ch = i3 < this.text.length() ? this.text.charAt(i3) : (char) 26;
                    skipObject(z);
                } else if (cCharAt == ']' && !z2 && (i2 = i2 - 1) == -1) {
                    int i4 = i + 1;
                    this.bp = i4;
                    if (i4 == this.text.length()) {
                        this.ch = (char) 26;
                        this.token = 20;
                        return;
                    } else {
                        this.ch = this.text.charAt(this.bp);
                        nextToken(16);
                        return;
                    }
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        if (i != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char cCharAt = this.text.charAt(i);
            if (cCharAt == '\\') {
                if (i >= this.len - 1) {
                    this.ch = cCharAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
                i++;
            } else if (cCharAt == '\"') {
                z2 = !z2;
            } else if (cCharAt != '{') {
                if (cCharAt == '}' && !z2 && (i2 = i2 - 1) == -1) {
                    int i3 = i + 1;
                    this.bp = i3;
                    if (i3 == this.text.length()) {
                        this.ch = (char) 26;
                        this.token = 20;
                        return;
                    }
                    char cCharAt2 = this.text.charAt(this.bp);
                    this.ch = cCharAt2;
                    if (cCharAt2 == ',') {
                        this.token = 16;
                        int i4 = this.bp + 1;
                        this.bp = i4;
                        this.ch = i4 < this.text.length() ? this.text.charAt(i4) : (char) 26;
                        return;
                    }
                    if (cCharAt2 == '}') {
                        this.token = 13;
                        next();
                        return;
                    } else if (cCharAt2 != ']') {
                        nextToken(16);
                        return;
                    } else {
                        this.token = 15;
                        next();
                        return;
                    }
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        for (int i5 = 0; i5 < this.bp; i5++) {
            if (i5 < this.text.length() && this.text.charAt(i5) == ' ') {
                i++;
            }
        }
        if (i != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    private boolean scanISO8601DateIfMatch(boolean z, int i) {
        int i2;
        boolean z2;
        char c;
        char cCharAt;
        char c2;
        char c3;
        char c4;
        int i3;
        int i4;
        int i5;
        int i6;
        char c5;
        char c6;
        char cCharAt2;
        char c7;
        char c8;
        char c9;
        int i7;
        int i8;
        char c10;
        int i9;
        int i10;
        char cCharAt3;
        char cCharAt4;
        char cCharAt5;
        char cCharAt6;
        char cCharAt7;
        char cCharAt8;
        if (i < 8) {
            return false;
        }
        char cCharAt9 = charAt(this.bp);
        char cCharAt10 = charAt(this.bp + 1);
        char cCharAt11 = charAt(this.bp + 2);
        int i11 = 3;
        char cCharAt12 = charAt(this.bp + 3);
        char cCharAt13 = charAt(this.bp + 4);
        int i12 = 5;
        char cCharAt14 = charAt(this.bp + 5);
        char cCharAt15 = charAt(this.bp + 6);
        char cCharAt16 = charAt(this.bp + 7);
        if (!z) {
            if (i > 13) {
                char cCharAt17 = charAt((this.bp + i) - 1);
                char cCharAt18 = charAt((this.bp + i) - 2);
                if (cCharAt9 == '/' && cCharAt10 == 'D' && cCharAt11 == 'a' && cCharAt12 == 't' && cCharAt13 == 'e' && cCharAt14 == '(' && cCharAt17 == '/' && cCharAt18 == ')') {
                    int i13 = -1;
                    for (int i14 = 6; i14 < i; i14++) {
                        char cCharAt19 = charAt(this.bp + i14);
                        if (cCharAt19 != '+') {
                            if (cCharAt19 < '0' || cCharAt19 > '9') {
                                break;
                            }
                        } else {
                            i13 = i14;
                        }
                    }
                    if (i13 == -1) {
                        return false;
                    }
                    int i15 = this.bp;
                    int i16 = i15 + 6;
                    long j = Long.parseLong(subString(i16, (i15 + i13) - i16));
                    Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
                    this.calendar = calendar;
                    calendar.setTimeInMillis(j);
                    this.token = 5;
                    return true;
                }
            }
            i12 = 5;
        }
        if (i == 8 || i == 14) {
            i2 = i12;
            z2 = false;
            c = c.b;
        } else {
            if (!(i == 16 && ((cCharAt8 = charAt(this.bp + 10)) == 'T' || cCharAt8 == ' ')) && (i != 17 || charAt(this.bp + 6) == '-')) {
                if (i < 9) {
                    return false;
                }
                char cCharAt20 = charAt(this.bp + 8);
                char cCharAt21 = charAt(this.bp + 9);
                if ((cCharAt13 == '-' && cCharAt16 == '-') || (cCharAt13 == '/' && cCharAt16 == '/')) {
                    if (cCharAt21 == ' ') {
                        c10 = '0';
                        i8 = 9;
                        cCharAt10 = cCharAt20;
                        cCharAt14 = cCharAt15;
                        cCharAt11 = cCharAt11;
                    } else {
                        i8 = 10;
                        c10 = cCharAt20;
                        cCharAt14 = cCharAt15;
                        cCharAt11 = cCharAt11;
                        cCharAt14 = cCharAt14;
                        cCharAt10 = cCharAt10;
                        cCharAt10 = cCharAt21;
                    }
                } else if (cCharAt13 == '-' && cCharAt15 == '-') {
                    if (cCharAt20 == ' ') {
                        cCharAt14 = '0';
                        i8 = 8;
                        cCharAt10 = cCharAt16;
                        cCharAt12 = cCharAt12;
                        c10 = '0';
                    } else {
                        cCharAt14 = '0';
                        i8 = 9;
                        cCharAt14 = cCharAt14;
                        cCharAt10 = cCharAt10;
                        cCharAt10 = cCharAt20;
                        c10 = cCharAt16;
                        cCharAt12 = cCharAt12;
                    }
                } else if ((cCharAt11 == '.' && cCharAt14 == '.') || (cCharAt11 == '-' && cCharAt14 == '-')) {
                    cCharAt10 = cCharAt16;
                    cCharAt12 = cCharAt21;
                    cCharAt14 = cCharAt12;
                    c10 = cCharAt9;
                    i8 = 10;
                    cCharAt14 = cCharAt13;
                    cCharAt9 = cCharAt15;
                    cCharAt11 = cCharAt20;
                } else {
                    if (cCharAt20 == 'T') {
                        cCharAt14 = cCharAt13;
                        cCharAt14 = cCharAt14;
                        cCharAt9 = cCharAt9;
                        cCharAt10 = cCharAt10;
                        i8 = 8;
                        cCharAt10 = cCharAt16;
                        cCharAt12 = cCharAt12;
                        c10 = cCharAt15;
                    } else {
                        if (cCharAt13 != 24180 && cCharAt13 != 45380) {
                            return false;
                        }
                        if (cCharAt16 != 26376 && cCharAt16 != 50900) {
                            if (cCharAt15 != 26376 && cCharAt15 != 50900) {
                                return false;
                            }
                            if (cCharAt20 == 26085 || cCharAt20 == 51068) {
                                i8 = 10;
                                cCharAt14 = '0';
                                cCharAt10 = cCharAt16;
                                cCharAt12 = cCharAt12;
                                c10 = '0';
                            } else {
                                if (cCharAt21 != 26085 && cCharAt21 != 51068) {
                                    return false;
                                }
                                i8 = 10;
                                cCharAt14 = '0';
                                cCharAt14 = cCharAt14;
                                cCharAt10 = cCharAt10;
                                cCharAt10 = cCharAt20;
                                c10 = cCharAt16;
                                cCharAt12 = cCharAt12;
                            }
                        } else if (cCharAt21 == 26085 || cCharAt21 == 51068) {
                            i8 = 10;
                            c10 = '0';
                            cCharAt10 = cCharAt20;
                            cCharAt14 = cCharAt15;
                        } else {
                            if (charAt(this.bp + 10) != 26085 && charAt(this.bp + 10) != 51068) {
                                return false;
                            }
                            i8 = 11;
                            c10 = cCharAt20;
                            cCharAt14 = cCharAt15;
                            cCharAt11 = cCharAt11;
                            cCharAt14 = cCharAt14;
                            cCharAt10 = cCharAt10;
                            cCharAt10 = cCharAt21;
                        }
                    }
                    cCharAt11 = cCharAt11;
                }
                if (!checkDate(cCharAt9, cCharAt10, cCharAt11, cCharAt12, cCharAt14, cCharAt14, c10, cCharAt10)) {
                    return false;
                }
                setCalendar(cCharAt9, cCharAt10, cCharAt11, cCharAt12, cCharAt14, cCharAt14, c10, cCharAt10);
                char cCharAt22 = charAt(this.bp + i8);
                char c11 = 'T';
                if (cCharAt22 == 'T') {
                    if (i == 16 && i8 == 8 && charAt(this.bp + 15) == 'Z') {
                        char cCharAt23 = charAt(this.bp + i8 + 1);
                        char cCharAt24 = charAt(this.bp + i8 + 2);
                        char cCharAt25 = charAt(this.bp + i8 + 3);
                        char cCharAt26 = charAt(this.bp + i8 + 4);
                        char cCharAt27 = charAt(this.bp + i8 + 5);
                        char cCharAt28 = charAt(this.bp + i8 + 6);
                        if (!checkTime(cCharAt23, cCharAt24, cCharAt25, cCharAt26, cCharAt27, cCharAt28)) {
                            return false;
                        }
                        setTime(cCharAt23, cCharAt24, cCharAt25, cCharAt26, cCharAt27, cCharAt28);
                        this.calendar.set(14, 0);
                        if (this.calendar.getTimeZone().getRawOffset() != 0) {
                            String[] availableIDs = TimeZone.getAvailableIDs(0);
                            if (availableIDs.length > 0) {
                                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                            }
                        }
                        this.token = 5;
                        return true;
                    }
                    c11 = 'T';
                }
                if (cCharAt22 != c11 && (cCharAt22 != ' ' || z)) {
                    if (cCharAt22 != '\"' && cCharAt22 != 26 && cCharAt22 != 26085 && cCharAt22 != 51068) {
                        if ((cCharAt22 != '+' && cCharAt22 != '-') || this.len != i8 + 6 || charAt(this.bp + i8 + 3) != ':' || charAt(this.bp + i8 + 4) != '0' || charAt(this.bp + i8 + 5) != '0') {
                            return false;
                        }
                        setTime('0', '0', '0', '0', '0', '0');
                        this.calendar.set(14, 0);
                        setTimeZone(cCharAt22, charAt(this.bp + i8 + 1), charAt(this.bp + i8 + 2));
                        return true;
                    }
                    this.calendar.set(11, 0);
                    this.calendar.set(12, 0);
                    this.calendar.set(13, 0);
                    this.calendar.set(14, 0);
                    int i17 = this.bp + i8;
                    this.bp = i17;
                    this.ch = charAt(i17);
                    this.token = 5;
                    return true;
                }
                if (i < i8 + 9 || charAt(this.bp + i8 + 3) != ':' || charAt(this.bp + i8 + 6) != ':') {
                    return false;
                }
                char cCharAt29 = charAt(this.bp + i8 + 1);
                char cCharAt30 = charAt(this.bp + i8 + 2);
                char cCharAt31 = charAt(this.bp + i8 + 4);
                char cCharAt32 = charAt(this.bp + i8 + 5);
                char cCharAt33 = charAt(this.bp + i8 + 7);
                char cCharAt34 = charAt(this.bp + i8 + 8);
                if (!checkTime(cCharAt29, cCharAt30, cCharAt31, cCharAt32, cCharAt33, cCharAt34)) {
                    return false;
                }
                setTime(cCharAt29, cCharAt30, cCharAt31, cCharAt32, cCharAt33, cCharAt34);
                if (charAt(this.bp + i8 + 9) == '.') {
                    int i18 = i8 + 11;
                    if (i < i18 || (cCharAt5 = charAt(this.bp + i8 + 10)) < '0' || cCharAt5 > '9') {
                        return false;
                    }
                    int i19 = cCharAt5 - '0';
                    if (i <= i18 || (cCharAt7 = charAt(this.bp + i8 + 11)) < '0' || cCharAt7 > '9') {
                        i9 = 1;
                    } else {
                        i19 = (i19 * 10) + (cCharAt7 - '0');
                        i9 = 2;
                    }
                    if (i9 != 2 || (cCharAt6 = charAt(this.bp + i8 + 12)) < '0' || cCharAt6 > '9') {
                        i10 = i19;
                    } else {
                        i10 = (cCharAt6 - '0') + (i19 * 10);
                        i9 = 3;
                    }
                } else {
                    i9 = -1;
                    i10 = 0;
                }
                this.calendar.set(14, i10);
                char cCharAt35 = charAt(this.bp + i8 + 10 + i9);
                if (cCharAt35 == ' ') {
                    i9++;
                    cCharAt35 = charAt(this.bp + i8 + 10 + i9);
                }
                char c12 = cCharAt35;
                if (c12 == '+' || c12 == '-') {
                    char cCharAt36 = charAt(this.bp + i8 + 10 + i9 + 1);
                    if (cCharAt36 < '0' || cCharAt36 > '1' || (cCharAt3 = charAt(this.bp + i8 + 10 + i9 + 2)) < '0' || cCharAt3 > '9') {
                        return false;
                    }
                    char cCharAt37 = charAt(this.bp + i8 + 10 + i9 + 3);
                    char c13 = '3';
                    if (cCharAt37 == ':') {
                        char cCharAt38 = charAt(this.bp + i8 + 10 + i9 + 4);
                        cCharAt4 = charAt(this.bp + i8 + 10 + i9 + 5);
                        if (cCharAt38 == '4' && cCharAt4 == '5') {
                            if (cCharAt36 != '1' || (cCharAt3 != '2' && cCharAt3 != '3')) {
                                if (cCharAt36 != '0') {
                                    return false;
                                }
                                if (cCharAt3 != '5' && cCharAt3 != '8') {
                                    return false;
                                }
                            }
                        } else if ((cCharAt38 != '0' && cCharAt38 != '3') || cCharAt4 != '0') {
                            return false;
                        }
                        c13 = cCharAt38;
                        i11 = 6;
                    } else {
                        if (cCharAt37 == '0') {
                            char cCharAt39 = charAt(this.bp + i8 + 10 + i9 + 4);
                            if (cCharAt39 != '0' && cCharAt39 != '3') {
                                return false;
                            }
                            c13 = cCharAt39;
                        } else {
                            if (cCharAt37 != '3' || charAt(this.bp + i8 + 10 + i9 + 4) != '0') {
                                if (cCharAt37 == '4' && charAt(this.bp + i8 + 10 + i9 + 4) == '5') {
                                    cCharAt4 = '5';
                                    i11 = 5;
                                    c13 = '4';
                                } else {
                                    c13 = '0';
                                }
                            }
                            cCharAt4 = '0';
                        }
                        i11 = 5;
                        cCharAt4 = '0';
                    }
                    setTimeZone(c12, cCharAt36, cCharAt3, c13, cCharAt4);
                } else if (c12 == 'Z') {
                    if (this.calendar.getTimeZone().getRawOffset() != 0) {
                        String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                        if (availableIDs2.length > 0) {
                            this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                        }
                    }
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                int i20 = i8 + 10 + i9 + i11;
                char cCharAt40 = charAt(this.bp + i20);
                if (cCharAt40 != 26 && cCharAt40 != '\"') {
                    return false;
                }
                int i21 = this.bp + i20;
                this.bp = i21;
                this.ch = charAt(i21);
                this.token = 5;
                return true;
            }
            z2 = false;
            c = c.b;
            i2 = 5;
        }
        if (z) {
            return z2;
        }
        char cCharAt41 = charAt(this.bp + 8);
        boolean z3 = cCharAt13 == '-' && cCharAt16 == '-';
        boolean z4 = z3 && i == 16;
        boolean z5 = z3 && i == 17;
        if (z5 || z4) {
            cCharAt = charAt(this.bp + 9);
            c2 = cCharAt14;
            c3 = cCharAt15;
            c4 = cCharAt41;
        } else if (cCharAt13 == '-' && cCharAt15 == '-') {
            c3 = cCharAt14;
            cCharAt = cCharAt16;
            c2 = '0';
            c4 = '0';
        } else {
            c2 = cCharAt13;
            c3 = cCharAt14;
            c4 = cCharAt15;
            cCharAt = cCharAt16;
        }
        if (!checkDate(cCharAt9, cCharAt10, cCharAt11, cCharAt12, c2, c3, c4, cCharAt)) {
            return false;
        }
        setCalendar(cCharAt9, cCharAt10, cCharAt11, cCharAt12, c2, c3, c4, cCharAt);
        if (i != 8) {
            char cCharAt42 = charAt(this.bp + 9);
            char cCharAt43 = charAt(this.bp + 10);
            char cCharAt44 = charAt(this.bp + 11);
            char cCharAt45 = charAt(this.bp + 12);
            char cCharAt46 = charAt(this.bp + 13);
            if ((z5 && cCharAt43 == 'T' && cCharAt46 == c && charAt(this.bp + 16) == 'Z') || (z4 && ((cCharAt43 == ' ' || cCharAt43 == 'T') && cCharAt46 == c))) {
                char cCharAt47 = charAt(this.bp + 14);
                cCharAt2 = charAt(this.bp + 15);
                c6 = cCharAt47;
                c8 = cCharAt44;
                c5 = cCharAt45;
                c9 = '0';
                c7 = '0';
            } else {
                c5 = cCharAt42;
                c6 = cCharAt43;
                cCharAt2 = cCharAt44;
                c7 = cCharAt46;
                c8 = cCharAt41;
                c9 = cCharAt45;
            }
            if (!checkTime(c8, c5, c6, cCharAt2, c9, c7)) {
                return false;
            }
            if (i != 17 || z5) {
                i7 = 0;
            } else {
                char cCharAt48 = charAt(this.bp + 14);
                char cCharAt49 = charAt(this.bp + 15);
                char cCharAt50 = charAt(this.bp + 16);
                if (cCharAt48 < '0' || cCharAt48 > '9' || cCharAt49 < '0' || cCharAt49 > '9' || cCharAt50 < '0' || cCharAt50 > '9') {
                    return false;
                }
                i7 = ((cCharAt48 - '0') * 100) + ((cCharAt49 - '0') * 10) + (cCharAt50 - '0');
            }
            i4 = ((c9 - '0') * 10) + (c7 - '0');
            i6 = ((c8 - '0') * 10) + (c5 - '0');
            i5 = i7;
            i3 = ((c6 - '0') * 10) + (cCharAt2 - '0');
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        this.calendar.set(11, i6);
        this.calendar.set(12, i3);
        this.calendar.set(13, i4);
        this.calendar.set(14, i5);
        this.token = i2;
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        int i2;
        char cCharAt;
        int i3 = this.bp;
        char c = this.ch;
        while (JSONLexerBase.isWhitespace(this.ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i4 = length + 1;
            char cCharAt2 = this.text.charAt(length);
            while (JSONLexerBase.isWhitespace(cCharAt2)) {
                cCharAt2 = this.text.charAt(i4);
                i4++;
            }
            if (cCharAt2 == ':') {
                i2 = i4 + 1;
                cCharAt = this.text.charAt(i4);
                while (JSONLexerBase.isWhitespace(cCharAt)) {
                    cCharAt = this.text.charAt(i2);
                    i2++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i2 = this.bp + 1;
            cCharAt = this.ch;
        }
        if (cCharAt == '[') {
            this.bp = i2;
            this.ch = this.text.charAt(i2);
            String[] strArr = i >= 0 ? new String[i] : new String[4];
            int i5 = 0;
            while (true) {
                if (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                } else {
                    if (this.ch != '\"') {
                        this.bp = i3;
                        this.ch = c;
                        this.matchStat = -1;
                        return null;
                    }
                    String strScanSymbol = scanSymbol(symbolTable, '\"');
                    if (i5 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i6 = i5 + 1;
                    strArr[i5] = strScanSymbol;
                    while (JSONLexerBase.isWhitespace(this.ch)) {
                        next();
                    }
                    if (this.ch == ',') {
                        next();
                        i5 = i6;
                    } else {
                        if (strArr.length != i6) {
                            String[] strArr3 = new String[i6];
                            System.arraycopy(strArr, 0, strArr3, 0, i6);
                            strArr = strArr3;
                        }
                        while (JSONLexerBase.isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i3;
                        this.ch = c;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else {
            if (cCharAt == 'n' && this.text.startsWith("ull", this.bp + 1)) {
                int i7 = this.bp + 4;
                this.bp = i7;
                this.ch = this.text.charAt(i7);
                return null;
            }
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long[] jArr) {
        char c;
        int i = this.token;
        if (i != 12 && i != 16) {
            throw new UnsupportedOperationException();
        }
        while (true) {
            char c2 = this.ch;
            if (c2 == '}') {
                next();
                nextToken();
                this.matchStat = -1;
                return -1;
            }
            if (c2 == 26) {
                this.matchStat = -1;
                return -1;
            }
            if (c2 != '\"') {
                skipWhitespace();
            }
            if (this.ch == '\"') {
                int i2 = this.bp + 1;
                long j = TypeUtils.fnv1a_64_magic_hashcode;
                while (i2 < this.text.length()) {
                    char cCharAt = this.text.charAt(i2);
                    if (cCharAt == '\\') {
                        i2++;
                        if (i2 != this.text.length()) {
                            cCharAt = this.text.charAt(i2);
                        } else {
                            throw new JSONException("unclosed str, " + info());
                        }
                    }
                    if (cCharAt == '\"') {
                        int i3 = i2 + 1;
                        this.bp = i3;
                        this.ch = i3 >= this.text.length() ? (char) 26 : this.text.charAt(this.bp);
                        break;
                    }
                    j = (j ^ ((long) cCharAt)) * TypeUtils.fnv1a_64_magic_prime;
                    i2++;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= jArr.length) {
                        i4 = -1;
                        break;
                    }
                    if (j == jArr[i4]) {
                        break;
                    }
                    i4++;
                }
                if (i4 != -1) {
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch == ':') {
                        int i5 = this.bp + 1;
                        this.bp = i5;
                        char cCharAt2 = i5 >= this.text.length() ? (char) 26 : this.text.charAt(i5);
                        this.ch = cCharAt2;
                        if (cCharAt2 == ',') {
                            int i6 = this.bp + 1;
                            this.bp = i6;
                            this.ch = i6 < this.text.length() ? this.text.charAt(i6) : (char) 26;
                            this.token = 16;
                        } else if (cCharAt2 == ']') {
                            int i7 = this.bp + 1;
                            this.bp = i7;
                            this.ch = i7 < this.text.length() ? this.text.charAt(i7) : (char) 26;
                            this.token = 15;
                        } else if (cCharAt2 == '}') {
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            this.ch = i8 < this.text.length() ? this.text.charAt(i8) : (char) 26;
                            this.token = 13;
                        } else if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                            this.sp = 0;
                            this.pos = this.bp;
                            scanNumber();
                        } else {
                            nextToken(2);
                        }
                    }
                    this.matchStat = 3;
                    return i4;
                }
                if (this.ch != ':') {
                    skipWhitespace();
                }
                if (this.ch == ':') {
                    int i9 = this.bp + 1;
                    this.bp = i9;
                    char cCharAt3 = i9 >= this.text.length() ? (char) 26 : this.text.charAt(i9);
                    this.ch = cCharAt3;
                    if (cCharAt3 != '\"' && cCharAt3 != '\'' && cCharAt3 != '{' && cCharAt3 != '[' && cCharAt3 != '0' && cCharAt3 != '1' && cCharAt3 != '2' && cCharAt3 != '3' && cCharAt3 != '4' && cCharAt3 != '5' && cCharAt3 != '6' && cCharAt3 != '7' && cCharAt3 != '8' && cCharAt3 != '9' && cCharAt3 != '+' && cCharAt3 != '-') {
                        skipWhitespace();
                    }
                    char c3 = this.ch;
                    if (c3 == '-' || c3 == '+' || (c3 >= '0' && c3 <= '9')) {
                        next();
                        while (true) {
                            c = this.ch;
                            if (c < '0' || c > '9') {
                                break;
                            }
                            next();
                        }
                        if (c == '.') {
                            next();
                            while (true) {
                                char c4 = this.ch;
                                if (c4 < '0' || c4 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        char c5 = this.ch;
                        if (c5 == 'E' || c5 == 'e') {
                            next();
                            char c6 = this.ch;
                            if (c6 == '-' || c6 == '+') {
                                next();
                            }
                            while (true) {
                                char c7 = this.ch;
                                if (c7 < '0' || c7 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        if (this.ch != ',') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c3 == '\"') {
                        skipString();
                        char c8 = this.ch;
                        if (c8 != ',' && c8 != '}') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c3 == '{') {
                        int i10 = this.bp + 1;
                        this.bp = i10;
                        this.ch = i10 < this.text.length() ? this.text.charAt(i10) : (char) 26;
                        skipObject(false);
                    } else if (c3 == '[') {
                        next();
                        skipArray(false);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    throw new JSONException("illegal json, " + info());
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }
}
