package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.CrystalPageInfo;
import com.huachenjie.social_contact.dialog.ExchangeWorldCrystalsDialog;
import com.huachenjie.social_contact.vm.ExchangeWorldCrystalsVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogExchangeWorldCrystalsBindingImpl extends DialogExchangeWorldCrystalsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12878a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12883a;

    @NonNull
    public final TextView b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f12884c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExchangeWorldCrystalsDialog.a f36145a;

        public a a(ExchangeWorldCrystalsDialog.a aVar) {
            this.f36145a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36145a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExchangeWorldCrystalsDialog.a f36146a;

        public b a(ExchangeWorldCrystalsDialog.a aVar) {
            this.f36146a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36146a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36144a = sparseIntArray;
        sparseIntArray.put(R.id.iv_star_drill, 7);
        sparseIntArray.put(R.id.iv_coin, 8);
    }

    public DialogExchangeWorldCrystalsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f12878a, f36144a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        b bVarA;
        a aVarA;
        int crystalValue;
        int starStone;
        int starDrill;
        int exchangeNum;
        boolean zCanBuy;
        synchronized (this) {
            j = this.f12879a;
            this.f12879a = 0L;
        }
        ExchangeWorldCrystalsVM exchangeWorldCrystalsVM = ((DialogExchangeWorldCrystalsBinding) this).f12877a;
        ExchangeWorldCrystalsDialog.a aVar = ((DialogExchangeWorldCrystalsBinding) this).f12876a;
        long j2 = 11 & j;
        boolean z = false;
        if (j2 != 0) {
            MutableLiveData<CrystalPageInfo> mutableLiveDataK = exchangeWorldCrystalsVM != null ? exchangeWorldCrystalsVM.k() : null;
            updateLiveDataRegistration(0, mutableLiveDataK);
            CrystalPageInfo value = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
            if (value != null) {
                starStone = value.getStarStone();
                starDrill = value.getStarDrill();
                exchangeNum = value.getExchangeNum();
                zCanBuy = value.canBuy();
                crystalValue = value.getCrystalValue();
            } else {
                crystalValue = 0;
                starStone = 0;
                starDrill = 0;
                exchangeNum = 0;
                zCanBuy = false;
            }
            str2 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(starStone));
            str3 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(starDrill));
            str4 = String.format("今日可兑换  %d/5", Integer.valueOf(exchangeNum));
            str = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(crystalValue));
            z = zCanBuy;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f12882a;
            if (bVar == null) {
                bVar = new b();
                this.f12882a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f12881a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12881a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.c, bVarA, null);
            CommonBindingAdapter.q(this.e, aVarA, null);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f12880a, str4);
            TextViewBindingAdapter.setText(this.b, str2);
            TextViewBindingAdapter.setText(this.f12884c, str);
            TextViewBindingAdapter.setText(this.d, str3);
            CommonBindingAdapter.e0(this.e, z);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12879a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12879a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogExchangeWorldCrystalsBinding
    public void l(@Nullable ExchangeWorldCrystalsDialog.a aVar) {
        ((DialogExchangeWorldCrystalsBinding) this).f12876a = aVar;
        synchronized (this) {
            this.f12879a |= 4;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogExchangeWorldCrystalsBinding
    public void m(@Nullable ExchangeWorldCrystalsVM exchangeWorldCrystalsVM) {
        ((DialogExchangeWorldCrystalsBinding) this).f12877a = exchangeWorldCrystalsVM;
        synchronized (this) {
            this.f12879a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<CrystalPageInfo> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12879a |= 1;
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
            m((ExchangeWorldCrystalsVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((ExchangeWorldCrystalsDialog.a) obj);
        }
        return true;
    }

    public DialogExchangeWorldCrystalsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[8], (ImageView) objArr[7]);
        this.f12879a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f12883a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.c = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12880a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.f12884c = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.d = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.e = textView5;
        textView5.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
