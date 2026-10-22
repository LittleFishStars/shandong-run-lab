package com.beizi.fusion.asnp.common.analyse2.base.model.init;

import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.kg;
import com.zj.adlib.xh9;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseChannelModel extends AnalyseBasicReceiveLog {

    @kg(key = "version")
    private String code;

    @kg(key = xh9.WEBSITE_PARAMS_CHANNEL)
    private String name;

    public AnalyseChannelModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
