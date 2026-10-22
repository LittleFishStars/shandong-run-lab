package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.dsbridge_webview.SpineWebView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.dormitory.DormitoryVM;
import com.huachenjie.works.widget.EnergyCircleView;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityDormitoryBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SpineWebView f13852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DormitoryVM f13853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EnergyCircleView f13854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f13855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f13856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f13857a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13858b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f13859b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f13860b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13861c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f13862d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f13863e;

    public WorksActivityDormitoryBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clCharmCard, BLFrameLayout flTitle, ImageView ivAddEnergy, ImageView ivAddGold, ImageView ivBack, ImageView ivCharmIcon, ImageView ivRule, BLFrameLayout llBottomMenu, BLLinearLayout llTopInfo, RecyclerView rvMenu, SpineWebView spCharacter, TextView tvCharmLabel, TextView tvCharmValue, TextView tvCoin, TextView tvHeart, TextView tvTitle, BLView vCharmBottom, BLView viewCharmBg, EnergyCircleView viewEnergy) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f13850a = clCharmCard;
        this.f13855a = flTitle;
        this.f36778a = ivAddEnergy;
        this.b = ivAddGold;
        this.c = ivBack;
        this.d = ivCharmIcon;
        this.e = ivRule;
        this.f13859b = llBottomMenu;
        this.f13856a = llTopInfo;
        this.f13851a = rvMenu;
        this.f13852a = spCharacter;
        this.f13849a = tvCharmLabel;
        this.f13858b = tvCharmValue;
        this.f13861c = tvCoin;
        this.f13862d = tvHeart;
        this.f13863e = tvTitle;
        this.f13857a = vCharmBottom;
        this.f13860b = viewCharmBg;
        this.f13854a = viewEnergy;
    }

    public static WorksActivityDormitoryBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityDormitoryBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityDormitoryBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_dormitory);
    }

    @NonNull
    public static WorksActivityDormitoryBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityDormitoryBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityDormitoryBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityDormitoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_dormitory, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityDormitoryBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityDormitoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_dormitory, null, false, component);
    }

    @Nullable
    public DormitoryVM f() {
        return this.f13853a;
    }

    public abstract void k(@Nullable DormitoryVM vm);
}
