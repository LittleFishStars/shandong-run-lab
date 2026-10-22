package com.huachenjie.works.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostImageBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import com.zj.adlib.ju3;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0010H\u0002J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0007H\u0002R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018¨\u0006#"}, d2 = {"Lcom/huachenjie/works/widget/PostNineGridView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "size", "", "setChildVisibility", "", "Lcom/huachenjie/works/bean/PostImageBean;", "postImages", "setData", "setPostImages", "Landroid/content/Context;", "context", "initView", "width", "height", "Landroid/util/Size;", "b", "Landroid/view/View;", "view", "d", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "c", "N", "I", "imageWidth", "O", "minImageHeight", "P", "maxImageHeight", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPostNineGridView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostNineGridView.kt\ncom/huachenjie/works/widget/PostNineGridView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,128:1\n341#2:129\n359#2:130\n*S KotlinDebug\n*F\n+ 1 PostNineGridView.kt\ncom/huachenjie/works/widget/PostNineGridView\n*L\n32#1:129\n32#1:130\n*E\n"})
public final class PostNineGridView extends ConstraintLayout {

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    public final int imageWidth;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    public final int minImageHeight;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    public final int maxImageHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PostNineGridView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PostNineGridView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PostNineGridView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setChildVisibility(int size) {
        boolean z = size == 4;
        if (z) {
            size++;
        }
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (i < size) {
                childAt.setVisibility((z && i == 2) ? 8 : 0);
            } else {
                childAt.setVisibility(8);
            }
            i++;
        }
    }

    private final void setData(List<PostImageBean> postImages) {
        int iMin = Math.min(postImages.size(), getChildCount());
        boolean z = postImages.size() == 4;
        for (int i = 0; i < iMin; i++) {
            getChildAt(i);
            if (!z) {
                c(getChildAt(i), postImages.get(i));
            } else if (i < 2) {
                c(getChildAt(i), postImages.get(i));
            } else {
                c(getChildAt(i + 1), postImages.get(i));
            }
        }
    }

    public final Size b(int width, int height) {
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

    public final void c(View view, PostImageBean bean) {
        if (view == null || !(view instanceof ImageView)) {
            return;
        }
        Glide.with(view).load(bean.getPath()).apply((BaseRequestOptions<?>) ju3.w).into((ImageView) view);
    }

    public final void d(View view, Size size) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = size.getWidth();
        layoutParams.height = size.getHeight();
        view.setLayoutParams(layoutParams);
    }

    public final void initView(Context context) {
        View.inflate(context, R.layout.works_view_post_nine_grid, this);
        if (getChildCount() > 3) {
            int iJ = fx7.j();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            int i = iJ - (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0);
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            int i2 = (int) (((double) (i - (marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0))) * 0.02499999999999991d * 0.5d);
            int childCount = getChildCount();
            for (int i3 = 3; i3 < childCount; i3++) {
                ViewGroup.LayoutParams layoutParams3 = getChildAt(i3).getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams3)).topMargin = i2;
            }
        }
    }

    public final void setPostImages(@Nullable List<PostImageBean> postImages) {
        if (postImages == null || postImages.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setChildVisibility(postImages.size());
        if (postImages.size() != 1) {
            int width = (int) (getWidth() * 0.325f);
            View childAt = getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(0)");
            d(childAt, new Size(width, width));
            setData(postImages);
            return;
        }
        PostImageBean postImageBean = (PostImageBean) CollectionsKt.first(postImages);
        View childAt2 = getChildAt(0);
        Size sizeB = b(postImageBean.getWidth(), postImageBean.getHeight());
        Intrinsics.checkNotNullExpressionValue(childAt2, "view");
        d(childAt2, sizeB);
        c(childAt2, postImageBean);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PostNineGridView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
        this.imageWidth = jj8.a(240.0f);
        this.minImageHeight = jj8.a(120.0f);
        this.maxImageHeight = jj8.a(280.0f);
    }
}
