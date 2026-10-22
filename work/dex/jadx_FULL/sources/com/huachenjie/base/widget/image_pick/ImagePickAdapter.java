package com.huachenjie.base.widget.image_pick;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.R;
import com.huachenjie.base.databinding.ViewItemImagePickAddBinding;
import com.huachenjie.base.databinding.ViewItemImagePickImageBinding;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ImagePickAdapter extends BaseMultiItemQuickAdapter<ImagePickBean, BaseDataBindingHolder<ViewDataBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f32986a;

    public ImagePickAdapter() {
        addItemType(1, R.layout.view_item_image_pick_image);
        addItemType(2, R.layout.view_item_image_pick_add);
    }

    public void f() {
        removeEmptyView();
    }

    public void g(View view) {
        this.f32986a = view;
    }

    public void h() {
        View view;
        if (hasEmptyView() || (view = this.f32986a) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(this.f32986a);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseDataBindingHolder<ViewDataBinding> holder, ImagePickBean item) {
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding == null) {
            return;
        }
        int postType = item.getPostType();
        if (postType == 1) {
            ((ViewItemImagePickImageBinding) dataBinding).k(item);
        } else if (postType == 2) {
            ((ViewItemImagePickAddBinding) dataBinding).k(item);
        }
        dataBinding.executePendingBindings();
    }
}
