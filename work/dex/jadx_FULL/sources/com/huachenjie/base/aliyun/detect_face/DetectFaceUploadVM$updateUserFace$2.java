package com.huachenjie.base.aliyun.detect_face;

import com.huachenjie.base.api.RequestModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceUploadVM$updateUserFace$2", f = "DetectFaceUploadVM.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
public final class DetectFaceUploadVM$updateUserFace$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $faceImg;
    int label;
    final /* synthetic */ DetectFaceUploadVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectFaceUploadVM$updateUserFace$2(String str, DetectFaceUploadVM detectFaceUploadVM, Continuation<? super DetectFaceUploadVM$updateUserFace$2> continuation) {
        super(2, continuation);
        this.$faceImg = str;
        this.this$0 = detectFaceUploadVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DetectFaceUploadVM$updateUserFace$2(this.$faceImg, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f32789a;
            String str = this.$faceImg;
            this.label = 1;
            if (requestModel.s(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.c();
        this.this$0.j().setValue(this.$faceImg);
        return Unit.INSTANCE;
    }
}
