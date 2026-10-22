package com.kc.openset.ad;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class NativeViewConfig {
    private final int actBtnId;
    private final int adIconId;
    private final int adMediaId;
    private final int adSourceId;
    private final int adSourceImgId;
    private final int appAuthorNameId;
    private final int appFunctionId;
    private final int appNameId;
    private final int appPermissionId;
    private final int appPrivacyId;
    private final int appVersionId;
    private final int closeImgId;
    private final int contentId;
    private final int layoutId;
    private final int titleId;

    @Keep
    public static class Builder {
        private int actBtnId;
        private int adIconId;
        private int adSourceId;
        private int adSourceImgId;
        private int adVideoId;
        private int appAuthorNameId;
        private int appFunctionId;
        private int appNameId;
        private int appPermissionId;
        private int appPrivacyId;
        private int appVersionId;
        private int closeImgId;
        private int contentId;
        private int layoutId;
        private int titleId;

        static {
            OSETSDKProtected.interface11(3714);
        }

        public static native /* synthetic */ int access$000(Builder builder);

        public static native /* synthetic */ int access$100(Builder builder);

        public static native /* synthetic */ int access$1000(Builder builder);

        public static native /* synthetic */ int access$1100(Builder builder);

        public static native /* synthetic */ int access$1200(Builder builder);

        public static native /* synthetic */ int access$1300(Builder builder);

        public static native /* synthetic */ int access$1400(Builder builder);

        public static native /* synthetic */ int access$200(Builder builder);

        public static native /* synthetic */ int access$300(Builder builder);

        public static native /* synthetic */ int access$400(Builder builder);

        public static native /* synthetic */ int access$500(Builder builder);

        public static native /* synthetic */ int access$600(Builder builder);

        public static native /* synthetic */ int access$700(Builder builder);

        public static native /* synthetic */ int access$800(Builder builder);

        public static native /* synthetic */ int access$900(Builder builder);

        public native NativeViewConfig builder();

        public native Builder setActBtnId(int i);

        public native Builder setAdIconId(int i);

        public native Builder setAdMediaId(int i);

        public native Builder setAdSourceId(int i);

        public native Builder setAdSourceImgId(int i);

        public native Builder setAppAuthorNameId(int i);

        public native Builder setAppFunctionId(int i);

        public native Builder setAppNameId(int i);

        public native Builder setAppPermissionId(int i);

        public native Builder setAppPrivacyId(int i);

        public native Builder setAppVersionId(int i);

        public native Builder setCloseImgId(int i);

        public native Builder setContentId(int i);

        public native Builder setLayoutId(int i);

        public native Builder setTitleId(int i);
    }

    @Keep
    public static /* synthetic */ class a {
    }

    static {
        OSETSDKProtected.interface11(3716);
    }

    private NativeViewConfig(Builder builder) {
        this.layoutId = Builder.access$000(builder);
        this.titleId = Builder.access$100(builder);
        this.contentId = Builder.access$200(builder);
        this.actBtnId = Builder.access$300(builder);
        this.closeImgId = Builder.access$400(builder);
        this.adSourceImgId = Builder.access$500(builder);
        this.adSourceId = Builder.access$600(builder);
        this.adIconId = Builder.access$700(builder);
        this.adMediaId = Builder.access$800(builder);
        this.appNameId = Builder.access$900(builder);
        this.appAuthorNameId = Builder.access$1000(builder);
        this.appVersionId = Builder.access$1100(builder);
        this.appPermissionId = Builder.access$1200(builder);
        this.appPrivacyId = Builder.access$1300(builder);
        this.appFunctionId = Builder.access$1400(builder);
    }

    public /* synthetic */ NativeViewConfig(Builder builder, a aVar) {
        this(builder);
    }

    public native int getActBtnId();

    public native int getAdIconId();

    public native int getAdMediaId();

    public native int getAdSourceId();

    public native int getAdSourceImgId();

    public native int getAppAuthorNameId();

    public native int getAppFunctionId();

    public native int getAppNameId();

    public native int getAppPermissionId();

    public native int getAppPrivacyId();

    public native int getAppVersionId();

    public native int getCloseImgId();

    public native int getContentId();

    public native int getLayoutId();

    public native int getTitleId();
}
