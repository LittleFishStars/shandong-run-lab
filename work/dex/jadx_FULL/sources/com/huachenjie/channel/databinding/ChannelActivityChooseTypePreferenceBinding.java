package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.create_channel.preference.ChooseTypePreferenceVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityChooseTypePreferenceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseTypePreferenceVM f7473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7474a;

    public ChannelActivityChooseTypePreferenceBinding(Object obj, View view, int i, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView) {
        super(obj, view, i);
        this.f7474a = layoutToolbarBindingBinding;
        this.f33055a = textView;
    }

    public static ChannelActivityChooseTypePreferenceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityChooseTypePreferenceBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityChooseTypePreferenceBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_choose_type_preference);
    }

    @NonNull
    public static ChannelActivityChooseTypePreferenceBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityChooseTypePreferenceBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityChooseTypePreferenceBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityChooseTypePreferenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_choose_type_preference, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityChooseTypePreferenceBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityChooseTypePreferenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_choose_type_preference, null, false, obj);
    }

    @Nullable
    public ChooseTypePreferenceVM f() {
        return this.f7473a;
    }

    public abstract void k(@Nullable ChooseTypePreferenceVM chooseTypePreferenceVM);
}
