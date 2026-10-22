package com.byazt.atv;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.aas.or;
import com.byazt.ete.gr;
import com.byazt.ete.ic;
import com.byazt.ete.ma;
import com.byazt.ete.pu;
import com.byazt.ouz.sl;
import com.byazt.sz.gt;
import com.byazt.sz.rh;
import com.byazt.sz.yp;
import com.byazt.xl.x;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 134, 91})
public class sp extends n implements c {
    public com.byazt.kdw.tt gu;
    public sl qy;

    public sp(Context context, ic icVar, tt ttVar, ViewGroup viewGroup) {
        super(context, icVar, ttVar, viewGroup);
        if (ttVar != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            uj.c(this.f28298a, this.c, ttVar.qp(), atomicBoolean);
            uj.tt(this.f28298a, this.c, ttVar.qp(), atomicBoolean);
        }
    }

    private void rh() {
        yp ypVar = new yp();
        HashMap map = new HashMap();
        ic icVar = this.f28298a;
        if (icVar != null) {
            map.put("shake_value", Integer.valueOf(icVar.ge()));
            map.put("calculation_method", Integer.valueOf(this.f28298a.e()));
            map.put("rotation_angle", Integer.valueOf(this.f28298a.br()));
            map.put("calculation_method_twist", Integer.valueOf(this.f28298a.pe()));
            map.put("twist_config", this.f28298a.lv());
            map.put("image_info", com.byazt.jlk.tt.n(this.f28298a));
            map.put("cache_dir", com.byazt.bzd.sl.n());
            map.put("shake_interact_conf", this.f28298a.cy());
            map.put("twist_interact_conf", this.f28298a.yx());
        }
        ypVar.c(map);
        ypVar.c(this.tt);
        ypVar.c(this.uj);
        ypVar.tt(this.n);
        this.c.c("ad", ypVar);
    }

    private int ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str.hashCode();
        if (str.equals("shake")) {
            return 1;
        }
        return !str.equals("twist") ? 0 : 2;
    }

    @Override // com.byazt.atv.n
    public com.byazt.xj.ve a() {
        com.byazt.xj.ve<View> veVar = this.ve;
        if (veVar == null) {
            return null;
        }
        return veVar.n("VideoV3");
    }

    @Override // com.byazt.atv.n, com.byazt.kn.uj
    public void c(CharSequence charSequence, int i, int i2, boolean z) {
    }

    @Override // com.byazt.atv.n
    public JSONObject sl() {
        return this.sp.n();
    }

    @Override // com.byazt.atv.n
    public void tt(com.byazt.xl.sp spVar) {
        rh();
        this.c.c((rh) this);
        this.c.c((gt) this);
        ma maVarSp = pu.sp(this.f28298a);
        try {
            if (maVarSp != null) {
                this.ve = this.c.c(this.uj, this.n, maVarSp.n());
            } else {
                this.ve = this.c.c(this.uj, this.n, (JSONObject) null);
            }
            if (this.c.c()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_not_exist", new JSONArray((Collection) this.c.tt()));
                this.sp.or().c(jSONObject);
                spVar.c(138, "ugen unknown component");
                return;
            }
            if (this.c.ve()) {
                spVar.c(142, "ugen root disable");
                return;
            }
            if (this.ve != null) {
                if (this.rl == null) {
                    this.rl = new com.byazt.qmz.c(this.sp.n());
                }
                this.rl.c(this.c, this.ve);
            }
            this.sp.or().tt();
            this.sp.or().ve();
        } catch (NoClassDefFoundError unused) {
            if (spVar != null) {
                spVar.c(140, "ugen no class def found error");
            }
        } catch (UnsatisfiedLinkError unused2) {
            if (spVar != null) {
                spVar.c(139, "ugen yoga so load fail");
            }
        } catch (Throwable unused3) {
            if (spVar != null) {
                spVar.c(141, "ugen other fail");
            }
        }
    }

    @Override // com.byazt.atv.n
    public JSONObject c() {
        return this.sp.n().optJSONObject("xTemplate");
    }

    @Override // com.byazt.atv.n, com.byazt.sz.rh
    public void c(final com.byazt.xj.ve veVar, final String str, final com.byazt.pm.a.c cVar) {
        if (cVar == null) {
            return;
        }
        if (!TextUtils.equals(str, "shake") && !TextUtils.equals(str, "twist")) {
            tt(veVar, str, cVar);
            return;
        }
        WeakReference<ViewGroup> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        or.c(this.z, new com.byazt.hkv.ve() { // from class: com.byazt.atv.sp.1
            @Override // com.byazt.hkv.ve
            public void c() {
                WeakReference<ViewGroup> weakReference2 = sp.this.z;
                if (weakReference2 == null || weakReference2.get() == null || !or.c(sp.this.z.get())) {
                    return;
                }
                sp.this.tt(veVar, str, cVar);
            }
        });
    }

    public void c(String str, Map<String, String> map) {
        if (this.ve == null) {
            return;
        }
        com.byazt.pm.a.c cVar = new com.byazt.pm.a.c();
        cVar.c("custom");
        cVar.tt("emit");
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("name", str);
        cVar.c(map2);
        com.byazt.vd.c.C0556c.c(this.ve, "jsb", cVar).c();
    }

    @Override // com.byazt.atv.c
    public void c(sl slVar) {
        this.qy = slVar;
    }

    public void c(com.byazt.kdw.tt ttVar) {
        this.gu = ttVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void tt(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        byte b;
        CharSequence text;
        String strTt = cVar.tt();
        Map<String, Object> mapVe = cVar.ve();
        if (tt()) {
            HashMap map = new HashMap();
            map.put("ugen_click_event_params", this.yp);
            map.put("convert_action_type", Integer.valueOf(ve(str)));
            map.put("v3_trigger_name", str);
            if (com.byazt.qdk.c.c().c(cVar, this.f28298a, this.tt, veVar, sl(), this.u, map)) {
                return;
            }
        }
        if (com.byazt.kdw.c.c.contains(strTt)) {
            com.byazt.kdw.c.c(this.qy, this.gu, this.f28298a, this.tt, strTt, cVar, this.rh, veVar);
            return;
        }
        if ("uchain".equals(strTt)) {
            HashMap map2 = new HashMap();
            map2.put("material_meta", this.f28298a);
            map2.put("context", this.tt);
            map2.put("event_tag", nb.tt(this.f28298a));
            com.byazt.ppf.ve.c(this.f28298a, (HashMap<String, Object>) map2, cVar);
            return;
        }
        strTt.hashCode();
        int i = 3;
        switch (strTt.hashCode()) {
            case -1822902106:
                b = !strTt.equals("openAppPermission") ? (byte) -1 : (byte) 0;
                break;
            case -1657551782:
                b = !strTt.equals("openCommonUrl") ? (byte) -1 : (byte) 1;
                break;
            case -1639156586:
                b = !strTt.equals("renderScene") ? (byte) -1 : (byte) 2;
                break;
            case -511324706:
                b = !strTt.equals("openPrivacy") ? (byte) -1 : (byte) 3;
                break;
            case -87658418:
                b = !strTt.equals("resumeVideo") ? (byte) -1 : (byte) 4;
                break;
            case -55818203:
                b = !strTt.equals("pauseVideo") ? (byte) -1 : (byte) 5;
                break;
            case 3532159:
                b = !strTt.equals(FreeSpaceBox.TYPE) ? (byte) -1 : (byte) 6;
                break;
            case 94756344:
                b = !strTt.equals("close") ? (byte) -1 : (byte) 7;
                break;
            case 293548143:
                b = !strTt.equals("openAppFunction") ? (byte) -1 : (byte) 8;
                break;
            case 421035042:
                b = !strTt.equals("dismissScene") ? (byte) -1 : (byte) 9;
                break;
            case 804386914:
                b = !strTt.equals("videoControl") ? (byte) -1 : (byte) 10;
                break;
            case 951590323:
                b = !strTt.equals("convert") ? (byte) -1 : (byte) 11;
                break;
            case 1151744482:
                b = !strTt.equals("muteVideo") ? (byte) -1 : (byte) 12;
                break;
            case 1237425033:
                b = !strTt.equals("openAppPolicy") ? (byte) -1 : (byte) 13;
                break;
            case 1671642405:
                b = !strTt.equals(com.byazt.dyf.tt.AD_TAG_DISLIKE) ? (byte) -1 : com.google.common.base.a.p;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                i = 10;
                break;
            case 1:
                i = 13;
                break;
            case 2:
                if (mapVe != null) {
                    c(Objects.toString(mapVe.get("scene"), ""), Objects.toString(mapVe.get("ugen_id"), ""), Objects.toString(mapVe.get("ugen_md5"), ""), Objects.toString(mapVe.get("ugen_url"), ""), Objects.toString(mapVe.get("displayAreaAndroid"), ""), Objects.toString(mapVe.get("render_sequence"), ""));
                    return;
                }
                return;
            case 3:
                i = 7;
                break;
            case 4:
                sl slVar = this.qy;
                if (slVar != null) {
                    slVar.c(3);
                    return;
                }
                return;
            case 5:
                sl slVar2 = this.qy;
                if (slVar2 != null) {
                    slVar2.c(2);
                    return;
                }
                return;
            case 6:
                i = 6;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 12;
                break;
            case 9:
                if (mapVe != null) {
                    c(Objects.toString(mapVe.get("scene"), ""));
                    return;
                }
                return;
            case 10:
                i = 4;
                break;
            case 11:
                i = 2;
                break;
            case 12:
                i = 5;
                break;
            case 13:
                i = 9;
                break;
            case 14:
                break;
            default:
                i = 0;
                break;
        }
        gr.c cVarC = new gr.c().uj(this.yp.nu()).ve(this.yp.rh()).tt(this.yp.my()).c(this.yp.gt()).c(veVar.eo()).tt(this.yp.z()).c(this.yp.m()).c(tt(str));
        JSONObject jSONObject = new JSONObject();
        int iVe = ve(str);
        if (iVe > 0) {
            try {
                jSONObject.put("convertActionType", iVe);
            } catch (Throwable unused) {
            }
        }
        try {
            Object obj = mapVe.get("webUrl");
            Object obj2 = mapVe.get("webTitle");
            String strC = com.byazt.wj.tt.c(Objects.toString(obj, ""), sl());
            String strC2 = com.byazt.wj.tt.c(Objects.toString(obj2, ""), sl());
            jSONObject.put("openCommonWebUrl", strC);
            jSONObject.put("openCommonWebTitle", strC2);
        } catch (JSONException unused2) {
        }
        View viewI = veVar.i();
        try {
            if ((viewI instanceof TextView) && (text = ((TextView) viewI).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused3) {
        }
        cVarC.c(jSONObject);
        gr grVarC = cVarC.c();
        x xVar = this.i;
        if (xVar != null) {
            xVar.c(viewI, i, grVarC, -1);
        }
    }

    public static byte tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return (byte) 0;
        }
        str.hashCode();
        switch (str) {
            case "tap":
                return (byte) 1;
            case "shake":
                return (byte) 3;
            case "slide":
                return (byte) 2;
            case "twist":
                return (byte) 4;
            case "longTap":
                return (byte) 5;
            default:
                return (byte) 0;
        }
    }
}
