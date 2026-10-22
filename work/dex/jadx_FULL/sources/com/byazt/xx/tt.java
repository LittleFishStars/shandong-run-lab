package com.byazt.xx;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1007, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f29194a;
    public List<Integer> c;
    public String n;
    public int sp;
    public JSONObject tt;
    public String uj;
    public int ve;

    public tt(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("behavior_state");
        if (jSONArrayOptJSONArray != null) {
            this.c = new LinkedList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    this.c.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i)));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("rule_excs");
        if (jSONObjectOptJSONObject != null) {
            this.sp = jSONObjectOptJSONObject.optInt("condition");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("perform");
            this.tt = jSONObjectOptJSONObject2;
            if (jSONObjectOptJSONObject2 != null) {
                this.ve = jSONObjectOptJSONObject2.optInt("condition");
                this.uj = this.tt.optString("opt");
                this.n = this.tt.optString("rule_id");
                this.f29194a = this.tt.optString("rule_timestamp");
            }
        }
    }

    public String a() {
        return this.uj;
    }

    public int c() {
        return this.ve;
    }

    public JSONObject n() {
        return this.tt;
    }

    public boolean sp() {
        return "1".equals(this.uj) || "2".equals(this.uj) || "3".equals(this.uj) || "4".equals(this.uj) || "5".equals(this.uj);
    }

    public int tt() {
        return this.sp;
    }

    public String uj() {
        return this.f29194a;
    }

    public String ve() {
        return this.n;
    }

    public boolean c(int i) {
        List<Integer> list = this.c;
        if (list != null) {
            return list.contains(Integer.valueOf(i));
        }
        return false;
    }

    public double tt(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.tt) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2)) == null || (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("srr")) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : jSONObjectOptJSONObject3.optDouble(str, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public boolean c(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = this.tt.optJSONObject("prime_rits");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(str)) == null) {
            return false;
        }
        return (jSONObjectOptJSONObject.optJSONObject("ssr") == null && jSONObjectOptJSONObject.optJSONObject("srr") == null) ? false : true;
    }

    public double c(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.tt) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2)) == null || (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("ssr")) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : jSONObjectOptJSONObject3.optDouble(str, AudioStats.AUDIO_AMPLITUDE_NONE);
    }
}
