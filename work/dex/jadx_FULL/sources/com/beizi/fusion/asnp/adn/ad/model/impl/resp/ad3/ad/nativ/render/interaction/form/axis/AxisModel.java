package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.axis;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.par.StatusParamModel;
import com.beizi.fusion.kg;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ipd.dsp.internal.l.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AxisModel extends ASNPJsonResponseModel {

    @kg(key = "angle")
    private StatusParamModel angle;

    @kg(key = a.l)
    private int animation;

    @kg(key = HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)
    private StatusParamModel direction;

    public AxisModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public StatusParamModel getAngle() {
        return this.angle;
    }

    public int getAnimation() {
        return this.animation;
    }

    public StatusParamModel getDirection() {
        return this.direction;
    }
}
