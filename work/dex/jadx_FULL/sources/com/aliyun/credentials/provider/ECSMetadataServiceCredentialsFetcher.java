package com.aliyun.credentials.provider;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.credentials.http.CompatibleUrlConnClient;
import com.aliyun.credentials.http.HttpRequest;
import com.aliyun.credentials.http.HttpResponse;
import com.aliyun.credentials.http.MethodType;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.ParameterHelper;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ECSMetadataServiceCredentialsFetcher {
    private static final String ECS_METADAT_FETCH_ERROR_MSG = "Failed to get RAM session credentials from ECS metadata service.";
    private static final String URL_IN_ECS_METADATA = "/latest/meta-data/ram/security-credentials/";
    private int connectionTimeout;
    private URL credentialUrl;
    private String metadataServiceHost;
    private int readTimeout;
    private String roleName;

    public ECSMetadataServiceCredentialsFetcher(String str, int i, int i2) {
        this.metadataServiceHost = "100.100.100.200";
        this.connectionTimeout = 1000;
        this.readTimeout = 1000;
        if (i > 1000) {
            this.connectionTimeout = i;
        }
        if (i2 > 1000) {
            this.readTimeout = i2;
        }
        this.roleName = str;
        setCredentialUrl();
    }

    private void setCredentialUrl() {
        try {
            this.credentialUrl = new URL("http://" + this.metadataServiceHost + URL_IN_ECS_METADATA + this.roleName);
        } catch (MalformedURLException e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }

    public RefreshResult<CredentialModel> fetch(CompatibleUrlConnClient compatibleUrlConnClient) {
        Map map = (Map) new Gson().fromJson(getMetadata(compatibleUrlConnClient), Map.class);
        if (!"Success".equals(map.get("Code"))) {
            throw new CredentialException(ECS_METADAT_FETCH_ERROR_MSG);
        }
        long time = ParameterHelper.getUTCDate((String) map.get("Expiration")).getTime();
        return RefreshResult.builder(CredentialModel.builder().accessKeyId((String) map.get(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID)).accessKeySecret((String) map.get("AccessKeySecret")).securityToken((String) map.get(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN)).type("ecs_ram_role").expiration(time).build()).staleTime(time - 180000).build();
    }

    public String fetchRoleName(CompatibleUrlConnClient compatibleUrlConnClient) {
        return getMetadata(compatibleUrlConnClient);
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public URL getCredentialUrl() {
        return this.credentialUrl;
    }

    public String getMetadata(CompatibleUrlConnClient compatibleUrlConnClient) {
        HttpRequest httpRequest = new HttpRequest(this.credentialUrl.toString());
        httpRequest.setSysMethod(MethodType.GET);
        httpRequest.setSysConnectTimeout(Integer.valueOf(this.connectionTimeout));
        httpRequest.setSysReadTimeout(Integer.valueOf(this.readTimeout));
        try {
            try {
                HttpResponse httpResponseSyncInvoke = compatibleUrlConnClient.syncInvoke(httpRequest);
                compatibleUrlConnClient.close();
                if (httpResponseSyncInvoke.getResponseCode() == 404) {
                    throw new CredentialException("The role name was not found in the instance");
                }
                if (httpResponseSyncInvoke.getResponseCode() == 200) {
                    return new String(httpResponseSyncInvoke.getHttpContent());
                }
                throw new CredentialException("Failed to get RAM session credentials from ECS metadata service. HttpCode=" + httpResponseSyncInvoke.getResponseCode());
            } catch (Exception e) {
                throw new CredentialException("Failed to connect ECS Metadata Service: " + e.toString());
            }
        } catch (Throwable th) {
            compatibleUrlConnClient.close();
            throw th;
        }
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public ECSMetadataServiceCredentialsFetcher(String str) {
        this.metadataServiceHost = "100.100.100.200";
        this.connectionTimeout = 1000;
        this.readTimeout = 1000;
        this.roleName = str;
        setCredentialUrl();
    }
}
