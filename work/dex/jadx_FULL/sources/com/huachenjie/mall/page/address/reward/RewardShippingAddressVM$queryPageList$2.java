package com.huachenjie.mall.page.address.reward;

import android.text.TextUtils;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.api.MallModel;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.address.reward.RewardShippingAddressVM$queryPageList$2", f = "RewardShippingAddressVM.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nRewardShippingAddressVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RewardShippingAddressVM.kt\ncom/huachenjie/mall/page/address/reward/RewardShippingAddressVM$queryPageList$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,125:1\n1855#2,2:126\n1855#2,2:128\n*S KotlinDebug\n*F\n+ 1 RewardShippingAddressVM.kt\ncom/huachenjie/mall/page/address/reward/RewardShippingAddressVM$queryPageList$2\n*L\n71#1:126,2\n83#1:128,2\n*E\n"})
public final class RewardShippingAddressVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RewardShippingAddressVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardShippingAddressVM$queryPageList$2(RewardShippingAddressVM rewardShippingAddressVM, Continuation<? super RewardShippingAddressVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = rewardShippingAddressVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RewardShippingAddressVM$queryPageList$2(this.this$0, continuation);
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
            MallModel mallModel = MallModel.f34763a;
            int pageNum = this.this$0.getPageNum();
            this.label = 1;
            obj = mallModel.o(pageNum, this);
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
        this.this$0.w(pageEntity != null ? pageEntity.getRefreshTime() : null);
        if (this.this$0.getPageNum() == 1) {
            this.this$0.p().setValue(Boxing.boxBoolean(false));
            if ((pageEntity != null ? pageEntity.getList() : null) == null || pageEntity.getList().isEmpty()) {
                RewardShippingAddressAdapter value = this.this$0.k().getValue();
                if (value != null) {
                    value.setList(null);
                }
                RewardShippingAddressAdapter value2 = this.this$0.k().getValue();
                if (value2 != null) {
                    value2.l();
                }
                this.this$0.o().setValue(Boxing.boxBoolean(true));
            } else {
                RewardShippingAddressAdapter value3 = this.this$0.k().getValue();
                if (value3 != null) {
                    value3.h();
                }
                if (!TextUtils.isEmpty(this.this$0.getOldAddressNo())) {
                    List<ShippingAddressBean> list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    RewardShippingAddressVM rewardShippingAddressVM = this.this$0;
                    for (ShippingAddressBean shippingAddressBean : list2) {
                        if (TextUtils.equals(shippingAddressBean.getAddressNo(), rewardShippingAddressVM.getOldAddressNo())) {
                            shippingAddressBean.setSelected(true);
                        }
                    }
                }
                RewardShippingAddressAdapter value4 = this.this$0.k().getValue();
                if (value4 != null) {
                    value4.setList(pageEntity.getList());
                }
                this.this$0.o().setValue(Boxing.boxBoolean(false));
            }
        } else if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
            if (!TextUtils.isEmpty(this.this$0.getOldAddressNo())) {
                List<ShippingAddressBean> list3 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                RewardShippingAddressVM rewardShippingAddressVM2 = this.this$0;
                for (ShippingAddressBean shippingAddressBean2 : list3) {
                    if (TextUtils.equals(shippingAddressBean2.getAddressNo(), rewardShippingAddressVM2.getOldAddressNo())) {
                        shippingAddressBean2.setSelected(true);
                    }
                }
            }
            RewardShippingAddressAdapter value5 = this.this$0.k().getValue();
            if (value5 != null) {
                List list4 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list4, "data.list");
                value5.addData((Collection) list4);
            }
        } else {
            RewardShippingAddressVM rewardShippingAddressVM3 = this.this$0;
            rewardShippingAddressVM3.v(rewardShippingAddressVM3.getPageNum() - 1);
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            RewardShippingAddressAdapter value6 = this.this$0.k().getValue();
            if (value6 != null && (loadMoreModule2 = value6.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            RewardShippingAddressAdapter value7 = this.this$0.k().getValue();
            if (value7 != null && (loadMoreModule = value7.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
