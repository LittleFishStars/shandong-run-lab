package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.nr.m;
import com.byazt.nys.tt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public final class TTPlayerConfiger {
    private static String APP_PATH = null;
    private static String CRASH_FILE_NAME = "ttplayer_crash.log";
    private static String CRASH_FILE_PATH = null;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_POOL_STACK_SIZE = 32;
    public static final int FALSE = 0;
    public static boolean IS_PRINT_INFO = false;
    public static final int IS_TIME_OUT_COUNT = 3;
    private static final SparseArray<Value> KEYS = new SparseArray<>();
    public static final int KEY_IS_BATTERY_INFO = 23;
    public static final int KEY_IS_CHECK_LIB = 3;
    public static final int KEY_IS_CHECK_TTPLAYER_MODEL = 0;
    public static final int KEY_IS_CRASHED = 7;
    public static final int KEY_IS_CRASH_FILE_NAME = 17;
    public static final int KEY_IS_CRASH_PATH = 19;
    public static final int KEY_IS_DEBUG_MODEL = 6;
    public static final int KEY_IS_FORBID_CREATED_OS_PLAYER = 11;
    public static final int KEY_IS_FOREGROUND = 21;
    public static final int KEY_IS_IPTTPLAYER_ON = 2;
    public static final int KEY_IS_LOG_FILE_DIR = 20;
    public static final int KEY_IS_ON_SCREEN = 22;
    public static final int KEY_IS_OPEN_DEVICE_FAIL = 8;
    public static final int KEY_IS_PORT_VERSION = 18;
    public static final int KEY_IS_PRINT_INFO = 5;
    public static final int KEY_IS_SDK_VERSION = 13;
    public static final int KEY_IS_SDK_VERSION_INFO = 15;
    public static final int KEY_IS_SDK_VERSION_NAME = 14;
    public static final int KEY_IS_START_SERVICE = 16;
    public static final int KEY_IS_STOP_SERVICE = 12;
    public static final int KEY_IS_THREAD_POOL_STACK_SIZE = 25;
    public static final int KEY_IS_THROW_CRASH = 4;
    public static final int KEY_IS_TIMEOUT_COUNT = 10;
    public static final int KEY_IS_TTPLAYER_ON = 1;
    public static final int KEY_IS_USED_THREAD_POOL = 24;
    private static String LIBRARY_DIR = null;
    private static String PLAYER_LIBRARY_NAME = "libttmplayer_lite.so";
    private static final int PORT_VERSION = 2;
    public static final String TAG = "ttplayer";
    public static final int TRUE = 1;
    private static String TTPLAYER_FILE_CACHE_DIR = null;
    private static final int VERSION = 1;
    private static final String VERSION_INFO = "version code:1,name:999.999.999.9default sdk info 2016-12-05";
    private static final String VERSION_NAME = "999.999.999.9";

    public static final class IntValue extends Value {
        private int mValue;

        public IntValue(int i, int i2) {
            super(i);
            this.mValue = i2;
        }

        public int getValue() {
            return this.mValue;
        }

        public void setValue(int i) {
            this.mValue = i;
        }
    }

    public static class LongValue extends Value {
        private long mValue;

        public LongValue(int i, long j) {
            super(i);
            this.mValue = j;
        }

        public long getValue() {
            return this.mValue;
        }

        public void setValue(long j) {
            this.mValue = j;
        }
    }

    public static class StringValue extends Value {
        private String mValue;

        public StringValue(int i, String str) {
            super(i);
            this.mValue = str;
        }

        public String getValue() {
            return this.mValue;
        }

        public void setValue(String str) {
            this.mValue = str;
        }
    }

    public static class Value {
        private int mKey;

        public Value(int i) {
            this.mKey = i;
        }

        public int getKey() {
            return this.mKey;
        }
    }

    static {
        setValue(13, 1);
        setValue(14, VERSION_NAME);
        setValue(15, VERSION_INFO);
        setValue(0, false);
        setValue(1, true);
        setValue(2, true);
        setValue(3, false);
        setValue(4, false);
        setValue(5, false);
        setValue(6, false);
        setValue(7, false);
        setValue(8, false);
        setValue(10, 0);
        setValue(11, false);
        setValue(18, 2);
        setValue(25, 32);
    }

    public static void checkDebugTTPlayerLib() {
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x0088 A[Catch: IOException -> 0x0084, TRY_LEAVE, TryCatch #10 {IOException -> 0x0084, blocks: (B:44:0x0080, B:48:0x0088), top: B:80:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x009b A[Catch: IOException -> 0x0097, TRY_LEAVE, TryCatch #0 {IOException -> 0x0097, blocks: (B:54:0x0093, B:58:0x009b), top: B:74:0x0093 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00ae A[Catch: IOException -> 0x00aa, TRY_LEAVE, TryCatch #7 {IOException -> 0x00aa, blocks: (B:64:0x00a6, B:68:0x00ae), top: B:78:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static final boolean copyFile(String str, String str2, boolean z, boolean z2) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(str2);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(str);
        if (file2.exists()) {
            if (z) {
                new File(str).delete();
            }
        } else if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    fileOutputStream.close();
                    fileInputStream.close();
                    if (z2) {
                        file.delete();
                    }
                    try {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return true;
                    } catch (IOException e) {
                        m.c(e);
                        return true;
                    }
                } catch (FileNotFoundException unused) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (IOException e2) {
                            m.c(e2);
                            return false;
                        }
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (IOException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (IOException e3) {
                            m.c(e3);
                            return false;
                        }
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (IOException e4) {
                            m.c(e4);
                            throw th;
                        }
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                th = th;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } else if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            fileInputStream = null;
        } catch (IOException unused6) {
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileOutputStream = null;
        }
    }

    @Deprecated
    public static final String getAppCrashFilePath(Context context) {
        if (CRASH_FILE_PATH != null || new File(getAppCrashFileStorePath(context)).exists()) {
            if (isPrintInfo()) {
                m.c(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,278>carsh file path:" + CRASH_FILE_PATH);
            }
            return CRASH_FILE_PATH;
        }
        return APP_PATH + File.separatorChar + "plugins" + File.separatorChar + "com.bykv.vk.component.ttvideo" + File.separatorChar + "data" + File.separatorChar + "files" + File.separatorChar + CRASH_FILE_NAME;
    }

    public static final String getAppCrashFilePath2(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = tt.c(context.getApplicationContext()).getAbsolutePath();
        }
        if (CRASH_FILE_PATH != null) {
            if (isPrintInfo()) {
                m.c(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,195>carsh file path:" + CRASH_FILE_PATH);
            }
            return CRASH_FILE_PATH;
        }
        if (APP_PATH == null) {
            APP_PATH = getAppFilesPath(context);
        }
        if (isPrintInfo()) {
            m.c(TAG, "<TTPlayerConfigure.java,getAppCrashFilePath2,211>app files path:" + APP_PATH);
        }
        if (APP_PATH == null) {
            return null;
        }
        return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
    }

    @Deprecated
    public static final String getAppCrashFileStorePath(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = tt.c(context.getApplicationContext()).getAbsolutePath();
        }
        if (CRASH_FILE_PATH != null) {
            if (isPrintInfo()) {
                m.c(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,253>carsh file path:" + CRASH_FILE_PATH);
            }
            return CRASH_FILE_PATH;
        }
        if (APP_PATH == null) {
            APP_PATH = getAppFilesPath(context);
        }
        if (isPrintInfo()) {
            m.c(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,245>app files path:" + APP_PATH);
        }
        if (APP_PATH == null) {
            return null;
        }
        return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
    }

    public static final String getAppFileCachePath(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = tt.c(context.getApplicationContext()).getAbsolutePath();
        }
        String str = TTPLAYER_FILE_CACHE_DIR;
        if (str != null) {
            return str;
        }
        String str2 = APP_PATH;
        if (str2 != null) {
            return str2;
        }
        if (context == null) {
            return null;
        }
        try {
            String absolutePath = tt.c(context.getApplicationContext()).getAbsolutePath();
            APP_PATH = absolutePath;
            return absolutePath;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getAppFilesPath(Context context) {
        String str = APP_PATH;
        if (str != null) {
            return str;
        }
        if (context == null) {
            return null;
        }
        try {
            String absolutePath = tt.c(context.getApplicationContext()).getAbsolutePath();
            APP_PATH = absolutePath;
            return absolutePath;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getExternalStorageDirectoryCrashFilePath() {
        return null;
    }

    public static String getPlayerLibraryPath(Context context) {
        if (APP_PATH == null || context != null) {
            APP_PATH = getAppFilesPath(context);
        }
        if (APP_PATH == null && LIBRARY_DIR == null) {
            return null;
        }
        String str = LIBRARY_DIR;
        if (str == null) {
            return APP_PATH + File.separatorChar + PLAYER_LIBRARY_NAME;
        }
        if (str.endsWith(String.valueOf(File.separatorChar))) {
            return LIBRARY_DIR + PLAYER_LIBRARY_NAME;
        }
        return LIBRARY_DIR + File.separatorChar + PLAYER_LIBRARY_NAME;
    }

    public static String getPlayerLibrarysDir(Context context) {
        String str = LIBRARY_DIR;
        if (str == null) {
            String str2 = getAppFilesPath(context) + File.separatorChar;
            LIBRARY_DIR = str2;
            return str2;
        }
        if (str.endsWith(String.valueOf(File.separatorChar))) {
            return LIBRARY_DIR;
        }
        return LIBRARY_DIR + File.separatorChar;
    }

    public static final String getPlugerCrashFilePath(Context context) {
        return APP_PATH + File.separatorChar + "plugins" + File.separatorChar + "com.bykv.vk.component.ttvideo" + File.separatorChar + "data" + File.separatorChar + "files" + File.separatorChar + CRASH_FILE_NAME;
    }

    public static final String getValue(int i, String str) {
        if (i == 17) {
            return CRASH_FILE_NAME;
        }
        Value value = KEYS.get(i);
        return (value == null || !(value instanceof StringValue)) ? str : ((StringValue) value).getValue();
    }

    public static final int getVersion() {
        return 1;
    }

    public static final boolean isOnTTPlayer() {
        if (getValue(6, 0) == 1) {
            return true;
        }
        if (getValue(1, 0) == 0) {
            return false;
        }
        if (getValue(11, 0) == 1) {
            return true;
        }
        return (getValue(7, 0) == 1 || getValue(8, 0) == 1 || getValue(10, 0) >= 3) ? false : true;
    }

    public static boolean isPrintInfo() {
        return IS_PRINT_INFO;
    }

    public static final boolean moveFile(String str, String str2, boolean z) {
        return copyFile(str, str2, z, true);
    }

    public static final void setCrashFileName(String str) {
        CRASH_FILE_NAME = str;
    }

    public static final void setCrashFilePath(String str) {
        CRASH_FILE_PATH = str;
    }

    public static final void setLibraryName(String str) {
        PLAYER_LIBRARY_NAME = str;
    }

    public static final void setLibrarysDir(String str) {
        LIBRARY_DIR = str;
    }

    public static final void setValue(int i, boolean z) {
        setValue(i, z ? 1 : 0);
    }

    public static final void setValue(int i, int i2) {
        SparseArray<Value> sparseArray = KEYS;
        Value value = sparseArray.get(i);
        if (value != null) {
            if (value instanceof IntValue) {
                if (i == 2 && getValue(6, false)) {
                    return;
                }
                ((IntValue) value).setValue(i2);
                return;
            }
            sparseArray.remove(i);
        }
        sparseArray.append(i, new IntValue(i, i2));
    }

    public static final boolean getValue(int i, boolean z) {
        Value value = KEYS.get(i);
        if (value == null || !(value instanceof IntValue)) {
            return z;
        }
        return ((IntValue) value).getValue() == 1;
    }

    public static final int getValue(int i, int i2) {
        Value value = KEYS.get(i);
        return (value == null || !(value instanceof IntValue)) ? i2 : ((IntValue) value).getValue();
    }

    public static String getPlayerLibraryPath() {
        return getPlayerLibraryPath(null);
    }

    public static final void setValue(int i, long j) {
        SparseArray<Value> sparseArray = KEYS;
        Value value = sparseArray.get(i);
        if (value != null) {
            if (value instanceof LongValue) {
                ((LongValue) value).setValue(j);
                return;
            }
            sparseArray.remove(i);
        }
        sparseArray.append(i, new LongValue(i, j));
    }

    public static final long getValue(int i, long j) {
        Value value = KEYS.get(i);
        return (value == null || !(value instanceof LongValue)) ? j : ((LongValue) value).getValue();
    }

    public static final void setValue(int i, String str) {
        SparseArray<Value> sparseArray = KEYS;
        Value value = sparseArray.get(i);
        if (value != null) {
            if (value instanceof StringValue) {
                ((StringValue) value).setValue(str);
                return;
            }
            sparseArray.remove(i);
        }
        sparseArray.append(i, new StringValue(i, str));
    }
}
