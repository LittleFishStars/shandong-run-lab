package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.bean.comment.CommentUserBean;
import com.huachenjie.works.bean.comment.TargetComment;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.page.comment.base.CommentDelegate;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemCommentReplyBindingImpl extends WorksItemCommentReplyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14551a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Group f14554a;

    @NonNull
    public final TextView f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37024a = sparseIntArray;
        sparseIntArray.put(R.id.tv_reply, 9);
        sparseIntArray.put(R.id.flow, 10);
        sparseIntArray.put(R.id.iv_pic, 11);
    }

    public WorksItemCommentReplyBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 12, f14551a, f37024a));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:102:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:108:0x0210  */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x014f  */
    /* JADX WARN: Code duplicated, block: B:57:0x015d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0166 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x0168  */
    /* JADX WARN: Code duplicated, block: B:62:0x016d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0177  */
    /* JADX WARN: Code duplicated, block: B:70:0x017d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x017f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0181  */
    /* JADX WARN: Code duplicated, block: B:74:0x0184 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x0186  */
    /* JADX WARN: Code duplicated, block: B:76:0x0189  */
    /* JADX WARN: Code duplicated, block: B:79:0x018e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0192  */
    /* JADX WARN: Code duplicated, block: B:81:0x0196  */
    /* JADX WARN: Code duplicated, block: B:85:0x019e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:89:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:92:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:94:0x01ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b6  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean liked;
        boolean zIsEmpty;
        boolean z2;
        int i;
        int i2;
        int i3;
        boolean z3;
        String str;
        String avatar;
        TargetComment targetComment;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String nickName;
        CharSequence charSequence;
        boolean z4;
        String submitTimeStr;
        boolean z5;
        String str7;
        long j2;
        int i4;
        boolean z6;
        long j3;
        int publishStatus;
        long j4;
        boolean z7;
        long j5;
        int likeCount;
        CommentUserBean userInfo;
        String bizAuthorNo;
        String commentNo;
        String bizNo;
        boolean z8;
        String avatarFrameImgUrl;
        String nickName2;
        boolean targetRootFlag;
        CharSequence textContent;
        synchronized (this) {
            j = this.f14552a;
            this.f14552a = 0L;
        }
        Integer num = ((WorksItemCommentReplyBinding) this).f14549a;
        Integer num2 = ((WorksItemCommentReplyBinding) this).f14550b;
        CommentReplyBean commentReplyBean = ((WorksItemCommentReplyBinding) this).f14547a;
        if ((j & 15) != 0) {
            int iSafeUnbox = ViewDataBinding.safeUnbox(num);
            int iSafeUnbox2 = ViewDataBinding.safeUnbox(num2);
            if (commentReplyBean != null) {
                userInfo = commentReplyBean.getUserInfo();
                bizAuthorNo = commentReplyBean.getBizAuthorNo();
                commentNo = commentReplyBean.getCommentNo();
                likeCount = commentReplyBean.getLikeCount();
                liked = commentReplyBean.getLiked();
                bizNo = commentReplyBean.getBizNo();
            } else {
                likeCount = 0;
                liked = false;
                userInfo = null;
                bizAuthorNo = null;
                commentNo = null;
                bizNo = null;
            }
            int iA = CommentDelegate.a(iSafeUnbox);
            String appUserCode = userInfo != null ? userInfo.getAppUserCode() : null;
            long j6 = j & 12;
            if (j6 != 0) {
                if (userInfo != null) {
                    avatarFrameImgUrl = userInfo.getAvatarFrameImgUrl();
                    nickName2 = userInfo.getNickName();
                    avatar = userInfo.getAvatar();
                } else {
                    avatar = null;
                    avatarFrameImgUrl = null;
                    nickName2 = null;
                }
                zIsEmpty = TextUtils.isEmpty(commentNo);
                if (j6 != 0) {
                    j = zIsEmpty ? j | 32 | 128 : j | 16 | 64;
                }
                z8 = !zIsEmpty;
            } else {
                z8 = false;
                zIsEmpty = false;
                avatar = null;
                avatarFrameImgUrl = null;
                nickName2 = null;
            }
            long j7 = j & 12;
            if (j7 != 0) {
                if (commentReplyBean != null) {
                    textContent = commentReplyBean.getTextContent();
                    targetComment = commentReplyBean.getTargetComment();
                    targetRootFlag = commentReplyBean.getTargetRootFlag();
                } else {
                    targetRootFlag = false;
                    textContent = null;
                    targetComment = null;
                }
                boolean zIsEmpty2 = TextUtils.isEmpty(textContent);
                z2 = !targetRootFlag;
                if (j7 != 0) {
                    j = z2 ? j | 2048 : j | 1024;
                }
                CommentUserBean userInfo2 = targetComment != null ? targetComment.getUserInfo() : null;
                boolean z9 = !zIsEmpty2;
                if (userInfo2 != null) {
                    i = iA;
                    i3 = iSafeUnbox2;
                    str3 = bizAuthorNo;
                    str4 = commentNo;
                    i2 = likeCount;
                    str2 = bizNo;
                    str5 = appUserCode;
                    z = z8;
                    str = avatarFrameImgUrl;
                    str6 = nickName2;
                    nickName = userInfo2.getNickName();
                    charSequence = textContent;
                    z3 = z9;
                } else {
                    i = iA;
                    i3 = iSafeUnbox2;
                    str3 = bizAuthorNo;
                    str4 = commentNo;
                    i2 = likeCount;
                    str2 = bizNo;
                    str5 = appUserCode;
                    z = z8;
                    str = avatarFrameImgUrl;
                    str6 = nickName2;
                    charSequence = textContent;
                    z3 = z9;
                    nickName = null;
                }
            } else {
                i = iA;
                i3 = iSafeUnbox2;
                z2 = false;
                z3 = false;
                str3 = bizAuthorNo;
                str4 = commentNo;
                i2 = likeCount;
                str2 = bizNo;
                str5 = appUserCode;
                z = z8;
                str = avatarFrameImgUrl;
                str6 = nickName2;
                targetComment = null;
            }
            if ((j & 2048) != 0 || targetComment == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            if ((64 & j) != 0 || commentReplyBean == null) {
                submitTimeStr = null;
            } else {
                submitTimeStr = commentReplyBean.getSubmitTimeStr();
            }
            if ((j & 160) != 0) {
                if (commentReplyBean != null) {
                    publishStatus = commentReplyBean.getPublishStatus();
                } else {
                    publishStatus = 0;
                }
                if ((32 & j) == 0 && publishStatus == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                j4 = 128 & j;
                if (j4 != 0) {
                    if (publishStatus == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (j4 != 0) {
                        if (z7) {
                            j5 = 512;
                        } else {
                            j5 = 256;
                        }
                        j |= j5;
                    }
                    if (z7) {
                        str7 = "发送中…";
                    } else {
                        str7 = "发送失败";
                    }
                }
                j2 = j & 12;
                if (j2 != 0) {
                    if (!zIsEmpty) {
                        z5 = false;
                    }
                    if (zIsEmpty) {
                        submitTimeStr = str7;
                    }
                    if (!z2) {
                        z4 = false;
                    }
                    if (j2 != 0) {
                        if (z5) {
                            j3 = 8192;
                        } else {
                            j3 = 4096;
                        }
                        j |= j3;
                    }
                    if (z5) {
                        i4 = -49859;
                    } else {
                        i4 = RunIndexRecordAdapter.O;
                    }
                    z6 = z4;
                } else {
                    i4 = 0;
                    z6 = false;
                    submitTimeStr = null;
                }
                if ((j & 12) != 0) {
                    CommonBindingAdapter.e0(((WorksItemCommentReplyBinding) this).f14548a, z);
                    aw9.d(((WorksItemCommentReplyBinding) this).f14546a, avatar, false, null);
                    aw9.c(((WorksItemCommentReplyBinding) this).f14546a, str, null);
                    CommonBindingAdapter.l0(this.f14554a, z6);
                    CommonBindingAdapter.l0(this.f, z);
                    CommonBindingAdapter.l0(((WorksItemCommentReplyBinding) this).f14544a, z3);
                    zv9.h(((WorksItemCommentReplyBinding) this).f14544a, charSequence, true);
                    TextViewBindingAdapter.setText(((WorksItemCommentReplyBinding) this).b, str6);
                    TextViewBindingAdapter.setText(this.d, nickName);
                    TextViewBindingAdapter.setText(this.e, submitTimeStr);
                    this.e.setTextColor(i4);
                }
                if ((j & 15) != 0) {
                    zv9.b(((WorksItemCommentReplyBinding) this).f14548a, i, Boolean.valueOf(liked), i2, str2, str3, str4, str5, i3);
                }
            }
            z5 = false;
            str7 = null;
            j2 = j & 12;
            if (j2 != 0) {
                if (!zIsEmpty) {
                    z5 = false;
                }
                if (zIsEmpty) {
                    submitTimeStr = str7;
                }
                if (!z2) {
                    z4 = false;
                }
                if (j2 != 0) {
                    if (z5) {
                        j3 = 8192;
                    } else {
                        j3 = 4096;
                    }
                    j |= j3;
                }
                if (z5) {
                    i4 = -49859;
                } else {
                    i4 = RunIndexRecordAdapter.O;
                }
                z6 = z4;
            } else {
                i4 = 0;
                z6 = false;
                submitTimeStr = null;
            }
            if ((j & 12) != 0) {
                CommonBindingAdapter.e0(((WorksItemCommentReplyBinding) this).f14548a, z);
                aw9.d(((WorksItemCommentReplyBinding) this).f14546a, avatar, false, null);
                aw9.c(((WorksItemCommentReplyBinding) this).f14546a, str, null);
                CommonBindingAdapter.l0(this.f14554a, z6);
                CommonBindingAdapter.l0(this.f, z);
                CommonBindingAdapter.l0(((WorksItemCommentReplyBinding) this).f14544a, z3);
                zv9.h(((WorksItemCommentReplyBinding) this).f14544a, charSequence, true);
                TextViewBindingAdapter.setText(((WorksItemCommentReplyBinding) this).b, str6);
                TextViewBindingAdapter.setText(this.d, nickName);
                TextViewBindingAdapter.setText(this.e, submitTimeStr);
                this.e.setTextColor(i4);
            }
            if ((j & 15) != 0) {
                zv9.b(((WorksItemCommentReplyBinding) this).f14548a, i, Boolean.valueOf(liked), i2, str2, str3, str4, str5, i3);
            }
        }
        z = false;
        liked = false;
        zIsEmpty = false;
        z2 = false;
        i = 0;
        i2 = 0;
        i3 = 0;
        z3 = false;
        str = null;
        avatar = null;
        targetComment = null;
        str2 = null;
        str3 = null;
        str4 = null;
        str5 = null;
        str6 = null;
        nickName = null;
        charSequence = null;
        if ((j & 2048) != 0) {
            z4 = false;
        } else {
            z4 = false;
        }
        if ((64 & j) != 0) {
            submitTimeStr = null;
        } else {
            submitTimeStr = null;
        }
        if ((j & 160) != 0) {
            if (commentReplyBean != null) {
                publishStatus = commentReplyBean.getPublishStatus();
            } else {
                publishStatus = 0;
            }
            if ((32 & j) == 0) {
                z5 = false;
            } else {
                z5 = false;
            }
            j4 = 128 & j;
            if (j4 != 0) {
                if (publishStatus == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (j4 != 0) {
                    if (z7) {
                        j5 = 512;
                    } else {
                        j5 = 256;
                    }
                    j |= j5;
                }
                if (z7) {
                    str7 = "发送中…";
                } else {
                    str7 = "发送失败";
                }
            }
            j2 = j & 12;
            if (j2 != 0) {
                if (!zIsEmpty) {
                    z5 = false;
                }
                if (zIsEmpty) {
                    submitTimeStr = str7;
                }
                if (!z2) {
                    z4 = false;
                }
                if (j2 != 0) {
                    if (z5) {
                        j3 = 8192;
                    } else {
                        j3 = 4096;
                    }
                    j |= j3;
                }
                if (z5) {
                    i4 = -49859;
                } else {
                    i4 = RunIndexRecordAdapter.O;
                }
                z6 = z4;
            } else {
                i4 = 0;
                z6 = false;
                submitTimeStr = null;
            }
            if ((j & 12) != 0) {
                CommonBindingAdapter.e0(((WorksItemCommentReplyBinding) this).f14548a, z);
                aw9.d(((WorksItemCommentReplyBinding) this).f14546a, avatar, false, null);
                aw9.c(((WorksItemCommentReplyBinding) this).f14546a, str, null);
                CommonBindingAdapter.l0(this.f14554a, z6);
                CommonBindingAdapter.l0(this.f, z);
                CommonBindingAdapter.l0(((WorksItemCommentReplyBinding) this).f14544a, z3);
                zv9.h(((WorksItemCommentReplyBinding) this).f14544a, charSequence, true);
                TextViewBindingAdapter.setText(((WorksItemCommentReplyBinding) this).b, str6);
                TextViewBindingAdapter.setText(this.d, nickName);
                TextViewBindingAdapter.setText(this.e, submitTimeStr);
                this.e.setTextColor(i4);
            }
            if ((j & 15) != 0) {
                zv9.b(((WorksItemCommentReplyBinding) this).f14548a, i, Boolean.valueOf(liked), i2, str2, str3, str4, str5, i3);
            }
        }
        z5 = false;
        str7 = null;
        j2 = j & 12;
        if (j2 != 0) {
            if (!zIsEmpty) {
                z5 = false;
            }
            if (zIsEmpty) {
                submitTimeStr = str7;
            }
            if (!z2) {
                z4 = false;
            }
            if (j2 != 0) {
                if (z5) {
                    j3 = 8192;
                } else {
                    j3 = 4096;
                }
                j |= j3;
            }
            if (z5) {
                i4 = -49859;
            } else {
                i4 = RunIndexRecordAdapter.O;
            }
            z6 = z4;
        } else {
            i4 = 0;
            z6 = false;
            submitTimeStr = null;
        }
        if ((j & 12) != 0) {
            CommonBindingAdapter.e0(((WorksItemCommentReplyBinding) this).f14548a, z);
            aw9.d(((WorksItemCommentReplyBinding) this).f14546a, avatar, false, null);
            aw9.c(((WorksItemCommentReplyBinding) this).f14546a, str, null);
            CommonBindingAdapter.l0(this.f14554a, z6);
            CommonBindingAdapter.l0(this.f, z);
            CommonBindingAdapter.l0(((WorksItemCommentReplyBinding) this).f14544a, z3);
            zv9.h(((WorksItemCommentReplyBinding) this).f14544a, charSequence, true);
            TextViewBindingAdapter.setText(((WorksItemCommentReplyBinding) this).b, str6);
            TextViewBindingAdapter.setText(this.d, nickName);
            TextViewBindingAdapter.setText(this.e, submitTimeStr);
            this.e.setTextColor(i4);
        }
        if ((j & 15) != 0) {
            zv9.b(((WorksItemCommentReplyBinding) this).f14548a, i, Boolean.valueOf(liked), i2, str2, str3, str4, str5, i3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14552a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14552a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemCommentReplyBinding
    public void m(@Nullable CommentReplyBean Bean) {
        ((WorksItemCommentReplyBinding) this).f14547a = Bean;
        synchronized (this) {
            this.f14552a |= 4;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemCommentReplyBinding
    public void n(@Nullable Integer CommentType) {
        ((WorksItemCommentReplyBinding) this).f14549a = CommentType;
        synchronized (this) {
            this.f14552a |= 1;
        }
        notifyPropertyChanged(qk0.l);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemCommentReplyBinding
    public void o(@Nullable Integer Source) {
        ((WorksItemCommentReplyBinding) this).f14550b = Source;
        synchronized (this) {
            this.f14552a |= 2;
        }
        notifyPropertyChanged(qk0.f0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.l == variableId) {
            n((Integer) variable);
        } else if (qk0.f0 == variableId) {
            o((Integer) variable);
        } else {
            if (qk0.g != variableId) {
                return false;
            }
            m((CommentReplyBean) variable);
        }
        return true;
    }

    public WorksItemCommentReplyBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLOperateAnimView) bindings[5], (Flow) bindings[10], (AvatarView) bindings[1], (ImageView) bindings[11], (TextView) bindings[6], (TextView) bindings[2], (TextView) bindings[9], (TextView) bindings[3], (TextView) bindings[7]);
        this.f14552a = -1L;
        ((WorksItemCommentReplyBinding) this).f14548a.setTag(null);
        ((WorksItemCommentReplyBinding) this).f14546a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14553a = constraintLayout;
        constraintLayout.setTag(null);
        Group group = (Group) bindings[4];
        this.f14554a = group;
        group.setTag(null);
        TextView textView = (TextView) bindings[8];
        this.f = textView;
        textView.setTag(null);
        ((WorksItemCommentReplyBinding) this).f14544a.setTag(null);
        ((WorksItemCommentReplyBinding) this).b.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
