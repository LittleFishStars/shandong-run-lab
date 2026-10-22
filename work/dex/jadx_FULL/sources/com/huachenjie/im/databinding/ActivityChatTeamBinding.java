package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.im.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class ActivityChatTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f9649a;

    @NonNull
    public final ImageView b;

    public ActivityChatTeamBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.f34405a = frameLayout;
        this.f9647a = imageView;
        this.b = imageView2;
        this.f9648a = textView;
    }

    public static ActivityChatTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChatTeamBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityChatTeamBinding) ViewDataBinding.bind(obj, view, R.layout.activity_chat_team);
    }

    @NonNull
    public static ActivityChatTeamBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityChatTeamBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChatTeamBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_team, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityChatTeamBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_team, null, false, obj);
    }

    @Nullable
    public BaseVM f() {
        return this.f9649a;
    }

    public abstract void k(@Nullable BaseVM baseVM);
}
