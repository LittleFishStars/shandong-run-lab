package cj.mobile.help.gromore;

import android.content.Context;
import android.view.View;
import cj.mobile.CJNativeExpress;
import cj.mobile.listener.CJInitListener;
import cj.mobile.listener.CJNativeExpressListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYNativeExpressLoader extends MediationCustomNativeLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CJNativeExpress f22235a;
    public LYNativeAd b;

    public class a implements CJInitListener {
        public a(LYNativeExpressLoader lYNativeExpressLoader) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initFailed(String str) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initSuccess() {
        }
    }

    public class b implements CJNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYNativeExpressLoader f22236a;

        public b(LYNativeExpressLoader lYNativeExpressLoader) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void loadSuccess(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClick(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClose(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onShow(View view) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
    }
}
