package com.kc.dw.core.taskcenter;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SignUtil {
    private static final String TAG = "SignUtil";
    private static final String appsign = "GlSjz6xbhIJ&KEK*6!pykPBDSe@6wP$M";

    public static String md5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("NoSuchAlgorithmException", e2);
        }
    }

    public static String replaceTimeMacros(String str) {
        return TextUtils.replace(str, new String[]{"__REQTIME__"}, new String[]{String.valueOf(System.currentTimeMillis())}).toString();
    }

    public static String sign(String str) {
        String strReplaceTimeMacros = replaceTimeMacros(str);
        return strReplaceTimeMacros + "&sign=" + md5(sortParams(strReplaceTimeMacros) + appsign);
    }

    private static String sortParams(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("&")) {
            return "";
        }
        try {
            Uri uri = Uri.parse(str);
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            TreeSet<String> treeSet = new TreeSet(new Comparator<String>() { // from class: com.kc.dw.core.taskcenter.SignUtil.1
                @Override // java.util.Comparator
                public int compare(String str2, String str3) {
                    return str2.compareTo(str3);
                }
            });
            treeSet.addAll(queryParameterNames);
            Log.e(TAG, "sortParams: " + treeSet.toString());
            StringBuilder sb = new StringBuilder();
            for (String str2 : treeSet) {
                String queryParameter = uri.getQueryParameter(str2);
                sb.append(str2);
                sb.append("=");
                sb.append(queryParameter);
                sb.append("&");
            }
            return sb.toString().substring(0, sb.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
