package com.huachenjie.channel.external.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelFragmentNotifyFansMenuBinding;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.dialog.NotifyFansMenuDialog;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.zj.adlib.dj1;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.iy5;
import com.zj.adlib.n0a;
import com.zj.adlib.tk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/huachenjie/channel/external/dialog/NotifyFansMenuDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentNotifyFansMenuBinding;", "Lcom/huachenjie/channel/external/dialog/NotifyFansMenuModel;", "", "", "", "getVariables", "getWidth", "getHeight", "getLayoutResID", "", "initData", "Lkotlin/Function1;", "", "onUnfollowFriendCallback", "Lkotlin/jvm/functions/Function1;", "getOnUnfollowFriendCallback", "()Lkotlin/jvm/functions/Function1;", "setOnUnfollowFriendCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/huachenjie/channel/external/bean/FansBean;", "fansBean$delegate", "Lkotlin/Lazy;", "getFansBean", "()Lcom/huachenjie/channel/external/bean/FansBean;", "fansBean", "<init>", "()V", "Companion", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class NotifyFansMenuDialog extends BaseMVVMBottomDialogFragment<ChannelFragmentNotifyFansMenuBinding, NotifyFansMenuModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String FANS_BEAN_KEY = "fans_bean";

    /* JADX INFO: renamed from: fansBean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fansBean = LazyKt.lazy(new Function0<FansBean>() { // from class: com.huachenjie.channel.external.dialog.NotifyFansMenuDialog$fansBean$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FansBean m243invoke() {
            Bundle arguments = this.this$0.getArguments();
            FansBean fansBean = arguments != null ? (FansBean) arguments.getParcelable("fans_bean") : null;
            return fansBean == null ? new FansBean(null, null, null, null, null, null, false, null, false, null, null, false, 4095, null) : fansBean;
        }
    });

    @Nullable
    private Function1<? super String, Unit> onUnfollowFriendCallback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/external/dialog/NotifyFansMenuDialog$a;", "", "Landroid/view/View;", "v", "", "c", "b", "d", "<init>", "(Lcom/huachenjie/channel/external/dialog/NotifyFansMenuDialog;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void e(NotifyFansMenuDialog notifyFansMenuDialog, View view) {
            String appUserCode;
            Intrinsics.checkNotNullParameter(notifyFansMenuDialog, "this$0");
            if (iy5.a(notifyFansMenuDialog.getContext()) == -1) {
                fv5.a(R.string.network_error_desc);
                return;
            }
            n0a.f43422a.F(notifyFansMenuDialog.getFansBean().getAppUserCode(), 3);
            Function1<String, Unit> onUnfollowFriendCallback = notifyFansMenuDialog.getOnUnfollowFriendCallback();
            if (onUnfollowFriendCallback != null) {
                FansBean value = NotifyFansMenuDialog.access$getMViewModel(notifyFansMenuDialog).i().getValue();
                if (value == null || (appUserCode = value.getAppUserCode()) == null) {
                    appUserCode = "";
                }
                onUnfollowFriendCallback.invoke(appUserCode);
            }
            notifyFansMenuDialog.dismiss();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            dj1.c0(NotifyFansMenuDialog.this.getFansBean().getAccid());
            NotifyFansMenuDialog.this.dismiss();
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            FansBean value = NotifyFansMenuDialog.access$getMViewModel(NotifyFansMenuDialog.this).i().getValue();
            boolean z = false;
            if (value != null && value.isAttentionPage()) {
                z = true;
            }
            if (z) {
                d();
            } else {
                ARouter.getInstance().build(RoutePathConstants.SocialContact.d).withString(UserConstants.CHAT_PARAMS.g, NotifyFansMenuDialog.this.getFansBean().getAppUserCode()).withInt(UserConstants.CHAT_PARAMS.e, 1).navigation();
                NotifyFansMenuDialog.this.dismiss();
            }
        }

        public final void d() {
            Context context = NotifyFansMenuDialog.this.getContext();
            Context context2 = NotifyFansMenuDialog.this.getContext();
            String string = context2 != null ? context2.getString(R.string.channel_fans_unfollow_message) : null;
            Context context3 = NotifyFansMenuDialog.this.getContext();
            String string2 = context3 != null ? context3.getString(R.string.channel_fans_unfollow_sure) : null;
            final NotifyFansMenuDialog notifyFansMenuDialog = NotifyFansMenuDialog.this;
            ft1.u(context, string, string2, new View.OnClickListener() { // from class: com.zj.adlib.j36
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotifyFansMenuDialog.a.e(notifyFansMenuDialog, view);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.external.dialog.NotifyFansMenuDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/external/dialog/NotifyFansMenuDialog$b;", "", "Lcom/huachenjie/channel/external/bean/FansBean;", "fansBean", "Lcom/huachenjie/channel/external/dialog/NotifyFansMenuDialog;", "a", "", "FANS_BEAN_KEY", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NotifyFansMenuDialog a(@NotNull FansBean fansBean) {
            Intrinsics.checkNotNullParameter(fansBean, "fansBean");
            NotifyFansMenuDialog notifyFansMenuDialog = new NotifyFansMenuDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(NotifyFansMenuDialog.FANS_BEAN_KEY, fansBean);
            notifyFansMenuDialog.setArguments(bundle);
            return notifyFansMenuDialog;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NotifyFansMenuModel access$getMViewModel(NotifyFansMenuDialog notifyFansMenuDialog) {
        return (NotifyFansMenuModel) notifyFansMenuDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FansBean getFansBean() {
        return (FansBean) this.fansBean.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_notify_fans_menu;
    }

    @Nullable
    public final Function1<String, Unit> getOnUnfollowFriendCallback() {
        return this.onUnfollowFriendCallback;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.k), new a()), TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        ((NotifyFansMenuModel) getMViewModel()).i().setValue(getFansBean());
    }

    public final void setOnUnfollowFriendCallback(@Nullable Function1<? super String, Unit> function1) {
        this.onUnfollowFriendCallback = function1;
    }
}
