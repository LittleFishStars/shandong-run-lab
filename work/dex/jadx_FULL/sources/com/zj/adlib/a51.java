package com.zj.adlib;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a51 {
    public static void a(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) gj9.k(a51.class.getClassLoader()));
        }
    }

    public static <T extends Bundleable> ImmutableList<T> b(Bundleable.Creator<T> creator, List<Bundle> list) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            aVarBuilder.a(creator.a((Bundle) sb0.g(list.get(i))));
        }
        return aVarBuilder.e();
    }

    public static <T extends Bundleable> SparseArray<T> c(Bundleable.Creator<T> creator, SparseArray<Bundle> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = (SparseArray<T>) new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            parcelableSparseArray.put(sparseArray.keyAt(i), creator.a(sparseArray.valueAt(i)));
        }
        return parcelableSparseArray;
    }

    public static <T extends Bundleable> ArrayList<Bundle> d(Collection<T> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toBundle());
        }
        return arrayList;
    }

    public static <T extends Bundleable> ImmutableList<Bundle> e(List<T> list) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            aVarBuilder.a(list.get(i).toBundle());
        }
        return aVarBuilder.e();
    }

    public static <T extends Bundleable> SparseArray<Bundle> f(SparseArray<T> sparseArray) {
        SparseArray<Bundle> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i).toBundle());
        }
        return sparseArray2;
    }
}
