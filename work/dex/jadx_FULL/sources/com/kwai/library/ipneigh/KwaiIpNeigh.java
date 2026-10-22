package com.kwai.library.ipneigh;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
class KwaiIpNeigh {
    private static final String TAG = "KwaiIpNeigh";

    static {
        System.loadLibrary("ipneigh-android");
    }

    private static boolean aG(String str, String str2) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split("\\s+");
        if (strArrSplit.length < 2) {
            return false;
        }
        return strArrSplit[0].equals(str2);
    }

    private static native int getARPTableFromJni(int i);

    private static native int getARPTableFromJni2(int i);

    public static String j(String str, boolean z) {
        String line;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
            ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorArrCreatePipe[1];
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            int iDetachFd = parcelFileDescriptor2.detachFd();
            if ((z ? getARPTableFromJni2(iDetachFd) : getARPTableFromJni(iDetachFd)) != 0) {
                Log.e(TAG, "ARP table reading failed, are you using targetSdk 32 and an Android 13 device?");
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
            do {
                line = bufferedReader.readLine();
                if (line == null) {
                    return "";
                }
            } while (!aG(line, str));
            return line;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e(TAG, "getARPResult exception:" + th.getMessage());
        }
    }
}
