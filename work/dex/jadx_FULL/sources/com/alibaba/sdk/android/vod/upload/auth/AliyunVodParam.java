package com.alibaba.sdk.android.vod.upload.auth;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.sdk.android.vod.upload.model.VodInfo;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.aliyun.auth.common.AliyunVodSignature;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.vod.common.utils.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliyunVodParam {
    public static String generateOpenAPIURL(Map<String, String> map, Map<String, String> map2, String str) {
        return generateURL(AliyunVodHttpCommon.VOD_DOMAIN, "GET", map, map2, str);
    }

    public static Map<String, String> generatePrivateParamtersToReUploadVideo(String str) {
        HashMap map = new HashMap();
        map.put(AliyunVodKey.KEY_VOD_ACTION, AliyunVodHttpCommon.Action.REFRESH_UPLOAD_VIDEO);
        map.put(AliyunVodKey.KEY_VOD_VIDEOID, str);
        return map;
    }

    public static Map<String, String> generatePrivateParamtersToUploadImage(VodInfo vodInfo, String str, String str2, boolean z) {
        HashMap map = new HashMap();
        map.put(AliyunVodKey.KEY_VOD_ACTION, AliyunVodHttpCommon.Action.CREATE_UPLOAD_IMAGE);
        if (z) {
            map.put(AliyunVodKey.KEY_VOD_IMAGETYPE, AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER);
        } else {
            map.put(AliyunVodKey.KEY_VOD_IMAGETYPE, "default");
        }
        map.put(AliyunVodKey.KEY_VOD_IMAGEEXT, "png");
        map.put(AliyunVodKey.KEY_VOD_TITLE, vodInfo.getTitle());
        map.put(AliyunVodKey.KEY_VOD_TAGS, generateTags(vodInfo.getTags()));
        map.put(AliyunVodKey.KEY_VOD_CATEID, String.valueOf(vodInfo.getCateId()));
        if (!StringUtils.isEmpty(vodInfo.getUserData())) {
            map.put(AliyunVodKey.KEY_VOD_DESCRIPTION, vodInfo.getDesc());
        }
        map.put(AliyunVodKey.KEY_VOD_STORAGELOCATION, str);
        if (!StringUtils.isEmpty(vodInfo.getUserData())) {
            map.put(AliyunVodKey.KEY_VOD_USERDATA, vodInfo.getUserData());
        }
        map.put("AppId", str2);
        return map;
    }

    public static Map<String, String> generatePrivateParamtersToUploadVideo(VodInfo vodInfo, boolean z, String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put(AliyunVodKey.KEY_VOD_ACTION, AliyunVodHttpCommon.Action.CREATE_UPLOAD_VIDEO);
        map.put(AliyunVodKey.KEY_VOD_TITLE, vodInfo.getTitle());
        map.put(AliyunVodKey.KEY_VOD_FILENAME, vodInfo.getFileName());
        if (!StringUtils.isEmpty(vodInfo.getFileSize())) {
            map.put(AliyunVodKey.KEY_VOD_FILESIZE, vodInfo.getFileSize());
        }
        if (!StringUtils.isEmpty(vodInfo.getDesc())) {
            map.put(AliyunVodKey.KEY_VOD_DESCRIPTION, vodInfo.getDesc());
        }
        if (!StringUtils.isEmpty(vodInfo.getCoverUrl())) {
            map.put(AliyunVodKey.KEY_VOD_COVERURL, vodInfo.getCoverUrl());
        }
        map.put(AliyunVodKey.KEY_VOD_CATEID, String.valueOf(vodInfo.getCateId()));
        map.put(AliyunVodKey.KEY_VOD_TAGS, generateTags(vodInfo.getTags()));
        map.put(AliyunVodKey.KEY_VOD_STORAGELOCATION, str2);
        if (!StringUtils.isEmpty(vodInfo.getUserData())) {
            map.put(AliyunVodKey.KEY_VOD_USERDATA, vodInfo.getUserData());
        }
        if (TextUtils.isEmpty(str)) {
            map.put(AliyunVodKey.KEY_VOD_TRANSCODEMODE, z ? AliyunVodHttpCommon.COMON_FAST_TRANSCODEMODE : AliyunVodHttpCommon.COMON_NO_TRANSCODEMODE);
        } else {
            map.put(AliyunVodKey.KEY_VOD_TEMPLATEGROUPID, str);
        }
        map.put(AliyunVodKey.KEY_VOD_WORKFLOWLD, str3);
        map.put("AppId", str4);
        return map;
    }

    public static Map<String, String> generatePublicParamters(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put(AliyunVodKey.KEY_VOD_COMMON_FORMAT, "json");
        map.put("Version", AliyunVodHttpCommon.COMMON_API_VERSION);
        map.put(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID, str);
        map.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_METHOD, "HMAC-SHA1");
        map.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_VERSION, "1.0");
        map.put(AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_NONCE, AliyunVodHttpCommon.generateRandom());
        map.put(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID, str3);
        if (str2 != null && str2.length() > 0) {
            map.put(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN, str2);
        }
        return map;
    }

    private static String generateTags(List<String> list) {
        String str = "";
        if (list == null || list.size() <= 0) {
            return "";
        }
        for (int i = 0; i < list.size(); i++) {
            str = str + "," + list.get(i).toString();
        }
        return trimFirstAndLastChar(str, ',');
    }

    private static String generateURL(String str, String str2, Map<String, String> map, Map<String, String> map2, String str3) {
        String cqs = AliyunVodSignature.getCQS(AliyunVodSignature.getAllParams(map, map2));
        System.out.print("CanonicalizedQueryString = " + cqs);
        String str4 = str2 + "&" + AliyunVodSignature.percentEncode(WVNativeCallbackUtil.SEPERATER) + "&" + AliyunVodSignature.percentEncode(cqs);
        System.out.print("StringtoSign = " + str4);
        String strHmacSHA1Signature = AliyunVodSignature.hmacSHA1Signature(str3, str4);
        System.out.print("Signature = " + strHmacSHA1Signature);
        return str + "?" + cqs + "&" + AliyunVodSignature.percentEncode("Signature") + "=" + AliyunVodSignature.percentEncode(strHmacSHA1Signature);
    }

    public static String trimFirstAndLastChar(String str, char c) {
        while (true) {
            str = str.substring(str.indexOf(c) == 0 ? 1 : 0, str.lastIndexOf(c) + 1 == str.length() ? str.lastIndexOf(c) : str.length());
            boolean z = str.indexOf(c) == 0;
            boolean z2 = str.lastIndexOf(c) + 1 == str.length();
            if (!z && !z2) {
                return str;
            }
        }
    }

    public static String generateOpenAPIURL(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        return generateURL(AliyunVodHttpCommon.generateVodDomain(str), "GET", map, map2, str2);
    }
}
