package com.byazt.omf;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 518})
public class h implements Function<SparseArray<Object>, Object> {
    public static final String GET_CONFIG_TIME_OUT_MSG = "配置未加载完成，请稍后2-5秒请求广告（修改建议：适当将请求非开屏类型广告的时机往后移）";
    public static final String NOT_INIT_TIPS_MSG = "please exec TTAdSdk.init and TTAdSdk.start before load ad";
    public static final String UNKNOWN_ERR_MSG = "未知异常";
    public volatile Context c;

    public h(Context context) {
        this.c = (context == null ? gt.getContext() : context).getApplicationContext();
    }

    public static boolean canMultiThreadLoad() {
        return AdSdkInitializerHolder.isSdkInitSuccess();
    }

    public static boolean checkExpressAdParamValid(com.byazt.dj.tt ttVar, boolean z) {
        if (ttVar == null) {
            return false;
        }
        return (z && !gt.tt().i(ttVar.uj())) || ttVar.x() > 0.0f;
    }

    public static void execLoadAd(com.byazt.bwm.sp spVar, int i) {
        if (canMultiThreadLoad()) {
            com.byazt.bwm.n.uj(spVar);
        } else {
            com.byazt.bwm.i.tt.t().execute(spVar);
        }
    }

    private Context getContext() {
        if (this.c == null) {
            this.c = gt.getContext();
        }
        return this.c;
    }

    public void loadAdByType(int i, PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c(pluginValueSet);
        cVarC.c(1, 0);
        PluginValueSet pluginValueSetTt = cVarC.tt();
        if (i == 1) {
            boolean zBooleanValue = pluginValueSetTt.booleanValue(2);
            com.byazt.dj.tt ttVarC = com.byazt.aas.md.c(i, pluginValueSetTt);
            if (zBooleanValue) {
                loadBannerExpressAd(ttVarC, new com.byazt.gk.x(function));
                return;
            } else {
                loadNativeAd(i, ttVarC, new com.byazt.gk.sp(function));
                return;
            }
        }
        if (i == 3) {
            loadSplashAd(com.byazt.aas.md.c(3, pluginValueSetTt), new com.byazt.gk.ve(function), pluginValueSetTt.intValue(3));
            return;
        }
        switch (i) {
            case 5:
                boolean zBooleanValue2 = pluginValueSetTt.booleanValue(2);
                com.byazt.dj.tt ttVarC2 = com.byazt.aas.md.c(i, pluginValueSetTt);
                if (!zBooleanValue2) {
                    loadFeedAd(ttVarC2, new com.byazt.gk.n(function));
                } else {
                    loadNativeExpressAd(ttVarC2, new com.byazt.gk.x(function));
                }
                break;
            case 6:
                loadStream(com.byazt.aas.md.c(6, pluginValueSetTt), new com.byazt.gk.n(function));
                break;
            case 7:
                loadRewardVideoAd(com.byazt.aas.md.c(7, pluginValueSetTt), new com.byazt.gk.i(function));
                break;
            case 8:
                loadFullScreenVideoAd(com.byazt.aas.md.c(8, pluginValueSetTt), new com.byazt.gk.a(function));
                break;
            case 9:
                boolean zBooleanValue3 = pluginValueSetTt.booleanValue(2);
                com.byazt.dj.tt ttVarC3 = com.byazt.aas.md.c(9, pluginValueSetTt);
                if (!zBooleanValue3) {
                    loadDrawFeedAd(ttVarC3, new com.byazt.gk.uj(function));
                } else {
                    loadExpressDrawFeedAd(ttVarC3, new com.byazt.gk.x(function));
                }
                break;
        }
    }

    public void loadBannerExpressAd(com.byazt.dj.tt ttVar, com.byazt.nh.a aVar) {
        com.byazt.sg.c.uj().c(1, ttVar, aVar);
    }

    public void loadDrawFeedAd(com.byazt.dj.tt ttVar, com.byazt.nh.tt ttVar2) {
        com.byazt.wb.c.uj().c(9, ttVar, ttVar2);
    }

    public void loadExpressDrawFeedAd(com.byazt.dj.tt ttVar, com.byazt.nh.a aVar) {
        com.byazt.wb.c.uj().c(9, ttVar, aVar);
    }

    public void loadFeedAd(com.byazt.dj.tt ttVar, com.byazt.nh.ve veVar) {
        com.byazt.pro.c.uj().c(5, ttVar, veVar);
    }

    public void loadFullScreenVideoAd(com.byazt.dj.tt ttVar, com.byazt.nh.uj ujVar) {
        com.byazt.cf.tt.c().c(ttVar, new com.byazt.cf.uj(ujVar));
    }

    public void loadNativeAd(int i, com.byazt.dj.tt ttVar, com.byazt.nh.n nVar) {
        com.byazt.sg.c.uj().c(i, ttVar, nVar);
    }

    public void loadNativeExpressAd(com.byazt.dj.tt ttVar, com.byazt.nh.a aVar) {
        com.byazt.pro.c.uj().c(5, ttVar, aVar);
    }

    public void loadRewardVideoAd(com.byazt.dj.tt ttVar, com.byazt.nh.sp spVar) {
        com.byazt.cf.sp.c().c(ttVar, new com.byazt.cf.uj(spVar));
    }

    public void loadSplashAd(com.byazt.dj.tt ttVar, com.byazt.nh.c cVar, int i) {
        com.byazt.cc.a.c(getContext()).c(ttVar, cVar, i);
    }

    public void loadStream(com.byazt.dj.tt ttVar, com.byazt.nh.ve veVar) {
        com.byazt.ob.c.uj().c(6, ttVar, veVar);
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            com.byazt.nr.m.ve("apply->load with null ->SparseArray");
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999982);
        Function<SparseArray<Object>, Object> function = (Function) pluginValueSetTt.objectValue(1, Function.class);
        if (function == null) {
            com.byazt.nr.m.ve("apply->load with null callback");
            return null;
        }
        loadAdByType(iIntValue, pluginValueSetTt, function);
        return null;
    }
}
