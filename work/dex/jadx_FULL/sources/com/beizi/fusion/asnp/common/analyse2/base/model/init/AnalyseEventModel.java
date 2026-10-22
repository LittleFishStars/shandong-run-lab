package com.beizi.fusion.asnp.common.analyse2.base.model.init;

import com.alibaba.ariver.permission.b;
import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseEventModel extends AnalyseBasicReceiveLog {

    @kg(key = "count")
    private int count;

    @kg(key = b.b)
    private List<String> exclude;

    @kg(key = "codes")
    private List<String> handleCodes;

    @kg(key = "sample")
    private int sample;

    @kg(key = "time")
    private String time;

    @kg(key = "uploadUrl")
    private String uploadUrl;

    public AnalyseEventModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public List a() {
        return this.exclude;
    }

    public List b() {
        return this.handleCodes;
    }

    public int c() {
        return this.sample;
    }

    public String d() {
        return this.time;
    }

    public String e() {
        return this.uploadUrl;
    }

    public int getCount() {
        return this.count;
    }
}
