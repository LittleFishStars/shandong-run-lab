package com.huachenjie.common.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.common.R;
import com.zj.adlib.qa4;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonSearchView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonSearchView.kt\ncom/huachenjie/common/widget/CommonSearchView$etSearch$2\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,193:1\n65#2,16:194\n93#2,3:210\n*S KotlinDebug\n*F\n+ 1 CommonSearchView.kt\ncom/huachenjie/common/widget/CommonSearchView$etSearch$2\n*L\n55#1:194,16\n55#1:210,3\n*E\n"})
public final class CommonSearchView$etSearch$2 extends Lambda implements Function0<EditText> {
    final /* synthetic */ CommonSearchView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonSearchView$etSearch$2(CommonSearchView commonSearchView) {
        super(0);
        this.this$0 = commonSearchView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$2$lambda$0(CommonSearchView commonSearchView, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(commonSearchView, "this$0");
        textView.clearFocus();
        qa4.b(textView);
        commonSearchView.getSearchListener().invoke(commonSearchView.getEtSearch().getText().toString());
        return true;
    }

    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final EditText m378invoke() {
        View viewFindViewById = this.this$0.getLlSearch().findViewById(R.id.et_search);
        final CommonSearchView commonSearchView = this.this$0;
        EditText editText = (EditText) viewFindViewById;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.huachenjie.common.widget.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return CommonSearchView$etSearch$2.invoke$lambda$2$lambda$0(commonSearchView, textView, i, keyEvent);
            }
        });
        Intrinsics.checkNotNullExpressionValue(editText, "invoke$lambda$2");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.huachenjie.common.widget.CommonSearchView$etSearch$2$invoke$lambda$2$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s) {
                boolean z = false;
                if (s != null) {
                    if (!(s.length() == 0)) {
                        z = true;
                    }
                }
                if (z) {
                    return;
                }
                commonSearchView.getClearListener().invoke();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            }
        });
        return editText;
    }
}
