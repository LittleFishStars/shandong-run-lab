package cj.mobile.wm;

import android.text.TextUtils;
import android.util.Log;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.IAdLoader;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e1 {
    public static final String dexa = "NativeDataLoader";

    public class dexa implements m9 {
        public final /* synthetic */ IAdLoader.OnNativeAdLoadListener dexa;

        public dexa(IAdLoader.OnNativeAdLoadListener onNativeAdLoadListener) {
            this.dexa = onNativeAdLoadListener;
        }

        @Override // cj.mobile.wm.m9
        public void a(int i, String str) {
            IAdLoader.OnNativeAdLoadListener onNativeAdLoadListener = this.dexa;
            if (onNativeAdLoadListener != null) {
                onNativeAdLoadListener.onAdLoadErr(i, str);
            }
        }

        @Override // cj.mobile.wm.m9
        public void dexa(Object obj, Object obj2, String str) {
            e1.this.dexa(this.dexa, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(IAdLoader.OnNativeAdLoadListener onNativeAdLoadListener, String str) {
        com.wangmai.insightvision.openadsdk.common.f fVarDexa = dex02.dexa(str, 1);
        if (onNativeAdLoadListener != null) {
            if (fVarDexa != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(fVarDexa);
                onNativeAdLoadListener.onAdLoaded(arrayList);
                return;
            }
            String strC = "";
            int i = -1;
            try {
                com.wangmai.insightvision.openadsdk.d.e eVarB = dex04.b(str);
                if (eVarB != null) {
                    if (eVarB.containsKey("msg_code")) {
                        try {
                            i = Integer.parseInt(eVarB.c("msg_code"));
                        } catch (Exception unused) {
                        }
                    }
                    if (eVarB.containsKey("msg")) {
                        strC = eVarB.c("msg");
                    }
                }
            } catch (Exception unused2) {
            }
            onNativeAdLoadListener.onAdLoadErr(i, strC);
        }
    }

    public void dexa(AdSlot adSlot, IAdLoader.OnNativeAdLoadListener onNativeAdLoadListener) {
        f1.dexa(dexa, "requestData: slot = " + adSlot);
        if (adSlot == null) {
            Log.e(dexa, "adSlot is null!");
            onNativeAdLoadListener.onAdLoadErr(1020003, "adSlot is null");
            return;
        }
        Map extMap = adSlot.getExtMap();
        if (extMap != null && extMap.containsKey("mock_data")) {
            String str = (String) extMap.get("mock_data");
            if (!TextUtils.isEmpty(str)) {
                dexa(onNativeAdLoadListener, str);
                return;
            }
        }
        if (TextUtils.isEmpty(g1.dexc().dexb().getAppId())) {
            Log.e(dexa, "appId is null!");
            onNativeAdLoadListener.onAdLoadErr(1020003, "appId is null");
        } else if (TextUtils.isEmpty(adSlot.getSlotId())) {
            Log.e(dexa, "slotId is null!");
            onNativeAdLoadListener.onAdLoadErr(1020003, "slotId is null");
        } else if (!TextUtils.isEmpty(tc.dexa(g1.dexc().dexa()))) {
            p9.dexa().dexa(adSlot, new dexa(onNativeAdLoadListener));
        } else {
            Log.e(dexa, "utdid is null!");
            onNativeAdLoadListener.onAdLoadErr(1020003, "utdid is null");
        }
    }
}
