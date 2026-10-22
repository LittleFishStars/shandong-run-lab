package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BaseItemMoreOptBindingImpl extends BaseItemMoreOptBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32811a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f6979a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f6980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f6981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f6982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f6983a;

    public BaseItemMoreOptBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f6979a, f32811a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String name;
        int icon;
        synchronized (this) {
            j = this.f6980a;
            this.f6980a = 0L;
        }
        MoreOptBean moreOptBean = ((BaseItemMoreOptBinding) this).f32810a;
        long j2 = j & 3;
        if (j2 == 0 || moreOptBean == null) {
            name = null;
            icon = 0;
        } else {
            name = moreOptBean.getName();
            icon = moreOptBean.getIcon();
        }
        if (j2 != 0) {
            CommonBindingAdapter.S(this.f6981a, icon);
            TextViewBindingAdapter.setText(this.f6983a, name);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6980a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6980a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.BaseItemMoreOptBinding
    public void k(@Nullable MoreOptBean Bean) {
        ((BaseItemMoreOptBinding) this).f32810a = Bean;
        synchronized (this) {
            this.f6980a |= 1;
        }
        notifyPropertyChanged(sk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.g != variableId) {
            return false;
        }
        k((MoreOptBean) variable);
        return true;
    }

    public BaseItemMoreOptBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f6980a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f6982a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f6981a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f6983a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
