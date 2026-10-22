package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.speed;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SpeedModel extends ASNPJsonResponseModel {

    @kg(key = "isAnimation")
    private int isAnimation;

    @kg(key = "isImageSpeed")
    private int isImageSpeed;

    @kg(key = "isPlaceHolder")
    private int isPlaceHolder;

    public SpeedModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public boolean isAnimation() {
        return this.isAnimation == 1;
    }

    public boolean isImageSpeed() {
        return this.isImageSpeed == 1;
    }

    public boolean isPlaceHolder() {
        return this.isPlaceHolder == 1;
    }
}
