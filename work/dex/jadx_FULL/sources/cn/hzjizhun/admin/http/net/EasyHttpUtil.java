package cn.hzjizhun.admin.http.net;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EasyHttpUtil {
    private static final Handler MAIN_UI_HREAD = new Handler(Looper.getMainLooper());

    public static class Logger {
        public static final String TAG = EasyHttp.class.getSimpleName();

        public static void e(String str, String str2) {
            if (EasyHttpConfig.isDebug) {
                Log.e(TAG, "[" + str + "]" + str2);
            }
        }

        public static void i(String str, String str2) {
            if (EasyHttpConfig.isDebug) {
                Log.i(TAG, "[" + str + "] " + str2);
            }
        }

        public static void w(String str, String str2) {
            if (EasyHttpConfig.isDebug) {
                Log.w(TAG, "[" + str + "] " + str2);
            }
        }
    }

    public static String appendHttpParams(Map<String, String> map, boolean z) {
        String strEncode;
        Iterator<String> it = map.keySet().iterator();
        Iterator<String> it2 = map.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        if (z && map.size() > 0) {
            stringBuffer.append("?");
        }
        for (int i = 0; i < map.size(); i++) {
            try {
                strEncode = URLEncoder.encode(it2.next(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                strEncode = null;
            }
            stringBuffer.append(it.next() + "=" + strEncode);
            if (i != map.size() - 1) {
                stringBuffer.append("&");
            }
        }
        return stringBuffer.toString();
    }

    public static String formatPostParams(Map<String, String> map) {
        if (map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static String formatPostString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    public static File getDownloaderDir(Context context, String str) {
        return new File((("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath()) + File.separator + str);
    }

    public static void postToMain(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            MAIN_UI_HREAD.post(runnable);
        }
    }

    public static void quietClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
