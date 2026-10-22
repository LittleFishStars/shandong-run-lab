package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.channel.bean.OrganizeBean;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemPublishOrgMesssageClubBindingImpl extends ChannelItemPublishOrgMesssageClubBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33311a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8165a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8167a;

    public ChannelItemPublishOrgMesssageClubBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f8165a, f33311a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f8166a;
            this.f8166a = 0L;
        }
        OrganizeBean organizeBean = ((ChannelItemPublishOrgMesssageClubBinding) this).f33310a;
        long j2 = j & 3;
        String clubName = (j2 == 0 || organizeBean == null) ? null : organizeBean.getClubName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f8167a, clubName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8166a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8166a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemPublishOrgMesssageClubBinding
    public void k(@Nullable OrganizeBean organizeBean) {
        ((ChannelItemPublishOrgMesssageClubBinding) this).f33310a = organizeBean;
        synchronized (this) {
            this.f8166a |= 1;
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

    public ChannelItemPublishOrgMesssageClubBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8166a = -1L;
        TextView textView = (TextView) objArr[0];
        this.f8167a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
