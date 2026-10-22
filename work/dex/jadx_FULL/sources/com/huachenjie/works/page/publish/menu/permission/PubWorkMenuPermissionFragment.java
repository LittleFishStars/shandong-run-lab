package com.huachenjie.works.page.publish.menu.permission;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.utils.TextUtils;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksFragmentPubWorksMenuPermissionBinding;
import com.zj.adlib.fv5;
import com.zj.adlib.oz9;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/permission/PubWorkMenuPermissionFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentPubWorksMenuPermissionBinding;", "Lcom/huachenjie/works/page/publish/menu/permission/PubWorkMenuPermissionModel;", "", "visit", "", "updateVisit", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initData", "", "showMessage$delegate", "Lkotlin/Lazy;", "getShowMessage", "()Z", PubWorkMenuPermissionFragment.SHOW_MESSAGE_KEY, "Lkotlin/Function1;", "selectCallback", "Lkotlin/jvm/functions/Function1;", "getSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "Companion", "a", "b", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PubWorkMenuPermissionFragment extends BaseMVVMBottomDialogFragment<WorksFragmentPubWorksMenuPermissionBinding, PubWorkMenuPermissionModel> {

    @NotNull
    private static final String SHOW_MESSAGE_KEY = "showMessage";

    @NotNull
    private static final String VISIBLE_KEY = "visible";

    @NotNull
    private static final String WORKS_NO_KEY = "worksNo";

    @Nullable
    private Function1<? super Integer, Unit> selectCallback;

    /* JADX INFO: renamed from: showMessage$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy showMessage = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.publish.menu.permission.PubWorkMenuPermissionFragment$showMessage$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m957invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("showMessage") : false);
        }
    });

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public static final int VISIBLE_TYPE_PUBLIC = 1;

    @JvmField
    public static final int VISIBLE_TYPE_MINE = 2;

    @JvmField
    public static final int VISIBLE_TYPE_FRIEND = 3;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/permission/PubWorkMenuPermissionFragment$a;", "", "Landroid/view/View;", "v", "", "c", "b", "a", "<init>", "(Lcom/huachenjie/works/page/publish/menu/permission/PubWorkMenuPermissionFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            PubWorkMenuPermissionFragment.this.updateVisit(PubWorkMenuPermissionFragment.VISIBLE_TYPE_FRIEND);
        }

        public final void b(@Nullable View v) {
            PubWorkMenuPermissionFragment.this.updateVisit(PubWorkMenuPermissionFragment.VISIBLE_TYPE_MINE);
        }

        public final void c(@Nullable View v) {
            PubWorkMenuPermissionFragment.this.updateVisit(PubWorkMenuPermissionFragment.VISIBLE_TYPE_PUBLIC);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.publish.menu.permission.PubWorkMenuPermissionFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/permission/PubWorkMenuPermissionFragment$b;", "", "", PubWorkMenuPermissionFragment.VISIBLE_KEY, "", "worksNo", "", PubWorkMenuPermissionFragment.SHOW_MESSAGE_KEY, "Lcom/huachenjie/works/page/publish/menu/permission/PubWorkMenuPermissionFragment;", "a", "SHOW_MESSAGE_KEY", "Ljava/lang/String;", "VISIBLE_KEY", "VISIBLE_TYPE_FRIEND", "I", "VISIBLE_TYPE_MINE", "VISIBLE_TYPE_PUBLIC", "WORKS_NO_KEY", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ PubWorkMenuPermissionFragment b(Companion companion, int i, String str, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str = "";
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            return companion.a(i, str, z);
        }

        @NotNull
        public final PubWorkMenuPermissionFragment a(int visible, @NotNull String worksNo, boolean showMessage) {
            Intrinsics.checkNotNullParameter(worksNo, "worksNo");
            PubWorkMenuPermissionFragment pubWorkMenuPermissionFragment = new PubWorkMenuPermissionFragment();
            Bundle bundle = new Bundle();
            bundle.putString("worksNo", worksNo);
            bundle.putInt(PubWorkMenuPermissionFragment.VISIBLE_KEY, visible);
            bundle.putBoolean(PubWorkMenuPermissionFragment.SHOW_MESSAGE_KEY, showMessage);
            pubWorkMenuPermissionFragment.setArguments(bundle);
            return pubWorkMenuPermissionFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37307a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37307a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37307a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37307a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PubWorkMenuPermissionModel access$getMViewModel(PubWorkMenuPermissionFragment pubWorkMenuPermissionFragment) {
        return (PubWorkMenuPermissionModel) pubWorkMenuPermissionFragment.getMViewModel();
    }

    private final boolean getShowMessage() {
        return ((Boolean) this.showMessage.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateVisit(final int visit) {
        int i;
        ((PubWorkMenuPermissionModel) getMViewModel()).j().setValue(Integer.valueOf(visit));
        if (getShowMessage()) {
            if (visit == VISIBLE_TYPE_PUBLIC) {
                i = R.string.works_publish_work_menu_permission_public_msg;
            } else {
                i = visit == VISIBLE_TYPE_MINE ? R.string.works_publish_work_menu_permission_mine_msg : R.string.works_publish_work_menu_permission_friend_msg;
            }
            fv5.a(i);
        }
        if (!TextUtils.isEmpty(((PubWorkMenuPermissionModel) getMViewModel()).k().getValue())) {
            ((PubWorkMenuPermissionModel) getMViewModel()).l();
            ((PubWorkMenuPermissionModel) getMViewModel()).i().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.publish.menu.permission.PubWorkMenuPermissionFragment.updateVisit.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Boolean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Boolean bool) {
                    oz9 oz9Var = oz9.f43864a;
                    Context contextRequireContext = PubWorkMenuPermissionFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    String value = PubWorkMenuPermissionFragment.access$getMViewModel(PubWorkMenuPermissionFragment.this).k().getValue();
                    if (value == null) {
                        value = "";
                    }
                    oz9Var.e(contextRequireContext, value, visit);
                    Function1<Integer, Unit> selectCallback = PubWorkMenuPermissionFragment.this.getSelectCallback();
                    if (selectCallback != null) {
                        selectCallback.invoke(Integer.valueOf(visit));
                    }
                    PubWorkMenuPermissionFragment.this.dismiss();
                }
            }));
        } else {
            Function1<? super Integer, Unit> function1 = this.selectCallback;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(visit));
            }
            dismiss();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_pub_works_menu_permission;
    }

    @Nullable
    public final Function1<Integer, Unit> getSelectCallback() {
        return this.selectCallback;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @Nullable
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
        String string;
        super.initData();
        MutableLiveData<String> mutableLiveDataK = ((PubWorkMenuPermissionModel) getMViewModel()).k();
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("worksNo")) == null) {
            string = "";
        }
        mutableLiveDataK.setValue(string);
        MutableLiveData<Integer> mutableLiveDataJ = ((PubWorkMenuPermissionModel) getMViewModel()).j();
        Bundle arguments2 = getArguments();
        mutableLiveDataJ.setValue(Integer.valueOf(arguments2 != null ? arguments2.getInt(VISIBLE_KEY) : VISIBLE_TYPE_PUBLIC));
    }

    public final void setSelectCallback(@Nullable Function1<? super Integer, Unit> function1) {
        this.selectCallback = function1;
    }
}
