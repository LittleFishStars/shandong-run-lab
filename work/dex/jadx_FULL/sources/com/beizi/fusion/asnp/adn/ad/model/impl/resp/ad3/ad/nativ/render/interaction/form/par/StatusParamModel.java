package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.par;

import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StatusParamModel extends ASNPJsonResponseModel {

    @kg(key = "cool")
    private String cool;

    @kg(key = "normal")
    private String normal;

    @kg(key = "passivation")
    private String passivation;

    public StatusParamModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getCool() {
        return TextUtils.isEmpty(this.cool) ? getNormal() : this.cool;
    }

    public String getNormal() {
        return TextUtils.isEmpty(this.normal) ? "" : this.normal;
    }

    public String getPassivation() {
        return TextUtils.isEmpty(this.passivation) ? getNormal() : this.passivation;
    }
}
