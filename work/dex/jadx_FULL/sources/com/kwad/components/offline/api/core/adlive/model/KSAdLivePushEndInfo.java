package com.kwad.components.offline.api.core.adlive.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KSAdLivePushEndInfo implements Serializable {
    public static final String KET_CONFIG_DISPLAY_LIKE_USER_COUNT = "displayLikeUserCount";
    public static final String KET_CONFIG_DISPLAY_WATCHING_USER_COUNT = "displayWatchingUserCount";
    public static final String KET_CONFIG_LIKE_USER_COUNT = "likeUserCount";
    public static final String KET_CONFIG_LIVE_DURATION = "liveDuration";
    public static final String KET_CONFIG_TOTAL_WATCHING_DURATION = "totalWatchingDuration";
    public static final String KET_CONFIG_WATCHING_USER_COUNT = "watchingUserCount";
    private static final long serialVersionUID = 7611577990274486211L;
    public int mLikeUserCount;
    public long mLiveDuration;
    public long mTotalWatchingDuration;
    public int mWatchingUserCount;
    public String mDisplayWatchingUserCount = "0";
    public String mDisplayLikeUserCount = "0";

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mTotalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        this.mWatchingUserCount = jSONObject.optInt("watchingUserCount");
        this.mDisplayWatchingUserCount = jSONObject.optString("displayWatchingUserCount", "0");
        this.mLiveDuration = jSONObject.optLong("liveDuration");
        this.mLikeUserCount = jSONObject.optInt("likeUserCount");
        this.mDisplayLikeUserCount = jSONObject.optString("displayLikeUserCount", "0");
    }

    public JSONObject toJson(JSONObject jSONObject) {
        ac.putValue(jSONObject, "totalWatchingDuration", this.mTotalWatchingDuration);
        ac.putValue(jSONObject, "watchingUserCount", this.mWatchingUserCount);
        ac.putValue(jSONObject, "displayWatchingUserCount", this.mDisplayWatchingUserCount);
        ac.putValue(jSONObject, "liveDuration", this.mLiveDuration);
        ac.putValue(jSONObject, "likeUserCount", this.mLikeUserCount);
        ac.putValue(jSONObject, "displayLikeUserCount", this.mDisplayLikeUserCount);
        return jSONObject;
    }
}
