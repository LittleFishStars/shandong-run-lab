package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CSensorModel extends ASNPJsonResponseModel {

    @kg(key = "acc")
    private int acc;

    @kg(key = "agl")
    private int agl;

    @kg(key = "dit")
    private String dit;

    @kg(key = "dut")
    private int dut;

    @kg(key = "type")
    private int type;

    public CSensorModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getAcc() {
        return this.acc;
    }

    public int getAgl() {
        return this.agl;
    }

    public String getDit() {
        return this.dit;
    }

    public int getDut() {
        return this.dut;
    }

    public int getType() {
        return this.type;
    }
}
