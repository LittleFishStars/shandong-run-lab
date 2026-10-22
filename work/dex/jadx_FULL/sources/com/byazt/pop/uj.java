package com.byazt.pop;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 993, 15})
public class uj implements c {
    public final ConcurrentHashMap<Integer, c> c = new ConcurrentHashMap<>();

    public void c(c cVar) {
        if (cVar != null) {
            this.c.put(Integer.valueOf(cVar.hashCode()), cVar);
        }
    }

    public void tt() {
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // com.byazt.pop.c
    public void ve(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new tt.c().c(next.getValue()).c("onDownloadFailed").c(j).tt(j2).tt(str).ve(str2).c();
            }
        }
    }

    @Override // com.byazt.pop.c
    public void c() {
        Iterator<Map.Entry<Integer, c>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new tt.c().c(next.getValue()).c("onIdle").c();
            }
        }
    }

    @Override // com.byazt.pop.c
    public void tt(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new tt.c().c(next.getValue()).c("onDownloadPaused").c(j).tt(j2).tt(str).ve(str2).c();
            }
        }
    }

    @Override // com.byazt.pop.c
    public void c(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new tt.c().c(next.getValue()).c("onDownloadActive").c(j).tt(j2).tt(str).ve(str2).c();
            }
        }
    }

    @Override // com.byazt.pop.c
    public void c(String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().c(str, str2);
                new tt.c().c(next.getValue()).c("onInstalled").tt(str).ve(str2).c();
            }
        }
    }

    @Override // com.byazt.pop.c
    public void c(long j, String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new tt.c().c(next.getValue()).c("onDownloadFinished").c(j).tt(str).ve(str2).c();
            }
        }
    }
}
