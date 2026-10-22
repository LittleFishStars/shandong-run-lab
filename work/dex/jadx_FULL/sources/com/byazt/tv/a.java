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
@com.byazt.zqa.c(c = {0, 1, 239, 34})
public class a extends c {
    public boolean gt;
    public int m;
    public boolean my;
    public String nu;
    public String rh;
    public int t;
    public String u;
    public boolean yp;
    public String z;

    public a(boolean z) {
        this.gt = z;
    }

    @Override // com.byazt.tv.c
    public List<String> c() {
        List<String> listC = super.c();
        ArrayList arrayList = new ArrayList(listC.size());
        arrayList.addAll(listC);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar", "is_first_time", TypedValues.Custom.S_INT, "page_title", "varchar", "page_key", "varchar", "resume_from_background", TypedValues.Custom.S_INT));
        return arrayList;
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
        boolean z = this.yp;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.sl);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ab_sdk_version", this.x);
        }
        if (!TextUtils.isEmpty(this.z)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.z);
        }
        if (this.m == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$resume_from_background", !this.gt);
        jSONObject.put("is_background", !this.gt);
        return jSONObject;
    }

    @Override // com.byazt.tv.c
    @NonNull
    public String uj() {
        return "launch";
    }

    @Override // com.byazt.tv.c
    public String x() {
        return this.yp ? "bg" : "fg";
    }

    @Override // com.byazt.tv.c
    public int c(@NonNull Cursor cursor) {
        int iC = super.c(cursor);
        int i = iC + 1;
        this.u = cursor.getString(iC);
        int i2 = i + 1;
        this.t = cursor.getInt(i);
        int i3 = i2 + 1;
        this.z = cursor.getString(i2);
        int i4 = i3 + 1;
        this.m = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.nu = cursor.getString(i4);
        int i6 = i5 + 1;
        this.rh = cursor.getString(i5);
        int i7 = i6 + 1;
        this.my = cursor.getInt(i6) == 0;
        return i7;
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put("ver_name", this.u);
        contentValues.put("ver_code", Integer.valueOf(this.t));
        contentValues.put("last_session", this.z);
        contentValues.put("is_first_time", Integer.valueOf(this.m));
        contentValues.put("page_title", this.nu);
        contentValues.put("page_key", this.rh);
        contentValues.put("resume_from_background", Integer.valueOf(this.my ? 1 : 0));
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
