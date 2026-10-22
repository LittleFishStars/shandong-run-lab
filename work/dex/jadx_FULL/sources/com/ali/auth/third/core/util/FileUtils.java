package com.ali.auth.third.core.util;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FileUtils {
    public static String readFileData(Context context, String str) {
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
            int iAvailable = fileInputStreamOpenFileInput.available();
            if (iAvailable > 0) {
                byte[] bArr = new byte[iAvailable];
                fileInputStreamOpenFileInput.read(bArr);
                String str2 = new String(bArr, "UTF-8");
                try {
                    fileInputStreamOpenFileInput.close();
                    return str2;
                } catch (Exception unused) {
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        return "";
    }

    public static void writeFileData(Context context, String str, String str2) {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            fileOutputStreamOpenFileOutput.write(str2.getBytes());
            fileOutputStreamOpenFileOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
