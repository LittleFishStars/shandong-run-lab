package com.kwad.sdk.core.b.a;

import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.kwad.sdk.core.response.model.LiveInfo;
import com.kwad.sdk.core.response.model.LiveRewardInfo;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ia implements com.kwad.sdk.core.d<LiveInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveInfo) bVar, jSONObject);
    }

    private static void a(LiveInfo liveInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveInfo.livingLink = jSONObject.optString("livingLink");
        if (JSONObject.NULL.toString().equals(liveInfo.livingLink)) {
            liveInfo.livingLink = "";
        }
        liveInfo.shennongjiaLog = jSONObject.optString("shennongjiaLog");
        if (JSONObject.NULL.toString().equals(liveInfo.shennongjiaLog)) {
            liveInfo.shennongjiaLog = "";
        }
        liveInfo.nebulaKwaiLink = jSONObject.optString("nebulaKwaiLink");
        if (JSONObject.NULL.toString().equals(liveInfo.nebulaKwaiLink)) {
            liveInfo.nebulaKwaiLink = "";
        }
        liveInfo.linkCode = jSONObject.optString("linkCode");
        if (JSONObject.NULL.toString().equals(liveInfo.linkCode)) {
            liveInfo.linkCode = "";
        }
        liveInfo.liveStreamId = jSONObject.optString("liveStreamId");
        if (JSONObject.NULL.toString().equals(liveInfo.liveStreamId)) {
            liveInfo.liveStreamId = "";
        }
        liveInfo.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        liveInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(liveInfo.title)) {
            liveInfo.title = "";
        }
        liveInfo.coverUrl = jSONObject.optString("coverUrl");
        if (JSONObject.NULL.toString().equals(liveInfo.coverUrl)) {
            liveInfo.coverUrl = "";
        }
        LiveInfo.User user = new LiveInfo.User();
        liveInfo.user = user;
        user.parseJson(jSONObject.optJSONObject(RichTextUtils.USER_SCHEME));
        LiveInfo.CoverUrlCdn coverUrlCdn = new LiveInfo.CoverUrlCdn();
        liveInfo.coverUrlCdn = coverUrlCdn;
        coverUrlCdn.parseJson(jSONObject.optJSONObject("coverUrlCdn"));
        liveInfo.audienceCount = jSONObject.optInt("audienceCount");
        liveInfo.caption = jSONObject.optString("caption");
        if (JSONObject.NULL.toString().equals(liveInfo.caption)) {
            liveInfo.caption = "";
        }
        liveInfo.cover_thumbnail_urls = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cover_thumbnail_urls");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                LiveInfo.CoverThumbnailUrl coverThumbnailUrl = new LiveInfo.CoverThumbnailUrl();
                coverThumbnailUrl.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                liveInfo.cover_thumbnail_urls.add(coverThumbnailUrl);
            }
        }
        liveInfo.exp_tag = jSONObject.optString("exp_tag");
        if (JSONObject.NULL.toString().equals(liveInfo.exp_tag)) {
            liveInfo.exp_tag = "";
        }
        liveInfo.liveStreamPlayCdnList = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("liveStreamPlayCdnList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                LiveInfo.LiveStreamPlayCDNNode liveStreamPlayCDNNode = new LiveInfo.LiveStreamPlayCDNNode();
                liveStreamPlayCDNNode.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                liveInfo.liveStreamPlayCdnList.add(liveStreamPlayCDNNode);
            }
        }
        liveInfo.livePageType = jSONObject.optInt("livePageType");
        liveInfo.pageDataKey = jSONObject.optString("pageDataKey");
        if (JSONObject.NULL.toString().equals(liveInfo.pageDataKey)) {
            liveInfo.pageDataKey = "";
        }
        liveInfo.kwaiUserId = jSONObject.optString("kwaiUserId");
        if (JSONObject.NULL.toString().equals(liveInfo.kwaiUserId)) {
            liveInfo.kwaiUserId = "";
        }
        liveInfo.shopItemId = jSONObject.optString("shopItemId");
        if (JSONObject.NULL.toString().equals(liveInfo.shopItemId)) {
            liveInfo.shopItemId = "";
        }
        LiveRewardInfo liveRewardInfo = new LiveRewardInfo();
        liveInfo.rewardInfo = liveRewardInfo;
        liveRewardInfo.parseJson(jSONObject.optJSONObject("rewardInfo"));
        liveInfo.deeplink = jSONObject.optString("deeplink");
        if (JSONObject.NULL.toString().equals(liveInfo.deeplink)) {
            liveInfo.deeplink = "";
        }
    }

    private static JSONObject b(LiveInfo liveInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = liveInfo.livingLink;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "livingLink", liveInfo.livingLink);
        }
        String str2 = liveInfo.shennongjiaLog;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "shennongjiaLog", liveInfo.shennongjiaLog);
        }
        String str3 = liveInfo.nebulaKwaiLink;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "nebulaKwaiLink", liveInfo.nebulaKwaiLink);
        }
        String str4 = liveInfo.linkCode;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "linkCode", liveInfo.linkCode);
        }
        String str5 = liveInfo.liveStreamId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveStreamId", liveInfo.liveStreamId);
        }
        long j = liveInfo.authorId;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j);
        }
        String str6 = liveInfo.title;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", liveInfo.title);
        }
        String str7 = liveInfo.coverUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "coverUrl", liveInfo.coverUrl);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, RichTextUtils.USER_SCHEME, liveInfo.user);
        com.kwad.sdk.utils.ac.a(jSONObject, "coverUrlCdn", liveInfo.coverUrlCdn);
        int i = liveInfo.audienceCount;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "audienceCount", i);
        }
        String str8 = liveInfo.caption;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "caption", liveInfo.caption);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "cover_thumbnail_urls", liveInfo.cover_thumbnail_urls);
        String str9 = liveInfo.exp_tag;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "exp_tag", liveInfo.exp_tag);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "liveStreamPlayCdnList", liveInfo.liveStreamPlayCdnList);
        int i2 = liveInfo.livePageType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "livePageType", i2);
        }
        String str10 = liveInfo.pageDataKey;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pageDataKey", liveInfo.pageDataKey);
        }
        String str11 = liveInfo.kwaiUserId;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "kwaiUserId", liveInfo.kwaiUserId);
        }
        String str12 = liveInfo.shopItemId;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "shopItemId", liveInfo.shopItemId);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "rewardInfo", liveInfo.rewardInfo);
        String str13 = liveInfo.deeplink;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplink", liveInfo.deeplink);
        }
        return jSONObject;
    }
}
