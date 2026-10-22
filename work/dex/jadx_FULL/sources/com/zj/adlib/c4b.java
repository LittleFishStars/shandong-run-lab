package com.zj.adlib;

import com.aliyun.vod.log.core.AliyunLogCommon;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.igexin.sdk.PushConsts;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c4b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f40901a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    public static int a(List<LatLng> list) {
        int i = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int iCalculateLineDistance = 0;
        while (i < list.size() - 1) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i);
            if (latLng == null || latLng2 == null) {
                break;
            }
            iCalculateLineDistance = (int) (iCalculateLineDistance + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return iCalculateLineDistance;
    }

    public static void b(int i, String str) throws com.amap.api.col.p0003l.ex {
        if (i != 0) {
            switch (i) {
                case 10000:
                    return;
                case 10001:
                    throw new com.amap.api.col.p0003l.ex("用户key不正确或过期");
                case 10002:
                    throw new com.amap.api.col.p0003l.ex("请求服务不存在");
                case 10003:
                    throw new com.amap.api.col.p0003l.ex("访问已超出日访问量");
                case 10004:
                    throw new com.amap.api.col.p0003l.ex("用户访问过于频繁");
                case 10005:
                    throw new com.amap.api.col.p0003l.ex("用户IP无效");
                case 10006:
                    throw new com.amap.api.col.p0003l.ex("用户域名无效");
                case PushConsts.GET_SDKONLINESTATE /* 10007 */:
                    throw new com.amap.api.col.p0003l.ex("用户签名未通过");
                case PushConsts.GET_SDKSERVICEPID /* 10008 */:
                    throw new com.amap.api.col.p0003l.ex("用户MD5安全码未通过");
                case 10009:
                    throw new com.amap.api.col.p0003l.ex("请求key与绑定平台不符");
                case 10010:
                    throw new com.amap.api.col.p0003l.ex("IP访问超限");
                case 10011:
                    throw new com.amap.api.col.p0003l.ex("服务不支持https请求");
                case 10012:
                    throw new com.amap.api.col.p0003l.ex("权限不足，服务请求被拒绝");
                case 10013:
                    throw new com.amap.api.col.p0003l.ex("开发者删除了key，key被删除后无法正常使用");
                default:
                    switch (i) {
                        case 20000:
                            throw new com.amap.api.col.p0003l.ex("请求参数非法");
                        case 20001:
                            throw new com.amap.api.col.p0003l.ex("缺少必填参数");
                        case 20002:
                            throw new com.amap.api.col.p0003l.ex("请求协议非法");
                        case 20003:
                            throw new com.amap.api.col.p0003l.ex("其他未知错误");
                        default:
                            switch (i) {
                                case 30000:
                                    throw new com.amap.api.col.p0003l.ex("请求服务响应错误");
                                case PushConsts.ALIAS_ERROR_FREQUENCY /* 30001 */:
                                    throw new com.amap.api.col.p0003l.ex("引擎返回数据异常");
                                case PushConsts.ALIAS_OPERATE_PARAM_ERROR /* 30002 */:
                                    throw new com.amap.api.col.p0003l.ex("服务端请求链接超时");
                                case PushConsts.ALIAS_REQUEST_FILTER /* 30003 */:
                                    throw new com.amap.api.col.p0003l.ex("读取服务结果超时");
                                default:
                                    throw new com.amap.api.col.p0003l.ex(str);
                            }
                    }
            }
        }
    }

    public static void c(String str) throws com.amap.api.col.p0003l.ex {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                b(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has("status") && jSONObject.has("infocode")) {
                String string = jSONObject.getString("status");
                int i = jSONObject.getInt("infocode");
                if ("1".equals(string)) {
                    return;
                }
                String string2 = jSONObject.getString(AliyunLogCommon.LogLevel.INFO);
                if ("0".equals(string)) {
                    b(i, string2);
                }
            }
        } catch (JSONException unused) {
            throw new com.amap.api.col.p0003l.ex(AMapException.ERROR_PROTOCOL);
        }
    }
}
