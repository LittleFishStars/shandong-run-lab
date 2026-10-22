package com.aliyun.credentials.provider;

import com.aliyun.credentials.models.CredentialModel;
import java.util.Date;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class SessionCredentialsProvider implements AlibabaCloudCredentialsProvider, AutoCloseable {
    private final boolean asyncCredentialUpdateEnabled;
    private RefreshCachedSupplier<CredentialModel> credentialsCache;
    private final Callable<RefreshResult<CredentialModel>> refreshCallable;

    public interface Builder<ProviderT extends SessionCredentialsProvider, BuilderT extends Builder> {
        BuilderT asyncCredentialUpdateEnabled(Boolean bool);

        ProviderT build();
    }

    public static abstract class BuilderImpl<ProviderT extends SessionCredentialsProvider, BuilderT extends Builder> implements Builder<ProviderT, BuilderT> {
        private boolean asyncCredentialUpdateEnabled = false;

        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        public BuilderT asyncCredentialUpdateEnabled(Boolean bool) {
            this.asyncCredentialUpdateEnabled = bool.booleanValue();
            return this;
        }
    }

    public SessionCredentialsProvider(BuilderImpl<?, ?> builderImpl) {
        Callable<RefreshResult<CredentialModel>> callable = new Callable<RefreshResult<CredentialModel>>() { // from class: com.aliyun.credentials.provider.SessionCredentialsProvider.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RefreshResult<CredentialModel> call() throws Exception {
                return SessionCredentialsProvider.this.refreshCredentials();
            }
        };
        this.refreshCallable = callable;
        boolean z = ((BuilderImpl) builderImpl).asyncCredentialUpdateEnabled;
        this.asyncCredentialUpdateEnabled = z;
        this.credentialsCache = RefreshCachedSupplier.builder(callable).asyncUpdateEnabled(Boolean.valueOf(z)).build();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        RefreshCachedSupplier<CredentialModel> refreshCachedSupplier = this.credentialsCache;
        if (refreshCachedSupplier != null) {
            refreshCachedSupplier.close();
        }
    }

    @Override // com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider
    public CredentialModel getCredentials() {
        return this.credentialsCache.get();
    }

    public long getStaleTime(long j) {
        return j <= 0 ? new Date().getTime() + 3600000 : j - 180000;
    }

    public boolean isAsyncCredentialUpdateEnabled() {
        return this.asyncCredentialUpdateEnabled;
    }

    public abstract RefreshResult<CredentialModel> refreshCredentials();
}
