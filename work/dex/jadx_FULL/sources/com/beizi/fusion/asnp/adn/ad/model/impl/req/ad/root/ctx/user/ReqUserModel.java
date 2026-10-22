package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.user;

import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.kg;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReqUserModel extends ASNPJsonRequestModel {

    @kg(key = "data")
    private JSONArray data;

    @kg(key = LoginConstants.EXT)
    private JSONObject ext;

    @kg(key = "forbidSensor")
    private int forbidSensor;

    @kg(key = "id")
    private String id;

    public void setData(JSONArray jSONArray) {
        this.data = jSONArray;
    }

    public void setExt(JSONObject jSONObject) {
        this.ext = jSONObject;
    }

    public void setForbidSensor(int i) {
        this.forbidSensor = i;
    }

    public void setId(String str) {
        this.id = str;
    }
}
