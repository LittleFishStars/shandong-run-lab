package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import com.zj.adlib.y6b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ImageModel extends ASNPJsonResponseModel {

    @kg(key = y6b.g)
    private int imageHeight;

    @kg(key = "w")
    private int imageWidth;

    @kg(key = "placeHolder")
    private String placeHolder;

    @kg(key = "type")
    private int type;

    @kg(key = "url")
    private String url;

    public ImageModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public String getPlaceHolder() {
        return this.placeHolder;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }
}
