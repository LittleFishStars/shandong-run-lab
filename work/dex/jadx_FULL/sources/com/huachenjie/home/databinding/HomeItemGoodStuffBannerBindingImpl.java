package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemGoodStuffBannerBindingImpl extends HomeItemGoodStuffBannerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9461a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f9463a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34268a = sparseIntArray;
        sparseIntArray.put(R.id.banner, 1);
    }

    public HomeItemGoodStuffBannerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f9461a, f34268a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9462a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9462a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9462a = 1L;
        }
        requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public HomeItemGoodStuffBannerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Banner) objArr[1]);
        this.f9462a = -1L;
        CardView cardView = (CardView) objArr[0];
        this.f9463a = cardView;
        cardView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
