package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.home.MineFragment;
import com.huachenjie.mine.page.home.MineVM;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineLayoutMineHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final HorizontalScrollView f11338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MineFragment.a f11343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MineVM f11344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f11345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f11346a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11347b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11348b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public MineLayoutMineHeaderBinding(Object obj, View view, int i, AvatarView avatarView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, BLRelativeLayout bLRelativeLayout, HorizontalScrollView horizontalScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, BLView bLView, View view2) {
        super(obj, view, i);
        this.f11342a = avatarView;
        this.f11339a = imageView;
        this.b = imageView2;
        this.f11340a = linearLayout;
        this.f11347b = linearLayout2;
        this.f11345a = bLRelativeLayout;
        this.f11338a = horizontalScrollView;
        this.f11341a = textView;
        this.f11348b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.f11346a = bLView;
        this.f35349a = view2;
    }

    public static MineLayoutMineHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineLayoutMineHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineLayoutMineHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.mine_layout_mine_header);
    }

    @NonNull
    public static MineLayoutMineHeaderBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineLayoutMineHeaderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineLayoutMineHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineLayoutMineHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_layout_mine_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineLayoutMineHeaderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineLayoutMineHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_layout_mine_header, null, false, obj);
    }

    @Nullable
    public MineFragment.a f() {
        return this.f11343a;
    }

    @Nullable
    public MineVM g() {
        return this.f11344a;
    }

    public abstract void l(@Nullable MineFragment.a aVar);

    public abstract void m(@Nullable MineVM mineVM);
}
