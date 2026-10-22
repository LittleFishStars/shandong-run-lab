package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.notify;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.anim.RenderAnimModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NotifyPropModel extends ASNPJsonResponseModel {

    @kg(key = "animate")
    private RenderAnimModel anim;

    @kg(key = "bindInfo")
    private String bindId;

    @kg(key = "delay")
    private int delay;

    @kg(key = "remain")
    private int remain;

    public NotifyPropModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public RenderAnimModel getAnim() {
        return this.anim;
    }

    public String getBindId() {
        return this.bindId;
    }

    public int getDelay() {
        return this.delay;
    }

    public int getRemain() {
        return this.remain;
    }
}
