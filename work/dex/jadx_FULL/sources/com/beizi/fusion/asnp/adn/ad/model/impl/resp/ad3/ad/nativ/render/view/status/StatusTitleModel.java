package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.status;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.par.StatusParamModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StatusTitleModel extends ASNPJsonResponseModel {

    @kg(key = "download")
    private StatusParamModel download;

    @kg(key = "normal")
    private StatusParamModel normal;

    public StatusTitleModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public StatusParamModel getDownload() {
        return this.download;
    }

    public StatusParamModel getNormal() {
        return this.normal;
    }
}
