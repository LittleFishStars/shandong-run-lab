package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.apps.pkg;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PkgModel extends ASNPJsonResponseModel {

    @kg(key = "link")
    private String link;

    @kg(key = "linkId")
    private String linkID;

    public PkgModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getLink() {
        return this.link;
    }

    public String getLinkID() {
        return this.linkID;
    }
}
