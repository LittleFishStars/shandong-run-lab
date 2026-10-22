package cj.mobile.help.tobid;

import android.content.Context;
import cj.mobile.CJMobileAd;
import cj.mobile.listener.CJInitListener;
import com.windmill.sdk.custom.WMCustomAdapterProxy;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYInitAdapter extends WMCustomAdapterProxy {

    public class a implements CJInitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYInitAdapter f22244a;

        public a(LYInitAdapter lYInitAdapter) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initFailed(String str) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initSuccess() {
        }
    }

    public int baseOnToBidCustomAdapterVersion() {
        return 10391;
    }

    public String getNetworkSdkVersion() {
        return CJMobileAd.getSdkVersion();
    }

    public void initializeADN(Context context, Map<String, Object> map) {
    }

    public void notifyPrivacyStatusChange() {
    }
}
