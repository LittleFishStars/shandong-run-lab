package com.huachenjie.run.adapter;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.run.R;
import com.zj.adlib.ju3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/huachenjie/run/adapter/GuideGalleryAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GuideGalleryAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {
    public GuideGalleryAdapter() {
        super(R.layout.run_item_guide_gallery, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Integer num) {
        convert(baseViewHolder, num.intValue());
    }

    public void convert(@NotNull BaseViewHolder holder, int item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Glide.with(getContext()).load(Integer.valueOf(item)).apply((BaseRequestOptions<?>) ju3.f).into((ImageView) holder.getView(R.id.img_guide));
    }
}
