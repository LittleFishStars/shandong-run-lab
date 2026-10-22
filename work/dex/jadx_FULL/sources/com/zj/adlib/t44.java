package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class t44 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44842a;

    public t44(String str) {
        super(ParsedResultType.ISBN);
        this.f44842a = str;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        return this.f44842a;
    }

    public String d() {
        return this.f44842a;
    }
}
