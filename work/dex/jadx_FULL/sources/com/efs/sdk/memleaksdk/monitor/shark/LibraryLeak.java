package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bm, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001*B%\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010\u000e\u001a\u00020\rHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0002HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0002HÆ\u0001J\u000f\u0010\u0016\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0019R\u0014\u0010'\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0019¨\u0006+"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak;", "Lcom/efs/sdk/memleaksdk/monitor/shark/Leak;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "component1", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "component2", "component3", "leakTraces", "pattern", "description", OperatePopupWindow.g, "leakTraceFromV20$memleaksdk_release", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "leakTraceFromV20", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "leakTrace", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "Ljava/util/List;", "getLeakTraces", "()Ljava/util/List;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "getPattern", "()Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "retainedHeapByteSize", "Ljava/lang/Integer;", "getShortDescription", "shortDescription", "getSignature", SignatureFragment.SIGNATURE, "<init>", "(Ljava/util/List;Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;Ljava/lang/String;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LibraryLeak extends Leak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29805a = new a(0);
    private static final long serialVersionUID = 3943636164568681903L;

    @NotNull
    private final List<LeakTrace> c;

    @NotNull
    private final ReferencePattern d;

    @NotNull
    private final String e;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bm$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryLeak(@NotNull List<LeakTrace> list, @NotNull ReferencePattern referencePattern, @NotNull String str) {
        super((byte) 0);
        Intrinsics.checkNotNullParameter(list, "leakTraces");
        Intrinsics.checkNotNullParameter(referencePattern, "pattern");
        Intrinsics.checkNotNullParameter(str, "description");
        this.c = list;
        this.d = referencePattern;
        this.e = str;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    @NotNull
    public String a() {
        return ct.a(this.d.toString());
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    @NotNull
    public List<LeakTrace> c() {
        return this.c;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryLeak)) {
            return false;
        }
        LibraryLeak libraryLeak = (LibraryLeak) other;
        return Intrinsics.areEqual(c(), libraryLeak.c()) && Intrinsics.areEqual(this.d, libraryLeak.d) && Intrinsics.areEqual(this.e, libraryLeak.e);
    }

    public int hashCode() {
        List<LeakTrace> listC = c();
        int iHashCode = (listC != null ? listC.hashCode() : 0) * 31;
        ReferencePattern referencePattern = this.d;
        int iHashCode2 = (iHashCode + (referencePattern != null ? referencePattern.hashCode() : 0)) * 31;
        String str = this.e;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    @NotNull
    public String toString() {
        return "Leak pattern: " + this.d + "\nDescription: " + this.e + '\n' + super.toString() + '\n';
    }
}
