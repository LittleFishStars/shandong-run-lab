package com.alipay.sdk.m.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class c extends b {
    public final String f;

    public c(String str) {
        this.f = str;
    }

    @Override // com.alipay.sdk.m.j.b
    public void a() throws Exception {
        this.f25449a = (byte) 1;
        byte[] bytes = this.f.getBytes("UTF-8");
        this.c = bytes;
        this.b = (byte) bytes.length;
    }
}
