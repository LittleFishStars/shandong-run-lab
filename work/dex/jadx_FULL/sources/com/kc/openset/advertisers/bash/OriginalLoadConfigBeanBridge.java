package com.kc.openset.advertisers.bash;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.AdBridge;
import com.kc.openset.ad.base.bridge.BaseAdBridge;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.config.AdapterType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OriginalLoadConfigBeanBridge {
    private final AdapterType adapterType;
    private final String advertisers;
    private final Class<? extends BaseAdBridge> sdkAdapterClass;
    private final AdType subAdType;

    @Keep
    public static final class Builder {
        private AdapterType adapterType;
        private String advertisers;
        private Class<? extends BaseAdBridge> sdkAdapterClass;
        private AdType subAdType = AdType.AD_TYPE_NO;

        static {
            OSETSDKProtected.interface11(4249);
        }

        public static native /* synthetic */ Class access$000(Builder builder);

        public static native /* synthetic */ String access$100(Builder builder);

        public static native /* synthetic */ AdapterType access$200(Builder builder);

        public static native /* synthetic */ AdType access$300(Builder builder);

        public native OriginalLoadConfigBeanBridge build();

        public native Builder setAdapterType(AdapterType adapterType);

        public native Builder setAdvertisers(String str);

        public native Builder setSdkAdapterClass(Class<? extends BaseAdBridge> cls);

        public native Builder setSubAdType(AdType adType);
    }

    @Keep
    public static /* synthetic */ class a {
    }

    static {
        OSETSDKProtected.interface11(4251);
    }

    private OriginalLoadConfigBeanBridge(Builder builder) {
        this.sdkAdapterClass = Builder.access$000(builder);
        this.advertisers = Builder.access$100(builder);
        this.adapterType = Builder.access$200(builder);
        this.subAdType = Builder.access$300(builder);
    }

    public /* synthetic */ OriginalLoadConfigBeanBridge(Builder builder, a aVar) {
        this(builder);
    }

    public native AdapterType getAdapterType();

    public native String getAdvertisers();

    public native Class<? extends AdBridge> getSdkAdapterClass();

    public native AdType getSubAdType();
}
