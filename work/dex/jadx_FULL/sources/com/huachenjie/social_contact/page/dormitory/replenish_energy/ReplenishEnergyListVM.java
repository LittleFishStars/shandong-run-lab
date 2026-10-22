package com.huachenjie.social_contact.page.dormitory.replenish_energy;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.social_contact.adapter.ReplenishEnergyListAdapter;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/social_contact/page/dormitory/replenish_energy/ReplenishEnergyListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "categoryCode", "", j.b, "", "drinkId", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/social_contact/adapter/ReplenishEnergyListAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "c", "n", "purchaseResult", "K", "I", "pageNum", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class ReplenishEnergyListVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ReplenishEnergyListAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> purchaseResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    public final void l(@NotNull String drinkId) {
        Intrinsics.checkNotNullParameter(drinkId, "drinkId");
        BaseViewModelExtKt.b(this, true, false, null, null, new ReplenishEnergyListVM$doExchange$1(drinkId, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<ReplenishEnergyListAdapter> m() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.purchaseResult;
    }

    public final void o(int categoryCode) {
        BaseViewModelExtKt.b(this, false, false, null, null, new ReplenishEnergyListVM$loadData$1(this, categoryCode, null), 15, null);
    }
}
