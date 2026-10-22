package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.log2;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.log2.crash.Crash2ConfigModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.log2.event.Analyse2EventModel;
import com.beizi.fusion.kg;
import com.beizi.fusion.m0;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Analyse2ConfigModel extends ASNPJsonResponseModel {

    @kg(key = "crash")
    private Crash2ConfigModel crash;

    @kg(key = "customData")
    private String customData;
    private final String customID;

    @kg(key = "acceptEncrypt")
    private String encrypt;

    @kg(key = "event")
    private List<Analyse2EventModel> events;

    @kg(key = "version")
    private String versionMd5;

    public Analyse2ConfigModel(JSONObject jSONObject) {
        super(jSONObject);
        this.customID = m0.e();
    }

    public Crash2ConfigModel getCrash() {
        return this.crash;
    }

    public String getVersionMd5() {
        return this.versionMd5;
    }
}
