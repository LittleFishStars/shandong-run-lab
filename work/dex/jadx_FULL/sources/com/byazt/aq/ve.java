package com.byazt.aq;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.nr.m;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1950, 54})
public class ve {
    public HashMap<String, Object> c = new HashMap<>();
    public JSONObject tt;

    public ve(JSONObject jSONObject) {
        this.tt = jSONObject;
    }

    public Object c(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        return null;
    }

    public boolean tt(String str) {
        return this.c.containsKey(str);
    }

    public void c() {
        Iterator<String> itKeys = this.tt.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.tt.opt(next);
            int i = 0;
            if (TextUtils.equals("image", next)) {
                if (objOpt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        if (i < jSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    Object objOpt2 = jSONObjectOptJSONObject.opt(next2);
                                    this.c.put(next + Consts.DOT + i + Consts.DOT + next2, objOpt2);
                                }
                            }
                            i++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (objOpt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) objOpt);
                        Iterator<String> itKeys3 = jSONObject.keys();
                        while (itKeys3.hasNext()) {
                            String next3 = itKeys3.next();
                            Object objOpt3 = jSONObject.opt(next3);
                            if ((objOpt3 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i2 = 0; i2 < ((JSONArray) objOpt3).length(); i2++) {
                                    this.c.put(next + Consts.DOT + next3 + Consts.DOT + i2, ((JSONArray) objOpt3).opt(i2));
                                }
                            } else if ((objOpt3 instanceof JSONObject) && TextUtils.equals(next3, "coupon")) {
                                Iterator<String> itKeys4 = ((JSONObject) objOpt3).keys();
                                while (itKeys4.hasNext()) {
                                    String next4 = itKeys4.next();
                                    Object objOpt4 = ((JSONObject) objOpt3).opt(next4);
                                    this.c.put(next + Consts.DOT + next3 + Consts.DOT + next4, objOpt4);
                                }
                            } else if ((objOpt3 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                c(next, next3, objOpt3);
                            } else {
                                this.c.put(next + Consts.DOT + next3, objOpt3);
                            }
                        }
                    } catch (JSONException e) {
                        m.c(e);
                    }
                }
            } else if (!(objOpt instanceof JSONObject)) {
                this.c.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.c.put(next, objOpt);
                }
            } else if (objOpt != null) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                Iterator<String> itKeys5 = jSONObject2.keys();
                while (itKeys5.hasNext()) {
                    String next5 = itKeys5.next();
                    Object objOpt5 = jSONObject2.opt(next5);
                    this.c.put(next + Consts.DOT + next5, objOpt5);
                }
            }
        }
    }

    private void c(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if ((objOpt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    if (i < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            Object objOpt2 = jSONObjectOptJSONObject.opt(next2);
                            this.c.put(str + Consts.DOT + str2 + Consts.DOT + next + Consts.DOT + i + Consts.DOT + next2, objOpt2);
                        }
                        i++;
                    }
                }
            } else {
                this.c.put(str + Consts.DOT + str2 + Consts.DOT + next, objOpt);
            }
        }
    }
}
