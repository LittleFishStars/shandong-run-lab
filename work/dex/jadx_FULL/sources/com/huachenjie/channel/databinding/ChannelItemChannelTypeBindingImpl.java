package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.channel.bean.ClassificationBean;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemChannelTypeBindingImpl extends ChannelItemChannelTypeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33233a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7939a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7941a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f7942a;

    public ChannelItemChannelTypeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f7939a, f33233a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7940a;
            this.f7940a = 0L;
        }
        ClassificationBean classificationBean = ((ChannelItemChannelTypeBinding) this).f33232a;
        long j2 = j & 3;
        String classificationName = (j2 == 0 || classificationBean == null) ? null : classificationBean.getClassificationName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f7941a, classificationName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7940a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7940a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemChannelTypeBinding
    public void k(@Nullable ClassificationBean classificationBean) {
        ((ChannelItemChannelTypeBinding) this).f33232a = classificationBean;
        synchronized (this) {
            this.f7940a |= 1;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.g != i) {
            return false;
        }
        k((ClassificationBean) obj);
        return true;
    }

    public ChannelItemChannelTypeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f7940a = -1L;
        CardView cardView = (CardView) objArr[0];
        this.f7942a = cardView;
        cardView.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f7941a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
