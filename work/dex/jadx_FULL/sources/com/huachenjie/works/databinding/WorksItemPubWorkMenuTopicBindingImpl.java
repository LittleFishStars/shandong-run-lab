package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.bean.publish.PubWorkTopicBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemPubWorkMenuTopicBindingImpl extends WorksItemPubWorkMenuTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37054a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14648a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14652a;

    @NonNull
    public final BLTextView b;

    public WorksItemPubWorkMenuTopicBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14648a, f37054a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        String str;
        String title;
        synchronized (this) {
            j = this.f14649a;
            this.f14649a = 0L;
        }
        PubWorkTopicBean pubWorkTopicBean = ((WorksItemPubWorkMenuTopicBinding) this).f37053a;
        long j2 = j & 3;
        String popularityValue = null;
        boolean zIsNewTopic = false;
        if (j2 != 0) {
            if (pubWorkTopicBean != null) {
                zIsNewTopic = pubWorkTopicBean.isNewTopic();
                popularityValue = pubWorkTopicBean.getPopularityValue();
                title = pubWorkTopicBean.getTitle();
            } else {
                title = null;
            }
            z2 = !zIsNewTopic;
            boolean z3 = zIsNewTopic;
            str = popularityValue;
            popularityValue = title;
            z = z3;
        } else {
            z = false;
            z2 = false;
            str = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f14651a, popularityValue);
            CommonBindingAdapter.l0(this.f14652a, z2);
            TextViewBindingAdapter.setText(this.f14652a, str);
            CommonBindingAdapter.l0(this.b, z);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14649a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14649a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPubWorkMenuTopicBinding
    public void k(@Nullable PubWorkTopicBean Bean) {
        ((WorksItemPubWorkMenuTopicBinding) this).f37053a = Bean;
        synchronized (this) {
            this.f14649a |= 1;
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
        k((PubWorkTopicBean) variable);
        return true;
    }

    public WorksItemPubWorkMenuTopicBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14649a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14650a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f14651a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.f14652a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) bindings[3];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
