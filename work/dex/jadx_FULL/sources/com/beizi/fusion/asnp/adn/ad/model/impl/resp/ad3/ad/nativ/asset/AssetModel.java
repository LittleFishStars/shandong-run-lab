package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type.ImageModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type.TitleModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type.VideoModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AssetModel extends ASNPJsonResponseModel {

    @kg(key = "id")
    private String id;

    @kg(key = "image")
    private ImageModel image;

    @kg(key = "title")
    private TitleModel title;

    @kg(key = "video")
    private VideoModel video;

    public AssetModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public ImageModel getImage() {
        return this.image;
    }

    public TitleModel getTitle() {
        return this.title;
    }

    public VideoModel getVideo() {
        return this.video;
    }
}
