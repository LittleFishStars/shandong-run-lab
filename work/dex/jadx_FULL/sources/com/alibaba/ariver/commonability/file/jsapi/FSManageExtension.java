package com.alibaba.ariver.commonability.file.jsapi;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.commonability.file.f;
import com.alibaba.ariver.commonability.file.fs.ConversionPathTool;
import com.alibaba.ariver.commonability.file.fs.a.c.a;
import com.alibaba.ariver.commonability.file.fs.a.d.b;
import com.alibaba.ariver.commonability.file.g;
import com.alibaba.ariver.commonability.file.l;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class FSManageExtension extends SimpleBridgeExtension {
    private static final String ACTION_ACCESS = "access";
    private static final String ACTION_APPEND_FILE = "appendFile";
    private static final String ACTION_COPY_FILE = "copyFile";
    public static final String ACTION_FS_MANAGE = "fsManage";
    private static final String ACTION_GET_FILE_INFO = "getFileInfo";
    private static final String ACTION_GET_SAVED_FILE_LIST = "getSavedFileList";
    private static final String ACTION_MKDIR = "mkdir";
    private static final String ACTION_READ_DIR = "readdir";
    private static final String ACTION_READ_FILE = "readFile";
    private static final String ACTION_REMOVE_SAVED_FILE = "removeSavedFile";
    private static final String ACTION_RENAME = "rename";
    private static final String ACTION_RMDIR = "rmdir";
    private static final String ACTION_SAVE_FILE = "saveFile";
    private static final String ACTION_STAT = "stat";
    private static final String ACTION_UNLINK = "unlink";
    private static final String ACTION_UNZIP = "unzip";
    private static final String ACTION_WRITE_FILE = "writeFile";
    private static final String DATA_TYPE_AF = "ArrayBuffer";
    private static final String ENCODING_BASE64 = "base64";
    private static final String ENCODING_BINARY = "binary";
    private static final String ENCODING_HEX = "hex";
    private static final int ERROR_DENIED = 10024;
    private static final int ERROR_DIR_NOT_EMPTY = 10027;
    private static final int ERROR_EXISTS = 10025;
    private static final int ERROR_IS_DIR = 10023;
    private static final int ERROR_IS_NOT_DIR = 10026;
    private static final int ERROR_NOT_EXISTS = 10022;
    private static final int ERROR_SIZE_OVERFLOW = 10028;
    private static final int ERROR_USER_INVALID = 10021;
    private static final long MAX_DIR_SIZE = 52428800;
    private static final long MAX_FILE_SIZE = 10485760;
    public static final String PATH_PREFIX = "https://usr/";
    public static final String PATH_ROOT = "https://usr";
    public static final int PATH_ROOT_LENGTH = 11;
    private static final String TAG = "FSManageExtension";

    private void access(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "path");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            if (!string.startsWith(g.e)) {
                if (a.a(apiContext, string)) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                    return;
                }
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "文件/目录不存在 " + string));
                return;
            }
            if (g.e.equals(string)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            strUsrPathToLocalPath = com.alibaba.ariver.commonability.file.a.b(string);
            if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
        }
        if (new File(strUsrPathToLocalPath).exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            return;
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "文件/目录不存在 " + string));
    }

    private void appendFile(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) throws Throwable {
        writeFile(apiContext, jSONObject, bridgeCallback, true);
    }

    private static boolean checkEncoding(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList("ascii", ENCODING_BASE64, ENCODING_BINARY, ENCODING_HEX, "ucs2", "ucs-2", "utf16le", "utf-16le", "utf-8", "utf8", "latin1").contains(str);
    }

    private static String convertEncoding(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return (TextUtils.equals(str, "ucs2") || TextUtils.equals(str, "ucs-2") || TextUtils.equals(str, "utf16le") || TextUtils.equals(str, "utf-16le")) ? "UTF-16LE" : str;
    }

    private void copyFile(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        String string = JSONUtils.getString(jSONObject, "srcPath");
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            if (!string.startsWith(g.e)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            } else {
                if (g.e.equals(string)) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                    return;
                }
                strUsrPathToLocalPath = com.alibaba.ariver.commonability.file.a.b(string);
                if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                    return;
                }
            }
        }
        File file = new File(strUsrPathToLocalPath);
        if (!file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "指定的 srcPath 文件不存在 " + string));
            return;
        }
        if (file.isDirectory()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_IS_DIR, "指定的 srcPath 是一个已经存在的目录 " + string));
            return;
        }
        if (!file.canRead()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 srcPath 路径没有读权限 " + string));
            return;
        }
        String string2 = JSONUtils.getString(jSONObject, "destPath");
        if (l.a(string2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath2 = ConversionPathTool.usrPathToLocalPath(string2, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strA = l.a(strUsrPathToLocalPath2, strUsrPathToLocalPath);
        File file2 = new File(strA);
        if (file2.exists()) {
            if (file2.isDirectory()) {
                file2 = new File(strA + WVNativeCallbackUtil.SEPERATER + file.getName());
            } else if (!file2.canWrite()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 destPath 路径没有写权限 " + string2));
                return;
            }
        } else if (!file2.getParentFile().canWrite()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 destPath 路径没有写权限 " + string2));
            return;
        }
        FileLock fileLockLock = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    try {
                        fileLockLock = fileOutputStream.getChannel().lock();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, i);
                            }
                        }
                        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                    } catch (Exception e) {
                        e = e;
                        RVLogger.e(TAG, e);
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e.getMessage()));
                    }
                } catch (Throwable th) {
                    th = th;
                    l.a(fileLockLock);
                    com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
                    com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                l.a(fileLockLock);
                com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
                com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            fileOutputStream = null;
        }
        l.a(fileLockLock);
        com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
        com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
    }

    private void getFileInfo(ApiContext apiContext, Page page, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "filePath");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (string.startsWith(g.e)) {
            jSONObject.remove("filePath");
            jSONObject.put("apFilePath", (Object) string);
        } else if (string.startsWith("https://usr/")) {
            jSONObject.put("filePath", ConversionPathTool.usrPathToLocalPath(string, apiContext));
        }
        apiContext.callBridgeApi(new NativeCallContext.Builder().node(page).name(ACTION_GET_FILE_INFO).params(jSONObject).id(String.valueOf(NativeCallContext.generateUniqueId())).build(), new SendToNativeCallback() { // from class: com.alibaba.ariver.commonability.file.jsapi.FSManageExtension.3
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject2, boolean z) {
                FSManageExtension.normalizeErrorCode(jSONObject2);
                bridgeCallback.sendJSONResponse(jSONObject2);
            }
        }, false);
    }

    private long getFileSize(File file) {
        File[] fileArrListFiles;
        long fileSize = 0;
        if (file == null) {
            return 0L;
        }
        if (file.isFile()) {
            return file.length();
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                fileSize += getFileSize(file2);
            }
        }
        return fileSize;
    }

    private void getSavedFileList(ApiContext apiContext, Page page, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        apiContext.callBridgeApi(new NativeCallContext.Builder().node(page).name(ACTION_GET_SAVED_FILE_LIST).params(jSONObject).id(String.valueOf(NativeCallContext.generateUniqueId())).build(), new SendToNativeCallback() { // from class: com.alibaba.ariver.commonability.file.jsapi.FSManageExtension.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject2, boolean z) {
                JSONArray jSONArray;
                FSManageExtension.normalizeErrorCode(jSONObject2);
                if (JSONUtils.getBoolean(jSONObject2, "success", false) && (jSONArray = JSONUtils.getJSONArray(jSONObject2, "fileList", new JSONArray())) != null && jSONArray.size() != 0) {
                    int size = jSONArray.size();
                    for (int i = 0; i < size; i++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        if (jSONObject3 != null) {
                            jSONObject3.put("filePath", jSONObject3.remove("apFilePath"));
                        }
                    }
                }
                bridgeCallback.sendJSONResponse(jSONObject2);
            }
        }, false);
    }

    public static boolean hasRightForSaveFile(ApiContext apiContext, String str) {
        RVConfigService rVConfigService;
        JSONArray array;
        boolean z = true;
        try {
            File file = new File(str);
            if (apiContext.getAppContext().getFilesDir() == null) {
                return true;
            }
            if (!file.getCanonicalPath().contains(apiContext.getAppContext().getFilesDir().getParentFile().getCanonicalPath()) || (rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class)) == null || (array = JSONUtils.parseArray(rVConfigService.getConfig("ta_saveFile_whiteList", null))) == null || array.isEmpty()) {
                return true;
            }
            try {
                for (Object obj : array) {
                    if ((obj instanceof String) && file.getCanonicalPath().contains((String) obj)) {
                        RVLogger.d(TAG, "file.getCanonicalPath() = " + file.getCanonicalPath() + " contains  whiteList: " + obj);
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                e = e;
                z = false;
            }
        } catch (Exception e2) {
            e = e2;
        }
        RVLogger.e(TAG, e);
        return z;
    }

    private void mkdir(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "dirPath");
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath) || l.a(strUsrPathToLocalPath)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        File file = new File(strUsrPathToLocalPath);
        if (file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_EXISTS, "指定的 dirPath 是一个已经存在的文件/目录 " + string));
            return;
        }
        boolean z = JSONUtils.getBoolean(jSONObject, "recursive", false);
        if (!z) {
            if (!file.getParentFile().exists()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "上级目录不存在 " + string));
                return;
            }
            if (!file.getParentFile().canWrite()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 dirPath 路径没有写权限 " + string));
                return;
            }
        }
        if (z) {
            if (file.mkdirs()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                return;
            } else {
                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                return;
            }
        }
        if (file.mkdir()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void normalizeErrorCode(JSONObject jSONObject) {
        if (jSONObject != null && JSONUtils.contains(jSONObject, "error") && JSONUtils.getInt(jSONObject, "error") == 12) {
            jSONObject.put("error", (Object) 10022);
        }
    }

    private void readDir(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "dirPath");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (!string.startsWith("https://usr/")) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "指定的 dirPath 目录不存在 " + string));
            return;
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        File file = new File(strUsrPathToLocalPath);
        if (!file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "指定的 dirPath 目录不存在 " + string));
            return;
        }
        if (!file.isDirectory()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_IS_NOT_DIR, "dirPath 不是目录 " + string));
            return;
        }
        if (!file.canRead()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 dirPath 路径没有读权限 " + string));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (File file2 : file.listFiles()) {
            jSONArray.add(file2.getName());
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("success", Boolean.TRUE);
        jSONObject2.put("files", (Object) jSONArray);
        bridgeCallback.sendJSONResponse(jSONObject2);
    }

    private void readFile(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) throws Throwable {
        byte[] bArrA;
        String string = JSONUtils.getString(jSONObject, "filePath");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        FileInputStream fileInputStream = null;
        boolean z = false;
        if (!TextUtils.isEmpty(strUsrPathToLocalPath)) {
            bArrA = null;
        } else if (string.startsWith(g.e)) {
            if (g.e.equals(string)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            strUsrPathToLocalPath = com.alibaba.ariver.commonability.file.a.b(string);
            if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            bArrA = null;
        } else {
            if (!a.a(apiContext, string)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "指定的 filePath 文件不存在  " + string));
                return;
            }
            bArrA = a.b(apiContext, string);
            z = true;
        }
        if (!z) {
            File file = new File(strUsrPathToLocalPath);
            if (!file.exists()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "指定的 filePath 文件不存在  " + string));
                return;
            }
            if (file.isDirectory()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_IS_DIR, "指定的 filePath 是一个已经存在的目录 " + string));
                return;
            }
            try {
                if (!file.canRead()) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 filePath 路径没有读权限 " + string));
                    return;
                }
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        bArrA = com.alibaba.ariver.commonability.file.a.a.a((InputStream) fileInputStream2);
                        com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream2);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        RVLogger.e(TAG, e);
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e.getMessage()));
                        com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
            throw th;
        }
        if (bArrA == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        boolean zContains = JSONUtils.contains(jSONObject, "encoding");
        String string2 = JSONUtils.getString(jSONObject, "encoding");
        if (zContains && !checkEncoding(string2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        String string3 = JSONUtils.getString(jSONObject, "dataType");
        if (TextUtils.isEmpty(string2) || TextUtils.equals(string3, DATA_TYPE_AF)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", Boolean.TRUE);
                jSONObject2.put("dataType", DATA_TYPE_AF);
                RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
                if (rVConfigService == null || !"true".equalsIgnoreCase(rVConfigService.getConfig("ta_readFile_enable_callback_arraybuffer", ""))) {
                    jSONObject2.put("data", Base64.encodeToString(bArrA, 2));
                } else {
                    jSONObject2.put("data", (Object) bArrA);
                }
                bridgeCallback.sendJSONResponse(jSONObject2);
                return;
            } catch (Exception e3) {
                RVLogger.e(TAG, e3);
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e3.getMessage()));
                return;
            }
        }
        if (ENCODING_BINARY.equals(string2)) {
            try {
                Object str = new String(bArrA);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("success", Boolean.TRUE);
                jSONObject3.put("data", str);
                bridgeCallback.sendJSONResponse(jSONObject3);
                return;
            } catch (Exception e4) {
                RVLogger.e(TAG, e4);
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e4.getMessage()));
                return;
            }
        }
        if (ENCODING_HEX.equals(string2)) {
            try {
                Object objA = com.alibaba.ariver.commonability.file.fs.a.a.a.a(bArrA);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("success", Boolean.TRUE);
                jSONObject4.put("data", objA);
                bridgeCallback.sendJSONResponse(jSONObject4);
                return;
            } catch (Exception e5) {
                RVLogger.e(TAG, e5);
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e5.getMessage()));
                return;
            }
        }
        if (ENCODING_BASE64.equals(string2)) {
            try {
                Object objEncodeToString = Base64.encodeToString(bArrA, 2);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("success", Boolean.TRUE);
                jSONObject5.put("data", objEncodeToString);
                bridgeCallback.sendJSONResponse(jSONObject5);
                return;
            } catch (Exception e6) {
                RVLogger.e(TAG, e6);
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e6.getMessage()));
                return;
            }
        }
        try {
            Object str2 = new String(bArrA, convertEncoding(string2));
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("success", Boolean.TRUE);
            jSONObject6.put("data", str2);
            bridgeCallback.sendJSONResponse(jSONObject6);
        } catch (Exception e7) {
            RVLogger.e(TAG, e7);
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e7.getMessage()));
        }
    }

    private boolean removeFile(File file, boolean z, String str) {
        File[] fileArrListFiles;
        if (!file.isDirectory()) {
            return l.a(file, str);
        }
        if (z && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (!removeFile(file2, z, str)) {
                    return false;
                }
            }
        }
        return l.a(file, str);
    }

    private void removeSavedFile(ApiContext apiContext, Page page, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "filePath");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (string.startsWith(g.e)) {
            jSONObject.remove("filePath");
            jSONObject.put("apFilePath", (Object) string);
        }
        apiContext.callBridgeApi(new NativeCallContext.Builder().node(page).name(ACTION_REMOVE_SAVED_FILE).params(jSONObject).id(String.valueOf(NativeCallContext.generateUniqueId())).build(), new SendToNativeCallback() { // from class: com.alibaba.ariver.commonability.file.jsapi.FSManageExtension.2
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject2, boolean z) {
                FSManageExtension.normalizeErrorCode(jSONObject2);
                bridgeCallback.sendJSONResponse(jSONObject2);
            }
        }, false);
    }

    private void rename(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "oldPath");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (!string.startsWith("https://usr/")) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的源文件或目标文件没有读写权限"));
            return;
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        File file = new File(strUsrPathToLocalPath);
        if (!file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "源文件不存在 " + string));
            return;
        }
        if (!file.canWrite()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定源文件或目标文件没有写权限 " + string));
            return;
        }
        String string2 = JSONUtils.getString(jSONObject, "newPath");
        if (TextUtils.isEmpty(string2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (!string2.startsWith("https://usr/")) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的源文件或目标文件没有读写权限"));
            return;
        }
        if (l.a(string2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath2 = ConversionPathTool.usrPathToLocalPath(string2, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        File file2 = new File(l.a(strUsrPathToLocalPath2, strUsrPathToLocalPath));
        if (file2.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_EXISTS, "指定的 newPath 是一个已经存在的文件/目录 " + string2));
            return;
        }
        if (file2.getParentFile().canWrite()) {
            if (file.renameTo(file2)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                return;
            } else {
                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                return;
            }
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "目标文件路径没有写权限 " + string2));
    }

    private void rmdir(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        File[] fileArrListFiles;
        String string = JSONUtils.getString(jSONObject, "dirPath");
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        File file = new File(strUsrPathToLocalPath);
        if (!file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "目录不存在 " + string));
            return;
        }
        if (!file.isDirectory()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_IS_NOT_DIR, "指定的 dirPath 不是目录 " + string));
            return;
        }
        if (!file.canWrite()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 dirPath 路径没有写权限 " + string));
            return;
        }
        boolean z = JSONUtils.getBoolean(jSONObject, "recursive", false);
        if (!z && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DIR_NOT_EMPTY, "目录不为空"));
        } else if (removeFile(file, z, ConversionPathTool.usrPathToLocalPath("https://usr", apiContext))) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }

    private void saveFile(ApiContext apiContext, Page page, JSONObject jSONObject, BridgeCallback bridgeCallback) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        String string = JSONUtils.getString(jSONObject, "tempFilePath");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String string2 = JSONUtils.getString(jSONObject, "filePath");
        if (TextUtils.isEmpty(string2)) {
            if (string.startsWith(g.e)) {
                jSONObject.remove("tempFilePath");
                jSONObject.put("apFilePath", (Object) string);
            }
            saveFileToCache(apiContext, page, jSONObject, bridgeCallback);
            return;
        }
        if (string.startsWith("file://")) {
            string = string.replaceAll("file://", "");
        }
        if (string.startsWith(g.e)) {
            if (g.e.equals(string)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            string = com.alibaba.ariver.commonability.file.a.b(string);
            if (TextUtils.isEmpty(string)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
        }
        File file = new File(string);
        if (!file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "指定的 tempFilePath 找不到文件"));
            return;
        }
        if (!hasRightForSaveFile(apiContext, string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "无权操作 " + string));
            return;
        }
        if (!string2.startsWith("https://usr/")) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的路径没有写权限"));
            return;
        }
        if (l.a(string2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string2, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strA = l.a(strUsrPathToLocalPath, string);
        File file2 = new File(strA);
        if (file2.exists()) {
            if (file2.isDirectory()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_IS_DIR, "指定的 filePath 是一个已经存在的目录 " + string2));
                return;
            }
            if (!file2.canWrite()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 filePath 路径没有写权限 " + string2));
                return;
            }
        } else if (!file2.getParentFile().exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "上级目录不存在 " + string2));
            return;
        }
        long length = file.length();
        if (length > 10485760) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_SIZE_OVERFLOW, "单个文件超限"));
            return;
        }
        if ((getFileSize(new File(ConversionPathTool.usrPathToLocalPath("https://usr", apiContext))) + length) - file2.length() > 52428800) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_SIZE_OVERFLOW, "文件夹超限"));
            return;
        }
        FileLock fileLockLock = null;
        try {
            fileInputStream = new FileInputStream(string);
            try {
                fileOutputStream = new FileOutputStream(strA);
                try {
                    try {
                        fileLockLock = fileOutputStream.getChannel().lock();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, i);
                            }
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("savedFilePath", (Object) ConversionPathTool.localPathToUsrPath(strA, apiContext));
                        bridgeCallback.sendJSONResponse(jSONObject2);
                    } catch (Exception e) {
                        e = e;
                        RVLogger.e(TAG, e);
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e.getMessage()));
                    }
                } catch (Throwable th) {
                    th = th;
                    l.a(fileLockLock);
                    com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
                    com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                l.a(fileLockLock);
                com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
                com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            fileOutputStream = null;
        }
        l.a(fileLockLock);
        com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
        com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
    }

    private void saveFileToCache(ApiContext apiContext, Page page, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        apiContext.callBridgeApi(new NativeCallContext.Builder().node(page).name(ACTION_SAVE_FILE).params(jSONObject).id(String.valueOf(NativeCallContext.generateUniqueId())).build(), new SendToNativeCallback() { // from class: com.alibaba.ariver.commonability.file.jsapi.FSManageExtension.4
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject2, boolean z) {
                FSManageExtension.normalizeErrorCode(jSONObject2);
                String string = JSONUtils.getString(jSONObject2, "apFilePath");
                if (TextUtils.isEmpty(string)) {
                    bridgeCallback.sendJSONResponse(jSONObject2);
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("success", (Object) Boolean.TRUE);
                jSONObject3.put("savedFilePath", (Object) string);
                bridgeCallback.sendJSONResponse(jSONObject3);
            }
        }, false);
    }

    private void stat(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "path");
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            if (!string.startsWith(g.e)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            } else {
                if (g.e.equals(string)) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                    return;
                }
                strUsrPathToLocalPath = com.alibaba.ariver.commonability.file.a.b(string);
                if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                    return;
                }
            }
        }
        File file = new File(strUsrPathToLocalPath);
        if (!file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "文件不存在 " + string));
            return;
        }
        if (!file.canRead()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 path 路径没有读权限 " + string));
            return;
        }
        boolean z = JSONUtils.getBoolean(jSONObject, "recursive", false);
        JSONArray jSONArray = new JSONArray();
        stat(jSONArray, file, file, z);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("success", (Object) Boolean.TRUE);
        if (z && file.isDirectory()) {
            jSONObject2.put("stats", (Object) jSONArray);
        } else if (jSONArray.size() > 0) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(0);
            jSONObject3.remove("path");
            jSONObject2.put("stats", (Object) jSONObject3);
        }
        bridgeCallback.sendJSONResponse(jSONObject2);
    }

    private void unlink(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "filePath");
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            strUsrPathToLocalPath = com.alibaba.ariver.commonability.file.a.c(string);
            if (!TextUtils.isEmpty(strUsrPathToLocalPath) && strUsrPathToLocalPath.startsWith("file://")) {
                strUsrPathToLocalPath = strUsrPathToLocalPath.replaceAll("file://", "");
            }
        }
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        File file = new File(strUsrPathToLocalPath);
        if (!file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "文件不存在 " + string));
            return;
        }
        if (file.isDirectory()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_IS_DIR, "传入的 filePath 是一个目录 " + string));
            return;
        }
        if (file.canWrite()) {
            if (TextUtils.isEmpty(ConversionPathTool.usrPathToLocalPath(string, apiContext)) ? f.a(file) : l.a(file, ConversionPathTool.usrPathToLocalPath("https://usr", apiContext))) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                return;
            } else {
                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                return;
            }
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 path 路径没有写权限 " + string));
    }

    private void unzip(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "zipFilePath");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath) && string.startsWith(g.e)) {
            if (g.e.equals(string)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            strUsrPathToLocalPath = com.alibaba.ariver.commonability.file.a.b(string);
            if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
        }
        File file = new File(strUsrPathToLocalPath);
        if (!file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "源文件不存在 " + string));
            return;
        }
        if (file.isDirectory()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_IS_DIR, "源文件不存在是一个目录 " + string));
            return;
        }
        if (!file.canRead()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "源文件没有读权限 " + string));
            return;
        }
        String string2 = JSONUtils.getString(jSONObject, "targetPath");
        if (TextUtils.isEmpty(string2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (!string2.startsWith("https://usr")) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的目标文件路径没有写权限"));
            return;
        }
        if (l.a(string2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath2 = ConversionPathTool.usrPathToLocalPath(string2, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        File file2 = new File(strUsrPathToLocalPath2);
        if (!file2.getParentFile().exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "目标文件路径的上层目录不存在 " + string2));
            return;
        }
        if (file2.exists()) {
            if (!file2.canWrite()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定目标文件路径没有写权限 " + string2));
                return;
            }
        } else if (!file2.getParentFile().canWrite()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定目标文件路径没有写权限 " + string2));
            return;
        }
        if (file.length() > 10485760) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_SIZE_OVERFLOW, "单个文件超限"));
            return;
        }
        long fileSize = getFileSize(new File(ConversionPathTool.usrPathToLocalPath("https://usr", apiContext)));
        if (file.length() + fileSize > 52428800) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_SIZE_OVERFLOW, "文件夹超限"));
            return;
        }
        try {
            b bVarB = b.b(file.getPath());
            if (!bVarB.b()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            if (bVarB.e()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, "不允许..路径"));
                return;
            }
            if (bVarB.c() <= 10485760 && bVarB.d() <= 10485760) {
                if (fileSize + bVarB.d() > 52428800) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_SIZE_OVERFLOW, "文件夹超限"));
                    return;
                } else if (com.alibaba.ariver.commonability.file.fs.a.d.a.a(strUsrPathToLocalPath, strUsrPathToLocalPath2)) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                    return;
                } else {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                    return;
                }
            }
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_SIZE_OVERFLOW, "单个文件超限"));
        } catch (Exception e) {
            RVLogger.e(TAG, e);
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e.getMessage()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private void writeFile(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback, boolean z) throws Throwable {
        byte[] bArrDecode;
        FileOutputStream fileOutputStream;
        String string = JSONUtils.getString(jSONObject, "filePath");
        if (TextUtils.isEmpty(string) || !JSONUtils.contains(jSONObject, "data")) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String strUsrPathToLocalPath = ConversionPathTool.usrPathToLocalPath(string, apiContext);
        if (TextUtils.isEmpty(strUsrPathToLocalPath)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        File file = new File(l.a(strUsrPathToLocalPath, string));
        if (z && !file.exists()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10022, "指定的 filePath 文件不存在 " + string));
            return;
        }
        if (file.isDirectory()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_IS_DIR, "指定的 filePath 是一个已经存在的目录 " + string));
            return;
        }
        if (z) {
            if (!file.canWrite()) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 filePath 路径没有写权限 " + string));
                return;
            }
        } else if (!file.getParentFile().canWrite()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_DENIED, "指定的 filePath 路径没有写权限 " + string));
            return;
        }
        if (!JSONUtils.contains(jSONObject, "data")) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        boolean zContains = JSONUtils.contains(jSONObject, "encoding");
        String string2 = JSONUtils.getString(jSONObject, "encoding", "utf8");
        if (zContains && !checkEncoding(string2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (TextUtils.equals(JSONUtils.getString(jSONObject, "dataType"), DATA_TYPE_AF)) {
            try {
                bArrDecode = Base64.decode(JSONUtils.getString(jSONObject, "data"), 0);
            } catch (Exception e) {
                RVLogger.e(TAG, e);
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
        } else if (ENCODING_BINARY.equals(string2)) {
            try {
                bArrDecode = JSONUtils.getString(jSONObject, "data").getBytes();
            } catch (Exception e2) {
                RVLogger.e(TAG, e2);
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
        } else if (ENCODING_HEX.equals(string2)) {
            bArrDecode = com.alibaba.ariver.commonability.file.fs.a.a.a.a(JSONUtils.getString(jSONObject, "data"));
        } else if (ENCODING_BASE64.equals(string2)) {
            try {
                bArrDecode = Base64.decode(JSONUtils.getString(jSONObject, "data"), 0);
            } catch (Exception e3) {
                RVLogger.e(TAG, e3);
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
        } else {
            try {
                bArrDecode = JSONUtils.getString(jSONObject, "data").getBytes(convertEncoding(string2));
            } catch (Exception e4) {
                RVLogger.e(TAG, e4);
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
        }
        if (bArrDecode == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        long length = bArrDecode.length;
        if (z) {
            length += file.length();
        }
        if (length > 10485760) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_SIZE_OVERFLOW, "单个文件超限"));
            return;
        }
        long fileSize = (getFileSize(new File(ConversionPathTool.usrPathToLocalPath("https://usr", apiContext))) + length) - file.length();
        ?? r0 = 52428800;
        if (fileSize > 52428800) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_SIZE_OVERFLOW, "文件夹超限"));
            return;
        }
        FileLock fileLockLock = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, z);
                try {
                    fileLockLock = fileOutputStream.getChannel().lock();
                    fileOutputStream.write(bArrDecode);
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                    r0 = fileOutputStream;
                } catch (Exception e5) {
                    e = e5;
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, e.getMessage()));
                    r0 = fileOutputStream;
                }
            } catch (Throwable th) {
                th = th;
                l.a(fileLockLock);
                com.alibaba.ariver.commonability.file.a.a.a((Closeable) r0);
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r0 = 0;
            l.a(fileLockLock);
            com.alibaba.ariver.commonability.file.a.a.a((Closeable) r0);
            throw th;
        }
        l.a(fileLockLock);
        com.alibaba.ariver.commonability.file.a.a.a((Closeable) r0);
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter(ACTION_FS_MANAGE)
    public void fsManage(@BindingApiContext ApiContext apiContext, @BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) throws Throwable {
        String string = JSONUtils.getString(jSONObject, "action");
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (TextUtils.isEmpty(com.alibaba.ariver.commonability.file.a.a())) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10021, "用户未登录"));
            return;
        }
        if (ACTION_ACCESS.equals(string)) {
            access(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_APPEND_FILE.equals(string)) {
            appendFile(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_SAVE_FILE.equals(string)) {
            saveFile(apiContext, page, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_GET_SAVED_FILE_LIST.equals(string)) {
            getSavedFileList(apiContext, page, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_REMOVE_SAVED_FILE.equals(string)) {
            removeSavedFile(apiContext, page, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_COPY_FILE.equals(string)) {
            copyFile(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_GET_FILE_INFO.equals(string)) {
            getFileInfo(apiContext, page, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_MKDIR.equals(string)) {
            mkdir(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_READ_FILE.equals(string)) {
            readFile(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_READ_DIR.equals(string)) {
            readDir(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_RENAME.equals(string)) {
            rename(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_RMDIR.equals(string)) {
            rmdir(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_STAT.equals(string)) {
            stat(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if (ACTION_UNLINK.equals(string)) {
            unlink(apiContext, jSONObject, bridgeCallback);
            return;
        }
        if ("unzip".equals(string)) {
            unzip(apiContext, jSONObject, bridgeCallback);
        } else if (ACTION_WRITE_FILE.equals(string)) {
            writeFile(apiContext, jSONObject, bridgeCallback, false);
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.NOT_FOUND);
        }
    }

    private void stat(JSONArray jSONArray, File file, File file2, boolean z) {
        File[] fileArrListFiles;
        String strSubstring = file2.getPath().substring(file.getPath().length());
        boolean zIsDirectory = file2.isDirectory();
        boolean zIsFile = file2.isFile();
        com.alibaba.ariver.commonability.file.fs.a.b.b bVarA = com.alibaba.ariver.commonability.file.fs.a.b.a.a(file2.getPath());
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(strSubstring)) {
            if (file2.isDirectory()) {
                jSONObject.put("path", (Object) WVNativeCallbackUtil.SEPERATER);
            }
        } else {
            jSONObject.put("path", (Object) strSubstring);
        }
        jSONObject.put("mode", (Object) Integer.valueOf(bVarA != null ? bVarA.c : 0));
        jSONObject.put("size", (Object) Long.valueOf(bVarA != null ? bVarA.h : 0L));
        jSONObject.put("lastAccessedTime", (Object) Long.valueOf(bVarA != null ? bVarA.i : 0L));
        jSONObject.put("lastModifiedTime", (Object) Long.valueOf(bVarA != null ? bVarA.j : 0L));
        jSONObject.put("is_directory", (Object) Boolean.valueOf(zIsDirectory));
        jSONObject.put("is_file", (Object) Boolean.valueOf(zIsFile));
        jSONArray.add(jSONObject);
        if (!z || !zIsDirectory || (fileArrListFiles = file2.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            stat(jSONArray, file, file3, z);
        }
    }
}
