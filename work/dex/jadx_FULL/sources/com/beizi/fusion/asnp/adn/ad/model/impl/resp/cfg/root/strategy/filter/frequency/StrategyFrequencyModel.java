package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.frequency;

import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StrategyFrequencyModel extends ASNPJsonResponseModel {

    @kg(key = "absoluteTime")
    private long[] absoluteTime;

    @kg(key = "count")
    private int count;

    @kg(key = StrategyEventDBModel.COLUMN_EVENT_CODE)
    private String eventCode;

    @kg(key = "relativeTime")
    private long relativeTime;

    public StrategyFrequencyModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public long[] getAbsoluteTime() {
        return this.absoluteTime;
    }

    public int getCount() {
        return this.count;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public long getRelativeTime() {
        return this.relativeTime;
    }
}
