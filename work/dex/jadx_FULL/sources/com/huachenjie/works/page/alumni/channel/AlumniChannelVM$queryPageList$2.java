package com.huachenjie.works.page.alumni.channel;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.external.adapter.WorksAdapter;
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
@DebugMetadata(c = "com.huachenjie.works.page.alumni.channel.AlumniChannelVM$queryPageList$2", f = "AlumniChannelVM.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
public final class AlumniChannelVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AlumniChannelVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlumniChannelVM$queryPageList$2(AlumniChannelVM alumniChannelVM, Continuation<? super AlumniChannelVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = alumniChannelVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AlumniChannelVM$queryPageList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            int i2 = this.this$0.pageNum;
            String str = this.this$0.refreshTime;
            this.label = 1;
            obj = requestModel.y(i2, str, this);
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
        AlumniChannelVM alumniChannelVM = this.this$0;
        String refreshTime = pageEntity != null ? pageEntity.getRefreshTime() : null;
        if (refreshTime == null) {
            refreshTime = String.valueOf(System.currentTimeMillis());
        }
        alumniChannelVM.refreshTime = refreshTime;
        if (this.this$0.pageNum == 1) {
            this.this$0.s().setValue(Boxing.boxBoolean(false));
            if ((pageEntity != null ? pageEntity.getList() : null) == null || pageEntity.getList().isEmpty()) {
                WorksAdapter value = this.this$0.n().getValue();
                if (value != null) {
                    value.setList(null);
                }
                WorksAdapter value2 = this.this$0.n().getValue();
                if (value2 != null) {
                    value2.r();
                }
            } else {
                WorksAdapter value3 = this.this$0.n().getValue();
                if (value3 != null) {
                    value3.p();
                }
                this.this$0.q().setValue(Boxing.boxBoolean(true));
                WorksAdapter value4 = this.this$0.n().getValue();
                if (value4 != null) {
                    value4.setList(pageEntity.getList());
                }
            }
        } else {
            if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                WorksAdapter value5 = this.this$0.n().getValue();
                if (value5 != null) {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    value5.addData((Collection) list2);
                }
            } else {
                this.this$0.pageNum--;
            }
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            WorksAdapter value6 = this.this$0.n().getValue();
            if (value6 != null && (loadMoreModule2 = value6.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            WorksAdapter value7 = this.this$0.n().getValue();
            if (value7 != null && (loadMoreModule = value7.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
