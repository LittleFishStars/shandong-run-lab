package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.apps;

import com.alibaba.ariver.kernel.RVParams;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.apps.pkg.PkgModel;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AppsModel extends ASNPJsonResponseModel {

    @kg(key = "delay")
    private int delay;

    @kg(key = "macros")
    private String macros;

    @kg(key = "pkgs")
    private List<PkgModel> pkgModelList;

    @kg(key = RVParams.LONG_REPORTURL)
    private String reportUrl;

    @kg(key = "taskReport")
    private int taskReport;

    public AppsModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getDelay() {
        return this.delay;
    }

    public String getMacros() {
        return this.macros;
    }

    public List<PkgModel> getPkgModelList() {
        return this.pkgModelList;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public int getTaskReport() {
        return this.taskReport;
    }
}
