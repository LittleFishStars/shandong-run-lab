package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentAvatarFrameBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public AvatarFrameVM f35303a;

    public MineFragmentAvatarFrameBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MineFragmentAvatarFrameBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentAvatarFrameBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentAvatarFrameBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_avatar_frame);
    }

    @NonNull
    public static MineFragmentAvatarFrameBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentAvatarFrameBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentAvatarFrameBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentAvatarFrameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_avatar_frame, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentAvatarFrameBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentAvatarFrameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_avatar_frame, null, false, obj);
    }

    @Nullable
    public AvatarFrameVM f() {
        return this.f35303a;
    }

    public abstract void k(@Nullable AvatarFrameVM avatarFrameVM);
}
