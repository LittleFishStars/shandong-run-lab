package com.beizi.fusion.asnp.common.analyse2.base.model.init;

import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseAdapterModel extends AnalyseBasicReceiveLog {

    @kg(key = "version")
    private String code;

    @kg(key = "adapter")
    private String name;

    public AnalyseAdapterModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
