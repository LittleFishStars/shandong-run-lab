package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bf, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\u0082\u0001\u0002\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/Leak;", "Ljava/io/Serializable;", "", "toString", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "getLeakTraces", "()Ljava/util/List;", "leakTraces", "getShortDescription", "()Ljava/lang/String;", "shortDescription", "getSignature", SignatureFragment.SIGNATURE, "", "getTotalRetainedHeapByteSize", "()Ljava/lang/Integer;", "totalRetainedHeapByteSize", "getTotalRetainedObjectCount", "totalRetainedObjectCount", "<init>", "()V", "Companion", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class Leak implements Serializable {

    @NotNull
    public static final a b = new a(0);
    private static final long serialVersionUID = -2287572510360910916L;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bf$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/Leak$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private Leak() {
    }

    @NotNull
    public abstract String a();

    @NotNull
    public abstract List<LeakTrace> c();

    @Nullable
    public final Integer d() {
        if (((LeakTrace) CollectionsKt.first(c())).a() == null) {
            return null;
        }
        Iterator<T> it = c().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            Integer numA = ((LeakTrace) it.next()).a();
            Intrinsics.checkNotNull(numA);
            iIntValue += numA.intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (d() != null) {
            str = d() + " bytes retained by leaking objects\n";
        } else {
            str = "";
        }
        sb.append(str);
        if (c().size() > 1) {
            str2 = "Displaying only 1 leak trace out of " + c().size() + " with the same signature\n";
        }
        sb.append(str2);
        sb.append("Signature: ");
        sb.append(a());
        sb.append('\n');
        sb.append((LeakTrace) CollectionsKt.first(c()));
        return sb.toString();
    }

    public /* synthetic */ Leak(byte b2) {
        this();
    }
}
