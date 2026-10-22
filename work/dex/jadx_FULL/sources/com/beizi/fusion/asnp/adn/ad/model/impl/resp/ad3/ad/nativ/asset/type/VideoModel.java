package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import com.zj.adlib.y6b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class VideoModel extends ASNPJsonResponseModel {

    @kg(key = "adm")
    private String adm;

    @kg(key = "curl")
    private String curl;

    @kg(key = "videoDuration")
    private int duration;

    @kg(key = "url")
    private String url;

    @kg(key = "videoCover")
    private String videoCover;

    @kg(key = y6b.g)
    private int videoHeight;

    @kg(key = "w")
    private int videoWidth;

    public VideoModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getAdm() {
        return this.adm;
    }

    public String getCurl() {
        return this.curl;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVideoCover() {
        return this.videoCover;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }
}
