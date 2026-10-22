package com.huachenjie.channel.page.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.huachenjie.base.broadcast.friend_alias.FriendAliasListener;
import com.huachenjie.base.broadcast.friend_alias.FriendAliasReceiver;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.FlashMessageBuddyChatBean;
import com.huachenjie.channel.bean.FlashMessageItem;
import com.huachenjie.channel.bean.FlashMessageSingleChatItem;
import com.huachenjie.channel.databinding.ChannelFragmentFlashMessageBinding;
import com.huachenjie.channel.page.channel_home.ChannelHomeActivity;
import com.huachenjie.channel.page.friend_list.FriendListActivity;
import com.huachenjie.channel.page.home.FlashMessageFragment;
import com.huachenjie.channel.page.notify.NotifyActivity;
import com.huachenjie.channel.page.notify.buddy.BuddyChatRoomActivity;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.IMTokenBean;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.zj.adlib.dj1;
import com.zj.adlib.dq1;
import com.zj.adlib.fv5;
import com.zj.adlib.p44;
import com.zj.adlib.pn3;
import com.zj.adlib.tk0;
import com.zj.adlib.vi3;
import com.zj.adlib.wi3;
import com.zj.adlib.wt1;
import com.zj.adlib.y57;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001c\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/huachenjie/channel/page/home/FlashMessageFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentFlashMessageBinding;", "Lcom/huachenjie/channel/page/home/FlashMessageVM;", "", "initAdapter", "obsContactChange", "unregisterContactChange", "checkLoginAndRefresh", "Lcom/huachenjie/base/widget/OperatePopupWindow;", "getPopupWindow", "showDarkStatusBar", "", "", "", "getVariables", "getLayoutResID", "initView", "onFragmentResume", "onDestroyView", "", "lastRefreshTime", "J", "", "hasObserveContact", "Z", "operatePopupWindow", "Lcom/huachenjie/base/widget/OperatePopupWindow;", "com/huachenjie/channel/page/home/FlashMessageFragment$c", "imLoginCallback", "Lcom/huachenjie/channel/page/home/FlashMessageFragment$c;", "Lcom/netease/nimlib/sdk/Observer;", "", "Lcom/netease/nimlib/sdk/msg/model/RecentContact;", "contactObserver", "Lcom/netease/nimlib/sdk/Observer;", "contactDeletedObserver", "Lcom/huachenjie/base/broadcast/friend_alias/FriendAliasReceiver;", "friendAliasReceiver", "Lcom/huachenjie/base/broadcast/friend_alias/FriendAliasReceiver;", "Lcom/huachenjie/base/widget/OperatePopupWindow$OnClickCallback;", "operateCallback", "Lcom/huachenjie/base/widget/OperatePopupWindow$OnClickCallback;", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class FlashMessageFragment extends BaseMVVMFragment<ChannelFragmentFlashMessageBinding, FlashMessageVM> {
    private boolean hasObserveContact;
    private long lastRefreshTime;

    @Nullable
    private OperatePopupWindow operatePopupWindow;

    @NotNull
    private final c imLoginCallback = new c();

    @NotNull
    private final Observer<List<RecentContact>> contactObserver = new vi3(this);

    @NotNull
    private final Observer<RecentContact> contactDeletedObserver = new wi3(this);

    @NotNull
    private final FriendAliasReceiver friendAliasReceiver = new FriendAliasReceiver(new b());

    @NotNull
    private final OperatePopupWindow.OnClickCallback operateCallback = new OperatePopupWindow.OnClickCallback() { // from class: com.zj.adlib.xi3
        @Override // com.huachenjie.base.widget.OperatePopupWindow.OnClickCallback
        public final void a(View view, int i, Object obj) {
            FlashMessageFragment.operateCallback$lambda$2(this.f45828a, view, i, obj);
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/home/FlashMessageFragment$a;", "", "Landroid/view/View;", "view", "", "a", "b", "c", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChannelHomeActivity.Companion companion = ChannelHomeActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            companion.a(context);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            FriendListActivity.Companion aVar = FriendListActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            aVar.a(context);
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            NotifyActivity.Companion aVar = NotifyActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            aVar.a(context);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/channel/page/home/FlashMessageFragment$b", "Lcom/huachenjie/base/broadcast/friend_alias/FriendAliasListener;", "", pn3.FRIEND_ACCOUNT, pn3.FRIEND_ALIAS, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements FriendAliasListener {
        public b() {
        }

        @Override // com.huachenjie.base.broadcast.friend_alias.FriendAliasListener
        public void a(@NotNull String friendAccount, @NotNull String friendAlias) {
            Intrinsics.checkNotNullParameter(friendAccount, pn3.FRIEND_ACCOUNT);
            Intrinsics.checkNotNullParameter(friendAlias, pn3.FRIEND_ALIAS);
            FlashMessageFragment.access$getMViewModel(FlashMessageFragment.this).z(friendAccount, friendAlias);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/channel/page/home/FlashMessageFragment$c", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/huachenjie/im/bean/IMTokenBean;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DefaultCallback<IMTokenBean> {
        public c() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable IMTokenBean result, @Nullable Throwable exception) {
            if (code != 200 || result == null) {
                return;
            }
            FlashMessageFragment.access$getMViewModel(FlashMessageFragment.this).y(result);
            FlashMessageFragment.this.obsContactChange();
            wt1.h().o();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/channel/page/home/FlashMessageFragment$d", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/huachenjie/im/bean/IMTokenBean;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlashMessageAdapter f33411a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f8282a;

        public d(FlashMessageAdapter flashMessageAdapter, Object obj) {
            this.f33411a = flashMessageAdapter;
            this.f8282a = obj;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable IMTokenBean result, @Nullable Throwable exception) {
            if (code != 200) {
                fv5.b("创建聊天失败,请重试");
            } else {
                BuddyChatRoomActivity.INSTANCE.a(this.f33411a.getContext(), ((FlashMessageBuddyChatBean) this.f8282a).getBuddyCode(), ((FlashMessageBuddyChatBean) this.f8282a).getTitle(), ((FlashMessageBuddyChatBean) this.f8282a).getRoomId());
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/channel/page/home/FlashMessageFragment$e", "Lcom/huachenjie/im/DefaultCallback;", "Ljava/lang/Void;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class e extends DefaultCallback<Void> {
        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable Void result, @Nullable Throwable exception) {
        }
    }

    public static final /* synthetic */ FlashMessageVM access$getMViewModel(FlashMessageFragment flashMessageFragment) {
        return flashMessageFragment.getMViewModel();
    }

    private final void checkLoginAndRefresh() {
        if (System.currentTimeMillis() - this.lastRefreshTime < 60000) {
            return;
        }
        this.lastRefreshTime = System.currentTimeMillis();
        if (p44.r()) {
            getMViewModel().v();
        } else {
            p44.x(this.imLoginCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contactDeletedObserver$lambda$1(FlashMessageFragment flashMessageFragment, RecentContact recentContact) {
        Intrinsics.checkNotNullParameter(flashMessageFragment, "this$0");
        if (recentContact != null) {
            flashMessageFragment.getMViewModel().o(recentContact);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contactObserver$lambda$0(FlashMessageFragment flashMessageFragment, List list) {
        Intrinsics.checkNotNullParameter(flashMessageFragment, "this$0");
        flashMessageFragment.lastRefreshTime = System.currentTimeMillis();
        FlashMessageVM mViewModel = flashMessageFragment.getMViewModel();
        Intrinsics.checkNotNullExpressionValue(list, "messages");
        mViewModel.n(list);
    }

    private final OperatePopupWindow getPopupWindow() {
        if (this.operatePopupWindow == null) {
            Context contextRequireContext = requireContext();
            Integer value = getMViewModel().e().c().getValue();
            if (value == null) {
                value = 0;
            }
            OperatePopupWindow operatePopupWindow = new OperatePopupWindow(contextRequireContext, value.intValue());
            this.operatePopupWindow = operatePopupWindow;
            operatePopupWindow.h(this.operateCallback);
        }
        OperatePopupWindow operatePopupWindow2 = this.operatePopupWindow;
        Intrinsics.checkNotNull(operatePopupWindow2);
        return operatePopupWindow2;
    }

    private final void initAdapter() {
        MutableLiveData<FlashMessageAdapter> mutableLiveDataP = getMViewModel().p();
        final FlashMessageAdapter flashMessageAdapter = new FlashMessageAdapter();
        flashMessageAdapter.setHeaderWithEmptyEnable(true);
        if (dq1.e().getBuddyEnable()) {
            View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.channel_item_flash_message_header_view, (ViewGroup) null);
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.si3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FlashMessageFragment.initAdapter$lambda$8$lambda$4$lambda$3(this.f44697a, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(requireContext())\n …                        }");
            BaseQuickAdapter.addHeaderView$default(flashMessageAdapter, viewInflate, 0, 0, 6, null);
        }
        View viewInflate2 = LayoutInflater.from(requireContext()).inflate(R.layout.layout_empty_work, (ViewGroup) null);
        ((TextView) viewInflate2.findViewById(R.id.tv_empty)).setText("暂无消息");
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(requireContext()).i…消息\"\n                    }");
        flashMessageAdapter.setEmptyView(viewInflate2);
        y57.d(flashMessageAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.ti3
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FlashMessageFragment.initAdapter$lambda$8$lambda$6(flashMessageAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        flashMessageAdapter.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.zj.adlib.ui3
            @Override // com.chad.library.adapter.base.listener.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                return FlashMessageFragment.initAdapter$lambda$8$lambda$7(this.f45153a, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataP.setValue(flashMessageAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$8$lambda$4$lambda$3(FlashMessageFragment flashMessageFragment, View view) {
        Intrinsics.checkNotNullParameter(flashMessageFragment, "this$0");
        FlashMessageVM mViewModel = flashMessageFragment.getMViewModel();
        Context contextRequireContext = flashMessageFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        mViewModel.s(contextRequireContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$8$lambda$6(FlashMessageAdapter flashMessageAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(flashMessageAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof FlashMessageBuddyChatBean) {
            p44.x(new d(flashMessageAdapter, item));
        } else if (item instanceof FlashMessageSingleChatItem) {
            dj1.c0(((FlashMessageSingleChatItem) item).getContact().getAccid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initAdapter$lambda$8$lambda$7(FlashMessageFragment flashMessageFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(flashMessageFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(baseQuickAdapter.getItem(i) instanceof FlashMessageSingleChatItem)) {
            return false;
        }
        flashMessageFragment.getPopupWindow().i(Integer.valueOf(i));
        flashMessageFragment.getPopupWindow().j(view, "delete");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void obsContactChange() {
        if (this.hasObserveContact) {
            return;
        }
        wt1.h().j().c(this.contactObserver);
        wt1.h().j().d(this.contactDeletedObserver);
        this.hasObserveContact = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void operateCallback$lambda$2(FlashMessageFragment flashMessageFragment, View view, int i, Object obj) {
        Intrinsics.checkNotNullParameter(flashMessageFragment, "this$0");
        if (view == null || i != 1001) {
            return;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            int iIntValue = num.intValue();
            FlashMessageAdapter value = flashMessageFragment.getMViewModel().p().getValue();
            FlashMessageItem flashMessageItem = value != null ? (FlashMessageItem) value.getItem(iIntValue) : null;
            FlashMessageSingleChatItem flashMessageSingleChatItem = flashMessageItem instanceof FlashMessageSingleChatItem ? (FlashMessageSingleChatItem) flashMessageItem : null;
            if (flashMessageSingleChatItem == null) {
                return;
            }
            dj1.q(flashMessageSingleChatItem.getContact().getAccid(), SessionTypeEnum.P2P, new e());
        }
    }

    private final void showDarkStatusBar() {
        com.gyf.immersionbar.e.z3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
    }

    private final void unregisterContactChange() {
        if (this.hasObserveContact) {
            wt1.h().j().p(this.contactObserver);
            wt1.h().j().q(this.contactDeletedObserver);
            this.hasObserveContact = false;
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_flash_message;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        initAdapter();
        pn3 pn3Var = pn3.f44021a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        pn3Var.registerReceiver(contextRequireContext, this.friendAliasReceiver);
        p44.j(this.imLoginCallback);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        unregisterContactChange();
        pn3 pn3Var = pn3.f44021a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        pn3Var.unregisterReceiver(contextRequireContext, this.friendAliasReceiver);
        this.operatePopupWindow = null;
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentResume() {
        showDarkStatusBar();
        getMViewModel().x();
        checkLoginAndRefresh();
    }
}
