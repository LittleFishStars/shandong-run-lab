package com.beizi.fusion.asnp.adn.ad.model.impl.resp.basic;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ADNConfigResponse extends ASNPJsonResponseModel {

    @kg(key = "code")
    private int code;

    @kg(key = "data")
    private ConfigResponseModel data;

    @kg(key = "msg")
    private String msg;

    public ADNConfigResponse(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getCode() {
        return this.code;
    }

    public ConfigResponseModel getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isResponseValid() {
        return (hasParseException() || this.code != 200 || this.data == null) ? false : true;
    }
}
