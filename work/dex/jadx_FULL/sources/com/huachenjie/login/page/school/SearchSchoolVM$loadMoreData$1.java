package com.huachenjie.login.page.school;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.SearchSchoolInfoBean;
import java.util.Collection;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.login.page.school.SearchSchoolVM$loadMoreData$1", f = "SearchSchoolVM.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class SearchSchoolVM$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $textValue;
    int label;
    final /* synthetic */ SearchSchoolVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSchoolVM$loadMoreData$1(String str, SearchSchoolVM searchSchoolVM, Continuation<? super SearchSchoolVM$loadMoreData$1> continuation) {
        super(2, continuation);
        this.$textValue = str;
        this.this$0 = searchSchoolVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchSchoolVM$loadMoreData$1(this.$textValue, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        SearchSchoolAdapter value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f34611a;
            String str = this.$textValue;
            if (str == null) {
                str = "";
            }
            int i2 = this.this$0.pageNum;
            this.label = 1;
            obj = requestModel.p(str, i2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        SearchSchoolInfoBean searchSchoolInfoBean = (SearchSchoolInfoBean) obj;
        if (Intrinsics.areEqual(this.$textValue, this.this$0.k().getValue()) && (value = this.this$0.j().getValue()) != null) {
            if (searchSchoolInfoBean == null || searchSchoolInfoBean.getList().isEmpty()) {
                value.s(false);
                value.setList(CollectionsKt.emptyList());
                this.this$0.l().setValue(searchSchoolInfoBean);
                return Unit.INSTANCE;
            }
            if (this.this$0.pageNum == 1) {
                value.setList(searchSchoolInfoBean.getList());
                this.this$0.l().setValue(searchSchoolInfoBean);
            } else {
                SearchSchoolInfoBean value2 = this.this$0.l().getValue();
                if (value2 != null) {
                    value.addData(value2.getList().size(), (Collection) searchSchoolInfoBean.getList());
                    value2.getList().addAll(searchSchoolInfoBean.getList());
                }
            }
            if (searchSchoolInfoBean.getHasNext()) {
                value.getLoadMoreModule().loadMoreComplete();
            } else {
                BaseLoadMoreModule.loadMoreEnd$default(value.getLoadMoreModule(), false, 1, null);
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
