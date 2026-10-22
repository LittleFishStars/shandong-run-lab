package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.works.bean.DormitoryMenuBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemDormitoryMenuBindingImpl extends WorksItemDormitoryMenuBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37028a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14559a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14564a;

    public WorksItemDormitoryMenuBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14559a, f37028a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iconRes;
        String title;
        int showVipTag;
        synchronized (this) {
            j = this.f14560a;
            this.f14560a = 0L;
        }
        DormitoryMenuBean dormitoryMenuBean = ((WorksItemDormitoryMenuBinding) this).f37027a;
        long j2 = j & 3;
        if (j2 == 0 || dormitoryMenuBean == null) {
            iconRes = 0;
            title = null;
            showVipTag = 0;
        } else {
            iconRes = dormitoryMenuBean.getIconRes();
            showVipTag = dormitoryMenuBean.getShowVipTag();
            title = dormitoryMenuBean.getTitle();
        }
        if (j2 != 0) {
            DrawablesBindingAdapter.e(this.f14562a, iconRes);
            TextViewBindingAdapter.setText(this.f14563a, title);
            this.f14564a.setVisibility(showVipTag);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14560a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14560a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemDormitoryMenuBinding
    public void k(@Nullable DormitoryMenuBean Bean) {
        ((WorksItemDormitoryMenuBinding) this).f37027a = Bean;
        synchronized (this) {
            this.f14560a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((DormitoryMenuBean) variable);
        return true;
    }

    public WorksItemDormitoryMenuBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14560a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14561a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14562a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f14563a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[3];
        this.f14564a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
