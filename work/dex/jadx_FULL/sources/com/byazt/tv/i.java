package com.byazt.tv;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 239, 42})
public class i extends c {
    public String gt;
    public String m;
    public int my;
    public String nu;
    public String rh;
    public long t;
    public String u;
    public String yp;
    public String z;

    private JSONObject t() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.yp);
        jSONObject.put("refer_page_key", this.u);
        jSONObject.put("is_back", this.my);
        jSONObject.put("duration", this.t);
        jSONObject.put("page_title", this.z);
        jSONObject.put("refer_page_title", this.m);
        jSONObject.put("page_path", this.nu);
        jSONObject.put("referrer_page_path", this.rh);
        return jSONObject;
    }

    @Override // com.byazt.tv.c
    public List<String> c() {
        List<String> listC = super.c();
        ArrayList arrayList = new ArrayList(listC.size());
        arrayList.addAll(listC);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar", "page_title", "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    public boolean da() {
        return this.t == -1;
    }

    public boolean sl() {
        return this.yp.contains(u15.f19942b);
    }

    @Override // com.byazt.tv.c
    public c tt(@NonNull JSONObject jSONObject) {
        super.tt(jSONObject);
        this.yp = jSONObject.optString("page_key", null);
        this.u = jSONObject.optString("refer_page_key", null);
        this.t = jSONObject.optLong("duration", 0L);
        this.my = jSONObject.optInt("is_back", 0);
        this.z = jSONObject.optString("page_title", null);
        this.m = jSONObject.optString("refer_page_title", null);
        this.nu = jSONObject.optString("page_path", null);
        this.rh = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    @Override // com.byazt.tv.c
    @NonNull
    public String uj() {
        return "page";
    }

    @Override // com.byazt.tv.c
    public String x() {
        return this.yp + ", " + this.t;
    }

    @Override // com.byazt.tv.c
    public int c(@NonNull Cursor cursor) {
        int iC = super.c(cursor);
        int i = iC + 1;
        this.yp = cursor.getString(iC);
        int i2 = i + 1;
        this.u = cursor.getString(i);
        int i3 = i2 + 1;
        this.t = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.my = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.gt = cursor.getString(i4);
        int i6 = i5 + 1;
        this.z = cursor.getString(i5);
        int i7 = i6 + 1;
        this.m = cursor.getString(i6);
        int i8 = i7 + 1;
        this.nu = cursor.getString(i7);
        int i9 = i8 + 1;
        this.rh = cursor.getString(i8);
        return i9;
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", t());
        jSONObject.put("datetime", this.sl);
        return jSONObject;
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put("page_key", this.yp);
        contentValues.put("refer_page_key", this.u);
        contentValues.put("duration", Long.valueOf(this.t));
        contentValues.put("is_back", Integer.valueOf(this.my));
        contentValues.put("last_session", this.gt);
        contentValues.put("page_title", this.z);
        contentValues.put("refer_page_title", this.m);
        contentValues.put("page_path", this.nu);
        contentValues.put("referrer_page_path", this.rh);
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull JSONObject jSONObject) throws JSONException {
        super.c(jSONObject);
        jSONObject.put("page_key", this.yp);
        jSONObject.put("refer_page_key", this.u);
        jSONObject.put("duration", this.t);
        jSONObject.put("is_back", this.my);
        jSONObject.put("page_title", this.z);
        jSONObject.put("refer_page_title", this.m);
        jSONObject.put("page_path", this.nu);
        jSONObject.put("referrer_page_path", this.rh);
    }
}
