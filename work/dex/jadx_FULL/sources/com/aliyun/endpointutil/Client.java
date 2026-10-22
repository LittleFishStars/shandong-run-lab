package com.aliyun.endpointutil;

import com.aliyun.tea.utils.StringUtils;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client {
    public static String getEndpointRules(String str, String str2, String str3, String str4, String str5) {
        String str6;
        String str7 = "";
        if (StringUtils.isEmpty((CharSequence) str4) || "public".equals(str4)) {
            str6 = "";
        } else {
            str6 = c49.f40900a + str4;
        }
        if (str5 != null) {
            str7 = c49.f40900a + str5;
        }
        if (!"regional".equals(str3)) {
            return String.format("%s%s%s.aliyuncs.com", str, str7, str6);
        }
        if (StringUtils.isEmpty((CharSequence) str2)) {
            throw new RuntimeException("RegionId is empty, please set a valid RegionId");
        }
        return String.format("%s%s%s.%s.aliyuncs.com", str, str7, str6, str2);
    }
}
