package com.beizi.fusion.asnp.common.analyse2.base.model.init;

import com.amap.api.fence.GeoFence;
import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseLogStrategyModel extends AnalyseBasicReceiveLog {

    @kg(key = "acceptEncrypt")
    private String acceptEncrypt;

    @kg(key = "crash")
    private AnalyseCrashModel crashModel;

    @kg(key = "customData")
    private String customData;

    @kg(key = GeoFence.BUNDLE_KEY_CUSTOMID)
    private String customID;

    @kg(key = "event")
    private List<AnalyseEventModel> eventModels;

    @kg(key = "version")
    private String version;

    public AnalyseLogStrategyModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String a() {
        return this.acceptEncrypt;
    }

    public AnalyseCrashModel b() {
        return this.crashModel;
    }

    public String getCustomData() {
        return this.customData;
    }

    public List getEventModels() {
        return this.eventModels;
    }

    public String getVersion() {
        return this.version;
    }
}
