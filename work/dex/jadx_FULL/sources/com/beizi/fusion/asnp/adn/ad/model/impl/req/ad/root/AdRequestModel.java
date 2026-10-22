package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root;

import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.ReqContextModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.item.ReqItemModel;
import com.beizi.fusion.kg;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class AdRequestModel extends ASNPJsonRequestModel {

    @kg(key = t.u)
    private int bidModel;

    @kg(key = "tmax")
    private int bidTimeout;

    @kg(key = "context")
    private ReqContextModel context;

    @kg(key = "country_CN")
    private int country_CN;

    @kg(key = "cur")
    private List<String> currency;

    @kg(key = LoginConstants.EXT)
    private JSONObject ext;

    @kg(key = "id")
    private String id;

    @kg(key = "item")
    private List<ReqItemModel> item;

    @kg(key = "test")
    private int test;

    public void setBidModel(int i) {
        this.bidModel = i;
    }

    public void setBidTimeout(int i) {
        this.bidTimeout = i;
    }

    public void setContext(ReqContextModel reqContextModel) {
        this.context = reqContextModel;
    }

    public void setCountryCN(int i) {
        this.country_CN = i;
    }

    public void setCurrency(List<String> list) {
        this.currency = list;
    }

    public void setExt(JSONObject jSONObject) {
        this.ext = jSONObject;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setItem(List<ReqItemModel> list) {
        this.item = list;
    }

    public void setTest(int i) {
        this.test = i;
    }
}
