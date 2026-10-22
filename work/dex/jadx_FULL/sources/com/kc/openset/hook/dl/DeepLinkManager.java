package com.kc.openset.hook.dl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class DeepLinkManager {
    private static final int PRE_TIMEOUT = 300000;
    private static final String TAG = OSETSDKProtected.getString2(1783);
    private static final int TIMEOUT = 300000;
    private static final int WHAT_REQUEST = 101;
    private static volatile DeepLinkManager instance;
    private static final Handler sHandler;
    boolean instrumentationIsHooked = false;
    private List<a.C1109a> mData;

    /* JADX INFO: renamed from: com.kc.openset.hook.dl.DeepLinkManager$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements DeepLinkHttpUtils.ICallBack {
        final DeepLinkManager this$0;

        static {
            OSETSDKProtected.interface11(4454);
        }

        public AnonymousClass2(DeepLinkManager deepLinkManager) {
            this.this$0 = deepLinkManager;
        }

        @Override // com.kc.openset.hook.dl.DeepLinkHttpUtils.ICallBack
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.hook.dl.DeepLinkHttpUtils.ICallBack
        public native void onSuccess(a aVar);
    }

    static {
        OSETSDKProtected.interface11(4455);
        sHandler = new Handler(Looper.getMainLooper()) { // from class: com.kc.openset.hook.dl.DeepLinkManager.1
            static {
                OSETSDKProtected.interface11(4453);
            }

            @Override // android.os.Handler
            public native void handleMessage(Message message);
        };
    }

    private DeepLinkManager() {
    }

    public static native /* synthetic */ void access$000(DeepLinkManager deepLinkManager);

    public static native /* synthetic */ Handler access$100();

    public static native /* synthetic */ void access$200(DeepLinkManager deepLinkManager, a aVar);

    public static native DeepLinkManager getInstance();

    private native void requestData();

    private native void start(a aVar);

    public native void cleanData();

    public native List<a.C1109a> getData();

    public native void hookInstrumentation();

    public native void init();
}
