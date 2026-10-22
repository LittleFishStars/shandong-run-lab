package com.kwad.sdk.components;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    private static final Map<Class, b> aKJ = new ConcurrentHashMap();

    public static void a(Class cls, b bVar) {
        aKJ.put(cls, bVar);
    }

    @Nullable
    public static DevelopMangerComponents.DevelopValue dO(String str) {
        return null;
    }

    @Nullable
    public static <T extends b> T f(Class<T> cls) {
        Map<Class, b> map = aKJ;
        T t = (T) map.get(cls);
        if (t != null) {
            return t;
        }
        try {
            if (!DevelopMangerComponents.class.isAssignableFrom(cls)) {
                return null;
            }
            f fVar = new f();
            map.put(cls, fVar);
            return fVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void init(Context context) {
        ArrayList<b> arrayList = new ArrayList(aKJ.values());
        Collections.sort(arrayList, new Comparator<b>() { // from class: com.kwad.sdk.components.d.1
            private static int a(b bVar, b bVar2) {
                if (bVar == null) {
                    return -1;
                }
                if (bVar2 == null) {
                    return 1;
                }
                try {
                    try {
                        return bVar.priority() - bVar2.priority();
                    } catch (Exception unused) {
                        return 1;
                    }
                } catch (Exception unused2) {
                    return -1;
                }
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(b bVar, b bVar2) {
                return a(bVar, bVar2);
            }
        });
        for (b bVar : arrayList) {
            if (bVar != null) {
                try {
                    bVar.init(context);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }
}
