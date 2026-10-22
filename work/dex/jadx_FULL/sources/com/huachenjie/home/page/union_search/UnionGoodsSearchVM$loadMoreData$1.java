package com.huachenjie.home.page.union_search;

import com.huachenjie.ad.util.OAIDUtil;
import com.huachenjie.home.api.HomeRequest;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.page.union_search.UnionGoodsSearchVM$loadMoreData$1", f = "UnionGoodsSearchVM.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
public final class UnionGoodsSearchVM$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UnionGoodsSearchVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnionGoodsSearchVM$loadMoreData$1(UnionGoodsSearchVM unionGoodsSearchVM, Continuation<? super UnionGoodsSearchVM$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = unionGoodsSearchVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnionGoodsSearchVM$loadMoreData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HomeRequest homeRequest = HomeRequest.f34197a;
            String value = this.this$0.C().getValue();
            if (value == null) {
                value = "";
            }
            int pageNum = this.this$0.getPageNum();
            String str = OAIDUtil.com.kc.openset.constant.DeviceIdType.OAID java.lang.String;
            String str2 = str != null ? str : "";
            this.label = 1;
            obj = homeRequest.x(value, pageNum, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity<?> pageEntity = (PageEntity) obj;
        if (pageEntity == null) {
            return Unit.INSTANCE;
        }
        if (pageEntity.getHasNext()) {
            List list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "pageEntity.list");
            z = list.isEmpty() ^ true;
        }
        pageEntity.setHasNext(z);
        this.this$0.u().setValue(pageEntity);
        return Unit.INSTANCE;
    }
}
