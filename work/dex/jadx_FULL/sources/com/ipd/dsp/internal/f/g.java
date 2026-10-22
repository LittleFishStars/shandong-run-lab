package com.ipd.dsp.internal.f;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.i.v;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g<T> implements m<T> {
    public final Collection<? extends m<T>> c;

    @SafeVarargs
    public g(@NonNull m<T>... mVarArr) {
        if (mVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.c = Arrays.asList(mVarArr);
    }

    @Override // com.ipd.dsp.internal.f.m
    @NonNull
    public v<T> a(@NonNull Context context, @NonNull v<T> vVar, int i, int i2) {
        Iterator<? extends m<T>> it = this.c.iterator();
        v<T> vVar2 = vVar;
        while (it.hasNext()) {
            v<T> vVarA = it.next().a(context, vVar2, i, i2);
            if (vVar2 != null && !vVar2.equals(vVar) && !vVar2.equals(vVarA)) {
                vVar2.e();
            }
            vVar2 = vVarA;
        }
        return vVar2;
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.c.equals(((g) obj).c);
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return this.c.hashCode();
    }

    public g(@NonNull Collection<? extends m<T>> collection) {
        if (!collection.isEmpty()) {
            this.c = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        Iterator<? extends m<T>> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(messageDigest);
        }
    }
}
