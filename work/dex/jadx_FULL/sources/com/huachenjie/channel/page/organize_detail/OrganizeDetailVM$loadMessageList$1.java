package com.huachenjie.channel.page.organize_detail;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.channel.adapter.ClubMessageAdapter;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.OrganizeBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.organize_detail.OrganizeDetailVM$loadMessageList$1", f = "OrganizeDetailVM.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class OrganizeDetailVM$loadMessageList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OrganizeDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrganizeDetailVM$loadMessageList$1(OrganizeDetailVM organizeDetailVM, Continuation<? super OrganizeDetailVM$loadMessageList$1> continuation) {
        super(2, continuation);
        this.this$0 = organizeDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrganizeDetailVM$loadMessageList$1(this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f33012a;
            int i2 = this.this$0.pageNum;
            OrganizeBean value = this.this$0.m().getValue();
            String clubCode = value != null ? value.getClubCode() : null;
            this.label = 1;
            obj = requestModel.W(i2, 10, (4 & 4) != 0 ? null : clubCode, (4 & 8) != 0 ? null : null, this);
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
        if (pageEntity != null) {
            OrganizeDetailVM organizeDetailVM = this.this$0;
            organizeDetailVM.n().setValue(Boxing.boxInt(pageEntity.getTotal()));
            if (organizeDetailVM.pageNum == 1) {
                ClubMessageAdapter value2 = organizeDetailVM.l().getValue();
                if (value2 != null) {
                    value2.setList(pageEntity.getList());
                }
            } else {
                ClubMessageAdapter value3 = organizeDetailVM.l().getValue();
                if (value3 != null) {
                    List list = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list, "it.list");
                    value3.addData((Collection) list);
                }
            }
            if (pageEntity.getHasNext()) {
                ClubMessageAdapter value4 = organizeDetailVM.l().getValue();
                if (value4 != null && (loadMoreModule2 = value4.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                ClubMessageAdapter value5 = organizeDetailVM.l().getValue();
                if (value5 != null && (loadMoreModule = value5.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
            organizeDetailVM.pageNum++;
        }
        return Unit.INSTANCE;
    }
}
