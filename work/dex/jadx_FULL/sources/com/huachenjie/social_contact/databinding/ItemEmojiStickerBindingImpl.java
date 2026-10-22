package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemEmojiStickerBindingImpl extends ItemEmojiStickerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12953a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12957a;

    @NonNull
    public final BLTextView b;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36176a = sparseIntArray;
        sparseIntArray.put(R.id.v_bottom_first, 20);
        sparseIntArray.put(R.id.v_bottom_second, 21);
    }

    public ItemEmojiStickerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 22, f12953a, f36176a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        int bottomIconSub;
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String emojiUrl;
        String str;
        String str2;
        String emojiUrl2;
        RequestOptions requestOptions;
        String emojiUrl3;
        String emojiUrl4;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean zShowSuccess;
        int level;
        boolean zObtain;
        boolean zShowFail;
        boolean zShowReview;
        int bottomIcon;
        boolean zShowBottomOperateSub;
        String emojiUrl5;
        String emojiUrl6;
        String bottomTextSub;
        String emojiBagName;
        String authName;
        String downloadTotal;
        String bottomText;
        String authHeadImg;
        String level2;
        synchronized (this) {
            j = this.f12954a;
            this.f12954a = 0L;
        }
        EmojiStickerBean emojiStickerBean = ((ItemEmojiStickerBinding) this).f12948a;
        long j2 = j & 3;
        int i2 = 0;
        if (j2 != 0) {
            requestOptions = ju3.l;
            if (emojiStickerBean != null) {
                bottomIconSub = emojiStickerBean.formatBottomIconSub();
                emojiUrl3 = emojiStickerBean.formatEmojiUrl(3);
                emojiUrl4 = emojiStickerBean.formatEmojiUrl(2);
                zShowSuccess = emojiStickerBean.showSuccess();
                level = emojiStickerBean.getLevel();
                emojiUrl5 = emojiStickerBean.formatEmojiUrl(1);
                zObtain = emojiStickerBean.obtain();
                emojiUrl6 = emojiStickerBean.formatEmojiUrl(0);
                bottomTextSub = emojiStickerBean.formatBottomTextSub();
                emojiBagName = emojiStickerBean.getEmojiBagName();
                zShowFail = emojiStickerBean.showFail();
                authName = emojiStickerBean.getAuthName();
                zShowReview = emojiStickerBean.showReview();
                bottomIcon = emojiStickerBean.formatBottomIcon();
                downloadTotal = emojiStickerBean.formatDownloadTotal();
                bottomText = emojiStickerBean.formatBottomText();
                emojiUrl2 = emojiStickerBean.formatEmojiUrl(5);
                zShowBottomOperateSub = emojiStickerBean.showBottomOperateSub();
                authHeadImg = emojiStickerBean.getAuthHeadImg();
                level2 = emojiStickerBean.formatLevel();
                emojiUrl = emojiStickerBean.formatEmojiUrl(4);
            } else {
                bottomIconSub = 0;
                zShowSuccess = false;
                level = 0;
                zObtain = false;
                zShowFail = false;
                zShowReview = false;
                bottomIcon = 0;
                zShowBottomOperateSub = false;
                emojiUrl = null;
                emojiUrl2 = null;
                emojiUrl3 = null;
                emojiUrl4 = null;
                emojiUrl5 = null;
                emojiUrl6 = null;
                bottomTextSub = null;
                emojiBagName = null;
                authName = null;
                downloadTotal = null;
                bottomText = null;
                authHeadImg = null;
                level2 = null;
            }
            if (j2 != 0) {
                j |= zObtain ? 8L : 4L;
            }
            boolean z7 = level > 0;
            int i3 = zObtain ? -10155284 : -7759964;
            z2 = !zShowReview;
            str3 = String.format("作者：%s", authName);
            z4 = zShowSuccess;
            str4 = emojiUrl5;
            str5 = bottomTextSub;
            str6 = emojiBagName;
            z5 = zShowFail;
            z6 = zShowReview;
            i2 = bottomIcon;
            str7 = downloadTotal;
            str8 = bottomText;
            str2 = authHeadImg;
            str9 = level2;
            z3 = z7;
            i = i3;
            str = emojiUrl6;
            z = zShowBottomOperateSub;
        } else {
            z = false;
            z2 = false;
            bottomIconSub = 0;
            i = 0;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            emojiUrl = null;
            str = null;
            str2 = null;
            emojiUrl2 = null;
            requestOptions = null;
            emojiUrl3 = null;
            emojiUrl4 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
        }
        if ((j & 3) != 0) {
            DrawablesBindingAdapter.e(((ItemEmojiStickerBinding) this).f12945a, i2);
            CommonBindingAdapter.l0(((ItemEmojiStickerBinding) this).f12945a, z2);
            DrawablesBindingAdapter.e(((ItemEmojiStickerBinding) this).f12949b, bottomIconSub);
            CommonBindingAdapter.l0(((ItemEmojiStickerBinding) this).f12949b, z);
            aw9.h(((ItemEmojiStickerBinding) this).f12951c, str, requestOptions, 0);
            aw9.h(super.d, str4, requestOptions, 0);
            aw9.h(super.e, emojiUrl4, requestOptions, 0);
            aw9.h(super.f, emojiUrl3, requestOptions, 0);
            aw9.h(this.g, emojiUrl, requestOptions, 0);
            aw9.h(this.h, emojiUrl2, requestOptions, 0);
            aw9.d(((ItemEmojiStickerBinding) this).f12947a, str2, false, null);
            TextViewBindingAdapter.setText(this.d, str3);
            CommonBindingAdapter.l0(this.e, z3);
            TextViewBindingAdapter.setText(this.e, str9);
            CommonBindingAdapter.l0(this.f12956a, z4);
            TextViewBindingAdapter.setText(this.f, str7);
            CommonBindingAdapter.l0(this.f12957a, z6);
            CommonBindingAdapter.l0(this.b, z5);
            CommonBindingAdapter.l0(((ItemEmojiStickerBinding) this).f12946a, z2);
            TextViewBindingAdapter.setText(((ItemEmojiStickerBinding) this).f12946a, str8);
            ((ItemEmojiStickerBinding) this).f12946a.setTextColor(i);
            CommonBindingAdapter.l0(((ItemEmojiStickerBinding) this).f12950b, z);
            TextViewBindingAdapter.setText(((ItemEmojiStickerBinding) this).f12950b, str5);
            TextViewBindingAdapter.setText(((ItemEmojiStickerBinding) this).f12952c, str6);
            CommonBindingAdapter.l0(((ItemEmojiStickerBinding) this).c, z);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12954a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12954a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemEmojiStickerBinding
    public void k(@Nullable EmojiStickerBean emojiStickerBean) {
        ((ItemEmojiStickerBinding) this).f12948a = emojiStickerBean;
        synchronized (this) {
            this.f12954a |= 1;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 != i) {
            return false;
        }
        k((EmojiStickerBean) obj);
        return true;
    }

    public ItemEmojiStickerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[16], (ImageView) objArr[19], (ImageView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[10], (ImageView) objArr[11], (ImageView) objArr[12], (AvatarView) objArr[13], (TextView) objArr[15], (TextView) objArr[18], (TextView) objArr[1], (View) objArr[20], (View) objArr[21], (View) objArr[17]);
        this.f12954a = -1L;
        ((ItemEmojiStickerBinding) this).f12945a.setTag(null);
        ((ItemEmojiStickerBinding) this).f12949b.setTag(null);
        ((ItemEmojiStickerBinding) this).f12951c.setTag(null);
        super.d.setTag(null);
        super.e.setTag(null);
        super.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        ((ItemEmojiStickerBinding) this).f12947a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f12955a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[14];
        this.d = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.e = textView2;
        textView2.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[3];
        this.f12956a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.f = textView3;
        textView3.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[5];
        this.f12957a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[6];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        ((ItemEmojiStickerBinding) this).f12946a.setTag(null);
        ((ItemEmojiStickerBinding) this).f12950b.setTag(null);
        ((ItemEmojiStickerBinding) this).f12952c.setTag(null);
        ((ItemEmojiStickerBinding) this).c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
