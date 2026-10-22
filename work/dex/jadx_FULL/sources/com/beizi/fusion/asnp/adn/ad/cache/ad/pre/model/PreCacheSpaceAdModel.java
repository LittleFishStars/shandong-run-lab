package com.beizi.fusion.asnp.adn.ad.cache.ad.pre.model;

import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.AdResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PreCacheSpaceAdModel extends ASNPJsonResponseModel {

    @kg(key = "ad")
    private AdResponseModel ad;

    @kg(key = StrategyEventDBModel.COLUMN_SPACE_ID)
    private String spaceId;

    public PreCacheSpaceAdModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public AdResponseModel a() {
        return this.ad;
    }

    public String b() {
        return this.spaceId;
    }
}
