package com.ipd.dsp.internal.d0;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class p<T> implements com.ipd.dsp.internal.b.b.InterfaceC0859b<T>, com.ipd.dsp.internal.a0.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f38283a;
    public a b;

    public static final class a extends com.ipd.dsp.internal.a0.f<View, Object> {
        public a(@NonNull View view) {
            super(view);
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // com.ipd.dsp.internal.a0.f
        public void onResourceCleared(@Nullable Drawable drawable) {
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void onResourceReady(@NonNull Object obj, @Nullable com.ipd.dsp.internal.b0.f<? super Object> fVar) {
        }
    }

    public p() {
    }

    @Override // com.ipd.dsp.internal.b.b.InterfaceC0859b
    @Nullable
    public int[] a(@NonNull T t, int i, int i2) {
        int[] iArr = this.f38283a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public p(@NonNull View view) {
        a aVar = new a(view);
        this.b = aVar;
        aVar.getSize(this);
    }

    @Override // com.ipd.dsp.internal.a0.o
    public void a(int i, int i2) {
        this.f38283a = new int[]{i, i2};
        this.b = null;
    }

    public void a(@NonNull View view) {
        if (this.f38283a == null && this.b == null) {
            a aVar = new a(view);
            this.b = aVar;
            aVar.getSize(this);
        }
    }
}
