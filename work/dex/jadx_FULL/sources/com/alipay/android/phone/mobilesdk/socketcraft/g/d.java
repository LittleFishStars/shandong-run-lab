package com.alipay.android.phone.mobilesdk.socketcraft.g;

import com.alipay.android.phone.mobilesdk.socketcraft.a.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {
    public static final f a(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("webSocketContext parameter can't null");
        }
        Object objA = fVar.a(com.alipay.android.phone.mobilesdk.socketcraft.a.c.b);
        if (objA != null && (objA instanceof f)) {
            return (f) objA;
        }
        synchronized (d.class) {
            Object objA2 = fVar.a(com.alipay.android.phone.mobilesdk.socketcraft.a.c.b);
            if (objA2 != null && (objA2 instanceof f)) {
                return (f) objA2;
            }
            com.alipay.android.phone.mobilesdk.socketcraft.a.a aVar = new com.alipay.android.phone.mobilesdk.socketcraft.a.a();
            fVar.a(com.alipay.android.phone.mobilesdk.socketcraft.a.c.b, aVar);
            return aVar;
        }
    }
}
