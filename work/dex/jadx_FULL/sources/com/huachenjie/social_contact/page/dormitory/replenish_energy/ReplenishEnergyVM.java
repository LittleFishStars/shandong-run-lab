package com.huachenjie.social_contact.page.dormitory.replenish_energy;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.social_contact.bean.DrinkCategory;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/social_contact/page/dormitory/replenish_energy/ReplenishEnergyVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "k", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/huachenjie/social_contact/bean/DrinkCategory;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "categories", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class ReplenishEnergyVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<DrinkCategory>> categories = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<List<DrinkCategory>> j() {
        return this.categories;
    }

    public final void k() {
        BaseViewModelExtKt.b(this, false, false, null, null, new ReplenishEnergyVM$loadDrinkCategories$1(this, null), 15, null);
    }
}
