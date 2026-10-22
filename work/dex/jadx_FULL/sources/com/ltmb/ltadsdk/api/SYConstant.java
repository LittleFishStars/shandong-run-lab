package com.ltmb.ltadsdk.api;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public interface SYConstant {

    public interface AdActionType {
        public static final int Deeplink = 1;
        public static final int Download = 2;
        public static final int LandingPage = 0;
        public static final int Wxapp = 3;
    }

    public interface AdTemplateType {
        public static final int GROUP_IMAGE = 5;
        public static final int IMAGE_LEFT_TEXT = 3;
        public static final int IMAGE_TOP_TEXT = 1;
        public static final int LARGE_IMG = 6;
        public static final int TEXT_LEFT_IMAGE = 4;
        public static final int TEXT_TOP_IMAGE = 2;
        public static final int VIDEO = 100;
    }

    public interface AdType {
        public static final int Banner = 3;
        public static final int FeedExpress = 1;
        public static final int Interstitial = 4;
        public static final int Native = 6;
        public static final int Reward = 5;
        public static final int Splash = 2;
    }

    public interface AdnType {
        public static final int Adn_Adx = 0;
        public static final int Adn_Ylh = 1;
    }

    public interface DownloadStatus {
        public static final int COMPLETED = 4;
        public static final int DOWNLOADING = 2;
        public static final int FAILED = 5;
        public static final int INSTALLED = 7;
        public static final int PAUSED = 3;
        public static final int PENDING = 1;
    }
}
