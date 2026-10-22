package com.aliyun.tea;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alipay.sdk.m.n.c;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.tea.interceptor.InterceptorChain;
import com.aliyun.tea.interceptor.InterceptorContext;
import com.aliyun.tea.okhttp.ClientHelper;
import com.aliyun.tea.okhttp.OkRequestBuilder;
import com.aliyun.tea.utils.AttributeMap;
import com.aliyun.tea.utils.StringUtils;
import com.google.common.net.b;
import com.zj.adlib.u15;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Credentials;
import okhttp3.Request;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Tea {
    public static boolean allowRetry(Map<String, ?> map, int i, long j) {
        if (i == 0) {
            return true;
        }
        if (map == null) {
            return false;
        }
        Object obj = map.get("retryable");
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            return (map.get("maxAttempts") == null ? 0 : Integer.parseInt(String.valueOf(map.get("maxAttempts")))) >= i;
        }
        return false;
    }

    private static String composeUrl(TeaRequest teaRequest) {
        Map<String, String> map = teaRequest.query;
        String str = teaRequest.headers.get(c.f);
        String str2 = teaRequest.protocol;
        if (str2 == null) {
            str2 = "http";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("://");
        sb.append(str);
        if (teaRequest.port != null) {
            sb.append(u15.f19942b);
            sb.append(teaRequest.port);
        }
        String str3 = teaRequest.pathname;
        if (str3 != null) {
            sb.append(str3);
        }
        if (map != null && map.size() > 0) {
            if (sb.indexOf("?") >= 1) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (value != null) {
                        sb.append(URLEncoder.encode(key, "UTF-8"));
                        sb.append("=");
                        sb.append(URLEncoder.encode(value, "UTF-8"));
                        sb.append("&");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (Exception e) {
                throw new TeaException(e.getMessage(), e);
            }
        }
        return sb.toString();
    }

    public static TeaResponse doAction(TeaRequest teaRequest) {
        return doAction(teaRequest, new HashMap());
    }

    public static int getBackoffTime(Object obj, int i) {
        Map map = (Map) obj;
        int iIntValue = 0;
        return (StringUtils.isEmpty(map.get(AuthConstant.INI_POLICY)) || "no".equals(map.get(AuthConstant.INI_POLICY)) || StringUtils.isEmpty(map.get(TypedValues.CycleType.S_WAVE_PERIOD)) || (iIntValue = Integer.valueOf(String.valueOf(map.get(TypedValues.CycleType.S_WAVE_PERIOD))).intValue()) > 0) ? iIntValue : i;
    }

    public static boolean isRetryable(Exception exc) {
        return exc instanceof TeaRetryableException;
    }

    private static Map<String, String> setProxyAuthorization(Map<String, String> map, Object obj) {
        String userInfo;
        try {
            if (!StringUtils.isEmpty(obj) && (userInfo = new URL(String.valueOf(obj)).getUserInfo()) != null) {
                String[] strArrSplit = userInfo.split(u15.f19942b);
                map.put(b.H, Credentials.basic(strArrSplit[0], strArrSplit[1]));
            }
            return map;
        } catch (Exception e) {
            throw new TeaException(e.getMessage(), e);
        }
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new TeaException(e.getMessage(), e);
        }
    }

    public static InputStream toReadable(String str) {
        try {
            return toReadable(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new TeaException(e.getMessage(), e);
        }
    }

    public static OutputStream toWriteable(int i) {
        try {
            return new ByteArrayOutputStream(i);
        } catch (IllegalArgumentException e) {
            throw new TeaException(e.getMessage(), e);
        }
    }

    public static TeaResponse doAction(TeaRequest teaRequest, Map<String, Object> map) {
        try {
            URL url = new URL(composeUrl(teaRequest));
            return new TeaResponse(ClientHelper.getOkHttpClient(url.getHost(), url.getPort(), map).newCall(new OkRequestBuilder(new Request.Builder()).url(url).header(teaRequest.headers).buildRequest(teaRequest)).execute());
        } catch (Exception e) {
            throw new TeaRetryableException(e);
        }
    }

    public static InputStream toReadable(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    public static OutputStream toWriteable() {
        return new ByteArrayOutputStream();
    }

    public static TeaResponse doAction(TeaRequest teaRequest, Map<String, Object> map, InterceptorChain interceptorChain) {
        if (interceptorChain == null) {
            return doAction(teaRequest, map);
        }
        InterceptorContext interceptorContextModifyRuntimeOptions = interceptorChain.modifyRuntimeOptions(InterceptorContext.create().setRuntimeOptions(map), AttributeMap.empty());
        interceptorContextModifyRuntimeOptions.setTeaRequest(teaRequest);
        InterceptorContext interceptorContextModifyRequest = interceptorChain.modifyRequest(interceptorContextModifyRuntimeOptions, AttributeMap.empty());
        interceptorContextModifyRequest.setTeaResponse(doAction(teaRequest, map));
        return interceptorChain.modifyResponse(interceptorContextModifyRequest, AttributeMap.empty()).teaResponse();
    }
}
