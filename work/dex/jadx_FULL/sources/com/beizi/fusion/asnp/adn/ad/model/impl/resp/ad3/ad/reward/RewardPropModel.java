package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.EndCardPageModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.PrimarySkipCtrlModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.PrivilegePageModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.RetainPageModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.RewardConditionModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RewardPropModel extends ASNPJsonResponseModel {

    @kg(key = "rewarded")
    private RewardConditionModel conditionModel;

    @kg(key = "endCard")
    private EndCardPageModel endCardModel;

    @kg(key = "forceEndCard")
    private int forceEndCard;

    @kg(key = "skipCtrl")
    private PrimarySkipCtrlModel primarySkipCtrlModel;

    @kg(key = "privilege")
    private PrivilegePageModel privilegePageModel;

    @kg(key = "privilegeTime")
    private int privilegeTime;

    @kg(key = "privilegeType")
    private int privilegeType;

    @kg(key = "retain")
    private RetainPageModel retainPageModel;

    public RewardPropModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public RewardConditionModel getConditionModel() {
        return this.conditionModel;
    }

    public EndCardPageModel getEndCardModel() {
        return this.endCardModel;
    }

    public int getEndCardType() {
        EndCardPageModel endCardPageModel = this.endCardModel;
        if (endCardPageModel != null) {
            return endCardPageModel.getType();
        }
        return 0;
    }

    public int getForceEndCard() {
        return this.forceEndCard;
    }

    public PrimarySkipCtrlModel getPrimarySkipCtrlModel() {
        return this.primarySkipCtrlModel;
    }

    public PrivilegePageModel getPrivilegePageModel() {
        return this.privilegePageModel;
    }

    public int getPrivilegeTime() {
        return this.privilegeTime;
    }

    public int getPrivilegeType() {
        return this.privilegeType;
    }

    public RetainPageModel getRetainPageModel() {
        return this.retainPageModel;
    }
}
