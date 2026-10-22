package com.kc.aw.lib.constants;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdConstant {

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface AD_SLOT_TYPE {
        public static final int AD_BANNER = 3;
        public static final int AD_FEED = 2;
        public static final int AD_INTERACTION = 4;
        public static final int AD_REWARD = 5;
        public static final int AD_SPLASH = 1;
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface AD_TYPE {
        public static final int IMAGE = 1;
        public static final int VIDEO = 2;
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface NATIVE_TYPE {
        public static final String LEFT_IMAGE = "304";
        public static final String LEFT_TEXT = "305";
        public static final String TEXT_FLOAT = "303";
        public static final String THREE_IMAGES = "306";
        public static final String TOP_IMAGE = "302";
        public static final String TOP_TEXT = "301";
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface NATIVE_USED_FOR {
        public static final int NORMAL = 0;
        public static final int SPLASH = 1;
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface SPLASH_AD_CLOSE_TYPE {
        public static final int CLICK_JUMP = 3;
        public static final int CLICK_SKIP = 1;
        public static final int COUNT_DOWN_OVER = 2;
    }
}
