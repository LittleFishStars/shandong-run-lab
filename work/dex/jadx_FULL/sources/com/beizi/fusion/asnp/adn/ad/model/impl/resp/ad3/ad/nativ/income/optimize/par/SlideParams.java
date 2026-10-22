package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.par;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SlideParams extends ASNPJsonResponseModel {

    @kg(key = SchoolActivitySuccessActivity.x)
    private int distance;

    @kg(key = "needTime")
    private int needTime;

    @kg(key = "randomNum")
    private int randomNum;

    public SlideParams(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNeedTime() {
        return this.needTime;
    }

    public int getRandomNum() {
        return this.randomNum;
    }
}
