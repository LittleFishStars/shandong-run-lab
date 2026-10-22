package com.aliyun.gateway.spi.models;

import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.aliyun.credentials.Client;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InterceptorContext extends TeaModel {

    @NameInMap("configuration")
    @Validation(required = true)
    public InterceptorContextConfiguration configuration;

    @NameInMap("request")
    @Validation(required = true)
    public InterceptorContextRequest request;

    @NameInMap(ConnectionLog.CONN_LOG_STATE_RESPONSE)
    @Validation(required = true)
    public InterceptorContextResponse response;

    public static class InterceptorContextConfiguration extends TeaModel {

        @NameInMap("endpoint")
        public String endpoint;

        @NameInMap("endpointMap")
        public Map<String, String> endpointMap;

        @NameInMap("endpointRule")
        public String endpointRule;

        @NameInMap("endpointType")
        public String endpointType;

        @NameInMap("network")
        public String network;

        @NameInMap("regionId")
        @Validation(required = true)
        public String regionId;

        @NameInMap("suffix")
        public String suffix;

        public static InterceptorContextConfiguration build(Map<String, ?> map) {
            return (InterceptorContextConfiguration) TeaModel.build(map, new InterceptorContextConfiguration());
        }

        public String getEndpoint() {
            return this.endpoint;
        }

        public Map<String, String> getEndpointMap() {
            return this.endpointMap;
        }

        public String getEndpointRule() {
            return this.endpointRule;
        }

        public String getEndpointType() {
            return this.endpointType;
        }

        public String getNetwork() {
            return this.network;
        }

        public String getRegionId() {
            return this.regionId;
        }

        public String getSuffix() {
            return this.suffix;
        }

        public InterceptorContextConfiguration setEndpoint(String str) {
            this.endpoint = str;
            return this;
        }

        public InterceptorContextConfiguration setEndpointMap(Map<String, String> map) {
            this.endpointMap = map;
            return this;
        }

        public InterceptorContextConfiguration setEndpointRule(String str) {
            this.endpointRule = str;
            return this;
        }

        public InterceptorContextConfiguration setEndpointType(String str) {
            this.endpointType = str;
            return this;
        }

        public InterceptorContextConfiguration setNetwork(String str) {
            this.network = str;
            return this;
        }

        public InterceptorContextConfiguration setRegionId(String str) {
            this.regionId = str;
            return this;
        }

        public InterceptorContextConfiguration setSuffix(String str) {
            this.suffix = str;
            return this;
        }
    }

    public static class InterceptorContextRequest extends TeaModel {

        @NameInMap("action")
        @Validation(required = true)
        public String action;

        @NameInMap("authType")
        @Validation(required = true)
        public String authType;

        @NameInMap("body")
        public Object body;

        @NameInMap("bodyType")
        @Validation(required = true)
        public String bodyType;

        @NameInMap("credential")
        @Validation(required = true)
        public Client credential;

        @NameInMap("headers")
        public Map<String, String> headers;

        @NameInMap("hostMap")
        public Map<String, String> hostMap;

        @NameInMap("method")
        @Validation(required = true)
        public String method;

        @NameInMap("pathname")
        @Validation(required = true)
        public String pathname;

        @NameInMap("productId")
        @Validation(required = true)
        public String productId;

        @NameInMap("protocol")
        @Validation(required = true)
        public String protocol;

        @NameInMap("query")
        public Map<String, String> query;

        @NameInMap("reqBodyType")
        @Validation(required = true)
        public String reqBodyType;

        @NameInMap("signatureAlgorithm")
        public String signatureAlgorithm;

        @NameInMap("signatureVersion")
        public String signatureVersion;

        @NameInMap("stream")
        public InputStream stream;

        @NameInMap("style")
        public String style;

        @NameInMap(TRiverConstants.KEY_ENVIRONMENT_USERAGENT)
        @Validation(required = true)
        public String userAgent;

        @NameInMap("version")
        @Validation(required = true)
        public String version;

        public static InterceptorContextRequest build(Map<String, ?> map) {
            return (InterceptorContextRequest) TeaModel.build(map, new InterceptorContextRequest());
        }

        public String getAction() {
            return this.action;
        }

        public String getAuthType() {
            return this.authType;
        }

        public Object getBody() {
            return this.body;
        }

        public String getBodyType() {
            return this.bodyType;
        }

        public Client getCredential() {
            return this.credential;
        }

        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public Map<String, String> getHostMap() {
            return this.hostMap;
        }

        public String getMethod() {
            return this.method;
        }

        public String getPathname() {
            return this.pathname;
        }

        public String getProductId() {
            return this.productId;
        }

        public String getProtocol() {
            return this.protocol;
        }

        public Map<String, String> getQuery() {
            return this.query;
        }

        public String getReqBodyType() {
            return this.reqBodyType;
        }

        public String getSignatureAlgorithm() {
            return this.signatureAlgorithm;
        }

        public String getSignatureVersion() {
            return this.signatureVersion;
        }

        public InputStream getStream() {
            return this.stream;
        }

        public String getStyle() {
            return this.style;
        }

        public String getUserAgent() {
            return this.userAgent;
        }

        public String getVersion() {
            return this.version;
        }

        public InterceptorContextRequest setAction(String str) {
            this.action = str;
            return this;
        }

        public InterceptorContextRequest setAuthType(String str) {
            this.authType = str;
            return this;
        }

        public InterceptorContextRequest setBody(Object obj) {
            this.body = obj;
            return this;
        }

        public InterceptorContextRequest setBodyType(String str) {
            this.bodyType = str;
            return this;
        }

        public InterceptorContextRequest setCredential(Client client) {
            this.credential = client;
            return this;
        }

        public InterceptorContextRequest setHeaders(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public InterceptorContextRequest setHostMap(Map<String, String> map) {
            this.hostMap = map;
            return this;
        }

        public InterceptorContextRequest setMethod(String str) {
            this.method = str;
            return this;
        }

        public InterceptorContextRequest setPathname(String str) {
            this.pathname = str;
            return this;
        }

        public InterceptorContextRequest setProductId(String str) {
            this.productId = str;
            return this;
        }

        public InterceptorContextRequest setProtocol(String str) {
            this.protocol = str;
            return this;
        }

        public InterceptorContextRequest setQuery(Map<String, String> map) {
            this.query = map;
            return this;
        }

        public InterceptorContextRequest setReqBodyType(String str) {
            this.reqBodyType = str;
            return this;
        }

        public InterceptorContextRequest setSignatureAlgorithm(String str) {
            this.signatureAlgorithm = str;
            return this;
        }

        public InterceptorContextRequest setSignatureVersion(String str) {
            this.signatureVersion = str;
            return this;
        }

        public InterceptorContextRequest setStream(InputStream inputStream) {
            this.stream = inputStream;
            return this;
        }

        public InterceptorContextRequest setStyle(String str) {
            this.style = str;
            return this;
        }

        public InterceptorContextRequest setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public InterceptorContextRequest setVersion(String str) {
            this.version = str;
            return this;
        }
    }

    public static class InterceptorContextResponse extends TeaModel {

        @NameInMap("body")
        public InputStream body;

        @NameInMap("deserializedBody")
        public Object deserializedBody;

        @NameInMap("headers")
        public Map<String, String> headers;

        @NameInMap("statusCode")
        public Number statusCode;

        public static InterceptorContextResponse build(Map<String, ?> map) {
            return (InterceptorContextResponse) TeaModel.build(map, new InterceptorContextResponse());
        }

        public InputStream getBody() {
            return this.body;
        }

        public Object getDeserializedBody() {
            return this.deserializedBody;
        }

        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public Number getStatusCode() {
            return this.statusCode;
        }

        public InterceptorContextResponse setBody(InputStream inputStream) {
            this.body = inputStream;
            return this;
        }

        public InterceptorContextResponse setDeserializedBody(Object obj) {
            this.deserializedBody = obj;
            return this;
        }

        public InterceptorContextResponse setHeaders(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public InterceptorContextResponse setStatusCode(Number number) {
            this.statusCode = number;
            return this;
        }
    }

    public static InterceptorContext build(Map<String, ?> map) {
        return (InterceptorContext) TeaModel.build(map, new InterceptorContext());
    }

    public InterceptorContextConfiguration getConfiguration() {
        return this.configuration;
    }

    public InterceptorContextRequest getRequest() {
        return this.request;
    }

    public InterceptorContextResponse getResponse() {
        return this.response;
    }

    public InterceptorContext setConfiguration(InterceptorContextConfiguration interceptorContextConfiguration) {
        this.configuration = interceptorContextConfiguration;
        return this;
    }

    public InterceptorContext setRequest(InterceptorContextRequest interceptorContextRequest) {
        this.request = interceptorContextRequest;
        return this;
    }

    public InterceptorContext setResponse(InterceptorContextResponse interceptorContextResponse) {
        this.response = interceptorContextResponse;
        return this;
    }
}
