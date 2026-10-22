package com.byazt.tv;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kc.aw.lib.constants.PtgRewardConstant;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 239, 72})
public class da extends c {
    public long t;
    public long u;
    public String yp;
    public int z = 0;

    @Override // com.byazt.tv.c
    public int c(@NonNull Cursor cursor) {
        com.byazt.yv.da.tt((Throwable) null);
        return 0;
    }

    @Override // com.byazt.tv.c
    public List<String> c() {
        return null;
    }

    @Override // com.byazt.tv.c
    public JSONObject tt() throws JSONException {
        a aVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.tt);
        jSONObject.put("tea_event_index", this.ve);
        jSONObject.put("session_id", this.uj);
        jSONObject.put("stop_timestamp", this.u / 1000);
        jSONObject.put("duration", this.t / 1000);
        jSONObject.put("datetime", this.sl);
        long j = this.n;
        if (j > 0) {
            jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f29074a) ? JSONObject.NULL : this.f29074a);
        if (!TextUtils.isEmpty(this.sp)) {
            jSONObject.put("ssid", this.sp);
        }
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ab_sdk_version", this.x);
        }
        if (!TextUtils.isEmpty(this.yp)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.yp, this.uj)) {
                jSONObject.put("original_session_id", this.yp);
            }
        }
        if (this.z == 0 && (aVar = (a) tt.tt.get("launch")) != null && !aVar.gt) {
            this.z = 6;
        }
        jSONObject.put("launch_from", this.z);
        return jSONObject;
    }

    @Override // com.byazt.tv.c
    @NonNull
    public String uj() {
        return "terminate";
    }

    @Override // com.byazt.tv.c
    public String x() {
        return String.valueOf(this.t);
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull ContentValues contentValues) {
        com.byazt.yv.da.tt((Throwable) null);
    }

    @Override // com.byazt.tv.c
    public void c(@NonNull JSONObject jSONObject) {
        com.byazt.yv.da.tt((Throwable) null);
    }

    @Override // com.byazt.tv.c
    public c tt(@NonNull JSONObject jSONObject) {
        com.byazt.yv.da.tt((Throwable) null);
        return this;
    }
}
