package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.ybc;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f31341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public Collection f5743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Iterator f5744a;

    public c(d dVar) {
        this.f31341a = dVar;
        this.f5744a = dVar.f5746a.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5744a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f5744a.next();
        this.f5743a = (Collection) entry.getValue();
        d dVar = this.f31341a;
        Object key = entry.getKey();
        return new zzcr(key, dVar.f31343a.zzd(key, (Collection) entry.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        ybc.e(this.f5743a != null, "no calls to next() since the last call to remove()");
        this.f5744a.remove();
        this.f31341a.f31343a.zzb -= this.f5743a.size();
        this.f5743a.clear();
        this.f5743a = null;
    }
}
