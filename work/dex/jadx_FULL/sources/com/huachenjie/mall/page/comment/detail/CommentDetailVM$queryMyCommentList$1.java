package com.huachenjie.mall.page.comment.detail;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.page.comment.list.CommodityCommentAdapter;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.comment.detail.CommentDetailVM$queryMyCommentList$1", f = "CommentDetailVM.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
public final class CommentDetailVM$queryMyCommentList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderNo;
    int label;
    final /* synthetic */ CommentDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentDetailVM$queryMyCommentList$1(String str, CommentDetailVM commentDetailVM, Continuation<? super CommentDetailVM$queryMyCommentList$1> continuation) {
        super(2, continuation);
        this.$orderNo = str;
        this.this$0 = commentDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentDetailVM$queryMyCommentList$1(this.$orderNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallModel mallModel = MallModel.f34763a;
            String str = this.$orderNo;
            this.label = 1;
            obj = mallModel.L(str, 1, "", this);
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
            return Unit.INSTANCE;
        }
        List list = pageEntity.getList();
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (z) {
            return Unit.INSTANCE;
        }
        CommodityCommentAdapter value = this.this$0.j().getValue();
        if (value != null) {
            value.setList(pageEntity.getList());
        }
        return Unit.INSTANCE;
    }
}
