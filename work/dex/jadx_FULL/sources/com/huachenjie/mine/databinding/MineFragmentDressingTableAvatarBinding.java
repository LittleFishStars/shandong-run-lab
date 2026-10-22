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
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentDressingTableAvatarBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public AvatarFragment.a f35305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AvatarVM f11223a;

    public MineFragmentDressingTableAvatarBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MineFragmentDressingTableAvatarBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentDressingTableAvatarBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentDressingTableAvatarBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_dressing_table_avatar);
    }

    @NonNull
    public static MineFragmentDressingTableAvatarBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentDressingTableAvatarBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentDressingTableAvatarBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentDressingTableAvatarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_dressing_table_avatar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentDressingTableAvatarBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentDressingTableAvatarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_dressing_table_avatar, null, false, obj);
    }

    @Nullable
    public AvatarFragment.a f() {
        return this.f35305a;
    }

    @Nullable
    public AvatarVM g() {
        return this.f11223a;
    }

    public abstract void l(@Nullable AvatarFragment.a aVar);

    public abstract void m(@Nullable AvatarVM avatarVM);
}
