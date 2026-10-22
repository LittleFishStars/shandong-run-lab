package com.huachenjie.social_contact.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.DrinkDetailBean;
import com.huachenjie.social_contact.databinding.ItemReplenishEnergyListBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/social_contact/adapter/ReplenishEnergyListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/social_contact/bean/DrinkDetailBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/social_contact/databinding/ItemReplenishEnergyListBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReplenishEnergyListAdapter extends BaseQuickAdapter<DrinkDetailBean, BaseDataBindingHolder<ItemReplenishEnergyListBinding>> implements LoadMoreModule {
    /* JADX WARN: Illegal instructions before constructor call */
    public ReplenishEnergyListAdapter() {
        List list = null;
        super(R.layout.item_replenish_energy_list, list, 2, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemReplenishEnergyListBinding> holder, @NotNull DrinkDetailBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemReplenishEnergyListBinding itemReplenishEnergyListBinding = (ItemReplenishEnergyListBinding) holder.getDataBinding();
        if (itemReplenishEnergyListBinding != null) {
            itemReplenishEnergyListBinding.k(item);
            itemReplenishEnergyListBinding.executePendingBindings();
        }
    }
}
