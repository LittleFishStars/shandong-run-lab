package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.item;

import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.item.spec.ReqSpecModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReqItemModel extends ASNPJsonRequestModel {

    @kg(key = "dlvy")
    private int dlvy;

    @kg(key = "exp")
    private long exp;

    @kg(key = LoginConstants.EXT)
    private JSONObject ext;

    @kg(key = "qty")
    private int qty;

    @kg(key = "spec")
    private ReqSpecModel spec;

    public void setDlvy(int i) {
        this.dlvy = i;
    }

    public void setExp(long j) {
        this.exp = j;
    }

    public void setExt(JSONObject jSONObject) {
        this.ext = jSONObject;
    }

    public void setQty(int i) {
        this.qty = i;
    }

    public void setSpec(ReqSpecModel reqSpecModel) {
        this.spec = reqSpecModel;
    }
}
