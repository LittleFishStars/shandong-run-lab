package com.ipd.dsp.internal.b;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.b0.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a<TranscodeType> extends i<a<TranscodeType>, TranscodeType> {
    @NonNull
    public static <TranscodeType> a<TranscodeType> b(int i) {
        return new a().a(i);
    }

    @NonNull
    public static <TranscodeType> a<TranscodeType> d() {
        return new a().a();
    }

    @Override // com.ipd.dsp.internal.b.i
    public boolean equals(Object obj) {
        return (obj instanceof a) && super.equals(obj);
    }

    @Override // com.ipd.dsp.internal.b.i
    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public static <TranscodeType> a<TranscodeType> b(@NonNull j.a aVar) {
        return new a().a(aVar);
    }

    @NonNull
    public static <TranscodeType> a<TranscodeType> b(@NonNull com.ipd.dsp.internal.b0.g<? super TranscodeType> gVar) {
        return new a().a(gVar);
    }
}
