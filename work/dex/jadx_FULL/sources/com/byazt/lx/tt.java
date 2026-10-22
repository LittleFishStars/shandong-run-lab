package com.byazt.lx;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.yxi.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.igexin.sdk.PushConsts;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1021, 13})
public class tt implements Function<SparseArray<Object>, Object> {
    public final Map<String, Supplier<?>> c;
    public Function<SparseArray<Object>, Object> tt;

    @com.byazt.zqa.c(c = {0, 1, 1021, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public static final tt c = new tt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a() {
        return com.byazt.bp.c.t().rl().sp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object aw() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object bm() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().da());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object bx() {
        return com.byazt.bp.c.t().tt().rh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object c() {
        return com.byazt.bp.tt.tt().yp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object cu() {
        return com.byazt.bp.c.t().tt().qy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object d() {
        return Integer.valueOf(com.byazt.bp.c.t().tt().md());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object da() {
        return com.byazt.bp.c.t().rl().ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object eo() {
        return com.byazt.bp.c.t().tt().p();
    }

    public static tt getInstance() {
        return c.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object gr() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().lr());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object gt() {
        return com.byazt.bp.c.t().tt().aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object gu() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object h() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object hd() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().sl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object i() {
        return com.byazt.bp.c.t().rl().uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object ic() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object l() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lr() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object m() {
        return com.byazt.bp.c.t().tt().nb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object md() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().sp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object my() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().qp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object n() {
        return com.byazt.bp.c.t().rl().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object nb() {
        return com.byazt.bp.c.t().tt().gt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object nu() {
        return com.byazt.bp.c.t().tt().hd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object or() {
        return com.byazt.bp.c.t().tt().gu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object p() {
        return Double.valueOf(com.byazt.bp.c.t().tt().m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object pf() {
        return com.byazt.bp.c.t().tt().my();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object qp() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().rl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object qy() {
        return com.byazt.bp.c.t().tt().tt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object rh() {
        return com.byazt.bp.c.t().tt().ic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object rl() {
        return com.byazt.bp.c.t().tt().ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object sl() {
        return com.byazt.bp.c.t().rl().tt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object sp() {
        return com.byazt.bp.c.t().rl().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object sv() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().yp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object t() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().yv());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object tt() {
        return Integer.valueOf(com.byazt.bp.tt.tt().s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object u() {
        return com.byazt.bp.c.t().tt().sv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object uj() {
        com.byazt.hk.c.c().ve();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object ve() {
        return Integer.valueOf(com.byazt.bp.tt.tt().r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object x() {
        return Integer.valueOf(com.byazt.bp.c.t().rl().n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object yp() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().bx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object yv() {
        return Double.valueOf(com.byazt.bp.c.t().tt().nu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object z() {
        return com.byazt.bp.c.t().tt().pf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object zb() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().zm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object zm() {
        return Boolean.valueOf(com.byazt.bp.c.t().tt().bm());
    }

    public void reportRequestResult(String str, Object obj, boolean z) {
        if (this.tt != null) {
            uj ujVarC = uj.c();
            ujVarC.c(10012).c(Void.class);
            ujVarC.c(20012, new Pair(str, obj));
            ujVarC.c(20017, Boolean.valueOf(z));
            this.tt.apply(ujVarC.tt());
        }
    }

    public void setQATool(Function<SparseArray<Object>, Object> function) {
        this.tt = function;
    }

    private tt() {
        HashMap map = new HashMap();
        this.c = map;
        map.put("PluginInitConfig.isCanUseLocation", new Supplier() { // from class: com.zj.adlib.zrb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.l();
            }
        });
        map.put("PluginInitConfig.isCanUsePhoneState", new Supplier() { // from class: com.zj.adlib.bsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.lr();
            }
        });
        map.put("PluginInitConfig.isCanUseWriteExternal", new Supplier() { // from class: com.zj.adlib.nsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.bm();
            }
        });
        map.put("PluginInitConfig.appList", new Supplier() { // from class: com.zj.adlib.zsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.hd();
            }
        });
        map.put("PluginInitConfig.isCanUseMacAddress", new Supplier() { // from class: com.zj.adlib.ftb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.ic();
            }
        });
        map.put("PluginInitConfig.isCanUseAndroidId", new Supplier() { // from class: com.zj.adlib.htb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.aw();
            }
        });
        map.put("PluginInitConfig.isProgrammaticRecommend", new Supplier() { // from class: com.zj.adlib.itb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.sv();
            }
        });
        map.put("PluginInitConfig.getDevImei", new Supplier() { // from class: com.zj.adlib.jtb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.bx();
            }
        });
        map.put("PluginInitConfig.getDevImeis", new Supplier() { // from class: com.zj.adlib.ktb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.pf();
            }
        });
        map.put("PluginInitConfig.getAndroidId", new Supplier() { // from class: com.zj.adlib.ltb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.nb();
            }
        });
        map.put("PluginInitConfig.isCanUseOaid", new Supplier() { // from class: com.zj.adlib.ksb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.qp();
            }
        });
        map.put("PluginInitConfig.getDevOaid", new Supplier() { // from class: com.zj.adlib.vsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.cu();
            }
        });
        map.put("PluginInitConfig.getMacAddress", new Supplier() { // from class: com.zj.adlib.gtb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.or();
            }
        });
        map.put("PluginInitConfig.isCanUseWifiState", new Supplier() { // from class: com.zj.adlib.mtb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.zb();
            }
        });
        map.put("PluginInitConfig.getAppList", new Supplier() { // from class: com.zj.adlib.ntb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.eo();
            }
        });
        map.put("PluginInitConfig.getAgeGroup", new Supplier() { // from class: com.zj.adlib.otb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.d();
            }
        });
        map.put("PluginInitConfig.isCustom", new Supplier() { // from class: com.zj.adlib.ptb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.h();
            }
        });
        map.put("PluginInitConfig.isLimitPersonalAds", new Supplier() { // from class: com.zj.adlib.qtb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.md();
            }
        });
        map.put("PluginInitConfig.getLatitude", new Supplier() { // from class: com.zj.adlib.rtb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.p();
            }
        });
        map.put("PluginInitConfig.getLongitude", new Supplier() { // from class: com.zj.adlib.asb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.yv();
            }
        });
        map.put("PluginInitConfig.isWxInstalled", new Supplier() { // from class: com.zj.adlib.csb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.zm();
            }
        });
        map.put("PluginInitConfig.isSupportH265", new Supplier() { // from class: com.zj.adlib.dsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.gr();
            }
        });
        map.put("PluginInitConfig.isSupportSplashZoomout", new Supplier() { // from class: com.zj.adlib.esb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.gu();
            }
        });
        map.put("PluginInitConfig.getAppId", new Supplier() { // from class: com.zj.adlib.fsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.qy();
            }
        });
        map.put("PluginInitConfig.getAppName", new Supplier() { // from class: com.zj.adlib.gsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.rl();
            }
        });
        map.put("PluginInitConfig.getLocalExtra", new Supplier() { // from class: com.zj.adlib.hsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.gt();
            }
        });
        map.put("PluginInitConfig.getHttps", new Supplier() { // from class: com.zj.adlib.isb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.my();
            }
        });
        map.put("PluginInitConfig.getCustomLocalConfig", new Supplier() { // from class: com.zj.adlib.jsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.rh();
            }
        });
        map.put("PluginInitConfig.getOpensdkVer", new Supplier() { // from class: com.zj.adlib.lsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.nu();
            }
        });
        map.put("PluginInitConfig.getWxAppId", new Supplier() { // from class: com.zj.adlib.msb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.m();
            }
        });
        map.put("PluginInitConfig.getPublisherDid", new Supplier() { // from class: com.zj.adlib.osb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.z();
            }
        });
        map.put("PluginInitConfig.isOpenAdnTest", new Supplier() { // from class: com.zj.adlib.psb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.yp();
            }
        });
        map.put("PluginInitConfig.getMediationConfigUserInfoForSegment", new Supplier() { // from class: com.zj.adlib.qsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.u();
            }
        });
        map.put("PluginInitConfig.isCanUsePermissionRecordAudio", new Supplier() { // from class: com.zj.adlib.rsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.t();
            }
        });
        map.put("GMConfigUserInfoForSegment.getUserId", new Supplier() { // from class: com.zj.adlib.ssb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.sl();
            }
        });
        map.put("GMConfigUserInfoForSegment.getChannel", new Supplier() { // from class: com.zj.adlib.tsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.da();
            }
        });
        map.put("GMConfigUserInfoForSegment.getSubChannel", new Supplier() { // from class: com.zj.adlib.usb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.i();
            }
        });
        map.put("GMConfigUserInfoForSegment.getAge", new Supplier() { // from class: com.zj.adlib.wsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.x();
            }
        });
        map.put("GMConfigUserInfoForSegment.getGender", new Supplier() { // from class: com.zj.adlib.xsb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.sp();
            }
        });
        map.put("GMConfigUserInfoForSegment.getUserValueGroup", new Supplier() { // from class: com.zj.adlib.ysb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.a();
            }
        });
        map.put("GMConfigUserInfoForSegment.getCustomInfos", new Supplier() { // from class: com.zj.adlib.atb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.n();
            }
        });
        map.put("AdCacheManager.clearCache", new Supplier() { // from class: com.zj.adlib.btb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.uj();
            }
        });
        map.put("TTSdkSettings.getIsLimitPersonalAds", new Supplier() { // from class: com.zj.adlib.ctb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.ve();
            }
        });
        map.put("TTSdkSettings.getIsLimitProgrammaticRecommend", new Supplier() { // from class: com.zj.adlib.dtb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.tt();
            }
        });
        map.put("TTSdkSettings.getEtag", new Supplier() { // from class: com.zj.adlib.etb
            @Override // java.util.function.Supplier
            public final Object get() {
                return com.byazt.lx.tt.c();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T c(Object obj, Class<T> cls, T t) {
        return cls.isInstance(obj) ? obj : t;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        int iIntValue = ((Integer) c(sparseArray.get(-99999987), Integer.class, 0)).intValue();
        c(sparseArray.get(-99999985), Class.class, null);
        if (iIntValue == 10007) {
            Supplier<?> supplier = this.c.get((String) c(sparseArray.get(20007), String.class, ""));
            if (supplier != null) {
                return supplier.get();
            }
        } else if (iIntValue != 10011) {
            switch (iIntValue) {
                case 10013:
                    JSONObject jSONObject = (JSONObject) c(sparseArray.get(20013), JSONObject.class, null);
                    if (jSONObject != null) {
                        com.byazt.bp.tt.tt().c(jSONObject);
                    }
                    break;
                case PushConsts.ACTION_NOTIFICATION_ENABLE /* 10014 */:
                    return com.byazt.ck.uj.c().c(((Integer) c(sparseArray.get(20015), Integer.class, -1)).intValue(), (String) c(sparseArray.get(20016), String.class, ""));
                case PushConsts.ACTION_POPUP_SHOW /* 10015 */:
                    return Integer.valueOf(com.byazt.hk.c.c().tt((String) c(sparseArray.get(20018), String.class, "")));
            }
        } else {
            JSONArray jSONArray = (JSONArray) c(sparseArray.get(PushConsts.SETTAG_TAG_ILLEGAL), JSONArray.class, null);
            if (jSONArray != null) {
                com.byazt.ck.uj.c().c(jSONArray, false, false);
            }
        }
        return null;
    }
}
