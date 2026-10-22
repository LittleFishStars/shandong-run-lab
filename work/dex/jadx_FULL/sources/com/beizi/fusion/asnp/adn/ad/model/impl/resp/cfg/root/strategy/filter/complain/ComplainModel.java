package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.complain;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ComplainModel extends ASNPJsonResponseModel {

    @kg(key = "duration")
    private long duration;

    public ComplainModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public long getDuration() {
        return this.duration;
    }
}
