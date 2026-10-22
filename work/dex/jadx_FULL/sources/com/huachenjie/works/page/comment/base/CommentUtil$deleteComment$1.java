package com.huachenjie.works.page.comment.base;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.works.page.comment.report.CommentOptVM;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.comment.base.CommentUtil$deleteComment$1", f = "CommentUtil.kt", i = {}, l = {225}, m = "invokeSuspend", n = {}, s = {})
public final class CommentUtil$deleteComment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $commentNo;
    final /* synthetic */ int $commentType;
    final /* synthetic */ CommentOptVM $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentUtil$deleteComment$1(int i, String str, CommentOptVM commentOptVM, Continuation<? super CommentUtil$deleteComment$1> continuation) {
        super(2, continuation);
        this.$commentType = i;
        this.$commentNo = str;
        this.$viewModel = commentOptVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentUtil$deleteComment$1(this.$commentType, this.$commentNo, this.$viewModel, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        JSONObject jSONObject;
        int intValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2D = CommentDelegate.f37252a.d(this.$commentType);
            if (function2D != null) {
                String str = this.$commentNo;
                this.label = 1;
                obj = function2D.invoke(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                jSONObject = null;
            }
            MutableLiveData<Integer> mutableLiveDataJ = this.$viewModel.j();
            if (jSONObject != null) {
                intValue = jSONObject.getIntValue("removeNums");
            } else {
                intValue = 0;
            }
            mutableLiveDataJ.setValue(Boxing.boxInt(intValue));
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        jSONObject = (JSONObject) obj;
        MutableLiveData<Integer> mutableLiveDataJ2 = this.$viewModel.j();
        if (jSONObject != null) {
            intValue = jSONObject.getIntValue("removeNums");
        } else {
            intValue = 0;
        }
        mutableLiveDataJ2.setValue(Boxing.boxInt(intValue));
        return Unit.INSTANCE;
    }
}
