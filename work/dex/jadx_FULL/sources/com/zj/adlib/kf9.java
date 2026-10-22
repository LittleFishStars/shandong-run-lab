package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.client.result.ResultParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class kf9 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42809a;
    public final String b;

    public kf9(String str, String str2) {
        super(ParsedResultType.URI);
        this.f42809a = h(str);
        this.b = str2;
    }

    public static boolean f(String str, int i) {
        int i2 = i + 1;
        int iIndexOf = str.indexOf(47, i2);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return ResultParser.isSubstringOfDigits(str, i2, iIndexOf - i2);
    }

    public static String h(String str) {
        String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(58);
        if (iIndexOf >= 0 && !f(strTrim, iIndexOf)) {
            return strTrim;
        }
        return "http://" + strTrim;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        ParsedResult.b(this.b, sb);
        ParsedResult.b(this.f42809a, sb);
        return sb.toString();
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f42809a;
    }

    @Deprecated
    public boolean g() {
        return lf9.j(this.f42809a);
    }
}
