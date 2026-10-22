package com.huachenjie.works.page.buddy;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.blankj.utilcode.util.KeyboardUtils;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksDialogBuddyApplyBinding;
import com.huachenjie.works.page.buddy.BuddyApplyDialog;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.jj8;
import com.zj.adlib.jq5;
import com.zj.adlib.qk0;
import com.zj.adlib.su9;
import java.util.ArrayList;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#$B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b¨\u0006%"}, d2 = {"Lcom/huachenjie/works/page/buddy/BuddyApplyDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogBuddyApplyBinding;", "Lcom/huachenjie/works/page/buddy/BuddyApplyVM;", "", "initKeyboardListener", "initMessageInput", "bindTags", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "onStart", "initView", "initData", "initDataObserve", "onDestroyView", "Lkotlin/Function0;", "onApplySuccess", "Lkotlin/jvm/functions/Function0;", "", "buddyCode$delegate", "Lkotlin/Lazy;", "getBuddyCode", "()Ljava/lang/String;", "buddyCode", "buddyTypeName$delegate", "getBuddyTypeName", "buddyTypeName", "<init>", "()V", "Companion", "a", "b", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBuddyApplyDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuddyApplyDialog.kt\ncom/huachenjie/works/page/buddy/BuddyApplyDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,179:1\n766#2:180\n857#2,2:181\n1864#2,3:183\n1#3:186\n*S KotlinDebug\n*F\n+ 1 BuddyApplyDialog.kt\ncom/huachenjie/works/page/buddy/BuddyApplyDialog\n*L\n138#1:180\n138#1:181,2\n145#1:183,3\n*E\n"})
public final class BuddyApplyDialog extends BaseMVVMBottomDialogFragment<WorksDialogBuddyApplyBinding, BuddyApplyVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_AVATAR_URL = "avatar_url";

    @NotNull
    private static final String KEY_BUDDY_CODE = "buddy_code";

    @NotNull
    private static final String KEY_BUDDY_TYPE = "buddy_type";

    @NotNull
    private static final String KEY_TAGS = "tags";

    @NotNull
    private static final String KEY_TITLE = "title";

    /* JADX INFO: renamed from: buddyCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy buddyCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.buddy.BuddyApplyDialog$buddyCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("buddy_code")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: buddyTypeName$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy buddyTypeName = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.buddy.BuddyApplyDialog$buddyTypeName$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            String string = arguments != null ? arguments.getString("buddy_type") : null;
            return string == null ? "" : string;
        }
    });

    @Nullable
    private Function0<Unit> onApplySuccess;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/works/page/buddy/BuddyApplyDialog$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/works/page/buddy/BuddyApplyDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            KeyboardUtils.k(view);
            BuddyApplyDialog.this.dismiss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            String value = BuddyApplyDialog.access$getMViewModel(BuddyApplyDialog.this).j().getValue();
            if (value == null) {
                value = "";
            }
            if (StringsKt.trim(value).toString().length() == 0) {
                fv5.a(R.string.works_buddy_apply_message_empty);
                return;
            }
            KeyboardUtils.k(view);
            BuddyApplyVM buddyApplyVMAccess$getMViewModel = BuddyApplyDialog.access$getMViewModel(BuddyApplyDialog.this);
            String buddyCode = BuddyApplyDialog.this.getBuddyCode();
            Intrinsics.checkNotNullExpressionValue(buddyCode, "buddyCode");
            buddyApplyVMAccess$getMViewModel.o(buddyCode);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.buddy.BuddyApplyDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JP\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/works/page/buddy/BuddyApplyDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "buddyCode", AvatarFragment.AVATAR_URL, "title", "", "tags", "buddyTypeName", "Lkotlin/Function0;", "", "onApplySuccess", "a", "KEY_AVATAR_URL", "Ljava/lang/String;", "KEY_BUDDY_CODE", "KEY_BUDDY_TYPE", "KEY_TAGS", "KEY_TITLE", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull String buddyCode, @NotNull String avatarUrl, @NotNull String title, @NotNull List<String> tags, @NotNull String buddyTypeName, @Nullable Function0<Unit> onApplySuccess) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
            Intrinsics.checkNotNullParameter(avatarUrl, AvatarFragment.AVATAR_URL);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(buddyTypeName, "buddyTypeName");
            BuddyApplyDialog buddyApplyDialog = new BuddyApplyDialog();
            Bundle bundle = new Bundle();
            bundle.putString(BuddyApplyDialog.KEY_BUDDY_CODE, buddyCode);
            bundle.putString(BuddyApplyDialog.KEY_BUDDY_TYPE, buddyTypeName);
            bundle.putString(BuddyApplyDialog.KEY_AVATAR_URL, avatarUrl);
            bundle.putString("title", title);
            bundle.putStringArrayList("tags", new ArrayList<>(tags));
            buddyApplyDialog.setArguments(bundle);
            buddyApplyDialog.onApplySuccess = onApplySuccess;
            buddyApplyDialog.show(fragmentManager, "BuddyApplyDialog");
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"com/huachenjie/works/page/buddy/BuddyApplyDialog$c", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s, int start, int before, int count) {
            MutableLiveData<String> mutableLiveDataJ = BuddyApplyDialog.access$getMViewModel(BuddyApplyDialog.this).j();
            String string = s != null ? s.toString() : null;
            if (string == null) {
                string = "";
            }
            mutableLiveDataJ.setValue(string);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37223a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37223a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37223a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37223a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ WorksDialogBuddyApplyBinding access$getMBinding(BuddyApplyDialog buddyApplyDialog) {
        return (WorksDialogBuddyApplyBinding) buddyApplyDialog.getMBinding();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ BuddyApplyVM access$getMViewModel(BuddyApplyDialog buddyApplyDialog) {
        return (BuddyApplyVM) buddyApplyDialog.getMViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void bindTags() {
        ViewGroup viewGroup;
        WorksDialogBuddyApplyBinding worksDialogBuddyApplyBinding = (WorksDialogBuddyApplyBinding) getMBinding();
        if (worksDialogBuddyApplyBinding == null || (viewGroup = worksDialogBuddyApplyBinding.f14015a) == null) {
            return;
        }
        Bundle arguments = getArguments();
        List stringArrayList = arguments != null ? arguments.getStringArrayList("tags") : null;
        if (stringArrayList == null) {
            stringArrayList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : stringArrayList) {
            String str = (String) obj;
            Intrinsics.checkNotNullExpressionValue(str, o.f);
            if (!StringsKt.isBlank(str)) {
                arrayList.add(obj);
            }
        }
        viewGroup.removeAllViews();
        if (arrayList.isEmpty()) {
            WorksDialogBuddyApplyBinding worksDialogBuddyApplyBinding2 = (WorksDialogBuddyApplyBinding) getMBinding();
            HorizontalScrollView horizontalScrollView = worksDialogBuddyApplyBinding2 != null ? worksDialogBuddyApplyBinding2.f14014a : null;
            if (horizontalScrollView == null) {
                return;
            }
            horizontalScrollView.setVisibility(8);
            return;
        }
        int iA = jj8.a(4.0f);
        int i = 0;
        for (Object obj2 : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.works_item_buddy_apply_tag, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewInflate;
            textView.setText((String) obj2);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.setMarginStart(i > 0 ? iA : 0);
                textView.setLayoutParams(layoutParams2);
            }
            viewGroup.addView(textView);
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBuddyCode() {
        return (String) this.buddyCode.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBuddyTypeName() {
        return (String) this.buddyTypeName.getValue();
    }

    private final void initKeyboardListener() {
        KeyboardUtils.o(requireActivity(), new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.zj.adlib.u01
            @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
            public final void a(int i) {
                BuddyApplyDialog.initKeyboardListener$lambda$0(this.f45037a, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initKeyboardListener$lambda$0(BuddyApplyDialog buddyApplyDialog, int i) {
        Intrinsics.checkNotNullParameter(buddyApplyDialog, "this$0");
        ((BuddyApplyVM) buddyApplyDialog.getMViewModel()).m().setValue(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initMessageInput() {
        EditText editText;
        WorksDialogBuddyApplyBinding worksDialogBuddyApplyBinding = (WorksDialogBuddyApplyBinding) getMBinding();
        if (worksDialogBuddyApplyBinding == null || (editText = worksDialogBuddyApplyBinding.f14013a) == null) {
            return;
        }
        editText.addTextChangedListener(new c());
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_buddy_apply;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        MutableLiveData<String> mutableLiveDataL = ((BuddyApplyVM) getMViewModel()).l();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(KEY_AVATAR_URL) : null;
        if (string == null) {
            string = "";
        }
        mutableLiveDataL.setValue(string);
        MutableLiveData<String> mutableLiveDataN = ((BuddyApplyVM) getMViewModel()).n();
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("title") : null;
        mutableLiveDataN.setValue(string2 != null ? string2 : "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        WorksDialogBuddyApplyBinding worksDialogBuddyApplyBinding = (WorksDialogBuddyApplyBinding) getMBinding();
        TextView textView = worksDialogBuddyApplyBinding != null ? worksDialogBuddyApplyBinding.b : null;
        if (textView != null) {
            textView.setText(((BuddyApplyVM) getMViewModel()).i());
        }
        ((BuddyApplyVM) getMViewModel()).j().observe(getViewLifecycleOwner(), new d(new Function1<String, Unit>() { // from class: com.huachenjie.works.page.buddy.BuddyApplyDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                WorksDialogBuddyApplyBinding worksDialogBuddyApplyBindingAccess$getMBinding = BuddyApplyDialog.access$getMBinding(BuddyApplyDialog.this);
                TextView textView2 = worksDialogBuddyApplyBindingAccess$getMBinding != null ? worksDialogBuddyApplyBindingAccess$getMBinding.b : null;
                if (textView2 == null) {
                    return;
                }
                textView2.setText(BuddyApplyDialog.access$getMViewModel(BuddyApplyDialog.this).i());
            }
        }));
        ((BuddyApplyVM) getMViewModel()).k().observe(getViewLifecycleOwner(), new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.buddy.BuddyApplyDialog.initDataObserve.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    Context contextRequireContext = BuddyApplyDialog.this.requireContext();
                    String buddyCode = BuddyApplyDialog.this.getBuddyCode();
                    Intrinsics.checkNotNullExpressionValue(buddyCode, "buddyCode");
                    jq5.a(contextRequireContext, buddyCode, BuddyApplyDialog.this.getBuddyTypeName());
                    fv5.a(R.string.works_buddy_apply_success);
                    Function0 function0 = BuddyApplyDialog.this.onApplySuccess;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    BuddyApplyDialog.this.dismiss();
                    su9.l(BuddyApplyDialog.this.requireContext(), Environment.c + "/#/buddy/mine");
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        bindTags();
        initMessageInput();
        initKeyboardListener();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            KeyboardUtils.v(window);
        }
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(48);
    }
}
