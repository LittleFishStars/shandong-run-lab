package com.bykv.vk.component.ttvideo.utils;

import android.os.Build;
import com.byazt.nr.m;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class VersionInfo {
    private static String[] mVersion;

    /* JADX WARN: Code duplicated, block: B:39:0x0063 A[Catch: all -> 0x0067, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0067, blocks: (B:9:0x002c, B:13:0x0034, B:39:0x0063, B:29:0x0051, B:8:0x0029, B:24:0x0047), top: B:57:0x000e, inners: #0, #7 }] */
    public static String[] getVersion() {
        FileReader fileReader;
        if (mVersion == null) {
            String[] strArr = {"null", "null", "null", "null"};
            BufferedReader bufferedReader = null;
            try {
                try {
                    fileReader = new FileReader("/proc/version");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                        try {
                            strArr[0] = bufferedReader2.readLine().split("\\s+")[2];
                            try {
                                bufferedReader2.close();
                                fileReader.close();
                            } catch (Throwable th) {
                                try {
                                    m.c(th);
                                    fileReader.close();
                                } catch (Throwable th2) {
                                    try {
                                        fileReader.close();
                                    } catch (Throwable th3) {
                                        m.c(th3);
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Throwable th4) {
                                    try {
                                        m.c(th4);
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                    } catch (Throwable th5) {
                                        if (fileReader != null) {
                                            try {
                                                fileReader.close();
                                            } catch (Throwable th6) {
                                                m.c(th6);
                                            }
                                        }
                                        throw th5;
                                    }
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    fileReader = null;
                }
            } catch (Throwable th7) {
                m.c(th7);
            }
            strArr[1] = Build.VERSION.RELEASE;
            strArr[2] = Build.MODEL;
            strArr[3] = Build.DISPLAY;
            mVersion = strArr;
        }
        return mVersion;
    }
}
