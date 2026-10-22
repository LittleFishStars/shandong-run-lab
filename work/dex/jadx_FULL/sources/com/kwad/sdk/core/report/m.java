package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class m<T extends e> implements l<T> {
    private final Map<String, T> aVr = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized void o(@NonNull T t) {
        this.aVr.put(t.actionId, t);
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void H(List<T> list) {
        for (T t : list) {
            if (t != null) {
                this.aVr.remove(t.actionId);
            }
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<T> eE(int i) {
        ArrayList arrayList;
        arrayList = new ArrayList(Math.min(this.aVr.size(), 200));
        Iterator<Map.Entry<String, T>> it = this.aVr.entrySet().iterator();
        for (int i2 = 0; i2 < 200 && it.hasNext(); i2++) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        int size;
        size = this.aVr.size();
        com.kwad.sdk.core.d.c.d("MemReportCache", "size() = " + size);
        return size;
    }
}
