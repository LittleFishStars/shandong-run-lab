package com.aliyun.credentials.provider;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.credentials.Configuration;
import com.aliyun.credentials.http.CompatibleUrlConnClient;
import com.aliyun.credentials.http.HttpRequest;
import com.aliyun.credentials.http.MethodType;
import com.aliyun.credentials.models.Config;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.AuthUtils;
import com.aliyun.credentials.utils.ParameterHelper;
import com.aliyun.credentials.utils.StringUtils;
import com.aliyun.tea.utils.Validate;
import com.google.gson.Gson;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RsaKeyPairCredentialProvider extends SessionCredentialsProvider {
    private String STSEndpoint;
    private int connectTimeout;
    public int durationSeconds;
    private String privateKey;
    private String privateKeyFile;
    private String publicKeyId;
    private int readTimeout;
    private String regionId;

    public interface Builder extends SessionCredentialsProvider.Builder<RsaKeyPairCredentialProvider, Builder> {
        Builder STSEndpoint(String str);

        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        RsaKeyPairCredentialProvider build();

        Builder connectionTimeout(int i);

        Builder durationSeconds(int i);

        Builder privateKeyFile(String str);

        Builder publicKeyId(String str);

        Builder readTimeout(int i);

        Builder regionId(String str);
    }

    public static final class BuilderImpl extends SessionCredentialsProvider.BuilderImpl<RsaKeyPairCredentialProvider, Builder> implements Builder {
        private String STSEndpoint;
        private int connectionTimeout;
        private int durationSeconds;
        private String privateKeyFile;
        private String publicKeyId;
        private int readTimeout;
        private String regionId;

        private BuilderImpl() {
            this.durationSeconds = 3600;
            this.regionId = "cn-hangzhou";
            this.connectionTimeout = 1000;
            this.readTimeout = 1000;
            this.STSEndpoint = "sts.aliyuncs.com";
        }

        @Override // com.aliyun.credentials.provider.RsaKeyPairCredentialProvider.Builder
        public Builder STSEndpoint(String str) {
            this.STSEndpoint = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RsaKeyPairCredentialProvider.Builder
        public Builder connectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RsaKeyPairCredentialProvider.Builder
        public Builder durationSeconds(int i) {
            this.durationSeconds = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RsaKeyPairCredentialProvider.Builder
        public Builder privateKeyFile(String str) {
            this.privateKeyFile = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RsaKeyPairCredentialProvider.Builder
        public Builder publicKeyId(String str) {
            this.publicKeyId = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RsaKeyPairCredentialProvider.Builder
        public Builder readTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RsaKeyPairCredentialProvider.Builder
        public Builder regionId(String str) {
            if (!StringUtils.isEmpty(str)) {
                this.regionId = str;
            }
            return this;
        }

        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        public RsaKeyPairCredentialProvider build() {
            return new RsaKeyPairCredentialProvider(this);
        }
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public RefreshResult<CredentialModel> createCredential(CompatibleUrlConnClient compatibleUrlConnClient) {
        try {
            return getNewSessionCredentials(compatibleUrlConnClient);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            compatibleUrlConnClient.close();
        }
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getDurationSeconds() {
        return this.durationSeconds;
    }

    public RefreshResult<CredentialModel> getNewSessionCredentials(CompatibleUrlConnClient compatibleUrlConnClient) throws Throwable {
        if (!StringUtils.isEmpty(this.privateKeyFile)) {
            this.privateKey = AuthUtils.getOIDCToken(this.privateKeyFile);
        }
        ParameterHelper parameterHelper = new ParameterHelper();
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setUrlParameter(AliyunVodKey.KEY_VOD_ACTION, "GenerateSessionAccessKey");
        httpRequest.setUrlParameter(AliyunVodKey.KEY_VOD_COMMON_FORMAT, "JSON");
        httpRequest.setUrlParameter("Version", "2015-04-01");
        httpRequest.setUrlParameter("DurationSeconds", String.valueOf(this.durationSeconds));
        httpRequest.setUrlParameter(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID, this.publicKeyId);
        httpRequest.setUrlParameter("RegionId", this.regionId);
        MethodType methodType = MethodType.GET;
        httpRequest.setUrlParameter("Signature", parameterHelper.signString(parameterHelper.composeStringToSign(methodType, httpRequest.getUrlParameters()), this.privateKey + "&"));
        httpRequest.setSysMethod(methodType);
        httpRequest.setSysConnectTimeout(Integer.valueOf(this.connectTimeout));
        httpRequest.setSysReadTimeout(Integer.valueOf(this.readTimeout));
        httpRequest.setSysUrl(parameterHelper.composeUrl(this.STSEndpoint, httpRequest.getUrlParameters(), "https"));
        Map map = (Map) ((Map) new Gson().fromJson(compatibleUrlConnClient.syncInvoke(httpRequest).getHttpContentString(), Map.class)).get("SessionAccessKey");
        long time = ParameterHelper.getUTCDate((String) map.get("Expiration")).getTime();
        return RefreshResult.builder(CredentialModel.builder().accessKeyId((String) map.get("SessionAccessKeyId")).accessKeySecret((String) map.get("SessionAccessKeySecret")).type("rsa_key_pair").expiration(time).build()).staleTime(getStaleTime(time)).build();
    }

    public String getPrivateKey() {
        return this.privateKey;
    }

    public String getPublicKeyId() {
        return this.publicKeyId;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public String getSTSEndpoint() {
        return this.STSEndpoint;
    }

    @Override // com.aliyun.credentials.provider.SessionCredentialsProvider
    public RefreshResult<CredentialModel> refreshCredentials() {
        return createCredential(new CompatibleUrlConnClient());
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setDurationSeconds(int i) {
        this.durationSeconds = i;
    }

    public void setPrivateKey(String str) {
        this.privateKey = str;
    }

    public void setPublicKeyId(String str) {
        this.publicKeyId = str;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setRegionId(String str) {
        this.regionId = str;
    }

    public void setSTSEndpoint(String str) {
        this.STSEndpoint = str;
    }

    @Deprecated
    public RsaKeyPairCredentialProvider(Configuration configuration) {
        this(configuration.getPublicKeyId(), configuration.getPrivateKeyFile());
        this.connectTimeout = configuration.getConnectTimeout();
        this.readTimeout = configuration.getReadTimeout();
        if (StringUtils.isEmpty(configuration.getSTSEndpoint())) {
            return;
        }
        this.STSEndpoint = configuration.getSTSEndpoint();
    }

    @Deprecated
    public RsaKeyPairCredentialProvider(Config config) {
        this(config.publicKeyId, config.privateKeyFile);
        this.connectTimeout = config.connectTimeout;
        this.readTimeout = config.timeout;
        if (StringUtils.isEmpty(config.STSEndpoint)) {
            return;
        }
        this.STSEndpoint = config.STSEndpoint;
    }

    @Deprecated
    public RsaKeyPairCredentialProvider(String str, String str2) {
        super(new BuilderImpl());
        this.durationSeconds = 3600;
        this.regionId = "cn-hangzhou";
        this.connectTimeout = 1000;
        this.readTimeout = 1000;
        this.STSEndpoint = "sts.aliyuncs.com";
        this.publicKeyId = str;
        this.privateKey = str2;
    }

    private RsaKeyPairCredentialProvider(BuilderImpl builderImpl) {
        super(builderImpl);
        this.durationSeconds = 3600;
        this.regionId = "cn-hangzhou";
        this.connectTimeout = 1000;
        this.readTimeout = 1000;
        this.STSEndpoint = "sts.aliyuncs.com";
        this.durationSeconds = builderImpl.durationSeconds;
        this.regionId = builderImpl.regionId;
        this.connectTimeout = builderImpl.connectionTimeout;
        this.readTimeout = builderImpl.readTimeout;
        this.STSEndpoint = builderImpl.STSEndpoint;
        this.publicKeyId = (String) Validate.notNull(builderImpl.publicKeyId, "PublicKeyId must not be null.", new Object[0]);
        this.privateKeyFile = (String) Validate.notNull(builderImpl.privateKeyFile, "privateKeyFile must not be null.", new Object[0]);
    }
}
