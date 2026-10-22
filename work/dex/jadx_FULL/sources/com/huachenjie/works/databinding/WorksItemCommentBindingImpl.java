package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentUserBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.page.comment.base.CommentDelegate;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemCommentBindingImpl extends WorksItemCommentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14525a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14528a;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37018a = sparseIntArray;
        sparseIntArray.put(R.id.iv_pic, 8);
    }

    public WorksItemCommentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, f14525a, f37018a));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x010b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0114 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0116  */
    /* JADX WARN: Code duplicated, block: B:46:0x011b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0125  */
    /* JADX WARN: Code duplicated, block: B:54:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x012d  */
    /* JADX WARN: Code duplicated, block: B:56:0x012f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0134  */
    /* JADX WARN: Code duplicated, block: B:60:0x0137  */
    /* JADX WARN: Code duplicated, block: B:63:0x013c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0140  */
    /* JADX WARN: Code duplicated, block: B:65:0x0144  */
    /* JADX WARN: Code duplicated, block: B:69:0x014c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x014f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0152  */
    /* JADX WARN: Code duplicated, block: B:75:0x0155 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0157  */
    /* JADX WARN: Code duplicated, block: B:77:0x015a  */
    /* JADX WARN: Code duplicated, block: B:80:0x015f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0163  */
    /* JADX WARN: Code duplicated, block: B:82:0x0167  */
    /* JADX WARN: Code duplicated, block: B:85:0x016f  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean liked;
        boolean zIsEmpty;
        int i;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        String str;
        String avatar;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        CharSequence charSequence;
        String submitTimeStr;
        boolean z4;
        String str7;
        long j2;
        int i4;
        long j3;
        int publishStatus;
        long j4;
        boolean z5;
        long j5;
        int likeCount;
        CommentUserBean userInfo;
        String bizAuthorNo;
        String commentNo;
        String bizNo;
        boolean z6;
        String avatarFrameImgUrl;
        String nickName;
        boolean authorFlag;
        CharSequence textContent;
        synchronized (this) {
            j = this.f14526a;
            this.f14526a = 0L;
        }
        Integer num = ((WorksItemCommentBinding) this).f14523a;
        Integer num2 = ((WorksItemCommentBinding) this).f14524b;
        CommentBean commentBean = ((WorksItemCommentBinding) this).f14521a;
        if ((j & 15) != 0) {
            int iSafeUnbox = ViewDataBinding.safeUnbox(num);
            int iSafeUnbox2 = ViewDataBinding.safeUnbox(num2);
            if (commentBean != null) {
                userInfo = commentBean.getUserInfo();
                bizAuthorNo = commentBean.getBizAuthorNo();
                commentNo = commentBean.getCommentNo();
                likeCount = commentBean.getLikeCount();
                liked = commentBean.getLiked();
                bizNo = commentBean.getBizNo();
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
                    nickName = userInfo.getNickName();
                    avatar = userInfo.getAvatar();
                } else {
                    avatar = null;
                    avatarFrameImgUrl = null;
                    nickName = null;
                }
                zIsEmpty = TextUtils.isEmpty(commentNo);
                if (j6 != 0) {
                    j = zIsEmpty ? j | 32 | 128 : j | 16 | 64;
                }
                z6 = !zIsEmpty;
            } else {
                z6 = false;
                zIsEmpty = false;
                avatar = null;
                avatarFrameImgUrl = null;
                nickName = null;
            }
            if ((j & 12) != 0) {
                if (commentBean != null) {
                    textContent = commentBean.getTextContent();
                    authorFlag = commentBean.getAuthorFlag();
                } else {
                    authorFlag = false;
                    textContent = null;
                }
                i = iA;
                i3 = iSafeUnbox2;
                str3 = bizAuthorNo;
                str4 = commentNo;
                i2 = likeCount;
                str2 = bizNo;
                str5 = appUserCode;
                z = z6;
                str = avatarFrameImgUrl;
                str6 = nickName;
                charSequence = textContent;
                z2 = authorFlag;
                z3 = !TextUtils.isEmpty(textContent);
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
                z = z6;
                str = avatarFrameImgUrl;
                str6 = nickName;
            }
            if ((64 & j) != 0 || commentBean == null) {
                submitTimeStr = null;
            } else {
                submitTimeStr = commentBean.getSubmitTimeStr();
            }
            if ((j & 160) != 0) {
                if (commentBean != null) {
                    publishStatus = commentBean.getPublishStatus();
                } else {
                    publishStatus = 0;
                }
                if ((32 & j) == 0 && publishStatus == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                j4 = 128 & j;
                if (j4 != 0) {
                    if (publishStatus == 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (j4 != 0) {
                        if (z5) {
                            j5 = 512;
                        } else {
                            j5 = 256;
                        }
                        j |= j5;
                    }
                    if (z5) {
                        str7 = "发送中…";
                    } else {
                        str7 = "发送失败";
                    }
                }
                j2 = j & 12;
                if (j2 != 0) {
                    if (!zIsEmpty) {
                        z4 = false;
                    }
                    if (zIsEmpty) {
                        submitTimeStr = str7;
                    }
                    if (j2 != 0) {
                        if (z4) {
                            j3 = 2048;
                        } else {
                            j3 = 1024;
                        }
                        j |= j3;
                    }
                    if (z4) {
                        i4 = -49859;
                    } else {
                        i4 = RunIndexRecordAdapter.O;
                    }
                } else {
                    i4 = 0;
                    submitTimeStr = null;
                }
                if ((j & 12) != 0) {
                    CommonBindingAdapter.e0(((WorksItemCommentBinding) this).f14522a, z);
                    aw9.d(((WorksItemCommentBinding) this).f14520a, avatar, false, null);
                    aw9.c(((WorksItemCommentBinding) this).f14520a, str, null);
                    CommonBindingAdapter.l0(this.f14528a, z2);
                    CommonBindingAdapter.l0(this.d, z);
                    CommonBindingAdapter.l0(((WorksItemCommentBinding) this).f14519a, z3);
                    zv9.h(((WorksItemCommentBinding) this).f14519a, charSequence, true);
                    TextViewBindingAdapter.setText(((WorksItemCommentBinding) this).b, str6);
                    TextViewBindingAdapter.setText(this.c, submitTimeStr);
                    this.c.setTextColor(i4);
                }
                if ((j & 15) != 0) {
                    zv9.b(((WorksItemCommentBinding) this).f14522a, i, Boolean.valueOf(liked), i2, str2, str3, str4, str5, i3);
                }
            }
            z4 = false;
            str7 = null;
            j2 = j & 12;
            if (j2 != 0) {
                if (!zIsEmpty) {
                    z4 = false;
                }
                if (zIsEmpty) {
                    submitTimeStr = str7;
                }
                if (j2 != 0) {
                    if (z4) {
                        j3 = 2048;
                    } else {
                        j3 = 1024;
                    }
                    j |= j3;
                }
                if (z4) {
                    i4 = -49859;
                } else {
                    i4 = RunIndexRecordAdapter.O;
                }
            } else {
                i4 = 0;
                submitTimeStr = null;
            }
            if ((j & 12) != 0) {
                CommonBindingAdapter.e0(((WorksItemCommentBinding) this).f14522a, z);
                aw9.d(((WorksItemCommentBinding) this).f14520a, avatar, false, null);
                aw9.c(((WorksItemCommentBinding) this).f14520a, str, null);
                CommonBindingAdapter.l0(this.f14528a, z2);
                CommonBindingAdapter.l0(this.d, z);
                CommonBindingAdapter.l0(((WorksItemCommentBinding) this).f14519a, z3);
                zv9.h(((WorksItemCommentBinding) this).f14519a, charSequence, true);
                TextViewBindingAdapter.setText(((WorksItemCommentBinding) this).b, str6);
                TextViewBindingAdapter.setText(this.c, submitTimeStr);
                this.c.setTextColor(i4);
            }
            if ((j & 15) != 0) {
                zv9.b(((WorksItemCommentBinding) this).f14522a, i, Boolean.valueOf(liked), i2, str2, str3, str4, str5, i3);
            }
        }
        z = false;
        liked = false;
        zIsEmpty = false;
        i = 0;
        i2 = 0;
        i3 = 0;
        z2 = false;
        z3 = false;
        str = null;
        avatar = null;
        str2 = null;
        str3 = null;
        str4 = null;
        str5 = null;
        str6 = null;
        charSequence = null;
        if ((64 & j) != 0) {
            submitTimeStr = null;
        } else {
            submitTimeStr = null;
        }
        if ((j & 160) != 0) {
            if (commentBean != null) {
                publishStatus = commentBean.getPublishStatus();
            } else {
                publishStatus = 0;
            }
            if ((32 & j) == 0) {
                z4 = false;
            } else {
                z4 = false;
            }
            j4 = 128 & j;
            if (j4 != 0) {
                if (publishStatus == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (j4 != 0) {
                    if (z5) {
                        j5 = 512;
                    } else {
                        j5 = 256;
                    }
                    j |= j5;
                }
                if (z5) {
                    str7 = "发送中…";
                } else {
                    str7 = "发送失败";
                }
            }
            j2 = j & 12;
            if (j2 != 0) {
                if (!zIsEmpty) {
                    z4 = false;
                }
                if (zIsEmpty) {
                    submitTimeStr = str7;
                }
                if (j2 != 0) {
                    if (z4) {
                        j3 = 2048;
                    } else {
                        j3 = 1024;
                    }
                    j |= j3;
                }
                if (z4) {
                    i4 = -49859;
                } else {
                    i4 = RunIndexRecordAdapter.O;
                }
            } else {
                i4 = 0;
                submitTimeStr = null;
            }
            if ((j & 12) != 0) {
                CommonBindingAdapter.e0(((WorksItemCommentBinding) this).f14522a, z);
                aw9.d(((WorksItemCommentBinding) this).f14520a, avatar, false, null);
                aw9.c(((WorksItemCommentBinding) this).f14520a, str, null);
                CommonBindingAdapter.l0(this.f14528a, z2);
                CommonBindingAdapter.l0(this.d, z);
                CommonBindingAdapter.l0(((WorksItemCommentBinding) this).f14519a, z3);
                zv9.h(((WorksItemCommentBinding) this).f14519a, charSequence, true);
                TextViewBindingAdapter.setText(((WorksItemCommentBinding) this).b, str6);
                TextViewBindingAdapter.setText(this.c, submitTimeStr);
                this.c.setTextColor(i4);
            }
            if ((j & 15) != 0) {
                zv9.b(((WorksItemCommentBinding) this).f14522a, i, Boolean.valueOf(liked), i2, str2, str3, str4, str5, i3);
            }
        }
        z4 = false;
        str7 = null;
        j2 = j & 12;
        if (j2 != 0) {
            if (!zIsEmpty) {
                z4 = false;
            }
            if (zIsEmpty) {
                submitTimeStr = str7;
            }
            if (j2 != 0) {
                if (z4) {
                    j3 = 2048;
                } else {
                    j3 = 1024;
                }
                j |= j3;
            }
            if (z4) {
                i4 = -49859;
            } else {
                i4 = RunIndexRecordAdapter.O;
            }
        } else {
            i4 = 0;
            submitTimeStr = null;
        }
        if ((j & 12) != 0) {
            CommonBindingAdapter.e0(((WorksItemCommentBinding) this).f14522a, z);
            aw9.d(((WorksItemCommentBinding) this).f14520a, avatar, false, null);
            aw9.c(((WorksItemCommentBinding) this).f14520a, str, null);
            CommonBindingAdapter.l0(this.f14528a, z2);
            CommonBindingAdapter.l0(this.d, z);
            CommonBindingAdapter.l0(((WorksItemCommentBinding) this).f14519a, z3);
            zv9.h(((WorksItemCommentBinding) this).f14519a, charSequence, true);
            TextViewBindingAdapter.setText(((WorksItemCommentBinding) this).b, str6);
            TextViewBindingAdapter.setText(this.c, submitTimeStr);
            this.c.setTextColor(i4);
        }
        if ((j & 15) != 0) {
            zv9.b(((WorksItemCommentBinding) this).f14522a, i, Boolean.valueOf(liked), i2, str2, str3, str4, str5, i3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14526a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14526a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemCommentBinding
    public void m(@Nullable CommentBean Bean) {
        ((WorksItemCommentBinding) this).f14521a = Bean;
        synchronized (this) {
            this.f14526a |= 4;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemCommentBinding
    public void n(@Nullable Integer CommentType) {
        ((WorksItemCommentBinding) this).f14523a = CommentType;
        synchronized (this) {
            this.f14526a |= 1;
        }
        notifyPropertyChanged(qk0.l);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemCommentBinding
    public void o(@Nullable Integer Source) {
        ((WorksItemCommentBinding) this).f14524b = Source;
        synchronized (this) {
            this.f14526a |= 2;
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
            m((CommentBean) variable);
        }
        return true;
    }

    public WorksItemCommentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLOperateAnimView) bindings[4], (AvatarView) bindings[1], (ImageView) bindings[8], (TextView) bindings[5], (TextView) bindings[2], (TextView) bindings[6]);
        this.f14526a = -1L;
        ((WorksItemCommentBinding) this).f14522a.setTag(null);
        ((WorksItemCommentBinding) this).f14520a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14527a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[3];
        this.f14528a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) bindings[7];
        this.d = textView;
        textView.setTag(null);
        ((WorksItemCommentBinding) this).f14519a.setTag(null);
        ((WorksItemCommentBinding) this).b.setTag(null);
        this.c.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
