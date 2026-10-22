package com.huachenjie.social_contact.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLImageView;
import com.zj.adlib.ju3;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemReportImageEvidenceBindingImpl extends ItemReportImageEvidenceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36188a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12982a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12985a;

    public ItemReportImageEvidenceBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12982a, f36188a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        boolean zIsEmpty;
        boolean z;
        synchronized (this) {
            j = this.f12983a;
            this.f12983a = 0L;
        }
        String str = this.f;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.p;
            zIsEmpty = TextUtils.isEmpty(str);
            z = !zIsEmpty;
        } else {
            requestOptions = null;
            zIsEmpty = false;
            z = false;
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(((ItemReportImageEvidenceBinding) this).f36187a, z);
            CommonBindingAdapter.b0(((ItemReportImageEvidenceBinding) this).f12981a, str, requestOptions, false);
            CommonBindingAdapter.l0(this.b, zIsEmpty);
            CommonBindingAdapter.l0(this.f12984a, zIsEmpty);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12983a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12983a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemReportImageEvidenceBinding
    public void k(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f12983a |= 1;
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
        k((String) obj);
        return true;
    }

    public ItemReportImageEvidenceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (BLImageView) objArr[1], (ImageView) objArr[3]);
        this.f12983a = -1L;
        ((ItemReportImageEvidenceBinding) this).f36187a.setTag(null);
        ((ItemReportImageEvidenceBinding) this).f12981a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12985a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f12984a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
