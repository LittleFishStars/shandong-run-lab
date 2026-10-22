package com.fl.saas.base.widget;

import com.fl.saas.config.utils.LogcatUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class JsonUtil {
    public static Map<String, Object> jsonObjectToMap(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.opt(next));
            }
        } catch (Exception e) {
            if (LogcatUtil.isDebug) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
