package com.huachenjie.works.databinding;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.noober.background.view.BLCheckBox;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;
import com.zj.adlib.s72;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemCommentOnMeBindingImpl extends WorksItemCommentOnMeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37022a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14540a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f14543a;

    public WorksItemCommentOnMeBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f14540a, f37022a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String coverImg;
        String str;
        Drawable drawable;
        String string;
        RequestOptions requestOptions;
        boolean z;
        int colorFromResource;
        boolean z2;
        String avatarFrameImgUrl;
        String str2;
        String nickName;
        SpannableString spannableString;
        boolean z3;
        long messageTime;
        boolean commentStatus;
        boolean liked;
        boolean readFlag;
        String avatar;
        SpannableString spannableString2;
        boolean zShowCommentImage;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f14541a;
            this.f14541a = 0L;
        }
        CommentOnMeBean commentOnMeBean = ((WorksItemCommentOnMeBinding) this).f14536a;
        long j4 = j & 3;
        if (j4 != 0) {
            requestOptions = ju3.p;
            if (commentOnMeBean != null) {
                messageTime = commentOnMeBean.getMessageTime();
                commentStatus = commentOnMeBean.getCommentStatus();
                avatarFrameImgUrl = commentOnMeBean.getAvatarFrameImgUrl();
                liked = commentOnMeBean.getLiked();
                readFlag = commentOnMeBean.getReadFlag();
                nickName = commentOnMeBean.getNickName();
                avatar = commentOnMeBean.getAvatar();
                spannableString2 = commentOnMeBean.formatterComment();
                zShowCommentImage = commentOnMeBean.showCommentImage();
                coverImg = commentOnMeBean.getCoverImg();
            } else {
                messageTime = 0;
                coverImg = null;
                commentStatus = false;
                avatarFrameImgUrl = null;
                liked = false;
                readFlag = false;
                nickName = null;
                avatar = null;
                spannableString2 = null;
                zShowCommentImage = false;
            }
            if (j4 != 0) {
                if (liked) {
                    j2 = j | 8 | 32;
                    j3 = 128;
                } else {
                    j2 = j | 4 | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            String strT = s72.t(messageTime);
            z = !commentStatus;
            colorFromResource = ViewDataBinding.getColorFromResource(((WorksItemCommentOnMeBinding) this).f14537a, liked ? R.color.color_FF3D3D : R.color.color_8997A4);
            drawable = liked ? AppCompatResources.getDrawable(((WorksItemCommentOnMeBinding) this).f14537a.getContext(), R.drawable.works_ic_message_comment_like) : AppCompatResources.getDrawable(((WorksItemCommentOnMeBinding) this).f14537a.getContext(), R.drawable.works_ic_message_comment_unlike);
            string = liked ? ((WorksItemCommentOnMeBinding) this).f14537a.getResources().getString(R.string.works_comment_on_me_liked) : ((WorksItemCommentOnMeBinding) this).f14537a.getResources().getString(R.string.works_comment_on_me_like);
            z2 = readFlag;
            spannableString = spannableString2;
            z3 = zShowCommentImage;
            str2 = strT;
            str = avatar;
        } else {
            coverImg = null;
            str = null;
            drawable = null;
            string = null;
            requestOptions = null;
            z = false;
            colorFromResource = 0;
            z2 = false;
            avatarFrameImgUrl = null;
            str2 = null;
            nickName = null;
            spannableString = null;
            z3 = false;
        }
        if ((j & 3) != 0) {
            CommonBindingAdapter.l0(((WorksItemCommentOnMeBinding) this).f14539a, z);
            TextViewBindingAdapter.setDrawableStart(((WorksItemCommentOnMeBinding) this).f14537a, drawable);
            TextViewBindingAdapter.setText(((WorksItemCommentOnMeBinding) this).f14537a, string);
            ((WorksItemCommentOnMeBinding) this).f14537a.setTextColor(colorFromResource);
            CommonBindingAdapter.l0(((WorksItemCommentOnMeBinding) this).f14537a, z);
            aw9.d(((WorksItemCommentOnMeBinding) this).f14535a, str, false, null);
            aw9.c(((WorksItemCommentOnMeBinding) this).f14535a, avatarFrameImgUrl, null);
            CommonBindingAdapter.b0(((WorksItemCommentOnMeBinding) this).f14538a, coverImg, requestOptions, false);
            CommonBindingAdapter.l0(this.f14543a, z2);
            CommonBindingAdapter.l0(((WorksItemCommentOnMeBinding) this).f37021a, z3);
            TextViewBindingAdapter.setText(this.b, spannableString);
            TextViewBindingAdapter.setText(this.c, nickName);
            TextViewBindingAdapter.setText(this.d, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14541a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14541a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemCommentOnMeBinding
    public void k(@Nullable CommentOnMeBean Bean) {
        ((WorksItemCommentOnMeBinding) this).f14536a = Bean;
        synchronized (this) {
            this.f14541a |= 1;
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
        k((CommentOnMeBean) variable);
        return true;
    }

    public WorksItemCommentOnMeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLTextView) bindings[8], (BLCheckBox) bindings[9], (AvatarView) bindings[1], (BLImageView) bindings[7], (TextView) bindings[5], (TextView) bindings[4], (TextView) bindings[3], (TextView) bindings[6]);
        this.f14541a = -1L;
        ((WorksItemCommentOnMeBinding) this).f14539a.setTag(null);
        ((WorksItemCommentOnMeBinding) this).f14537a.setTag(null);
        ((WorksItemCommentOnMeBinding) this).f14535a.setTag(null);
        ((WorksItemCommentOnMeBinding) this).f14538a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14542a = constraintLayout;
        constraintLayout.setTag(null);
        BLView bLView = (BLView) bindings[2];
        this.f14543a = bLView;
        bLView.setTag(null);
        ((WorksItemCommentOnMeBinding) this).f37021a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
