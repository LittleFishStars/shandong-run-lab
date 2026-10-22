package com.byazt.xz;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.mg.da;
import com.byazt.mg.yp;
import com.byazt.nr.m;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1730, 20})
public class c {
    public JSONObject c;

    public c() {
        this.c = new JSONObject();
    }

    public static c c(long j, Context context, @Nullable Thread thread, @NonNull Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        c cVar = new c();
        cVar.c("isJava", (Object) 1);
        cVar.c("event_type", "java_crash");
        cVar.c("timestamp", Long.valueOf(System.currentTimeMillis()));
        cVar.c("data", yp.c(th));
        cVar.c("isOOM", Boolean.valueOf(yp.tt(th)));
        cVar.c("crash_time", Long.valueOf(j));
        cVar.c(ContentProviderManager.PLUGIN_PROCESS_NAME, com.byazt.mg.c.uj(context));
        if (!com.byazt.mg.c.tt(context)) {
            cVar.c("remote_process", (Object) 1);
        }
        com.byazt.mg.c.c(context, cVar.c());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            cVar.c("crash_thread_name", name);
        }
        cVar.c("all_thread_stacks", yp.c(name));
        return cVar;
    }

    public c tt(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    da.tt(e);
                }
            }
            try {
                this.c.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                m.c(e2);
            }
        }
        return this;
    }

    public c ve(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                    m.c(e);
                }
            }
            c("filters", jSONObject);
        }
        return this;
    }

    public c(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public c tt(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        c("logcat", jSONArray);
        return this;
    }

    public JSONObject c() {
        return this.c;
    }

    public c c(tt ttVar) {
        c("header", ttVar.c());
        return this;
    }

    public c c(long j) {
        try {
            c(CropKey.RESULT_KEY_START_TIME, Long.valueOf(j));
            c("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            m.c(e);
        }
        return this;
    }

    public c c(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            c("session_id", str);
        }
        return this;
    }

    public c c(com.byazt.ia.tt ttVar) {
        c("activity_trace", ttVar.c());
        c("running_tasks", ttVar.tt());
        return this;
    }

    public c c(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            if (map == null) {
                this.c.put("plugin_info", jSONArray);
                return this;
            }
            for (String str : map.keySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("package_name", str);
                jSONObject.put("version_code", map.get(str));
                jSONArray.put(jSONObject);
            }
            this.c.put("plugin_info", jSONArray);
            return this;
        } catch (Exception unused) {
        }
    }

    public c c(int i, String str) {
        try {
            this.c.put("miniapp_id", i);
            this.c.put("miniapp_version", str);
        } catch (JSONException e) {
            m.c(e);
        }
        return this;
    }

    public c c(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            c("patch_info", jSONArray);
            return this;
        }
        c("patch_info", jSONArray);
        return this;
    }

    public c c(JSONObject jSONObject) {
        c("storage", jSONObject);
        return this;
    }

    public void c(@NonNull String str, @Nullable Object obj) {
        try {
            this.c.put(str, obj);
        } catch (Exception e) {
            da.tt(e);
        }
    }
}
