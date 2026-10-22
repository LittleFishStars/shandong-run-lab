package com.aliyun.vod.log.report;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.vod.common.utils.DateUtil;
import com.aliyun.vod.log.core.AliyunLogSignature;
import com.aliyun.vod.log.util.UUIDGenerator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AliyunReportParam {
    private static final String DOMAIN_PREFIX = "http://vod.";
    private static final String DOMAIN_REGION = "cn-hangzhou";
    private static final String DOMAIN_SUFFIX = ".aliyuncs.com/";
    static final String UP_ACTION = "Action";
    static final String UP_APPVERSION = "AppVersion";
    static final String UP_AUTHINFO = "AuthInfo";
    static final String UP_AUTHTIMESTAMP = "AuthTimestamp";
    static final String UP_BUSINESSTYPE = "BusinessType";
    static final String UP_CLIENTID = "ClientId";
    static final String UP_DEVICEMODEL = "DeviceModel";
    static final String UP_DONEPARTSCOUNT = "DonePartsCount";
    static final String UP_FILECREATETIME = "FileCreateTime";
    static final String UP_FILEHASH = "FileHash";
    static final String UP_FILENAME = "FileName";
    static final String UP_FILESIZE = "FileSize";
    static final String UP_PARTSIZE = "PartSize";
    static final String UP_SOURCE = "Source";
    static final String UP_TERMINALTYPE = "TerminalType";
    static final String UP_TOTALPART = "TotalPart";
    static final String UP_UPLOADADRESS = "UploadAddress";
    static final String UP_UPLOADID = "UploadId";
    static final String UP_UPLOADPOINT = "UploadPoint";
    static final String UP_UPLOADRATIO = "UploadRatio";
    static final String UP_USERID = "UserId";
    static final String UP_VIDEOID = "VideoId";

    public static final String generateDomainWithRegion(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(DOMAIN_PREFIX);
        if (TextUtils.isEmpty(str)) {
            str = DOMAIN_REGION;
        }
        sb.append(str);
        sb.append(DOMAIN_SUFFIX);
        return sb.toString();
    }

    public static final String generateUploadProgressParams(Map<String, String> map, String str) {
        HashMap map2 = new HashMap();
        map2.put(AliyunVodKey.KEY_VOD_COMMON_FORMAT, "JSON");
        map2.put("Version", "2017-03-14");
        map2.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_METHOD, "HMAC-SHA1");
        map2.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_NONCE, UUIDGenerator.generateRequestID());
        map2.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_VERSION, "1.0");
        map2.put("Timestamp", DateUtil.generateTimestamp());
        String cqs = AliyunLogSignature.getCQS(AliyunLogSignature.getAllParams(map, map2));
        return "?" + cqs + "&" + AliyunLogSignature.percentEncode("Signature") + "=" + AliyunLogSignature.percentEncode(AliyunLogSignature.hmacSHA1Signature(str, "POST&" + AliyunLogSignature.percentEncode(WVNativeCallbackUtil.SEPERATER) + "&" + AliyunLogSignature.percentEncode(cqs)));
    }
}
