package com.huachenjie.college.databinding;

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
import com.huachenjie.college.bean.HuaweiHealthSportRecordBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeItemHwHealthBindingImpl extends CollegeItemHwHealthBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33575a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8403a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f8405a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public CollegeItemHwHealthBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f8403a, f33575a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        RequestOptions requestOptions;
        String str;
        String str2;
        String deductStr;
        String sportTimeStr;
        String str3;
        boolean deducted;
        String str4;
        String logoUrl;
        synchronized (this) {
            j = this.f8404a;
            this.f8404a = 0L;
        }
        HuaweiHealthSportRecordBean huaweiHealthSportRecordBean = ((CollegeItemHwHealthBinding) this).f8401a;
        long j2 = j & 3;
        String str5 = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (huaweiHealthSportRecordBean != null) {
                String sportName = huaweiHealthSportRecordBean.getSportName();
                String dataSource = huaweiHealthSportRecordBean.getDataSource();
                deductStr = huaweiHealthSportRecordBean.getDeductStr();
                sportTimeStr = huaweiHealthSportRecordBean.getSportTimeStr();
                logoUrl = huaweiHealthSportRecordBean.getLogoUrl();
                deducted = huaweiHealthSportRecordBean.getDeducted();
                String sportDesc = huaweiHealthSportRecordBean.getSportDesc();
                str4 = sportName;
                str5 = dataSource;
                str2 = sportDesc;
            } else {
                deducted = false;
                str4 = null;
                str2 = null;
                deductStr = null;
                sportTimeStr = null;
                logoUrl = null;
            }
            z = !deducted;
            String str6 = str4;
            str = String.format("*数据来源：%s", str5);
            str5 = logoUrl;
            str3 = str6;
        } else {
            z = false;
            requestOptions = null;
            str = null;
            str2 = null;
            deductStr = null;
            sportTimeStr = null;
            str3 = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((CollegeItemHwHealthBinding) this).f33574a, str5, requestOptions, false);
            TextViewBindingAdapter.setText(this.c, str);
            TextViewBindingAdapter.setText(this.d, sportTimeStr);
            CommonBindingAdapter.e0(((CollegeItemHwHealthBinding) this).f8402a, z);
            TextViewBindingAdapter.setText(((CollegeItemHwHealthBinding) this).f8402a, deductStr);
            TextViewBindingAdapter.setText(((CollegeItemHwHealthBinding) this).f8400a, str2);
            TextViewBindingAdapter.setText(this.b, str3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8404a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8404a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeItemHwHealthBinding
    public void k(@Nullable HuaweiHealthSportRecordBean huaweiHealthSportRecordBean) {
        ((CollegeItemHwHealthBinding) this).f8401a = huaweiHealthSportRecordBean;
        synchronized (this) {
            this.f8404a |= 1;
        }
        notifyPropertyChanged(uk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.g != i) {
            return false;
        }
        k((HuaweiHealthSportRecordBean) obj);
        return true;
    }

    public CollegeItemHwHealthBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (BLTextView) objArr[5], (TextView) objArr[3], (TextView) objArr[2]);
        this.f8404a = -1L;
        ((CollegeItemHwHealthBinding) this).f33574a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f8405a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.d = textView2;
        textView2.setTag(null);
        ((CollegeItemHwHealthBinding) this).f8402a.setTag(null);
        ((CollegeItemHwHealthBinding) this).f8400a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
