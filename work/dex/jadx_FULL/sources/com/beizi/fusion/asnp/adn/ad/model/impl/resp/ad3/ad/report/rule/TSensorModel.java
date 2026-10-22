package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TSensorModel extends ASNPJsonResponseModel {

    @kg(key = "accx")
    private int accx;

    @kg(key = "accy")
    private int accy;

    @kg(key = "accz")
    private int accz;

    @kg(key = "aglx")
    private int aglx;

    @kg(key = "agly")
    private int agly;

    @kg(key = "aglz")
    private int aglz;

    @kg(key = "sld")
    private SldModel sld;

    @kg(key = "type")
    private int type;

    public TSensorModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getAccx() {
        return this.accx;
    }

    public int getAccy() {
        return this.accy;
    }

    public int getAccz() {
        return this.accz;
    }

    public int getAglx() {
        return this.aglx;
    }

    public int getAgly() {
        return this.agly;
    }

    public int getAglz() {
        return this.aglz;
    }

    public SldModel getSld() {
        return this.sld;
    }

    public int getType() {
        return this.type;
    }
}
