package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentDressingTableNicknameBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f35308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NicknameFragment.a f11232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NicknameVM f11233a;

    public MineFragmentDressingTableNicknameBinding(Object obj, View view, int i, EditText editText, ImageView imageView) {
        super(obj, view, i);
        this.f35308a = editText;
        this.f11231a = imageView;
    }

    public static MineFragmentDressingTableNicknameBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentDressingTableNicknameBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentDressingTableNicknameBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_dressing_table_nickname);
    }

    @NonNull
    public static MineFragmentDressingTableNicknameBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentDressingTableNicknameBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentDressingTableNicknameBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentDressingTableNicknameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_dressing_table_nickname, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentDressingTableNicknameBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentDressingTableNicknameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_dressing_table_nickname, null, false, obj);
    }

    @Nullable
    public NicknameFragment.a f() {
        return this.f11232a;
    }

    @Nullable
    public NicknameVM g() {
        return this.f11233a;
    }

    public abstract void l(@Nullable NicknameFragment.a aVar);

    public abstract void m(@Nullable NicknameVM nicknameVM);
}
