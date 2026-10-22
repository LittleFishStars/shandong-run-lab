package com.kc.dw.core.service;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements com.kc.dw.core.router.service.b {
    @Override // com.kc.dw.core.router.service.b
    public void a(Throwable th) {
        try {
            ArrayList<String> arrayList = com.kc.dw.core.exception.c.f39253a;
            try {
                com.kc.dw.core.exception.c.a(com.kc.dw.base.a.getContext(), com.kc.dw.base.a.adConfig() != null ? com.kc.dw.base.a.adConfig().isTest() : false, Thread.currentThread(), th, false);
            } catch (Throwable unused) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
