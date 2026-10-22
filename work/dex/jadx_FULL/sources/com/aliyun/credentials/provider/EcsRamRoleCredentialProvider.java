package com.aliyun.credentials.provider;

import com.aliyun.credentials.Configuration;
import com.aliyun.credentials.http.CompatibleUrlConnClient;
import com.aliyun.credentials.models.Config;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.StringUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EcsRamRoleCredentialProvider extends SessionCredentialsProvider {
    private ECSMetadataServiceCredentialsFetcher fetcher;

    public interface Builder extends SessionCredentialsProvider.Builder<EcsRamRoleCredentialProvider, Builder> {
        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        EcsRamRoleCredentialProvider build();

        Builder connectionTimeout(int i);

        Builder readTimeout(int i);

        Builder roleName(String str);
    }

    public static final class BuilderImpl extends SessionCredentialsProvider.BuilderImpl<EcsRamRoleCredentialProvider, Builder> implements Builder {
        private int connectionTimeout;
        private int readTimeout;
        private String roleName;

        private BuilderImpl() {
            this.connectionTimeout = 1000;
            this.readTimeout = 1000;
        }

        @Override // com.aliyun.credentials.provider.EcsRamRoleCredentialProvider.Builder
        public Builder connectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.EcsRamRoleCredentialProvider.Builder
        public Builder readTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.EcsRamRoleCredentialProvider.Builder
        public Builder roleName(String str) {
            this.roleName = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        public EcsRamRoleCredentialProvider build() {
            return new EcsRamRoleCredentialProvider(this);
        }
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public ECSMetadataServiceCredentialsFetcher getFetcher() {
        return this.fetcher;
    }

    @Override // com.aliyun.credentials.provider.SessionCredentialsProvider
    public RefreshResult<CredentialModel> refreshCredentials() {
        return this.fetcher.fetch(new CompatibleUrlConnClient());
    }

    public void setFetcher(ECSMetadataServiceCredentialsFetcher eCSMetadataServiceCredentialsFetcher) {
        this.fetcher = eCSMetadataServiceCredentialsFetcher;
    }

    @Deprecated
    public EcsRamRoleCredentialProvider(String str) {
        super(new BuilderImpl());
        if (StringUtils.isEmpty(str)) {
            str = new ECSMetadataServiceCredentialsFetcher("").fetchRoleName(new CompatibleUrlConnClient());
        }
        this.fetcher = new ECSMetadataServiceCredentialsFetcher(str);
    }

    @Deprecated
    public EcsRamRoleCredentialProvider(Configuration configuration) {
        super(new BuilderImpl());
        if (StringUtils.isEmpty(configuration.getRoleName())) {
            configuration.setRoleName(new ECSMetadataServiceCredentialsFetcher("").fetchRoleName(new CompatibleUrlConnClient()));
        }
        this.fetcher = new ECSMetadataServiceCredentialsFetcher(configuration.getRoleName(), configuration.getConnectTimeout(), configuration.getReadTimeout());
    }

    @Deprecated
    public EcsRamRoleCredentialProvider(Config config) {
        super(new BuilderImpl());
        if (StringUtils.isEmpty(config.roleName)) {
            config.roleName = new ECSMetadataServiceCredentialsFetcher("").fetchRoleName(new CompatibleUrlConnClient());
        }
        this.fetcher = new ECSMetadataServiceCredentialsFetcher(config.roleName, config.connectTimeout, config.timeout);
    }

    private EcsRamRoleCredentialProvider(BuilderImpl builderImpl) {
        super(builderImpl);
        String strFetchRoleName = builderImpl.roleName;
        if (StringUtils.isEmpty(strFetchRoleName)) {
            strFetchRoleName = new ECSMetadataServiceCredentialsFetcher("").fetchRoleName(new CompatibleUrlConnClient());
        }
        this.fetcher = new ECSMetadataServiceCredentialsFetcher(strFetchRoleName, builderImpl.connectionTimeout, builderImpl.readTimeout);
    }
}
