package com.beizi.fusion.asnp.common.analyse2.base.model.init;

import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.kg;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.openset.constant.DeviceIdType;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseUserModel extends AnalyseBasicReceiveLog {

    @kg(exclude = true, key = DeviceIdType.OAID)
    private String oaid;

    @kg(exclude = true, key = "said")
    private String said;

    @kg(key = "user_custom_data")
    private String userCustomData;

    @kg(key = PtgRewardConstant.REWARD_PARAMS.USER_ID)
    private String userId;

    @kg(key = "lmt")
    private String userLmt;

    public AnalyseUserModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String a() {
        return this.oaid;
    }

    public String b() {
        return this.said;
    }

    public String c() {
        return this.userCustomData;
    }

    public String d() {
        return this.userId;
    }

    public String e() {
        return this.userLmt;
    }
}
