package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.beta;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.beta.unit.UnitTestModel;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BetaPlanModel extends ASNPJsonResponseModel {

    @kg(key = "release")
    private List<String> release;

    @kg(key = "unitTest")
    private List<UnitTestModel> unitTestModelList;

    @kg(key = "version")
    private String versionMd5;

    public BetaPlanModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public List<String> getRelease() {
        return this.release;
    }

    public List<UnitTestModel> getUnitTestModelList() {
        return this.unitTestModelList;
    }

    public String getVersionMd5() {
        return this.versionMd5;
    }
}
