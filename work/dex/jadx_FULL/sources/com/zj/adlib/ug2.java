package com.zj.adlib;

import com.hp.hpl.sparta.ParseLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ug2 implements ParseLog {
    @Override // com.hp.hpl.sparta.ParseLog
    public void a(String str, String str2, int i) {
        System.out.println(str2 + "(" + i + "): " + str + " (WARNING)");
    }

    @Override // com.hp.hpl.sparta.ParseLog
    public void b(String str, String str2, int i) {
        System.out.println(str2 + "(" + i + "): " + str + " (NOTE)");
    }

    @Override // com.hp.hpl.sparta.ParseLog
    public void c(String str, String str2, int i) {
        System.err.println(str2 + "(" + i + "): " + str + " (ERROR)");
    }
}
