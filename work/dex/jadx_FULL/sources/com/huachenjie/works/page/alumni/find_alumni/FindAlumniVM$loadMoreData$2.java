package com.huachenjie.works.page.alumni.find_alumni;

import android.view.View;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.SchoolMateBean;
import huachenjie.sdk.http.PageEntity;
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
@DebugMetadata(c = "com.huachenjie.works.page.alumni.find_alumni.FindAlumniVM$loadMoreData$2", f = "FindAlumniVM.kt", i = {0}, l = {69}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class FindAlumniVM$loadMoreData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FindAlumniVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FindAlumniVM$loadMoreData$2(FindAlumniVM findAlumniVM, Continuation<? super FindAlumniVM$loadMoreData$2> continuation) {
        super(2, continuation);
        this.this$0 = findAlumniVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FindAlumniVM$loadMoreData$2 findAlumniVM$loadMoreData$2 = new FindAlumniVM$loadMoreData$2(this.this$0, continuation);
        findAlumniVM$loadMoreData$2.L$0 = obj;
        return findAlumniVM$loadMoreData$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BaseLoadMoreModule loadMoreModule;
        FindAlumniAdapter value;
        List<SchoolMateBean> data;
        BaseLoadMoreModule loadMoreModule2;
        BaseLoadMoreModule loadMoreModule3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            RequestModel requestModel = RequestModel.f36762a;
            int i2 = this.this$0.pageNum;
            String str = this.this$0.refreshTime;
            String str2 = this.this$0.selectedSex;
            String str3 = this.this$0.selectedGradeCode;
            List<String> list = this.this$0.selectedTagNoList;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = requestModel.y0(i2, str, str2, str3, list, this);
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
        boolean z = false;
        if (pageEntity == null) {
            FindAlumniVM findAlumniVM = this.this$0;
            if (findAlumniVM.pageNum == 1) {
                findAlumniVM.s().setValue(Boxing.boxBoolean(false));
            } else {
                FindAlumniAdapter value2 = findAlumniVM.q().getValue();
                if (value2 != null && (loadMoreModule3 = value2.getLoadMoreModule()) != null) {
                    loadMoreModule3.loadMoreFail();
                }
            }
            return Unit.INSTANCE;
        }
        this.this$0.refreshTime = pageEntity.getRefreshTime();
        if (this.this$0.pageNum == 1) {
            this.this$0.s().setValue(Boxing.boxBoolean(false));
            FindAlumniAdapter value3 = this.this$0.q().getValue();
            if (value3 != null) {
                value3.setList(pageEntity.getList());
            }
        } else {
            FindAlumniAdapter value4 = this.this$0.q().getValue();
            if (value4 != null) {
                List list2 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                value4.addData((Collection) list2);
            }
        }
        if (pageEntity.getHasNext()) {
            FindAlumniAdapter value5 = this.this$0.q().getValue();
            if (value5 != null && (loadMoreModule2 = value5.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            FindAlumniAdapter value6 = this.this$0.q().getValue();
            if (value6 != null && (loadMoreModule = value6.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        FindAlumniAdapter value7 = this.this$0.q().getValue();
        if (value7 != null && (data = value7.getData()) != null && data.size() == 0) {
            z = true;
        }
        if (z) {
            View view = this.this$0.emptyView;
            if (view != null && (value = this.this$0.q().getValue()) != null) {
                value.setEmptyView(view);
            }
        } else {
            FindAlumniAdapter value8 = this.this$0.q().getValue();
            if (value8 != null) {
                value8.removeEmptyView();
            }
        }
        this.this$0.pageNum++;
        return Unit.INSTANCE;
    }
}
