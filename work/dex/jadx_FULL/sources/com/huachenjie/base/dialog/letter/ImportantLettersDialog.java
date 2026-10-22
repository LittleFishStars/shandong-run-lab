package com.huachenjie.base.dialog.letter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.p002lifecycle.Observer;
import com.huachenjie.base.R;
import com.huachenjie.base.bean.LetterBean;
import com.huachenjie.base.databinding.DialogLetterImportantBinding;
import com.huachenjie.base.dialog.letter.ImportantLettersDialog;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.zj.adlib.i4a;
import com.zj.adlib.sk0;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0017J\b\u0010\u000f\u001a\u00020\u0004H\u0016R)\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/base/dialog/letter/ImportantLettersDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/base/databinding/DialogLetterImportantBinding;", "Lcom/huachenjie/base/dialog/letter/ImportantLettersVM;", "", "onIndexChange", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "onStart", "initView", "initDataObserve", "", "Lcom/huachenjie/base/bean/LetterBean;", "kotlin.jvm.PlatformType", "listBean$delegate", "Lkotlin/Lazy;", "getListBean", "()Ljava/util/List;", "listBean", "currentIndex", "I", "<init>", "()V", "Companion", "a", "b", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nImportantLettersDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportantLettersDialog.kt\ncom/huachenjie/base/dialog/letter/ImportantLettersDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,195:1\n1864#2,3:196\n1864#2,3:199\n*S KotlinDebug\n*F\n+ 1 ImportantLettersDialog.kt\ncom/huachenjie/base/dialog/letter/ImportantLettersDialog\n*L\n128#1:196,3\n140#1:199,3\n*E\n"})
public final class ImportantLettersDialog extends BaseMVVMDialogFragment<DialogLetterImportantBinding, ImportantLettersVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_LETTERS = "letters";
    private int currentIndex;

    /* JADX INFO: renamed from: listBean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy listBean = LazyKt.lazy(new Function0<List<? extends LetterBean>>() { // from class: com.huachenjie.base.dialog.letter.ImportantLettersDialog$listBean$2
        {
            super(0);
        }

        @NotNull
        public final List<LetterBean> invoke() {
            Bundle arguments = this.this$0.getArguments();
            ArrayList parcelableArrayList = arguments != null ? arguments.getParcelableArrayList("letters") : null;
            return parcelableArrayList == null ? CollectionsKt.emptyList() : parcelableArrayList;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/base/dialog/letter/ImportantLettersDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/base/dialog/letter/ImportantLettersDialog;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                int size = ImportantLettersDialog.this.getListBean().size();
                int i = ImportantLettersDialog.this.currentIndex;
                boolean z = false;
                if (i >= 0 && i < size) {
                    z = true;
                }
                if (z) {
                    ImportantLettersDialog.access$getMViewModel(ImportantLettersDialog.this).i(((LetterBean) ImportantLettersDialog.this.getListBean().get(ImportantLettersDialog.this.currentIndex)).getSchoolLetterRelationCode());
                } else {
                    ImportantLettersDialog.this.dismiss();
                }
            } catch (Exception unused) {
                ImportantLettersDialog.this.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.dialog.letter.ImportantLettersDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/base/dialog/letter/ImportantLettersDialog$b;", "", "Ljava/util/ArrayList;", "Lcom/huachenjie/base/bean/LetterBean;", "Lkotlin/collections/ArrayList;", "letterList", "Lcom/huachenjie/base/dialog/letter/ImportantLettersDialog;", "a", "", "KEY_LETTERS", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImportantLettersDialog a(@NotNull ArrayList<LetterBean> letterList) {
            Intrinsics.checkNotNullParameter(letterList, "letterList");
            ImportantLettersDialog importantLettersDialog = new ImportantLettersDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(ImportantLettersDialog.KEY_LETTERS, letterList);
            importantLettersDialog.setArguments(bundle);
            return importantLettersDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f32885a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f32885a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f32885a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f32885a.invoke(obj);
        }
    }

    public static final /* synthetic */ ImportantLettersVM access$getMViewModel(ImportantLettersDialog importantLettersDialog) {
        return importantLettersDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<LetterBean> getListBean() {
        return (List) this.listBean.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(DialogLetterImportantBinding dialogLetterImportantBinding, View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dialogLetterImportantBinding, "$this_apply");
        int contentHeight = (int) (dialogLetterImportantBinding.f32822a.getContentHeight() * dialogLetterImportantBinding.f32822a.getScale());
        int height = (dialogLetterImportantBinding.f7010a.getVisibility() == 8 ? 0 : dialogLetterImportantBinding.f7010a.getHeight()) + contentHeight;
        int height2 = dialogLetterImportantBinding.f7011a.getHeight();
        i4a.c("contentHeight:" + contentHeight + " totalHeight:" + height + " viewHeight:" + height2);
        StringBuilder sb = new StringBuilder();
        sb.append("totalHeight:");
        sb.append(height);
        sb.append(" scroll:");
        int i5 = i2 + height2;
        sb.append(i5);
        i4a.c(sb.toString());
        if (height - i5 <= 120) {
            dialogLetterImportantBinding.f7015a.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onIndexChange() {
        int size = getListBean().size();
        int i = this.currentIndex;
        LetterBean letterBean = !(i >= 0 && i < size) ? new LetterBean(null, null, null, null, null, 0L, 63, null) : getListBean().get(this.currentIndex);
        final DialogLetterImportantBinding mBinding = getMBinding();
        if (mBinding != null) {
            TextView textView = mBinding.b;
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(this.currentIndex + 1);
            sb.append('/');
            sb.append(getListBean().size());
            sb.append(')');
            textView.setText(sb.toString());
            mBinding.d.setText(letterBean.getSchoolLetterTitle());
            mBinding.c.setText(letterBean.formatLetterTime());
            String str = "";
            if (TextUtils.isEmpty(letterBean.getSchoolLetterSummary())) {
                mBinding.f7010a.setText("");
                mBinding.f7010a.setVisibility(8);
            } else {
                mBinding.f7010a.setText(letterBean.getSchoolLetterSummary());
                mBinding.f7010a.setVisibility(0);
            }
            mBinding.f7015a.setEnabled(false);
            if (this.currentIndex == getListBean().size() - 1) {
                mBinding.f7015a.setText("我已知晓并关闭");
            } else {
                mBinding.f7015a.setText("我已知晓，阅读下一篇");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<!doctype html><html lang=\"zh\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"><title></title></head><body>");
            if (StringsKt.contains$default(letterBean.getSchoolLetterContent(), "<img", false, 2, (Object) null)) {
                int i2 = 0;
                for (Object obj : StringsKt.split$default(letterBean.getSchoolLetterContent(), new String[]{"<img"}, false, 0, 6, (Object) null)) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str2 = (String) obj;
                    str = i2 == 0 ? str + str2 : str + "<img style = \"width:100%\" " + str2;
                    i2 = i3;
                }
            } else {
                str = "" + letterBean.getSchoolLetterContent();
            }
            String str3 = str;
            if (StringsKt.contains$default(str3, "<video", false, 2, (Object) null)) {
                int i4 = 0;
                for (Object obj2 : StringsKt.split$default(str3, new String[]{"<video"}, false, 0, 6, (Object) null)) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str4 = (String) obj2;
                    if (i4 == 0) {
                        stringBuffer.append(str4);
                    } else {
                        stringBuffer.append("<video style = \"width:100%\" " + str4);
                    }
                    i4 = i5;
                }
            } else {
                stringBuffer.append(str3);
            }
            stringBuffer.append("</body></html>");
            mBinding.f32822a.loadDataWithBaseURL(null, stringBuffer.toString(), "text/html", "utf-8", null);
            mBinding.f7011a.scrollTo(0, 0);
            mBinding.f32822a.postDelayed(new Runnable() { // from class: com.zj.adlib.v84
                @Override // java.lang.Runnable
                public final void run() {
                    ImportantLettersDialog.onIndexChange$lambda$8$lambda$7(mBinding);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onIndexChange$lambda$8$lambda$7(DialogLetterImportantBinding dialogLetterImportantBinding) {
        Intrinsics.checkNotNullParameter(dialogLetterImportantBinding, "$this_apply");
        int contentHeight = (int) (dialogLetterImportantBinding.f32822a.getContentHeight() * dialogLetterImportantBinding.f32822a.getScale());
        int height = (dialogLetterImportantBinding.f7010a.getVisibility() == 8 ? 0 : dialogLetterImportantBinding.f7010a.getHeight()) + contentHeight;
        int height2 = dialogLetterImportantBinding.f7011a.getHeight();
        i4a.c("contentHeight:" + contentHeight + " totalHeight:" + height + " viewHeight:" + height2);
        if (height - 90 <= height2) {
            dialogLetterImportantBinding.f7015a.setEnabled(true);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.dialog_letter_important;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(sk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(sk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        getMViewModel().j().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.base.dialog.letter.ImportantLettersDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ImportantLettersDialog.this.currentIndex++;
                    int size = ImportantLettersDialog.this.getListBean().size();
                    int i = ImportantLettersDialog.this.currentIndex;
                    if (i >= 0 && i < size) {
                        ImportantLettersDialog.this.onIndexChange();
                    } else {
                        ImportantLettersDialog.this.dismiss();
                    }
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @SuppressLint({"SetTextI18n"})
    public void initView() {
        View viewFindViewById;
        super.initView();
        View view = getView();
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.s84
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ImportantLettersDialog.initView$lambda$1(view2);
                }
            });
        }
        View view2 = getView();
        if (view2 != null && (viewFindViewById = view2.findViewById(R.id.ll_container)) != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.t84
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    ImportantLettersDialog.initView$lambda$2(view3);
                }
            });
        }
        this.currentIndex = 0;
        final DialogLetterImportantBinding mBinding = getMBinding();
        if (mBinding != null) {
            if (getListBean().size() == 1) {
                mBinding.b.setVisibility(8);
            } else {
                mBinding.b.setVisibility(0);
                TextView textView = mBinding.b;
                StringBuilder sb = new StringBuilder();
                sb.append('(');
                sb.append(this.currentIndex + 1);
                sb.append('/');
                sb.append(getListBean().size());
                sb.append(')');
                textView.setText(sb.toString());
            }
            mBinding.f7011a.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.zj.adlib.u84
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view3, int i, int i2, int i3, int i4) {
                    ImportantLettersDialog.initView$lambda$4$lambda$3(mBinding, view3, i, i2, i3, i4);
                }
            });
            onIndexChange();
        }
        setCancelable(false);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.getAttributes().dimAmount = 0.0f;
        window.setAttributes(window.getAttributes());
    }
}
