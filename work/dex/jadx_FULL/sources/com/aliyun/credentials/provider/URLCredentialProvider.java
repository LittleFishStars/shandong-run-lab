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
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.credentials.utils.ParameterHelper;
import com.aliyun.credentials.utils.StringUtils;
import com.aliyun.tea.utils.Validate;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class URLCredentialProvider extends SessionCredentialsProvider {
    private int connectTimeout;
    private URL credentialsURI;
    private int readTimeout;

    public interface Builder extends SessionCredentialsProvider.Builder<URLCredentialProvider, Builder> {
        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        URLCredentialProvider build();

        Builder connectionTimeout(int i);

        Builder credentialsURI(String str);

        Builder credentialsURI(URL url);

        Builder readTimeout(int i);
    }

    public static final class BuilderImpl extends SessionCredentialsProvider.BuilderImpl<URLCredentialProvider, Builder> implements Builder {
        private int connectionTimeout;
        private String credentialsURI;
        private int readTimeout;

        private BuilderImpl() {
            this.credentialsURI = System.getenv("ALIBABA_CLOUD_CREDENTIALS_URI");
            this.connectionTimeout = 1000;
            this.readTimeout = 1000;
        }

        @Override // com.aliyun.credentials.provider.URLCredentialProvider.Builder
        public Builder connectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.URLCredentialProvider.Builder
        public Builder credentialsURI(URL url) {
            this.credentialsURI = url.toString();
            return this;
        }

        @Override // com.aliyun.credentials.provider.URLCredentialProvider.Builder
        public Builder readTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        @Override // com.aliyun.credentials.provider.SessionCredentialsProvider.Builder
        public URLCredentialProvider build() {
            return new URLCredentialProvider(this);
        }

        @Override // com.aliyun.credentials.provider.URLCredentialProvider.Builder
        public Builder credentialsURI(String str) {
            this.credentialsURI = str;
            return this;
        }
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public String getURL() {
        return this.credentialsURI.toString();
    }

    @Override // com.aliyun.credentials.provider.SessionCredentialsProvider
    public RefreshResult<CredentialModel> refreshCredentials() {
        CompatibleUrlConnClient compatibleUrlConnClient = new CompatibleUrlConnClient();
        HttpRequest httpRequest = new HttpRequest(this.credentialsURI.toString());
        httpRequest.setSysMethod(MethodType.GET);
        httpRequest.setSysConnectTimeout(Integer.valueOf(this.connectTimeout));
        httpRequest.setSysReadTimeout(Integer.valueOf(this.readTimeout));
        try {
            try {
                HttpResponse httpResponseSyncInvoke = compatibleUrlConnClient.syncInvoke(httpRequest);
                compatibleUrlConnClient.close();
                if (httpResponseSyncInvoke.getResponseCode() >= 300 || httpResponseSyncInvoke.getResponseCode() < 200) {
                    throw new CredentialException("Failed to get credentials from server: " + this.credentialsURI.toString() + "\nHttpCode=" + httpResponseSyncInvoke.getResponseCode() + "\nHttpRAWContent=" + httpResponseSyncInvoke.getHttpContentString());
                }
                Gson gson = new Gson();
                try {
                    Map map = (Map) gson.fromJson(httpResponseSyncInvoke.getHttpContentString(), Map.class);
                    if (!map.containsKey("Code") || !((String) map.get("Code")).equals("Success")) {
                        throw new CredentialException(gson.toJson(map));
                    }
                    long time = ParameterHelper.getUTCDate((String) map.get("Expiration")).getTime();
                    return RefreshResult.builder(CredentialModel.builder().accessKeyId((String) map.get(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID)).accessKeySecret((String) map.get("AccessKeySecret")).securityToken((String) map.get(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN)).type(AuthConstant.URL_STS).expiration(time).build()).staleTime(getStaleTime(time)).build();
                } catch (Exception e) {
                    throw new CredentialException("Failed to get credentials from server: " + this.credentialsURI.toString() + "\nHttpCode=" + httpResponseSyncInvoke.getResponseCode() + "\nHttpRAWContent=" + httpResponseSyncInvoke.getHttpContentString(), e);
                }
            } catch (Exception e2) {
                throw new CredentialException("Failed to connect Server: " + e2.toString());
            }
        } catch (Throwable th) {
            compatibleUrlConnClient.close();
            throw th;
        }
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    @Deprecated
    public URLCredentialProvider() {
        this(System.getenv("ALIBABA_CLOUD_CREDENTIALS_URI"));
    }

    @Deprecated
    public URLCredentialProvider(String str) {
        super(new BuilderImpl());
        this.connectTimeout = 1000;
        this.readTimeout = 1000;
        if (!StringUtils.isEmpty(str)) {
            try {
                this.credentialsURI = new URL(str);
                return;
            } catch (MalformedURLException unused) {
                throw new CredentialException("Credential URI is not valid.");
            }
        }
        throw new CredentialException("Credential URI cannot be null.");
    }

    @Deprecated
    public URLCredentialProvider(URL url) {
        super(new BuilderImpl());
        this.connectTimeout = 1000;
        this.readTimeout = 1000;
        if (url != null) {
            this.credentialsURI = url;
            return;
        }
        throw new CredentialException("Credential URI cannot be null.");
    }

    @Deprecated
    public URLCredentialProvider(Configuration configuration) {
        this(configuration.getCredentialsURI());
        this.connectTimeout = configuration.getConnectTimeout();
        this.readTimeout = configuration.getReadTimeout();
    }

    @Deprecated
    public URLCredentialProvider(Config config) {
        this(config.credentialsURI);
        this.connectTimeout = config.connectTimeout;
        this.readTimeout = config.timeout;
    }

    private URLCredentialProvider(BuilderImpl builderImpl) {
        super(builderImpl);
        this.connectTimeout = 1000;
        this.readTimeout = 1000;
        try {
            this.credentialsURI = new URL((String) Validate.notNull(builderImpl.credentialsURI, "Credentials URI is not valid.", new Object[0]));
            this.connectTimeout = builderImpl.connectionTimeout;
            this.readTimeout = builderImpl.readTimeout;
        } catch (MalformedURLException unused) {
            throw new CredentialException("Credential URI is not valid.");
        }
    }
}
