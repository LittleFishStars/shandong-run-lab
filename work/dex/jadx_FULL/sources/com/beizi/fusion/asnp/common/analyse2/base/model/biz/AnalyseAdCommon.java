package com.beizi.fusion.asnp.common.analyse2.base.model.biz;

import android.text.TextUtils;
import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.gb;
import com.beizi.fusion.j2;
import com.beizi.fusion.kg;
import com.beizi.fusion.mg;
import com.beizi.fusion.nn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseAdCommon extends AnalyseBasicReceiveLog {

    @kg(key = "cache_session_id")
    private String cacheSessionID;

    @kg(key = "ad_type")
    private String mAdType;

    @kg(key = "currency")
    private String mCurrency;

    @kg(key = "custom_data")
    private String mCustomData;

    @kg(key = "hex_id")
    private String mHex;

    @kg(key = "quantity")
    private String mQuantity;

    @kg(key = "session_id")
    private String mSessionID;

    @kg(key = "space_id")
    private String mSpaceID;

    @kg(key = "time_out")
    private String mTimeout;

    public static class AnalyseSessionCommonLogWrapper extends gb implements j2.b {

        @kg(key = "event_list")
        private List<j2.a> adEventLogs;

        @kg(key = "cache_session_id")
        private String cacheSessionID;

        @kg(key = "ad_type")
        private String mAdType;

        @kg(key = "currency")
        private String mCurrency;

        @kg(key = "custom_data")
        private String mCustomData;

        @kg(key = "hex_id")
        private String mHex;

        @kg(key = "quantity")
        private String mQuantity;

        @kg(key = "session_id")
        private String mSessionID;

        @kg(key = "space_id")
        private String mSpaceID;

        @kg(key = "time_out")
        private String mTimeout;

        private AnalyseSessionCommonLogWrapper(AnalyseAdCommon analyseAdCommon) {
            JSONArray jSONArrayB;
            this.mSpaceID = analyseAdCommon.mSpaceID;
            this.mSessionID = analyseAdCommon.mSessionID;
            this.mAdType = analyseAdCommon.mAdType;
            this.mCurrency = analyseAdCommon.mCurrency;
            this.mCustomData = analyseAdCommon.mCustomData;
            this.mTimeout = analyseAdCommon.mTimeout;
            this.mQuantity = analyseAdCommon.mQuantity;
            this.cacheSessionID = analyseAdCommon.cacheSessionID;
            String str = analyseAdCommon.mHex;
            this.mHex = str;
            if (TextUtils.isEmpty(str)) {
                this.mHex = nn.a(this.mSessionID) + "";
            }
            if (TextUtils.isEmpty(this.mCurrency) || (jSONArrayB = mg.b(this.mCurrency)) == null || jSONArrayB.length() <= 0) {
                return;
            }
            this.mCurrency = mg.a(jSONArrayB, 0);
        }

        @Override // com.beizi.fusion.j2.b
        public void b(List list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((AnalyseAdEventLog) it.next()).a());
            }
            this.adEventLogs = arrayList;
        }
    }

    public AnalyseAdCommon(JSONObject jSONObject) {
        super(jSONObject);
    }

    public j2.b a() {
        return new AnalyseSessionCommonLogWrapper();
    }

    public String b() {
        return this.mSessionID;
    }
}
