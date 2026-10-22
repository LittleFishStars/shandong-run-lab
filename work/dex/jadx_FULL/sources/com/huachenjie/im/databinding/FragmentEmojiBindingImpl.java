package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.input_panel.emoji.EmojiPanelView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FragmentEmojiBindingImpl extends FragmentEmojiBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34420a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9686a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9687a;

    public FragmentEmojiBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f9686a, f34420a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9687a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9687a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9687a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentEmojiBinding
    public void k(@Nullable BaseVM baseVM) {
        ((FragmentEmojiBinding) this).f9685a = baseVM;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.p0 != i) {
            return false;
        }
        k((BaseVM) obj);
        return true;
    }

    public FragmentEmojiBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EmojiPanelView) objArr[0]);
        this.f9687a = -1L;
        ((FragmentEmojiBinding) this).f34419a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
