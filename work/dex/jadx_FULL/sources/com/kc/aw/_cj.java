package com.kc.aw;

import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cj {
    public String _f;
    public HashMap _e = new HashMap();
    public HashMap _d = new HashMap();
    public HashMap _a = new HashMap();
    public HashMap _b = new HashMap();
    public HashMap _c = new HashMap();

    @Keep
    public static final class _a {
        public boolean _a;
        public int _b;

        public _a(boolean z, int i) {
            this._a = z;
            this._b = i;
        }
    }

    public final boolean _a(String str, _cn _cnVar) {
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("slotBiddings");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        _cm _cmVar = new _cm();
                        _cmVar._a(jSONObjectOptJSONObject, _cnVar);
                        String str2 = _cmVar._a;
                        this._c.put(str2, new _a(_cmVar._c, _cmVar._d));
                        this._d.put(str2, Integer.valueOf(_cmVar._f));
                        for (_cl _clVar : _cmVar._v) {
                            List arrayList = (List) this._a.get(str2);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                this._a.put(str2, arrayList);
                            }
                            arrayList.add(_clVar);
                        }
                        HashMap map = _cmVar._w;
                        if (map != null) {
                            this._b.put(str2, map);
                        }
                        this._e.put(str2, _cmVar);
                    }
                }
            }
            this._f = str;
            return true;
        } catch (JSONException e) {
            Logger.e(e.getMessage());
            return false;
        }
    }
}
