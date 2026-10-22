package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TitleModel extends ASNPJsonResponseModel {

    @kg(key = "len")
    private int length;

    @kg(key = "text")
    private String text;

    public TitleModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getLength() {
        return this.length;
    }

    public String getText() {
        return this.text;
    }
}
