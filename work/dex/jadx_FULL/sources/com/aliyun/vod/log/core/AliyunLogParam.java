package com.aliyun.vod.log.core;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AliyunLogParam {
    public static String generatePushParams(Map<String, String> map, String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        return "&t=" + String.valueOf(System.currentTimeMillis()) + "&" + AliyunLogKey.KEY_LOG_LEVEL + "=" + str2 + "&" + AliyunLogKey.KEY_LOG_VERSION + "=1&pd=" + str + "&md=" + str3 + "&sm=" + str4 + "&" + AliyunLogKey.KEY_HOSTNAME + "=" + getHostIp() + "&bi=&ri=" + str5 + "&e=" + String.valueOf(i) + "&args=" + transcodeArgs(map) + "&tt=" + AliyunLogCommon.TERMINAL_TYPE + "&dm=" + AliyunLogCommon.DEVICE_MODEL + "&os=android&" + AliyunLogKey.KEY_OSVERSION + "=" + AliyunLogCommon.OS_VERSION + "&av=" + str7 + "&uuid=" + AliyunLogCommon.UUID + "&" + AliyunLogKey.KEY_DEFINITION + "=&" + AliyunLogKey.KEY_CONNECTION + "=" + str6 + "&" + AliyunLogKey.KEY_USER_AGENT + "=&ui=" + AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE + "&app_id=" + AliyunLogCommon.APPLICATION_ID + "&" + AliyunLogKey.KEY_CDN_IP + "=&r=&" + AliyunLogKey.KEY_APP_NAME + "=" + AliyunLogCommon.APPLICATION_NAME;
    }

    public static String generateRandom() {
        return UUID.randomUUID().toString();
    }

    public static String generateTimestamp() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(date);
    }

    public static String getHostIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException | Exception unused) {
            return null;
        }
    }

    public static String transcodeArgs(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
            sb.deleteCharAt(sb.lastIndexOf("&"));
            try {
                return URLEncoder.encode(sb.toString(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String generateTimestamp(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(date);
    }
}
