package com.huachenjie.works.external.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.alibclinkpartner.smartlink.constants.ALPUserTrackConstant;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.widget.AttachListNoLinePopupView;
import com.huachenjie.works.R;
import com.huachenjie.works.external.dialog.AddFriendDialog;
import com.huachenjie.works.external.widget.UserLaoButton;
import com.huachenjie.works.external.widget.UserLaoButton.PersonUserLaoStyle;
import com.huachenjie.works.external.widget.UserLaoButton.PicDetailUserLaoStyle;
import com.huachenjie.works.external.widget.UserLaoButton.VideoDetailUserLaoStyle;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.FullScreenDialog;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.impl.AttachListPopupView;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.zj.adlib.dj1;
import com.zj.adlib.jj8;
import com.zj.adlib.n0a;
import com.zj.adlib.nc0;
import com.zj.adlib.r5a;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u0005\u0016;<=>B\u0011\b\u0016\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104B\u001b\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b3\u00107B#\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u00108\u001a\u00020\u0004¢\u0006\u0004\b3\u00109J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002R*\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u001dR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010\"\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010+\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010$\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b.\u0010/¨\u0006?"}, d2 = {"Lcom/huachenjie/works/external/widget/UserLaoButton;", "Landroid/widget/FrameLayout;", "Lcom/huachenjie/base/bean/UserInfoBean;", "userInfo", "", "buttonType", "source", "", "initLaoButton", "m", "i", "Lcom/zj/adlib/r5a$b;", ALPUserTrackConstant.METHOD_BUILD, "q", "Lcom/lxj/xpopup/impl/AttachListPopupView;", "p", "Lcom/lxj/xpopup/interfaces/OnSelectListener;", "n", y6b.f, "f", "", "value", "a", "Z", "getPersonBlackState", "()Z", "setPersonBlackState", "(Z)V", "personBlackState", "Lcom/huachenjie/base/bean/UserInfoBean;", "K", "I", "L", "b", "isFollowed", "Lcom/huachenjie/works/external/widget/UserLaoButton$UserLaoStyle;", "Lkotlin/Lazy;", "getUserLaoStyle", "()Lcom/huachenjie/works/external/widget/UserLaoButton$UserLaoStyle;", "userLaoStyle", "Landroid/widget/ImageView;", "getIvLao", "()Landroid/widget/ImageView;", "ivLao", "Landroid/widget/TextView;", "c", "getTvLao", "()Landroid/widget/TextView;", "tvLao", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "PersonUserLaoStyle", "PicDetailUserLaoStyle", "UserLaoStyle", "VideoDetailUserLaoStyle", "works_release"}, k = 1, mv = {1, 8, 0})
public final class UserLaoButton extends FrameLayout {
    public static final int BUTTON_TYPE_MINE = 3;
    public static final int BUTTON_TYPE_WORKS_PIC = 1;
    public static final int BUTTON_TYPE_WORKS_VIDEO = 2;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int buttonType;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int source;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public UserInfoBean userInfo;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy userLaoStyle;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean personBlackState;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy ivLao;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean isFollowed;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy tvLao;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R*\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0015\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/works/external/widget/UserLaoButton$PersonUserLaoStyle;", "Lcom/huachenjie/works/external/widget/UserLaoButton$UserLaoStyle;", "", "c", "a", "b", "", "value", "Z", "f", "()Z", y6b.f, "(Z)V", "personBlackState", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "e", "()Landroid/view/View;", "personBgViewNormal", "d", "personBgViewAttention", "<init>", "(Lcom/huachenjie/works/external/widget/UserLaoButton;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class PersonUserLaoStyle implements UserLaoStyle {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final Lazy personBgViewNormal;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        public boolean personBlackState;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final Lazy personBgViewAttention;

        public PersonUserLaoStyle() {
            this.personBgViewNormal = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$PersonUserLaoStyle$personBgViewNormal$2
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final View m821invoke() {
                    View viewInflate = LayoutInflater.from(userLaoButton.getContext()).inflate(R.layout.works_view_work_detail_person_lao, (ViewGroup) userLaoButton, false);
                    userLaoButton.addView(viewInflate, 0);
                    return viewInflate;
                }
            });
            this.personBgViewAttention = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$PersonUserLaoStyle$personBgViewAttention$2
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final View m820invoke() {
                    View viewInflate = LayoutInflater.from(userLaoButton.getContext()).inflate(R.layout.works_view_work_detail_video_person_lao_attention, (ViewGroup) userLaoButton, false);
                    userLaoButton.addView(viewInflate, 0);
                    return viewInflate;
                }
            });
        }

        @Override // com.huachenjie.works.external.widget.UserLaoButton.UserLaoStyle
        public void a() {
            UserLaoButton.this.getIvLao().setImageResource(R.drawable.ic_common_arrow_up_black_dp16);
        }

        @Override // com.huachenjie.works.external.widget.UserLaoButton.UserLaoStyle
        public void b() {
            if (UserLaoButton.this.isFollowed) {
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_attention_v2);
            } else {
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_normal_v2);
            }
        }

        @Override // com.huachenjie.works.external.widget.UserLaoButton.UserLaoStyle
        public void c() {
            if (!UserLaoButton.this.isFollowed) {
                d().setVisibility(8);
                e().setVisibility(0);
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_normal_v2);
                UserLaoButton.this.getTvLao().setTextColor(UserLaoButton.this.getResources().getColor(R.color.color_191F20));
                return;
            }
            d().setVisibility(0);
            e().setVisibility(8);
            UserLaoButton.this.getTvLao().setTextColor(UserLaoButton.this.getResources().getColor(R.color.color_191F20));
            UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_attention_v2);
            Drawable background = d().getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            if (this.personBlackState) {
                gradientDrawable.setStroke(jj8.a(1.0f), UserLaoButton.this.getResources().getColor(R.color.color_E8E8E8));
            } else {
                gradientDrawable.setStroke(jj8.a(0.0f), UserLaoButton.this.getResources().getColor(R.color.color_E8E8E8));
            }
            d().setBackground(gradientDrawable);
        }

        public final View d() {
            return (View) this.personBgViewAttention.getValue();
        }

        public final View e() {
            return (View) this.personBgViewNormal.getValue();
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final boolean getPersonBlackState() {
            return this.personBlackState;
        }

        public final void g(boolean z) {
            this.personBlackState = z;
            if (UserLaoButton.this.isFollowed) {
                c();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u001b\u0010\n\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tR#\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/works/external/widget/UserLaoButton$PicDetailUserLaoStyle;", "Lcom/huachenjie/works/external/widget/UserLaoButton$UserLaoStyle;", "", "c", "a", "b", "Landroid/view/View;", "Lkotlin/Lazy;", "e", "()Landroid/view/View;", "picBgViewNormal", "kotlin.jvm.PlatformType", "d", "picBgViewAttention", "<init>", "(Lcom/huachenjie/works/external/widget/UserLaoButton;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class PicDetailUserLaoStyle implements UserLaoStyle {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final Lazy picBgViewNormal;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final Lazy picBgViewAttention;

        public PicDetailUserLaoStyle() {
            this.picBgViewNormal = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$PicDetailUserLaoStyle$picBgViewNormal$2
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final View m823invoke() {
                    View viewInflate = LayoutInflater.from(userLaoButton.getContext()).inflate(R.layout.works_view_work_detail_pic_lao, (ViewGroup) userLaoButton, false);
                    userLaoButton.addView(viewInflate, 0);
                    return viewInflate;
                }
            });
            this.picBgViewAttention = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$PicDetailUserLaoStyle$picBgViewAttention$2
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final View m822invoke() {
                    View viewInflate = LayoutInflater.from(userLaoButton.getContext()).inflate(R.layout.works_view_work_detail_pic_lao_attention, (ViewGroup) userLaoButton, false);
                    userLaoButton.addView(viewInflate, 0);
                    return viewInflate;
                }
            });
        }

        @Override // com.huachenjie.works.external.widget.UserLaoButton.UserLaoStyle
        public void a() {
            if (UserLaoButton.this.isFollowed) {
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.ic_common_arrow_up_purple_dp16);
            } else {
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.ic_common_arrow_up_white_dp16);
            }
        }

        @Override // com.huachenjie.works.external.widget.UserLaoButton.UserLaoStyle
        public void b() {
            if (UserLaoButton.this.isFollowed) {
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_attention);
            } else {
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_normal);
            }
        }

        @Override // com.huachenjie.works.external.widget.UserLaoButton.UserLaoStyle
        public void c() {
            if (UserLaoButton.this.isFollowed) {
                d().setVisibility(0);
                e().setVisibility(8);
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_attention);
                UserLaoButton.this.getTvLao().setTextColor(UserLaoButton.this.getResources().getColor(R.color.color_650aec));
                return;
            }
            d().setVisibility(8);
            e().setVisibility(0);
            UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_normal);
            UserLaoButton.this.getTvLao().setTextColor(UserLaoButton.this.getResources().getColor(R.color.white));
        }

        public final View d() {
            return (View) this.picBgViewAttention.getValue();
        }

        public final View e() {
            Object value = this.picBgViewNormal.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-picBgViewNormal>(...)");
            return (View) value;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/works/external/widget/UserLaoButton$UserLaoStyle;", "", "", "c", "a", "b", "works_release"}, k = 1, mv = {1, 8, 0})
    public interface UserLaoStyle {
        void a();

        void b();

        void c();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R#\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/works/external/widget/UserLaoButton$VideoDetailUserLaoStyle;", "Lcom/huachenjie/works/external/widget/UserLaoButton$UserLaoStyle;", "", "c", "a", "b", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "e", "()Landroid/view/View;", "videoBgViewNormal", "d", "videoBgViewAttention", "<init>", "(Lcom/huachenjie/works/external/widget/UserLaoButton;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class VideoDetailUserLaoStyle implements UserLaoStyle {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final Lazy videoBgViewNormal;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final Lazy videoBgViewAttention;

        public VideoDetailUserLaoStyle() {
            this.videoBgViewNormal = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$VideoDetailUserLaoStyle$videoBgViewNormal$2
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final View m825invoke() {
                    View viewInflate = LayoutInflater.from(userLaoButton.getContext()).inflate(R.layout.works_view_work_detail_video_lao, (ViewGroup) userLaoButton, false);
                    userLaoButton.addView(viewInflate, 0);
                    return viewInflate;
                }
            });
            this.videoBgViewAttention = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$VideoDetailUserLaoStyle$videoBgViewAttention$2
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final View m824invoke() {
                    View viewInflate = LayoutInflater.from(userLaoButton.getContext()).inflate(R.layout.works_view_work_detail_video_lao_attention, (ViewGroup) userLaoButton, false);
                    userLaoButton.addView(viewInflate, 0);
                    return viewInflate;
                }
            });
        }

        @Override // com.huachenjie.works.external.widget.UserLaoButton.UserLaoStyle
        public void a() {
            UserLaoButton.this.getIvLao().setImageResource(R.drawable.ic_common_arrow_up_white_dp16);
        }

        @Override // com.huachenjie.works.external.widget.UserLaoButton.UserLaoStyle
        public void b() {
            if (UserLaoButton.this.isFollowed) {
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_video_attention);
            } else {
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_normal);
            }
        }

        @Override // com.huachenjie.works.external.widget.UserLaoButton.UserLaoStyle
        public void c() {
            if (UserLaoButton.this.isFollowed) {
                d().setVisibility(0);
                e().setVisibility(8);
                UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_video_attention);
                UserLaoButton.this.getTvLao().setTextSize(12.0f);
                return;
            }
            d().setVisibility(8);
            e().setVisibility(0);
            UserLaoButton.this.getIvLao().setImageResource(R.drawable.works_ic_user_menu_pic_normal);
            UserLaoButton.this.getTvLao().setTextSize(14.0f);
        }

        public final View d() {
            return (View) this.videoBgViewAttention.getValue();
        }

        public final View e() {
            return (View) this.videoBgViewNormal.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserLaoButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.userLaoStyle = LazyKt.lazy(new Function0<UserLaoStyle>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$userLaoStyle$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final UserLaoButton.UserLaoStyle m828invoke() {
                int i = this.this$0.buttonType;
                if (i == 1) {
                    return this.this$0.new PicDetailUserLaoStyle();
                }
                if (i != 2) {
                    return i != 3 ? this.this$0.new PicDetailUserLaoStyle() : this.this$0.new PersonUserLaoStyle();
                }
                return this.this$0.new VideoDetailUserLaoStyle();
            }
        });
        this.ivLao = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$ivLao$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m826invoke() {
                ImageView imageView = new ImageView(this.this$0.getContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                return imageView;
            }
        });
        this.tvLao = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$tvLao$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m827invoke() {
                TextView textView = new TextView(this.this$0.getContext());
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMarginStart(jj8.a(4.0f));
                textView.setLayoutParams(marginLayoutParams);
                textView.setText(textView.getContext().getString(R.string.works_detail_lao));
                textView.setTextColor(-1);
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextSize(14.0f);
                return textView;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getIvLao() {
        return (ImageView) this.ivLao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvLao() {
        return (TextView) this.tvLao.getValue();
    }

    private final UserLaoStyle getUserLaoStyle() {
        return (UserLaoStyle) this.userLaoStyle.getValue();
    }

    public static final void h(UserLaoButton userLaoButton) {
        Intrinsics.checkNotNullParameter(userLaoButton, "this$0");
        userLaoButton.m();
        userLaoButton.i();
    }

    public static final void j(final UserLaoButton userLaoButton, View view) {
        Intrinsics.checkNotNullParameter(userLaoButton, "this$0");
        r5a.m(0);
        userLaoButton.getUserLaoStyle().a();
        userLaoButton.getTvLao().setVisibility(8);
        r5a.b bVarB0 = new r5a.b(userLaoButton.getContext()).J(jj8.a(8.0f)).F(view).b0(userLaoButton.buttonType == 1);
        Intrinsics.checkNotNullExpressionValue(bVarB0, ALPUserTrackConstant.METHOD_BUILD);
        userLaoButton.q(bVarB0);
        final AttachListNoLinePopupView attachListNoLinePopupViewShow = userLaoButton.p(bVarB0).show();
        if (userLaoButton.buttonType == 3 && userLaoButton.isFollowed && (attachListNoLinePopupViewShow instanceof AttachListNoLinePopupView)) {
            AttachListNoLinePopupView attachListNoLinePopupView = attachListNoLinePopupViewShow;
            UserInfoBean userInfoBean = userLaoButton.userInfo;
            if (userInfoBean == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userInfo");
                userInfoBean = null;
            }
            attachListNoLinePopupView.updateItemTvColor(!userInfoBean.getFriendFlag() ? 1 : 0, userLaoButton.getResources().getColor(R.color.color_979A9A));
        }
        userLaoButton.post(new Runnable() { // from class: com.zj.adlib.ki9
            @Override // java.lang.Runnable
            public final void run() {
                UserLaoButton.k(attachListNoLinePopupViewShow, userLaoButton);
            }
        });
    }

    public static final void k(BasePopupView basePopupView, final UserLaoButton userLaoButton) {
        Intrinsics.checkNotNullParameter(userLaoButton, "this$0");
        FullScreenDialog fullScreenDialog = basePopupView.dialog;
        if (fullScreenDialog != null) {
            fullScreenDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zj.adlib.ji9
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    UserLaoButton.l(this.f42595a, dialogInterface);
                }
            });
        }
    }

    public static final void l(UserLaoButton userLaoButton, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(userLaoButton, "this$0");
        userLaoButton.getTvLao().setVisibility(0);
        userLaoButton.getUserLaoStyle().b();
    }

    public static final void o(UserLaoButton userLaoButton, int i, String str) {
        Intrinsics.checkNotNullParameter(userLaoButton, "this$0");
        if (userLaoButton.buttonType == 3) {
            UserInfoBean userInfoBean = userLaoButton.userInfo;
            UserInfoBean userInfoBean2 = null;
            if (userInfoBean == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userInfo");
                userInfoBean = null;
            }
            if (!userInfoBean.getFriendFlag()) {
                if (i != 0) {
                    if (i != 1) {
                        userLaoButton.f();
                        return;
                    } else {
                        userLaoButton.g();
                        return;
                    }
                }
                UserInfoBean userInfoBean3 = userLaoButton.userInfo;
                if (userInfoBean3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfo");
                    userInfoBean3 = null;
                }
                if (userInfoBean3.getHasAppliedFriend()) {
                    return;
                }
                Context context = userLaoButton.getContext();
                UserInfoBean userInfoBean4 = userLaoButton.userInfo;
                if (userInfoBean4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfo");
                } else {
                    userInfoBean2 = userInfoBean4;
                }
                new AddFriendDialog(context, userInfoBean2).show();
                return;
            }
        }
        if (i == 0) {
            userLaoButton.g();
        } else {
            userLaoButton.f();
        }
    }

    public final void f() {
        UserInfoBean userInfoBean = this.userInfo;
        if (userInfoBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userInfo");
            userInfoBean = null;
        }
        dj1.c0(userInfoBean.getAccId());
    }

    public final void g() {
        boolean z = !this.isFollowed;
        this.isFollowed = z;
        UserInfoBean userInfoBean = null;
        if (z) {
            n0a n0aVar = n0a.f43422a;
            UserInfoBean userInfoBean2 = this.userInfo;
            if (userInfoBean2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userInfo");
            } else {
                userInfoBean = userInfoBean2;
            }
            n0aVar.b(userInfoBean.getAppUserCode(), this.source);
        } else {
            n0a n0aVar2 = n0a.f43422a;
            UserInfoBean userInfoBean3 = this.userInfo;
            if (userInfoBean3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userInfo");
            } else {
                userInfoBean = userInfoBean3;
            }
            n0aVar2.F(userInfoBean.getAppUserCode(), this.source);
        }
        getUserLaoStyle().c();
        getTvLao().setVisibility(0);
    }

    public final boolean getPersonBlackState() {
        return this.personBlackState;
    }

    public final void i() {
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.li9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserLaoButton.j(this.f43075a, view);
            }
        });
    }

    public final void initLaoButton(@NotNull UserInfoBean userInfo, int buttonType, int source) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        this.userInfo = userInfo;
        if (this.buttonType <= 0) {
            boolean z = true;
            if (buttonType < 1 || buttonType > 3) {
                return;
            }
            this.buttonType = buttonType;
            this.source = source;
            n0a n0aVar = n0a.f43422a;
            String appUserCode = userInfo.getAppUserCode();
            if (userInfo.getRelation() != 2 && userInfo.getRelation() != 3) {
                z = false;
            }
            this.isFollowed = n0aVar.l(appUserCode, z);
            post(new Runnable() { // from class: com.zj.adlib.hi9
                @Override // java.lang.Runnable
                public final void run() {
                    UserLaoButton.h(this.f42132a);
                }
            });
        }
    }

    public final void m() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(jj8.a(58.0f), jj8.a(28.0f));
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(getIvLao());
        linearLayout.addView(getTvLao());
        getUserLaoStyle().c();
    }

    public final OnSelectListener n() {
        return new OnSelectListener() { // from class: com.zj.adlib.ii9
            public final void a(int i, String str) {
                UserLaoButton.o(this.f42365a, i, str);
            }
        };
    }

    public final AttachListPopupView p(r5a.b build) {
        Object[] objArr;
        if (this.buttonType != 3) {
            String[] strArr = new String[2];
            strArr[0] = getContext().getString(this.isFollowed ? R.string.works_detail_lao_attentioned : R.string.works_detail_lao_attention);
            strArr[1] = getContext().getString(R.string.works_detail_lao_send);
            int[] iArr = new int[2];
            iArr[0] = this.isFollowed ? R.drawable.works_ic_user_pop_attentioned : R.drawable.works_ic_user_pop_attention;
            iArr[1] = R.drawable.works_ic_user_pop_message;
            return nc0.a(build, strArr, iArr, n());
        }
        UserInfoBean userInfoBean = this.userInfo;
        UserInfoBean userInfoBean2 = null;
        if (userInfoBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userInfo");
            userInfoBean = null;
        }
        if (userInfoBean.getFriendFlag()) {
            objArr = new Object[2];
            String[] strArr2 = new String[2];
            strArr2[0] = getContext().getString(this.isFollowed ? R.string.works_detail_lao_attentioned : R.string.works_detail_lao_attention);
            strArr2[1] = getContext().getString(R.string.works_detail_lao_send);
            objArr[0] = strArr2;
            int[] iArr2 = new int[2];
            iArr2[0] = this.isFollowed ? R.drawable.works_ic_user_pop_attentioned_v2 : R.drawable.works_ic_user_pop_attention_v2;
            iArr2[1] = R.drawable.works_ic_user_pop_message_v2;
            objArr[1] = iArr2;
        } else {
            objArr = new Object[2];
            String[] strArr3 = new String[3];
            Context context = getContext();
            UserInfoBean userInfoBean3 = this.userInfo;
            if (userInfoBean3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userInfo");
            } else {
                userInfoBean2 = userInfoBean3;
            }
            strArr3[0] = context.getString(userInfoBean2.getHasAppliedFriend() ? R.string.works_detail_lao_friend_applied : R.string.works_detail_lao_friend);
            strArr3[1] = getContext().getString(this.isFollowed ? R.string.works_detail_lao_attentioned : R.string.works_detail_lao_attention);
            strArr3[2] = getContext().getString(R.string.works_detail_lao_send);
            objArr[0] = strArr3;
            int[] iArr3 = new int[3];
            iArr3[0] = R.drawable.works_ic_add_friend_v2;
            iArr3[1] = this.isFollowed ? R.drawable.works_ic_user_pop_attentioned_v2 : R.drawable.works_ic_user_pop_attention_v2;
            iArr3[2] = R.drawable.works_ic_user_pop_message_v2;
            objArr[1] = iArr3;
        }
        Object obj = objArr[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String?>");
        Object obj2 = objArr[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.IntArray");
        return nc0.a(build, (String[]) obj, (int[]) obj2, n());
    }

    public final void q(r5a.b build) {
        build.q0(this.buttonType == 2 ? PopupPosition.Top : PopupPosition.Bottom).n0(jj8.a((this.buttonType == 2 ? 0.0f : 13.0f) + 2.0f));
    }

    public final void setPersonBlackState(boolean z) {
        if (this.personBlackState != z && this.buttonType == 3) {
            UserLaoStyle userLaoStyle = getUserLaoStyle();
            Intrinsics.checkNotNull(userLaoStyle, "null cannot be cast to non-null type com.huachenjie.works.external.widget.UserLaoButton.PersonUserLaoStyle");
            ((PersonUserLaoStyle) userLaoStyle).g(z);
        }
        this.personBlackState = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserLaoButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.userLaoStyle = LazyKt.lazy(new Function0<UserLaoStyle>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$userLaoStyle$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final UserLaoButton.UserLaoStyle m828invoke() {
                int i = this.this$0.buttonType;
                if (i == 1) {
                    return this.this$0.new PicDetailUserLaoStyle();
                }
                if (i != 2) {
                    return i != 3 ? this.this$0.new PicDetailUserLaoStyle() : this.this$0.new PersonUserLaoStyle();
                }
                return this.this$0.new VideoDetailUserLaoStyle();
            }
        });
        this.ivLao = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$ivLao$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m826invoke() {
                ImageView imageView = new ImageView(this.this$0.getContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                return imageView;
            }
        });
        this.tvLao = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$tvLao$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m827invoke() {
                TextView textView = new TextView(this.this$0.getContext());
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMarginStart(jj8.a(4.0f));
                textView.setLayoutParams(marginLayoutParams);
                textView.setText(textView.getContext().getString(R.string.works_detail_lao));
                textView.setTextColor(-1);
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextSize(14.0f);
                return textView;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserLaoButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.userLaoStyle = LazyKt.lazy(new Function0<UserLaoStyle>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$userLaoStyle$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final UserLaoButton.UserLaoStyle m828invoke() {
                int i2 = this.this$0.buttonType;
                if (i2 == 1) {
                    return this.this$0.new PicDetailUserLaoStyle();
                }
                if (i2 != 2) {
                    return i2 != 3 ? this.this$0.new PicDetailUserLaoStyle() : this.this$0.new PersonUserLaoStyle();
                }
                return this.this$0.new VideoDetailUserLaoStyle();
            }
        });
        this.ivLao = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$ivLao$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m826invoke() {
                ImageView imageView = new ImageView(this.this$0.getContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                return imageView;
            }
        });
        this.tvLao = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.works.external.widget.UserLaoButton$tvLao$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m827invoke() {
                TextView textView = new TextView(this.this$0.getContext());
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMarginStart(jj8.a(4.0f));
                textView.setLayoutParams(marginLayoutParams);
                textView.setText(textView.getContext().getString(R.string.works_detail_lao));
                textView.setTextColor(-1);
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextSize(14.0f);
                return textView;
            }
        });
    }
}
