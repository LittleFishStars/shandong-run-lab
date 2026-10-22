package com.huachenjie.channel.page.advertise;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.channel.api.RequestModel;
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
@DebugMetadata(c = "com.huachenjie.channel.page.advertise.AdvertiseVM$queryPageList$2", f = "AdvertiseVM.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class AdvertiseVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AdvertiseVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvertiseVM$queryPageList$2(AdvertiseVM advertiseVM, Continuation<? super AdvertiseVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = advertiseVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdvertiseVM$queryPageList$2(this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f33012a;
            String value = this.this$0.o().getValue();
            if (value == null) {
                value = "";
            }
            Integer value2 = this.this$0.getType().getValue();
            if (value2 == null) {
                value2 = Boxing.boxInt(0);
            }
            int iIntValue = value2.intValue();
            int i2 = this.this$0.pageNum;
            this.label = 1;
            obj = requestModel.I(value, iIntValue, i2, this);
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
        if (this.this$0.pageNum == 1) {
            this.this$0.q().setValue(Boxing.boxBoolean(false));
            if ((pageEntity != null ? pageEntity.getList() : null) == null || pageEntity.getList().isEmpty()) {
                AdvertiseAdapter value3 = this.this$0.n().getValue();
                if (value3 != null) {
                    value3.setList(null);
                }
                AdvertiseAdapter value4 = this.this$0.n().getValue();
                if (value4 != null) {
                    value4.i();
                }
            } else {
                AdvertiseAdapter value5 = this.this$0.n().getValue();
                if (value5 != null) {
                    value5.g();
                }
                AdvertiseAdapter value6 = this.this$0.n().getValue();
                if (value6 != null) {
                    value6.setList(pageEntity.getList());
                }
            }
        } else {
            if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                AdvertiseAdapter value7 = this.this$0.n().getValue();
                if (value7 != null) {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    value7.addData((Collection) list2);
                }
            } else {
                this.this$0.pageNum--;
            }
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            AdvertiseAdapter value8 = this.this$0.n().getValue();
            if (value8 != null && (loadMoreModule2 = value8.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            AdvertiseAdapter value9 = this.this$0.n().getValue();
            if (value9 != null && (loadMoreModule = value9.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
