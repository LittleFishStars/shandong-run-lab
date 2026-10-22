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
public class HomeItemInspirationRecordConsumeBindingImpl extends HomeItemInspirationRecordConsumeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9492a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f9494a;

    @NonNull
    public final TextView e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34278a = sparseIntArray;
        sparseIntArray.put(R.id.v_line, 7);
    }

    public HomeItemInspirationRecordConsumeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f9492a, f34278a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String name;
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str3;
        int jumpType;
        synchronized (this) {
            j = this.f9493a;
            this.f9493a = 0L;
        }
        InspirationRecordBean inspirationRecordBean = ((HomeItemInspirationRecordConsumeBinding) this).f9490a;
        long j2 = j & 3;
        String str4 = null;
        if (j2 != 0) {
            if (inspirationRecordBean != null) {
                jumpType = inspirationRecordBean.getJumpType();
                str3 = inspirationRecordBean.formatterResult();
                str = inspirationRecordBean.formatterConsumeInspiration();
                name = inspirationRecordBean.getName();
                str2 = inspirationRecordBean.formatterConsumeTime();
            } else {
                str3 = null;
                str = null;
                name = null;
                str2 = null;
                jumpType = 0;
            }
            z2 = jumpType == 1;
            z = jumpType != 2;
            if (j2 != 0) {
                j |= z2 ? 8L : 4L;
            }
            if ((j & 3) != 0) {
                j |= z ? 32L : 16L;
            }
            str4 = str3;
        } else {
            str = null;
            name = null;
            str2 = null;
            z = false;
            z2 = false;
        }
        boolean lottery = ((40 & j) == 0 || inspirationRecordBean == null) ? false : inspirationRecordBean.getLottery();
        long j3 = j & 3;
        if (j3 != 0) {
            boolean z5 = z2 ? lottery : false;
            z3 = z ? lottery : false;
            z4 = z5;
        } else {
            z3 = false;
            z4 = false;
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.e, str);
            CommonBindingAdapter.l0(((HomeItemInspirationRecordConsumeBinding) this).f9491a, z4);
            TextViewBindingAdapter.setText(((HomeItemInspirationRecordConsumeBinding) this).f9489a, str4);
            CommonBindingAdapter.l0(((HomeItemInspirationRecordConsumeBinding) this).f9489a, z3);
            TextViewBindingAdapter.setText(this.b, str2);
            TextViewBindingAdapter.setText(this.c, name);
            CommonBindingAdapter.l0(this.d, z4);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9493a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9493a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemInspirationRecordConsumeBinding
    public void k(@Nullable InspirationRecordBean inspirationRecordBean) {
        ((HomeItemInspirationRecordConsumeBinding) this).f9490a = inspirationRecordBean;
        synchronized (this) {
            this.f9493a |= 1;
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

    public HomeItemInspirationRecordConsumeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLTextView) objArr[5], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[1], (TextView) objArr[4], (View) objArr[7]);
        this.f9493a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f9494a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.e = textView;
        textView.setTag(null);
        ((HomeItemInspirationRecordConsumeBinding) this).f9491a.setTag(null);
        ((HomeItemInspirationRecordConsumeBinding) this).f9489a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
