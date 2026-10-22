package com.huachenjie.works.page.share;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.LifecycleOwnerKt;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.ChatTeamBean;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.databinding.WorksDialogShareWorkBinding;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.share.ShareWorksDialog;
import com.huachenjie.works.page.share.choose_friend.ChooseFriendDialog;
import com.huachenjie.works.page.share.choose_team.ChooseTeamDialog;
import com.huachenjie.works.page.share.enums.ExtendEvents;
import com.igexin.push.g.o;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.ai9;
import com.zj.adlib.dj1;
import com.zj.adlib.fv5;
import com.zj.adlib.jo2;
import com.zj.adlib.qk0;
import com.zj.adlib.v41;
import com.zj.adlib.y88;
import huachenjie.sdk.share.FlavourName;
import huachenjie.sdk.share.ShareListener;
import huachenjie.sdk.share.sharebody.SharedBody;
import huachenjie.sdk.share.sharebody.WebPageBody;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000201B\u0007¢\u0006\u0004\b-\u0010.J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0019\u001a\u00020\bR\u001b\u0010\u001e\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001b\u0010&\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\"R\u001b\u0010)\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\"R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/huachenjie/works/page/share/ShareWorksDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogShareWorkBinding;", "Lcom/huachenjie/works/page/share/ShareWorksVM;", "", "viewId", "Lhuachenjie/sdk/share/FlavourName;", "flavourName", "", "initShareStatus", "visible", "setViewVisibility", "clickShare", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initView", "initDataObserve", "shareType", "", "targetNo", "onShareSuccess", "showShareSuccess", "shareCoverUrl$delegate", "Lkotlin/Lazy;", "getShareCoverUrl", "()Ljava/lang/String;", ShareWorksDialog.SHARE_COVER_URL, "", "shareWork$delegate", "getShareWork", "()Z", ShareWorksDialog.SHARE_WORK, "shareThird$delegate", "getShareThird", ShareWorksDialog.SHARE_THIRD, "sharePoster$delegate", "getSharePoster", ShareWorksDialog.SHARE_POSTER, "Lcom/huachenjie/works/page/share/OnShareCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/works/page/share/OnShareCallback;", "<init>", "()V", "Companion", "a", "b", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ShareWorksDialog extends BaseMVVMBottomDialogFragment<WorksDialogShareWorkBinding, ShareWorksVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SHARE_COVER_URL = "shareCoverUrl";

    @NotNull
    public static final String SHARE_POSTER = "sharePoster";

    @NotNull
    public static final String SHARE_THIRD = "shareThird";

    @NotNull
    public static final String SHARE_WORK = "shareWork";

    @Nullable
    private OnShareCallback callback;

    /* JADX INFO: renamed from: shareCoverUrl$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareCoverUrl = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.share.ShareWorksDialog$shareCoverUrl$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(ShareWorksDialog.SHARE_COVER_URL)) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: shareWork$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareWork = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.share.ShareWorksDialog$shareWork$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m975invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(ShareWorksDialog.SHARE_WORK) : false);
        }
    });

    /* JADX INFO: renamed from: shareThird$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareThird = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.share.ShareWorksDialog$shareThird$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m974invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(ShareWorksDialog.SHARE_THIRD) : false);
        }
    });

    /* JADX INFO: renamed from: sharePoster$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy sharePoster = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.share.ShareWorksDialog$sharePoster$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m973invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(ShareWorksDialog.SHARE_POSTER) : false);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/works/page/share/ShareWorksDialog$a;", "", "Landroid/view/View;", "view", "", "a", "b", "e", "d", "c", "<init>", "(Lcom/huachenjie/works/page/share/ShareWorksDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.works.page.share.ShareWorksDialog$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/works/page/share/ShareWorksDialog$a$a", "Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog$OnFriendChooseCallback;", "Lcom/huachenjie/im/bean/FriendUserInfo;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0832a implements ChooseFriendDialog.OnFriendChooseCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ShareWorksDialog f37322a;

            /* JADX INFO: renamed from: com.huachenjie.works.page.share.ShareWorksDialog$a$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/page/share/ShareWorksDialog$a$a$a", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/netease/nimlib/sdk/msg/model/IMMessage;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
            public static final class C0833a extends DefaultCallback<IMMessage> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Dialog f37323a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ FriendUserInfo f14941a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ ShareWorksDialog f14942a;

                public C0833a(Dialog dialog, ShareWorksDialog shareWorksDialog, FriendUserInfo friendUserInfo) {
                    this.f37323a = dialog;
                    this.f14942a = shareWorksDialog;
                    this.f14941a = friendUserInfo;
                }

                @Override // com.huachenjie.im.DefaultCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResult(int code, @Nullable IMMessage result, @Nullable Throwable exception) {
                    this.f37323a.dismiss();
                    if (code == 200 && result != null) {
                        this.f14942a.onShareSuccess(1, this.f14941a.getAccId());
                    } else {
                        fv5.b("分享失败");
                        this.f14942a.dismiss();
                    }
                }
            }

            public C0832a(ShareWorksDialog shareWorksDialog) {
                this.f37322a = shareWorksDialog;
            }

            @Override // com.huachenjie.works.page.share.choose_friend.ChooseFriendDialog.OnFriendChooseCallback
            public void a(@NotNull FriendUserInfo bean) {
                Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
                if (this.f37322a.callback == null) {
                    return;
                }
                OnShareCallback onShareCallback = this.f37322a.callback;
                MsgAttachment msgAttachmentF = onShareCallback != null ? onShareCallback.f() : null;
                if (msgAttachmentF == null) {
                    return;
                }
                Dialog dialogM = DialogUtil.m(this.f37322a.getActivity());
                dialogM.show();
                dj1.P(msgAttachmentF, bean.getAccId(), new C0833a(dialogM, this.f37322a, bean));
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/works/page/share/ShareWorksDialog$a$b", "Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog$OnTeamChooseCallback;", "Lcom/huachenjie/works/bean/ChatTeamBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
        public static final class b implements ChooseTeamDialog.OnTeamChooseCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ShareWorksDialog f37324a;

            /* JADX INFO: renamed from: com.huachenjie.works.page.share.ShareWorksDialog$a$b$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/page/share/ShareWorksDialog$a$b$a", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/netease/nimlib/sdk/chatroom/model/ChatRoomMessage;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
            public static final class C0834a extends DefaultCallback<ChatRoomMessage> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Dialog f37325a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ ChatTeamBean f14943a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ ShareWorksDialog f14944a;

                public C0834a(Dialog dialog, ShareWorksDialog shareWorksDialog, ChatTeamBean chatTeamBean) {
                    this.f37325a = dialog;
                    this.f14944a = shareWorksDialog;
                    this.f14943a = chatTeamBean;
                }

                @Override // com.huachenjie.im.DefaultCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResult(int code, @Nullable ChatRoomMessage result, @Nullable Throwable exception) {
                    this.f37325a.dismiss();
                    if (code == 200 && result != null) {
                        this.f14944a.onShareSuccess(2, this.f14943a.getRoomId());
                    } else {
                        fv5.b("分享失败");
                        this.f14944a.dismiss();
                    }
                }
            }

            public b(ShareWorksDialog shareWorksDialog) {
                this.f37324a = shareWorksDialog;
            }

            @Override // com.huachenjie.works.page.share.choose_team.ChooseTeamDialog.OnTeamChooseCallback
            public void a(@NotNull ChatTeamBean bean) {
                Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
                if (this.f37324a.callback == null) {
                    return;
                }
                OnShareCallback onShareCallback = this.f37324a.callback;
                MsgAttachment msgAttachmentF = onShareCallback != null ? onShareCallback.f() : null;
                if (msgAttachmentF == null) {
                    return;
                }
                Dialog dialogM = DialogUtil.m(this.f37324a.getActivity());
                dialogM.show();
                dj1.Q(msgAttachmentF, bean.getRoomId(), new C0834a(dialogM, this.f37324a, bean));
            }
        }

        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ShareWorksDialog.this.dismissAllowingStateLoss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChooseFriendDialog chooseFriendDialogA = ChooseFriendDialog.INSTANCE.a(new C0832a(ShareWorksDialog.this));
            FragmentManager childFragmentManager = ShareWorksDialog.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            chooseFriendDialogA.show(childFragmentManager, ChooseFriendDialog.class.getName());
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            OnShareCallback onShareCallback = ShareWorksDialog.this.callback;
            if (onShareCallback != null) {
                onShareCallback.c(ExtendEvents.MINI_PROGRAM);
            }
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            OnShareCallback onShareCallback = ShareWorksDialog.this.callback;
            if (onShareCallback != null) {
                onShareCallback.c(ExtendEvents.POSTER);
            }
            ShareWorksDialog.this.dismissAllowingStateLoss();
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (ShareWorksDialog.this.callback == null) {
                return;
            }
            OnShareCallback onShareCallback = ShareWorksDialog.this.callback;
            String strB = onShareCallback != null ? onShareCallback.b() : null;
            if (strB == null) {
                strB = "";
            }
            ChooseTeamDialog chooseTeamDialogA = ChooseTeamDialog.INSTANCE.a(strB, new b(ShareWorksDialog.this));
            FragmentManager childFragmentManager = ShareWorksDialog.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            chooseTeamDialogA.show(childFragmentManager, ChooseTeamDialog.class.getName());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.share.ShareWorksDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/works/page/share/ShareWorksDialog$b;", "", "Lcom/huachenjie/works/page/share/OnShareCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/works/page/share/ShareWorksDialog;", "a", "c", "", "coverUrl", "d", "b", "SHARE_COVER_URL", "Ljava/lang/String;", "SHARE_POSTER", "SHARE_THIRD", "SHARE_WORK", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ShareWorksDialog a(@NotNull OnShareCallback callback) {
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            ShareWorksDialog shareWorksDialog = new ShareWorksDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ShareWorksDialog.SHARE_WORK, false);
            bundle.putBoolean(ShareWorksDialog.SHARE_THIRD, false);
            bundle.putBoolean(ShareWorksDialog.SHARE_POSTER, false);
            shareWorksDialog.setArguments(bundle);
            shareWorksDialog.callback = callback;
            return shareWorksDialog;
        }

        @NotNull
        public final ShareWorksDialog b(@NotNull String coverUrl, @NotNull OnShareCallback callback) {
            Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            ShareWorksDialog shareWorksDialog = new ShareWorksDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ShareWorksDialog.SHARE_WORK, false);
            bundle.putBoolean(ShareWorksDialog.SHARE_THIRD, true);
            bundle.putBoolean(ShareWorksDialog.SHARE_POSTER, true);
            bundle.putString(ShareWorksDialog.SHARE_COVER_URL, coverUrl);
            shareWorksDialog.setArguments(bundle);
            shareWorksDialog.callback = callback;
            return shareWorksDialog;
        }

        @NotNull
        public final ShareWorksDialog c(@NotNull OnShareCallback callback) {
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            ShareWorksDialog shareWorksDialog = new ShareWorksDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ShareWorksDialog.SHARE_WORK, false);
            bundle.putBoolean(ShareWorksDialog.SHARE_THIRD, false);
            bundle.putBoolean(ShareWorksDialog.SHARE_POSTER, false);
            shareWorksDialog.setArguments(bundle);
            shareWorksDialog.callback = callback;
            return shareWorksDialog;
        }

        @NotNull
        public final ShareWorksDialog d(@NotNull String coverUrl, @NotNull OnShareCallback callback) {
            Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            ShareWorksDialog shareWorksDialog = new ShareWorksDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ShareWorksDialog.SHARE_WORK, true);
            bundle.putBoolean(ShareWorksDialog.SHARE_THIRD, true);
            bundle.putBoolean(ShareWorksDialog.SHARE_POSTER, false);
            bundle.putString(ShareWorksDialog.SHARE_COVER_URL, coverUrl);
            shareWorksDialog.setArguments(bundle);
            shareWorksDialog.callback = callback;
            return shareWorksDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37326a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37326a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37326a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37326a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.share.ShareWorksDialog$clickShare$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.share.ShareWorksDialog$clickShare$1", f = "ShareWorksDialog.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlavourName $flavourName;
        final /* synthetic */ SharedBody $mSharedBody;
        int label;
        final /* synthetic */ ShareWorksDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SharedBody sharedBody, ShareWorksDialog shareWorksDialog, FlavourName flavourName, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mSharedBody = sharedBody;
            this.this$0 = shareWorksDialog;
            this.$flavourName = flavourName;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$mSharedBody, this.this$0, this.$flavourName, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$mSharedBody instanceof WebPageBody) {
                    CoroutineDispatcher coroutineDispatcherC = jo2.c();
                    ShareWorksDialog$clickShare$1$bitmap$1 shareWorksDialog$clickShare$1$bitmap$1 = new ShareWorksDialog$clickShare$1$bitmap$1(this.this$0, null);
                    this.label = 1;
                    obj = v41.h(coroutineDispatcherC, shareWorksDialog$clickShare$1$bitmap$1, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Context context = this.this$0.getContext();
                SharedBody sharedBody = this.$mSharedBody;
                final FlavourName flavourName = this.$flavourName;
                final ShareWorksDialog shareWorksDialog = this.this$0;
                y88.i(context, sharedBody, new ShareListener() { // from class: com.huachenjie.works.page.share.ShareWorksDialog.clickShare.1.1

                    /* JADX INFO: renamed from: com.huachenjie.works.page.share.ShareWorksDialog$clickShare$1$1$a */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class a {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public static final /* synthetic */ int[] f37327a;

                        static {
                            int[] iArr = new int[FlavourName.values().length];
                            try {
                                iArr[FlavourName.WX_SESSION.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[FlavourName.WX_MOMENT.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[FlavourName.QQ.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            try {
                                iArr[FlavourName.SINA.ordinal()] = 4;
                            } catch (NoSuchFieldError unused4) {
                            }
                            f37327a = iArr;
                        }
                    }

                    public void onCancel(@Nullable FlavourName flavour) {
                        fv5.b("分享取消");
                        shareWorksDialog.dismissAllowingStateLoss();
                    }

                    public void onFailed(@Nullable FlavourName flavour, int code, @Nullable String message) {
                        if (code == 1) {
                            fv5.b(message);
                        } else {
                            if (message == null) {
                                message = "分享失败";
                            }
                            fv5.b(message);
                        }
                        shareWorksDialog.dismissAllowingStateLoss();
                    }

                    public void onSuccess(@Nullable FlavourName flavour) {
                        int i2 = a.f37327a[flavourName.ordinal()];
                        int i3 = 3;
                        if (i2 != 1) {
                            if (i2 == 2) {
                                i3 = 5;
                            } else if (i2 != 3) {
                                i3 = i2 != 4 ? 0 : 6;
                            } else {
                                i3 = 4;
                            }
                        }
                        ShareWorksDialog.onShareSuccess$default(shareWorksDialog, i3, null, 2, null);
                    }
                });
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$mSharedBody.setBitmap((Bitmap) obj);
            Context context2 = this.this$0.getContext();
            SharedBody sharedBody2 = this.$mSharedBody;
            final FlavourName flavourName2 = this.$flavourName;
            final ShareWorksDialog shareWorksDialog2 = this.this$0;
            y88.i(context2, sharedBody2, new ShareListener() { // from class: com.huachenjie.works.page.share.ShareWorksDialog.clickShare.1.1

                /* JADX INFO: renamed from: com.huachenjie.works.page.share.ShareWorksDialog$clickShare$1$1$a */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                public /* synthetic */ class a {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f37327a;

                    static {
                        int[] iArr = new int[FlavourName.values().length];
                        try {
                            iArr[FlavourName.WX_SESSION.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[FlavourName.WX_MOMENT.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[FlavourName.QQ.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[FlavourName.SINA.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        f37327a = iArr;
                    }
                }

                public void onCancel(@Nullable FlavourName flavour) {
                    fv5.b("分享取消");
                    shareWorksDialog2.dismissAllowingStateLoss();
                }

                public void onFailed(@Nullable FlavourName flavour, int code, @Nullable String message) {
                    if (code == 1) {
                        fv5.b(message);
                    } else {
                        if (message == null) {
                            message = "分享失败";
                        }
                        fv5.b(message);
                    }
                    shareWorksDialog2.dismissAllowingStateLoss();
                }

                public void onSuccess(@Nullable FlavourName flavour) {
                    int i2 = a.f37327a[flavourName2.ordinal()];
                    int i3 = 3;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            i3 = 5;
                        } else if (i2 != 3) {
                            i3 = i2 != 4 ? 0 : 6;
                        } else {
                            i3 = 4;
                        }
                    }
                    ShareWorksDialog.onShareSuccess$default(shareWorksDialog2, i3, null, 2, null);
                }
            });
            return Unit.INSTANCE;
        }
    }

    private final void clickShare(FlavourName flavourName) {
        OnShareCallback onShareCallback = this.callback;
        if (onShareCallback == null) {
            return;
        }
        SharedBody sharedBodyE = onShareCallback != null ? onShareCallback.e() : null;
        if (sharedBodyE == null) {
            return;
        }
        sharedBodyE.setFlavour(flavourName);
        v41.e(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(sharedBodyE, this, flavourName, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getShareCoverUrl() {
        return (String) this.shareCoverUrl.getValue();
    }

    private final boolean getSharePoster() {
        return ((Boolean) this.sharePoster.getValue()).booleanValue();
    }

    private final boolean getShareThird() {
        return ((Boolean) this.shareThird.getValue()).booleanValue();
    }

    private final boolean getShareWork() {
        return ((Boolean) this.shareWork.getValue()).booleanValue();
    }

    private final void initShareStatus(int viewId, final FlavourName flavourName) {
        View viewFindViewById;
        View view = getView();
        if (view == null || (viewFindViewById = view.findViewById(viewId)) == null) {
            return;
        }
        viewFindViewById.setVisibility(0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.a98
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShareWorksDialog.initShareStatus$lambda$1$lambda$0(this.f40488a, flavourName, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initShareStatus$lambda$1$lambda$0(ShareWorksDialog shareWorksDialog, FlavourName flavourName, View view) {
        Intrinsics.checkNotNullParameter(shareWorksDialog, "this$0");
        Intrinsics.checkNotNullParameter(flavourName, "$flavourName");
        shareWorksDialog.clickShare(flavourName);
    }

    public static /* synthetic */ void onShareSuccess$default(ShareWorksDialog shareWorksDialog, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        shareWorksDialog.onShareSuccess(i, str);
    }

    private final void setViewVisibility(int viewId, int visible) {
        View viewFindViewById;
        View view = getView();
        if (view == null || (viewFindViewById = view.findViewById(viewId)) == null) {
            return;
        }
        viewFindViewById.setVisibility(visible);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_share_work;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        MutableLiveData<Boolean> mutableLiveDataJ;
        ShareWorksVM shareWorksVM = (ShareWorksVM) getMViewModel();
        if (shareWorksVM == null || (mutableLiveDataJ = shareWorksVM.j()) == null) {
            return;
        }
        mutableLiveDataJ.observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.share.ShareWorksDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue()) {
                    ShareWorksDialog.this.showShareSuccess();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        if (getShareThird()) {
            int i = R.id.iv_share_to_wechat;
            FlavourName flavourName = FlavourName.WX_SESSION;
            initShareStatus(i, flavourName);
            initShareStatus(R.id.tv_share_to_wechat, flavourName);
            int i2 = R.id.iv_share_to_moments;
            FlavourName flavourName2 = FlavourName.WX_MOMENT;
            initShareStatus(i2, flavourName2);
            initShareStatus(R.id.tv_share_to_moments, flavourName2);
            int i3 = R.id.iv_share_to_qq;
            FlavourName flavourName3 = FlavourName.QQ;
            initShareStatus(i3, flavourName3);
            initShareStatus(R.id.tv_share_to_qq, flavourName3);
            int i4 = R.id.iv_share_to_sina;
            FlavourName flavourName4 = FlavourName.SINA;
            initShareStatus(i4, flavourName4);
            initShareStatus(R.id.tv_share_to_sina, flavourName4);
            if (getSharePoster()) {
                setViewVisibility(R.id.iv_share_poster, 0);
                setViewVisibility(R.id.tv_share_poster, 0);
                setViewVisibility(R.id.iv_share_to_mini_program, 4);
                setViewVisibility(R.id.tv_share_to_mini_program, 4);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onShareSuccess(int shareType, @Nullable String targetNo) {
        if (!getShareWork()) {
            showShareSuccess();
            return;
        }
        OnShareCallback onShareCallback = this.callback;
        WorkDetailBean workDetailBeanD = onShareCallback != null ? onShareCallback.d() : null;
        if (workDetailBeanD != null) {
            ((ShareWorksVM) getMViewModel()).i(workDetailBeanD.getWorksNo(), shareType, workDetailBeanD.formatAuthorNo(), ai9.e().getUserId(), targetNo);
        } else {
            showShareSuccess();
        }
    }

    public final void showShareSuccess() {
        OnShareCallback onShareCallback;
        fv5.b("分享成功");
        if (getShareWork() && (onShareCallback = this.callback) != null) {
            onShareCallback.a();
        }
        dismissAllowingStateLoss();
    }
}
