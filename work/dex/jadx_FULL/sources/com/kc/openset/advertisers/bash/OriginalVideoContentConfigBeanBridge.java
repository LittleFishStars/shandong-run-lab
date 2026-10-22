package com.kc.openset.advertisers.bash;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.video.BaseVideoBridge;
import com.kc.openset.ad.config.AdapterType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OriginalVideoContentConfigBeanBridge {
    private final AdapterType adapterType;
    private final String advertisers;
    private final Class<? extends BaseVideoBridge> sdkAdapterClass;

    @Keep
    public static final class Builder {
        private AdapterType adapterType;
        private String advertisers;
        private Class<? extends BaseVideoBridge> sdkAdapterClass;

        static {
            OSETSDKProtected.interface11(4252);
        }

        public static native /* synthetic */ Class access$000(Builder builder);

        public static native /* synthetic */ String access$100(Builder builder);

        public static native /* synthetic */ AdapterType access$200(Builder builder);

        public native OriginalVideoContentConfigBeanBridge build();

        public native Builder setAdapterType(AdapterType adapterType);

        public native Builder setAdvertisers(String str);

        public native Builder setSdkAdapterClass(Class<? extends BaseVideoBridge> cls);
    }

    @Keep
    public static /* synthetic */ class a {
    }

    static {
        OSETSDKProtected.interface11(4254);
    }

    private OriginalVideoContentConfigBeanBridge(Builder builder) {
        this.sdkAdapterClass = Builder.access$000(builder);
        this.advertisers = Builder.access$100(builder);
        this.adapterType = Builder.access$200(builder);
    }

    public /* synthetic */ OriginalVideoContentConfigBeanBridge(Builder builder, a aVar) {
        this(builder);
    }

    public native AdapterType getAdapterType();

    public native String getAdvertisers();

    public native Class<? extends BaseVideoBridge> getSdkAdapterClass();
}
