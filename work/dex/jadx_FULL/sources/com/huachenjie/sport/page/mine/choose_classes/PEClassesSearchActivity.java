package com.huachenjie.sport.page.mine.choose_classes;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.ActivityPeClassesSearchBinding;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0006\u0010\n\u001a\u00020\u0003¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSearchActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSearchVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "f0", "<init>", "()V", "a", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class PEClassesSearchActivity extends BaseVmActivity<PEClassesSearchVM> {

    @NotNull
    public static final String x = "searchText";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSearchActivity$a;", "", "Landroid/view/View;", "v", "", "a", "b", "<init>", "(Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSearchActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PEClassesSearchActivity.this.finish();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PEClassesSearchActivity.this.f0();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/PEClassesSearchActivity$c", "Landroid/widget/TextView$OnEditorActionListener;", "Landroid/widget/TextView;", "v", "", "actionId", "Landroid/view/KeyEvent;", "event", "", "onEditorAction", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements TextView.OnEditorActionListener {
        public c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(@Nullable TextView v, int actionId, @Nullable KeyEvent event) {
            if (actionId != 3) {
                return false;
            }
            PEClassesSearchActivity.this.f0();
            return true;
        }
    }

    public final void f0() {
        String string;
        String value = ((PEClassesSearchVM) ((BaseVmActivity) this).f8507a).h().getValue();
        if (value == null || (string = StringsKt.trim(value).toString()) == null) {
            string = "";
        }
        Intent intent = new Intent();
        intent.putExtra(x, string);
        setResult(-1, intent);
        finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_pe_classes_search), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        String stringExtra;
        MutableLiveData<String> mutableLiveDataH = ((PEClassesSearchVM) ((BaseVmActivity) this).f8507a).h();
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra(x)) == null) {
            stringExtra = "";
        }
        mutableLiveDataH.setValue(stringExtra);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivityPeClassesSearchBinding");
        ((ActivityPeClassesSearchBinding) binding).f13316a.setOnEditorActionListener(new c());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }
}
