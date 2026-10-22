package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class ac {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static <T> JSONArray Y(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (T t : list) {
                        if (t != null) {
                            if (t instanceof JSONObject) {
                                jSONArray.put(t);
                            } else if (t instanceof com.kwad.sdk.core.b) {
                                jSONArray.put(((com.kwad.sdk.core.b) t).toJson());
                            } else {
                                if (!(t instanceof String)) {
                                    throw new IllegalArgumentException("<T> now suppprt type: " + t.getClass().getName());
                                }
                                jSONArray.put(t);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return jSONArray;
    }

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static <T extends com.kwad.sdk.core.b> T b(@Nullable String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        T t = (T) cVar.IA();
        try {
            if (TextUtils.isEmpty(str)) {
                return t;
            }
            try {
                t.parseJson(new JSONObject(str));
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return t;
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        return ad.h(jSONArray);
    }

    public static <T> List<T> hL(String str) {
        return ad.hL(str);
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        return ad.parseJSON2MapString(str);
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        return ad.parseMap2JSON(map);
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        ad.putValue(jSONObject, str, str2);
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        return ad.toJsonArray(list);
    }

    public static JSONArray a(JSONArray jSONArray, JSONObject jSONObject) {
        try {
            jSONArray.put(jSONObject);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return jSONArray;
    }

    public static void putValue(JSONObject jSONObject, String str, double d) {
        if (jSONObject == null) {
            return;
        }
        ad.putValue(jSONObject, str, d);
    }

    public static void putValue(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null) {
            return;
        }
        ad.putValue(jSONObject, str, i);
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        try {
            ad.a(jSONObject, jSONObject2, z);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f) {
        if (jSONObject == null) {
            return;
        }
        ad.putValue(jSONObject, str, f);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b) {
        if (jSONObject == null) {
            return;
        }
        ad.putValue(jSONObject, str, b);
    }

    public static <T extends com.kwad.sdk.core.b> List<T> a(String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.kwad.sdk.core.b bVarIA = cVar.IA();
                bVarIA.parseJson(jSONObject);
                arrayList.add(bVarIA);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return arrayList;
    }

    public static void putValue(JSONObject jSONObject, String str, long j) {
        if (jSONObject == null) {
            return;
        }
        ad.putValue(jSONObject, str, j);
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null) {
            return;
        }
        ad.putValue(jSONObject, str, z);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        ad.putValue(jSONObject, str, jSONObject2);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null) {
            return;
        }
        ad.putValue(jSONObject, str, jSONArray);
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            boolean z = false;
            for (Object obj : list) {
                if (obj instanceof com.kwad.sdk.core.b) {
                    a(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
                } else if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof JSONObject) && !(obj instanceof JSONArray) && !(obj instanceof Double) && !(obj instanceof Boolean)) {
                    if (!(obj instanceof Float)) {
                        break;
                    } else {
                        try {
                            jSONArray.put(((Float) obj).floatValue());
                        } catch (JSONException unused) {
                        }
                    }
                } else {
                    jSONArray.put(obj);
                }
                z = true;
            }
            if (z) {
                putValue(jSONObject, str, jSONArray);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.b bVar, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            bVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }
}
