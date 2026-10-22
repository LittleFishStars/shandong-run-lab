package com.zj.adlib;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.lm7, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u001f\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/zj/adlib/lm7;", "", "", "a", "b", "label", "imageUrl", "c", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "e", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "run_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class RunRecordFaceThumb {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    public final String label;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @Nullable
    public final String imageUrl;

    public RunRecordFaceThumb(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "label");
        this.label = str;
        this.imageUrl = str2;
    }

    public static /* synthetic */ RunRecordFaceThumb d(RunRecordFaceThumb runRecordFaceThumb, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = runRecordFaceThumb.label;
        }
        if ((i & 2) != 0) {
            str2 = runRecordFaceThumb.imageUrl;
        }
        return runRecordFaceThumb.c(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final RunRecordFaceThumb c(@NotNull String label, @Nullable String imageUrl) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new RunRecordFaceThumb(label, imageUrl);
    }

    @Nullable
    public final String e() {
        return this.imageUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RunRecordFaceThumb)) {
            return false;
        }
        RunRecordFaceThumb runRecordFaceThumb = (RunRecordFaceThumb) other;
        return Intrinsics.areEqual(this.label, runRecordFaceThumb.label) && Intrinsics.areEqual(this.imageUrl, runRecordFaceThumb.imageUrl);
    }

    @NotNull
    public final String f() {
        return this.label;
    }

    public int hashCode() {
        int iHashCode = this.label.hashCode() * 31;
        String str = this.imageUrl;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "RunRecordFaceThumb(label=" + this.label + ", imageUrl=" + this.imageUrl + ')';
    }
}
