package com.alibaba.ariver.commonability.file.jsapi;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.ariver.commonability.core.util.b;
import com.alibaba.ariver.commonability.file.c;
import com.alibaba.ariver.commonability.file.d;
import com.alibaba.ariver.commonability.file.e;
import com.alibaba.ariver.commonability.file.f;
import com.alibaba.ariver.commonability.file.g;
import com.alibaba.ariver.commonability.file.h;
import com.alibaba.ariver.commonability.file.l;
import com.alibaba.ariver.commonability.file.proxy.FolderPickProxy;
import com.alibaba.ariver.commonability.file.proxy.RVFileAbilityProxy;
import com.alibaba.ariver.commonability.file.proxy.a;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FileBridgeExtension implements BridgeExtension, NodeAware<App> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24031a = "https://usr/";
    private static final String b = "https://resource/";
    private static final int c = 10485760;
    private static final String d = "FileBridgeExtension";
    private static String i;
    private Map<String, d> e = new ConcurrentHashMap();
    private e f;
    private String g;
    private String h;

    private static boolean a(JSONObject jSONObject, Context context) {
        try {
            String string = CommonUtils.getString(jSONObject, "tempFilePath");
            if (!TextUtils.isEmpty(string) && string.startsWith("file://")) {
                string = string.replaceAll("file://", "");
            }
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            File file = new File(string);
            if (!file.exists()) {
                return false;
            }
            if (TextUtils.isEmpty(i)) {
                i = context.getFilesDir().getParentFile().getCanonicalPath();
            }
            return !file.getCanonicalPath().startsWith(i);
        } catch (Throwable th) {
            RVLogger.e(d, "limitAccessExternalStorage", th);
            return true;
        }
    }

    private String b(String str) {
        int iLastIndexOf;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(Consts.DOT)) == -1) {
            return null;
        }
        String strSubstring = str.substring(iLastIndexOf + 1);
        RVLogger.d(d, "filePath suffix: " + strSubstring);
        return strSubstring;
    }

    private long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return a(new File(str));
    }

    public static boolean deleteFile(File file, String str) {
        if (file == null || !file.exists()) {
            return false;
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            if (TextUtils.equals(canonicalPath, WVNativeCallbackUtil.SEPERATER)) {
                return false;
            }
            try {
                String absolutePath = file.getAbsolutePath();
                if (TextUtils.equals(absolutePath, WVNativeCallbackUtil.SEPERATER)) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (!absolutePath.startsWith(str) && !canonicalPath.startsWith(str)) {
                            return false;
                        }
                    } catch (Exception e) {
                        RVLogger.e(d, e);
                    }
                }
                return file.delete();
            } catch (Exception e2) {
                RVLogger.e(d, e2);
                return false;
            }
        } catch (Exception e3) {
            RVLogger.e(d, e3);
            return false;
        }
    }

    public static boolean isInAccessExternalPathWhiteList(String str) {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null) {
            return false;
        }
        String config = rVConfigService.getConfig("ta_allow_access_external_storage_white_list", "");
        if (TextUtils.isEmpty(config) || TextUtils.isEmpty(str) || TextUtils.equals(config, "all")) {
            return true;
        }
        if (TextUtils.equals(config, "none")) {
            return false;
        }
        try {
            for (String str2 : config.split(",")) {
                if (str.equals(str2.trim())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            RVLogger.e("ConfigCenter", th);
        }
        return false;
    }

    public static boolean isPermitToDisk(String str) {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null) {
            return true;
        }
        String config = rVConfigService.getConfig("ta_save_to_file_to_disk_black_list", "");
        if (!TextUtils.isEmpty(config) && !TextUtils.isEmpty(str)) {
            if (TextUtils.equals(config, "all")) {
                return false;
            }
            if (TextUtils.equals(config, "none")) {
                return true;
            }
            try {
                for (String str2 : config.split(",")) {
                    if (str.equals(str2.trim())) {
                        return false;
                    }
                }
            } catch (Throwable th) {
                RVLogger.e("ConfigCenter", th);
            }
        }
        return true;
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getFileInfo(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        String strA;
        String strT;
        String string = CommonUtils.getString(jSONObject, "filePath");
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
        }
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String string2 = CommonUtils.getString(jSONObject, "digestAlgorithm");
        if (TextUtils.isEmpty(string2)) {
            string2 = TKDownloadReason.KSAD_TK_MD5;
        }
        if (!TextUtils.equals(TKDownloadReason.KSAD_TK_MD5, string2) && !TextUtils.equals("sha1", string2)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error", (Object) 16);
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "digestAlgorithm 参数只支持 md5 或 sha1");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        try {
            String string3 = CommonUtils.getString(jSONObject, "filePath");
            if (TextUtils.isEmpty(string3)) {
                String string4 = CommonUtils.getString(jSONObject, "apFilePath");
                if (TextUtils.isEmpty(string4)) {
                    strA = "";
                } else {
                    strA = string4.startsWith("https://resource/") ? a(jSONObject, "filePath") : a(apiContext, string4, jSONObject);
                }
            } else if (string3.startsWith("https://resource/")) {
                jSONObject.remove("filePath");
                jSONObject.put("apFilePath", (Object) string3);
                strA = a(jSONObject, "filePath");
            } else {
                strA = a(apiContext, string3, jSONObject);
            }
            if (TextUtils.isEmpty(strA) || !new File(strA).exists()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("error", (Object) 12);
                jSONObject3.put(SendToNativeCallback.KEY_MESSAGE, "文件不存在");
                bridgeCallback.sendJSONResponse(jSONObject3);
                return;
            }
            if (TKDownloadReason.KSAD_TK_MD5.equals(string2)) {
                strT = f.u(strA);
            } else {
                strT = "sha1".equals(string2) ? f.t(strA) : null;
            }
            JSONObject jSONObject4 = new JSONObject();
            if (TextUtils.isEmpty(strT)) {
                jSONObject4.put("error", (Object) 17);
                jSONObject4.put(SendToNativeCallback.KEY_MESSAGE, "计算文件摘要信息错误");
            } else {
                jSONObject4.put("size", Long.valueOf(f.i(strA)));
                jSONObject4.put("digest", (Object) strT);
            }
            bridgeCallback.sendJSONResponse(jSONObject4);
            RVLogger.d(d, "getFileInfo...");
        } catch (Exception e) {
            RVLogger.d(d, "getFileInfo exception" + e.toString());
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getSavedFileInfo(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        String string = CommonUtils.getString(jSONObject, "filePath");
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        String strA = a(jSONObject, "filePath");
        if (TextUtils.isEmpty(strA)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (!strA.contains(a(apiContext).a())) {
            jSONObject2.put("error", (Object) 12);
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "文件不存在");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        long jI = f.i(strA);
        long jY = f.y(strA);
        RVLogger.d(d, "filePath:" + strA + "size : " + jI + ", createTime: " + jY);
        if (jI == 0 || jY == 0) {
            jSONObject2.put("error", (Object) 12);
            bridgeCallback.sendJSONResponse(jSONObject2);
        } else {
            jSONObject2.put("success", (Object) Boolean.TRUE);
            jSONObject2.put("size", (Object) Long.valueOf(jI));
            jSONObject2.put("createTime", (Object) Long.valueOf(jY));
            bridgeCallback.sendJSONResponse(jSONObject2);
        }
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getSavedFileList(@BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        String strA = a(apiContext).a(apiContext.getAppContext());
        RVLogger.d(d, "getSavedFileList..." + strA);
        File file = new File(strA);
        JSONArray jSONArray = new JSONArray();
        if (!file.isDirectory()) {
            jSONObject.put("success", Boolean.TRUE);
            jSONObject.put("fileList", (Object) jSONArray);
            bridgeCallback.sendJSONResponse(jSONObject);
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            jSONObject.put("error", (Object) 12);
            jSONObject.put(SendToNativeCallback.KEY_MESSAGE, "文件不存在");
            bridgeCallback.sendJSONResponse(jSONObject);
            return;
        }
        for (File file2 : fileArrListFiles) {
            String path = file2.getPath();
            String strA2 = a(path, b(path));
            JSONObject jSONObject2 = new JSONObject();
            long jD = f.d(file2);
            long jY = f.y(path);
            jSONObject2.put("size", (Object) Long.valueOf(jD));
            jSONObject2.put("apFilePath", (Object) strA2);
            jSONObject2.put("createTime", (Object) Long.valueOf(jY));
            jSONArray.add(jSONObject2);
        }
        jSONObject.put("success", Boolean.TRUE);
        jSONObject.put("fileList", (Object) jSONArray);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        RVFileAbilityProxy rVFileAbilityProxy = (RVFileAbilityProxy) RVProxy.get(RVFileAbilityProxy.class);
        if (rVFileAbilityProxy == null) {
            return;
        }
        this.h = rVFileAbilityProxy.getUserId();
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void removeSavedFile(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        String string = CommonUtils.getString(jSONObject, "filePath");
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        String strA = a(jSONObject, "filePath");
        if (TextUtils.isEmpty(strA)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (!strA.contains(a(apiContext).a())) {
            jSONObject2.put("error", (Object) 12);
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "文件不存在");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        boolean zD = f.d(strA);
        if (!zD) {
            jSONObject2.put("error", (Object) 15);
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "删除文件失败");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        RVLogger.d(d, "filePath is " + strA + ", result is " + zD);
        jSONObject2.put("success", (Object) Boolean.TRUE);
        bridgeCallback.sendJSONResponse(jSONObject2);
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void saveFile(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback) {
        FolderPickProxy folderPickProxy;
        int i2;
        JSONObject jSONObject2 = new JSONObject();
        boolean z = JSONUtils.getBoolean(jSONObject, "toDisk", false);
        if (z) {
            folderPickProxy = (FolderPickProxy) RVProxy.get(FolderPickProxy.class);
            boolean z2 = folderPickProxy != null ? z : false;
            if (!isPermitToDisk(apiContext.getAppId())) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "not have permission to access external storage"));
                return;
            }
            z = z2;
        } else {
            folderPickProxy = null;
        }
        final String strB = b.a("enableSaveFilePathLimit", true) ? b(jSONObject, "tempFilePath") : a(jSONObject, "tempFilePath");
        if (TextUtils.isEmpty(strB)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (a(jSONObject, apiContext.getAppContext()) && !isInAccessExternalPathWhiteList(apiContext.getAppId())) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "not have permission to access external storage"));
            return;
        }
        if (!z && a(apiContext, strB)) {
            jSONObject2.put("error", (Object) 19);
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "文件存储大小限制为 10M");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        if (!a(strB)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "not have permission to save"));
            return;
        }
        if (z) {
            HashMap<String, String> map = new HashMap<>();
            map.put(FolderPickProxy.STORAGE_PERMISSION, FolderPickProxy.STORAGE_WRITE);
            int iLastIndexOf = strB.lastIndexOf(WVNativeCallbackUtil.SEPERATER);
            final String strSubstring = (iLastIndexOf == -1 || (i2 = iLastIndexOf + 1) >= strB.length()) ? strB : strB.substring(i2);
            if (!TextUtils.isEmpty(strSubstring)) {
                map.put(FolderPickProxy.DISPLAY_FILE_NAME, strSubstring);
            }
            String strL = f.l(strB);
            if ("jpg".equals(strL) || "png".equals(strL) || strB.endsWith("image")) {
                map.put(FolderPickProxy.DISPLAY_ICON_PATH, strB);
            }
            folderPickProxy.setResultListener(new a() { // from class: com.alibaba.ariver.commonability.file.jsapi.FileBridgeExtension.1
                @Override // com.alibaba.ariver.commonability.file.proxy.a
                public void a(final String str) {
                    ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alibaba.ariver.commonability.file.jsapi.FileBridgeExtension.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    String str2 = str;
                                    if (!str2.endsWith(WVNativeCallbackUtil.SEPERATER)) {
                                        str2 = str2 + WVNativeCallbackUtil.SEPERATER;
                                    }
                                    if (f.b(strB, str2 + strSubstring, true)) {
                                        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                                        RVLogger.d(FileBridgeExtension.d, "save file to disk succeed");
                                        return;
                                    }
                                    RVLogger.e(FileBridgeExtension.d, "copy file failed.");
                                } catch (Throwable th) {
                                    RVLogger.e(FileBridgeExtension.d, "copyFile exception", th);
                                }
                            }
                            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, "保存失败"));
                        }
                    });
                }

                @Override // com.alibaba.ariver.commonability.file.proxy.a
                public void a() {
                    RVLogger.d(FileBridgeExtension.d, "folder picker canceled.");
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(21, "用户取消"));
                }

                @Override // com.alibaba.ariver.commonability.file.proxy.a
                public void a(int i3, String str) {
                    RVLogger.e(FileBridgeExtension.d, "folder picker error:" + str);
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(22, str));
                }
            });
            folderPickProxy.start(map);
            return;
        }
        String strA = a(apiContext).a(apiContext.getAppContext(), strB);
        boolean zB = f.b(strB, strA, true);
        String str = d;
        RVLogger.d(str, "saveFile..result:" + zB);
        if (!zB) {
            jSONObject2.put("error", (Object) 13);
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "保存失败");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        String strA2 = a(strA, b(CommonUtils.getString(jSONObject, "apFilePath")));
        RVLogger.d(str, "apFilePath " + strA2 + " savedFilePath " + strA);
        jSONObject2.put("apFilePath", (Object) strA2);
        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject2));
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        if (weakReference.get() == null) {
            return;
        }
        this.g = weakReference.get().getAppId();
    }

    private String b(JSONObject jSONObject, String str) {
        String strB;
        String string = CommonUtils.getString(jSONObject, str);
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
        }
        if (TextUtils.isEmpty(string) || !string.startsWith("https://resource/")) {
            strB = "";
        } else {
            if ("https://resource/".equals(string)) {
                return null;
            }
            strB = com.alibaba.ariver.commonability.file.a.b(string);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
        }
        return strB.startsWith("file://") ? strB.replaceAll("file://", "") : strB;
    }

    private boolean a(String str) {
        File file = new File(str);
        RVFileAbilityProxy rVFileAbilityProxy = (RVFileAbilityProxy) RVProxy.get(RVFileAbilityProxy.class);
        if (rVFileAbilityProxy == null) {
            return false;
        }
        try {
            return rVFileAbilityProxy.hasFolderPermission(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String a(ApiContext apiContext, String str, JSONObject jSONObject) {
        String strA = com.alibaba.ariver.commonability.file.a.a();
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("usr/");
        sb.append(h.a(com.alibaba.ariver.commonability.file.a.a(apiContext) + strA));
        String string = sb.toString();
        CharSequence charSequenceA = a(apiContext).a();
        if (!str.startsWith("https://usr/")) {
            if (str.contains(string) || (!TextUtils.isEmpty(charSequenceA) && str.contains(charSequenceA))) {
                return str;
            }
            return null;
        }
        String strA2 = c.a(apiContext.getAppContext(), string);
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        if (str.length() == 12) {
            return strA2;
        }
        return strA2 + WVNativeCallbackUtil.SEPERATER + str.substring(12);
    }

    private String a(String str, String str2) {
        String strA = com.alibaba.ariver.commonability.file.a.a(str);
        String strM = f.m(str);
        if (!TextUtils.isEmpty(strM)) {
            str2 = strM;
        }
        if (str2 != null && str2.startsWith("image")) {
            return g.a(strA, "image");
        }
        if (str2 != null && str2.startsWith("audio")) {
            return g.a(strA, "audio");
        }
        if (str2 != null && str2.startsWith("video")) {
            return g.a(strA, "video");
        }
        return g.a(strA, "other");
    }

    private String a(JSONObject jSONObject, String str) {
        String string = CommonUtils.getString(jSONObject, str);
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
            if (!TextUtils.isEmpty(string)) {
                string = com.alibaba.ariver.commonability.file.a.c(string);
            }
        }
        if (!TextUtils.isEmpty(string) && string.startsWith("file://")) {
            string = string.replaceAll("file://", "");
        }
        if (TextUtils.isEmpty(string) || !f.e(string)) {
            return null;
        }
        return string;
    }

    private boolean a(ApiContext apiContext, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long jC = c(a(apiContext).a(apiContext.getAppContext()));
        long length = new File(str).length();
        String str2 = d;
        RVLogger.d(str2, "checkFolderSizeLimited appendSize=" + length + ",folderSize=" + jC);
        if (jC + length <= 10485760) {
            return false;
        }
        RVLogger.d(str2, "checkFolderSizeLimited file exceed limited size");
        return true;
    }

    private long a(File file) {
        long length;
        long j = 0;
        if (file == null) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        try {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = a(file2);
                } else {
                    length = file2.length();
                }
                j += length;
            }
        } catch (Throwable th) {
            RVLogger.e(d, "getFolderSize...e = " + th);
        }
        return j;
    }

    private e a(ApiContext apiContext) {
        if (this.f == null) {
            this.f = new e(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), com.alibaba.ariver.commonability.file.a.a(apiContext), this.h);
        }
        return this.f;
    }
}
