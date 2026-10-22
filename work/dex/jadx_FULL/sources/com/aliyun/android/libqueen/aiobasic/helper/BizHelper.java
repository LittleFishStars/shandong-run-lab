package com.aliyun.android.libqueen.aiobasic.helper;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import com.zj.adlib.c49;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class BizHelper {
    private static final int MAX_WRITE_COUNT = 10;
    private static final String UUID_DIR = "AlivcData";
    private static final String UUID_FILE = "alivc_data.txt";
    private static final String UUID_PROP = "UUID";
    private static String sDeviceUUID;
    private static int sWriteUUIDCount;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f25562a;
        final /* synthetic */ String b;

        public a(File file, String str) {
            this.f25562a = file;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                boolean z2 = this.f25562a.exists() || this.f25562a.createNewFile();
                Properties properties = new Properties();
                properties.setProperty(BizHelper.UUID_PROP, this.b);
                if (z2) {
                    FileWriter fileWriter = new FileWriter(this.f25562a);
                    properties.store(fileWriter, (String) null);
                    fileWriter.close();
                    z = true;
                }
            } catch (Throwable unused) {
            }
            BizHelper.access$008();
            if (z || BizHelper.sWriteUUIDCount >= 10) {
                return;
            }
            BizHelper.writeUUIDToFile(this.f25562a, this.b);
        }
    }

    public static /* synthetic */ int access$008() {
        int i = sWriteUUIDCount;
        sWriteUUIDCount = i + 1;
        return i;
    }

    public static boolean checkWriteFilePermission() {
        Context context = ContextManager.getContext();
        return context != null && context.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0;
    }

    @Keep
    public static synchronized String getDeviceUUID() {
        if (!TextUtils.isEmpty(sDeviceUUID)) {
            return sDeviceUUID;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "AlivcData");
        File file2 = new File(file, UUID_FILE);
        if (file.exists() || file.mkdir()) {
            try {
                Properties properties = new Properties();
                FileReader fileReader = new FileReader(file2);
                properties.load(fileReader);
                fileReader.close();
                sDeviceUUID = properties.getProperty(UUID_PROP);
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(sDeviceUUID)) {
            sWriteUUIDCount = 0;
            String strReplace = UUID.randomUUID().toString().replace(c49.f40900a, "");
            sDeviceUUID = strReplace;
            writeUUIDToFile(file2, strReplace);
        }
        return sDeviceUUID;
    }

    @Keep
    public static String getWriteFilePermission() {
        return checkWriteFilePermission() ? "1" : "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeUUIDToFile(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        ExecutorHelper.getInstance().submitDelay(new a(file, str), 3000L);
    }
}
