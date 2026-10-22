package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev;

import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.ext.ReqDeviceExtModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.geo.ReqDeviceGeoModel;
import com.beizi.fusion.kg;
import com.beizi.fusion.yb;
import com.zj.adlib.dv9;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReqDeviceModel extends ASNPJsonRequestModel {

    @kg(key = "brand")
    private String brand;

    @kg(key = "carrier")
    private String carrier;

    @kg(key = "contype")
    private String connectType;

    @kg(key = ze1.s)
    private String country;

    @kg(key = y6b.g)
    private int deviceHeight;

    @kg(key = "w")
    private int deviceWidth;

    @kg(key = LoginConstants.EXT)
    private ReqDeviceExtModel ext;

    @kg(key = "geo")
    private ReqDeviceGeoModel geo;

    @kg(key = dv9.h)
    private String language;

    @kg(key = "lmt")
    private int lmt;

    @kg(key = "make")
    private String make;

    @kg(key = ze1.k)
    private String model;

    @kg(key = "os")
    private int os;

    @kg(key = "osv")
    private String osVersion;

    @kg(key = "ppi")
    private float ppi;

    @kg(key = "pxratio")
    private float pxRatio;

    @kg(key = "tzone")
    private String timezone;

    @kg(key = "type")
    private int type;

    @kg(key = "ua")
    private String ua;

    public ReqDeviceModel(yb ybVar) {
        if (ybVar != null) {
            this.type = ybVar.y();
            this.ua = ybVar.d();
            this.make = ybVar.e();
            this.brand = ybVar.h();
            this.model = ybVar.g();
            this.os = ybVar.B();
            this.osVersion = ybVar.j();
            this.deviceWidth = ybVar.C();
            this.deviceHeight = ybVar.u();
            this.ppi = ybVar.k();
            this.pxRatio = ybVar.i();
            this.language = ybVar.D();
            this.carrier = ybVar.q();
            this.connectType = String.valueOf(ybVar.a());
            this.timezone = ybVar.F();
            this.country = ybVar.s();
        }
    }

    public void setExtModel(ReqDeviceExtModel reqDeviceExtModel) {
        this.ext = reqDeviceExtModel;
    }

    public void setGeoModel(ReqDeviceGeoModel reqDeviceGeoModel) {
        this.geo = reqDeviceGeoModel;
    }

    public void setLmt(int i) {
        this.lmt = i;
    }
}
