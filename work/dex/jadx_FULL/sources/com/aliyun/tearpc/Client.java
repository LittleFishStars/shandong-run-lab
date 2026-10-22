package com.aliyun.tearpc;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alipay.sdk.m.n.c;
import com.alipay.sdk.m.t.e;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.tea.Tea;
import com.aliyun.tea.TeaConverter;
import com.aliyun.tea.TeaException;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.TeaPair;
import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.TeaResponse;
import com.aliyun.tea.TeaUnretryableException;
import com.aliyun.tearpc.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Client {
    public Integer _connectTimeout;
    public com.aliyun.credentials.Client _credential;
    public String _endpoint;
    public Map<String, String> _endpointMap;
    public String _endpointRule;
    public String _endpointType;
    public String _httpProxy;
    public String _httpsProxy;
    public Integer _maxIdleConns;
    public String _network;
    public String _noProxy;
    public String _openPlatformEndpoint;
    public String _productId;
    public String _protocol;
    public Integer _readTimeout;
    public String _regionId;
    public String _socks5NetWork;
    public String _socks5Proxy;
    public String _suffix;
    public String _userAgent;

    public Client(Config config) throws Exception {
        if (Common.isUnset(TeaModel.buildMap(config))) {
            throw new TeaException(TeaConverter.buildMap(new TeaPair("code", "ParameterMissing"), new TeaPair("message", "'config' can not be unset")));
        }
        Common.validateModel(config);
        if (!Common.empty(config.accessKeyId) && !Common.empty(config.accessKeySecret)) {
            if (Common.empty(config.securityToken)) {
                config.type = AuthConstant.ACCESS_KEY;
            } else {
                config.type = AuthConstant.STS;
            }
            this._credential = new com.aliyun.credentials.Client(com.aliyun.credentials.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", config.accessKeyId), new TeaPair("type", config.type), new TeaPair("accessKeySecret", config.accessKeySecret), new TeaPair("securityToken", config.securityToken))));
        } else {
            if (Common.isUnset(config.credential)) {
                throw new TeaException(TeaConverter.buildMap(new TeaPair("code", "ParameterMissing"), new TeaPair("message", "'accessKeyId' and 'accessKeySecret' or 'credential' can not be unset")));
            }
            this._credential = config.credential;
        }
        this._network = config.network;
        this._suffix = config.suffix;
        this._endpoint = config.endpoint;
        this._protocol = config.protocol;
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
        this._endpointType = config.endpointType;
        this._openPlatformEndpoint = config.openPlatformEndpoint;
    }

    public static Object defaultAny(Object obj, Object obj2) throws Exception {
        return Common.isUnset(obj) ? obj2 : obj;
    }

    public void checkConfig(Config config) throws Exception {
        if (Common.empty(this._endpointRule) && Common.empty(config.endpoint)) {
            throw new TeaException(TeaConverter.buildMap(new TeaPair("code", "ParameterMissing"), new TeaPair("message", "'config.endpoint' can not be empty")));
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0385 A[LOOP:0: B:3:0x0106->B:133:0x0385, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:184:0x0392 A[SYNTHETIC] */
    public Map<String, ?> doRequest(String str, String str2, String str3, String str4, String str5, Map<String, ?> map, Map<String, ?> map2, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        int backoffTime;
        Client client = this;
        String str6 = "retry";
        boolean z2 = false;
        String str7 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, client._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, client._connectTimeout)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, client._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, client._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, client._noProxy)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, client._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", runtimeOptions.autoretry), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", runtimeOptions.ignoreSSL));
        long jCurrentTimeMillis = System.currentTimeMillis();
        Exception e = null;
        TeaRequest teaRequest = null;
        int i = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str6), i, jCurrentTimeMillis)) {
            if (i > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str7), i)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i2 = i + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                try {
                    teaRequest2.protocol = Common.defaultString(client._protocol, str2);
                    teaRequest2.method = str3;
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER;
                    str6 = str6;
                    try {
                        Map[] mapArr = new Map[2];
                        i2 = i2;
                        try {
                            TeaPair[] teaPairArr = new TeaPair[5];
                            str7 = str7;
                            try {
                                try {
                                    teaPairArr[0] = new TeaPair(AliyunVodKey.KEY_VOD_ACTION, str);
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    try {
                                        try {
                                            teaPairArr[1] = new TeaPair(AliyunVodKey.KEY_VOD_COMMON_FORMAT, "json");
                                            char c = 2;
                                            try {
                                                teaPairArr[2] = new TeaPair("Timestamp", com.aliyun.common.Common.getTimestamp());
                                                teaPairArr[3] = new TeaPair("Version", str4);
                                                teaPairArr[4] = new TeaPair(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_NONCE, Common.getNonce());
                                                Map mapBuildMap2 = TeaConverter.buildMap(teaPairArr);
                                                boolean z3 = false;
                                                try {
                                                    mapArr[0] = mapBuildMap2;
                                                    try {
                                                        mapArr[1] = map;
                                                        teaRequest2.query = com.aliyun.common.Common.query(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr));
                                                        TeaPair[] teaPairArr2 = new TeaPair[4];
                                                        z3 = false;
                                                        teaPairArr2[0] = new TeaPair("x-acs-version", str4);
                                                        try {
                                                            teaPairArr2[1] = new TeaPair("x-acs-action", str);
                                                            try {
                                                                teaPairArr2[2] = new TeaPair(c.f, client._endpoint);
                                                                teaPairArr2[3] = new TeaPair("user-agent", getUserAgent());
                                                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr2);
                                                                if (!Common.isUnset(map2)) {
                                                                    teaRequest2.body = Tea.toReadable(Common.toFormString(Common.anyifyMapValue(com.aliyun.common.Common.query(map2))));
                                                                    teaRequest2.headers.put(e.f, "application/x-www-form-urlencoded");
                                                                }
                                                                try {
                                                                    if (!Common.equalString(str5, "Anonymous")) {
                                                                        String accessKeyId = getAccessKeyId();
                                                                        String accessKeySecret = getAccessKeySecret();
                                                                        String securityToken = getSecurityToken();
                                                                        if (!Common.empty(securityToken)) {
                                                                            teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN, securityToken);
                                                                        }
                                                                        teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_METHOD, "HMAC-SHA1");
                                                                        teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_VERSION, "1.0");
                                                                        teaRequest2.query.put(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID, accessKeyId);
                                                                        c = 2;
                                                                        try {
                                                                            Map[] mapArr2 = new Map[2];
                                                                            try {
                                                                                mapArr2[0] = teaRequest2.query;
                                                                                try {
                                                                                    mapArr2[1] = com.aliyun.common.Common.query(map2);
                                                                                    teaRequest2.query.put("Signature", com.aliyun.common.Common.getSignatureV1(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr2), teaRequest2.method, accessKeySecret));
                                                                                } catch (Exception e2) {
                                                                                    e = e2;
                                                                                    z = false;
                                                                                    if (!Tea.isRetryable(e)) {
                                                                                        throw e;
                                                                                    }
                                                                                    i = i2;
                                                                                    z2 = z;
                                                                                    str6 = str6;
                                                                                    str7 = str7;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    client = this;
                                                                                }
                                                                            } catch (Exception e3) {
                                                                                e = e3;
                                                                                z = false;
                                                                                if (!Tea.isRetryable(e)) {
                                                                                    throw e;
                                                                                }
                                                                                i = i2;
                                                                                z2 = z;
                                                                                str6 = str6;
                                                                                str7 = str7;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                client = this;
                                                                            }
                                                                        } catch (Exception e4) {
                                                                            e = e4;
                                                                            z = false;
                                                                            if (!Tea.isRetryable(e)) {
                                                                                throw e;
                                                                            }
                                                                            i = i2;
                                                                            z2 = z;
                                                                            str6 = str6;
                                                                            str7 = str7;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            client = this;
                                                                        }
                                                                    }
                                                                    try {
                                                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                        Map<String, ?> mapAssertAsMap = Common.assertAsMap(Common.readAsJSON(teaResponseDoAction.body));
                                                                        if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                                    return mapAssertAsMap;
                                                                                }
                                                                            } catch (Exception e5) {
                                                                                e = e5;
                                                                                teaRequest = teaRequest2;
                                                                                z = false;
                                                                                if (!Tea.isRetryable(e)) {
                                                                                    throw e;
                                                                                }
                                                                                i = i2;
                                                                                z2 = z;
                                                                                str6 = str6;
                                                                                str7 = str7;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                client = this;
                                                                            }
                                                                        }
                                                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                        z = false;
                                                                        try {
                                                                            teaPairArr3[0] = new TeaPair("code", "" + defaultAny(mapAssertAsMap.get("Code"), mapAssertAsMap.get("code")) + "");
                                                                            try {
                                                                                teaPairArr3[1] = new TeaPair("message", "code: " + teaResponseDoAction.statusCode + ", " + defaultAny(mapAssertAsMap.get("Message"), mapAssertAsMap.get("message")) + " request id: " + defaultAny(mapAssertAsMap.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID), mapAssertAsMap.get("requestId")) + "");
                                                                                try {
                                                                                    teaPairArr3[2] = new TeaPair("data", mapAssertAsMap);
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr3));
                                                                                } catch (Exception e6) {
                                                                                    e = e6;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (!Tea.isRetryable(e)) {
                                                                                        throw e;
                                                                                    }
                                                                                    i = i2;
                                                                                    z2 = z;
                                                                                    str6 = str6;
                                                                                    str7 = str7;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    client = this;
                                                                                }
                                                                            } catch (Exception e7) {
                                                                                e = e7;
                                                                            }
                                                                        } catch (Exception e8) {
                                                                            e = e8;
                                                                            teaRequest = teaRequest2;
                                                                            if (!Tea.isRetryable(e)) {
                                                                                throw e;
                                                                            }
                                                                            i = i2;
                                                                            z2 = z;
                                                                            str6 = str6;
                                                                            str7 = str7;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            client = this;
                                                                        }
                                                                    } catch (Exception e9) {
                                                                        e = e9;
                                                                        z = false;
                                                                    }
                                                                } catch (Exception e10) {
                                                                    e = e10;
                                                                }
                                                            } catch (Exception e11) {
                                                                e = e11;
                                                                z = false;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw e;
                                                                }
                                                                i = i2;
                                                                z2 = z;
                                                                str6 = str6;
                                                                str7 = str7;
                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                client = this;
                                                            }
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                        }
                                                    } catch (Exception e13) {
                                                        e = e13;
                                                    }
                                                } catch (Exception e14) {
                                                    e = e14;
                                                    z = z3;
                                                }
                                            } catch (Exception e15) {
                                                e = e15;
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                    z = false;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                }
                            } catch (Exception e19) {
                                e = e19;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw e;
                                }
                                i = i2;
                                z2 = z;
                                str6 = str6;
                                str7 = str7;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                client = this;
                            }
                        } catch (Exception e20) {
                            e = e20;
                            str7 = str7;
                        }
                    } catch (Exception e21) {
                        e = e21;
                        i2 = i2;
                        str7 = str7;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                    }
                } catch (Exception e22) {
                    e = e22;
                    z = false;
                    if (!Tea.isRetryable(e)) {
                        throw e;
                    }
                    i = i2;
                    z2 = z;
                    str6 = str6;
                    str7 = str7;
                    jCurrentTimeMillis = jCurrentTimeMillis;
                    client = this;
                }
            } catch (Exception e23) {
                e = e23;
                z = z2;
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

    public String getSecurityToken() throws Exception {
        return Common.isUnset(this._credential) ? "" : this._credential.getSecurityToken();
    }

    public String getUserAgent() throws Exception {
        return Common.getUserAgent(this._userAgent);
    }
}
