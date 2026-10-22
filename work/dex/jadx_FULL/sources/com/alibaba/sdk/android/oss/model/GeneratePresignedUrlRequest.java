package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.common.HttpMethod;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GeneratePresignedUrlRequest {
    private String bucketName;
    private String contentMD5;
    private String contentType;
    private long expiration;
    private String key;
    private HttpMethod method;
    private String process;
    private Map<String, String> queryParam;

    public GeneratePresignedUrlRequest(String str, String str2) {
        this(str, str2, 3600L);
    }

    public void addQueryParameter(String str, String str2) {
        this.queryParam.put(str, str2);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getContentMD5() {
        return this.contentMD5;
    }

    public String getContentType() {
        return this.contentType;
    }

    public long getExpiration() {
        return this.expiration;
    }

    public String getKey() {
        return this.key;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public String getProcess() {
        return this.process;
    }

    public Map<String, String> getQueryParameter() {
        return this.queryParam;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setContentMD5(String str) {
        this.contentMD5 = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setExpiration(long j) {
        this.expiration = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMethod(HttpMethod httpMethod) {
        if (httpMethod != HttpMethod.GET && httpMethod != HttpMethod.PUT) {
            throw new IllegalArgumentException("Only GET or PUT is supported!");
        }
        this.method = httpMethod;
    }

    public void setProcess(String str) {
        this.process = str;
    }

    public void setQueryParameter(Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("The argument 'queryParameter' is null.");
        }
        Map<String, String> map2 = this.queryParam;
        if (map2 != null && map2.size() > 0) {
            this.queryParam.clear();
        }
        this.queryParam.putAll(map);
    }

    public GeneratePresignedUrlRequest(String str, String str2, long j) {
        this(str, str2, 3600L, HttpMethod.GET);
    }

    public GeneratePresignedUrlRequest(String str, String str2, long j, HttpMethod httpMethod) {
        this.queryParam = new HashMap();
        this.bucketName = str;
        this.key = str2;
        this.expiration = j;
        this.method = httpMethod;
    }
}
