package com.byazt.vx;

import android.content.Context;
import android.content.pm.Signature;
import com.zj.adlib.u15;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 71})
public class x {
    public static HashMap<String, ArrayList<String>> c = new HashMap<>();

    public static ArrayList<String> c(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (c.get(str) != null) {
                return c.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : tt(context, packageName)) {
                    String strC = "error!";
                    if ("MD5".equals(str)) {
                        strC = c(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        strC = c(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        strC = c(signature, "SHA256");
                    }
                    arrayList.add(strC);
                }
            } catch (Exception e) {
                com.byazt.eu.tt.ve(e.toString());
            }
            c.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] tt(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            com.byazt.eu.tt.ve(e.toString());
            return null;
        }
    }

    private static String c(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(u15.f19942b);
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e) {
            com.byazt.eu.tt.ve(e.toString());
            return "error!";
        }
    }
}
