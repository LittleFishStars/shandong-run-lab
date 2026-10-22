package com.huachenjie.channel.databinding;

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
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopic;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemManageTopicChatTopicBindingImpl extends ChannelItemManageTopicChatTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33273a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8041a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8045a;

    public ChannelItemManageTopicChatTopicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f8041a, f33273a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean isExpanded;
        synchronized (this) {
            j = this.f8042a;
            this.f8042a = 0L;
        }
        ManageTopic manageTopic = ((ChannelItemManageTopicChatTopicBinding) this).f33272a;
        long j2 = j & 3;
        String subjectName = null;
        int i = 0;
        if (j2 != 0) {
            if (manageTopic != null) {
                subjectName = manageTopic.getSubjectName();
                isExpanded = manageTopic.getIsExpanded();
            } else {
                isExpanded = false;
            }
            if (j2 != 0) {
                j |= isExpanded ? 8L : 4L;
            }
            subjectName = String.format("#%s", subjectName);
            if (!isExpanded) {
                i = 270;
            }
        }
        if ((j & 3) != 0) {
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.f8043a.setRotation(i);
            }
            TextViewBindingAdapter.setText(this.f8045a, subjectName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8042a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8042a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemManageTopicChatTopicBinding
    public void k(@Nullable ManageTopic manageTopic) {
        ((ChannelItemManageTopicChatTopicBinding) this).f33272a = manageTopic;
        synchronized (this) {
            this.f8042a |= 1;
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
        k((ManageTopic) obj);
        return true;
    }

    public ChannelItemManageTopicChatTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8042a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8044a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f8043a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f8045a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
