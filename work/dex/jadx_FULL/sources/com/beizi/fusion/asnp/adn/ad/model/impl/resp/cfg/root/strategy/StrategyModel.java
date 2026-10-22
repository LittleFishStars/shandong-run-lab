package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy;

import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.cache.AdCacheModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StrategyModel extends ASNPJsonResponseModel {

    @kg(key = "adCache")
    private AdCacheModel adCache;

    @kg(key = "filter")
    private StrategyFilterModel filter;

    @kg(key = StrategyEventDBModel.COLUMN_SPACE_ID)
    private String spaceID;

    @kg(key = "version")
    private String version;

    public StrategyModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public AdCacheModel getAdCache() {
        return this.adCache;
    }

    public StrategyFilterModel getFilter() {
        return this.filter;
    }

    public String getSpaceID() {
        return this.spaceID;
    }

    public String getVersion() {
        return this.version;
    }
}
