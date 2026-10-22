package com.aliyun.credentials.provider;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.credentials.Configuration;
import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.credentials.http.CompatibleUrlConnClient;
import com.aliyun.credentials.http.FormatType;
import com.aliyun.credentials.http.HttpRequest;
import com.aliyun.credentials.http.HttpResponse;
import com.aliyun.credentials.http.MethodType;
import com.aliyun.credentials.models.Config;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.AuthUtils;
import com.aliyun.credentials.utils.ParameterHelper;
import com.aliyun.credentials.utils.StringUtils;
import com.aliyun.tea.utils.Validate;
import com.google.gson.Gson;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OIDCRoleArnCredentialProvider extends SessionCredentialsProvider {
    private String STSEndpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private int connectTimeout;
    public int durationSeconds;
    private String oidcProviderArn;
    private String oidcToken;
    private String oidcTokenFilePath;
    private String policy;
    private int readTimeout;
    private String regionId;
    private String roleArn;
    private String roleSessionName;

    public interface Builder extends SessionCredentialsProvider.Builder<OIDCRoleArnCredentialProvider, Builder> {
        Builder STSEndpoint(String str);

        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        OIDCRoleArnCredentialProvider build();

        Builder connectionTimeout(int i);

        Builder durationSeconds(int i);

        Builder oidcProviderArn(String str);

        Builder oidcTokenFilePath(String str);

        Builder policy(String str);

        Builder readTimeout(int i);

        Builder regionId(String str);

        Builder roleArn(String str);

        Builder roleSessionName(String str);
    }

    public static final class BuilderImpl extends SessionCredentialsProvider.BuilderImpl<OIDCRoleArnCredentialProvider, Builder> implements Builder {
        private String STSEndpoint;
        private int connectionTimeout;
        private int durationSeconds;
        private String oidcProviderArn;
        private String oidcTokenFilePath;
        private String policy;
        private int readTimeout;
        private String regionId;
        private String roleArn;
        private String roleSessionName;

        private BuilderImpl() {
            this.roleSessionName = StringUtils.isEmpty(System.getenv("ALIBABA_CLOUD_ROLE_SESSION_NAME")) ? "defaultSessionName" : System.getenv("ALIBABA_CLOUD_ROLE_SESSION_NAME");
            this.durationSeconds = 3600;
            this.roleArn = System.getenv("ALIBABA_CLOUD_ROLE_ARN");
            this.oidcProviderArn = System.getenv("ALIBABA_CLOUD_OIDC_PROVIDER_ARN");
            this.oidcTokenFilePath = System.getenv("ALIBABA_CLOUD_OIDC_TOKEN_FILE");
            this.regionId = "cn-hangzhou";
            this.connectionTimeout = 1000;
            this.readTimeout = 1000;
            this.STSEndpoint = "sts.aliyuncs.com";
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder STSEndpoint(String str) {
            this.STSEndpoint = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder connectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder durationSeconds(int i) {
            this.durationSeconds = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder oidcProviderArn(String str) {
            if (!StringUtils.isEmpty(str)) {
                this.oidcProviderArn = str;
            }
            return this;
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder oidcTokenFilePath(String str) {
            if (!StringUtils.isEmpty(str)) {
                this.oidcTokenFilePath = str;
            }
            return this;
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder policy(String str) {
            this.policy = str;
            return this;
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder readTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder regionId(String str) {
            if (!StringUtils.isEmpty(str)) {
                this.regionId = str;
            }
            return this;
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder roleArn(String str) {
            if (!StringUtils.isEmpty(str)) {
                this.roleArn = str;
            }
            return this;
        }

        @Override // com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider.Builder
        public Builder roleSessionName(String str) {
            if (!StringUtils.isEmpty(str)) {
                this.roleSessionName = str;
            }
            return this;
        }

        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        public OIDCRoleArnCredentialProvider build() {
            return new OIDCRoleArnCredentialProvider(this);
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

    @Deprecated
    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    @Deprecated
    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getDurationSeconds() {
        return this.durationSeconds;
    }

    public RefreshResult<CredentialModel> getNewSessionCredentials(CompatibleUrlConnClient compatibleUrlConnClient) throws Throwable {
        this.oidcToken = AuthUtils.getOIDCToken(this.oidcTokenFilePath);
        ParameterHelper parameterHelper = new ParameterHelper();
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setUrlParameter(AliyunVodKey.KEY_VOD_ACTION, "AssumeRoleWithOIDC");
        httpRequest.setUrlParameter(AliyunVodKey.KEY_VOD_COMMON_FORMAT, "JSON");
        httpRequest.setUrlParameter("Version", "2015-04-01");
        httpRequest.setUrlParameter("RegionId", this.regionId);
        HashMap map = new HashMap();
        map.put("DurationSeconds", String.valueOf(this.durationSeconds));
        map.put("RoleArn", this.roleArn);
        map.put("OIDCProviderArn", this.oidcProviderArn);
        map.put("OIDCToken", this.oidcToken);
        map.put("RoleSessionName", this.roleSessionName);
        map.put("Policy", this.policy);
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!StringUtils.isEmpty((CharSequence) entry.getValue())) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
            }
        }
        httpRequest.setHttpContent(sb.toString().getBytes("UTF-8"), "UTF-8", FormatType.FORM);
        httpRequest.setSysMethod(MethodType.POST);
        httpRequest.setSysConnectTimeout(Integer.valueOf(this.connectTimeout));
        httpRequest.setSysReadTimeout(Integer.valueOf(this.readTimeout));
        httpRequest.setSysUrl(parameterHelper.composeUrl(this.STSEndpoint, httpRequest.getUrlParameters(), "https"));
        HttpResponse httpResponseSyncInvoke = compatibleUrlConnClient.syncInvoke(httpRequest);
        Gson gson = new Gson();
        Map map2 = (Map) gson.fromJson(httpResponseSyncInvoke.getHttpContentString(), Map.class);
        if (map2 == null) {
            throw new CredentialException(httpResponseSyncInvoke.getResponseMessage());
        }
        if (!map2.containsKey("Credentials")) {
            throw new CredentialException(gson.toJson(map2));
        }
        Map map3 = (Map) map2.get("Credentials");
        long time = ParameterHelper.getUTCDate((String) map3.get("Expiration")).getTime();
        return RefreshResult.builder(CredentialModel.builder().accessKeyId((String) map3.get(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID)).accessKeySecret((String) map3.get("AccessKeySecret")).securityToken((String) map3.get(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN)).type("oidc_role_arn").expiration(time).build()).staleTime(getStaleTime(time)).build();
    }

    public String getOIDCProviderArn() {
        return this.oidcProviderArn;
    }

    public String getOIDCToken() {
        return this.oidcToken;
    }

    public String getOIDCTokenFilePath() {
        return this.oidcTokenFilePath;
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

    @Deprecated
    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    @Deprecated
    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setDurationSeconds(int i) {
        this.durationSeconds = i;
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
    public OIDCRoleArnCredentialProvider(Configuration configuration) {
        this(configuration.getRoleArn(), configuration.getOIDCProviderArn(), configuration.getOIDCTokenFilePath());
        this.roleSessionName = configuration.getRoleSessionName();
        this.connectTimeout = configuration.getConnectTimeout();
        this.readTimeout = configuration.getReadTimeout();
        if (StringUtils.isEmpty(configuration.getSTSEndpoint())) {
            return;
        }
        this.STSEndpoint = configuration.getSTSEndpoint();
    }

    @Deprecated
    public OIDCRoleArnCredentialProvider(Config config) {
        this(config.roleArn, config.oidcProviderArn, config.oidcTokenFilePath);
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
    public OIDCRoleArnCredentialProvider(String str, String str2, String str3, String str4, String str5) {
        this(str3, str4, str5);
    }

    @Deprecated
    public OIDCRoleArnCredentialProvider(String str, String str2, String str3) {
        super(new BuilderImpl());
        this.durationSeconds = 3600;
        this.roleSessionName = "defaultSessionName";
        this.regionId = "cn-hangzhou";
        this.connectTimeout = 1000;
        this.readTimeout = 1000;
        this.STSEndpoint = "sts.aliyuncs.com";
        if (!StringUtils.isEmpty(str)) {
            this.roleArn = str;
        } else if (!StringUtils.isEmpty(System.getenv("ALIBABA_CLOUD_ROLE_ARN"))) {
            this.roleArn = System.getenv("ALIBABA_CLOUD_ROLE_ARN");
        } else {
            throw new CredentialException("roleArn does not exist and env ALIBABA_CLOUD_ROLE_ARN is null.");
        }
        if (!StringUtils.isEmpty(str2)) {
            this.oidcProviderArn = str2;
        } else if (!StringUtils.isEmpty(System.getenv("ALIBABA_CLOUD_OIDC_PROVIDER_ARN"))) {
            this.oidcProviderArn = System.getenv("ALIBABA_CLOUD_OIDC_PROVIDER_ARN");
        } else {
            throw new CredentialException("OIDCProviderArn does not exist and env ALIBABA_CLOUD_OIDC_PROVIDER_ARN is null.");
        }
        if (!StringUtils.isEmpty(str3)) {
            this.oidcTokenFilePath = str3;
        } else if (!StringUtils.isEmpty(System.getenv("ALIBABA_CLOUD_OIDC_TOKEN_FILE"))) {
            this.oidcTokenFilePath = System.getenv("ALIBABA_CLOUD_OIDC_TOKEN_FILE");
        } else {
            throw new CredentialException("OIDCTokenFilePath does not exist and env ALIBABA_CLOUD_OIDC_TOKEN_FILE is null.");
        }
        if (StringUtils.isEmpty(System.getenv("ALIBABA_CLOUD_ROLE_SESSION_NAME"))) {
            return;
        }
        this.roleSessionName = System.getenv("ALIBABA_CLOUD_ROLE_SESSION_NAME");
    }

    @Deprecated
    public OIDCRoleArnCredentialProvider(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this(str3, str4, str5, str6, str7, str8);
    }

    @Deprecated
    public OIDCRoleArnCredentialProvider(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str2, str3, str4);
        this.roleSessionName = str;
        this.regionId = str5;
        this.policy = str6;
    }

    private OIDCRoleArnCredentialProvider(BuilderImpl builderImpl) {
        super(builderImpl);
        this.durationSeconds = 3600;
        this.roleSessionName = "defaultSessionName";
        this.regionId = "cn-hangzhou";
        this.connectTimeout = 1000;
        this.readTimeout = 1000;
        this.STSEndpoint = "sts.aliyuncs.com";
        this.roleSessionName = builderImpl.roleSessionName;
        this.durationSeconds = builderImpl.durationSeconds;
        this.roleArn = (String) Validate.notNull(builderImpl.roleArn, "RoleArn or environment variable ALIBABA_CLOUD_ROLE_ARN cannot be null.", new Object[0]);
        this.oidcProviderArn = (String) Validate.notNull(builderImpl.oidcProviderArn, "OIDCProviderArn or environment variable ALIBABA_CLOUD_OIDC_PROVIDER_ARN cannot be null.", new Object[0]);
        this.oidcTokenFilePath = (String) Validate.notNull(builderImpl.oidcTokenFilePath, "OIDCTokenFilePath or environment variable ALIBABA_CLOUD_OIDC_TOKEN_FILE cannot be null.", new Object[0]);
        this.regionId = builderImpl.regionId;
        this.policy = builderImpl.policy;
        this.connectTimeout = builderImpl.connectionTimeout;
        this.readTimeout = builderImpl.readTimeout;
        this.STSEndpoint = builderImpl.STSEndpoint;
    }
}
