package com.beizi.fusion.asnp.common.analyse2.base.model.biz;

import com.beizi.fusion.asnp.common.analyse2.base.model.Analyse2JsonLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.j2;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AMPSExtraAdInfoLog extends AnalyseBasicReceiveLog {

    @kg(key = "deepLink")
    private List<String> deeplink;

    @kg(key = "desc")
    private String desc;

    @kg(key = "materialUrl")
    private List<String> materialUrl;

    @kg(key = "price")
    private String price;

    @kg(key = "title")
    private String title;

    @kg(key = "url")
    private List<String> url;

    public static class AMPSExtraAdInfoLogWrapper extends Analyse2JsonLog implements j2.a {

        @kg(key = "deepLink")
        private List<String> deeplink;

        @kg(key = "desc")
        private String desc;

        @kg(key = "materialUrl")
        private List<String> materialUrl;

        @kg(key = "price")
        private String price;

        @kg(key = "title")
        private String title;

        @kg(key = "url")
        private List<String> url;

        public AMPSExtraAdInfoLogWrapper(AMPSExtraAdInfoLog aMPSExtraAdInfoLog) {
            this.title = aMPSExtraAdInfoLog.title;
            this.desc = aMPSExtraAdInfoLog.desc;
            this.materialUrl = aMPSExtraAdInfoLog.materialUrl;
            this.price = aMPSExtraAdInfoLog.price;
            this.url = aMPSExtraAdInfoLog.url;
            this.deeplink = aMPSExtraAdInfoLog.deeplink;
        }
    }

    public AMPSExtraAdInfoLog(JSONObject jSONObject) {
        super(jSONObject);
    }

    public AMPSExtraAdInfoLogWrapper a() {
        return new AMPSExtraAdInfoLogWrapper(this);
    }
}
