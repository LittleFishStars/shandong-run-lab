package com.baidu.location.b;

import android.util.Base64;
import com.baidu.location.Jni;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26373a;
    private String[] b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static n f26374a = new n();
    }

    private n() {
        this.f26373a = false;
        this.b = null;
        try {
            String str = Jni.getldkaiv();
            if (str == null || !str.contains("|")) {
                return;
            }
            String[] strArrSplit = str.split("\\|");
            this.b = strArrSplit;
            if (strArrSplit == null || strArrSplit.length != 2) {
                return;
            }
            this.f26373a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static n a() {
        return a.f26374a;
    }

    public synchronized String a(String str) {
        if (this.f26373a) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(this.b[1].getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(this.b[0].getBytes("UTF-8"), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public synchronized String b(String str) {
        if (!this.f26373a) {
            return null;
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.b[1].getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.b[0].getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str, 0)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean b() {
        return this.f26373a;
    }
}
