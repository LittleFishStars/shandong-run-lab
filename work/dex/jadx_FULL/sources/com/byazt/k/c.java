package com.byazt.k;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.w.x;
import com.byazt.zz.Downloader;
import com.byazt.zz.ve;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 981, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f28717a;
    public static Boolean n;
    public static c sp;
    public static JSONObject uj;
    public static JSONObject ve;
    public final Boolean da;
    public final JSONObject i;
    public int sl;
    public final JSONObject x;
    public static final x<Integer, c> c = new x<>(16, 16);
    public static final c tt = new c(null);

    static {
        c();
    }

    private c(JSONObject jSONObject) {
        Boolean bool;
        this.x = jSONObject;
        JSONObject jSONObject2 = null;
        boolValueOf = null;
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (jSONObject == null || a("bugfix")) {
            bool = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("default") && !a("default")) {
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool2 = boolValueOf;
            jSONObject2 = jSONObjectOptJSONObject;
            bool = bool2;
        }
        this.i = jSONObject2;
        this.da = bool;
    }

    public static boolean a(String str) {
        JSONObject jSONObject = ve;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public static void c() {
        Boolean boolValueOf;
        JSONObject jSONObjectZb = ve.zb();
        f28717a = jSONObjectZb.optInt("disable_task_setting", 0) == 1;
        ve = jSONObjectZb.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectZb.optJSONObject("bugfix");
        if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("default")) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
        }
        uj = jSONObjectOptJSONObject;
        n = boolValueOf;
    }

    @NonNull
    public static JSONObject tt() {
        return ve.zb();
    }

    @NonNull
    public static c ve() {
        return tt;
    }

    public JSONArray n(String str) {
        JSONObject jSONObject = this.x;
        return (jSONObject == null || !jSONObject.has(str) || a(str)) ? tt().optJSONArray(str) : this.x.optJSONArray(str);
    }

    public JSONObject uj(String str) {
        JSONObject jSONObject = this.x;
        return (jSONObject == null || !jSONObject.has(str) || a(str)) ? tt().optJSONObject(str) : this.x.optJSONObject(str);
    }

    public boolean tt(String str, boolean z) {
        if (this.i != null && !a(str)) {
            if (this.i.has(str)) {
                return this.i.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.da;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = uj;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return uj.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = n;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String ve(String str) {
        return c(str, "");
    }

    private static c ve(int i) {
        DownloadInfo downloadInfo;
        if (f28717a) {
            return tt;
        }
        Context contextIc = ve.ic();
        if (contextIc != null && (downloadInfo = Downloader.getInstance(contextIc).getDownloadInfo(i)) != null) {
            return tt(downloadInfo);
        }
        return tt;
    }

    public static void c(String str, boolean z) {
        try {
            if (uj == null) {
                uj = new JSONObject();
            }
            uj.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static c c(int i) {
        return c(i, (DownloadInfo) null);
    }

    public int tt(String str) {
        return c(str, 0);
    }

    @NonNull
    public static c c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return tt;
        }
        return c(downloadInfo.getId(), downloadInfo);
    }

    public static void tt(int i) {
        c cVar = sp;
        if (cVar != null && cVar.sl == i) {
            sp = null;
        }
        x<Integer, c> xVar = c;
        synchronized (xVar) {
            xVar.remove(Integer.valueOf(i));
        }
    }

    private static c c(int i, DownloadInfo downloadInfo) {
        c cVarVe;
        c cVar = sp;
        if (cVar != null && cVar.sl == i) {
            return cVar;
        }
        x<Integer, c> xVar = c;
        synchronized (xVar) {
            cVarVe = xVar.get(Integer.valueOf(i));
        }
        if (cVarVe == null) {
            cVarVe = downloadInfo == null ? ve(i) : tt(downloadInfo);
            synchronized (xVar) {
                xVar.put(Integer.valueOf(i), cVarVe);
            }
        }
        cVarVe.sl = i;
        sp = cVarVe;
        return cVarVe;
    }

    private static c tt(DownloadInfo downloadInfo) {
        if (f28717a) {
            return tt;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new c(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return tt;
    }

    public boolean c(String str) {
        return tt(str, false);
    }

    public int c(String str, int i) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !a(str)) {
            return this.x.optInt(str, i);
        }
        return tt().optInt(str, i);
    }

    public long c(String str, long j) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !a(str)) {
            return this.x.optLong(str, j);
        }
        return tt().optLong(str, j);
    }

    public double c(String str, double d) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !a(str)) {
            return this.x.optDouble(str, d);
        }
        return tt().optDouble(str, d);
    }

    public String c(String str, String str2) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !a(str)) {
            return this.x.optString(str, str2);
        }
        return tt().optString(str, str2);
    }

    @NonNull
    public static c c(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != tt() && !f28717a) {
            c cVar = sp;
            if (cVar != null && cVar.x == jSONObject) {
                return cVar;
            }
            x<Integer, c> xVar = c;
            synchronized (xVar) {
                for (c cVar2 : xVar.values()) {
                    if (cVar2.x == jSONObject) {
                        sp = cVar2;
                        return cVar2;
                    }
                }
                c cVar3 = new c(jSONObject);
                sp = cVar3;
                return cVar3;
            }
        }
        return tt;
    }

    public static void c(int i, JSONObject jSONObject) {
        c next;
        if (jSONObject == null || jSONObject == tt() || f28717a) {
            return;
        }
        x<Integer, c> xVar = c;
        synchronized (xVar) {
            c cVar = sp;
            if (cVar != null && cVar.x == jSONObject) {
                cVar.sl = i;
            } else {
                Iterator<c> it = xVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.x == jSONObject) {
                        next.sl = i;
                        break;
                    }
                }
                if (next == null) {
                    cVar = new c(jSONObject);
                    cVar.sl = i;
                } else {
                    cVar = next;
                }
                sp = cVar;
            }
            c.put(Integer.valueOf(i), cVar);
        }
    }
}
