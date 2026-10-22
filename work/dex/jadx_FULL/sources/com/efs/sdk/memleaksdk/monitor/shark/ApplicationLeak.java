package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.android.arouter.utils.Consts;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.al, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u0019\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u000f\u0010\u0011\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006!"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak;", "Lcom/efs/sdk/memleaksdk/monitor/shark/Leak;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "component1", "leakTraces", OperatePopupWindow.g, "leakTraceFromV20$memleaksdk_release", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "leakTraceFromV20", "leakTrace", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "Ljava/util/List;", "getLeakTraces", "()Ljava/util/List;", "retainedHeapByteSize", "Ljava/lang/Integer;", "getShortDescription", "()Ljava/lang/String;", "shortDescription", "getSignature", SignatureFragment.SIGNATURE, "<init>", "(Ljava/util/List;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class ApplicationLeak extends Leak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29723a = new a(0);
    private static final long serialVersionUID = 524928276700576863L;

    @NotNull
    private final List<LeakTrace> c;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.al$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationLeak(@NotNull List<LeakTrace> list) {
        super((byte) 0);
        Intrinsics.checkNotNullParameter(list, "leakTraces");
        this.c = list;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    @NotNull
    public String a() {
        return ((LeakTrace) CollectionsKt.first(c())).c();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @NotNull
    public String b() throws NoWhenBranchMatchedException {
        LeakTrace leakTrace = (LeakTrace) CollectionsKt.first(c());
        LeakTraceReference leakTraceReference = (LeakTraceReference) SequencesKt.firstOrNull(leakTrace.b());
        if (leakTraceReference != null) {
            String str = leakTraceReference.originObject.a() + Consts.DOT + leakTraceReference.c();
            if (str != null) {
                return str;
            }
        }
        return leakTrace.c.b;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    @NotNull
    public List<LeakTrace> c() {
        return this.c;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            return (other instanceof ApplicationLeak) && Intrinsics.areEqual(c(), ((ApplicationLeak) other).c());
        }
        return true;
    }

    public int hashCode() {
        List<LeakTrace> listC = c();
        if (listC != null) {
            return listC.hashCode();
        }
        return 0;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    @NotNull
    public String toString() {
        return super.toString();
    }
}
