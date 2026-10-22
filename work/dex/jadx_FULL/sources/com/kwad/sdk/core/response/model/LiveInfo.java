package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class LiveInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -6382708726460249425L;
    public int audienceCount;
    public long authorId;
    public String caption;
    public String coverUrl;
    public String deeplink;
    public String exp_tag;
    public String kwaiUserId;
    public String linkCode;
    public int livePageType;
    public String liveStreamId;
    public String livingLink;
    public String nebulaKwaiLink;
    public String pageDataKey;
    public transient String pcursor;
    public transient JSONObject playInfo;
    public String shennongjiaLog;
    public String shopItemId;
    public String title;
    public User user = new User();
    public CoverUrlCdn coverUrlCdn = new CoverUrlCdn();
    public List<CoverThumbnailUrl> cover_thumbnail_urls = new ArrayList();
    public List<LiveStreamPlayCDNNode> liveStreamPlayCdnList = new ArrayList();
    public LiveRewardInfo rewardInfo = new LiveRewardInfo();

    @KsJson
    public static class CoverThumbnailUrl extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -9411857293708312L;
        public String cdn;
        public String url;
        public String urlPattern;
    }

    @KsJson
    public static class CoverUrlCdn extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 6749700043335441902L;
        public String coverUrlCdn;
    }

    @KsJson
    public static class LiveStreamPlayCDNNode extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 4809830877910908561L;
        public String cdn;
        public String url;
    }

    @KsJson
    public static class User extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 8394855164198099170L;
        public List<HeadUrl> headurls = new ArrayList();
        public long user_id;
        public String user_name;

        @KsJson
        public static class HeadUrl extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = 7710129978455547652L;
            public String cdn;
            public String url;
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("playInfo");
            if (jSONObjectOptJSONObject != null) {
                this.playInfo = jSONObjectOptJSONObject;
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        try {
            JSONObject jSONObject2 = this.playInfo;
            if (jSONObject2 != null) {
                ac.putValue(jSONObject, "playInfo", jSONObject2);
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }
}
