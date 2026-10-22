package com.huachenjie.works.page.alumni.find_alumni;

import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.InterestTag;
import com.zj.adlib.qk0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u001e\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsAdapter;", "Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "Lcom/huachenjie/works/bean/InterestTag;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "()V", "convert", "", "holder", "item", "convertHeader", "helper", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SettingInterestTagsAdapter extends BaseSectionQuickAdapter<InterestTag, BaseDataBindingHolder<ViewDataBinding>> {
    public SettingInterestTagsAdapter() {
        super(R.layout.works_item_setting_interest_tags_header, null, 2, null);
        setNormalLayout(R.layout.works_item_setting_interest_tags);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull InterestTag item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            dataBinding.setVariable(qk0.g, item);
            dataBinding.executePendingBindings();
        }
    }

    @Override // com.chad.library.adapter.base.BaseSectionQuickAdapter
    public void convertHeader(@NotNull BaseDataBindingHolder<ViewDataBinding> helper, @NotNull InterestTag item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = helper.getDataBinding();
        if (dataBinding != null) {
            dataBinding.setVariable(qk0.g, item);
            dataBinding.executePendingBindings();
        }
    }
}
