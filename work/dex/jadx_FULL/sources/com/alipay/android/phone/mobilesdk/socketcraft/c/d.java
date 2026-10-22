package com.alipay.android.phone.mobilesdk.socketcraft.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25289a = "*";

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.c.b
    public void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.f25289a = str;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.c.a
    public String a() {
        return this.f25289a;
    }
}
