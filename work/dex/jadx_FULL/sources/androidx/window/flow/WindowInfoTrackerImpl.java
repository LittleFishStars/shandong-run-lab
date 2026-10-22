package androidx.window.flow;

import android.app.Activity;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.zj.adlib.oj3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/WindowInfoTracker;", "windowMetricsCalculator", "Landroidx/window/layout/WindowMetricsCalculator;", "windowBackend", "Landroidx/window/layout/WindowBackend;", "(Landroidx/window/layout/WindowMetricsCalculator;Landroidx/window/layout/WindowBackend;)V", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "Companion", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;

    @NotNull
    private final WindowBackend windowBackend;

    @NotNull
    private final WindowMetricsCalculator windowMetricsCalculator;

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1, reason: from Kotlin metadata */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/window/layout/WindowLayoutInfo;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {0, 0, 1, 1}, l = {54, 55}, m = "invokeSuspend", n = {"$this$flow", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "$this$flow", ServiceSpecificExtraArgs.CastExtraArgs.f31291a}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class FlowCollector extends SuspendLambda implements Function2<kotlinx.coroutines.flow.FlowCollector<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FlowCollector(Activity activity, Continuation<? super FlowCollector> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        public static final void m78invokeSuspend$lambda0(Channel channel, WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullExpressionValue(windowLayoutInfo, AliyunLogCommon.LogLevel.INFO);
            channel.o(windowLayoutInfo);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            FlowCollector flowCollector = WindowInfoTrackerImpl.this.new FlowCollector(this.$activity, continuation);
            flowCollector.L$0 = obj;
            return flowCollector;
        }

        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.flow.FlowCollector<? super WindowLayoutInfo> flowCollector, @Nullable Continuation<? super Unit> continuation) {
            return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0072 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x0073  */
        /* JADX WARN: Code duplicated, block: B:23:0x007e A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:17:0x0064, B:21:0x0076, B:23:0x007e), top: B:35:0x0064 }] */
        /* JADX WARN: Code duplicated, block: B:25:0x0092 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x0093  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0093 -> B:35:0x0064). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L39
                if (r1 == r3) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r1 = r9.L$2
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r9.L$1
                androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
                java.lang.Object r5 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> La3
                r10 = r5
                goto L63
            L1f:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L27:
                java.lang.Object r1 = r9.L$2
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r9.L$1
                androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
                java.lang.Object r5 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> La3
                r6 = r5
                r5 = r9
                goto L76
            L39:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
                r4 = 4
                r5 = 10
                r6 = 0
                kotlinx.coroutines.channels.Channel r1 = kotlinx.coroutines.channels.c.d(r5, r1, r6, r4, r6)
                androidx.window.layout.a r4 = new androidx.window.layout.a
                r4.<init>()
                androidx.window.layout.WindowInfoTrackerImpl r5 = androidx.window.flow.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r5 = androidx.window.flow.WindowInfoTrackerImpl.access$getWindowBackend$p(r5)
                android.app.Activity r6 = r9.$activity
                com.zj.adlib.z07 r7 = new com.zj.adlib.z07
                r7.<init>()
                r5.registerLayoutChangeCallback(r6, r7, r4)
                kotlinx.coroutines.channels.ChannelIterator r1 = r1.B()     // Catch: java.lang.Throwable -> La3
            L63:
                r5 = r9
            L64:
                r5.L$0 = r10     // Catch: java.lang.Throwable -> La1
                r5.L$1 = r4     // Catch: java.lang.Throwable -> La1
                r5.L$2 = r1     // Catch: java.lang.Throwable -> La1
                r5.label = r3     // Catch: java.lang.Throwable -> La1
                java.lang.Object r6 = r1.h(r5)     // Catch: java.lang.Throwable -> La1
                if (r6 != r0) goto L73
                return r0
            L73:
                r8 = r6
                r6 = r10
                r10 = r8
            L76:
                java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> La1
                boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> La1
                if (r10 == 0) goto L95
                java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> La1
                androidx.window.layout.WindowLayoutInfo r10 = (androidx.window.flow.WindowLayoutInfo) r10     // Catch: java.lang.Throwable -> La1
                r5.L$0 = r6     // Catch: java.lang.Throwable -> La1
                r5.L$1 = r4     // Catch: java.lang.Throwable -> La1
                r5.L$2 = r1     // Catch: java.lang.Throwable -> La1
                r5.label = r2     // Catch: java.lang.Throwable -> La1
                java.lang.Object r10 = r6.emit(r10, r5)     // Catch: java.lang.Throwable -> La1
                if (r10 != r0) goto L93
                return r0
            L93:
                r10 = r6
                goto L64
            L95:
                androidx.window.layout.WindowInfoTrackerImpl r10 = androidx.window.flow.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r10 = androidx.window.flow.WindowInfoTrackerImpl.access$getWindowBackend$p(r10)
                r10.unregisterLayoutChangeCallback(r4)
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            La1:
                r10 = move-exception
                goto La5
            La3:
                r10 = move-exception
                r5 = r9
            La5:
                androidx.window.layout.WindowInfoTrackerImpl r0 = androidx.window.flow.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r0 = androidx.window.flow.WindowInfoTrackerImpl.access$getWindowBackend$p(r0)
                r0.unregisterLayoutChangeCallback(r4)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.flow.WindowInfoTrackerImpl.FlowCollector.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public WindowInfoTrackerImpl(@NotNull WindowMetricsCalculator windowMetricsCalculator, @NotNull WindowBackend windowBackend) {
        Intrinsics.checkNotNullParameter(windowMetricsCalculator, "windowMetricsCalculator");
        Intrinsics.checkNotNullParameter(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.flow.WindowInfoTracker
    @NotNull
    public Flow<WindowLayoutInfo> windowLayoutInfo(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        return oj3.J0(new FlowCollector(activity, null));
    }
}
