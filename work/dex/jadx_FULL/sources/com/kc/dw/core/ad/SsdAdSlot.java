package com.kc.dw.core.ad;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdAdSlot {
    private boolean autoRender;
    private String channel;
    private boolean closeButtonVisible;
    private boolean enableInterstitialAutoClose;
    private int fetchCount;
    private int fixedHeight;
    private int height;
    private boolean hideSkipButton;
    private boolean isClickToClose;
    private boolean isMute;
    private boolean isSplashFullScreen;
    private boolean isVideoAutoPlay;
    private String pid;
    private int[] preRenderPaddings;
    private boolean showDetail;
    private boolean showFeedAdLogo;
    private boolean splashClickPause;
    private long splashShowTime;
    private int width;

    @Keep
    public static class Builder {
        private String channel;
        private int fixedHeight;
        private boolean hideSkipButton;
        private boolean isClickToClose;
        private boolean isSplashFullScreen;
        private boolean nativeFeedUseShake;
        private String pid;
        private int[] preRenderPaddings;
        private boolean showDetail;
        private int width = -1;
        private int height = -1;
        private boolean isVideoAutoPlay = true;
        private int fetchCount = 1;
        private boolean isMute = true;
        private boolean autoRender = true;
        private boolean closeButtonVisible = true;
        private long splashShowTime = 5000;
        private boolean splashClickPause = true;
        private boolean enableInterstitialAutoClose = true;
        private boolean showFeedAdLogo = false;

        public SsdAdSlot build() {
            return new SsdAdSlot(this);
        }

        public Builder setAutoRender(boolean z) {
            this.autoRender = z;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setCloseButtonVisible(boolean z) {
            this.closeButtonVisible = z;
            return this;
        }

        public Builder setEnableInterstitialAutoClose(boolean z) {
            this.enableInterstitialAutoClose = z;
            return this;
        }

        public Builder setFetchCount(int i) {
            this.fetchCount = i;
            return this;
        }

        public Builder setFixHeight(int i) {
            this.fixedHeight = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setIsClickToClose(boolean z) {
            this.isClickToClose = z;
            return this;
        }

        public Builder setIsHideSkipBtn(boolean z) {
            this.hideSkipButton = z;
            return this;
        }

        public Builder setIsVideoAutoPlay(boolean z) {
            this.isVideoAutoPlay = z;
            return this;
        }

        public Builder setIsshowDetail(boolean z) {
            this.showDetail = z;
            return this;
        }

        public Builder setNativeFeedUseShake(boolean z) {
            this.nativeFeedUseShake = z;
            return this;
        }

        public Builder setPid(String str) {
            this.pid = str;
            return this;
        }

        public Builder setSplashClickPause(boolean z) {
            this.splashClickPause = z;
            return this;
        }

        public Builder setSplashIsFullScreen(boolean z) {
            this.isSplashFullScreen = z;
            return this;
        }

        public Builder setSplashShowTime(long j) {
            if (j >= 3000) {
                this.splashShowTime = j;
            }
            return this;
        }

        public Builder setVideoMute(boolean z) {
            this.isMute = z;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder showFeedAdLogo(boolean z) {
            this.showFeedAdLogo = z;
            return this;
        }

        public Builder userPreRenderPaddings(int i, int i2, int i3, int i4) {
            if (this.preRenderPaddings == null) {
                this.preRenderPaddings = new int[4];
            }
            int[] iArr = this.preRenderPaddings;
            iArr[0] = i;
            iArr[1] = i2;
            iArr[2] = i3;
            iArr[3] = i4;
            return this;
        }
    }

    public SsdAdSlot(Builder builder) {
        this.width = -1;
        this.height = -1;
        this.isVideoAutoPlay = true;
        this.fetchCount = 1;
        this.isMute = true;
        this.autoRender = true;
        this.closeButtonVisible = true;
        this.splashShowTime = 5000L;
        this.splashClickPause = true;
        this.enableInterstitialAutoClose = true;
        this.pid = builder.pid;
        this.width = builder.width;
        this.height = builder.height;
        this.isClickToClose = builder.isClickToClose;
        this.showDetail = builder.showDetail;
        this.isVideoAutoPlay = builder.isVideoAutoPlay;
        this.fixedHeight = builder.fixedHeight;
        this.fetchCount = builder.fetchCount;
        this.isMute = builder.isMute;
        this.hideSkipButton = builder.hideSkipButton;
        this.isSplashFullScreen = builder.isSplashFullScreen;
        this.channel = builder.channel;
        this.autoRender = builder.autoRender;
        this.closeButtonVisible = builder.closeButtonVisible;
        this.splashClickPause = builder.splashClickPause;
        this.splashShowTime = builder.splashShowTime;
        this.enableInterstitialAutoClose = builder.enableInterstitialAutoClose;
        this.preRenderPaddings = builder.preRenderPaddings;
        this.showFeedAdLogo = builder.showFeedAdLogo;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getFetchCount() {
        return this.fetchCount;
    }

    public int getFixedHeight() {
        return this.fixedHeight;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getIsClickToClose() {
        return this.isClickToClose;
    }

    public boolean getIsHideSkipButton() {
        return this.hideSkipButton;
    }

    public boolean getIsMute() {
        return this.isMute;
    }

    public boolean getIsShowDetail() {
        return this.showDetail;
    }

    public boolean getIsVideoAutoPlay() {
        return this.isVideoAutoPlay;
    }

    public String getPid() {
        return this.pid;
    }

    public long getSplashShowTime() {
        return this.splashShowTime;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAutoRender() {
        return this.autoRender;
    }

    public boolean isCloseButtonVisible() {
        return this.closeButtonVisible;
    }

    public boolean isEnableInterstitialAutoClose() {
        return this.enableInterstitialAutoClose;
    }

    public boolean isSplashClickPause() {
        return this.splashClickPause;
    }

    public boolean isSplashFullScreen() {
        return this.isSplashFullScreen;
    }

    public boolean showFeedAdLogo() {
        return this.showFeedAdLogo;
    }

    public void userPreRenderPaddings(int i, int i2, int i3, int i4) {
        if (this.preRenderPaddings == null) {
            this.preRenderPaddings = new int[4];
        }
        int[] iArr = this.preRenderPaddings;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
    }

    public int[] userPreRenderPaddings() {
        return this.preRenderPaddings;
    }
}
