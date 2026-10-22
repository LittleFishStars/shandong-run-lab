package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.dressing_table.DressingTableVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineActivityDressingTableBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final HorizontalScrollView f35288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11169a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f11174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f11175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DressingTableVM f11177a;

    public MineActivityDressingTableBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, AvatarView avatarView, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout, HorizontalScrollView horizontalScrollView, SlidingTabLayout slidingTabLayout, TextView textView, ViewPager viewPager) {
        super(obj, view, i);
        this.f11173a = constraintLayout;
        this.f11176a = avatarView;
        this.f11169a = imageView;
        this.f11170a = linearLayout;
        this.f11171a = relativeLayout;
        this.f35288a = horizontalScrollView;
        this.f11175a = slidingTabLayout;
        this.f11172a = textView;
        this.f11174a = viewPager;
    }

    public static MineActivityDressingTableBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineActivityDressingTableBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineActivityDressingTableBinding) ViewDataBinding.bind(obj, view, R.layout.mine_activity_dressing_table);
    }

    @NonNull
    public static MineActivityDressingTableBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineActivityDressingTableBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineActivityDressingTableBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineActivityDressingTableBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_dressing_table, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineActivityDressingTableBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineActivityDressingTableBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_dressing_table, null, false, obj);
    }

    @Nullable
    public DressingTableVM f() {
        return this.f11177a;
    }

    public abstract void k(@Nullable DressingTableVM dressingTableVM);
}
