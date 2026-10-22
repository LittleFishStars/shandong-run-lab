package com.aliyun.credentials.models;

import com.aliyun.credentials.AlibabaCloudCredentials;
import com.aliyun.tea.TeaModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CredentialModel extends TeaModel implements AlibabaCloudCredentials {
    public String accessKeyId;
    public String accessKeySecret;
    public String bearerToken;
    public long expiration;
    public String securityToken;
    public String type;

    public static final class Builder {
        private String accessKeyId;
        private String accessKeySecret;
        private String bearerToken;
        private long expiration;
        private String securityToken;
        private String type;

        public Builder accessKeyId(String str) {
            this.accessKeyId = str;
            return this;
        }

        public Builder accessKeySecret(String str) {
            this.accessKeySecret = str;
            return this;
        }

        public Builder bearerToken(String str) {
            this.bearerToken = str;
            return this;
        }

        public CredentialModel build() {
            return new CredentialModel(this);
        }

        public Builder expiration(long j) {
            this.expiration = j;
            return this;
        }

        public Builder securityToken(String str) {
            this.securityToken = str;
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getBearerToken() {
        return this.bearerToken;
    }

    public long getExpiration() {
        return this.expiration;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getSecurityToken() {
        return this.securityToken;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getType() {
        return this.type;
    }

    public CredentialModel setAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public CredentialModel setAccessKeySecret(String str) {
        this.accessKeySecret = str;
        return this;
    }

    public CredentialModel setBearerToken(String str) {
        this.bearerToken = str;
        return this;
    }

    public CredentialModel setSecurityToken(String str) {
        this.securityToken = str;
        return this;
    }

    public CredentialModel setType(String str) {
        this.type = str;
        return this;
    }

    private CredentialModel(Builder builder) {
        this.accessKeyId = builder.accessKeyId;
        this.accessKeySecret = builder.accessKeySecret;
        this.securityToken = builder.securityToken;
        this.bearerToken = builder.bearerToken;
        this.type = builder.type;
        this.expiration = builder.expiration;
    }
}
