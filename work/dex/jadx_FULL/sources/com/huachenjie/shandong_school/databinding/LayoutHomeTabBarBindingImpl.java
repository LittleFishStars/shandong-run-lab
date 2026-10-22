package com.huachenjie.shandong_school.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.BottomIconView;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.home.HomeActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LayoutHomeTabBarBindingImpl extends LayoutHomeTabBarBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12665a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12667a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36042a = sparseIntArray;
        sparseIntArray.put(R.id.bivHome, 1);
        sparseIntArray.put(R.id.bivAlumni, 2);
        sparseIntArray.put(R.id.bivFlashCoins, 3);
        sparseIntArray.put(R.id.bivMessage, 4);
        sparseIntArray.put(R.id.bivMine, 5);
    }

    public LayoutHomeTabBarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f12665a, f36042a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12666a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12666a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12666a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.shandong_school.databinding.LayoutHomeTabBarBinding
    public void k(@Nullable HomeActivity.a aVar) {
        ((LayoutHomeTabBarBinding) this).f12664a = aVar;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (10 != i) {
            return false;
        }
        k((HomeActivity.a) obj);
        return true;
    }

    public LayoutHomeTabBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BottomIconView) objArr[2], (BottomIconView) objArr[3], (BottomIconView) objArr[1], (BottomIconView) objArr[4], (BottomIconView) objArr[5]);
        this.f12666a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12667a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
