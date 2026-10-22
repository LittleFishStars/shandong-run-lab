package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ad;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class PhotoInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -4483350806354759008L;
    public String mOriginJString;
    public BaseInfo baseInfo = new BaseInfo();
    public VideoInfo videoInfo = new VideoInfo();

    @KsJson
    public static class BaseInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 2257669583403371065L;
        public long commentCount;
        public int contentSourceType;
        public long createTime;
        public long likeCount;
        public int photoDescribeSize;
        public long photoId;
        public int photoTitleSize;
        public long playTimes;
        public String recoExt;
        public String sdkExtraData;
        public String shareUrl;
        public String title;
        public boolean toolbarDisable;
        public String videoDesc;
        public long videoUrlCacheTime;
        public long viewCount;
        public int waterMarkPosition;
        public long waterMarkShowDuration;
    }

    @KsJson
    public static class VideoInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 1395696168725754442L;
        public long duration;
        public String firstFrame;
        public int height;
        public double heightRatio;
        public double leftRatio;
        public String manifest;
        public int size;
        public double topRatio;
        public String videoUrl;
        public int width;
        public double widthRatio;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null || !TextUtils.isEmpty(this.mOriginJString)) {
            return;
        }
        this.mOriginJString = jSONObject.toString();
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void beforeToJson(JSONObject jSONObject) {
        super.beforeToJson(jSONObject);
        if (TextUtils.isEmpty(this.mOriginJString)) {
            return;
        }
        try {
            ad.merge(jSONObject, new JSONObject(this.mOriginJString));
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
    }
}
