package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.link.mini;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class WxMiniModel extends ASNPJsonResponseModel {

    @kg(key = "wxExtraData")
    private String wxExtraData;

    @kg(key = "wxCanvas")
    private String wxNativeCanvas;

    @kg(key = "wxOriginalId")
    private String wxOriginalId;

    @kg(key = "wxProgramPath")
    private String wxProgramPath;

    public WxMiniModel(JSONObject jSONObject) {
        super(jSONObject);
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
}
