package com.aliyun.vod.log.util;

import android.content.Context;
import android.text.TextUtils;
import com.zj.adlib.c49;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class UUIDGenerator {
    public static final String DATA_DIRECTORY = "AlivcData";
    private static final int MAX_WRITE_COUNT = 10;
    private static final String UUID_FILE = "alivc_data.txt";
    private static final String UUID_PROP = "UUID";
    private static String sDeviceUUID;
    private static int sWriteUUIDCount;

    public static /* synthetic */ int access$008() {
        int i = sWriteUUIDCount;
        sWriteUUIDCount = i + 1;
        return i;
    }

    public static final String generateRequestID() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    public static synchronized String generateUUID(Context context) {
        if (!TextUtils.isEmpty(sDeviceUUID)) {
            return sDeviceUUID;
        }
        File appFilesOrCacheDir = getAppFilesOrCacheDir(context, "AlivcData");
        File file = new File(appFilesOrCacheDir, UUID_FILE);
        try {
            if (appFilesOrCacheDir.exists() || appFilesOrCacheDir.mkdir()) {
                Properties properties = new Properties();
                FileReader fileReader = new FileReader(file);
                properties.load(fileReader);
                fileReader.close();
                sDeviceUUID = properties.getProperty(UUID_PROP);
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(sDeviceUUID)) {
            sWriteUUIDCount = 0;
            String strReplace = UUID.randomUUID().toString().replace(c49.f40900a, "");
            sDeviceUUID = strReplace;
            writeUUIDToFile(file, strReplace);
        }
        return sDeviceUUID;
    }

    public static File getAppFilesOrCacheDir(Context context, String str) {
        if (context == null) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir;
        }
        File file = new File("/sdcard/Android/data/" + context.getPackageName() + "/files", TextUtils.isEmpty(str) ? "" : str);
        if (!file.exists() && !file.mkdirs()) {
            if (TextUtils.isEmpty(str)) {
                return context.getCacheDir();
            }
            file = new File(context.getCacheDir(), str);
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeUUIDToFile(final File file, final String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        new Timer().schedule(new TimerTask() { // from class: com.aliyun.vod.log.util.UUIDGenerator.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean z = false;
                try {
                    boolean z2 = file.exists() || file.createNewFile();
                    Properties properties = new Properties();
                    properties.setProperty(UUIDGenerator.UUID_PROP, str);
                    if (z2) {
                        FileWriter fileWriter = new FileWriter(file);
                        properties.store(fileWriter, (String) null);
                        fileWriter.close();
                        z = true;
                    }
                } catch (Throwable unused) {
                }
                UUIDGenerator.access$008();
                if (z || UUIDGenerator.sWriteUUIDCount >= 10) {
                    return;
                }
                UUIDGenerator.writeUUIDToFile(file, str);
            }
        }, 3000L);
    }
}
