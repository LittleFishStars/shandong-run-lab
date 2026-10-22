package com.huachenjie.works.databinding;

import android.text.TextUtils;
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
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodsRecommendData;
import com.huachenjie.works.bean.InteractBean;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.external.widget.UserLaoButton;
import com.huachenjie.works.external.widget.UserReportButton;
import com.huachenjie.works.widget.TagListView;
import com.huachenjie.works.widget.WorksDeleteButton;
import com.huachenjie.works.widget.WorksDetailGoodsView;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorkDetailListBindingImpl extends WorksItemWorkDetailListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14713a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WorksDetailGoodsView f14715a;

    @NonNull
    public final ConstraintLayout b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37076a = sparseIntArray;
        sparseIntArray.put(R.id.vBottomContainer, 18);
        sparseIntArray.put(R.id.v_lao, 19);
        sparseIntArray.put(R.id.ll_left_container, 20);
        sparseIntArray.put(R.id.tvLike, 21);
        sparseIntArray.put(R.id.ivShare, 22);
        sparseIntArray.put(R.id.ivComment, 23);
    }

    public WorksItemWorkDetailListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 24, f14713a, f37076a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        UserInfoBean userInfoBean;
        boolean zHasLiked;
        boolean zHasCollected;
        int i;
        String str;
        CharSequence closeContent;
        boolean textExpand;
        int likeCount;
        String appUserCode;
        boolean zIsMineInfo;
        int collecteCount;
        String str2;
        String str3;
        boolean z4;
        String str4;
        String str5;
        boolean z5;
        GoodsRecommendData goodsRecommendData;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z6;
        List<String> list;
        boolean z7;
        CharSequence charSequence;
        boolean zShowChannelName;
        String location;
        String commentCount;
        int recommendGoodNum;
        String channelName;
        String shareCount;
        int statusBarHeight;
        UserInfoBean userInfo;
        String worksNo;
        boolean zShowCategoryTag;
        GoodsRecommendData goodsRecommend;
        String avatarUrl;
        String categoryTag;
        String avatarFrameUrl;
        String nickName;
        InteractBean interactInfo;
        List<String> tagList;
        synchronized (this) {
            j = this.f14714a;
            this.f14714a = 0L;
        }
        WorkDetailBean workDetailBean = ((WorksItemWorkDetailListBinding) this).f14701a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (workDetailBean != null) {
                zHasLiked = workDetailBean.hasLiked();
                zHasCollected = workDetailBean.hasCollected();
                zShowChannelName = workDetailBean.showChannelName();
                location = workDetailBean.getLocation();
                commentCount = workDetailBean.formatCommentCount();
                recommendGoodNum = workDetailBean.getRecommendGoodNum();
                closeContent = workDetailBean.getCloseContent();
                channelName = workDetailBean.formatChannelName();
                shareCount = workDetailBean.formatShareCount();
                statusBarHeight = workDetailBean.getStatusBarHeight();
                userInfo = workDetailBean.getUserInfo();
                worksNo = workDetailBean.getWorksNo();
                zShowCategoryTag = workDetailBean.showCategoryTag();
                goodsRecommend = workDetailBean.getGoodsRecommend();
                avatarUrl = workDetailBean.formatAvatarUrl();
                categoryTag = workDetailBean.getCategoryTag();
                avatarFrameUrl = workDetailBean.formatAvatarFrameUrl();
                nickName = workDetailBean.formatNickName();
                textExpand = workDetailBean.getTextExpand();
                interactInfo = workDetailBean.getInteractInfo();
            } else {
                zHasLiked = false;
                zHasCollected = false;
                zShowChannelName = false;
                location = null;
                commentCount = null;
                recommendGoodNum = 0;
                closeContent = null;
                channelName = null;
                shareCount = null;
                statusBarHeight = 0;
                userInfo = null;
                worksNo = null;
                zShowCategoryTag = false;
                goodsRecommend = null;
                avatarUrl = null;
                categoryTag = null;
                avatarFrameUrl = null;
                nickName = null;
                textExpand = false;
                interactInfo = null;
            }
            if (j2 != 0) {
                j |= zShowChannelName ? 32L : 16L;
            }
            if ((j & 3) != 0) {
                j = textExpand ? j | 8 : j | 4;
            }
            boolean zIsEmpty = TextUtils.isEmpty(location);
            boolean z8 = recommendGoodNum > 0;
            boolean zIsEmpty2 = TextUtils.isEmpty(closeContent);
            int i2 = statusBarHeight + 4;
            if (userInfo != null) {
                tagList = userInfo.getTagList();
                appUserCode = userInfo.getAppUserCode();
                zIsMineInfo = userInfo.isMineInfo();
            } else {
                tagList = null;
                appUserCode = null;
                zIsMineInfo = false;
            }
            if ((j & 3) != 0) {
                j = zIsMineInfo ? j | 128 : j | 64;
            }
            if (interactInfo != null) {
                collecteCount = interactInfo.getCollecteCount();
                likeCount = interactInfo.getLikeCount();
            } else {
                likeCount = 0;
                collecteCount = 0;
            }
            z = !zIsEmpty;
            z3 = zShowChannelName;
            str2 = location;
            str3 = commentCount;
            z4 = z8;
            str4 = channelName;
            str5 = shareCount;
            i = i2;
            userInfoBean = userInfo;
            str = worksNo;
            z5 = zShowCategoryTag;
            goodsRecommendData = goodsRecommend;
            str6 = avatarUrl;
            str7 = categoryTag;
            str8 = avatarFrameUrl;
            str9 = nickName;
            z6 = !zIsEmpty2;
            list = tagList;
            z2 = !zIsMineInfo;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            userInfoBean = null;
            zHasLiked = false;
            zHasCollected = false;
            i = 0;
            str = null;
            closeContent = null;
            textExpand = false;
            likeCount = 0;
            appUserCode = null;
            zIsMineInfo = false;
            collecteCount = 0;
            str2 = null;
            str3 = null;
            z4 = false;
            str4 = null;
            str5 = null;
            z5 = false;
            goodsRecommendData = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            z6 = false;
            list = null;
        }
        boolean fromMine = ((128 & j) == 0 || workDetailBean == null) ? false : workDetailBean.getFromMine();
        long j3 = 3 & j;
        if (j3 != 0) {
            z7 = z3 ? true : z5;
        } else {
            z7 = false;
        }
        CharSequence expandContent = ((8 & j) == 0 || workDetailBean == null) ? null : workDetailBean.getExpandContent();
        if (j3 != 0) {
            if (textExpand) {
                closeContent = expandContent;
            }
            if (!zIsMineInfo) {
                fromMine = false;
            }
            charSequence = closeContent;
        } else {
            charSequence = null;
            fromMine = false;
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(((WorksItemWorkDetailListBinding) this).f14703a, z2);
            zv9.a(((WorksItemWorkDetailListBinding) this).f14703a, userInfoBean, 2, 1);
            CommonBindingAdapter.l0(((WorksItemWorkDetailListBinding) this).f14698a, z7);
            aw9.d(((WorksItemWorkDetailListBinding) this).f14700a, str6, false, null);
            aw9.c(((WorksItemWorkDetailListBinding) this).f14700a, str8, null);
            int i3 = i;
            CommonBindingAdapter.I(((WorksItemWorkDetailListBinding) this).f14707a, 0, i3, 0, 0, null);
            CommonBindingAdapter.l0(((WorksItemWorkDetailListBinding) this).f14706a, fromMine);
            zv9.g(((WorksItemWorkDetailListBinding) this).f14706a, workDetailBean);
            CommonBindingAdapter.I(((WorksItemWorkDetailListBinding) this).f14706a, 0, i3, 0, 0, null);
            String str10 = str;
            String str11 = appUserCode;
            zv9.b(((WorksItemWorkDetailListBinding) this).f14702a, 1, Boolean.valueOf(zHasCollected), collecteCount, str10, str11, null, null, 1);
            zv9.b(((WorksItemWorkDetailListBinding) this).f14711b, 2, Boolean.valueOf(zHasLiked), likeCount, str10, str11, null, null, 1);
            CommonBindingAdapter.l0(this.f14715a, z4);
            String str12 = str;
            WorksDetailGoodsView.setWorksGoods(this.f14715a, str12, goodsRecommendData);
            TextViewBindingAdapter.setText(((WorksItemWorkDetailListBinding) this).f14697a, str9);
            CommonBindingAdapter.l0(((WorksItemWorkDetailListBinding) this).f14704a, z2);
            zv9.e(((WorksItemWorkDetailListBinding) this).f14704a, str12, 1, 2);
            CommonBindingAdapter.I(((WorksItemWorkDetailListBinding) this).f14704a, 0, i, 0, 0, null);
            ((WorksItemWorkDetailListBinding) this).f14705a.setTagList(list);
            TextViewBindingAdapter.setText(((WorksItemWorkDetailListBinding) this).f14710b, str3);
            CommonBindingAdapter.l0(((WorksItemWorkDetailListBinding) this).f14699a, z6);
            TextViewBindingAdapter.setText(((WorksItemWorkDetailListBinding) this).f14699a, charSequence);
            CommonBindingAdapter.l0(((WorksItemWorkDetailListBinding) this).f14709a, z3);
            TextViewBindingAdapter.setText(((WorksItemWorkDetailListBinding) this).f14709a, str4);
            CommonBindingAdapter.l0(this.d, z);
            TextViewBindingAdapter.setText(this.d, str2);
            TextViewBindingAdapter.setText(this.e, str5);
            CommonBindingAdapter.l0(((WorksItemWorkDetailListBinding) this).f14712b, z5);
            TextViewBindingAdapter.setText(((WorksItemWorkDetailListBinding) this).f14712b, str7);
        }
        if ((j & 2) != 0) {
            WorksDetailGoodsView.setWorksDetailGoodsInfo(this.f14715a, true);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14714a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14714a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorkDetailListBinding
    public void k(@Nullable WorkDetailBean Vm) {
        ((WorksItemWorkDetailListBinding) this).f14701a = Vm;
        synchronized (this) {
            this.f14714a |= 1;
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

    public WorksItemWorkDetailListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (UserLaoButton) bindings[3], (ConstraintLayout) bindings[6], (AvatarView) bindings[1], (BLImageView) bindings[15], (ImageView) bindings[23], (WorksDeleteButton) bindings[17], (ImageView) bindings[22], (BLOperateAnimView) bindings[12], (LinearLayout) bindings[20], (BLOperateAnimView) bindings[11], (TextView) bindings[2], (UserReportButton) bindings[16], (TagListView) bindings[4], (TextView) bindings[14], (ExpandableTextView) bindings[5], (BLTextView) bindings[7], (TextView) bindings[21], (TextView) bindings[9], (TextView) bindings[13], (BLTextView) bindings[8], (BLLinearLayout) bindings[18], (View) bindings[19]);
        this.f14714a = -1L;
        ((WorksItemWorkDetailListBinding) this).f14703a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14698a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14700a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14707a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14706a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14702a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14711b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        WorksDetailGoodsView worksDetailGoodsView = (WorksDetailGoodsView) bindings[10];
        this.f14715a = worksDetailGoodsView;
        worksDetailGoodsView.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14697a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14704a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14705a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14710b.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14699a.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14709a.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        ((WorksItemWorkDetailListBinding) this).f14712b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
