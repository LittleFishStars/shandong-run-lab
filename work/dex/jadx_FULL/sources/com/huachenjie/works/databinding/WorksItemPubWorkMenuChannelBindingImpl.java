package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemPubWorkMenuChannelBindingImpl extends WorksItemPubWorkMenuChannelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37050a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14640a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f14642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14643a;

    public WorksItemPubWorkMenuChannelBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f14640a, f37050a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean zIsEmpty;
        String str;
        RequestOptions requestOptions;
        String popularityValue;
        String logoUrl;
        String description;
        Object drawable;
        int channelType;
        String title;
        synchronized (this) {
            j = this.f14641a;
            this.f14641a = 0L;
        }
        PubWorkChannelBean pubWorkChannelBean = ((WorksItemPubWorkMenuChannelBinding) this).f14639a;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.b;
            if (pubWorkChannelBean != null) {
                popularityValue = pubWorkChannelBean.getPopularityValue();
                title = pubWorkChannelBean.getTitle();
                logoUrl = pubWorkChannelBean.getLogoUrl();
                description = pubWorkChannelBean.getDescription();
                channelType = pubWorkChannelBean.getChannelType();
            } else {
                channelType = 0;
                popularityValue = null;
                title = null;
                logoUrl = null;
                description = null;
            }
            str = String.format("@%s", title);
            zIsEmpty = TextUtils.isEmpty(logoUrl);
            z = channelType != 4;
            if (j2 != 0) {
                j |= zIsEmpty ? 8L : 4L;
            }
        } else {
            z = false;
            zIsEmpty = false;
            str = null;
            requestOptions = null;
            popularityValue = null;
            logoUrl = null;
            description = null;
        }
        long j3 = j & 3;
        if (j3 != 0) {
            drawable = zIsEmpty ? AppCompatResources.getDrawable(((WorksItemPubWorkMenuChannelBinding) this).f37049a.getContext(), R.drawable.works_ic_channel_default_pic) : logoUrl;
        } else {
            drawable = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(((WorksItemPubWorkMenuChannelBinding) this).f37049a, drawable, requestOptions, false);
            CommonBindingAdapter.l0(this.f14643a, z);
            TextViewBindingAdapter.setText(((WorksItemPubWorkMenuChannelBinding) this).f14638a, description);
            TextViewBindingAdapter.setText(this.b, popularityValue);
            TextViewBindingAdapter.setText(this.c, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14641a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14641a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPubWorkMenuChannelBinding
    public void k(@Nullable PubWorkChannelBean Bean) {
        ((WorksItemPubWorkMenuChannelBinding) this).f14639a = Bean;
        synchronized (this) {
            this.f14641a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((PubWorkChannelBean) variable);
        return true;
    }

    public WorksItemPubWorkMenuChannelBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (TextView) bindings[4], (TextView) bindings[5], (TextView) bindings[3]);
        this.f14641a = -1L;
        ((WorksItemPubWorkMenuChannelBinding) this).f37049a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f14642a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.f14643a = bLTextView;
        bLTextView.setTag(null);
        ((WorksItemPubWorkMenuChannelBinding) this).f14638a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
