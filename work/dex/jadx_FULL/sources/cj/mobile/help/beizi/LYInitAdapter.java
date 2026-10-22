package cj.mobile.help.beizi;

import cj.mobile.listener.CJInitListener;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYInitAdapter extends AMPSChannelInitMediation {
    public static LYInitAdapter b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22216a;

    public class a implements CJInitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAMPSChannelInitCallBack f22217a;
        public final /* synthetic */ LYInitAdapter b;

        public a(LYInitAdapter lYInitAdapter, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initFailed(String str) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initSuccess() {
        }
    }

    public static synchronized LYInitAdapter getInstance() {
    }

    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
    }
}
