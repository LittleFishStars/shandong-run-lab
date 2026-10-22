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
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemManageTopicBindingImpl extends ChannelItemManageTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8031a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8034a;

    @NonNull
    public final ImageView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33269a = sparseIntArray;
        sparseIntArray.put(R.id.iv_edit, 3);
    }

    public ChannelItemManageTopicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8031a, f33269a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String subjectImg;
        synchronized (this) {
            j = this.f8032a;
            this.f8032a = 0L;
        }
        MyChannelTopic myChannelTopic = ((ChannelItemManageTopicBinding) this).f8030a;
        long j2 = j & 3;
        String subjectName = null;
        if (j2 != 0) {
            requestOptions = ju3.p;
            if (myChannelTopic != null) {
                subjectName = myChannelTopic.getSubjectName();
                subjectImg = myChannelTopic.getSubjectImg();
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
            CommonBindingAdapter.b0(this.b, subjectName, requestOptions, false);
            TextViewBindingAdapter.setText(this.f8034a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8032a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8032a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemManageTopicBinding
    public void k(@Nullable MyChannelTopic myChannelTopic) {
        ((ChannelItemManageTopicBinding) this).f8030a = myChannelTopic;
        synchronized (this) {
            this.f8032a |= 1;
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
        k((MyChannelTopic) obj);
        return true;
    }

    public ChannelItemManageTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3]);
        this.f8032a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f8033a = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.b = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f8034a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
