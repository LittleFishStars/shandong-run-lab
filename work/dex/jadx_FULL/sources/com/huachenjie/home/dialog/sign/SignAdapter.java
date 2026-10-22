package com.huachenjie.home.dialog.sign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.SignBean;
import com.zj.adlib.xk0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/home/dialog/sign/SignAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/home/bean/SignBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "()V", "convert", "", "holder", "item", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignAdapter extends BaseMultiItemQuickAdapter<SignBean, BaseDataBindingHolder<? extends ViewDataBinding>> {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/home/dialog/sign/SignAdapter$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", com.ipd.dsp.internal.l.a.l, "", "onAnimationEnd", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f34317a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ BaseDataBindingHolder<? extends ViewDataBinding> f9600a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SignBean f9601a;

        public a(LottieAnimationView lottieAnimationView, SignBean signBean, BaseDataBindingHolder<? extends ViewDataBinding> baseDataBindingHolder) {
            this.f34317a = lottieAnimationView;
            this.f9601a = signBean;
            this.f9600a = baseDataBindingHolder;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, com.ipd.dsp.internal.l.a.l);
            this.f34317a.removeAnimatorListener(this);
            this.f9601a.setFromSign(false);
            ViewDataBinding dataBinding = this.f9600a.getDataBinding();
            if (dataBinding != null) {
                dataBinding.setVariable(xk0.g, this.f9601a);
                dataBinding.executePendingBindings();
            }
        }
    }

    public SignAdapter() {
        super(null, 1, null);
        addItemType(1, R.layout.home_item_sign);
        addItemType(2, R.layout.home_item_sign_7_extra);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<? extends ViewDataBinding> holder, @NotNull SignBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            dataBinding.setVariable(xk0.g, item);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) holder.getViewOrNull(R.id.lottie_coin);
            if (lottieAnimationView != null) {
                lottieAnimationView.removeAllAnimatorListeners();
            }
            if (item.getFromSign() && lottieAnimationView != null) {
                lottieAnimationView.addAnimatorListener(new a(lottieAnimationView, item, holder));
                lottieAnimationView.setProgress(0.0f);
                lottieAnimationView.setSpeed(2.0f);
                lottieAnimationView.playAnimation();
            }
            dataBinding.executePendingBindings();
        }
    }
}
