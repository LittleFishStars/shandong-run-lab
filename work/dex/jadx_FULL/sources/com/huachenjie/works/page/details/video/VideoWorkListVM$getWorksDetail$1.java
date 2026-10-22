package com.huachenjie.works.page.details.video;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.WorkDetailBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.details.video.VideoWorkListVM$getWorksDetail$1", f = "VideoWorkListVM.kt", i = {}, l = {56, 57}, m = "invokeSuspend", n = {}, s = {})
public final class VideoWorkListVM$getWorksDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $worksNo;
    int label;
    final /* synthetic */ VideoWorkListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoWorkListVM$getWorksDetail$1(String str, VideoWorkListVM videoWorkListVM, Continuation<? super VideoWorkListVM$getWorksDetail$1> continuation) {
        super(2, continuation);
        this.$worksNo = str;
        this.this$0 = videoWorkListVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VideoWorkListVM$getWorksDetail$1(this.$worksNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objK0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                objK0 = obj;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        RequestModel requestModel = RequestModel.f36762a;
        String str = this.$worksNo;
        this.label = 1;
        objK0 = requestModel.K0(str, this);
        if (objK0 == coroutine_suspended) {
            return coroutine_suspended;
        }
        WorkDetailBean workDetailBean = (WorkDetailBean) objK0;
        if (workDetailBean == null) {
            workDetailBean = new WorkDetailBean(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, null, false, false, 0, null, null, 33554431, null);
        }
        VideoWorkListVM videoWorkListVM = this.this$0;
        this.label = 2;
        if (videoWorkListVM.k(workDetailBean, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
