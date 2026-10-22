package com.kc.dw.core.utils;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class x0 extends com.kc.dw.core.safe.j {
    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            Process processStart = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream(), "utf-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    stringBuffer.append(line);
                }
            }
            bufferedReader.close();
            String lowerCase = stringBuffer.toString().toLowerCase();
            w0.A = lowerCase;
            if (TextUtils.isEmpty(lowerCase)) {
                return;
            }
            r.a().b("cpuInfo", w0.A);
        } catch (Throwable unused) {
        }
    }
}
