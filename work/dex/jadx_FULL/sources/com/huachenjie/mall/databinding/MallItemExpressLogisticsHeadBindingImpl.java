package com.huachenjie.mall.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressLogisticsOutBean;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemExpressLogisticsHeadBindingImpl extends MallItemExpressLogisticsHeadBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34997a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10788a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f10793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10794a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLButton f10795b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExpressLogisticsActivity.a f34998a;

        public a a(ExpressLogisticsActivity.a aVar) {
            this.f34998a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34998a.a(view);
        }
    }

    public MallItemExpressLogisticsHeadBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f10788a, f34997a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int colorFromResource;
        boolean z;
        boolean z2;
        String logisticSid;
        Drawable drawable;
        String str;
        a aVarA;
        String logisticCoName;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f10789a;
            this.f10789a = 0L;
        }
        ExpressLogisticsOutBean expressLogisticsOutBean = ((MallItemExpressLogisticsHeadBinding) this).f34996a;
        ExpressLogisticsActivity.a aVar = ((MallItemExpressLogisticsHeadBinding) this).f10787a;
        long j4 = j & 5;
        int i = 0;
        boolean isLightStatus = false;
        if (j4 != 0) {
            if (expressLogisticsOutBean != null) {
                isLightStatus = expressLogisticsOutBean.getIsLightStatus();
                logisticCoName = expressLogisticsOutBean.getLogisticCoName();
                logisticSid = expressLogisticsOutBean.getLogisticSid();
            } else {
                logisticSid = null;
                logisticCoName = null;
            }
            if (j4 != 0) {
                if (isLightStatus) {
                    j2 = j | 16 | 64;
                    j3 = 256;
                } else {
                    j2 = j | 8 | 32;
                    j3 = 128;
                }
                j = j2 | j3;
            }
            drawable = AppCompatResources.getDrawable(this.f10790a.getContext(), isLightStatus ? R.drawable.mall_ic_reward_express_default : R.drawable.mall_ic_express_default);
            int colorFromResource2 = ViewDataBinding.getColorFromResource(this.f10791a, isLightStatus ? R.color.color_191F20 : R.color.color_2C3E50);
            z2 = !isLightStatus;
            colorFromResource = isLightStatus ? ViewDataBinding.getColorFromResource(this.b, R.color.color_191F20) : ViewDataBinding.getColorFromResource(this.b, R.color.color_2C3E50);
            String str2 = logisticCoName;
            z = isLightStatus;
            i = colorFromResource2;
            str = str2;
        } else {
            colorFromResource = 0;
            z = false;
            z2 = false;
            logisticSid = null;
            drawable = null;
            str = null;
        }
        long j5 = j & 6;
        if (j5 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f10792a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10792a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 5) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f10790a, drawable);
            TextViewBindingAdapter.setText(this.f10791a, str);
            this.f10791a.setTextColor(i);
            TextViewBindingAdapter.setText(this.b, logisticSid);
            this.b.setTextColor(colorFromResource);
            CommonBindingAdapter.l0(this.f10793a, z2);
            CommonBindingAdapter.l0(this.f10795b, z);
        }
        if (j5 != 0) {
            CommonBindingAdapter.q(this.f10793a, aVarA, null);
            CommonBindingAdapter.q(this.f10795b, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10789a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10789a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemExpressLogisticsHeadBinding
    public void l(@Nullable ExpressLogisticsOutBean expressLogisticsOutBean) {
        ((MallItemExpressLogisticsHeadBinding) this).f34996a = expressLogisticsOutBean;
        synchronized (this) {
            this.f10789a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemExpressLogisticsHeadBinding
    public void m(@Nullable ExpressLogisticsActivity.a aVar) {
        ((MallItemExpressLogisticsHeadBinding) this).f10787a = aVar;
        synchronized (this) {
            this.f10789a |= 2;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g == i) {
            l((ExpressLogisticsOutBean) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            m((ExpressLogisticsActivity.a) obj);
        }
        return true;
    }

    public MallItemExpressLogisticsHeadBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10789a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f10794a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10790a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10791a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.b = textView2;
        textView2.setTag(null);
        BLButton bLButton = (BLButton) objArr[4];
        this.f10793a = bLButton;
        bLButton.setTag(null);
        BLButton bLButton2 = (BLButton) objArr[5];
        this.f10795b = bLButton2;
        bLButton2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
