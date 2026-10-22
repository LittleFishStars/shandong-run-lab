package com.alibaba.baichuan.trade.common.ut;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UserTrackUtils {
    public static void sendApplinkUserTrack(Map<String, String> map, boolean z, int i, String str, int i2) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && map.size() > 0) {
            jSONObject.put("param", (Object) JSON.toJSONString(map));
            String str2 = map.get("ybhpss");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ybhpss", (Object) str2);
            }
        }
        jSONObject.put("from", (Object) "ultimate");
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put(UserTrackConstant.ERROR_TYPE, (Object) str);
        }
        jSONObject.put(UserTrackConstant.JUMP_TYPE, (Object) String.valueOf(i2));
        AlibcUserTracker.getInstance().trackAlarm(z, UserTrackConstant.E_SHOW_APPLINK, String.valueOf(i), "", jSONObject);
    }

    public static void sendUserTrack(String str, Map<String, String> map) {
        AlibcUserTracker.getInstance().sendCustomHit(str, "", map);
    }
}
