package com.byazt.rx;

import com.byazt.nr.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 152, 15})
public class uj {

    @com.byazt.zqa.c(c = {0, 1, 152, 123})
    public static class c extends com.byazt.jtc.ve {
        public InputStream c;
        public List<String> tt;

        public c(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.c = inputStream;
            this.tt = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.c));
            int length = 32768;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.startsWith("---------")) {
                            length -= line.getBytes("UTF-8").length;
                            if (length < 0) {
                                break;
                            } else {
                                this.tt.add(line);
                            }
                        }
                    } else {
                        break;
                    }
                } catch (IOException unused) {
                    com.byazt.mg.a.c(bufferedReader);
                    return;
                } catch (Throwable th) {
                    com.byazt.mg.a.c(bufferedReader);
                    throw th;
                }
            }
            com.byazt.mg.a.c(bufferedReader);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 152, 153})
    public static class tt extends com.byazt.jtc.ve {
        public Process c;
        public long tt;

        public tt(Process process, long j) {
            super("LogcatDump$TimerThread");
            this.c = process;
            this.tt = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.tt);
            } catch (InterruptedException e) {
                m.c(e);
            }
            Process process = this.c;
            if (process != null) {
                process.destroy();
            }
        }
    }

    public static List<String> c(int i, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {"logcat", "-t", String.valueOf(i), c(i2)};
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            new c(processExec.getInputStream(), copyOnWriteArrayList).start();
            new c(processExec.getErrorStream(), copyOnWriteArrayList).start();
            new tt(processExec, 3000L).start();
            processExec.waitFor(3000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            try {
                m.c(th);
                return copyOnWriteArrayList;
            } finally {
                if (processExec != null) {
                    processExec.destroy();
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private static String c(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }
}
