package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.task;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TaskUrlModel extends ASNPJsonResponseModel {

    @kg(key = "implement")
    private String implement;

    @kg(key = "delay")
    private long nextTime;

    @kg(key = "randomTime")
    private long randomTime;

    @kg(key = "schedule")
    private int schedule;

    @kg(key = "url")
    private String url;

    public TaskUrlModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public long getDelay() {
        return this.nextTime;
    }

    public String getImplement() {
        return this.implement;
    }

    public long getRandomTime() {
        return this.randomTime;
    }

    public int getSchedule() {
        return this.schedule;
    }

    public String getUrl() {
        return this.url;
    }
}
