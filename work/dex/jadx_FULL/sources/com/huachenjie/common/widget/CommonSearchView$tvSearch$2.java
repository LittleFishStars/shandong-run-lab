package com.huachenjie.common.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.R;
import com.zj.adlib.qa4;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonSearchView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonSearchView.kt\ncom/huachenjie/common/widget/CommonSearchView$tvSearch$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,193:1\n177#2,2:194\n*S KotlinDebug\n*F\n+ 1 CommonSearchView.kt\ncom/huachenjie/common/widget/CommonSearchView$tvSearch$2\n*L\n97#1:194,2\n*E\n"})
public final class CommonSearchView$tvSearch$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ CommonSearchView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonSearchView$tvSearch$2(CommonSearchView commonSearchView) {
        super(0);
        this.this$0 = commonSearchView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(CommonSearchView commonSearchView, View view) {
        Intrinsics.checkNotNullParameter(commonSearchView, "this$0");
        qa4.b(commonSearchView.getEtSearch());
        commonSearchView.getEtSearch().clearFocus();
        commonSearchView.getSearchListener().invoke(commonSearchView.getEtSearch().getText().toString());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final TextView m382invoke() {
        TextView textView = new TextView(this.this$0.getContext());
        final CommonSearchView commonSearchView = this.this$0;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.setMarginEnd(SizeUtils.b(8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int iB = SizeUtils.b(8.0f);
        textView.setPadding(iB, iB, iB, iB);
        textView.setTextSize(14.0f);
        textView.setTextColor(textView.getResources().getColor(R.color.color_999999));
        textView.setText(R.string.common_search);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonSearchView$tvSearch$2.invoke$lambda$2$lambda$1(commonSearchView, view);
            }
        });
        commonSearchView.addView(textView);
        return textView;
    }
}
