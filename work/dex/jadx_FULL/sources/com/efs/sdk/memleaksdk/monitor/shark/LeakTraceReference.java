package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bk, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001:\u0002'(B'\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0002HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001R\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010 \u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001aR\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b!\u0010\u001aR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "Ljava/io/Serializable;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "component1", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "component2", "component3", "component4", "originObject", "referenceType", "owningClassName", "referenceName", OperatePopupWindow.g, "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "getOriginObject", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "Ljava/lang/String;", "getOwningClassName", "()Ljava/lang/String;", "getOwningClassSimpleName", "owningClassSimpleName", "getReferenceDisplayName", "referenceDisplayName", "getReferenceGenericName", "referenceGenericName", "getReferenceName", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "getReferenceType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "<init>", "(Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "ReferenceType", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LeakTraceReference implements Serializable {

    @NotNull
    public static final a c = new a(0);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from toString */
    @NotNull
    public final LeakTraceObject originObject;

    /* JADX INFO: renamed from: b, reason: from toString */
    @NotNull
    final b referenceType;

    /* JADX INFO: renamed from: d, reason: from toString */
    @NotNull
    private final String owningClassName;

    /* JADX INFO: renamed from: e, reason: from toString */
    @NotNull
    private final String referenceName;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bk$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bk$b */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "", "<init>", "(Ljava/lang/String;I)V", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum b {
        INSTANCE_FIELD,
        STATIC_FIELD,
        LOCAL,
        ARRAY_ENTRY
    }

    public LeakTraceReference(@NotNull LeakTraceObject leakTraceObject, @NotNull b bVar, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(leakTraceObject, "originObject");
        Intrinsics.checkNotNullParameter(bVar, "referenceType");
        Intrinsics.checkNotNullParameter(str, "owningClassName");
        Intrinsics.checkNotNullParameter(str2, "referenceName");
        this.originObject = leakTraceObject;
        this.referenceType = bVar;
        this.owningClassName = str;
        this.referenceName = str2;
    }

    @NotNull
    public final String a() {
        return ct.a(this.owningClassName, '.');
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @NotNull
    public final String b() throws NoWhenBranchMatchedException {
        int i = bl.f29804a[this.referenceType.ordinal()];
        if (i == 1) {
            return '[' + this.referenceName + ']';
        }
        if (i == 2 || i == 3) {
            return this.referenceName;
        }
        if (i == 4) {
            return "<Java Local>";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @NotNull
    public final String c() throws NoWhenBranchMatchedException {
        int i = bl.b[this.referenceType.ordinal()];
        if (i == 1) {
            return "[x]";
        }
        if (i == 2 || i == 3) {
            return this.referenceName;
        }
        if (i == 4) {
            return "<Java Local>";
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeakTraceReference)) {
            return false;
        }
        LeakTraceReference leakTraceReference = (LeakTraceReference) other;
        return Intrinsics.areEqual(this.originObject, leakTraceReference.originObject) && Intrinsics.areEqual(this.referenceType, leakTraceReference.referenceType) && Intrinsics.areEqual(this.owningClassName, leakTraceReference.owningClassName) && Intrinsics.areEqual(this.referenceName, leakTraceReference.referenceName);
    }

    public int hashCode() {
        LeakTraceObject leakTraceObject = this.originObject;
        int iHashCode = (leakTraceObject != null ? leakTraceObject.hashCode() : 0) * 31;
        b bVar = this.referenceType;
        int iHashCode2 = (iHashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
        String str = this.owningClassName;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.referenceName;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LeakTraceReference(originObject=" + this.originObject + ", referenceType=" + this.referenceType + ", owningClassName=" + this.owningClassName + ", referenceName=" + this.referenceName + ")";
    }
}
