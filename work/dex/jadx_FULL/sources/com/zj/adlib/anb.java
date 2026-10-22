package com.zj.adlib;

import cn.hzjizhun.admin.base.g;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class anb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zlb f40563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ File f15305a;

    public anb(File file, zlb zlbVar) {
        this.f15305a = file;
        this.f40563a = zlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            FileReader fileReader = new FileReader(this.f15305a);
            try {
                char[] cArr = new char[2048];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = fileReader.read(cArr);
                    if (i == -1) {
                        String string = sb.toString();
                        zlb zlbVar = this.f40563a;
                        zlbVar.f46289a.a(g.a(string));
                        fileReader.close();
                        return;
                    }
                    sb.append(cArr, 0, i);
                    th.getMessage();
                    zlb zlbVar2 = this.f40563a;
                    zlbVar2.f21087a.c(zlbVar2.f21089a, zlbVar2.f21088a, zlbVar2.f46289a);
                }
            } catch (Throwable th) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th3.getMessage();
            zlb zlbVar3 = this.f40563a;
            zlbVar3.f21087a.c(zlbVar3.f21089a, zlbVar3.f21088a, zlbVar3.f46289a);
        }
    }
}
