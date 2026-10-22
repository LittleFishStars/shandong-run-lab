package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.geo;

import androidx.annotation.NonNull;
import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.geo.ext.GeoExtModel;
import com.beizi.fusion.jd;
import com.beizi.fusion.kg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ReqDeviceGeoModel extends ASNPJsonRequestModel {

    @kg(key = LoginConstants.EXT)
    private GeoExtModel ext;

    @kg(key = "lat")
    private float latitude;

    @kg(key = "lon")
    private float longitude;

    public ReqDeviceGeoModel(@NonNull jd jdVar) {
        this.latitude = (float) jdVar.a();
        this.longitude = (float) jdVar.b();
        this.ext = new GeoExtModel(jdVar.d(), jdVar.c().b());
    }
}
