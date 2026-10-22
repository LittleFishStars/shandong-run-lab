package com.igexin.push.core.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38006a = "MsgSPManager";
    private static final String b = "gx_msg_sp";
    private static final String c = "taskIdList";
    private static final String d = "gx_vendor_token";
    private static final String e = "tokeninfo";
    private static final String f = "usfdl";
    private static final Object h = new Object();
    private static final Object i = new Object();
    private static volatile d j;
    private SharedPreferences g;

    private d(Context context) {
        if (context != null) {
            this.g = context.getSharedPreferences(b, 0);
        }
    }

    public static d a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (j == null) {
            synchronized (d.class) {
                if (j == null) {
                    j = new d(applicationContext);
                }
            }
        }
        return j;
    }

    private void a(String str, Object obj) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        }
        editorEdit.apply();
    }

    private Object b(String str, Object obj) {
        return obj instanceof String ? this.g.getString(str, (String) obj) : obj;
    }

    private static void b(JSONObject jSONObject) {
        try {
            if (jSONObject.length() < 150) {
                return;
            }
            Iterator<String> itKeys = jSONObject.keys();
            boolean z = false;
            long j2 = Long.MAX_VALUE;
            String str = null;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                long j3 = jSONObject.getLong(next);
                if (j2 > j3) {
                    str = next;
                    j2 = j3;
                }
                if (j3 < System.currentTimeMillis() - 432000000) {
                    itKeys.remove();
                    z = true;
                }
            }
            if (z || str == null) {
                return;
            }
            jSONObject.remove(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void c(String str) {
        try {
            a(d, str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void c(JSONObject jSONObject) {
        try {
            if (jSONObject.length() < 20) {
                return;
            }
            Iterator<String> itKeys = jSONObject.keys();
            boolean z = false;
            long j2 = Long.MAX_VALUE;
            String str = null;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                long j3 = Long.parseLong(jSONObject.getJSONObject(next).getString("timestamp"));
                if (j2 > j3) {
                    str = next;
                    j2 = j3;
                }
                if (j3 < System.currentTimeMillis() - 432000000) {
                    itKeys.remove();
                    z = true;
                }
            }
            if (z || str == null) {
                return;
            }
            jSONObject.remove(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private JSONObject d() {
        try {
            String str = (String) b(c, "");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private JSONObject e() {
        try {
            String str = (String) b(f, "");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private String f() {
        try {
            return (String) b(d, null);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    public final JSONObject a() {
        synchronized (h) {
            try {
                String str = (String) b(f, "");
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(itKeys.next());
                    if (!jSONObject2.has("timestamp") || Long.parseLong(jSONObject2.getString("timestamp")) < System.currentTimeMillis() - 432000000) {
                        itKeys.remove();
                    }
                }
                return jSONObject;
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return null;
            }
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        if (this.g == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (h) {
            try {
                JSONObject jSONObjectE = e();
                if (jSONObjectE == null) {
                    jSONObjectE = new JSONObject();
                }
                if (jSONObjectE.length() > 0) {
                    c(jSONObjectE);
                }
                jSONObjectE.put(str, jSONObject);
                a(f, jSONObjectE.toString());
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            a(e, jSONObject.toString());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    public final boolean a(String str) {
        if (this.g != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObjectD = d();
                if (jSONObjectD != null && jSONObjectD.has(str)) {
                    com.igexin.c.a.c.a.a("sp task " + str + " already exists", new Object[0]);
                    return true;
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
        return false;
    }

    public final void b() {
        synchronized (h) {
            try {
                if (this.g != null) {
                    a(f, "");
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    public final void b(String str) {
        if (this.g == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (i) {
            try {
                JSONObject jSONObjectD = d();
                if (jSONObjectD == null) {
                    jSONObjectD = new JSONObject();
                }
                if (jSONObjectD.length() > 0) {
                    b(jSONObjectD);
                }
                jSONObjectD.put(str, System.currentTimeMillis());
                a(c, jSONObjectD.toString());
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    public final JSONObject c() {
        try {
            String strValueOf = String.valueOf(b(e, ""));
            return strValueOf.isEmpty() ? new JSONObject() : new JSONObject(strValueOf);
        } catch (JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            return new JSONObject();
        }
    }
}
