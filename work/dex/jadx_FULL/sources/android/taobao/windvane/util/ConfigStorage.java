package android.taobao.windvane.util;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.file.a;
import android.taobao.windvane.file.b;
import android.text.TextUtils;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class ConfigStorage {
    public static final long DEFAULT_MAX_AGE = 21600000;
    public static final long DEFAULT_SMALL_MAX_AGE = 1800000;
    public static final String KEY_DATA = "wv-data";
    public static final String KEY_TIME = "wv-time";
    public static final String ROOT_WINDVANE_CONFIG_DIR = "windvane/config";
    private static String TAG = "ConfigStorage";

    /* JADX INFO: Access modifiers changed from: private */
    public static String getConfigKey(String str, String str2) {
        return "WindVane_" + str + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFileAbsolutePath(String str) {
        String str2 = "";
        if (GlobalConfig.context == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(GlobalConfig.context.getFilesDir().getAbsolutePath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(ROOT_WINDVANE_CONFIG_DIR);
        if (str != null) {
            str2 = str3 + str;
        }
        sb.append(str2);
        return sb.toString();
    }

    public static long getLongVal(String str, String str2) throws Throwable {
        String configKey = getConfigKey(str, str2);
        long j = 0;
        try {
            File file = new File(getFileAbsolutePath(configKey));
            if (file.exists()) {
                byte[] bArrA = a.a(file);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                byteBufferAllocate.put(bArrA);
                byteBufferAllocate.flip();
                j = byteBufferAllocate.getLong();
                TaoLog.d(TAG, "read " + configKey + " by file : " + j);
            } else {
                SharedPreferences sharedPreference = getSharedPreference();
                if (sharedPreference == null) {
                    return 0L;
                }
                j = sharedPreference.getLong(configKey, 0L);
                putLongVal(str, str2, j);
                SharedPreferences.Editor editorEdit = sharedPreference.edit();
                editorEdit.remove(configKey);
                editorEdit.commit();
                TaoLog.i(TAG, "read " + configKey + " by sp : " + j);
            }
        } catch (Exception unused) {
            TaoLog.e(TAG, "can not read file : " + configKey);
        }
        return j;
    }

    private static SharedPreferences getSharedPreference() {
        Application application = GlobalConfig.context;
        if (application == null) {
            return null;
        }
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    public static String getStringVal(String str, String str2) {
        String configKey = getConfigKey(str, str2);
        String string = "";
        try {
            if (new File(getFileAbsolutePath(configKey)).exists()) {
                String str3 = new String(a.a(new File(getFileAbsolutePath(configKey))));
                try {
                    TaoLog.d(TAG, "read " + configKey + " by file : " + str3);
                    return str3;
                } catch (Exception unused) {
                    string = str3;
                    TaoLog.e(TAG, "can not read file : " + configKey);
                    return string;
                }
            }
            SharedPreferences sharedPreference = getSharedPreference();
            if (sharedPreference == null) {
                return "";
            }
            string = sharedPreference.getString(configKey, "");
            putStringVal(str, str2, string);
            SharedPreferences.Editor editorEdit = sharedPreference.edit();
            editorEdit.remove(configKey);
            editorEdit.commit();
            TaoLog.i(TAG, "read " + configKey + " by sp : " + string);
            return string;
        } catch (Exception unused2) {
        }
    }

    public static synchronized boolean initDirs() {
        Application application = GlobalConfig.context;
        if (application == null) {
            return false;
        }
        File fileA = b.a(application, ROOT_WINDVANE_CONFIG_DIR);
        TaoLog.d(TAG, "createDir: dir[" + fileA.getAbsolutePath() + "]:" + fileA.exists());
        return fileA.exists();
    }

    @TargetApi(11)
    public static synchronized void putLongVal(final String str, final String str2, final long j) {
        if (str == null || str2 == null) {
            return;
        }
        AsyncTask.execute(new Runnable() { // from class: android.taobao.windvane.util.ConfigStorage.2
            @Override // java.lang.Runnable
            public void run() {
                String configKey = ConfigStorage.getConfigKey(str, str2);
                String fileAbsolutePath = ConfigStorage.getFileAbsolutePath(configKey);
                try {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    byteBufferAllocate.putLong(j);
                    a.a(fileAbsolutePath, byteBufferAllocate);
                } catch (Exception unused) {
                    TaoLog.e(ConfigStorage.TAG, "can not sava file : " + configKey + " value : " + j);
                }
            }
        });
    }

    @TargetApi(11)
    public static synchronized void putStringVal(final String str, final String str2, final String str3) {
        if (str == null || str2 == null) {
            return;
        }
        AsyncTask.execute(new Runnable() { // from class: android.taobao.windvane.util.ConfigStorage.1
            @Override // java.lang.Runnable
            public void run() {
                String configKey = ConfigStorage.getConfigKey(str, str2);
                try {
                    a.a(ConfigStorage.getFileAbsolutePath(configKey), ByteBuffer.wrap(str3.getBytes()));
                } catch (Exception unused) {
                    TaoLog.e(ConfigStorage.TAG, "can not sava file : " + configKey + " value : " + str3);
                }
            }
        });
    }

    public static String getStringVal(String str, String str2, String str3) {
        try {
            String stringVal = getStringVal(str, str2);
            return TextUtils.isEmpty(stringVal) ? str3 : stringVal;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return str3;
        }
    }

    public static long getLongVal(String str, String str2, long j) {
        try {
            Long lValueOf = Long.valueOf(getLongVal(str, str2));
            return lValueOf.longValue() == 0 ? j : lValueOf.longValue();
        } catch (ClassCastException e) {
            e.printStackTrace();
            return j;
        }
    }
}
