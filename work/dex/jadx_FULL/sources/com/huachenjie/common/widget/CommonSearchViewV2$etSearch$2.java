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
@SourceDebugExtension({"SMAP\nCommonSearchViewV2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonSearchViewV2.kt\ncom/huachenjie/common/widget/CommonSearchViewV2$etSearch$2\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,178:1\n65#2,16:179\n93#2,3:195\n*S KotlinDebug\n*F\n+ 1 CommonSearchViewV2.kt\ncom/huachenjie/common/widget/CommonSearchViewV2$etSearch$2\n*L\n55#1:179,16\n55#1:195,3\n*E\n"})
public final class CommonSearchViewV2$etSearch$2 extends Lambda implements Function0<EditText> {
    final /* synthetic */ CommonSearchViewV2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonSearchViewV2$etSearch$2(CommonSearchViewV2 commonSearchViewV2) {
        super(0);
        this.this$0 = commonSearchViewV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$2$lambda$0(CommonSearchViewV2 commonSearchViewV2, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(commonSearchViewV2, "this$0");
        textView.clearFocus();
        qa4.b(textView);
        commonSearchViewV2.getSearchListener().invoke(commonSearchViewV2.getEtSearch().getText().toString());
        return true;
    }

    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final EditText m384invoke() {
        View viewFindViewById = this.this$0.getLlSearch().findViewById(R.id.et_search);
        final CommonSearchViewV2 commonSearchViewV2 = this.this$0;
        EditText editText = (EditText) viewFindViewById;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.huachenjie.common.widget.e
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return CommonSearchViewV2$etSearch$2.invoke$lambda$2$lambda$0(commonSearchViewV2, textView, i, keyEvent);
            }
        });
        Intrinsics.checkNotNullExpressionValue(editText, "invoke$lambda$2");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.huachenjie.common.widget.CommonSearchViewV2$etSearch$2$invoke$lambda$2$$inlined$addTextChangedListener$default$1
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
                commonSearchViewV2.getClearListener().invoke();
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
