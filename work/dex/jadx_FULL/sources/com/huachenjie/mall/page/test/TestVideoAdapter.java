package com.huachenjie.mall.page.test;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallItemTestVideoBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/test/TestVideoAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/page/test/TestVideoDetailBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemTestVideoBinding;", "()V", "convert", "", "holder", "item", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TestVideoAdapter extends BaseQuickAdapter<TestVideoDetailBean, BaseDataBindingHolder<MallItemTestVideoBinding>> {
    public TestVideoAdapter() {
        super(R.layout.mall_item_test_video, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemTestVideoBinding> holder, @NotNull TestVideoDetailBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemTestVideoBinding mallItemTestVideoBinding = (MallItemTestVideoBinding) holder.getDataBinding();
        if (mallItemTestVideoBinding != null) {
            mallItemTestVideoBinding.k(item);
            mallItemTestVideoBinding.executePendingBindings();
        }
    }
}
