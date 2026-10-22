package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.dialog.lottery.LotteryVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class DialogLotteryBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public LotteryVM f7020a;

    public DialogLotteryBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivLottery) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f32825a = ivLottery;
    }

    public static DialogLotteryBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogLotteryBinding d(@NonNull View view, @Nullable Object component) {
        return (DialogLotteryBinding) ViewDataBinding.bind(component, view, R.layout.dialog_lottery);
    }

    @NonNull
    public static DialogLotteryBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogLotteryBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogLotteryBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (DialogLotteryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_lottery, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static DialogLotteryBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (DialogLotteryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_lottery, null, false, component);
    }

    @Nullable
    public LotteryVM f() {
        return this.f7020a;
    }

    public abstract void k(@Nullable LotteryVM vm);
}
