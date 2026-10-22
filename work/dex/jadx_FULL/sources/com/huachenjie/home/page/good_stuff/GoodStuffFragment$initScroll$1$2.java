package com.huachenjie.home.page.good_stuff;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.home.databinding.HomeFragmentGoodStuffBinding;
import com.huachenjie.home.page.good_stuff.GoodStuffFragment$initScroll$1$2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/home/page/good_stuff/GoodStuffFragment$initScroll$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoodStuffFragment$initScroll$1$2 implements RecyclerView.OnChildAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomeFragmentGoodStuffBinding f34352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ GoodStuffFragment f9612a;

    public GoodStuffFragment$initScroll$1$2(GoodStuffFragment goodStuffFragment, HomeFragmentGoodStuffBinding homeFragmentGoodStuffBinding) {
        this.f9612a = goodStuffFragment;
        this.f34352a = homeFragmentGoodStuffBinding;
    }

    public static final void b(GoodStuffFragment goodStuffFragment, View view) {
        Intrinsics.checkNotNullParameter(goodStuffFragment, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        goodStuffFragment.setFirstItemHeight(view.getHeight());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!this.f9612a.hasScroll) {
            this.f9612a.changeMaxPosition();
        }
        if (this.f34352a.f34247a.getChildAdapterPosition(view) == 0) {
            final GoodStuffFragment goodStuffFragment = this.f9612a;
            view.post(new Runnable() { // from class: com.zj.adlib.ev3
                @Override // java.lang.Runnable
                public final void run() {
                    GoodStuffFragment$initScroll$1$2.b(goodStuffFragment, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
