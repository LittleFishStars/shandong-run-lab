package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.par;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ClickAreaParams extends ASNPJsonResponseModel {

    @kg(key = "durationTime")
    private int duration;

    @kg(key = "height")
    private String height;

    @kg(key = "horizontalSpace")
    private String horizontalSpace;

    @kg(key = "needTime")
    private int needTime;

    @kg(key = "randomNum")
    private int randomNum;

    @kg(key = "reference")
    private int reference;

    @kg(key = "verticalSpace")
    private String verticalSpace;

    @kg(key = "width")
    private String width;

    public ClickAreaParams(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getDuration() {
        return this.duration;
    }

    public String getHeight() {
        return this.height;
    }

    public String getHorizontalSpace() {
        return this.horizontalSpace;
    }

    public int getNeedTime() {
        return this.needTime;
    }

    public int getRandomNum() {
        return this.randomNum;
    }

    public int getReference() {
        return this.reference;
    }

    public String getVerticalSpace() {
        return this.verticalSpace;
    }

    public String getWidth() {
        return this.width;
    }
}
