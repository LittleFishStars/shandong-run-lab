package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.cfg.ConfigRequestModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class x5 implements db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f28023a;
    private final String b;

    public x5(Context context, String str) {
        this.f28023a = context;
        this.b = str;
    }

    private ConfigRequestModel a(Context context, String str) {
        ConfigRequestModel configRequestModel = new ConfigRequestModel();
        configRequestModel.setTimeStamp(System.currentTimeMillis());
        configRequestModel.setAppID(str);
        configRequestModel.setSdkVersion(m0.c());
        configRequestModel.setBetaPlanIds(f.f);
        n nVar = (n) o.a().b(context);
        yb ybVarB = nVar != null ? nVar.b() : null;
        if (ybVarB != null) {
            configRequestModel.setUserAgent(ybVarB.d());
            configRequestModel.setDeviceType(ybVarB.y());
            configRequestModel.setManufacturer(ybVarB.e());
            configRequestModel.setBrand(ybVarB.h());
            configRequestModel.setModel(ybVarB.g());
            configRequestModel.setOs(ybVarB.B());
            configRequestModel.setOsVersion(ybVarB.j());
            configRequestModel.setCarrier(ybVarB.q());
            configRequestModel.setConnectType(ybVarB.a());
            configRequestModel.setLanguage(ybVarB.D());
            configRequestModel.setScreenWidth(ybVarB.C());
            configRequestModel.setScreenHeight(ybVarB.u());
            configRequestModel.setResolutionWidth(ybVarB.C());
            configRequestModel.setResolutionHeight(ybVarB.u());
            configRequestModel.setOrientation(ybVarB.c());
            configRequestModel.setDensity(ybVarB.i());
            configRequestModel.setPpi(ybVarB.k());
            configRequestModel.setUpdateMark(ybVarB.A());
            configRequestModel.setPhysicalMemory(ybVarB.n());
            configRequestModel.setHardDiskSize(ybVarB.l());
            configRequestModel.setDeviceName(ybVarB.b());
            configRequestModel.setCountry(ybVarB.s());
            configRequestModel.setTimeZone(ybVarB.F());
            configRequestModel.setFileMark(ybVarB.r());
            configRequestModel.setCountry_CN(ybVarB.x());
            configRequestModel.setSAID(m0.a(context));
            configRequestModel.setOAID(ybVarB.getOAID());
        }
        g gVar = (g) h.a().b(context);
        if (gVar != null) {
            v vVarA = gVar.a();
            if (vVarA != null) {
                configRequestModel.setCOAID(vVarA.m());
            }
            ConfigResponseModel configResponseModelA = gVar.a(false);
            if (configResponseModelA != null) {
                configRequestModel.setUpdateMd5(configResponseModelA.getUpdateMD5());
                configRequestModel.setRequestUrlMD5(configResponseModelA.getRequestUrlMD5());
                configRequestModel.setStatisticsMD5(configResponseModelA.getStatisticsMD5());
            }
        }
        return configRequestModel;
    }

    @Override // com.beizi.fusion.db
    public String a() {
        return a(this.f28023a, this.b).toJsonString();
    }
}
