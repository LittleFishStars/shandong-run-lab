package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.mall.page.comment.write.WriteReviewImageAdapter;
import com.huachenjie.mall.page.comment.write.WriteReviewVM;
import com.huachenjie.mall.widget.CommentStarView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityWriteReviewBindingImpl extends MallActivityWriteReviewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckBox f10491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f10493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10495a;
    public InverseBindingListener b;

    @NonNull
    public final TextView c;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((MallActivityWriteReviewBinding) MallActivityWriteReviewBindingImpl.this).f10480a);
            WriteReviewVM writeReviewVM = ((MallActivityWriteReviewBinding) MallActivityWriteReviewBindingImpl.this).f10486a;
            if (writeReviewVM != null) {
                MutableLiveData<String> mutableLiveDataO = writeReviewVM.o();
                if (mutableLiveDataO != null) {
                    mutableLiveDataO.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            boolean zIsChecked = MallActivityWriteReviewBindingImpl.this.f10491a.isChecked();
            WriteReviewVM writeReviewVM = ((MallActivityWriteReviewBinding) MallActivityWriteReviewBindingImpl.this).f10486a;
            if (writeReviewVM != null) {
                MutableLiveData<Boolean> mutableLiveDataM = writeReviewVM.m();
                if (mutableLiveDataM != null) {
                    mutableLiveDataM.setValue(Boolean.valueOf(zIsChecked));
                }
            }
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WriteReviewActivity.a f34891a;

        public c a(WriteReviewActivity.a aVar) {
            this.f34891a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34891a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        f10489a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{9}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34888a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.v_split_line, 10);
        sparseIntArray.put(com.huachenjie.mall.R.id.des_star, 11);
        sparseIntArray.put(com.huachenjie.mall.R.id.logistics_star, 12);
        sparseIntArray.put(com.huachenjie.mall.R.id.merchants_star, 13);
    }

    public MallActivityWriteReviewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f10489a, f34888a));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x010b  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String goodsSpec;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        BindingTitleBean value;
        WriteReviewImageAdapter value2;
        String value3;
        String str;
        String goodsName;
        String str2;
        c cVarA;
        boolean z;
        String value4;
        synchronized (this) {
            j = this.f10490a;
            this.f10490a = 0L;
        }
        WriteReviewVM writeReviewVM = ((MallActivityWriteReviewBinding) this).f10486a;
        WriteReviewActivity.a aVar = ((MallActivityWriteReviewBinding) this).f10485a;
        long j2 = 1408 & j;
        RequestOptions requestOptions = j2 != 0 ? ju3.h : null;
        if ((1534 & j) != 0) {
            if ((j & 1282) != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = writeReviewVM != null ? writeReviewVM.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 1284) != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = writeReviewVM != null ? writeReviewVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 1288) == 0) {
                value3 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataP = writeReviewVM != null ? writeReviewVM.p() : null;
                updateLiveDataRegistration(3, mediatorLiveDataP);
                if (mediatorLiveDataP != null) {
                    value3 = mediatorLiveDataP.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 1296) == 0) {
                value4 = null;
            } else {
                MutableLiveData<String> mutableLiveDataO = writeReviewVM != null ? writeReviewVM.o() : null;
                updateLiveDataRegistration(4, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value4 = mutableLiveDataO.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 1312) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = writeReviewVM != null ? writeReviewVM.i() : null;
                updateLiveDataRegistration(5, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 1344) == 0) {
                value2 = null;
            } else {
                MediatorLiveData<WriteReviewImageAdapter> mediatorLiveDataS = writeReviewVM != null ? writeReviewVM.s() : null;
                updateLiveDataRegistration(6, mediatorLiveDataS);
                if (mediatorLiveDataS != null) {
                    value2 = mediatorLiveDataS.getValue();
                } else {
                    value2 = null;
                }
            }
            if (j2 == 0) {
                str2 = value4;
                goodsSpec = null;
                str = null;
                goodsName = null;
            } else {
                MutableLiveData<OrderGoodsBean> mutableLiveDataR = writeReviewVM != null ? writeReviewVM.r() : null;
                updateLiveDataRegistration(7, mutableLiveDataR);
                OrderGoodsBean value5 = mutableLiveDataR != null ? mutableLiveDataR.getValue() : null;
                if (value5 != null) {
                    goodsName = value5.getGoodsName();
                    String goodsImage = value5.getGoodsImage();
                    goodsSpec = value5.getGoodsSpec();
                    str2 = value4;
                    str = goodsImage;
                } else {
                    str2 = value4;
                    goodsSpec = null;
                    str = null;
                    goodsName = null;
                }
            }
        } else {
            goodsSpec = null;
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            value = null;
            value2 = null;
            value3 = null;
            str = null;
            goodsName = null;
            str2 = null;
        }
        long j3 = j & 1536;
        if (j3 == 0 || aVar == null) {
            cVarA = null;
        } else {
            c cVar = this.f10494a;
            if (cVar == null) {
                cVar = new c();
                this.f10494a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if ((j & 1296) != 0) {
            TextViewBindingAdapter.setText(((MallActivityWriteReviewBinding) this).f10480a, str2);
        }
        if ((1024 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((MallActivityWriteReviewBinding) this).f10480a, null, null, null, this.f10493a);
            CompoundButtonBindingAdapter.setListeners(this.f10491a, null, this.b);
        }
        if ((1288 & j) != 0) {
            TextViewBindingAdapter.setText(((MallActivityWriteReviewBinding) this).f10481a, value3);
        }
        if ((1344 & j) != 0) {
            z = false;
            CommonBindingAdapter.g(((MallActivityWriteReviewBinding) this).f10482a, value2, false, false);
        } else {
            z = false;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((MallActivityWriteReviewBinding) this).f10483a, str, requestOptions, z);
            TextViewBindingAdapter.setText(this.c, goodsSpec);
            TextViewBindingAdapter.setText(((MallActivityWriteReviewBinding) this).b, goodsName);
        }
        if ((j & 1284) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.f10491a, zSafeUnbox2);
        }
        if ((j & 1282) != 0) {
            CommonBindingAdapter.e0(this.f10495a, zSafeUnbox);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f10495a, cVarA, null);
        }
        if ((j & 1312) != 0) {
            ((MallActivityWriteReviewBinding) this).f10484a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityWriteReviewBinding) this).f10484a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10490a != 0) {
                return true;
            }
            return ((MallActivityWriteReviewBinding) this).f10484a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10490a = 1024L;
        }
        ((MallActivityWriteReviewBinding) this).f10484a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityWriteReviewBinding
    public void l(@Nullable WriteReviewActivity.a aVar) {
        ((MallActivityWriteReviewBinding) this).f10485a = aVar;
        synchronized (this) {
            this.f10490a |= 512;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityWriteReviewBinding
    public void m(@Nullable WriteReviewVM writeReviewVM) {
        ((MallActivityWriteReviewBinding) this).f10486a = writeReviewVM;
        synchronized (this) {
            this.f10490a |= 256;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean o(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10490a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return o((LayoutToolbarBindingBinding) obj, i2);
            case 1:
                return q((MutableLiveData) obj, i2);
            case 2:
                return p((MutableLiveData) obj, i2);
            case 3:
                return s((MediatorLiveData) obj, i2);
            case 4:
                return r((MutableLiveData) obj, i2);
            case 5:
                return v((MutableLiveData) obj, i2);
            case 6:
                return u((MediatorLiveData) obj, i2);
            case 7:
                return t((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10490a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10490a |= 2;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10490a |= 16;
        }
        return true;
    }

    public final boolean s(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10490a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityWriteReviewBinding) this).f10484a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((WriteReviewVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((WriteReviewActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<OrderGoodsBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10490a |= 128;
        }
        return true;
    }

    public final boolean u(MediatorLiveData<WriteReviewImageAdapter> mediatorLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10490a |= 64;
        }
        return true;
    }

    public final boolean v(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10490a |= 32;
        }
        return true;
    }

    public MallActivityWriteReviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (CommentStarView) objArr[11], (EditText) objArr[4], (TextView) objArr[5], (RecyclerView) objArr[6], (RoundImageView) objArr[1], (CommentStarView) objArr[12], (CommentStarView) objArr[13], (LayoutToolbarBindingBinding) objArr[9], (TextView) objArr[2], (View) objArr[10]);
        this.f10493a = new a();
        this.b = new b();
        this.f10490a = -1L;
        ((MallActivityWriteReviewBinding) this).f10480a.setTag(null);
        ((MallActivityWriteReviewBinding) this).f10481a.setTag(null);
        ((MallActivityWriteReviewBinding) this).f10482a.setTag(null);
        ((MallActivityWriteReviewBinding) this).f10483a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10492a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.c = textView;
        textView.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[7];
        this.f10491a = checkBox;
        checkBox.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[8];
        this.f10495a = bLTextView;
        bLTextView.setTag(null);
        setContainedBinding(((MallActivityWriteReviewBinding) this).f10484a);
        ((MallActivityWriteReviewBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
