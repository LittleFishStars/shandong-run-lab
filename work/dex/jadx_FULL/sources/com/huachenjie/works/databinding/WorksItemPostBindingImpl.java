package com.huachenjie.works.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.CommentListBean;
import com.huachenjie.works.bean.PostImageBean;
import com.huachenjie.works.bean.PostInfoBean;
import com.huachenjie.works.bean.PostItemBean;
import com.huachenjie.works.bean.PostUserBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.widget.PostNineGridView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemPostBindingImpl extends WorksItemPostBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14628a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f14629b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14630b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView g;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(27);
        f14625a = includedLayouts;
        int i = R.layout.works_layout_post_comment;
        includedLayouts.setIncludes(16, new String[]{"works_layout_post_comment", "works_layout_post_comment", "works_layout_post_comment", "works_layout_post_comment", "works_layout_post_comment"}, new int[]{18, 19, 20, 21, 22}, new int[]{i, i, i, i, i});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37044a = sparseIntArray;
        sparseIntArray.put(R.id.tv_content, 23);
        sparseIntArray.put(R.id.llShare, 24);
        sparseIntArray.put(R.id.ivShare, 25);
        sparseIntArray.put(R.id.tvShare, 26);
    }

    public WorksItemPostBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 27, f14625a, f37044a));
    }

    /* JADX WARN: Code duplicated, block: B:116:0x026c A[PHI: r2 r53
      0x026c: PHI (r2v4 long) = (r2v3 long), (r2v55 long) binds: [B:74:0x01d0, B:87:0x01f9] A[DONT_GENERATE, DONT_INLINE]
      0x026c: PHI (r53v2 boolean) = (r53v1 boolean), (r53v5 boolean) binds: [B:74:0x01d0, B:87:0x01f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:163:0x0310 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:164:0x0312  */
    /* JADX WARN: Code duplicated, block: B:165:0x0315  */
    /* JADX WARN: Code duplicated, block: B:167:0x031e  */
    /* JADX WARN: Code duplicated, block: B:169:0x0323 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:171:0x0326  */
    /* JADX WARN: Code duplicated, block: B:173:0x032f  */
    /* JADX WARN: Code duplicated, block: B:176:0x033a  */
    /* JADX WARN: Code duplicated, block: B:177:0x035b  */
    /* JADX WARN: Code duplicated, block: B:180:0x0365  */
    /* JADX WARN: Code duplicated, block: B:181:0x0402  */
    /* JADX WARN: Code duplicated, block: B:183:0x0406  */
    /* JADX WARN: Code duplicated, block: B:185:0x0421  */
    /* JADX WARN: Code duplicated, block: B:188:0x0432  */
    /* JADX WARN: Code duplicated, block: B:191:0x046e  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean zOnTop;
        int i;
        boolean liked;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        List<PostImageBean> list;
        String str9;
        boolean z8;
        boolean z9;
        boolean z10;
        Drawable drawable;
        Drawable drawable2;
        boolean z11;
        long j2;
        int i2;
        boolean z12;
        Drawable drawable3;
        Drawable drawable4;
        boolean z13;
        boolean z14;
        long j3;
        boolean z15;
        boolean z16;
        boolean z17;
        Context context;
        int i3;
        int i4;
        boolean zShowCommentUser;
        boolean zShowCommentUser2;
        boolean zShowCommentUser3;
        boolean zShowCommentUser4;
        int likeCount;
        boolean zShowCommentUser5;
        String avatar;
        String publishTime;
        String avatarFrameImgUrl;
        String appUserCode;
        String nickName;
        List<PostImageBean> imageList;
        String postNo;
        PostUserBean userInfo;
        PostInfoBean postInfo;
        CommentListBean comment;
        String redPacket;
        synchronized (this) {
            j = this.f14626a;
            this.f14626a = 0L;
        }
        Integer num = ((WorksItemPostBinding) this).f14619a;
        PostItemBean postItemBean = ((WorksItemPostBinding) this).f14614a;
        Integer num2 = ((WorksItemPostBinding) this).f14621b;
        long j4 = j & 416;
        if (j4 != 0) {
            z = ViewDataBinding.safeUnbox(num) == 1;
            if (j4 != 0) {
                j = z ? j | 4096 : j | 2048;
            }
        } else {
            z = false;
        }
        long j5 = j & 352;
        if (j5 != 0) {
            if ((j & 320) != 0) {
                if (postItemBean != null) {
                    zShowCommentUser = postItemBean.showCommentUser(3);
                    zShowCommentUser2 = postItemBean.showCommentUser(0);
                    userInfo = postItemBean.getUserInfo();
                    publishTime = postItemBean.formatPublishTime();
                    zShowCommentUser3 = postItemBean.showCommentUser(4);
                    zShowCommentUser4 = postItemBean.showCommentUser(2);
                    postInfo = postItemBean.getPostInfo();
                    zShowCommentUser5 = postItemBean.showCommentUser(1);
                    comment = postItemBean.getComment();
                } else {
                    zShowCommentUser = false;
                    zShowCommentUser2 = false;
                    zShowCommentUser3 = false;
                    zShowCommentUser4 = false;
                    zShowCommentUser5 = false;
                    userInfo = null;
                    publishTime = null;
                    postInfo = null;
                    comment = null;
                }
                if (userInfo != null) {
                    avatarFrameImgUrl = userInfo.getAvatarFrameImgUrl();
                    appUserCode = userInfo.getAppUserCode();
                    nickName = userInfo.getNickName();
                    avatar = userInfo.getAvatar();
                } else {
                    avatar = null;
                    avatarFrameImgUrl = null;
                    appUserCode = null;
                    nickName = null;
                }
                if (postInfo != null) {
                    redPacket = postInfo.getRedPacket();
                    liked = postInfo.getLiked();
                    imageList = postInfo.getImageList();
                    postNo = postInfo.getPostNo();
                    likeCount = postInfo.getLikeCount();
                } else {
                    likeCount = 0;
                    liked = false;
                    redPacket = null;
                    imageList = null;
                    postNo = null;
                }
                int total = comment != null ? comment.getTotal() : 0;
                str = String.format("¥%s", redPacket);
                boolean zIsEmpty = TextUtils.isEmpty(redPacket);
                str2 = String.format("评论 (%d)", Integer.valueOf(total));
                z3 = !zIsEmpty;
            } else {
                z3 = false;
                zShowCommentUser = false;
                zShowCommentUser2 = false;
                zShowCommentUser3 = false;
                zShowCommentUser4 = false;
                likeCount = 0;
                zShowCommentUser5 = false;
                liked = false;
                str = null;
                str2 = null;
                avatar = null;
                publishTime = null;
                avatarFrameImgUrl = null;
                appUserCode = null;
                nickName = null;
                imageList = null;
                postNo = null;
            }
            zOnTop = postItemBean != null ? postItemBean.onTop() : false;
            if (j5 != 0) {
                j = zOnTop ? j | 1024 : j | 512;
            }
            z2 = zShowCommentUser;
            z4 = zShowCommentUser2;
            str5 = avatar;
            str6 = publishTime;
            z5 = zShowCommentUser3;
            z6 = zShowCommentUser4;
            i = likeCount;
            z7 = zShowCommentUser5;
            str7 = avatarFrameImgUrl;
            str4 = appUserCode;
            str8 = nickName;
            list = imageList;
            str3 = postNo;
        } else {
            z2 = false;
            z3 = false;
            zOnTop = false;
            i = 0;
            liked = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            list = null;
        }
        long j6 = j & 384;
        if (j6 != 0) {
            int iSafeUnbox = ViewDataBinding.safeUnbox(num2);
            int i5 = iSafeUnbox + 1;
            z9 = iSafeUnbox >= 0;
            if (iSafeUnbox == 0) {
                z10 = true;
                i4 = 2;
            } else {
                i4 = 2;
                z10 = false;
            }
            z8 = iSafeUnbox > i4;
            if (j6 != 0) {
                j = z9 ? j | 67108864 : j | 33554432;
            }
            if ((j & 384) != 0) {
                j = z10 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | 1048576 : j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            str9 = String.format("TOP%d", Integer.valueOf(i5));
        } else {
            str9 = null;
            z8 = false;
            z9 = false;
            z10 = false;
        }
        boolean z18 = (j & 1024) != 0 && ViewDataBinding.safeUnbox(num) == 0;
        if ((j & 561152) != 0) {
            int iSafeUnbox2 = ViewDataBinding.safeUnbox(num2);
            if ((j & 4096) != 0) {
                boolean z19 = iSafeUnbox2 >= 0;
                if ((j & 384) != 0) {
                    j = z19 ? j | 67108864 : j | 33554432;
                }
                z9 = z19;
            }
            if ((j & 557056) != 0) {
                boolean z20 = iSafeUnbox2 == 1;
                if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
                    j |= z20 ? 262144L : 131072L;
                }
                if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
                    j |= z20 ? 16777216L : 8388608L;
                }
                if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
                    drawable = z20 ? AppCompatResources.getDrawable(this.e.getContext(), R.drawable.works_ic_post_rank_top_two) : AppCompatResources.getDrawable(this.e.getContext(), R.drawable.works_ic_post_rank_top_three);
                } else {
                    drawable = null;
                }
                if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
                    if (z20) {
                        context = this.d.getContext();
                        i3 = R.drawable.works_bg_post_list_two;
                    } else {
                        context = this.d.getContext();
                        i3 = R.drawable.works_bg_post_list_three;
                    }
                    drawable2 = AppCompatResources.getDrawable(context, i3);
                }
            } else {
                z18 = z18;
                drawable = null;
            }
            drawable2 = null;
        } else {
            z18 = z18;
            drawable = null;
            drawable2 = null;
        }
        long j7 = j & 352;
        if (j7 != 0) {
            if (!zOnTop) {
                z18 = false;
            }
            if (j7 != 0) {
                j |= z18 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
            }
            i2 = z18 ? 36 : 20;
            z11 = z18;
            j2 = 416;
        } else {
            z11 = false;
            j2 = 416;
            i2 = 0;
        }
        long j8 = j & j2;
        if (j8 != 0) {
            z12 = z ? z9 : false;
            if (j8 != 0) {
                j |= z12 ? PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED : 2097152L;
            }
        } else {
            z12 = false;
        }
        long j9 = j & 384;
        if (j9 != 0) {
            if (z10) {
                drawable2 = AppCompatResources.getDrawable(this.d.getContext(), R.drawable.works_bg_post_list_one);
            }
            drawable3 = z10 ? AppCompatResources.getDrawable(this.e.getContext(), R.drawable.works_ic_post_rank_top_one) : drawable;
            drawable4 = drawable2;
        } else {
            drawable3 = null;
            drawable4 = null;
        }
        if ((j & 71303168) != 0) {
            z13 = z;
            z14 = ViewDataBinding.safeUnbox(num2) < 3;
            j3 = j & 416;
            if (j3 != 0) {
                if (z12) {
                    z17 = z14;
                } else {
                    z17 = false;
                }
                z15 = z17;
            } else {
                z15 = false;
            }
            if (j9 != 0) {
                if (!z9) {
                    z14 = false;
                }
                z16 = z14;
            } else {
                z16 = false;
            }
            if ((j & 352) != 0) {
                CommonBindingAdapter.I(((WorksItemPostBinding) this).f14613a, 0, i2, 0, 0, null);
                CommonBindingAdapter.l0(this.f14629b, z11);
                CommonBindingAdapter.l0(this.c, z11);
                CommonBindingAdapter.l0(this.f, z11);
            }
            if ((j & 320) != 0) {
                aw9.d(((WorksItemPostBinding) this).f14613a, str5, false, null);
                aw9.c(((WorksItemPostBinding) this).f14613a, str7, null);
                zv9.b(((WorksItemPostBinding) this).f14616a, 6, Boolean.valueOf(liked), i, str3, str4, null, null, 9);
                CommonBindingAdapter.l0(this.f14630b, z3);
                TextViewBindingAdapter.setText(this.g, str);
                zv9.c(((WorksItemPostBinding) this).f14617a, list);
                CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14615a.getRoot(), z5);
                ((WorksItemPostBinding) this).f14615a.m(postItemBean);
                CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14620b.getRoot(), z2);
                ((WorksItemPostBinding) this).f14620b.m(postItemBean);
                boolean z21 = z4;
                CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14622c.getRoot(), z21);
                ((WorksItemPostBinding) this).f14622c.m(postItemBean);
                CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14623d.getRoot(), z6);
                ((WorksItemPostBinding) this).f14623d.m(postItemBean);
                CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14624e.getRoot(), z7);
                ((WorksItemPostBinding) this).f14624e.m(postItemBean);
                TextViewBindingAdapter.setText(((WorksItemPostBinding) this).f14612a, str2);
                TextViewBindingAdapter.setText(((WorksItemPostBinding) this).c, str8);
                TextViewBindingAdapter.setText(((WorksItemPostBinding) this).d, str6);
                CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14618a, z21);
            }
            if (j9 != 0) {
                TextViewBindingAdapter.setText(this.f14628a, str9);
                ImageViewBindingAdapter.setImageDrawable(this.d, drawable4);
                CommonBindingAdapter.l0(this.e, z16);
                ImageViewBindingAdapter.setImageDrawable(this.e, drawable3);
                CommonBindingAdapter.l0(this.b, z8);
            }
            if (j3 != 0) {
                CommonBindingAdapter.l0(this.d, z15);
            }
            if ((j & 256) != 0) {
                ((WorksItemPostBinding) this).f14615a.l(4);
                ((WorksItemPostBinding) this).f14620b.l(3);
                ((WorksItemPostBinding) this).f14622c.l(0);
                ((WorksItemPostBinding) this).f14623d.l(2);
                ((WorksItemPostBinding) this).f14624e.l(1);
            }
            if ((j & 288) != 0) {
                CommonBindingAdapter.l0(((WorksItemPostBinding) this).f37043a, z13);
            }
            ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14622c);
            ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14624e);
            ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14623d);
            ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14620b);
            ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14615a);
        }
        z13 = z;
        j3 = j & 416;
        if (j3 != 0) {
            if (z12) {
                z17 = z14;
            } else {
                z17 = false;
            }
            z15 = z17;
        } else {
            z15 = false;
        }
        if (j9 != 0) {
            if (!z9) {
                z14 = false;
            }
            z16 = z14;
        } else {
            z16 = false;
        }
        if ((j & 352) != 0) {
            CommonBindingAdapter.I(((WorksItemPostBinding) this).f14613a, 0, i2, 0, 0, null);
            CommonBindingAdapter.l0(this.f14629b, z11);
            CommonBindingAdapter.l0(this.c, z11);
            CommonBindingAdapter.l0(this.f, z11);
        }
        if ((j & 320) != 0) {
            aw9.d(((WorksItemPostBinding) this).f14613a, str5, false, null);
            aw9.c(((WorksItemPostBinding) this).f14613a, str7, null);
            zv9.b(((WorksItemPostBinding) this).f14616a, 6, Boolean.valueOf(liked), i, str3, str4, null, null, 9);
            CommonBindingAdapter.l0(this.f14630b, z3);
            TextViewBindingAdapter.setText(this.g, str);
            zv9.c(((WorksItemPostBinding) this).f14617a, list);
            CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14615a.getRoot(), z5);
            ((WorksItemPostBinding) this).f14615a.m(postItemBean);
            CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14620b.getRoot(), z2);
            ((WorksItemPostBinding) this).f14620b.m(postItemBean);
            boolean z22 = z4;
            CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14622c.getRoot(), z22);
            ((WorksItemPostBinding) this).f14622c.m(postItemBean);
            CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14623d.getRoot(), z6);
            ((WorksItemPostBinding) this).f14623d.m(postItemBean);
            CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14624e.getRoot(), z7);
            ((WorksItemPostBinding) this).f14624e.m(postItemBean);
            TextViewBindingAdapter.setText(((WorksItemPostBinding) this).f14612a, str2);
            TextViewBindingAdapter.setText(((WorksItemPostBinding) this).c, str8);
            TextViewBindingAdapter.setText(((WorksItemPostBinding) this).d, str6);
            CommonBindingAdapter.l0(((WorksItemPostBinding) this).f14618a, z22);
        }
        if (j9 != 0) {
            TextViewBindingAdapter.setText(this.f14628a, str9);
            ImageViewBindingAdapter.setImageDrawable(this.d, drawable4);
            CommonBindingAdapter.l0(this.e, z16);
            ImageViewBindingAdapter.setImageDrawable(this.e, drawable3);
            CommonBindingAdapter.l0(this.b, z8);
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(this.d, z15);
        }
        if ((j & 256) != 0) {
            ((WorksItemPostBinding) this).f14615a.l(4);
            ((WorksItemPostBinding) this).f14620b.l(3);
            ((WorksItemPostBinding) this).f14622c.l(0);
            ((WorksItemPostBinding) this).f14623d.l(2);
            ((WorksItemPostBinding) this).f14624e.l(1);
        }
        if ((j & 288) != 0) {
            CommonBindingAdapter.l0(((WorksItemPostBinding) this).f37043a, z13);
        }
        ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14622c);
        ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14624e);
        ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14623d);
        ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14620b);
        ViewDataBinding.executeBindingsOn(((WorksItemPostBinding) this).f14615a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f14626a != 0) {
                return true;
            }
            return ((WorksItemPostBinding) this).f14622c.hasPendingBindings() || ((WorksItemPostBinding) this).f14624e.hasPendingBindings() || ((WorksItemPostBinding) this).f14623d.hasPendingBindings() || ((WorksItemPostBinding) this).f14620b.hasPendingBindings() || ((WorksItemPostBinding) this).f14615a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14626a = 256L;
        }
        ((WorksItemPostBinding) this).f14622c.invalidateAll();
        ((WorksItemPostBinding) this).f14624e.invalidateAll();
        ((WorksItemPostBinding) this).f14623d.invalidateAll();
        ((WorksItemPostBinding) this).f14620b.invalidateAll();
        ((WorksItemPostBinding) this).f14615a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPostBinding
    public void m(@Nullable Integer Position) {
        ((WorksItemPostBinding) this).f14621b = Position;
        synchronized (this) {
            this.f14626a |= 128;
        }
        notifyPropertyChanged(qk0.P);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPostBinding
    public void n(@Nullable Integer PostType) {
        ((WorksItemPostBinding) this).f14619a = PostType;
        synchronized (this) {
            this.f14626a |= 32;
        }
        notifyPropertyChanged(qk0.Q);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPostBinding
    public void o(@Nullable PostItemBean Vm) {
        ((WorksItemPostBinding) this).f14614a = Vm;
        synchronized (this) {
            this.f14626a |= 64;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return t((WorksLayoutPostCommentBinding) object, fieldId);
        }
        if (localFieldId == 1) {
            return p((WorksLayoutPostCommentBinding) object, fieldId);
        }
        if (localFieldId == 2) {
            return r((WorksLayoutPostCommentBinding) object, fieldId);
        }
        if (localFieldId == 3) {
            return q((WorksLayoutPostCommentBinding) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return s((WorksLayoutPostCommentBinding) object, fieldId);
    }

    public final boolean p(WorksLayoutPostCommentBinding PostCommentFive, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14626a |= 2;
        }
        return true;
    }

    public final boolean q(WorksLayoutPostCommentBinding PostCommentFour, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14626a |= 8;
        }
        return true;
    }

    public final boolean r(WorksLayoutPostCommentBinding PostCommentOne, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14626a |= 4;
        }
        return true;
    }

    public final boolean s(WorksLayoutPostCommentBinding PostCommentThree, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14626a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((WorksItemPostBinding) this).f14622c.setLifecycleOwner(lifecycleOwner);
        ((WorksItemPostBinding) this).f14624e.setLifecycleOwner(lifecycleOwner);
        ((WorksItemPostBinding) this).f14623d.setLifecycleOwner(lifecycleOwner);
        ((WorksItemPostBinding) this).f14620b.setLifecycleOwner(lifecycleOwner);
        ((WorksItemPostBinding) this).f14615a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.Q == variableId) {
            n((Integer) variable);
        } else if (qk0.p0 == variableId) {
            o((PostItemBean) variable);
        } else {
            if (qk0.P != variableId) {
                return false;
            }
            m((Integer) variable);
        }
        return true;
    }

    public final boolean t(WorksLayoutPostCommentBinding PostCommentTwo, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14626a |= 1;
        }
        return true;
    }

    public WorksItemPostBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (AvatarView) bindings[5], (ImageView) bindings[25], (BLOperateAnimView) bindings[13], (LinearLayout) bindings[24], (PostNineGridView) bindings[12], (WorksLayoutPostCommentBinding) bindings[22], (WorksLayoutPostCommentBinding) bindings[21], (WorksLayoutPostCommentBinding) bindings[18], (WorksLayoutPostCommentBinding) bindings[20], (WorksLayoutPostCommentBinding) bindings[19], (FrameLayout) bindings[7], (TextView) bindings[17], (TextView) bindings[23], (TextView) bindings[6], (TextView) bindings[11], (TextView) bindings[26], (TextView) bindings[2], (BLLinearLayout) bindings[16]);
        this.f14626a = -1L;
        ((WorksItemPostBinding) this).f14613a.setTag(null);
        ((WorksItemPostBinding) this).f14616a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14627a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14629b = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[10];
        this.f14628a = bLTextView;
        bLTextView.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[14];
        this.f14630b = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) bindings[15];
        this.g = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[3];
        this.c = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[4];
        this.d = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[8];
        this.e = imageView4;
        imageView4.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[9];
        this.b = frameLayout;
        frameLayout.setTag(null);
        ((WorksItemPostBinding) this).f14617a.setTag(null);
        setContainedBinding(((WorksItemPostBinding) this).f14615a);
        setContainedBinding(((WorksItemPostBinding) this).f14620b);
        setContainedBinding(((WorksItemPostBinding) this).f14622c);
        setContainedBinding(((WorksItemPostBinding) this).f14623d);
        setContainedBinding(((WorksItemPostBinding) this).f14624e);
        ((WorksItemPostBinding) this).f37043a.setTag(null);
        ((WorksItemPostBinding) this).f14612a.setTag(null);
        ((WorksItemPostBinding) this).c.setTag(null);
        ((WorksItemPostBinding) this).d.setTag(null);
        this.f.setTag(null);
        ((WorksItemPostBinding) this).f14618a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
