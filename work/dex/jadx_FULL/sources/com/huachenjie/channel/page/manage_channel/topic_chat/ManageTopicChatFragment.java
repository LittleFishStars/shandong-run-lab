package com.huachenjie.channel.page.manage_channel.topic_chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopicChat;
import com.huachenjie.channel.databinding.ChannelFragmentManageTopicChatBinding;
import com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatFragment;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity;
import com.huachenjie.channel.utils.channel.ChannelRefreshReceiver;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.zj.adlib.f99;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.y89;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001*B\u0007¢\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010$\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/ManageTopicChatFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentManageTopicChatBinding;", "Lcom/huachenjie/channel/page/manage_channel/topic_chat/ManageTopicChatVM;", "", "initAdapter", "addTopicChat", "Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopicChat;", "manageTopicChat", "manageTeam", "", "", "getVariables", "getLayoutResID", "", "isAdd2ViewPager2", "initView", "onDestroyView", "lazyLoadData", "initDataObservable", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "Lcom/huachenjie/channel/utils/channel/ChannelRefreshReceiver;", "receiver$delegate", "getReceiver", "()Lcom/huachenjie/channel/utils/channel/ChannelRefreshReceiver;", "receiver", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mAddLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "mManageLauncher", "clickChat", "Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopicChat;", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageTopicChatFragment extends BaseMVVMFragment<ChannelFragmentManageTopicChatBinding, ManageTopicChatVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channel_no";

    @Nullable
    private ManageTopicChat clickChat;

    @NotNull
    private final ActivityResultLauncher<Intent> mAddLauncher;

    @NotNull
    private final ActivityResultLauncher<Intent> mManageLauncher;

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatFragment$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("channel_no")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: receiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy receiver = LazyKt.lazy(new Function0<ChannelRefreshReceiver>() { // from class: com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatFragment$receiver$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ChannelRefreshReceiver m290invoke() {
            String channelNo = this.this$0.getChannelNo();
            Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
            final ManageTopicChatFragment manageTopicChatFragment = this.this$0;
            return new ChannelRefreshReceiver(channelNo, new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatFragment$receiver$2.1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    if (i == 5) {
                        manageTopicChatFragment.setMHasLoadData(false);
                    }
                }
            });
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/ManageTopicChatFragment$a;", "", "", "channelNo", "Lcom/huachenjie/channel/page/manage_channel/topic_chat/ManageTopicChatFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ManageTopicChatFragment a(@NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            ManageTopicChatFragment manageTopicChatFragment = new ManageTopicChatFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channel_no", channelNo);
            manageTopicChatFragment.setArguments(bundle);
            return manageTopicChatFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33460a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33460a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33460a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33460a.invoke(obj);
        }
    }

    public ManageTopicChatFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.n75
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ManageTopicChatFragment.mAddLauncher$lambda$2(this.f43465a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.mAddLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.o75
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ManageTopicChatFragment.mManageLauncher$lambda$3(this.f43684a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResul…lickChat = null\n        }");
        this.mManageLauncher = activityResultLauncherRegisterForActivityResult2;
    }

    private final void addTopicChat() {
        ActivityResultLauncher<Intent> activityResultLauncher = this.mAddLauncher;
        CreateTopicChatActivity.Companion companion = CreateTopicChatActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        activityResultLauncher.launch(companion.a(contextRequireContext, channelNo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final ChannelRefreshReceiver getReceiver() {
        return (ChannelRefreshReceiver) this.receiver.getValue();
    }

    private final void initAdapter() {
        MutableLiveData<ManageTopicChatAdapter> mutableLiveDataI = getMViewModel().i();
        ManageTopicChatAdapter manageTopicChatAdapter = new ManageTopicChatAdapter();
        manageTopicChatAdapter.addNodeProvider(new f99());
        manageTopicChatAdapter.addNodeProvider(new y89(new ManageTopicChatFragment$initAdapter$1$1(this)));
        View viewInflate = getLayoutInflater().inflate(R.layout.channel_view_manage_create_topic_chat, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_add)).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.p75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageTopicChatFragment.initAdapter$lambda$1$lambda$0(this.f43921a, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewInflate, "headerView");
        BaseQuickAdapter.setHeaderView$default(manageTopicChatAdapter, viewInflate, 0, 0, 6, null);
        mutableLiveDataI.setValue(manageTopicChatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1$lambda$0(ManageTopicChatFragment manageTopicChatFragment, View view) {
        Intrinsics.checkNotNullParameter(manageTopicChatFragment, "this$0");
        manageTopicChatFragment.addTopicChat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mAddLauncher$lambda$2(ManageTopicChatFragment manageTopicChatFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(manageTopicChatFragment, "this$0");
        if (activityResult.getResultCode() == -1) {
            manageTopicChatFragment.getMViewModel().j().setValue(Boolean.TRUE);
            ManageTopicChatVM mViewModel = manageTopicChatFragment.getMViewModel();
            String channelNo = manageTopicChatFragment.getChannelNo();
            Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
            mViewModel.k(channelNo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mManageLauncher$lambda$3(ManageTopicChatFragment manageTopicChatFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(manageTopicChatFragment, "this$0");
        if (activityResult.getResultCode() == -1 && activityResult.getData() != null && manageTopicChatFragment.clickChat != null) {
            Intent data = activityResult.getData();
            Intrinsics.checkNotNull(data);
            int intExtra = data.getIntExtra("result_type", -1);
            if (intExtra == 1) {
                manageTopicChatFragment.getMViewModel().j().setValue(Boolean.TRUE);
                ManageTopicChatVM mViewModel = manageTopicChatFragment.getMViewModel();
                String channelNo = manageTopicChatFragment.getChannelNo();
                Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                mViewModel.k(channelNo);
            } else if (intExtra == 2) {
                Intent data2 = activityResult.getData();
                Intrinsics.checkNotNull(data2);
                int intExtra2 = data2.getIntExtra(TeamMemberManageActivity.x, 0);
                ManageTopicChatVM mViewModel2 = manageTopicChatFragment.getMViewModel();
                ManageTopicChat manageTopicChat = manageTopicChatFragment.clickChat;
                Intrinsics.checkNotNull(manageTopicChat);
                mViewModel2.l(manageTopicChat, intExtra2);
            }
        }
        manageTopicChatFragment.clickChat = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void manageTeam(ManageTopicChat manageTopicChat) {
        this.clickChat = manageTopicChat;
        ActivityResultLauncher<Intent> activityResultLauncher = this.mManageLauncher;
        TeamMemberManageActivity.Companion companion = TeamMemberManageActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        activityResultLauncher.launch(companion.a(contextRequireContext, manageTopicChat.getTid(), manageTopicChat.getSubjectGroupNo()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_manage_topic_chat;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, ManageTopicChatVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().j().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ri1 ri1Var = ri1.f19330a;
                    Context contextRequireContext = ManageTopicChatFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    String channelNo = ManageTopicChatFragment.this.getChannelNo();
                    Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                    ri1Var.b(contextRequireContext, channelNo, 6);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
        ri1 ri1Var = ri1.f19330a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ri1Var.a(contextRequireContext, getReceiver());
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        super.lazyLoadData();
        ManageTopicChatVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.k(channelNo);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ri1 ri1Var = ri1.f19330a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ri1Var.c(contextRequireContext, getReceiver());
        super.onDestroyView();
    }
}
