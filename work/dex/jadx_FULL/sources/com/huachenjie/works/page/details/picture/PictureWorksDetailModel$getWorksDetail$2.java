package com.huachenjie.works.page.details.picture;

import com.huachenjie.base.util.rich_text.RichTextUtils;
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
@DebugMetadata(c = "com.huachenjie.works.page.details.picture.PictureWorksDetailModel$getWorksDetail$2", f = "PictureWorksDetailModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
public final class PictureWorksDetailModel$getWorksDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $worksNo;
    int label;
    final /* synthetic */ PictureWorksDetailModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureWorksDetailModel$getWorksDetail$2(String str, PictureWorksDetailModel pictureWorksDetailModel, Continuation<? super PictureWorksDetailModel$getWorksDetail$2> continuation) {
        super(2, continuation);
        this.$worksNo = str;
        this.this$0 = pictureWorksDetailModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PictureWorksDetailModel$getWorksDetail$2(this.$worksNo, this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f36762a;
            String str = this.$worksNo;
            this.label = 1;
            obj = requestModel.K0(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        WorkDetailBean workDetailBean = (WorkDetailBean) obj;
        if (workDetailBean == null) {
            return Unit.INSTANCE;
        }
        workDetailBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, workDetailBean.getContent(), 0, 2, null));
        this.this$0.m().setValue(workDetailBean);
        return Unit.INSTANCE;
    }
}
