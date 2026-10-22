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
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostDetailBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.external.widget.UserReportButton;
import com.huachenjie.works.page.campus_wall.detail.PostDetailActivity;
import com.huachenjie.works.page.campus_wall.detail.PostDetailViewModel;
import com.huachenjie.works.widget.PostDeleteButton;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivityPostDetailBindingImpl extends WorksActivityPostDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13893a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13896a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f13900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13901a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PostDetailActivity.a f36788a;

        public a a(PostDetailActivity.a value) {
            this.f36788a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36788a.c(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PostDetailActivity.a f36789a;

        public b a(PostDetailActivity.a value) {
            this.f36789a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36789a.d(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PostDetailActivity.a f36790a;

        public c a(PostDetailActivity.a value) {
            this.f36790a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36790a.b(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PostDetailActivity.a f36791a;

        public d a(PostDetailActivity.a value) {
            this.f36791a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36791a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36787a = sparseIntArray;
        sparseIntArray.put(R.id.v_head, 10);
        sparseIntArray.put(R.id.fl_container, 11);
        sparseIntArray.put(R.id.card_bottom, 12);
    }

    public WorksActivityPostDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 13, f13893a, f36787a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zIsMineInfo;
        String nickName;
        boolean z;
        boolean liked;
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        c cVarA;
        d dVarA;
        a aVarA;
        b bVarA;
        boolean zSafeUnbox;
        int likeCount;
        String postNo;
        String shareCount;
        String appUserCode;
        String avatarFrameImgUrl;
        String avatar;
        synchronized (this) {
            j = this.f13894a;
            this.f13894a = 0L;
        }
        PostDetailViewModel postDetailViewModel = ((WorksActivityPostDetailBinding) this).f13891a;
        PostDetailActivity.a aVar = ((WorksActivityPostDetailBinding) this).f13890a;
        long j2 = j & 23;
        if (j2 != 0) {
            MutableLiveData<PostDetailBean> mutableLiveDataN = postDetailViewModel != null ? postDetailViewModel.n() : null;
            updateLiveDataRegistration(1, mutableLiveDataN);
            PostDetailBean value = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
            long j3 = j & 22;
            if (j3 == 0 || value == null) {
                liked = false;
                likeCount = 0;
                postNo = null;
                shareCount = null;
            } else {
                liked = value.getLiked();
                likeCount = value.getLikeCount();
                postNo = value.getPostNo();
                shareCount = value.formatShareCount();
            }
            UserInfoBean userInfo = value != null ? value.getUserInfo() : null;
            if (j3 == 0 || userInfo == null) {
                nickName = null;
                appUserCode = null;
                avatarFrameImgUrl = null;
                avatar = null;
            } else {
                nickName = userInfo.getNickName();
                appUserCode = userInfo.getAppUserCode();
                avatarFrameImgUrl = userInfo.getAvatarFrameImgUrl();
                avatar = userInfo.getAvatar();
            }
            zIsMineInfo = userInfo != null ? userInfo.isMineInfo() : false;
            if (j2 != 0) {
                j = zIsMineInfo ? j | 64 : j | 32;
            }
            if ((j & 22) != 0) {
                z = !zIsMineInfo;
                i = likeCount;
                str5 = postNo;
                str4 = shareCount;
                str3 = appUserCode;
                str = avatarFrameImgUrl;
                str2 = avatar;
            } else {
                i = likeCount;
                str5 = postNo;
                str4 = shareCount;
                str3 = appUserCode;
                str = avatarFrameImgUrl;
                str2 = avatar;
                z = false;
            }
        } else {
            zIsMineInfo = false;
            nickName = null;
            z = false;
            liked = false;
            str = null;
            str2 = null;
            i = 0;
            str3 = null;
            str4 = null;
            str5 = null;
        }
        long j4 = j & 24;
        if (j4 == 0 || aVar == null) {
            cVarA = null;
            dVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            d dVar = this.f13900a;
            if (dVar == null) {
                dVar = new d();
                this.f13900a = dVar;
            }
            dVarA = dVar.a(aVar);
            a aVar2 = this.f13897a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13897a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f13898a;
            if (bVar == null) {
                bVar = new b();
                this.f13898a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f13899a;
            if (cVar == null) {
                cVar = new c();
                this.f13899a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if ((j & 64) != 0) {
            MutableLiveData<Boolean> mutableLiveDataL = postDetailViewModel != null ? postDetailViewModel.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
        } else {
            zSafeUnbox = false;
        }
        long j5 = 23 & j;
        if (j5 == 0 || !zIsMineInfo) {
            zSafeUnbox = false;
        }
        if ((j & 22) != 0) {
            aw9.d(((WorksActivityPostDetailBinding) this).f13887a, str2, false, null);
            aw9.c(((WorksActivityPostDetailBinding) this).f13887a, str, null);
            String str6 = str5;
            zv9.d(((WorksActivityPostDetailBinding) this).f13892a, str6);
            CommonBindingAdapter.l0(((WorksActivityPostDetailBinding) this).f13889a, z);
            zv9.e(((WorksActivityPostDetailBinding) this).f13889a, str6, 5, 4);
            TextViewBindingAdapter.setText(((WorksActivityPostDetailBinding) this).f13885a, nickName);
            TextViewBindingAdapter.setText(this.b, str4);
            zv9.b(((WorksActivityPostDetailBinding) this).f13888a, 6, Boolean.valueOf(liked), i, str6, str3, null, null, 10);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(((WorksActivityPostDetailBinding) this).f13887a, aVarA, null);
            CommonBindingAdapter.q(((WorksActivityPostDetailBinding) this).f13884a, dVarA, null);
            CommonBindingAdapter.q(this.f13901a, cVarA, null);
            CommonBindingAdapter.q(this.f13895a, bVarA, null);
        }
        if (j5 != 0) {
            CommonBindingAdapter.l0(((WorksActivityPostDetailBinding) this).f13892a, zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13894a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13894a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityPostDetailBinding
    public void l(@Nullable PostDetailActivity.a Click) {
        ((WorksActivityPostDetailBinding) this).f13890a = Click;
        synchronized (this) {
            this.f13894a |= 8;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityPostDetailBinding
    public void m(@Nullable PostDetailViewModel Vm) {
        ((WorksActivityPostDetailBinding) this).f13891a = Vm;
        synchronized (this) {
            this.f13894a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> VmFromMine, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13894a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<PostDetailBean> VmPostDetailBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13894a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((PostDetailViewModel) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((PostDetailActivity.a) variable);
        }
        return true;
    }

    public WorksActivityPostDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (CardView) bindings[12], (FrameLayout) bindings[11], (AvatarView) bindings[2], (ImageView) bindings[1], (PostDeleteButton) bindings[5], (UserReportButton) bindings[4], (TextView) bindings[3], (TextView) bindings[8], (View) bindings[10], (BLOperateAnimView) bindings[9]);
        this.f13894a = -1L;
        ((WorksActivityPostDetailBinding) this).f13887a.setTag(null);
        ((WorksActivityPostDetailBinding) this).f13884a.setTag(null);
        ((WorksActivityPostDetailBinding) this).f13892a.setTag(null);
        ((WorksActivityPostDetailBinding) this).f13889a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f13896a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[6];
        this.f13901a = bLTextView;
        bLTextView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[7];
        this.f13895a = linearLayout;
        linearLayout.setTag(null);
        ((WorksActivityPostDetailBinding) this).f13885a.setTag(null);
        this.b.setTag(null);
        ((WorksActivityPostDetailBinding) this).f13888a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
