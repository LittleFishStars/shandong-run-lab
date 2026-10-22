package com.huachenjie.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.a;
import com.bumptech.glide.Glide;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.wgw.photo.preview.PhotoPreview;
import com.wgw.photo.preview.interfaces.IFindThumbnailView;
import com.wgw.photo.preview.interfaces.ImageLoader;
import com.wgw.photo.preview.interfaces.OnDismissListener;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007JO\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\b\b\u0002\u0010\r\u001a\u00020\f2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eH\u0007J´\u0001\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0006\u0010\r\u001a\u00020\f2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e2O\b\u0002\u0010\u0019\u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ´\u0001\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0006\u0010\r\u001a\u00020\f2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e2O\b\u0002\u0010\u0019\u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ´\u0001\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0006\u0010\r\u001a\u00020\f2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e2O\b\u0002\u0010\u0019\u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¨\u0006&"}, d2 = {"Lcom/huachenjie/common/util/PicturePreviewUtil;", "", "Landroid/view/View;", "view", "", "img", "", "i", "Landroid/content/Context;", "context", "", "imgList", "", "position", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "findViewFunc", y6b.g, "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Lkotlin/Function3;", "url", "Landroid/widget/ImageView;", "imageView", "imgLoadFunc", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "pageChangeListener", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "d", "Landroidx/fragment/app/Fragment;", "fragment", "e", "activityOrFragment", "k", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class PicturePreviewUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PicturePreviewUtil f33906a = new PicturePreviewUtil();

    @JvmStatic
    public static final void h(@NotNull Context context, @NotNull List<String> imgList, int position, @NotNull Function1<? super Integer, ? extends View> findViewFunc) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imgList, "imgList");
        Intrinsics.checkNotNullParameter(findViewFunc, "findViewFunc");
        Activity activityX = a.x(context);
        if (activityX == null) {
            return;
        }
        l(f33906a, activityX, imgList, position, findViewFunc, null, null, null, 112, null);
    }

    @JvmStatic
    public static final void i(@NotNull final View view, @NotNull String img) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(img, "img");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        h(context, CollectionsKt.listOf(img), 0, new Function1<Integer, View>() { // from class: com.huachenjie.common.util.PicturePreviewUtil$previewImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Nullable
            public final View invoke(int i) {
                return view;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        });
    }

    public static /* synthetic */ void j(Context context, List list, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        h(context, list, i, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(PicturePreviewUtil picturePreviewUtil, Object obj, List list, int i, Function1 function1, Function3 function3, ViewPager.OnPageChangeListener onPageChangeListener, DialogInterface.OnDismissListener onDismissListener, int i2, Object obj2) {
        picturePreviewUtil.k(obj, list, i, function1, (i2 & 16) != 0 ? null : function3, (i2 & 32) != 0 ? null : onPageChangeListener, (i2 & 64) != 0 ? null : onDismissListener);
    }

    public static final void m(Function3 function3, Object obj, int i, Object obj2, ImageView imageView) {
        Intrinsics.checkNotNullParameter(obj, "$activityOrFragment");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (function3 == null) {
            (obj instanceof Activity ? Glide.with((Activity) obj) : Glide.with((Fragment) obj)).load(obj2).into(imageView);
            return;
        }
        Integer numValueOf = Integer.valueOf(i);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        function3.invoke(numValueOf, (String) obj2, imageView);
    }

    public static final View n(Function1 function1, int i) {
        Intrinsics.checkNotNullParameter(function1, "$findViewFunc");
        return (View) function1.invoke(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewImgWithFragmentOrActivity$lambda$1(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            onDismissListener.onDismiss(null);
        }
    }

    public final void d(@NotNull Activity activity, @NotNull List<String> imgList, int position, @NotNull Function1<? super Integer, ? extends View> findViewFunc, @Nullable Function3<? super Integer, ? super String, ? super ImageView, Unit> imgLoadFunc, @Nullable ViewPager.OnPageChangeListener pageChangeListener, @Nullable DialogInterface.OnDismissListener dismissListener) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(imgList, "imgList");
        Intrinsics.checkNotNullParameter(findViewFunc, "findViewFunc");
        k(activity, imgList, position, findViewFunc, imgLoadFunc, pageChangeListener, dismissListener);
    }

    public final void e(@NotNull Fragment fragment, @NotNull List<String> imgList, int position, @NotNull Function1<? super Integer, ? extends View> findViewFunc, @Nullable Function3<? super Integer, ? super String, ? super ImageView, Unit> imgLoadFunc, @Nullable ViewPager.OnPageChangeListener pageChangeListener, @Nullable DialogInterface.OnDismissListener dismissListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(imgList, "imgList");
        Intrinsics.checkNotNullParameter(findViewFunc, "findViewFunc");
        k(fragment, imgList, position, findViewFunc, imgLoadFunc, pageChangeListener, dismissListener);
    }

    public final void k(@NotNull final Object activityOrFragment, @NotNull List<String> imgList, int position, @NotNull final Function1<? super Integer, ? extends View> findViewFunc, @Nullable final Function3<? super Integer, ? super String, ? super ImageView, Unit> imgLoadFunc, @Nullable ViewPager.OnPageChangeListener pageChangeListener, @Nullable final DialogInterface.OnDismissListener dismissListener) {
        Intrinsics.checkNotNullParameter(activityOrFragment, "activityOrFragment");
        Intrinsics.checkNotNullParameter(imgList, "imgList");
        Intrinsics.checkNotNullParameter(findViewFunc, "findViewFunc");
        PhotoPreview.J(activityOrFragment).d(position).a(200L).h(1).x(imgList).g(new ImageLoader() { // from class: com.zj.adlib.gr6
            public final void a(int i, Object obj, ImageView imageView) {
                PicturePreviewUtil.m(imgLoadFunc, activityOrFragment, i, obj, imageView);
            }
        }).m(pageChangeListener).k(new OnDismissListener() { // from class: com.zj.adlib.hr6
            public final void onDismiss() {
                PicturePreviewUtil.previewImgWithFragmentOrActivity$lambda$1(dismissListener);
            }
        }).b().G(new IFindThumbnailView() { // from class: com.zj.adlib.ir6
            public final View a(int i) {
                return PicturePreviewUtil.n(findViewFunc, i);
            }
        });
    }
}
