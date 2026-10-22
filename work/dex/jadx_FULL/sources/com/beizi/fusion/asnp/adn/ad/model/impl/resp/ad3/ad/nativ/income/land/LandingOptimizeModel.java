package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.land;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LandingOptimizeModel extends ASNPJsonResponseModel {

    @kg(key = "againOpen")
    private int againOpen;

    @kg(key = "againOpenTime")
    private int againOpenTime;

    @kg(key = "autoOpen")
    private int autoOpen;

    @kg(key = "autoOpenType")
    private int autoOpenType;

    @kg(key = "random")
    private int random;

    @kg(key = "repeatOpen")
    private int repeatOpen;

    @kg(key = "repeatOpenCount")
    private int repeatOpenCount;

    @kg(key = "showMask")
    private int showMask;

    @kg(key = "url")
    private String url;

    public LandingOptimizeModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getAgainOpen() {
        return this.againOpen;
    }

    public int getAgainOpenTime() {
        return this.againOpenTime;
    }

    public int getAutoOpen() {
        return this.autoOpen;
    }

    public int getAutoOpenType() {
        return this.autoOpenType;
    }

    public int getRandom() {
        return this.random;
    }

    public int getRepeatOpen() {
        return this.repeatOpen;
    }

    public int getRepeatOpenCount() {
        return this.repeatOpenCount;
    }

    public int getShowMask() {
        return this.showMask;
    }

    public String getUrl() {
        return this.url;
    }
}
