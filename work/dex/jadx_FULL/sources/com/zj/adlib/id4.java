package com.zj.adlib;

import android.app.Dialog;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.base.share.ShareLinkCallback;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.im.custom.ShareLinkAttachment;
import com.huachenjie.push.interfaces.InternalShareLink;
import com.huachenjie.works.bean.ChatTeamBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.share.choose_friend.ChooseFriendDialog;
import com.huachenjie.works.page.share.choose_team.ChooseTeamDialog;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/zj/adlib/id4;", "Lcom/huachenjie/push/interfaces/InternalShareLink;", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", "jsonStr", "Lcom/huachenjie/base/share/ShareLinkCallback;", RenderCallContext.TYPE_CALLBACK, "", "b", "a", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class id4 implements InternalShareLink {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/zj/adlib/id4$a", "Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog$OnFriendChooseCallback;", "Lcom/huachenjie/im/bean/FriendUserInfo;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements ChooseFriendDialog.OnFriendChooseCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f42333a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ShareLinkCallback f17190a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f17191a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        /* JADX INFO: renamed from: com.zj.adlib.id4$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/zj/adlib/id4$a$a", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/netease/nimlib/sdk/msg/model/IMMessage;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
        public static final class C1330a extends DefaultCallback<IMMessage> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Dialog f42334a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ShareLinkCallback f17192a;

            public C1330a(Dialog dialog, ShareLinkCallback shareLinkCallback) {
                this.f42334a = dialog;
                this.f17192a = shareLinkCallback;
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int code, @Nullable IMMessage result, @Nullable Throwable exception) {
                this.f42334a.dismiss();
                if (code != 200 || result == null) {
                    fv5.b("分享失败");
                    this.f17192a.a(false);
                } else {
                    fv5.b("分享成功");
                    this.f17192a.a(true);
                }
            }
        }

        public a(String str, String str2, String str3, String str4, FragmentActivity fragmentActivity, ShareLinkCallback shareLinkCallback) {
            this.f17191a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.f42333a = fragmentActivity;
            this.f17190a = shareLinkCallback;
        }

        @Override // com.huachenjie.works.page.share.choose_friend.ChooseFriendDialog.OnFriendChooseCallback
        public void a(@NotNull FriendUserInfo bean) {
            Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            ShareLinkAttachment shareLinkAttachment = new ShareLinkAttachment();
            shareLinkAttachment.setTitle(this.f17191a);
            shareLinkAttachment.setDesc(this.b);
            shareLinkAttachment.setImageUrl(this.c);
            shareLinkAttachment.setLink(this.d);
            Dialog dialogM = DialogUtil.m(this.f42333a);
            dialogM.show();
            dj1.P(shareLinkAttachment, bean.getAccId(), new C1330a(dialogM, this.f17190a));
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/zj/adlib/id4$b", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onDismiss", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements BaseDialogFragment.DialogFragmentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareLinkCallback f42335a;

        public b(ShareLinkCallback shareLinkCallback) {
            this.f42335a = shareLinkCallback;
        }

        @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
        public void onDismiss() {
            this.f42335a.a(false);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/zj/adlib/id4$c", "Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog$OnTeamChooseCallback;", "Lcom/huachenjie/works/bean/ChatTeamBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements ChooseTeamDialog.OnTeamChooseCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f42336a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ShareLinkCallback f17193a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f17194a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/zj/adlib/id4$c$a", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/netease/nimlib/sdk/chatroom/model/ChatRoomMessage;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends DefaultCallback<ChatRoomMessage> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Dialog f42337a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ShareLinkCallback f17195a;

            public a(Dialog dialog, ShareLinkCallback shareLinkCallback) {
                this.f42337a = dialog;
                this.f17195a = shareLinkCallback;
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int code, @Nullable ChatRoomMessage result, @Nullable Throwable exception) {
                this.f42337a.dismiss();
                if (code != 200 || result == null) {
                    fv5.b("分享失败");
                    this.f17195a.a(false);
                } else {
                    fv5.b("分享成功");
                    this.f17195a.a(true);
                }
            }
        }

        public c(String str, String str2, String str3, String str4, FragmentActivity fragmentActivity, ShareLinkCallback shareLinkCallback) {
            this.f17194a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.f42336a = fragmentActivity;
            this.f17193a = shareLinkCallback;
        }

        @Override // com.huachenjie.works.page.share.choose_team.ChooseTeamDialog.OnTeamChooseCallback
        public void a(@NotNull ChatTeamBean bean) {
            Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            ShareLinkAttachment shareLinkAttachment = new ShareLinkAttachment();
            shareLinkAttachment.setTitle(this.f17194a);
            shareLinkAttachment.setDesc(this.b);
            shareLinkAttachment.setImageUrl(this.c);
            shareLinkAttachment.setLink(this.d);
            Dialog dialogM = DialogUtil.m(this.f42336a);
            dialogM.show();
            dj1.Q(shareLinkAttachment, bean.getRoomId(), new a(dialogM, this.f17193a));
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/zj/adlib/id4$d", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onDismiss", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements BaseDialogFragment.DialogFragmentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareLinkCallback f42338a;

        public d(ShareLinkCallback shareLinkCallback) {
            this.f42338a = shareLinkCallback;
        }

        @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
        public void onDismiss() {
            this.f42338a.a(false);
        }
    }

    @Override // com.huachenjie.push.interfaces.InternalShareLink
    public void a(@Nullable FragmentActivity fragmentActivity, @Nullable String jsonStr, @NotNull ShareLinkCallback callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        if (fragmentActivity == null || TextUtils.isEmpty(jsonStr)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(jsonStr);
        String strOptString = jSONObject.optString("title");
        String strOptString2 = jSONObject.optString("desc");
        String strOptString3 = jSONObject.optString("url");
        ChooseTeamDialog chooseTeamDialogA = ChooseTeamDialog.INSTANCE.a("", new c(strOptString, strOptString2, jSONObject.optString("imageUrl"), strOptString3, fragmentActivity, callback));
        chooseTeamDialogA.setDialogFragmentListener(new d(callback));
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        chooseTeamDialogA.show(supportFragmentManager, ChooseTeamDialog.class.getName());
    }

    @Override // com.huachenjie.push.interfaces.InternalShareLink
    public void b(@Nullable FragmentActivity fragmentActivity, @Nullable String jsonStr, @NotNull ShareLinkCallback callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        if (fragmentActivity == null || TextUtils.isEmpty(jsonStr)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(jsonStr);
        String strOptString = jSONObject.optString("title");
        String strOptString2 = jSONObject.optString("desc");
        String strOptString3 = jSONObject.optString("url");
        ChooseFriendDialog chooseFriendDialogA = ChooseFriendDialog.INSTANCE.a(new a(strOptString, strOptString2, jSONObject.optString("imageUrl"), strOptString3, fragmentActivity, callback));
        chooseFriendDialogA.setDialogFragmentListener(new b(callback));
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        chooseFriendDialogA.show(supportFragmentManager, ChooseFriendDialog.class.getName());
    }
}
