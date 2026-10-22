package com.alibaba.triver.kit.api.network;

import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpDownloader {
    /* JADX WARN: Code duplicated, block: B:41:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0086 A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #4 {all -> 0x00a5, blocks: (B:3:0x0003, B:12:0x0037, B:16:0x0044, B:39:0x0076, B:42:0x0086, B:19:0x0049, B:15:0x003d, B:33:0x0065, B:38:0x0073, B:36:0x006a, B:46:0x008e, B:51:0x009c, B:55:0x00a4, B:54:0x00a1, B:49:0x0093), top: B:61:0x0003, inners: #0, #1, #5, #6, #10 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.net.HttpURLConnection] */
    public static String download(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            boolean z = true;
            try {
                try {
                    try {
                        str = (HttpURLConnection) new URL(str).openConnection();
                        try {
                            str.setConnectTimeout(5000);
                            str.setReadTimeout(5000);
                            bufferedReader2 = new BufferedReader(new InputStreamReader(str.getInputStream(), "utf-8"));
                            while (true) {
                                try {
                                    String line = bufferedReader2.readLine();
                                    if (line != null) {
                                        stringBuffer.append(line);
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException e) {
                                            RVLogger.w(Log.getStackTraceString(e));
                                        }
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    RVLogger.w(Log.getStackTraceString(e));
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e3) {
                                            RVLogger.w(Log.getStackTraceString(e3));
                                        }
                                    }
                                    if (str != 0) {
                                        str.disconnect();
                                    }
                                    RVLogger.e("TAG", "下载txt文件");
                                    RVLogger.e("TAG", stringBuffer.toString());
                                    if (z) {
                                        return null;
                                    }
                                    return stringBuffer.toString();
                                }
                            }
                            bufferedReader2.close();
                            z = false;
                            str.disconnect();
                        } catch (IOException e4) {
                            e = e4;
                            bufferedReader2 = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = null;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    RVLogger.w(Log.getStackTraceString(e5));
                                }
                            }
                            if (str == 0) {
                                throw th;
                            }
                            try {
                                str.disconnect();
                                throw th;
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                } catch (IOException e8) {
                    e = e8;
                    str = 0;
                    bufferedReader2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                    bufferedReader = null;
                }
                RVLogger.e("TAG", "下载txt文件");
                RVLogger.e("TAG", stringBuffer.toString());
                if (z) {
                    return null;
                }
                return stringBuffer.toString();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
