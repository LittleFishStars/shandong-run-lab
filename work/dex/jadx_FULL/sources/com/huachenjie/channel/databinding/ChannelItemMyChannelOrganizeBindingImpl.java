package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemMyChannelOrganizeBindingImpl extends ChannelItemMyChannelOrganizeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33281a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8064a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8068a;

    @NonNull
    public final TextView b;

    public ChannelItemMyChannelOrganizeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f8064a, f33281a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String str2;
        int i;
        synchronized (this) {
            j = this.f8065a;
            this.f8065a = 0L;
        }
        Boolean bool = ((ChannelItemMyChannelOrganizeBinding) this).f8063a;
        OrganizeBean organizeBean = ((ChannelItemMyChannelOrganizeBinding) this).f8062a;
        long j2 = 5 & j;
        boolean zSafeUnbox = j2 != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        long j3 = j & 6;
        String coverUrl = null;
        if (j3 != 0) {
            requestOptions = ju3.p;
            if (organizeBean != null) {
                String clubName = organizeBean.getClubName();
                int userCount = organizeBean.getUserCount();
                str = clubName;
                coverUrl = organizeBean.getCoverUrl();
                i = userCount;
            } else {
                str = null;
                i = 0;
            }
            str2 = String.format("成员：%s人", Integer.valueOf(i));
        } else {
            requestOptions = null;
            str = null;
            str2 = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f8068a, zSafeUnbox);
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(this.f8066a, coverUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.b, str2);
            TextViewBindingAdapter.setText(((ChannelItemMyChannelOrganizeBinding) this).f33280a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8065a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8065a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelOrganizeBinding
    public void l(@Nullable OrganizeBean organizeBean) {
        ((ChannelItemMyChannelOrganizeBinding) this).f8062a = organizeBean;
        synchronized (this) {
            this.f8065a |= 2;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelOrganizeBinding
    public void m(@Nullable Boolean bool) {
        ((ChannelItemMyChannelOrganizeBinding) this).f8063a = bool;
        synchronized (this) {
            this.f8065a |= 1;
        }
        notifyPropertyChanged(tk0.v);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.v == i) {
            m((Boolean) obj);
        } else {
            if (tk0.g != i) {
                return false;
            }
            l((OrganizeBean) obj);
        }
        return true;
    }

    public ChannelItemMyChannelOrganizeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3]);
        this.f8065a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f8067a = relativeLayout;
        relativeLayout.setTag(null);
        BLView bLView = (BLView) objArr[1];
        this.f8068a = bLView;
        bLView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f8066a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.b = textView;
        textView.setTag(null);
        ((ChannelItemMyChannelOrganizeBinding) this).f33280a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
