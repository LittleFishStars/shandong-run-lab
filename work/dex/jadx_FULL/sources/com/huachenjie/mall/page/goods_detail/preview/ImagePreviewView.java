package com.huachenjie.mall.page.goods_detail.preview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.SizeUtils;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.bean.VideoBean;
import com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\n¢\u0006\u0004\b8\u00109J>\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0003J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002RF\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u001b\u00102\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b0\u00101¨\u0006:"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewView;", "Landroid/widget/FrameLayout;", "Lcom/huachenjie/base/bean/VideoBean;", "videoBean", "", "Lcom/huachenjie/base/bean/ImageBean;", "imageList", "", "autoPlay", "showCover", "", "position", "isFullScreen", "", "initData", "resume", "pause", "setCurrentPosition", "rebindTextureView", y6b.f, "e", "c", "Lkotlin/Function1;", "value", "a", "Lkotlin/jvm/functions/Function1;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "<set-?>", "K", "I", "getCurrentPosition", "()I", "currentPosition", "Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewViewPager;", "Lkotlin/Lazy;", "getViewPager", "()Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewViewPager;", "viewPager", "Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewAdapter;", "b", "getAdapter", "()Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewAdapter;", "adapter", "Landroid/widget/TextView;", "getNumView", "()Landroid/widget/TextView;", "numView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ImagePreviewView extends FrameLayout {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int currentPosition;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy viewPager;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function1<? super Integer, Unit> onItemClickListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy adapter;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy numView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImagePreviewView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImagePreviewView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ImagePreviewView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void d(ImagePreviewView imagePreviewView, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(imagePreviewView, "this$0");
        imagePreviewView.c(z, z2);
    }

    public static final void f(ImagePreviewView imagePreviewView, int i) {
        Intrinsics.checkNotNullParameter(imagePreviewView, "this$0");
        TextView numView = imagePreviewView.getNumView();
        StringBuilder sb = new StringBuilder();
        sb.append(i + 1);
        sb.append('/');
        sb.append(imagePreviewView.getAdapter().getCount());
        numView.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImagePreviewAdapter getAdapter() {
        return (ImagePreviewAdapter) this.adapter.getValue();
    }

    private final TextView getNumView() {
        return (TextView) this.numView.getValue();
    }

    private final ImagePreviewViewPager getViewPager() {
        return (ImagePreviewViewPager) this.viewPager.getValue();
    }

    public final void c(boolean autoPlay, boolean showCover) {
        if (SequencesKt.count(ViewGroupKt.getChildren(getViewPager())) > 0) {
            View viewFindViewWithTag = getViewPager().findViewWithTag(0);
            if (viewFindViewWithTag instanceof VideoLayout) {
                ((VideoLayout) viewFindViewWithTag).bindTextureView(autoPlay, showCover);
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void e(final int position) {
        post(new Runnable() { // from class: com.zj.adlib.x74
            @Override // java.lang.Runnable
            public final void run() {
                ImagePreviewView.f(this.f45757a, position);
            }
        });
    }

    public final void g(boolean isFullScreen) {
        if (isFullScreen) {
            getNumView().setTextSize(14.0f);
            getNumView().setPadding(SizeUtils.b(12.0f), 0, SizeUtils.b(12.0f), 0);
            getNumView().setBackground(new DrawableCreator.Builder().setSolidColor(-2130706433).setCornersRadius(SizeUtils.b(12.0f)).build());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, SizeUtils.b(24.0f));
            layoutParams.gravity = 1;
            layoutParams.topMargin = e.J0(getContext()) + SizeUtils.b(16.0f);
            getNumView().setLayoutParams(layoutParams);
            return;
        }
        getNumView().setTextSize(10.0f);
        getNumView().setPadding(SizeUtils.b(8.0f), 0, SizeUtils.b(8.0f), 0);
        getNumView().setBackground(new DrawableCreator.Builder().setSolidColor(Integer.MIN_VALUE).setCornersRadius(SizeUtils.b(8.0f)).build());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, SizeUtils.b(16.0f));
        layoutParams2.gravity = 8388693;
        layoutParams2.setMarginEnd(SizeUtils.b(16.0f));
        layoutParams2.bottomMargin = SizeUtils.b(12.0f);
        getNumView().setLayoutParams(layoutParams2);
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    @Nullable
    public final Function1<Integer, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final void initData(@Nullable VideoBean videoBean, @NotNull List<ImageBean> imageList, final boolean autoPlay, final boolean showCover, int position, boolean isFullScreen) {
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        if (imageList.isEmpty()) {
            return;
        }
        this.currentPosition = position;
        g(isFullScreen);
        ArrayList arrayList = new ArrayList();
        if (videoBean != null) {
            arrayList.add(videoBean);
        }
        getAdapter().j(isFullScreen);
        arrayList.addAll(imageList);
        getViewPager().setOffscreenPageLimit(arrayList.size());
        getAdapter().k(arrayList);
        if (position == 0) {
            e(position);
        } else {
            setCurrentPosition(position);
        }
        post(new Runnable() { // from class: com.zj.adlib.w74
            @Override // java.lang.Runnable
            public final void run() {
                ImagePreviewView.d(this.f45535a, autoPlay, showCover);
            }
        });
    }

    public final void pause() {
        if (SequencesKt.count(ViewGroupKt.getChildren(getViewPager())) > 0) {
            View viewFindViewWithTag = getViewPager().findViewWithTag(0);
            if ((viewFindViewWithTag instanceof VideoLayout) && this.currentPosition == 0) {
                ((VideoLayout) viewFindViewWithTag).pause();
            }
        }
    }

    public final void rebindTextureView() {
        if (SequencesKt.count(ViewGroupKt.getChildren(getViewPager())) > 0) {
            View viewFindViewWithTag = getViewPager().findViewWithTag(0);
            if (viewFindViewWithTag instanceof VideoLayout) {
                ((VideoLayout) viewFindViewWithTag).rebindTextureView();
            }
        }
    }

    public final void resume() {
        if (SequencesKt.count(ViewGroupKt.getChildren(getViewPager())) > 0) {
            View viewFindViewWithTag = getViewPager().findViewWithTag(0);
            if ((viewFindViewWithTag instanceof VideoLayout) && this.currentPosition == 0) {
                ((VideoLayout) viewFindViewWithTag).resume();
            }
        }
    }

    public final void setCurrentPosition(int position) {
        getViewPager().setCurrentItem(position, false);
    }

    public final void setOnItemClickListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.onItemClickListener = function1;
        getAdapter().l(function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImagePreviewView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewPager = LazyKt.lazy(new Function0<ImagePreviewViewPager>() { // from class: com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView$viewPager$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImagePreviewViewPager m543invoke() {
                final ImagePreviewViewPager imagePreviewViewPager = new ImagePreviewViewPager(context);
                final ImagePreviewView imagePreviewView = this;
                imagePreviewViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView$viewPager$2.1
                    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int position) {
                        if (imagePreviewView.getCurrentPosition() != position) {
                            if (position == 0) {
                                View viewFindViewWithTag = imagePreviewViewPager.findViewWithTag(0);
                                if (viewFindViewWithTag instanceof VideoLayout) {
                                    ((VideoLayout) viewFindViewWithTag).resume();
                                }
                            } else {
                                View viewFindViewWithTag2 = imagePreviewViewPager.findViewWithTag(Integer.valueOf(imagePreviewView.getCurrentPosition()));
                                if (viewFindViewWithTag2 instanceof VideoLayout) {
                                    ((VideoLayout) viewFindViewWithTag2).pause();
                                }
                            }
                        }
                        imagePreviewView.currentPosition = position;
                        imagePreviewView.e(position);
                    }
                });
                imagePreviewViewPager.setAdapter(this.getAdapter());
                this.addView(imagePreviewViewPager, new FrameLayout.LayoutParams(-1, -1));
                return imagePreviewViewPager;
            }
        });
        this.adapter = LazyKt.lazy(new Function0<ImagePreviewAdapter>() { // from class: com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView$adapter$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImagePreviewAdapter m541invoke() {
                return new ImagePreviewAdapter();
            }
        });
        this.numView = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView$numView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m542invoke() {
                TextView textView = new TextView(context);
                textView.setTextColor(-1);
                textView.setGravity(16);
                this.addView(textView);
                return textView;
            }
        });
        getViewPager();
        getNumView();
    }
}
