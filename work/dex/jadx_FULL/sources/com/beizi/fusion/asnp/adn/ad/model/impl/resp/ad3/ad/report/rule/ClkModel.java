package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ClkModel extends ASNPJsonResponseModel {

    @kg(key = "acb")
    private int acb;

    @kg(key = "acc")
    private int acc;

    @kg(key = "agl")
    private int agl;

    @kg(key = "av")
    private int av;

    @kg(key = "ncb")
    private int ncb;

    @kg(key = "rt")
    private int rt;

    public ClkModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getAcb() {
        return this.acb;
    }

    public int getAgl() {
        return this.agl;
    }

    public int getAt() {
        return this.acc;
    }

    public int getAv() {
        return this.av;
    }

    public int getNcb() {
        return this.ncb;
    }

    public int getRt() {
        return this.rt;
    }
}
