package com.alibaba.triver.kit.api.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Keep;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.commonability.file.g;
import com.alibaba.ariver.commonability.file.i;
import com.alibaba.ariver.commonability.file.proxy.b;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.triver_render.render.WMLTRWebView;
import com.google.common.base.a;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class FileUtils {
    private static final String TAG = "TRiverFileUtils";

    public static String apUrlToFilePath(String str) {
        Uri uriB;
        String[] strArrSplit;
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(g.e) && (uriB = i.b(str)) != null && !TextUtils.isEmpty(uriB.getPath()) && (strArrSplit = uriB.getPath().replace(WVNativeCallbackUtil.SEPERATER, "").split("\\.")) != null && strArrSplit.length > 1) {
                String str2 = strArrSplit[0];
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        str = b.a().b(str2);
                        return str;
                    }
                } catch (Exception e) {
                    RVLogger.e("", e);
                }
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & a.q];
        }
        return new String(cArr2);
    }

    public static boolean checkWriteable(File file) {
        return file != null && file.canWrite();
    }

    public static boolean delete(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile() ? deleteSingleFile(str) : deleteDirectory(str);
        }
        return false;
    }

    public static boolean deleteDirectory(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            boolean zDeleteDirectory = true;
            for (File file2 : file.listFiles()) {
                if (!file2.isFile()) {
                    if (file2.isDirectory() && !(zDeleteDirectory = deleteDirectory(file2.getAbsolutePath()))) {
                        break;
                    }
                } else {
                    zDeleteDirectory = deleteSingleFile(file2.getAbsolutePath());
                    if (!zDeleteDirectory) {
                        break;
                    }
                }
            }
            if (zDeleteDirectory && file.delete()) {
                RVLogger.e("--Method--", "Copy_Delete.deleteDirectory: 删除目录" + str + "成功！");
                return true;
            }
        }
        return false;
    }

    public static void deleteFiles(File file) {
        if (file != null && !file.isDirectory()) {
            file.delete();
            return;
        }
        if (file == null || !file.isDirectory()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                deleteFiles(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static boolean deleteSingleFile(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile() || !file.delete()) {
            return false;
        }
        RVLogger.e("--Method--", "Copy_Delete.deleteSingleFile: 删除单个文件" + str + "成功！");
        return true;
    }

    public static String filePathToApUrl(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String strA = b.a().a(str);
            if (!TextUtils.isEmpty(str2)) {
                return g.e + strA + Consts.DOT + str2;
            }
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit == null || strArrSplit.length <= 1) {
                return g.e + strA;
            }
            return g.e + strA + Consts.DOT + strArrSplit[strArrSplit.length - 1];
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getClientExtendConfig() {
        ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
        String str = "var CLIENT_EXTEND_CONFIG = {'apis':[";
        if (extensionManager != null && extensionManager.getBridgeDSLs() != null && !extensionManager.getBridgeDSLs().isEmpty()) {
            int size = extensionManager.getBridgeDSLs().size();
            for (int i = 0; i < size; i++) {
                str = str + extensionManager.getBridgeDSLs().get(i).toJSONString();
                if (i < size - 1) {
                    str = str + ",";
                }
            }
        }
        return str + "]}";
    }

    public static File getLocalFilePath(Context context, String str) {
        return new File(context.getCacheDir().getAbsolutePath() + File.separator + str);
    }

    public static String getMD5(File file) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        DigestInputStream digestInputStream;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
                try {
                    while (digestInputStream.read(new byte[262144]) > 0) {
                    }
                    String strByteArrayToHex = byteArrayToHex(digestInputStream.getMessageDigest().digest());
                    try {
                        digestInputStream.close();
                    } catch (Exception unused) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                    return strByteArrayToHex;
                } catch (Exception unused3) {
                    try {
                        digestInputStream.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused5) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        digestInputStream.close();
                    } catch (Exception unused6) {
                    }
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Exception unused7) {
                        throw th;
                    }
                }
            } catch (Exception unused8) {
                digestInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                digestInputStream = null;
            }
        } catch (Exception unused9) {
            digestInputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            digestInputStream = null;
        }
    }

    public static String getPagePathWithoutQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uriBuild = Uri.parse(str);
        if (!TextUtils.isEmpty(uriBuild.getQuery())) {
            uriBuild = uriBuild.buildUpon().clearQuery().build();
        }
        return uriBuild.toString();
    }

    public static File getParentPath(Context context) {
        File filesDir = context.getFilesDir();
        if (checkWriteable(filesDir)) {
            return filesDir;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (checkWriteable(externalFilesDir)) {
                return externalFilesDir;
            }
            File externalCacheDir = context.getExternalCacheDir();
            if (checkWriteable(externalCacheDir)) {
                return externalCacheDir;
            }
        }
        File cacheDir = context.getCacheDir();
        if (checkWriteable(cacheDir)) {
            return cacheDir;
        }
        return null;
    }

    public static String loadAsset(String str, Context context) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return readStreamToString(context.getAssets().open(str));
        } catch (IOException e) {
            RVLogger.e(WMLTRWebView.c, "loadAsset", e);
            return "";
        }
    }

    public static String loadFileOrAsset(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            return loadAsset(str, context);
        }
        try {
            return readStreamToString(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            RVLogger.w(Log.getStackTraceString(e));
            return "";
        }
    }

    public static String loadResource(String str, Node node) {
        String strWebResourceResponseToStr;
        Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(node).create()).load(ResourceLoadContext.newBuilder().originUrl(str).build());
        if (resourceLoad != null) {
            WebResourceResponse webResourceResponse = new WebResourceResponse(resourceLoad.getMimeType(), resourceLoad.getEncoding(), resourceLoad.getStream());
            HashMap map = new HashMap();
            map.put("Access-Control-Allow-Origin", "*");
            webResourceResponse.setResponseHeaders(map);
            strWebResourceResponseToStr = webResourceResponseToStr(webResourceResponse);
        } else {
            strWebResourceResponseToStr = null;
        }
        if (strWebResourceResponseToStr == null) {
            RVLogger.e(TAG, "loadResource h5ContentProvider.getContent return null");
        }
        if (TextUtils.isEmpty(strWebResourceResponseToStr)) {
            RVLogger.e(TAG, "*** Failed to load: " + str);
        }
        return strWebResourceResponseToStr;
    }

    public static String readStreamToString(InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        IOException e;
        try {
            StringBuilder sb = new StringBuilder(inputStream.available() + 10);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                try {
                    char[] cArr = new char[4096];
                    while (true) {
                        int i = bufferedReader.read(cArr);
                        if (i <= 0) {
                            break;
                        }
                        sb.append(cArr, 0, i);
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (inputStream == null) {
                            throw th;
                        }
                        try {
                            inputStream.close();
                            throw th;
                        } catch (IOException unused2) {
                            throw th;
                        }
                    }
                    String string = sb.toString();
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                    return string;
                } catch (IOException e2) {
                    e = e2;
                    RVLogger.w(Log.getStackTraceString(e));
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (inputStream == null) {
                        return "";
                    }
                    try {
                        inputStream.close();
                        return "";
                    } catch (IOException unused6) {
                        return "";
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static void removeFilesInDirectory(File file) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                deleteFiles(file2);
            } else {
                file2.delete();
            }
        }
    }

    public static String webResourceResponseToStr(WebResourceResponse webResourceResponse) {
        try {
            InputStream data = webResourceResponse.getData();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = data.read(bArr);
                if (i == -1) {
                    data.close();
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            RVLogger.e(TAG, "webResourceResponseToStr close stream error", e);
            return null;
        }
    }

    public static String writeString2LocalFile(Context context, String str, String str2) {
        File file = new File(context.getCacheDir().getAbsolutePath() + File.separator + str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(str2.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception e) {
            RVLogger.e(WMLTRWebView.c, "writeString2LocalFile", e);
        }
        return file.getAbsolutePath();
    }
}
