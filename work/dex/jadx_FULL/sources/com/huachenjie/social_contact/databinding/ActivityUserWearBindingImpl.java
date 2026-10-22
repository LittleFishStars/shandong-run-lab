package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.base.dsbridge_webview.SpineWebView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.PointCardView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.UserAssetsBean;
import com.huachenjie.social_contact.page.suit.UserWearActivity;
import com.huachenjie.social_contact.page.suit.UserWearTypeAdapter;
import com.huachenjie.social_contact.page.suit.UserWearVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityUserWearBindingImpl extends ActivityUserWearBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12830a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12831a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12835a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UserWearActivity.a f36121a;

        public a a(UserWearActivity.a aVar) {
            this.f36121a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36121a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UserWearActivity.a f36122a;

        public b a(UserWearActivity.a aVar) {
            this.f36122a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36122a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UserWearActivity.a f36123a;

        public c a(UserWearActivity.a aVar) {
            this.f36123a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36123a.c(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36120a = sparseIntArray;
        sparseIntArray.put(R.id.spineWeb, 8);
        sparseIntArray.put(R.id.fl_container, 9);
    }

    public ActivityUserWearBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f12830a, f36120a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        UserWearTypeAdapter value;
        String str;
        String str2;
        String str3;
        b bVarA;
        a aVarA;
        c cVarA;
        int skinVoucher;
        int starDrill;
        int inspirationValue;
        synchronized (this) {
            j = this.f12831a;
            this.f12831a = 0L;
        }
        UserWearVM userWearVM = ((ActivityUserWearBinding) this).f12828a;
        UserWearActivity.a aVar = ((ActivityUserWearBinding) this).f12827a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<UserWearTypeAdapter> mutableLiveDataK = userWearVM != null ? userWearVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 42) != 0) {
                MutableLiveData<UserAssetsBean> mutableLiveDataI = userWearVM != null ? userWearVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                UserAssetsBean value2 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                if (value2 != null) {
                    starDrill = value2.getStarDrill();
                    inspirationValue = value2.getInspirationValue();
                    skinVoucher = value2.getSkinVoucher();
                } else {
                    skinVoucher = 0;
                    starDrill = 0;
                    inspirationValue = 0;
                }
                str = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(starDrill));
                str2 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(inspirationValue));
                str3 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(skinVoucher));
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            if ((j & 44) != 0) {
                MutableLiveData<Integer> mutableLiveData = userWearVM != null ? ((BaseVM) userWearVM).f33644a : null;
                updateLiveDataRegistration(2, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
        } else {
            iSafeUnbox = 0;
            value = null;
            str = null;
            str2 = null;
            str3 = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f12835a;
            if (cVar == null) {
                cVar = new c();
                this.f12835a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f12833a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12833a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f12834a;
            if (bVar == null) {
                bVar = new b();
                this.f12834a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityUserWearBinding) this).f12822a, cVarA, null);
            CommonBindingAdapter.q(((ActivityUserWearBinding) this).b, aVarA, null);
            CommonBindingAdapter.q(this.c, bVarA, null);
        }
        if ((j & 44) != 0) {
            ViewBindingAdapter.setPaddingTop(((ActivityUserWearBinding) this).f12823a, iSafeUnbox);
        }
        if ((42 & j) != 0) {
            CommonBindingAdapter.Q(((ActivityUserWearBinding) this).f12826a, str3);
            CommonBindingAdapter.Q(((ActivityUserWearBinding) this).f12829b, str2);
            CommonBindingAdapter.Q(this.c, str);
        }
        if ((j & 41) != 0) {
            CommonBindingAdapter.g(((ActivityUserWearBinding) this).f12824a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12831a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12831a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityUserWearBinding
    public void l(@Nullable UserWearActivity.a aVar) {
        ((ActivityUserWearBinding) this).f12827a = aVar;
        synchronized (this) {
            this.f12831a |= 16;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityUserWearBinding
    public void m(@Nullable UserWearVM userWearVM) {
        ((ActivityUserWearBinding) this).f12828a = userWearVM;
        synchronized (this) {
            this.f12831a |= 8;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12831a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<UserAssetsBean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12831a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<UserWearTypeAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12831a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((UserWearVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((UserWearActivity.a) obj);
        }
        return true;
    }

    public ActivityUserWearBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ImageView) objArr[2], (FrameLayout) objArr[9], (RelativeLayout) objArr[1], (ImageView) objArr[6], (PointCardView) objArr[5], (PointCardView) objArr[3], (PointCardView) objArr[4], (SpineWebView) objArr[8], (RecyclerView) objArr[7]);
        this.f12831a = -1L;
        ((ActivityUserWearBinding) this).f12822a.setTag(null);
        ((ActivityUserWearBinding) this).f12823a.setTag(null);
        ((ActivityUserWearBinding) this).b.setTag(null);
        ((ActivityUserWearBinding) this).f12826a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12832a = linearLayout;
        linearLayout.setTag(null);
        ((ActivityUserWearBinding) this).f12829b.setTag(null);
        this.c.setTag(null);
        ((ActivityUserWearBinding) this).f12824a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
