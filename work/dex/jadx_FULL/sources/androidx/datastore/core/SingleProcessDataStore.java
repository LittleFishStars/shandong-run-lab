package androidx.datastore.core;

import androidx.annotation.GuardedBy;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import com.alibaba.baichuan.log.TLogConstant;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.igexin.push.g.o;
import com.zj.adlib.jo2;
import com.zj.adlib.oj3;
import com.zj.adlib.tq1;
import com.zj.adlib.uq8;
import com.zj.adlib.uw8;
import com.zj.adlib.v41;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 F*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003FGHB\u007f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012?\b\u0002\u0010\b\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n0\t\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001f\u0010+\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00103\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00105\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00106\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00107\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00108\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104JL\u00109\u001a\u00028\u000021\u0010:\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\u0006\u0010<\u001a\u00020=H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010>JD\u0010?\u001a\u00028\u000021\u0010:\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001b\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00028\u0000H\u0080@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\f\u0010E\u001a\u00020\u0010*\u00020\u0005H\u0002R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0!X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'RJ\u0010*\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n\u0018\u00010\tX\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006I"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore;", "T", "Landroidx/datastore/core/DataStore;", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "corruptionHandler", "Landroidx/datastore/core/CorruptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/datastore/core/Serializer;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "SCRATCH_SUFFIX", "", "actor", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "downstreamFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/datastore/core/State;", "getDownstreamFlow$annotations", "()V", "file", "getFile", "()Ljava/io/File;", "file$delegate", "Lkotlin/Lazy;", "initTasks", "handleRead", OperatePopupWindow.h, "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Read;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUpdate", "update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInitOrPropagateAndThrowFailure", "readAndInitOrPropagateFailure", "readData", "readDataOrHandleCorruption", "transformAndWrite", "transform", "t", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateData", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "newData", "writeData$datastore_core", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "Companion", "Message", "UncloseableOutputStream", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SingleProcessDataStore<T> implements DataStore<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @GuardedBy("activeFilesLock")
    @NotNull
    private static final Set<String> activeFiles = new LinkedHashSet();

    @NotNull
    private static final Object activeFilesLock = new Object();

    @NotNull
    private final String SCRATCH_SUFFIX;

    @NotNull
    private final SimpleActor<Message<T>> actor;

    @NotNull
    private final CorruptionHandler<T> corruptionHandler;

    @NotNull
    private final Flow<T> data;

    @NotNull
    private final MutableStateFlow<State<T>> downstreamFlow;

    /* JADX INFO: renamed from: file$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy file;

    @Nullable
    private List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;

    @NotNull
    private final Function0<File> produceFile;

    @NotNull
    private final CoroutineScope scope;

    @NotNull
    private final Serializer<T> serializer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Companion;", "", "()V", "activeFiles", "", "", "getActiveFiles$datastore_core", "()Ljava/util/Set;", "activeFilesLock", "getActiveFilesLock$datastore_core", "()Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Set<String> getActiveFiles$datastore_core() {
            return SingleProcessDataStore.activeFiles;
        }

        @NotNull
        public final Object getActiveFilesLock$datastore_core() {
            return SingleProcessDataStore.activeFilesLock;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message;", "T", "", "()V", "lastState", "Landroidx/datastore/core/State;", "getLastState", "()Landroidx/datastore/core/State;", "Read", "Update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Message<T> {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "lastState", "Landroidx/datastore/core/State;", "(Landroidx/datastore/core/State;)V", "getLastState", "()Landroidx/datastore/core/State;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Read<T> extends Message<T> {

            @Nullable
            private final State<T> lastState;

            public Read(@Nullable State<T> state) {
                super(null);
                this.lastState = state;
            }

            @Override // androidx.datastore.core.SingleProcessDataStore.Message
            @Nullable
            public State<T> getLastState() {
                return this.lastState;
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002Ba\u00121\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016RA\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "ack", "Lkotlinx/coroutines/CompletableDeferred;", "lastState", "Landroidx/datastore/core/State;", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CompletableDeferred;Landroidx/datastore/core/State;Lkotlin/coroutines/CoroutineContext;)V", "getAck", "()Lkotlinx/coroutines/CompletableDeferred;", "getCallerContext", "()Lkotlin/coroutines/CoroutineContext;", "getLastState", "()Landroidx/datastore/core/State;", "getTransform", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Update<T> extends Message<T> {

            @NotNull
            private final CompletableDeferred<T> ack;

            @NotNull
            private final CoroutineContext callerContext;

            @Nullable
            private final State<T> lastState;

            @NotNull
            private final Function2<T, Continuation<? super T>, Object> transform;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Update(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull CompletableDeferred<T> completableDeferred, @Nullable State<T> state, @NotNull CoroutineContext coroutineContext) {
                super(null);
                Intrinsics.checkNotNullParameter(function2, "transform");
                Intrinsics.checkNotNullParameter(completableDeferred, "ack");
                Intrinsics.checkNotNullParameter(coroutineContext, "callerContext");
                this.transform = function2;
                this.ack = completableDeferred;
                this.lastState = state;
                this.callerContext = coroutineContext;
            }

            @NotNull
            public final CompletableDeferred<T> getAck() {
                return this.ack;
            }

            @NotNull
            public final CoroutineContext getCallerContext() {
                return this.callerContext;
            }

            @Override // androidx.datastore.core.SingleProcessDataStore.Message
            @Nullable
            public State<T> getLastState() {
                return this.lastState;
            }

            @NotNull
            public final Function2<T, Continuation<? super T>, Object> getTransform() {
                return this.transform;
            }
        }

        private Message() {
        }

        public /* synthetic */ Message(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public abstract State<T> getLastState();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$UncloseableOutputStream;", "Ljava/io/OutputStream;", "fileOutputStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;)V", "getFileOutputStream", "()Ljava/io/FileOutputStream;", "close", "", "flush", "write", "b", "", "bytes", TLogConstant.TLOG_MODULE_OFF, "", "len", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UncloseableOutputStream extends OutputStream {

        @NotNull
        private final FileOutputStream fileOutputStream;

        public UncloseableOutputStream(@NotNull FileOutputStream fileOutputStream) {
            Intrinsics.checkNotNullParameter(fileOutputStream, "fileOutputStream");
            this.fileOutputStream = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.fileOutputStream.flush();
        }

        @NotNull
        public final FileOutputStream getFileOutputStream() {
            return this.fileOutputStream;
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            this.fileOutputStream.write(b);
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] b) throws IOException {
            Intrinsics.checkNotNullParameter(b, "b");
            this.fileOutputStream.write(b);
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] bytes, int off, int len) throws IOException {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            this.fileOutputStream.write(bytes, off, len);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$handleUpdate$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {1, 1}, l = {276, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER}, m = "handleUpdate", n = {"update", "$this$handleUpdate_u24lambda_u2d0"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handleUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 1, 1, 1, 2}, l = {322, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 505}, m = "readAndInit", n = {"updateLock", "initData", "updateLock", "initData", "initializationComplete", "$this$withLock_u24default$iv"}, s = {"L$1", "L$2", "L$1", "L$2", "L$3", "L$3"})
    public static final class C13551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13551(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C13551> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInit(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {302}, m = "readAndInitOrPropagateAndThrowFailure", n = {"this"}, s = {"L$0"})
    public static final class C13561 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13561(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C13561> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateAndThrowFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {311}, m = "readAndInitOrPropagateFailure", n = {"this"}, s = {"L$0"})
    public static final class C13571 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13571(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C13571> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200}, m = "readData", n = {"this"}, s = {"L$0"})
    public static final class C13581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13581(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C13581> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readData(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 1, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME}, m = "readDataOrHandleCorruption", n = {"this", "ex", "ex", "newData"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C13591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13591(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C13591> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataOrHandleCorruption(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 0}, l = {402, 410}, m = "transformAndWrite", n = {"this", "curDataAndHash", "curData"}, s = {"L$0", "L$1", "L$2"})
    public static final class C13601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13601(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C13601> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.transformAndWrite(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SingleProcessDataStore(@NotNull Function0<? extends File> function0, @NotNull Serializer<T> serializer, @NotNull List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list, @NotNull CorruptionHandler<T> corruptionHandler, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(list, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.produceFile = function0;
        this.serializer = serializer;
        this.corruptionHandler = corruptionHandler;
        this.scope = coroutineScope;
        this.data = oj3.J0(new SingleProcessDataStore$data$1(this, null));
        this.SCRATCH_SUFFIX = ".tmp";
        this.file = LazyKt.lazy(new Function0<File>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$file$2
            final /* synthetic */ SingleProcessDataStore<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final File m27invoke() {
                File file = (File) ((SingleProcessDataStore) this.this$0).produceFile.invoke();
                String absolutePath = file.getAbsolutePath();
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.INSTANCE;
                synchronized (companion.getActiveFilesLock$datastore_core()) {
                    if (!(!companion.getActiveFiles$datastore_core().contains(absolutePath))) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    Set<String> activeFiles$datastore_core = companion.getActiveFiles$datastore_core();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, o.f);
                    activeFiles$datastore_core.add(absolutePath);
                }
                return file;
            }
        });
        this.downstreamFlow = uq8.a(UnInitialized.INSTANCE);
        this.initTasks = CollectionsKt.toList(list);
        this.actor = new SimpleActor<>(coroutineScope, new Function1<Throwable, Unit>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$actor$1
            final /* synthetic */ SingleProcessDataStore<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Throwable th) {
                if (th != null) {
                    ((SingleProcessDataStore) this.this$0).downstreamFlow.b(new Final(th));
                }
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.INSTANCE;
                Object activeFilesLock$datastore_core = companion.getActiveFilesLock$datastore_core();
                SingleProcessDataStore<T> singleProcessDataStore = this.this$0;
                synchronized (activeFilesLock$datastore_core) {
                    companion.getActiveFiles$datastore_core().remove(singleProcessDataStore.getFile().getAbsolutePath());
                    Unit unit = Unit.INSTANCE;
                }
            }
        }, new Function2<Message<T>, Throwable, Unit>() { // from class: androidx.datastore.core.SingleProcessDataStore$actor$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((SingleProcessDataStore.Message) obj, (Throwable) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SingleProcessDataStore.Message<T> message, @Nullable Throwable th) {
                Intrinsics.checkNotNullParameter(message, "msg");
                if (message instanceof SingleProcessDataStore.Message.Update) {
                    CompletableDeferred<T> ack = ((SingleProcessDataStore.Message.Update) message).getAck();
                    if (th == null) {
                        th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                    }
                    ack.c(th);
                }
            }
        }, new SingleProcessDataStore$actor$3(this, null));
    }

    private final void createParentDirectories(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(Intrinsics.stringPlus("Unable to create parent directories of ", file));
        }
    }

    private static /* synthetic */ void getDownstreamFlow$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getFile() {
        return (File) this.file.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleRead(Message.Read<T> read, Continuation<? super Unit> continuation) {
        State<T> state = (State) this.downstreamFlow.getValue();
        if (!(state instanceof Data)) {
            if (state instanceof ReadException) {
                if (state == read.getLastState()) {
                    Object andInitOrPropagateFailure = readAndInitOrPropagateFailure(continuation);
                    return andInitOrPropagateFailure == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? andInitOrPropagateFailure : Unit.INSTANCE;
                }
            } else {
                if (Intrinsics.areEqual(state, UnInitialized.INSTANCE)) {
                    Object andInitOrPropagateFailure2 = readAndInitOrPropagateFailure(continuation);
                    return andInitOrPropagateFailure2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? andInitOrPropagateFailure2 : Unit.INSTANCE;
                }
                if (state instanceof Final) {
                    throw new IllegalStateException("Can't read in final state.".toString());
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object handleUpdate(Message.Update<T> update, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        Message.Update<T> ack;
        SingleProcessDataStore<T> singleProcessDataStore;
        Object objTransformAndWrite;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, continuation);
        }
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        boolean z = true;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    update = (CompletableDeferred) anonymousClass1.L$0;
                } else if (i2 == 2) {
                    Message.Update<T> update2 = (CompletableDeferred) anonymousClass1.L$2;
                    singleProcessDataStore = (SingleProcessDataStore) anonymousClass1.L$1;
                    Message.Update<T> update3 = (Message.Update) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    ack = update2;
                    update = update3;
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    update = (CompletableDeferred) anonymousClass1.L$0;
                }
                ResultKt.throwOnFailure(obj2);
                obj = Result.constructor-impl(obj2);
                tq1.d(update, obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj2);
            ack = update.getAck();
            try {
                Result.Companion companion = Result.Companion;
                State<T> state = (State) this.downstreamFlow.getValue();
                if (state instanceof Data) {
                    Function2<? super T, ? super Continuation<? super T>, ? extends Object> transform = update.getTransform();
                    CoroutineContext callerContext = update.getCallerContext();
                    anonymousClass1.L$0 = ack;
                    anonymousClass1.label = 1;
                    objTransformAndWrite = transformAndWrite(transform, callerContext, anonymousClass1);
                    if (objTransformAndWrite == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(state instanceof ReadException)) {
                        z = state instanceof UnInitialized;
                    }
                    if (!z) {
                        if (state instanceof Final) {
                            throw ((Final) state).getFinalException();
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    if (state != update.getLastState()) {
                        throw ((ReadException) state).getReadException();
                    }
                    anonymousClass1.L$0 = update;
                    anonymousClass1.L$1 = this;
                    anonymousClass1.L$2 = ack;
                    anonymousClass1.label = 2;
                    if (readAndInitOrPropagateAndThrowFailure(anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    singleProcessDataStore = this;
                }
                Message.Update<T> update4 = ack;
                obj2 = objTransformAndWrite;
                update = update4;
                obj = Result.constructor-impl(obj2);
            } catch (Throwable th) {
                th = th;
                update = ack;
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            tq1.d(update, obj);
            return Unit.INSTANCE;
            Function2<? super T, ? super Continuation<? super T>, ? extends Object> transform2 = update.getTransform();
            CoroutineContext callerContext2 = update.getCallerContext();
            anonymousClass1.L$0 = ack;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 3;
            objTransformAndWrite = singleProcessDataStore.transformAndWrite(transform2, callerContext2, anonymousClass1);
            if (objTransformAndWrite == coroutine_suspended) {
                return coroutine_suspended;
            }
            Message.Update<T> update5 = ack;
            obj2 = objTransformAndWrite;
            update = update5;
            obj = Result.constructor-impl(obj2);
        } catch (Throwable th2) {
            th = th2;
        }
        tq1.d(update, obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:42:0x0116 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0117  */
    /* JADX WARN: Code duplicated, block: B:47:0x0128  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:? A[LOOP:0: B:34:0x00da->B:60:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readAndInit(Continuation<? super Unit> continuation) throws CorruptionException, FileNotFoundException {
        C13551 c13551;
        Mutex mutexB;
        Ref.ObjectRef objectRef;
        SingleProcessDataStore<T> singleProcessDataStore;
        Ref.ObjectRef objectRef2;
        SingleProcessDataStore<T> singleProcessDataStore2;
        Ref.ObjectRef objectRef3;
        SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1;
        Iterator<T> it;
        Mutex mutex;
        Ref.BooleanRef booleanRef;
        Mutex mutex2;
        SingleProcessDataStore<T> singleProcessDataStore3;
        Ref.ObjectRef objectRef4;
        Ref.BooleanRef booleanRef2;
        Function2 function2;
        if (continuation instanceof C13551) {
            c13551 = (C13551) continuation;
            int i = c13551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13551.label = i - Integer.MIN_VALUE;
            } else {
                c13551 = new C13551(this, continuation);
            }
        } else {
            c13551 = new C13551(this, continuation);
        }
        Object dataOrHandleCorruption = c13551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13551.label;
        if (i2 != 0) {
            if (i2 == 1) {
                objectRef = (Ref.ObjectRef) c13551.L$3;
                objectRef2 = (Ref.ObjectRef) c13551.L$2;
                mutexB = (Mutex) c13551.L$1;
                singleProcessDataStore = (SingleProcessDataStore) c13551.L$0;
                ResultKt.throwOnFailure(dataOrHandleCorruption);
            } else if (i2 == 2) {
                it = (Iterator) c13551.L$5;
                singleProcessDataStore$readAndInit$api$1 = (SingleProcessDataStore$readAndInit$api$1) c13551.L$4;
                booleanRef = (Ref.BooleanRef) c13551.L$3;
                objectRef3 = (Ref.ObjectRef) c13551.L$2;
                mutex = (Mutex) c13551.L$1;
                singleProcessDataStore2 = (SingleProcessDataStore) c13551.L$0;
                ResultKt.throwOnFailure(dataOrHandleCorruption);
                while (it.hasNext()) {
                    function2 = (Function2) it.next();
                    c13551.L$0 = singleProcessDataStore2;
                    c13551.L$1 = mutex;
                    c13551.L$2 = objectRef3;
                    c13551.L$3 = booleanRef;
                    c13551.L$4 = singleProcessDataStore$readAndInit$api$1;
                    c13551.L$5 = it;
                    c13551.label = 2;
                    if (function2.invoke(singleProcessDataStore$readAndInit$api$1, c13551) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                objectRef2 = objectRef3;
                mutex2 = mutex;
                singleProcessDataStore3 = singleProcessDataStore2;
                singleProcessDataStore3.initTasks = null;
                c13551.L$0 = singleProcessDataStore3;
                c13551.L$1 = objectRef2;
                c13551.L$2 = booleanRef;
                c13551.L$3 = mutex2;
                c13551.L$4 = null;
                c13551.L$5 = null;
                c13551.label = 3;
                if (mutex2.d((Object) null, c13551) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef4 = objectRef2;
                booleanRef2 = booleanRef;
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) c13551.L$3;
                booleanRef2 = (Ref.BooleanRef) c13551.L$2;
                objectRef4 = (Ref.ObjectRef) c13551.L$1;
                singleProcessDataStore3 = (SingleProcessDataStore) c13551.L$0;
                ResultKt.throwOnFailure(dataOrHandleCorruption);
            }
            try {
                booleanRef2.element = true;
                Unit unit = Unit.INSTANCE;
                mutex2.unlock((Object) null);
                MutableStateFlow<State<T>> mutableStateFlow = singleProcessDataStore3.downstreamFlow;
                Object obj = objectRef4.element;
                mutableStateFlow.b(new Data(obj, obj != null ? obj.hashCode() : 0));
                return unit;
            } catch (Throwable th) {
                mutex2.unlock((Object) null);
                throw th;
            }
        }
        ResultKt.throwOnFailure(dataOrHandleCorruption);
        if (!(Intrinsics.areEqual(this.downstreamFlow.getValue(), UnInitialized.INSTANCE) || (this.downstreamFlow.getValue() instanceof ReadException))) {
            throw new IllegalStateException("Check failed.".toString());
        }
        mutexB = MutexKt.b(false, 1, (Object) null);
        objectRef = new Ref.ObjectRef();
        c13551.L$0 = this;
        c13551.L$1 = mutexB;
        c13551.L$2 = objectRef;
        c13551.L$3 = objectRef;
        c13551.label = 1;
        dataOrHandleCorruption = readDataOrHandleCorruption(c13551);
        if (dataOrHandleCorruption == coroutine_suspended) {
            return coroutine_suspended;
        }
        singleProcessDataStore = this;
        objectRef2 = objectRef;
        objectRef.element = dataOrHandleCorruption;
        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$2 = new SingleProcessDataStore$readAndInit$api$1(mutexB, booleanRef3, objectRef2, singleProcessDataStore);
        List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list = singleProcessDataStore.initTasks;
        if (list == null) {
            mutex2 = mutexB;
            booleanRef = booleanRef3;
            singleProcessDataStore3 = singleProcessDataStore;
        } else {
            singleProcessDataStore2 = singleProcessDataStore;
            objectRef3 = objectRef2;
            singleProcessDataStore$readAndInit$api$1 = singleProcessDataStore$readAndInit$api$2;
            it = list.iterator();
            mutex = mutexB;
            booleanRef = booleanRef3;
            while (it.hasNext()) {
                function2 = (Function2) it.next();
                c13551.L$0 = singleProcessDataStore2;
                c13551.L$1 = mutex;
                c13551.L$2 = objectRef3;
                c13551.L$3 = booleanRef;
                c13551.L$4 = singleProcessDataStore$readAndInit$api$1;
                c13551.L$5 = it;
                c13551.label = 2;
                if (function2.invoke(singleProcessDataStore$readAndInit$api$1, c13551) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            objectRef2 = objectRef3;
            mutex2 = mutex;
            singleProcessDataStore3 = singleProcessDataStore2;
        }
        singleProcessDataStore3.initTasks = null;
        c13551.L$0 = singleProcessDataStore3;
        c13551.L$1 = objectRef2;
        c13551.L$2 = booleanRef;
        c13551.L$3 = mutex2;
        c13551.L$4 = null;
        c13551.L$5 = null;
        c13551.label = 3;
        if (mutex2.d((Object) null, c13551) == coroutine_suspended) {
            return coroutine_suspended;
        }
        objectRef4 = objectRef2;
        booleanRef2 = booleanRef;
        booleanRef2.element = true;
        Unit unit2 = Unit.INSTANCE;
        mutex2.unlock((Object) null);
        MutableStateFlow<State<T>> mutableStateFlow2 = singleProcessDataStore3.downstreamFlow;
        Object obj2 = objectRef4.element;
        mutableStateFlow2.b(new Data(obj2, obj2 != null ? obj2.hashCode() : 0));
        return unit2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readAndInitOrPropagateAndThrowFailure(Continuation<? super Unit> continuation) throws Throwable {
        C13561 c13561;
        SingleProcessDataStore<T> singleProcessDataStore;
        if (continuation instanceof C13561) {
            c13561 = (C13561) continuation;
            int i = c13561.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13561.label = i - Integer.MIN_VALUE;
            } else {
                c13561 = new C13561(this, continuation);
            }
        } else {
            c13561 = new C13561(this, continuation);
        }
        Object obj = c13561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13561.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            singleProcessDataStore = (SingleProcessDataStore) c13561.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                singleProcessDataStore.downstreamFlow.b(new ReadException(th));
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            c13561.L$0 = this;
            c13561.label = 1;
            if (readAndInit(c13561) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            singleProcessDataStore = this;
            singleProcessDataStore.downstreamFlow.b(new ReadException(th));
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readAndInitOrPropagateFailure(Continuation<? super Unit> continuation) {
        C13571 c13571;
        SingleProcessDataStore<T> singleProcessDataStore;
        if (continuation instanceof C13571) {
            c13571 = (C13571) continuation;
            int i = c13571.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13571.label = i - Integer.MIN_VALUE;
            } else {
                c13571 = new C13571(this, continuation);
            }
        } else {
            c13571 = new C13571(this, continuation);
        }
        Object obj = c13571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13571.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                c13571.L$0 = this;
                c13571.label = 1;
                if (readAndInit(c13571) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th) {
                th = th;
                singleProcessDataStore = this;
                singleProcessDataStore.downstreamFlow.b(new ReadException(th));
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            singleProcessDataStore = (SingleProcessDataStore) c13571.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                singleProcessDataStore.downstreamFlow.b(new ReadException(th));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.SingleProcessDataStore$readData$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream, java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.datastore.core.Serializer, androidx.datastore.core.Serializer<T>] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object readData(Continuation<? super T> continuation) throws FileNotFoundException {
        ?? c13581;
        ?? fileInputStream;
        Throwable th;
        ?? r2;
        if (continuation instanceof C13581) {
            C13581 c13582 = (C13581) continuation;
            int i = c13582.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13582.label = i - Integer.MIN_VALUE;
                c13581 = c13582;
            } else {
                c13581 = new C13581(this, continuation);
            }
        } else {
            c13581 = new C13581(this, continuation);
        }
        Object from = c13581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13581.label;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) c13581.L$2;
                fileInputStream = (Closeable) c13581.L$1;
                c13581 = (SingleProcessDataStore) c13581.L$0;
                try {
                    ResultKt.throwOnFailure(from);
                    r2 = fileInputStream;
                    CloseableKt.closeFinally((Closeable) r2, th);
                    return from;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally((Closeable) fileInputStream, th);
                        throw th3;
                    }
                }
            }
            ResultKt.throwOnFailure(from);
            try {
                fileInputStream = new FileInputStream(getFile());
                try {
                    Serializer<T> serializer = this.serializer;
                    c13581.L$0 = this;
                    c13581.L$1 = fileInputStream;
                    c13581.L$2 = null;
                    c13581.label = 1;
                    from = serializer.readFrom(fileInputStream, c13581);
                    if (from == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th = null;
                    r2 = fileInputStream;
                    CloseableKt.closeFinally((Closeable) r2, th);
                    return from;
                } catch (Throwable th4) {
                    th = th4;
                    c13581 = this;
                    throw th;
                }
            } catch (FileNotFoundException e) {
                e = e;
                c13581 = this;
                if (c13581.getFile().exists()) {
                    throw e;
                }
                return c13581.serializer.getDefaultValue();
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x0074 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readDataOrHandleCorruption(Continuation<? super T> continuation) throws CorruptionException, FileNotFoundException {
        C13591 c13591;
        SingleProcessDataStore singleProcessDataStore;
        Object objHandleCorruption;
        CorruptionException corruptionException;
        SingleProcessDataStore singleProcessDataStore2;
        CorruptionException corruptionException2;
        if (continuation instanceof C13591) {
            c13591 = (C13591) continuation;
            int i = c13591.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13591.label = i - Integer.MIN_VALUE;
            } else {
                c13591 = new C13591(this, continuation);
            }
        } else {
            c13591 = new C13591(this, continuation);
        }
        Object data = c13591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13591.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(data);
            try {
                c13591.L$0 = this;
                c13591.label = 1;
                data = readData(c13591);
                return data == coroutine_suspended ? coroutine_suspended : data;
            } catch (CorruptionException e) {
                e = e;
                singleProcessDataStore = this;
                CorruptionHandler<T> corruptionHandler = singleProcessDataStore.corruptionHandler;
                c13591.L$0 = singleProcessDataStore;
                c13591.L$1 = e;
                c13591.label = 2;
                objHandleCorruption = corruptionHandler.handleCorruption(e, c13591);
                if (objHandleCorruption == coroutine_suspended) {
                    return coroutine_suspended;
                }
                SingleProcessDataStore singleProcessDataStore3 = singleProcessDataStore;
                corruptionException = e;
                data = objHandleCorruption;
                singleProcessDataStore2 = singleProcessDataStore3;
                c13591.L$0 = corruptionException;
                c13591.L$1 = data;
                c13591.label = 3;
                if (singleProcessDataStore2.writeData$datastore_core(data, c13591) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return data;
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                corruptionException = (CorruptionException) c13591.L$1;
                SingleProcessDataStore singleProcessDataStore4 = (SingleProcessDataStore) c13591.L$0;
                ResultKt.throwOnFailure(data);
                singleProcessDataStore2 = singleProcessDataStore4;
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = c13591.L$1;
                corruptionException2 = (CorruptionException) c13591.L$0;
                try {
                    ResultKt.throwOnFailure(data);
                    return obj;
                } catch (IOException e2) {
                    e = e2;
                }
            }
            ExceptionsKt.addSuppressed(corruptionException2, e);
            throw corruptionException2;
        }
        singleProcessDataStore = (SingleProcessDataStore) c13591.L$0;
        try {
            ResultKt.throwOnFailure(data);
        } catch (CorruptionException e3) {
            e = e3;
            CorruptionHandler<T> corruptionHandler2 = singleProcessDataStore.corruptionHandler;
            c13591.L$0 = singleProcessDataStore;
            c13591.L$1 = e;
            c13591.label = 2;
            objHandleCorruption = corruptionHandler2.handleCorruption(e, c13591);
            if (objHandleCorruption == coroutine_suspended) {
                return coroutine_suspended;
            }
            SingleProcessDataStore singleProcessDataStore5 = singleProcessDataStore;
            corruptionException = e;
            data = objHandleCorruption;
            singleProcessDataStore2 = singleProcessDataStore5;
            c13591.L$0 = corruptionException;
            c13591.L$1 = data;
            c13591.label = 3;
            if (singleProcessDataStore2.writeData$datastore_core(data, c13591) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return data;
        }
        try {
            c13591.L$0 = corruptionException;
            c13591.L$1 = data;
            c13591.label = 3;
            if (singleProcessDataStore2.writeData$datastore_core(data, c13591) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return data;
        } catch (IOException e4) {
            e = e4;
            corruptionException2 = corruptionException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0094  */
    /* JADX WARN: Code duplicated, block: B:30:0x0099  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object transformAndWrite(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        Continuation<? super Unit> c13601;
        Data data;
        Object obj;
        SingleProcessDataStore singleProcessDataStore;
        SingleProcessDataStore singleProcessDataStore2;
        int iHashCode;
        if (continuation instanceof C13601) {
            c13601 = (C13601) continuation;
            int i = c13601.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13601.label = i - Integer.MIN_VALUE;
            } else {
                c13601 = new C13601(this, continuation);
            }
        } else {
            c13601 = new C13601(this, continuation);
        }
        Object obj2 = c13601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13601.label;
        if (i2 != 0) {
            if (i2 == 1) {
                obj = c13601.L$2;
                data = (Data) c13601.L$1;
                SingleProcessDataStore singleProcessDataStore3 = (SingleProcessDataStore) c13601.L$0;
                ResultKt.throwOnFailure(obj2);
                singleProcessDataStore = singleProcessDataStore3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = c13601.L$1;
                SingleProcessDataStore singleProcessDataStore4 = (SingleProcessDataStore) c13601.L$0;
                ResultKt.throwOnFailure(obj2);
                singleProcessDataStore2 = singleProcessDataStore4;
            }
            MutableStateFlow<State<T>> mutableStateFlow = singleProcessDataStore2.downstreamFlow;
            if (obj != null) {
                iHashCode = obj.hashCode();
            } else {
                iHashCode = 0;
            }
            mutableStateFlow.b(new Data(obj, iHashCode));
            return obj;
        }
        ResultKt.throwOnFailure(obj2);
        Data data2 = (Data) this.downstreamFlow.getValue();
        data2.checkHashCode();
        Object value = data2.getValue();
        SingleProcessDataStore$transformAndWrite$newData$1 singleProcessDataStore$transformAndWrite$newData$1 = new SingleProcessDataStore$transformAndWrite$newData$1(function2, value, null);
        c13601.L$0 = this;
        c13601.L$1 = data2;
        c13601.L$2 = value;
        c13601.label = 1;
        Object objH = v41.h(coroutineContext, singleProcessDataStore$transformAndWrite$newData$1, c13601);
        if (objH == coroutine_suspended) {
            return coroutine_suspended;
        }
        data = data2;
        obj2 = objH;
        obj = value;
        singleProcessDataStore = this;
        data.checkHashCode();
        if (!Intrinsics.areEqual(obj, obj2)) {
            c13601.L$0 = singleProcessDataStore;
            c13601.L$1 = obj2;
            c13601.L$2 = null;
            c13601.label = 2;
            if (singleProcessDataStore.writeData$datastore_core(obj2, c13601) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = obj2;
            singleProcessDataStore2 = singleProcessDataStore;
            MutableStateFlow<State<T>> mutableStateFlow2 = singleProcessDataStore2.downstreamFlow;
            if (obj != null) {
                iHashCode = obj.hashCode();
            } else {
                iHashCode = 0;
            }
            mutableStateFlow2.b(new Data(obj, iHashCode));
        }
        return obj;
    }

    @Override // androidx.datastore.core.DataStore
    @NotNull
    public Flow<T> getData() {
        return this.data;
    }

    @Override // androidx.datastore.core.DataStore
    @Nullable
    public Object updateData(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) throws Throwable {
        CompletableDeferred completableDeferredC = tq1.c((Job) null, 1, (Object) null);
        this.actor.offer(new Message.Update(function2, completableDeferredC, (State) this.downstreamFlow.getValue(), continuation.getContext()));
        return completableDeferredC.H(continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.StringBuilder] */
    @Nullable
    public final Object writeData$datastore_core(T t, @NotNull Continuation<? super Unit> continuation) throws IOException {
        SingleProcessDataStore$writeData$1 singleProcessDataStore$writeData$1;
        ?? file;
        ?? fileOutputStream;
        SingleProcessDataStore<T> singleProcessDataStore;
        ?? r8;
        Throwable th;
        if (continuation instanceof SingleProcessDataStore$writeData$1) {
            singleProcessDataStore$writeData$1 = (SingleProcessDataStore$writeData$1) continuation;
            int i = singleProcessDataStore$writeData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                singleProcessDataStore$writeData$1.label = i - Integer.MIN_VALUE;
            } else {
                singleProcessDataStore$writeData$1 = new SingleProcessDataStore$writeData$1(this, continuation);
            }
        } else {
            singleProcessDataStore$writeData$1 = new SingleProcessDataStore$writeData$1(this, continuation);
        }
        Object obj = singleProcessDataStore$writeData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = singleProcessDataStore$writeData$1.label;
        ?? r3 = 1;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                createParentDirectories(getFile());
                file = new File(Intrinsics.stringPlus(getFile().getAbsolutePath(), this.SCRATCH_SUFFIX));
                try {
                    fileOutputStream = new FileOutputStream((File) file);
                    try {
                        Serializer<T> serializer = this.serializer;
                        UncloseableOutputStream uncloseableOutputStream = new UncloseableOutputStream(fileOutputStream);
                        singleProcessDataStore$writeData$1.L$0 = this;
                        singleProcessDataStore$writeData$1.L$1 = file;
                        singleProcessDataStore$writeData$1.L$2 = fileOutputStream;
                        singleProcessDataStore$writeData$1.L$3 = null;
                        singleProcessDataStore$writeData$1.L$4 = fileOutputStream;
                        singleProcessDataStore$writeData$1.label = 1;
                        if (serializer.writeTo(t, uncloseableOutputStream, singleProcessDataStore$writeData$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        singleProcessDataStore = this;
                        r3 = file;
                        r8 = fileOutputStream;
                        th = null;
                        fileOutputStream = fileOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        r3 = file;
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    if (file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FileOutputStream fileOutputStream2 = (FileOutputStream) singleProcessDataStore$writeData$1.L$4;
                th = (Throwable) singleProcessDataStore$writeData$1.L$3;
                fileOutputStream = (Closeable) singleProcessDataStore$writeData$1.L$2;
                r3 = (File) singleProcessDataStore$writeData$1.L$1;
                singleProcessDataStore = (SingleProcessDataStore) singleProcessDataStore$writeData$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    fileOutputStream = fileOutputStream;
                    r3 = r3;
                    r8 = fileOutputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally((Closeable) fileOutputStream, th);
                        throw th4;
                    }
                }
            }
            r8.getFD().sync();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally((Closeable) fileOutputStream, th);
            if (r3.renameTo(singleProcessDataStore.getFile())) {
                return unit;
            }
            throw new IOException("Unable to rename " + r3 + ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
        } catch (IOException e2) {
            e = e2;
            file = r3;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SingleProcessDataStore(Function0 function0, Serializer serializer, List list, CorruptionHandler corruptionHandler, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        List listEmptyList = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
        CorruptionHandler noOpCorruptionHandler = (i & 8) != 0 ? new NoOpCorruptionHandler() : corruptionHandler;
        if ((i & 16) != 0) {
            jo2 jo2Var = jo2.a;
            coroutineScope = f.a(jo2.c().plus(uw8.c((Job) null, 1, (Object) null)));
        }
        this(function0, serializer, listEmptyList, noOpCorruptionHandler, coroutineScope);
    }
}
