package com.aliyun.oss;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alipay.sdk.m.n.c;
import com.alipay.sdk.m.t.e;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.oss.models.AbortMultipartUploadRequest;
import com.aliyun.oss.models.AbortMultipartUploadResponse;
import com.aliyun.oss.models.AppendObjectRequest;
import com.aliyun.oss.models.AppendObjectResponse;
import com.aliyun.oss.models.CallbackRequest;
import com.aliyun.oss.models.CallbackResponse;
import com.aliyun.oss.models.CompleteMultipartUploadRequest;
import com.aliyun.oss.models.CompleteMultipartUploadResponse;
import com.aliyun.oss.models.Config;
import com.aliyun.oss.models.CopyObjectRequest;
import com.aliyun.oss.models.CopyObjectResponse;
import com.aliyun.oss.models.DeleteBucketCORSRequest;
import com.aliyun.oss.models.DeleteBucketCORSResponse;
import com.aliyun.oss.models.DeleteBucketEncryptionRequest;
import com.aliyun.oss.models.DeleteBucketEncryptionResponse;
import com.aliyun.oss.models.DeleteBucketLifecycleRequest;
import com.aliyun.oss.models.DeleteBucketLifecycleResponse;
import com.aliyun.oss.models.DeleteBucketLoggingRequest;
import com.aliyun.oss.models.DeleteBucketLoggingResponse;
import com.aliyun.oss.models.DeleteBucketRequest;
import com.aliyun.oss.models.DeleteBucketResponse;
import com.aliyun.oss.models.DeleteBucketTagsRequest;
import com.aliyun.oss.models.DeleteBucketTagsResponse;
import com.aliyun.oss.models.DeleteBucketWebsiteRequest;
import com.aliyun.oss.models.DeleteBucketWebsiteResponse;
import com.aliyun.oss.models.DeleteLiveChannelRequest;
import com.aliyun.oss.models.DeleteLiveChannelResponse;
import com.aliyun.oss.models.DeleteMultipleObjectsRequest;
import com.aliyun.oss.models.DeleteMultipleObjectsResponse;
import com.aliyun.oss.models.DeleteObjectRequest;
import com.aliyun.oss.models.DeleteObjectResponse;
import com.aliyun.oss.models.DeleteObjectTaggingRequest;
import com.aliyun.oss.models.DeleteObjectTaggingResponse;
import com.aliyun.oss.models.GetBucketAclRequest;
import com.aliyun.oss.models.GetBucketAclResponse;
import com.aliyun.oss.models.GetBucketCORSRequest;
import com.aliyun.oss.models.GetBucketCORSResponse;
import com.aliyun.oss.models.GetBucketEncryptionRequest;
import com.aliyun.oss.models.GetBucketEncryptionResponse;
import com.aliyun.oss.models.GetBucketInfoRequest;
import com.aliyun.oss.models.GetBucketInfoResponse;
import com.aliyun.oss.models.GetBucketLifecycleRequest;
import com.aliyun.oss.models.GetBucketLifecycleResponse;
import com.aliyun.oss.models.GetBucketLocationRequest;
import com.aliyun.oss.models.GetBucketLocationResponse;
import com.aliyun.oss.models.GetBucketLoggingRequest;
import com.aliyun.oss.models.GetBucketLoggingResponse;
import com.aliyun.oss.models.GetBucketRefererRequest;
import com.aliyun.oss.models.GetBucketRefererResponse;
import com.aliyun.oss.models.GetBucketRequest;
import com.aliyun.oss.models.GetBucketRequestPaymentRequest;
import com.aliyun.oss.models.GetBucketRequestPaymentResponse;
import com.aliyun.oss.models.GetBucketResponse;
import com.aliyun.oss.models.GetBucketTagsRequest;
import com.aliyun.oss.models.GetBucketTagsResponse;
import com.aliyun.oss.models.GetBucketWebsiteRequest;
import com.aliyun.oss.models.GetBucketWebsiteResponse;
import com.aliyun.oss.models.GetLiveChannelHistoryRequest;
import com.aliyun.oss.models.GetLiveChannelHistoryResponse;
import com.aliyun.oss.models.GetLiveChannelInfoRequest;
import com.aliyun.oss.models.GetLiveChannelInfoResponse;
import com.aliyun.oss.models.GetLiveChannelStatRequest;
import com.aliyun.oss.models.GetLiveChannelStatResponse;
import com.aliyun.oss.models.GetObjectAclRequest;
import com.aliyun.oss.models.GetObjectAclResponse;
import com.aliyun.oss.models.GetObjectMetaRequest;
import com.aliyun.oss.models.GetObjectMetaResponse;
import com.aliyun.oss.models.GetObjectRequest;
import com.aliyun.oss.models.GetObjectResponse;
import com.aliyun.oss.models.GetObjectTaggingRequest;
import com.aliyun.oss.models.GetObjectTaggingResponse;
import com.aliyun.oss.models.GetServiceRequest;
import com.aliyun.oss.models.GetServiceResponse;
import com.aliyun.oss.models.GetSymlinkRequest;
import com.aliyun.oss.models.GetSymlinkResponse;
import com.aliyun.oss.models.GetVodPlaylistRequest;
import com.aliyun.oss.models.GetVodPlaylistResponse;
import com.aliyun.oss.models.HeadObjectRequest;
import com.aliyun.oss.models.HeadObjectResponse;
import com.aliyun.oss.models.InitiateMultipartUploadRequest;
import com.aliyun.oss.models.InitiateMultipartUploadResponse;
import com.aliyun.oss.models.ListLiveChannelRequest;
import com.aliyun.oss.models.ListLiveChannelResponse;
import com.aliyun.oss.models.ListMultipartUploadsRequest;
import com.aliyun.oss.models.ListMultipartUploadsResponse;
import com.aliyun.oss.models.ListPartsRequest;
import com.aliyun.oss.models.ListPartsResponse;
import com.aliyun.oss.models.OptionObjectRequest;
import com.aliyun.oss.models.OptionObjectResponse;
import com.aliyun.oss.models.PostObjectRequest;
import com.aliyun.oss.models.PostObjectResponse;
import com.aliyun.oss.models.PostVodPlaylistRequest;
import com.aliyun.oss.models.PostVodPlaylistResponse;
import com.aliyun.oss.models.PutBucketAclRequest;
import com.aliyun.oss.models.PutBucketAclResponse;
import com.aliyun.oss.models.PutBucketCORSRequest;
import com.aliyun.oss.models.PutBucketCORSResponse;
import com.aliyun.oss.models.PutBucketEncryptionRequest;
import com.aliyun.oss.models.PutBucketEncryptionResponse;
import com.aliyun.oss.models.PutBucketLifecycleRequest;
import com.aliyun.oss.models.PutBucketLifecycleResponse;
import com.aliyun.oss.models.PutBucketLoggingRequest;
import com.aliyun.oss.models.PutBucketLoggingResponse;
import com.aliyun.oss.models.PutBucketRefererRequest;
import com.aliyun.oss.models.PutBucketRefererResponse;
import com.aliyun.oss.models.PutBucketRequest;
import com.aliyun.oss.models.PutBucketRequestPaymentRequest;
import com.aliyun.oss.models.PutBucketRequestPaymentResponse;
import com.aliyun.oss.models.PutBucketResponse;
import com.aliyun.oss.models.PutBucketTagsRequest;
import com.aliyun.oss.models.PutBucketTagsResponse;
import com.aliyun.oss.models.PutBucketWebsiteRequest;
import com.aliyun.oss.models.PutBucketWebsiteResponse;
import com.aliyun.oss.models.PutLiveChannelRequest;
import com.aliyun.oss.models.PutLiveChannelResponse;
import com.aliyun.oss.models.PutLiveChannelStatusRequest;
import com.aliyun.oss.models.PutLiveChannelStatusResponse;
import com.aliyun.oss.models.PutObjectAclRequest;
import com.aliyun.oss.models.PutObjectAclResponse;
import com.aliyun.oss.models.PutObjectRequest;
import com.aliyun.oss.models.PutObjectResponse;
import com.aliyun.oss.models.PutObjectTaggingRequest;
import com.aliyun.oss.models.PutObjectTaggingResponse;
import com.aliyun.oss.models.PutSymlinkRequest;
import com.aliyun.oss.models.PutSymlinkResponse;
import com.aliyun.oss.models.RestoreObjectRequest;
import com.aliyun.oss.models.RestoreObjectResponse;
import com.aliyun.oss.models.SelectObjectRequest;
import com.aliyun.oss.models.SelectObjectResponse;
import com.aliyun.oss.models.UploadPartCopyRequest;
import com.aliyun.oss.models.UploadPartCopyResponse;
import com.aliyun.oss.models.UploadPartRequest;
import com.aliyun.oss.models.UploadPartResponse;
import com.aliyun.ossutil.models.RuntimeOptions;
import com.aliyun.tea.Tea;
import com.aliyun.tea.TeaConverter;
import com.aliyun.tea.TeaException;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.TeaPair;
import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.TeaResponse;
import com.aliyun.tea.TeaUnretryableException;
import com.aliyun.teautil.Common;
import com.baidu.mapapi.http.wrapper.HttpManager;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client {
    public List<String> _addtionalHeaders;
    public Integer _connectTimeout;
    public com.aliyun.credentials.Client _credential;
    public String _endpoint;
    public String _hostModel;
    public String _httpProxy;
    public String _httpsProxy;
    public Boolean _isEnableCrc;
    public Boolean _isEnableMD5;
    public String _localAddr;
    public Integer _maxIdleConns;
    public String _noProxy;
    public String _protocol;
    public Integer _readTimeout;
    public String _regionId;
    public String _signatureVersion;
    public String _socks5NetWork;
    public String _socks5Proxy;
    public String _userAgent;

    public Client(Config config) throws Exception {
        if (Common.isUnset(TeaModel.buildMap(config))) {
            throw new TeaException(TeaConverter.buildMap(new TeaPair("name", "ParameterMissing"), new TeaPair("message", "'config' can not be unset")));
        }
        if (Common.empty(config.type)) {
            config.type = AuthConstant.ACCESS_KEY;
        }
        this._credential = new com.aliyun.credentials.Client(com.aliyun.credentials.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", config.accessKeyId), new TeaPair("type", config.type), new TeaPair("accessKeySecret", config.accessKeySecret), new TeaPair("securityToken", config.securityToken))));
        if (Common.isUnset(config.isEnableMD5)) {
            config.isEnableMD5 = Boolean.FALSE;
        }
        if (Common.isUnset(config.isEnableCrc)) {
            config.isEnableCrc = Boolean.FALSE;
        }
        this._endpoint = config.endpoint;
        this._protocol = config.protocol;
        this._regionId = config.regionId;
        this._userAgent = config.userAgent;
        this._readTimeout = config.readTimeout;
        this._connectTimeout = config.connectTimeout;
        this._localAddr = config.localAddr;
        this._httpProxy = config.httpProxy;
        this._httpsProxy = config.httpsProxy;
        this._noProxy = config.noProxy;
        this._socks5Proxy = config.socks5Proxy;
        this._socks5NetWork = config.socks5NetWork;
        this._maxIdleConns = config.maxIdleConns;
        this._signatureVersion = config.signatureVersion;
        this._addtionalHeaders = config.addtionalHeaders;
        this._hostModel = config.hostModel;
        this._isEnableMD5 = config.isEnableMD5;
        this._isEnableCrc = config.isEnableCrc;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02da A[LOOP:0: B:3:0x0142->B:53:0x02da, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02e4 A[SYNTHETIC] */
    public AbortMultipartUploadResponse abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(abortMultipartUploadRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(abortMultipartUploadRequest.objectName);
                    sb.append("");
                    teaRequest2.pathname = sb.toString();
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(abortMultipartUploadRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(abortMultipartUploadRequest.filter));
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, abortMultipartUploadRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (AbortMultipartUploadResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new AbortMultipartUploadResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x03b5 A[Catch: Exception -> 0x0431, TRY_LEAVE, TryCatch #12 {Exception -> 0x0431, blocks: (B:79:0x0335, B:97:0x0396, B:82:0x0342, B:85:0x0347, B:88:0x0356, B:89:0x0384, B:101:0x03b5), top: B:167:0x0335 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0485 A[LOOP:0: B:3:0x0152->B:139:0x0485, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:186:0x0497 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x026c A[Catch: Exception -> 0x0440, TRY_ENTER, TryCatch #13 {Exception -> 0x0440, blocks: (B:26:0x01cc, B:29:0x01f5, B:32:0x0215, B:40:0x0236, B:48:0x0277, B:47:0x026c), top: B:168:0x01cc }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public AppendObjectResponse appendObject(AppendObjectRequest appendObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        long j;
        String str;
        String str2;
        TeaRequest teaRequest;
        int i;
        String str3;
        TeaRequest teaRequest2;
        TeaResponse teaResponseDoAction;
        int backoffTime;
        Client client = this;
        AppendObjectRequest appendObjectRequest2 = appendObjectRequest;
        String str4 = "content-md5";
        String str5 = OSSHeaders.OSS_HASH_CRC64_ECMA;
        String str6 = TKDownloadReason.KSAD_TK_MD5;
        TeaModel.validateParams(appendObjectRequest2, "request");
        String str7 = "retry";
        String str8 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, client._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, client._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, client._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, client._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, client._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, client._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, client._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, client._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, client._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest3 = null;
        int i2 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str7), i2, jCurrentTimeMillis)) {
            if (i2 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str8), i2)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i3 = i2 + 1;
            try {
                teaRequest2 = new TeaRequest();
                HashMap map = new HashMap();
                j = jCurrentTimeMillis;
                try {
                    String accessKeyId = client._credential.getAccessKeyId();
                    String accessKeySecret = client._credential.getAccessKeySecret();
                    String securityToken = client._credential.getSecurityToken();
                    teaRequest2.protocol = client._protocol;
                    teaRequest2.method = "POST";
                    StringBuilder sb = new StringBuilder();
                    str = str7;
                    try {
                        sb.append(WVNativeCallbackUtil.SEPERATER);
                        sb.append(appendObjectRequest2.objectName);
                        sb.append("?append");
                        teaRequest2.pathname = sb.toString();
                        Map[] mapArr = new Map[3];
                        str2 = str8;
                        try {
                            TeaPair[] teaPairArr = new TeaPair[3];
                            i = i3;
                            teaRequest = teaRequest3;
                            try {
                                String str9 = str4;
                                try {
                                    String str10 = str6;
                                    try {
                                        String str11 = str5;
                                        try {
                                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(appendObjectRequest2.bucketName, client._regionId, client._endpoint, client._hostModel));
                                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                            char c = 2;
                                            try {
                                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(appendObjectRequest2.header));
                                                c = 2;
                                                mapArr[2] = com.aliyun.ossutil.Client.parseMeta(appendObjectRequest2.userMeta, OSSHeaders.OSS_USER_METADATA_PREFIX);
                                                teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                if (Common.empty(securityToken)) {
                                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(appendObjectRequest2.filter));
                                                    teaRequest2.body = com.aliyun.ossutil.Client.inject(appendObjectRequest2.body, map);
                                                    if (Common.isUnset(TeaModel.buildMap(appendObjectRequest2.header))) {
                                                        teaRequest2.headers.put(e.f, com.aliyun.ossutil.Client.getContentType(appendObjectRequest2.objectName));
                                                    } else {
                                                        teaRequest2.headers.put(e.f, com.aliyun.ossutil.Client.getContentType(appendObjectRequest2.objectName));
                                                    }
                                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, appendObjectRequest2.bucketName, accessKeyId, accessKeySecret, client._signatureVersion, client._addtionalHeaders));
                                                    teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                        str3 = str9;
                                                        str6 = str10;
                                                        str5 = str11;
                                                        Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                        TeaPair[] teaPairArr2 = new TeaPair[3];
                                                        teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                        teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                    }
                                                    str3 = str9;
                                                    str6 = str10;
                                                    str5 = str11;
                                                    Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                    TeaPair[] teaPairArr4 = new TeaPair[3];
                                                    teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                    teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                    TeaPair[] teaPairArr5 = new TeaPair[3];
                                                    teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                    teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                }
                                                try {
                                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(appendObjectRequest2.filter));
                                                    teaRequest2.body = com.aliyun.ossutil.Client.inject(appendObjectRequest2.body, map);
                                                    if (Common.isUnset(TeaModel.buildMap(appendObjectRequest2.header)) || Common.empty(appendObjectRequest2.header.contentType)) {
                                                        teaRequest2.headers.put(e.f, com.aliyun.ossutil.Client.getContentType(appendObjectRequest2.objectName));
                                                    } else {
                                                        teaRequest2.headers.put(e.f, appendObjectRequest2.header.contentType);
                                                    }
                                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, appendObjectRequest2.bucketName, accessKeyId, accessKeySecret, client._signatureVersion, client._addtionalHeaders));
                                                    try {
                                                        teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                        if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode)) && !Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            if (client._isEnableCrc.booleanValue()) {
                                                                try {
                                                                    str5 = str11;
                                                                    try {
                                                                        if (!Common.equalString((String) map.get("crc"), teaResponseDoAction.headers.get(str5))) {
                                                                            char c2 = 2;
                                                                            try {
                                                                                TeaPair[] teaPairArr6 = new TeaPair[2];
                                                                                teaPairArr6[0] = new TeaPair("code", "CrcNotMatched");
                                                                                c2 = 2;
                                                                                TeaPair[] teaPairArr7 = new TeaPair[2];
                                                                                teaPairArr7[0] = new TeaPair("clientCrc", map.get("crc"));
                                                                                teaPairArr7[1] = new TeaPair("serverCrc", teaResponseDoAction.headers.get(str5));
                                                                                teaPairArr6[1] = new TeaPair("data", TeaConverter.buildMap(teaPairArr7));
                                                                                throw new TeaException(TeaConverter.buildMap(teaPairArr6));
                                                                            } catch (Exception e) {
                                                                                e = e;
                                                                                str3 = str9;
                                                                                str6 = str10;
                                                                            }
                                                                        }
                                                                    } catch (Exception e2) {
                                                                        e = e2;
                                                                        str3 = str9;
                                                                        str6 = str10;
                                                                        if (!Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        client = this;
                                                                        appendObjectRequest2 = appendObjectRequest;
                                                                        i2 = i;
                                                                        str6 = str6;
                                                                        str5 = str5;
                                                                        str4 = str3;
                                                                        teaRequest3 = teaRequest2;
                                                                        jCurrentTimeMillis = j;
                                                                        str7 = str;
                                                                        str8 = str2;
                                                                    }
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    str5 = str11;
                                                                    str3 = str9;
                                                                    str6 = str10;
                                                                    if (!Tea.isRetryable(e)) {
                                                                        throw new RuntimeException(e);
                                                                    }
                                                                    client = this;
                                                                    appendObjectRequest2 = appendObjectRequest;
                                                                    i2 = i;
                                                                    str6 = str6;
                                                                    str5 = str5;
                                                                    str4 = str3;
                                                                    teaRequest3 = teaRequest2;
                                                                    jCurrentTimeMillis = j;
                                                                    str7 = str;
                                                                    str8 = str2;
                                                                }
                                                            } else {
                                                                str5 = str11;
                                                            }
                                                            if (client._isEnableMD5.booleanValue()) {
                                                                str6 = str10;
                                                                try {
                                                                    str3 = str9;
                                                                    try {
                                                                        if (!Common.equalString((String) map.get(str6), teaResponseDoAction.headers.get(str3))) {
                                                                            try {
                                                                                TeaPair[] teaPairArr8 = new TeaPair[2];
                                                                                teaPairArr8[0] = new TeaPair("code", "MD5NotMatched");
                                                                                try {
                                                                                    TeaPair[] teaPairArr9 = new TeaPair[2];
                                                                                    teaPairArr9[0] = new TeaPair("clientMD5", map.get(str6));
                                                                                    teaPairArr9[1] = new TeaPair("serverMD5", teaResponseDoAction.headers.get(str3));
                                                                                    teaPairArr8[1] = new TeaPair("data", TeaConverter.buildMap(teaPairArr9));
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr8));
                                                                                } catch (Exception e4) {
                                                                                    e = e4;
                                                                                }
                                                                            } catch (Exception e5) {
                                                                                e = e5;
                                                                            }
                                                                        }
                                                                    } catch (Exception e6) {
                                                                        e = e6;
                                                                    }
                                                                } catch (Exception e7) {
                                                                    e = e7;
                                                                    str3 = str9;
                                                                }
                                                            }
                                                            return (AppendObjectResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new AppendObjectResponse());
                                                        }
                                                        str3 = str9;
                                                        str6 = str10;
                                                        str5 = str11;
                                                        Map<String, Object> errMessage3 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                        TeaPair[] teaPairArr10 = new TeaPair[3];
                                                        teaPairArr10[0] = new TeaPair("code", errMessage3.get("Code"));
                                                        teaPairArr10[1] = new TeaPair("message", errMessage3.get("Message"));
                                                        TeaPair[] teaPairArr11 = new TeaPair[3];
                                                        teaPairArr11[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr11[1] = new TeaPair("requestId", errMessage3.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        try {
                                                            teaPairArr11[2] = new TeaPair("hostId", errMessage3.get("HostId"));
                                                            teaPairArr10[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr11));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr10));
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                        }
                                                    } catch (Exception e9) {
                                                        e = e9;
                                                        str3 = str9;
                                                        str6 = str10;
                                                        str5 = str11;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        client = this;
                                                        appendObjectRequest2 = appendObjectRequest;
                                                        i2 = i;
                                                        str6 = str6;
                                                        str5 = str5;
                                                        str4 = str3;
                                                        teaRequest3 = teaRequest2;
                                                        jCurrentTimeMillis = j;
                                                        str7 = str;
                                                        str8 = str2;
                                                    }
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    teaRequest2 = teaRequest;
                                                    str3 = str9;
                                                    str6 = str10;
                                                    str5 = str11;
                                                    if (!Tea.isRetryable(e)) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    client = this;
                                                    appendObjectRequest2 = appendObjectRequest;
                                                    i2 = i;
                                                    str6 = str6;
                                                    str5 = str5;
                                                    str4 = str3;
                                                    teaRequest3 = teaRequest2;
                                                    jCurrentTimeMillis = j;
                                                    str7 = str;
                                                    str8 = str2;
                                                }
                                            } catch (Exception e11) {
                                                e = e11;
                                                str3 = str9;
                                                str6 = str10;
                                                str5 = str11;
                                                teaRequest2 = teaRequest;
                                            }
                                        } catch (Exception e12) {
                                            e = e12;
                                            str3 = str9;
                                            str6 = str10;
                                            str5 = str11;
                                            teaRequest2 = teaRequest;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            client = this;
                                            appendObjectRequest2 = appendObjectRequest;
                                            i2 = i;
                                            str6 = str6;
                                            str5 = str5;
                                            str4 = str3;
                                            teaRequest3 = teaRequest2;
                                            jCurrentTimeMillis = j;
                                            str7 = str;
                                            str8 = str2;
                                        }
                                    } catch (Exception e13) {
                                        e = e13;
                                        str5 = str5;
                                        str3 = str9;
                                        str6 = str10;
                                    }
                                } catch (Exception e14) {
                                    e = e14;
                                    str5 = str5;
                                    str6 = str6;
                                    str3 = str9;
                                }
                            } catch (Exception e15) {
                                e = e15;
                                str3 = str4;
                                str5 = str5;
                                str6 = str6;
                                teaRequest2 = teaRequest;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                client = this;
                                appendObjectRequest2 = appendObjectRequest;
                                i2 = i;
                                str6 = str6;
                                str5 = str5;
                                str4 = str3;
                                teaRequest3 = teaRequest2;
                                jCurrentTimeMillis = j;
                                str7 = str;
                                str8 = str2;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            teaRequest = teaRequest3;
                            i = i3;
                            str3 = str4;
                            teaRequest2 = teaRequest;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            client = this;
                            appendObjectRequest2 = appendObjectRequest;
                            i2 = i;
                            str6 = str6;
                            str5 = str5;
                            str4 = str3;
                            teaRequest3 = teaRequest2;
                            jCurrentTimeMillis = j;
                            str7 = str;
                            str8 = str2;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str2 = str8;
                    }
                } catch (Exception e18) {
                    e = e18;
                    str = str7;
                    str2 = str8;
                    teaRequest = teaRequest3;
                    i = i3;
                    str3 = str4;
                    str5 = str5;
                    str6 = str6;
                    teaRequest2 = teaRequest;
                    if (!Tea.isRetryable(e)) {
                        throw new RuntimeException(e);
                    }
                    client = this;
                    appendObjectRequest2 = appendObjectRequest;
                    i2 = i;
                    str6 = str6;
                    str5 = str5;
                    str4 = str3;
                    teaRequest3 = teaRequest2;
                    jCurrentTimeMillis = j;
                    str7 = str;
                    str8 = str2;
                }
            } catch (Exception e19) {
                e = e19;
                j = jCurrentTimeMillis;
            }
            if (!Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            client = this;
            appendObjectRequest2 = appendObjectRequest;
            i2 = i;
            str6 = str6;
            str5 = str5;
            str4 = str3;
            teaRequest3 = teaRequest2;
            jCurrentTimeMillis = j;
            str7 = str;
            str8 = str2;
        }
        throw new TeaUnretryableException(teaRequest3);
    }

    public void appendUserAgent(String str) throws Exception {
        this._userAgent = "" + this._userAgent + " " + str + "";
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02b8 A[LOOP:0: B:3:0x0142->B:53:0x02b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02c2 A[SYNTHETIC] */
    public CallbackResponse callback(CallbackRequest callbackRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(callbackRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = "GET";
                teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER;
                TeaPair[] teaPairArr = new TeaPair[i2];
                try {
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(callbackRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, callbackRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (CallbackResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new CallbackResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0368 A[LOOP:0: B:3:0x0144->B:123:0x0368, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:175:0x0376 A[SYNTHETIC] */
    public CompleteMultipartUploadResponse completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        long j;
        boolean z;
        boolean z2;
        char c;
        int backoffTime;
        TeaModel.validateParams(completeMultipartUploadRequest, "request");
        String str3 = "retry";
        boolean z3 = false;
        boolean z4 = true;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(completeMultipartUploadRequest.body));
                    try {
                        teaRequest2.protocol = this._protocol;
                        teaRequest2.method = "POST";
                        StringBuilder sb = new StringBuilder();
                        try {
                            sb.append(WVNativeCallbackUtil.SEPERATER);
                            sb.append(completeMultipartUploadRequest.objectName);
                            sb.append("");
                            teaRequest2.pathname = sb.toString();
                            TeaPair[] teaPairArr = new TeaPair[i2];
                            str = str3;
                            try {
                                i = i4;
                                try {
                                    str2 = str4;
                                    try {
                                        j = jCurrentTimeMillis;
                                        try {
                                            try {
                                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(completeMultipartUploadRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                                try {
                                                    teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                    try {
                                                        teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                        teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                                        if (!Common.empty(securityToken)) {
                                                            teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                        }
                                                        teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(completeMultipartUploadRequest.filter));
                                                        teaRequest2.body = Tea.toReadable(xml);
                                                        teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, completeMultipartUploadRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                        try {
                                                            TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                            if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                try {
                                                                    if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                        try {
                                                                            Map[] mapArr = new Map[2];
                                                                            try {
                                                                                TeaPair[] teaPairArr2 = new TeaPair[1];
                                                                                try {
                                                                                    teaPairArr2[0] = new TeaPair("CompleteMultipartUploadResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), CompleteMultipartUploadResponse.class).get("CompleteMultipartUploadResult"));
                                                                                    mapArr[0] = TeaConverter.buildMap(teaPairArr2);
                                                                                    try {
                                                                                        mapArr[1] = teaResponseDoAction.headers;
                                                                                        return (CompleteMultipartUploadResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new CompleteMultipartUploadResponse());
                                                                                    } catch (Exception e) {
                                                                                        e = e;
                                                                                        z2 = true;
                                                                                        teaRequest = teaRequest2;
                                                                                        c = 2;
                                                                                        z = false;
                                                                                        if (Tea.isRetryable(e)) {
                                                                                            throw new RuntimeException(e);
                                                                                        }
                                                                                        i3 = i;
                                                                                        c2 = c;
                                                                                        z4 = z2;
                                                                                        z3 = z;
                                                                                        str3 = str;
                                                                                        str4 = str2;
                                                                                        jCurrentTimeMillis = j;
                                                                                        i2 = 3;
                                                                                    }
                                                                                } catch (Exception e2) {
                                                                                    e = e2;
                                                                                    z = false;
                                                                                    teaRequest = teaRequest2;
                                                                                    c = 2;
                                                                                    z2 = true;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i3 = i;
                                                                                    c2 = c;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str3 = str;
                                                                                    str4 = str2;
                                                                                    jCurrentTimeMillis = j;
                                                                                    i2 = 3;
                                                                                }
                                                                            } catch (Exception e3) {
                                                                                e = e3;
                                                                                z2 = true;
                                                                            }
                                                                        } catch (Exception e4) {
                                                                            e = e4;
                                                                            c = 2;
                                                                            teaRequest = teaRequest2;
                                                                            z2 = true;
                                                                            z = false;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i3 = i;
                                                                            c2 = c;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str3 = str;
                                                                            str4 = str2;
                                                                            jCurrentTimeMillis = j;
                                                                            i2 = 3;
                                                                        }
                                                                    }
                                                                } catch (Exception e5) {
                                                                    e = e5;
                                                                    teaRequest = teaRequest2;
                                                                    c = 2;
                                                                    z2 = true;
                                                                    z = false;
                                                                    if (Tea.isRetryable(e)) {
                                                                        throw new RuntimeException(e);
                                                                    }
                                                                    i3 = i;
                                                                    c2 = c;
                                                                    z4 = z2;
                                                                    z3 = z;
                                                                    str3 = str;
                                                                    str4 = str2;
                                                                    jCurrentTimeMillis = j;
                                                                    i2 = 3;
                                                                }
                                                            }
                                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                                            try {
                                                                teaPairArr3[0] = new TeaPair("code", errMessage.get("Code"));
                                                                try {
                                                                    teaPairArr3[1] = new TeaPair("message", errMessage.get("Message"));
                                                                    TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                    z = false;
                                                                    try {
                                                                        teaPairArr4[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                        z2 = true;
                                                                        try {
                                                                            teaPairArr4[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                            c = 2;
                                                                            try {
                                                                                teaPairArr4[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                teaPairArr3[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr4));
                                                                                throw new TeaException(TeaConverter.buildMap(teaPairArr3));
                                                                            } catch (Exception e6) {
                                                                                e = e6;
                                                                                teaRequest = teaRequest2;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i3 = i;
                                                                                c2 = c;
                                                                                z4 = z2;
                                                                                z3 = z;
                                                                                str3 = str;
                                                                                str4 = str2;
                                                                                jCurrentTimeMillis = j;
                                                                                i2 = 3;
                                                                            }
                                                                        } catch (Exception e7) {
                                                                            e = e7;
                                                                            c = 2;
                                                                        }
                                                                    } catch (Exception e8) {
                                                                        e = e8;
                                                                        c = 2;
                                                                        z2 = true;
                                                                        teaRequest = teaRequest2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i3 = i;
                                                                        c2 = c;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str3 = str;
                                                                        str4 = str2;
                                                                        jCurrentTimeMillis = j;
                                                                        i2 = 3;
                                                                    }
                                                                } catch (Exception e9) {
                                                                    e = e9;
                                                                    z2 = true;
                                                                    c = 2;
                                                                    z = false;
                                                                    teaRequest = teaRequest2;
                                                                    if (Tea.isRetryable(e)) {
                                                                        throw new RuntimeException(e);
                                                                    }
                                                                    i3 = i;
                                                                    c2 = c;
                                                                    z4 = z2;
                                                                    z3 = z;
                                                                    str3 = str;
                                                                    str4 = str2;
                                                                    jCurrentTimeMillis = j;
                                                                    i2 = 3;
                                                                }
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                z = false;
                                                            }
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            c = 2;
                                                            z2 = true;
                                                        }
                                                    } catch (Exception e12) {
                                                        e = e12;
                                                        c = 2;
                                                    }
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    z2 = true;
                                                }
                                            } catch (Exception e14) {
                                                e = e14;
                                                z = false;
                                            }
                                        } catch (Exception e15) {
                                            e = e15;
                                        }
                                    } catch (Exception e16) {
                                        e = e16;
                                        j = jCurrentTimeMillis;
                                        c = 2;
                                        z2 = true;
                                        z = false;
                                        if (Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        z4 = z2;
                                        z3 = z;
                                        str3 = str;
                                        str4 = str2;
                                        jCurrentTimeMillis = j;
                                        i2 = 3;
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    str2 = str4;
                                    j = jCurrentTimeMillis;
                                    c = 2;
                                    z2 = true;
                                    z = false;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i3 = i;
                                    c2 = c;
                                    z4 = z2;
                                    z3 = z;
                                    str3 = str;
                                    str4 = str2;
                                    jCurrentTimeMillis = j;
                                    i2 = 3;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                i = i4;
                                str2 = str4;
                                j = jCurrentTimeMillis;
                                c = 2;
                                z2 = true;
                                z = false;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z4 = z2;
                                z3 = z;
                                str3 = str;
                                str4 = str2;
                                jCurrentTimeMillis = j;
                                i2 = 3;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            str = str3;
                        }
                    } catch (Exception e20) {
                        e = e20;
                        str = str3;
                        i = i4;
                        str2 = str4;
                        j = jCurrentTimeMillis;
                        c = 2;
                        z2 = true;
                        z = z3;
                    }
                } catch (Exception e21) {
                    e = e21;
                    str = str3;
                    i = i4;
                    str2 = str4;
                    j = jCurrentTimeMillis;
                    c = 2;
                    z = z3;
                    z2 = z4;
                }
            } catch (Exception e22) {
                e = e22;
                str = str3;
                i = i4;
                str2 = str4;
                j = jCurrentTimeMillis;
                z = z3;
                z2 = z4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0363 A[LOOP:0: B:3:0x0147->B:102:0x0363, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:142:0x0372 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x029a A[Catch: Exception -> 0x031a, TRY_LEAVE, TryCatch #13 {Exception -> 0x031a, blocks: (B:39:0x023b, B:41:0x024b, B:43:0x0257, B:47:0x0269, B:50:0x027d, B:56:0x029a, B:59:0x02b9), top: B:133:0x023b }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public CopyObjectResponse copyObject(CopyObjectRequest copyObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        int i2;
        String str2;
        long j;
        boolean z;
        TeaRequest teaRequest;
        TeaResponse teaResponseDoAction;
        int backoffTime;
        TeaModel.validateParams(copyObjectRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        int i3 = 2;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        TeaRequest teaRequest2 = null;
        int i4 = 0;
        for (long jCurrentTimeMillis = System.currentTimeMillis(); Tea.allowRetry((Map) mapBuildMap.get(str3), i4, jCurrentTimeMillis); jCurrentTimeMillis = j) {
            if (i4 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i4)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i5 = i4 + 1;
            try {
                teaRequest = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest.protocol = this._protocol;
                    teaRequest.method = HttpManager.HTTP_PUT;
                    teaRequest.pathname = WVNativeCallbackUtil.SEPERATER + copyObjectRequest.destObjectName + "";
                    Map[] mapArr = new Map[i3];
                    str = str3;
                    try {
                        TeaPair[] teaPairArr = new TeaPair[3];
                        i2 = i5;
                        str2 = str4;
                        try {
                            j = jCurrentTimeMillis;
                            try {
                                teaRequest2 = teaRequest2;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(copyObjectRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            try {
                                                mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(copyObjectRequest.header));
                                                teaRequest.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                if (Common.empty(securityToken)) {
                                                    Map<String, String> map = teaRequest.headers;
                                                    map.put(OSSHeaders.COPY_OBJECT_SOURCE, com.aliyun.ossutil.Client.encode(map.get(OSSHeaders.COPY_OBJECT_SOURCE), "UrlEncode"));
                                                    teaRequest.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest, copyObjectRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                    teaResponseDoAction = Tea.doAction(teaRequest, mapBuildMap);
                                                    if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                        Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                        TeaPair[] teaPairArr2 = new TeaPair[3];
                                                        teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                        teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                                        z = false;
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        TeaPair teaPair = new TeaPair("hostId", errMessage.get("HostId"));
                                                        i = 2;
                                                        teaPairArr3[2] = teaPair;
                                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                    }
                                                    Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                    TeaPair[] teaPairArr4 = new TeaPair[3];
                                                    teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                    teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                    TeaPair[] teaPairArr5 = new TeaPair[3];
                                                    z = false;
                                                    teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                    teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                    TeaPair teaPair2 = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    i = 2;
                                                    teaPairArr5[2] = teaPair2;
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                }
                                                try {
                                                    teaRequest.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                    Map<String, String> map2 = teaRequest.headers;
                                                    map2.put(OSSHeaders.COPY_OBJECT_SOURCE, com.aliyun.ossutil.Client.encode(map2.get(OSSHeaders.COPY_OBJECT_SOURCE), "UrlEncode"));
                                                    teaRequest.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest, copyObjectRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                    try {
                                                        teaResponseDoAction = Tea.doAction(teaRequest, mapBuildMap);
                                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode)) || Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map<String, Object> errMessage3 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                            TeaPair[] teaPairArr6 = new TeaPair[3];
                                                            try {
                                                                teaPairArr6[0] = new TeaPair("code", errMessage3.get("Code"));
                                                                teaPairArr6[1] = new TeaPair("message", errMessage3.get("Message"));
                                                                TeaPair[] teaPairArr7 = new TeaPair[3];
                                                                z = false;
                                                                try {
                                                                    teaPairArr7[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                    teaPairArr7[1] = new TeaPair("requestId", errMessage3.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                    TeaPair teaPair3 = new TeaPair("hostId", errMessage3.get("HostId"));
                                                                    i = 2;
                                                                    try {
                                                                        teaPairArr7[2] = teaPair3;
                                                                        teaPairArr6[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr7));
                                                                        throw new TeaException(TeaConverter.buildMap(teaPairArr6));
                                                                    } catch (Exception e) {
                                                                        e = e;
                                                                    }
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    i = 2;
                                                                }
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                z = false;
                                                            }
                                                        } else {
                                                            try {
                                                                Map[] mapArr2 = new Map[2];
                                                                TeaPair[] teaPairArr8 = new TeaPair[1];
                                                                try {
                                                                    teaPairArr8[0] = new TeaPair("CopyObjectResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), CopyObjectResponse.class).get("CopyObjectResult"));
                                                                    mapArr2[0] = TeaConverter.buildMap(teaPairArr8);
                                                                    mapArr2[1] = teaResponseDoAction.headers;
                                                                    return (CopyObjectResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr2), new CopyObjectResponse());
                                                                } catch (Exception e4) {
                                                                    e = e4;
                                                                    z = false;
                                                                }
                                                            } catch (Exception e5) {
                                                                e = e5;
                                                                i = 2;
                                                                z = false;
                                                                if (Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i4 = i2;
                                                                i3 = i;
                                                                teaRequest2 = teaRequest;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                            }
                                                        }
                                                        i = 2;
                                                    } catch (Exception e6) {
                                                        e = e6;
                                                        i = 2;
                                                        z = false;
                                                        if (Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i4 = i2;
                                                        i3 = i;
                                                        teaRequest2 = teaRequest;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                    }
                                                } catch (Exception e7) {
                                                    e = e7;
                                                    teaRequest = teaRequest2;
                                                    i = 2;
                                                    z = false;
                                                    if (Tea.isRetryable(e)) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    i4 = i2;
                                                    i3 = i;
                                                    teaRequest2 = teaRequest;
                                                    z2 = z;
                                                    str3 = str;
                                                    str4 = str2;
                                                }
                                            } catch (Exception e8) {
                                                e = e8;
                                                z = false;
                                                i = 2;
                                                teaRequest = teaRequest2;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            i = 2;
                                            z = false;
                                            teaRequest = teaRequest2;
                                        }
                                    } catch (Exception e10) {
                                        e = e10;
                                        z = false;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    i = 2;
                                    z = false;
                                    teaRequest = teaRequest2;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i4 = i2;
                                    i3 = i;
                                    teaRequest2 = teaRequest;
                                    z2 = z;
                                    str3 = str;
                                    str4 = str2;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                teaRequest2 = teaRequest2;
                            }
                        } catch (Exception e13) {
                            e = e13;
                            j = jCurrentTimeMillis;
                            i = 2;
                            z = false;
                            teaRequest = teaRequest2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i4 = i2;
                            i3 = i;
                            teaRequest2 = teaRequest;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                        }
                    } catch (Exception e14) {
                        e = e14;
                        i2 = i5;
                        str2 = str4;
                    }
                } catch (Exception e15) {
                    e = e15;
                    teaRequest2 = teaRequest2;
                    str = str3;
                    i = i3;
                    i2 = i5;
                    str2 = str4;
                    j = jCurrentTimeMillis;
                }
            } catch (Exception e16) {
                e = e16;
                teaRequest2 = teaRequest2;
                str = str3;
                i = i3;
                i2 = i5;
                str2 = str4;
                j = jCurrentTimeMillis;
                z = z2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i4 = i2;
            i3 = i;
            teaRequest2 = teaRequest;
            z2 = z;
            str3 = str;
            str4 = str2;
        }
        throw new TeaUnretryableException(teaRequest2);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02b8 A[LOOP:0: B:3:0x0142->B:53:0x02b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02c2 A[SYNTHETIC] */
    public DeleteBucketResponse deleteBucket(DeleteBucketRequest deleteBucketRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteBucketRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER;
                TeaPair[] teaPairArr = new TeaPair[i2];
                try {
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteBucketRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteBucketRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteBucketResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteBucketResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02b8 A[LOOP:0: B:3:0x0142->B:53:0x02b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02c2 A[SYNTHETIC] */
    public DeleteBucketCORSResponse deleteBucketCORS(DeleteBucketCORSRequest deleteBucketCORSRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteBucketCORSRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                teaRequest2.pathname = "/?cors";
                TeaPair[] teaPairArr = new TeaPair[i2];
                try {
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteBucketCORSRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteBucketCORSRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteBucketCORSResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteBucketCORSResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02b8 A[LOOP:0: B:3:0x0142->B:53:0x02b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02c2 A[SYNTHETIC] */
    public DeleteBucketEncryptionResponse deleteBucketEncryption(DeleteBucketEncryptionRequest deleteBucketEncryptionRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteBucketEncryptionRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                teaRequest2.pathname = "/?encryption";
                TeaPair[] teaPairArr = new TeaPair[i2];
                try {
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteBucketEncryptionRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteBucketEncryptionRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteBucketEncryptionResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteBucketEncryptionResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02b8 A[LOOP:0: B:3:0x0142->B:53:0x02b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02c2 A[SYNTHETIC] */
    public DeleteBucketLifecycleResponse deleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteBucketLifecycleRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                teaRequest2.pathname = "/?lifecycle";
                TeaPair[] teaPairArr = new TeaPair[i2];
                try {
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteBucketLifecycleRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteBucketLifecycleRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteBucketLifecycleResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteBucketLifecycleResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02b8 A[LOOP:0: B:3:0x0142->B:53:0x02b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02c2 A[SYNTHETIC] */
    public DeleteBucketLoggingResponse deleteBucketLogging(DeleteBucketLoggingRequest deleteBucketLoggingRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteBucketLoggingRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                teaRequest2.pathname = "/?logging";
                TeaPair[] teaPairArr = new TeaPair[i2];
                try {
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteBucketLoggingRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteBucketLoggingRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteBucketLoggingResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteBucketLoggingResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02c4 A[LOOP:0: B:3:0x0142->B:53:0x02c4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02ce A[SYNTHETIC] */
    public DeleteBucketTagsResponse deleteBucketTags(DeleteBucketTagsRequest deleteBucketTagsRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteBucketTagsRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER;
                TeaPair[] teaPairArr = new TeaPair[i2];
                try {
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteBucketTagsRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(deleteBucketTagsRequest.filter));
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteBucketTagsRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteBucketTagsResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteBucketTagsResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02b8 A[LOOP:0: B:3:0x0142->B:53:0x02b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02c2 A[SYNTHETIC] */
    public DeleteBucketWebsiteResponse deleteBucketWebsite(DeleteBucketWebsiteRequest deleteBucketWebsiteRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteBucketWebsiteRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                teaRequest2.pathname = "/?website";
                TeaPair[] teaPairArr = new TeaPair[i2];
                try {
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteBucketWebsiteRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteBucketWebsiteRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteBucketWebsiteResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteBucketWebsiteResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02ce A[LOOP:0: B:3:0x0142->B:53:0x02ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02d8 A[SYNTHETIC] */
    public DeleteLiveChannelResponse deleteLiveChannel(DeleteLiveChannelRequest deleteLiveChannelRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteLiveChannelRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(deleteLiveChannelRequest.channelName);
                    sb.append("?live");
                    teaRequest2.pathname = sb.toString();
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteLiveChannelRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteLiveChannelRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteLiveChannelResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteLiveChannelResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:144:0x03aa A[LOOP:0: B:3:0x0144->B:144:0x03aa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:200:0x03ba A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public DeleteMultipleObjectsResponse deleteMultipleObjects(DeleteMultipleObjectsRequest deleteMultipleObjectsRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        int i2;
        String str2;
        long j;
        boolean z;
        boolean z2;
        int backoffTime;
        TeaModel.validateParams(deleteMultipleObjectsRequest, "request");
        String str3 = "retry";
        boolean z3 = false;
        boolean z4 = true;
        int i3 = 2;
        int i4 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i5 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i5, jCurrentTimeMillis)) {
            if (i5 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i5)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i6 = i5 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(deleteMultipleObjectsRequest.body));
                    try {
                        teaRequest2.protocol = this._protocol;
                        teaRequest2.method = "POST";
                        teaRequest2.pathname = "/?delete";
                        str = str3;
                        try {
                            Map[] mapArr = new Map[i3];
                            try {
                                TeaPair[] teaPairArr = new TeaPair[i4];
                                i2 = i6;
                                str2 = str4;
                                try {
                                    j = jCurrentTimeMillis;
                                    try {
                                        teaRequest = teaRequest;
                                        try {
                                            try {
                                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteMultipleObjectsRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                                try {
                                                    teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                    try {
                                                        teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                        try {
                                                            mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                            try {
                                                                mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(deleteMultipleObjectsRequest.header));
                                                                teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                                if (!Common.empty(securityToken)) {
                                                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                                }
                                                                teaRequest2.body = Tea.toReadable(xml);
                                                                if (Common.isUnset(TeaModel.buildMap(deleteMultipleObjectsRequest.header)) || Common.empty(deleteMultipleObjectsRequest.header.contentMD5)) {
                                                                    teaRequest2.headers.put("content-md5", com.aliyun.ossutil.Client.getContentMD5(xml, this._isEnableMD5.booleanValue()));
                                                                } else {
                                                                    teaRequest2.headers.put("content-md5", deleteMultipleObjectsRequest.header.contentMD5);
                                                                }
                                                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteMultipleObjectsRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                                try {
                                                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                        try {
                                                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                                try {
                                                                                    Map[] mapArr2 = new Map[2];
                                                                                    try {
                                                                                        TeaPair[] teaPairArr2 = new TeaPair[1];
                                                                                        try {
                                                                                            teaPairArr2[0] = new TeaPair("DeleteResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), DeleteMultipleObjectsResponse.class).get("DeleteResult"));
                                                                                            mapArr2[0] = TeaConverter.buildMap(teaPairArr2);
                                                                                            try {
                                                                                                mapArr2[1] = teaResponseDoAction.headers;
                                                                                                return (DeleteMultipleObjectsResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr2), new DeleteMultipleObjectsResponse());
                                                                                            } catch (Exception e) {
                                                                                                e = e;
                                                                                                z2 = true;
                                                                                                teaRequest = teaRequest2;
                                                                                                i = 2;
                                                                                                z = false;
                                                                                                if (!Tea.isRetryable(e)) {
                                                                                                    throw new RuntimeException(e);
                                                                                                }
                                                                                                i5 = i2;
                                                                                                i3 = i;
                                                                                                z4 = z2;
                                                                                                z3 = z;
                                                                                                str3 = str;
                                                                                                str4 = str2;
                                                                                                jCurrentTimeMillis = j;
                                                                                                teaRequest = teaRequest;
                                                                                                i4 = 3;
                                                                                            }
                                                                                        } catch (Exception e2) {
                                                                                            e = e2;
                                                                                            z = false;
                                                                                            teaRequest = teaRequest2;
                                                                                            i = 2;
                                                                                            z2 = true;
                                                                                            if (!Tea.isRetryable(e)) {
                                                                                                throw new RuntimeException(e);
                                                                                            }
                                                                                            i5 = i2;
                                                                                            i3 = i;
                                                                                            z4 = z2;
                                                                                            z3 = z;
                                                                                            str3 = str;
                                                                                            str4 = str2;
                                                                                            jCurrentTimeMillis = j;
                                                                                            teaRequest = teaRequest;
                                                                                            i4 = 3;
                                                                                        }
                                                                                    } catch (Exception e3) {
                                                                                        e = e3;
                                                                                        z2 = true;
                                                                                    }
                                                                                } catch (Exception e4) {
                                                                                    e = e4;
                                                                                    i = 2;
                                                                                    teaRequest = teaRequest2;
                                                                                    z2 = true;
                                                                                    z = false;
                                                                                    if (!Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i5 = i2;
                                                                                    i3 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str3 = str;
                                                                                    str4 = str2;
                                                                                    jCurrentTimeMillis = j;
                                                                                    teaRequest = teaRequest;
                                                                                    i4 = 3;
                                                                                }
                                                                            }
                                                                        } catch (Exception e5) {
                                                                            e = e5;
                                                                            teaRequest = teaRequest2;
                                                                            i = 2;
                                                                            z2 = true;
                                                                            z = false;
                                                                            if (!Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i5 = i2;
                                                                            i3 = i;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str3 = str;
                                                                            str4 = str2;
                                                                            jCurrentTimeMillis = j;
                                                                            teaRequest = teaRequest;
                                                                            i4 = 3;
                                                                        }
                                                                    }
                                                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                    try {
                                                                        teaPairArr3[0] = new TeaPair("code", errMessage.get("Code"));
                                                                        try {
                                                                            teaPairArr3[1] = new TeaPair("message", errMessage.get("Message"));
                                                                            TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                            z = false;
                                                                            try {
                                                                                teaPairArr4[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                z2 = true;
                                                                                try {
                                                                                    teaPairArr4[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                                    TeaPair teaPair = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                    i = 2;
                                                                                    try {
                                                                                        teaPairArr4[2] = teaPair;
                                                                                        teaPairArr3[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr4));
                                                                                        throw new TeaException(TeaConverter.buildMap(teaPairArr3));
                                                                                    } catch (Exception e6) {
                                                                                        e = e6;
                                                                                        teaRequest = teaRequest2;
                                                                                        if (!Tea.isRetryable(e)) {
                                                                                            throw new RuntimeException(e);
                                                                                        }
                                                                                        i5 = i2;
                                                                                        i3 = i;
                                                                                        z4 = z2;
                                                                                        z3 = z;
                                                                                        str3 = str;
                                                                                        str4 = str2;
                                                                                        jCurrentTimeMillis = j;
                                                                                        teaRequest = teaRequest;
                                                                                        i4 = 3;
                                                                                    }
                                                                                } catch (Exception e7) {
                                                                                    e = e7;
                                                                                    i = 2;
                                                                                }
                                                                            } catch (Exception e8) {
                                                                                e = e8;
                                                                                i = 2;
                                                                                z2 = true;
                                                                                teaRequest = teaRequest2;
                                                                                if (!Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i5 = i2;
                                                                                i3 = i;
                                                                                z4 = z2;
                                                                                z3 = z;
                                                                                str3 = str;
                                                                                str4 = str2;
                                                                                jCurrentTimeMillis = j;
                                                                                teaRequest = teaRequest;
                                                                                i4 = 3;
                                                                            }
                                                                        } catch (Exception e9) {
                                                                            e = e9;
                                                                            z2 = true;
                                                                            i = 2;
                                                                            z = false;
                                                                            teaRequest = teaRequest2;
                                                                            if (!Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i5 = i2;
                                                                            i3 = i;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str3 = str;
                                                                            str4 = str2;
                                                                            jCurrentTimeMillis = j;
                                                                            teaRequest = teaRequest;
                                                                            i4 = 3;
                                                                        }
                                                                    } catch (Exception e10) {
                                                                        e = e10;
                                                                        z = false;
                                                                    }
                                                                } catch (Exception e11) {
                                                                    e = e11;
                                                                    i = 2;
                                                                    z2 = true;
                                                                }
                                                            } catch (Exception e12) {
                                                                e = e12;
                                                                z2 = true;
                                                            }
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            z = false;
                                                        }
                                                    } catch (Exception e14) {
                                                        e = e14;
                                                        i = 2;
                                                    }
                                                } catch (Exception e15) {
                                                    e = e15;
                                                    z2 = true;
                                                }
                                            } catch (Exception e16) {
                                                e = e16;
                                                z = false;
                                            }
                                        } catch (Exception e17) {
                                            e = e17;
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        teaRequest = teaRequest;
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                    j = jCurrentTimeMillis;
                                    i = 2;
                                    z2 = true;
                                    z = false;
                                    if (!Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i5 = i2;
                                    i3 = i;
                                    z4 = z2;
                                    z3 = z;
                                    str3 = str;
                                    str4 = str2;
                                    jCurrentTimeMillis = j;
                                    teaRequest = teaRequest;
                                    i4 = 3;
                                }
                            } catch (Exception e20) {
                                e = e20;
                                i2 = i6;
                                str2 = str4;
                            }
                        } catch (Exception e21) {
                            e = e21;
                            i = i3;
                            i2 = i6;
                            str2 = str4;
                            j = jCurrentTimeMillis;
                            z2 = true;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i5 = i2;
                            i3 = i;
                            z4 = z2;
                            z3 = z;
                            str3 = str;
                            str4 = str2;
                            jCurrentTimeMillis = j;
                            teaRequest = teaRequest;
                            i4 = 3;
                        }
                    } catch (Exception e22) {
                        e = e22;
                        str = str3;
                    }
                } catch (Exception e23) {
                    e = e23;
                    teaRequest = teaRequest;
                    str = str3;
                    i = i3;
                    i2 = i6;
                    str2 = str4;
                    j = jCurrentTimeMillis;
                    z2 = true;
                    z = z3;
                }
            } catch (Exception e24) {
                e = e24;
                teaRequest = teaRequest;
                str = str3;
                i = i3;
                i2 = i6;
                str2 = str4;
                j = jCurrentTimeMillis;
                z = z3;
                z2 = z4;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02ce A[LOOP:0: B:3:0x0142->B:53:0x02ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02d8 A[SYNTHETIC] */
    public DeleteObjectResponse deleteObject(DeleteObjectRequest deleteObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteObjectRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(deleteObjectRequest.objectName);
                    sb.append("");
                    teaRequest2.pathname = sb.toString();
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteObjectRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteObjectRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteObjectResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteObjectResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02ce A[LOOP:0: B:3:0x0142->B:53:0x02ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02d8 A[SYNTHETIC] */
    public DeleteObjectTaggingResponse deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(deleteObjectTaggingRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_DELETE;
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(deleteObjectTaggingRequest.objectName);
                    sb.append("?tagging");
                    teaRequest2.pathname = sb.toString();
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(deleteObjectTaggingRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, deleteObjectTaggingRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (DeleteObjectTaggingResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new DeleteObjectTaggingResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    public String getAccessKeyId() throws Exception {
        return Common.isUnset(this._credential) ? "" : this._credential.getAccessKeyId();
    }

    public String getAccessKeySecret() throws Exception {
        return Common.isUnset(this._credential) ? "" : this._credential.getAccessKeySecret();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0257 A[Catch: Exception -> 0x02d0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x02d0, blocks: (B:24:0x01f8, B:38:0x0257), top: B:69:0x01f8 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02f4 A[LOOP:0: B:3:0x0144->B:64:0x02f4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x0300 A[SYNTHETIC] */
    public GetBucketResponse getBucket(GetBucketRequest getBucketRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER;
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(getBucketRequest.filter));
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("ListBucketResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketResponse.class).get("ListBucketResult")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketAclResponse getBucketAcl(GetBucketAclRequest getBucketAclRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketAclRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?acl";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketAclRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketAclRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("AccessControlPolicy", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketAclResponse.class).get("AccessControlPolicy")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketAclResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketAclResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketCORSResponse getBucketCORS(GetBucketCORSRequest getBucketCORSRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketCORSRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?cors";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketCORSRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketCORSRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("CORSConfiguration", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketCORSResponse.class).get("CORSConfiguration")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketCORSResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketCORSResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketEncryptionResponse getBucketEncryption(GetBucketEncryptionRequest getBucketEncryptionRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketEncryptionRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?encryption";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketEncryptionRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketEncryptionRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("ServerSideEncryptionRule", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketEncryptionResponse.class).get("ServerSideEncryptionRule")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketEncryptionResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketEncryptionResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketInfoResponse getBucketInfo(GetBucketInfoRequest getBucketInfoRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketInfoRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?bucketInfo";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketInfoRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketInfoRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("BucketInfo", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketInfoResponse.class).get("BucketInfo")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketInfoResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketInfoResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketLifecycleResponse getBucketLifecycle(GetBucketLifecycleRequest getBucketLifecycleRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketLifecycleRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?lifecycle";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketLifecycleRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketLifecycleRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("LifecycleConfiguration", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketLifecycleResponse.class).get("LifecycleConfiguration")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketLifecycleResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketLifecycleResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketLocationResponse getBucketLocation(GetBucketLocationRequest getBucketLocationRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketLocationRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?location";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketLocationRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketLocationRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair(CreateBucketRequest.TAB_LOCATIONCONSTRAINT, com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketLocationResponse.class).get(CreateBucketRequest.TAB_LOCATIONCONSTRAINT)));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketLocationResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketLocationResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketLoggingResponse getBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketLoggingRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?logging";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketLoggingRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketLoggingRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("BucketLoggingStatus", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketLoggingResponse.class).get("BucketLoggingStatus")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketLoggingResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketLoggingResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketRefererResponse getBucketReferer(GetBucketRefererRequest getBucketRefererRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketRefererRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?referer";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketRefererRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketRefererRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("RefererConfiguration", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketRefererResponse.class).get("RefererConfiguration")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketRefererResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketRefererResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketRequestPaymentResponse getBucketRequestPayment(GetBucketRequestPaymentRequest getBucketRequestPaymentRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketRequestPaymentRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?requestPayment";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketRequestPaymentRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketRequestPaymentRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("RequestPaymentConfiguration", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketRequestPaymentResponse.class).get("RequestPaymentConfiguration")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketRequestPaymentResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketRequestPaymentResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketTagsResponse getBucketTags(GetBucketTagsRequest getBucketTagsRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketTagsRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?tagging";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketTagsRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketTagsRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("Tagging", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketTagsResponse.class).get("Tagging")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketTagsResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketTagsResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024b A[Catch: Exception -> 0x02c4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c4, blocks: (B:24:0x01ec, B:38:0x024b), top: B:81:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02e8 A[LOOP:0: B:3:0x0144->B:64:0x02e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f4 A[SYNTHETIC] */
    public GetBucketWebsiteResponse getBucketWebsite(GetBucketWebsiteRequest getBucketWebsiteRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getBucketWebsiteRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?website";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getBucketWebsiteRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getBucketWebsiteRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("WebsiteConfiguration", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetBucketWebsiteResponse.class).get("WebsiteConfiguration")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetBucketWebsiteResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetBucketWebsiteResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x026d A[Catch: Exception -> 0x02e6, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x02e6, blocks: (B:24:0x020e, B:38:0x026d), top: B:79:0x020e }] */
    /* JADX WARN: Code duplicated, block: B:64:0x030a A[LOOP:0: B:3:0x0144->B:64:0x030a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x0316 A[SYNTHETIC] */
    public GetLiveChannelHistoryResponse getLiveChannelHistory(GetLiveChannelHistoryRequest getLiveChannelHistoryRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getLiveChannelHistoryRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER + getLiveChannelHistoryRequest.channelName + "?live";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getLiveChannelHistoryRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(getLiveChannelHistoryRequest.filter));
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getLiveChannelHistoryRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("LiveChannelHistory", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetLiveChannelHistoryResponse.class).get("LiveChannelHistory")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetLiveChannelHistoryResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetLiveChannelHistoryResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0261 A[Catch: Exception -> 0x02da, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x02da, blocks: (B:24:0x0202, B:38:0x0261), top: B:75:0x0202 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02fe A[LOOP:0: B:3:0x0144->B:64:0x02fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x030a A[SYNTHETIC] */
    public GetLiveChannelInfoResponse getLiveChannelInfo(GetLiveChannelInfoRequest getLiveChannelInfoRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getLiveChannelInfoRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER + getLiveChannelInfoRequest.channelName + "?live";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getLiveChannelInfoRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getLiveChannelInfoRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("LiveChannelConfiguration", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetLiveChannelInfoResponse.class).get("LiveChannelConfiguration")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetLiveChannelInfoResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetLiveChannelInfoResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x026d A[Catch: Exception -> 0x02e6, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x02e6, blocks: (B:24:0x020e, B:38:0x026d), top: B:79:0x020e }] */
    /* JADX WARN: Code duplicated, block: B:64:0x030a A[LOOP:0: B:3:0x0144->B:64:0x030a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x0316 A[SYNTHETIC] */
    public GetLiveChannelStatResponse getLiveChannelStat(GetLiveChannelStatRequest getLiveChannelStatRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getLiveChannelStatRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER + getLiveChannelStatRequest.channelName + "?live";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getLiveChannelStatRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(getLiveChannelStatRequest.filter));
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getLiveChannelStatRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("LiveChannelStat", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetLiveChannelStatResponse.class).get("LiveChannelStat")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetLiveChannelStatResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetLiveChannelStatResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:145:0x036d A[LOOP:0: B:3:0x0142->B:145:0x036d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:201:0x037b A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public GetObjectResponse getObject(GetObjectRequest getObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        int i;
        boolean z;
        int i2;
        int backoffTime;
        TeaModel.validateParams(getObjectRequest, "request");
        String str = "retry";
        boolean z2 = false;
        boolean z3 = true;
        int i3 = 2;
        int i4 = 3;
        String str2 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i5 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str), i5, jCurrentTimeMillis)) {
            if (i5 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str2), i5)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i6 = i5 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = "GET";
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(getObjectRequest.objectName);
                    sb.append("");
                    teaRequest2.pathname = sb.toString();
                    Map[] mapArr = new Map[i3];
                    try {
                        TeaPair[] teaPairArr = new TeaPair[i4];
                        try {
                            str = str;
                            try {
                                i6 = i6;
                                try {
                                    str2 = str2;
                                    try {
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                        try {
                                            try {
                                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getObjectRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                                boolean z4 = true;
                                                try {
                                                    teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                    try {
                                                        teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                        try {
                                                            mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                            z4 = true;
                                                            mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(getObjectRequest.header));
                                                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                            if (!Common.empty(securityToken)) {
                                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                            }
                                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getObjectRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                            try {
                                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    try {
                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                Map[] mapArr2 = new Map[2];
                                                                                boolean z5 = true;
                                                                                try {
                                                                                    TeaPair[] teaPairArr2 = new TeaPair[1];
                                                                                    try {
                                                                                        teaPairArr2[0] = new TeaPair("body", teaResponseDoAction.body);
                                                                                        mapArr2[0] = TeaConverter.buildMap(teaPairArr2);
                                                                                        z5 = true;
                                                                                        mapArr2[1] = teaResponseDoAction.headers;
                                                                                        return (GetObjectResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr2), new GetObjectResponse());
                                                                                    } catch (Exception e) {
                                                                                        e = e;
                                                                                        z2 = false;
                                                                                        teaRequest = teaRequest2;
                                                                                        i2 = 3;
                                                                                        z = true;
                                                                                        i = 2;
                                                                                        if (Tea.isRetryable(e)) {
                                                                                            throw new RuntimeException(e);
                                                                                        }
                                                                                        i5 = i6;
                                                                                        i4 = i2;
                                                                                        z3 = z;
                                                                                        z2 = z2;
                                                                                        i3 = i;
                                                                                        str = str;
                                                                                        str2 = str2;
                                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    }
                                                                                } catch (Exception e2) {
                                                                                    e = e2;
                                                                                    z = z5;
                                                                                    teaRequest = teaRequest2;
                                                                                    i2 = 3;
                                                                                    z2 = false;
                                                                                    i = 2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i5 = i6;
                                                                                    i4 = i2;
                                                                                    z3 = z;
                                                                                    z2 = z2;
                                                                                    i3 = i;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                }
                                                                            } catch (Exception e3) {
                                                                                e = e3;
                                                                                i = 2;
                                                                                teaRequest = teaRequest2;
                                                                                i2 = 3;
                                                                                z = true;
                                                                                z2 = false;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i5 = i6;
                                                                                i4 = i2;
                                                                                z3 = z;
                                                                                z2 = z2;
                                                                                i3 = i;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            }
                                                                        }
                                                                    } catch (Exception e4) {
                                                                        e = e4;
                                                                        teaRequest = teaRequest2;
                                                                        i2 = 3;
                                                                        z = true;
                                                                        z2 = false;
                                                                        i = 2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i5 = i6;
                                                                        i4 = i2;
                                                                        z3 = z;
                                                                        z2 = z2;
                                                                        i3 = i;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                    }
                                                                }
                                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                                try {
                                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                    try {
                                                                        teaPairArr3[0] = new TeaPair("code", errMessage.get("Code"));
                                                                        try {
                                                                            teaPairArr3[1] = new TeaPair("message", errMessage.get("Message"));
                                                                            i2 = 3;
                                                                            try {
                                                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                                z2 = false;
                                                                                try {
                                                                                    teaPairArr4[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                    z = true;
                                                                                    try {
                                                                                        teaPairArr4[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                                        i = 2;
                                                                                        try {
                                                                                            teaPairArr4[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                            teaPairArr3[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr4));
                                                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr3));
                                                                                        } catch (Exception e5) {
                                                                                            e = e5;
                                                                                            teaRequest = teaRequest2;
                                                                                            if (Tea.isRetryable(e)) {
                                                                                                throw new RuntimeException(e);
                                                                                            }
                                                                                            i5 = i6;
                                                                                            i4 = i2;
                                                                                            z3 = z;
                                                                                            z2 = z2;
                                                                                            i3 = i;
                                                                                            str = str;
                                                                                            str2 = str2;
                                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                        }
                                                                                    } catch (Exception e6) {
                                                                                        e = e6;
                                                                                        i = 2;
                                                                                        teaRequest = teaRequest2;
                                                                                        if (Tea.isRetryable(e)) {
                                                                                            throw new RuntimeException(e);
                                                                                        }
                                                                                        i5 = i6;
                                                                                        i4 = i2;
                                                                                        z3 = z;
                                                                                        z2 = z2;
                                                                                        i3 = i;
                                                                                        str = str;
                                                                                        str2 = str2;
                                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    }
                                                                                } catch (Exception e7) {
                                                                                    e = e7;
                                                                                    z = true;
                                                                                    i = 2;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i5 = i6;
                                                                                    i4 = i2;
                                                                                    z3 = z;
                                                                                    z2 = z2;
                                                                                    i3 = i;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                }
                                                                            } catch (Exception e8) {
                                                                                e = e8;
                                                                                z = true;
                                                                                z2 = false;
                                                                                i = 2;
                                                                                teaRequest = teaRequest2;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i5 = i6;
                                                                                i4 = i2;
                                                                                z3 = z;
                                                                                z2 = z2;
                                                                                i3 = i;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            }
                                                                        } catch (Exception e9) {
                                                                            e = e9;
                                                                            z = true;
                                                                            i2 = 3;
                                                                            z2 = false;
                                                                            i = 2;
                                                                            teaRequest = teaRequest2;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i5 = i6;
                                                                            i4 = i2;
                                                                            z3 = z;
                                                                            z2 = z2;
                                                                            i3 = i;
                                                                            str = str;
                                                                            str2 = str2;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        }
                                                                    } catch (Exception e10) {
                                                                        e = e10;
                                                                        z2 = false;
                                                                        i2 = 3;
                                                                    }
                                                                } catch (Exception e11) {
                                                                    e = e11;
                                                                    i2 = 3;
                                                                }
                                                            } catch (Exception e12) {
                                                                e = e12;
                                                                i2 = 3;
                                                            }
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            z2 = false;
                                                        }
                                                    } catch (Exception e14) {
                                                        e = e14;
                                                        i = 2;
                                                    }
                                                } catch (Exception e15) {
                                                    e = e15;
                                                    z = z4;
                                                }
                                            } catch (Exception e16) {
                                                e = e16;
                                                z2 = false;
                                            }
                                        } catch (Exception e17) {
                                            e = e17;
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                        i2 = 3;
                                        z = true;
                                        z2 = false;
                                        i = 2;
                                        if (Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i5 = i6;
                                        i4 = i2;
                                        z3 = z;
                                        z2 = z2;
                                        i3 = i;
                                        str = str;
                                        str2 = str2;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i2 = 3;
                                    z = true;
                                    z2 = false;
                                    i = 2;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i5 = i6;
                                    i4 = i2;
                                    z3 = z;
                                    z2 = z2;
                                    i3 = i;
                                    str = str;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                }
                            } catch (Exception e20) {
                                e = e20;
                                i6 = i6;
                            }
                        } catch (Exception e21) {
                            e = e21;
                            str = str;
                            i6 = i6;
                            str2 = str2;
                            jCurrentTimeMillis = jCurrentTimeMillis;
                            i2 = 3;
                            z = true;
                            i = 2;
                            z2 = z2;
                        }
                    } catch (Exception e22) {
                        e = e22;
                        z = true;
                        i = 2;
                        i2 = i4;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i5 = i6;
                        i4 = i2;
                        z3 = z;
                        z2 = z2;
                        i3 = i;
                        str = str;
                        str2 = str2;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                    }
                } catch (Exception e23) {
                    e = e23;
                    i = i3;
                    z = true;
                }
            } catch (Exception e24) {
                e = e24;
                str = str;
                i = i3;
                i6 = i6;
                str2 = str2;
                jCurrentTimeMillis = jCurrentTimeMillis;
                z = z3;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0261 A[Catch: Exception -> 0x02da, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x02da, blocks: (B:24:0x0202, B:38:0x0261), top: B:75:0x0202 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02fe A[LOOP:0: B:3:0x0144->B:64:0x02fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x030a A[SYNTHETIC] */
    public GetObjectAclResponse getObjectAcl(GetObjectAclRequest getObjectAclRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getObjectAclRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER + getObjectAclRequest.objectName + "?acl";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getObjectAclRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getObjectAclRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("AccessControlPolicy", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetObjectAclResponse.class).get("AccessControlPolicy")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetObjectAclResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetObjectAclResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02ce A[LOOP:0: B:3:0x0142->B:53:0x02ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02d8 A[SYNTHETIC] */
    public GetObjectMetaResponse getObjectMeta(GetObjectMetaRequest getObjectMetaRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(getObjectMetaRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = com.ipd.dsp.internal.g0.c.f38307a;
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(getObjectMetaRequest.objectName);
                    sb.append("?objectMeta");
                    teaRequest2.pathname = sb.toString();
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getObjectMetaRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getObjectMetaRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (GetObjectMetaResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new GetObjectMetaResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0261 A[Catch: Exception -> 0x02da, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x02da, blocks: (B:24:0x0202, B:38:0x0261), top: B:75:0x0202 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02fe A[LOOP:0: B:3:0x0144->B:64:0x02fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x030a A[SYNTHETIC] */
    public GetObjectTaggingResponse getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getObjectTaggingRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER + getObjectTaggingRequest.objectName + "?tagging";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getObjectTaggingRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getObjectTaggingRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("Tagging", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetObjectTaggingResponse.class).get("Tagging")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetObjectTaggingResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetObjectTaggingResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0255 A[Catch: Exception -> 0x02ce, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x02ce, blocks: (B:24:0x01f6, B:38:0x0255), top: B:69:0x01f6 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02f2 A[LOOP:0: B:3:0x0144->B:64:0x02f2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02fe A[SYNTHETIC] */
    public GetServiceResponse getService(GetServiceRequest getServiceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(getServiceRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER;
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost("", this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(getServiceRequest.filter));
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, "", accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("ListAllMyBucketsResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), GetServiceResponse.class).get("ListAllMyBucketsResult")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (GetServiceResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new GetServiceResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02ce A[LOOP:0: B:3:0x0142->B:53:0x02ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02d8 A[SYNTHETIC] */
    public GetSymlinkResponse getSymlink(GetSymlinkRequest getSymlinkRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(getSymlinkRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = "GET";
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(getSymlinkRequest.objectName);
                    sb.append("?symlink");
                    teaRequest2.pathname = sb.toString();
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getSymlinkRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getSymlinkRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (GetSymlinkResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new GetSymlinkResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    public String getUserAgent() throws Exception {
        return Common.getUserAgent(this._userAgent);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02da A[LOOP:0: B:3:0x0142->B:53:0x02da, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02e4 A[SYNTHETIC] */
    public GetVodPlaylistResponse getVodPlaylist(GetVodPlaylistRequest getVodPlaylistRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(getVodPlaylistRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = "GET";
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(getVodPlaylistRequest.channelName);
                    sb.append("?vod");
                    teaRequest2.pathname = sb.toString();
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(getVodPlaylistRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(getVodPlaylistRequest.filter));
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, getVodPlaylistRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (GetVodPlaylistResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new GetVodPlaylistResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:145:0x0375 A[LOOP:0: B:3:0x0142->B:145:0x0375, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:201:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public HeadObjectResponse headObject(HeadObjectRequest headObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        int i;
        boolean z;
        int i2;
        int backoffTime;
        TeaModel.validateParams(headObjectRequest, "request");
        String str = "retry";
        boolean z2 = false;
        boolean z3 = true;
        int i3 = 2;
        int i4 = 3;
        String str2 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i5 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str), i5, jCurrentTimeMillis)) {
            if (i5 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str2), i5)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i6 = i5 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = com.ipd.dsp.internal.g0.c.f38307a;
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(headObjectRequest.objectName);
                    sb.append("");
                    teaRequest2.pathname = sb.toString();
                    Map[] mapArr = new Map[i3];
                    try {
                        TeaPair[] teaPairArr = new TeaPair[i4];
                        try {
                            str = str;
                            try {
                                i6 = i6;
                                try {
                                    str2 = str2;
                                    try {
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                        try {
                                            try {
                                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(headObjectRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                                boolean z4 = true;
                                                try {
                                                    teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                    try {
                                                        teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                        try {
                                                            mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                            z4 = true;
                                                            mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(headObjectRequest.header));
                                                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                            if (!Common.empty(securityToken)) {
                                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                            }
                                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, headObjectRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                            try {
                                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    try {
                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                Map[] mapArr2 = new Map[2];
                                                                                boolean z5 = true;
                                                                                try {
                                                                                    TeaPair[] teaPairArr2 = new TeaPair[1];
                                                                                    try {
                                                                                        teaPairArr2[0] = new TeaPair("usermeta", com.aliyun.ossutil.Client.toMeta(teaResponseDoAction.headers, OSSHeaders.OSS_USER_METADATA_PREFIX));
                                                                                        mapArr2[0] = TeaConverter.buildMap(teaPairArr2);
                                                                                        z5 = true;
                                                                                        mapArr2[1] = teaResponseDoAction.headers;
                                                                                        return (HeadObjectResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr2), new HeadObjectResponse());
                                                                                    } catch (Exception e) {
                                                                                        e = e;
                                                                                        z2 = false;
                                                                                        teaRequest = teaRequest2;
                                                                                        i2 = 3;
                                                                                        z = true;
                                                                                        i = 2;
                                                                                        if (Tea.isRetryable(e)) {
                                                                                            throw new RuntimeException(e);
                                                                                        }
                                                                                        i5 = i6;
                                                                                        i4 = i2;
                                                                                        z3 = z;
                                                                                        z2 = z2;
                                                                                        i3 = i;
                                                                                        str = str;
                                                                                        str2 = str2;
                                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    }
                                                                                } catch (Exception e2) {
                                                                                    e = e2;
                                                                                    z = z5;
                                                                                    teaRequest = teaRequest2;
                                                                                    i2 = 3;
                                                                                    z2 = false;
                                                                                    i = 2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i5 = i6;
                                                                                    i4 = i2;
                                                                                    z3 = z;
                                                                                    z2 = z2;
                                                                                    i3 = i;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                }
                                                                            } catch (Exception e3) {
                                                                                e = e3;
                                                                                i = 2;
                                                                                teaRequest = teaRequest2;
                                                                                i2 = 3;
                                                                                z = true;
                                                                                z2 = false;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i5 = i6;
                                                                                i4 = i2;
                                                                                z3 = z;
                                                                                z2 = z2;
                                                                                i3 = i;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            }
                                                                        }
                                                                    } catch (Exception e4) {
                                                                        e = e4;
                                                                        teaRequest = teaRequest2;
                                                                        i2 = 3;
                                                                        z = true;
                                                                        z2 = false;
                                                                        i = 2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i5 = i6;
                                                                        i4 = i2;
                                                                        z3 = z;
                                                                        z2 = z2;
                                                                        i3 = i;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                    }
                                                                }
                                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                                try {
                                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                    try {
                                                                        teaPairArr3[0] = new TeaPair("code", errMessage.get("Code"));
                                                                        try {
                                                                            teaPairArr3[1] = new TeaPair("message", errMessage.get("Message"));
                                                                            i2 = 3;
                                                                            try {
                                                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                                z2 = false;
                                                                                try {
                                                                                    teaPairArr4[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                                    z = true;
                                                                                    try {
                                                                                        teaPairArr4[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                                        i = 2;
                                                                                        try {
                                                                                            teaPairArr4[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                            teaPairArr3[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr4));
                                                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr3));
                                                                                        } catch (Exception e5) {
                                                                                            e = e5;
                                                                                            teaRequest = teaRequest2;
                                                                                            if (Tea.isRetryable(e)) {
                                                                                                throw new RuntimeException(e);
                                                                                            }
                                                                                            i5 = i6;
                                                                                            i4 = i2;
                                                                                            z3 = z;
                                                                                            z2 = z2;
                                                                                            i3 = i;
                                                                                            str = str;
                                                                                            str2 = str2;
                                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                        }
                                                                                    } catch (Exception e6) {
                                                                                        e = e6;
                                                                                        i = 2;
                                                                                        teaRequest = teaRequest2;
                                                                                        if (Tea.isRetryable(e)) {
                                                                                            throw new RuntimeException(e);
                                                                                        }
                                                                                        i5 = i6;
                                                                                        i4 = i2;
                                                                                        z3 = z;
                                                                                        z2 = z2;
                                                                                        i3 = i;
                                                                                        str = str;
                                                                                        str2 = str2;
                                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    }
                                                                                } catch (Exception e7) {
                                                                                    e = e7;
                                                                                    z = true;
                                                                                    i = 2;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i5 = i6;
                                                                                    i4 = i2;
                                                                                    z3 = z;
                                                                                    z2 = z2;
                                                                                    i3 = i;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                }
                                                                            } catch (Exception e8) {
                                                                                e = e8;
                                                                                z = true;
                                                                                z2 = false;
                                                                                i = 2;
                                                                                teaRequest = teaRequest2;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i5 = i6;
                                                                                i4 = i2;
                                                                                z3 = z;
                                                                                z2 = z2;
                                                                                i3 = i;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            }
                                                                        } catch (Exception e9) {
                                                                            e = e9;
                                                                            z = true;
                                                                            i2 = 3;
                                                                            z2 = false;
                                                                            i = 2;
                                                                            teaRequest = teaRequest2;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i5 = i6;
                                                                            i4 = i2;
                                                                            z3 = z;
                                                                            z2 = z2;
                                                                            i3 = i;
                                                                            str = str;
                                                                            str2 = str2;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        }
                                                                    } catch (Exception e10) {
                                                                        e = e10;
                                                                        z2 = false;
                                                                        i2 = 3;
                                                                    }
                                                                } catch (Exception e11) {
                                                                    e = e11;
                                                                    i2 = 3;
                                                                }
                                                            } catch (Exception e12) {
                                                                e = e12;
                                                                i2 = 3;
                                                            }
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            z2 = false;
                                                        }
                                                    } catch (Exception e14) {
                                                        e = e14;
                                                        i = 2;
                                                    }
                                                } catch (Exception e15) {
                                                    e = e15;
                                                    z = z4;
                                                }
                                            } catch (Exception e16) {
                                                e = e16;
                                                z2 = false;
                                            }
                                        } catch (Exception e17) {
                                            e = e17;
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                        i2 = 3;
                                        z = true;
                                        z2 = false;
                                        i = 2;
                                        if (Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i5 = i6;
                                        i4 = i2;
                                        z3 = z;
                                        z2 = z2;
                                        i3 = i;
                                        str = str;
                                        str2 = str2;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i2 = 3;
                                    z = true;
                                    z2 = false;
                                    i = 2;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i5 = i6;
                                    i4 = i2;
                                    z3 = z;
                                    z2 = z2;
                                    i3 = i;
                                    str = str;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                }
                            } catch (Exception e20) {
                                e = e20;
                                i6 = i6;
                            }
                        } catch (Exception e21) {
                            e = e21;
                            str = str;
                            i6 = i6;
                            str2 = str2;
                            jCurrentTimeMillis = jCurrentTimeMillis;
                            i2 = 3;
                            z = true;
                            i = 2;
                            z2 = z2;
                        }
                    } catch (Exception e22) {
                        e = e22;
                        z = true;
                        i = 2;
                        i2 = i4;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i5 = i6;
                        i4 = i2;
                        z3 = z;
                        z2 = z2;
                        i3 = i;
                        str = str;
                        str2 = str2;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                    }
                } catch (Exception e23) {
                    e = e23;
                    i = i3;
                    z = true;
                }
            } catch (Exception e24) {
                e = e24;
                str = str;
                i = i3;
                i6 = i6;
                str2 = str2;
                jCurrentTimeMillis = jCurrentTimeMillis;
                z = z3;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:141:0x03a1 A[LOOP:0: B:3:0x0144->B:141:0x03a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x03af A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InitiateMultipartUploadResponse initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        boolean z2;
        int i;
        int backoffTime;
        TeaModel.validateParams(initiateMultipartUploadRequest, "request");
        String str = "retry";
        boolean z3 = false;
        boolean z4 = true;
        int i2 = 2;
        int i3 = 3;
        String str2 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i4 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str), i4, jCurrentTimeMillis)) {
            if (i4 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str2), i4)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i5 = i4 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "POST";
                    StringBuilder sb = new StringBuilder();
                    try {
                        sb.append(WVNativeCallbackUtil.SEPERATER);
                        sb.append(initiateMultipartUploadRequest.objectName);
                        sb.append("?uploads");
                        teaRequest2.pathname = sb.toString();
                        Map[] mapArr = new Map[i2];
                        try {
                            TeaPair[] teaPairArr = new TeaPair[i3];
                            str = str;
                            i5 = i5;
                            try {
                                str2 = str2;
                                try {
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    try {
                                        try {
                                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(initiateMultipartUploadRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                            try {
                                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                try {
                                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                    try {
                                                        mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                        try {
                                                            mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(initiateMultipartUploadRequest.header));
                                                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                            if (!Common.empty(securityToken)) {
                                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                            }
                                                            teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(initiateMultipartUploadRequest.filter));
                                                            if (Common.isUnset(TeaModel.buildMap(initiateMultipartUploadRequest.header)) || Common.empty(initiateMultipartUploadRequest.header.contentType)) {
                                                                teaRequest2.headers.put(e.f, com.aliyun.ossutil.Client.getContentType(initiateMultipartUploadRequest.objectName));
                                                            } else {
                                                                teaRequest2.headers.put(e.f, initiateMultipartUploadRequest.header.contentType);
                                                            }
                                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, initiateMultipartUploadRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                            try {
                                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    try {
                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                Map[] mapArr2 = new Map[2];
                                                                                try {
                                                                                    TeaPair[] teaPairArr2 = new TeaPair[1];
                                                                                    try {
                                                                                        teaPairArr2[0] = new TeaPair("InitiateMultipartUploadResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), InitiateMultipartUploadResponse.class).get("InitiateMultipartUploadResult"));
                                                                                        mapArr2[0] = TeaConverter.buildMap(teaPairArr2);
                                                                                        try {
                                                                                            mapArr2[1] = teaResponseDoAction.headers;
                                                                                            return (InitiateMultipartUploadResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr2), new InitiateMultipartUploadResponse());
                                                                                        } catch (Exception e) {
                                                                                            e = e;
                                                                                            z2 = true;
                                                                                            teaRequest = teaRequest2;
                                                                                            i = 2;
                                                                                            z = false;
                                                                                            if (Tea.isRetryable(e)) {
                                                                                                throw new RuntimeException(e);
                                                                                            }
                                                                                            i4 = i5;
                                                                                            i2 = i;
                                                                                            z4 = z2;
                                                                                            z3 = z;
                                                                                            str = str;
                                                                                            str2 = str2;
                                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                            i3 = 3;
                                                                                        }
                                                                                    } catch (Exception e2) {
                                                                                        e = e2;
                                                                                        z = false;
                                                                                        teaRequest = teaRequest2;
                                                                                        i = 2;
                                                                                        z2 = true;
                                                                                        if (Tea.isRetryable(e)) {
                                                                                            throw new RuntimeException(e);
                                                                                        }
                                                                                        i4 = i5;
                                                                                        i2 = i;
                                                                                        z4 = z2;
                                                                                        z3 = z;
                                                                                        str = str;
                                                                                        str2 = str2;
                                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                        i3 = 3;
                                                                                    }
                                                                                } catch (Exception e3) {
                                                                                    e = e3;
                                                                                    z2 = true;
                                                                                }
                                                                            } catch (Exception e4) {
                                                                                e = e4;
                                                                                i = 2;
                                                                                teaRequest = teaRequest2;
                                                                                z2 = true;
                                                                                z = false;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i4 = i5;
                                                                                i2 = i;
                                                                                z4 = z2;
                                                                                z3 = z;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                i3 = 3;
                                                                            }
                                                                        }
                                                                    } catch (Exception e5) {
                                                                        e = e5;
                                                                        teaRequest = teaRequest2;
                                                                        i = 2;
                                                                        z2 = true;
                                                                        z = false;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                }
                                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                                TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                try {
                                                                    teaPairArr3[0] = new TeaPair("code", errMessage.get("Code"));
                                                                    try {
                                                                        teaPairArr3[1] = new TeaPair("message", errMessage.get("Message"));
                                                                        TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                        z = false;
                                                                        try {
                                                                            teaPairArr4[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                            z2 = true;
                                                                            try {
                                                                                teaPairArr4[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                                i = 2;
                                                                                try {
                                                                                    teaPairArr4[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                    teaPairArr3[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr4));
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr3));
                                                                                } catch (Exception e6) {
                                                                                    e = e6;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e7) {
                                                                                e = e7;
                                                                                i = 2;
                                                                            }
                                                                        } catch (Exception e8) {
                                                                            e = e8;
                                                                            i = 2;
                                                                            z2 = true;
                                                                            teaRequest = teaRequest2;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i4 = i5;
                                                                            i2 = i;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str = str;
                                                                            str2 = str2;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            i3 = 3;
                                                                        }
                                                                    } catch (Exception e9) {
                                                                        e = e9;
                                                                        z2 = true;
                                                                        i = 2;
                                                                        z = false;
                                                                        teaRequest = teaRequest2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                } catch (Exception e10) {
                                                                    e = e10;
                                                                    z = false;
                                                                }
                                                            } catch (Exception e11) {
                                                                e = e11;
                                                                i = 2;
                                                                z2 = true;
                                                            }
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                            z2 = true;
                                                        }
                                                    } catch (Exception e13) {
                                                        e = e13;
                                                        z = false;
                                                    }
                                                } catch (Exception e14) {
                                                    e = e14;
                                                    i = 2;
                                                }
                                            } catch (Exception e15) {
                                                e = e15;
                                                z2 = true;
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                            z = false;
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i = 2;
                                    z2 = true;
                                    z = false;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i4 = i5;
                                    i2 = i;
                                    z4 = z2;
                                    z3 = z;
                                    str = str;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i3 = 3;
                                }
                            } catch (Exception e19) {
                                e = e19;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i = 2;
                                z2 = true;
                                z = false;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i4 = i5;
                                i2 = i;
                                z4 = z2;
                                z3 = z;
                                str = str;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i3 = 3;
                            }
                        } catch (Exception e20) {
                            e = e20;
                            str = str;
                            i5 = i5;
                        }
                    } catch (Exception e21) {
                        e = e21;
                        z2 = true;
                        z = false;
                        i = i2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i4 = i5;
                        i2 = i;
                        z4 = z2;
                        z3 = z;
                        str = str;
                        str2 = str2;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                        i3 = 3;
                    }
                } catch (Exception e22) {
                    e = e22;
                    z2 = true;
                    z = z3;
                }
            } catch (Exception e23) {
                e = e23;
                z = z3;
                z2 = z4;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0257 A[Catch: Exception -> 0x02d0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x02d0, blocks: (B:24:0x01f8, B:38:0x0257), top: B:69:0x01f8 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02f4 A[LOOP:0: B:3:0x0144->B:64:0x02f4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x0300 A[SYNTHETIC] */
    public ListLiveChannelResponse listLiveChannel(ListLiveChannelRequest listLiveChannelRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(listLiveChannelRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?live";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(listLiveChannelRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(listLiveChannelRequest.filter));
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, listLiveChannelRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("ListLiveChannelResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), ListLiveChannelResponse.class).get("ListLiveChannelResult")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (ListLiveChannelResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new ListLiveChannelResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0257 A[Catch: Exception -> 0x02d0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x02d0, blocks: (B:24:0x01f8, B:38:0x0257), top: B:69:0x01f8 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x02f4 A[LOOP:0: B:3:0x0144->B:64:0x02f4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x0300 A[SYNTHETIC] */
    public ListMultipartUploadsResponse listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(listMultipartUploadsRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = "/?uploads";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(listMultipartUploadsRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(listMultipartUploadsRequest.filter));
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, listMultipartUploadsRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("ListMultipartUploadsResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), ListMultipartUploadsResponse.class).get("ListMultipartUploadsResult")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (ListMultipartUploadsResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new ListMultipartUploadsResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x026d A[Catch: Exception -> 0x02e6, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x02e6, blocks: (B:24:0x020e, B:38:0x026d), top: B:79:0x020e }] */
    /* JADX WARN: Code duplicated, block: B:64:0x030a A[LOOP:0: B:3:0x0144->B:64:0x030a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x0316 A[SYNTHETIC] */
    public ListPartsResponse listParts(ListPartsRequest listPartsRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(listPartsRequest, "request");
        String str3 = "retry";
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "GET";
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER + listPartsRequest.objectName + "";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        i = i4;
                        try {
                            str2 = str4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(listPartsRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(listPartsRequest.filter));
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, listPartsRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                            teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                            teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            c = 2;
                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        }
                                        try {
                                            if (Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                TeaPair[] teaPairArr5 = new TeaPair[3];
                                                teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                c = 2;
                                                try {
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                            } else {
                                                try {
                                                    Map[] mapArr = new Map[2];
                                                    mapArr[0] = TeaConverter.buildMap(new TeaPair("ListPartsResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), ListPartsResponse.class).get("ListPartsResult")));
                                                    mapArr[1] = teaResponseDoAction.headers;
                                                    return (ListPartsResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new ListPartsResponse());
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    c = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                        teaRequest = teaRequest2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        c = 2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    c = 2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str2 = str4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        str2 = str4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    str = str3;
                }
            } catch (Exception e10) {
                e = e10;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            i3 = i;
            c2 = c;
            str3 = str;
            str4 = str2;
            i2 = 3;
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x033b A[LOOP:0: B:3:0x0144->B:123:0x033b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:173:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public OptionObjectResponse optionObject(OptionObjectRequest optionObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        boolean z2;
        int i;
        int backoffTime;
        TeaModel.validateParams(optionObjectRequest, "request");
        String str = "retry";
        boolean z3 = false;
        boolean z4 = true;
        int i2 = 2;
        int i3 = 3;
        String str2 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i4 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str), i4, jCurrentTimeMillis)) {
            if (i4 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str2), i4)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i5 = i4 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "OPTIONS";
                    StringBuilder sb = new StringBuilder();
                    try {
                        sb.append(WVNativeCallbackUtil.SEPERATER);
                        sb.append(optionObjectRequest.objectName);
                        sb.append("");
                        teaRequest2.pathname = sb.toString();
                        Map[] mapArr = new Map[i2];
                        TeaPair[] teaPairArr = new TeaPair[i3];
                        str = str;
                        try {
                            i5 = i5;
                            try {
                                str2 = str2;
                                try {
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    try {
                                        try {
                                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(optionObjectRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                            try {
                                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                try {
                                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                    try {
                                                        mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                        try {
                                                            mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(optionObjectRequest.header));
                                                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                            if (!Common.empty(securityToken)) {
                                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                            }
                                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, optionObjectRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                            try {
                                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    try {
                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                Map[] mapArr2 = new Map[1];
                                                                                try {
                                                                                    mapArr2[0] = teaResponseDoAction.headers;
                                                                                    return (OptionObjectResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr2), new OptionObjectResponse());
                                                                                } catch (Exception e) {
                                                                                    e = e;
                                                                                    z = false;
                                                                                    teaRequest = teaRequest2;
                                                                                    i = 2;
                                                                                    z2 = true;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e2) {
                                                                                e = e2;
                                                                                z2 = true;
                                                                                teaRequest = teaRequest2;
                                                                                i = 2;
                                                                                z = false;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i4 = i5;
                                                                                i2 = i;
                                                                                z4 = z2;
                                                                                z3 = z;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                i3 = 3;
                                                                            }
                                                                        }
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                        teaRequest = teaRequest2;
                                                                        i = 2;
                                                                        z2 = true;
                                                                        z = false;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                }
                                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                                try {
                                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                                    try {
                                                                        teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                        z = false;
                                                                        try {
                                                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                            z2 = true;
                                                                            try {
                                                                                teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                                i = 2;
                                                                                try {
                                                                                    teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                    teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                                                } catch (Exception e4) {
                                                                                    e = e4;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e5) {
                                                                                e = e5;
                                                                                i = 2;
                                                                            }
                                                                        } catch (Exception e6) {
                                                                            e = e6;
                                                                            i = 2;
                                                                            z2 = true;
                                                                            teaRequest = teaRequest2;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i4 = i5;
                                                                            i2 = i;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str = str;
                                                                            str2 = str2;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            i3 = 3;
                                                                        }
                                                                    } catch (Exception e7) {
                                                                        e = e7;
                                                                        z2 = true;
                                                                        i = 2;
                                                                        z = false;
                                                                        teaRequest = teaRequest2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                } catch (Exception e8) {
                                                                    e = e8;
                                                                    z = false;
                                                                }
                                                            } catch (Exception e9) {
                                                                e = e9;
                                                                i = 2;
                                                                z2 = true;
                                                            }
                                                        } catch (Exception e10) {
                                                            e = e10;
                                                            z2 = true;
                                                        }
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        z = false;
                                                    }
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    i = 2;
                                                    z2 = true;
                                                    z = false;
                                                    if (Tea.isRetryable(e)) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    i4 = i5;
                                                    i2 = i;
                                                    z4 = z2;
                                                    z3 = z;
                                                    str = str;
                                                    str2 = str2;
                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                    i3 = 3;
                                                }
                                            } catch (Exception e13) {
                                                e = e13;
                                                z2 = true;
                                            }
                                        } catch (Exception e14) {
                                            e = e14;
                                            z = false;
                                        }
                                    } catch (Exception e15) {
                                        e = e15;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i = 2;
                                    z2 = true;
                                    z = false;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i4 = i5;
                                    i2 = i;
                                    z4 = z2;
                                    z3 = z;
                                    str = str;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i3 = 3;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i = 2;
                                z2 = true;
                                z = false;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i4 = i5;
                                i2 = i;
                                z4 = z2;
                                z3 = z;
                                str = str;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i3 = 3;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            i5 = i5;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        z2 = true;
                        z = false;
                        i = i2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i4 = i5;
                        i2 = i;
                        z4 = z2;
                        z3 = z;
                        str = str;
                        str2 = str2;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                        i3 = 3;
                    }
                } catch (Exception e20) {
                    e = e20;
                    z2 = true;
                    z = z3;
                }
            } catch (Exception e21) {
                e = e21;
                z = z3;
                z2 = z4;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0312 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0304 A[LOOP:0: B:3:0x010b->B:87:0x0304, LOOP_END] */
    public PostObjectResponse postObject(PostObjectRequest postObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        long j;
        char c;
        int i2;
        int backoffTime;
        TeaModel.validateParams(postObjectRequest, "request");
        String str3 = "retry";
        int i3 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        TeaRequest teaRequest = null;
        int i4 = 0;
        for (long jCurrentTimeMillis = System.currentTimeMillis(); Tea.allowRetry((Map) mapBuildMap.get(str3), i4, jCurrentTimeMillis); jCurrentTimeMillis = j) {
            if (i4 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i4)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i5 = i4 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String boundary = com.aliyun.fileform.Client.getBoundary();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = "POST";
                teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER;
                TeaPair[] teaPairArr = new TeaPair[i3];
                try {
                    str = str3;
                    try {
                        i = i5;
                        try {
                            str2 = str4;
                            try {
                                j = jCurrentTimeMillis;
                                try {
                                    teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(postObjectRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                    teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                    try {
                                        teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                        Map<String, String> mapBuildMap2 = TeaConverter.buildMap(teaPairArr);
                                        teaRequest2.headers = mapBuildMap2;
                                        mapBuildMap2.put(e.f, "multipart/form-data; boundary=" + boundary + "");
                                        try {
                                            Map[] mapArr = new Map[2];
                                            TeaPair[] teaPairArr2 = new TeaPair[6];
                                            teaPairArr2[0] = new TeaPair(RequestParameters.OSS_ACCESS_KEY_ID, postObjectRequest.header.accessKeyId);
                                            teaPairArr2[1] = new TeaPair(AuthConstant.INI_POLICY, postObjectRequest.header.policy);
                                            c = 2;
                                            try {
                                                teaPairArr2[2] = new TeaPair("Signature", postObjectRequest.header.signature);
                                                try {
                                                    teaPairArr2[3] = new TeaPair(CachedContentIndex.a.e, postObjectRequest.header.key);
                                                    teaPairArr2[4] = new TeaPair("success_action_status", postObjectRequest.header.successActionStatus);
                                                    teaPairArr2[5] = new TeaPair("file", postObjectRequest.header.file);
                                                    mapArr[0] = TeaConverter.buildMap(teaPairArr2);
                                                    mapArr[1] = com.aliyun.ossutil.Client.toMeta(postObjectRequest.header.userMeta, OSSHeaders.OSS_USER_METADATA_PREFIX);
                                                    teaRequest2.body = com.aliyun.fileform.Client.toFileForm(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), boundary);
                                                    try {
                                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                        String asString = Common.readAsString(teaResponseDoAction.body);
                                                        if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            try {
                                                                if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    return (PostObjectResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) new Map[]{com.aliyun.teaxml.Client.parseXml(asString, PostObjectResponse.class)}), new PostObjectResponse());
                                                                }
                                                            } catch (Exception e) {
                                                                e = e;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                i2 = 3;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i4 = i;
                                                                i3 = i2;
                                                                str3 = str;
                                                                str4 = str2;
                                                            }
                                                        }
                                                        Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(asString);
                                                        try {
                                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                                            teaPairArr3[0] = new TeaPair("code", errMessage.get("Code"));
                                                            teaPairArr3[1] = new TeaPair("message", errMessage.get("Message"));
                                                            i2 = 3;
                                                            try {
                                                                TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                teaPairArr4[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                teaPairArr4[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                c = 2;
                                                                try {
                                                                    teaPairArr4[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                    teaPairArr3[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr4));
                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr3));
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    teaRequest = teaRequest2;
                                                                    if (!Tea.isRetryable(e)) {
                                                                        throw new RuntimeException(e);
                                                                    }
                                                                    i4 = i;
                                                                    i3 = i2;
                                                                    str3 = str;
                                                                    str4 = str2;
                                                                }
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                c = 2;
                                                                teaRequest = teaRequest2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i4 = i;
                                                                i3 = i2;
                                                                str3 = str;
                                                                str4 = str2;
                                                            }
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        c = 2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e6) {
                                                    e = e6;
                                                    i2 = 3;
                                                    c = 2;
                                                }
                                            } catch (Exception e7) {
                                                e = e7;
                                                i2 = 3;
                                                if (!Tea.isRetryable(e)) {
                                                    throw new RuntimeException(e);
                                                }
                                                i4 = i;
                                                i3 = i2;
                                                str3 = str;
                                                str4 = str2;
                                            }
                                        } catch (Exception e8) {
                                            e = e8;
                                            c = 2;
                                        }
                                    } catch (Exception e9) {
                                        e = e9;
                                        c = 2;
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                }
                            } catch (Exception e11) {
                                e = e11;
                                j = jCurrentTimeMillis;
                                c = 2;
                                i2 = 3;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i4 = i;
                                i3 = i2;
                                str3 = str;
                                str4 = str2;
                            }
                        } catch (Exception e12) {
                            e = e12;
                            str2 = str4;
                            j = jCurrentTimeMillis;
                            c = 2;
                            i2 = 3;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i4 = i;
                            i3 = i2;
                            str3 = str;
                            str4 = str2;
                        }
                    } catch (Exception e13) {
                        e = e13;
                        i = i5;
                        str2 = str4;
                        j = jCurrentTimeMillis;
                        c = 2;
                        i2 = 3;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i4 = i;
                        i3 = i2;
                        str3 = str;
                        str4 = str2;
                    }
                } catch (Exception e14) {
                    e = e14;
                    str = str3;
                }
            } catch (Exception e15) {
                e = e15;
                str = str3;
                i = i5;
                str2 = str4;
                j = jCurrentTimeMillis;
                c = 2;
                i2 = i3;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x02eb A[LOOP:0: B:3:0x0144->B:58:0x02eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:84:0x02f7 A[SYNTHETIC] */
    public PostVodPlaylistResponse postVodPlaylist(PostVodPlaylistRequest postVodPlaylistRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        String str2;
        char c;
        int i;
        int backoffTime;
        String str3 = WVNativeCallbackUtil.SEPERATER;
        TeaModel.validateParams(postVodPlaylistRequest, "request");
        String str4 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str4), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "POST";
                    teaRequest2.pathname = str3 + postVodPlaylistRequest.channelName + str3 + postVodPlaylistRequest.playlistName + "?vod";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str3;
                    try {
                        str2 = str4;
                        try {
                            i = i4;
                            try {
                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(postVodPlaylistRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                try {
                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                    teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                    if (!Common.empty(securityToken)) {
                                        teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                    }
                                    teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(postVodPlaylistRequest.filter));
                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, postVodPlaylistRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                    try {
                                        TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                        if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                            try {
                                                if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    return (PostVodPlaylistResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new PostVodPlaylistResponse());
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                teaRequest = teaRequest2;
                                                c = 2;
                                                if (Tea.isRetryable(e)) {
                                                    throw new RuntimeException(e);
                                                }
                                                i3 = i;
                                                c2 = c;
                                                str3 = str;
                                                str4 = str2;
                                                i2 = 3;
                                            }
                                        }
                                        Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                        TeaPair[] teaPairArr2 = new TeaPair[3];
                                        teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                        teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                        TeaPair teaPair = new TeaPair("hostId", errMessage.get("HostId"));
                                        c = 2;
                                        try {
                                            teaPairArr3[2] = teaPair;
                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                        } catch (Exception e2) {
                                            e = e2;
                                            teaRequest = teaRequest2;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        c = 2;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    c = 2;
                                }
                            } catch (Exception e5) {
                                e = e5;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            i = i4;
                            c = 2;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str2 = str4;
                        i = i4;
                        c = 2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str3 = str;
                        str4 = str2;
                        i2 = 3;
                    }
                } catch (Exception e8) {
                    e = e8;
                    str = str3;
                }
            } catch (Exception e9) {
                e = e9;
                str = str3;
                str2 = str4;
                c = c2;
                i = i4;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0335 A[LOOP:0: B:3:0x0144->B:123:0x0335, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:173:0x0343 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PutBucketResponse putBucket(PutBucketRequest putBucketRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        boolean z2;
        int i;
        int backoffTime;
        TeaModel.validateParams(putBucketRequest, "request");
        String str = "retry";
        boolean z3 = false;
        boolean z4 = true;
        int i2 = 2;
        int i3 = 3;
        String str2 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i4 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str), i4, jCurrentTimeMillis)) {
            if (i4 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str2), i4)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i5 = i4 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putBucketRequest.body));
                    try {
                        teaRequest2.protocol = this._protocol;
                        teaRequest2.method = HttpManager.HTTP_PUT;
                        teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER;
                        Map[] mapArr = new Map[i2];
                        try {
                            TeaPair[] teaPairArr = new TeaPair[i3];
                            str = str;
                            i5 = i5;
                            try {
                                str2 = str2;
                                try {
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    try {
                                        try {
                                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                            try {
                                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                try {
                                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                    try {
                                                        mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                        try {
                                                            mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(putBucketRequest.header));
                                                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                            if (!Common.empty(securityToken)) {
                                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                            }
                                                            teaRequest2.body = Tea.toReadable(xml);
                                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                            try {
                                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    try {
                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                Map[] mapArr2 = new Map[1];
                                                                                try {
                                                                                    mapArr2[0] = teaResponseDoAction.headers;
                                                                                    return (PutBucketResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr2), new PutBucketResponse());
                                                                                } catch (Exception e) {
                                                                                    e = e;
                                                                                    z = false;
                                                                                    teaRequest = teaRequest2;
                                                                                    i = 2;
                                                                                    z2 = true;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e2) {
                                                                                e = e2;
                                                                                z2 = true;
                                                                                teaRequest = teaRequest2;
                                                                                i = 2;
                                                                                z = false;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i4 = i5;
                                                                                i2 = i;
                                                                                z4 = z2;
                                                                                z3 = z;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                i3 = 3;
                                                                            }
                                                                        }
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                        teaRequest = teaRequest2;
                                                                        i = 2;
                                                                        z2 = true;
                                                                        z = false;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                }
                                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                                try {
                                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                                    try {
                                                                        teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                        z = false;
                                                                        try {
                                                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                            z2 = true;
                                                                            try {
                                                                                teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                                i = 2;
                                                                                try {
                                                                                    teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                    teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                                                } catch (Exception e4) {
                                                                                    e = e4;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e5) {
                                                                                e = e5;
                                                                                i = 2;
                                                                            }
                                                                        } catch (Exception e6) {
                                                                            e = e6;
                                                                            i = 2;
                                                                            z2 = true;
                                                                            teaRequest = teaRequest2;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i4 = i5;
                                                                            i2 = i;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str = str;
                                                                            str2 = str2;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            i3 = 3;
                                                                        }
                                                                    } catch (Exception e7) {
                                                                        e = e7;
                                                                        z2 = true;
                                                                        i = 2;
                                                                        z = false;
                                                                        teaRequest = teaRequest2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                } catch (Exception e8) {
                                                                    e = e8;
                                                                    z = false;
                                                                }
                                                            } catch (Exception e9) {
                                                                e = e9;
                                                                i = 2;
                                                                z2 = true;
                                                            }
                                                        } catch (Exception e10) {
                                                            e = e10;
                                                            z2 = true;
                                                        }
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        z = false;
                                                    }
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    i = 2;
                                                    z2 = true;
                                                    z = false;
                                                    if (Tea.isRetryable(e)) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    i4 = i5;
                                                    i2 = i;
                                                    z4 = z2;
                                                    z3 = z;
                                                    str = str;
                                                    str2 = str2;
                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                    i3 = 3;
                                                }
                                            } catch (Exception e13) {
                                                e = e13;
                                                z2 = true;
                                            }
                                        } catch (Exception e14) {
                                            e = e14;
                                            z = false;
                                        }
                                    } catch (Exception e15) {
                                        e = e15;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i = 2;
                                    z2 = true;
                                    z = false;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i4 = i5;
                                    i2 = i;
                                    z4 = z2;
                                    z3 = z;
                                    str = str;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i3 = 3;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i = 2;
                                z2 = true;
                                z = false;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i4 = i5;
                                i2 = i;
                                z4 = z2;
                                z3 = z;
                                str = str;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i3 = 3;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            str = str;
                            i5 = i5;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        z2 = true;
                        z = false;
                        i = i2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i4 = i5;
                        i2 = i;
                        z4 = z2;
                        z3 = z;
                        str = str;
                        str2 = str2;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                        i3 = 3;
                    }
                } catch (Exception e20) {
                    e = e20;
                    z2 = true;
                    z = z3;
                }
            } catch (Exception e21) {
                e = e21;
                z = z3;
                z2 = z4;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0323 A[LOOP:0: B:3:0x0144->B:121:0x0323, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:169:0x0331 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public PutBucketAclResponse putBucketAcl(PutBucketAclRequest putBucketAclRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        int i;
        int backoffTime;
        TeaModel.validateParams(putBucketAclRequest, "request");
        String str = "retry";
        boolean z2 = false;
        boolean z3 = true;
        int i2 = 2;
        int i3 = 3;
        String str2 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i4 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str), i4, jCurrentTimeMillis)) {
            if (i4 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str2), i4)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i5 = i4 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = "/?acl";
                    Map[] mapArr = new Map[i2];
                    try {
                        TeaPair[] teaPairArr = new TeaPair[i3];
                        str = str;
                        try {
                            i5 = i5;
                            try {
                                str2 = str2;
                                try {
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    try {
                                        try {
                                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketAclRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                            boolean z4 = true;
                                            try {
                                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                try {
                                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                    try {
                                                        mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                        z4 = true;
                                                        mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(putBucketAclRequest.header));
                                                        teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                        if (!Common.empty(securityToken)) {
                                                            teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                        }
                                                        teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketAclRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                        try {
                                                            TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                            if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                try {
                                                                    if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                        try {
                                                                            Map[] mapArr2 = new Map[1];
                                                                            try {
                                                                                mapArr2[0] = teaResponseDoAction.headers;
                                                                                return (PutBucketAclResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr2), new PutBucketAclResponse());
                                                                            } catch (Exception e) {
                                                                                e = e;
                                                                                z2 = false;
                                                                                teaRequest = teaRequest2;
                                                                                i = 2;
                                                                                z = true;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i4 = i5;
                                                                                i2 = i;
                                                                                z3 = z;
                                                                                z2 = z2;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                i3 = 3;
                                                                            }
                                                                        } catch (Exception e2) {
                                                                            e = e2;
                                                                            z = true;
                                                                            teaRequest = teaRequest2;
                                                                            i = 2;
                                                                            z2 = false;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i4 = i5;
                                                                            i2 = i;
                                                                            z3 = z;
                                                                            z2 = z2;
                                                                            str = str;
                                                                            str2 = str2;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            i3 = 3;
                                                                        }
                                                                    }
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    teaRequest = teaRequest2;
                                                                    i = 2;
                                                                    z = true;
                                                                    z2 = false;
                                                                    if (Tea.isRetryable(e)) {
                                                                        throw new RuntimeException(e);
                                                                    }
                                                                    i4 = i5;
                                                                    i2 = i;
                                                                    z3 = z;
                                                                    z2 = z2;
                                                                    str = str;
                                                                    str2 = str2;
                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                    i3 = 3;
                                                                }
                                                            }
                                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                            TeaPair[] teaPairArr2 = new TeaPair[3];
                                                            try {
                                                                teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                                try {
                                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                    z2 = false;
                                                                    try {
                                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                        z = true;
                                                                        try {
                                                                            teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                            i = 2;
                                                                            try {
                                                                                teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                                                throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                                            } catch (Exception e4) {
                                                                                e = e4;
                                                                                teaRequest = teaRequest2;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i4 = i5;
                                                                                i2 = i;
                                                                                z3 = z;
                                                                                z2 = z2;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                i3 = 3;
                                                                            }
                                                                        } catch (Exception e5) {
                                                                            e = e5;
                                                                            i = 2;
                                                                        }
                                                                    } catch (Exception e6) {
                                                                        e = e6;
                                                                        i = 2;
                                                                        z = true;
                                                                        teaRequest = teaRequest2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z3 = z;
                                                                        z2 = z2;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                } catch (Exception e7) {
                                                                    e = e7;
                                                                    z = true;
                                                                    i = 2;
                                                                    z2 = false;
                                                                    teaRequest = teaRequest2;
                                                                    if (Tea.isRetryable(e)) {
                                                                        throw new RuntimeException(e);
                                                                    }
                                                                    i4 = i5;
                                                                    i2 = i;
                                                                    z3 = z;
                                                                    z2 = z2;
                                                                    str = str;
                                                                    str2 = str2;
                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                    i3 = 3;
                                                                }
                                                            } catch (Exception e8) {
                                                                e = e8;
                                                                z2 = false;
                                                            }
                                                        } catch (Exception e9) {
                                                            e = e9;
                                                            i = 2;
                                                            z = true;
                                                        }
                                                    } catch (Exception e10) {
                                                        e = e10;
                                                        z2 = false;
                                                    }
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    i = 2;
                                                    z = true;
                                                    z2 = false;
                                                    if (Tea.isRetryable(e)) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    i4 = i5;
                                                    i2 = i;
                                                    z3 = z;
                                                    z2 = z2;
                                                    str = str;
                                                    str2 = str2;
                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                    i3 = 3;
                                                }
                                            } catch (Exception e12) {
                                                e = e12;
                                                z = z4;
                                            }
                                        } catch (Exception e13) {
                                            e = e13;
                                            z2 = false;
                                        }
                                    } catch (Exception e14) {
                                        e = e14;
                                    }
                                } catch (Exception e15) {
                                    e = e15;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i = 2;
                                    z = true;
                                    z2 = false;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i4 = i5;
                                    i2 = i;
                                    z3 = z;
                                    z2 = z2;
                                    str = str;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i3 = 3;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i = 2;
                                z = true;
                                z2 = false;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i4 = i5;
                                i2 = i;
                                z3 = z;
                                z2 = z2;
                                str = str;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i3 = 3;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            i5 = i5;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str = str;
                        i5 = i5;
                        str2 = str2;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                        i = 2;
                        z = true;
                        z2 = z2;
                    }
                } catch (Exception e19) {
                    e = e19;
                    z = true;
                    i = i2;
                    if (Tea.isRetryable(e)) {
                        throw new RuntimeException(e);
                    }
                    i4 = i5;
                    i2 = i;
                    z3 = z;
                    z2 = z2;
                    str = str;
                    str2 = str2;
                    jCurrentTimeMillis = jCurrentTimeMillis;
                    i3 = 3;
                }
            } catch (Exception e20) {
                e = e20;
                z = z3;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x02eb A[LOOP:0: B:3:0x0142->B:83:0x02eb, LOOP_END] */
    public PutBucketCORSResponse putBucketCORS(PutBucketCORSRequest putBucketCORSRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putBucketCORSRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putBucketCORSRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = "/?cors";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketCORSRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketCORSRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (PutBucketCORSResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new PutBucketCORSResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x02eb A[LOOP:0: B:3:0x0142->B:83:0x02eb, LOOP_END] */
    public PutBucketEncryptionResponse putBucketEncryption(PutBucketEncryptionRequest putBucketEncryptionRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putBucketEncryptionRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putBucketEncryptionRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = "/?encryption";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketEncryptionRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketEncryptionRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (PutBucketEncryptionResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new PutBucketEncryptionResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x02eb A[LOOP:0: B:3:0x0142->B:83:0x02eb, LOOP_END] */
    public PutBucketLifecycleResponse putBucketLifecycle(PutBucketLifecycleRequest putBucketLifecycleRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putBucketLifecycleRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putBucketLifecycleRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = "/?lifecycle";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketLifecycleRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketLifecycleRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (PutBucketLifecycleResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new PutBucketLifecycleResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x02eb A[LOOP:0: B:3:0x0142->B:83:0x02eb, LOOP_END] */
    public PutBucketLoggingResponse putBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putBucketLoggingRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putBucketLoggingRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = "/?logging";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketLoggingRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketLoggingRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (PutBucketLoggingResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new PutBucketLoggingResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x02eb A[LOOP:0: B:3:0x0142->B:83:0x02eb, LOOP_END] */
    public PutBucketRefererResponse putBucketReferer(PutBucketRefererRequest putBucketRefererRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putBucketRefererRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putBucketRefererRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = "/?referer";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketRefererRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketRefererRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (PutBucketRefererResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new PutBucketRefererResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x02eb A[LOOP:0: B:3:0x0142->B:83:0x02eb, LOOP_END] */
    public PutBucketRequestPaymentResponse putBucketRequestPayment(PutBucketRequestPaymentRequest putBucketRequestPaymentRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putBucketRequestPaymentRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putBucketRequestPaymentRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = "/?requestPayment";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketRequestPaymentRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketRequestPaymentRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (PutBucketRequestPaymentResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new PutBucketRequestPaymentResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x02eb A[LOOP:0: B:3:0x0142->B:83:0x02eb, LOOP_END] */
    public PutBucketTagsResponse putBucketTags(PutBucketTagsRequest putBucketTagsRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putBucketTagsRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putBucketTagsRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = "/?tagging";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketTagsRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketTagsRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (PutBucketTagsResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new PutBucketTagsResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x02eb A[LOOP:0: B:3:0x0142->B:83:0x02eb, LOOP_END] */
    public PutBucketWebsiteResponse putBucketWebsite(PutBucketWebsiteRequest putBucketWebsiteRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putBucketWebsiteRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putBucketWebsiteRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = "/?website";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putBucketWebsiteRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putBucketWebsiteRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (PutBucketWebsiteResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new PutBucketWebsiteResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x035c A[LOOP:0: B:3:0x0144->B:123:0x035c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:175:0x036a A[SYNTHETIC] */
    public PutLiveChannelResponse putLiveChannel(PutLiveChannelRequest putLiveChannelRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        String str2;
        long j;
        boolean z;
        boolean z2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putLiveChannelRequest, "request");
        String str3 = "retry";
        boolean z3 = false;
        boolean z4 = true;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putLiveChannelRequest.body));
                    try {
                        teaRequest2.protocol = this._protocol;
                        teaRequest2.method = HttpManager.HTTP_PUT;
                        StringBuilder sb = new StringBuilder();
                        try {
                            sb.append(WVNativeCallbackUtil.SEPERATER);
                            sb.append(putLiveChannelRequest.channelName);
                            sb.append("?live");
                            teaRequest2.pathname = sb.toString();
                            TeaPair[] teaPairArr = new TeaPair[i2];
                            str = str3;
                            try {
                                i = i4;
                                try {
                                    str2 = str4;
                                    try {
                                        j = jCurrentTimeMillis;
                                        try {
                                            try {
                                                teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putLiveChannelRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                                try {
                                                    teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                    try {
                                                        teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                        teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                                        if (!Common.empty(securityToken)) {
                                                            teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                        }
                                                        teaRequest2.body = Tea.toReadable(xml);
                                                        teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putLiveChannelRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                        try {
                                                            TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                            if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                try {
                                                                    if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                        try {
                                                                            Map[] mapArr = new Map[2];
                                                                            try {
                                                                                TeaPair[] teaPairArr2 = new TeaPair[1];
                                                                                try {
                                                                                    teaPairArr2[0] = new TeaPair("CreateLiveChannelResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), PutLiveChannelResponse.class).get("CreateLiveChannelResult"));
                                                                                    mapArr[0] = TeaConverter.buildMap(teaPairArr2);
                                                                                    try {
                                                                                        mapArr[1] = teaResponseDoAction.headers;
                                                                                        return (PutLiveChannelResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr), new PutLiveChannelResponse());
                                                                                    } catch (Exception e) {
                                                                                        e = e;
                                                                                        z2 = true;
                                                                                        teaRequest = teaRequest2;
                                                                                        c = 2;
                                                                                        z = false;
                                                                                        if (Tea.isRetryable(e)) {
                                                                                            throw new RuntimeException(e);
                                                                                        }
                                                                                        i3 = i;
                                                                                        c2 = c;
                                                                                        z4 = z2;
                                                                                        z3 = z;
                                                                                        str3 = str;
                                                                                        str4 = str2;
                                                                                        jCurrentTimeMillis = j;
                                                                                        i2 = 3;
                                                                                    }
                                                                                } catch (Exception e2) {
                                                                                    e = e2;
                                                                                    z = false;
                                                                                    teaRequest = teaRequest2;
                                                                                    c = 2;
                                                                                    z2 = true;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i3 = i;
                                                                                    c2 = c;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str3 = str;
                                                                                    str4 = str2;
                                                                                    jCurrentTimeMillis = j;
                                                                                    i2 = 3;
                                                                                }
                                                                            } catch (Exception e3) {
                                                                                e = e3;
                                                                                z2 = true;
                                                                            }
                                                                        } catch (Exception e4) {
                                                                            e = e4;
                                                                            c = 2;
                                                                            teaRequest = teaRequest2;
                                                                            z2 = true;
                                                                            z = false;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i3 = i;
                                                                            c2 = c;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str3 = str;
                                                                            str4 = str2;
                                                                            jCurrentTimeMillis = j;
                                                                            i2 = 3;
                                                                        }
                                                                    }
                                                                } catch (Exception e5) {
                                                                    e = e5;
                                                                    teaRequest = teaRequest2;
                                                                    c = 2;
                                                                    z2 = true;
                                                                    z = false;
                                                                    if (Tea.isRetryable(e)) {
                                                                        throw new RuntimeException(e);
                                                                    }
                                                                    i3 = i;
                                                                    c2 = c;
                                                                    z4 = z2;
                                                                    z3 = z;
                                                                    str3 = str;
                                                                    str4 = str2;
                                                                    jCurrentTimeMillis = j;
                                                                    i2 = 3;
                                                                }
                                                            }
                                                            Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                            TeaPair[] teaPairArr3 = new TeaPair[3];
                                                            try {
                                                                teaPairArr3[0] = new TeaPair("code", errMessage.get("Code"));
                                                                try {
                                                                    teaPairArr3[1] = new TeaPair("message", errMessage.get("Message"));
                                                                    TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                    z = false;
                                                                    try {
                                                                        teaPairArr4[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                        z2 = true;
                                                                        try {
                                                                            teaPairArr4[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                            c = 2;
                                                                            try {
                                                                                teaPairArr4[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                teaPairArr3[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr4));
                                                                                throw new TeaException(TeaConverter.buildMap(teaPairArr3));
                                                                            } catch (Exception e6) {
                                                                                e = e6;
                                                                                teaRequest = teaRequest2;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i3 = i;
                                                                                c2 = c;
                                                                                z4 = z2;
                                                                                z3 = z;
                                                                                str3 = str;
                                                                                str4 = str2;
                                                                                jCurrentTimeMillis = j;
                                                                                i2 = 3;
                                                                            }
                                                                        } catch (Exception e7) {
                                                                            e = e7;
                                                                            c = 2;
                                                                        }
                                                                    } catch (Exception e8) {
                                                                        e = e8;
                                                                        c = 2;
                                                                        z2 = true;
                                                                        teaRequest = teaRequest2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i3 = i;
                                                                        c2 = c;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str3 = str;
                                                                        str4 = str2;
                                                                        jCurrentTimeMillis = j;
                                                                        i2 = 3;
                                                                    }
                                                                } catch (Exception e9) {
                                                                    e = e9;
                                                                    z2 = true;
                                                                    c = 2;
                                                                    z = false;
                                                                    teaRequest = teaRequest2;
                                                                    if (Tea.isRetryable(e)) {
                                                                        throw new RuntimeException(e);
                                                                    }
                                                                    i3 = i;
                                                                    c2 = c;
                                                                    z4 = z2;
                                                                    z3 = z;
                                                                    str3 = str;
                                                                    str4 = str2;
                                                                    jCurrentTimeMillis = j;
                                                                    i2 = 3;
                                                                }
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                z = false;
                                                            }
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            c = 2;
                                                            z2 = true;
                                                        }
                                                    } catch (Exception e12) {
                                                        e = e12;
                                                        c = 2;
                                                    }
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    z2 = true;
                                                }
                                            } catch (Exception e14) {
                                                e = e14;
                                                z = false;
                                            }
                                        } catch (Exception e15) {
                                            e = e15;
                                        }
                                    } catch (Exception e16) {
                                        e = e16;
                                        j = jCurrentTimeMillis;
                                        c = 2;
                                        z2 = true;
                                        z = false;
                                        if (Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        z4 = z2;
                                        z3 = z;
                                        str3 = str;
                                        str4 = str2;
                                        jCurrentTimeMillis = j;
                                        i2 = 3;
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    str2 = str4;
                                    j = jCurrentTimeMillis;
                                    c = 2;
                                    z2 = true;
                                    z = false;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i3 = i;
                                    c2 = c;
                                    z4 = z2;
                                    z3 = z;
                                    str3 = str;
                                    str4 = str2;
                                    jCurrentTimeMillis = j;
                                    i2 = 3;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                i = i4;
                                str2 = str4;
                                j = jCurrentTimeMillis;
                                c = 2;
                                z2 = true;
                                z = false;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z4 = z2;
                                z3 = z;
                                str3 = str;
                                str4 = str2;
                                jCurrentTimeMillis = j;
                                i2 = 3;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            str = str3;
                        }
                    } catch (Exception e20) {
                        e = e20;
                        str = str3;
                        i = i4;
                        str2 = str4;
                        j = jCurrentTimeMillis;
                        c = 2;
                        z2 = true;
                        z = z3;
                    }
                } catch (Exception e21) {
                    e = e21;
                    str = str3;
                    i = i4;
                    str2 = str4;
                    j = jCurrentTimeMillis;
                    c = 2;
                    z = z3;
                    z2 = z4;
                }
            } catch (Exception e22) {
                e = e22;
                str = str3;
                i = i4;
                str2 = str4;
                j = jCurrentTimeMillis;
                z = z3;
                z2 = z4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02da A[LOOP:0: B:3:0x0142->B:53:0x02da, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02e4 A[SYNTHETIC] */
    public PutLiveChannelStatusResponse putLiveChannelStatus(PutLiveChannelStatusRequest putLiveChannelStatusRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(putLiveChannelStatusRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = HttpManager.HTTP_PUT;
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(putLiveChannelStatusRequest.channelName);
                    sb.append("?live");
                    teaRequest2.pathname = sb.toString();
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putLiveChannelStatusRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(putLiveChannelStatusRequest.filter));
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putLiveChannelStatusRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (PutLiveChannelStatusResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new PutLiveChannelStatusResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x03a9 A[Catch: Exception -> 0x0425, TRY_LEAVE, TryCatch #13 {Exception -> 0x0425, blocks: (B:79:0x0329, B:97:0x038a, B:82:0x0336, B:85:0x033b, B:88:0x034a, B:89:0x0378, B:101:0x03a9), top: B:170:0x0329 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0479 A[LOOP:0: B:3:0x0152->B:139:0x0479, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:187:0x048b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0260 A[Catch: Exception -> 0x0434, TRY_ENTER, TryCatch #5 {Exception -> 0x0434, blocks: (B:26:0x01cc, B:29:0x01f5, B:32:0x0215, B:40:0x0236, B:48:0x026b, B:47:0x0260), top: B:154:0x01cc }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public PutObjectResponse putObject(PutObjectRequest putObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        long j;
        String str;
        String str2;
        TeaRequest teaRequest;
        int i;
        String str3;
        TeaRequest teaRequest2;
        TeaResponse teaResponseDoAction;
        int backoffTime;
        Client client = this;
        PutObjectRequest putObjectRequest2 = putObjectRequest;
        String str4 = "content-md5";
        String str5 = OSSHeaders.OSS_HASH_CRC64_ECMA;
        String str6 = TKDownloadReason.KSAD_TK_MD5;
        TeaModel.validateParams(putObjectRequest2, "request");
        String str7 = "retry";
        String str8 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, client._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, client._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, client._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, client._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, client._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, client._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, client._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, client._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, client._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest3 = null;
        int i2 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str7), i2, jCurrentTimeMillis)) {
            if (i2 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str8), i2)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i3 = i2 + 1;
            try {
                teaRequest2 = new TeaRequest();
                HashMap map = new HashMap();
                j = jCurrentTimeMillis;
                try {
                    String accessKeyId = client._credential.getAccessKeyId();
                    String accessKeySecret = client._credential.getAccessKeySecret();
                    String securityToken = client._credential.getSecurityToken();
                    teaRequest2.protocol = client._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    StringBuilder sb = new StringBuilder();
                    str = str7;
                    try {
                        sb.append(WVNativeCallbackUtil.SEPERATER);
                        sb.append(putObjectRequest2.objectName);
                        sb.append("");
                        teaRequest2.pathname = sb.toString();
                        Map[] mapArr = new Map[3];
                        str2 = str8;
                        try {
                            TeaPair[] teaPairArr = new TeaPair[3];
                            i = i3;
                            teaRequest = teaRequest3;
                            try {
                                String str9 = str4;
                                try {
                                    String str10 = str6;
                                    try {
                                        String str11 = str5;
                                        try {
                                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putObjectRequest2.bucketName, client._regionId, client._endpoint, client._hostModel));
                                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                            char c = 2;
                                            try {
                                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(putObjectRequest2.header));
                                                c = 2;
                                                mapArr[2] = com.aliyun.ossutil.Client.parseMeta(putObjectRequest2.userMeta, OSSHeaders.OSS_USER_METADATA_PREFIX);
                                                teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                if (Common.empty(securityToken)) {
                                                    teaRequest2.body = com.aliyun.ossutil.Client.inject(putObjectRequest2.body, map);
                                                    if (Common.isUnset(TeaModel.buildMap(putObjectRequest2.header))) {
                                                        teaRequest2.headers.put(e.f, com.aliyun.ossutil.Client.getContentType(putObjectRequest2.objectName));
                                                    } else {
                                                        teaRequest2.headers.put(e.f, com.aliyun.ossutil.Client.getContentType(putObjectRequest2.objectName));
                                                    }
                                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putObjectRequest2.bucketName, accessKeyId, accessKeySecret, client._signatureVersion, client._addtionalHeaders));
                                                    teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                        str3 = str9;
                                                        str6 = str10;
                                                        str5 = str11;
                                                        Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                        TeaPair[] teaPairArr2 = new TeaPair[3];
                                                        teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                        teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                    }
                                                    str3 = str9;
                                                    str6 = str10;
                                                    str5 = str11;
                                                    Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                    TeaPair[] teaPairArr4 = new TeaPair[3];
                                                    teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                                    teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                                    TeaPair[] teaPairArr5 = new TeaPair[3];
                                                    teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                    teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                    teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                                    teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                                }
                                                try {
                                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                    teaRequest2.body = com.aliyun.ossutil.Client.inject(putObjectRequest2.body, map);
                                                    if (Common.isUnset(TeaModel.buildMap(putObjectRequest2.header)) || Common.empty(putObjectRequest2.header.contentType)) {
                                                        teaRequest2.headers.put(e.f, com.aliyun.ossutil.Client.getContentType(putObjectRequest2.objectName));
                                                    } else {
                                                        teaRequest2.headers.put(e.f, putObjectRequest2.header.contentType);
                                                    }
                                                    teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putObjectRequest2.bucketName, accessKeyId, accessKeySecret, client._signatureVersion, client._addtionalHeaders));
                                                    try {
                                                        teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                        if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode)) && !Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            if (client._isEnableCrc.booleanValue()) {
                                                                try {
                                                                    str5 = str11;
                                                                    try {
                                                                        if (!Common.equalString((String) map.get("crc"), teaResponseDoAction.headers.get(str5))) {
                                                                            char c2 = 2;
                                                                            try {
                                                                                TeaPair[] teaPairArr6 = new TeaPair[2];
                                                                                teaPairArr6[0] = new TeaPair("code", "CrcNotMatched");
                                                                                c2 = 2;
                                                                                TeaPair[] teaPairArr7 = new TeaPair[2];
                                                                                teaPairArr7[0] = new TeaPair("clientCrc", map.get("crc"));
                                                                                teaPairArr7[1] = new TeaPair("serverCrc", teaResponseDoAction.headers.get(str5));
                                                                                teaPairArr6[1] = new TeaPair("data", TeaConverter.buildMap(teaPairArr7));
                                                                                throw new TeaException(TeaConverter.buildMap(teaPairArr6));
                                                                            } catch (Exception e) {
                                                                                e = e;
                                                                                str3 = str9;
                                                                                str6 = str10;
                                                                            }
                                                                        }
                                                                    } catch (Exception e2) {
                                                                        e = e2;
                                                                        str3 = str9;
                                                                        str6 = str10;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        client = this;
                                                                        putObjectRequest2 = putObjectRequest;
                                                                        i2 = i;
                                                                        str6 = str6;
                                                                        str5 = str5;
                                                                        str4 = str3;
                                                                        teaRequest3 = teaRequest2;
                                                                        jCurrentTimeMillis = j;
                                                                        str7 = str;
                                                                        str8 = str2;
                                                                    }
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    str5 = str11;
                                                                }
                                                            } else {
                                                                str5 = str11;
                                                            }
                                                            if (client._isEnableMD5.booleanValue()) {
                                                                str6 = str10;
                                                                try {
                                                                    str3 = str9;
                                                                    try {
                                                                        if (!Common.equalString((String) map.get(str6), teaResponseDoAction.headers.get(str3))) {
                                                                            try {
                                                                                TeaPair[] teaPairArr8 = new TeaPair[2];
                                                                                teaPairArr8[0] = new TeaPair("code", "MD5NotMatched");
                                                                                try {
                                                                                    TeaPair[] teaPairArr9 = new TeaPair[2];
                                                                                    teaPairArr9[0] = new TeaPair("clientMD5", map.get(str6));
                                                                                    teaPairArr9[1] = new TeaPair("serverMD5", teaResponseDoAction.headers.get(str3));
                                                                                    teaPairArr8[1] = new TeaPair("data", TeaConverter.buildMap(teaPairArr9));
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr8));
                                                                                } catch (Exception e4) {
                                                                                    e = e4;
                                                                                }
                                                                            } catch (Exception e5) {
                                                                                e = e5;
                                                                            }
                                                                        }
                                                                    } catch (Exception e6) {
                                                                        e = e6;
                                                                    }
                                                                } catch (Exception e7) {
                                                                    e = e7;
                                                                    str3 = str9;
                                                                }
                                                            }
                                                            return (PutObjectResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new PutObjectResponse());
                                                        }
                                                        str3 = str9;
                                                        str6 = str10;
                                                        str5 = str11;
                                                        Map<String, Object> errMessage3 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                        TeaPair[] teaPairArr10 = new TeaPair[3];
                                                        teaPairArr10[0] = new TeaPair("code", errMessage3.get("Code"));
                                                        teaPairArr10[1] = new TeaPair("message", errMessage3.get("Message"));
                                                        TeaPair[] teaPairArr11 = new TeaPair[3];
                                                        teaPairArr11[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr11[1] = new TeaPair("requestId", errMessage3.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        try {
                                                            teaPairArr11[2] = new TeaPair("hostId", errMessage3.get("HostId"));
                                                            teaPairArr10[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr11));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr10));
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                        }
                                                    } catch (Exception e9) {
                                                        e = e9;
                                                        str3 = str9;
                                                        str6 = str10;
                                                        str5 = str11;
                                                        if (Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        client = this;
                                                        putObjectRequest2 = putObjectRequest;
                                                        i2 = i;
                                                        str6 = str6;
                                                        str5 = str5;
                                                        str4 = str3;
                                                        teaRequest3 = teaRequest2;
                                                        jCurrentTimeMillis = j;
                                                        str7 = str;
                                                        str8 = str2;
                                                    }
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    teaRequest2 = teaRequest;
                                                    str3 = str9;
                                                    str6 = str10;
                                                    str5 = str11;
                                                    if (Tea.isRetryable(e)) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    client = this;
                                                    putObjectRequest2 = putObjectRequest;
                                                    i2 = i;
                                                    str6 = str6;
                                                    str5 = str5;
                                                    str4 = str3;
                                                    teaRequest3 = teaRequest2;
                                                    jCurrentTimeMillis = j;
                                                    str7 = str;
                                                    str8 = str2;
                                                }
                                            } catch (Exception e11) {
                                                e = e11;
                                                str3 = str9;
                                                str6 = str10;
                                                str5 = str11;
                                                teaRequest2 = teaRequest;
                                            }
                                        } catch (Exception e12) {
                                            e = e12;
                                            str3 = str9;
                                            str6 = str10;
                                            str5 = str11;
                                            teaRequest2 = teaRequest;
                                            if (Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            client = this;
                                            putObjectRequest2 = putObjectRequest;
                                            i2 = i;
                                            str6 = str6;
                                            str5 = str5;
                                            str4 = str3;
                                            teaRequest3 = teaRequest2;
                                            jCurrentTimeMillis = j;
                                            str7 = str;
                                            str8 = str2;
                                        }
                                    } catch (Exception e13) {
                                        e = e13;
                                        str5 = str5;
                                        str3 = str9;
                                        str6 = str10;
                                    }
                                } catch (Exception e14) {
                                    e = e14;
                                    str5 = str5;
                                    str6 = str6;
                                    str3 = str9;
                                }
                            } catch (Exception e15) {
                                e = e15;
                                str3 = str4;
                                str5 = str5;
                                str6 = str6;
                                teaRequest2 = teaRequest;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                client = this;
                                putObjectRequest2 = putObjectRequest;
                                i2 = i;
                                str6 = str6;
                                str5 = str5;
                                str4 = str3;
                                teaRequest3 = teaRequest2;
                                jCurrentTimeMillis = j;
                                str7 = str;
                                str8 = str2;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            teaRequest = teaRequest3;
                            i = i3;
                            str3 = str4;
                            teaRequest2 = teaRequest;
                            if (Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            client = this;
                            putObjectRequest2 = putObjectRequest;
                            i2 = i;
                            str6 = str6;
                            str5 = str5;
                            str4 = str3;
                            teaRequest3 = teaRequest2;
                            jCurrentTimeMillis = j;
                            str7 = str;
                            str8 = str2;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str2 = str8;
                    }
                } catch (Exception e18) {
                    e = e18;
                    str = str7;
                    str2 = str8;
                    teaRequest = teaRequest3;
                    i = i3;
                    str3 = str4;
                    str5 = str5;
                    str6 = str6;
                    teaRequest2 = teaRequest;
                    if (Tea.isRetryable(e)) {
                        throw new RuntimeException(e);
                    }
                    client = this;
                    putObjectRequest2 = putObjectRequest;
                    i2 = i;
                    str6 = str6;
                    str5 = str5;
                    str4 = str3;
                    teaRequest3 = teaRequest2;
                    jCurrentTimeMillis = j;
                    str7 = str;
                    str8 = str2;
                }
            } catch (Exception e19) {
                e = e19;
                j = jCurrentTimeMillis;
            }
            if (Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            client = this;
            putObjectRequest2 = putObjectRequest;
            i2 = i;
            str6 = str6;
            str5 = str5;
            str4 = str3;
            teaRequest3 = teaRequest2;
            jCurrentTimeMillis = j;
            str7 = str;
            str8 = str2;
        }
        throw new TeaUnretryableException(teaRequest3);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x033b A[LOOP:0: B:3:0x0144->B:123:0x033b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:173:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public PutObjectAclResponse putObjectAcl(PutObjectAclRequest putObjectAclRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        boolean z2;
        int i;
        int backoffTime;
        TeaModel.validateParams(putObjectAclRequest, "request");
        String str = "retry";
        boolean z3 = false;
        boolean z4 = true;
        int i2 = 2;
        int i3 = 3;
        String str2 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i4 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str), i4, jCurrentTimeMillis)) {
            if (i4 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str2), i4)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i5 = i4 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    StringBuilder sb = new StringBuilder();
                    try {
                        sb.append(WVNativeCallbackUtil.SEPERATER);
                        sb.append(putObjectAclRequest.objectName);
                        sb.append("?acl");
                        teaRequest2.pathname = sb.toString();
                        Map[] mapArr = new Map[i2];
                        TeaPair[] teaPairArr = new TeaPair[i3];
                        str = str;
                        try {
                            i5 = i5;
                            try {
                                str2 = str2;
                                try {
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    try {
                                        try {
                                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putObjectAclRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                            try {
                                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                try {
                                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                    try {
                                                        mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                        try {
                                                            mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(putObjectAclRequest.header));
                                                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                            if (!Common.empty(securityToken)) {
                                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                            }
                                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putObjectAclRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                            try {
                                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    try {
                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                Map[] mapArr2 = new Map[1];
                                                                                try {
                                                                                    mapArr2[0] = teaResponseDoAction.headers;
                                                                                    return (PutObjectAclResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr2), new PutObjectAclResponse());
                                                                                } catch (Exception e) {
                                                                                    e = e;
                                                                                    z = false;
                                                                                    teaRequest = teaRequest2;
                                                                                    i = 2;
                                                                                    z2 = true;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e2) {
                                                                                e = e2;
                                                                                z2 = true;
                                                                                teaRequest = teaRequest2;
                                                                                i = 2;
                                                                                z = false;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i4 = i5;
                                                                                i2 = i;
                                                                                z4 = z2;
                                                                                z3 = z;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                i3 = 3;
                                                                            }
                                                                        }
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                        teaRequest = teaRequest2;
                                                                        i = 2;
                                                                        z2 = true;
                                                                        z = false;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                }
                                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                                try {
                                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                                    try {
                                                                        teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                        z = false;
                                                                        try {
                                                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                            z2 = true;
                                                                            try {
                                                                                teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                                i = 2;
                                                                                try {
                                                                                    teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                    teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                                                } catch (Exception e4) {
                                                                                    e = e4;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e5) {
                                                                                e = e5;
                                                                                i = 2;
                                                                            }
                                                                        } catch (Exception e6) {
                                                                            e = e6;
                                                                            i = 2;
                                                                            z2 = true;
                                                                            teaRequest = teaRequest2;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i4 = i5;
                                                                            i2 = i;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str = str;
                                                                            str2 = str2;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            i3 = 3;
                                                                        }
                                                                    } catch (Exception e7) {
                                                                        e = e7;
                                                                        z2 = true;
                                                                        i = 2;
                                                                        z = false;
                                                                        teaRequest = teaRequest2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                } catch (Exception e8) {
                                                                    e = e8;
                                                                    z = false;
                                                                }
                                                            } catch (Exception e9) {
                                                                e = e9;
                                                                i = 2;
                                                                z2 = true;
                                                            }
                                                        } catch (Exception e10) {
                                                            e = e10;
                                                            z2 = true;
                                                        }
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        z = false;
                                                    }
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    i = 2;
                                                    z2 = true;
                                                    z = false;
                                                    if (Tea.isRetryable(e)) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    i4 = i5;
                                                    i2 = i;
                                                    z4 = z2;
                                                    z3 = z;
                                                    str = str;
                                                    str2 = str2;
                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                    i3 = 3;
                                                }
                                            } catch (Exception e13) {
                                                e = e13;
                                                z2 = true;
                                            }
                                        } catch (Exception e14) {
                                            e = e14;
                                            z = false;
                                        }
                                    } catch (Exception e15) {
                                        e = e15;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i = 2;
                                    z2 = true;
                                    z = false;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i4 = i5;
                                    i2 = i;
                                    z4 = z2;
                                    z3 = z;
                                    str = str;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i3 = 3;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i = 2;
                                z2 = true;
                                z = false;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i4 = i5;
                                i2 = i;
                                z4 = z2;
                                z3 = z;
                                str = str;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i3 = 3;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            i5 = i5;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        z2 = true;
                        z = false;
                        i = i2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i4 = i5;
                        i2 = i;
                        z4 = z2;
                        z3 = z;
                        str = str;
                        str2 = str2;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                        i3 = 3;
                    }
                } catch (Exception e20) {
                    e = e20;
                    z2 = true;
                    z = z3;
                }
            } catch (Exception e21) {
                e = e21;
                z = z3;
                z2 = z4;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x030d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0301 A[LOOP:0: B:3:0x0142->B:83:0x0301, LOOP_END] */
    public PutObjectTaggingResponse putObjectTagging(PutObjectTaggingRequest putObjectTaggingRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(putObjectTaggingRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(putObjectTaggingRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER + putObjectTaggingRequest.objectName + "?tagging";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putObjectTaggingRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putObjectTaggingRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (PutObjectTaggingResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new PutObjectTaggingResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x033b A[LOOP:0: B:3:0x0144->B:123:0x033b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:173:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public PutSymlinkResponse putSymlink(PutSymlinkRequest putSymlinkRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        boolean z2;
        int i;
        int backoffTime;
        TeaModel.validateParams(putSymlinkRequest, "request");
        String str = "retry";
        boolean z3 = false;
        boolean z4 = true;
        int i2 = 2;
        int i3 = 3;
        String str2 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i4 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str), i4, jCurrentTimeMillis)) {
            if (i4 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str2), i4)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i5 = i4 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    StringBuilder sb = new StringBuilder();
                    try {
                        sb.append(WVNativeCallbackUtil.SEPERATER);
                        sb.append(putSymlinkRequest.objectName);
                        sb.append("?symlink");
                        teaRequest2.pathname = sb.toString();
                        Map[] mapArr = new Map[i2];
                        TeaPair[] teaPairArr = new TeaPair[i3];
                        str = str;
                        try {
                            i5 = i5;
                            try {
                                str2 = str2;
                                try {
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    try {
                                        try {
                                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(putSymlinkRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                            try {
                                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                try {
                                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                    try {
                                                        mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                        try {
                                                            mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(putSymlinkRequest.header));
                                                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                            if (!Common.empty(securityToken)) {
                                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                            }
                                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, putSymlinkRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                            try {
                                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    try {
                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                Map[] mapArr2 = new Map[1];
                                                                                try {
                                                                                    mapArr2[0] = teaResponseDoAction.headers;
                                                                                    return (PutSymlinkResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr2), new PutSymlinkResponse());
                                                                                } catch (Exception e) {
                                                                                    e = e;
                                                                                    z = false;
                                                                                    teaRequest = teaRequest2;
                                                                                    i = 2;
                                                                                    z2 = true;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e2) {
                                                                                e = e2;
                                                                                z2 = true;
                                                                                teaRequest = teaRequest2;
                                                                                i = 2;
                                                                                z = false;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i4 = i5;
                                                                                i2 = i;
                                                                                z4 = z2;
                                                                                z3 = z;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                i3 = 3;
                                                                            }
                                                                        }
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                        teaRequest = teaRequest2;
                                                                        i = 2;
                                                                        z2 = true;
                                                                        z = false;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                }
                                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                                try {
                                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                                    try {
                                                                        teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                                        TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                        z = false;
                                                                        try {
                                                                            teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                            z2 = true;
                                                                            try {
                                                                                teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                                i = 2;
                                                                                try {
                                                                                    teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                    teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                                                } catch (Exception e4) {
                                                                                    e = e4;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e5) {
                                                                                e = e5;
                                                                                i = 2;
                                                                            }
                                                                        } catch (Exception e6) {
                                                                            e = e6;
                                                                            i = 2;
                                                                            z2 = true;
                                                                            teaRequest = teaRequest2;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i4 = i5;
                                                                            i2 = i;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str = str;
                                                                            str2 = str2;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            i3 = 3;
                                                                        }
                                                                    } catch (Exception e7) {
                                                                        e = e7;
                                                                        z2 = true;
                                                                        i = 2;
                                                                        z = false;
                                                                        teaRequest = teaRequest2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                } catch (Exception e8) {
                                                                    e = e8;
                                                                    z = false;
                                                                }
                                                            } catch (Exception e9) {
                                                                e = e9;
                                                                i = 2;
                                                                z2 = true;
                                                            }
                                                        } catch (Exception e10) {
                                                            e = e10;
                                                            z2 = true;
                                                        }
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        z = false;
                                                    }
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    i = 2;
                                                    z2 = true;
                                                    z = false;
                                                    if (Tea.isRetryable(e)) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    i4 = i5;
                                                    i2 = i;
                                                    z4 = z2;
                                                    z3 = z;
                                                    str = str;
                                                    str2 = str2;
                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                    i3 = 3;
                                                }
                                            } catch (Exception e13) {
                                                e = e13;
                                                z2 = true;
                                            }
                                        } catch (Exception e14) {
                                            e = e14;
                                            z = false;
                                        }
                                    } catch (Exception e15) {
                                        e = e15;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i = 2;
                                    z2 = true;
                                    z = false;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i4 = i5;
                                    i2 = i;
                                    z4 = z2;
                                    z3 = z;
                                    str = str;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i3 = 3;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i = 2;
                                z2 = true;
                                z = false;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i4 = i5;
                                i2 = i;
                                z4 = z2;
                                z3 = z;
                                str = str;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i3 = 3;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            i5 = i5;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        z2 = true;
                        z = false;
                        i = i2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i4 = i5;
                        i2 = i;
                        z4 = z2;
                        z3 = z;
                        str = str;
                        str2 = str2;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                        i3 = 3;
                    }
                } catch (Exception e20) {
                    e = e20;
                    z2 = true;
                    z = z3;
                }
            } catch (Exception e21) {
                e = e21;
                z = z3;
                z2 = z4;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02ce A[LOOP:0: B:3:0x0142->B:53:0x02ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x02d8 A[SYNTHETIC] */
    public RestoreObjectResponse restoreObject(RestoreObjectRequest restoreObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        String str;
        int i;
        char c;
        int backoffTime;
        TeaModel.validateParams(restoreObjectRequest, "request");
        String str2 = "retry";
        char c2 = 2;
        int i2 = 3;
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str2), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get("backoff"), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                teaRequest2.protocol = this._protocol;
                teaRequest2.method = "POST";
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(restoreObjectRequest.objectName);
                    sb.append("?restore");
                    teaRequest2.pathname = sb.toString();
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    str = str2;
                    try {
                        i = i4;
                        try {
                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(restoreObjectRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                            teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                            try {
                                teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                if (!Common.empty(securityToken)) {
                                    teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                }
                                teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, restoreObjectRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                try {
                                    TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                    if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                        try {
                                            if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                return (RestoreObjectResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new RestoreObjectResponse());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            teaRequest = teaRequest2;
                                            c = 2;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            str2 = str;
                                            i2 = 3;
                                        }
                                    }
                                    Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                    TeaPair[] teaPairArr2 = new TeaPair[3];
                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                    teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                    teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                    c = 2;
                                    try {
                                        teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                        teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                        throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        teaRequest = teaRequest2;
                                        if (!Tea.isRetryable(e)) {
                                            throw new RuntimeException(e);
                                        }
                                        i3 = i;
                                        c2 = c;
                                        str2 = str;
                                        i2 = 3;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    c = 2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c = 2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = i4;
                        c = 2;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i3 = i;
                        c2 = c;
                        str2 = str;
                        i2 = 3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                }
            } catch (Exception e8) {
                e = e8;
                str = str2;
                i = i4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x0319 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x030d A[LOOP:0: B:3:0x0142->B:83:0x030d, LOOP_END] */
    public SelectObjectResponse selectObject(SelectObjectRequest selectObjectRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String str;
        int i;
        String str2;
        char c;
        int backoffTime;
        TeaModel.validateParams(selectObjectRequest, "request");
        String str3 = "retry";
        boolean z2 = false;
        char c2 = 2;
        int i2 = 3;
        String str4 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i3 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str3), i3, jCurrentTimeMillis)) {
            if (i3 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str4), i3)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i4 = i3 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                String xml = com.aliyun.teaxml.Client.toXML(TeaModel.buildMap(selectObjectRequest.body));
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = "POST";
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER + selectObjectRequest.objectName + "";
                    TeaPair[] teaPairArr = new TeaPair[i2];
                    try {
                        str = str3;
                        try {
                            i = i4;
                            try {
                                str2 = str4;
                                try {
                                    try {
                                        teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(selectObjectRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                        teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                        try {
                                            teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                            teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                            if (!Common.empty(securityToken)) {
                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            }
                                            teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(selectObjectRequest.filter));
                                            teaRequest2.body = Tea.toReadable(xml);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, selectObjectRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                            try {
                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                    try {
                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                            Map[] mapArr = new Map[1];
                                                            try {
                                                                mapArr[0] = teaResponseDoAction.headers;
                                                                return (SelectObjectResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr), new SelectObjectResponse());
                                                            } catch (Exception e) {
                                                                e = e;
                                                                z = false;
                                                                teaRequest = teaRequest2;
                                                                c = 2;
                                                                if (!Tea.isRetryable(e)) {
                                                                    throw new RuntimeException(e);
                                                                }
                                                                i3 = i;
                                                                c2 = c;
                                                                z2 = z;
                                                                str3 = str;
                                                                str4 = str2;
                                                                i2 = 3;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        teaRequest = teaRequest2;
                                                        c = 2;
                                                        z = false;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                }
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                try {
                                                    teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                    teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                    TeaPair[] teaPairArr3 = new TeaPair[3];
                                                    z = false;
                                                    try {
                                                        teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        c = 2;
                                                        try {
                                                            teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                            teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            teaRequest = teaRequest2;
                                                            if (!Tea.isRetryable(e)) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            i3 = i;
                                                            c2 = c;
                                                            z2 = z;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i2 = 3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        c = 2;
                                                        teaRequest = teaRequest2;
                                                        if (!Tea.isRetryable(e)) {
                                                            throw new RuntimeException(e);
                                                        }
                                                        i3 = i;
                                                        c2 = c;
                                                        z2 = z;
                                                        str3 = str;
                                                        str4 = str2;
                                                        i2 = 3;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                c = 2;
                                                z = false;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            c = 2;
                                            z = false;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            i3 = i;
                                            c2 = c;
                                            z2 = z;
                                            str3 = str;
                                            str4 = str2;
                                            i2 = 3;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        z = false;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str2 = str4;
                                c = 2;
                                z = false;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i3 = i;
                                c2 = c;
                                z2 = z;
                                str3 = str;
                                str4 = str2;
                                i2 = 3;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            i = i4;
                            str2 = str4;
                            c = 2;
                            z = false;
                            if (!Tea.isRetryable(e)) {
                                throw new RuntimeException(e);
                            }
                            i3 = i;
                            c2 = c;
                            z2 = z;
                            str3 = str;
                            str4 = str2;
                            i2 = 3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str3;
                    }
                } catch (Exception e13) {
                    e = e13;
                    z = z2;
                    str = str3;
                    i = i4;
                    str2 = str4;
                }
            } catch (Exception e14) {
                e = e14;
                z = z2;
                str = str3;
                i = i4;
                str2 = str4;
                c = c2;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }

    public void setUserAgent(String str) throws Exception {
        this._userAgent = str;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x03e4 A[LOOP:0: B:3:0x014e->B:108:0x03e4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x03f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x033d A[Catch: Exception -> 0x03b4, TRY_LEAVE, TryCatch #5 {Exception -> 0x03b4, blocks: (B:58:0x02cd, B:72:0x0323, B:61:0x02da, B:64:0x02df, B:67:0x02ee, B:68:0x031c, B:74:0x033d), top: B:122:0x0247 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest, RuntimeOptions runtimeOptions) throws Exception {
        long j;
        String str;
        String str2;
        TeaRequest teaRequest;
        int i;
        String str3;
        TeaRequest teaRequest2;
        TeaResponse teaResponseDoAction;
        int backoffTime;
        Client client = this;
        String str4 = "content-md5";
        TeaModel.validateParams(uploadPartRequest, "request");
        String str5 = "retry";
        String str6 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, client._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, client._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, client._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, client._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, client._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, client._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, client._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, client._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, client._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest3 = null;
        int i2 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str5), i2, jCurrentTimeMillis)) {
            if (i2 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str6), i2)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i3 = i2 + 1;
            try {
                teaRequest2 = new TeaRequest();
                HashMap map = new HashMap();
                String accessKeyId = client._credential.getAccessKeyId();
                String accessKeySecret = client._credential.getAccessKeySecret();
                String securityToken = client._credential.getSecurityToken();
                j = jCurrentTimeMillis;
                try {
                    teaRequest2.protocol = client._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    teaRequest2.pathname = WVNativeCallbackUtil.SEPERATER + uploadPartRequest.objectName + "";
                    TeaPair[] teaPairArr = new TeaPair[3];
                    str = str5;
                    str2 = str6;
                    try {
                        String str7 = uploadPartRequest.bucketName;
                        i = i3;
                        try {
                            String str8 = client._regionId;
                            teaRequest = teaRequest3;
                            try {
                                str3 = client._endpoint;
                                String str9 = str4;
                                try {
                                    teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(str7, str8, str3, client._hostModel));
                                    teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                    try {
                                        teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                        teaRequest2.headers = TeaConverter.buildMap(teaPairArr);
                                        if (Common.empty(securityToken)) {
                                            teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(uploadPartRequest.filter));
                                            teaRequest2.body = com.aliyun.ossutil.Client.inject(uploadPartRequest.body, map);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, uploadPartRequest.bucketName, accessKeyId, accessKeySecret, client._signatureVersion, client._addtionalHeaders));
                                            teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                            if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                str3 = str9;
                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                TeaPair[] teaPairArr2 = new TeaPair[3];
                                                teaPairArr2[0] = new TeaPair("code", errMessage.get("Code"));
                                                teaPairArr2[1] = new TeaPair("message", errMessage.get("Message"));
                                                TeaPair[] teaPairArr3 = new TeaPair[3];
                                                teaPairArr3[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                teaPairArr3[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                teaPairArr3[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                teaPairArr2[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr3));
                                                throw new TeaException(TeaConverter.buildMap(teaPairArr2));
                                            }
                                            str3 = str9;
                                            Map<String, Object> errMessage2 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                            TeaPair[] teaPairArr4 = new TeaPair[3];
                                            teaPairArr4[0] = new TeaPair("code", errMessage2.get("Code"));
                                            teaPairArr4[1] = new TeaPair("message", errMessage2.get("Message"));
                                            TeaPair[] teaPairArr5 = new TeaPair[3];
                                            teaPairArr5[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                            teaPairArr5[1] = new TeaPair("requestId", errMessage2.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                            teaPairArr5[2] = new TeaPair("hostId", errMessage2.get("HostId"));
                                            teaPairArr4[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr5));
                                            throw new TeaException(TeaConverter.buildMap(teaPairArr4));
                                        }
                                        try {
                                            teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                            teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(uploadPartRequest.filter));
                                            teaRequest2.body = com.aliyun.ossutil.Client.inject(uploadPartRequest.body, map);
                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, uploadPartRequest.bucketName, accessKeyId, accessKeySecret, client._signatureVersion, client._addtionalHeaders));
                                            try {
                                                teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                try {
                                                    if (Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode)) || Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                        str3 = str9;
                                                        Map<String, Object> errMessage3 = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                        TeaPair[] teaPairArr6 = new TeaPair[3];
                                                        teaPairArr6[0] = new TeaPair("code", errMessage3.get("Code"));
                                                        teaPairArr6[1] = new TeaPair("message", errMessage3.get("Message"));
                                                        TeaPair[] teaPairArr7 = new TeaPair[3];
                                                        teaPairArr7[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                        teaPairArr7[1] = new TeaPair("requestId", errMessage3.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                        try {
                                                            teaPairArr7[2] = new TeaPair("hostId", errMessage3.get("HostId"));
                                                            teaPairArr6[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr7));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr6));
                                                        } catch (Exception e) {
                                                            e = e;
                                                        }
                                                    } else {
                                                        if (!client._isEnableCrc.booleanValue() || Common.equalString((String) map.get("crc"), teaResponseDoAction.headers.get(OSSHeaders.OSS_HASH_CRC64_ECMA))) {
                                                            if (client._isEnableMD5.booleanValue()) {
                                                                str3 = str9;
                                                                if (!Common.equalString((String) map.get(TKDownloadReason.KSAD_TK_MD5), teaResponseDoAction.headers.get(str3))) {
                                                                    char c = 2;
                                                                    try {
                                                                        TeaPair[] teaPairArr8 = new TeaPair[2];
                                                                        teaPairArr8[0] = new TeaPair("code", "MD5NotMatched");
                                                                        c = 2;
                                                                        TeaPair[] teaPairArr9 = new TeaPair[2];
                                                                        teaPairArr9[0] = new TeaPair("clientMD5", map.get(TKDownloadReason.KSAD_TK_MD5));
                                                                        teaPairArr9[1] = new TeaPair("serverMD5", teaResponseDoAction.headers.get(str3));
                                                                        teaPairArr8[1] = new TeaPair("data", TeaConverter.buildMap(teaPairArr9));
                                                                        throw new TeaException(TeaConverter.buildMap(teaPairArr8));
                                                                    } catch (Exception e2) {
                                                                        e = e2;
                                                                    }
                                                                }
                                                            }
                                                            return (UploadPartResponse) TeaModel.toModel(TeaConverter.merge(String.class, (Map<String, ?>[]) new Map[]{teaResponseDoAction.headers}), new UploadPartResponse());
                                                        }
                                                        char c2 = 2;
                                                        try {
                                                            TeaPair[] teaPairArr10 = new TeaPair[2];
                                                            teaPairArr10[0] = new TeaPair("code", "CrcNotMatched");
                                                            c2 = 2;
                                                            TeaPair[] teaPairArr11 = new TeaPair[2];
                                                            teaPairArr11[0] = new TeaPair("clientCrc", map.get("crc"));
                                                            teaPairArr11[1] = new TeaPair("serverCrc", teaResponseDoAction.headers.get(OSSHeaders.OSS_HASH_CRC64_ECMA));
                                                            teaPairArr10[1] = new TeaPair("data", TeaConverter.buildMap(teaPairArr11));
                                                            throw new TeaException(TeaConverter.buildMap(teaPairArr10));
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            str3 = str9;
                                                        }
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                str3 = str9;
                                                if (!Tea.isRetryable(e)) {
                                                    throw new RuntimeException(e);
                                                }
                                                client = this;
                                                i2 = i;
                                                str4 = str3;
                                                teaRequest3 = teaRequest2;
                                                jCurrentTimeMillis = j;
                                                str5 = str;
                                                str6 = str2;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            teaRequest2 = teaRequest;
                                            str3 = str9;
                                            if (!Tea.isRetryable(e)) {
                                                throw new RuntimeException(e);
                                            }
                                            client = this;
                                            i2 = i;
                                            str4 = str3;
                                            teaRequest3 = teaRequest2;
                                            jCurrentTimeMillis = j;
                                            str5 = str;
                                            str6 = str2;
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        str3 = str9;
                                        teaRequest2 = teaRequest;
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    str3 = str9;
                                    teaRequest2 = teaRequest;
                                    if (!Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    client = this;
                                    i2 = i;
                                    str4 = str3;
                                    teaRequest3 = teaRequest2;
                                    jCurrentTimeMillis = j;
                                    str5 = str;
                                    str6 = str2;
                                }
                            } catch (Exception e9) {
                                e = e9;
                                str3 = str4;
                                teaRequest2 = teaRequest;
                                if (!Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                client = this;
                                i2 = i;
                                str4 = str3;
                                teaRequest3 = teaRequest2;
                                jCurrentTimeMillis = j;
                                str5 = str;
                                str6 = str2;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            teaRequest = teaRequest3;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        teaRequest = teaRequest3;
                        i = i3;
                        str3 = str4;
                        teaRequest2 = teaRequest;
                        if (!Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        client = this;
                        i2 = i;
                        str4 = str3;
                        teaRequest3 = teaRequest2;
                        jCurrentTimeMillis = j;
                        str5 = str;
                        str6 = str2;
                    }
                } catch (Exception e12) {
                    e = e12;
                    str = str5;
                    str2 = str6;
                    teaRequest = teaRequest3;
                    i = i3;
                    str3 = str4;
                    teaRequest2 = teaRequest;
                    if (!Tea.isRetryable(e)) {
                        throw new RuntimeException(e);
                    }
                    client = this;
                    i2 = i;
                    str4 = str3;
                    teaRequest3 = teaRequest2;
                    jCurrentTimeMillis = j;
                    str5 = str;
                    str6 = str2;
                }
            } catch (Exception e13) {
                e = e13;
                j = jCurrentTimeMillis;
            }
            if (!Tea.isRetryable(e)) {
                throw new RuntimeException(e);
            }
            client = this;
            i2 = i;
            str4 = str3;
            teaRequest3 = teaRequest2;
            jCurrentTimeMillis = j;
            str5 = str;
            str6 = str2;
        }
        throw new TeaUnretryableException(teaRequest3);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x0374 A[LOOP:0: B:3:0x0144->B:134:0x0374, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:188:0x0382 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UploadPartCopyResponse uploadPartCopy(UploadPartCopyRequest uploadPartCopyRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        boolean z2;
        int i;
        int backoffTime;
        TeaModel.validateParams(uploadPartCopyRequest, "request");
        String str = "retry";
        boolean z3 = false;
        boolean z4 = true;
        int i2 = 2;
        int i3 = 3;
        String str2 = "backoff";
        Map mapBuildMap = TeaConverter.buildMap(new TeaPair("timeouted", "retry"), new TeaPair("readTimeout", Common.defaultNumber(runtimeOptions.readTimeout, this._readTimeout)), new TeaPair("connectTimeout", Common.defaultNumber(runtimeOptions.connectTimeout, this._connectTimeout)), new TeaPair("localAddr", Common.defaultString(runtimeOptions.localAddr, this._localAddr)), new TeaPair("httpProxy", Common.defaultString(runtimeOptions.httpProxy, this._httpProxy)), new TeaPair("httpsProxy", Common.defaultString(runtimeOptions.httpsProxy, this._httpsProxy)), new TeaPair("noProxy", Common.defaultString(runtimeOptions.noProxy, this._noProxy)), new TeaPair("socks5Proxy", Common.defaultString(runtimeOptions.socks5Proxy, this._socks5Proxy)), new TeaPair("socks5NetWork", Common.defaultString(runtimeOptions.socks5NetWork, this._socks5NetWork)), new TeaPair("maxIdleConns", Common.defaultNumber(runtimeOptions.maxIdleConns, this._maxIdleConns)), new TeaPair("retry", TeaConverter.buildMap(new TeaPair("retryable", Boolean.valueOf(runtimeOptions.autoretry)), new TeaPair("maxAttempts", Common.defaultNumber(runtimeOptions.maxAttempts, 3)))), new TeaPair("backoff", TeaConverter.buildMap(new TeaPair(AuthConstant.INI_POLICY, Common.defaultString(runtimeOptions.backoffPolicy, "no")), new TeaPair(TypedValues.CycleType.S_WAVE_PERIOD, Common.defaultNumber(runtimeOptions.backoffPeriod, 1)))), new TeaPair("ignoreSSL", Boolean.valueOf(runtimeOptions.ignoreSSL)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        TeaRequest teaRequest = null;
        int i4 = 0;
        while (Tea.allowRetry((Map) mapBuildMap.get(str), i4, jCurrentTimeMillis)) {
            if (i4 > 0 && (backoffTime = Tea.getBackoffTime(mapBuildMap.get(str2), i4)) > 0) {
                Tea.sleep(backoffTime);
            }
            int i5 = i4 + 1;
            try {
                TeaRequest teaRequest2 = new TeaRequest();
                String accessKeyId = this._credential.getAccessKeyId();
                String accessKeySecret = this._credential.getAccessKeySecret();
                String securityToken = this._credential.getSecurityToken();
                try {
                    teaRequest2.protocol = this._protocol;
                    teaRequest2.method = HttpManager.HTTP_PUT;
                    StringBuilder sb = new StringBuilder();
                    try {
                        sb.append(WVNativeCallbackUtil.SEPERATER);
                        sb.append(uploadPartCopyRequest.objectName);
                        sb.append("");
                        teaRequest2.pathname = sb.toString();
                        Map[] mapArr = new Map[i2];
                        try {
                            TeaPair[] teaPairArr = new TeaPair[i3];
                            str = str;
                            i5 = i5;
                            try {
                                str2 = str2;
                                try {
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    try {
                                        try {
                                            teaPairArr[0] = new TeaPair(c.f, com.aliyun.ossutil.Client.getHost(uploadPartCopyRequest.bucketName, this._regionId, this._endpoint, this._hostModel));
                                            try {
                                                teaPairArr[1] = new TeaPair("date", Common.getDateUTCString());
                                                try {
                                                    teaPairArr[2] = new TeaPair("user-agent", getUserAgent());
                                                    try {
                                                        mapArr[0] = TeaConverter.buildMap(teaPairArr);
                                                        try {
                                                            mapArr[1] = Common.stringifyMapValue(TeaModel.buildMap(uploadPartCopyRequest.header));
                                                            teaRequest2.headers = TeaConverter.merge(String.class, (Map<String, ?>[]) mapArr);
                                                            if (!Common.empty(securityToken)) {
                                                                teaRequest2.headers.put(OSSHeaders.OSS_SECURITY_TOKEN, securityToken);
                                                            }
                                                            teaRequest2.query = Common.stringifyMapValue(TeaModel.buildMap(uploadPartCopyRequest.filter));
                                                            teaRequest2.headers.put("authorization", com.aliyun.ossutil.Client.getSignature(teaRequest2, uploadPartCopyRequest.bucketName, accessKeyId, accessKeySecret, this._signatureVersion, this._addtionalHeaders));
                                                            try {
                                                                TeaResponse teaResponseDoAction = Tea.doAction(teaRequest2, mapBuildMap);
                                                                if (!Common.is4xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                    try {
                                                                        if (!Common.is5xx(Integer.valueOf(teaResponseDoAction.statusCode))) {
                                                                            try {
                                                                                Map[] mapArr2 = new Map[2];
                                                                                try {
                                                                                    TeaPair[] teaPairArr2 = new TeaPair[1];
                                                                                    try {
                                                                                        teaPairArr2[0] = new TeaPair("CopyPartResult", com.aliyun.teaxml.Client.parseXml(Common.readAsString(teaResponseDoAction.body), UploadPartCopyResponse.class).get("CopyPartResult"));
                                                                                        mapArr2[0] = TeaConverter.buildMap(teaPairArr2);
                                                                                        try {
                                                                                            mapArr2[1] = teaResponseDoAction.headers;
                                                                                            return (UploadPartCopyResponse) TeaModel.toModel(TeaConverter.merge(Object.class, (Map<String, ?>[]) mapArr2), new UploadPartCopyResponse());
                                                                                        } catch (Exception e) {
                                                                                            e = e;
                                                                                            z2 = true;
                                                                                            teaRequest = teaRequest2;
                                                                                            i = 2;
                                                                                            z = false;
                                                                                            if (Tea.isRetryable(e)) {
                                                                                                throw new RuntimeException(e);
                                                                                            }
                                                                                            i4 = i5;
                                                                                            i2 = i;
                                                                                            z4 = z2;
                                                                                            z3 = z;
                                                                                            str = str;
                                                                                            str2 = str2;
                                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                            i3 = 3;
                                                                                        }
                                                                                    } catch (Exception e2) {
                                                                                        e = e2;
                                                                                        z = false;
                                                                                        teaRequest = teaRequest2;
                                                                                        i = 2;
                                                                                        z2 = true;
                                                                                        if (Tea.isRetryable(e)) {
                                                                                            throw new RuntimeException(e);
                                                                                        }
                                                                                        i4 = i5;
                                                                                        i2 = i;
                                                                                        z4 = z2;
                                                                                        z3 = z;
                                                                                        str = str;
                                                                                        str2 = str2;
                                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                        i3 = 3;
                                                                                    }
                                                                                } catch (Exception e3) {
                                                                                    e = e3;
                                                                                    z2 = true;
                                                                                }
                                                                            } catch (Exception e4) {
                                                                                e = e4;
                                                                                i = 2;
                                                                                teaRequest = teaRequest2;
                                                                                z2 = true;
                                                                                z = false;
                                                                                if (Tea.isRetryable(e)) {
                                                                                    throw new RuntimeException(e);
                                                                                }
                                                                                i4 = i5;
                                                                                i2 = i;
                                                                                z4 = z2;
                                                                                z3 = z;
                                                                                str = str;
                                                                                str2 = str2;
                                                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                i3 = 3;
                                                                            }
                                                                        }
                                                                    } catch (Exception e5) {
                                                                        e = e5;
                                                                        teaRequest = teaRequest2;
                                                                        i = 2;
                                                                        z2 = true;
                                                                        z = false;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                }
                                                                Map<String, Object> errMessage = com.aliyun.ossutil.Client.getErrMessage(Common.readAsString(teaResponseDoAction.body));
                                                                TeaPair[] teaPairArr3 = new TeaPair[3];
                                                                try {
                                                                    teaPairArr3[0] = new TeaPair("code", errMessage.get("Code"));
                                                                    try {
                                                                        teaPairArr3[1] = new TeaPair("message", errMessage.get("Message"));
                                                                        TeaPair[] teaPairArr4 = new TeaPair[3];
                                                                        z = false;
                                                                        try {
                                                                            teaPairArr4[0] = new TeaPair("httpCode", Integer.valueOf(teaResponseDoAction.statusCode));
                                                                            z2 = true;
                                                                            try {
                                                                                teaPairArr4[1] = new TeaPair("requestId", errMessage.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID));
                                                                                i = 2;
                                                                                try {
                                                                                    teaPairArr4[2] = new TeaPair("hostId", errMessage.get("HostId"));
                                                                                    teaPairArr3[2] = new TeaPair("data", TeaConverter.buildMap(teaPairArr4));
                                                                                    throw new TeaException(TeaConverter.buildMap(teaPairArr3));
                                                                                } catch (Exception e6) {
                                                                                    e = e6;
                                                                                    teaRequest = teaRequest2;
                                                                                    if (Tea.isRetryable(e)) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    i4 = i5;
                                                                                    i2 = i;
                                                                                    z4 = z2;
                                                                                    z3 = z;
                                                                                    str = str;
                                                                                    str2 = str2;
                                                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                                                    i3 = 3;
                                                                                }
                                                                            } catch (Exception e7) {
                                                                                e = e7;
                                                                                i = 2;
                                                                            }
                                                                        } catch (Exception e8) {
                                                                            e = e8;
                                                                            i = 2;
                                                                            z2 = true;
                                                                            teaRequest = teaRequest2;
                                                                            if (Tea.isRetryable(e)) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            i4 = i5;
                                                                            i2 = i;
                                                                            z4 = z2;
                                                                            z3 = z;
                                                                            str = str;
                                                                            str2 = str2;
                                                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                                                            i3 = 3;
                                                                        }
                                                                    } catch (Exception e9) {
                                                                        e = e9;
                                                                        z2 = true;
                                                                        i = 2;
                                                                        z = false;
                                                                        teaRequest = teaRequest2;
                                                                        if (Tea.isRetryable(e)) {
                                                                            throw new RuntimeException(e);
                                                                        }
                                                                        i4 = i5;
                                                                        i2 = i;
                                                                        z4 = z2;
                                                                        z3 = z;
                                                                        str = str;
                                                                        str2 = str2;
                                                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                                                        i3 = 3;
                                                                    }
                                                                } catch (Exception e10) {
                                                                    e = e10;
                                                                    z = false;
                                                                }
                                                            } catch (Exception e11) {
                                                                e = e11;
                                                                i = 2;
                                                                z2 = true;
                                                            }
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                            z2 = true;
                                                        }
                                                    } catch (Exception e13) {
                                                        e = e13;
                                                        z = false;
                                                    }
                                                } catch (Exception e14) {
                                                    e = e14;
                                                    i = 2;
                                                }
                                            } catch (Exception e15) {
                                                e = e15;
                                                z2 = true;
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                            z = false;
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i = 2;
                                    z2 = true;
                                    z = false;
                                    if (Tea.isRetryable(e)) {
                                        throw new RuntimeException(e);
                                    }
                                    i4 = i5;
                                    i2 = i;
                                    z4 = z2;
                                    z3 = z;
                                    str = str;
                                    str2 = str2;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    i3 = 3;
                                }
                            } catch (Exception e19) {
                                e = e19;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i = 2;
                                z2 = true;
                                z = false;
                                if (Tea.isRetryable(e)) {
                                    throw new RuntimeException(e);
                                }
                                i4 = i5;
                                i2 = i;
                                z4 = z2;
                                z3 = z;
                                str = str;
                                str2 = str2;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                i3 = 3;
                            }
                        } catch (Exception e20) {
                            e = e20;
                            str = str;
                            i5 = i5;
                        }
                    } catch (Exception e21) {
                        e = e21;
                        z2 = true;
                        z = false;
                        i = i2;
                        if (Tea.isRetryable(e)) {
                            throw new RuntimeException(e);
                        }
                        i4 = i5;
                        i2 = i;
                        z4 = z2;
                        z3 = z;
                        str = str;
                        str2 = str2;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                        i3 = 3;
                    }
                } catch (Exception e22) {
                    e = e22;
                    z2 = true;
                    z = z3;
                }
            } catch (Exception e23) {
                e = e23;
                z = z3;
                z2 = z4;
            }
        }
        throw new TeaUnretryableException(teaRequest);
    }
}
