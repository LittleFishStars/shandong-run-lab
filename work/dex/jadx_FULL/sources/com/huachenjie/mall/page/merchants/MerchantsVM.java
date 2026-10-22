package com.huachenjie.mall.page.merchants;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.bean.MerchantsBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/merchants/MerchantsVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "shopNo", "", "j", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mall/bean/MerchantsBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "merchantsBean", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class MerchantsVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<MerchantsBean> merchantsBean = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<MerchantsBean> i() {
        return this.merchantsBean;
    }

    public final void j(@NotNull String shopNo) {
        Intrinsics.checkNotNullParameter(shopNo, "shopNo");
        BaseViewModelExtKt.b(this, false, false, null, null, new MerchantsVM$queryMerchantsDes$1(shopNo, this, null), 15, null);
    }
}
