package com.huachenjie.mall.page.comment.write;

import android.view.View;
import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.WriteReviewAddImageBean;
import com.huachenjie.mall.bean.WriteReviewImageBean;
import com.huachenjie.mall.databinding.MallItemWriteReviewImageAddBinding;
import com.huachenjie.mall.databinding.MallItemWriteReviewImageBinding;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/mall/page/comment/write/WriteReviewImageAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/mall/bean/WriteReviewImageBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "holder", "item", "", "convert", "Landroid/view/View;", "view", y6b.f, y6b.g, "f", "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class WriteReviewImageAdapter extends BaseMultiItemQuickAdapter<WriteReviewImageBean, BaseDataBindingHolder<ViewDataBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public WriteReviewImageAdapter() {
        super(null, 1, null);
        addItemType(0, R.layout.mall_item_write_review_image);
        addItemType(1, R.layout.mall_item_write_review_image_add);
    }

    public final void f() {
        removeEmptyView();
    }

    public final void g(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    public final void h() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull WriteReviewImageBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding == null) {
            return;
        }
        int postType = item.getPostType();
        if (postType == 0) {
            ((MallItemWriteReviewImageBinding) dataBinding).k(item);
        } else if (postType == 1) {
            ((MallItemWriteReviewImageAddBinding) dataBinding).k((WriteReviewAddImageBean) item);
        }
        dataBinding.executePendingBindings();
    }
}
