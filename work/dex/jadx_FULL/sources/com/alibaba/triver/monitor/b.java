package com.alibaba.triver.monitor;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25018a = "triver.db";
    private static final long b = 4194304;
    private final File c = new File(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getCacheDir() + WVNativeCallbackUtil.SEPERATER + f25018a);

    private void c() throws IOException {
        if (!this.c.exists()) {
            this.c.createNewFile();
        } else if (this.c.isDirectory()) {
            this.c.delete();
            this.c.createNewFile();
        }
    }

    @Override // com.alibaba.triver.monitor.a
    public void a(String str) throws Throwable {
        try {
            c();
            if (this.c.length() >= 4194304) {
                return;
            }
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(this.c, true);
                try {
                    fileWriter2.append((CharSequence) str).append((CharSequence) "\n");
                    fileWriter2.close();
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.triver.monitor.a
    public void b() {
        if (this.c.exists()) {
            this.c.delete();
        }
    }

    @Override // com.alibaba.triver.monitor.a
    public List<String> a() throws Throwable {
        BufferedReader bufferedReader;
        try {
            c();
            if (this.c.length() > 0) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(this.c));
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            arrayList.add(line);
                        }
                        bufferedReader.close();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
