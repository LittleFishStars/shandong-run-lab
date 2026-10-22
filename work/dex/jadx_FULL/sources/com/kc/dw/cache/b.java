package com.kc.dw.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.kc.dw.cache.image.a> f39219a = new ConcurrentHashMap<>();

    public static void a(String str, d dVar) {
        Bitmap bitmapDecodeByteArray;
        if (TextUtils.isEmpty(str)) {
            dVar.b(0);
            return;
        }
        try {
            File fileA = com.kc.dw.core.bquery.c.a(str, (String) null);
            if (fileA != null && fileA.exists() && fileA.length() > 0) {
                if (System.currentTimeMillis() - fileA.lastModified() < 86400000) {
                    byte[] bArrA = com.kc.dw.core.bquery.c.a(fileA.getAbsolutePath());
                    if (bArrA != null && bArrA.length > 0 && (bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length)) != null) {
                        dVar.a(bitmapDecodeByteArray, bArrA, true);
                        return;
                    }
                } else {
                    try {
                        fileA.delete();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            String strB = com.kc.dw.core.bquery.c.b(str);
            ConcurrentHashMap<String, com.kc.dw.cache.image.a> concurrentHashMap = f39219a;
            if (concurrentHashMap.containsKey(strB)) {
                concurrentHashMap.get(strB).a(dVar);
                dVar.a();
            } else {
                com.kc.dw.cache.image.c cVarA = new com.kc.dw.cache.image.c(str, new a(str)).a(dVar);
                concurrentHashMap.put(strB, cVarA);
                z.a(cVarA.b, (x) new com.kc.dw.cache.image.b(cVarA), false);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            dVar.b(9);
        }
    }
}
