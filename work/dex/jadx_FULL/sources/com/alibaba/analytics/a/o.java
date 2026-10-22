package com.alibaba.analytics.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Random f23748a = new Random();
    private static String bd = "";
    private static String be = "";

    public static synchronized String d(Context context) {
        return bd;
    }

    public static synchronized String e(Context context) {
        return be;
    }

    public static String getImei(Context context) {
        String strD;
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_ie", "");
                if (!u.isEmpty(string)) {
                    String str = new String(b.decode(string.getBytes(), 2), "UTF-8");
                    if (!u.isEmpty(str)) {
                        return str;
                    }
                }
            } catch (Exception unused) {
            }
            strD = d(context);
        } else {
            strD = null;
        }
        if (u.isEmpty(strD)) {
            strD = getUniqueID();
        }
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("UTCommon", 0).edit();
                editorEdit.putString("_ie", new String(b.encode(strD.getBytes("UTF-8"), 2)));
                editorEdit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return strD;
    }

    public static String getImsi(Context context) {
        String strE;
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_is", "");
                if (!u.isEmpty(string)) {
                    String str = new String(b.decode(string.getBytes(), 2), "UTF-8");
                    if (!u.isEmpty(str)) {
                        return str;
                    }
                }
            } catch (Exception unused) {
            }
            strE = e(context);
        } else {
            strE = null;
        }
        if (u.isEmpty(strE)) {
            strE = getUniqueID();
        }
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("UTCommon", 0).edit();
                editorEdit.putString("_is", new String(b.encode(strE.getBytes("UTF-8"), 2)));
                editorEdit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return strE;
    }

    public static final String getUniqueID() {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNanoTime = (int) System.nanoTime();
        Random random = f23748a;
        int iNextInt = random.nextInt();
        int iNextInt2 = random.nextInt();
        byte[] bytes = h.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = h.getBytes(iNanoTime);
        byte[] bytes3 = h.getBytes(iNextInt);
        byte[] bytes4 = h.getBytes(iNextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return b.encodeToString(bArr, 2);
    }
}
