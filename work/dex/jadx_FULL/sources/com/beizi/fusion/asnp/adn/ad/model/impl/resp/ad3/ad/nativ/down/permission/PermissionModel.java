package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.permission;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PermissionModel extends ASNPJsonResponseModel {

    @kg(key = "describe")
    private String describe;

    @kg(key = "permissionType")
    private String permissionType;

    @kg(key = "title")
    private String title;

    public PermissionModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getDescribe() {
        return this.describe;
    }

    public String getPermissionType() {
        return this.permissionType;
    }

    public String getTitle() {
        return this.title;
    }
}
