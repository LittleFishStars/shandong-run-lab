package com.huachenjie.channel.external.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.huachenjie.channel.R;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.widget.FriendFollowButton;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.iy5;
import com.zj.adlib.n0a;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u001d\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001eB%\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002R.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/huachenjie/channel/external/widget/FriendFollowButton;", "Lcom/noober/background/view/BLTextView;", "", "e", "i", "f", y6b.f, "Lcom/huachenjie/channel/external/bean/FansBean;", "value", "a", "Lcom/huachenjie/channel/external/bean/FansBean;", "getFansBean", "()Lcom/huachenjie/channel/external/bean/FansBean;", "setFansBean", "(Lcom/huachenjie/channel/external/bean/FansBean;)V", "fansBean", "", "K", "I", "getSource", "()I", "setSource", "(I)V", "source", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFriendFollowButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FriendFollowButton.kt\ncom/huachenjie/channel/external/widget/FriendFollowButton\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,118:1\n177#2,2:119\n*S KotlinDebug\n*F\n+ 1 FriendFollowButton.kt\ncom/huachenjie/channel/external/widget/FriendFollowButton\n*L\n46#1:119,2\n*E\n"})
public final class FriendFollowButton extends BLTextView {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int source;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public FansBean fansBean;

    /* JADX WARN: Multi-variable type inference failed */
    public FriendFollowButton(@Nullable Context context) {
        super(context);
        setPadding(0, 0, 0, 0);
        setTextSize(12.0f);
        setTextColor(-1);
        setGravity(17);
        setMinHeight(0);
        setMinWidth(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vn3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendFollowButton.c(this.f45391a, view);
            }
        });
    }

    public static final void c(FriendFollowButton friendFollowButton, View view) {
        Intrinsics.checkNotNullParameter(friendFollowButton, "this$0");
        if (friendFollowButton.fansBean == null) {
            return;
        }
        friendFollowButton.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(FriendFollowButton friendFollowButton, View view) {
        Intrinsics.checkNotNullParameter(friendFollowButton, "this$0");
        if (iy5.a(friendFollowButton.getContext()) == -1) {
            fv5.a(R.string.network_error_desc);
            return;
        }
        n0a n0aVar = n0a.f43422a;
        FansBean fansBean = friendFollowButton.fansBean;
        Intrinsics.checkNotNull(fansBean);
        n0aVar.F(fansBean.getAppUserCode(), friendFollowButton.source);
        FansBean fansBean2 = friendFollowButton.fansBean;
        Intrinsics.checkNotNull(fansBean2);
        fansBean2.setEachFollow(false);
        friendFollowButton.i();
    }

    public final void e() {
        FansBean fansBean = this.fansBean;
        Intrinsics.checkNotNull(fansBean);
        if (fansBean.getEachFollow()) {
            g();
        } else {
            f();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        if (iy5.a(getContext()) == -1) {
            fv5.a(R.string.network_error_desc);
            return;
        }
        n0a n0aVar = n0a.f43422a;
        FansBean fansBean = this.fansBean;
        Intrinsics.checkNotNull(fansBean);
        n0aVar.b(fansBean.getAppUserCode(), this.source);
        FansBean fansBean2 = this.fansBean;
        Intrinsics.checkNotNull(fansBean2);
        fansBean2.setEachFollow(true);
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        ft1.u(getContext(), getContext().getString(R.string.channel_fans_unfollow_message), getContext().getString(R.string.channel_fans_unfollow_sure), new View.OnClickListener() { // from class: com.zj.adlib.wn3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendFollowButton.h(this.f45635a, view);
            }
        });
    }

    @Nullable
    public final FansBean getFansBean() {
        return this.fansBean;
    }

    public final int getSource() {
        return this.source;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        FansBean fansBean = this.fansBean;
        Intrinsics.checkNotNull(fansBean);
        setText(fansBean.getEachFollow() ? R.string.channel_notify_menu_follow : R.string.channel_notify_menu_unfollow);
        Drawable background = getBackground();
        GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        if (gradientDrawable != null) {
            Resources resources = getContext().getResources();
            FansBean fansBean2 = this.fansBean;
            Intrinsics.checkNotNull(fansBean2);
            gradientDrawable.setColor(resources.getColor(fansBean2.getEachFollow() ? R.color.color_c1c1c1 : R.color.color_650aec));
        }
    }

    public final void setFansBean(@Nullable FansBean fansBean) {
        this.fansBean = fansBean;
        if (fansBean != null) {
            fansBean.setEachFollow(n0a.f43422a.l(fansBean.getAppUserCode(), fansBean.getEachFollow()));
            i();
        }
    }

    public final void setSource(int i) {
        this.source = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendFollowButton(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setPadding(0, 0, 0, 0);
        setTextSize(12.0f);
        setTextColor(-1);
        setGravity(17);
        setMinHeight(0);
        setMinWidth(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vn3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendFollowButton.c(this.f45391a, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendFollowButton(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setPadding(0, 0, 0, 0);
        setTextSize(12.0f);
        setTextColor(-1);
        setGravity(17);
        setMinHeight(0);
        setMinWidth(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vn3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendFollowButton.c(this.f45391a, view);
            }
        });
    }
}
