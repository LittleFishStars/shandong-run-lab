package com.kc.openset;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Keep
public class VideoContentConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39587a;
    private final int b;
    private final boolean c;

    @Keep
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f39588a;
        private int b;
        private boolean c;

        static {
            OSETSDKProtected.interface11(3675);
        }

        public static native /* synthetic */ int a(Builder builder);

        public static native /* synthetic */ int b(Builder builder);

        public static native /* synthetic */ boolean c(Builder builder);

        public native VideoContentConfig build();

        public native Builder setNeedBack(boolean z);

        public native Builder setRewardCount(int i);

        public native Builder setRewardDownTime(int i);
    }

    @Keep
    public static /* synthetic */ class a {
    }

    static {
        OSETSDKProtected.interface11(3677);
    }

    private VideoContentConfig(Builder builder) {
    }

    public /* synthetic */ VideoContentConfig(Builder builder, a aVar) {
        this(builder);
    }

    public native int getRewardCount();

    public native int getRewardDownTime();

    public native boolean isNeedBack();
}
