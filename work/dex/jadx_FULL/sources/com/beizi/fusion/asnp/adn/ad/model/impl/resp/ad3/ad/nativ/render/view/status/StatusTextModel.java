package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.status;

import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StatusTextModel extends ASNPJsonResponseModel {

    @kg(key = "finals")
    private String finalText;

    @kg(key = "normal")
    private String normal;

    @kg(key = "select")
    private String selected;

    public StatusTextModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getFinalText() {
        return TextUtils.isEmpty(this.finalText) ? getNormal() : this.finalText;
    }

    public String getNormal() {
        return TextUtils.isEmpty(this.normal) ? "" : this.normal;
    }

    public String getSelected() {
        return TextUtils.isEmpty(this.selected) ? getNormal() : this.selected;
    }
}
