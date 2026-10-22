package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.PosterDetailBean;
import com.huachenjie.mall.dialog.poster.CreatePosterDialog;
import com.huachenjie.mall.dialog.poster.CreatePosterVM;
import com.huachenjie.mall.dialog.poster.PosterBgAdapter;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.aw9;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallDialogCreatePosterBindingImpl extends MallDialogCreatePosterBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10535a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f10541a;

    @NonNull
    public final LinearLayout b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreatePosterDialog.a f34903a;

        public a a(CreatePosterDialog.a aVar) {
            this.f34903a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34903a.d(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreatePosterDialog.a f34904a;

        public b a(CreatePosterDialog.a aVar) {
            this.f34904a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34904a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreatePosterDialog.a f34905a;

        public c a(CreatePosterDialog.a aVar) {
            this.f34905a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34905a.a(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreatePosterDialog.a f34906a;

        public d a(CreatePosterDialog.a aVar) {
            this.f34906a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34906a.c(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34902a = sparseIntArray;
        sparseIntArray.put(R.id.v_share, 16);
        sparseIntArray.put(R.id.ll_poster_title, 17);
        sparseIntArray.put(R.id.v_container, 18);
        sparseIntArray.put(R.id.tv_scan_tip, 19);
        sparseIntArray.put(R.id.iv_goods_qr_code, 20);
        sparseIntArray.put(R.id.tv_user_recommend, 21);
        sparseIntArray.put(R.id.v_split_line, 22);
    }

    public MallDialogCreatePosterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, f10535a, f34902a));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0194  */
    /* JADX WARN: Code duplicated, block: B:104:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:107:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:110:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:69:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0153  */
    /* JADX WARN: Code duplicated, block: B:94:0x0163  */
    /* JADX WARN: Code duplicated, block: B:95:0x0171  */
    /* JADX WARN: Code duplicated, block: B:97:0x017a  */
    /* JADX WARN: Code duplicated, block: B:99:0x018d  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CharSequence oldPrice;
        String value;
        String value2;
        CharSequence price;
        String value3;
        PosterBgAdapter value4;
        String value5;
        String imageUrl;
        long j2;
        RequestOptions requestOptions;
        long j3;
        RequestOptions requestOptions2;
        long j4;
        d dVar;
        b bVar;
        c cVarA;
        a aVar;
        boolean z;
        synchronized (this) {
            j = this.f10536a;
            this.f10536a = 0L;
        }
        CreatePosterVM createPosterVM = ((MallDialogCreatePosterBinding) this).f10527a;
        CreatePosterDialog.a aVar2 = ((MallDialogCreatePosterBinding) this).f10526a;
        if ((383 & j) != 0) {
            if ((j & 321) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = createPosterVM != null ? createPosterVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 322) == 0) {
                value5 = null;
            } else {
                MutableLiveData<String> mutableLiveDataN = createPosterVM != null ? createPosterVM.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value5 = mutableLiveDataN.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 324) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = createPosterVM != null ? createPosterVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value3 = mutableLiveDataJ.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 328) == 0) {
                value4 = null;
            } else {
                MutableLiveData<PosterBgAdapter> mutableLiveDataI = createPosterVM != null ? createPosterVM.i() : null;
                updateLiveDataRegistration(3, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value4 = mutableLiveDataI.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 336) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = createPosterVM != null ? createPosterVM.k() : null;
                updateLiveDataRegistration(4, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 352) != 0) {
                MutableLiveData<PosterDetailBean> mutableLiveDataM = createPosterVM != null ? createPosterVM.m() : null;
                updateLiveDataRegistration(5, mutableLiveDataM);
                PosterDetailBean value6 = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
                if (value6 != null) {
                    price = value6.formatPrice();
                    imageUrl = value6.getImageUrl();
                    oldPrice = value6.formatOldPrice();
                }
                j2 = j & 322;
                if (j2 != 0) {
                    requestOptions = ju3.z;
                } else {
                    requestOptions = null;
                }
                j3 = j & 352;
                if (j3 != 0) {
                    requestOptions2 = ju3.p;
                } else {
                    requestOptions2 = null;
                }
                j4 = j & 384;
                if (j4 != 0 || aVar2 == null) {
                    dVar = null;
                    bVar = null;
                    cVarA = null;
                    aVar = null;
                } else {
                    d dVar2 = this.f10541a;
                    if (dVar2 == null) {
                        dVar2 = new d();
                        this.f10541a = dVar2;
                    }
                    d dVarA = dVar2.a(aVar2);
                    a aVar3 = this.f10538a;
                    if (aVar3 == null) {
                        aVar3 = new a();
                        this.f10538a = aVar3;
                    }
                    a aVarA = aVar3.a(aVar2);
                    b bVar2 = this.f10539a;
                    if (bVar2 == null) {
                        bVar2 = new b();
                        this.f10539a = bVar2;
                    }
                    b bVarA = bVar2.a(aVar2);
                    c cVar = this.f10540a;
                    if (cVar == null) {
                        cVar = new c();
                        this.f10540a = cVar;
                    }
                    cVarA = cVar.a(aVar2);
                    dVar = dVarA;
                    aVar = aVarA;
                    bVar = bVarA;
                }
                if ((j & 324) != 0) {
                    z = false;
                    aw9.d(((MallDialogCreatePosterBinding) this).f10525a, value3, false, null);
                } else {
                    z = false;
                }
                if (j3 != 0) {
                    CommonBindingAdapter.b0(((MallDialogCreatePosterBinding) this).f10521a, imageUrl, requestOptions2, z);
                    TextViewBindingAdapter.setText(((MallDialogCreatePosterBinding) this).f10530b, price);
                    TextViewBindingAdapter.setText(((MallDialogCreatePosterBinding) this).f10531c, oldPrice);
                }
                if (j2 != 0) {
                    CommonBindingAdapter.b0(((MallDialogCreatePosterBinding) this).c, value5, requestOptions, z);
                }
                if (j4 != 0) {
                    CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).d, dVar, null);
                    CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).e, bVar, null);
                    CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).f, aVar, null);
                    CommonBindingAdapter.q(this.b, cVarA, null);
                    CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).f10528a, cVarA, null);
                    CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).f10533e, dVar, null);
                    CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).f10534f, bVar, null);
                    CommonBindingAdapter.q(this.g, aVar, null);
                }
                if ((j & 328) != 0) {
                    CommonBindingAdapter.g(this.f10537a, value4, false, false);
                }
                if ((j & 336) != 0) {
                    TextViewBindingAdapter.setText(((MallDialogCreatePosterBinding) this).f10523a, value2);
                }
                if ((j & 321) != 0) {
                    TextViewBindingAdapter.setText(this.h, value);
                }
            }
            oldPrice = null;
            price = null;
        } else {
            oldPrice = null;
            value = null;
            value2 = null;
            price = null;
            value3 = null;
            value4 = null;
            value5 = null;
        }
        imageUrl = null;
        j2 = j & 322;
        if (j2 != 0) {
            requestOptions = ju3.z;
        } else {
            requestOptions = null;
        }
        j3 = j & 352;
        if (j3 != 0) {
            requestOptions2 = ju3.p;
        } else {
            requestOptions2 = null;
        }
        j4 = j & 384;
        if (j4 != 0) {
            dVar = null;
            bVar = null;
            cVarA = null;
            aVar = null;
        } else {
            dVar = null;
            bVar = null;
            cVarA = null;
            aVar = null;
        }
        if ((j & 324) != 0) {
            z = false;
            aw9.d(((MallDialogCreatePosterBinding) this).f10525a, value3, false, null);
        } else {
            z = false;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(((MallDialogCreatePosterBinding) this).f10521a, imageUrl, requestOptions2, z);
            TextViewBindingAdapter.setText(((MallDialogCreatePosterBinding) this).f10530b, price);
            TextViewBindingAdapter.setText(((MallDialogCreatePosterBinding) this).f10531c, oldPrice);
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((MallDialogCreatePosterBinding) this).c, value5, requestOptions, z);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).d, dVar, null);
            CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).e, bVar, null);
            CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).f, aVar, null);
            CommonBindingAdapter.q(this.b, cVarA, null);
            CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).f10528a, cVarA, null);
            CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).f10533e, dVar, null);
            CommonBindingAdapter.q(((MallDialogCreatePosterBinding) this).f10534f, bVar, null);
            CommonBindingAdapter.q(this.g, aVar, null);
        }
        if ((j & 328) != 0) {
            CommonBindingAdapter.g(this.f10537a, value4, false, false);
        }
        if ((j & 336) != 0) {
            TextViewBindingAdapter.setText(((MallDialogCreatePosterBinding) this).f10523a, value2);
        }
        if ((j & 321) != 0) {
            TextViewBindingAdapter.setText(this.h, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10536a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10536a = 256L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogCreatePosterBinding
    public void l(@Nullable CreatePosterDialog.a aVar) {
        ((MallDialogCreatePosterBinding) this).f10526a = aVar;
        synchronized (this) {
            this.f10536a |= 128;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogCreatePosterBinding
    public void m(@Nullable CreatePosterVM createPosterVM) {
        ((MallDialogCreatePosterBinding) this).f10527a = createPosterVM;
        synchronized (this) {
            this.f10536a |= 64;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<PosterBgAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10536a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10536a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return s((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 4) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return r((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10536a |= 16;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10536a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<PosterDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10536a |= 32;
        }
        return true;
    }

    public final boolean s(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10536a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((CreatePosterVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((CreatePosterDialog.a) obj);
        }
        return true;
    }

    public MallDialogCreatePosterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (AvatarView) objArr[6], (ImageView) objArr[2], (ImageView) objArr[20], (ImageView) objArr[1], (ImageView) objArr[13], (ImageView) objArr[11], (ImageView) objArr[9], (LinearLayout) objArr[17], (BLTextView) objArr[15], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[19], (TextView) objArr[14], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[7], (TextView) objArr[21], (BLView) objArr[18], (ConstraintLayout) objArr[16], (View) objArr[22]);
        this.f10536a = -1L;
        ((MallDialogCreatePosterBinding) this).f10525a.setTag(null);
        ((MallDialogCreatePosterBinding) this).f10521a.setTag(null);
        ((MallDialogCreatePosterBinding) this).c.setTag(null);
        ((MallDialogCreatePosterBinding) this).d.setTag(null);
        ((MallDialogCreatePosterBinding) this).e.setTag(null);
        ((MallDialogCreatePosterBinding) this).f.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[8];
        this.f10537a = recyclerView;
        recyclerView.setTag(null);
        ((MallDialogCreatePosterBinding) this).f10528a.setTag(null);
        ((MallDialogCreatePosterBinding) this).f10523a.setTag(null);
        ((MallDialogCreatePosterBinding) this).f10530b.setTag(null);
        ((MallDialogCreatePosterBinding) this).f10531c.setTag(null);
        ((MallDialogCreatePosterBinding) this).f10533e.setTag(null);
        ((MallDialogCreatePosterBinding) this).f10534f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
