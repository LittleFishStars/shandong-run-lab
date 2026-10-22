package com.alibaba.triver.kit.api.utils;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.WorkerThread;
import com.acse.ottn.p3;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.model.PluginParamModel;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.model.EntryInfo;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IUserTrackProxy;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.common.base.a;
import com.gyf.immersionbar.b;
import com.zj.adlib.u15;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CommonUtils {
    public static final String CUSTOM_LOTTIE_DIR = "CustomWMLLottie";
    private static final String DEFAULT_ENCODING = "UTF-8";
    public static final String DEFAULT_LOTTIE_DIR = "WMLLottie";
    public static final String FEEDBACK_APP_ID = "3000000002007701";
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private static final int NOT_FOUND = -1;
    private static final String TAG = "TriverKitApi.CommonUtils";

    public static Uri appUrlQuery(Uri uri, String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("&")) == null) {
            return uri;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (!TextUtils.isEmpty(uri.getEncodedQuery())) {
                for (String str2 : uri.getEncodedQuery().split("&")) {
                    String[] strArrSplit2 = str2.split("=");
                    if (strArrSplit2 != null && strArrSplit2.length > 1) {
                        linkedHashMap.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                }
            }
            if (linkedHashMap.containsKey("page")) {
                String strDecode = Uri.decode((String) linkedHashMap.get("page"));
                if (!TextUtils.isEmpty(strDecode)) {
                    String strSubstring = strDecode.substring(0, strDecode.indexOf("?") + 1);
                    Uri uri2 = Uri.parse(strDecode);
                    if ("plugin-private".equals(uri2.getScheme())) {
                        String strDecode2 = Uri.decode(uri2.getQuery());
                        if (!TextUtils.isEmpty(strDecode2)) {
                            for (String str3 : strDecode2.split("&")) {
                                String[] strArrSplit3 = str3.split("=");
                                if (strArrSplit3 != null && strArrSplit3.length > 1) {
                                    linkedHashMap2.put(strArrSplit3[0], strArrSplit3[1]);
                                }
                            }
                        }
                    }
                    splitQuery(strArrSplit, linkedHashMap2);
                    linkedHashMap.put("page", handleParams(strSubstring, linkedHashMap2));
                }
            } else if (linkedHashMap.containsKey("query")) {
                String strDecode3 = Uri.decode((String) linkedHashMap.get("query"));
                if (!TextUtils.isEmpty(strDecode3)) {
                    for (String str4 : strDecode3.split("&")) {
                        String[] strArrSplit4 = str4.split("=");
                        if (strArrSplit4 != null && strArrSplit4.length > 1) {
                            linkedHashMap2.put(strArrSplit4[0], strArrSplit4[1]);
                        }
                    }
                }
                splitQuery(strArrSplit, linkedHashMap2);
                linkedHashMap.put("query", handleParams("", linkedHashMap2));
            } else {
                splitQuery(strArrSplit, linkedHashMap);
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                try {
                    sb.append(encode((String) entry.getKey()));
                    sb.append("=");
                    sb.append(encode(URLDecoder.decode((String) entry.getValue(), "UTF-8")));
                    sb.append("&");
                } catch (Exception unused) {
                    sb.append(encode((String) entry.getKey()));
                    sb.append("=");
                    sb.append(encode((String) entry.getValue()));
                    sb.append("&");
                }
            }
            return uri.buildUpon().encodedQuery(sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "").build();
        } catch (Exception e) {
            RVLogger.e("url parse exception: " + e.getMessage());
            return uri;
        }
    }

    public static String buildFeedBackFromPage(Page page) {
        String string;
        String[] strArrSplit;
        if (page != null) {
            try {
                if (page.getApp() != null && page.getApp().isWindmillApp()) {
                    String startUrl = page.getApp().getStartUrl();
                    return Uri.parse(startUrl).buildUpon().appendQueryParameter("_wml_path", page.getPagePath()).build().toString();
                }
                if (page != null && page.getApp() != null) {
                    string = page.getApp().getStartParams().getString(TRiverConstants.KEY_ORI_URL);
                    strArrSplit = page.getPagePath().split("#");
                    if (strArrSplit != null && strArrSplit.length > 2) {
                        return Uri.parse(string).buildUpon().appendQueryParameter("page", strArrSplit[1]).build().toString();
                    }
                }
            } catch (Exception e) {
                RVLogger.w(TAG, "buildFromPage: ", e);
            }
        } else if (page != null) {
            string = page.getApp().getStartParams().getString(TRiverConstants.KEY_ORI_URL);
            strArrSplit = page.getPagePath().split("#");
            if (strArrSplit != null) {
                return Uri.parse(string).buildUpon().appendQueryParameter("page", strArrSplit[1]).build().toString();
            }
        }
        return null;
    }

    public static boolean closePreloadScheduler() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("closePreloadScheduler");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "closePreloadScheduler error", e);
                }
            }
        }
        return false;
    }

    public static boolean closePreloadSchedulerJob(String str) {
        Map<String, String> configsByGroup;
        if (!TextUtils.isEmpty(str) && (configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config")) != null) {
            String str2 = configsByGroup.get("needClosedPreloadSchedulerJobs");
            if (!TextUtils.isEmpty(str2)) {
                for (String str3 : str2.split(",")) {
                    if (str3.equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean closePreloadSchedulerPoints(PreloadScheduler.PointType pointType) {
        Map<String, String> configsByGroup;
        if (pointType != null && (configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config")) != null) {
            String str = configsByGroup.get("needClosedPreloadSchedulerPoints");
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split(",")) {
                    if (str2.equals(pointType.name())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void commitViewHit(Page page, String str, Pair<String, String>... pairArr) {
        IUserTrackProxy iUserTrackProxy;
        if (page == null || (iUserTrackProxy = (IUserTrackProxy) RVProxy.get(IUserTrackProxy.class)) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("miniapp_id", page.getApp().getAppId());
        map.put("appId", page.getApp().getAppId());
        map.put("currentPagePath", UrlUtils.getHash(page.getPagePath()));
        map.put("SDKVersion", "2.0");
        if (pairArr != null) {
            for (Pair<String, String> pair : pairArr) {
                map.put(pair.first, pair.second);
            }
        }
        iUserTrackProxy.controlHit("Button-" + str, map);
    }

    public static int dip2px(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    @WorkerThread
    public static boolean downloadLottieFavAnimRes(Context context, String str) {
        boolean z;
        try {
            String customFirstFavorAnimResUrl = getCustomFirstFavorAnimResUrl(str);
            if (TextUtils.isEmpty(customFirstFavorAnimResUrl)) {
                customFirstFavorAnimResUrl = getDefaultFirstFavorAnimResUrl();
                z = false;
            } else {
                z = true;
            }
            if (customFirstFavorAnimResUrl != null) {
                RVHttpResponse rVHttpResponseHttpRequest = ((RVTransportService) RVProxy.get(RVTransportService.class)).httpRequest(RVHttpRequest.newBuilder().url(customFirstFavorAnimResUrl).build());
                InputStream resStream = rVHttpResponseHttpRequest.getResStream();
                if (rVHttpResponseHttpRequest.getStatusCode() == 200 && resStream != null) {
                    File localFilePath = FileUtils.getLocalFilePath(context, z ? CUSTOM_LOTTIE_DIR : DEFAULT_LOTTIE_DIR);
                    if (!localFilePath.exists()) {
                        localFilePath.mkdir();
                    }
                    FileUtils.removeFilesInDirectory(localFilePath);
                    String absolutePath = localFilePath.getAbsolutePath();
                    ZipInputStream zipInputStream = new ZipInputStream(resStream);
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!TextUtils.isEmpty(name) && !name.contains("../")) {
                            String strReplaceAll = (absolutePath + File.separator + name).replaceAll("\\*", WVNativeCallbackUtil.SEPERATER);
                            File file = new File(strReplaceAll.substring(0, strReplaceAll.lastIndexOf(47)));
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            if (!new File(strReplaceAll).isDirectory()) {
                                FileOutputStream fileOutputStream = new FileOutputStream(strReplaceAll);
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int i = zipInputStream.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.getFD().sync();
                                fileOutputStream.close();
                            }
                        }
                    }
                    zipInputStream.close();
                    File file2 = new File(absolutePath, md5(customFirstFavorAnimResUrl));
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            RVLogger.e(TAG, "mPreLoadFavAnimRes: ", e);
        }
        return false;
    }

    public static String encode(String str) {
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i;
            while (i2 < length && isAllowed(str.charAt(i2))) {
                i2++;
            }
            if (i2 == length) {
                if (i == 0) {
                    return str;
                }
                sb.append((CharSequence) str, i, length);
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            if (i2 > i) {
                sb.append((CharSequence) str, i, i2);
            }
            i = i2 + 1;
            while (i < length && !isAllowed(str.charAt(i))) {
                i++;
            }
            try {
                byte[] bytes = str.substring(i2, i).getBytes("UTF-8");
                int length2 = bytes.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    sb.append('%');
                    char[] cArr = HEX_DIGITS;
                    sb.append(cArr[(bytes[i3] & 240) >> 4]);
                    sb.append(cArr[bytes[i3] & a.q]);
                }
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return sb == null ? str : sb.toString();
    }

    public static String get(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class).invoke(cls.newInstance(), str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getAppFrameType(App app) {
        JSONObject jSONObject;
        String string = null;
        try {
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (appModel != null && appModel.getExtendInfos() != null) {
                string = appModel.getExtendInfos().getString("frameTempType");
            }
            if (TextUtils.isEmpty(string) && app.getStartParams() != null) {
                string = app.getStartParams().getString(TRiverConstants.KEY_FRAME_TYPE);
            }
            EntryInfo entryInfo = (EntryInfo) app.getData(EntryInfo.class);
            return (!TextUtils.isEmpty(string) || entryInfo == null || (jSONObject = entryInfo.extraInfo) == null) ? string : jSONObject.getJSONObject("extendInfo").getString("frameTempType");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Application getApplicationContext() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    }

    public static HashMap<String, String> getBasicAppMonitorData(App app) {
        AppInfoModel appInfoModel;
        HashMap<String, String> map = new HashMap<>();
        if (app != null) {
            map.put("miniAppId", app.getAppId());
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (appModel != null && (appInfoModel = appModel.getAppInfoModel()) != null) {
                map.put("deployVersion", appInfoModel.getVersion());
                map.put("developerVersion", appInfoModel.getDeveloperVersion());
                TemplateConfigModel templateConfig = appInfoModel.getTemplateConfig();
                if (templateConfig != null) {
                    map.put("templateId", templateConfig.getTemplateId());
                }
                JSONObject extendInfos = appModel.getExtendInfos();
                if (extendInfos != null) {
                    map.put("bizType", String.valueOf(extendInfos.getInteger("bizType")));
                    map.put(TRiverConstants.KEY_SUB_BIZ_TYPE, String.valueOf(extendInfos.getInteger(TRiverConstants.KEY_SUB_BIZ_TYPE)));
                }
            }
        }
        return map;
    }

    public static String getCustomFirstFavorAnimResUrl(String str) {
        String str2;
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.ORANGE_GROUP_WINDMILL_COMMON);
        if (configsByGroup != null && !configsByGroup.isEmpty()) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (str2 = configsByGroup.get(TRiverConstants.ORANGE_KEY_WINDMILL_CUSTOM_FIRST_FAVOR_ANIMATION_RES_APPIDS)) != null) {
                JSONArray array = JSON.parseArray(str2);
                for (int i = 0; i < array.size(); i++) {
                    if (TextUtils.equals(str, array.getString(i))) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                return configsByGroup.get(TRiverConstants.ORANGE_KEY_WINDMILL_CUSTOM_FIRST_FAVOR_ANIMATION_RES_URL);
            }
        }
        return null;
    }

    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursorQuery;
        String[] strArr2 = {"_data"};
        try {
            cursorQuery = context.getContentResolver().query(uri, strArr2, str, strArr, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                if (cursorQuery.moveToFirst()) {
                    return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(strArr2[0]));
                }
                return null;
            } catch (Exception unused) {
                if (cursorQuery == null) {
                    return null;
                }
                cursorQuery.close();
                return null;
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        }
    }

    public static String getDefaultFirstFavorAnimResUrl() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.ORANGE_GROUP_WINDMILL_COMMON);
        if (configsByGroup == null || configsByGroup.isEmpty()) {
            return null;
        }
        return configsByGroup.get(TRiverConstants.ORANGE_KEY_WINDMILL_FIRST_FAVOR_ANIMATION_RES_URL);
    }

    @TargetApi(19)
    public static String getImageAbsolutePath(Context context, Uri uri) {
        Uri uriWithAppendedId;
        Uri uri2 = null;
        if (context != null && uri != null) {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (isExternalStorageDocument(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(u15.f19942b);
                    if (strArrSplit != null && strArrSplit.length >= 2 && "primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + WVNativeCallbackUtil.SEPERATER + strArrSplit[1];
                    }
                } else {
                    if (isDownloadsDocument(uri)) {
                        String documentId = DocumentsContract.getDocumentId(uri);
                        if (TextUtils.isEmpty(documentId) || (uriWithAppendedId = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue())) == null) {
                            return null;
                        }
                        return getDataColumn(context, uriWithAppendedId, null, null);
                    }
                    if (isMediaDocument(uri)) {
                        String documentId2 = DocumentsContract.getDocumentId(uri);
                        if (TextUtils.isEmpty(documentId2)) {
                            return null;
                        }
                        String[] strArrSplit2 = documentId2.split(u15.f19942b);
                        if (strArrSplit2.length < 2) {
                            return null;
                        }
                        String str = strArrSplit2[0];
                        if (TextUtils.isEmpty(str)) {
                            return null;
                        }
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else if ("audio".equals(str)) {
                            uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    return isGooglePhotosUri(uri) ? uri.getLastPathSegment() : getDataColumn(context, uri, null, null);
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
        }
        return null;
    }

    public static String getLottieConfigUrl(String str) {
        String customFirstFavorAnimResUrl = getCustomFirstFavorAnimResUrl(str);
        return TextUtils.isEmpty(customFirstFavorAnimResUrl) ? getDefaultFirstFavorAnimResUrl() : customFirstFavorAnimResUrl;
    }

    public static String getPathFromUri(Context context, Uri uri) {
        if (uri == null || context == null) {
            return null;
        }
        return getImageAbsolutePath(context, uri);
    }

    public static String getPluginIdFromPageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String hash = UrlUtils.getHash(str);
        if (!hash.startsWith(PluginParamModel.PLUGIN_PAGE_PREFIX)) {
            return null;
        }
        String strReplace = hash.replace(PluginParamModel.PLUGIN_PAGE_PREFIX, "");
        return strReplace.substring(0, strReplace.indexOf(WVNativeCallbackUtil.SEPERATER));
    }

    public static String getPluginVersion(String str, com.alibaba.ariver.app.api.Page page) {
        App app;
        AppModel appModel;
        if (page != null && (app = page.getApp()) != null && (appModel = (AppModel) app.getData(AppModel.class)) != null && appModel.getAppInfoModel() != null) {
            ArrayList<PluginModel> arrayList = new ArrayList();
            List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
            if (plugins != null) {
                arrayList.addAll(plugins);
            }
            DynamicPluginInfo dynamicPluginInfo = (DynamicPluginInfo) app.getData(DynamicPluginInfo.class);
            if (dynamicPluginInfo != null && dynamicPluginInfo.getPluginModels() != null) {
                arrayList.addAll(dynamicPluginInfo.getPluginModels());
            }
            for (PluginModel pluginModel : arrayList) {
                if (TextUtils.equals(pluginModel.getAppId(), str)) {
                    return pluginModel.getVersion();
                }
            }
        }
        return null;
    }

    public static int getStatusBarHeight(Context context) {
        int iDip2px = dip2px(context, 25.0f);
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField(b.f6802a).get(cls.newInstance()).toString()));
        } catch (Exception unused) {
            return iDip2px;
        }
    }

    private static String handleParams(String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    sb.append(key);
                    sb.append("=");
                    sb.append(Uri.encode(value, "utf-8"));
                    sb.append("&");
                }
            }
            return Uri.encode(sb.substring(0, sb.length() - 1), "utf-8");
        } catch (Exception e) {
            RVLogger.e("url parse exception: " + e.getMessage());
            return "";
        }
    }

    public static boolean hasFillAppInfo(String str) {
        String lottieConfigUrl = getLottieConfigUrl(str);
        if (!TextUtils.isEmpty(lottieConfigUrl)) {
            try {
                return Uri.parse(lottieConfigUrl).getBooleanQueryParameter("fillAppInfo", false);
            } catch (Exception e) {
                RVLogger.e(TAG, e);
            }
        }
        return false;
    }

    public static boolean hasLottieConfigUrl(String str) {
        return !TextUtils.isEmpty(getLottieConfigUrl(str));
    }

    public static boolean hasShowBtn(String str) {
        String lottieConfigUrl = getLottieConfigUrl(str);
        if (!TextUtils.isEmpty(lottieConfigUrl)) {
            try {
                return Uri.parse(lottieConfigUrl).getBooleanQueryParameter("showBtn", false);
            } catch (Exception e) {
                RVLogger.e(TAG, e);
            }
        }
        return false;
    }

    private static boolean isAllowed(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || "_-.~".indexOf(c) != -1);
    }

    public static boolean isApkDebug() {
        try {
            Application applicationContext = getApplicationContext();
            return (applicationContext == null || (applicationContext.getApplicationInfo().flags & 2) == 0) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isCustomLottieRes(String str) {
        return !TextUtils.isEmpty(getCustomFirstFavorAnimResUrl(str));
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isFeedbackApp(String str) {
        return TextUtils.equals(FEEDBACK_APP_ID, str);
    }

    public static boolean isForbidLYInitJSEngine() {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG);
            if (configsByGroup == null) {
                return false;
            }
            String str = configsByGroup.get("forbidLYInitJSEngine");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return "true".equals(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isLottieResFileExisted(Context context, String str) {
        String str2;
        String customFirstFavorAnimResUrl = getCustomFirstFavorAnimResUrl(str);
        if (TextUtils.isEmpty(customFirstFavorAnimResUrl)) {
            customFirstFavorAnimResUrl = getDefaultFirstFavorAnimResUrl();
            if (TextUtils.isEmpty(customFirstFavorAnimResUrl)) {
                return false;
            }
            str2 = DEFAULT_LOTTIE_DIR;
        } else {
            str2 = CUSTOM_LOTTIE_DIR;
        }
        File localFilePath = FileUtils.getLocalFilePath(context, str2);
        if (!localFilePath.exists()) {
            RVLogger.d(TAG, "isLottieResFileExisted: root not exist");
            return false;
        }
        if (!new File(localFilePath, md5(customFirstFavorAnimResUrl)).exists()) {
            RVLogger.d(TAG, "isLottieResFileExisted: md5 not existtrue");
            return false;
        }
        if (new File(localFilePath, "data.json").exists()) {
            return true;
        }
        RVLogger.d(TAG, "isLottieResFileExisted: data.json not exist");
        return false;
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isMiniAppDebug(App app) {
        if (app == null || app.getStartParams() == null) {
            return false;
        }
        return isMiniAppDebug(app.getStartParams());
    }

    public static String md5(byte[] bArr) {
        try {
            return toHex(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean openShopLoadingSimple() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            return !AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(configsByGroup.get("openShopLoadingSimple"));
        }
        return true;
    }

    public static int parseColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    return Color.parseColor(str);
                } catch (Exception e) {
                    RVLogger.e(TAG, "parseColor", e);
                }
            } catch (Exception unused) {
                return Integer.parseInt(str);
            }
        }
        return 0;
    }

    public static boolean sendFavorChangeEvent(TinyApp tinyApp, boolean z) {
        if (tinyApp == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", (Object) Boolean.valueOf(z));
        jSONObject.put("appId", (Object) tinyApp.getAppId());
        tinyApp.sendGlobalEvent("favorChange", jSONObject);
        return true;
    }

    public static boolean sendShareTarget(TinyApp tinyApp, String str, String str2) {
        if (tinyApp == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("target", (Object) str);
        jSONObject.put("from", (Object) str2);
        tinyApp.sendGlobalEvent("shareTarget", jSONObject);
        return true;
    }

    public static void setExposureTag(TinyApp tinyApp, View view, String str, String str2, Pair<String, String>... pairArr) {
        IUserTrackProxy iUserTrackProxy;
        if (tinyApp == null || (iUserTrackProxy = (IUserTrackProxy) RVProxy.get(IUserTrackProxy.class)) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("miniapp_id", tinyApp.getAppId());
        if (pairArr != null) {
            for (Pair<String, String> pair : pairArr) {
                map.put(pair.first, pair.second);
            }
        }
        iUserTrackProxy.setExposureTag(view, str, str2, map);
    }

    private static void splitQuery(String[] strArr, Map<String, String> map) {
        for (String str : strArr) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit != null && strArrSplit.length > 1) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
    }

    private static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            char[] cArr = HEX_DIGITS;
            sb.append(cArr[(bArr[i] >> 4) & 15]);
            sb.append(cArr[bArr[i] & a.q]);
        }
        return sb.toString();
    }

    public static boolean isMiniAppDebug(Bundle bundle) {
        return bundle != null && bundle.containsKey(AppInfoScene.PARAM_SOURCE) && AliyunLogCommon.LogLevel.DEBUG.equals(bundle.get(AppInfoScene.PARAM_SOURCE));
    }

    public static boolean isApkDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (((Application) context.getApplicationContext()).getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String md5(String str) {
        try {
            return toHex(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Uri appUrlQuery(Uri uri, JSONObject jSONObject) {
        if (jSONObject == null) {
            return uri;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : uri.getQueryParameterNames()) {
            linkedHashMap.put(str, uri.getQueryParameter(str));
        }
        for (String str2 : jSONObject.keySet()) {
            linkedHashMap.put(str2, jSONObject.getString(str2));
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            sb.append(encode((String) entry.getKey()));
            sb.append("=");
            sb.append(encode((String) entry.getValue()));
            sb.append("&");
        }
        return uri.buildUpon().encodedQuery(sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "").build();
    }
}
