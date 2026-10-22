package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.bid;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BiddingModel3 extends ASNPJsonResponseModel {

    @kg(key = "auction")
    private BidAuction auction;

    @kg(key = "burl")
    private String burl;

    @kg(key = "lurl")
    private String lurl;

    @kg(key = "price")
    private double price;

    @kg(key = "purl")
    private String purl;

    public BiddingModel3(JSONObject jSONObject) {
        super(jSONObject);
    }

    public BidAuction getAuction() {
        return this.auction;
    }

    public String getBiddingURL() {
        return this.purl;
    }

    public String getLoseURL() {
        return this.lurl;
    }

    public double getPrice() {
        return this.price;
    }

    public String getWinURL() {
        return this.burl;
    }
}
