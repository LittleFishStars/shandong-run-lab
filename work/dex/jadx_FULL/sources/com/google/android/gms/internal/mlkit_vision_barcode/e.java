package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.ybc;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f31344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Iterator f5747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public Map.Entry f5748a;

    public e(f fVar, Iterator it) {
        this.f31344a = fVar;
        this.f5747a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5747a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.f5747a.next();
        this.f5748a = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        ybc.e(this.f5748a != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.f5748a.getValue();
        this.f5747a.remove();
        this.f31344a.f31346a.zzb -= collection.size();
        collection.clear();
        this.f5748a = null;
    }
}
