package com.huachenjie.mall.page.check_order;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.kernel.RVParams;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/check_order/OrderRemarkVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", RVParams.KEYBOARD_HEIGHT, "", "b", "j", "remark", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class OrderRemarkVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> keyboardHeight = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> remark = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<Integer> i() {
        return this.keyboardHeight;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.remark;
    }
}
