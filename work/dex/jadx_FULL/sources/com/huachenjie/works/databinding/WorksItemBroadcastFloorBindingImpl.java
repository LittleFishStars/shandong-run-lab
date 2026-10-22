package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.noober.background.view.BLLinearLayout;
import com.vanniktech.emoji.EmojiTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemBroadcastFloorBindingImpl extends WorksItemBroadcastFloorBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14483a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14484a;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37007a = sparseIntArray;
        sparseIntArray.put(R.id.ivIcon, 10);
        sparseIntArray.put(R.id.jsonAudio, 11);
        sparseIntArray.put(R.id.llComment, 12);
        sparseIntArray.put(R.id.ivComment, 13);
        sparseIntArray.put(R.id.v_line, 14);
    }

    public WorksItemBroadcastFloorBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 15, f14483a, f37007a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zShowText;
        boolean liked;
        int i;
        int likedCount;
        boolean z;
        boolean z2;
        CharSequence charSequence;
        RequestOptions requestOptions;
        String str;
        String str2;
        String avatarFrameImgUrl;
        String str3;
        String nickName;
        String appUserCode;
        String str4;
        String str5;
        String str6;
        boolean zIsMatched;
        boolean zShowVoice;
        boolean zShowImage;
        CharSequence textContent;
        String quoteNo;
        String commentCount;
        String avatar;
        String voiceDurationStr;
        String publishTime;
        String imageUrl;
        synchronized (this) {
            j = this.f14484a;
            this.f14484a = 0L;
        }
        BroadcastFloorMessageBean broadcastFloorMessageBean = ((WorksItemBroadcastFloorBinding) this).f14477a;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.p;
            if (broadcastFloorMessageBean != null) {
                textContent = broadcastFloorMessageBean.getTextContent();
                quoteNo = broadcastFloorMessageBean.getQuoteNo();
                avatarFrameImgUrl = broadcastFloorMessageBean.getAvatarFrameImgUrl();
                liked = broadcastFloorMessageBean.getLiked();
                commentCount = broadcastFloorMessageBean.formatCommentCount();
                nickName = broadcastFloorMessageBean.getNickName();
                appUserCode = broadcastFloorMessageBean.getAppUserCode();
                avatar = broadcastFloorMessageBean.getAvatar();
                zIsMatched = broadcastFloorMessageBean.isMatched();
                voiceDurationStr = broadcastFloorMessageBean.formatVoiceDurationStr();
                zShowVoice = broadcastFloorMessageBean.showVoice();
                zShowImage = broadcastFloorMessageBean.showImage();
                publishTime = broadcastFloorMessageBean.formatPublishTime();
                imageUrl = broadcastFloorMessageBean.formatImageUrl();
                likedCount = broadcastFloorMessageBean.getLikedCount();
                zShowText = broadcastFloorMessageBean.showText();
            } else {
                zShowText = false;
                liked = false;
                zIsMatched = false;
                zShowVoice = false;
                zShowImage = false;
                likedCount = 0;
                textContent = null;
                quoteNo = null;
                avatarFrameImgUrl = null;
                commentCount = null;
                nickName = null;
                appUserCode = null;
                avatar = null;
                voiceDurationStr = null;
                publishTime = null;
                imageUrl = null;
            }
            if (j2 != 0) {
                j |= zIsMatched ? 8L : 4L;
            }
            str4 = voiceDurationStr;
            z = zShowVoice;
            z2 = zShowImage;
            str5 = publishTime;
            str6 = imageUrl;
            String str7 = avatar;
            i = zIsMatched ? 8 : 7;
            charSequence = textContent;
            str = str7;
            String str8 = commentCount;
            str3 = quoteNo;
            str2 = str8;
        } else {
            zShowText = false;
            liked = false;
            i = 0;
            likedCount = 0;
            z = false;
            z2 = false;
            charSequence = null;
            requestOptions = null;
            str = null;
            str2 = null;
            avatarFrameImgUrl = null;
            str3 = null;
            nickName = null;
            appUserCode = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        if ((j & 3) != 0) {
            aw9.d(((WorksItemBroadcastFloorBinding) this).f14476a, str, false, null);
            aw9.c(((WorksItemBroadcastFloorBinding) this).f14476a, avatarFrameImgUrl, null);
            CommonBindingAdapter.l0(((WorksItemBroadcastFloorBinding) this).c, z2);
            CommonBindingAdapter.b0(((WorksItemBroadcastFloorBinding) this).c, str6, requestOptions, false);
            CommonBindingAdapter.l0(((WorksItemBroadcastFloorBinding) this).f14479a, z);
            zv9.b(((WorksItemBroadcastFloorBinding) this).f14478a, 4, Boolean.valueOf(liked), likedCount, str3, appUserCode, null, null, i);
            TextViewBindingAdapter.setText(this.d, str4);
            TextViewBindingAdapter.setText(((WorksItemBroadcastFloorBinding) this).f14473a, str2);
            CommonBindingAdapter.l0(((WorksItemBroadcastFloorBinding) this).f14480a, zShowText);
            zv9.h(((WorksItemBroadcastFloorBinding) this).f14480a, charSequence, true);
            TextViewBindingAdapter.setText(((WorksItemBroadcastFloorBinding) this).f14481b, nickName);
            TextViewBindingAdapter.setText(((WorksItemBroadcastFloorBinding) this).f14482c, str5);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14484a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14484a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemBroadcastFloorBinding
    public void k(@Nullable BroadcastFloorMessageBean Bean) {
        ((WorksItemBroadcastFloorBinding) this).f14477a = Bean;
        synchronized (this) {
            this.f14484a |= 1;
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
        k((BroadcastFloorMessageBean) variable);
        return true;
    }

    public WorksItemBroadcastFloorBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[0], (AvatarView) bindings[1], (ImageView) bindings[13], (ImageView) bindings[10], (ImageView) bindings[5], (LottieAnimationView) bindings[11], (BLLinearLayout) bindings[6], (LinearLayout) bindings[12], (BLOperateAnimView) bindings[9], (TextView) bindings[8], (EmojiTextView) bindings[4], (TextView) bindings[2], (TextView) bindings[3], (View) bindings[14]);
        this.f14484a = -1L;
        ((WorksItemBroadcastFloorBinding) this).f14474a.setTag(null);
        ((WorksItemBroadcastFloorBinding) this).f14476a.setTag(null);
        ((WorksItemBroadcastFloorBinding) this).c.setTag(null);
        ((WorksItemBroadcastFloorBinding) this).f14479a.setTag(null);
        ((WorksItemBroadcastFloorBinding) this).f14478a.setTag(null);
        TextView textView = (TextView) bindings[7];
        this.d = textView;
        textView.setTag(null);
        ((WorksItemBroadcastFloorBinding) this).f14473a.setTag(null);
        ((WorksItemBroadcastFloorBinding) this).f14480a.setTag(null);
        ((WorksItemBroadcastFloorBinding) this).f14481b.setTag(null);
        ((WorksItemBroadcastFloorBinding) this).f14482c.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
