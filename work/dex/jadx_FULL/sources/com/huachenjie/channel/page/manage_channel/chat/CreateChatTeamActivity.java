package com.huachenjie.channel.page.manage_channel.chat;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.channel.databinding.ChannelActivityCreateChatTeamBinding;
import com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.igexin.push.g.o;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.tk0;
import com.zj.adlib.ys8;
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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#\"B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/chat/CreateChatTeamActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityCreateChatTeamBinding;", "Lcom/huachenjie/channel/page/manage_channel/chat/CreateChatTeamVM;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "W", "initToolbar", "h0", "", "b", "Lkotlin/Lazy;", "e0", "()Ljava/lang/String;", "channelNo", "c", "f0", "teamGroupCode", "d", "g0", "teamGroupTitle", "", "e", "j0", "()Z", "isEdit", "<init>", "()V", "a", "ClickProxy", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCreateChatTeamActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateChatTeamActivity.kt\ncom/huachenjie/channel/page/manage_channel/chat/CreateChatTeamActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,176:1\n65#2,16:177\n93#2,3:193\n*S KotlinDebug\n*F\n+ 1 CreateChatTeamActivity.kt\ncom/huachenjie/channel/page/manage_channel/chat/CreateChatTeamActivity\n*L\n98#1:177,16\n98#1:193,3\n*E\n"})
public final class CreateChatTeamActivity extends BaseMVVMActivity<ChannelActivityCreateChatTeamBinding, CreateChatTeamVM> {

    @NotNull
    public static final String A = "team_group_code";

    @NotNull
    public static final String B = "team_group_title";

    @NotNull
    public static final String C = "chat_team";
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "result_type";

    @NotNull
    public static final String x = "result_team_group_code";

    @NotNull
    public static final String y = "result_team_chat";

    @NotNull
    public static final String z = "channel_no";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity$channelNo$2
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
    public final Lazy teamGroupCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity$teamGroupCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(CreateChatTeamActivity.A);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy teamGroupTitle = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity$teamGroupTitle$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(CreateChatTeamActivity.B);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy isEdit = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity$isEdit$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m275invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getParcelableExtra(CreateChatTeamActivity.C) != null);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/chat/CreateChatTeamActivity$ClickProxy;", "", "Landroid/view/View;", "view", "", "d", "v", "c", "b", "<init>", "(Lcom/huachenjie/channel/page/manage_channel/chat/CreateChatTeamActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public static final void e(CreateChatTeamActivity createChatTeamActivity, View view) {
            Intrinsics.checkNotNullParameter(createChatTeamActivity, "this$0");
            CreateChatTeamVM createChatTeamVMB0 = CreateChatTeamActivity.b0(createChatTeamActivity);
            String strE0 = createChatTeamActivity.e0();
            Intrinsics.checkNotNullExpressionValue(strE0, "channelNo");
            String strF0 = createChatTeamActivity.f0();
            Intrinsics.checkNotNullExpressionValue(strF0, "teamGroupCode");
            createChatTeamVMB0.j(strE0, strF0);
        }

        public final void b(@Nullable View view) {
            if (CreateChatTeamActivity.this.j0()) {
                CreateChatTeamVM createChatTeamVMB0 = CreateChatTeamActivity.b0(CreateChatTeamActivity.this);
                String strE0 = CreateChatTeamActivity.this.e0();
                Intrinsics.checkNotNullExpressionValue(strE0, "channelNo");
                createChatTeamVMB0.k(strE0);
                return;
            }
            CreateChatTeamVM createChatTeamVMB1 = CreateChatTeamActivity.b0(CreateChatTeamActivity.this);
            String strE1 = CreateChatTeamActivity.this.e0();
            Intrinsics.checkNotNullExpressionValue(strE1, "channelNo");
            String strF0 = CreateChatTeamActivity.this.f0();
            Intrinsics.checkNotNullExpressionValue(strF0, "teamGroupCode");
            createChatTeamVMB1.i(strE1, strF0);
        }

        public final void c(@Nullable View v) {
            SelectChatTeamLogoDialog.Companion aVar = SelectChatTeamLogoDialog.INSTANCE;
            final CreateChatTeamActivity createChatTeamActivity = CreateChatTeamActivity.this;
            SelectChatTeamLogoDialog selectChatTeamLogoDialogA = aVar.a(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity$ClickProxy$clickSelectLogo$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, o.f);
                    MyChannelChatTeam value = CreateChatTeamActivity.b0(createChatTeamActivity).m().getValue();
                    if (value != null) {
                        CreateChatTeamActivity createChatTeamActivity2 = createChatTeamActivity;
                        value.setLogoUrl(str);
                        CreateChatTeamActivity.b0(createChatTeamActivity2).m().setValue(value);
                    }
                }
            });
            FragmentManager supportFragmentManager = CreateChatTeamActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            selectChatTeamLogoDialogA.show(supportFragmentManager, SelectChatTeamLogoDialog.class.getSimpleName());
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CreateChatTeamActivity createChatTeamActivity = CreateChatTeamActivity.this;
            String strE = ys8.e(R.string.channel_manage_delete_chat_team);
            final CreateChatTeamActivity createChatTeamActivity2 = CreateChatTeamActivity.this;
            ft1.p(createChatTeamActivity, strE, new View.OnClickListener() { // from class: com.zj.adlib.fx1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CreateChatTeamActivity.ClickProxy.e(createChatTeamActivity2, view2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/chat/CreateChatTeamActivity$a;", "", "Landroid/content/Context;", "context", "", "channelNo", "teamGroupCode", "teamGroupTitle", "Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeam;", "chanTeam", "Landroid/content/Intent;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "KEY_CHAT_TEAM", "KEY_TEAM_GROUP_CODE", "KEY_TEAM_GROUP_TITLE", "RESULT_TEAM_CHAT", "RESULT_TEAM_GROUP_CODE", "RESULT_TYPE", "", "RESULT_TYPE_ADD", "I", "RESULT_TYPE_DELETE", "RESULT_TYPE_EDIT", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, String str, String str2, String str3, MyChannelChatTeam myChannelChatTeam, int i, Object obj) {
            if ((i & 16) != 0) {
                myChannelChatTeam = null;
            }
            return companion.a(context, str, str2, str3, myChannelChatTeam);
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull String channelNo, @NotNull String teamGroupCode, @NotNull String teamGroupTitle, @Nullable MyChannelChatTeam chanTeam) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intrinsics.checkNotNullParameter(teamGroupCode, "teamGroupCode");
            Intrinsics.checkNotNullParameter(teamGroupTitle, "teamGroupTitle");
            Intent intent = new Intent(context, (Class<?>) CreateChatTeamActivity.class);
            intent.putExtra("channel_no", channelNo);
            intent.putExtra(CreateChatTeamActivity.A, teamGroupCode);
            intent.putExtra(CreateChatTeamActivity.B, teamGroupTitle);
            intent.putExtra(CreateChatTeamActivity.C, chanTeam);
            return intent;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 CreateChatTeamActivity.kt\ncom/huachenjie/channel/page/manage_channel/chat/CreateChatTeamActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n99#2,5:98\n71#3:103\n77#4:104\n*E\n"})
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
            MyChannelChatTeam value = CreateChatTeamActivity.b0(CreateChatTeamActivity.this).m().getValue();
            if (value != null) {
                value.setTeamTitle(String.valueOf(s));
                CreateChatTeamActivity.b0(CreateChatTeamActivity.this).m().setValue(value);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33433a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33433a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33433a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33433a.invoke(obj);
        }
    }

    public static final /* synthetic */ CreateChatTeamVM b0(CreateChatTeamActivity createChatTeamActivity) {
        return createChatTeamActivity.getMViewModel();
    }

    public static final void i0(CreateChatTeamActivity createChatTeamActivity, View view) {
        Intrinsics.checkNotNullParameter(createChatTeamActivity, "this$0");
        createChatTeamActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new ClickProxy()), TuplesKt.to(Integer.valueOf(tk0.z), Boolean.valueOf(j0())), TuplesKt.to(Integer.valueOf(tk0.k0), g0())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().l().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    CreateChatTeamActivity createChatTeamActivity = this.this$0;
                    Intent intent = new Intent();
                    CreateChatTeamActivity createChatTeamActivity2 = this.this$0;
                    intent.putExtra("result_type", 1);
                    intent.putExtra(CreateChatTeamActivity.x, createChatTeamActivity2.f0());
                    intent.putExtra(CreateChatTeamActivity.y, CreateChatTeamActivity.b0(createChatTeamActivity2).m().getValue());
                    Unit unit = Unit.INSTANCE;
                    createChatTeamActivity.setResult(-1, intent);
                    this.this$0.finish();
                }
            }
        }));
        getMViewModel().o().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    CreateChatTeamActivity createChatTeamActivity = this.this$0;
                    Intent intent = new Intent();
                    CreateChatTeamActivity createChatTeamActivity2 = this.this$0;
                    intent.putExtra("result_type", 2);
                    intent.putExtra(CreateChatTeamActivity.x, createChatTeamActivity2.f0());
                    intent.putExtra(CreateChatTeamActivity.y, CreateChatTeamActivity.b0(createChatTeamActivity2).m().getValue());
                    Unit unit = Unit.INSTANCE;
                    createChatTeamActivity.setResult(-1, intent);
                    this.this$0.finish();
                }
            }
        }));
        getMViewModel().n().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    fv5.b(this.this$0.getString(R.string.channel_manage_delete_success));
                    CreateChatTeamActivity createChatTeamActivity = this.this$0;
                    Intent intent = new Intent();
                    CreateChatTeamActivity createChatTeamActivity2 = this.this$0;
                    intent.putExtra("result_type", 3);
                    intent.putExtra(CreateChatTeamActivity.x, createChatTeamActivity2.f0());
                    intent.putExtra(CreateChatTeamActivity.y, CreateChatTeamActivity.b0(createChatTeamActivity2).m().getValue());
                    Unit unit = Unit.INSTANCE;
                    createChatTeamActivity.setResult(-1, intent);
                    this.this$0.finish();
                }
            }
        }));
    }

    public final String e0() {
        return (String) this.channelNo.getValue();
    }

    public final String f0() {
        return (String) this.teamGroupCode.getValue();
    }

    public final String g0() {
        return (String) this.teamGroupTitle.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_create_chat_team;
    }

    public final void h0() {
        EditText editText = getMBinding().f7479a;
        Intrinsics.checkNotNullExpressionValue(editText, "mBinding.etTitle");
        editText.addTextChangedListener(new b());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        MutableLiveData<MyChannelChatTeam> mutableLiveDataM = getMViewModel().m();
        MyChannelChatTeam myChannelChatTeam = (MyChannelChatTeam) getIntent().getParcelableExtra(C);
        if (myChannelChatTeam == null) {
            myChannelChatTeam = new MyChannelChatTeam(null, null, null, null, 0, 31, null);
        }
        mutableLiveDataM.setValue(myChannelChatTeam);
    }

    public final void initToolbar() {
        MutableLiveData<BindingTitleBean> mutableLiveDataP = getMViewModel().p();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataP.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(j0() ? getString(R.string.channel_manage_update_chat_team) : getString(R.string.channel_manage_create_chat_team)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setShowDivider(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ex1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateChatTeamActivity.i0(this.f41543a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initToolbar();
        h0();
    }

    public final boolean j0() {
        return ((Boolean) this.isEdit.getValue()).booleanValue();
    }
}
