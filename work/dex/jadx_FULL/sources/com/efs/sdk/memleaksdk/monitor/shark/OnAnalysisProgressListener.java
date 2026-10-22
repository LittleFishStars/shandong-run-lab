package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bp, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Step;", "step", "", "onAnalysisProgress", "Companion", "Step", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public interface OnAnalysisProgressListener {

    @NotNull
    public static final a b = a.f29808a;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bp$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\u00042\u0014\b\u0004\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0086\nø\u0001\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Companion;", "", "()V", "NO_OP", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", "getNO_OP", "()Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", BridgeDSL.INVOKE, "block", "Lkotlin/Function1;", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Step;", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f29808a = new a();

        @NotNull
        private static final OnAnalysisProgressListener b = C0629a.f29809a;

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bp$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Step;", o.f, "", "onAnalysisProgress", "(Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Step;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        public static final class C0629a implements OnAnalysisProgressListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0629a f29809a = new C0629a();

            @Override // com.efs.sdk.memleaksdk.monitor.shark.OnAnalysisProgressListener
            public final void a(@NotNull b bVar) {
                Intrinsics.checkNotNullParameter(bVar, o.f);
            }
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bp$b */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Step;", "", "<init>", "(Ljava/lang/String;I)V", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum b {
        PARSING_HEAP_DUMP,
        EXTRACTING_METADATA,
        FINDING_RETAINED_OBJECTS,
        FINDING_PATHS_TO_RETAINED_OBJECTS,
        FINDING_DOMINATORS,
        INSPECTING_OBJECTS,
        COMPUTING_NATIVE_RETAINED_SIZE,
        COMPUTING_RETAINED_SIZE,
        BUILDING_LEAK_TRACES,
        REPORTING_HEAP_ANALYSIS
    }

    void a(@NotNull b bVar);
}
