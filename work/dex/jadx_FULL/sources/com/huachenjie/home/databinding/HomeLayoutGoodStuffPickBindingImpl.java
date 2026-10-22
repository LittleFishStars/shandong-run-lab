package com.huachenjie.home.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.HomeFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.PromoSlotBean;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeLayoutGoodStuffPickBindingImpl extends HomeLayoutGoodStuffPickBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34308a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9592a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9595a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeFragment.ClickProxy f34309a;

        public a a(HomeFragment.ClickProxy clickProxy) {
            this.f34309a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34309a.f(view);
        }
    }

    public HomeLayoutGoodStuffPickBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f9592a, f34308a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        boolean z;
        boolean z2;
        String str;
        String str2;
        String str3;
        RequestOptions requestOptions;
        RequestOptions requestOptions2;
        a aVarA;
        int titleType;
        String titleContent;
        String imageUrl;
        String price;
        Context context;
        int i;
        synchronized (this) {
            j = this.f9593a;
            this.f9593a = 0L;
        }
        Boolean bool = ((HomeLayoutGoodStuffPickBinding) this).f9590a;
        Integer num = ((HomeLayoutGoodStuffPickBinding) this).f9591a;
        PromoSlotBean promoSlotBean = ((HomeLayoutGoodStuffPickBinding) this).f9589a;
        HomeFragment.ClickProxy clickProxy = ((HomeLayoutGoodStuffPickBinding) this).f9588a;
        long j2 = j & 17;
        if (j2 != 0) {
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j2 != 0) {
                j |= zSafeUnbox ? 64L : 32L;
            }
            if (zSafeUnbox) {
                context = this.f9594a.getContext();
                i = R.drawable.home_bg_good_stuff_pick_item_sea;
            } else {
                context = this.f9594a.getContext();
                i = R.drawable.home_bg_good_stuff_pick_item;
            }
            drawable = AppCompatResources.getDrawable(context, i);
        } else {
            drawable = null;
        }
        long j3 = 20 & j;
        if (j3 != 0) {
            requestOptions = ju3.h;
            requestOptions2 = ju3.p;
            if (promoSlotBean != null) {
                titleContent = promoSlotBean.getTitleContent();
                imageUrl = promoSlotBean.getImageUrl();
                price = promoSlotBean.getPrice();
                titleType = promoSlotBean.getTitleType();
            } else {
                titleType = 0;
                titleContent = null;
                imageUrl = null;
                price = null;
            }
            boolean z3 = titleType == 1;
            z = titleType == 2;
            str = titleContent;
            str2 = imageUrl;
            str3 = price;
            z2 = z3;
        } else {
            z = false;
            z2 = false;
            str = null;
            str2 = null;
            str3 = null;
            requestOptions = null;
            requestOptions2 = null;
        }
        long j4 = j & 18;
        long j5 = j & 24;
        if (j5 == 0 || clickProxy == null) {
            aVarA = null;
        } else {
            a aVar = this.f9595a;
            if (aVar == null) {
                aVar = new a();
                this.f9595a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(((HomeLayoutGoodStuffPickBinding) this).f34307a, str2, requestOptions2, false);
            CommonBindingAdapter.l0(super.b, z);
            CommonBindingAdapter.b0(super.b, str, requestOptions, false);
            TextViewBindingAdapter.setText(this.b, str3);
            CommonBindingAdapter.l0(((HomeLayoutGoodStuffPickBinding) this).f9587a, z2);
            TextViewBindingAdapter.setText(((HomeLayoutGoodStuffPickBinding) this).f9587a, str);
        }
        if (j4 != 0) {
            this.f9594a.setTag(num);
        }
        if ((j & 17) != 0) {
            ViewBindingAdapter.setBackground(this.f9594a, drawable);
        }
        if (j5 != 0) {
            CommonBindingAdapter.q(this.f9594a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9593a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9593a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeLayoutGoodStuffPickBinding
    public void o(@Nullable PromoSlotBean promoSlotBean) {
        ((HomeLayoutGoodStuffPickBinding) this).f9589a = promoSlotBean;
        synchronized (this) {
            this.f9593a |= 4;
        }
        notifyPropertyChanged(xk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.huachenjie.home.databinding.HomeLayoutGoodStuffPickBinding
    public void p(@Nullable HomeFragment.ClickProxy clickProxy) {
        ((HomeLayoutGoodStuffPickBinding) this).f9588a = clickProxy;
        synchronized (this) {
            this.f9593a |= 8;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeLayoutGoodStuffPickBinding
    public void q(@Nullable Integer num) {
        ((HomeLayoutGoodStuffPickBinding) this).f9591a = num;
        synchronized (this) {
            this.f9593a |= 2;
        }
        notifyPropertyChanged(xk0.w);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeLayoutGoodStuffPickBinding
    public void r(@Nullable Boolean bool) {
        ((HomeLayoutGoodStuffPickBinding) this).f9590a = bool;
        synchronized (this) {
            this.f9593a |= 1;
        }
        notifyPropertyChanged(xk0.c0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.c0 == i) {
            r((Boolean) obj);
        } else if (xk0.w == i) {
            q((Integer) obj);
        } else if (xk0.g == i) {
            o((PromoSlotBean) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            p((HomeFragment.ClickProxy) obj);
        }
        return true;
    }

    public HomeLayoutGoodStuffPickBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ImageView) objArr[2], (TextView) objArr[1]);
        this.f9593a = -1L;
        ((HomeLayoutGoodStuffPickBinding) this).f34307a.setTag(null);
        super.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9594a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.b = textView;
        textView.setTag(null);
        ((HomeLayoutGoodStuffPickBinding) this).f9587a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
