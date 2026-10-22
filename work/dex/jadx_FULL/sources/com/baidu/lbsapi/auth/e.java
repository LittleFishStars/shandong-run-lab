package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26306a;
    private HashMap b = null;
    private a c = null;

    public interface a {
        void a(Object obj);
    }

    public e(Context context) {
        this.f26306a = context;
    }

    private HashMap a(HashMap map) {
        HashMap map2 = new HashMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String string = ((String) it.next()).toString();
            map2.put(string, map.get(string));
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(jSONObject.toString());
        }
    }

    public void a(HashMap map, String str, int i, String str2, String str3, a aVar) {
        this.b = a(map);
        this.c = aVar;
        new Thread(new f(this, str, i, str2, str3)).start();
    }
}
