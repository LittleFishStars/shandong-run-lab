package com.huachenjie.channel.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.TopicMainBean;
import com.huachenjie.channel.page.topic_main.TopicMainActivity;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelViewTopicMainHeaderBindingImpl extends ChannelViewTopicMainHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8261a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f8265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8266a;

    @NonNull
    public final ImageView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TopicMainActivity.a f33346a;

        public a a(TopicMainActivity.a aVar) {
            this.f33346a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33346a.d(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TopicMainActivity.a f33347a;

        public b a(TopicMainActivity.a aVar) {
            this.f33347a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33347a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33345a = sparseIntArray;
        sparseIntArray.put(R.id.v_line_horizontal, 13);
        sparseIntArray.put(R.id.tv_hot_title, 14);
    }

    public ChannelViewTopicMainHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, f8261a, f33345a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        String str;
        Drawable drawable2;
        boolean z;
        boolean z2;
        String str2;
        RequestOptions requestOptions;
        String str3;
        boolean z3;
        String str4;
        RequestOptions requestOptions2;
        String str5;
        String str6;
        boolean z4;
        String str7;
        String str8;
        String str9;
        boolean z5;
        Object drawable3;
        boolean z6;
        b bVar;
        a aVarA;
        Object obj;
        int worksCount;
        boolean joinFlag;
        String avatar3;
        String subjectName;
        String popularityValue;
        String avatar2;
        String avatar1;
        List<String> avatarList;
        String subjectUserValue;
        String subjectImg;
        String channelName;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f8262a;
            this.f8262a = 0L;
        }
        Integer num = ((ChannelViewTopicMainHeaderBinding) this).f8257a;
        TopicMainBean topicMainBean = ((ChannelViewTopicMainHeaderBinding) this).f8253a;
        TopicMainActivity.a aVar = ((ChannelViewTopicMainHeaderBinding) this).f8254a;
        long j4 = j & 10;
        if (j4 != 0) {
            RequestOptions requestOptions3 = ju3.b;
            RequestOptions requestOptions4 = ju3.h;
            if (topicMainBean != null) {
                subjectName = topicMainBean.getSubjectName();
                popularityValue = topicMainBean.getPopularityValue();
                avatar2 = topicMainBean.getAvatar2();
                avatar1 = topicMainBean.getAvatar1();
                avatarList = topicMainBean.getAvatarList();
                subjectUserValue = topicMainBean.getSubjectUserValue();
                worksCount = topicMainBean.getWorksCount();
                joinFlag = topicMainBean.getJoinFlag();
                subjectImg = topicMainBean.getSubjectImg();
                channelName = topicMainBean.getChannelName();
                avatar3 = topicMainBean.getAvatar3();
            } else {
                worksCount = 0;
                joinFlag = false;
                avatar3 = null;
                subjectName = null;
                popularityValue = null;
                avatar2 = null;
                avatar1 = null;
                avatarList = null;
                subjectUserValue = null;
                subjectImg = null;
                channelName = null;
            }
            if (j4 != 0) {
                if (joinFlag) {
                    j2 = j | 32 | 128;
                    j3 = 512;
                } else {
                    j2 = j | 16 | 64;
                    j3 = 256;
                }
                j = j2 | j3;
            }
            String str10 = String.format("#%s", subjectName);
            String str11 = String.format(((ChannelViewTopicMainHeaderBinding) this).f8258b.getResources().getString(R.string.channel_my_channel_hot), popularityValue);
            boolean z7 = avatar2 != null;
            boolean z8 = avatar1 != null;
            String str12 = String.format(this.e.getResources().getString(R.string.channel_main_user_num), subjectUserValue);
            String str13 = String.format(this.f8266a.getResources().getString(R.string.channel_topic_main_count), Integer.valueOf(worksCount));
            String string = ((ChannelViewTopicMainHeaderBinding) this).f8255a.getResources().getString(joinFlag ? R.string.channel_topic_main_has_follow : R.string.channel_topic_main_un_follow);
            Drawable drawable4 = joinFlag ? AppCompatResources.getDrawable(((ChannelViewTopicMainHeaderBinding) this).f8255a.getContext(), R.drawable.channel_ic_channel_main_has_add) : AppCompatResources.getDrawable(((ChannelViewTopicMainHeaderBinding) this).f8255a.getContext(), R.drawable.channel_ic_channel_main_un_add);
            Drawable drawable5 = joinFlag ? AppCompatResources.getDrawable(((ChannelViewTopicMainHeaderBinding) this).f8255a.getContext(), R.drawable.channel_bg_join_channel) : AppCompatResources.getDrawable(((ChannelViewTopicMainHeaderBinding) this).f8255a.getContext(), R.drawable.channel_bg_un_join_channel);
            boolean zIsEmpty = TextUtils.isEmpty(subjectImg);
            Drawable drawable6 = drawable5;
            String str14 = String.format(((ChannelViewTopicMainHeaderBinding) this).f8252a.getResources().getString(R.string.channel_topic_main_from), channelName);
            boolean zIsEmpty2 = TextUtils.isEmpty(channelName);
            boolean z9 = avatar3 != null;
            if ((j & 10) != 0) {
                j |= zIsEmpty ? 2048L : 1024L;
            }
            boolean z10 = !zIsEmpty2;
            boolean z11 = (avatarList != null ? avatarList.size() : 0) > 0;
            z6 = z10;
            z4 = zIsEmpty;
            str3 = avatar2;
            str = avatar1;
            str6 = str10;
            drawable3 = subjectImg;
            str5 = str12;
            str8 = str14;
            z5 = z11;
            drawable = drawable4;
            str7 = str11;
            str9 = str13;
            z2 = z9;
            z = z8;
            requestOptions2 = requestOptions3;
            z3 = z7;
            str2 = avatar3;
            drawable2 = drawable6;
            str4 = string;
            requestOptions = requestOptions4;
        } else {
            drawable = null;
            str = null;
            drawable2 = null;
            z = false;
            z2 = false;
            str2 = null;
            requestOptions = null;
            str3 = null;
            z3 = false;
            str4 = null;
            requestOptions2 = null;
            str5 = null;
            str6 = null;
            z4 = false;
            str7 = null;
            str8 = null;
            str9 = null;
            z5 = false;
            drawable3 = null;
            z6 = false;
        }
        long j5 = j & 9;
        int iSafeUnbox = j5 != 0 ? ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(num) + 75)) : 0;
        long j6 = j & 12;
        if (j6 == 0 || aVar == null) {
            bVar = null;
            aVarA = null;
        } else {
            b bVar2 = this.f8265a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f8265a = bVar2;
            }
            b bVarA = bVar2.a(aVar);
            a aVar2 = this.f8264a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8264a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            bVar = bVarA;
        }
        long j7 = j & 10;
        if (j7 != 0) {
            if (z4) {
                drawable3 = AppCompatResources.getDrawable(((ChannelViewTopicMainHeaderBinding) this).f8251a.getContext(), R.drawable.base_bg_channel_main_head);
            }
            obj = drawable3;
        } else {
            bVar = bVar;
            obj = null;
        }
        if (j7 != 0) {
            ViewBindingAdapter.setBackground(((ChannelViewTopicMainHeaderBinding) this).f8255a, drawable2);
            TextViewBindingAdapter.setDrawableStart(((ChannelViewTopicMainHeaderBinding) this).f8255a, drawable);
            TextViewBindingAdapter.setText(((ChannelViewTopicMainHeaderBinding) this).f8255a, str4);
            CommonBindingAdapter.b0(((ChannelViewTopicMainHeaderBinding) this).f8251a, obj, requestOptions, false);
            CommonBindingAdapter.l0(((ChannelViewTopicMainHeaderBinding) this).f8256a, z);
            CommonBindingAdapter.b0(((ChannelViewTopicMainHeaderBinding) this).f8256a, str, requestOptions2, false);
            CommonBindingAdapter.l0(((ChannelViewTopicMainHeaderBinding) this).f8259b, z3);
            CommonBindingAdapter.b0(((ChannelViewTopicMainHeaderBinding) this).f8259b, str3, requestOptions2, false);
            CommonBindingAdapter.l0(((ChannelViewTopicMainHeaderBinding) this).f8260c, z2);
            CommonBindingAdapter.b0(((ChannelViewTopicMainHeaderBinding) this).f8260c, str2, requestOptions2, false);
            boolean z12 = z5;
            CommonBindingAdapter.l0(this.b, z12);
            TextViewBindingAdapter.setText(this.f8266a, str9);
            TextViewBindingAdapter.setText(((ChannelViewTopicMainHeaderBinding) this).f8252a, str8);
            CommonBindingAdapter.i(((ChannelViewTopicMainHeaderBinding) this).f8252a, z6);
            TextViewBindingAdapter.setText(((ChannelViewTopicMainHeaderBinding) this).f8258b, str7);
            TextViewBindingAdapter.setText(this.d, str6);
            CommonBindingAdapter.l0(this.e, z12);
            TextViewBindingAdapter.setText(this.e, str5);
            CommonBindingAdapter.l0(((ChannelViewTopicMainHeaderBinding) this).b, z12);
        }
        if (j6 != 0) {
            CommonBindingAdapter.q(((ChannelViewTopicMainHeaderBinding) this).f8255a, aVarA, null);
            b bVar3 = bVar;
            CommonBindingAdapter.q(this.b, bVar3, null);
            CommonBindingAdapter.q(this.e, bVar3, null);
        }
        if (j5 != 0) {
            CommonBindingAdapter.I(this.d, 0, iSafeUnbox, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8262a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8262a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewTopicMainHeaderBinding
    public void m(@Nullable TopicMainBean topicMainBean) {
        ((ChannelViewTopicMainHeaderBinding) this).f8253a = topicMainBean;
        synchronized (this) {
            this.f8262a |= 2;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewTopicMainHeaderBinding
    public void n(@Nullable TopicMainActivity.a aVar) {
        ((ChannelViewTopicMainHeaderBinding) this).f8254a = aVar;
        synchronized (this) {
            this.f8262a |= 4;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewTopicMainHeaderBinding
    public void o(@Nullable Integer num) {
        ((ChannelViewTopicMainHeaderBinding) this).f8257a = num;
        synchronized (this) {
            this.f8262a |= 1;
        }
        notifyPropertyChanged(tk0.g0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.g0 == i) {
            o((Integer) obj);
        } else if (tk0.g == i) {
            m((TopicMainBean) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            n((TopicMainActivity.a) obj);
        }
        return true;
    }

    public ChannelViewTopicMainHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (DrawableCenterButton) objArr[11], (ImageView) objArr[1], (BLImageView) objArr[6], (BLImageView) objArr[7], (BLImageView) objArr[8], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[14], (TextView) objArr[2], (TextView) objArr[9], (View) objArr[13], (View) objArr[5]);
        this.f8262a = -1L;
        ((ChannelViewTopicMainHeaderBinding) this).f8255a.setTag(null);
        ((ChannelViewTopicMainHeaderBinding) this).f8251a.setTag(null);
        ((ChannelViewTopicMainHeaderBinding) this).f8256a.setTag(null);
        ((ChannelViewTopicMainHeaderBinding) this).f8259b.setTag(null);
        ((ChannelViewTopicMainHeaderBinding) this).f8260c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8263a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[10];
        this.b = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[12];
        this.f8266a = bLTextView;
        bLTextView.setTag(null);
        ((ChannelViewTopicMainHeaderBinding) this).f8252a.setTag(null);
        ((ChannelViewTopicMainHeaderBinding) this).f8258b.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        ((ChannelViewTopicMainHeaderBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
