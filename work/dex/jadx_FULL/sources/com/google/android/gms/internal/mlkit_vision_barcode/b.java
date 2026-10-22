package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends zzde {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f31339a;

    public b(d dVar) {
        this.f31339a = dVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzde
    public final Map b() {
        return this.f31339a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzde, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        Set setEntrySet = this.f31339a.f5746a.entrySet();
        setEntrySet.getClass();
        try {
            return setEntrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new c(this.f31339a);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzde, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        zzbu.zzr(this.f31339a.f31343a, entry.getKey());
        return true;
    }
}
