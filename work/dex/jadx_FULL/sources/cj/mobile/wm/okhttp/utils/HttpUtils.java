package cj.mobile.wm.okhttp.utils;

import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.OkHttp;
import cj.mobile.wm.okhttp.model.HttpHeaders;
import cj.mobile.wm.okhttp.model.HttpParams;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpUtils {
    public static final String TAG = dexc.dexa("IuuqVujmt");

    public static Request.Builder appendHeaders(Request.Builder builder, HttpHeaders httpHeaders) {
        if (httpHeaders.headersMap.isEmpty()) {
            return builder;
        }
        Headers.Builder builder2 = new Headers.Builder();
        try {
            for (Map.Entry<String, String> entry : httpHeaders.headersMap.entrySet()) {
                builder2.add(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        builder.headers(builder2.build());
        return builder;
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static String createUrlFromParams(String str, Map<String, List<String>> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append((str.indexOf(38) > 0 || str.indexOf(63) > 0) ? dexc.dexa("'") : dexc.dexa("@"));
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    String strEncode = URLEncoder.encode(it.next(), dexc.dexa("VUG.9"));
                    sb.append(entry.getKey());
                    sb.append(dexc.dexa(">"));
                    sb.append(strEncode);
                    sb.append(dexc.dexa("'"));
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static RequestBody generateMultipartRequestBody(HttpParams httpParams, boolean z) {
        if (httpParams.fileParamsMap.isEmpty() && !z) {
            FormBody.Builder builder = new FormBody.Builder();
            for (String str : httpParams.urlParamsMap.keySet()) {
                Iterator<String> it = httpParams.urlParamsMap.get(str).iterator();
                while (it.hasNext()) {
                    builder.addEncoded(str, it.next());
                }
            }
            return builder.build();
        }
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (!httpParams.urlParamsMap.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : httpParams.urlParamsMap.entrySet()) {
                Iterator<String> it2 = entry.getValue().iterator();
                while (it2.hasNext()) {
                    type.addFormDataPart(entry.getKey(), it2.next());
                }
            }
        }
        for (Map.Entry<String, List<HttpParams.FileWrapper>> entry2 : httpParams.fileParamsMap.entrySet()) {
            for (HttpParams.FileWrapper fileWrapper : entry2.getValue()) {
                type.addFormDataPart(entry2.getKey(), fileWrapper.fileName, RequestBody.create(fileWrapper.contentType, fileWrapper.file));
            }
        }
        return type.build();
    }

    public static String getHeaderFileName(Response response) {
        String strHeader = response.header(dexc.dexa("Dpoufou.Ejtqptjujpo"));
        if (strHeader == null) {
            return null;
        }
        String strReplaceAll = strHeader.replaceAll(dexc.dexa("#"), "");
        int iIndexOf = strReplaceAll.indexOf(dexc.dexa("gjmfobnf>"));
        if (iIndexOf != -1) {
            return strReplaceAll.substring(iIndexOf + 9, strReplaceAll.length());
        }
        int iIndexOf2 = strReplaceAll.indexOf(dexc.dexa("gjmfobnf+>"));
        if (iIndexOf2 == -1) {
            return null;
        }
        String strSubstring = strReplaceAll.substring(iIndexOf2 + 10, strReplaceAll.length());
        return strSubstring.startsWith(dexc.dexa("VUG.9((")) ? strSubstring.substring(7, strSubstring.length()) : strSubstring;
    }

    public static String getNetFileName(Response response, String str) {
        String headerFileName = getHeaderFileName(response);
        if (TextUtils.isEmpty(headerFileName)) {
            headerFileName = getUrlFileName(str);
        }
        if (TextUtils.isEmpty(headerFileName)) {
            headerFileName = dexc.dexa("volopxogjmf`") + System.currentTimeMillis();
        }
        try {
            return URLDecoder.decode(headerFileName, dexc.dexa("VUG.9"));
        } catch (UnsupportedEncodingException unused) {
            return headerFileName;
        }
    }

    public static String getUrlFileName(String str) {
        int iIndexOf;
        String[] strArrSplit = str.split(dexc.dexa("0"));
        for (String str2 : strArrSplit) {
            if (str2.contains(dexc.dexa("@")) && (iIndexOf = str2.indexOf(dexc.dexa("@"))) != -1) {
                return str2.substring(0, iIndexOf);
            }
        }
        if (strArrSplit.length > 0) {
            return strArrSplit[strArrSplit.length - 1];
        }
        return null;
    }

    public static int getWindowHeight() {
        try {
            return OkHttp.getInstance().getContext().getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable th) {
            Log.w(dexc.dexa("hfuXjoepxIfjhiu"), dexc.dexa("hfuXjoepxIfjhiu!gbjm!") + th);
            return 0;
        }
    }

    public static int getWindowWidth() {
        try {
            return OkHttp.getInstance().getContext().getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable th) {
            Log.w(TAG, dexc.dexa("hfuXjoepxXjeui!gbjm!") + th);
            return 0;
        }
    }

    public static MediaType guessMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.replace(dexc.dexa("$"), ""));
        return contentTypeFor == null ? HttpParams.MEDIA_TYPE_STREAM : MediaType.parse(contentTypeFor);
    }
}
