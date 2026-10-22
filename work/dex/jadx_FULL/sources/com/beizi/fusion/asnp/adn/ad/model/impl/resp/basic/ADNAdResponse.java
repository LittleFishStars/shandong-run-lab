package com.beizi.fusion.asnp.adn.ad.model.impl.resp.basic;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.AdResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ADNAdResponse extends ASNPJsonResponseModel {

    @kg(key = "code")
    private int code;

    @kg(key = "data")
    private AdResponseModel data3;

    @kg(key = "msg")
    private String msg;

    public ADNAdResponse(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getCode() {
        return this.code;
    }

    public AdResponseModel getData() {
        return this.data3;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isResponseValid() {
        return (hasParseException() || this.code != 200 || this.data3 == null) ? false : true;
    }
}
