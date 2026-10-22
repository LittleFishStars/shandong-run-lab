package com.huachenjie.mall.page.merchants;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.MerchantsBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.merchants.MerchantsVM$queryMerchantsDes$1", f = "MerchantsVM.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
public final class MerchantsVM$queryMerchantsDes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $shopNo;
    int label;
    final /* synthetic */ MerchantsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantsVM$queryMerchantsDes$1(String str, MerchantsVM merchantsVM, Continuation<? super MerchantsVM$queryMerchantsDes$1> continuation) {
        super(2, continuation);
        this.$shopNo = str;
        this.this$0 = merchantsVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MerchantsVM$queryMerchantsDes$1(this.$shopNo, this.this$0, continuation);
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
            MallModel mallModel = MallModel.f34763a;
            String str = this.$shopNo;
            this.label = 1;
            obj = mallModel.K(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MerchantsBean merchantsBean = (MerchantsBean) obj;
        MutableLiveData<MerchantsBean> mutableLiveDataI = this.this$0.i();
        if (merchantsBean == null) {
            merchantsBean = new MerchantsBean(null, null, null, null, null, false, null, 127, null);
        }
        mutableLiveDataI.setValue(merchantsBean);
        return Unit.INSTANCE;
    }
}
