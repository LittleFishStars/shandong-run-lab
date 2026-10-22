package com.aliyun.liveshift.bean;

import com.aliyun.utils.e;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TimeLineContent {
    private static final String TAG = "TimeLineContent";
    public long current;
    public List<TimeLineInfo> timelines;

    public static TimeLineContent getInfoFromJson(JSONObject jSONObject) {
        TimeLineContent timeLineContent = new TimeLineContent();
        if (jSONObject == null) {
            return timeLineContent;
        }
        timeLineContent.current = e.b(jSONObject, "current");
        try {
            timeLineContent.timelines = TimeLineInfo.getInfoArrayFromJson(jSONObject.getJSONArray("timeline"));
        } catch (JSONException unused) {
        }
        return timeLineContent;
    }
}
