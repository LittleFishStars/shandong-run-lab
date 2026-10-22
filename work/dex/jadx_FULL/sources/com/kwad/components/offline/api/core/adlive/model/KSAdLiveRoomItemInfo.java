package com.kwad.components.offline.api.core.adlive.model;

import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KSAdLiveRoomItemInfo extends BaseOfflineCompoJsonParse<KSAdLiveRoomItemInfo> implements Serializable {
    private static final long serialVersionUID = -6149616231567033413L;
    public String imageUrl;
    public String itemId;
    public String price;
    public String title;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdLiveRoomItemInfo.itemId = jSONObject.optString(ALPParamConstant.ITMEID);
        if (jSONObject.opt(ALPParamConstant.ITMEID) == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.itemId = "";
        }
        kSAdLiveRoomItemInfo.imageUrl = jSONObject.optString("imageUrl");
        if (jSONObject.opt("imageUrl") == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.imageUrl = "";
        }
        kSAdLiveRoomItemInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.title = "";
        }
        kSAdLiveRoomItemInfo.price = jSONObject.optString("templateVersion");
        if (jSONObject.opt("price") == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.price = "";
        }
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = kSAdLiveRoomItemInfo.itemId;
        if (str != null && !str.equals("")) {
            ac.putValue(jSONObject, ALPParamConstant.ITMEID, kSAdLiveRoomItemInfo.itemId);
        }
        String str2 = kSAdLiveRoomItemInfo.imageUrl;
        if (str2 != null && !str2.equals("")) {
            ac.putValue(jSONObject, "imageUrl", kSAdLiveRoomItemInfo.imageUrl);
        }
        String str3 = kSAdLiveRoomItemInfo.title;
        if (str3 != null && !str3.equals("")) {
            ac.putValue(jSONObject, "title", kSAdLiveRoomItemInfo.title);
        }
        String str4 = kSAdLiveRoomItemInfo.price;
        if (str4 != null && !str4.equals("")) {
            ac.putValue(jSONObject, "price", kSAdLiveRoomItemInfo.price);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo) {
        return toJson(kSAdLiveRoomItemInfo, (JSONObject) null);
    }
}
