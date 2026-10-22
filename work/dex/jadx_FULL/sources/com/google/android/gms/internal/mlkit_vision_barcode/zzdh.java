package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.uic;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zzdh extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public transient Collection f31366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public transient Set f5782a;

    @CheckForNull
    public transient Set b;

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f5782a;
        if (set != null) {
            return set;
        }
        Set setZzb = zzb();
        this.f5782a = setZzb;
        return setZzb;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.b;
        if (set != null) {
            return set;
        }
        y yVar = new y(this);
        this.b = yVar;
        return yVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f31366a;
        if (collection != null) {
            return collection;
        }
        uic uicVar = new uic(this);
        this.f31366a = uicVar;
        return uicVar;
    }

    public abstract Set zzb();
}
