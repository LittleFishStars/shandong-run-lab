package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.dgc;
import com.zj.adlib.wac;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class q extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcl f31355a;

    public q(zzcl zzclVar) {
        this.f31355a = zzclVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f31355a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        Map mapZzj = this.f31355a.zzj();
        if (mapZzj != null) {
            return mapZzj.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iZzq = this.f31355a.zzq(entry.getKey());
            if (iZzq != -1) {
                Object[] objArr = this.f31355a.zzc;
                objArr.getClass();
                if (wac.a(objArr[iZzq], entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzcl zzclVar = this.f31355a;
        Map mapZzj = zzclVar.zzj();
        return mapZzj != null ? mapZzj.entrySet().iterator() : new o(zzclVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        Map mapZzj = this.f31355a.zzj();
        if (mapZzj != null) {
            return mapZzj.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzcl zzclVar = this.f31355a;
        if (zzclVar.zzo()) {
            return false;
        }
        int iZzp = zzclVar.zzp();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object objZzh = zzcl.zzh(this.f31355a);
        zzcl zzclVar2 = this.f31355a;
        int[] iArr = zzclVar2.zza;
        iArr.getClass();
        Object[] objArr = zzclVar2.zzb;
        objArr.getClass();
        Object[] objArr2 = zzclVar2.zzc;
        objArr2.getClass();
        int iB = dgc.b(key, value, iZzp, objZzh, iArr, objArr, objArr2);
        if (iB == -1) {
            return false;
        }
        this.f31355a.zzn(iB, iZzp);
        this.f31355a.zzg--;
        this.f31355a.zzl();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f31355a.size();
    }
}
