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
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemMyChannelTopicBindingImpl extends ChannelItemMyChannelTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33285a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8076a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f8078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8081a;

    public ChannelItemMyChannelTopicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8076a, f33285a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        int i;
        String subjectImg;
        String str;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f8077a;
            this.f8077a = 0L;
        }
        Boolean bool = ((ChannelItemMyChannelTopicBinding) this).f8075a;
        MyChannelTopic myChannelTopic = ((ChannelItemMyChannelTopicBinding) this).f33284a;
        long j2 = j & 5;
        if (j2 != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            boolean z = !zSafeUnbox;
            if (j2 != 0) {
                j |= z ? 16L : 8L;
            }
            i = z ? 10 : 0;
        } else {
            zSafeUnbox = false;
            i = 0;
        }
        long j3 = 6 & j;
        String subjectName = null;
        if (j3 != 0) {
            RequestOptions requestOptions2 = ju3.p;
            if (myChannelTopic != null) {
                subjectName = myChannelTopic.getSubjectName();
                subjectImg = myChannelTopic.getSubjectImg();
            } else {
                subjectImg = null;
            }
            str = String.format("#%s", subjectName);
            requestOptions = requestOptions2;
        } else {
            subjectImg = null;
            str = null;
            requestOptions = null;
        }
        if ((j & 5) != 0) {
            CommonBindingAdapter.I(this.f8078a, 12, 0, 12, i, null);
            CommonBindingAdapter.l0(this.f8081a, zSafeUnbox);
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(this.f8079a, subjectImg, requestOptions, false);
            TextViewBindingAdapter.setText(this.f8080a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8077a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8077a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelTopicBinding
    public void l(@Nullable MyChannelTopic myChannelTopic) {
        ((ChannelItemMyChannelTopicBinding) this).f33284a = myChannelTopic;
        synchronized (this) {
            this.f8077a |= 2;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelTopicBinding
    public void m(@Nullable Boolean bool) {
        ((ChannelItemMyChannelTopicBinding) this).f8075a = bool;
        synchronized (this) {
            this.f8077a |= 1;
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
            l((MyChannelTopic) obj);
        }
        return true;
    }

    public ChannelItemMyChannelTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8077a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f8078a = frameLayout;
        frameLayout.setTag(null);
        BLView bLView = (BLView) objArr[1];
        this.f8081a = bLView;
        bLView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f8079a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f8080a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
