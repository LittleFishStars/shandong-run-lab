package com.kc.bw.aliagainstcheatingId;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AliAgainstId {
    static {
        System.loadLibrary(dexg.dexa("ldcxBmjBhbjotuJe"));
    }

    public static String getBoot() {
        BufferedReader bufferedReader;
        String str = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(dexg.dexa("0qspd0tzt0lfsofm0sboepn0cppu`je"))));
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
                        Log.w(dexg.dexa("hfuCppu!gbjm!"), th.toString());
                        return str;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                Log.w(dexg.dexa("gjobmmz"), th2.toString());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        return str;
    }

    public static native Intent getD1(Context context, Intent intent);

    public static native String getD2K();

    public static native int getD2V();

    public static native boolean getD3(Context context, String str);

    public static native Intent getD4(Intent intent);

    public static native String getUpdate();
}
