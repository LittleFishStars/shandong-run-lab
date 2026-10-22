package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.update;

import com.beizi.fusion.asnp.adn.ad.model.impl.db.AdvertCacheDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class UpdateModel extends ASNPJsonResponseModel {

    @kg(key = "checkInterval")
    private int checkInterval;

    @kg(key = AdvertCacheDBModel.COLUMN_EXPIRE_TIME)
    private long expireTime;

    @kg(key = "maxExpireTime")
    private long maxExpireTime;

    @kg(key = "version")
    private String version;

    public UpdateModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getCheckInterval() {
        return this.checkInterval;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public long getMaxExpireTime() {
        return this.maxExpireTime;
    }

    public String getVersion() {
        return this.version;
    }
}
