package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodsRecommendData;
import com.huachenjie.works.bean.InteractBean;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.external.widget.UserLaoButton;
import com.huachenjie.works.external.widget.UserReportButton;
import com.huachenjie.works.page.details.picture.PictureWorksDetailFragment;
import com.huachenjie.works.page.details.picture.PictureWorksDetailModel;
import com.huachenjie.works.widget.TagListView;
import com.huachenjie.works.widget.WorksDeleteButton;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentPictureWorksDetailBindingImpl extends WorksFragmentPictureWorksDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14261a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f14267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f14268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f14269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f14270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14272a;

    @NonNull
    public final LinearLayout b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PictureWorksDetailFragment.a f36929a;

        public a a(PictureWorksDetailFragment.a value) {
            this.f36929a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36929a.b(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PictureWorksDetailFragment.a f36930a;

        public b a(PictureWorksDetailFragment.a value) {
            this.f36930a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36930a.f(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PictureWorksDetailFragment.a f36931a;

        public c a(PictureWorksDetailFragment.a value) {
            this.f36931a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36931a.g(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PictureWorksDetailFragment.a f36932a;

        public d a(PictureWorksDetailFragment.a value) {
            this.f36932a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36932a.e(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PictureWorksDetailFragment.a f36933a;

        public e a(PictureWorksDetailFragment.a value) {
            this.f36933a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36933a.c(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36928a = sparseIntArray;
        sparseIntArray.put(R.id.v_head, 17);
        sparseIntArray.put(R.id.fl_container, 18);
        sparseIntArray.put(R.id.card_bottom, 19);
    }

    public WorksFragmentPictureWorksDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 20, f14261a, f36928a));
    }

    /* JADX WARN: Code duplicated, block: B:57:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x0110  */
    /* JADX WARN: Code duplicated, block: B:59:0x0117  */
    /* JADX WARN: Code duplicated, block: B:62:0x011e  */
    /* JADX WARN: Code duplicated, block: B:63:0x013f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zHasLiked;
        String value;
        WorkDetailBean value2;
        String avatar;
        UserInfoBean userInfo;
        boolean zHasCollected;
        int collecteCount;
        boolean zIsMineInfo;
        String str;
        int i;
        String avatarFrameImgUrl;
        String nickName;
        List<String> tagList;
        String worksNo;
        boolean z;
        String shareCount;
        String recommendGoodUrl;
        boolean z2;
        boolean z3;
        a aVarA;
        b bVarA;
        d dVarA;
        c cVarA;
        e eVarA;
        boolean zSafeUnbox;
        long j2;
        String appUserCode;
        int likeCount;
        MutableLiveData<String> mutableLiveDataI;
        InteractBean interactInfo;
        GoodsRecommendData goodsRecommend;
        int recommendGoodNum;
        synchronized (this) {
            j = this.f14262a;
            this.f14262a = 0L;
        }
        PictureWorksDetailModel pictureWorksDetailModel = ((WorksFragmentPictureWorksDetailBinding) this).f14257a;
        PictureWorksDetailFragment.a aVar = ((WorksFragmentPictureWorksDetailBinding) this).f14256a;
        if ((47 & j) != 0) {
            long j3 = j & 43;
            if (j3 != 0) {
                MutableLiveData<WorkDetailBean> mutableLiveDataM = pictureWorksDetailModel != null ? pictureWorksDetailModel.m() : null;
                updateLiveDataRegistration(1, mutableLiveDataM);
                value2 = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
                userInfo = value2 != null ? value2.getUserInfo() : null;
                if ((j & 42) == 0 || userInfo == null) {
                    avatar = null;
                    nickName = null;
                    tagList = null;
                    avatarFrameImgUrl = null;
                    appUserCode = null;
                } else {
                    avatar = userInfo.getAvatar();
                    nickName = userInfo.getNickName();
                    tagList = userInfo.getTagList();
                    avatarFrameImgUrl = userInfo.getAvatarFrameImgUrl();
                    appUserCode = userInfo.getAppUserCode();
                }
                zIsMineInfo = userInfo != null ? userInfo.isMineInfo() : false;
                if (j3 != 0) {
                    j = zIsMineInfo ? j | 128 : j | 64;
                }
                long j4 = j & 42;
                z = j4 != 0 ? !zIsMineInfo : false;
                if (j4 != 0) {
                    if (value2 != null) {
                        zHasLiked = value2.hasLiked();
                        interactInfo = value2.getInteractInfo();
                        zHasCollected = value2.hasCollected();
                        shareCount = value2.formatShareCount();
                        worksNo = value2.getWorksNo();
                        goodsRecommend = value2.getGoodsRecommend();
                        recommendGoodNum = value2.getRecommendGoodNum();
                    } else {
                        zHasLiked = false;
                        interactInfo = null;
                        zHasCollected = false;
                        shareCount = null;
                        worksNo = null;
                        goodsRecommend = null;
                        recommendGoodNum = 0;
                    }
                    if (interactInfo != null) {
                        collecteCount = interactInfo.getCollecteCount();
                        likeCount = interactInfo.getLikeCount();
                    } else {
                        likeCount = 0;
                        collecteCount = 0;
                    }
                    z3 = recommendGoodNum > 0;
                    z2 = recommendGoodNum == 0;
                    if (goodsRecommend != null) {
                        recommendGoodUrl = goodsRecommend.getRecommendGoodUrl();
                        j2 = 44;
                    } else {
                        j2 = 44;
                        recommendGoodUrl = null;
                    }
                } else {
                    zHasLiked = false;
                    j2 = 44;
                }
                if ((j & j2) == 0) {
                    value = null;
                } else {
                    if (pictureWorksDetailModel != null) {
                        mutableLiveDataI = pictureWorksDetailModel.i();
                    } else {
                        mutableLiveDataI = null;
                    }
                    updateLiveDataRegistration(2, mutableLiveDataI);
                    if (mutableLiveDataI != null) {
                        value = mutableLiveDataI.getValue();
                    } else {
                        value = null;
                    }
                }
                str = appUserCode;
                i = likeCount;
            } else {
                zHasLiked = false;
                value2 = null;
                j2 = 44;
                userInfo = null;
                avatar = null;
                nickName = null;
                tagList = null;
                avatarFrameImgUrl = null;
                appUserCode = null;
                zIsMineInfo = false;
                z = false;
            }
            likeCount = 0;
            zHasCollected = false;
            shareCount = null;
            worksNo = null;
            recommendGoodUrl = null;
            z2 = false;
            collecteCount = 0;
            z3 = false;
            if ((j & j2) == 0) {
                value = null;
            } else {
                if (pictureWorksDetailModel != null) {
                    mutableLiveDataI = pictureWorksDetailModel.i();
                } else {
                    mutableLiveDataI = null;
                }
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            str = appUserCode;
            i = likeCount;
        } else {
            zHasLiked = false;
            value = null;
            value2 = null;
            avatar = null;
            userInfo = null;
            zHasCollected = false;
            collecteCount = 0;
            zIsMineInfo = false;
            str = null;
            i = 0;
            avatarFrameImgUrl = null;
            nickName = null;
            tagList = null;
            worksNo = null;
            z = false;
            shareCount = null;
            recommendGoodUrl = null;
            z2 = false;
            z3 = false;
        }
        long j5 = 42 & j;
        RequestOptions requestOptions = j5 != 0 ? ju3.t : null;
        long j6 = j & 48;
        if (j6 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
            dVarA = null;
            cVarA = null;
            eVarA = null;
        } else {
            e eVar = this.f14269a;
            if (eVar == null) {
                eVar = new e();
                this.f14269a = eVar;
            }
            eVarA = eVar.a(aVar);
            a aVar2 = this.f14265a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14265a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f14266a;
            if (bVar == null) {
                bVar = new b();
                this.f14266a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f14267a;
            if (cVar == null) {
                cVar = new c();
                this.f14267a = cVar;
            }
            cVarA = cVar.a(aVar);
            d dVar = this.f14268a;
            if (dVar == null) {
                dVar = new d();
                this.f14268a = dVar;
            }
            dVarA = dVar.a(aVar);
        }
        if ((j & 128) != 0) {
            MutableLiveData<Boolean> mutableLiveDataK = pictureWorksDetailModel != null ? pictureWorksDetailModel.k() : null;
            updateLiveDataRegistration(0, mutableLiveDataK);
            zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataK != null ? mutableLiveDataK.getValue() : null);
        } else {
            zSafeUnbox = false;
        }
        long j7 = j & 43;
        if (j7 == 0 || !zIsMineInfo) {
            zSafeUnbox = false;
        }
        if (j5 != 0) {
            boolean z4 = z;
            CommonBindingAdapter.l0(((WorksFragmentPictureWorksDetailBinding) this).f14254a, z4);
            zv9.a(((WorksFragmentPictureWorksDetailBinding) this).f14254a, userInfo, 1, 1);
            aw9.d(((WorksFragmentPictureWorksDetailBinding) this).f14252a, avatar, false, null);
            aw9.c(((WorksFragmentPictureWorksDetailBinding) this).f14252a, avatarFrameImgUrl, null);
            zv9.g(((WorksFragmentPictureWorksDetailBinding) this).f14259a, value2);
            CommonBindingAdapter.l0(((WorksFragmentPictureWorksDetailBinding) this).f14255a, z4);
            String str2 = worksNo;
            zv9.e(((WorksFragmentPictureWorksDetailBinding) this).f14255a, str2, 1, 2);
            CommonBindingAdapter.b0(this.f14270a, recommendGoodUrl, requestOptions, false);
            CommonBindingAdapter.l0(this.f14272a, z2);
            CommonBindingAdapter.l0(this.f14271a, z3);
            ((WorksFragmentPictureWorksDetailBinding) this).f14258a.setTagList(tagList);
            TextViewBindingAdapter.setText(((WorksFragmentPictureWorksDetailBinding) this).b, nickName);
            TextViewBindingAdapter.setText(this.c, shareCount);
            String str3 = str;
            zv9.b(((WorksFragmentPictureWorksDetailBinding) this).f14253a, 1, Boolean.valueOf(zHasCollected), collecteCount, str2, str3, null, null, 1);
            zv9.b(((WorksFragmentPictureWorksDetailBinding) this).f14260b, 2, Boolean.valueOf(zHasLiked), i, str2, str3, null, null, 1);
        }
        if (j6 != 0) {
            CommonBindingAdapter.q(((WorksFragmentPictureWorksDetailBinding) this).f14252a, bVarA, null);
            CommonBindingAdapter.q(((WorksFragmentPictureWorksDetailBinding) this).f14249a, aVarA, null);
            CommonBindingAdapter.q(this.f14263a, cVarA, null);
            CommonBindingAdapter.q(this.b, dVarA, null);
            CommonBindingAdapter.q(this.f14272a, dVarA, null);
            CommonBindingAdapter.q(this.f14271a, eVarA, null);
        }
        if (j7 != 0) {
            CommonBindingAdapter.l0(((WorksFragmentPictureWorksDetailBinding) this).f14259a, zSafeUnbox);
        }
        if ((j & 44) != 0) {
            TextViewBindingAdapter.setText(((WorksFragmentPictureWorksDetailBinding) this).f14250a, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14262a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14262a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentPictureWorksDetailBinding
    public void l(@Nullable PictureWorksDetailFragment.a Click) {
        ((WorksFragmentPictureWorksDetailBinding) this).f14256a = Click;
        synchronized (this) {
            this.f14262a |= 16;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentPictureWorksDetailBinding
    public void m(@Nullable PictureWorksDetailModel Vm) {
        ((WorksFragmentPictureWorksDetailBinding) this).f14257a = Vm;
        synchronized (this) {
            this.f14262a |= 8;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> VmCommentNum, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14262a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> VmFromMine, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14262a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<WorkDetailBean> VmWorksDetailBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14262a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((PictureWorksDetailModel) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((PictureWorksDetailFragment.a) variable);
        }
        return true;
    }

    public WorksFragmentPictureWorksDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (UserLaoButton) bindings[5], (CardView) bindings[19], (FrameLayout) bindings[18], (AvatarView) bindings[2], (ImageView) bindings[1], (WorksDeleteButton) bindings[7], (UserReportButton) bindings[6], (TagListView) bindings[4], (TextView) bindings[14], (TextView) bindings[3], (TextView) bindings[12], (BLOperateAnimView) bindings[15], (View) bindings[17], (BLOperateAnimView) bindings[16]);
        this.f14262a = -1L;
        ((WorksFragmentPictureWorksDetailBinding) this).f14254a.setTag(null);
        ((WorksFragmentPictureWorksDetailBinding) this).f14252a.setTag(null);
        ((WorksFragmentPictureWorksDetailBinding) this).f14249a.setTag(null);
        ((WorksFragmentPictureWorksDetailBinding) this).f14259a.setTag(null);
        ((WorksFragmentPictureWorksDetailBinding) this).f14255a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14264a = constraintLayout;
        constraintLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) bindings[10];
        this.f14270a = bLImageView;
        bLImageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[11];
        this.f14263a = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[13];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[8];
        this.f14272a = bLTextView;
        bLTextView.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[9];
        this.f14271a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ((WorksFragmentPictureWorksDetailBinding) this).f14258a.setTag(null);
        ((WorksFragmentPictureWorksDetailBinding) this).f14250a.setTag(null);
        ((WorksFragmentPictureWorksDetailBinding) this).b.setTag(null);
        this.c.setTag(null);
        ((WorksFragmentPictureWorksDetailBinding) this).f14253a.setTag(null);
        ((WorksFragmentPictureWorksDetailBinding) this).f14260b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
