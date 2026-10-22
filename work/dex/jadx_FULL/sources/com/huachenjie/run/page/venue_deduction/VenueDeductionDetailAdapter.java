package com.huachenjie.run.page.venue_deduction;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.VenueRecordDetailBean;
import com.huachenjie.run.databinding.RunItemVenueDeductionDetailBinding;
import com.zj.adlib.jj8;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/run/page/venue_deduction/VenueDeductionDetailAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/run/bean/VenueRecordDetailBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/run/databinding/RunItemVenueDeductionDetailBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "Landroid/view/View;", "view", y6b.f, y6b.g, "f", "", "K", "I", "itemPadding", "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class VenueDeductionDetailAdapter extends BaseQuickAdapter<VenueRecordDetailBean, BaseDataBindingHolder<RunItemVenueDeductionDetailBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int itemPadding;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public VenueDeductionDetailAdapter() {
        super(R.layout.run_item_venue_deduction_detail, null, 2, null);
        this.itemPadding = jj8.a(16.0f);
    }

    public final void f() {
        removeEmptyView();
    }

    public final void g(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    public final void h() {
        View view = this.mEmptyView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            setEmptyView(view);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<RunItemVenueDeductionDetailBinding> holder, @NotNull VenueRecordDetailBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        RunItemVenueDeductionDetailBinding runItemVenueDeductionDetailBinding = (RunItemVenueDeductionDetailBinding) holder.getDataBinding();
        if (runItemVenueDeductionDetailBinding != null) {
            if (getItemPosition(item) == 0) {
                View root = runItemVenueDeductionDetailBinding.getRoot();
                int i = this.itemPadding;
                root.setPadding(i, 0, i, i);
            } else {
                View root2 = runItemVenueDeductionDetailBinding.getRoot();
                int i2 = this.itemPadding;
                root2.setPadding(i2, i2, i2, i2);
            }
            runItemVenueDeductionDetailBinding.k(item);
            runItemVenueDeductionDetailBinding.executePendingBindings();
        }
    }
}
