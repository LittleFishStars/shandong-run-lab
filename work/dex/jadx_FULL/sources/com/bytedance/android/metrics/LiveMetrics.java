package com.bytedance.android.metrics;

import com.byazt.nr.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class LiveMetrics {
    public static final String EVENT_LIVESDK_LIVE_SHOW = "tobsdk_livesdk_live_show";
    public static final String EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2 = "tobsdk_livesdk_live_window_duration_v2";
    public static final String EVENT_LIVESDK_REC_LIVE_PLAY = "tobsdk_livesdk_rec_live_play";

    private static JSONObject buildJsonObject(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject;
    }

    public static JSONObject filterParam(Params params) {
        return filterParam(params, new HashMap());
    }

    public static JSONObject filterParam(Params params, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(params.getRoomId());
        map.put("room_id", sb.toString());
        map.put("anchor_id", params.getAnchorId());
        map.put("enter_from_merge", params.getEnterFromMerge().lowerName());
        map.put("enter_method", params.getEnterMethod().lowerName());
        map.put("action_type", params.getActionType().lowerName());
        map.put("request_id", params.getRequestId());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(params.getDuration());
        map.put("duration", sb2.toString());
        map.put("is_other_channel", "union_ad");
        return buildJsonObject(map);
    }
}
