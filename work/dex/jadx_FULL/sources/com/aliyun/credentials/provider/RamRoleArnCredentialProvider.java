package com.aliyun.credentials.provider;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.credentials.Configuration;
import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.credentials.http.CompatibleUrlConnClient;
import com.aliyun.credentials.http.HttpRequest;
import com.aliyun.credentials.http.HttpResponse;
import com.aliyun.credentials.http.MethodType;
import com.aliyun.credentials.models.Config;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.ParameterHelper;
import com.aliyun.credentials.utils.StringUtils;
import com.aliyun.tea.utils.Validate;
import com.google.gson.Gson;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RamRoleArnCredentialProvider extends SessionCredentialsProvider {
    private String STSEndpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private int connectTimeout;
    public int durationSeconds;
    private String externalId;
    private String policy;
    private int readTimeout;
    private String regionId;
    private String roleArn;
    private String roleSessionName;

    public interface Builder extends SessionCredentialsProvider.Builder<RamRoleArnCredentialProvider, Builder> {
        Builder STSEndpoint(String str);

        Builder accessKeyId(String str);

        Builder accessKeySecret(String str);

        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        RamRoleArnCredentialProvider build();

        Builder connectionTimeout(int i);

        Builder durationSeconds(int i);

        Builder externalId(String str);

        Builder policy(String str);

        Builder readTimeout(int i);

        Builder regionId(String str);

        Builder roleArn(String str);

        Builder roleSessionName(String str);
    }

    public static final class BuilderImpl extends SessionCredentialsProvider.BuilderImpl<RamRoleArnCredentialProvider, Builder> implements Builder {
        private String STSEndpoint;
        private String accessKeyId;
        private String accessKeySecret;
        private int connectionTimeout;
        private int durationSeconds;
        private String externalId;
        private String policy;
        private int readTimeout;
        private String regionId;
        private String roleArn;
        private String roleSessionName;

        private BuilderImpl() {
            this.roleSessionName = StringUtils.isEmpty(System.getenv("ALIBABA_CLOUD_ROLE_SESSION_NAME")) ? "defaultSessionName" : System.getenv("ALIBABA_CLOUD_ROLE_SESSION_NAME");
            this.durationSeconds = 3600;
            this.roleArn = System.getenv("ALIBABA_CLOUD_ROLE_ARN");
            this.regionId = "cn-hangzhou";
            this.connectionTimeout = 1000;
            this.readTimeout = 1000;
            this.STSEndpoint = "sts.aliyuncs.com";
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder STSEndpoint(String str) {
            this.STSEndpoint = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder accessKeyId(String str) {
            this.accessKeyId = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder accessKeySecret(String str) {
            this.accessKeySecret = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder connectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder durationSeconds(int i) {
            this.durationSeconds = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder externalId(String str) {
            this.externalId = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder policy(String str) {
            this.policy = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder readTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder regionId(String str) {
            if (!StringUtils.isEmpty(str)) {
                this.regionId = str;
            }
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder roleArn(String str) {
            if (!StringUtils.isEmpty(str)) {
                this.roleArn = str;
            }
            return this;
        }

        @Override // com.aliyun.credentials.provider.RamRoleArnCredentialProvider.Builder
        public Builder roleSessionName(String str) {
            if (!StringUtils.isEmpty(str)) {
                this.roleSessionName = str;
            }
            return this;
        }

        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        public RamRoleArnCredentialProvider build() {
            return new RamRoleArnCredentialProvider(this);
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

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public RefreshResult<CredentialModel> getNewSessionCredentials(CompatibleUrlConnClient compatibleUrlConnClient) throws Throwable {
        ParameterHelper parameterHelper = new ParameterHelper();
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setUrlParameter(AliyunVodKey.KEY_VOD_ACTION, "AssumeRole");
        httpRequest.setUrlParameter(AliyunVodKey.KEY_VOD_COMMON_FORMAT, "JSON");
        httpRequest.setUrlParameter("Version", "2015-04-01");
        httpRequest.setUrlParameter("DurationSeconds", String.valueOf(this.durationSeconds));
        httpRequest.setUrlParameter("RoleArn", this.roleArn);
        httpRequest.setUrlParameter(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID, this.accessKeyId);
        httpRequest.setUrlParameter("RegionId", this.regionId);
        httpRequest.setUrlParameter("RoleSessionName", this.roleSessionName);
        String str = this.policy;
        if (str != null) {
            httpRequest.setUrlParameter("Policy", str);
        }
        String str2 = this.externalId;
        if (str2 != null) {
            httpRequest.setUrlParameter("ExternalId", str2);
        }
        MethodType methodType = MethodType.GET;
        httpRequest.setSysMethod(methodType);
        httpRequest.setSysConnectTimeout(Integer.valueOf(this.connectTimeout));
        httpRequest.setSysReadTimeout(Integer.valueOf(this.readTimeout));
        httpRequest.setUrlParameter("Signature", parameterHelper.signString(parameterHelper.composeStringToSign(methodType, httpRequest.getUrlParameters()), this.accessKeySecret + "&"));
        httpRequest.setSysUrl(parameterHelper.composeUrl(this.STSEndpoint, httpRequest.getUrlParameters(), "https"));
        HttpResponse httpResponseSyncInvoke = compatibleUrlConnClient.syncInvoke(httpRequest);
        Gson gson = new Gson();
        Map map = (Map) gson.fromJson(httpResponseSyncInvoke.getHttpContentString(), Map.class);
        if (map == null) {
            throw new CredentialException(httpResponseSyncInvoke.getResponseMessage());
        }
        if (!map.containsKey("Credentials")) {
            throw new CredentialException(gson.toJson(map));
        }
        Map map2 = (Map) map.get("Credentials");
        long time = ParameterHelper.getUTCDate((String) map2.get("Expiration")).getTime();
        return RefreshResult.builder(CredentialModel.builder().accessKeyId((String) map2.get(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID)).accessKeySecret((String) map2.get("AccessKeySecret")).securityToken((String) map2.get(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN)).type("ram_role_arn").expiration(time).build()).staleTime(getStaleTime(time)).build();
    }

    public String getPolicy() {
        return this.policy;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getRoleSessionName() {
        return this.roleSessionName;
    }

    public String getSTSEndpoint() {
        return this.STSEndpoint;
    }

    @Override // com.aliyun.credentials.provider.SessionCredentialsProvider
    public RefreshResult<CredentialModel> refreshCredentials() {
        return createCredential(new CompatibleUrlConnClient());
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setDurationSeconds(int i) {
        this.durationSeconds = i;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setRegionId(String str) {
        this.regionId = str;
    }

    public void setRoleSessionName(String str) {
        this.roleSessionName = str;
    }

    public void setSTSEndpoint(String str) {
        this.STSEndpoint = str;
    }

    @Deprecated
    public RamRoleArnCredentialProvider(Configuration configuration) {
        this(configuration.getAccessKeyId(), configuration.getAccessKeySecret(), configuration.getRoleArn());
        this.roleSessionName = configuration.getRoleSessionName();
        this.connectTimeout = configuration.getConnectTimeout();
        this.readTimeout = configuration.getReadTimeout();
        if (StringUtils.isEmpty(configuration.getSTSEndpoint())) {
            return;
        }
        this.STSEndpoint = configuration.getSTSEndpoint();
    }

    @Deprecated
    public RamRoleArnCredentialProvider(Config config) {
        this(config.accessKeyId, config.accessKeySecret, config.roleArn);
        this.roleSessionName = config.roleSessionName;
        this.connectTimeout = config.connectTimeout;
        this.readTimeout = config.timeout;
        this.policy = config.policy;
        this.durationSeconds = config.roleSessionExpiration.intValue();
        if (StringUtils.isEmpty(config.STSEndpoint)) {
            return;
        }
        this.STSEndpoint = config.STSEndpoint;
    }

    @Deprecated
    public RamRoleArnCredentialProvider(String str, String str2, String str3) {
        super(new BuilderImpl());
        this.durationSeconds = 3600;
        this.roleSessionName = "defaultSessionName";
        this.regionId = "cn-hangzhou";
        this.connectTimeout = 1000;
        this.readTimeout = 1000;
        this.STSEndpoint = "sts.aliyuncs.com";
        this.roleArn = str3;
        this.accessKeyId = str;
        this.accessKeySecret = str2;
    }

    @Deprecated
    public RamRoleArnCredentialProvider(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str4);
        this.roleSessionName = str3;
        this.regionId = str5;
        this.policy = str6;
    }

    private RamRoleArnCredentialProvider(BuilderImpl builderImpl) {
        super(builderImpl);
        this.durationSeconds = 3600;
        this.roleSessionName = "defaultSessionName";
        this.regionId = "cn-hangzhou";
        this.connectTimeout = 1000;
        this.readTimeout = 1000;
        this.STSEndpoint = "sts.aliyuncs.com";
        this.roleSessionName = builderImpl.roleSessionName;
        this.durationSeconds = builderImpl.durationSeconds;
        this.roleArn = builderImpl.roleArn;
        this.regionId = builderImpl.regionId;
        this.policy = builderImpl.policy;
        this.connectTimeout = builderImpl.connectionTimeout;
        this.readTimeout = builderImpl.readTimeout;
        this.STSEndpoint = builderImpl.STSEndpoint;
        this.accessKeyId = (String) Validate.notNull(builderImpl.accessKeyId, "AccessKeyId must not be null.", new Object[0]);
        this.accessKeySecret = (String) Validate.notNull(builderImpl.accessKeySecret, "AccessKeySecret must not be null.", new Object[0]);
        this.externalId = builderImpl.externalId;
    }
}
