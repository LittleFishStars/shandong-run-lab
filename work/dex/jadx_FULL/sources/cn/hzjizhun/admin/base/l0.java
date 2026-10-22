package cn.hzjizhun.admin.base;

import android.text.TextUtils;
import com.zj.adlib.bv9;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22702a;

    public void a(int i, String str) {
    }

    public void b(String str) {
        if (TextUtils.isEmpty(this.f22702a) || !(this.f22702a.contains(d.f22698a) || this.f22702a.contains(d.b))) {
            e(str);
            return;
        }
        String strA = g.a(str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strA);
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString("msg");
            if (iOptInt != 0) {
                if (iOptInt != 2450 && iOptInt != 2451) {
                    a(iOptInt, strOptString);
                    return;
                }
                return;
            }
            if (jSONObject.has("data")) {
                String string = jSONObject.getString("data");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                if (string.startsWith(bv9.b)) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        d(jSONObjectOptJSONObject);
                        return;
                    }
                    return;
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                if (jSONArrayOptJSONArray != null) {
                    c(jSONArrayOptJSONArray);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void c(JSONArray jSONArray) {
    }

    public void d(JSONObject jSONObject) {
    }

    public void e(String str) {
    }
}
