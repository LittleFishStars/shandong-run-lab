package com.huachenjie.mall.dialog.poster;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.PosterBackgroundBean;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.dialog.poster.CreatePosterVM$queryPosterBgList$1", f = "CreatePosterVM.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class CreatePosterVM$queryPosterBgList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreatePosterVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreatePosterVM$queryPosterBgList$1(CreatePosterVM createPosterVM, Continuation<? super CreatePosterVM$queryPosterBgList$1> continuation) {
        super(2, continuation);
        this.this$0 = createPosterVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CreatePosterVM$queryPosterBgList$1(this.this$0, continuation);
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
            MallModel mallModel = MallModel.f34763a;
            this.label = 1;
            obj = mallModel.U(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        if (pageEntity == null) {
            pageEntity = new PageEntity();
            pageEntity.setList(CollectionsKt.emptyList());
            pageEntity.setHasNext(false);
        }
        PosterBgAdapter value = this.this$0.i().getValue();
        if (value != null) {
            value.setList(pageEntity.getList());
        }
        List list = pageEntity.getList();
        Intrinsics.checkNotNullExpressionValue(list, "data.list");
        if (!list.isEmpty()) {
            PosterBackgroundBean posterBackgroundBean = (PosterBackgroundBean) pageEntity.getList().get(0);
            this.this$0.n().setValue(posterBackgroundBean.getPosterUrl());
            PosterBgAdapter value2 = this.this$0.i().getValue();
            if (value2 != null) {
                value2.e(posterBackgroundBean.getPosterNo());
            }
        }
        return Unit.INSTANCE;
    }
}
