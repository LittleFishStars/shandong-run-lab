package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.bean.ExpressLogisticsBean;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemExpressLogisticsBindingImpl extends MallItemExpressLogisticsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34995a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10783a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f10785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10786a;

    public MallItemExpressLogisticsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f10783a, f34995a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        CharSequence charSequence;
        String time;
        int i;
        boolean z;
        int i2;
        CharSequence contentSpan;
        int position;
        boolean zIsLastPosition;
        int logisticNode;
        boolean isLightStatus;
        boolean zIsFirstPosition;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f10784a;
            this.f10784a = 0L;
        }
        ExpressLogisticsBean expressLogisticsBean = ((MallItemExpressLogisticsBinding) this).f10782a;
        long j4 = j & 3;
        CharSequence logisticNodeDesc = null;
        int logisticsStatusIcon = 0;
        if (j4 != 0) {
            if (expressLogisticsBean != null) {
                logisticNodeDesc = expressLogisticsBean.getLogisticNodeDesc();
                time = expressLogisticsBean.getTime();
                zIsLastPosition = expressLogisticsBean.isLastPosition();
                logisticNode = expressLogisticsBean.getLogisticNode();
                isLightStatus = expressLogisticsBean.getIsLightStatus();
                contentSpan = expressLogisticsBean.getContentSpan();
                zIsFirstPosition = expressLogisticsBean.isFirstPosition();
                position = expressLogisticsBean.getPosition();
            } else {
                time = null;
                contentSpan = null;
                position = 0;
                zIsLastPosition = false;
                logisticNode = 0;
                isLightStatus = false;
                zIsFirstPosition = false;
            }
            if (j4 != 0) {
                j |= zIsLastPosition ? 32L : 16L;
            }
            if ((j & 3) != 0) {
                if (zIsFirstPosition) {
                    j2 = j | 8;
                    j3 = 128;
                } else {
                    j2 = j | 4;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            boolean z2 = !zIsLastPosition;
            int i3 = zIsLastPosition ? 20 : 0;
            int i4 = zIsFirstPosition ? 13 : 4;
            String str2 = zIsFirstPosition ? "#191F20" : "#757979";
            logisticsStatusIcon = ExpressLogisticsBean.getLogisticsStatusIcon(logisticNode, position == 0, isLightStatus);
            i2 = i3;
            str = str2;
            i = i4;
            CharSequence charSequence2 = contentSpan;
            z = z2;
            charSequence = logisticNodeDesc;
            logisticNodeDesc = charSequence2;
        } else {
            str = null;
            charSequence = null;
            time = null;
            i = 0;
            z = false;
            i2 = 0;
        }
        if ((j & 3) != 0) {
            CommonBindingAdapter.S(((MallItemExpressLogisticsBinding) this).f34994a, logisticsStatusIcon);
            CommonBindingAdapter.I(((MallItemExpressLogisticsBinding) this).f34994a, 0, i, 0, 0, null);
            CommonBindingAdapter.I(this.f10786a, 0, 0, 0, i2, null);
            CommonBindingAdapter.l0(this.f10785a, z);
            TextViewBindingAdapter.setText(((MallItemExpressLogisticsBinding) this).f10781a, logisticNodeDesc);
            CommonBindingAdapter.W(((MallItemExpressLogisticsBinding) this).f10781a, str);
            TextViewBindingAdapter.setText(this.b, charSequence);
            CommonBindingAdapter.W(this.b, str);
            TextViewBindingAdapter.setText(this.c, time);
            CommonBindingAdapter.W(this.c, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10784a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10784a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemExpressLogisticsBinding
    public void k(@Nullable ExpressLogisticsBean expressLogisticsBean) {
        ((MallItemExpressLogisticsBinding) this).f10782a = expressLogisticsBean;
        synchronized (this) {
            this.f10784a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((ExpressLogisticsBean) obj);
        return true;
    }

    public MallItemExpressLogisticsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[5]);
        this.f10784a = -1L;
        ((MallItemExpressLogisticsBinding) this).f34994a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f10786a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        View view2 = (View) objArr[3];
        this.f10785a = view2;
        view2.setTag(null);
        ((MallItemExpressLogisticsBinding) this).f10781a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
