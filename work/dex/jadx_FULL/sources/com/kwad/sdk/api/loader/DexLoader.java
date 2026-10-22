package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.Keep;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
public class DexLoader {
    private static final String DEX_ROOT_DIR_NAME = "ksad_dex";
    private static final String TAG = "DexLoader";
    private static final String TARGET_DEX_NAME = "dexJar.jar";
    private static final String dexJarCheckFileName = "ksaddex_makejar.check";
    private static final String dexJarFileName = "ksad_data.jar";
    private static String sDexPathRoot;

    private static boolean checkLocal(Context context, String str, int i) {
        Log.d(TAG, "checkLocal start assetCheckFileMd5: " + str + ", assetCheckVersionCode: " + i);
        if (i != 5041002) {
            return false;
        }
        File file = new File(getTargetDexFilePath(context));
        return file.exists() && Objects.equals(y.getFileMD5(file), str);
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static File copyAssetsToData(Context context, String str, DexLoadError dexLoadError) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            AssetManager assets = context.getAssets();
            File file = new File(getDexRootPath(context));
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(getTargetDexFilePath(context));
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            inputStreamOpen = assets.open(str);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    try {
                        int iA = p.a(getTargetDexFilePath(context), inputStreamOpen, p.bs(context));
                        if (iA != 1 && dexLoadError != null) {
                            dexLoadError.setErrorCode(iA);
                        }
                        fileOutputStream.flush();
                        file2.setReadable(true);
                        file2.setWritable(false);
                        closeQuietly(inputStreamOpen);
                        closeQuietly(fileOutputStream);
                        return file2;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (dexLoadError != null) {
                            dexLoadError.setErrorCode(-3);
                            dexLoadError.setErrorMsg(e.getMessage());
                        }
                        closeQuietly(inputStreamOpen);
                        closeQuietly(fileOutputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpen;
                    closeQuietly(inputStream);
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                inputStream = inputStreamOpen;
                closeQuietly(inputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamOpen = null;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            closeQuietly(inputStream);
            closeQuietly(fileOutputStream);
            throw th;
        }
    }

    private static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    private static ClassLoader createDexClassLoader(Context context, ClassLoader classLoader, String str, DexLoadError dexLoadError) {
        try {
            String strB = z.b(classLoader);
            Log.w(TAG, "createDexClassLoader parent classLoader is: " + classLoader + ", defaultLibPaths is:  " + strB);
            ClassLoader classLoaderA = g.a(context, classLoader, str, context.getCacheDir().getAbsolutePath(), strB);
            Log.w(TAG, "createDexClassLoader KsAdSDKImpl class is: " + classLoaderA.loadClass("com.kwad.sdk.KsAdSDKImpl"));
            return classLoaderA;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            if (dexLoadError == null) {
                return null;
            }
            dexLoadError.setErrorMsg(e.getMessage());
            dexLoadError.setErrorCode(-1);
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            if (dexLoadError == null) {
                return null;
            }
            dexLoadError.setErrorMsg(th.getMessage());
            dexLoadError.setErrorCode(-2);
            return null;
        }
    }

    private static String getDexRootPath(Context context) {
        String str = sDexPathRoot;
        if (str != null) {
            return str;
        }
        return context.getApplicationInfo().dataDir + File.separator + DEX_ROOT_DIR_NAME;
    }

    public static String getTargetDexFilePath(Context context) {
        return getDexRootPath(context) + File.separator + TARGET_DEX_NAME;
    }

    public static ClassLoader initDex(Context context, ClassLoader classLoader) {
        q qVarHH = r.HH();
        if (qVarHH != null) {
            qVarHH.onInit(context);
        }
        Log.w(TAG, "initDex liteApi: " + qVarHH);
        DexLoadError dexLoadError = new DexLoadError();
        String strPrepareDexFile = prepareDexFile(context, dexLoadError);
        Log.w(TAG, "initDex after prepareDexFile error: " + dexLoadError);
        if (!dexLoadError.success()) {
            if (qVarHH != null) {
                Log.w(TAG, "initDex after prepareDexFile reportDexLoadError: ");
                qVarHH.reportDexLoadError(context, dexLoadError);
            }
            return null;
        }
        ClassLoader classLoaderCreateDexClassLoader = createDexClassLoader(context, classLoader, strPrepareDexFile, dexLoadError);
        Log.w(TAG, "initDex after createDexClassLoader error: " + dexLoadError);
        if (dexLoadError.success()) {
            return classLoaderCreateDexClassLoader;
        }
        Log.w(TAG, "initDex after createDexClassLoader reportDexLoadError: ");
        if (qVarHH != null) {
            qVarHH.reportDexLoadError(context, dexLoadError);
        }
        return null;
    }

    private static boolean isTargetDexFileExist(Context context) {
        return false;
    }

    private static String obtainCheckMd5(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return null;
        }
        return strArrSplit[0];
    }

    private static int obtainVersionCode(String str) {
        if (str == null) {
            return -1;
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return -1;
        }
        int length = strArrSplit.length;
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            if (str2.startsWith("versionCode:")) {
                try {
                    return Integer.parseInt(str2.replace("versionCode:", "").trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    private static String prepareDexFile(Context context, DexLoadError dexLoadError) throws Throwable {
        Log.d(TAG, "prepareDexFile start");
        String targetDexFilePath = getTargetDexFilePath(context);
        String checkFile = readCheckFile(context);
        String strObtainCheckMd5 = obtainCheckMd5(checkFile);
        int iObtainVersionCode = obtainVersionCode(checkFile);
        Log.d(TAG, "prepareDexFile after read check md5: " + strObtainCheckMd5);
        if (checkLocal(context, strObtainCheckMd5, iObtainVersionCode)) {
            Log.d(TAG, "prepareDexFile checkLocal success");
            return targetDexFilePath;
        }
        File fileCopyAssetsToData = copyAssetsToData(context, dexJarFileName, dexLoadError);
        Log.d(TAG, "prepareDexFile copyAssetsToData done");
        if (fileCopyAssetsToData != null && fileCopyAssetsToData.exists()) {
            String fileMD5 = y.getFileMD5(fileCopyAssetsToData);
            if (Objects.equals(fileMD5, strObtainCheckMd5)) {
                targetDexFilePath = fileCopyAssetsToData.getAbsolutePath();
            } else {
                dexLoadError.setErrorCode(-4);
                dexLoadError.setErrorMsg("targetMd5:" + fileMD5 + ", assetJarFileMd5:" + strObtainCheckMd5);
            }
        }
        Log.d(TAG, "prepareDexFile end with: " + targetDexFilePath);
        return targetDexFilePath;
    }

    private static String readCheckFile(Context context) throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStreamOpen;
        try {
            inputStreamOpen = context.getAssets().open(dexJarCheckFileName);
            try {
                StringBuilder sb = new StringBuilder();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, "UTF-8"));
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                String strTrim = sb.toString().trim();
                                closeQuietly(inputStreamOpen);
                                closeQuietly(bufferedReader);
                                return strTrim;
                            }
                            sb.append(line);
                            sb.append("\n");
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            closeQuietly(inputStreamOpen);
                            closeQuietly(bufferedReader);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th2;
                    closeQuietly(inputStreamOpen);
                    closeQuietly(bufferedReader);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamOpen = null;
            bufferedReader = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            inputStreamOpen = null;
        }
    }
}
