package com.byazt.vl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.gj.sp;
import com.byazt.se.tt;
import com.byazt.yv.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 503, 20})
public class c extends com.byazt.iw.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f29133a;
    public final Map<String, com.byazt.co.c> n;

    public c(Context context, tt ttVar, com.byazt.az.c cVar) {
        super(context, ttVar, cVar);
        this.n = new HashMap();
        this.f29133a = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        for (Map.Entry<String, com.byazt.co.c> entry : this.n.entrySet()) {
            if (TextUtils.equals(entry.getKey(), "d_i0")) {
                JSONObject jSONObjectTt = entry.getValue().tt();
                sp spVarA = u.a();
                if (spVarA != null && jSONObjectTt != null) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectTt.optJSONObject("data");
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        arrayList.add(itKeys.next());
                    }
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    int[] iArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        iArr[i] = jSONObjectOptJSONObject.optInt(strArr[i]);
                    }
                    spVarA.c(strArr, iArr, false);
                    return;
                }
            }
        }
    }

    public void tt() {
        if (this.c.size() <= 0) {
            com.byazt.tf.c.c("__kite", "return");
            return;
        }
        for (int i = 0; i < this.c.size(); i++) {
            try {
                com.byazt.co.c cVar = this.c.get(i).get();
                this.n.put(cVar.c(), cVar);
                if (com.byazt.tf.c.tt()) {
                    com.byazt.tf.c.c("__kite", "result: ".concat(String.valueOf(cVar)));
                }
            } catch (Exception e) {
                com.byazt.tf.c.uj("__kite", "error " + e.getMessage());
            }
        }
    }

    @Override // com.byazt.iw.c
    public List<String> c() {
        this.f29133a.add("d_i0");
        this.f29133a.add("d_a0");
        return this.f29133a;
    }

    public void c(final JSONObject jSONObject, final String str) {
        com.byazt.tf.c.c("__kite", "doReport");
        com.byazt.ww.c.c().postDelayed(new Runnable() { // from class: com.byazt.vl.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tf.c.c("__kite", "run()");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObjectC = u.c(jSONObject, str);
                    String strC = c.this.ve.c("d_data");
                    if (TextUtils.isEmpty(strC)) {
                        JSONObject jSONObject3 = new JSONObject();
                        String strTt = u.tt(jSONObjectC);
                        jSONObject3.putOpt("header", strTt);
                        if (com.byazt.tf.c.tt()) {
                            com.byazt.tf.c.c("__kite", "config 请求header进行sword加密：加密内容：".concat(String.valueOf(jSONObjectC)));
                            com.byazt.tf.c.c("__kite", "config 请求header进行sword加密：加密结果：".concat(String.valueOf(strTt)));
                        }
                        jSONObject3.putOpt("fetch_config", Boolean.TRUE);
                        jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        jSONObject2 = com.byazt.ey.c.c(c.this.tt, jSONObject3, c.this.c(jSONObjectC));
                        com.byazt.tf.c.c("__kite", "config from server.");
                    } else {
                        jSONObject2.putOpt("message", "ok");
                        jSONObject2.putOpt("data", strC);
                        com.byazt.tf.c.c("__kite", "config from cache");
                    }
                    if (com.byazt.tf.c.tt()) {
                        com.byazt.tf.c.c("__kite", "config: ".concat(String.valueOf(jSONObject2)));
                    }
                    c.this.uj.c(jSONObject2);
                    c.this.c(5L);
                    c.this.tt();
                    c.this.ve();
                    c.this.tt(jSONObjectC);
                } catch (Exception e) {
                    com.byazt.tf.c.uj("__kite", "error " + e.getMessage());
                }
            }
        }, this.uj.ve());
    }

    public void c(long j) {
        Map<String, JSONObject> mapC = this.uj.c();
        if (mapC.isEmpty()) {
            com.byazt.tf.c.c("__kite", "map is empty");
        } else {
            c(mapC, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final JSONObject jSONObject) {
        if (this.n.size() <= 0) {
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, com.byazt.co.c> entry : this.n.entrySet()) {
            try {
                JSONObject jSONObjectTt = entry.getValue().tt();
                jSONObject2.putOpt(entry.getKey(), u.tt(jSONObjectTt));
                if (com.byazt.tf.c.tt()) {
                    com.byazt.tf.c.c("__kite", "report 请求data中的字段进行sword加密：加密内容：".concat(String.valueOf(jSONObjectTt)));
                }
            } catch (JSONException e) {
                com.byazt.tf.c.uj("__kite", "error " + e.getMessage());
            }
        }
        com.byazt.ww.c.c(new Runnable() { // from class: com.byazt.vl.c.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject.putOpt("device_type", Build.MODEL);
                    jSONObject.putOpt("device_platform", "android");
                    jSONObject3.putOpt("header", u.tt(jSONObject));
                    if (com.byazt.tf.c.tt()) {
                        com.byazt.tf.c.c("__kite", "report 请求header进行sword加密：加密内容：" + jSONObject);
                    }
                    jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    jSONObject3.putOpt("data", jSONObject2);
                    jSONObject3.putOpt("version", Integer.valueOf(c.this.uj.tt()));
                } catch (Exception e2) {
                    com.byazt.tf.c.c("__kite", "error: " + e2.getMessage());
                }
                JSONObject jSONObjectC = com.byazt.ey.c.c(c.this.tt, jSONObject3, c.this.c(jSONObject));
                if (com.byazt.tf.c.tt()) {
                    com.byazt.tf.c.ve("__kite", "response:".concat(String.valueOf(jSONObjectC)));
                }
                c.this.uj.tt(jSONObjectC);
            }
        });
    }
}
