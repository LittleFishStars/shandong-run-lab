package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.log2.crash;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Crash2ConfigModel extends ASNPJsonResponseModel {

    @kg(key = "close")
    private int close;

    @kg(key = "url")
    private String url;

    public Crash2ConfigModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public boolean isClose() {
        return this.close == 1;
    }
}
