package com.byazt.vm;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 145})
public final class my {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f29135a;
    public final String c;
    public final Long n;
    public final Long sp;
    public final String tt;
    public final Long uj;
    public final Boolean ve;

    public my(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.c = str;
        this.tt = str2;
        this.ve = bool;
        this.uj = l;
        this.n = l2;
        this.f29135a = num;
        this.sp = l3;
    }

    @NonNull
    public Map<String, String> c() {
        HashMap map = new HashMap();
        m.c(map, "id", this.c);
        m.c(map, "req_id", this.tt);
        m.c(map, "is_track_limited", String.valueOf(this.ve));
        m.c(map, "take_ms", String.valueOf(this.uj));
        m.c(map, "time", String.valueOf(this.n));
        m.c(map, "query_times", String.valueOf(this.f29135a));
        m.c(map, "hw_id_version_code", String.valueOf(this.sp));
        return map;
    }

    public String toString() {
        return tt().toString();
    }

    @NonNull
    public JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        m.c(jSONObject, "id", this.c);
        m.c(jSONObject, "req_id", this.tt);
        m.c(jSONObject, "is_track_limited", this.ve);
        m.c(jSONObject, "take_ms", this.uj);
        m.c(jSONObject, "time", this.n);
        m.c(jSONObject, "query_times", this.f29135a);
        m.c(jSONObject, "hw_id_version_code", this.sp);
        return jSONObject;
    }

    @Nullable
    @AnyThread
    public static my c(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new my(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            com.byazt.yv.da.c(e);
            return null;
        }
    }
}
