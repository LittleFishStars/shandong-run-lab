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
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemMyChannelTopicGroupBindingImpl extends ChannelItemMyChannelTopicGroupBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33289a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8088a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8092a;

    public ChannelItemMyChannelTopicGroupBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f8088a, f33289a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean isExpanded;
        synchronized (this) {
            j = this.f8089a;
            this.f8089a = 0L;
        }
        MyChannelTopicGroup myChannelTopicGroup = ((ChannelItemMyChannelTopicGroupBinding) this).f33288a;
        long j2 = j & 3;
        int i = 0;
        String subjectCategoryName = null;
        if (j2 != 0) {
            if (myChannelTopicGroup != null) {
                subjectCategoryName = myChannelTopicGroup.getSubjectCategoryName();
                isExpanded = myChannelTopicGroup.getIsExpanded();
            } else {
                isExpanded = false;
            }
            if (j2 != 0) {
                j |= isExpanded ? 8L : 4L;
            }
            if (!isExpanded) {
                i = 270;
            }
        }
        if ((j & 3) != 0) {
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.f8090a.setRotation(i);
            }
            TextViewBindingAdapter.setText(this.f8092a, subjectCategoryName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8089a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8089a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelTopicGroupBinding
    public void k(@Nullable MyChannelTopicGroup myChannelTopicGroup) {
        ((ChannelItemMyChannelTopicGroupBinding) this).f33288a = myChannelTopicGroup;
        synchronized (this) {
            this.f8089a |= 1;
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
        k((MyChannelTopicGroup) obj);
        return true;
    }

    public ChannelItemMyChannelTopicGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8089a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8091a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f8090a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f8092a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
