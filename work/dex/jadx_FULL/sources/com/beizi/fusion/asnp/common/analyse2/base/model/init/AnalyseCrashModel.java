package com.beizi.fusion.asnp.common.analyse2.base.model.init;

import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseCrashModel extends AnalyseBasicReceiveLog {

    @kg(key = "close")
    private int close;

    @kg(key = "url")
    private String url;

    public AnalyseCrashModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getUrl() {
        return this.url;
    }
}
