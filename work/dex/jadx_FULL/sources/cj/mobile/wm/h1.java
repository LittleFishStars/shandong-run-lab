package cj.mobile.wm;

import android.os.Handler;
import androidx.camera.video.AudioStats;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h1 {
    public static volatile h1 dexb;
    public final Handler dexa = new Handler();

    public static h1 dexa() {
        if (dexb == null) {
            synchronized (h1.class) {
                if (dexb == null) {
                    dexb = new h1();
                }
            }
        }
        return dexb;
    }

    private String dexa(double d) {
        try {
            return URLEncoder.encode(ae.dexb(d + "", "ykaduscNO7X8D5Ny"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa(com.wangmai.insightvision.openadsdk.common.f fVar, hc hcVar) {
        dexa(fVar.j(), hcVar);
    }

    private void dexa(List<String> list, hc hcVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            u9 u9Var = new u9();
            q9 q9Var = new q9();
            u9Var.dexb(str.replaceAll("\\$\\{AUCTION_PRICE\\}", dexa(AudioStats.AUDIO_AMPLITUDE_NONE)).replaceAll("__DOWN_X__", String.valueOf(hcVar.dexb)).replaceAll("__DOWN_Y__", String.valueOf(hcVar.dexc)).replaceAll("__UP_X__", String.valueOf(hcVar.dexd)).replaceAll("__UP_Y__", String.valueOf(hcVar.dexe)));
            InsightProxy.getInstance().getNetworkProxy().dexa(u9Var.dexa(q9Var), null);
        }
    }

    private void dexc(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            u9 u9Var = new u9();
            q9 q9Var = new q9();
            u9Var.dexb(str.replaceAll("\\$\\{AUCTION_PRICE\\}", dexa(AudioStats.AUDIO_AMPLITUDE_NONE)));
            InsightProxy.getInstance().getNetworkProxy().dexa(u9Var.dexa(q9Var), null);
        }
    }

    public void dexa(int i, INativeAd iNativeAd) {
        if (iNativeAd instanceof com.wangmai.insightvision.openadsdk.common.f) {
            List<dexz> listU = ((com.wangmai.insightvision.openadsdk.common.f) iNativeAd).u();
            ArrayList arrayList = new ArrayList();
            if (listU != null) {
                for (dexz dexzVar : listU) {
                    if (i == dexzVar.a()) {
                        String url = dexzVar.getUrl();
                        arrayList.add(url);
                        f1.dexa("ExposeManager", "reportPlayEvent ... pos = " + i + " , url = " + url);
                    }
                }
            }
            dexc(arrayList);
        }
    }

    public void dexa(INativeAd iNativeAd) {
        if (iNativeAd instanceof com.wangmai.insightvision.openadsdk.common.f) {
            dexa((com.wangmai.insightvision.openadsdk.common.f) iNativeAd, "on_click_callback");
        }
    }

    public void dexa(INativeAd iNativeAd, double d) {
        if (iNativeAd instanceof com.wangmai.insightvision.openadsdk.common.f) {
            f1.dexa("ExposeManager", "reportWinEvent ... winPrice = " + d);
            List listB = ((com.wangmai.insightvision.openadsdk.common.f) iNativeAd).B();
            ArrayList arrayList = new ArrayList();
            if (listB != null && !listB.isEmpty()) {
                Iterator it = listB.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).replaceAll("__MTYPE__", "win").replaceAll("\\$\\{AUCTION_PRICE\\}", dexa(d)));
                }
            }
            dexc(arrayList);
        }
    }

    public void dexa(INativeAd iNativeAd, final hc hcVar) {
        int i;
        if (iNativeAd instanceof com.wangmai.insightvision.openadsdk.common.f) {
            f1.dexa("ExposeManager", "reportClickEvent ... ");
            final com.wangmai.insightvision.openadsdk.common.f fVar = (com.wangmai.insightvision.openadsdk.common.f) iNativeAd;
            if (fVar.D()) {
                i = 50;
            } else {
                dexd(iNativeAd);
                i = 1500;
            }
            this.dexa.postDelayed(new Runnable() { // from class: com.zj.adlib.d8b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41127a.dexa(fVar, hcVar);
                }
            }, i);
        }
    }

    public void dexa(INativeAd iNativeAd, String str, double d) {
        if (iNativeAd instanceof com.wangmai.insightvision.openadsdk.common.f) {
            f1.dexa("ExposeManager", "reportLossEvent ... ");
            List listT = ((com.wangmai.insightvision.openadsdk.common.f) iNativeAd).t();
            ArrayList arrayList = new ArrayList();
            if (listT != null && !listT.isEmpty()) {
                Iterator it = listT.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).replaceAll("__MTYPE__", "loss").replaceAll("__LOSSREASON__", str).replaceAll("\\$\\{AUCTION_PRICE\\}", dexa(d)));
                }
            }
            dexc(arrayList);
        }
    }

    public void dexa(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "destroy_ad");
    }

    public void dexa(com.wangmai.insightvision.openadsdk.common.f fVar, String str) {
        try {
            List listK = fVar.k();
            ArrayList arrayList = new ArrayList();
            if (listK != null && !listK.isEmpty()) {
                Iterator it = listK.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).replaceAll("__MTYPE__", str));
                }
            }
            f1.dexa("ExposeManager", "reportCustomEvent ... " + str + " , size : " + arrayList.size());
            dexc(arrayList);
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    public void dexa(com.wangmai.insightvision.openadsdk.common.f fVar, boolean z) {
        f1.dexa("ExposeManager", "reportDeepLinkAppEvent ... hasApp = " + z);
        dexa(fVar, z ? "deeplink_has_app" : "deeplink_no_app");
    }

    public void dexa(List<String> list) {
        f1.dexa("ExposeManager", "reportDownloadFinishEvent ...");
        dexc(list);
    }

    public void dexa(boolean z, String str, AdSlot adSlot, INativeAd iNativeAd) {
        j1.dexa().dexa(z, str, adSlot, iNativeAd);
    }

    public void dexb(INativeAd iNativeAd) {
        if (iNativeAd instanceof com.wangmai.insightvision.openadsdk.common.f) {
            dexa((com.wangmai.insightvision.openadsdk.common.f) iNativeAd, "close");
        }
    }

    public void dexb(com.wangmai.insightvision.openadsdk.common.f fVar) {
        f1.dexa("ExposeManager", "reportH5PageEvent ...");
        dexa(fVar, "web_success");
    }

    public void dexb(List<String> list) {
        f1.dexa("ExposeManager", "reportDownloadStartEvent ...");
        dexc(list);
    }

    public void dexc(INativeAd iNativeAd) {
        if (iNativeAd instanceof com.wangmai.insightvision.openadsdk.common.f) {
            f1.dexa("ExposeManager", "reportDpSuccessEvent ... ");
            dexc(((com.wangmai.insightvision.openadsdk.common.f) iNativeAd).o());
        }
    }

    public void dexc(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "load_success");
    }

    public void dexd(INativeAd iNativeAd) {
        if (iNativeAd instanceof com.wangmai.insightvision.openadsdk.common.f) {
            f1.dexa("ExposeManager", "reportExposeEvent ... ");
            com.wangmai.insightvision.openadsdk.common.f fVar = (com.wangmai.insightvision.openadsdk.common.f) iNativeAd;
            boolean zD = fVar.D();
            if (dex03.dexe(fVar) || !zD) {
                fVar.c(true);
                dexc(fVar.q());
            }
        }
    }

    public void dexd(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "play_end");
    }

    public void dexe(INativeAd iNativeAd) {
        if (iNativeAd instanceof com.wangmai.insightvision.openadsdk.common.f) {
            dexa((com.wangmai.insightvision.openadsdk.common.f) iNativeAd, FreeSpaceBox.TYPE);
        }
    }

    public void dexe(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "play_start");
    }

    public void dexf(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "register_view_for_interaction");
    }

    public void dexg(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "render_failed");
    }

    public void dexh(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "render_success");
    }

    public void dexi(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "reward_failed");
    }

    public void dexj(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "reward_success");
    }

    public void dexk(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "show_ad");
    }

    public void dexl(com.wangmai.insightvision.openadsdk.common.f fVar) {
        dexa(fVar, "start_render");
    }
}
