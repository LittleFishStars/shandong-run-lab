package com.zj.adlib;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class sh9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44693a = "FileProvider.UriUtil";

    public static Uri a(Context context, Uri uri) {
        try {
            if ("file" == uri.getScheme()) {
                return i(context, new File(uri.getPath()));
            }
        } catch (Throwable unused) {
        }
        return uri;
    }

    public static String b(Context context, Uri uri) {
        String string = "";
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
            }
        } catch (IllegalArgumentException unused) {
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return string;
    }

    public static String c(Context context) {
        return context.getPackageName() + ".provider";
    }

    public static String d(Context context, Uri uri) {
        String fileExtensionFromUrl;
        if ("content" == uri.getScheme()) {
            fileExtensionFromUrl = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
            if (TextUtils.isEmpty(fileExtensionFromUrl)) {
                fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            }
        } else {
            fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            if (TextUtils.isEmpty(fileExtensionFromUrl)) {
                fileExtensionFromUrl = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
            }
        }
        return TextUtils.isEmpty(fileExtensionFromUrl) ? e(jg3.j(context, uri).getName()) : fileExtensionFromUrl;
    }

    public static String e(String fileName) {
        return TextUtils.isEmpty(fileName) ? "" : fileName.substring(fileName.lastIndexOf(Consts.DOT), fileName.length());
    }

    public static String f(String url, String name) {
        return g(url).get(name);
    }

    public static Map<String, String> g(String url) {
        int iIndexOf;
        String[] strArrSplit;
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(url) && (iIndexOf = url.indexOf("?")) > 0 && (strArrSplit = url.substring(iIndexOf + 1).split("&")) != null && strArrSplit.length > 0) {
            for (String str : strArrSplit) {
                if (str != null) {
                    String[] strArrSplit2 = str.split("=");
                    if (strArrSplit2.length >= 2) {
                        map.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                }
            }
        }
        return map;
    }

    public static Uri h(Context context) {
        new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File file = new File(context.getExternalCacheDir(), "/images/$timeStamp");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return i(context, file);
    }

    public static Uri i(Context context, File file) {
        try {
            return FileProvider.getUriForFile(context, yf3.a(context), file);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean j(String link) {
        return k(link, false);
    }

    public static boolean k(String link, boolean isSimpleMode) {
        if (TextUtils.isEmpty(link)) {
            return false;
        }
        if (isSimpleMode) {
            return link.toLowerCase().startsWith("http://") || link.toLowerCase().startsWith("https://");
        }
        return Pattern.compile("^(http://|https://)?((?:[A-Za-z0-9]+-[A-Za-z0-9]+|[A-Za-z0-9]+)\\.)+([A-Za-z]+)[/\\?\\:]?.*$", 2).matcher(link).matches();
    }

    public static String l(Context context, Uri uri) {
        try {
            return TextUtils.equals(uri.getAuthority(), yf3.a(context)) ? new File(uri.getPath().replace("file_path/", "")).getAbsolutePath() : uri.getPath();
        } catch (Throwable unused) {
            return "";
        }
    }
}
