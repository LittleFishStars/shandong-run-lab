package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.local.AppInstallModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.AdRequestModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.ReqContextModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.app.ReqAppModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.ReqDeviceModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.ext.ReqDeviceExtModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.geo.ReqDeviceGeoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.ext.ReqContextExtModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.ext.install.ReqAppInstallModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.reg.ReqRegsModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.user.ReqUserModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.item.ReqItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.item.spec.ReqSpecModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.item.spec.ext.ReqSpecExtModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class v1 implements db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ba f27847a;
    private v b;
    private final Context c;
    private String d;
    private yb e;
    private d f;
    private String g;

    public v1(Context context) {
        this.c = context;
        n nVar = (n) o.a().b(context);
        if (nVar != null) {
            this.e = nVar.b();
        }
    }

    private List b() {
        List<AppInstallModel> listA = ((n) o.a().b(this.c)).a();
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AppInstallModel appInstallModel : listA) {
            ReqAppInstallModel reqAppInstallModel = new ReqAppInstallModel();
            reqAppInstallModel.setInstall(appInstallModel.isInstall());
            reqAppInstallModel.setLinkId(appInstallModel.getLinkId());
            reqAppInstallModel.setUpdateTime(appInstallModel.getUpdateTime());
            arrayList.add(reqAppInstallModel);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    private ReqContextExtModel c() {
        String strD;
        ReqContextExtModel reqContextExtModel = new ReqContextExtModel();
        reqContextExtModel.setAppInstall(b());
        q0 q0Var = (q0) r0.a().b(this.c);
        if (q0Var != null) {
            strD = q0Var.d();
            if (TextUtils.isEmpty(strD)) {
                strD = "0";
            }
        } else {
            strD = "0";
        }
        reqContextExtModel.setBlackListVersion(strD);
        return reqContextExtModel;
    }

    private ReqAppModel d() {
        ReqAppModel reqAppModel = new ReqAppModel();
        v vVar = this.b;
        reqAppModel.setAppId(vVar != null ? vVar.e() : "");
        reqAppModel.setBundle(this.c.getPackageName());
        reqAppModel.setInstall(xk.a(this.c));
        reqAppModel.setName(xk.c(this.c));
        reqAppModel.setUpdate(xk.b(this.c));
        reqAppModel.setVer(xk.d(this.c));
        return reqAppModel;
    }

    private ReqContextModel e() {
        ReqContextModel reqContextModel = new ReqContextModel();
        reqContextModel.setApp(d());
        reqContextModel.setExtModel(c());
        reqContextModel.setDevice(f());
        reqContextModel.setRegs(h());
        reqContextModel.setUser(i());
        return reqContextModel;
    }

    private ReqDeviceModel f() {
        ReqDeviceModel reqDeviceModel = new ReqDeviceModel(this.e);
        reqDeviceModel.setExtModel(a(this.e));
        jd jdVarA = ((kd) hh.a().b(this.c)).a();
        if (jdVarA != null) {
            reqDeviceModel.setGeoModel(new ReqDeviceGeoModel(jdVarA));
        }
        v vVar = this.b;
        if (vVar == null || !vVar.d()) {
            reqDeviceModel.setLmt(1);
            return reqDeviceModel;
        }
        reqDeviceModel.setLmt(0);
        return reqDeviceModel;
    }

    private List g() {
        ArrayList arrayList = new ArrayList();
        if (this.b != null) {
            ReqItemModel reqItemModel = new ReqItemModel();
            reqItemModel.setDlvy(1);
            ba baVar = this.f27847a;
            reqItemModel.setExp(baVar != null ? baVar.h() : 5000L);
            ba baVar2 = this.f27847a;
            reqItemModel.setQty(baVar2 != null ? baVar2.a() : 1);
            reqItemModel.setSpec(k());
            arrayList.add(reqItemModel);
        }
        return arrayList;
    }

    private ReqRegsModel h() {
        ReqRegsModel reqRegsModel = new ReqRegsModel();
        v vVar = this.b;
        if (vVar != null) {
            reqRegsModel.setCCPA(vVar.f());
            reqRegsModel.setCOPPA(this.b.g());
            reqRegsModel.setGDPR(this.b.q());
        }
        return reqRegsModel;
    }

    private ReqUserModel i() {
        ReqUserModel reqUserModel = new ReqUserModel();
        v vVar = this.b;
        reqUserModel.setId(vVar != null ? vVar.w() : "");
        reqUserModel.setData(a(this.b));
        v vVar2 = this.b;
        reqUserModel.setForbidSensor((vVar2 == null || !vVar2.x()) ? 1 : 0);
        return reqUserModel;
    }

    private ReqSpecExtModel j() {
        ReqSpecExtModel reqSpecExtModel = new ReqSpecExtModel();
        s0 s0Var = (s0) t0.a().b(this.c);
        if (s0Var != null) {
            reqSpecExtModel.setLocalSchemeIDs(s0Var.b(this.f));
        }
        return reqSpecExtModel;
    }

    private ReqSpecModel k() {
        ReqSpecModel reqSpecModel = new ReqSpecModel();
        reqSpecModel.setExt(j());
        reqSpecModel.setSdk(m0.a());
        reqSpecModel.setSdkVersion(m0.c());
        reqSpecModel.setStrategyMD5(this.g);
        ba baVar = this.f27847a;
        reqSpecModel.setTagID(baVar != null ? baVar.g() : "");
        return reqSpecModel;
    }

    public void a(ba baVar, v vVar, d dVar, String str, String str2) {
        this.f27847a = baVar;
        this.b = vVar;
        this.d = str;
        this.f = dVar;
        this.g = str2;
    }

    @Override // com.beizi.fusion.db
    public String a() {
        int iX;
        if (this.f27847a == null || this.b == null) {
            return "";
        }
        AdRequestModel adRequestModel = new AdRequestModel();
        adRequestModel.setBidModel(1);
        adRequestModel.setContext(e());
        adRequestModel.setCurrency(this.b.i());
        adRequestModel.setId(this.d);
        adRequestModel.setItem(g());
        v vVar = this.b;
        if (vVar != null) {
            iX = vVar.h();
        } else {
            yb ybVar = this.e;
            iX = ybVar != null ? ybVar.x() : w6.COUNTRY_CHINA_TYPE.b();
        }
        adRequestModel.setCountryCN(iX);
        v vVar2 = this.b;
        adRequestModel.setTest((vVar2 == null || !vVar2.y()) ? 0 : 1);
        adRequestModel.setBidTimeout(5000);
        return adRequestModel.toJsonString();
    }

    private JSONArray a(v vVar) {
        Map mapS;
        if (vVar != null && (mapS = vVar.s()) != null && !mapS.isEmpty()) {
            return mg.a(mapS, "id", "name");
        }
        return mg.a();
    }

    private ReqDeviceExtModel a(yb ybVar) {
        if (ybVar == null) {
            return null;
        }
        ReqDeviceExtModel reqDeviceExtModel = new ReqDeviceExtModel();
        reqDeviceExtModel.setDeviceName(ybVar.b());
        reqDeviceExtModel.setFileMark(ybVar.r());
        reqDeviceExtModel.setPhysicalMemory(ybVar.n());
        reqDeviceExtModel.setUpdateMark(ybVar.A());
        reqDeviceExtModel.setHardDiskSize(ybVar.l());
        reqDeviceExtModel.setSaid(m0.a(this.c));
        reqDeviceExtModel.setHonorOAID(ybVar.w());
        reqDeviceExtModel.setIsDeveloper(ybVar.f());
        reqDeviceExtModel.setIsPrompt(ybVar.o());
        reqDeviceExtModel.setRomVersion(ybVar.E());
        reqDeviceExtModel.setCoreVersion(ybVar.t());
        reqDeviceExtModel.setStoreVersion(ybVar.z());
        reqDeviceExtModel.setOaid(ybVar.getOAID());
        v vVar = this.b;
        reqDeviceExtModel.setCoaid(vVar != null ? vVar.m() : "");
        gq gqVarA = gq.a(this.c);
        reqDeviceExtModel.setWxInstall(gqVarA.b(this.c));
        reqDeviceExtModel.setOpenSDKVersion(gqVarA.b());
        reqDeviceExtModel.setWxSupportApiVersion(gqVarA.c());
        return reqDeviceExtModel;
    }
}
