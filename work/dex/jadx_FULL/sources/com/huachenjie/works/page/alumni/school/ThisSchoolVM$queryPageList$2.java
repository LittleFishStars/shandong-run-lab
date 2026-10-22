package com.huachenjie.works.page.alumni.school;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.page.campus_wall.post.PostAdapter;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.alumni.school.ThisSchoolVM$queryPageList$2", f = "ThisSchoolVM.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
public final class ThisSchoolVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ThisSchoolVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThisSchoolVM$queryPageList$2(ThisSchoolVM thisSchoolVM, Continuation<? super ThisSchoolVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = thisSchoolVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ThisSchoolVM$queryPageList$2(this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f36762a;
            int pageNum = this.this$0.getPageNum();
            String refreshTime = this.this$0.getRefreshTime();
            String value = this.this$0.s().getValue();
            this.label = 1;
            obj = requestModel.i0(pageNum, refreshTime, (12 & 4) != 0 ? null : null, (12 & 8) != 0 ? null : null, (12 & 16) != 0 ? null : value, this);
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
        this.this$0.F(pageEntity.getRefreshTime());
        if (this.this$0.getPageNum() == 1) {
            this.this$0.v().setValue(Boxing.boxBoolean(false));
            if (pageEntity.getList() == null || pageEntity.getList().isEmpty()) {
                PostAdapter value2 = this.this$0.k().getValue();
                if (value2 != null) {
                    value2.setList(null);
                }
                PostAdapter value3 = this.this$0.k().getValue();
                if (value3 != null) {
                    value3.p();
                }
            } else {
                PostAdapter value4 = this.this$0.k().getValue();
                if (value4 != null) {
                    value4.n();
                }
                PostAdapter value5 = this.this$0.k().getValue();
                if (value5 != null) {
                    value5.setList(pageEntity.getList());
                }
            }
        } else {
            List list = pageEntity.getList();
            if (list != null && (list.isEmpty() ^ true)) {
                PostAdapter value6 = this.this$0.k().getValue();
                if (value6 != null) {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    value6.addData((Collection) list2);
                }
            } else {
                ThisSchoolVM thisSchoolVM = this.this$0;
                thisSchoolVM.E(thisSchoolVM.getPageNum() - 1);
            }
        }
        if (pageEntity.getHasNext()) {
            PostAdapter value7 = this.this$0.k().getValue();
            if (value7 != null && (loadMoreModule2 = value7.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            PostAdapter value8 = this.this$0.k().getValue();
            if (value8 != null && (loadMoreModule = value8.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
