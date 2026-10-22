package com.beizi.fusion.asnp.common.analyse2.base.model.biz;

import com.beizi.fusion.j2;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ASNPExtraLog extends AnalyseAdEventLog {

    @kg(key = "click_type")
    private String clickType;

    @kg(key = "creative_id")
    private String creativeId;

    @kg(key = "dsp_id")
    private String dspId;

    @kg(key = "ecpm")
    private String ecpm;

    @kg(key = "floor_price")
    private String floorPrice;

    @kg(key = "material_id")
    private String materialId;

    @kg(key = "order_id")
    private String orderId;

    @kg(key = "scheme_id")
    private String schemeId;

    public static class ASNPAnalyseAdEventLogWrapper extends AnalyseSimpleLog.AnalyseSimpleLogWrapper implements j2.a {

        @kg(key = "click_type")
        private String clickType;

        @kg(key = "creative_id")
        private String creativeId;

        @kg(key = "dsp_id")
        private String dspId;

        @kg(key = "ecpm")
        private String ecpm;

        @kg(key = "floor_price")
        private String floorPrice;

        @kg(key = "material_id")
        private String materialId;

        @kg(key = "order_id")
        private String orderId;

        @kg(key = "scheme_id")
        private String schemeId;

        public ASNPAnalyseAdEventLogWrapper(ASNPExtraLog aSNPExtraLog) {
            super(aSNPExtraLog);
            this.dspId = aSNPExtraLog.dspId;
            this.orderId = aSNPExtraLog.orderId;
            this.creativeId = aSNPExtraLog.creativeId;
            this.materialId = aSNPExtraLog.materialId;
            this.schemeId = aSNPExtraLog.schemeId;
            this.clickType = aSNPExtraLog.clickType;
            this.ecpm = aSNPExtraLog.ecpm;
            this.floorPrice = aSNPExtraLog.floorPrice;
        }
    }

    public ASNPExtraLog(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseAdEventLog
    public j2.a c() {
        return new ASNPAnalyseAdEventLogWrapper(this);
    }
}
