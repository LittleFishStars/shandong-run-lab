package com.aliyun.credentials.http;

import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.credentials.utils.Base64Helper;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class HttpMessage {
    protected static final String CONTENT_LENGTH = "Content-Length";
    protected static final String CONTENT_MD5 = "Content-MD5";
    protected static final String CONTENT_TYPE = "Content-Type";
    protected Integer connectTimeout;
    protected String encoding;
    protected Map<String, String> headers;
    protected byte[] httpContent;
    protected FormatType httpContentType;
    private MethodType method;
    protected Integer readTimeout;
    private String url;

    public HttpMessage(String str) {
        this.httpContentType = null;
        this.httpContent = null;
        this.encoding = null;
        this.headers = new HashMap();
        this.connectTimeout = null;
        this.readTimeout = null;
        this.method = null;
        this.url = str;
    }

    public static String md5Sum(byte[] bArr) {
        try {
            return Base64Helper.encode(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Exception e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }

    public String getHeaderValue(String str) {
        return this.headers.get(str);
    }

    public byte[] getHttpContent() {
        return this.httpContent;
    }

    public String getHttpContentString() {
        byte[] bArr = this.httpContent;
        if (bArr == null) {
            return "";
        }
        try {
            String str = this.encoding;
            return str == null ? new String(bArr) : new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw new CredentialException("Can not parse response due to unsupported encoding: " + e.getMessage(), e);
        }
    }

    public FormatType getHttpContentType() {
        return this.httpContentType;
    }

    public Integer getSysConnectTimeout() {
        return this.connectTimeout;
    }

    public String getSysEncoding() {
        return this.encoding;
    }

    public Map<String, String> getSysHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    public MethodType getSysMethod() {
        return this.method;
    }

    public Integer getSysReadTimeout() {
        return this.readTimeout;
    }

    public String getSysUrl() {
        return this.url;
    }

    public void putHeaderParameter(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.headers.put(str, str2);
    }

    public void setHttpContent(byte[] bArr, String str, FormatType formatType) {
        if (bArr == null) {
            this.headers.remove("Content-MD5");
            this.headers.put("Content-Length", "0");
            this.headers.remove("Content-Type");
            this.httpContentType = null;
            this.httpContent = null;
            this.encoding = null;
            return;
        }
        if (getSysMethod() != null && !getSysMethod().hasContent()) {
            bArr = new byte[0];
        }
        this.httpContent = bArr;
        this.encoding = str;
        String strValueOf = String.valueOf(bArr.length);
        this.headers.put("Content-MD5", md5Sum(bArr));
        this.headers.put("Content-Length", strValueOf);
        if (formatType != null) {
            this.headers.put("Content-Type", FormatType.mapFormatToAccept(formatType));
        }
    }

    public void setHttpContentType(FormatType formatType) {
        this.httpContentType = formatType;
    }

    public void setSysConnectTimeout(Integer num) {
        this.connectTimeout = num;
    }

    public void setSysEncoding(String str) {
        this.encoding = str;
    }

    public void setSysMethod(MethodType methodType) {
        this.method = methodType;
        if (MethodType.PUT == methodType) {
            setHttpContentType(FormatType.JSON);
        }
    }

    public void setSysReadTimeout(Integer num) {
        this.readTimeout = num;
    }

    public void setSysUrl(String str) {
        this.url = str;
    }

    public HttpMessage() {
        this.httpContentType = null;
        this.httpContent = null;
        this.encoding = null;
        this.headers = new HashMap();
        this.connectTimeout = null;
        this.readTimeout = null;
        this.url = null;
        this.method = null;
    }
}
