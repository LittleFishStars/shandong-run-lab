package com.beizi.fusion.asnp.adn.ad.cache.ad.pre.model;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PreCacheAdModel extends ASNPJsonResponseModel {

    @kg(key = "result")
    private List<PreCacheSpaceAdModel> spaceAdModelList;

    public PreCacheAdModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public List a() {
        return this.spaceAdModelList;
    }
}
