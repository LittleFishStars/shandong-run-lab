package com.aliyun.credentials.http;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.credentials.utils.ParameterHelper;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpRequest extends HttpMessage {
    private Map<String, String> immutableMap;

    public HttpRequest() {
        this.immutableMap = new HashMap();
        setCommonParameter();
    }

    private void setCommonParameter() {
        this.immutableMap.put("Timestamp", ParameterHelper.getISO8601Time(new Date()));
        this.immutableMap.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_NONCE, ParameterHelper.getUniqueNonce());
        this.immutableMap.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_METHOD, "HMAC-SHA1");
        this.immutableMap.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_VERSION, "1.0");
    }

    public String getUrlParameter(String str) {
        return this.immutableMap.get(str);
    }

    public Map<String, String> getUrlParameters() {
        return Collections.unmodifiableMap(this.immutableMap);
    }

    public void setUrlParameter(String str, String str2) {
        this.immutableMap.put(str, str2);
    }

    public HttpRequest(String str) {
        super(str);
        this.immutableMap = new HashMap();
        setCommonParameter();
    }
}
