package com.byazt.tv;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kc.aw.lib.constants.PtgRewardConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 239, 15})
public class uj extends c {

    @NonNull
    public String t;

    @NonNull
    public String u;

    public uj(@NonNull String str, @NonNull JSONObject jSONObject) {
        this.u = str;
        this.t = jSONObject.toString();
        this.da = 0;
    }

    @Override // com.byazt.tv.c
    public List<String> c() {
        List<String> listC = super.c();
        ArrayList arrayList = new ArrayList(listC.size());
        arrayList.addAll(listC);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.byazt.tv.c
    public String i() {
        return this.t;
    }

    @Override // com.byazt.tv.c
    public JSONObject tt() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.tt);
        jSONObject.put("tea_event_index", this.ve);
        jSONObject.put("session_id", this.uj);
        long j = this.n;
        if (j > 0) {
            jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f29074a) ? JSONObject.NULL : this.f29074a);
        if (!TextUtils.isEmpty(this.sp)) {
            jSONObject.put("ssid", this.sp);
        }
        jSONObject.put("log_type", this.u);
        try {
            JSONObject jSONObject2 = new JSONObject(this.t);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    com.byazt.yv.da.tt("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            com.byazt.yv.da.ve("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.byazt.tv.c
    @NonNull
    public String uj() {
        return "event_misc";
    }

    @Override // com.byazt.tv.c
    public String x() {
        return "param:" + this.t + " logType:" + this.u;
    }

    @Override // com.byazt.tv.c
    public int c(@NonNull Cursor cursor) {
        int iC = super.c(cursor);
        int i = iC + 1;
        this.t = cursor.getString(iC);
        int i2 = i + 1;
        this.u = cursor.getString(i);
        return i2;
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put("params", this.t);
        contentValues.put("log_type", this.u);
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull JSONObject jSONObject) throws JSONException {
        super.c(jSONObject);
        jSONObject.put("params", this.t);
        jSONObject.put("log_type", this.u);
    }

    @Override // com.byazt.tv.c
    public c tt(@NonNull JSONObject jSONObject) {
        super.tt(jSONObject);
        this.t = jSONObject.optString("params", null);
        this.u = jSONObject.optString("log_type", null);
        return this;
    }
}
