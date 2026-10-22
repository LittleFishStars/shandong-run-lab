package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.mlkit.vision.barcode.ZoomSuggestionOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class am0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ZoomSuggestionOptions f15292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Executor f15293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f15294a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40554a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public ZoomSuggestionOptions f15295a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Executor f15296a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f15297a;

        @NonNull
        public am0 a() {
            return new am0(this.f40554a, this.f15297a, this.f15296a, this.f15295a, null);
        }

        @NonNull
        public a b() {
            this.f15297a = true;
            return this;
        }

        @NonNull
        public a c(@Barcode.BarcodeFormat int i, @NonNull @Barcode.BarcodeFormat int... iArr) {
            this.f40554a = i;
            if (iArr != null) {
                for (int i2 : iArr) {
                    this.f40554a = i2 | this.f40554a;
                }
            }
            return this;
        }

        @NonNull
        public a d(@NonNull Executor executor) {
            this.f15296a = executor;
            return this;
        }

        @NonNull
        public a e(@NonNull ZoomSuggestionOptions zoomSuggestionOptions) {
            this.f15295a = zoomSuggestionOptions;
            return this;
        }
    }

    public /* synthetic */ am0(int i, boolean z, Executor executor, ZoomSuggestionOptions zoomSuggestionOptions, u6c u6cVar) {
        this.f40553a = i;
        this.f15294a = z;
        this.f15293a = executor;
        this.f15292a = zoomSuggestionOptions;
    }

    public final int a() {
        return this.f40553a;
    }

    @Nullable
    public final ZoomSuggestionOptions b() {
        return this.f15292a;
    }

    @Nullable
    public final Executor c() {
        return this.f15293a;
    }

    public final boolean d() {
        return this.f15294a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof am0)) {
            return false;
        }
        am0 am0Var = (am0) obj;
        return this.f40553a == am0Var.f40553a && this.f15294a == am0Var.f15294a && i76.b(this.f15293a, am0Var.f15293a) && i76.b(this.f15292a, am0Var.f15292a);
    }

    public int hashCode() {
        return i76.c(Integer.valueOf(this.f40553a), Boolean.valueOf(this.f15294a), this.f15293a, this.f15292a);
    }
}
