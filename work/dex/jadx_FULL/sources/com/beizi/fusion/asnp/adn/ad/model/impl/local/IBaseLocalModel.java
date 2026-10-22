package com.beizi.fusion.asnp.adn.ad.model.impl.local;

import com.beizi.fusion.mg;
import com.beizi.fusion.oa;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class IBaseLocalModel extends oa {
    public IBaseLocalModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    private String parseToJson() {
        return mg.b(this).toString();
    }

    @Override // com.beizi.fusion.oa, com.beizi.fusion.fd
    public String toJsonString() {
        JSONObject jSONObject = this.mJsonObject;
        return jSONObject != null ? jSONObject.toString() : parseToJson();
    }
}
