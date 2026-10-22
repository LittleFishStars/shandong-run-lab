package com.huachenjie.channel.page.manage_channel.topic_chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopic;
import com.huachenjie.channel.databinding.ChannelActivityCreateTopicChatBinding;
import com.huachenjie.channel.page.manage_channel.topic_chat.CreateTopicChatActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.igexin.push.g.o;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/CreateTopicChatActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityCreateTopicChatBinding;", "Lcom/huachenjie/channel/page/manage_channel/topic_chat/CreateTopicChatVM;", "", "", "", "V", "getLayoutResID", "", "initView", "W", "d0", "", "b", "Lkotlin/Lazy;", "c0", "()Ljava/lang/String;", "channelNo", "<init>", "()V", "a", "ClickProxy", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CreateTopicChatActivity extends BaseMVVMActivity<ChannelActivityCreateTopicChatBinding, CreateTopicChatVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channel_no";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.topic_chat.CreateTopicChatActivity$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("channel_no");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/CreateTopicChatActivity$ClickProxy;", "", "Landroid/view/View;", "view", "", "a", "c", "b", "<init>", "(Lcom/huachenjie/channel/page/manage_channel/topic_chat/CreateTopicChatActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CreateTopicChatActivity.b0(CreateTopicChatActivity.this).m().setValue("");
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CreateTopicChatActivity.b0(CreateTopicChatActivity.this).n();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TopicListDialog.Companion bVar = TopicListDialog.INSTANCE;
            String strC0 = CreateTopicChatActivity.this.c0();
            Intrinsics.checkNotNullExpressionValue(strC0, "channelNo");
            final CreateTopicChatActivity createTopicChatActivity = CreateTopicChatActivity.this;
            TopicListDialog topicListDialogA = bVar.a(strC0, new Function1<ManageTopic, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.topic_chat.CreateTopicChatActivity$ClickProxy$selectTopic$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ManageTopic) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ManageTopic manageTopic) {
                    Intrinsics.checkNotNullParameter(manageTopic, o.f);
                    CreateTopicChatActivity.b0(createTopicChatActivity).o(manageTopic.getSubjectNo());
                    CreateTopicChatActivity.b0(createTopicChatActivity).k().setValue(manageTopic.getSubjectName());
                }
            });
            FragmentManager supportFragmentManager = CreateTopicChatActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            topicListDialogA.show(supportFragmentManager, TopicListDialog.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.topic_chat.CreateTopicChatActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/CreateTopicChatActivity$a;", "", "Landroid/content/Context;", "context", "", "channelNo", "Landroid/content/Intent;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intent intent = new Intent(context, (Class<?>) CreateTopicChatActivity.class);
            intent.putExtra("channel_no", channelNo);
            return intent;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33458a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33458a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33458a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33458a.invoke(obj);
        }
    }

    public static final /* synthetic */ CreateTopicChatVM b0(CreateTopicChatActivity createTopicChatActivity) {
        return createTopicChatActivity.getMViewModel();
    }

    public static final void e0(CreateTopicChatActivity createTopicChatActivity, View view) {
        Intrinsics.checkNotNullParameter(createTopicChatActivity, "this$0");
        createTopicChatActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().j().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.topic_chat.CreateTopicChatActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue()) {
                    this.this$0.setResult(-1);
                    this.this$0.finish();
                }
            }
        }));
    }

    public final String c0() {
        return (String) this.channelNo.getValue();
    }

    public final void d0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.channel_manage_create_topic_chat)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setShowDivider(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.rx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateTopicChatActivity.e0(this.f44560a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_create_topic_chat;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        d0();
    }
}
