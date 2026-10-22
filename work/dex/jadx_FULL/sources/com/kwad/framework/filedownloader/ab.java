package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class ab implements w {
    private final SparseArray<Handler> aAp = new SparseArray<>();

    private static void b(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void c(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void BM() {
        for (int i = 0; i < this.aAp.size(); i++) {
            b(this.aAp.get(this.aAp.keyAt(i)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int BN() {
        return this.aAp.size();
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean cz(int i) {
        return this.aAp.get(i) != null;
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void w(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            c(this.aAp.get(it.next().intValue()));
        }
    }
}
