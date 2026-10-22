package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.external.bean.ChannelBean;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemAllChannelListBindingImpl extends WorksItemAllChannelListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36996a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14430a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14432a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public WorksItemAllChannelListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f14430a, f36996a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zShowOfficial;
        RequestOptions requestOptions;
        String formatterPopularity;
        Object coverUrl;
        String avatar;
        String str;
        String formatterFollowedCount;
        String channelName;
        synchronized (this) {
            j = this.f14431a;
            this.f14431a = 0L;
        }
        ChannelBean channelBean = ((WorksItemAllChannelListBinding) this).f14429a;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.v;
            if (channelBean != null) {
                formatterPopularity = channelBean.getFormatterPopularity();
                coverUrl = channelBean.formatCoverUrl();
                avatar = channelBean.getAvatar();
                channelName = channelBean.getChannelName();
                formatterFollowedCount = channelBean.getFormatterFollowedCount();
                zShowOfficial = channelBean.showOfficial();
            } else {
                zShowOfficial = false;
                formatterPopularity = null;
                coverUrl = null;
                avatar = null;
                channelName = null;
                formatterFollowedCount = null;
            }
            str = String.format("@%s", channelName);
        } else {
            zShowOfficial = false;
            requestOptions = null;
            formatterPopularity = null;
            coverUrl = null;
            avatar = null;
            str = null;
            formatterFollowedCount = null;
        }
        if (j2 != 0) {
            aw9.d(((WorksItemAllChannelListBinding) this).f14428a, avatar, false, null);
            CommonBindingAdapter.b0(((WorksItemAllChannelListBinding) this).f14427a, coverUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.c, formatterPopularity);
            CommonBindingAdapter.l0(this.d, zShowOfficial);
            TextViewBindingAdapter.setText(((WorksItemAllChannelListBinding) this).f36995a, str);
            TextViewBindingAdapter.setText(this.b, formatterFollowedCount);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14431a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14431a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemAllChannelListBinding
    public void k(@Nullable ChannelBean Vm) {
        ((WorksItemAllChannelListBinding) this).f14429a = Vm;
        synchronized (this) {
            this.f14431a |= 1;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((ChannelBean) variable);
        return true;
    }

    public WorksItemAllChannelListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AvatarView) bindings[3], (RoundImageView) bindings[1], (TextView) bindings[2], (TextView) bindings[6]);
        this.f14431a = -1L;
        ((WorksItemAllChannelListBinding) this).f14428a.setTag(null);
        ((WorksItemAllChannelListBinding) this).f14427a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14432a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[4];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[5];
        this.d = textView2;
        textView2.setTag(null);
        ((WorksItemAllChannelListBinding) this).f36995a.setTag(null);
        this.b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
