package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.link;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LinkModel extends ASNPJsonResponseModel {

    @kg(key = "urlfb")
    private String deeplink;

    @kg(key = "urldw")
    private String downloadURL;

    @kg(key = "dwPrompt")
    private int dwPrompt;

    @kg(key = "interactType")
    private int interact_type;

    @kg(key = "url")
    private String linkURL;

    @kg(key = "urlmk")
    private String marketURL;

    @kg(key = "urlulk")
    private String universalLink;

    @kg(key = "webIntercept")
    private int webIntercept;

    @kg(key = "miniext")
    private String wxExtraData;

    @kg(key = "minicanvas")
    private String wxNativeCanvas;

    @kg(key = "miniid")
    private String wxOriginalId;

    @kg(key = "minipath")
    private String wxProgramPath;

    public LinkModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getDownloadURL() {
        return this.downloadURL;
    }

    public int getInteractType() {
        return this.interact_type;
    }

    public String getLandingPageURL() {
        return this.linkURL;
    }

    public String getMarketURL() {
        return this.marketURL;
    }

    public String getUniversalLink() {
        return this.universalLink;
    }

    public String getWxExtraData() {
        return this.wxExtraData;
    }

    public String getWxNativeCanvas() {
        return this.wxNativeCanvas;
    }

    public String getWxOriginalId() {
        return this.wxOriginalId;
    }

    public String getWxProgramPath() {
        return this.wxProgramPath;
    }

    public boolean shouldWebIntercept() {
        return this.webIntercept == 1;
    }

    public boolean showDownloadPrompt() {
        return this.dwPrompt == 1;
    }
}
