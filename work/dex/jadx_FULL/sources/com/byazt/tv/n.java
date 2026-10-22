package com.byazt.tv;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kc.aw.lib.constants.PtgRewardConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 239, 46})
public class n extends c {
    public String t;
    public String u;
    public boolean yp;

    public n(String str, boolean z, String str2) {
        this.u = str;
        this.yp = z;
        this.t = str2;
        this.da = 0;
    }

    @Override // com.byazt.tv.c
    public List<String> c() {
        List<String> listC = super.c();
        ArrayList arrayList = new ArrayList(listC.size());
        arrayList.addAll(listC);
        arrayList.addAll(Arrays.asList("event", "varchar", "params", "varchar", "is_bav", TypedValues.Custom.S_INT));
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
        jSONObject.put("event", this.u);
        if (this.yp) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.t)) {
            jSONObject.put("params", new JSONObject(this.t));
        }
        jSONObject.put("datetime", this.sl);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ab_sdk_version", this.x);
        }
        return jSONObject;
    }

    @Override // com.byazt.tv.c
    @NonNull
    public String uj() {
        return "eventv3";
    }

    @Override // com.byazt.tv.c
    public String x() {
        return this.u;
    }

    @Override // com.byazt.tv.c
    public int c(@NonNull Cursor cursor) {
        int iC = super.c(cursor);
        int i = iC + 1;
        this.u = cursor.getString(iC);
        int i2 = i + 1;
        this.t = cursor.getString(i);
        int i3 = i2 + 1;
        this.yp = cursor.getInt(i2) == 1;
        return i3;
    }

    public n(String str, boolean z, String str2, int i) {
        this.u = str;
        this.yp = z;
        this.t = str2;
        this.da = i;
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put("event", this.u);
        contentValues.put("params", this.t);
        contentValues.put("is_bav", Integer.valueOf(this.yp ? 1 : 0));
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull JSONObject jSONObject) throws JSONException {
        super.c(jSONObject);
        jSONObject.put("event", this.u);
        jSONObject.put("params", this.t);
        jSONObject.put("is_bav", this.yp);
    }

    @Override // com.byazt.tv.c
    public c tt(@NonNull JSONObject jSONObject) {
        super.tt(jSONObject);
        this.u = jSONObject.optString("event", null);
        this.t = jSONObject.optString("params", null);
        this.yp = jSONObject.optBoolean("is_bav", false);
        return this;
    }
}
