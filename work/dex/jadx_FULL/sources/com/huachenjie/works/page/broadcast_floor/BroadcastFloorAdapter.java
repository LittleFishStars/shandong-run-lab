package com.huachenjie.works.page.broadcast_floor;

import android.text.method.LinkMovementMethod;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.databinding.WorksItemBroadcastFloorBinding;
import com.zj.adlib.jj8;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010 \u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0018\u0010\"\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010!¨\u0006%"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/BroadcastFloorMessageBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemBroadcastFloorBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "Landroid/view/View;", "view", y6b.f, "i", "f", "Landroid/util/Size;", "size", y6b.g, "", "width", "height", "e", "", "a", "Z", "isMatched", "K", "I", "imageWidth", "L", "minImageHeight", "M", "maxImageHeight", "Landroid/view/View;", "mEmptyView", "<init>", "(Z)V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BroadcastFloorAdapter extends BaseQuickAdapter<BroadcastFloorMessageBean, BaseDataBindingHolder<WorksItemBroadcastFloorBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int imageWidth;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int minImageHeight;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public final int maxImageHeight;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final boolean isMatched;

    public BroadcastFloorAdapter() {
        this(false, 1, null);
    }

    public /* synthetic */ BroadcastFloorAdapter(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final Size e(int width, int height) {
        if (width == 0 && height == 0) {
            int i = this.imageWidth;
            return new Size(i, i);
        }
        if (width == 0 || height == 0) {
            return new Size(this.imageWidth, this.minImageHeight);
        }
        int i2 = this.imageWidth;
        float f = (height * i2) / width;
        int i3 = this.minImageHeight;
        if (f < i3) {
            f = i3;
        }
        int i4 = this.maxImageHeight;
        if (f > i4) {
            f = i4;
        }
        return new Size(i2, (int) f);
    }

    public final void f() {
        removeEmptyView();
    }

    public final void g(@Nullable View view) {
        this.mEmptyView = view;
    }

    public final void h(View view, Size size) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = size.getWidth();
        layoutParams.height = size.getHeight();
        view.setLayoutParams(layoutParams);
    }

    public final void i() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        setEmptyView(view);
    }

    public BroadcastFloorAdapter(boolean z) {
        super(R.layout.works_item_broadcast_floor, null, 2, null);
        this.isMatched = z;
        this.imageWidth = jj8.a(220.0f);
        this.minImageHeight = jj8.a(120.0f);
        this.maxImageHeight = jj8.a(280.0f);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemBroadcastFloorBinding> holder, @NotNull BroadcastFloorMessageBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemBroadcastFloorBinding worksItemBroadcastFloorBinding = (WorksItemBroadcastFloorBinding) holder.getDataBinding();
        if (worksItemBroadcastFloorBinding != null) {
            item.setMatched(this.isMatched);
            worksItemBroadcastFloorBinding.k(item);
            if (item.showImage()) {
                Size sizeE = e(item.getWidth(), item.getHeight());
                ImageView imageView = worksItemBroadcastFloorBinding.c;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivImage");
                h(imageView, sizeE);
            }
            worksItemBroadcastFloorBinding.f14482c.setMovementMethod(new LinkMovementMethod());
            worksItemBroadcastFloorBinding.f14482c.setHighlightColor(0);
            worksItemBroadcastFloorBinding.executePendingBindings();
        }
    }
}
