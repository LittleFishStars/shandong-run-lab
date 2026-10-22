package com.zj.adlib;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class o07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f43641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static String f18537a;

    @androidx.annotation.Nullable
    @KeepForSdk
    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        if (f18537a == null) {
            int iMyPid = f43641a;
            if (iMyPid == 0) {
                iMyPid = Process.myPid();
                f43641a = iMyPid;
            }
            String strTrim = null;
            strTrim = null;
            strTrim = null;
            BufferedReader bufferedReader2 = null;
            if (iMyPid > 0) {
                try {
                    String str = "/proc/" + iMyPid + "/cmdline";
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        bufferedReader = new BufferedReader(new FileReader(str));
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        try {
                            String line = bufferedReader.readLine();
                            yw6.l(line);
                            strTrim = line.trim();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            q44.b(bufferedReader2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th2;
                    }
                } catch (IOException unused2) {
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                }
                q44.b(bufferedReader);
            }
            f18537a = strTrim;
        }
        return f18537a;
    }
}
