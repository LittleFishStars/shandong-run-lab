package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelTopicBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemAllTopicBindingImpl extends ChannelItemAllTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33225a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7920a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7923a;

    public ChannelItemAllTopicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f7920a, f33225a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String str2;
        String popularityValue;
        Object obj;
        synchronized (this) {
            j = this.f7921a;
            this.f7921a = 0L;
        }
        ChannelTopicBean channelTopicBean = ((ChannelItemAllTopicBinding) this).f7919a;
        long j2 = j & 3;
        Object obj2 = null;
        if (j2 != 0) {
            requestOptions = ju3.u;
            if (channelTopicBean != null) {
                Object subjectImg = channelTopicBean.formatSubjectImg();
                String subjectName = channelTopicBean.getSubjectName();
                popularityValue = channelTopicBean.getPopularityValue();
                obj = subjectImg;
                obj2 = subjectName;
            } else {
                popularityValue = null;
                obj = null;
            }
            String str3 = String.format("#%s", obj2);
            str = String.format(((ChannelItemAllTopicBinding) this).f33224a.getResources().getString(R.string.channel_my_channel_hot), popularityValue);
            Object obj3 = obj;
            str2 = str3;
            obj2 = obj3;
        } else {
            requestOptions = null;
            str = null;
            str2 = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f7922a, obj2, requestOptions, false);
            TextViewBindingAdapter.setText(((ChannelItemAllTopicBinding) this).f33224a, str);
            TextViewBindingAdapter.setText(this.b, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7921a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7921a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemAllTopicBinding
    public void k(@Nullable ChannelTopicBean channelTopicBean) {
        ((ChannelItemAllTopicBinding) this).f7919a = channelTopicBean;
        synchronized (this) {
            this.f7921a |= 1;
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
        k((ChannelTopicBean) obj);
        return true;
    }

    public ChannelItemAllTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (TextView) objArr[2]);
        this.f7921a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7923a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f7922a = imageView;
        imageView.setTag(null);
        ((ChannelItemAllTopicBinding) this).f33224a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
