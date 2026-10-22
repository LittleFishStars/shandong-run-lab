package com.alibaba.triver.triver_render.utils;

import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static String a(String str) throws Throwable {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(((HttpURLConnection) new URL(str).openConnection()).getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuffer.append(line);
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        RVLogger.w(Log.getStackTraceString(e));
                        bufferedReader.close();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            RVLogger.w(Log.getStackTraceString(e2));
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            RVLogger.w(Log.getStackTraceString(e4));
        }
        return stringBuffer.toString();
    }
}
