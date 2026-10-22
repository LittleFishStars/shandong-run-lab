package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.facebook.common.internal.ImmutableList;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @KeepForSdk
    public static final String f43677a = "next_page_token";

    @NonNull
    @KeepForSdk
    public static final String b = "prev_page_token";

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> a(@NonNull DataBuffer<E> dataBuffer) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList(dataBuffer.getCount());
        try {
            Iterator<E> it = dataBuffer.iterator();
            while (it.hasNext()) {
                immutableList.add(it.next().freeze());
            }
            dataBuffer.close();
            return immutableList;
        } catch (Throwable th) {
            dataBuffer.close();
            throw th;
        }
    }

    public static boolean b(@NonNull DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean c(@NonNull DataBuffer<?> dataBuffer) {
        Bundle metadata = dataBuffer.getMetadata();
        return (metadata == null || metadata.getString(f43677a) == null) ? false : true;
    }

    public static boolean d(@NonNull DataBuffer<?> dataBuffer) {
        Bundle metadata = dataBuffer.getMetadata();
        return (metadata == null || metadata.getString(b) == null) ? false : true;
    }
}
