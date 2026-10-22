package cj.mobile.help.gromore;

import android.app.Activity;
import android.content.Context;
import cj.mobile.CJRewardVideo;
import cj.mobile.listener.CJInitListener;
import cj.mobile.listener.CJRewardListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYRewardLoader extends MediationCustomRewardVideoLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJRewardVideo f22237a;

    public class a implements CJInitListener {
        public a(LYRewardLoader lYRewardLoader) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initFailed(String str) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initSuccess() {
        }
    }

    public class b implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdSlot f22238a;
        public final /* synthetic */ LYRewardLoader b;

        public class a implements MediationRewardItem {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ float f22239a;
            public final /* synthetic */ String b;

            public a(b bVar, float f, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
            public float getAmount() {
                return this.f22239a;
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
            public Map<String, Object> getCustomData() {
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
            public String getRewardName() {
                return this.b;
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
            public boolean rewardVerify() {
                return true;
            }
        }

        public b(LYRewardLoader lYRewardLoader, AdSlot adSlot) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onReward(String str) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onShow() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoEnd() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoStart() {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader
    public void showAd(Activity activity) {
    }
}
