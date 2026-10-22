package com.kc.cw.ad.internal;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f39043a;
    private final ArrayList<a> b = new ArrayList<>();

    @Keep
    public interface a {
        void a(String str);
    }

    public static k a() {
        k kVar;
        synchronized (k.class) {
            try {
                if (f39043a == null) {
                    f39043a = new k();
                }
                kVar = f39043a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    public void a(a aVar) {
        this.b.add(aVar);
    }

    public void a(String str) {
        try {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(str);
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void b(a aVar) {
        try {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                if (it.next() == aVar) {
                    it.remove();
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }
}
