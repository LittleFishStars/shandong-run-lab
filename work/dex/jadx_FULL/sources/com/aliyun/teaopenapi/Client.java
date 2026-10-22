package com.aliyun.teaopenapi;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.alipay.sdk.m.n.c;
import com.alipay.sdk.m.t.e;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.gateway.spi.models.AttributeMap;
import com.aliyun.gateway.spi.models.InterceptorContext;
import com.aliyun.tea.Tea;
import com.aliyun.tea.TeaConverter;
import com.aliyun.tea.TeaException;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.TeaPair;
import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.TeaResponse;
import com.aliyun.tea.TeaUnretryableException;
import com.aliyun.tea.interceptor.InterceptorChain;
import com.aliyun.tea.interceptor.RequestInterceptor;
import com.aliyun.tea.interceptor.ResponseInterceptor;
import com.aliyun.tea.interceptor.RuntimeOptionsInterceptor;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teaopenapi.models.GlobalParameters;
import com.aliyun.teaopenapi.models.OpenApiRequest;
import com.aliyun.teaopenapi.models.Params;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.u15;
import com.zj.adlib.ze1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Client {
    private static final InterceptorChain interceptorChain = InterceptorChain.create();
    public String _ca;
    public String _cert;
    public Integer _connectTimeout;
    public com.aliyun.credentials.Client _credential;
    public Boolean _disableHttp2;
    public String _endpoint;
    public Map<String, String> _endpointMap;
    public String _endpointRule;
    public String _endpointType;
    public GlobalParameters _globalParameters;
    public Map<String, String> _headers;
    public String _httpProxy;
    public String _httpsProxy;
    public String _key;
    public Integer _maxIdleConns;
    public String _method;
    public String _network;
    public String _noProxy;
    public String _openPlatformEndpoint;
    public String _productId;
    public String _protocol;
    public Integer _readTimeout;
    public String _regionId;
    public String _signatureAlgorithm;
    public String _signatureVersion;
    public String _socks5NetWork;
    public String _socks5Proxy;
    public com.aliyun.gateway.spi.Client _spi;
    public String _suffix;
    public String _userAgent;

    public Client(Config config) throws Exception {
        if (Common.isUnset(config)) {
            throw new TeaException(TeaConverter.buildMap(new TeaPair("code", "ParameterMissing"), new TeaPair("message", "'config' can not be unset")));
        }
        if (!Common.empty(config.accessKeyId) && !Common.empty(config.accessKeySecret)) {
            if (Common.empty(config.securityToken)) {
                config.type = AuthConstant.ACCESS_KEY;
            } else {
                config.type = AuthConstant.STS;
            }
            com.aliyun.credentials.models.Config configBuild = com.aliyun.credentials.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", config.accessKeyId), new TeaPair("type", config.type), new TeaPair("accessKeySecret", config.accessKeySecret)));
            configBuild.securityToken = config.securityToken;
            this._credential = new com.aliyun.credentials.Client(configBuild);
        } else if (!Common.isUnset(config.credential)) {
            this._credential = config.credential;
        }
        this._endpoint = config.endpoint;
        this._endpointType = config.endpointType;
        this._network = config.network;
        this._suffix = config.suffix;
        this._protocol = config.protocol;
        this._method = config.method;
        this._regionId = config.regionId;
        this._userAgent = config.userAgent;
        this._readTimeout = config.readTimeout;
        this._connectTimeout = config.connectTimeout;
        this._httpProxy = config.httpProxy;
        this._httpsProxy = config.httpsProxy;
        this._noProxy = config.noProxy;
        this._socks5Proxy = config.socks5Proxy;
        this._socks5NetWork = config.socks5NetWork;
        this._maxIdleConns = config.maxIdleConns;
        this._signatureVersion = config.signatureVersion;
        this._signatureAlgorithm = config.signatureAlgorithm;
        this._globalParameters = config.globalParameters;
        this._key = config.key;
        this._cert = config.cert;
        this._ca = config.ca;
        this._disableHttp2 = config.disableHttp2;
    }

    public static Object defaultAny(Object obj, Object obj2) throws Exception {
        return Common.isUnset(obj) ? obj2 : obj;
    }

    public void addRequestInterceptor(RequestInterceptor requestInterceptor) {
        interceptorChain.addRequestInterceptor(requestInterceptor);
    }

    public void addResponseInterceptor(ResponseInterceptor responseInterceptor) {
        interceptorChain.addResponseInterceptor(responseInterceptor);
    }

    public void addRuntimeOptionsInterceptor(RuntimeOptionsInterceptor runtimeOptionsInterceptor) {
        interceptorChain.addRuntimeOptionsInterceptor(runtimeOptionsInterceptor);
    }

    public Map<String, ?> callApi(Params params, OpenApiRequest openApiRequest, RuntimeOptions runtimeOptions) throws Exception {
        if (Common.isUnset(params)) {
            throw new TeaException(TeaConverter.buildMap(new TeaPair("code", "ParameterMissing"), new TeaPair("message", "'params' can not be unset")));
        }
        if (Common.isUnset(this._signatureAlgorithm) || !Common.equalString(this._signatureAlgorithm, "v2")) {
            return doRequest(params, openApiRequest, runtimeOptions);
        }
        if (Common.equalString(params.style, "ROA") && Common.equalString(params.reqBodyType, "json")) {
            return doROARequest(params.action, params.version, params.protocol, params.method, params.authType, params.pathname, params.bodyType, openApiRequest, runtimeOptions);
        }
        return Common.equalString(params.style, "ROA") ? doROARequestWithForm(params.action, params.version, params.protocol, params.method, params.authType, params.pathname, params.bodyType, openApiRequest, runtimeOptions) : doRPCRequest(params.action, params.version, params.protocol, params.method, params.authType, params.bodyType, openApiRequest, runtimeOptions);
    }

    public void checkConfig(Config config) throws Exception {
        if (Common.empty(this._endpointRule) && Common.empty(config.endpoint)) {
            throw new TeaException(TeaConverter.buildMap(new TeaPair("code", "ParameterMissing"), new TeaPair("message", "'config.endpoint' can not be empty")));
        }
    }

    /* JADX WARN: Code duplicated, block: B:113:0x03aa A[Catch: Exception -> 0x0348, TryCatch #25 {Exception -> 0x0348, blocks: (B:81:0x0339, B:91:0x035f, B:93:0x036b, B:98:0x0378, B:101:0x038c, B:104:0x039a, B:113:0x03aa, B:115:0x03b2, B:118:0x03bb, B:121:0x03cd, B:124:0x03db, B:128:0x03e3, B:130:0x03eb, B:133:0x03f4, B:136:0x0406, B:139:0x0414, B:141:0x0419, B:143:0x0421, B:146:0x042e, B:149:0x0440, B:152:0x044e, B:154:0x0453, B:156:0x045b, B:159:0x0464, B:162:0x0476, B:165:0x0484, B:169:0x048c, B:172:0x04a4), top: B:295:0x035f }] */
    /* JADX WARN: Code duplicated, block: B:128:0x03e3 A[Catch: Exception -> 0x0348, TryCatch #25 {Exception -> 0x0348, blocks: (B:81:0x0339, B:91:0x035f, B:93:0x036b, B:98:0x0378, B:101:0x038c, B:104:0x039a, B:113:0x03aa, B:115:0x03b2, B:118:0x03bb, B:121:0x03cd, B:124:0x03db, B:128:0x03e3, B:130:0x03eb, B:133:0x03f4, B:136:0x0406, B:139:0x0414, B:141:0x0419, B:143:0x0421, B:146:0x042e, B:149:0x0440, B:152:0x044e, B:154:0x0453, B:156:0x045b, B:159:0x0464, B:162:0x0476, B:165:0x0484, B:169:0x048c, B:172:0x04a4), top: B:295:0x035f }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0419 A[Catch: Exception -> 0x0348, TryCatch #25 {Exception -> 0x0348, blocks: (B:81:0x0339, B:91:0x035f, B:93:0x036b, B:98:0x0378, B:101:0x038c, B:104:0x039a, B:113:0x03aa, B:115:0x03b2, B:118:0x03bb, B:121:0x03cd, B:124:0x03db, B:128:0x03e3, B:130:0x03eb, B:133:0x03f4, B:136:0x0406, B:139:0x0414, B:141:0x0419, B:143:0x0421, B:146:0x042e, B:149:0x0440, B:152:0x044e, B:154:0x0453, B:156:0x045b, B:159:0x0464, B:162:0x0476, B:165:0x0484, B:169:0x048c, B:172:0x04a4), top: B:295:0x035f }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0453 A[Catch: Exception -> 0x0348, TryCatch #25 {Exception -> 0x0348, blocks: (B:81:0x0339, B:91:0x035f, B:93:0x036b, B:98:0x0378, B:101:0x038c, B:104:0x039a, B:113:0x03aa, B:115:0x03b2, B:118:0x03bb, B:121:0x03cd, B:124:0x03db, B:128:0x03e3, B:130:0x03eb, B:133:0x03f4, B:136:0x0406, B:139:0x0414, B:141:0x0419, B:143:0x0421, B:146:0x042e, B:149:0x0440, B:152:0x044e, B:154:0x0453, B:156:0x045b, B:159:0x0464, B:162:0x0476, B:165:0x0484, B:169:0x048c, B:172:0x04a4), top: B:295:0x035f }] */
    /* JADX WARN: Code duplicated, block: B:167:0x0489  */
    /* JADX WARN: Code duplicated, block: B:245:0x063d A[LOOP:0: B:3:0x0172->B:245:0x063d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:295:0x035f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:0x03b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:304:0x03eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x0421 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:306:0x045b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:309:0x0651 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x02c9 A[Catch: Exception -> 0x05b5, TRY_ENTER, TryCatch #4 {Exception -> 0x05b5, blocks: (B:63:0x02c1, B:66:0x02c9, B:68:0x02db, B:69:0x02e9), top: B:257:0x02c1 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x02db A[Catch: Exception -> 0x05b5, TryCatch #4 {Exception -> 0x05b5, blocks: (B:63:0x02c1, B:66:0x02c9, B:68:0x02db, B:69:0x02e9), top: B:257:0x02c1 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x031a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0336  */
    /* JADX WARN: Code duplicated, block: B:88:0x0351 A[Catch: Exception -> 0x05ab, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x05ab, blocks: (B:76:0x031c, B:88:0x0351, B:177:0x04ae), top: B:249:0x031c }] */
    /* JADX WARN: Code duplicated, block: B:93:0x036b A[Catch: Exception -> 0x0348, TRY_LEAVE, TryCatch #25 {Exception -> 0x0348, blocks: (B:81:0x0339, B:91:0x035f, B:93:0x036b, B:98:0x0378, B:101:0x038c, B:104:0x039a, B:113:0x03aa, B:115:0x03b2, B:118:0x03bb, B:121:0x03cd, B:124:0x03db, B:128:0x03e3, B:130:0x03eb, B:133:0x03f4, B:136:0x0406, B:139:0x0414, B:141:0x0419, B:143:0x0421, B:146:0x042e, B:149:0x0440, B:152:0x044e, B:154:0x0453, B:156:0x045b, B:159:0x0464, B:162:0x0476, B:165:0x0484, B:169:0x048c, B:172:0x04a4), top: B:295:0x035f }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0375  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v47 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public Map<String, ?> doROARequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, OpenApiRequest openApiRequest, RuntimeOptions runtimeOptions) throws Exception {
        int i;
        long j;
        ?? r11;
        TeaResponse teaResponseDoAction;
        String accessKeyId;
        String securityToken;
        int backoffTime;
        Client client = this;
        OpenApiRequest openApiRequest2 = openApiRequest;
        Class<String> cls = String.class;
        TeaModel.validateParams(openApiRequest2, "request");
        String str8 = "retry";
        String str9 = "accessDeniedDetail";
        String str10 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair(CachedContentIndex.a.e, Common.defaultString(runtimeOptions.key, client._key)), new TeaPair("cert", Common.defaultString(runtimeOptions.cert, client._cert)), new TeaPair("ca", Common.defaultString(runtimeOptions.ca, client._ca)), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, client._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, client._connectTimeout)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, client._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, client._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, client._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, client._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, client._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, client._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", runtimeOptions.autoretry), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", runtimeOptions.ignoreSSL));
        long jCurrentTimeMillis = System.currentTimeMillis();
        Exception e = null;
        TeaRequest teaRequest = null;
        for (int i2 = 0; Tea.allowRetry((Map) mapBuildMap.get(str8), i2, jCurrentTimeMillis); i2 = i) {
            if (i2 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str10), i2)) > 0) {
                Tea.sleep(backoffTime);
            }
            i = i2 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                j = jCurrentTimeMillis;
                try {
                    teaRequest2.protocol = Common.defaultString(client._protocol, str3);
                    teaRequest2.method = str4;
                    teaRequest2.pathname = str6;
                    HashMap map = new HashMap();
                    Map<String, String> map2 = new HashMap<>();
                    Map<String, String> map3 = map;
                    if (!Common.isUnset(client._globalParameters)) {
                        GlobalParameters globalParameters = client._globalParameters;
                        if (!Common.isUnset(globalParameters.queries)) {
                            map3 = globalParameters.queries;
                        }
                        if (!Common.isUnset(globalParameters.headers)) {
                            map2 = globalParameters.headers;
                        }
                    }
                    Map<String, String> map4 = map3;
                    try {
                        Map[] mapArr = new Map[3];
                        str10 = str10;
                        try {
                            TeaPair[] teaPairArr = new TeaPair[9];
                            str8 = str8;
                            i = i;
                            try {
                                teaPairArr[0] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[1] = new TeaPair(c.f, client._endpoint);
                                    try {
                                        teaPairArr[2] = new TeaPair(SubscribeResouceItemModel.ACCEPT, ze1.g);
                                        try {
                                            teaPairArr[3] = new TeaPair("x-acs-signature-nonce", Common.getNonce());
                                            try {
                                                teaPairArr[4] = new TeaPair("x-acs-signature-method", "HMAC-SHA1");
                                                teaPairArr[5] = new TeaPair("x-acs-signature-version", "1.0");
                                                teaPairArr[6] = new TeaPair("x-acs-version", str2);
                                                teaPairArr[7] = new TeaPair("x-acs-action", str);
                                                teaPairArr[8] = new TeaPair("user-agent", Common.getUserAgent(client._userAgent));
                                                mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                try {
                                                    mapArr[1] = map2;
                                                    ?? r12 = 2;
                                                    try {
                                                        mapArr[2] = openApiRequest2.headers;
                                                        teaRequest2.headers = TeaConverter.merge((Class) cls, (Map<String, ?>[]) mapArr);
                                                        if (!Common.isUnset(openApiRequest2.body)) {
                                                            teaRequest2.body = Tea.toReadable(Common.toJSONString(openApiRequest2.body));
                                                            teaRequest2.headers.put(e.f, "application/json; charset=utf-8");
                                                            r12 = "application/json; charset=utf-8";
                                                        }
                                                        teaRequest2.query = map4;
                                                        if (Common.isUnset(openApiRequest2.query)) {
                                                            if (Common.equalString(str5, "Anonymous")) {
                                                                cls = cls;
                                                                r11 = r12;
                                                            } else {
                                                                accessKeyId = getAccessKeyId();
                                                                String accessKeySecret = getAccessKeySecret();
                                                                securityToken = getSecurityToken();
                                                                if (!Common.empty(securityToken)) {
                                                                    teaRequest2.headers.put("x-acs-accesskey-id", accessKeyId);
                                                                    teaRequest2.headers.put("x-acs-security-token", securityToken);
                                                                }
                                                                String stringToSign = com.aliyun.openapiutil.Client.getStringToSign(teaRequest2);
                                                                Map<String, String> map5 = teaRequest2.headers;
                                                                StringBuilder sb = new StringBuilder();
                                                                cls = cls;
                                                                sb.append("acs ");
                                                                sb.append(accessKeyId);
                                                                sb.append(u15.f19942b);
                                                                sb.append(com.aliyun.openapiutil.Client.getROASignature(stringToSign, accessKeySecret));
                                                                sb.append("");
                                                                map5.put("authorization", sb.toString());
                                                                r11 = accessKeySecret;
                                                            }
                                                            teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap, interceptorChain);
                                                            if (Common.equalNumber(Integer.valueOf(teaResponseDoAction.statusCode), 204)) {
                                                                TeaPair[] teaPairArr2 = new TeaPair[1];
                                                                teaPairArr2[0] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                return TeaConverter.buildMap(teaPairArr2);
                                                            }
                                                            if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    if (Common.equalString(str7, "binary")) {
                                                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                        teaPairArr3[0] = new TeaPair("body", teaResponseDoAction.body);
                                                                        teaPairArr3[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                        teaPairArr3[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                        return TeaConverter.buildMap(teaPairArr3);
                                                                    }
                                                                    if (Common.equalString(str7, "byte")) {
                                                                        TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                        teaPairArr4[0] = new TeaPair("body", Common.readAsBytes(teaResponseDoAction.body));
                                                                        teaPairArr4[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                        teaPairArr4[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                        return TeaConverter.buildMap(teaPairArr4);
                                                                    }
                                                                    if (Common.equalString(str7, TypedValues.Custom.S_STRING)) {
                                                                        TeaPair[] teaPairArr5 = new TeaPair[3];
                                                                        teaPairArr5[0] = new TeaPair("body", Common.readAsString(teaResponseDoAction.body));
                                                                        teaPairArr5[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                        teaPairArr5[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                        return TeaConverter.buildMap(teaPairArr5);
                                                                    }
                                                                    if (Common.equalString(str7, "json")) {
                                                                        TeaPair[] teaPairArr6 = new TeaPair[3];
                                                                        teaPairArr6[0] = new TeaPair("body", Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body)));
                                                                        teaPairArr6[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                        teaPairArr6[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                        return TeaConverter.buildMap(teaPairArr6);
                                                                    }
                                                                    if (!Common.equalString(str7, "array")) {
                                                                        TeaPair[] teaPairArr7 = new TeaPair[2];
                                                                        teaPairArr7[0] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                        teaPairArr7[1] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                        return TeaConverter.buildMap(teaPairArr7);
                                                                    }
                                                                    TeaPair[] teaPairArr8 = new TeaPair[3];
                                                                    teaPairArr8[0] = new TeaPair("body", Common.readAsJSON(teaResponseDoAction.body));
                                                                    teaPairArr8[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                    teaPairArr8[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                    return TeaConverter.buildMap(teaPairArr8);
                                                                    teaRequest = teaRequest2;
                                                                    str9 = str9;
                                                                }
                                                            }
                                                            Map<String, Object> mapAssertAsMap = Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body));
                                                            Object objDefaultAny = defaultAny(defaultAny(mapAssertAsMap.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID), mapAssertAsMap.get("requestId")), mapAssertAsMap.get("requestid"));
                                                            mapAssertAsMap.put("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                            TeaPair[] teaPairArr9 = new TeaPair[5];
                                                            teaPairArr9[0] = new TeaPair("code", "" + defaultAny(mapAssertAsMap.get("Code"), mapAssertAsMap.get("code")) + "");
                                                            teaPairArr9[1] = new TeaPair("message", "code: " + teaResponseDoAction.statusCode + ", " + defaultAny(mapAssertAsMap.get("Message"), mapAssertAsMap.get("message")) + " request id: " + objDefaultAny + "");
                                                            teaPairArr9[2] = new TeaPair("data", mapAssertAsMap);
                                                            teaPairArr9[3] = new TeaPair("description", "" + defaultAny(mapAssertAsMap.get(AliyunVodKey.KEY_VOD_DESCRIPTION), mapAssertAsMap.get("description")) + "");
                                                            str9 = str9;
                                                            teaPairArr9[4] = new TeaPair(str9, defaultAny(mapAssertAsMap.get("AccessDeniedDetail"), mapAssertAsMap.get(str9)));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr9));
                                                            teaRequest = teaRequest2;
                                                            str9 = str9;
                                                        } else {
                                                            try {
                                                                Map[] mapArr2 = new Map[2];
                                                                mapArr2[0] = teaRequest2.query;
                                                                try {
                                                                    mapArr2[1] = openApiRequest2.query;
                                                                    teaRequest2.query = TeaConverter.merge((Class) cls, (Map<String, ?>[]) mapArr2);
                                                                    try {
                                                                        if (Common.equalString(str5, "Anonymous")) {
                                                                            accessKeyId = getAccessKeyId();
                                                                            String accessKeySecret2 = getAccessKeySecret();
                                                                            securityToken = getSecurityToken();
                                                                            if (!Common.empty(securityToken)) {
                                                                                teaRequest2.headers.put("x-acs-accesskey-id", accessKeyId);
                                                                                teaRequest2.headers.put("x-acs-security-token", securityToken);
                                                                            }
                                                                            String stringToSign2 = com.aliyun.openapiutil.Client.getStringToSign(teaRequest2);
                                                                            Map<String, String> map6 = teaRequest2.headers;
                                                                            StringBuilder sb2 = new StringBuilder();
                                                                            cls = cls;
                                                                            try {
                                                                                sb2.append("acs ");
                                                                                sb2.append(accessKeyId);
                                                                                sb2.append(u15.f19942b);
                                                                                sb2.append(com.aliyun.openapiutil.Client.getROASignature(stringToSign2, accessKeySecret2));
                                                                                sb2.append("");
                                                                                map6.put("authorization", sb2.toString());
                                                                                r11 = accessKeySecret2;
                                                                            } catch (Exception e2) {
                                                                                e = e2;
                                                                                if (!Tea.isRetryable(e)) {
                                                                                    throw e;
                                                                                }
                                                                                client = this;
                                                                                openApiRequest2 = openApiRequest;
                                                                                str9 = str9;
                                                                                str10 = str10;
                                                                                jCurrentTimeMillis = j;
                                                                                cls = cls;
                                                                                str8 = str8;
                                                                            }
                                                                        } else {
                                                                            cls = cls;
                                                                            r11 = r12;
                                                                        }
                                                                        try {
                                                                            teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap, interceptorChain);
                                                                            if (Common.equalNumber(Integer.valueOf(teaResponseDoAction.statusCode), 204)) {
                                                                                try {
                                                                                    TeaPair[] teaPairArr10 = new TeaPair[1];
                                                                                    teaPairArr10[0] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                    return TeaConverter.buildMap(teaPairArr10);
                                                                                } catch (Exception e3) {
                                                                                    e = e3;
                                                                                }
                                                                            } else {
                                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                                    try {
                                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                                            try {
                                                                                                try {
                                                                                                    if (Common.equalString(str7, "binary")) {
                                                                                                        try {
                                                                                                            TeaPair[] teaPairArr11 = new TeaPair[3];
                                                                                                            teaPairArr11[0] = new TeaPair("body", teaResponseDoAction.body);
                                                                                                            teaPairArr11[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                            teaPairArr11[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                            return TeaConverter.buildMap(teaPairArr11);
                                                                                                        } catch (Exception e4) {
                                                                                                            e = e4;
                                                                                                        }
                                                                                                    } else {
                                                                                                        try {
                                                                                                            if (Common.equalString(str7, "byte")) {
                                                                                                                TeaPair[] teaPairArr12 = new TeaPair[3];
                                                                                                                teaPairArr12[0] = new TeaPair("body", Common.readAsBytes(teaResponseDoAction.body));
                                                                                                                teaPairArr12[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                                teaPairArr12[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                                return TeaConverter.buildMap(teaPairArr12);
                                                                                                            }
                                                                                                            if (Common.equalString(str7, TypedValues.Custom.S_STRING)) {
                                                                                                                TeaPair[] teaPairArr13 = new TeaPair[3];
                                                                                                                teaPairArr13[0] = new TeaPair("body", Common.readAsString(teaResponseDoAction.body));
                                                                                                                teaPairArr13[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                                teaPairArr13[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                                return TeaConverter.buildMap(teaPairArr13);
                                                                                                            }
                                                                                                            if (Common.equalString(str7, "json")) {
                                                                                                                TeaPair[] teaPairArr14 = new TeaPair[3];
                                                                                                                teaPairArr14[0] = new TeaPair("body", Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body)));
                                                                                                                teaPairArr14[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                                teaPairArr14[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                                return TeaConverter.buildMap(teaPairArr14);
                                                                                                            }
                                                                                                            if (!Common.equalString(str7, "array")) {
                                                                                                                TeaPair[] teaPairArr15 = new TeaPair[3];
                                                                                                                teaPairArr15[0] = new TeaPair("body", Common.readAsJSON(teaResponseDoAction.body));
                                                                                                                teaPairArr15[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                                teaPairArr15[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                                return TeaConverter.buildMap(teaPairArr15);
                                                                                                            }
                                                                                                            try {
                                                                                                                TeaPair[] teaPairArr16 = new TeaPair[2];
                                                                                                                teaPairArr16[0] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                                teaPairArr16[1] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                                return TeaConverter.buildMap(teaPairArr16);
                                                                                                            } catch (Exception e5) {
                                                                                                                e = e5;
                                                                                                                teaRequest = teaRequest2;
                                                                                                                str9 = str9;
                                                                                                                if (!Tea.isRetryable(e)) {
                                                                                                                    throw e;
                                                                                                                }
                                                                                                                client = this;
                                                                                                                openApiRequest2 = openApiRequest;
                                                                                                                str9 = str9;
                                                                                                                str10 = str10;
                                                                                                                jCurrentTimeMillis = j;
                                                                                                                cls = cls;
                                                                                                                str8 = str8;
                                                                                                            }
                                                                                                        } catch (Exception e6) {
                                                                                                            e = e6;
                                                                                                        }
                                                                                                    }
                                                                                                    teaRequest = teaRequest2;
                                                                                                } catch (Exception e7) {
                                                                                                    e = e7;
                                                                                                }
                                                                                            } catch (Exception e8) {
                                                                                                e = e8;
                                                                                            }
                                                                                            str9 = str9;
                                                                                        }
                                                                                    } catch (Exception e9) {
                                                                                        e = e9;
                                                                                        teaRequest = teaRequest2;
                                                                                        if (!Tea.isRetryable(e)) {
                                                                                            throw e;
                                                                                        }
                                                                                        client = this;
                                                                                        openApiRequest2 = openApiRequest;
                                                                                        str9 = str9;
                                                                                        str10 = str10;
                                                                                        jCurrentTimeMillis = j;
                                                                                        cls = cls;
                                                                                        str8 = str8;
                                                                                    }
                                                                                }
                                                                                Map<String, Object> mapAssertAsMap2 = Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body));
                                                                                Object objDefaultAny2 = defaultAny(defaultAny(mapAssertAsMap2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID), mapAssertAsMap2.get("requestId")), mapAssertAsMap2.get("requestid"));
                                                                                mapAssertAsMap2.put("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                TeaPair[] teaPairArr17 = new TeaPair[5];
                                                                                teaPairArr17[0] = new TeaPair("code", "" + defaultAny(mapAssertAsMap2.get("Code"), mapAssertAsMap2.get("code")) + "");
                                                                                try {
                                                                                    teaPairArr17[1] = new TeaPair("message", "code: " + teaResponseDoAction.statusCode + ", " + defaultAny(mapAssertAsMap2.get("Message"), mapAssertAsMap2.get("message")) + " request id: " + objDefaultAny2 + "");
                                                                                    try {
                                                                                        teaPairArr17[2] = new TeaPair("data", mapAssertAsMap2);
                                                                                        try {
                                                                                            teaPairArr17[3] = new TeaPair("description", "" + defaultAny(mapAssertAsMap2.get(AliyunVodKey.KEY_VOD_DESCRIPTION), mapAssertAsMap2.get("description")) + "");
                                                                                            str9 = str9;
                                                                                            try {
                                                                                                try {
                                                                                                    teaPairArr17[4] = new TeaPair(str9, defaultAny(mapAssertAsMap2.get("AccessDeniedDetail"), mapAssertAsMap2.get(str9)));
                                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr17));
                                                                                                } catch (Exception e10) {
                                                                                                    e = e10;
                                                                                                    teaRequest = teaRequest2;
                                                                                                    if (!Tea.isRetryable(e)) {
                                                                                                        throw e;
                                                                                                    }
                                                                                                    client = this;
                                                                                                    openApiRequest2 = openApiRequest;
                                                                                                    str9 = str9;
                                                                                                    str10 = str10;
                                                                                                    jCurrentTimeMillis = j;
                                                                                                    cls = cls;
                                                                                                    str8 = str8;
                                                                                                }
                                                                                            } catch (Exception e11) {
                                                                                                e = e11;
                                                                                                teaRequest = teaRequest2;
                                                                                                if (!Tea.isRetryable(e)) {
                                                                                                    throw e;
                                                                                                }
                                                                                                client = this;
                                                                                                openApiRequest2 = openApiRequest;
                                                                                                str9 = str9;
                                                                                                str10 = str10;
                                                                                                jCurrentTimeMillis = j;
                                                                                                cls = cls;
                                                                                                str8 = str8;
                                                                                            }
                                                                                        } catch (Exception e12) {
                                                                                            e = e12;
                                                                                            str9 = str9;
                                                                                        }
                                                                                    } catch (Exception e13) {
                                                                                        e = e13;
                                                                                        str9 = str9;
                                                                                    }
                                                                                } catch (Exception e14) {
                                                                                    e = e14;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (!Tea.isRetryable(e)) {
                                                                                        throw e;
                                                                                    }
                                                                                    client = this;
                                                                                    openApiRequest2 = openApiRequest;
                                                                                    str9 = str9;
                                                                                    str10 = str10;
                                                                                    jCurrentTimeMillis = j;
                                                                                    cls = cls;
                                                                                    str8 = str8;
                                                                                }
                                                                            }
                                                                            teaRequest = teaRequest2;
                                                                        } catch (Exception e15) {
                                                                            e = e15;
                                                                        }
                                                                    } catch (Exception e16) {
                                                                        e = e16;
                                                                        cls = cls;
                                                                        if (!Tea.isRetryable(e)) {
                                                                            throw e;
                                                                        }
                                                                        client = this;
                                                                        openApiRequest2 = openApiRequest;
                                                                        str9 = str9;
                                                                        str10 = str10;
                                                                        jCurrentTimeMillis = j;
                                                                        cls = cls;
                                                                        str8 = str8;
                                                                    }
                                                                } catch (Exception e17) {
                                                                    e = e17;
                                                                    cls = cls;
                                                                }
                                                            } catch (Exception e18) {
                                                                e = e18;
                                                                cls = cls;
                                                                str9 = str9;
                                                            }
                                                            str9 = str9;
                                                        }
                                                    } catch (Exception e19) {
                                                        e = e19;
                                                        cls = cls;
                                                    }
                                                } catch (Exception e20) {
                                                    e = e20;
                                                    cls = cls;
                                                    str9 = str9;
                                                    if (!Tea.isRetryable(e)) {
                                                        throw e;
                                                    }
                                                    client = this;
                                                    openApiRequest2 = openApiRequest;
                                                    str9 = str9;
                                                    str10 = str10;
                                                    jCurrentTimeMillis = j;
                                                    cls = cls;
                                                    str8 = str8;
                                                }
                                            } catch (Exception e21) {
                                                e = e21;
                                                cls = cls;
                                            }
                                        } catch (Exception e22) {
                                            e = e22;
                                            cls = cls;
                                        }
                                    } catch (Exception e23) {
                                        e = e23;
                                        cls = cls;
                                    }
                                } catch (Exception e24) {
                                    e = e24;
                                    cls = cls;
                                }
                            } catch (Exception e25) {
                                e = e25;
                            }
                        } catch (Exception e26) {
                            e = e26;
                            str8 = str8;
                            i = i;
                            if (!Tea.isRetryable(e)) {
                                throw e;
                            }
                            client = this;
                            openApiRequest2 = openApiRequest;
                            str9 = str9;
                            str10 = str10;
                            jCurrentTimeMillis = j;
                            cls = cls;
                            str8 = str8;
                        }
                    } catch (Exception e27) {
                        e = e27;
                        if (!Tea.isRetryable(e)) {
                            throw e;
                        }
                        client = this;
                        openApiRequest2 = openApiRequest;
                        str9 = str9;
                        str10 = str10;
                        jCurrentTimeMillis = j;
                        cls = cls;
                        str8 = str8;
                    }
                } catch (Exception e28) {
                    e = e28;
                    str10 = str10;
                }
            } catch (Exception e29) {
                e = e29;
                j = jCurrentTimeMillis;
            }
            if (!Tea.isRetryable(e)) {
                throw e;
            }
            client = this;
            openApiRequest2 = openApiRequest;
            str9 = str9;
            str10 = str10;
            jCurrentTimeMillis = j;
            cls = cls;
            str8 = str8;
        }
        throw new TeaUnretryableException(teaRequest, e);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x03a8 A[Catch: Exception -> 0x0341, TRY_LEAVE, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x03d9 A[Catch: Exception -> 0x0341, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x03e1 A[Catch: Exception -> 0x0341, TRY_LEAVE, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x040f A[Catch: Exception -> 0x0341, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0417 A[Catch: Exception -> 0x0341, TRY_LEAVE, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0449 A[Catch: Exception -> 0x0341, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0451 A[Catch: Exception -> 0x0341, TRY_LEAVE, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x047f A[Catch: Exception -> 0x0341, TRY_LEAVE, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x0608 A[LOOP:0: B:3:0x0172->B:201:0x0608, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:243:0x0358 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:0x061a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x02c2 A[Catch: Exception -> 0x0595, TRY_ENTER, TryCatch #9 {Exception -> 0x0595, blocks: (B:53:0x02ba, B:56:0x02c2, B:58:0x02d4, B:59:0x02e2), top: B:221:0x02ba }] */
    /* JADX WARN: Code duplicated, block: B:58:0x02d4 A[Catch: Exception -> 0x0595, TryCatch #9 {Exception -> 0x0595, blocks: (B:53:0x02ba, B:56:0x02c2, B:58:0x02d4, B:59:0x02e2), top: B:221:0x02ba }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0313  */
    /* JADX WARN: Code duplicated, block: B:69:0x032f  */
    /* JADX WARN: Code duplicated, block: B:78:0x034a A[Catch: Exception -> 0x058c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x058c, blocks: (B:66:0x0315, B:78:0x034a, B:145:0x049f), top: B:211:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0364 A[Catch: Exception -> 0x0341, TRY_LEAVE, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x036e  */
    /* JADX WARN: Code duplicated, block: B:98:0x03a0 A[Catch: Exception -> 0x0341, TryCatch #20 {Exception -> 0x0341, blocks: (B:71:0x0332, B:81:0x0358, B:83:0x0364, B:88:0x0371, B:91:0x0385, B:98:0x03a0, B:100:0x03a8, B:103:0x03b1, B:106:0x03c3, B:110:0x03d9, B:112:0x03e1, B:115:0x03ea, B:118:0x03fc, B:120:0x040f, B:122:0x0417, B:125:0x0424, B:128:0x0436, B:130:0x0449, B:132:0x0451, B:135:0x045a, B:138:0x046c, B:140:0x047f, B:143:0x049a), top: B:243:0x0358 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public Map<String, ?> doROARequestWithForm(String str, String str2, String str3, String str4, String str5, String str6, String str7, OpenApiRequest openApiRequest, RuntimeOptions runtimeOptions) throws Exception {
        int i;
        long j;
        ?? r11;
        TeaResponse teaResponseDoAction;
        String accessKeyId;
        String securityToken;
        int backoffTime;
        Client client = this;
        OpenApiRequest openApiRequest2 = openApiRequest;
        Class<String> cls = String.class;
        TeaModel.validateParams(openApiRequest2, "request");
        String str8 = "retry";
        String str9 = "accessDeniedDetail";
        String str10 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair(CachedContentIndex.a.e, Common.defaultString(runtimeOptions.key, client._key)), new TeaPair("cert", Common.defaultString(runtimeOptions.cert, client._cert)), new TeaPair("ca", Common.defaultString(runtimeOptions.ca, client._ca)), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, client._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, client._connectTimeout)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, client._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, client._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, client._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, client._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, client._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, client._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", runtimeOptions.autoretry), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", runtimeOptions.ignoreSSL));
        long jCurrentTimeMillis = System.currentTimeMillis();
        Exception e = null;
        TeaRequest teaRequest = null;
        for (int i2 = 0; Tea.allowRetry((Map) mapBuildMap.get(str8), i2, jCurrentTimeMillis); i2 = i) {
            if (i2 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str10), i2)) > 0) {
                Tea.sleep(backoffTime);
            }
            i = i2 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                j = jCurrentTimeMillis;
                try {
                    teaRequest2.protocol = Common.defaultString(client._protocol, str3);
                    teaRequest2.method = str4;
                    teaRequest2.pathname = str6;
                    HashMap map = new HashMap();
                    Map<String, String> map2 = new HashMap<>();
                    Map<String, String> map3 = map;
                    if (!Common.isUnset(client._globalParameters)) {
                        GlobalParameters globalParameters = client._globalParameters;
                        if (!Common.isUnset(globalParameters.queries)) {
                            map3 = globalParameters.queries;
                        }
                        if (!Common.isUnset(globalParameters.headers)) {
                            map2 = globalParameters.headers;
                        }
                    }
                    Map<String, String> map4 = map3;
                    try {
                        Map[] mapArr = new Map[3];
                        str10 = str10;
                        try {
                            TeaPair[] teaPairArr = new TeaPair[9];
                            str8 = str8;
                            i = i;
                            try {
                                teaPairArr[0] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[1] = new TeaPair(c.f, client._endpoint);
                                    teaPairArr[2] = new TeaPair(SubscribeResouceItemModel.ACCEPT, ze1.g);
                                    try {
                                        teaPairArr[3] = new TeaPair("x-acs-signature-nonce", Common.getNonce());
                                        try {
                                            teaPairArr[4] = new TeaPair("x-acs-signature-method", "HMAC-SHA1");
                                            teaPairArr[5] = new TeaPair("x-acs-signature-version", "1.0");
                                            teaPairArr[6] = new TeaPair("x-acs-version", str2);
                                            teaPairArr[7] = new TeaPair("x-acs-action", str);
                                            teaPairArr[8] = new TeaPair("user-agent", Common.getUserAgent(client._userAgent));
                                            mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                            try {
                                                mapArr[1] = map2;
                                                ?? r12 = 2;
                                                mapArr[2] = openApiRequest2.headers;
                                                teaRequest2.headers = TeaConverter.merge((Class) cls, (Map<String, ?>[]) mapArr);
                                                if (!Common.isUnset(openApiRequest2.body)) {
                                                    teaRequest2.body = Tea.toReadable(com.aliyun.openapiutil.Client.toForm(Common.assertAsMap(openApiRequest2.body)));
                                                    teaRequest2.headers.put(e.f, "application/x-www-form-urlencoded");
                                                    r12 = "application/x-www-form-urlencoded";
                                                }
                                                teaRequest2.query = map4;
                                                if (Common.isUnset(openApiRequest2.query)) {
                                                    if (Common.equalString(str5, "Anonymous")) {
                                                        cls = cls;
                                                        r11 = r12;
                                                    } else {
                                                        accessKeyId = getAccessKeyId();
                                                        String accessKeySecret = getAccessKeySecret();
                                                        securityToken = getSecurityToken();
                                                        if (!Common.empty(securityToken)) {
                                                            teaRequest2.headers.put("x-acs-accesskey-id", accessKeyId);
                                                            teaRequest2.headers.put("x-acs-security-token", securityToken);
                                                        }
                                                        String stringToSign = com.aliyun.openapiutil.Client.getStringToSign(teaRequest2);
                                                        Map<String, String> map5 = teaRequest2.headers;
                                                        StringBuilder sb = new StringBuilder();
                                                        cls = cls;
                                                        sb.append("acs ");
                                                        sb.append(accessKeyId);
                                                        sb.append(u15.f19942b);
                                                        sb.append(com.aliyun.openapiutil.Client.getROASignature(stringToSign, accessKeySecret));
                                                        sb.append("");
                                                        map5.put("authorization", sb.toString());
                                                        r11 = accessKeySecret;
                                                    }
                                                    teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap, interceptorChain);
                                                    if (Common.equalNumber(Integer.valueOf(teaResponseDoAction.statusCode), 204)) {
                                                        TeaPair[] teaPairArr2 = new TeaPair[1];
                                                        teaPairArr2[0] = new TeaPair("headers", teaResponseDoAction.headers);
                                                        return TeaConverter.buildMap(teaPairArr2);
                                                    }
                                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            if (Common.equalString(str7, "binary")) {
                                                                TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                teaPairArr3[0] = new TeaPair("body", teaResponseDoAction.body);
                                                                teaPairArr3[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                teaPairArr3[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                return TeaConverter.buildMap(teaPairArr3);
                                                            }
                                                            if (Common.equalString(str7, "byte")) {
                                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                teaPairArr4[0] = new TeaPair("body", Common.readAsBytes(teaResponseDoAction.body));
                                                                teaPairArr4[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                teaPairArr4[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                return TeaConverter.buildMap(teaPairArr4);
                                                            }
                                                            if (Common.equalString(str7, TypedValues.Custom.S_STRING)) {
                                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                                teaPairArr5[0] = new TeaPair("body", Common.readAsString(teaResponseDoAction.body));
                                                                teaPairArr5[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                teaPairArr5[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                return TeaConverter.buildMap(teaPairArr5);
                                                            }
                                                            if (Common.equalString(str7, "json")) {
                                                                TeaPair[] teaPairArr6 = new TeaPair[3];
                                                                teaPairArr6[0] = new TeaPair("body", Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body)));
                                                                teaPairArr6[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                teaPairArr6[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                return TeaConverter.buildMap(teaPairArr6);
                                                            }
                                                            if (Common.equalString(str7, "array")) {
                                                                TeaPair[] teaPairArr7 = new TeaPair[2];
                                                                teaPairArr7[0] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                teaPairArr7[1] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                return TeaConverter.buildMap(teaPairArr7);
                                                            }
                                                            TeaPair[] teaPairArr8 = new TeaPair[3];
                                                            teaPairArr8[0] = new TeaPair("body", Common.readAsJSON(teaResponseDoAction.body));
                                                            teaPairArr8[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                            teaPairArr8[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                            return TeaConverter.buildMap(teaPairArr8);
                                                            teaRequest = teaRequest2;
                                                            str9 = str9;
                                                        }
                                                    }
                                                    Map<String, Object> mapAssertAsMap = Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body));
                                                    mapAssertAsMap.put("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                    TeaPair[] teaPairArr9 = new TeaPair[5];
                                                    teaPairArr9[0] = new TeaPair("code", "" + defaultAny(mapAssertAsMap.get("Code"), mapAssertAsMap.get("code")) + "");
                                                    teaPairArr9[1] = new TeaPair("message", "code: " + teaResponseDoAction.statusCode + ", " + defaultAny(mapAssertAsMap.get("Message"), mapAssertAsMap.get("message")) + " request id: " + defaultAny(mapAssertAsMap.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID), mapAssertAsMap.get("requestId")) + "");
                                                    teaPairArr9[2] = new TeaPair("data", mapAssertAsMap);
                                                    teaPairArr9[3] = new TeaPair("description", "" + defaultAny(mapAssertAsMap.get(AliyunVodKey.KEY_VOD_DESCRIPTION), mapAssertAsMap.get("description")) + "");
                                                    str9 = str9;
                                                    teaPairArr9[4] = new TeaPair(str9, defaultAny(mapAssertAsMap.get("AccessDeniedDetail"), mapAssertAsMap.get(str9)));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr9));
                                                    teaRequest = teaRequest2;
                                                    str9 = str9;
                                                } else {
                                                    Map[] mapArr2 = new Map[2];
                                                    mapArr2[0] = teaRequest2.query;
                                                    try {
                                                        mapArr2[1] = openApiRequest2.query;
                                                        teaRequest2.query = TeaConverter.merge((Class) cls, (Map<String, ?>[]) mapArr2);
                                                        try {
                                                            if (Common.equalString(str5, "Anonymous")) {
                                                                accessKeyId = getAccessKeyId();
                                                                String accessKeySecret2 = getAccessKeySecret();
                                                                securityToken = getSecurityToken();
                                                                if (!Common.empty(securityToken)) {
                                                                    teaRequest2.headers.put("x-acs-accesskey-id", accessKeyId);
                                                                    teaRequest2.headers.put("x-acs-security-token", securityToken);
                                                                }
                                                                String stringToSign2 = com.aliyun.openapiutil.Client.getStringToSign(teaRequest2);
                                                                Map<String, String> map6 = teaRequest2.headers;
                                                                StringBuilder sb2 = new StringBuilder();
                                                                cls = cls;
                                                                try {
                                                                    sb2.append("acs ");
                                                                    sb2.append(accessKeyId);
                                                                    sb2.append(u15.f19942b);
                                                                    sb2.append(com.aliyun.openapiutil.Client.getROASignature(stringToSign2, accessKeySecret2));
                                                                    sb2.append("");
                                                                    map6.put("authorization", sb2.toString());
                                                                    r11 = accessKeySecret2;
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    if (Tea.isRetryable(e)) {
                                                                        throw e;
                                                                    }
                                                                    client = this;
                                                                    openApiRequest2 = openApiRequest;
                                                                    str9 = str9;
                                                                    str10 = str10;
                                                                    jCurrentTimeMillis = j;
                                                                    cls = cls;
                                                                    str8 = str8;
                                                                }
                                                            } else {
                                                                cls = cls;
                                                                r11 = r12;
                                                            }
                                                            try {
                                                                teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap, interceptorChain);
                                                                if (Common.equalNumber(Integer.valueOf(teaResponseDoAction.statusCode), 204)) {
                                                                    try {
                                                                        TeaPair[] teaPairArr10 = new TeaPair[1];
                                                                        teaPairArr10[0] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                        return TeaConverter.buildMap(teaPairArr10);
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                    }
                                                                } else {
                                                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                        try {
                                                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                                try {
                                                                                    if (Common.equalString(str7, "binary")) {
                                                                                        try {
                                                                                            TeaPair[] teaPairArr11 = new TeaPair[3];
                                                                                            teaPairArr11[0] = new TeaPair("body", teaResponseDoAction.body);
                                                                                            teaPairArr11[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                            teaPairArr11[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                            return TeaConverter.buildMap(teaPairArr11);
                                                                                        } catch (Exception e4) {
                                                                                            e = e4;
                                                                                        }
                                                                                    } else {
                                                                                        try {
                                                                                            if (Common.equalString(str7, "byte")) {
                                                                                                TeaPair[] teaPairArr12 = new TeaPair[3];
                                                                                                teaPairArr12[0] = new TeaPair("body", Common.readAsBytes(teaResponseDoAction.body));
                                                                                                teaPairArr12[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                teaPairArr12[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                return TeaConverter.buildMap(teaPairArr12);
                                                                                            }
                                                                                            if (Common.equalString(str7, TypedValues.Custom.S_STRING)) {
                                                                                                TeaPair[] teaPairArr13 = new TeaPair[3];
                                                                                                teaPairArr13[0] = new TeaPair("body", Common.readAsString(teaResponseDoAction.body));
                                                                                                teaPairArr13[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                teaPairArr13[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                return TeaConverter.buildMap(teaPairArr13);
                                                                                            }
                                                                                            if (Common.equalString(str7, "json")) {
                                                                                                TeaPair[] teaPairArr14 = new TeaPair[3];
                                                                                                teaPairArr14[0] = new TeaPair("body", Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body)));
                                                                                                teaPairArr14[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                teaPairArr14[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                return TeaConverter.buildMap(teaPairArr14);
                                                                                            }
                                                                                            if (Common.equalString(str7, "array")) {
                                                                                                TeaPair[] teaPairArr15 = new TeaPair[2];
                                                                                                teaPairArr15[0] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                teaPairArr15[1] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                return TeaConverter.buildMap(teaPairArr15);
                                                                                            }
                                                                                            TeaPair[] teaPairArr16 = new TeaPair[3];
                                                                                            teaPairArr16[0] = new TeaPair("body", Common.readAsJSON(teaResponseDoAction.body));
                                                                                            teaPairArr16[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                            teaPairArr16[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                            return TeaConverter.buildMap(teaPairArr16);
                                                                                        } catch (Exception e5) {
                                                                                            e = e5;
                                                                                        }
                                                                                    }
                                                                                    teaRequest = teaRequest2;
                                                                                } catch (Exception e6) {
                                                                                    e = e6;
                                                                                }
                                                                                str9 = str9;
                                                                            }
                                                                        } catch (Exception e7) {
                                                                            e = e7;
                                                                            teaRequest = teaRequest2;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw e;
                                                                            }
                                                                            client = this;
                                                                            openApiRequest2 = openApiRequest;
                                                                            str9 = str9;
                                                                            str10 = str10;
                                                                            jCurrentTimeMillis = j;
                                                                            cls = cls;
                                                                            str8 = str8;
                                                                        }
                                                                    }
                                                                    Map<String, Object> mapAssertAsMap2 = Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body));
                                                                    mapAssertAsMap2.put("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                    TeaPair[] teaPairArr17 = new TeaPair[5];
                                                                    teaPairArr17[0] = new TeaPair("code", "" + defaultAny(mapAssertAsMap2.get("Code"), mapAssertAsMap2.get("code")) + "");
                                                                    try {
                                                                        teaPairArr17[1] = new TeaPair("message", "code: " + teaResponseDoAction.statusCode + ", " + defaultAny(mapAssertAsMap2.get("Message"), mapAssertAsMap2.get("message")) + " request id: " + defaultAny(mapAssertAsMap2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID), mapAssertAsMap2.get("requestId")) + "");
                                                                        teaPairArr17[2] = new TeaPair("data", mapAssertAsMap2);
                                                                        try {
                                                                            teaPairArr17[3] = new TeaPair("description", "" + defaultAny(mapAssertAsMap2.get(AliyunVodKey.KEY_VOD_DESCRIPTION), mapAssertAsMap2.get("description")) + "");
                                                                            str9 = str9;
                                                                            try {
                                                                                try {
                                                                                    teaPairArr17[4] = new TeaPair(str9, defaultAny(mapAssertAsMap2.get("AccessDeniedDetail"), mapAssertAsMap2.get(str9)));
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr17));
                                                                                } catch (Exception e8) {
                                                                                    e = e8;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw e;
                                                                                    }
                                                                                    client = this;
                                                                                    openApiRequest2 = openApiRequest;
                                                                                    str9 = str9;
                                                                                    str10 = str10;
                                                                                    jCurrentTimeMillis = j;
                                                                                    cls = cls;
                                                                                    str8 = str8;
                                                                                }
                                                                            } catch (Exception e9) {
                                                                                e = e9;
                                                                                teaRequest = teaRequest2;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw e;
                                                                                }
                                                                                client = this;
                                                                                openApiRequest2 = openApiRequest;
                                                                                str9 = str9;
                                                                                str10 = str10;
                                                                                jCurrentTimeMillis = j;
                                                                                cls = cls;
                                                                                str8 = str8;
                                                                            }
                                                                        } catch (Exception e10) {
                                                                            e = e10;
                                                                            str9 = str9;
                                                                        }
                                                                    } catch (Exception e11) {
                                                                        e = e11;
                                                                        str9 = str9;
                                                                    }
                                                                }
                                                                teaRequest = teaRequest2;
                                                            } catch (Exception e12) {
                                                                e = e12;
                                                                str9 = str9;
                                                            }
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            cls = cls;
                                                            if (Tea.isRetryable(e)) {
                                                                throw e;
                                                            }
                                                            client = this;
                                                            openApiRequest2 = openApiRequest;
                                                            str9 = str9;
                                                            str10 = str10;
                                                            jCurrentTimeMillis = j;
                                                            cls = cls;
                                                            str8 = str8;
                                                        }
                                                    } catch (Exception e14) {
                                                        e = e14;
                                                        cls = cls;
                                                    }
                                                    str9 = str9;
                                                }
                                            } catch (Exception e15) {
                                                e = e15;
                                                cls = cls;
                                                str9 = str9;
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                            cls = cls;
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                        cls = cls;
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                    cls = cls;
                                }
                            } catch (Exception e19) {
                                e = e19;
                            }
                        } catch (Exception e20) {
                            e = e20;
                            str8 = str8;
                            i = i;
                            if (Tea.isRetryable(e)) {
                                throw e;
                            }
                            client = this;
                            openApiRequest2 = openApiRequest;
                            str9 = str9;
                            str10 = str10;
                            jCurrentTimeMillis = j;
                            cls = cls;
                            str8 = str8;
                        }
                    } catch (Exception e21) {
                        e = e21;
                        if (Tea.isRetryable(e)) {
                            throw e;
                        }
                        client = this;
                        openApiRequest2 = openApiRequest;
                        str9 = str9;
                        str10 = str10;
                        jCurrentTimeMillis = j;
                        cls = cls;
                        str8 = str8;
                    }
                } catch (Exception e22) {
                    e = e22;
                    str10 = str10;
                }
            } catch (Exception e23) {
                e = e23;
                j = jCurrentTimeMillis;
            }
            if (Tea.isRetryable(e)) {
                throw e;
            }
            client = this;
            openApiRequest2 = openApiRequest;
            str9 = str9;
            str10 = str10;
            jCurrentTimeMillis = j;
            cls = cls;
            str8 = str8;
        }
        throw new TeaUnretryableException(teaRequest, e);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x049a A[Catch: Exception -> 0x0522, TryCatch #12 {Exception -> 0x0522, blocks: (B:100:0x0494, B:102:0x049a, B:104:0x04cc, B:106:0x04d4, B:108:0x0502), top: B:204:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x04cc A[Catch: Exception -> 0x0522, TryCatch #12 {Exception -> 0x0522, blocks: (B:100:0x0494, B:102:0x049a, B:104:0x04cc, B:106:0x04d4, B:108:0x0502), top: B:204:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x04d4 A[Catch: Exception -> 0x0522, TryCatch #12 {Exception -> 0x0522, blocks: (B:100:0x0494, B:102:0x049a, B:104:0x04cc, B:106:0x04d4, B:108:0x0502), top: B:204:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0502 A[Catch: Exception -> 0x0522, TRY_LEAVE, TryCatch #12 {Exception -> 0x0522, blocks: (B:100:0x0494, B:102:0x049a, B:104:0x04cc, B:106:0x04d4, B:108:0x0502), top: B:204:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x06ac A[LOOP:0: B:3:0x0180->B:176:0x06ac, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:196:0x03d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:0x032c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:0x03ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x042e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:233:0x0464 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:0x06c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x026b  */
    /* JADX WARN: Code duplicated, block: B:54:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:68:0x035e A[Catch: Exception -> 0x034e, TRY_ENTER, TryCatch #14 {Exception -> 0x034e, blocks: (B:62:0x032c, B:68:0x035e, B:70:0x0370, B:71:0x0377, B:73:0x0398, B:75:0x03a0), top: B:207:0x032c }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0370 A[Catch: Exception -> 0x034e, TryCatch #14 {Exception -> 0x034e, blocks: (B:62:0x032c, B:68:0x035e, B:70:0x0370, B:71:0x0377, B:73:0x0398, B:75:0x03a0), top: B:207:0x032c }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0398 A[Catch: Exception -> 0x034e, TryCatch #14 {Exception -> 0x034e, blocks: (B:62:0x032c, B:68:0x035e, B:70:0x0370, B:71:0x0377, B:73:0x0398, B:75:0x03a0), top: B:207:0x032c }] */
    /* JADX WARN: Code duplicated, block: B:74:0x039f  */
    /* JADX WARN: Code duplicated, block: B:81:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:91:0x0426 A[Catch: Exception -> 0x0524, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x0524, blocks: (B:83:0x03e4, B:91:0x0426, B:95:0x045c), top: B:200:0x03e4 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x045c A[Catch: Exception -> 0x0524, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x0524, blocks: (B:83:0x03e4, B:91:0x0426, B:95:0x045c), top: B:200:0x03e4 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0492  */
    public Map<String, ?> doRPCRequest(String str, String str2, String str3, String str4, String str5, String str6, OpenApiRequest openApiRequest, RuntimeOptions runtimeOptions) throws Exception {
        int i;
        String str7;
        long j;
        String str8;
        String str9;
        Map<String, String> rpcHeaders;
        String str10;
        TeaRequest teaRequest;
        TeaResponse teaResponseDoAction;
        String securityToken;
        Map<String, Object> mapAssertAsMap;
        int backoffTime;
        Client client = this;
        String str11 = str6;
        OpenApiRequest openApiRequest2 = openApiRequest;
        String str12 = "json";
        TeaModel.validateParams(openApiRequest2, "request");
        String str13 = "retry";
        String str14 = "description";
        String str15 = "message";
        String str16 = "code";
        String str17 = "";
        String str18 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair(CachedContentIndex.a.e, Common.defaultString(runtimeOptions.key, client._key)), new TeaPair("cert", Common.defaultString(runtimeOptions.cert, client._cert)), new TeaPair("ca", Common.defaultString(runtimeOptions.ca, client._ca)), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, client._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, client._connectTimeout)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, client._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, client._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, client._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, client._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, client._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, client._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", runtimeOptions.autoretry), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", runtimeOptions.ignoreSSL));
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        TeaRequest teaRequest2 = null;
        Exception exc = null;
        while (Tea.allowRetry((Map) mapBuildMap.get(str13), i2, jCurrentTimeMillis)) {
            if (i2 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str18), i2)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i3 = i2 + 1;
            try {
                teaRequest2 = new TeaRequest();
                i = i3;
                try {
                    teaRequest2.protocol = Common.defaultString(client._protocol, str3);
                    teaRequest2.method = str4;
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER;
                    HashMap map = new HashMap();
                    Map<String, String> map2 = new HashMap<>();
                    Map<String, String> map3 = map;
                    if (Common.isUnset(client._globalParameters)) {
                        Map<String, String> map4 = map3;
                        str7 = str18;
                        Map[] mapArr = new Map[3];
                        j = jCurrentTimeMillis;
                        TeaPair[] teaPairArr = new TeaPair[5];
                        teaPairArr[0] = new TeaPair(AliyunVodKey.KEY_VOD_ACTION, str);
                        teaPairArr[1] = new TeaPair(AliyunVodKey.KEY_VOD_COMMON_FORMAT, str12);
                        teaPairArr[2] = new TeaPair("Version", str2);
                        str8 = str13;
                        teaPairArr[3] = new TeaPair("Timestamp", com.aliyun.openapiutil.Client.getTimestamp());
                        teaPairArr[4] = new TeaPair(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_NONCE, Common.getNonce());
                        mapArr[0] = TeaConverter.buildMap(teaPairArr);
                        mapArr[1] = map4;
                        mapArr[2] = openApiRequest2.query;
                        teaRequest2.query = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                        rpcHeaders = getRpcHeaders();
                        if (Common.isUnset(rpcHeaders)) {
                            Map[] mapArr2 = new Map[2];
                            teaRequest = teaRequest2;
                            TeaPair[] teaPairArr2 = new TeaPair[4];
                            str10 = str12;
                            teaPairArr2[0] = new TeaPair(c.f, client._endpoint);
                            teaPairArr2[1] = new TeaPair("x-acs-version", str2);
                            teaPairArr2[2] = new TeaPair("x-acs-action", str);
                            teaPairArr2[3] = new TeaPair("user-agent", getUserAgent());
                            mapArr2[0] = TeaConverter.buildMap(teaPairArr2);
                            mapArr2[1] = map2;
                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr2);
                        } else {
                            str10 = str12;
                            teaRequest = teaRequest2;
                            Map[] mapArr3 = new Map[3];
                            TeaPair[] teaPairArr3 = new TeaPair[4];
                            teaPairArr3[0] = new TeaPair(c.f, client._endpoint);
                            teaPairArr3[1] = new TeaPair("x-acs-version", str2);
                            teaPairArr3[2] = new TeaPair("x-acs-action", str);
                            teaPairArr3[3] = new TeaPair("user-agent", getUserAgent());
                            mapArr3[0] = TeaConverter.buildMap(teaPairArr3);
                            mapArr3[1] = map2;
                            mapArr3[2] = rpcHeaders;
                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr3);
                        }
                        if (!Common.isUnset(openApiRequest2.body)) {
                            teaRequest2.body = Tea.toReadable(Common.toFormString(Common.anyifyMapValue(com.aliyun.openapiutil.Client.query(Common.assertAsMap(openApiRequest2.body)))));
                            teaRequest2.headers.put(e.f, "application/x-www-form-urlencoded");
                        }
                        if (!Common.equalString(str5, "Anonymous")) {
                            String accessKeyId = getAccessKeyId();
                            String accessKeySecret = getAccessKeySecret();
                            securityToken = getSecurityToken();
                            if (!Common.empty(securityToken)) {
                                teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN, securityToken);
                            }
                            teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_METHOD, "HMAC-SHA1");
                            teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_VERSION, "1.0");
                            teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID, accessKeyId);
                            if (Common.isUnset(openApiRequest2.body)) {
                                mapAssertAsMap = null;
                            } else {
                                mapAssertAsMap = Common.assertAsMap(openApiRequest2.body);
                            }
                            teaRequest2.query.put("Signature", com.aliyun.openapiutil.Client.getRPCSignature(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaRequest2.query, com.aliyun.openapiutil.Client.query(mapAssertAsMap)}), teaRequest2.method, accessKeySecret));
                        }
                        teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap, interceptorChain);
                        if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                str9 = str6;
                                if (Common.equalString(str9, "binary")) {
                                    return TeaConverter.buildMap(new TeaPair("body", teaResponseDoAction.body), new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode)));
                                }
                                if (Common.equalString(str9, "byte")) {
                                    return TeaConverter.buildMap(new TeaPair("body", Common.readAsBytes(teaResponseDoAction.body)), new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode)));
                                }
                                if (Common.equalString(str9, TypedValues.Custom.S_STRING)) {
                                    return TeaConverter.buildMap(new TeaPair("body", Common.readAsString(teaResponseDoAction.body)), new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode)));
                                }
                                str12 = str10;
                                if (Common.equalString(str9, str12)) {
                                    return TeaConverter.buildMap(new TeaPair("body", Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body))), new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode)));
                                }
                                if (Common.equalString(str9, "array")) {
                                }
                                exc = e;
                            }
                        }
                        str9 = str6;
                        str12 = str10;
                        Map<String, Object> mapAssertAsMap2 = Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body));
                        Object objDefaultAny = defaultAny(mapAssertAsMap2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID), mapAssertAsMap2.get("requestId"));
                        mapAssertAsMap2.put("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                        TeaPair[] teaPairArr4 = new TeaPair[5];
                        StringBuilder sb = new StringBuilder();
                        str17 = str17;
                        sb.append(str17);
                        str16 = str16;
                        sb.append(defaultAny(mapAssertAsMap2.get("Code"), mapAssertAsMap2.get(str16)));
                        sb.append(str17);
                        teaPairArr4[0] = new TeaPair(str16, sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("code: ");
                        sb2.append(teaResponseDoAction.statusCode);
                        sb2.append(", ");
                        str15 = str15;
                        sb2.append(defaultAny(mapAssertAsMap2.get("Message"), mapAssertAsMap2.get(str15)));
                        sb2.append(" request id: ");
                        sb2.append(objDefaultAny);
                        sb2.append(str17);
                        teaPairArr4[1] = new TeaPair(str15, sb2.toString());
                        teaPairArr4[2] = new TeaPair("data", mapAssertAsMap2);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str17);
                        str14 = str14;
                        sb3.append(defaultAny(mapAssertAsMap2.get(AliyunVodKey.KEY_VOD_DESCRIPTION), mapAssertAsMap2.get(str14)));
                        sb3.append(str17);
                        teaPairArr4[3] = new TeaPair(str14, sb3.toString());
                        teaPairArr4[4] = new TeaPair("accessDeniedDetail", defaultAny(mapAssertAsMap2.get("AccessDeniedDetail"), mapAssertAsMap2.get("accessDeniedDetail")));
                        throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                    }
                    try {
                        GlobalParameters globalParameters = client._globalParameters;
                        if (!Common.isUnset(globalParameters.queries)) {
                            map3 = globalParameters.queries;
                        }
                        if (!Common.isUnset(globalParameters.headers)) {
                            map2 = globalParameters.headers;
                        }
                        Map<String, String> map5 = map3;
                        str7 = str18;
                        try {
                            Map[] mapArr4 = new Map[3];
                            j = jCurrentTimeMillis;
                            try {
                                TeaPair[] teaPairArr5 = new TeaPair[5];
                                teaPairArr5[0] = new TeaPair(AliyunVodKey.KEY_VOD_ACTION, str);
                                teaPairArr5[1] = new TeaPair(AliyunVodKey.KEY_VOD_COMMON_FORMAT, str12);
                                teaPairArr5[2] = new TeaPair("Version", str2);
                                str8 = str13;
                                try {
                                    teaPairArr5[3] = new TeaPair("Timestamp", com.aliyun.openapiutil.Client.getTimestamp());
                                    try {
                                        teaPairArr5[4] = new TeaPair(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_NONCE, Common.getNonce());
                                        mapArr4[0] = TeaConverter.buildMap(teaPairArr5);
                                        mapArr4[1] = map5;
                                        mapArr4[2] = openApiRequest2.query;
                                        teaRequest2.query = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr4);
                                        rpcHeaders = getRpcHeaders();
                                        if (Common.isUnset(rpcHeaders)) {
                                            try {
                                                Map[] mapArr5 = new Map[2];
                                                teaRequest = teaRequest2;
                                                try {
                                                    TeaPair[] teaPairArr6 = new TeaPair[4];
                                                    try {
                                                        str10 = str12;
                                                        try {
                                                            teaPairArr6[0] = new TeaPair(c.f, client._endpoint);
                                                            teaPairArr6[1] = new TeaPair("x-acs-version", str2);
                                                            teaPairArr6[2] = new TeaPair("x-acs-action", str);
                                                            teaPairArr6[3] = new TeaPair("user-agent", getUserAgent());
                                                            mapArr5[0] = TeaConverter.buildMap(teaPairArr6);
                                                            mapArr5[1] = map2;
                                                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr5);
                                                        } catch (Exception e) {
                                                            exc = e;
                                                            str9 = str11;
                                                            str14 = str14;
                                                            str15 = str15;
                                                            str16 = str16;
                                                            str17 = str17;
                                                            teaRequest2 = teaRequest;
                                                            str12 = str10;
                                                            if (Tea.isRetryable(exc)) {
                                                                throw exc;
                                                            }
                                                            client = this;
                                                            openApiRequest2 = openApiRequest;
                                                            str17 = str17;
                                                            str14 = str14;
                                                            str16 = str16;
                                                            str11 = str9;
                                                            str15 = str15;
                                                            i2 = i;
                                                            str18 = str7;
                                                            jCurrentTimeMillis = j;
                                                            str13 = str8;
                                                            str12 = str12;
                                                        }
                                                    } catch (Exception e2) {
                                                        exc = e2;
                                                        str12 = str12;
                                                        teaRequest2 = teaRequest;
                                                        str9 = str11;
                                                        str16 = str16;
                                                        if (Tea.isRetryable(exc)) {
                                                            throw exc;
                                                        }
                                                        client = this;
                                                        openApiRequest2 = openApiRequest;
                                                        str17 = str17;
                                                        str14 = str14;
                                                        str16 = str16;
                                                        str11 = str9;
                                                        str15 = str15;
                                                        i2 = i;
                                                        str18 = str7;
                                                        jCurrentTimeMillis = j;
                                                        str13 = str8;
                                                        str12 = str12;
                                                    }
                                                } catch (Exception e3) {
                                                    exc = e3;
                                                    str12 = str12;
                                                    str14 = str14;
                                                    str15 = str15;
                                                    str17 = str17;
                                                    teaRequest2 = teaRequest;
                                                    str9 = str11;
                                                    str16 = str16;
                                                    if (Tea.isRetryable(exc)) {
                                                        throw exc;
                                                    }
                                                    client = this;
                                                    openApiRequest2 = openApiRequest;
                                                    str17 = str17;
                                                    str14 = str14;
                                                    str16 = str16;
                                                    str11 = str9;
                                                    str15 = str15;
                                                    i2 = i;
                                                    str18 = str7;
                                                    jCurrentTimeMillis = j;
                                                    str13 = str8;
                                                    str12 = str12;
                                                }
                                            } catch (Exception e4) {
                                                exc = e4;
                                                str9 = str11;
                                                str16 = str16;
                                                if (Tea.isRetryable(exc)) {
                                                    throw exc;
                                                }
                                                client = this;
                                                openApiRequest2 = openApiRequest;
                                                str17 = str17;
                                                str14 = str14;
                                                str16 = str16;
                                                str11 = str9;
                                                str15 = str15;
                                                i2 = i;
                                                str18 = str7;
                                                jCurrentTimeMillis = j;
                                                str13 = str8;
                                                str12 = str12;
                                            }
                                        } else {
                                            str10 = str12;
                                            teaRequest = teaRequest2;
                                            try {
                                                Map[] mapArr6 = new Map[3];
                                                try {
                                                    TeaPair[] teaPairArr7 = new TeaPair[4];
                                                    teaPairArr7[0] = new TeaPair(c.f, client._endpoint);
                                                    teaPairArr7[1] = new TeaPair("x-acs-version", str2);
                                                    teaPairArr7[2] = new TeaPair("x-acs-action", str);
                                                    teaPairArr7[3] = new TeaPair("user-agent", getUserAgent());
                                                    mapArr6[0] = TeaConverter.buildMap(teaPairArr7);
                                                    mapArr6[1] = map2;
                                                    mapArr6[2] = rpcHeaders;
                                                    teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr6);
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    str9 = str11;
                                                    str12 = str10;
                                                    exc = e;
                                                    teaRequest2 = teaRequest;
                                                    if (Tea.isRetryable(exc)) {
                                                        throw exc;
                                                    }
                                                    client = this;
                                                    openApiRequest2 = openApiRequest;
                                                    str17 = str17;
                                                    str14 = str14;
                                                    str16 = str16;
                                                    str11 = str9;
                                                    str15 = str15;
                                                    i2 = i;
                                                    str18 = str7;
                                                    jCurrentTimeMillis = j;
                                                    str13 = str8;
                                                    str12 = str12;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                str9 = str11;
                                                str12 = str10;
                                                exc = e;
                                                teaRequest2 = teaRequest;
                                                if (Tea.isRetryable(exc)) {
                                                    throw exc;
                                                }
                                                client = this;
                                                openApiRequest2 = openApiRequest;
                                                str17 = str17;
                                                str14 = str14;
                                                str16 = str16;
                                                str11 = str9;
                                                str15 = str15;
                                                i2 = i;
                                                str18 = str7;
                                                jCurrentTimeMillis = j;
                                                str13 = str8;
                                                str12 = str12;
                                            }
                                        }
                                        try {
                                            if (!Common.isUnset(openApiRequest2.body)) {
                                                try {
                                                    teaRequest2.body = Tea.toReadable(Common.toFormString(Common.anyifyMapValue(com.aliyun.openapiutil.Client.query(Common.assertAsMap(openApiRequest2.body)))));
                                                    teaRequest2.headers.put(e.f, "application/x-www-form-urlencoded");
                                                } catch (Exception e7) {
                                                    str9 = str6;
                                                    exc = e7;
                                                    str14 = str14;
                                                    str15 = str15;
                                                    str16 = str16;
                                                    str17 = str17;
                                                    teaRequest2 = teaRequest;
                                                    str12 = str10;
                                                    if (Tea.isRetryable(exc)) {
                                                        throw exc;
                                                    }
                                                    client = this;
                                                    openApiRequest2 = openApiRequest;
                                                    str17 = str17;
                                                    str14 = str14;
                                                    str16 = str16;
                                                    str11 = str9;
                                                    str15 = str15;
                                                    i2 = i;
                                                    str18 = str7;
                                                    jCurrentTimeMillis = j;
                                                    str13 = str8;
                                                    str12 = str12;
                                                }
                                            }
                                            if (!Common.equalString(str5, "Anonymous")) {
                                                String accessKeyId2 = getAccessKeyId();
                                                String accessKeySecret2 = getAccessKeySecret();
                                                securityToken = getSecurityToken();
                                                if (!Common.empty(securityToken)) {
                                                    teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN, securityToken);
                                                }
                                                teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_METHOD, "HMAC-SHA1");
                                                teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_VERSION, "1.0");
                                                teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID, accessKeyId2);
                                                if (Common.isUnset(openApiRequest2.body)) {
                                                    mapAssertAsMap = Common.assertAsMap(openApiRequest2.body);
                                                } else {
                                                    mapAssertAsMap = null;
                                                }
                                                teaRequest2.query.put("Signature", com.aliyun.openapiutil.Client.getRPCSignature(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaRequest2.query, com.aliyun.openapiutil.Client.query(mapAssertAsMap)}), teaRequest2.method, accessKeySecret2));
                                            }
                                            try {
                                                teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap, interceptorChain);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            str9 = str6;
                                                            try {
                                                                try {
                                                                    if (Common.equalString(str9, "binary")) {
                                                                        return TeaConverter.buildMap(new TeaPair("body", teaResponseDoAction.body), new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode)));
                                                                    }
                                                                    if (Common.equalString(str9, "byte")) {
                                                                        return TeaConverter.buildMap(new TeaPair("body", Common.readAsBytes(teaResponseDoAction.body)), new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode)));
                                                                    }
                                                                    if (Common.equalString(str9, TypedValues.Custom.S_STRING)) {
                                                                        return TeaConverter.buildMap(new TeaPair("body", Common.readAsString(teaResponseDoAction.body)), new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode)));
                                                                    }
                                                                    str12 = str10;
                                                                    try {
                                                                        if (Common.equalString(str9, str12)) {
                                                                            return TeaConverter.buildMap(new TeaPair("body", Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body))), new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode)));
                                                                        }
                                                                        return Common.equalString(str9, "array") ? TeaConverter.buildMap(new TeaPair("body", Common.readAsJSON(teaResponseDoAction.body)), new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode))) : TeaConverter.buildMap(new TeaPair("headers", teaResponseDoAction.headers), new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode)));
                                                                    } catch (Exception e8) {
                                                                        e = e8;
                                                                    }
                                                                } catch (Exception e9) {
                                                                    e = e9;
                                                                    str12 = str10;
                                                                }
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                str12 = str10;
                                                            }
                                                            exc = e;
                                                        }
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        str9 = str6;
                                                    }
                                                }
                                                str9 = str6;
                                                str12 = str10;
                                                try {
                                                    Map<String, Object> mapAssertAsMap3 = Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body));
                                                    Object objDefaultAny2 = defaultAny(mapAssertAsMap3.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID), mapAssertAsMap3.get("requestId"));
                                                    mapAssertAsMap3.put("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                    TeaPair[] teaPairArr8 = new TeaPair[5];
                                                    StringBuilder sb4 = new StringBuilder();
                                                    str17 = str17;
                                                    try {
                                                        sb4.append(str17);
                                                        str16 = str16;
                                                        try {
                                                            sb4.append(defaultAny(mapAssertAsMap3.get("Code"), mapAssertAsMap3.get(str16)));
                                                            sb4.append(str17);
                                                            teaPairArr8[0] = new TeaPair(str16, sb4.toString());
                                                            StringBuilder sb5 = new StringBuilder();
                                                            sb5.append("code: ");
                                                            sb5.append(teaResponseDoAction.statusCode);
                                                            sb5.append(", ");
                                                            str15 = str15;
                                                            try {
                                                                sb5.append(defaultAny(mapAssertAsMap3.get("Message"), mapAssertAsMap3.get(str15)));
                                                                sb5.append(" request id: ");
                                                                sb5.append(objDefaultAny2);
                                                                sb5.append(str17);
                                                                teaPairArr8[1] = new TeaPair(str15, sb5.toString());
                                                                teaPairArr8[2] = new TeaPair("data", mapAssertAsMap3);
                                                                StringBuilder sb6 = new StringBuilder();
                                                                sb6.append(str17);
                                                                str14 = str14;
                                                                try {
                                                                    sb6.append(defaultAny(mapAssertAsMap3.get(AliyunVodKey.KEY_VOD_DESCRIPTION), mapAssertAsMap3.get(str14)));
                                                                    sb6.append(str17);
                                                                    teaPairArr8[3] = new TeaPair(str14, sb6.toString());
                                                                    try {
                                                                        teaPairArr8[4] = new TeaPair("accessDeniedDetail", defaultAny(mapAssertAsMap3.get("AccessDeniedDetail"), mapAssertAsMap3.get("accessDeniedDetail")));
                                                                        throw new TeaException(TeaConverter.buildMap(teaPairArr8));
                                                                    } catch (Exception e12) {
                                                                        e = e12;
                                                                        teaRequest2 = teaRequest2;
                                                                        exc = e;
                                                                        if (Tea.isRetryable(exc)) {
                                                                            throw exc;
                                                                        }
                                                                        client = this;
                                                                        openApiRequest2 = openApiRequest;
                                                                        str17 = str17;
                                                                        str14 = str14;
                                                                        str16 = str16;
                                                                        str11 = str9;
                                                                        str15 = str15;
                                                                        i2 = i;
                                                                        str18 = str7;
                                                                        jCurrentTimeMillis = j;
                                                                        str13 = str8;
                                                                        str12 = str12;
                                                                    }
                                                                } catch (Exception e13) {
                                                                    e = e13;
                                                                    teaRequest2 = teaRequest2;
                                                                    exc = e;
                                                                    if (Tea.isRetryable(exc)) {
                                                                        throw exc;
                                                                    }
                                                                    client = this;
                                                                    openApiRequest2 = openApiRequest;
                                                                    str17 = str17;
                                                                    str14 = str14;
                                                                    str16 = str16;
                                                                    str11 = str9;
                                                                    str15 = str15;
                                                                    i2 = i;
                                                                    str18 = str7;
                                                                    jCurrentTimeMillis = j;
                                                                    str13 = str8;
                                                                    str12 = str12;
                                                                }
                                                            } catch (Exception e14) {
                                                                e = e14;
                                                                str14 = str14;
                                                            }
                                                        } catch (Exception e15) {
                                                            e = e15;
                                                            str14 = str14;
                                                            str15 = str15;
                                                        }
                                                    } catch (Exception e16) {
                                                        e = e16;
                                                        str14 = str14;
                                                        str15 = str15;
                                                        str16 = str16;
                                                    }
                                                } catch (Exception e17) {
                                                    e = e17;
                                                    str14 = str14;
                                                    str15 = str15;
                                                    str16 = str16;
                                                    str17 = str17;
                                                }
                                            } catch (Exception e18) {
                                                e = e18;
                                                str9 = str6;
                                                str14 = str14;
                                                str15 = str15;
                                                str16 = str16;
                                                str17 = str17;
                                                str12 = str10;
                                            }
                                        } catch (Exception e19) {
                                            e = e19;
                                            str9 = str6;
                                            str12 = str10;
                                            exc = e;
                                            teaRequest2 = teaRequest;
                                            if (Tea.isRetryable(exc)) {
                                                throw exc;
                                            }
                                            client = this;
                                            openApiRequest2 = openApiRequest;
                                            str17 = str17;
                                            str14 = str14;
                                            str16 = str16;
                                            str11 = str9;
                                            str15 = str15;
                                            i2 = i;
                                            str18 = str7;
                                            jCurrentTimeMillis = j;
                                            str13 = str8;
                                            str12 = str12;
                                        }
                                    } catch (Exception e20) {
                                        e = e20;
                                        str12 = str12;
                                        str9 = str11;
                                        str16 = str16;
                                    }
                                } catch (Exception e21) {
                                    e = e21;
                                    str12 = str12;
                                    str9 = str11;
                                    str16 = str16;
                                    exc = e;
                                    if (Tea.isRetryable(exc)) {
                                        throw exc;
                                    }
                                    client = this;
                                    openApiRequest2 = openApiRequest;
                                    str17 = str17;
                                    str14 = str14;
                                    str16 = str16;
                                    str11 = str9;
                                    str15 = str15;
                                    i2 = i;
                                    str18 = str7;
                                    jCurrentTimeMillis = j;
                                    str13 = str8;
                                    str12 = str12;
                                }
                            } catch (Exception e22) {
                                e = e22;
                                str8 = str13;
                                str9 = str11;
                                str16 = str16;
                                exc = e;
                                if (Tea.isRetryable(exc)) {
                                    throw exc;
                                }
                                client = this;
                                openApiRequest2 = openApiRequest;
                                str17 = str17;
                                str14 = str14;
                                str16 = str16;
                                str11 = str9;
                                str15 = str15;
                                i2 = i;
                                str18 = str7;
                                jCurrentTimeMillis = j;
                                str13 = str8;
                                str12 = str12;
                            }
                        } catch (Exception e23) {
                            e = e23;
                            j = jCurrentTimeMillis;
                            str8 = str13;
                            str9 = str11;
                            str16 = str16;
                            exc = e;
                            if (Tea.isRetryable(exc)) {
                                throw exc;
                            }
                            client = this;
                            openApiRequest2 = openApiRequest;
                            str17 = str17;
                            str14 = str14;
                            str16 = str16;
                            str11 = str9;
                            str15 = str15;
                            i2 = i;
                            str18 = str7;
                            jCurrentTimeMillis = j;
                            str13 = str8;
                            str12 = str12;
                        }
                    } catch (Exception e24) {
                        exc = e24;
                        str7 = str18;
                        j = jCurrentTimeMillis;
                        str8 = str13;
                        str9 = str11;
                        str16 = str16;
                        if (Tea.isRetryable(exc)) {
                            throw exc;
                        }
                        client = this;
                        openApiRequest2 = openApiRequest;
                        str17 = str17;
                        str14 = str14;
                        str16 = str16;
                        str11 = str9;
                        str15 = str15;
                        i2 = i;
                        str18 = str7;
                        jCurrentTimeMillis = j;
                        str13 = str8;
                        str12 = str12;
                    }
                } catch (Exception e25) {
                    e = e25;
                    str7 = str18;
                    j = jCurrentTimeMillis;
                    str8 = str13;
                    str9 = str11;
                    str16 = str16;
                    exc = e;
                    if (Tea.isRetryable(exc)) {
                        throw exc;
                    }
                    client = this;
                    openApiRequest2 = openApiRequest;
                    str17 = str17;
                    str14 = str14;
                    str16 = str16;
                    str11 = str9;
                    str15 = str15;
                    i2 = i;
                    str18 = str7;
                    jCurrentTimeMillis = j;
                    str13 = str8;
                    str12 = str12;
                }
            } catch (Exception e26) {
                e = e26;
                i = i3;
            }
            if (Tea.isRetryable(exc)) {
                throw exc;
            }
            client = this;
            openApiRequest2 = openApiRequest;
            str17 = str17;
            str14 = str14;
            str16 = str16;
            str11 = str9;
            str15 = str15;
            i2 = i;
            str18 = str7;
            jCurrentTimeMillis = j;
            str13 = str8;
            str12 = str12;
        }
        throw new TeaUnretryableException(teaRequest2, exc);
    }

    /* JADX WARN: Code duplicated, block: B:256:0x06fa A[LOOP:0: B:3:0x0177->B:256:0x06fa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:318:0x070c A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public Map<String, ?> doRequest(Params params, OpenApiRequest openApiRequest, RuntimeOptions runtimeOptions) throws Exception {
        long j;
        String str;
        String str2;
        int i;
        int backoffTime;
        Client client = this;
        OpenApiRequest openApiRequest2 = openApiRequest;
        Class<String> cls = String.class;
        TeaModel.validateParams(params, "params");
        TeaModel.validateParams(openApiRequest2, "request");
        String str3 = "retry";
        String str4 = "description";
        String str5 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair(CachedContentIndex.a.e, Common.defaultString(runtimeOptions.key, client._key)), new TeaPair("cert", Common.defaultString(runtimeOptions.cert, client._cert)), new TeaPair("ca", Common.defaultString(runtimeOptions.ca, client._ca)), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, client._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, client._connectTimeout)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, client._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, client._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, client._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, client._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, client._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, client._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", runtimeOptions.autoretry), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", runtimeOptions.ignoreSSL));
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        TeaRequest teaRequest = null;
        Exception exc = null;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i2, jCurrentTimeMillis)) {
            if (i2 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str5), i2)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i3 = i2 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                j = jCurrentTimeMillis;
                try {
                    teaRequest2.protocol = Common.defaultString(client._protocol, params.protocol);
                    teaRequest2.method = params.method;
                    teaRequest2.pathname = params.pathname;
                    Map<String, String> map = new HashMap<>();
                    Map map2 = new HashMap();
                    if (!Common.isUnset(client._globalParameters)) {
                        try {
                            GlobalParameters globalParameters = client._globalParameters;
                            Map<String, String> map3 = map;
                            if (!Common.isUnset(globalParameters.queries)) {
                                map3 = globalParameters.queries;
                            }
                            if (!Common.isUnset(globalParameters.headers)) {
                                map2 = globalParameters.headers;
                            }
                            map = map3;
                        } catch (Exception e) {
                            exc = e;
                            cls = cls;
                            str = str5;
                            str2 = str3;
                            i = i3;
                            if (!Tea.isRetryable(exc)) {
                                throw exc;
                            }
                            client = this;
                            openApiRequest2 = openApiRequest;
                            str4 = str4;
                            jCurrentTimeMillis = j;
                            str5 = str;
                            str3 = str2;
                            i2 = i;
                            cls = cls;
                        }
                    }
                    str = str5;
                    try {
                        Map[] mapArr = new Map[2];
                        try {
                            mapArr[0] = map;
                            try {
                                mapArr[1] = openApiRequest2.query;
                                teaRequest2.query = TeaConverter.merge((Class) cls, (Map<String, ?>[]) mapArr);
                                Map[] mapArr2 = new Map[3];
                                TeaPair[] teaPairArr = new TeaPair[7];
                                str2 = str3;
                                i = i3;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, client._endpoint);
                                        try {
                                            teaPairArr[1] = new TeaPair("x-acs-version", params.version);
                                            teaPairArr[2] = new TeaPair("x-acs-action", params.action);
                                            teaPairArr[3] = new TeaPair("user-agent", getUserAgent());
                                            try {
                                                teaPairArr[4] = new TeaPair("x-acs-date", com.aliyun.openapiutil.Client.getTimestamp());
                                                teaPairArr[5] = new TeaPair("x-acs-signature-nonce", Common.getNonce());
                                                teaPairArr[6] = new TeaPair(SubscribeResouceItemModel.ACCEPT, ze1.g);
                                                try {
                                                    mapArr2[0] = TeaConverter.buildMap(teaPairArr);
                                                    try {
                                                        mapArr2[1] = map2;
                                                        mapArr2[2] = openApiRequest2.headers;
                                                        teaRequest2.headers = TeaConverter.merge((Class) cls, (Map<String, ?>[]) mapArr2);
                                                        if (Common.equalString(params.style, "RPC")) {
                                                            try {
                                                                Map<String, String> rpcHeaders = getRpcHeaders();
                                                                if (!Common.isUnset(rpcHeaders)) {
                                                                    Map[] mapArr3 = new Map[2];
                                                                    try {
                                                                        mapArr3[0] = teaRequest2.headers;
                                                                        try {
                                                                            mapArr3[1] = rpcHeaders;
                                                                            teaRequest2.headers = TeaConverter.merge((Class) cls, (Map<String, ?>[]) mapArr3);
                                                                        } catch (Exception e2) {
                                                                            exc = e2;
                                                                            cls = cls;
                                                                            str4 = str4;
                                                                        }
                                                                    } catch (Exception e3) {
                                                                        exc = e3;
                                                                        cls = cls;
                                                                        str4 = str4;
                                                                    }
                                                                }
                                                            } catch (Exception e4) {
                                                                exc = e4;
                                                                cls = cls;
                                                                if (!Tea.isRetryable(exc)) {
                                                                    throw exc;
                                                                }
                                                                client = this;
                                                                openApiRequest2 = openApiRequest;
                                                                str4 = str4;
                                                                jCurrentTimeMillis = j;
                                                                str5 = str;
                                                                str3 = str2;
                                                                i2 = i;
                                                                cls = cls;
                                                            }
                                                        }
                                                        String strDefaultString = Common.defaultString(client._signatureAlgorithm, com.aliyun.openapiutil.Client.HMAC_SHA256);
                                                        String strHexEncode = com.aliyun.openapiutil.Client.hexEncode(com.aliyun.openapiutil.Client.hash(Common.toBytes(""), strDefaultString));
                                                        if (Common.isUnset(openApiRequest2.stream)) {
                                                            cls = cls;
                                                            if (!Common.isUnset(openApiRequest2.body)) {
                                                                if (Common.equalString(params.reqBodyType, "byte")) {
                                                                    byte[] bArrAssertAsBytes = Common.assertAsBytes(openApiRequest2.body);
                                                                    strHexEncode = com.aliyun.openapiutil.Client.hexEncode(com.aliyun.openapiutil.Client.hash(bArrAssertAsBytes, strDefaultString));
                                                                    teaRequest2.body = Tea.toReadable(bArrAssertAsBytes);
                                                                } else if (Common.equalString(params.reqBodyType, "json")) {
                                                                    String jSONString = Common.toJSONString(openApiRequest2.body);
                                                                    strHexEncode = com.aliyun.openapiutil.Client.hexEncode(com.aliyun.openapiutil.Client.hash(Common.toBytes(jSONString), strDefaultString));
                                                                    teaRequest2.body = Tea.toReadable(jSONString);
                                                                    teaRequest2.headers.put(e.f, "application/json; charset=utf-8");
                                                                } else {
                                                                    String form = com.aliyun.openapiutil.Client.toForm(Common.assertAsMap(openApiRequest2.body));
                                                                    strHexEncode = com.aliyun.openapiutil.Client.hexEncode(com.aliyun.openapiutil.Client.hash(Common.toBytes(form), strDefaultString));
                                                                    teaRequest2.body = Tea.toReadable(form);
                                                                    teaRequest2.headers.put(e.f, "application/x-www-form-urlencoded");
                                                                }
                                                            }
                                                        } else {
                                                            try {
                                                                byte[] asBytes = Common.readAsBytes(openApiRequest2.stream);
                                                                String strHexEncode2 = com.aliyun.openapiutil.Client.hexEncode(com.aliyun.openapiutil.Client.hash(asBytes, strDefaultString));
                                                                teaRequest2.body = Tea.toReadable(asBytes);
                                                                cls = cls;
                                                                try {
                                                                    teaRequest2.headers.put(e.f, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                                                                    strHexEncode = strHexEncode2;
                                                                } catch (Exception e5) {
                                                                    e = e5;
                                                                    exc = e;
                                                                    if (!Tea.isRetryable(exc)) {
                                                                        throw exc;
                                                                    }
                                                                    client = this;
                                                                    openApiRequest2 = openApiRequest;
                                                                    str4 = str4;
                                                                    jCurrentTimeMillis = j;
                                                                    str5 = str;
                                                                    str3 = str2;
                                                                    i2 = i;
                                                                    cls = cls;
                                                                }
                                                            } catch (Exception e6) {
                                                                e = e6;
                                                                cls = cls;
                                                            }
                                                        }
                                                        try {
                                                            teaRequest2.headers.put("x-acs-content-sha256", strHexEncode);
                                                            if (!Common.equalString(params.authType, "Anonymous")) {
                                                                try {
                                                                    CredentialModel credential = client._credential.getCredential();
                                                                    if (Common.equalString(credential.type, AuthConstant.BEARER)) {
                                                                        teaRequest2.headers.put("x-acs-bearer-token", credential.bearerToken);
                                                                    } else {
                                                                        String str6 = credential.accessKeyId;
                                                                        String str7 = credential.accessKeySecret;
                                                                        String str8 = credential.securityToken;
                                                                        if (!Common.empty(str8)) {
                                                                            TeaRequest teaRequest3 = teaRequest;
                                                                            try {
                                                                                teaRequest2.headers.put("x-acs-accesskey-id", str6);
                                                                                teaRequest2.headers.put("x-acs-security-token", str8);
                                                                            } catch (Exception e7) {
                                                                                exc = e7;
                                                                                teaRequest = teaRequest3;
                                                                                if (!Tea.isRetryable(exc)) {
                                                                                    throw exc;
                                                                                }
                                                                                client = this;
                                                                                openApiRequest2 = openApiRequest;
                                                                                str4 = str4;
                                                                                jCurrentTimeMillis = j;
                                                                                str5 = str;
                                                                                str3 = str2;
                                                                                i2 = i;
                                                                                cls = cls;
                                                                            }
                                                                        }
                                                                        teaRequest2.headers.put("Authorization", com.aliyun.openapiutil.Client.getAuthorization(teaRequest2, strDefaultString, strHexEncode, str6, str7));
                                                                    }
                                                                } catch (Exception e8) {
                                                                    e = e8;
                                                                    exc = e;
                                                                    if (!Tea.isRetryable(exc)) {
                                                                        throw exc;
                                                                    }
                                                                    client = this;
                                                                    openApiRequest2 = openApiRequest;
                                                                    str4 = str4;
                                                                    jCurrentTimeMillis = j;
                                                                    str5 = str;
                                                                    str3 = str2;
                                                                    i2 = i;
                                                                    cls = cls;
                                                                }
                                                            }
                                                            try {
                                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap, interceptorChain);
                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    try {
                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                if (Common.equalString(params.bodyType, "binary")) {
                                                                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                                                                    try {
                                                                                        teaPairArr2[0] = new TeaPair("body", teaResponseDoAction.body);
                                                                                        teaPairArr2[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                        teaPairArr2[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                        return TeaConverter.buildMap(teaPairArr2);
                                                                                    } catch (Exception e9) {
                                                                                        e = e9;
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        if (Common.equalString(params.bodyType, "byte")) {
                                                                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                                            teaPairArr3[0] = new TeaPair("body", Common.readAsBytes(teaResponseDoAction.body));
                                                                                            teaPairArr3[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                            teaPairArr3[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                            return TeaConverter.buildMap(teaPairArr3);
                                                                                        }
                                                                                        if (Common.equalString(params.bodyType, TypedValues.Custom.S_STRING)) {
                                                                                            TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                                            teaPairArr4[0] = new TeaPair("body", Common.readAsString(teaResponseDoAction.body));
                                                                                            teaPairArr4[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                            teaPairArr4[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                            return TeaConverter.buildMap(teaPairArr4);
                                                                                        }
                                                                                        if (Common.equalString(params.bodyType, "json")) {
                                                                                            TeaPair[] teaPairArr5 = new TeaPair[3];
                                                                                            teaPairArr5[0] = new TeaPair("body", Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body)));
                                                                                            teaPairArr5[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                            teaPairArr5[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                            return TeaConverter.buildMap(teaPairArr5);
                                                                                        }
                                                                                        if (Common.equalString(params.bodyType, "array")) {
                                                                                            TeaPair[] teaPairArr6 = new TeaPair[3];
                                                                                            teaPairArr6[0] = new TeaPair("body", Common.readAsJSON(teaResponseDoAction.body));
                                                                                            teaPairArr6[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                            teaPairArr6[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                            return TeaConverter.buildMap(teaPairArr6);
                                                                                        }
                                                                                        TeaPair[] teaPairArr7 = new TeaPair[3];
                                                                                        teaPairArr7[0] = new TeaPair("body", Common.readAsString(teaResponseDoAction.body));
                                                                                        teaPairArr7[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                        teaPairArr7[2] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                        return TeaConverter.buildMap(teaPairArr7);
                                                                                    } catch (Exception e10) {
                                                                                        e = e10;
                                                                                    }
                                                                                }
                                                                                teaRequest = teaRequest2;
                                                                            } catch (Exception e11) {
                                                                                e = e11;
                                                                                teaRequest = teaRequest2;
                                                                                str4 = str4;
                                                                                exc = e;
                                                                                if (!Tea.isRetryable(exc)) {
                                                                                    throw exc;
                                                                                }
                                                                                client = this;
                                                                                openApiRequest2 = openApiRequest;
                                                                                str4 = str4;
                                                                                jCurrentTimeMillis = j;
                                                                                str5 = str;
                                                                                str3 = str2;
                                                                                i2 = i;
                                                                                cls = cls;
                                                                            }
                                                                            str4 = str4;
                                                                            exc = e;
                                                                            if (!Tea.isRetryable(exc)) {
                                                                                throw exc;
                                                                            }
                                                                            client = this;
                                                                            openApiRequest2 = openApiRequest;
                                                                            str4 = str4;
                                                                            jCurrentTimeMillis = j;
                                                                            str5 = str;
                                                                            str3 = str2;
                                                                            i2 = i;
                                                                            cls = cls;
                                                                        }
                                                                    } catch (Exception e12) {
                                                                        e = e12;
                                                                        teaRequest = teaRequest2;
                                                                        exc = e;
                                                                        if (!Tea.isRetryable(exc)) {
                                                                            throw exc;
                                                                        }
                                                                        client = this;
                                                                        openApiRequest2 = openApiRequest;
                                                                        str4 = str4;
                                                                        jCurrentTimeMillis = j;
                                                                        str5 = str;
                                                                        str3 = str2;
                                                                        i2 = i;
                                                                        cls = cls;
                                                                    }
                                                                }
                                                                new HashMap();
                                                                Map<String, Object> mapAssertAsMap = (Common.isUnset(teaResponseDoAction.headers.get(e.f)) || !Common.equalString(teaResponseDoAction.headers.get(e.f), "text/xml;charset=utf-8")) ? Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body)) : Common.assertAsMap(com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), null).get("Error"));
                                                                mapAssertAsMap.put("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                TeaPair[] teaPairArr8 = new TeaPair[5];
                                                                try {
                                                                    teaPairArr8[0] = new TeaPair("code", "" + defaultAny(mapAssertAsMap.get("Code"), mapAssertAsMap.get("code")) + "");
                                                                    try {
                                                                        teaPairArr8[1] = new TeaPair("message", "code: " + teaResponseDoAction.statusCode + ", " + defaultAny(mapAssertAsMap.get("Message"), mapAssertAsMap.get("message")) + " request id: " + defaultAny(mapAssertAsMap.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID), mapAssertAsMap.get("requestId")) + "");
                                                                        teaPairArr8[2] = new TeaPair("data", mapAssertAsMap);
                                                                        StringBuilder sb = new StringBuilder();
                                                                        sb.append("");
                                                                        str4 = str4;
                                                                        try {
                                                                            sb.append(defaultAny(mapAssertAsMap.get(AliyunVodKey.KEY_VOD_DESCRIPTION), mapAssertAsMap.get(str4)));
                                                                            sb.append("");
                                                                            teaPairArr8[3] = new TeaPair(str4, sb.toString());
                                                                            try {
                                                                                teaPairArr8[4] = new TeaPair("accessDeniedDetail", defaultAny(mapAssertAsMap.get("AccessDeniedDetail"), mapAssertAsMap.get("accessDeniedDetail")));
                                                                                throw new TeaException(TeaConverter.buildMap(teaPairArr8));
                                                                            } catch (Exception e13) {
                                                                                e = e13;
                                                                                teaRequest = teaRequest2;
                                                                                exc = e;
                                                                                if (!Tea.isRetryable(exc)) {
                                                                                    throw exc;
                                                                                }
                                                                                client = this;
                                                                                openApiRequest2 = openApiRequest;
                                                                                str4 = str4;
                                                                                jCurrentTimeMillis = j;
                                                                                str5 = str;
                                                                                str3 = str2;
                                                                                i2 = i;
                                                                                cls = cls;
                                                                            }
                                                                        } catch (Exception e14) {
                                                                            e = e14;
                                                                            teaRequest = teaRequest2;
                                                                            exc = e;
                                                                            if (!Tea.isRetryable(exc)) {
                                                                                throw exc;
                                                                            }
                                                                            client = this;
                                                                            openApiRequest2 = openApiRequest;
                                                                            str4 = str4;
                                                                            jCurrentTimeMillis = j;
                                                                            str5 = str;
                                                                            str3 = str2;
                                                                            i2 = i;
                                                                            cls = cls;
                                                                        }
                                                                    } catch (Exception e15) {
                                                                        e = e15;
                                                                        str4 = str4;
                                                                    }
                                                                } catch (Exception e16) {
                                                                    e = e16;
                                                                    teaRequest = teaRequest2;
                                                                    exc = e;
                                                                    if (!Tea.isRetryable(exc)) {
                                                                        throw exc;
                                                                    }
                                                                    client = this;
                                                                    openApiRequest2 = openApiRequest;
                                                                    str4 = str4;
                                                                    jCurrentTimeMillis = j;
                                                                    str5 = str;
                                                                    str3 = str2;
                                                                    i2 = i;
                                                                    cls = cls;
                                                                }
                                                            } catch (Exception e17) {
                                                                e = e17;
                                                            }
                                                        } catch (Exception e18) {
                                                            e = e18;
                                                            exc = e;
                                                            if (!Tea.isRetryable(exc)) {
                                                                throw exc;
                                                            }
                                                            client = this;
                                                            openApiRequest2 = openApiRequest;
                                                            str4 = str4;
                                                            jCurrentTimeMillis = j;
                                                            str5 = str;
                                                            str3 = str2;
                                                            i2 = i;
                                                            cls = cls;
                                                        }
                                                    } catch (Exception e19) {
                                                        e = e19;
                                                        str4 = str4;
                                                        exc = e;
                                                        if (!Tea.isRetryable(exc)) {
                                                            throw exc;
                                                        }
                                                        client = this;
                                                        openApiRequest2 = openApiRequest;
                                                        str4 = str4;
                                                        jCurrentTimeMillis = j;
                                                        str5 = str;
                                                        str3 = str2;
                                                        i2 = i;
                                                        cls = cls;
                                                    }
                                                } catch (Exception e20) {
                                                    e = e20;
                                                }
                                            } catch (Exception e21) {
                                                e = e21;
                                                cls = cls;
                                            }
                                        } catch (Exception e22) {
                                            e = e22;
                                        }
                                    } catch (Exception e23) {
                                        e = e23;
                                    }
                                } catch (Exception e24) {
                                    e = e24;
                                    cls = cls;
                                }
                            } catch (Exception e25) {
                                e = e25;
                                cls = cls;
                                str2 = str3;
                                i = i3;
                                str4 = str4;
                            }
                        } catch (Exception e26) {
                            e = e26;
                            cls = cls;
                            str2 = str3;
                            i = i3;
                            str4 = str4;
                        }
                    } catch (Exception e27) {
                        e = e27;
                        cls = cls;
                        str2 = str3;
                        i = i3;
                        exc = e;
                        if (!Tea.isRetryable(exc)) {
                            throw exc;
                        }
                        client = this;
                        openApiRequest2 = openApiRequest;
                        str4 = str4;
                        jCurrentTimeMillis = j;
                        str5 = str;
                        str3 = str2;
                        i2 = i;
                        cls = cls;
                    }
                } catch (Exception e28) {
                    e = e28;
                    str = str5;
                    str2 = str3;
                    i = i3;
                    exc = e;
                    if (!Tea.isRetryable(exc)) {
                        throw exc;
                    }
                    client = this;
                    openApiRequest2 = openApiRequest;
                    str4 = str4;
                    jCurrentTimeMillis = j;
                    str5 = str;
                    str3 = str2;
                    i2 = i;
                    cls = cls;
                }
            } catch (Exception e29) {
                e = e29;
                j = jCurrentTimeMillis;
            }
        }
        throw new TeaUnretryableException(teaRequest, exc);
    }

    /* JADX WARN: Code duplicated, block: B:176:0x04b3 A[LOOP:0: B:3:0x0185->B:176:0x04b3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:240:0x04c0 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, ?> execute(Params params, OpenApiRequest openApiRequest, RuntimeOptions runtimeOptions) throws Exception {
        int i;
        String str;
        String str2;
        long j;
        char c;
        int backoffTime;
        TeaModel.validateParams(params, "params");
        TeaModel.validateParams(openApiRequest, "request");
        String str3 = "retry";
        char c2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair(CachedContentIndex.a.e, Common.defaultString(runtimeOptions.key, this._key)), new TeaPair("cert", Common.defaultString(runtimeOptions.cert, this._cert)), new TeaPair("ca", Common.defaultString(runtimeOptions.ca, this._ca)), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", runtimeOptions.autoretry), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", runtimeOptions.ignoreSSL), new TeaPair("disableHttp2", defaultAny(this._disableHttp2, Boolean.FALSE)));
        int i2 = 0;
        TeaRequest teaRequest = null;
        Exception e = null;
        for (long jCurrentTimeMillis = System.currentTimeMillis(); Tea.allowRetry((Map) mapBuildMap.get(str3), i2, jCurrentTimeMillis); jCurrentTimeMillis = j) {
            if (i2 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i2)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i3 = i2 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                Map<String, String> rpcHeaders = getRpcHeaders();
                Map<String, String> map = new HashMap<>();
                Map<String, String> map2 = new HashMap<>();
                try {
                    if (Common.isUnset(this._globalParameters)) {
                        i = i3;
                    } else {
                        GlobalParameters globalParameters = this._globalParameters;
                        i = i3;
                        try {
                            if (!Common.isUnset(globalParameters.queries)) {
                                map = globalParameters.queries;
                            }
                            if (!Common.isUnset(globalParameters.headers)) {
                                map2 = globalParameters.headers;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = str4;
                            str2 = str3;
                            j = jCurrentTimeMillis;
                            c = 3;
                            if (!Tea.isRetryable(e)) {
                                throw e;
                            }
                            c2 = c;
                            i2 = i;
                            str4 = str;
                            str3 = str2;
                        }
                    }
                    TeaPair[] teaPairArr = new TeaPair[19];
                    str = str4;
                    str2 = str3;
                    j = jCurrentTimeMillis;
                    try {
                        Map[] mapArr = new Map[3];
                        try {
                            mapArr[0] = map2;
                            try {
                                boolean z = true;
                                try {
                                    mapArr[1] = openApiRequest.headers;
                                    try {
                                        mapArr[2] = rpcHeaders;
                                        try {
                                            teaPairArr[0] = new TeaPair("headers", TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr));
                                            try {
                                                Map[] mapArr2 = new Map[2];
                                                mapArr2[0] = map;
                                                z = true;
                                                mapArr2[1] = openApiRequest.query;
                                                teaPairArr[1] = new TeaPair("query", TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr2));
                                                try {
                                                    teaPairArr[2] = new TeaPair("body", openApiRequest.body);
                                                    try {
                                                        teaPairArr[3] = new TeaPair("stream", openApiRequest.stream);
                                                        teaPairArr[4] = new TeaPair("hostMap", openApiRequest.hostMap);
                                                        teaPairArr[5] = new TeaPair("pathname", params.pathname);
                                                        teaPairArr[6] = new TeaPair("productId", this._productId);
                                                        teaPairArr[7] = new TeaPair("action", params.action);
                                                        teaPairArr[8] = new TeaPair("version", params.version);
                                                        teaPairArr[9] = new TeaPair("protocol", Common.defaultString(this._protocol, params.protocol));
                                                        teaPairArr[10] = new TeaPair("method", Common.defaultString(this._method, params.method));
                                                        try {
                                                            teaPairArr[11] = new TeaPair("authType", params.authType);
                                                            teaPairArr[12] = new TeaPair("bodyType", params.bodyType);
                                                            teaPairArr[13] = new TeaPair("reqBodyType", params.reqBodyType);
                                                            teaPairArr[14] = new TeaPair("style", params.style);
                                                            teaPairArr[15] = new TeaPair("credential", this._credential);
                                                            teaPairArr[16] = new TeaPair("signatureVersion", this._signatureVersion);
                                                            teaPairArr[17] = new TeaPair("signatureAlgorithm", this._signatureAlgorithm);
                                                            teaPairArr[18] = new TeaPair(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, getUserAgent());
                                                            InterceptorContext.InterceptorContextRequest interceptorContextRequestBuild = InterceptorContext.InterceptorContextRequest.build(TeaConverter.buildMap(teaPairArr));
                                                            TeaPair[] teaPairArr2 = new TeaPair[7];
                                                            try {
                                                                teaPairArr2[0] = new TeaPair("regionId", this._regionId);
                                                                try {
                                                                    teaPairArr2[1] = new TeaPair("endpoint", Common.defaultString(openApiRequest.endpointOverride, this._endpoint));
                                                                    try {
                                                                        teaPairArr2[2] = new TeaPair("endpointRule", this._endpointRule);
                                                                        try {
                                                                            teaPairArr2[3] = new TeaPair("endpointMap", this._endpointMap);
                                                                            teaPairArr2[4] = new TeaPair("endpointType", this._endpointType);
                                                                            teaPairArr2[5] = new TeaPair("network", this._network);
                                                                            teaPairArr2[6] = new TeaPair("suffix", this._suffix);
                                                                            InterceptorContext.InterceptorContextConfiguration interceptorContextConfigurationBuild = InterceptorContext.InterceptorContextConfiguration.build(TeaConverter.buildMap(teaPairArr2));
                                                                            try {
                                                                                TeaPair[] teaPairArr3 = new TeaPair[2];
                                                                                try {
                                                                                    teaPairArr3[0] = new TeaPair("request", interceptorContextRequestBuild);
                                                                                    try {
                                                                                        teaPairArr3[1] = new TeaPair("configuration", interceptorContextConfigurationBuild);
                                                                                        InterceptorContext interceptorContextBuild = InterceptorContext.build(TeaConverter.buildMap(teaPairArr3));
                                                                                        AttributeMap attributeMap = new AttributeMap();
                                                                                        this._spi.modifyConfiguration(interceptorContextBuild, attributeMap);
                                                                                        this._spi.modifyRequest(interceptorContextBuild, attributeMap);
                                                                                        InterceptorContext.InterceptorContextRequest interceptorContextRequest = interceptorContextBuild.request;
                                                                                        teaRequest2.protocol = interceptorContextRequest.protocol;
                                                                                        teaRequest2.method = interceptorContextRequest.method;
                                                                                        teaRequest2.pathname = interceptorContextRequest.pathname;
                                                                                        teaRequest2.query = interceptorContextRequest.query;
                                                                                        teaRequest2.body = interceptorContextRequest.stream;
                                                                                        teaRequest2.headers = interceptorContextRequest.headers;
                                                                                        try {
                                                                                            TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap, interceptorChain);
                                                                                            try {
                                                                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                                                try {
                                                                                                    teaPairArr4[0] = new TeaPair("statusCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                                    try {
                                                                                                        teaPairArr4[1] = new TeaPair("headers", teaResponseDoAction.headers);
                                                                                                        try {
                                                                                                            teaPairArr4[2] = new TeaPair("body", teaResponseDoAction.body);
                                                                                                            interceptorContextBuild.response = InterceptorContext.InterceptorContextResponse.build(TeaConverter.buildMap(teaPairArr4));
                                                                                                            this._spi.modifyResponse(interceptorContextBuild, attributeMap);
                                                                                                            c = 3;
                                                                                                            try {
                                                                                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                                                                                try {
                                                                                                                    teaPairArr5[0] = new TeaPair("headers", interceptorContextBuild.response.headers);
                                                                                                                    try {
                                                                                                                        teaPairArr5[1] = new TeaPair("statusCode", interceptorContextBuild.response.statusCode);
                                                                                                                        try {
                                                                                                                            teaPairArr5[2] = new TeaPair("body", interceptorContextBuild.response.deserializedBody);
                                                                                                                            return TeaConverter.buildMap(teaPairArr5);
                                                                                                                        } catch (Exception e3) {
                                                                                                                            e = e3;
                                                                                                                            teaRequest = teaRequest2;
                                                                                                                            if (!Tea.isRetryable(e)) {
                                                                                                                                throw e;
                                                                                                                            }
                                                                                                                            c2 = c;
                                                                                                                            i2 = i;
                                                                                                                            str4 = str;
                                                                                                                            str3 = str2;
                                                                                                                        }
                                                                                                                    } catch (Exception e4) {
                                                                                                                        e = e4;
                                                                                                                        teaRequest = teaRequest2;
                                                                                                                        if (!Tea.isRetryable(e)) {
                                                                                                                            throw e;
                                                                                                                        }
                                                                                                                        c2 = c;
                                                                                                                        i2 = i;
                                                                                                                        str4 = str;
                                                                                                                        str3 = str2;
                                                                                                                    }
                                                                                                                } catch (Exception e5) {
                                                                                                                    e = e5;
                                                                                                                    teaRequest = teaRequest2;
                                                                                                                    if (!Tea.isRetryable(e)) {
                                                                                                                        throw e;
                                                                                                                    }
                                                                                                                    c2 = c;
                                                                                                                    i2 = i;
                                                                                                                    str4 = str;
                                                                                                                    str3 = str2;
                                                                                                                }
                                                                                                            } catch (Exception e6) {
                                                                                                                e = e6;
                                                                                                                teaRequest = teaRequest2;
                                                                                                                if (!Tea.isRetryable(e)) {
                                                                                                                    throw e;
                                                                                                                }
                                                                                                                c2 = c;
                                                                                                                i2 = i;
                                                                                                                str4 = str;
                                                                                                                str3 = str2;
                                                                                                            }
                                                                                                        } catch (Exception e7) {
                                                                                                            e = e7;
                                                                                                            c = 3;
                                                                                                        }
                                                                                                    } catch (Exception e8) {
                                                                                                        e = e8;
                                                                                                        c = 3;
                                                                                                    }
                                                                                                } catch (Exception e9) {
                                                                                                    e = e9;
                                                                                                    c = 3;
                                                                                                }
                                                                                            } catch (Exception e10) {
                                                                                                e = e10;
                                                                                                c = 3;
                                                                                            }
                                                                                        } catch (Exception e11) {
                                                                                            e = e11;
                                                                                            c = 3;
                                                                                        }
                                                                                    } catch (Exception e12) {
                                                                                        e = e12;
                                                                                        c = 3;
                                                                                        if (!Tea.isRetryable(e)) {
                                                                                            throw e;
                                                                                        }
                                                                                        c2 = c;
                                                                                        i2 = i;
                                                                                        str4 = str;
                                                                                        str3 = str2;
                                                                                    }
                                                                                } catch (Exception e13) {
                                                                                    e = e13;
                                                                                    c = 3;
                                                                                    if (!Tea.isRetryable(e)) {
                                                                                        throw e;
                                                                                    }
                                                                                    c2 = c;
                                                                                    i2 = i;
                                                                                    str4 = str;
                                                                                    str3 = str2;
                                                                                }
                                                                            } catch (Exception e14) {
                                                                                e = e14;
                                                                                c = 3;
                                                                                if (!Tea.isRetryable(e)) {
                                                                                    throw e;
                                                                                }
                                                                                c2 = c;
                                                                                i2 = i;
                                                                                str4 = str;
                                                                                str3 = str2;
                                                                            }
                                                                        } catch (Exception e15) {
                                                                            e = e15;
                                                                            c = 3;
                                                                            if (!Tea.isRetryable(e)) {
                                                                                throw e;
                                                                            }
                                                                            c2 = c;
                                                                            i2 = i;
                                                                            str4 = str;
                                                                            str3 = str2;
                                                                        }
                                                                    } catch (Exception e16) {
                                                                        e = e16;
                                                                    }
                                                                } catch (Exception e17) {
                                                                    e = e17;
                                                                    c = 3;
                                                                    if (!Tea.isRetryable(e)) {
                                                                        throw e;
                                                                    }
                                                                    c2 = c;
                                                                    i2 = i;
                                                                    str4 = str;
                                                                    str3 = str2;
                                                                }
                                                            } catch (Exception e18) {
                                                                e = e18;
                                                            }
                                                        } catch (Exception e19) {
                                                            e = e19;
                                                            c = 3;
                                                        }
                                                    } catch (Exception e20) {
                                                        e = e20;
                                                        c = 3;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw e;
                                                        }
                                                        c2 = c;
                                                        i2 = i;
                                                        str4 = str;
                                                        str3 = str2;
                                                    }
                                                } catch (Exception e21) {
                                                    e = e21;
                                                    c = 3;
                                                    if (!Tea.isRetryable(e)) {
                                                        throw e;
                                                    }
                                                    c2 = c;
                                                    i2 = i;
                                                    str4 = str;
                                                    str3 = str2;
                                                }
                                            } catch (Exception e22) {
                                                e = e22;
                                                c = 3;
                                                if (!Tea.isRetryable(e)) {
                                                    throw e;
                                                }
                                                c2 = c;
                                                i2 = i;
                                                str4 = str;
                                                str3 = str2;
                                            }
                                        } catch (Exception e23) {
                                            e = e23;
                                            c = 3;
                                            if (!Tea.isRetryable(e)) {
                                                throw e;
                                            }
                                            c2 = c;
                                            i2 = i;
                                            str4 = str;
                                            str3 = str2;
                                        }
                                    } catch (Exception e24) {
                                        e = e24;
                                    }
                                } catch (Exception e25) {
                                    e = e25;
                                    c = 3;
                                }
                            } catch (Exception e26) {
                                e = e26;
                                c = 3;
                                if (!Tea.isRetryable(e)) {
                                    throw e;
                                }
                                c2 = c;
                                i2 = i;
                                str4 = str;
                                str3 = str2;
                            }
                        } catch (Exception e27) {
                            e = e27;
                        }
                    } catch (Exception e28) {
                        e = e28;
                        c = 3;
                    }
                } catch (Exception e29) {
                    e = e29;
                    i = i3;
                }
            } catch (Exception e30) {
                e = e30;
                i = i3;
                str = str4;
                str2 = str3;
                j = jCurrentTimeMillis;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest, e);
    }

    public String getAccessKeyId() throws Exception {
        return Common.isUnset(this._credential) ? "" : this._credential.getAccessKeyId();
    }

    public String getAccessKeySecret() throws Exception {
        return Common.isUnset(this._credential) ? "" : this._credential.getAccessKeySecret();
    }

    public String getBearerToken() throws Exception {
        return Common.isUnset(this._credential) ? "" : this._credential.getBearerToken();
    }

    public Map<String, String> getRpcHeaders() throws Exception {
        Map<String, String> map = this._headers;
        this._headers = null;
        return map;
    }

    public String getSecurityToken() throws Exception {
        return Common.isUnset(this._credential) ? "" : this._credential.getSecurityToken();
    }

    public String getType() throws Exception {
        return Common.isUnset(this._credential) ? "" : this._credential.getType();
    }

    public String getUserAgent() throws Exception {
        return Common.getUserAgent(this._userAgent);
    }

    public void setGatewayClient(com.aliyun.gateway.spi.Client client) throws Exception {
        this._spi = client;
    }

    public void setRpcHeaders(Map<String, String> map) throws Exception {
        this._headers = map;
    }
}
