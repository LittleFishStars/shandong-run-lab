package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.bid;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BidAuction extends ASNPJsonResponseModel {

    @kg(key = "customData")
    private String customData;

    @kg(key = "isClose")
    private int isClose;

    @kg(key = "maxRate")
    private String maxRate;

    @kg(key = "minRate")
    private String minRate;

    @kg(key = "random")
    private int random;

    @kg(key = "secondPrice")
    private int secondPrice;

    @kg(key = "sortRaise")
    private int sortRaise;

    @kg(key = "type")
    private int type;

    public BidAuction(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getCustomData() {
        return this.customData;
    }

    public int getIsClose() {
        return this.isClose;
    }

    public String getMaxRate() {
        return this.maxRate;
    }

    public String getMinRate() {
        return this.minRate;
    }

    public int getRandom() {
        return this.random;
    }

    public int getSecondPrice() {
        return this.secondPrice;
    }

    public int getSortRaise() {
        return this.sortRaise;
    }

    public int getType() {
        return this.type;
    }
}
