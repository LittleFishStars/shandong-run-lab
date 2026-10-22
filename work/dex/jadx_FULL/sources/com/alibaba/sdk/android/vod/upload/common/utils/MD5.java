package com.alibaba.sdk.android.vod.upload.common.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.vod.common.utils.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MD5 {
    private static final String TAG = "MD5";

    public static String calculateMD5(Context context, String str) {
        return StringUtils.isUriPath(str) ? calculateMD5(context, Uri.parse(str)) : calculateMD5(new File(str));
    }

    @NotNull
    private static String calculateMD5ByStream(MessageDigest messageDigest, InputStream inputStream) {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            try {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i2);
                    if (i >= 1048576) {
                        break;
                    }
                    i += i2;
                } catch (IOException e) {
                    throw new RuntimeException("Unable to process file for MD5", e);
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.e("MD5", "Exception on closing MD5 input stream", e2);
                }
                throw th;
            }
        }
        String strReplace = String.format("%32s", new BigInteger(1, messageDigest.digest()).toString(16)).replace(' ', '0');
        try {
            inputStream.close();
        } catch (IOException e3) {
            Log.e("MD5", "Exception on closing MD5 input stream", e3);
        }
        return strReplace;
    }

    public static boolean checkMD5(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null) {
            Log.e("MD5", "MD5 string empty or updateFile null");
            return false;
        }
        String strCalculateMD5 = calculateMD5(file);
        if (strCalculateMD5 == null) {
            Log.e("MD5", "calculatedDigest null");
            return false;
        }
        Log.v("MD5", "Calculated digest: " + strCalculateMD5);
        Log.v("MD5", "Provided digest: " + str);
        return strCalculateMD5.equalsIgnoreCase(str);
    }

    public static String calculateMD5(File file) {
        try {
            try {
                return calculateMD5ByStream(MessageDigest.getInstance("MD5"), new FileInputStream(file));
            } catch (FileNotFoundException e) {
                Log.e("MD5", "Exception while getting FileInputStream", e);
                return null;
            }
        } catch (NoSuchAlgorithmException e2) {
            Log.e("MD5", "Exception while getting digest", e2);
            return null;
        }
    }

    public static boolean checkMD5(Context context, String str, String str2) {
        String strCalculateMD5;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e("MD5", "MD5 string empty or updateFile null");
            return false;
        }
        if (context == null) {
            Log.e("MD5", "context has been release");
            return false;
        }
        if (StringUtils.isUriPath(str2)) {
            strCalculateMD5 = calculateMD5(context, Uri.parse(str2));
        } else {
            strCalculateMD5 = calculateMD5(new File(str2));
        }
        if (strCalculateMD5 == null) {
            Log.e("MD5", "calculatedDigest null");
            return false;
        }
        Log.v("MD5", "Calculated digest: " + strCalculateMD5);
        Log.v("MD5", "Provided digest: " + str);
        return strCalculateMD5.equalsIgnoreCase(str);
    }

    public static String calculateMD5(Context context, Uri uri) {
        try {
            try {
                return calculateMD5ByStream(MessageDigest.getInstance("MD5"), context.getContentResolver().openInputStream(uri));
            } catch (FileNotFoundException e) {
                Log.e("MD5", "Exception while getting FileInputStream", e);
                return null;
            }
        } catch (NoSuchAlgorithmException e2) {
            Log.e("MD5", "Exception while getting digest", e2);
            return null;
        }
    }
}
