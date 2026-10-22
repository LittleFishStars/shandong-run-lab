package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bq;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> aMW = new ConcurrentHashMap();
    private static SharedPreferences aMX = null;

    private static SharedPreferences Ji() {
        if (aMX == null) {
            aMX = bq.m1068if("ksadsdk_config");
        }
        return aMX;
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> setEi = ei(key);
        if (setEi == null) {
            setEi = new CopyOnWriteArraySet<>();
            aMW.put(key, setEi);
        }
        setEi.add(bVar);
    }

    @WorkerThread
    public static synchronized void bL(Context context) {
        try {
            SharedPreferences sharedPreferencesJi = Ji();
            if (sharedPreferencesJi != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesJi.edit();
                a(editorEdit);
                editorEdit.commit();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @WorkerThread
    public static synchronized void bM(Context context) {
        SharedPreferences sharedPreferencesJi = Ji();
        if (sharedPreferencesJi != null) {
            a(sharedPreferencesJi);
        }
    }

    @Nullable
    private static Set<com.kwad.sdk.core.config.item.b> ei(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return aMW.get(str);
    }

    public static void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : aMW.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = aMW.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.l(jSONObject);
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = aMW.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = aMW.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            Iterator<String> it = aMW.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = aMW.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences sharedPreferencesJi;
        if (bVar == null || (sharedPreferencesJi = Ji()) == null) {
            return;
        }
        try {
            bVar.a(sharedPreferencesJi);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
