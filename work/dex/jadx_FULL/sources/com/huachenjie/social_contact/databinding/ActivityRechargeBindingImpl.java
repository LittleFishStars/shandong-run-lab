package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.BuyStarDrillInfo;
import com.huachenjie.social_contact.page.RechargeActivity;
import com.huachenjie.social_contact.vm.PayVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityRechargeBindingImpl extends ActivityRechargeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12754a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12760a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f12761b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f12762c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f12763d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RechargeActivity.a f36097a;

        public a a(RechargeActivity.a aVar) {
            this.f36097a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36097a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RechargeActivity.a f36098a;

        public b a(RechargeActivity.a aVar) {
            this.f36098a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36098a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RechargeActivity.a f36099a;

        public c a(RechargeActivity.a aVar) {
            this.f36099a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36099a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36096a = sparseIntArray;
        sparseIntArray.put(R.id.bg_recharge, 12);
        sparseIntArray.put(R.id.iv_recharge, 13);
        sparseIntArray.put(R.id.pay_lottie, 14);
        sparseIntArray.put(R.id.cl_buy_star_drill, 15);
        sparseIntArray.put(R.id.tv_title, 16);
        sparseIntArray.put(R.id.tv_des, 17);
    }

    public ActivityRechargeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, f12754a, f36096a));
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00f3  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zShowLeft;
        boolean zShowRight;
        BuyStarDrillInfo value;
        String str;
        String str2;
        String str3;
        String str4;
        b bVarA;
        a aVarA;
        c cVarA;
        boolean z;
        boolean z2;
        boolean z3;
        int rightStarDrill;
        int leftStarDrill;
        String rightPayAmountStr;
        String leftPayAmountStr;
        synchronized (this) {
            j = this.f12755a;
            this.f12755a = 0L;
        }
        PayVM payVM = ((ActivityRechargeBinding) this).f12750a;
        RechargeActivity.a aVar = ((ActivityRechargeBinding) this).f12749a;
        long j2 = j & 11;
        if (j2 != 0) {
            MutableLiveData<BuyStarDrillInfo> mutableLiveDataV = payVM != null ? payVM.v() : null;
            updateLiveDataRegistration(0, mutableLiveDataV);
            value = mutableLiveDataV != null ? mutableLiveDataV.getValue() : null;
            if (value != null) {
                zShowLeft = value.showLeft();
                rightStarDrill = value.getRightStarDrill();
                zShowRight = value.showRight();
                rightPayAmountStr = value.getRightPayAmountStr();
                leftPayAmountStr = value.getLeftPayAmountStr();
                leftStarDrill = value.getLeftStarDrill();
            } else {
                zShowLeft = false;
                rightStarDrill = 0;
                zShowRight = false;
                leftStarDrill = 0;
                rightPayAmountStr = null;
                leftPayAmountStr = null;
            }
            if (j2 != 0) {
                j |= zShowLeft ? 32L : 16L;
            }
            if ((j & 11) != 0) {
                j |= zShowRight ? 128L : 64L;
            }
            str3 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(rightStarDrill));
            str4 = String.format("%s元购买", rightPayAmountStr);
            str = String.format("%s元购买", leftPayAmountStr);
            str2 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(leftStarDrill));
        } else {
            zShowLeft = false;
            zShowRight = false;
            value = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f12759a;
            if (cVar == null) {
                cVar = new c();
                this.f12759a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f12757a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12757a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f12758a;
            if (bVar == null) {
                bVar = new b();
                this.f12758a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((160 & j) != 0) {
            z = (value != null ? value.getDoubleStarDill() : 0) == 1;
        }
        long j4 = j & 11;
        if (j4 != 0) {
            z2 = zShowLeft ? z : false;
            z3 = zShowRight ? z : false;
        } else {
            z2 = false;
            z3 = false;
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.b, cVarA, null);
            CommonBindingAdapter.q(((ActivityRechargeBinding) this).f12752a, aVarA, null);
            CommonBindingAdapter.q(((ActivityRechargeBinding) this).f12753b, bVarA, null);
        }
        if (j4 != 0) {
            CommonBindingAdapter.l0(this.f12762c, zShowRight);
            TextViewBindingAdapter.setText(this.f12762c, str3);
            CommonBindingAdapter.l0(this.f12763d, zShowRight);
            TextViewBindingAdapter.setText(this.f12763d, str4);
            CommonBindingAdapter.l0(this.f12760a, z2);
            CommonBindingAdapter.l0(this.c, zShowLeft);
            CommonBindingAdapter.l0(this.e, zShowLeft);
            TextViewBindingAdapter.setText(this.e, str2);
            CommonBindingAdapter.l0(this.f, zShowLeft);
            TextViewBindingAdapter.setText(this.f, str);
            CommonBindingAdapter.l0(this.f12761b, z3);
            CommonBindingAdapter.l0(this.d, zShowRight);
            CommonBindingAdapter.l0(((ActivityRechargeBinding) this).f12752a, zShowRight);
            CommonBindingAdapter.l0(((ActivityRechargeBinding) this).f12753b, zShowLeft);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12755a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12755a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityRechargeBinding
    public void l(@Nullable RechargeActivity.a aVar) {
        ((ActivityRechargeBinding) this).f12749a = aVar;
        synchronized (this) {
            this.f12755a |= 4;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityRechargeBinding
    public void m(@Nullable PayVM payVM) {
        ((ActivityRechargeBinding) this).f12750a = payVM;
        synchronized (this) {
            this.f12755a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<BuyStarDrillInfo> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12755a |= 1;
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
        if (nk0.p0 == i) {
            m((PayVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((RechargeActivity.a) obj);
        }
        return true;
    }

    public ActivityRechargeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[12], (BLConstraintLayout) objArr[15], (ImageView) objArr[13], (LottieAnimationView) objArr[14], (TextView) objArr[17], (TextView) objArr[16], (BLView) objArr[7], (BLView) objArr[2]);
        this.f12755a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f12756a = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.b = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.f12762c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[11];
        this.f12763d = textView2;
        textView2.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f12760a = bLTextView;
        bLTextView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[4];
        this.c = imageView2;
        imageView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.e = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[6];
        this.f = textView4;
        textView4.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[8];
        this.f12761b = bLTextView2;
        bLTextView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[9];
        this.d = imageView3;
        imageView3.setTag(null);
        ((ActivityRechargeBinding) this).f12752a.setTag(null);
        ((ActivityRechargeBinding) this).f12753b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
