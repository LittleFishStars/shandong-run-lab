package com.aliyun.credentials.http;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.zj.adlib.ze1;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum FormatType {
    XML("application/xml", "text/xml"),
    JSON(ze1.g, "text/json"),
    RAW(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE),
    FORM("application/x-www-form-urlencoded");

    private String[] formats;

    FormatType(String... strArr) {
        this.formats = strArr;
    }

    public static FormatType mapAcceptToFormat(String str) {
        for (FormatType formatType : values()) {
            if (Arrays.asList(formatType.formats).contains(str)) {
                return formatType;
            }
        }
        return RAW;
    }

    public static String mapFormatToAccept(FormatType formatType) {
        return formatType.formats[0];
    }
}
