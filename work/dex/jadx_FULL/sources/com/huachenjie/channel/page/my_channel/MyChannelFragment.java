package com.huachenjie.channel.page.my_channel;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Lifecycle;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.huachenjie.ad.interfaces.BannerAdListener;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.base.bean.TabEntity;
import com.huachenjie.base.util.CustomerServiceUtil;
import com.huachenjie.base.widget.MoreOptDialog;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelDetail;
import com.huachenjie.channel.databinding.ChannelFragmentMyChannelBinding;
import com.huachenjie.channel.page.advertise.AdvertiseActivity;
import com.huachenjie.channel.page.all_member.AllMemberActivity;
import com.huachenjie.channel.page.create_channel.type.ChooseChannelTypeActivity;
import com.huachenjie.channel.page.manage_channel.ManageActivity;
import com.huachenjie.channel.page.my_channel.MyChannelFragment;
import com.huachenjie.channel.page.my_channel.communication.CommunicationFragment;
import com.huachenjie.channel.page.my_channel.my_organize.MyOrganizeActivity;
import com.huachenjie.channel.page.my_channel.organize.OrganizeFragment;
import com.huachenjie.channel.page.my_channel.topic.TopicFragment;
import com.huachenjie.channel.page.organize.OrganizeActivity;
import com.huachenjie.channel.utils.channel.ChannelRefreshReceiver;
import com.huachenjie.channel.widget.NotSaveStateTabLayout;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.reconfig.baseView.BaseFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.igexin.push.g.o;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.ew;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.kl3;
import com.zj.adlib.ku5;
import com.zj.adlib.r8a;
import com.zj.adlib.r90;
import com.zj.adlib.ri1;
import com.zj.adlib.su9;
import com.zj.adlib.tk0;
import com.zj.adlib.vb8;
import com.zj.adlib.w88;
import com.zj.adlib.wt1;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002BCB\u0007¢\u0006\u0004\b?\u0010@J \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\nR\u001b\u0010'\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010+\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R$\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R$\u0010=\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010;0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/MyChannelFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentMyChannelBinding;", "Lcom/huachenjie/channel/page/my_channel/MyChannelVM;", "", "certificationFlag", "Ljava/util/ArrayList;", "Lcom/flyco/tablayout/listener/CustomTabEntity;", "Lkotlin/collections/ArrayList;", "createTabEntity", "", "initTabLayout", "initOrganizeTab", "initReceiver", "initAd", "", "channelStatus", "", "failReason", "initStateView", "cancelCreate", "updateEdit", "index", "updateChildDataRefresh", "", "", "getVariables", "getLayoutResID", "initView", "onDestroyView", "onResume", "initDataObservable", "registerObserveContact", "unregisterObserveContact", "updateRefresh", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "channelType$delegate", "getChannelType", "()I", MyChannelFragment.KEY_CHANNEL_YPE, "Lcom/huachenjie/channel/utils/channel/ChannelRefreshReceiver;", "receiver", "Lcom/huachenjie/channel/utils/channel/ChannelRefreshReceiver;", "Lkotlin/Function0;", "onChannelDelete", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "onChannelStatusCallback", "Lkotlin/jvm/functions/Function1;", "Lcom/zj/adlib/kl3;", "manager", "Lcom/zj/adlib/kl3;", "needReload", "Z", "Lcom/netease/nimlib/sdk/Observer;", "", "Lcom/netease/nimlib/sdk/msg/model/RecentContact;", "contactObserver", "Lcom/netease/nimlib/sdk/Observer;", "<init>", "()V", "Companion", "ClickProxy", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMyChannelFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyChannelFragment.kt\ncom/huachenjie/channel/page/my_channel/MyChannelFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,456:1\n1855#2,2:457\n*S KotlinDebug\n*F\n+ 1 MyChannelFragment.kt\ncom/huachenjie/channel/page/my_channel/MyChannelFragment\n*L\n443#1:457,2\n*E\n"})
public final class MyChannelFragment extends BaseMVVMFragment<ChannelFragmentMyChannelBinding, MyChannelVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channelNo";

    @NotNull
    private static final String KEY_CHANNEL_YPE = "channelType";

    @Nullable
    private kl3 manager;

    @Nullable
    private Function0<Unit> onChannelDelete;

    @Nullable
    private Function1<? super Integer, Unit> onChannelStatusCallback;

    @Nullable
    private ChannelRefreshReceiver receiver;

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.my_channel.MyChannelFragment$channelNo$2
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

    /* JADX INFO: renamed from: channelType$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.channel.page.my_channel.MyChannelFragment$channelType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m293invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("channelType") : 0);
        }
    });
    private boolean needReload = true;

    @NotNull
    private final Observer<List<RecentContact>> contactObserver = new ku5(this);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/MyChannelFragment$ClickProxy;", "", "Landroid/view/View;", "view", "", "b", "c", "d", "a", "<init>", "(Lcom/huachenjie/channel/page/my_channel/MyChannelFragment;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MyChannelDetail value = MyChannelFragment.access$getMViewModel(MyChannelFragment.this).l().getValue();
            boolean z = false;
            if (value != null && !value.isRunOrUniverseChannel()) {
                z = true;
            }
            if (z) {
                MyChannelFragment myChannelFragment = MyChannelFragment.this;
                AllMemberActivity.Companion aVar = AllMemberActivity.INSTANCE;
                Context contextRequireContext = myChannelFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                int i = AllMemberActivity.K;
                String channelNo = MyChannelFragment.this.getChannelNo();
                Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                myChannelFragment.startActivity(aVar.a(contextRequireContext, i, channelNo));
            }
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MyChannelDetail value = MyChannelFragment.access$getMViewModel(MyChannelFragment.this).l().getValue();
            Integer numValueOf = value != null ? Integer.valueOf(value.getChannelStatus()) : null;
            if (numValueOf != null && numValueOf.intValue() == 1) {
                fv5.b(MyChannelFragment.this.getString(R.string.channel_my_channel_refuse_by_auditing));
                return;
            }
            if (numValueOf != null && numValueOf.intValue() == 3) {
                fv5.b(MyChannelFragment.this.getString(R.string.channel_my_channel_refuse_by_audit_fail));
            } else if (numValueOf != null && numValueOf.intValue() == 2) {
                ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", MyChannelFragment.this.getChannelNo()).navigation();
            }
        }

        public final void c(@NotNull final View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            final MyChannelDetail value = MyChannelFragment.access$getMViewModel(MyChannelFragment.this).l().getValue();
            boolean z = false;
            if (value != null && value.getChannelStatus() == 1) {
                fv5.b(MyChannelFragment.this.getString(R.string.channel_my_channel_refuse_by_auditing));
                return;
            }
            if (value != null && value.getChannelStatus() == 3) {
                fv5.b(MyChannelFragment.this.getString(R.string.channel_my_channel_refuse_by_audit_fail));
                return;
            }
            if (value != null && value.getChannelStatus() == 2) {
                z = true;
            }
            if (z) {
                ArrayList<MoreOptBean> arrayList = new ArrayList<>();
                if (value.isAdminOrSubAdmin()) {
                    arrayList.add(new MoreOptBean("管理频道", R.drawable.channel_ic_menu_manage, 1));
                    if (value.getCertificationFlag()) {
                        arrayList.add(new MoreOptBean("频道广告", R.drawable.channel_ic_menu_ad, 2));
                        arrayList.add(new MoreOptBean("官方组织", R.drawable.channel_ic_menu_certification, 3));
                    }
                }
                if (value.getClubAdminFlag()) {
                    arrayList.add(new MoreOptBean("我的组织", R.drawable.channel_ic_menu_my_orz, 4));
                }
                arrayList.add(new MoreOptBean("分享频道", R.drawable.channel_ic_menu_share, 5));
                MoreOptDialog.Companion aVar = MoreOptDialog.INSTANCE;
                final MyChannelFragment myChannelFragment = MyChannelFragment.this;
                MoreOptDialog moreOptDialogA = aVar.a(arrayList, new Function2<MoreOptBean, Integer, Unit>() { // from class: com.huachenjie.channel.page.my_channel.MyChannelFragment$ClickProxy$clickManage$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((MoreOptBean) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull MoreOptBean moreOptBean, int i) {
                        Intrinsics.checkNotNullParameter(moreOptBean, "menu");
                        int optType = moreOptBean.getOptType();
                        if (optType == 1) {
                            ManageActivity.a aVar2 = ManageActivity.f33416a;
                            Context contextRequireContext = myChannelFragment.requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                            aVar2.a(contextRequireContext, value.getChannelNo(), value.getChannelMemberType() == 2);
                            return;
                        }
                        if (optType == 2) {
                            AdvertiseActivity.a aVar3 = AdvertiseActivity.f33354a;
                            Context context = view.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "view.context");
                            String channelNo = myChannelFragment.getChannelNo();
                            Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                            aVar3.a(context, channelNo);
                            return;
                        }
                        if (optType == 3) {
                            OrganizeActivity.b bVar = OrganizeActivity.f33510a;
                            Context context2 = view.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                            String channelNo2 = myChannelFragment.getChannelNo();
                            Intrinsics.checkNotNullExpressionValue(channelNo2, "channelNo");
                            bVar.a(context2, channelNo2, value.getChannelMemberType() == 1);
                            return;
                        }
                        if (optType != 4) {
                            if (optType != 5) {
                                return;
                            }
                            MyChannelDetail myChannelDetail = value;
                            FragmentManager childFragmentManager = myChannelFragment.getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "this@MyChannelFragment.childFragmentManager");
                            w88.b(myChannelDetail, childFragmentManager);
                            return;
                        }
                        MyOrganizeActivity.b bVar2 = MyOrganizeActivity.f33475a;
                        Context context3 = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
                        String channelNo3 = myChannelFragment.getChannelNo();
                        Intrinsics.checkNotNullExpressionValue(channelNo3, "channelNo");
                        bVar2.a(context3, channelNo3);
                    }
                });
                FragmentManager childFragmentManager = MyChannelFragment.this.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                moreOptDialogA.show(childFragmentManager, Reflection.getOrCreateKotlinClass(MoreOptDialog.class).getSimpleName());
            }
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MyChannelDetail value = MyChannelFragment.access$getMViewModel(MyChannelFragment.this).l().getValue();
            Integer numValueOf = value != null ? Integer.valueOf(value.getChannelType()) : null;
            if (numValueOf != null && numValueOf.intValue() == 1) {
                CustomerServiceUtil.f32958a.f(MyChannelFragment.this);
            } else if (numValueOf != null && numValueOf.intValue() == 2) {
                su9.p(MyChannelFragment.this.requireContext(), "");
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.my_channel.MyChannelFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J@\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/MyChannelFragment$a;", "", "", "channelNo", "", MyChannelFragment.KEY_CHANNEL_YPE, "Lkotlin/Function0;", "", "onChannelDelete", "Lkotlin/Function1;", "onChannelStatusCallback", "Lcom/huachenjie/channel/page/my_channel/MyChannelFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "KEY_CHANNEL_YPE", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MyChannelFragment b(Companion companion, String str, int i, Function0 function0, Function1 function1, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                function0 = null;
            }
            if ((i2 & 8) != 0) {
                function1 = null;
            }
            return companion.a(str, i, function0, function1);
        }

        @NotNull
        public final MyChannelFragment a(@NotNull String channelNo, int channelType, @Nullable Function0<Unit> onChannelDelete, @Nullable Function1<? super Integer, Unit> onChannelStatusCallback) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            MyChannelFragment myChannelFragment = new MyChannelFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelNo", channelNo);
            bundle.putInt(MyChannelFragment.KEY_CHANNEL_YPE, channelType);
            myChannelFragment.setArguments(bundle);
            myChannelFragment.onChannelDelete = onChannelDelete;
            myChannelFragment.onChannelStatusCallback = onChannelStatusCallback;
            return myChannelFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/channel/page/my_channel/MyChannelFragment$b", "Lcom/huachenjie/ad/interfaces/BannerAdListener;", "", "loadSupplier", "", "b", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements BannerAdListener {
        public b() {
        }

        @Override // com.huachenjie.ad.interfaces.BannerAdListener
        public void a(int loadSupplier) {
            ChannelFragmentMyChannelBinding channelFragmentMyChannelBindingAccess$getMBinding = MyChannelFragment.access$getMBinding(MyChannelFragment.this);
            FrameLayout frameLayout = channelFragmentMyChannelBindingAccess$getMBinding != null ? channelFragmentMyChannelBindingAccess$getMBinding.f33192a : null;
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(8);
        }

        @Override // com.huachenjie.ad.interfaces.BannerAdListener
        public void b(int loadSupplier) {
            ChannelFragmentMyChannelBinding channelFragmentMyChannelBindingAccess$getMBinding = MyChannelFragment.access$getMBinding(MyChannelFragment.this);
            FrameLayout frameLayout = channelFragmentMyChannelBindingAccess$getMBinding != null ? channelFragmentMyChannelBindingAccess$getMBinding.f33192a : null;
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/channel/page/my_channel/MyChannelFragment$c", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements OnTabSelectListener {
        public c() {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            kl3 kl3Var = MyChannelFragment.this.manager;
            if (kl3Var != null) {
                kl3Var.h(position);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements androidx.p002lifecycle.Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33471a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33471a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof androidx.p002lifecycle.Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33471a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33471a.invoke(obj);
        }
    }

    public static final /* synthetic */ ChannelFragmentMyChannelBinding access$getMBinding(MyChannelFragment myChannelFragment) {
        return myChannelFragment.getMBinding();
    }

    public static final /* synthetic */ MyChannelVM access$getMViewModel(MyChannelFragment myChannelFragment) {
        return myChannelFragment.getMViewModel();
    }

    private final void cancelCreate() {
        ft1.o(requireContext(), getString(R.string.channel_my_channel_cancel_content), getString(R.string.cancel), getString(R.string.ok), new View.OnClickListener() { // from class: com.zj.adlib.ju5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyChannelFragment.cancelCreate$lambda$7(this.f42676a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelCreate$lambda$7(MyChannelFragment myChannelFragment, View view) {
        Intrinsics.checkNotNullParameter(myChannelFragment, "this$0");
        MyChannelVM mViewModel = myChannelFragment.getMViewModel();
        String channelNo = myChannelFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.i(channelNo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contactObserver$lambda$8(MyChannelFragment myChannelFragment, List list) {
        Intrinsics.checkNotNullParameter(myChannelFragment, "this$0");
        List list2 = list;
        boolean z = false;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        kl3 kl3Var = myChannelFragment.manager;
        Object objD = kl3Var != null ? kl3Var.d(1) : null;
        TopicFragment topicFragment = objD instanceof TopicFragment ? (TopicFragment) objD : null;
        if (topicFragment != null && topicFragment.isAdded()) {
            Intrinsics.checkNotNullExpressionValue(list, o.f);
            topicFragment.updateChatMessage(list);
        }
        kl3 kl3Var2 = myChannelFragment.manager;
        Object objD2 = kl3Var2 != null ? kl3Var2.d(2) : null;
        OrganizeFragment organizeFragment = objD2 instanceof OrganizeFragment ? (OrganizeFragment) objD2 : null;
        if (organizeFragment != null && organizeFragment.isAdded()) {
            z = true;
        }
        if (z) {
            Intrinsics.checkNotNullExpressionValue(list, o.f);
            organizeFragment.updateChatMessage(list);
        }
    }

    private final ArrayList<CustomTabEntity> createTabEntity(boolean certificationFlag) {
        ArrayList<CustomTabEntity> arrayListArrayListOf = CollectionsKt.arrayListOf(new CustomTabEntity[]{new TabEntity("交流区"), new TabEntity("频道话题")});
        if (certificationFlag) {
            arrayListArrayListOf.add(new TabEntity("官方组织"));
        }
        return arrayListArrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final int getChannelType() {
        return ((Number) this.channelType.getValue()).intValue();
    }

    private final void initAd() {
        if (getChannelType() != 1) {
            return;
        }
        AdPlatformSwitch adPlatformSwitchE = r90.e("srocb");
        if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
            int iJ = fx7.j() - SizeUtils.b(92.0f);
            int i = (iJ * 50) / 320;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Lifecycle lifecycle = getLifecycle();
            ChannelFragmentMyChannelBinding mBinding = getMBinding();
            ew.n(fragmentActivityRequireActivity, vb8.d, r8a.k, lifecycle, mBinding != null ? mBinding.f33192a : null, iJ, i, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initOrganizeTab(boolean certificationFlag) {
        NotSaveStateTabLayout notSaveStateTabLayout;
        NotSaveStateTabLayout notSaveStateTabLayout2;
        NotSaveStateTabLayout notSaveStateTabLayout3;
        ChannelFragmentMyChannelBinding mBinding = getMBinding();
        Integer numValueOf = (mBinding == null || (notSaveStateTabLayout3 = mBinding.f7841a) == null) ? null : Integer.valueOf(notSaveStateTabLayout3.getTabCount());
        ChannelFragmentMyChannelBinding mBinding2 = getMBinding();
        Integer numValueOf2 = (mBinding2 == null || (notSaveStateTabLayout2 = mBinding2.f7841a) == null) ? null : Integer.valueOf(notSaveStateTabLayout2.getCurrentTab());
        if (numValueOf != null && numValueOf.intValue() == 3 && certificationFlag) {
            return;
        }
        if (numValueOf == null || numValueOf.intValue() != 2 || certificationFlag) {
            if (!certificationFlag && numValueOf2 != null && numValueOf2.intValue() == 2) {
                ChannelFragmentMyChannelBinding mBinding3 = getMBinding();
                NotSaveStateTabLayout notSaveStateTabLayout4 = mBinding3 != null ? mBinding3.f7841a : null;
                if (notSaveStateTabLayout4 != null) {
                    notSaveStateTabLayout4.setCurrentTab(0);
                }
                kl3 kl3Var = this.manager;
                if (kl3Var != null) {
                    kl3Var.h(0);
                }
            }
            ChannelFragmentMyChannelBinding mBinding4 = getMBinding();
            if (mBinding4 != null && (notSaveStateTabLayout = mBinding4.f7841a) != null) {
                notSaveStateTabLayout.setTabData(createTabEntity(certificationFlag));
            }
            if (!certificationFlag) {
                kl3 kl3Var2 = this.manager;
                if (kl3Var2 != null) {
                    kl3Var2.f(2);
                    return;
                }
                return;
            }
            kl3 kl3Var3 = this.manager;
            if (kl3Var3 != null) {
                OrganizeFragment.Companion aVar = OrganizeFragment.INSTANCE;
                String channelNo = getChannelNo();
                Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                kl3Var3.a(aVar.a(channelNo));
            }
        }
    }

    private final void initReceiver() {
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        this.receiver = new ChannelRefreshReceiver(channelNo, new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.my_channel.MyChannelFragment.initReceiver.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                        MyChannelFragment.this.needReload = true;
                        break;
                    case 4:
                        MyChannelFragment.this.updateChildDataRefresh(0);
                        break;
                    case 5:
                    case 6:
                        MyChannelFragment.this.updateChildDataRefresh(1);
                        break;
                    case 7:
                        MyChannelFragment.this.updateChildDataRefresh(2);
                        break;
                }
            }
        });
        ri1 ri1Var = ri1.f19330a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ChannelRefreshReceiver channelRefreshReceiver = this.receiver;
        Intrinsics.checkNotNull(channelRefreshReceiver);
        ri1Var.a(contextRequireContext, channelRefreshReceiver);
        registerObserveContact();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initStateView(int channelStatus, String failReason) {
        ChannelFragmentMyChannelBinding mBinding;
        FrameLayout frameLayout;
        ChannelFragmentMyChannelBinding mBinding2;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        FrameLayout frameLayout4;
        ChannelFragmentMyChannelBinding mBinding3 = getMBinding();
        int childCount = (mBinding3 == null || (frameLayout4 = mBinding3.b) == null) ? 0 : frameLayout4.getChildCount();
        View viewInflate = null;
        if (childCount > 1) {
            for (int i = 0; i < childCount; i++) {
                ChannelFragmentMyChannelBinding mBinding4 = getMBinding();
                View childAt = (mBinding4 == null || (frameLayout3 = mBinding4.b) == null) ? null : frameLayout3.getChildAt(i);
                if (!(childAt != null && childAt.getId() == R.id.ll_page) && (mBinding2 = getMBinding()) != null && (frameLayout2 = mBinding2.b) != null) {
                    frameLayout2.removeView(childAt);
                }
            }
        }
        if (channelStatus == 2 || channelStatus == 4) {
            ChannelFragmentMyChannelBinding mBinding5 = getMBinding();
            viewInflate = mBinding5 != null ? mBinding5.f7842a : null;
            if (viewInflate == null) {
                return;
            }
            viewInflate.setVisibility(0);
            return;
        }
        ChannelFragmentMyChannelBinding mBinding6 = getMBinding();
        BLLinearLayout bLLinearLayout = mBinding6 != null ? mBinding6.f7842a : null;
        if (bLLinearLayout != null) {
            bLLinearLayout.setVisibility(8);
        }
        if (channelStatus == 1) {
            viewInflate = getLayoutInflater().inflate(R.layout.channel_view_my_channel_auditing, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(R.id.btn_cancel);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.lu5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MyChannelFragment.initStateView$lambda$2$lambda$1(this.f43151a, view);
                    }
                });
            }
        } else if (channelStatus == 3) {
            viewInflate = getLayoutInflater().inflate(R.layout.channel_view_my_channel_audit_fail, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_audit_info);
            if (textView != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(R.string.channel_my_channel_audit_fail_tip);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chann…y_channel_audit_fail_tip)");
                String str = String.format(string, Arrays.copyOf(new Object[]{failReason}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView.setText(str);
            }
            View viewFindViewById2 = viewInflate.findViewById(R.id.btn_cancel);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.mu5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MyChannelFragment.initStateView$lambda$5$lambda$3(this.f43385a, view);
                    }
                });
            }
            View viewFindViewById3 = viewInflate.findViewById(R.id.btn_update);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nu5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MyChannelFragment.initStateView$lambda$5$lambda$4(this.f43609a, view);
                    }
                });
            }
        }
        if (viewInflate == null || (mBinding = getMBinding()) == null || (frameLayout = mBinding.b) == null) {
            return;
        }
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initStateView$lambda$2$lambda$1(MyChannelFragment myChannelFragment, View view) {
        Intrinsics.checkNotNullParameter(myChannelFragment, "this$0");
        myChannelFragment.cancelCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initStateView$lambda$5$lambda$3(MyChannelFragment myChannelFragment, View view) {
        Intrinsics.checkNotNullParameter(myChannelFragment, "this$0");
        myChannelFragment.cancelCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initStateView$lambda$5$lambda$4(MyChannelFragment myChannelFragment, View view) {
        Intrinsics.checkNotNullParameter(myChannelFragment, "this$0");
        myChannelFragment.updateEdit();
    }

    private final void initTabLayout() {
        NotSaveStateTabLayout notSaveStateTabLayout;
        NotSaveStateTabLayout notSaveStateTabLayout2;
        CommunicationFragment.Companion aVar = CommunicationFragment.INSTANCE;
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        TopicFragment.Companion aVar2 = TopicFragment.INSTANCE;
        String channelNo2 = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo2, "channelNo");
        ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf(new Fragment[]{aVar.a(channelNo), aVar2.a(channelNo2)});
        ChannelFragmentMyChannelBinding mBinding = getMBinding();
        if (mBinding != null && (notSaveStateTabLayout2 = mBinding.f7841a) != null) {
            notSaveStateTabLayout2.setTabData(createTabEntity(false));
        }
        this.manager = new kl3(getChildFragmentManager(), R.id.fl_page_content, arrayListArrayListOf);
        ChannelFragmentMyChannelBinding mBinding2 = getMBinding();
        if (mBinding2 == null || (notSaveStateTabLayout = mBinding2.f7841a) == null) {
            return;
        }
        notSaveStateTabLayout.setOnTabSelectListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x001d  */
    public final void updateChildDataRefresh(int index) {
        boolean z;
        kl3 kl3Var = this.manager;
        Object objD = kl3Var != null ? kl3Var.d(index) : null;
        BaseFragment baseFragment = objD instanceof BaseFragment ? (BaseFragment) objD : null;
        if (baseFragment != null) {
            z = baseFragment.isAdded();
        }
        if (z) {
            baseFragment.updateHasLoadData(false);
        }
    }

    private final void updateEdit() {
        ChooseChannelTypeActivity.Companion aVar = ChooseChannelTypeActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        aVar.a(contextRequireContext, getChannelNo());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_my_channel;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().l().observe(this, new d(new Function1<MyChannelDetail, Unit>() { // from class: com.huachenjie.channel.page.my_channel.MyChannelFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MyChannelDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MyChannelDetail myChannelDetail) {
                MyChannelFragment.this.initOrganizeTab(myChannelDetail.getCertificationFlag());
                MyChannelFragment.this.initStateView(myChannelDetail.getChannelStatus(), myChannelDetail.getFailReason());
                if (myChannelDetail.getPopFlag()) {
                    CreateSuccessDialog.Companion bVar = CreateSuccessDialog.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(myChannelDetail, o.f);
                    CreateSuccessDialog createSuccessDialogA = bVar.a(myChannelDetail);
                    FragmentManager childFragmentManager = MyChannelFragment.this.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    createSuccessDialogA.show(childFragmentManager, Reflection.getOrCreateKotlinClass(CreateSuccessDialog.class).getSimpleName());
                }
                Function1 function1 = MyChannelFragment.this.onChannelStatusCallback;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(myChannelDetail.getChannelStatus()));
                }
            }
        }));
        getMViewModel().k().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.my_channel.MyChannelFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Function0 function0;
                if (Intrinsics.areEqual(bool, Boolean.TRUE) && (function0 = MyChannelFragment.this.onChannelDelete) != null) {
                    function0.invoke();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initTabLayout();
        initReceiver();
        initAd();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ChannelRefreshReceiver channelRefreshReceiver = this.receiver;
        if (channelRefreshReceiver != null) {
            ri1 ri1Var = ri1.f19330a;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            ri1Var.c(contextRequireContext, channelRefreshReceiver);
        }
        unregisterObserveContact();
        this.needReload = true;
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isHidden() || !this.needReload) {
            return;
        }
        this.needReload = false;
        MyChannelVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.m(channelNo);
    }

    public final void registerObserveContact() {
        wt1.h().k().c(this.contactObserver);
    }

    public final void unregisterObserveContact() {
        wt1.h().k().p(this.contactObserver);
    }

    public final void updateRefresh() {
        ArrayList<Fragment> arrayListE;
        this.needReload = true;
        kl3 kl3Var = this.manager;
        if (kl3Var == null || (arrayListE = kl3Var.e()) == null) {
            return;
        }
        for (Fragment fragment : arrayListE) {
            if (fragment.isAdded()) {
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.huachenjie.common.reconfig.baseView.BaseFragment");
                ((BaseFragment) fragment).updateHasLoadData(false);
            }
        }
    }
}
