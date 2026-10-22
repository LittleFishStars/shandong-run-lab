package com.kc.dw.core.service;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c implements com.kc.dw.core.router.service.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<com.kc.dw.core.router.service.a.InterfaceC1044a> f39313a = Collections.synchronizedList(new ArrayList());
    public static AtomicInteger b = new AtomicInteger(0);
    public static boolean c = false;

    public static void a(boolean z) {
        try {
            List<com.kc.dw.core.router.service.a.InterfaceC1044a> list = f39313a;
            if (list.isEmpty()) {
                return;
            }
            Iterator<com.kc.dw.core.router.service.a.InterfaceC1044a> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onAppStateUpdate(z);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean a() {
        return b.get() > 0;
    }

    @Override // com.kc.dw.core.router.service.a
    public void a(com.kc.dw.core.router.service.a.InterfaceC1044a interfaceC1044a) {
        if (interfaceC1044a == null) {
            return;
        }
        try {
            List<com.kc.dw.core.router.service.a.InterfaceC1044a> list = f39313a;
            if (list.contains(interfaceC1044a)) {
                return;
            }
            list.add(interfaceC1044a);
        } catch (Exception unused) {
        }
    }

    @Override // com.kc.dw.core.router.service.a
    public void b(com.kc.dw.core.router.service.a.InterfaceC1044a interfaceC1044a) {
        if (interfaceC1044a == null) {
            return;
        }
        try {
            f39313a.remove(interfaceC1044a);
        } catch (Exception unused) {
        }
    }
}
