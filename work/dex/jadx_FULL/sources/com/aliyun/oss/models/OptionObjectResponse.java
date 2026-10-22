package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OptionObjectResponse extends TeaModel {

    @NameInMap("access-control-allow-headers")
    @Validation(required = true)
    public String accessControlAllowHeaders;

    @NameInMap("access-control-allow-methods")
    @Validation(required = true)
    public String accessControlAllowMethods;

    @NameInMap("access-control-allow-origin")
    @Validation(required = true)
    public String accessControlAllowOrigin;

    @NameInMap("access-control-expose-headers")
    @Validation(required = true)
    public String accessControlExposeHeaders;

    @NameInMap("access-control-max-age")
    @Validation(required = true)
    public String accessControlMaxAge;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static OptionObjectResponse build(Map<String, ?> map) throws Exception {
        return (OptionObjectResponse) TeaModel.build(map, new OptionObjectResponse());
    }

    public String getAccessControlAllowHeaders() {
        return this.accessControlAllowHeaders;
    }

    public String getAccessControlAllowMethods() {
        return this.accessControlAllowMethods;
    }

    public String getAccessControlAllowOrigin() {
        return this.accessControlAllowOrigin;
    }

    public String getAccessControlExposeHeaders() {
        return this.accessControlExposeHeaders;
    }

    public String getAccessControlMaxAge() {
        return this.accessControlMaxAge;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public OptionObjectResponse setAccessControlAllowHeaders(String str) {
        this.accessControlAllowHeaders = str;
        return this;
    }

    public OptionObjectResponse setAccessControlAllowMethods(String str) {
        this.accessControlAllowMethods = str;
        return this;
    }

    public OptionObjectResponse setAccessControlAllowOrigin(String str) {
        this.accessControlAllowOrigin = str;
        return this;
    }

    public OptionObjectResponse setAccessControlExposeHeaders(String str) {
        this.accessControlExposeHeaders = str;
        return this;
    }

    public OptionObjectResponse setAccessControlMaxAge(String str) {
        this.accessControlMaxAge = str;
        return this;
    }

    public OptionObjectResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
