package com.alibaba.sdk.android.vod.upload.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SharedPreferencesUtil {
    public static boolean clearUploadInfo(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).edit().remove(str2).commit();
    }

    public static OSSUploadInfo getUploadInfo(Context context, String str, String str2) {
        try {
            return (OSSUploadInfo) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(context.getSharedPreferences(str, 0).getString(str2, "").getBytes(), 0))).readObject();
        } catch (IOException | ClassNotFoundException unused) {
            return null;
        }
    }

    public static void saveUploadInfp(Context context, String str, String str2, OSSUploadInfo oSSUploadInfo) throws Exception {
        if (!(oSSUploadInfo instanceof Serializable)) {
            throw new Exception("User must implements Serializable");
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(oSSUploadInfo);
            editorEdit.putString(str2, new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0)));
            editorEdit.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
