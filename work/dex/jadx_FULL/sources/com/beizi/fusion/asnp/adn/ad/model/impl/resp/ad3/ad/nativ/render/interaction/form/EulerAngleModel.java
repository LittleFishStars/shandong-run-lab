package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.axis.AxisModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class EulerAngleModel extends ASNPJsonResponseModel {

    @kg(key = "xAxis")
    private AxisModel xAxis;

    @kg(key = "yAxis")
    private AxisModel yAxis;

    @kg(key = "zAxis")
    private AxisModel zAxis;

    public EulerAngleModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public AxisModel getXAxis() {
        return this.xAxis;
    }

    public AxisModel getYAxis() {
        return this.yAxis;
    }

    public AxisModel getZAxis() {
        return this.zAxis;
    }
}
