package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class y39 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45952a;
    public final String b;

    public y39(String str, String str2) {
        super(ParsedResultType.TEXT);
        this.f45952a = str;
        this.b = str2;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        return this.f45952a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f45952a;
    }
}
