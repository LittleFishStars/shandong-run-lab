package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class w07 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45501a;
    public final String b;

    public w07(String str) {
        this(str, str);
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        return this.f45501a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f45501a;
    }

    public w07(String str, String str2) {
        super(ParsedResultType.PRODUCT);
        this.f45501a = str;
        this.b = str2;
    }
}
