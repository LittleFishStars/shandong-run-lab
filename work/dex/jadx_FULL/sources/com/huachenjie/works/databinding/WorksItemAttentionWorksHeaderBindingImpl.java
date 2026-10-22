package com.huachenjie.works.databinding;

import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.widget.TagListView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemAttentionWorksHeaderBindingImpl extends WorksItemAttentionWorksHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14450a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14452a;

    @NonNull
    public final ConstraintLayout b;

    @NonNull
    public final TextView f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37000a = sparseIntArray;
        sparseIntArray.put(R.id.vLine, 12);
        sparseIntArray.put(R.id.llNickName, 13);
    }

    public WorksItemAttentionWorksHeaderBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 14, f14450a, f37000a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String nickName;
        List<String> tagList;
        String str;
        String attentionTag;
        String str2;
        String str3;
        CharSequence charSequence;
        String str4;
        String str5;
        String str6;
        boolean z;
        boolean z2;
        boolean zShowAttentionTag;
        int tagBackground;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String title;
        UserInfoBean userInfo;
        Boolean showLookMore;
        SpannableString content;
        String publishTime;
        String avatarUrl;
        CharSequence textContent;
        String categoryTag;
        String avatarFrameUrl;
        String channelName;
        boolean zShowChannelName;
        boolean zShowCategoryTag;
        synchronized (this) {
            j = this.f14451a;
            this.f14451a = 0L;
        }
        WorkDetailBean workDetailBean = ((WorksItemAttentionWorksHeaderBinding) this).f14446a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (workDetailBean != null) {
                zShowAttentionTag = workDetailBean.showAttentionTag();
                title = workDetailBean.getTitle();
                tagBackground = workDetailBean.formatTagBackground();
                attentionTag = workDetailBean.formatAttentionTag();
                userInfo = workDetailBean.getUserInfo();
                showLookMore = workDetailBean.getShowLookMore();
                zShowChannelName = workDetailBean.showChannelName();
                content = workDetailBean.formatContent();
                publishTime = workDetailBean.formatPublishTime();
                zShowCategoryTag = workDetailBean.showCategoryTag();
                avatarUrl = workDetailBean.formatAvatarUrl();
                textContent = workDetailBean.getTextContent();
                categoryTag = workDetailBean.getCategoryTag();
                avatarFrameUrl = workDetailBean.formatAvatarFrameUrl();
                channelName = workDetailBean.formatChannelName();
                nickName = workDetailBean.formatNickName();
            } else {
                nickName = null;
                title = null;
                attentionTag = null;
                userInfo = null;
                showLookMore = null;
                content = null;
                publishTime = null;
                avatarUrl = null;
                textContent = null;
                categoryTag = null;
                avatarFrameUrl = null;
                channelName = null;
                zShowAttentionTag = false;
                tagBackground = 0;
                zShowChannelName = false;
                zShowCategoryTag = false;
            }
            if (j2 != 0) {
                j |= zShowChannelName ? 8L : 4L;
            }
            boolean zIsEmpty = TextUtils.isEmpty(title);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(showLookMore);
            boolean zIsEmpty2 = TextUtils.isEmpty(content);
            z = !zIsEmpty;
            tagList = userInfo != null ? userInfo.getTagList() : null;
            z3 = zSafeUnbox;
            z2 = zShowChannelName;
            z4 = !zIsEmpty2;
            str3 = publishTime;
            z5 = zShowCategoryTag;
            charSequence = textContent;
            str4 = categoryTag;
            str5 = avatarFrameUrl;
            str6 = channelName;
            str2 = title;
            str = avatarUrl;
        } else {
            nickName = null;
            tagList = null;
            str = null;
            attentionTag = null;
            str2 = null;
            str3 = null;
            charSequence = null;
            str4 = null;
            str5 = null;
            str6 = null;
            z = false;
            z2 = false;
            zShowAttentionTag = false;
            tagBackground = 0;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        long j3 = j & 3;
        if (j3 != 0) {
            z6 = z2 ? true : z5;
        } else {
            z6 = false;
        }
        if (j3 != 0) {
            aw9.d(((WorksItemAttentionWorksHeaderBinding) this).f14445a, str, false, null);
            aw9.c(((WorksItemAttentionWorksHeaderBinding) this).f14445a, str5, null);
            CommonBindingAdapter.x(this.f, tagBackground);
            CommonBindingAdapter.l0(this.f, zShowAttentionTag);
            TextViewBindingAdapter.setText(this.f, attentionTag);
            CommonBindingAdapter.l0(this.b, z6);
            ((WorksItemAttentionWorksHeaderBinding) this).f14447a.setTagList(tagList);
            CommonBindingAdapter.l0(((WorksItemAttentionWorksHeaderBinding) this).f14444a, z4);
            TextViewBindingAdapter.setText(((WorksItemAttentionWorksHeaderBinding) this).f14444a, charSequence);
            CommonBindingAdapter.l0(((WorksItemAttentionWorksHeaderBinding) this).f14448a, z2);
            TextViewBindingAdapter.setText(((WorksItemAttentionWorksHeaderBinding) this).f14448a, str6);
            CommonBindingAdapter.l0(((WorksItemAttentionWorksHeaderBinding) this).b, z3);
            TextViewBindingAdapter.setText(this.c, nickName);
            TextViewBindingAdapter.setText(this.d, str3);
            CommonBindingAdapter.l0(((WorksItemAttentionWorksHeaderBinding) this).f14449b, z5);
            TextViewBindingAdapter.setText(((WorksItemAttentionWorksHeaderBinding) this).f14449b, str4);
            CommonBindingAdapter.l0(this.e, z);
            TextViewBindingAdapter.setText(this.e, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14451a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14451a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemAttentionWorksHeaderBinding
    public void k(@Nullable WorkDetailBean Vm) {
        ((WorksItemAttentionWorksHeaderBinding) this).f14446a = Vm;
        synchronized (this) {
            this.f14451a |= 1;
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
        k((WorkDetailBean) variable);
        return true;
    }

    public WorksItemAttentionWorksHeaderBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AvatarView) bindings[1], (RelativeLayout) bindings[13], (TagListView) bindings[4], (TextView) bindings[7], (BLTextView) bindings[10], (TextView) bindings[8], (TextView) bindings[2], (TextView) bindings[5], (BLTextView) bindings[11], (TextView) bindings[6], (View) bindings[12]);
        this.f14451a = -1L;
        ((WorksItemAttentionWorksHeaderBinding) this).f14445a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14452a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.f = textView;
        textView.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) bindings[9];
        this.b = constraintLayout2;
        constraintLayout2.setTag(null);
        ((WorksItemAttentionWorksHeaderBinding) this).f14447a.setTag(null);
        ((WorksItemAttentionWorksHeaderBinding) this).f14444a.setTag(null);
        ((WorksItemAttentionWorksHeaderBinding) this).f14448a.setTag(null);
        ((WorksItemAttentionWorksHeaderBinding) this).b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        ((WorksItemAttentionWorksHeaderBinding) this).f14449b.setTag(null);
        this.e.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
