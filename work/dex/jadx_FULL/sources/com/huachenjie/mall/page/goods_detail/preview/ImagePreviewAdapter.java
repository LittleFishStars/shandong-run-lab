package com.huachenjie.mall.page.goods_detail.preview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.bean.VideoBean;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "", "", GoodsSpecificationPreviewActivity.z, "", "k", "", "getCount", "Landroid/view/View;", "view", "object", "", "isViewFromObject", "Landroid/view/ViewGroup;", "container", "position", "instantiateItem", "destroyItem", "a", "Z", "i", "()Z", "j", "(Z)V", "isFullScreen", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", y6b.g, "()Lkotlin/jvm/functions/Function1;", t.d, "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "", "c", "Ljava/util/List;", "data", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ImagePreviewAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Function1<? super Integer, Unit> onItemClickListener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isFullScreen;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<Object> data = new ArrayList();

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.data.size();
    }

    @Nullable
    public final Function1<Integer, Unit> h() {
        return this.onItemClickListener;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getIsFullScreen() {
        return this.isFullScreen;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        View view;
        Intrinsics.checkNotNullParameter(container, "container");
        Object obj = this.data.get(position);
        if (obj instanceof ImageBean) {
            Context context = container.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "container.context");
            PhotoLayout photoLayout = new PhotoLayout(context, null, 0, 6, null);
            photoLayout.bindData(((ImageBean) obj).getUrl(), this.isFullScreen, this.onItemClickListener, position);
            view = photoLayout;
        } else {
            if (!(obj instanceof VideoBean)) {
                throw new IllegalArgumentException("Invalid item type");
            }
            Context context2 = container.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "container.context");
            VideoLayout videoLayout = new VideoLayout(context2, null, 0, 6, null);
            videoLayout.setTag(Integer.valueOf(position));
            videoLayout.initData(((VideoBean) obj).getPreviewUrl(), this.isFullScreen, this.onItemClickListener, position);
            view = videoLayout;
        }
        container.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }

    public final void j(boolean z) {
        this.isFullScreen = z;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void k(@NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    public final void l(@Nullable Function1<? super Integer, Unit> function1) {
        this.onItemClickListener = function1;
    }
}
