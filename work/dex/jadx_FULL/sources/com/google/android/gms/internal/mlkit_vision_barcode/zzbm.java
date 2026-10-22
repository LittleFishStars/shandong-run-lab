package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zzbm implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbu f31364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Iterator f5781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public Object f5779a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public Collection f5780a = null;
    public Iterator b = zzcz.INSTANCE;

    public zzbm(zzbu zzbuVar) {
        this.f31364a = zzbuVar;
        this.f5781a = zzbuVar.zza.entrySet().iterator();
    }

    public abstract Object a(Object obj, Object obj2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5781a.hasNext() || this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.b.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f5781a.next();
            this.f5779a = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f5780a = collection;
            this.b = collection.iterator();
        }
        return a(this.f5779a, this.b.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.b.remove();
        Collection collection = this.f5780a;
        collection.getClass();
        if (collection.isEmpty()) {
            this.f5781a.remove();
        }
        this.f31364a.zzb--;
    }
}
