package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.event;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class EventModel extends ASNPJsonResponseModel {

    @kg(key = "method")
    private int method;

    @kg(key = "type")
    private int type;

    @kg(key = "url")
    private String url;

    public EventModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getMethod() {
        return this.method;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }
}
