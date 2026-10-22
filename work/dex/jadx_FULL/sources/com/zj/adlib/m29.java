package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class m29 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f43206a;
    public final String b;
    public final String c;

    public m29(String str, String str2, String str3) {
        super(ParsedResultType.TEL);
        this.f43206a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        ParsedResult.b(this.f43206a, sb);
        ParsedResult.b(this.c, sb);
        return sb.toString();
    }

    public String d() {
        return this.f43206a;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }
}
