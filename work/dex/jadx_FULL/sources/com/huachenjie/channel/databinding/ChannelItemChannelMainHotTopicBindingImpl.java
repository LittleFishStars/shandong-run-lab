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
import com.huachenjie.channel.bean.ChannelTopicBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemChannelMainHotTopicBindingImpl extends ChannelItemChannelMainHotTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33231a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7934a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7938a;

    public ChannelItemChannelMainHotTopicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7934a, f33231a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String subjectImg;
        synchronized (this) {
            j = this.f7935a;
            this.f7935a = 0L;
        }
        ChannelTopicBean channelTopicBean = ((ChannelItemChannelMainHotTopicBinding) this).f33230a;
        long j2 = j & 3;
        String subjectName = null;
        if (j2 != 0) {
            requestOptions = ju3.p;
            if (channelTopicBean != null) {
                subjectName = channelTopicBean.getSubjectName();
                subjectImg = channelTopicBean.getSubjectImg();
            } else {
                subjectImg = null;
            }
            String str2 = subjectImg;
            str = String.format("#%s", subjectName);
            subjectName = str2;
        } else {
            requestOptions = null;
            str = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f7937a, subjectName, requestOptions, false);
            TextViewBindingAdapter.setText(this.f7938a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7935a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7935a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemChannelMainHotTopicBinding
    public void k(@Nullable ChannelTopicBean channelTopicBean) {
        ((ChannelItemChannelMainHotTopicBinding) this).f33230a = channelTopicBean;
        synchronized (this) {
            this.f7935a |= 1;
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

    public ChannelItemChannelMainHotTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f7935a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f7936a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f7937a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f7938a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
