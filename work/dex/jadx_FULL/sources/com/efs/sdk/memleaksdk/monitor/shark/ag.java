package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ag extends ae {
    private int b = 0;
    private int c = 0;

    private void e() {
        File[] fileArrListFiles;
        if (this.c > a().getMaxOverThresholdCount() || (fileArrListFiles = new File("/proc/self/task").listFiles()) == null) {
            return;
        }
        g.b("UMonitor.Thread", "over threshold dump thread");
        StringBuilder sb = new StringBuilder();
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            Closeable closeable = null;
            if (i < length) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileArrListFiles[i], "comm")));
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                            sb.append(",");
                        }
                        i.a(bufferedReader);
                    } catch (Throwable unused) {
                        closeable = bufferedReader;
                        i.a(closeable);
                    }
                } catch (Throwable unused2) {
                }
                i++;
            } else {
                sb.setLength(sb.length() - 1);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(e.a(e.d()), false);
                    try {
                        fileOutputStream.write(sb.toString().getBytes());
                        i.a(fileOutputStream);
                        return;
                    } catch (Throwable unused3) {
                        closeable = fileOutputStream;
                        i.a(closeable);
                        return;
                    }
                } catch (Throwable unused4) {
                }
            }
        }
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public boolean b() {
        int i = ah.e.f29649a;
        if (i <= a().getThreadThreshold() || i < this.b - 50) {
            c();
        } else {
            int i2 = this.c + 1;
            this.c = i2;
            g.c("UMonitor.Thread", String.format(Locale.US, "match: overThresholdCount: %d, threadCount: %d", Integer.valueOf(i2), Integer.valueOf(i)));
            e();
        }
        this.b = i;
        return this.c > a().getMaxOverThresholdCount();
    }

    public void c() {
        this.b = 0;
        this.c = 0;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public String d() {
        return "reason_thread";
    }
}
