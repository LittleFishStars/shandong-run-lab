package com.huachenjie.channel.page.manage_channel.topic;

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
import com.huachenjie.base.widget.dialog.OnSaveInputListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
import com.huachenjie.channel.databinding.ChannelFragmentManageTopicBinding;
import com.huachenjie.channel.page.manage_channel.topic.ManageTopicFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.a99;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.h99;
import com.zj.adlib.ri1;
import com.zj.adlib.sx1;
import com.zj.adlib.tk0;
import com.zj.adlib.ys8;
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
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic/ManageTopicFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentManageTopicBinding;", "Lcom/huachenjie/channel/page/manage_channel/topic/ManageTopicVM;", "", "initAdapter", "addTopicGroup", "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicGroup;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "position", "editTopicGroup", "deleteTopicGroup", "topicGroup", "addTopic", "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopic;", "topic", "editTopic", "", "getVariables", "getLayoutResID", "", "isAdd2ViewPager2", "initView", "lazyLoadData", "initDataObservable", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "createTopicActivityLaunch", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageTopicFragment extends BaseMVVMFragment<ChannelFragmentManageTopicBinding, ManageTopicVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channel_no";

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.topic.ManageTopicFragment$channelNo$2
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

    @NotNull
    private final ActivityResultLauncher<Intent> createTopicActivityLaunch;

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.topic.ManageTopicFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic/ManageTopicFragment$a;", "", "", "channelNo", "Lcom/huachenjie/channel/page/manage_channel/topic/ManageTopicFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ManageTopicFragment a(@NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            ManageTopicFragment manageTopicFragment = new ManageTopicFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channel_no", channelNo);
            manageTopicFragment.setArguments(bundle);
            return manageTopicFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33452a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33452a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33452a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33452a.invoke(obj);
        }
    }

    public ManageTopicFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.t75
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ManageTopicFragment.createTopicActivityLaunch$lambda$5(this.f44865a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.createTopicActivityLaunch = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addTopic(MyChannelTopicGroup topicGroup) {
        ActivityResultLauncher<Intent> activityResultLauncher = this.createTopicActivityLaunch;
        CreateTopicActivity.Companion companion = CreateTopicActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        activityResultLauncher.launch(CreateTopicActivity.Companion.b(companion, contextRequireContext, channelNo, topicGroup.getSubjectCategoryNo(), topicGroup.getSubjectCategoryName(), null, 16, null));
    }

    private final void addTopicGroup() {
        ft1.w(requireContext(), getString(R.string.channel_manage_create_topic_group), "", getString(R.string.channel_manage_create_topic_group_hint), 10, new OnSaveInputListener() { // from class: com.zj.adlib.s75
            @Override // com.huachenjie.base.widget.dialog.OnSaveInputListener
            public final void a(Dialog dialog, String str) {
                ManageTopicFragment.addTopicGroup$lambda$2(this.f44632a, dialog, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTopicGroup$lambda$2(ManageTopicFragment manageTopicFragment, Dialog dialog, String str) {
        Intrinsics.checkNotNullParameter(manageTopicFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(str, "text");
        String string = StringsKt.trim(str).toString();
        if (ys8.h(string)) {
            fv5.b(manageTopicFragment.getString(R.string.channel_manage_create_topic_group_error));
            return;
        }
        ManageTopicVM mViewModel = manageTopicFragment.getMViewModel();
        String channelNo = manageTopicFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        mViewModel.j(channelNo, string, dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTopicActivityLaunch$lambda$5(ManageTopicFragment manageTopicFragment, ActivityResult activityResult) {
        Intent data;
        String stringExtra;
        Intrinsics.checkNotNullParameter(manageTopicFragment, "this$0");
        if (activityResult.getResultCode() != -1 || activityResult.getData() == null || (data = activityResult.getData()) == null || (stringExtra = data.getStringExtra(CreateTopicActivity.x)) == null) {
            return;
        }
        Intent data2 = activityResult.getData();
        MyChannelTopic myChannelTopic = data2 != null ? (MyChannelTopic) data2.getParcelableExtra(CreateTopicActivity.y) : null;
        if (myChannelTopic == null) {
            return;
        }
        Intent data3 = activityResult.getData();
        Integer numValueOf = data3 != null ? Integer.valueOf(data3.getIntExtra("result_type", -1)) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            manageTopicFragment.getMViewModel().i(stringExtra, myChannelTopic);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            manageTopicFragment.getMViewModel().m(stringExtra, myChannelTopic);
        } else if (numValueOf != null && numValueOf.intValue() == 3) {
            manageTopicFragment.getMViewModel().k(stringExtra, myChannelTopic);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteTopicGroup(final MyChannelTopicGroup bean, final int position) {
        ft1.p(requireContext(), getString(R.string.channel_manage_delete_topic_group), new View.OnClickListener() { // from class: com.zj.adlib.u75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageTopicFragment.deleteTopicGroup$lambda$4(this.f20001a, bean, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteTopicGroup$lambda$4(ManageTopicFragment manageTopicFragment, MyChannelTopicGroup myChannelTopicGroup, int i, View view) {
        Intrinsics.checkNotNullParameter(manageTopicFragment, "this$0");
        Intrinsics.checkNotNullParameter(myChannelTopicGroup, "$bean");
        ManageTopicVM mViewModel = manageTopicFragment.getMViewModel();
        String channelNo = manageTopicFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.l(channelNo, myChannelTopicGroup, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void editTopic(MyChannelTopicGroup topicGroup, MyChannelTopic topic) {
        ActivityResultLauncher<Intent> activityResultLauncher = this.createTopicActivityLaunch;
        CreateTopicActivity.Companion companion = CreateTopicActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        activityResultLauncher.launch(companion.a(contextRequireContext, channelNo, topicGroup.getSubjectCategoryNo(), topicGroup.getSubjectCategoryName(), topic));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void editTopicGroup(final MyChannelTopicGroup bean, final int position) {
        ft1.w(requireContext(), getString(R.string.channel_manage_update_topic_group), bean.getSubjectCategoryName(), getString(R.string.channel_manage_create_topic_group_hint), 10, new OnSaveInputListener() { // from class: com.zj.adlib.r75
            @Override // com.huachenjie.base.widget.dialog.OnSaveInputListener
            public final void a(Dialog dialog, String str) {
                ManageTopicFragment.editTopicGroup$lambda$3(this.f19246a, bean, position, dialog, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void editTopicGroup$lambda$3(ManageTopicFragment manageTopicFragment, MyChannelTopicGroup myChannelTopicGroup, int i, Dialog dialog, String str) {
        Intrinsics.checkNotNullParameter(manageTopicFragment, "this$0");
        Intrinsics.checkNotNullParameter(myChannelTopicGroup, "$bean");
        Intrinsics.checkNotNullExpressionValue(str, "text");
        String string = StringsKt.trim(str).toString();
        if (ys8.h(string)) {
            fv5.b(manageTopicFragment.getString(R.string.channel_manage_create_topic_group_error));
            return;
        }
        ManageTopicVM mViewModel = manageTopicFragment.getMViewModel();
        String channelNo = manageTopicFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        mViewModel.q(channelNo, string, myChannelTopicGroup, i, dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final void initAdapter() {
        MutableLiveData<ManageTopicAdapter> mutableLiveDataN = getMViewModel().n();
        ManageTopicAdapter manageTopicAdapter = new ManageTopicAdapter();
        manageTopicAdapter.addNodeProvider(new a99(new ManageTopicFragment$initAdapter$1$1(this), new ManageTopicFragment$initAdapter$1$2(this)));
        manageTopicAdapter.addNodeProvider(new h99(new ManageTopicFragment$initAdapter$1$3(this)));
        manageTopicAdapter.addNodeProvider(new sx1(new ManageTopicFragment$initAdapter$1$4(this)));
        View viewInflate = getLayoutInflater().inflate(R.layout.channel_view_manage_create_topic_group, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_add)).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.q75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageTopicFragment.initAdapter$lambda$1$lambda$0(this.f44143a, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewInflate, "headerView");
        BaseQuickAdapter.setHeaderView$default(manageTopicAdapter, viewInflate, 0, 0, 6, null);
        mutableLiveDataN.setValue(manageTopicAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1$lambda$0(ManageTopicFragment manageTopicFragment, View view) {
        Intrinsics.checkNotNullParameter(manageTopicFragment, "this$0");
        manageTopicFragment.addTopicGroup();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_manage_topic;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, ManageTopicVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().o().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.topic.ManageTopicFragment.initDataObservable.1
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
                    Context contextRequireContext = ManageTopicFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    String channelNo = ManageTopicFragment.this.getChannelNo();
                    Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                    ri1Var.b(contextRequireContext, channelNo, 5);
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
        ManageTopicVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.p(channelNo);
    }
}
