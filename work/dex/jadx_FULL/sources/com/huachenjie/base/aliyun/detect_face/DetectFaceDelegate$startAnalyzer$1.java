package com.huachenjie.base.aliyun.detect_face;

import com.huachenjie.base.bean.RunFaceDetectStatus;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/ResultException;", o.f, "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$startAnalyzer$1", f = "DetectFaceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DetectFaceDelegate$startAnalyzer$1 extends SuspendLambda implements Function2<ResultException, Continuation<? super Boolean>, Object> {
    final /* synthetic */ RunFaceDetectStatus $detectStatus;
    int label;
    final /* synthetic */ DetectFaceDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectFaceDelegate$startAnalyzer$1(DetectFaceDelegate detectFaceDelegate, RunFaceDetectStatus runFaceDetectStatus, Continuation<? super DetectFaceDelegate$startAnalyzer$1> continuation) {
        super(2, continuation);
        this.this$0 = detectFaceDelegate;
        this.$detectStatus = runFaceDetectStatus;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DetectFaceDelegate$startAnalyzer$1(this.this$0, this.$detectStatus, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull ResultException resultException, @Nullable Continuation<? super Boolean> continuation) {
        return create(resultException, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.t(this.$detectStatus);
        this.this$0.v(false);
        return Boxing.boxBoolean(false);
    }
}
