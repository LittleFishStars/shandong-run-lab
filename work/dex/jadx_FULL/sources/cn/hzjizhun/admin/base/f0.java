package cn.hzjizhun.admin.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import cn.hzjizhun.admin.base.ad.RcSdk;
import com.google.common.base.a;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22699a = "";

    public static String a(Context context, String str) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        String str2 = null;
        if (str != null) {
            try {
                signatureArr = (str.length() == 0 || (packageInfo = context.getPackageManager().getPackageInfo(str, 64)) == null) ? null : packageInfo.signatures;
            } catch (Throwable unused) {
            }
        }
        if (signatureArr == null || signatureArr.length == 0) {
            return null;
        }
        byte[] byteArray = signatureArr[0].toByteArray();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(byteArray);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i = 0;
            for (byte b : bArrDigest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i += 2;
                cArr2[i2] = cArr[b & a.q];
            }
            str2 = new String(cArr2);
            return str2;
        } catch (Throwable unused2) {
            return str2;
        }
    }

    public static boolean b() {
        try {
            if (!TextUtils.isEmpty(f22699a)) {
                return true;
            }
            String strA = a(RcSdk.e(), RcSdk.e().getPackageName());
            f22699a = strA;
            return !TextUtils.isEmpty(strA);
        } catch (Throwable unused) {
            return false;
        }
    }
}
