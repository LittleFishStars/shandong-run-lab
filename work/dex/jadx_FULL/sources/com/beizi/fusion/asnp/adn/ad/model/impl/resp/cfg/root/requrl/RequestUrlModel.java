package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.requrl;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RequestUrlModel extends ASNPJsonResponseModel {

    @kg(key = "adUrl")
    private String adURL;

    @kg(key = "configUrl")
    private String configURL;

    @kg(key = "cacheAdUrl")
    private String preloadAdURL;

    @kg(key = "cacheImageUrl")
    private String preloadImageUrl;

    @kg(key = "version")
    private String version;

    public RequestUrlModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getAdURL() {
        return this.adURL;
    }

    public String getConfigURL() {
        return this.configURL;
    }

    public String getPreloadAdURL() {
        return this.preloadAdURL;
    }

    public String getPreloadImageUrl() {
        return this.preloadImageUrl;
    }

    public String getVersion() {
        return this.version;
    }
}
