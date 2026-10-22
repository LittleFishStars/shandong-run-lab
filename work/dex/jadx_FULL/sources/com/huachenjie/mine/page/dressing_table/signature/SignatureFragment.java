package com.huachenjie.mine.page.dressing_table.signature;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineFragmentDressingTableNicknameBinding;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/signature/SignatureFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentDressingTableNicknameBinding;", "Lcom/huachenjie/mine/page/dressing_table/signature/SignatureVM;", "", "", "", "getVariables", "getLayoutResID", "", "initData", "initDataObservable", "", "signature$delegate", "Lkotlin/Lazy;", "getSignature", "()Ljava/lang/String;", SignatureFragment.SIGNATURE, "<init>", "()V", "Companion", "a", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class SignatureFragment extends BaseMVVMFragment<MineFragmentDressingTableNicknameBinding, SignatureVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SIGNATURE = "signature";

    /* JADX INFO: renamed from: signature$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy signature = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mine.page.dressing_table.signature.SignatureFragment$signature$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(SignatureFragment.SIGNATURE)) == null) ? "" : string;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/signature/SignatureFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mine/page/dressing_table/signature/SignatureFragment;)V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SignatureFragment.access$getMViewModel(SignatureFragment.this).l();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mine.page.dressing_table.signature.SignatureFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/signature/SignatureFragment$b;", "", "", SignatureFragment.SIGNATURE, "Lcom/huachenjie/mine/page/dressing_table/signature/SignatureFragment;", "a", "SIGNATURE", "Ljava/lang/String;", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SignatureFragment a(@NotNull String signature) {
            Intrinsics.checkNotNullParameter(signature, SignatureFragment.SIGNATURE);
            SignatureFragment signatureFragment = new SignatureFragment();
            Bundle bundle = new Bundle();
            bundle.putString(SignatureFragment.SIGNATURE, signature);
            signatureFragment.setArguments(bundle);
            return signatureFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35380a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35380a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35380a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35380a.invoke(obj);
        }
    }

    public static final /* synthetic */ SignatureVM access$getMViewModel(SignatureFragment signatureFragment) {
        return signatureFragment.getMViewModel();
    }

    private final String getSignature() {
        return (String) this.signature.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_fragment_dressing_table_signature;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().j().setValue(getSignature());
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().i().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mine.page.dressing_table.signature.SignatureFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (!bool.booleanValue() || SignatureFragment.this.getActivity() == null) {
                    return;
                }
                FragmentActivity activity = SignatureFragment.this.getActivity();
                boolean z = false;
                if (activity != null && activity.isFinishing()) {
                    z = true;
                }
                if (z || !(SignatureFragment.this.getActivity() instanceof DressingTableActivity)) {
                    return;
                }
                FragmentActivity activity2 = SignatureFragment.this.getActivity();
                Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.huachenjie.mine.page.dressing_table.DressingTableActivity");
                DressingTableActivity dressingTableActivity = (DressingTableActivity) activity2;
                String value = SignatureFragment.access$getMViewModel(SignatureFragment.this).j().getValue();
                if (value == null) {
                    value = "";
                }
                dressingTableActivity.e0(value);
            }
        }));
    }
}
