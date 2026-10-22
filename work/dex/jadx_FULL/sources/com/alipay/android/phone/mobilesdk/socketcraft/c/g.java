package com.alipay.android.phone.mobilesdk.socketcraft.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f25291a;
    private TreeMap<String, String> b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.c.c
    public void a(byte[] bArr) {
        this.f25291a = bArr;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.c.f
    public String b(String str) {
        String str2 = this.b.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.c.f
    public Iterator<String> c() {
        return Collections.unmodifiableSet(this.b.keySet()).iterator();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.c.f
    public byte[] d() {
        return this.f25291a;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.c.c
    public void a(String str, String str2) {
        this.b.put(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.c.f
    public boolean c(String str) {
        return this.b.containsKey(str);
    }
}
