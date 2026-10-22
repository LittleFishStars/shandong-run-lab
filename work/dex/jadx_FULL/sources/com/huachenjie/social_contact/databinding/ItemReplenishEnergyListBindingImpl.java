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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.bean.DrinkDetailBean;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemReplenishEnergyListBindingImpl extends ItemReplenishEnergyListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36186a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12977a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f12979a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f12980b;

    @NonNull
    public final BLTextView c;

    public ItemReplenishEnergyListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f12977a, f36186a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean affordable;
        RequestOptions requestOptions;
        String consumeStr;
        String str;
        String name;
        String description;
        int price;
        synchronized (this) {
            j = this.f12978a;
            this.f12978a = 0L;
        }
        DrinkDetailBean drinkDetailBean = ((ItemReplenishEnergyListBinding) this).f12974a;
        long j2 = j & 3;
        String imageUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.p;
            if (drinkDetailBean != null) {
                imageUrl = drinkDetailBean.getImageUrl();
                price = drinkDetailBean.getPrice();
                name = drinkDetailBean.getName();
                description = drinkDetailBean.getDescription();
                affordable = drinkDetailBean.getAffordable();
                consumeStr = drinkDetailBean.getConsumeStr();
            } else {
                price = 0;
                affordable = false;
                consumeStr = null;
                name = null;
                description = null;
            }
            str = String.format("%d闪金币", Integer.valueOf(price));
        } else {
            affordable = false;
            requestOptions = null;
            consumeStr = null;
            str = null;
            name = null;
            description = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((ItemReplenishEnergyListBinding) this).f36185a, imageUrl, requestOptions, false);
            CommonBindingAdapter.e0(((ItemReplenishEnergyListBinding) this).f12975a, affordable);
            TextViewBindingAdapter.setText(this.b, description);
            CommonBindingAdapter.e0(this.f12980b, affordable);
            CommonBindingAdapter.e0(this.c, affordable);
            TextViewBindingAdapter.setText(this.c, str);
            TextViewBindingAdapter.setText(((ItemReplenishEnergyListBinding) this).f12976a, consumeStr);
            TextViewBindingAdapter.setText(((ItemReplenishEnergyListBinding) this).f12973a, name);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12978a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12978a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemReplenishEnergyListBinding
    public void k(@Nullable DrinkDetailBean drinkDetailBean) {
        ((ItemReplenishEnergyListBinding) this).f12974a = drinkDetailBean;
        synchronized (this) {
            this.f12978a |= 1;
        }
        notifyPropertyChanged(nk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.g != i) {
            return false;
        }
        k((DrinkDetailBean) obj);
        return true;
    }

    public ItemReplenishEnergyListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (BLLinearLayout) objArr[5], (BLTextView) objArr[4], (TextView) objArr[2]);
        this.f12978a = -1L;
        ((ItemReplenishEnergyListBinding) this).f36185a.setTag(null);
        ((ItemReplenishEnergyListBinding) this).f12975a.setTag(null);
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) objArr[0];
        this.f12979a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.b = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[6];
        this.f12980b = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[7];
        this.c = bLTextView2;
        bLTextView2.setTag(null);
        ((ItemReplenishEnergyListBinding) this).f12976a.setTag(null);
        ((ItemReplenishEnergyListBinding) this).f12973a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
