package com.zj.adlib;

import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zh9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f46264a = "RepresentationID";
    public static final int b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f21058b = "Number";
    public static final int c = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f21059c = "Bandwidth";
    public static final int d = 3;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f21060d = "Time";
    public static final int e = 4;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f21061e = "$$";
    public static final String f = "%01d";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f21062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f21063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f21064a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String[] f21065b;

    public zh9(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.f21064a = strArr;
        this.f21063a = iArr;
        this.f21065b = strArr2;
        this.f21062a = i;
    }

    public static zh9 b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new zh9(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    public static int c(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String strSubstring;
        strArr[0] = "";
        int length = 0;
        int i = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf("$", length);
            if (iIndexOf == -1) {
                strArr[i] = strArr[i] + str.substring(length);
                length = str.length();
            } else if (iIndexOf != length) {
                strArr[i] = strArr[i] + str.substring(length, iIndexOf);
                length = iIndexOf;
            } else if (str.startsWith("$$", length)) {
                strArr[i] = strArr[i] + "$";
                length += 2;
            } else {
                int i2 = length + 1;
                int iIndexOf2 = str.indexOf("$", i2);
                String strSubstring2 = str.substring(i2, iIndexOf2);
                if (strSubstring2.equals(f46264a)) {
                    iArr[i] = 1;
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith("d") && !strSubstring.endsWith("x") && !strSubstring.endsWith("X")) {
                            strSubstring = strSubstring + "d";
                        }
                        strSubstring2 = strSubstring2.substring(0, iIndexOf3);
                    } else {
                        strSubstring = f;
                    }
                    strSubstring2.hashCode();
                    switch (strSubstring2) {
                        case "Number":
                            iArr[i] = 2;
                            break;
                        case "Time":
                            iArr[i] = 4;
                            break;
                        case "Bandwidth":
                            iArr[i] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i] = strSubstring;
                }
                i++;
                strArr[i] = "";
                length = iIndexOf2 + 1;
            }
        }
        return i;
    }

    public String a(String str, long j, int i, long j2) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = this.f21062a;
            if (i2 >= i3) {
                sb.append(this.f21064a[i3]);
                return sb.toString();
            }
            sb.append(this.f21064a[i2]);
            int i4 = this.f21063a[i2];
            if (i4 == 1) {
                sb.append(str);
            } else if (i4 == 2) {
                sb.append(String.format(Locale.US, this.f21065b[i2], Long.valueOf(j)));
            } else if (i4 == 3) {
                sb.append(String.format(Locale.US, this.f21065b[i2], Integer.valueOf(i)));
            } else if (i4 == 4) {
                sb.append(String.format(Locale.US, this.f21065b[i2], Long.valueOf(j2)));
            }
            i2++;
        }
    }
}
