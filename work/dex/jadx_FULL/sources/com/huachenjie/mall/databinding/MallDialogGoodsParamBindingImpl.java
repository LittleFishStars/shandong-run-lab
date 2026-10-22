package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsParamAdapter;
import com.huachenjie.mall.page.goods_detail.GoodsParamDialog;
import com.huachenjie.mall.page.goods_detail.GoodsParamVM;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallDialogGoodsParamBindingImpl extends MallDialogGoodsParamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10560a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10564a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f10565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10566a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsParamDialog.a f34915a;

        public a a(GoodsParamDialog.a aVar) {
            this.f34915a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34915a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34914a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 4);
        sparseIntArray.put(R.id.cv_bottom, 5);
    }

    public MallDialogGoodsParamBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f10560a, f34914a));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x008a  */
    /* JADX WARN: Code duplicated, block: B:42:0x008d  */
    /* JADX WARN: Code duplicated, block: B:45:0x009d  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        GoodsParamAdapter value;
        long j2;
        a aVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f10561a;
            this.f10561a = 0L;
        }
        GoodsParamVM goodsParamVM = ((MallDialogGoodsParamBinding) this).f10559a;
        GoodsParamDialog.a aVar = ((MallDialogGoodsParamBinding) this).f10558a;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                BaseViewModel.b bVarE = goodsParamVM != null ? goodsParamVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(0, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null) + 8));
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 22) != 0) {
                MutableLiveData<GoodsParamAdapter> mutableLiveDataI = goodsParamVM != null ? goodsParamVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                    i = iSafeUnbox;
                }
                j2 = 24 & j;
                if (j2 != 0 || aVar == null) {
                    aVarA = null;
                } else {
                    a aVar2 = this.f10564a;
                    if (aVar2 == null) {
                        aVar2 = new a();
                        this.f10564a = aVar2;
                    }
                    aVarA = aVar2.a(aVar);
                }
                if (j2 != 0) {
                    CommonBindingAdapter.q(this.f10562a, aVarA, null);
                    CommonBindingAdapter.q(this.f10566a, aVarA, null);
                }
                if ((j & 22) != 0) {
                    CommonBindingAdapter.g(this.f10563a, value, false, false);
                }
                if ((j & 21) != 0) {
                    CommonBindingAdapter.I(this.f10566a, 16, 8, 16, i, null);
                }
            }
            i = iSafeUnbox;
        } else {
            i = 0;
        }
        value = null;
        j2 = 24 & j;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10562a, aVarA, null);
            CommonBindingAdapter.q(this.f10566a, aVarA, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(this.f10563a, value, false, false);
        }
        if ((j & 21) != 0) {
            CommonBindingAdapter.I(this.f10566a, 16, 8, 16, i, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10561a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10561a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogGoodsParamBinding
    public void l(@Nullable GoodsParamDialog.a aVar) {
        ((MallDialogGoodsParamBinding) this).f10558a = aVar;
        synchronized (this) {
            this.f10561a |= 8;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogGoodsParamBinding
    public void m(@Nullable GoodsParamVM goodsParamVM) {
        ((MallDialogGoodsParamBinding) this).f10559a = goodsParamVM;
        synchronized (this) {
            this.f10561a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<GoodsParamAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10561a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10561a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((GoodsParamVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((GoodsParamDialog.a) obj);
        }
        return true;
    }

    public MallDialogGoodsParamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (CardView) objArr[5], (TextView) objArr[4]);
        this.f10561a = -1L;
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) objArr[0];
        this.f10565a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10562a = imageView;
        imageView.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f10563a = recyclerView;
        recyclerView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f10566a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
