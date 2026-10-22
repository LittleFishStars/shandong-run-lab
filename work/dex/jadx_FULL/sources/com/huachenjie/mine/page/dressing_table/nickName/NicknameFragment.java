package com.huachenjie.mine.page.dressing_table.nickName;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineFragmentDressingTableNicknameBinding;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment;
import com.igexin.push.g.o;
import com.zj.adlib.ik0;
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
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/nickName/NicknameFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentDressingTableNicknameBinding;", "Lcom/huachenjie/mine/page/dressing_table/nickName/NicknameVM;", "", "", "", "getVariables", "getLayoutResID", "", "initData", "initView", "initDataObservable", "", "nickname$delegate", "Lkotlin/Lazy;", "getNickname", "()Ljava/lang/String;", NicknameFragment.NICKNAME, "<init>", "()V", "Companion", "a", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nNicknameFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NicknameFragment.kt\ncom/huachenjie/mine/page/dressing_table/nickName/NicknameFragment\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,99:1\n65#2,16:100\n93#2,3:116\n*S KotlinDebug\n*F\n+ 1 NicknameFragment.kt\ncom/huachenjie/mine/page/dressing_table/nickName/NicknameFragment\n*L\n58#1:100,16\n58#1:116,3\n*E\n"})
public final class NicknameFragment extends BaseMVVMFragment<MineFragmentDressingTableNicknameBinding, NicknameVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String NICKNAME = "nickname";

    /* JADX INFO: renamed from: nickname$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy nickname = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment$nickname$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(NicknameFragment.NICKNAME)) == null) ? "" : string;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/nickName/NicknameFragment$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/mine/page/dressing_table/nickName/NicknameFragment;)V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            NicknameFragment.access$getMViewModel(NicknameFragment.this).i().setValue("");
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            NicknameFragment.access$getMViewModel(NicknameFragment.this).k();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/nickName/NicknameFragment$b;", "", "", NicknameFragment.NICKNAME, "Lcom/huachenjie/mine/page/dressing_table/nickName/NicknameFragment;", "a", "NICKNAME", "Ljava/lang/String;", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NicknameFragment a(@NotNull String nickname) {
            Intrinsics.checkNotNullParameter(nickname, NicknameFragment.NICKNAME);
            NicknameFragment nicknameFragment = new NicknameFragment();
            Bundle bundle = new Bundle();
            bundle.putString(NicknameFragment.NICKNAME, nickname);
            nicknameFragment.setArguments(bundle);
            return nicknameFragment;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 NicknameFragment.kt\ncom/huachenjie/mine/page/dressing_table/nickName/NicknameFragment\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n*L\n1#1,97:1\n70#2,3:98\n60#2,8:102\n71#3:101\n*E\n"})
    public static final class c implements TextWatcher {
        public c(NicknameFragment nicknameFragment) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
            MineFragmentDressingTableNicknameBinding mineFragmentDressingTableNicknameBindingAccess$getMBinding = NicknameFragment.access$getMBinding(NicknameFragment.this);
            ImageView imageView = mineFragmentDressingTableNicknameBindingAccess$getMBinding != null ? mineFragmentDressingTableNicknameBindingAccess$getMBinding.f11231a : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(TextUtils.isEmpty(String.valueOf(s)) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            EditText editText;
            EditText editText2;
            if (text != null) {
                String strReplace$default = StringsKt.replace$default(text.toString(), "\n", " ", false, 4, (Object) null);
                if (TextUtils.equals(strReplace$default, text)) {
                    return;
                }
                MineFragmentDressingTableNicknameBinding mineFragmentDressingTableNicknameBindingAccess$getMBinding = NicknameFragment.access$getMBinding(NicknameFragment.this);
                if (mineFragmentDressingTableNicknameBindingAccess$getMBinding != null && (editText2 = mineFragmentDressingTableNicknameBindingAccess$getMBinding.f35308a) != null) {
                    editText2.setText(strReplace$default);
                }
                MineFragmentDressingTableNicknameBinding mineFragmentDressingTableNicknameBindingAccess$getMBinding2 = NicknameFragment.access$getMBinding(NicknameFragment.this);
                if (mineFragmentDressingTableNicknameBindingAccess$getMBinding2 == null || (editText = mineFragmentDressingTableNicknameBindingAccess$getMBinding2.f35308a) == null) {
                    return;
                }
                editText.setSelection(strReplace$default.length());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35377a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35377a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35377a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35377a.invoke(obj);
        }
    }

    public static final /* synthetic */ MineFragmentDressingTableNicknameBinding access$getMBinding(NicknameFragment nicknameFragment) {
        return nicknameFragment.getMBinding();
    }

    public static final /* synthetic */ NicknameVM access$getMViewModel(NicknameFragment nicknameFragment) {
        return nicknameFragment.getMViewModel();
    }

    private final String getNickname() {
        return (String) this.nickname.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(NicknameFragment nicknameFragment, View view, boolean z) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(nicknameFragment, "this$0");
        if (z) {
            MutableLiveData<String> mutableLiveDataI = nicknameFragment.getMViewModel().i();
            if (!TextUtils.isEmpty(mutableLiveDataI != null ? mutableLiveDataI.getValue() : null)) {
                MineFragmentDressingTableNicknameBinding mBinding = nicknameFragment.getMBinding();
                imageView = mBinding != null ? mBinding.f11231a : null;
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(0);
                return;
            }
        }
        MineFragmentDressingTableNicknameBinding mBinding2 = nicknameFragment.getMBinding();
        imageView = mBinding2 != null ? mBinding2.f11231a : null;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_fragment_dressing_table_nickname;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().i().setValue(getNickname());
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().j().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (!bool.booleanValue() || NicknameFragment.this.getActivity() == null) {
                    return;
                }
                FragmentActivity activity = NicknameFragment.this.getActivity();
                boolean z = false;
                if (activity != null && activity.isFinishing()) {
                    z = true;
                }
                if (z || !(NicknameFragment.this.getActivity() instanceof DressingTableActivity)) {
                    return;
                }
                FragmentActivity activity2 = NicknameFragment.this.getActivity();
                Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.huachenjie.mine.page.dressing_table.DressingTableActivity");
                DressingTableActivity dressingTableActivity = (DressingTableActivity) activity2;
                String value = NicknameFragment.access$getMViewModel(NicknameFragment.this).i().getValue();
                if (value == null) {
                    value = "";
                }
                dressingTableActivity.d0(value);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        EditText editText;
        EditText editText2;
        MineFragmentDressingTableNicknameBinding mBinding = getMBinding();
        if (mBinding != null && (editText2 = mBinding.f35308a) != null) {
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.zj.adlib.cz5
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    NicknameFragment.initView$lambda$0(this.f41071a, view, z);
                }
            });
        }
        MineFragmentDressingTableNicknameBinding mBinding2 = getMBinding();
        if (mBinding2 == null || (editText = mBinding2.f35308a) == null) {
            return;
        }
        editText.addTextChangedListener(new c(this));
    }
}
