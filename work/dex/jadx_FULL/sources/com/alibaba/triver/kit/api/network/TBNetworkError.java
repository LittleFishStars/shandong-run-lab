package com.alibaba.triver.kit.api.network;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.amap.api.maps.AMapException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBNetworkError {
    private static Map<String, String> sErrMap;

    public static String getErrorMsg(String str) {
        Map<String, String> map = sErrMap;
        if (map == null || map.isEmpty()) {
            initErrCode();
        }
        String str2 = sErrMap.get(str);
        return TextUtils.isEmpty(str2) ? "UNKONW" : str2;
    }

    private static void initErrCode() {
        if (sErrMap == null) {
            HashMap map = new HashMap();
            sErrMap = map;
            map.put("-100", AlibcProtocolConstant.UNKNOWN_ERROR);
            sErrMap.put("-101", "发生异常");
            sErrMap.put("-102", AMapException.ILLEGAL_AMAP_ARGUMENT);
            sErrMap.put("-103", "远程调用失败");
            sErrMap.put("-105", "ACCS自定义帧回调为空");
            sErrMap.put("-108", "获取进程信息错误");
            sErrMap.put("-200", "无网络");
            sErrMap.put("-201", "请求失败");
            sErrMap.put("-202", "请求超时");
            sErrMap.put("-203", "无策略");
            sErrMap.put("-204", "请求被取消");
            sErrMap.put("-205", "请求后台被禁止");
            sErrMap.put("-206", "请求收到的数据长度与Content-Length不匹配");
            sErrMap.put("-300", "Tnet层抛出异常");
            sErrMap.put("-301", "Session不可用");
            sErrMap.put("-302", "鉴权异常");
            sErrMap.put("-303", "自定义帧数据过大");
            sErrMap.put("-304", "Tnet请求失败");
            sErrMap.put("-400", "连接超时");
            sErrMap.put("-401", "Socket超时");
            sErrMap.put("-402", "SSL失败");
            sErrMap.put("-403", "域名未认证");
            sErrMap.put("-404", "IO异常");
            sErrMap.put("-405", "域名不能解析");
            sErrMap.put("-406", "连接异常");
        }
    }
}
