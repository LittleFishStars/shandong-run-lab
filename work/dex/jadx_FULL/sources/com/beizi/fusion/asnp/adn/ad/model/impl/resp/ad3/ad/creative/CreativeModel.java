package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.creative;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CreativeModel extends ASNPJsonResponseModel {

    @kg(key = "cid")
    private String creativeId;

    @kg(key = "mid")
    private String materialID;

    @kg(key = "mime")
    private String mime;

    public CreativeModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    public String getMaterialID() {
        return this.materialID;
    }

    public String getMime() {
        return this.mime;
    }
}
