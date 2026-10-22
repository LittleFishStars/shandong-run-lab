package com.alibaba.ariver.resource.api.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ImageUtil;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVSnapshotUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24435a = "AriverRes:SnapshotProvider";
    private static final String b = "index.snapshot.html";
    private static final String c = "titleBar.snapshot.json";
    private static final String d = "useSnapshot";

    private static boolean a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_snapshotExpiredDays", "7");
            if (new Date().getTime() - file.lastModified() > Integer.parseInt(configWithProcessCache) * 24 * 60 * 60 * 1000) {
                file.delete();
                RVLogger.d(f24435a, "snapshot file " + str + " expired " + configWithProcessCache + " days and delete success");
                return true;
            }
        } catch (Throwable th) {
            RVLogger.e(f24435a, "deleteFileIfExpired: " + str + "  error: " + th);
        }
        return false;
    }

    private static String b(App app, String str) {
        AppConfigModel appConfigModel;
        if (!TextUtils.isEmpty(app.getAppId()) && !TextUtils.isEmpty(str) && (appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class)) != null && appConfigModel.getPageLaunchParams() != null) {
            for (String str2 : appConfigModel.getPageLaunchParams().keySet()) {
                if (str.equals(str2)) {
                    JSONObject jSONObject = JSONUtils.getJSONObject(appConfigModel.getPageLaunchParams(), str2, null);
                    if (jSONObject == null) {
                        break;
                    }
                    String string = jSONObject.getString(d);
                    RVLogger.d(f24435a, "pageUseSnapshot, pathPath:" + str + " useSnapshot:" + string);
                    return string;
                }
            }
        }
        return "";
    }

    public static boolean deleteSnapshot(App app, String str) {
        if (!isSnapshotEnabled(app)) {
            RVLogger.d(f24435a, "deleteSnapshot, snapshot switch is disabled");
            return true;
        }
        try {
            String strA = a(app, str);
            String strReplace = strA.replace(b, c);
            if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strReplace)) {
                File file = new File(strA);
                File file2 = new File(strReplace);
                if ((file.exists() || file2.exists()) && ((file.exists() && file.delete()) || (file2.exists() && file2.delete()))) {
                    RVLogger.d(f24435a, "deleteSnapshot, success: " + strA);
                }
                return true;
            }
            RVLogger.d(f24435a, "deleteSnapshot, snapshot pagePath is null");
            return true;
        } catch (Throwable th) {
            RVLogger.e(f24435a, "deleteSnapshot exception: ", th);
            return false;
        }
    }

    @Nullable
    public static String getPagePathFromPageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri url = UrlUtils.parseUrl(str);
        if (url == null) {
            return null;
        }
        try {
            String fragment = url.getFragment();
            if (fragment == null) {
                return null;
            }
            int iIndexOf = fragment.indexOf("?");
            return iIndexOf != -1 ? fragment.substring(0, iIndexOf) : fragment;
        } catch (Throwable th) {
            RVLogger.d(f24435a, "getPagePathFromPageUrl error: " + th);
            return "";
        }
    }

    public static void handleSnapshotEvent(Page page) {
        if (page == null || page.isExited() || page.getApp() == null || page.getApp().isExited() || page.getEmbedType() != EmbedType.NO) {
            return;
        }
        if (!isSnapshotEnabled(page.getApp())) {
            RVLogger.e(f24435a, "snapshot switch is disabled");
            return;
        }
        String pageURI = page.getPageURI();
        if (isHomePage(page.getApp(), pageURI)) {
            Render render = page.getRender();
            if (render != null) {
                render.triggerSaveSnapshot();
                return;
            }
            return;
        }
        RVLogger.e(f24435a, "handleSnapshotEvent non first page, pageUrl: " + pageURI);
    }

    public static boolean hitPageLevelWhiteList(String str) {
        JSONArray configJSONArray;
        if (TextUtils.isEmpty(str) || (configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshot2WhiteList")) == null || (!configJSONArray.contains("all") && !configJSONArray.contains(str))) {
            return false;
        }
        RVLogger.d(f24435a, "PageLevel snapshot hit whitelist, appId: " + str);
        return true;
    }

    public static boolean isHomePage(App app, String str) {
        if (app != null && !TextUtils.isEmpty(app.getAppId()) && !TextUtils.isEmpty(str)) {
            String strA = a(app);
            try {
                if (TextUtils.isEmpty(strA)) {
                    return false;
                }
                if (str.contains("index.html#" + strA)) {
                    return true;
                }
            } catch (Exception e) {
                RVLogger.e(f24435a, "isHomePage.. e: " + e);
            }
        }
        return false;
    }

    public static boolean isHomePage2(App app, String str) {
        if (!TextUtils.isEmpty(app.getAppId()) && !TextUtils.isEmpty(str)) {
            String strA = a(app);
            try {
                if (!TextUtils.isEmpty(strA) && str.equals(strA)) {
                    return true;
                }
            } catch (Exception e) {
                RVLogger.e(f24435a, "isHomePage.. e: " + e);
            }
        }
        return false;
    }

    public static boolean isSnapshotEnabled(App app) {
        if (app != null && !app.isExited() && !TextUtils.isEmpty(app.getAppId())) {
            String appId = app.getAppId();
            if (RVProxy.get(ISnapshotProxy.class, true) != null) {
                return ((ISnapshotProxy) RVProxy.get(ISnapshotProxy.class)).isSnapshotEnable(app);
            }
            if ("YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), RVParams.APPX_ROUTE_FRAMEWORK))) {
                JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotWhiteList_appxng");
                if (configJSONArray != null && (configJSONArray.contains("all") || configJSONArray.contains(appId))) {
                    RVLogger.d(f24435a, "ta_snapshotWhiteList_appxng hit, appId: " + appId);
                    return true;
                }
            } else {
                JSONArray configJSONArray2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotWhiteList");
                JSONArray configJSONArray3 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotBlackList");
                if (configJSONArray3 != null && (configJSONArray3.contains("all") || configJSONArray3.contains(appId))) {
                    RVLogger.d(f24435a, "ta_snapshotBlackList hit, appId: " + appId);
                    return false;
                }
                if (configJSONArray2 != null && (configJSONArray2.contains("all") || configJSONArray2.contains(appId))) {
                    RVLogger.d(f24435a, "ta_snapshotWhiteList hit, appId: " + appId);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidSnapshot(String str) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.w(f24435a, "isValidSnapshot...invalid snapshot, string is null");
            return false;
        }
        if (!str.contains("<div id=\"__react-content\">")) {
            RVLogger.w(f24435a, "isValidSnapshot...invalid snapshot, string has no root node");
            return false;
        }
        if (str.contains("<div class=\"a-cp-loading-indicator\" aria-hidden=\"true\">") && str.contains("<div class=\"a-cp-loading-item\"></div>")) {
            RVLogger.w(f24435a, "isValidSnapshot...invalid snapshot, snapshot is loading view");
            return false;
        }
        if (!str.contains("<div id=\"__react-content\"><div class=\"a-page tiny-page\"></div></div>\n")) {
            return true;
        }
        RVLogger.w(f24435a, "isValidSnapshot...invalid snapshot, dom tree no ready");
        return false;
    }

    @Nullable
    public static byte[] loadSnapshotFile(App app, String str) {
        app.getAppId();
        String strA = a(app, getPagePathFromPageUrl(str));
        if (!isSnapshotEnabled(app)) {
            RVLogger.e(f24435a, "snapshot switch is disabled");
            return null;
        }
        if (TextUtils.isEmpty(strA)) {
            RVLogger.e(f24435a, "snapshotFilePath is null");
            return null;
        }
        if (a(strA)) {
            return null;
        }
        try {
            File file = new File(strA);
            if (!file.exists()) {
                RVLogger.e(f24435a, "snapshot file not existed: " + strA);
                return null;
            }
            byte[] file2 = readFile(file);
            if (file2 == null || file2.length <= 100) {
                return null;
            }
            RVLogger.d(f24435a, "snapshot file existed: " + strA);
            return file2;
        } catch (Throwable th) {
            RVLogger.e(f24435a, " loadSnapshotFile error: " + th);
            return null;
        }
    }

    public static String loadTitleBarSnapshot(App app, String str) {
        app.getAppId();
        if (!isHomePage(app, str)) {
            return null;
        }
        String strA = a(app, getPagePathFromPageUrl(str));
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        String strReplace = strA.replace(b, c);
        if (!isSnapshotEnabled(app)) {
            RVLogger.e(f24435a, "titleBar snapshot switch is disabled");
            return null;
        }
        if (TextUtils.isEmpty(strReplace)) {
            RVLogger.e(f24435a, "titleBar snapshotFilePath is null");
            return null;
        }
        if (a(strReplace)) {
            return null;
        }
        try {
            File file = new File(strReplace);
            if (!file.exists()) {
                RVLogger.e(f24435a, "titleBar snapshot file not existed: " + strReplace);
                return null;
            }
            RVLogger.d(f24435a, "titleBar snapshot file existed: " + strReplace);
            byte[] file2 = readFile(file);
            if (file2 == null) {
                return null;
            }
            String str2 = new String(file2, StandardCharsets.UTF_8);
            RVLogger.d(f24435a, "titleBar snapshot file : " + str2);
            return str2;
        } catch (Throwable th) {
            RVLogger.e(f24435a, "titleBar loadSnapshotFile error: " + th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileInputStream] */
    public static byte[] readFile(File file) throws Throwable {
        FileInputStream fileInputStream;
        ?? IsFile = file.isFile();
        ?? r1 = 0;
        try {
            if (IsFile != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            RVLogger.e(f24435a, e);
                        }
                        return byteArray;
                    } catch (IOException e2) {
                        e = e2;
                        RVLogger.e(f24435a, "readFile，error:" + e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                                RVLogger.e(f24435a, e3);
                            }
                        }
                        return null;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (Exception e5) {
                            RVLogger.e(f24435a, e5);
                        }
                    }
                    throw th;
                }
            } else {
                RVLogger.e(f24435a, "readFile failed");
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            r1 = IsFile;
        }
    }

    public static void saveSnapshot(App app, String str, String str2) {
        TitleBar titleBar;
        if (!isSnapshotEnabled(app)) {
            RVLogger.e(f24435a, "saveSnapshot, snapshot switch is disabled");
            return;
        }
        if (!isValidSnapshot(str)) {
            RVLogger.e(f24435a, "saveSnapshot invalid snapshot string");
            return;
        }
        try {
            if (isHomePage2(app, str2) && app.isFirstPage() && app.getActivePage() != null && app.getActivePage().getPageContext() != null && (titleBar = app.getActivePage().getPageContext().getTitleBar()) != null) {
                JSONObject jSONObject = new JSONObject();
                String title = titleBar.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    jSONObject.put(RVParams.LONG_DEFAULT_TITLE, (Object) title);
                }
                String subTitle = titleBar.getSubTitle();
                if (!TextUtils.isEmpty(subTitle)) {
                    jSONObject.put(RVParams.LONG_SUB_TITLE, (Object) subTitle);
                }
                jSONObject.put(RVParams.LONG_TITLE_BAR_COLOR, (Object) Integer.valueOf(titleBar.getTitleColor() | (-16777216)));
                String transparentTitle = titleBar.getTransparentTitle();
                if (!TextUtils.isEmpty(transparentTitle)) {
                    jSONObject.put("transparentTitle", (Object) transparentTitle);
                }
                Bitmap imgTitle = titleBar.getImgTitle();
                if (imgTitle != null) {
                    jSONObject.put(RVParams.LONG_TITLE_IMAGE, (Object) ImageUtil.bitmapToString(imgTitle, "PNG"));
                }
                String string = JSONUtils.toString(jSONObject);
                String strA = a(app, str2);
                if (!TextUtils.isEmpty(strA)) {
                    writeToFile(string, strA.replace(b, c));
                }
            }
        } catch (Throwable th) {
            RVLogger.e(f24435a, "saveSnapshot exception!", th);
        }
        try {
            writeToFile(str, a(app, str2));
        } catch (Throwable th2) {
            RVLogger.e(f24435a, "saveSnapshot exception: ", th2);
        }
    }

    public static void writeToFile(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str2), false);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        RVLogger.d(f24435a, "saveSnapshot success, file: " + str2);
    }

    @Nullable
    private static String a(App app, String str) {
        String absolutePath;
        String str2 = "YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), RVParams.APPX_ROUTE_FRAMEWORK)) ? "appxV2_" : "appxV1_";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(app);
        if (TextUtils.isEmpty(userId)) {
            userId = "000";
        }
        ISnapshotProxy iSnapshotProxy = (ISnapshotProxy) RVProxy.get(ISnapshotProxy.class, true);
        if (iSnapshotProxy != null) {
            absolutePath = iSnapshotProxy.getSnapshotExtDir(app);
        } else {
            absolutePath = RVResourceUtils.getExtDirectory((AppModel) app.getData(AppModel.class), true).getAbsolutePath();
        }
        if (absolutePath == null) {
            absolutePath = RVResourceUtils.getExtDirectory((AppModel) app.getData(AppModel.class), true).getAbsolutePath();
        }
        if (absolutePath == null) {
            return null;
        }
        return new File(absolutePath, "snapshot_" + str2 + str.replace('/', '_') + LoginConstants.UNDER_LINE + userId + LoginConstants.UNDER_LINE + b).getAbsolutePath();
    }

    private static String a(App app) {
        AppConfigModel appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class);
        if (appConfigModel == null || appConfigModel.getPages() == null || appConfigModel.getPages().size() <= 0) {
            return null;
        }
        return appConfigModel.getPages().get(0);
    }
}
