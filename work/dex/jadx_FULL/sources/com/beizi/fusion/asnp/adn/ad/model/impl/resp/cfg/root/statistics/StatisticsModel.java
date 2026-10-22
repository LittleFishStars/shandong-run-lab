package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.apps.AppsModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.task.TaskUrlModel;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StatisticsModel extends ASNPJsonResponseModel {

    @kg(key = "apps")
    private AppsModel appsModel;

    @kg(key = "task")
    private List<TaskUrlModel> taskModels;

    @kg(key = "version")
    private String version;

    public StatisticsModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public AppsModel getAppsModel() {
        return this.appsModel;
    }

    public List<TaskUrlModel> getTaskModels() {
        return this.taskModels;
    }

    public String getVersion() {
        return this.version;
    }
}
