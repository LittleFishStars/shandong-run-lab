package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements DataBufferObserver, DataBufferObserver.Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f31276a = new HashSet();

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public void a(@NonNull DataBufferObserver dataBufferObserver) {
        this.f31276a.add(dataBufferObserver);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public void b(@NonNull DataBufferObserver dataBufferObserver) {
        this.f31276a.remove(dataBufferObserver);
    }

    public void c() {
        this.f31276a.clear();
    }

    public boolean d() {
        return !this.f31276a.isEmpty();
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataChanged() {
        Iterator it = this.f31276a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataChanged();
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeChanged(int i, int i2) {
        Iterator it = this.f31276a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeChanged(i, i2);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeInserted(int i, int i2) {
        Iterator it = this.f31276a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeInserted(i, i2);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeMoved(int i, int i2, int i3) {
        Iterator it = this.f31276a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeMoved(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeRemoved(int i, int i2) {
        Iterator it = this.f31276a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeRemoved(i, i2);
        }
    }
}
