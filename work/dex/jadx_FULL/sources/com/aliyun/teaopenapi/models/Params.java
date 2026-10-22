package com.aliyun.teaopenapi.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Params extends TeaModel {

    @NameInMap("action")
    @Validation(required = true)
    public String action;

    @NameInMap("authType")
    @Validation(required = true)
    public String authType;

    @NameInMap("bodyType")
    @Validation(required = true)
    public String bodyType;

    @NameInMap("method")
    @Validation(required = true)
    public String method;

    @NameInMap("pathname")
    @Validation(required = true)
    public String pathname;

    @NameInMap("protocol")
    @Validation(required = true)
    public String protocol;

    @NameInMap("reqBodyType")
    @Validation(required = true)
    public String reqBodyType;

    @NameInMap("style")
    public String style;

    @NameInMap("version")
    @Validation(required = true)
    public String version;

    public static Params build(Map<String, ?> map) throws Exception {
        return (Params) TeaModel.build(map, new Params());
    }

    public String getAction() {
        return this.action;
    }

    public String getAuthType() {
        return this.authType;
    }

    public String getBodyType() {
        return this.bodyType;
    }

    public String getMethod() {
        return this.method;
    }

    public String getPathname() {
        return this.pathname;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getReqBodyType() {
        return this.reqBodyType;
    }

    public String getStyle() {
        return this.style;
    }

    public String getVersion() {
        return this.version;
    }

    public Params setAction(String str) {
        this.action = str;
        return this;
    }

    public Params setAuthType(String str) {
        this.authType = str;
        return this;
    }

    public Params setBodyType(String str) {
        this.bodyType = str;
        return this;
    }

    public Params setMethod(String str) {
        this.method = str;
        return this;
    }

    public Params setPathname(String str) {
        this.pathname = str;
        return this;
    }

    public Params setProtocol(String str) {
        this.protocol = str;
        return this;
    }

    public Params setReqBodyType(String str) {
        this.reqBodyType = str;
        return this;
    }

    public Params setStyle(String str) {
        this.style = str;
        return this;
    }

    public Params setVersion(String str) {
        this.version = str;
        return this;
    }
}
