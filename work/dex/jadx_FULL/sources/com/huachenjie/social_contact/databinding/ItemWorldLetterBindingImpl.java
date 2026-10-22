package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.NoticeBean;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemWorldLetterBindingImpl extends ItemWorldLetterBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13032a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f13034a;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36199a = sparseIntArray;
        sparseIntArray.put(R.id.rl_letter, 7);
        sparseIntArray.put(R.id.iv_world_letter, 8);
        sparseIntArray.put(R.id.llLetterTitle, 9);
        sparseIntArray.put(R.id.tvLookLetter, 10);
        sparseIntArray.put(R.id.tvAnnexName, 11);
        sparseIntArray.put(R.id.rlGift1, 12);
        sparseIntArray.put(R.id.ivIcon1, 13);
        sparseIntArray.put(R.id.ivGeneType1, 14);
        sparseIntArray.put(R.id.rlGift2, 15);
        sparseIntArray.put(R.id.ivIcon2, 16);
        sparseIntArray.put(R.id.ivGeneType2, 17);
        sparseIntArray.put(R.id.rlGift3, 18);
        sparseIntArray.put(R.id.ivIcon3, 19);
        sparseIntArray.put(R.id.ivGeneType3, 20);
        sparseIntArray.put(R.id.rlGift4, 21);
        sparseIntArray.put(R.id.ivIcon4, 22);
        sparseIntArray.put(R.id.ivGeneType4, 23);
    }

    public ItemWorldLetterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 24, f13032a, f36199a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String noticeTitle;
        String subContent;
        String noticeTime;
        int i;
        boolean receiveType;
        int readStatus;
        int messageType;
        synchronized (this) {
            j = this.f13033a;
            this.f13033a = 0L;
        }
        NoticeBean noticeBean = ((ItemWorldLetterBinding) this).f13022a;
        long j2 = j & 3;
        String str = null;
        int i2 = 0;
        if (j2 != 0) {
            if (noticeBean != null) {
                readStatus = noticeBean.getReadStatus();
                messageType = noticeBean.getMessageType();
                noticeTitle = noticeBean.getNoticeTitle();
                subContent = noticeBean.getSubContent();
                noticeTime = noticeBean.getNoticeTime();
                receiveType = noticeBean.getReceiveType();
            } else {
                noticeTitle = null;
                subContent = null;
                noticeTime = null;
                receiveType = false;
                readStatus = 0;
                messageType = 0;
            }
            if (j2 != 0) {
                j |= receiveType ? 32L : 16L;
            }
            boolean z = readStatus == 0;
            boolean z2 = messageType == 1;
            String str2 = receiveType ? "已领取" : "领取";
            if ((j & 3) != 0) {
                j |= z ? 8L : 4L;
            }
            if ((j & 3) != 0) {
                j |= z2 ? 128L : 64L;
            }
            int i3 = z ? 0 : 8;
            str = str2;
            i = z2 ? 0 : 8;
            i2 = i3;
        } else {
            noticeTitle = null;
            subContent = null;
            noticeTime = null;
            i = 0;
        }
        if ((3 & j) != 0) {
            this.f13034a.setVisibility(i2);
            TextViewBindingAdapter.setText(this.f, str);
            ((ItemWorldLetterBinding) this).f13023b.setVisibility(i);
            TextViewBindingAdapter.setText(((ItemWorldLetterBinding) this).f13025b, subContent);
            TextViewBindingAdapter.setText(((ItemWorldLetterBinding) this).f13027c, noticeTime);
            TextViewBindingAdapter.setText(((ItemWorldLetterBinding) this).f13029d, noticeTitle);
        }
        if ((j & 2) != 0) {
            View view = this.f13034a;
            DrawablesBindingAdapter.h(view, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(view, R.color.red)), 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13033a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13033a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemWorldLetterBinding
    public void k(@Nullable NoticeBean noticeBean) {
        ((ItemWorldLetterBinding) this).f13022a = noticeBean;
        synchronized (this) {
            this.f13033a |= 1;
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
        k((NoticeBean) obj);
        return true;
    }

    public ItemWorldLetterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[14], (ImageView) objArr[17], (ImageView) objArr[20], (ImageView) objArr[23], (ImageView) objArr[13], (ImageView) objArr[16], (ImageView) objArr[19], (ImageView) objArr[22], (ImageView) objArr[8], (LinearLayout) objArr[9], (RelativeLayout) objArr[12], (RelativeLayout) objArr[15], (RelativeLayout) objArr[18], (RelativeLayout) objArr[21], (RelativeLayout) objArr[7], (LinearLayout) objArr[5], (TextView) objArr[11], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[10]);
        this.f13033a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.c = linearLayout;
        linearLayout.setTag(null);
        View view2 = (View) objArr[1];
        this.f13034a = view2;
        view2.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.f = textView;
        textView.setTag(null);
        ((ItemWorldLetterBinding) this).f13023b.setTag(null);
        ((ItemWorldLetterBinding) this).f13025b.setTag(null);
        ((ItemWorldLetterBinding) this).f13027c.setTag(null);
        ((ItemWorldLetterBinding) this).f13029d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
