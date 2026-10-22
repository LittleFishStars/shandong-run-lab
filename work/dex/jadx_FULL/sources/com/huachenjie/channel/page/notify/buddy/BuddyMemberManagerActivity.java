package com.huachenjie.channel.page.notify.buddy;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.notify.BuddyDetailUserBean;
import com.huachenjie.channel.databinding.ChannelActivityBuddyMemberManagerBinding;
import com.huachenjie.channel.page.notify.buddy.BuddyMemberManagerActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.widget.GridSpacingItemDecoration;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.pu9;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/page/notify/buddy/BuddyMemberManagerActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityBuddyMemberManagerBinding;", "Lcom/huachenjie/channel/page/notify/buddy/BuddyMemberManagerVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "c0", "b0", "<init>", "()V", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class BuddyMemberManagerActivity extends BaseMVVMActivity<ChannelActivityBuddyMemberManagerBinding, BuddyMemberManagerVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "buddyCode";

    @NotNull
    public static final String x = "buddyTitle";

    @NotNull
    public static final String y = "members";

    @NotNull
    public static final String z = "isMine";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/notify/buddy/BuddyMemberManagerActivity$a;", "", "Landroid/view/View;", "view", "", "b", "<init>", "(Lcom/huachenjie/channel/page/notify/buddy/BuddyMemberManagerActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void c(BuddyMemberManagerActivity buddyMemberManagerActivity, View view) {
            Intrinsics.checkNotNullParameter(buddyMemberManagerActivity, "this$0");
            BuddyMemberManagerActivity.a0(buddyMemberManagerActivity).p();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            boolean zAreEqual = Intrinsics.areEqual(BuddyMemberManagerActivity.a0(BuddyMemberManagerActivity.this).o().getValue(), Boolean.TRUE);
            final BuddyMemberManagerActivity buddyMemberManagerActivity = BuddyMemberManagerActivity.this;
            ft1.p(buddyMemberManagerActivity, zAreEqual ? "确定解散该搭子吗？" : "确定退出该搭子吗？", new View.OnClickListener() { // from class: com.zj.adlib.y01
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BuddyMemberManagerActivity.a.c(buddyMemberManagerActivity, view2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.notify.buddy.BuddyMemberManagerActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/channel/page/notify/buddy/BuddyMemberManagerActivity$b;", "", "Landroid/content/Context;", "context", "", "buddyCode", "title", "Ljava/util/ArrayList;", "Lcom/huachenjie/channel/bean/notify/BuddyDetailUserBean;", "Lkotlin/collections/ArrayList;", BuddyMemberManagerActivity.y, "", BuddyMemberManagerActivity.z, "", "a", "KEY_BUDDY_CODE", "Ljava/lang/String;", "KEY_BUDDY_TITLE", "KEY_IS_MINE", "KEY_MEMBERS", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String buddyCode, @NotNull String title, @NotNull ArrayList<BuddyDetailUserBean> members, boolean isMine) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(members, BuddyMemberManagerActivity.y);
            Intent intent = new Intent(context, (Class<?>) BuddyMemberManagerActivity.class);
            intent.putExtra("buddyCode", buddyCode);
            intent.putExtra("buddyTitle", title);
            intent.putParcelableArrayListExtra(BuddyMemberManagerActivity.y, members);
            intent.putExtra(BuddyMemberManagerActivity.z, isMine);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33501a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33501a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33501a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33501a.invoke(obj);
        }
    }

    public static final /* synthetic */ BuddyMemberManagerVM a0(BuddyMemberManagerActivity buddyMemberManagerActivity) {
        return buddyMemberManagerActivity.getMViewModel();
    }

    public static final void d0(BuddyMemberManagerActivity buddyMemberManagerActivity, View view) {
        Intrinsics.checkNotNullParameter(buddyMemberManagerActivity, "this$0");
        buddyMemberManagerActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().getLeaveSuccessEvent().observe(this, new c(new Function1() { // from class: com.huachenjie.channel.page.notify.buddy.BuddyMemberManagerActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Void) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Void r2) {
                if (Intrinsics.areEqual(BuddyMemberManagerActivity.a0(this.this$0).o().getValue(), Boolean.TRUE)) {
                    fv5.b("解散成功");
                } else {
                    fv5.b("退出成功");
                }
                ActivityLifecycleManager.l().f(BuddyChatRoomActivity.class);
                this.this$0.finish();
                Context applicationContext = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                pu9.a(applicationContext);
            }
        }));
    }

    public final void b0() {
        getMBinding().f33042a.addItemDecoration(new GridSpacingItemDecoration(5, ((fx7.e() - (SizeUtils.b(48.0f) * 5)) - SizeUtils.b(32.0f)) / 6, SizeUtils.b(20.0f), true));
        getMViewModel().m().setValue(new BuddyMemberAdapter());
    }

    public final void c0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("成员管理").setTitleTextColor(zn1.a(R.color.color_191F20)).setBackground(-1).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.x01
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyMemberManagerActivity.d0(this.f45722a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_buddy_member_manager;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        BuddyMemberManagerVM mViewModel = getMViewModel();
        String stringExtra = getIntent().getStringExtra("buddyCode");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra("buddyTitle");
        String str = stringExtra2 != null ? stringExtra2 : "";
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(y);
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = new ArrayList();
        }
        mViewModel.n(stringExtra, str, parcelableArrayListExtra, getIntent().getBooleanExtra(z, false));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        c0();
        b0();
    }
}
