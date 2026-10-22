package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.anim;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RenderAnimModel extends ASNPJsonResponseModel {

    @kg(key = HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)
    private int direction;

    @kg(key = "duration")
    private long duration;

    public RenderAnimModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getDirection() {
        return this.direction;
    }

    public long getDuration() {
        return this.duration;
    }
}
