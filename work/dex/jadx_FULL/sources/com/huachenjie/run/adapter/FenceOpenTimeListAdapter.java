package com.huachenjie.run.adapter;

import androidx.annotation.LayoutRes;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.OpenTimeBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/run/adapter/FenceOpenTimeListAdapter;", "Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "Lcom/huachenjie/run/bean/OpenTimeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "sectionHeadResId", "", "layoutResId", "(II)V", "convert", "", "holder", "item", "convertHeader", "helper", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FenceOpenTimeListAdapter extends BaseSectionQuickAdapter<OpenTimeBean, BaseViewHolder> {
    public FenceOpenTimeListAdapter(@LayoutRes int i, @LayoutRes int i2) {
        super(i, i2, null, 4, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull OpenTimeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        holder.setText(R.id.tvTime, item.getContent());
    }

    @Override // com.chad.library.adapter.base.BaseSectionQuickAdapter
    public void convertHeader(@NotNull BaseViewHolder helper, @NotNull OpenTimeBean item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        helper.setText(R.id.tvHeader, item.getContent() + (char) 65306);
    }
}
