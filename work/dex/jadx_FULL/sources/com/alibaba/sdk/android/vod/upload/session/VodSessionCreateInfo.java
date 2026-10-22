package com.alibaba.sdk.android.vod.upload.session;

import com.alibaba.sdk.android.vod.upload.model.SvideoInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VodSessionCreateInfo {
    private final String accessKeyId;
    private final String accessKeySecret;
    private final String appId;
    private final String expriedTime;
    private final String imagePath;
    private final boolean isTranscode;
    private final long partSize;
    private final String requestID;
    private final String securityToken;
    private final String storageLocation;
    private final SvideoInfo svideoInfo;
    private final String templateGroupId;
    private final String videoPath;
    private final VodHttpClientConfig vodHttpClientConfig;
    private final String workFlowId;

    public static final class Builder {
        private String _AccessKeyId;
        private String _AccessKeySecret;
        private String _ExpriedTime;
        private String _ImagePath;
        private boolean _IsTranscode;
        private long _PartSize;
        private String _RequestID;
        private String _SecurityToken;
        private SvideoInfo _SvideoInfo;
        private String _TemplateGroupId;
        private String _VideoPath;
        VodHttpClientConfig _VodHttpClientConfig = new VodHttpClientConfig.Builder().build();
        private String _appId;
        private String _storageLocation;
        private String _workFlowId;

        public VodSessionCreateInfo build() {
            return new VodSessionCreateInfo(this);
        }

        public Builder setAccessKeyId(String str) {
            this._AccessKeyId = str;
            return this;
        }

        public Builder setAccessKeySecret(String str) {
            this._AccessKeySecret = str;
            return this;
        }

        public Builder setAppId(String str) {
            this._appId = str;
            return this;
        }

        public Builder setExpriedTime(String str) {
            this._ExpriedTime = str;
            return this;
        }

        public Builder setImagePath(String str) {
            this._ImagePath = str;
            return this;
        }

        public Builder setIsTranscode(Boolean bool) {
            this._IsTranscode = bool.booleanValue();
            return this;
        }

        public Builder setPartSize(long j) {
            this._PartSize = j;
            return this;
        }

        public Builder setRequestID(String str) {
            this._RequestID = str;
            return this;
        }

        public Builder setSecurityToken(String str) {
            this._SecurityToken = str;
            return this;
        }

        public Builder setStorageLocation(String str) {
            this._storageLocation = str;
            return this;
        }

        public Builder setSvideoInfo(SvideoInfo svideoInfo) {
            this._SvideoInfo = svideoInfo;
            return this;
        }

        public Builder setTemplateGroupId(String str) {
            this._TemplateGroupId = str;
            return this;
        }

        public Builder setVideoPath(String str) {
            this._VideoPath = str;
            return this;
        }

        public Builder setVodHttpClientConfig(VodHttpClientConfig vodHttpClientConfig) {
            this._VodHttpClientConfig = vodHttpClientConfig;
            return this;
        }

        public Builder setWorkFlowId(String str) {
            this._workFlowId = str;
            return this;
        }
    }

    public VodSessionCreateInfo(Builder builder) {
        this.videoPath = builder._VideoPath;
        this.imagePath = builder._ImagePath;
        this.accessKeyId = builder._AccessKeyId;
        this.accessKeySecret = builder._AccessKeySecret;
        this.securityToken = builder._SecurityToken;
        this.expriedTime = builder._ExpriedTime;
        this.requestID = builder._RequestID;
        this.svideoInfo = builder._SvideoInfo;
        this.isTranscode = builder._IsTranscode;
        this.partSize = builder._PartSize;
        this.vodHttpClientConfig = builder._VodHttpClientConfig;
        this.templateGroupId = builder._TemplateGroupId;
        this.storageLocation = builder._storageLocation;
        this.appId = builder._appId;
        this.workFlowId = builder._workFlowId;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getExpriedTime() {
        return this.expriedTime;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public String getRequestID() {
        return this.requestID;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public String getStorageLocation() {
        return this.storageLocation;
    }

    public SvideoInfo getSvideoInfo() {
        return this.svideoInfo;
    }

    public String getTemplateGroupId() {
        return this.templateGroupId;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public VodHttpClientConfig getVodHttpClientConfig() {
        return this.vodHttpClientConfig;
    }

    public String getWorkFlowId() {
        return this.workFlowId;
    }

    public boolean isTranscode() {
        return this.isTranscode;
    }
}
