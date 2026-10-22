package com.kc.dw.cache.image;

import android.graphics.Bitmap;
import com.kc.dw.cache.d;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c implements a {
    public final String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SoftReference<d>> f39221a = new ArrayList();
    public final Object c = new Object();

    public c(String str, d dVar) {
        this.b = str;
        a(dVar);
    }

    public static void a(c cVar, int i) {
        synchronized (cVar.c) {
            Iterator<SoftReference<d>> it = cVar.f39221a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().get().b(i);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            cVar.f39221a.clear();
        }
    }

    public static void a(c cVar, Bitmap bitmap, byte[] bArr) {
        synchronized (cVar.c) {
            Iterator<SoftReference<d>> it = cVar.f39221a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().get().a(bitmap, bArr, false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            cVar.f39221a.clear();
        }
    }

    @Override // com.kc.dw.cache.image.a
    public c a(d dVar) {
        boolean z;
        if (dVar == null) {
            return this;
        }
        try {
            synchronized (this.c) {
                Iterator<SoftReference<d>> it = this.f39221a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (it.next().get() == dVar) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f39221a.add(new SoftReference<>(dVar));
                }
            }
        } catch (Throwable unused) {
        }
        return this;
    }
}
