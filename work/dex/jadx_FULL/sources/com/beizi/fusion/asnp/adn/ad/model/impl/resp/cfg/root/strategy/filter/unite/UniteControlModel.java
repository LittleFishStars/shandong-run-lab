package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.unite;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Deprecated
public class UniteControlModel extends ASNPJsonResponseModel {

    @kg(key = "duration")
    private long duration;

    @kg(key = "random")
    private int random;

    public UniteControlModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Deprecated
    public long getDuration() {
        return this.duration;
    }

    @Deprecated
    public int getRandom() {
        return this.random;
    }
}
