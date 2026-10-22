package com.huachenjie.channel.databinding;

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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemChannelMainHotOrganizeBindingImpl extends ChannelItemChannelMainHotOrganizeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33229a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7929a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7933a;

    public ChannelItemChannelMainHotOrganizeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7929a, f33229a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String clubName;
        synchronized (this) {
            j = this.f7930a;
            this.f7930a = 0L;
        }
        OrganizeBean organizeBean = ((ChannelItemChannelMainHotOrganizeBinding) this).f33228a;
        long j2 = j & 3;
        String coverUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.p;
            if (organizeBean != null) {
                clubName = organizeBean.getClubName();
                coverUrl = organizeBean.getCoverUrl();
            } else {
                clubName = null;
            }
        } else {
            requestOptions = null;
            clubName = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f7932a, coverUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.f7933a, clubName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7930a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7930a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemChannelMainHotOrganizeBinding
    public void k(@Nullable OrganizeBean organizeBean) {
        ((ChannelItemChannelMainHotOrganizeBinding) this).f33228a = organizeBean;
        synchronized (this) {
            this.f7930a |= 1;
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
        k((OrganizeBean) obj);
        return true;
    }

    public ChannelItemChannelMainHotOrganizeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f7930a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f7931a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f7932a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f7933a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
