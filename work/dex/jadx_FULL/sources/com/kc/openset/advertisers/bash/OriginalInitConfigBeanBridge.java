package com.kc.openset.advertisers.bash;

import android.text.TextUtils;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OriginalInitConfigBeanBridge {
    private final String LogName;
    private final String adapterVersion;
    private final String advertisers;
    private final String advertisersName;
    private final List<String> checkPackageList;
    private final String miniSupportVersion;
    private final boolean preInit;
    private final Class<? extends BaseConfig> sdkConfigClass;

    @Keep
    public static final class Builder {
        private String LogName;
        private String adapterVersion;
        private String advertisers;
        private String advertisersName;
        private List<String> checkPackageList;
        private String miniSupportVersion;
        private boolean preInit;
        private Class<? extends BaseConfig> sdkConfigClass;

        static {
            OSETSDKProtected.interface11(4246);
        }

        public static native /* synthetic */ Class access$000(Builder builder);

        public static native /* synthetic */ String access$100(Builder builder);

        public static native /* synthetic */ String access$200(Builder builder);

        public static native /* synthetic */ List access$300(Builder builder);

        public static native /* synthetic */ String access$400(Builder builder);

        public static native /* synthetic */ boolean access$500(Builder builder);

        public static native /* synthetic */ String access$600(Builder builder);

        public static native /* synthetic */ String access$700(Builder builder);

        public native OriginalInitConfigBeanBridge build();

        public native Builder setAdapterVersion(String str);

        public native Builder setAdvertisers(String str);

        public native Builder setAdvertisersName(String str);

        public native Builder setCheckPackageList(String... strArr);

        public native Builder setLogName(String str);

        public native Builder setMiniSupportVersion(String str);

        public native Builder setPreInit(boolean z);

        public native Builder setSdkConfigClass(Class<? extends BaseConfig> cls);
    }

    @Keep
    public static /* synthetic */ class a {
    }

    static {
        OSETSDKProtected.interface11(4248);
    }

    private OriginalInitConfigBeanBridge(Builder builder) {
        this.sdkConfigClass = Builder.access$000(builder);
        this.advertisers = Builder.access$100(builder);
        this.advertisersName = Builder.access$200(builder);
        this.checkPackageList = Builder.access$300(builder);
        this.miniSupportVersion = Builder.access$400(builder);
        this.preInit = Builder.access$500(builder);
        this.adapterVersion = Builder.access$600(builder);
        this.LogName = TextUtils.isEmpty(Builder.access$700(builder)) ? Builder.access$100(builder) : Builder.access$700(builder);
    }

    public /* synthetic */ OriginalInitConfigBeanBridge(Builder builder, a aVar) {
        this(builder);
    }

    public native String getAdapterVersion();

    public native String getAdvertisers();

    public native String getAdvertisersName();

    public native List<String> getCheckPackageList();

    public native String getLogName();

    public native String getMiniSupportVersion();

    public native Class<? extends BaseConfig> getSdkConfigClass();

    public native boolean isPreInit();

    public native String toString();
}
