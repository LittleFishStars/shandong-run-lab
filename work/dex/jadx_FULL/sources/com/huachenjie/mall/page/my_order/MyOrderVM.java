package com.huachenjie.mall.page.my_order;

import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModelKt;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.bean.OrderCountBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.v41;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mall/page/my_order/MyOrderVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "m", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mall/bean/OrderCountBean;", "b", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "orderCount", "Lkotlinx/coroutines/Job;", "a", "Lkotlinx/coroutines/Job;", "countDownTask", "", "c", "j", "countDown", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class MyOrderVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Job countDownTask;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrderCountBean> orderCount = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> countDown = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.countDown;
    }

    @NotNull
    public final MutableLiveData<OrderCountBean> k() {
        return this.orderCount;
    }

    public final void l() {
        BaseViewModelExtKt.b(this, false, false, null, null, new MyOrderVM$queryOrderCount$1(this, null), 15, null);
    }

    public final void m() {
        Job job = this.countDownTask;
        if (job != null) {
            Job.a.b(job, (CancellationException) null, 1, (Object) null);
        }
        this.countDownTask = v41.e(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MyOrderVM$startCountDown$1(this, null), 3, (Object) null);
    }
}
