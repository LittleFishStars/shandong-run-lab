package com.huachenjie.mall.page.apply_refund;

import com.alibaba.android.arouter.utils.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.ApplyRefundFileBean;
import com.huachenjie.mall.bean.ApplyRefundRequestBean;
import com.huachenjie.mall.bean.AttachmentBean;
import com.huachenjie.mall.bean.OrderReasonBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.huachenjie.mall.page.apply_refund.ApplyRefundVM$submitRefund$1", f = "ApplyRefundVM.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nApplyRefundVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApplyRefundVM.kt\ncom/huachenjie/mall/page/apply_refund/ApplyRefundVM$submitRefund$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,130:1\n766#2:131\n857#2,2:132\n1549#2:134\n1620#2,3:135\n*S KotlinDebug\n*F\n+ 1 ApplyRefundVM.kt\ncom/huachenjie/mall/page/apply_refund/ApplyRefundVM$submitRefund$1\n*L\n116#1:131\n116#1:132,2\n118#1:134\n118#1:135,3\n*E\n"})
public final class ApplyRefundVM$submitRefund$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ApplyRefundVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyRefundVM$submitRefund$1(ApplyRefundVM applyRefundVM, Continuation<? super ApplyRefundVM$submitRefund$1> continuation) {
        super(2, continuation);
        this.this$0 = applyRefundVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyRefundVM$submitRefund$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            OrderGoodsBean value = this.this$0.l().getValue();
            Intrinsics.checkNotNull(value);
            String orderItemNo = value.getOrderItemNo();
            Integer value2 = this.this$0.q().getValue();
            if (value2 == null) {
                value2 = Boxing.boxInt(1);
            }
            int iIntValue = value2.intValue();
            OrderReasonBean value3 = this.this$0.o().getValue();
            Intrinsics.checkNotNull(value3);
            int code = value3.getCode();
            String value4 = this.this$0.n().getValue();
            String str = value4 == null ? "" : value4;
            String value5 = this.this$0.p().getValue();
            String str2 = value5 == null ? "" : value5;
            ApplyRefundFileAdapter value6 = this.this$0.m().getValue();
            Intrinsics.checkNotNull(value6);
            Iterable data = value6.getData();
            ArrayList<ApplyRefundFileBean> arrayList = new ArrayList();
            for (Object obj2 : data) {
                if (((ApplyRefundFileBean) obj2).getPostType() == 1) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (ApplyRefundFileBean applyRefundFileBean : arrayList) {
                String path = applyRefundFileBean.getPath();
                if (path == null) {
                    path = "";
                }
                String cover = applyRefundFileBean.getCover();
                if (cover == null) {
                    cover = "";
                }
                arrayList2.add(new AttachmentBean(path, cover, TextUtils.isEmpty(applyRefundFileBean.getCover()) ? 1 : 2));
            }
            ApplyRefundRequestBean applyRefundRequestBean = new ApplyRefundRequestBean(orderItemNo, iIntValue, code, str, str2, arrayList2);
            MallModel mallModel = MallModel.f34763a;
            this.label = 1;
            obj = mallModel.d(applyRefundRequestBean, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        JSONObject jSONObject = (JSONObject) obj;
        this.this$0.k().setValue(jSONObject != null ? jSONObject.getString("refundOrderNo") : null);
        return Unit.INSTANCE;
    }
}
