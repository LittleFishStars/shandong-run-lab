package cn.jy.ad.sdk.jybn;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VideoOption {
    private boolean autoPlayMuted;
    private int autoPlayPolicy;
    private boolean detailPageMuted;
    private boolean enableDetailPage;
    private boolean enableUserControl;
    private boolean needCoverImage;
    private boolean needProgressBar;

    public interface AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoPolicy {
    }

    public static class Builder {
        private int autoPlayPolicy = 0;
        private boolean autoPlayMuted = true;
        private boolean detailPageMuted = true;
        private boolean needCoverImage = true;
        private boolean needProgressBar = true;
        private boolean enableDetailPage = true;
        private boolean enableUserControl = false;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.autoPlayMuted = z;
            return this;
        }

        public Builder setAutoPlayPolicy(int i) {
            this.autoPlayPolicy = i;
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.detailPageMuted = z;
            return this;
        }

        public Builder setEnableDetailPage(boolean z) {
            this.enableDetailPage = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.enableUserControl = z;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.needCoverImage = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.needProgressBar = z;
            return this;
        }
    }

    public VideoOption() {
        this.autoPlayPolicy = 0;
        this.autoPlayMuted = true;
        this.detailPageMuted = true;
        this.needCoverImage = true;
        this.needProgressBar = true;
        this.enableDetailPage = true;
        this.enableUserControl = false;
    }

    public VideoOption(Builder builder) {
        this.autoPlayPolicy = 0;
        this.autoPlayMuted = true;
        this.detailPageMuted = true;
        this.needCoverImage = true;
        this.needProgressBar = true;
        this.enableDetailPage = true;
        this.enableUserControl = false;
        this.autoPlayPolicy = builder.autoPlayPolicy;
        this.autoPlayMuted = builder.autoPlayMuted;
        this.detailPageMuted = builder.detailPageMuted;
        this.needCoverImage = builder.needCoverImage;
        this.needProgressBar = builder.needProgressBar;
        this.enableDetailPage = builder.enableDetailPage;
        this.enableUserControl = builder.enableUserControl;
    }

    @Deprecated
    public int getAutoPlayPolicy() {
        return this.autoPlayPolicy;
    }

    @Deprecated
    public boolean isAutoPlayMuted() {
        return this.autoPlayMuted;
    }

    @Deprecated
    public boolean isDetailPageMuted() {
        return this.detailPageMuted;
    }

    @Deprecated
    public boolean isEnableDetailPage() {
        return this.enableDetailPage;
    }

    @Deprecated
    public boolean isEnableUserControl() {
        return this.enableUserControl;
    }

    @Deprecated
    public boolean isNeedCoverImage() {
        return this.needCoverImage;
    }

    @Deprecated
    public boolean isNeedProgressBar() {
        return this.needProgressBar;
    }
}
