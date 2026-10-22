package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.geo.ext;

import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.kg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GeoExtModel extends ASNPJsonRequestModel {

    @kg(key = "coordinate")
    private String coordinateType;

    @kg(key = "timestamp")
    private long timestamp;

    public GeoExtModel(long j, String str) {
        this.coordinateType = str;
        this.timestamp = j;
    }
}
