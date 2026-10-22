package com.alibaba.sdk.android.vod.upload.session;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VodHttpClientConfig {
    private int connectionTimeout;
    private int maxRetryCount;
    private int socketTimeout;

    public static class Builder {
        int _MaxRetryCount = Integer.MAX_VALUE;
        int _ConnectionTimeout = 15000;
        int _SocketTimeout = 15000;

        public VodHttpClientConfig build() {
            return new VodHttpClientConfig(this);
        }

        public Builder setConnectionTimeout(int i) {
            this._ConnectionTimeout = i;
            return this;
        }

        public Builder setMaxRetryCount(int i) {
            if (i > 0) {
                this._MaxRetryCount = i;
                return this;
            }
            this._MaxRetryCount = 2;
            return this;
        }

        public Builder setSocketTimeout(int i) {
            this._SocketTimeout = i;
            return this;
        }
    }

    public VodHttpClientConfig(Builder builder) {
        this.maxRetryCount = Integer.MAX_VALUE;
        this.connectionTimeout = 15000;
        this.socketTimeout = 15000;
        this.maxRetryCount = builder._MaxRetryCount;
        this.connectionTimeout = builder._ConnectionTimeout;
        this.socketTimeout = builder._SocketTimeout;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getMaxRetryCount() {
        return this.maxRetryCount;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }
}
