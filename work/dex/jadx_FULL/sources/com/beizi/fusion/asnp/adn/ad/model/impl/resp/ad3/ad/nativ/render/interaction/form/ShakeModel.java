package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.par.StatusParamModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ShakeModel extends ASNPJsonResponseModel {

    @kg(key = "angle")
    private StatusParamModel angle;

    @kg(key = "axial")
    private StatusParamModel axial;

    @kg(key = "count")
    private StatusParamModel count;

    @kg(key = "endAmplitude")
    private StatusParamModel endAmplitude;

    @kg(key = "startAmplitude")
    private StatusParamModel startAmplitude;

    public ShakeModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public StatusParamModel getAxial() {
        return this.axial;
    }

    public StatusParamModel getCount() {
        return this.count;
    }

    public StatusParamModel getEndAmplitude() {
        return this.endAmplitude;
    }

    public StatusParamModel getRegulatoryAngle() {
        return this.angle;
    }

    public StatusParamModel getStartAmplitude() {
        return this.startAmplitude;
    }
}
