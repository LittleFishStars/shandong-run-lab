package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.par.StatusParamModel;
import com.beizi.fusion.kg;
import com.beizi.fusion.no;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SlideModel extends ASNPJsonResponseModel {
    private final String TYPE_COOLING;

    @kg(key = HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)
    private StatusParamModel slideDirection;

    @kg(key = SchoolActivitySuccessActivity.x)
    private StatusParamModel slideDistance;

    public SlideModel(JSONObject jSONObject) {
        super(jSONObject);
        this.TYPE_COOLING = "Cooling";
    }

    public String getSlideDirection(String str) {
        if (this.slideDirection != null) {
            return "Cooling".equalsIgnoreCase(str) ? this.slideDirection.getCool() : this.slideDirection.getNormal();
        }
        return "UP";
    }

    public int getSlideDistance(String str) {
        if (this.slideDistance != null) {
            return "Cooling".equalsIgnoreCase(str) ? no.i(this.slideDistance.getCool()) : no.i(this.slideDistance.getNormal());
        }
        return 0;
    }
}
