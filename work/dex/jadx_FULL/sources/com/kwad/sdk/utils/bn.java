package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class bn {
    private static String TAG = "plugin.signature";
    public static Signature[] currentSignatures = new Signature[0];

    public static String getSignMd5Str(Context context) {
        try {
            Signature[] signatures = getSignatures(context);
            if (signatures != null && signatures.length > 0) {
                return an.md5ForByte(signatures[0].toByteArray());
            }
            return "";
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w(TAG, e);
            return "";
        }
    }

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    private static Signature[] getSignatures(Context context) {
        Signature[] signatureArr = currentSignatures;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        PackageInfo packageInfo = aa.getPackageInfo(context, context.getPackageName(), 64);
        if (packageInfo != null) {
            currentSignatures = packageInfo.signatures;
        }
        return currentSignatures;
    }
}
