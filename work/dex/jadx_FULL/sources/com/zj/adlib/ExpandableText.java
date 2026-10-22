package com.zj.adlib;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.gb3, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/gb3;", "", "", "a", "b", "closeSpan", "expandSpan", "c", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/CharSequence;", "e", "()Ljava/lang/CharSequence;", "f", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ExpandableText {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    public final CharSequence closeSpan;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @NotNull
    public final CharSequence expandSpan;

    public ExpandableText(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "closeSpan");
        Intrinsics.checkNotNullParameter(charSequence2, "expandSpan");
        this.closeSpan = charSequence;
        this.expandSpan = charSequence2;
    }

    public static /* synthetic */ ExpandableText d(ExpandableText expandableText, CharSequence charSequence, CharSequence charSequence2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = expandableText.closeSpan;
        }
        if ((i & 2) != 0) {
            charSequence2 = expandableText.expandSpan;
        }
        return expandableText.c(charSequence, charSequence2);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public final CharSequence getCloseSpan() {
        return this.closeSpan;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: from getter */
    public final CharSequence getExpandSpan() {
        return this.expandSpan;
    }

    @NotNull
    public final ExpandableText c(@NotNull CharSequence closeSpan, @NotNull CharSequence expandSpan) {
        Intrinsics.checkNotNullParameter(closeSpan, "closeSpan");
        Intrinsics.checkNotNullParameter(expandSpan, "expandSpan");
        return new ExpandableText(closeSpan, expandSpan);
    }

    @NotNull
    public final CharSequence e() {
        return this.closeSpan;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpandableText)) {
            return false;
        }
        ExpandableText expandableText = (ExpandableText) other;
        return Intrinsics.areEqual(this.closeSpan, expandableText.closeSpan) && Intrinsics.areEqual(this.expandSpan, expandableText.expandSpan);
    }

    @NotNull
    public final CharSequence f() {
        return this.expandSpan;
    }

    public int hashCode() {
        return (this.closeSpan.hashCode() * 31) + this.expandSpan.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExpandableText(closeSpan=" + ((Object) this.closeSpan) + ", expandSpan=" + ((Object) this.expandSpan) + ')';
    }
}
