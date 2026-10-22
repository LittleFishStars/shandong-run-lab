package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewVM;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityGoodsSpecificationPreviewBindingImpl extends MallActivityGoodsSpecificationPreviewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10236a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f10238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10241a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsSpecificationPreviewActivity.a f34801a;

        public a a(GoodsSpecificationPreviewActivity.a aVar) {
            this.f34801a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34801a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34800a = sparseIntArray;
        sparseIntArray.put(R.id.view_pager, 3);
    }

    public MallActivityGoodsSpecificationPreviewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10236a, f34800a));
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:64:0x0103  */
    /* JADX WARN: Code duplicated, block: B:67:0x0110  */
    /* JADX WARN: Code duplicated, block: B:70:0x011c  */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        long j2;
        a aVarA;
        int iSafeUnbox;
        int iSafeUnbox2;
        MutableLiveData<Integer> mutableLiveDataI;
        MutableLiveData<List<GoodsDetailSpecValue>> mutableLiveData;
        synchronized (this) {
            j = this.f10237a;
            this.f10237a = 0L;
        }
        GoodsSpecificationPreviewVM goodsSpecificationPreviewVM = ((MallActivityGoodsSpecificationPreviewBinding) this).f10235a;
        GoodsSpecificationPreviewActivity.a aVar = ((MallActivityGoodsSpecificationPreviewBinding) this).f10234a;
        if ((95 & j) != 0) {
            if ((j & 81) != 0) {
                MutableLiveData<Integer> mutableLiveDataJ = goodsSpecificationPreviewVM != null ? goodsSpecificationPreviewVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 84) != 0) {
                BaseViewModel.b bVarE = goodsSpecificationPreviewVM != null ? goodsSpecificationPreviewVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 10));
            } else {
                iSafeUnbox2 = 0;
            }
            if ((j & 90) != 0) {
                if (goodsSpecificationPreviewVM != null) {
                    MutableLiveData<List<GoodsDetailSpecValue>> mutableLiveDataK = goodsSpecificationPreviewVM.k();
                    mutableLiveDataI = goodsSpecificationPreviewVM.i();
                    mutableLiveData = mutableLiveDataK;
                } else {
                    mutableLiveDataI = null;
                    mutableLiveData = null;
                }
                updateLiveDataRegistration(1, mutableLiveData);
                updateLiveDataRegistration(3, mutableLiveDataI);
                List<GoodsDetailSpecValue> value = mutableLiveData != null ? mutableLiveData.getValue() : null;
                str = String.format("%d/%d", Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataI != null ? mutableLiveDataI.getValue() : null) + 1), Integer.valueOf(value != null ? value.size() : 0));
                i2 = iSafeUnbox;
                i = iSafeUnbox2;
            } else {
                i2 = iSafeUnbox;
                i = iSafeUnbox2;
            }
            j2 = 96 & j;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
            } else {
                a aVar2 = this.f10239a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f10239a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((j & 84) != 0) {
                CommonBindingAdapter.I(this.f10240a, 0, i, 0, 0, null);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f10240a, aVarA, null);
            }
            if ((90 & j) != 0) {
                TextViewBindingAdapter.setText(this.f10241a, str);
            }
            if ((j & 81) != 0) {
                CommonBindingAdapter.I(this.f10241a, 0, 0, 0, i2, null);
            }
        }
        i = 0;
        i2 = 0;
        str = null;
        j2 = 96 & j;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((j & 84) != 0) {
            CommonBindingAdapter.I(this.f10240a, 0, i, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10240a, aVarA, null);
        }
        if ((90 & j) != 0) {
            TextViewBindingAdapter.setText(this.f10241a, str);
        }
        if ((j & 81) != 0) {
            CommonBindingAdapter.I(this.f10241a, 0, 0, 0, i2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10237a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10237a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityGoodsSpecificationPreviewBinding
    public void l(@Nullable GoodsSpecificationPreviewActivity.a aVar) {
        ((MallActivityGoodsSpecificationPreviewBinding) this).f10234a = aVar;
        synchronized (this) {
            this.f10237a |= 32;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityGoodsSpecificationPreviewBinding
    public void m(@Nullable GoodsSpecificationPreviewVM goodsSpecificationPreviewVM) {
        ((MallActivityGoodsSpecificationPreviewBinding) this).f10235a = goodsSpecificationPreviewVM;
        synchronized (this) {
            this.f10237a |= 16;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10237a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10237a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<List<GoodsDetailSpecValue>> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10237a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10237a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((GoodsSpecificationPreviewVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((GoodsSpecificationPreviewActivity.a) obj);
        }
        return true;
    }

    public MallActivityGoodsSpecificationPreviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ViewPager2) objArr[3]);
        this.f10237a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f10238a = relativeLayout;
        relativeLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) objArr[1];
        this.f10240a = bLImageView;
        bLImageView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f10241a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
