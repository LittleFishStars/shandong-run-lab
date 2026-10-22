package cj.mobile.help.gromore;

import android.content.Context;
import cj.mobile.CJMobileAd;
import cj.mobile.listener.CJInitListener;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYInitLoader extends MediationCustomInitLoader {

    public class a implements CJInitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYInitLoader f22231a;

        public a(LYInitLoader lYInitLoader) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initFailed(String str) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initSuccess() {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public String getNetworkSdkVersion() {
        return CJMobileAd.getSdkVersion();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public void initializeADN(Context context, MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map) {
    }
}
