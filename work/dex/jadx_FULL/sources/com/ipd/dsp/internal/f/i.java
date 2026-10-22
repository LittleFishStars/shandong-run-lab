package com.ipd.dsp.internal.f;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i implements f {
    public final ArrayMap<h<?>, Object> c = new com.ipd.dsp.internal.d0.b();

    public void a(@NonNull i iVar) {
        this.c.putAll((SimpleArrayMap<? extends h<?>, ? extends Object>) iVar.c);
    }

    public i b(@NonNull h<?> hVar) {
        this.c.remove(hVar);
        return this;
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.c.equals(((i) obj).c);
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.c + '}';
    }

    @NonNull
    public <T> i a(@NonNull h<T> hVar, @NonNull T t) {
        this.c.put(hVar, t);
        return this;
    }

    @Nullable
    public <T> T a(@NonNull h<T> hVar) {
        return this.c.containsKey(hVar) ? (T) this.c.get(hVar) : hVar.b();
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.c.size(); i++) {
            a(this.c.keyAt(i), this.c.valueAt(i), messageDigest);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(@NonNull h<T> hVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        hVar.a(obj, messageDigest);
    }
}
