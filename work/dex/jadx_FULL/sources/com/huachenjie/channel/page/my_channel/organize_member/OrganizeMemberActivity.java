package com.huachenjie.channel.page.my_channel.organize_member;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.OrganizeMemberAdapter;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeMemberBinding;
import com.huachenjie.channel.page.my_channel.organize_member.OrganizeMemberActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.igexin.push.g.o;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_member/OrganizeMemberActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityOrganizeMemberBinding;", "Lcom/huachenjie/channel/page/my_channel/organize_member/OrganizeMemberModel;", "", "", "", "V", "getLayoutResID", "", "initView", "W", "initData", "g0", "d0", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeMemberActivity extends BaseMVVMActivity<ChannelActivityOrganizeMemberBinding, OrganizeMemberModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "clubCode";

    /* JADX INFO: renamed from: com.huachenjie.channel.page.my_channel.organize_member.OrganizeMemberActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_member/OrganizeMemberActivity$a;", "", "Landroid/content/Context;", "context", "", "clubCode", "", "a", "CLUB_CODE", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String clubCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(clubCode, "clubCode");
            Intent intent = new Intent(context, (Class<?>) OrganizeMemberActivity.class);
            intent.putExtra("clubCode", clubCode);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33481a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33481a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33481a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33481a.invoke(obj);
        }
    }

    public static final /* synthetic */ OrganizeMemberModel c0(OrganizeMemberActivity organizeMemberActivity) {
        return organizeMemberActivity.getMViewModel();
    }

    public static final void e0(OrganizeMemberActivity organizeMemberActivity) {
        Intrinsics.checkNotNullParameter(organizeMemberActivity, "this$0");
        BaseStateRequestModel.x(organizeMemberActivity.getMViewModel(), false, 1, null);
    }

    public static final void f0(OrganizeMemberAdapter organizeMemberAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(organizeMemberAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", organizeMemberAdapter.getData().get(i).getAppUserCode()).navigation();
    }

    public static final void h0(OrganizeMemberActivity organizeMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(organizeMemberActivity, "this$0");
        organizeMemberActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().D().observe(this, new b(new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.my_channel.organize_member.OrganizeMemberActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                BindingTitleBean value = OrganizeMemberActivity.c0(this.this$0).i().getValue();
                if (value != null) {
                    OrganizeMemberActivity organizeMemberActivity = this.this$0;
                    value.setTitleName(organizeMemberActivity.getString(R.string.channel_organize_member_title, num));
                    OrganizeMemberActivity.c0(organizeMemberActivity).i().setValue(value);
                }
            }
        }));
    }

    public final void d0() {
        OrganizeMemberAdapter value = getMViewModel().B().getValue();
        Intrinsics.checkNotNull(value);
        final OrganizeMemberAdapter organizeMemberAdapter = value;
        OrganizeMemberModel mViewModel = getMViewModel();
        StateLayout stateLayout = getMBinding().f7655a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, organizeMemberAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, organizeMemberAdapter, false, 4, null);
        organizeMemberAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.ne6
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                OrganizeMemberActivity.e0(this.f43509a);
            }
        });
        Intrinsics.checkNotNullExpressionValue(organizeMemberAdapter, "adapter");
        y57.d(organizeMemberAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.oe6
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrganizeMemberActivity.f0(organizeMemberAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    public final void g0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.channel_organize_member_title, 0)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.me6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizeMemberActivity.h0(this.f43281a, view);
            }
        }).setBackground(-1));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_organize_member;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        OrganizeMemberModel mViewModel = getMViewModel();
        String stringExtra = getIntent().getStringExtra("clubCode");
        if (stringExtra == null) {
            stringExtra = "";
        }
        mViewModel.F(stringExtra);
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        g0();
        d0();
        getMBinding().f7656a.setSearchListener(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.my_channel.organize_member.OrganizeMemberActivity.initView.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                OrganizeMemberActivity.c0(OrganizeMemberActivity.this).E().setValue(str);
                OrganizeMemberActivity.c0(OrganizeMemberActivity.this).y();
            }
        });
        getMBinding().f7656a.setClearListener(new Function0<Unit>() { // from class: com.huachenjie.channel.page.my_channel.organize_member.OrganizeMemberActivity.initView.2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m298invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m298invoke() {
                if (TextUtils.isEmpty(OrganizeMemberActivity.c0(OrganizeMemberActivity.this).E().getValue())) {
                    return;
                }
                OrganizeMemberActivity.c0(OrganizeMemberActivity.this).E().setValue("");
                OrganizeMemberActivity.c0(OrganizeMemberActivity.this).y();
            }
        });
    }
}
