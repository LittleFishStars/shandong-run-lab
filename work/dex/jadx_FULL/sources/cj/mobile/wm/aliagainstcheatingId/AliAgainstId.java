package cj.mobile.wm.aliagainstcheatingId;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import cj.mobile.wm.dexc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliAgainstId {
    static {
        System.loadLibrary(dexc.dexa("mzxnBmjBhbjotuJe"));
    }

    public static String getBoot() {
        BufferedReader bufferedReader;
        String str = "";
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File(dexc.dexa("0qspd0tzt0lfsofm0sboepn0cppu`je"))));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        str = str + line;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            Log.w(dexc.dexa("hfuCppu!gbjm!"), th.toString());
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th3) {
                                    Log.w(dexc.dexa("gjobmmz"), th3.toString());
                                }
                            }
                            throw th2;
                        }
                    }
                }
                bufferedReader.close();
            } catch (Throwable th4) {
                Log.w(dexc.dexa("gjobmmz"), th4.toString());
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        return str;
    }

    public static native boolean getD1V2(Context context, Intent intent);

    public static native boolean getD2V2(Context context, Intent intent);

    public static native boolean getD3(Context context, String str);

    public static native boolean getD3V2(Context context, String str, String str2);

    public static native boolean getD4V2(Context context, Intent intent);

    public static native boolean getD5(Context context, Intent intent, String str);

    public static native String getUpdateV2();
}
