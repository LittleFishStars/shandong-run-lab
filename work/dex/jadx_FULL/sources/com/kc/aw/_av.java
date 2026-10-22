package com.kc.aw;

import com.heytap.mcssdk.constant.b;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _av {
    public ArrayList _a = new ArrayList();
    public String _b;
    public String _c;

    public final _av _a(JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("target");
            this._a.clear();
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String string = jSONArrayOptJSONArray.getString(i);
                    if (string != null) {
                        this._a.add(string);
                    }
                }
            }
            this._b = jSONObject.optString("targetHash");
            this._c = jSONObject.optString(b.p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public final boolean _a() {
        return (this._a.isEmpty() || this._c.isEmpty()) ? false : true;
    }
}
