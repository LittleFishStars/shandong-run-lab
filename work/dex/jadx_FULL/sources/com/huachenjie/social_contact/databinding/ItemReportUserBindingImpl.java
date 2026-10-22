package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.social_contact.bean.ReportReasonBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemReportUserBindingImpl extends ItemReportUserBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36190a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12987a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12989a;

    public ItemReportUserBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12987a, f36190a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f12988a;
            this.f12988a = 0L;
        }
        ReportReasonBean reportReasonBean = ((ItemReportUserBinding) this).f36189a;
        long j4 = j & 3;
        byte b = 0;
        boolean selected = false;
        String reason = null;
        if (j4 != 0) {
            if (reportReasonBean != null) {
                selected = reportReasonBean.getSelected();
                reason = reportReasonBean.getReason();
            }
            if (j4 != 0) {
                if (selected) {
                    j2 = j | 8;
                    j3 = 32;
                } else {
                    j2 = j | 4;
                    j3 = 16;
                }
                j = j2 | j3;
            }
            byte b2 = selected ? (byte) -10155284 : (byte) -657931;
            int i2 = selected ? -1 : -13877680;
            b = b2;
            i = i2;
        } else {
            i = 0;
        }
        if ((j & 3) != 0) {
            aw9.e(((ItemReportUserBinding) this).f12986a, b);
            TextViewBindingAdapter.setText(((ItemReportUserBinding) this).f12986a, reason);
            ((ItemReportUserBinding) this).f12986a.setTextColor(i);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12988a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12988a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemReportUserBinding
    public void k(@Nullable ReportReasonBean reportReasonBean) {
        ((ItemReportUserBinding) this).f36189a = reportReasonBean;
        synchronized (this) {
            this.f12988a |= 1;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 != i) {
            return false;
        }
        k((ReportReasonBean) obj);
        return true;
    }

    public ItemReportUserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLTextView) objArr[1]);
        this.f12988a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12989a = linearLayout;
        linearLayout.setTag(null);
        ((ItemReportUserBinding) this).f12986a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
