package com.huachenjie.channel.page.manage_channel.chat;

import android.app.Dialog;
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
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.dialog.OnSaveInputListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;
import com.huachenjie.channel.databinding.ChannelFragmentManageChatBinding;
import com.huachenjie.channel.page.manage_channel.chat.ManageChatFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.gx1;
import com.zj.adlib.lj1;
import com.zj.adlib.nj1;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.List;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/chat/ManageChatFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentManageChatBinding;", "Lcom/huachenjie/channel/page/manage_channel/chat/ManageChatVM;", "", "initAdapter", "addChatTeamGroup", "Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeamGroup;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "position", "editChatTeamGroup", "deleteChatTeamGroup", "teamGroup", "addChatTeam", "Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeam;", "team", "editChatTeam", "", "getVariables", "getLayoutResID", "", "isAdd2ViewPager2", "initView", "lazyLoadData", "initDataObservable", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "createChatTeamActivityLaunch", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nManageChatFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ManageChatFragment.kt\ncom/huachenjie/channel/page/manage_channel/chat/ManageChatFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,198:1\n800#2,11:199\n*S KotlinDebug\n*F\n+ 1 ManageChatFragment.kt\ncom/huachenjie/channel/page/manage_channel/chat/ManageChatFragment\n*L\n89#1:199,11\n*E\n"})
public final class ManageChatFragment extends BaseMVVMFragment<ChannelFragmentManageChatBinding, ManageChatVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channelNo";

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.chat.ManageChatFragment$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("channelNo")) == null) ? "" : string;
        }
    });

    @NotNull
    private final ActivityResultLauncher<Intent> createChatTeamActivityLaunch;

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.chat.ManageChatFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/chat/ManageChatFragment$a;", "", "", "channelNo", "Lcom/huachenjie/channel/page/manage_channel/chat/ManageChatFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ManageChatFragment a(@NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            ManageChatFragment manageChatFragment = new ManageChatFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelNo", channelNo);
            manageChatFragment.setArguments(bundle);
            return manageChatFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33436a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33436a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33436a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33436a.invoke(obj);
        }
    }

    public ManageChatFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.i75
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ManageChatFragment.createChatTeamActivityLaunch$lambda$5(this.f42294a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.createChatTeamActivityLaunch = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addChatTeam(MyChannelChatTeamGroup teamGroup) {
        ActivityResultLauncher<Intent> activityResultLauncher = this.createChatTeamActivityLaunch;
        CreateChatTeamActivity.Companion companion = CreateChatTeamActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        activityResultLauncher.launch(CreateChatTeamActivity.Companion.b(companion, contextRequireContext, channelNo, teamGroup.getTeamGroupCode(), teamGroup.getTeamGroupTitle(), null, 16, null));
    }

    private final void addChatTeamGroup() {
        int size;
        List<BaseNode> data;
        ManageChatAdapter value = getMViewModel().n().getValue();
        if (value == null || (data = value.getData()) == null) {
            size = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                if (obj instanceof MyChannelChatTeamGroup) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        }
        if (size >= 3) {
            fv5.b(getString(R.string.channel_manage_chat_team_group_max_count));
        } else {
            ft1.w(requireContext(), getString(R.string.channel_manage_create_chat_team_group), "", getString(R.string.channel_manage_create_chat_team_group_hint), 10, new OnSaveInputListener() { // from class: com.zj.adlib.j75
                @Override // com.huachenjie.base.widget.dialog.OnSaveInputListener
                public final void a(Dialog dialog, String str) {
                    ManageChatFragment.addChatTeamGroup$lambda$2(this.f42523a, dialog, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addChatTeamGroup$lambda$2(ManageChatFragment manageChatFragment, Dialog dialog, String str) {
        Intrinsics.checkNotNullParameter(manageChatFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(str, "text");
        String string = StringsKt.trim(str).toString();
        if (ys8.h(string)) {
            fv5.b(manageChatFragment.getString(R.string.channel_manage_create_chat_team_group_error));
            return;
        }
        ManageChatVM mViewModel = manageChatFragment.getMViewModel();
        String channelNo = manageChatFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        mViewModel.j(channelNo, string, dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createChatTeamActivityLaunch$lambda$5(ManageChatFragment manageChatFragment, ActivityResult activityResult) {
        Intent data;
        String stringExtra;
        Intrinsics.checkNotNullParameter(manageChatFragment, "this$0");
        if (activityResult.getResultCode() != -1 || activityResult.getData() == null || (data = activityResult.getData()) == null || (stringExtra = data.getStringExtra(CreateChatTeamActivity.x)) == null) {
            return;
        }
        Intent data2 = activityResult.getData();
        MyChannelChatTeam myChannelChatTeam = data2 != null ? (MyChannelChatTeam) data2.getParcelableExtra(CreateChatTeamActivity.y) : null;
        if (myChannelChatTeam == null) {
            return;
        }
        Intent data3 = activityResult.getData();
        Integer numValueOf = data3 != null ? Integer.valueOf(data3.getIntExtra("result_type", -1)) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            manageChatFragment.getMViewModel().i(stringExtra, myChannelChatTeam);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            manageChatFragment.getMViewModel().m(stringExtra, myChannelChatTeam);
        } else if (numValueOf != null && numValueOf.intValue() == 3) {
            manageChatFragment.getMViewModel().k(stringExtra, myChannelChatTeam);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteChatTeamGroup(final MyChannelChatTeamGroup bean, final int position) {
        ft1.p(requireContext(), getString(R.string.channel_manage_delete_chat_team_group), new View.OnClickListener() { // from class: com.zj.adlib.l75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageChatFragment.deleteChatTeamGroup$lambda$4(this.f17897a, bean, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteChatTeamGroup$lambda$4(ManageChatFragment manageChatFragment, MyChannelChatTeamGroup myChannelChatTeamGroup, int i, View view) {
        Intrinsics.checkNotNullParameter(manageChatFragment, "this$0");
        Intrinsics.checkNotNullParameter(myChannelChatTeamGroup, "$bean");
        ManageChatVM mViewModel = manageChatFragment.getMViewModel();
        String channelNo = manageChatFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.l(channelNo, myChannelChatTeamGroup, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void editChatTeam(MyChannelChatTeamGroup teamGroup, MyChannelChatTeam team) {
        ActivityResultLauncher<Intent> activityResultLauncher = this.createChatTeamActivityLaunch;
        CreateChatTeamActivity.Companion companion = CreateChatTeamActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        activityResultLauncher.launch(companion.a(contextRequireContext, channelNo, teamGroup.getTeamGroupCode(), teamGroup.getTeamGroupTitle(), team));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void editChatTeamGroup(final MyChannelChatTeamGroup bean, final int position) {
        ft1.w(requireContext(), getString(R.string.channel_manage_update_chat_team_group), bean.getTeamGroupTitle(), getString(R.string.channel_manage_create_chat_team_group_hint), 10, new OnSaveInputListener() { // from class: com.zj.adlib.k75
            @Override // com.huachenjie.base.widget.dialog.OnSaveInputListener
            public final void a(Dialog dialog, String str) {
                ManageChatFragment.editChatTeamGroup$lambda$3(this.f17598a, bean, position, dialog, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void editChatTeamGroup$lambda$3(ManageChatFragment manageChatFragment, MyChannelChatTeamGroup myChannelChatTeamGroup, int i, Dialog dialog, String str) {
        Intrinsics.checkNotNullParameter(manageChatFragment, "this$0");
        Intrinsics.checkNotNullParameter(myChannelChatTeamGroup, "$bean");
        Intrinsics.checkNotNullExpressionValue(str, "text");
        String string = StringsKt.trim(str).toString();
        if (ys8.h(string)) {
            fv5.b(manageChatFragment.getString(R.string.channel_manage_create_chat_team_group_error));
            return;
        }
        ManageChatVM mViewModel = manageChatFragment.getMViewModel();
        String channelNo = manageChatFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        mViewModel.q(channelNo, string, myChannelChatTeamGroup, i, dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final void initAdapter() {
        MutableLiveData<ManageChatAdapter> mutableLiveDataN = getMViewModel().n();
        ManageChatAdapter manageChatAdapter = new ManageChatAdapter();
        manageChatAdapter.addNodeProvider(new lj1(new ManageChatFragment$initAdapter$1$1(this), new ManageChatFragment$initAdapter$1$2(this)));
        manageChatAdapter.addNodeProvider(new nj1(new ManageChatFragment$initAdapter$1$3(this)));
        manageChatAdapter.addNodeProvider(new gx1(new ManageChatFragment$initAdapter$1$4(this)));
        View viewInflate = getLayoutInflater().inflate(R.layout.channel_view_manage_create_chat_team_group, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_add)).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.m75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageChatFragment.initAdapter$lambda$1$lambda$0(this.f43240a, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewInflate, "headerView");
        BaseQuickAdapter.setHeaderView$default(manageChatAdapter, viewInflate, 0, 0, 6, null);
        mutableLiveDataN.setValue(manageChatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1$lambda$0(ManageChatFragment manageChatFragment, View view) {
        Intrinsics.checkNotNullParameter(manageChatFragment, "this$0");
        manageChatFragment.addChatTeamGroup();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_manage_chat;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, ManageChatVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().o().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.chat.ManageChatFragment.initDataObservable.1
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
                    Context contextRequireContext = ManageChatFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    String channelNo = ManageChatFragment.this.getChannelNo();
                    Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                    ri1Var.b(contextRequireContext, channelNo, 4);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        super.lazyLoadData();
        ManageChatVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.p(channelNo);
    }
}
