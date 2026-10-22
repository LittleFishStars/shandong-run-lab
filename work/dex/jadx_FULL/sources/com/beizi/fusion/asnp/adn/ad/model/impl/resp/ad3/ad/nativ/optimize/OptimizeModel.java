package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.optimize;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.optimize.par.ClickAreaParams;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.optimize.par.SlideParams;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OptimizeModel extends ASNPJsonResponseModel {

    @kg(key = "clickArea")
    private ClickAreaParams clickArea;

    @kg(key = "closeClickNum")
    private int closeClickNum;

    @kg(key = "slideNum")
    private int holdSlideNum;

    @kg(key = "adSlide")
    private SlideParams slide;

    @kg(key = "touchDownNum")
    private int touchDownNum;

    public OptimizeModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public ClickAreaParams getClickArea() {
        return this.clickArea;
    }

    public int getCloseClickNum() {
        return this.closeClickNum;
    }

    public int getHoldSlideNum() {
        return this.holdSlideNum;
    }

    public SlideParams getSlide() {
        return this.slide;
    }

    public int getTouchDownNum() {
        return this.touchDownNum;
    }
}
