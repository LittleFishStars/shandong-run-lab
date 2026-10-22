package com.huachenjie.channel.page.manage_channel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelActivityManageBinding;
import com.huachenjie.channel.page.manage_channel.ManageActivity;
import com.huachenjie.channel.page.manage_channel.admin.ManageAdminFragment;
import com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoFragment;
import com.huachenjie.channel.page.manage_channel.chat.ManageChatFragment;
import com.huachenjie.channel.page.manage_channel.share.ShareSettingFragment;
import com.huachenjie.channel.page.manage_channel.topic.ManageTopicFragment;
import com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatFragment;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0002R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/ManageActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityManageBinding;", "Lcom/huachenjie/channel/page/manage_channel/ManageVM;", "", "", "V", "getLayoutResID", "", "initView", "b0", "", "b", "Lkotlin/Lazy;", "a0", "()Ljava/lang/String;", "channelNo", "", "c", "d0", "()Z", "isSubAdmin", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageActivity extends BaseMVVMActivity<ChannelActivityManageBinding, ManageVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channel_no";

    @NotNull
    public static final String x = "is_sub_admin";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.ManageActivity$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("channel_no");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy isSubAdmin = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.channel.page.manage_channel.ManageActivity$isSubAdmin$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m268invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(ManageActivity.x, false));
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.ManageActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/ManageActivity$a;", "", "Landroid/content/Context;", "context", "", "channelNo", "", "isSubAdmin", "", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "KEY_IS_SUB_ADMIN", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String channelNo, boolean isSubAdmin) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intent intent = new Intent(context, (Class<?>) ManageActivity.class);
            intent.putExtra("channel_no", channelNo);
            intent.putExtra(ManageActivity.x, isSubAdmin);
            context.startActivity(intent);
        }
    }

    public static final void c0(ManageActivity manageActivity, View view) {
        Intrinsics.checkNotNullParameter(manageActivity, "this$0");
        manageActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, ManageVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    public final String a0() {
        return (String) this.channelNo.getValue();
    }

    public final void b0() {
        String[] stringArray = getResources().getStringArray(R.array.channel_manage_tabs);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…rray.channel_manage_tabs)");
        List<String> mutableList = ArraysKt.toMutableList(stringArray);
        ManageBasicInfoFragment.Companion companion = ManageBasicInfoFragment.INSTANCE;
        String strA0 = a0();
        Intrinsics.checkNotNullExpressionValue(strA0, "channelNo");
        ManageAdminFragment.Companion companion2 = ManageAdminFragment.INSTANCE;
        String strA1 = a0();
        Intrinsics.checkNotNullExpressionValue(strA1, "channelNo");
        ManageChatFragment.Companion companion3 = ManageChatFragment.INSTANCE;
        String strA2 = a0();
        Intrinsics.checkNotNullExpressionValue(strA2, "channelNo");
        ManageTopicFragment.Companion companion4 = ManageTopicFragment.INSTANCE;
        String strA3 = a0();
        Intrinsics.checkNotNullExpressionValue(strA3, "channelNo");
        ShareSettingFragment.Companion companion5 = ShareSettingFragment.INSTANCE;
        String strA4 = a0();
        Intrinsics.checkNotNullExpressionValue(strA4, "channelNo");
        List<Fragment> listMutableListOf = CollectionsKt.mutableListOf(new Fragment[]{companion.a(strA0), companion2.a(strA1, d0()), companion3.a(strA2), companion4.a(strA3), companion5.a(strA4)});
        if (!d0()) {
            mutableList.add(mutableList.size() - 1, getResources().getString(R.string.channel_manage_topic_chat_group));
            int size = listMutableListOf.size() - 1;
            ManageTopicChatFragment.Companion companion6 = ManageTopicChatFragment.INSTANCE;
            String strA5 = a0();
            Intrinsics.checkNotNullExpressionValue(strA5, "channelNo");
            listMutableListOf.add(size, companion6.a(strA5));
        }
        getMBinding().f33088a.setOffscreenPageLimit(listMutableListOf.size());
        getMBinding().f33088a.setUserInputEnabled(false);
        getMBinding().f7572a.setViewPager(getMBinding().f33088a, mutableList, this, listMutableListOf);
    }

    public final boolean d0() {
        return ((Boolean) this.isSubAdmin.getValue()).booleanValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_manage;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.channel_manage_header_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.d75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageActivity.c0(this.f41116a, view);
            }
        }));
        b0();
    }
}
