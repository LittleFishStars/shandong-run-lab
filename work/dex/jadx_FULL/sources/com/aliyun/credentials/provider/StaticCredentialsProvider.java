package com.aliyun.credentials.provider;

import com.aliyun.credentials.models.CredentialModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StaticCredentialsProvider implements AlibabaCloudCredentialsProvider {
    private CredentialModel credential;

    public static final class Builder {
        private CredentialModel credential;

        public StaticCredentialsProvider build() {
            return new StaticCredentialsProvider(this);
        }

        public Builder credential(CredentialModel credentialModel) {
            this.credential = credentialModel;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider
    public CredentialModel getCredentials() {
        return this.credential;
    }

    private StaticCredentialsProvider(Builder builder) {
        this.credential = builder.credential;
    }
}
