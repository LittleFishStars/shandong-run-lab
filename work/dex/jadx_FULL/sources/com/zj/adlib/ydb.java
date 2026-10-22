package com.zj.adlib;

import java.io.File;
import java.io.FileWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ydb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f46009a;
    public final /* synthetic */ String f;

    public ydb(File file, String str) {
        this.f46009a = file;
        this.f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            FileWriter fileWriter = new FileWriter(this.f46009a);
            try {
                fileWriter.write(this.f);
                fileWriter.close();
            } catch (Throwable th) {
                try {
                    fileWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable unused) {
        }
    }
}
