package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.preview.ImagePreviewActivity;
import com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView;
import com.noober.background.view.BLImageView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityBannerPreviewBindingImpl extends MallActivityBannerPreviewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10145a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10149a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImagePreviewActivity.a f34773a;

        public a a(ImagePreviewActivity.a aVar) {
            this.f34773a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34773a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34772a = sparseIntArray;
        sparseIntArray.put(R.id.banner_view, 2);
    }

    public MallActivityBannerPreviewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10145a, f34772a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f10146a;
            this.f10146a = 0L;
        }
        BaseViewModel baseViewModel = ((MallActivityBannerPreviewBinding) this).f34771a;
        ImagePreviewActivity.a aVar = ((MallActivityBannerPreviewBinding) this).f10143a;
        long j2 = 11 & j;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = baseViewModel != null ? baseViewModel.e() : null;
            MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
            updateLiveDataRegistration(0, mutableLiveDataB);
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 10));
        }
        int i = iSafeUnbox;
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f10148a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10148a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.I(this.f10149a, 0, i, 0, 0, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f10149a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10146a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10146a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityBannerPreviewBinding
    public void l(@Nullable ImagePreviewActivity.a aVar) {
        ((MallActivityBannerPreviewBinding) this).f10143a = aVar;
        synchronized (this) {
            this.f10146a |= 4;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityBannerPreviewBinding
    public void m(@Nullable BaseViewModel baseViewModel) {
        ((MallActivityBannerPreviewBinding) this).f34771a = baseViewModel;
        synchronized (this) {
            this.f10146a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10146a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((BaseViewModel) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((ImagePreviewActivity.a) obj);
        }
        return true;
    }

    public MallActivityBannerPreviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImagePreviewView) objArr[2]);
        this.f10146a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10147a = frameLayout;
        frameLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) objArr[1];
        this.f10149a = bLImageView;
        bLImageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
