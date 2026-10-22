package com.huachenjie.mine.page.home.post;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.mine.api.RequestModel;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mine.page.home.post.MyPostVM$queryPageList$2", f = "MyPostVM.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class MyPostVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MyPostVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyPostVM$queryPageList$2(MyPostVM myPostVM, Continuation<? super MyPostVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = myPostVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MyPostVM$queryPageList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f35285a;
            int pageNum = this.this$0.getPageNum();
            String refreshTime = this.this$0.getRefreshTime();
            this.label = 1;
            obj = requestModel.w(pageNum, refreshTime, this);
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
            pageEntity.setList(new ArrayList());
            pageEntity.setHasNext(false);
        }
        this.this$0.q(pageEntity.getRefreshTime());
        if (this.this$0.getPageNum() == 1) {
            this.this$0.l().setValue(Boxing.boxBoolean(false));
            if (pageEntity.getList() == null || pageEntity.getList().isEmpty()) {
                MyPostAdapter value = this.this$0.i().getValue();
                if (value != null) {
                    value.setList(null);
                }
                MyPostAdapter value2 = this.this$0.i().getValue();
                if (value2 != null) {
                    value2.i();
                }
            } else {
                MyPostAdapter value3 = this.this$0.i().getValue();
                if (value3 != null) {
                    value3.g();
                }
                MyPostAdapter value4 = this.this$0.i().getValue();
                if (value4 != null) {
                    value4.setList(pageEntity.getList());
                }
            }
        } else {
            List list = pageEntity.getList();
            if (list != null && (list.isEmpty() ^ true)) {
                MyPostAdapter value5 = this.this$0.i().getValue();
                if (value5 != null) {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    value5.addData((Collection) list2);
                }
            } else {
                MyPostVM myPostVM = this.this$0;
                myPostVM.p(myPostVM.getPageNum() - 1);
            }
        }
        if (pageEntity.getHasNext()) {
            MyPostAdapter value6 = this.this$0.i().getValue();
            if (value6 != null && (loadMoreModule2 = value6.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            MyPostAdapter value7 = this.this$0.i().getValue();
            if (value7 != null && (loadMoreModule = value7.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
