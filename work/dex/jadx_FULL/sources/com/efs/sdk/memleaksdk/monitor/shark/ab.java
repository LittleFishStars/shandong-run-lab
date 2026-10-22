package com.efs.sdk.memleaksdk.monitor.shark;

import android.system.Os;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ab extends ae {
    private int b = 0;
    private int c = 0;

    private int e() {
        File[] fileArrListFiles = new File("/proc/self/fd").listFiles();
        if (fileArrListFiles != null) {
            return fileArrListFiles.length;
        }
        return 0;
    }

    private void f() {
        File[] fileArrListFiles;
        FileOutputStream fileOutputStream;
        if (this.c <= a().getMaxOverThresholdCount() && (fileArrListFiles = new File("/proc/self/fd").listFiles()) != null) {
            g.b("UMonitor.Fd", "over threshold dump fd if need.");
            StringBuilder sb = new StringBuilder();
            for (File file : fileArrListFiles) {
                try {
                    sb.append(Os.readlink(file.getPath()));
                    sb.append(",");
                } catch (Throwable unused) {
                }
            }
            sb.setLength(sb.length() - 1);
            try {
                fileOutputStream = new FileOutputStream(e.a(e.e()), false);
                try {
                    fileOutputStream.write(sb.toString().getBytes());
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                fileOutputStream = null;
            }
            i.a(fileOutputStream);
        }
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public boolean b() {
        int iE = e();
        if (iE <= a().getFdThreshold() || iE < this.b - 50) {
            c();
        } else {
            int i = this.c + 1;
            this.c = i;
            g.c("UMonitor.Fd", String.format(Locale.US, "match: overThresholdCount: %d, fdCount: %d", Integer.valueOf(i), Integer.valueOf(iE)));
            f();
        }
        this.b = iE;
        return this.c >= a().getMaxOverThresholdCount();
    }

    public void c() {
        this.b = 0;
        this.c = 0;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public String d() {
        return "reason_fd";
    }
}
