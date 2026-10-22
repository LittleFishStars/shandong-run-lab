package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.InspirationRecordBean;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemInspirationRecordGetBindingImpl extends HomeItemInspirationRecordGetBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9497a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f9499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9500a;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34280a = sparseIntArray;
        sparseIntArray.put(R.id.v_line, 6);
    }

    public HomeItemInspirationRecordGetBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f9497a, f34280a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String name;
        boolean zIsNotOfficialRecord;
        String str;
        String str2;
        String obtainType;
        String str3;
        synchronized (this) {
            j = this.f9498a;
            this.f9498a = 0L;
        }
        InspirationRecordBean inspirationRecordBean = ((HomeItemInspirationRecordGetBinding) this).f9496a;
        long j2 = j & 3;
        if (j2 == 0 || inspirationRecordBean == null) {
            name = null;
            zIsNotOfficialRecord = false;
            str = null;
            str2 = null;
            obtainType = null;
            str3 = null;
        } else {
            name = inspirationRecordBean.getName();
            str = inspirationRecordBean.formatterSource();
            str2 = inspirationRecordBean.formatterGetInspiration();
            zIsNotOfficialRecord = inspirationRecordBean.isNotOfficialRecord();
            str3 = inspirationRecordBean.formatterGetTime();
            obtainType = inspirationRecordBean.getObtainType();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.d, str2);
            TextViewBindingAdapter.setText(this.f9500a, obtainType);
            CommonBindingAdapter.l0(((HomeItemInspirationRecordGetBinding) this).f9495a, zIsNotOfficialRecord);
            TextViewBindingAdapter.setText(((HomeItemInspirationRecordGetBinding) this).f9495a, str);
            TextViewBindingAdapter.setText(this.b, str3);
            TextViewBindingAdapter.setText(this.c, name);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9498a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9498a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemInspirationRecordGetBinding
    public void k(@Nullable InspirationRecordBean inspirationRecordBean) {
        ((HomeItemInspirationRecordGetBinding) this).f9496a = inspirationRecordBean;
        synchronized (this) {
            this.f9498a |= 1;
        }
        notifyPropertyChanged(xk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.g != i) {
            return false;
        }
        k((InspirationRecordBean) obj);
        return true;
    }

    public HomeItemInspirationRecordGetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1], (View) objArr[6]);
        this.f9498a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f9499a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.d = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[5];
        this.f9500a = bLTextView;
        bLTextView.setTag(null);
        ((HomeItemInspirationRecordGetBinding) this).f9495a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
