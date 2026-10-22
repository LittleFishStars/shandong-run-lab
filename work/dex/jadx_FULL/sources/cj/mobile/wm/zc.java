package cj.mobile.wm;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.listener.ITemplateInteractionListener;
import com.wangmai.insightvision.openadsdk.view.InsightAdView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class zc extends gc {
    public zc(Context context, AdSlot adSlot, INativeAd iNativeAd, ITemplateInteractionListener iTemplateInteractionListener) {
        super(context, adSlot, iNativeAd, iTemplateInteractionListener);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00ca  */
    private ad dexc(Context context) {
        ad hdVar;
        String strDexb = xc.dexb(this.dexc);
        if (!TextUtils.isEmpty(strDexb)) {
            strDexb.hashCode();
            switch (strDexb) {
                case "122803001":
                    hdVar = new hd(context, this.dexd, this.dexe, this.dexc);
                    break;
                case "122803002":
                    hdVar = new dd(context, this.dexd, this.dexe, this.dexc);
                    break;
                case "122803003":
                    hdVar = new ed(context, this.dexd, this.dexe, this.dexc);
                    break;
                case "122803004":
                    hdVar = new fd(context, this.dexd, this.dexe, this.dexc);
                    break;
                case "122803005":
                    hdVar = new gd(context, this.dexd, this.dexe, this.dexc);
                    break;
                case "122816001":
                    hdVar = new cd(context, this.dexd, this.dexe, this.dexc);
                    break;
                case "122817002":
                    hdVar = new bd(context, this.dexd, this.dexe, this.dexc);
                    break;
                default:
                    hdVar = null;
                    break;
            }
        } else {
            hdVar = null;
        }
        if (hdVar == null) {
            String strDexa = xc.dexa(this.dexc);
            if (MediationConstant.RIT_TYPE_INTERSTITIAL.equals(strDexa)) {
                return new cd(context, this.dexd, this.dexe, this.dexc);
            }
            if ("inner_flow".equals(strDexa)) {
                return new bd(context, this.dexd, this.dexe, this.dexc);
            }
        }
        f1.dexb(gc.dexh, "createFeedTemplate templateId: " + strDexb + ", template: " + hdVar);
        return hdVar;
    }

    @Override // cj.mobile.wm.gc
    public InsightAdView dexa(Context context) {
        com.wangmai.insightvision.openadsdk.template.rendering.feed.a aVar = new com.wangmai.insightvision.openadsdk.template.rendering.feed.a(this.dexa);
        aVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return aVar;
    }

    @Override // cj.mobile.wm.gc
    public com.wangmai.insightvision.openadsdk.o.a.a dexb(Context context) {
        return dexc(context);
    }
}
