package cn.jy.ad.sdk.jycfg;

import com.ali.auth.third.login.LoginConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdCode {
    private int adCount;
    private String codeId;
    private float expressViewAcceptedHeight;
    private float expressViewAcceptedWidth;
    private int imgAcceptedHeight;
    private int imgAcceptedWidth;
    private int orientation;
    private boolean isMute = true;
    private int refreshDuration = 0;
    private int timeOut = 0;
    private final HashMap<String, Object> extMap = new HashMap<>();

    public static class Builder {
        private int adCount;
        private String codeId;
        private float expressViewAcceptedHeight;
        private float expressViewAcceptedWidth;
        private String ext;
        private int imgAcceptedHeight;
        private int imgAcceptedWidth;
        private int orientation;
        private String userId;
        private boolean isMute = true;
        private int refreshDuration = 0;
        private int timeOut = 0;

        public AdCode build() {
            AdCode adCode = new AdCode();
            adCode.codeId = this.codeId;
            adCode.adCount = this.adCount;
            adCode.orientation = this.orientation;
            adCode.imgAcceptedWidth = this.imgAcceptedWidth;
            adCode.imgAcceptedHeight = this.imgAcceptedHeight;
            adCode.expressViewAcceptedWidth = this.expressViewAcceptedWidth;
            adCode.expressViewAcceptedHeight = this.expressViewAcceptedHeight;
            adCode.isMute = this.isMute;
            adCode.extMap.put("userId", this.userId);
            adCode.extMap.put(LoginConstants.EXT, this.ext);
            adCode.refreshDuration = this.refreshDuration;
            adCode.timeOut = this.timeOut;
            return adCode;
        }

        public Builder setAdCount(int i) {
            this.adCount = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.codeId = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.expressViewAcceptedWidth = f;
            this.expressViewAcceptedHeight = f2;
            return this;
        }

        public Builder setExt(String str) {
            this.ext = str;
            return this;
        }

        public Builder setImgAcceptedSize(int i, int i2) {
            this.imgAcceptedWidth = i;
            this.imgAcceptedHeight = i2;
            return this;
        }

        @Deprecated
        public Builder setMute(boolean z) {
            this.isMute = z;
            return this;
        }

        public Builder setOrientation(int i) {
            this.orientation = i;
            return this;
        }

        @Deprecated
        public Builder setRefreshDuration(int i) {
            this.refreshDuration = i;
            return this;
        }

        public Builder setTimeOut(int i) {
            this.timeOut = i;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }
    }

    public interface Orientation {
        public static final int HORIZONTAL = 2;
        public static final int VERTICAL = 1;
    }

    public int getAdCount() {
        return this.adCount;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public float getExpressViewAcceptedHeight() {
        return this.expressViewAcceptedHeight;
    }

    public float getExpressViewAcceptedWidth() {
        return this.expressViewAcceptedWidth;
    }

    public HashMap<String, Object> getExtraMap() {
        return this.extMap;
    }

    public int getImgAcceptedHeight() {
        return this.imgAcceptedHeight;
    }

    public int getImgAcceptedWidth() {
        return this.imgAcceptedWidth;
    }

    public boolean getMute() {
        return this.isMute;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getRefreshDuration() {
        return this.refreshDuration;
    }

    public int getTimeOut() {
        return this.timeOut;
    }
}
