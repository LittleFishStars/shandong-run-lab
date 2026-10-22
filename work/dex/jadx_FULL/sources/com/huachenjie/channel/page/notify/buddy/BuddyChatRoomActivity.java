package com.huachenjie.channel.page.notify.buddy;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.notify.BuddyDetailBean;
import com.huachenjie.channel.bean.notify.BuddyDetailUserBean;
import com.huachenjie.channel.databinding.ChannelActivityBuddyChatRoomBinding;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.im.page.ChatRoomFragment;
import com.huachenjie.im.page.SingleChatFragment;
import com.zj.adlib.ai9;
import com.zj.adlib.tk0;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = zj7.b.BUDDY_CHAT)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/page/notify/buddy/BuddyChatRoomActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityBuddyChatRoomBinding;", "Lcom/huachenjie/channel/page/notify/buddy/BuddyChatRoomVM;", "", "S", "", "", "", "V", "getLayoutResID", "initData", "", "roomId", "a0", "<init>", "()V", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class BuddyChatRoomActivity extends BaseMVVMActivity<ChannelActivityBuddyChatRoomBinding, BuddyChatRoomVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/channel/page/notify/buddy/BuddyChatRoomActivity$a;", "", "Landroid/view/View;", "view", "", "back", "a", "<init>", "(Lcom/huachenjie/channel/page/notify/buddy/BuddyChatRoomActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            BuddyDetailBean value = BuddyChatRoomActivity.Z(BuddyChatRoomActivity.this).i().getValue();
            if (value != null) {
                BuddyChatRoomActivity buddyChatRoomActivity = BuddyChatRoomActivity.this;
                BuddyMemberManagerActivity.Companion bVar = BuddyMemberManagerActivity.INSTANCE;
                String buddyCode = value.getBuddyCode();
                String title = value.getTitle();
                ArrayList<BuddyDetailUserBean> memberPreviewList = value.getMemberPreviewList();
                if (memberPreviewList == null) {
                    memberPreviewList = new ArrayList<>();
                }
                BuddyDetailUserBean creatorInfo = value.getCreatorInfo();
                bVar.a(buddyChatRoomActivity, buddyCode, title, memberPreviewList, Intrinsics.areEqual(creatorInfo != null ? creatorInfo.getAppUserCode() : null, ai9.e().getUserId()));
            }
        }

        public final void back(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            BuddyChatRoomActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.notify.buddy.BuddyChatRoomActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/huachenjie/channel/page/notify/buddy/BuddyChatRoomActivity$b;", "", "Landroid/content/Context;", "context", "", "buddyCode", "title", "roomId", "", "a", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull String buddyCode, @NotNull String title, @NotNull String roomId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            Intent intent = new Intent(context, (Class<?>) BuddyChatRoomActivity.class);
            intent.putExtra("buddyCode", buddyCode);
            intent.putExtra("buddyTitle", title);
            intent.putExtra(yj7.b.BUDDY_ROOM_ID, roomId);
            context.startActivity(intent);
        }
    }

    public static final /* synthetic */ BuddyChatRoomVM Z(BuddyChatRoomActivity buddyChatRoomActivity) {
        return buddyChatRoomActivity.getMViewModel();
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.a(context, str, str2, str3);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e eVarP3 = e.p3(this);
        int i = R.color.white;
        eVarP3.G2(i).T2(true).u1(i).G1(true).q1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    public final void a0(String roomId) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "supportFragmentManager.beginTransaction()");
        ChatRoomFragment chatRoomFragmentNewInstance = ChatRoomFragment.newInstance(roomId, 100);
        Intrinsics.checkNotNullExpressionValue(chatRoomFragmentNewInstance, "newInstance(roomId, 100)");
        fragmentTransactionBeginTransaction.add(R.id.fl_chat_content, chatRoomFragmentNewInstance, SingleChatFragment.class.getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        getSupportFragmentManager().executePendingTransactions();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_buddy_chat_room;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().j().setValue(getIntent().getStringExtra("buddyTitle"));
        String stringExtra = getIntent().getStringExtra(yj7.b.BUDDY_ROOM_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        a0(stringExtra);
        String stringExtra2 = getIntent().getStringExtra("buddyCode");
        getMViewModel().k(stringExtra2 != null ? stringExtra2 : "");
    }
}
