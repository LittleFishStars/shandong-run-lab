package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.oned.OneDimensionalCodeWriter;
import com.google.zxing.oned.rss.expanded.decoders.g;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class zm1 extends OneDimensionalCodeWriter {
    public static void f(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00ef  */
    public static String g(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 0) {
                sb.append("%U");
            } else if (cCharAt == ' ') {
                sb.append(cCharAt);
            } else if (cCharAt == '@') {
                sb.append("%V");
            } else if (cCharAt == '`') {
                sb.append("%W");
            } else if (cCharAt == '-' || cCharAt == '.') {
                sb.append(cCharAt);
            } else if (cCharAt <= 26) {
                sb.append(g.b);
                sb.append((char) ((cCharAt - 1) + 65));
            } else if (cCharAt < ' ') {
                sb.append('%');
                sb.append((char) ((cCharAt - 27) + 65));
            } else if (cCharAt <= ',' || cCharAt == '/' || cCharAt == ':') {
                sb.append('/');
                sb.append((char) ((cCharAt - '!') + 65));
            } else if (cCharAt <= '9') {
                sb.append((char) ((cCharAt - '0') + 48));
            } else if (cCharAt <= '?') {
                sb.append('%');
                sb.append((char) ((cCharAt - ';') + 70));
            } else if (cCharAt <= 'Z') {
                sb.append((char) ((cCharAt - 'A') + 65));
            } else if (cCharAt <= '_') {
                sb.append('%');
                sb.append((char) ((cCharAt - '[') + 75));
            } else if (cCharAt <= 'z') {
                sb.append('+');
                sb.append((char) ((cCharAt - 'a') + 65));
            } else {
                if (cCharAt > 127) {
                    throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i) + "'");
                }
                sb.append('%');
                sb.append((char) ((cCharAt - '{') + 80));
            }
        }
        return sb.toString();
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        for (int i = 0; i < length; i++) {
            if (ym1.f20885a.indexOf(str.charAt(i)) < 0) {
                str = g(str);
                length = str.length();
                if (length <= 80) {
                    break;
                }
                throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
            }
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[(length * 13) + 25];
        f(148, iArr);
        int iAppendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int iAppendPattern2 = iAppendPattern + OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, iArr2, false);
        for (int i2 = 0; i2 < length; i2++) {
            f(ym1.b[ym1.f20885a.indexOf(str.charAt(i2))], iArr);
            int iAppendPattern3 = iAppendPattern2 + OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, iArr, true);
            iAppendPattern2 = iAppendPattern3 + OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern3, iArr2, false);
        }
        f(148, iArr);
        OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, iArr, true);
        return zArr;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.CODE_39);
    }
}
