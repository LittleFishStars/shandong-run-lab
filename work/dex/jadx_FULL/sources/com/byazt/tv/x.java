package com.byazt.tv;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alipay.sdk.m.y.l;
import com.fl.saas.base.cache.DatabaseHelper;
import com.igexin.c.a.c.a.d;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 239, 71})
public class x extends c {
    public JSONObject gr;
    public JSONArray gt;
    public da gu;
    public long m;
    public a my;
    public JSONArray nu;
    public JSONArray qy;
    public long rh;
    public long rl;
    public byte[] t;
    public int u;
    public int yp;
    public JSONArray z;

    public void c(JSONObject jSONObject, a aVar, da daVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i) {
        c(0L);
        this.gr = jSONObject;
        this.my = aVar;
        this.gu = daVar;
        this.qy = jSONArray;
        this.z = jSONArrayArr[0];
        this.m = jArr[0];
        this.nu = jSONArrayArr[1];
        this.rh = jArr[1];
        this.gt = jSONArrayArr[2];
        this.rl = jArr[2];
        this.da = i;
    }

    public byte[] da() {
        this.t = null;
        try {
            byte[] bArrC = com.byazt.yv.uj.c(a().toString());
            this.t = bArrC;
            return bArrC;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                tt.C0538tt[] c0538ttArr = tt.ve;
                if (i >= c0538ttArr.length) {
                    throw new RuntimeException(sb.toString(), e);
                }
                tt.C0538tt c0538tt = c0538ttArr[i];
                if (c0538tt != null) {
                    sb.append(c0538tt.toString());
                    sb.append(l.b);
                }
                i++;
            }
        }
    }

    @Override // com.byazt.tv.c
    public JSONObject tt() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.gr);
        jSONObject.put("time_sync", com.byazt.mp.c.c);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.my != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.my.a());
            jSONObject.put("launch", jSONArray);
        }
        da daVar = this.gu;
        int i = 0;
        if (daVar != null) {
            JSONObject jSONObjectA = daVar.a();
            JSONArray jSONArray2 = this.qy;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i2 = 0;
            long j = 0;
            while (i2 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.qy.optString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(i, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt("duration", i) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                int i3 = length;
                long jOptLong = jSONObject2.optLong("local_time_ms", 0L);
                if (jOptLong > j) {
                    jSONObjectA.put("$page_title", jSONObject3.optString("page_title", ""));
                    jSONObjectA.put("$page_key", jSONObject3.optString("page_key", ""));
                    j = jOptLong;
                }
                i2++;
                length = i3;
                i = 0;
            }
            if (length > 0) {
                jSONObjectA.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectA);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.z;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.z);
        }
        JSONArray jSONArray7 = this.qy;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.nu;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.nu);
        }
        JSONArray jSONArray9 = this.gt;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put(d.d, this.gt);
        }
        StringBuilder sb = new StringBuilder("pack {");
        sb.append("ts:");
        sb.append(this.tt);
        sb.append(", la:");
        Object obj = this.my;
        if (obj == null) {
            obj = "0";
        }
        sb.append(obj);
        sb.append(", te:");
        da daVar2 = this.gu;
        sb.append(daVar2 != null ? daVar2 : "0");
        sb.append(", p:");
        sb.append(length3);
        sb.append(", v1:");
        sb.append(length2);
        sb.append(", v3:");
        sb.append(length4);
        sb.append(", m:");
        sb.append(length5);
        com.byazt.yv.da.c(sb.toString());
        return jSONObject;
    }

    @Override // com.byazt.tv.c
    @NonNull
    public String uj() {
        return "pack";
    }

    @Override // com.byazt.tv.c
    public String x() {
        return String.valueOf(this.c);
    }

    @Override // com.byazt.tv.c
    public List<String> c() {
        return Arrays.asList(DatabaseHelper.COLUMN_ID, "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "_fail", TypedValues.Custom.S_INT, "event_type", TypedValues.Custom.S_INT);
    }

    @Override // com.byazt.tv.c
    public int c(@NonNull Cursor cursor) {
        this.c = cursor.getLong(0);
        this.tt = cursor.getLong(1);
        this.t = cursor.getBlob(2);
        this.u = cursor.getInt(3);
        this.da = cursor.getInt(4);
        this.uj = "";
        this.gr = null;
        this.my = null;
        this.gu = null;
        this.qy = null;
        this.z = null;
        this.nu = null;
        this.gt = null;
        return 5;
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.tt));
        contentValues.put("_data", da());
        contentValues.put("event_type", Integer.valueOf(this.da));
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull JSONObject jSONObject) {
        com.byazt.yv.da.tt((Throwable) null);
    }

    @Override // com.byazt.tv.c
    public c tt(@NonNull JSONObject jSONObject) {
        com.byazt.yv.da.tt((Throwable) null);
        return null;
    }
}
