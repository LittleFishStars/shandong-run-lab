package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorksBindingImpl extends WorksItemWorksBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14744a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14747a;

    @NonNull
    public final BLTextView b;

    @NonNull
    public final BLTextView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f14748e;

    @NonNull
    public final TextView f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37086a = sparseIntArray;
        sparseIntArray.put(R.id.flImageContainer, 16);
        sparseIntArray.put(R.id.ivHot, 17);
    }

    public WorksItemWorksBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 18, f14744a, f37086a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        RequestOptions requestOptions;
        String str;
        String str2;
        String str3;
        int i;
        boolean z4;
        CharSequence charSequence;
        String str4;
        String str5;
        CharSequence charSequence2;
        String str6;
        int i2;
        Object obj;
        int i3;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String str7;
        boolean zSafeUnbox;
        int i4;
        boolean zShowVideoIcon;
        String popularityValue;
        String attentionTag;
        int attentionIcon;
        boolean zShowChannelName;
        boolean zShowTag;
        CharSequence title;
        String tagText;
        String avatar;
        CharSequence channelName;
        String userName;
        int violationIcon;
        Object coverUrl;
        int tagBackground;
        boolean zShowTitle;
        boolean zShowViolation;
        boolean zShowCategoryTag;
        String violationText;
        boolean zShowImage;
        String categoryTag;
        synchronized (this) {
            j = this.f14745a;
            this.f14745a = 0L;
        }
        WorkItemBean workItemBean = ((WorksItemWorksBinding) this).f14739a;
        Boolean bool = ((WorksItemWorksBinding) this).f14741a;
        long j2 = j & 5;
        if (j2 != 0) {
            requestOptions = ju3.s;
            if (workItemBean != null) {
                zShowVideoIcon = workItemBean.showVideoIcon();
                popularityValue = workItemBean.getPopularityValue();
                attentionTag = workItemBean.formatAttentionTag();
                attentionIcon = workItemBean.formatAttentionIcon();
                zShowChannelName = workItemBean.showChannelName();
                zShowTag = workItemBean.showTag();
                title = workItemBean.formatTitle();
                tagText = workItemBean.formatTagText();
                avatar = workItemBean.getAvatar();
                channelName = workItemBean.formatChannelName();
                userName = workItemBean.getUserName();
                violationIcon = workItemBean.formatViolationIcon();
                coverUrl = workItemBean.formatCoverUrl();
                tagBackground = workItemBean.formatTagBackground();
                zShowTitle = workItemBean.showTitle();
                zShowViolation = workItemBean.showViolation();
                zShowCategoryTag = workItemBean.showCategoryTag();
                violationText = workItemBean.formatViolationText();
                int visit = workItemBean.getVisit();
                zShowImage = workItemBean.showImage();
                categoryTag = workItemBean.getCategoryTag();
                i4 = visit;
            } else {
                i4 = 0;
                zShowVideoIcon = false;
                popularityValue = null;
                attentionTag = null;
                attentionIcon = 0;
                zShowChannelName = false;
                zShowTag = false;
                title = null;
                tagText = null;
                avatar = null;
                channelName = null;
                userName = null;
                violationIcon = 0;
                coverUrl = null;
                tagBackground = 0;
                zShowTitle = false;
                zShowViolation = false;
                zShowCategoryTag = false;
                violationText = null;
                zShowImage = false;
                categoryTag = null;
            }
            if (j2 != 0) {
                j = zShowViolation ? j | 64 : j | 32;
            }
            z = i4 == 2;
            z2 = zShowVideoIcon;
            str2 = popularityValue;
            str3 = attentionTag;
            i = attentionIcon;
            z3 = zShowChannelName;
            z4 = zShowTag;
            charSequence = title;
            str4 = tagText;
            str5 = avatar;
            charSequence2 = channelName;
            str6 = userName;
            i2 = violationIcon;
            obj = coverUrl;
            i3 = tagBackground;
            z5 = zShowTitle;
            z6 = zShowViolation;
            z7 = zShowCategoryTag;
            str = violationText;
            z8 = zShowImage;
            str7 = categoryTag;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            requestOptions = null;
            str = null;
            str2 = null;
            str3 = null;
            i = 0;
            z4 = false;
            charSequence = null;
            str4 = null;
            str5 = null;
            charSequence2 = null;
            str6 = null;
            i2 = 0;
            obj = null;
            i3 = 0;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            str7 = null;
        }
        long j3 = j & 7;
        if (j3 != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j3 != 0) {
                j = zSafeUnbox ? j | 16 : j | 8;
            }
        } else {
            zSafeUnbox = false;
        }
        boolean zShowAttentionTag = ((j & 16) == 0 || workItemBean == null) ? false : workItemBean.showAttentionTag();
        boolean zIsEmpty = (64 & j) != 0 ? true ^ TextUtils.isEmpty(str) : false;
        long j4 = j & 7;
        if (j4 == 0 || !zSafeUnbox) {
            zShowAttentionTag = false;
        }
        long j5 = j & 5;
        boolean z9 = z6;
        if (j5 == 0 || !z9) {
            zIsEmpty = false;
        }
        if (j5 != 0) {
            CommonBindingAdapter.l0(((WorksItemWorksBinding) this).f37085a, z3);
            aw9.d(((WorksItemWorksBinding) this).f14738a, str5, false, null);
            CommonBindingAdapter.l0(((WorksItemWorksBinding) this).b, z8);
            CommonBindingAdapter.b0(((WorksItemWorksBinding) this).b, obj, requestOptions, false);
            CommonBindingAdapter.l0(((WorksItemWorksBinding) this).c, z2);
            DrawablesBindingAdapter.e(this.d, i2);
            CommonBindingAdapter.l0(this.d, z9);
            TextViewBindingAdapter.setText(this.f14747a, charSequence2);
            TextViewBindingAdapter.setText(this.f14748e, str6);
            CommonBindingAdapter.l0(this.f, zIsEmpty);
            TextViewBindingAdapter.setText(this.f, str);
            CommonBindingAdapter.l0(this.b, z7);
            TextViewBindingAdapter.setText(this.b, str7);
            CommonBindingAdapter.l0(this.c, z);
            DrawablesBindingAdapter.e(this.e, i);
            TextViewBindingAdapter.setText(((WorksItemWorksBinding) this).f14737a, str2);
            TextViewBindingAdapter.setText(((WorksItemWorksBinding) this).f14742b, str3);
            CommonBindingAdapter.x(((WorksItemWorksBinding) this).f14743c, i3);
            CommonBindingAdapter.l0(((WorksItemWorksBinding) this).f14743c, z4);
            TextViewBindingAdapter.setText(((WorksItemWorksBinding) this).f14743c, str4);
            CommonBindingAdapter.l0(super.d, z5);
            TextViewBindingAdapter.setText(super.d, charSequence);
        }
        if (j4 != 0) {
            CommonBindingAdapter.l0(this.e, zShowAttentionTag);
            CommonBindingAdapter.l0(((WorksItemWorksBinding) this).f14742b, zShowAttentionTag);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14745a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14745a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorksBinding
    public void l(@Nullable Boolean ShowRelation) {
        ((WorksItemWorksBinding) this).f14741a = ShowRelation;
        synchronized (this) {
            this.f14745a |= 2;
        }
        notifyPropertyChanged(qk0.b0);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorksBinding
    public void m(@Nullable WorkItemBean Vm) {
        ((WorksItemWorksBinding) this).f14739a = Vm;
        synchronized (this) {
            this.f14745a |= 1;
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
        if (qk0.p0 == variableId) {
            m((WorkItemBean) variable);
        } else {
            if (qk0.b0 != variableId) {
                return false;
            }
            l((Boolean) variable);
        }
        return true;
    }

    public WorksItemWorksBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLFrameLayout) bindings[16], (FrameLayout) bindings[11], (AvatarView) bindings[13], (ImageView) bindings[17], (ImageView) bindings[3], (ImageView) bindings[7], (TextView) bindings[15], (TextView) bindings[8], (TextView) bindings[4], (TextView) bindings[10]);
        this.f14745a = -1L;
        ((WorksItemWorksBinding) this).f37085a.setTag(null);
        ((WorksItemWorksBinding) this).f14738a.setTag(null);
        ((WorksItemWorksBinding) this).b.setTag(null);
        ((WorksItemWorksBinding) this).c.setTag(null);
        CardView cardView = (CardView) bindings[0];
        this.f14746a = cardView;
        cardView.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.d = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[12];
        this.f14747a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) bindings[14];
        this.f14748e = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.f = textView2;
        textView2.setTag(null);
        BLTextView bLTextView2 = (BLTextView) bindings[5];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        BLTextView bLTextView3 = (BLTextView) bindings[6];
        this.c = bLTextView3;
        bLTextView3.setTag(null);
        ImageView imageView2 = (ImageView) bindings[9];
        this.e = imageView2;
        imageView2.setTag(null);
        ((WorksItemWorksBinding) this).f14737a.setTag(null);
        ((WorksItemWorksBinding) this).f14742b.setTag(null);
        ((WorksItemWorksBinding) this).f14743c.setTag(null);
        super.d.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
