package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.shopping_message.ShoppingMessageVM;
import com.noober.background.view.BLTextView;
import com.vanniktech.emoji.EmojiTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemShoppingMessageHeaderBindingImpl extends MallItemShoppingMessageHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10939a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10941a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35043a = sparseIntArray;
        sparseIntArray.put(R.id.cl_container, 2);
        sparseIntArray.put(R.id.iv_message_avatar, 3);
        sparseIntArray.put(R.id.tv_message_nick_name, 4);
        sparseIntArray.put(R.id.tv_message_time, 5);
        sparseIntArray.put(R.id.tv_message_title, 6);
    }

    public MallItemShoppingMessageHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10939a, f35043a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        synchronized (this) {
            j = this.f10940a;
            this.f10940a = 0L;
        }
        ShoppingMessageVM shoppingMessageVM = ((MallItemShoppingMessageHeaderBinding) this).f10936a;
        long j2 = j & 7;
        String str = null;
        int i = 0;
        if (j2 != 0) {
            MutableLiveData<Integer> mutableLiveDataN = shoppingMessageVM != null ? shoppingMessageVM.n() : null;
            updateLiveDataRegistration(0, mutableLiveDataN);
            int iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
            z2 = iSafeUnbox > 99;
            i = iSafeUnbox > 0 ? 1 : 0;
            if (j2 != 0) {
                j = z2 ? j | 16 : j | 8;
            }
            int i2 = i;
            i = iSafeUnbox;
            z = i2;
        } else {
            z = 0;
            z2 = false;
        }
        String strValueOf = (j & 8) != 0 ? String.valueOf(i) : null;
        long j3 = j & 7;
        if (j3 != 0) {
            str = z2 ? "99+" : strValueOf;
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(((MallItemShoppingMessageHeaderBinding) this).f10937a, z);
            TextViewBindingAdapter.setText(((MallItemShoppingMessageHeaderBinding) this).f10937a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10940a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10940a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemShoppingMessageHeaderBinding
    public void k(@Nullable ShoppingMessageVM shoppingMessageVM) {
        ((MallItemShoppingMessageHeaderBinding) this).f10936a = shoppingMessageVM;
        synchronized (this) {
            this.f10940a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10940a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((ShoppingMessageVM) obj);
        return true;
    }

    public MallItemShoppingMessageHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[2], (ImageView) objArr[3], (TextView) objArr[4], (TextView) objArr[5], (EmojiTextView) objArr[6], (BLTextView) objArr[1]);
        this.f10940a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10941a = frameLayout;
        frameLayout.setTag(null);
        ((MallItemShoppingMessageHeaderBinding) this).f10937a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
