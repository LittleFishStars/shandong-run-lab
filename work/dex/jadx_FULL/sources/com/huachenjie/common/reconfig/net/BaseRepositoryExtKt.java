package com.huachenjie.common.reconfig.net;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.zj.adlib.jo2;
import com.zj.adlib.oj3;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aO\u0010\b\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0097\u0001\u0010\u0010\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"S", "T", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/huachenjie/common/reconfig/net/IResponse;", "", "block", "a", "(Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException$ApiException;", "", "onApiError", "Lcom/huachenjie/common/reconfig/net/exception/ResultException$NetException;", "onNetError", "onSuccess", "b", "(Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBaseRepositoryExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseRepositoryExt.kt\ncom/huachenjie/common/reconfig/net/BaseRepositoryExtKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,58:1\n53#2:59\n55#2:63\n53#2:64\n55#2:68\n50#3:60\n55#3:62\n50#3:65\n55#3:67\n106#4:61\n106#4:66\n*S KotlinDebug\n*F\n+ 1 BaseRepositoryExt.kt\ncom/huachenjie/common/reconfig/net/BaseRepositoryExtKt\n*L\n20#1:59\n20#1:63\n44#1:64\n44#1:68\n20#1:60\n20#1:62\n44#1:65\n44#1:67\n20#1:61\n44#1:66\n*E\n"})
public final class BaseRepositoryExtKt {

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "S", "T", o.f, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<T, Unit> f33867a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super T, Unit> function1) {
            this.f33867a = function1;
        }

        @Nullable
        public final Object emit(@Nullable T t, @NotNull Continuation<? super Unit> continuation) {
            Function1<T, Unit> function1 = this.f33867a;
            if (function1 != null) {
                function1.invoke(t);
            }
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public static final <S, T> Object a(@NotNull BaseRepository<S> baseRepository, @NotNull Function1<? super Continuation<? super IResponse<T>>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        final Flow flowO0 = oj3.O0(oj3.J0(new BaseRepositoryExtKt$request$2(function1, null)), jo2.c());
        return oj3.J1(new Flow<T>() { // from class: com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$request$$inlined$map$1

            /* JADX INFO: renamed from: com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$request$$inlined$map$1$2, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BaseRepositoryExt.kt\ncom/huachenjie/common/reconfig/net/BaseRepositoryExtKt\n*L\n1#1,222:1\n54#2:223\n21#3,4:224\n*E\n"})
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f33869a;

                /* JADX INFO: renamed from: com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$request$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$request$$inlined$map$1$2", f = "BaseRepositoryExt.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f33869a = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Nullable
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.f33869a;
                        IResponse iResponse = (IResponse) obj;
                        if (!iResponse.isSuccess()) {
                            throw new ResultException.ApiException(iResponse.getResponseCode(), iResponse.getResponseMsg());
                        }
                        Object responseData = iResponse.getResponseData();
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(responseData, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Nullable
            public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation2) {
                Object objCollect = flowO0.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, continuation);
    }

    @Nullable
    public static final <S, T> Object b(@NotNull BaseRepository<S> baseRepository, @NotNull Function1<? super Continuation<? super IResponse<T>>, ? extends Object> function1, @Nullable Function1<? super ResultException.ApiException, Unit> function2, @Nullable Function1<? super ResultException.NetException, Unit> function3, @Nullable Function1<? super T, Unit> function4, @NotNull Continuation<? super Unit> continuation) {
        final Flow flowO0 = oj3.O0(oj3.J0(new BaseRepositoryExtKt$requestCatching$2(function1, null)), jo2.c());
        Object objCollect = oj3.u(new Flow<T>() { // from class: com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$requestCatching$$inlined$map$1

            /* JADX INFO: renamed from: com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$requestCatching$$inlined$map$1$2, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BaseRepositoryExt.kt\ncom/huachenjie/common/reconfig/net/BaseRepositoryExtKt\n*L\n1#1,222:1\n54#2:223\n45#3,4:224\n*E\n"})
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f33871a;

                /* JADX INFO: renamed from: com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$requestCatching$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$requestCatching$$inlined$map$1$2", f = "BaseRepositoryExt.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f33871a = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Nullable
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.f33871a;
                        IResponse iResponse = (IResponse) obj;
                        if (!iResponse.isSuccess()) {
                            throw new ResultException.ApiException(iResponse.getResponseCode(), iResponse.getResponseMsg());
                        }
                        Object responseData = iResponse.getResponseData();
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(responseData, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Nullable
            public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation2) {
                Object objCollect2 = flowO0.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect2 : Unit.INSTANCE;
            }
        }, new BaseRepositoryExtKt$requestCatching$4(function2, function3, null)).collect(new a(function4), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
