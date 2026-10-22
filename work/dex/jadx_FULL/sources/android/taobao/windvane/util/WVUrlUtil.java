package android.taobao.windvane.util;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@SuppressLint({"DefaultLocale"})
public class WVUrlUtil {
    private static Map<String, String> mimeTypes = new HashMap();

    static {
        for (MimeTypeEnum mimeTypeEnum : MimeTypeEnum.values()) {
            mimeTypes.put(mimeTypeEnum.getSuffix(), mimeTypeEnum.getMimeType());
        }
    }

    public static String force2HttpUrl(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll("^((?i)https:)?//", "http://");
    }

    public static String getMimeType(String str) {
        String str2 = mimeTypes.get(getSuffix(str));
        return str2 == null ? "" : str2;
    }

    public static String getMimeTypeExtra(String str) {
        if (str.contains("??")) {
            str = str.replaceFirst("\\?\\?", "");
        }
        return getMimeType(str);
    }

    public static Map<String, String> getParamMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap map = new HashMap();
        int iIndexOf = str.indexOf("?");
        if (iIndexOf != -1) {
            String strSubstring = str.substring(iIndexOf + 1);
            if (strSubstring.contains("#")) {
                strSubstring = strSubstring.substring(0, strSubstring.indexOf("#"));
            }
            for (String str2 : strSubstring.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length < 2) {
                    map.put(strArrSplit[0], "");
                } else {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        return map;
    }

    private static int getQueryIndex(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf("?", i);
            if (iIndexOf == -1) {
                return -1;
            }
            int i2 = iIndexOf + 1;
            if (i2 >= length || str.charAt(i2) != '?') {
                return iIndexOf;
            }
            i = iIndexOf + 2;
        }
    }

    private static String getSuffix(String str) {
        String path;
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (iLastIndexOf = path.lastIndexOf(Consts.DOT)) == -1) ? "" : path.substring(iLastIndexOf + 1);
    }

    public static boolean isCommonUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://");
    }

    public static boolean isHtml(String str) {
        String path;
        if (!TextUtils.isEmpty(str) && !str.contains("??") && (path = Uri.parse(str).getPath()) != null) {
            if (path.endsWith(Consts.DOT + MimeTypeEnum.HTM.getSuffix())) {
                return true;
            }
            if (path.endsWith(Consts.DOT + MimeTypeEnum.HTML.getSuffix()) || TextUtils.isEmpty(path) || WVNativeCallbackUtil.SEPERATER.equals(path)) {
                return true;
            }
        }
        return false;
    }

    public static String[] parseCombo(String str) {
        String strRemoveQueryParam = removeQueryParam(str);
        int iIndexOf = strRemoveQueryParam.indexOf("??");
        if (-1 == iIndexOf) {
            return null;
        }
        return strRemoveQueryParam.substring(iIndexOf + 2).split("\\,");
    }

    public static String removeHashCode(String str) {
        return (TextUtils.isEmpty(str) || str.indexOf("#") == -1) ? str : str.substring(0, str.indexOf("#"));
    }

    public static String removeQueryParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int queryIndex = getQueryIndex(str);
        if (queryIndex != -1) {
            return str.substring(0, queryIndex);
        }
        return str.indexOf("#") > 0 ? str.substring(0, str.indexOf("#")) : str;
    }

    public static String removeScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strReplace = str.startsWith("http:") ? str.replace("http:", "") : null;
        if (str.startsWith("https:")) {
            strReplace = str.replace("https:", "");
        }
        return TextUtils.isEmpty(strReplace) ? str : strReplace;
    }
}
