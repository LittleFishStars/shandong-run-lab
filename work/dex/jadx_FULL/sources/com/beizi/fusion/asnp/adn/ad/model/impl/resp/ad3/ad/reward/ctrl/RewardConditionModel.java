package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RewardConditionModel extends ASNPJsonResponseModel {

    @kg(key = "browse")
    private int browse;

    @kg(key = "count")
    private int count;

    @kg(key = "install")
    private int install;

    @kg(key = TypedValues.CycleType.S_WAVE_PERIOD)
    private int period;

    public RewardConditionModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getBrowse() {
        return this.browse;
    }

    public int getCount() {
        return this.count;
    }

    public int getInstall() {
        return this.install;
    }

    public int getPeriod() {
        return this.period;
    }
}
