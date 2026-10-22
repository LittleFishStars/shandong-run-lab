package com.zj.adlib;

import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class rs7 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f19420a;
    public final String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String[] f19421b;

    public rs7(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.f19420a = new String[]{str};
        this.f19421b = new String[]{str2};
        this.f44527a = str3;
        this.b = str4;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.c(this.f19420a, sb);
        ParsedResult.b(this.f44527a, sb);
        ParsedResult.b(this.b, sb);
        return sb.toString();
    }

    public String d() {
        return this.b;
    }

    public String[] e() {
        return this.f19420a;
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(WVUCWebViewClient.SCHEME_SMS);
        boolean z = true;
        for (int i = 0; i < this.f19420a.length; i++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(this.f19420a[i]);
            String[] strArr = this.f19421b;
            if (strArr != null && strArr[i] != null) {
                sb.append(";via=");
                sb.append(this.f19421b[i]);
            }
        }
        boolean z2 = this.b != null;
        boolean z3 = this.f44527a != null;
        if (z2 || z3) {
            sb.append('?');
            if (z2) {
                sb.append("body=");
                sb.append(this.b);
            }
            if (z3) {
                if (z2) {
                    sb.append(dv9.d);
                }
                sb.append("subject=");
                sb.append(this.f44527a);
            }
        }
        return sb.toString();
    }

    public String g() {
        return this.f44527a;
    }

    public String[] h() {
        return this.f19421b;
    }

    public rs7(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.f19420a = strArr;
        this.f19421b = strArr2;
        this.f44527a = str;
        this.b = str2;
    }
}
