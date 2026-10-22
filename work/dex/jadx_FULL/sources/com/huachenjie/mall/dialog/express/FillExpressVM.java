package com.huachenjie.mall.dialog.express;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.kernel.RVParams;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.bean.ExpressCompanyBean;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/mall/dialog/express/FillExpressVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "isFillExpress", "", "refundOrderNo", "", "i", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", RVParams.KEYBOARD_HEIGHT, "Lcom/huachenjie/mall/bean/ExpressCompanyBean;", "b", "j", "expressCompanyBean", "c", "k", "expressNo", "d", t.d, "expressResult", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class FillExpressVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> keyboardHeight = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ExpressCompanyBean> expressCompanyBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> expressNo = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> expressResult = new MutableLiveData<>();

    public final void i(boolean isFillExpress, @NotNull String refundOrderNo) {
        String shipperCode;
        Intrinsics.checkNotNullParameter(refundOrderNo, "refundOrderNo");
        ExpressCompanyBean value = this.expressCompanyBean.getValue();
        if (value == null || (shipperCode = value.getShipperCode()) == null) {
            return;
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new FillExpressVM$fillExpress$1(isFillExpress, refundOrderNo, shipperCode, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<ExpressCompanyBean> j() {
        return this.expressCompanyBean;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.expressNo;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.expressResult;
    }

    @NotNull
    public final MutableLiveData<Integer> m() {
        return this.keyboardHeight;
    }
}
