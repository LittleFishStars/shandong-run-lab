package com.huachenjie.mine.page.dressing_table.avatar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Observer;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineFragmentDressingTableAvatarBinding;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.ik0;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/avatar/AvatarFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentDressingTableAvatarBinding;", "Lcom/huachenjie/mine/page/dressing_table/avatar/AvatarVM;", "", "", "", "getVariables", "getLayoutResID", "", "initView", "initData", "initDataObservable", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "", "avatarUrl$delegate", "Lkotlin/Lazy;", "getAvatarUrl", "()Ljava/lang/String;", AvatarFragment.AVATAR_URL, "<init>", "()V", "Companion", "a", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class AvatarFragment extends BaseMVVMFragment<MineFragmentDressingTableAvatarBinding, AvatarVM> {

    @NotNull
    public static final String AVATAR_URL = "avatarUrl";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: avatarUrl$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy avatarUrl = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment$avatarUrl$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(AvatarFragment.AVATAR_URL)) == null) ? "" : string;
        }
    });
    private MediaPickerLauncher picker;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/avatar/AvatarFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mine/page/dressing_table/avatar/AvatarFragment;)V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MediaPickerLauncher mediaPickerLauncher = AvatarFragment.this.picker;
            if (mediaPickerLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picker");
                mediaPickerLauncher = null;
            }
            MediaPickerLauncher.Y(mediaPickerLauncher, UploadPictureButton.g, 0, 1080, 1024, true, 0.0f, 0.0f, false, 226, null);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/avatar/AvatarFragment$b;", "", "", AvatarFragment.AVATAR_URL, "Lcom/huachenjie/mine/page/dressing_table/avatar/AvatarFragment;", "a", "AVATAR_URL", "Ljava/lang/String;", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AvatarFragment a(@NotNull String avatarUrl) {
            Intrinsics.checkNotNullParameter(avatarUrl, AvatarFragment.AVATAR_URL);
            AvatarFragment avatarFragment = new AvatarFragment();
            Bundle bundle = new Bundle();
            bundle.putString(AvatarFragment.AVATAR_URL, avatarUrl);
            avatarFragment.setArguments(bundle);
            return avatarFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/mine/page/dressing_table/avatar/AvatarFragment$c", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements MediaPickerListener {
        public c() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!(result instanceof MediaPickerResult.Success)) {
                if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                    return;
                }
                fv5.b(((MediaPickerResult.Error) result).f());
                return;
            }
            String str = (String) CollectionsKt.getOrNull(((MediaPickerResult.Success) result).g(), 0);
            if (str == null) {
                return;
            }
            AvatarVM avatarVMAccess$getMViewModel = AvatarFragment.access$getMViewModel(AvatarFragment.this);
            Context contextRequireContext = AvatarFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            avatarVMAccess$getMViewModel.n(contextRequireContext, str);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35368a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35368a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35368a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35368a.invoke(obj);
        }
    }

    public static final /* synthetic */ AvatarVM access$getMViewModel(AvatarFragment avatarFragment) {
        return avatarFragment.getMViewModel();
    }

    private final String getAvatarUrl() {
        return (String) this.avatarUrl.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_fragment_dressing_table_avatar;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().j().setValue(getAvatarUrl());
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().k().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (!bool.booleanValue() || AvatarFragment.this.getActivity() == null) {
                    return;
                }
                FragmentActivity activity = AvatarFragment.this.getActivity();
                boolean z = false;
                if (activity != null && activity.isFinishing()) {
                    z = true;
                }
                if (z || !(AvatarFragment.this.getActivity() instanceof DressingTableActivity)) {
                    return;
                }
                FragmentActivity activity2 = AvatarFragment.this.getActivity();
                Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.huachenjie.mine.page.dressing_table.DressingTableActivity");
                DressingTableActivity dressingTableActivity = (DressingTableActivity) activity2;
                String value = AvatarFragment.access$getMViewModel(AvatarFragment.this).j().getValue();
                if (value == null) {
                    value = "";
                }
                dressingTableActivity.b0(value);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        this.picker = MediaPicker.v(this, new c());
    }
}
