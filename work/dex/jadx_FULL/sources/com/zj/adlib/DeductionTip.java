package com.zj.adlib;

import com.huachenjie.run.page.run_index.adapter.DeductionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.s82, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/zj/adlib/s82;", "", "Lcom/huachenjie/run/page/run_index/adapter/DeductionType;", "a", "", "b", "type", "text", "c", "toString", "", "hashCode", "other", "", "equals", "Lcom/huachenjie/run/page/run_index/adapter/DeductionType;", "getType", "()Lcom/huachenjie/run/page/run_index/adapter/DeductionType;", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "<init>", "(Lcom/huachenjie/run/page/run_index/adapter/DeductionType;Ljava/lang/String;)V", "run_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class DeductionTip {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    public final DeductionType type;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final String text;

    public DeductionTip(@NotNull DeductionType deductionType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(deductionType, "type");
        Intrinsics.checkNotNullParameter(str, "text");
        this.type = deductionType;
        this.text = str;
    }

    public static /* synthetic */ DeductionTip d(DeductionTip deductionTip, DeductionType deductionType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            deductionType = deductionTip.type;
        }
        if ((i & 2) != 0) {
            str = deductionTip.text;
        }
        return deductionTip.c(deductionType, str);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public final DeductionType getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final DeductionTip c(@NotNull DeductionType type, @NotNull String text) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        return new DeductionTip(type, text);
    }

    @NotNull
    public final String e() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeductionTip)) {
            return false;
        }
        DeductionTip deductionTip = (DeductionTip) other;
        return this.type == deductionTip.type && Intrinsics.areEqual(this.text, deductionTip.text);
    }

    @NotNull
    public final DeductionType getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "DeductionTip(type=" + this.type + ", text=" + this.text + ')';
    }
}
