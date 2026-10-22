package com.huachenjie.common.widget;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonSearchView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonSearchView.kt\ncom/huachenjie/common/widget/CommonSearchView$ivBack$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,193:1\n177#2,2:194\n*S KotlinDebug\n*F\n+ 1 CommonSearchView.kt\ncom/huachenjie/common/widget/CommonSearchView$ivBack$2\n*L\n79#1:194,2\n*E\n"})
public final class CommonSearchView$ivBack$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ CommonSearchView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonSearchView$ivBack$2(CommonSearchView commonSearchView) {
        super(0);
        this.this$0 = commonSearchView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(ImageView imageView, View view) {
        Intrinsics.checkNotNullParameter(imageView, "$this_apply");
        Activity activityX = com.blankj.utilcode.util.a.x(imageView.getContext());
        if (activityX != null) {
            activityX.finish();
        }
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
    public final ImageView m379invoke() {
        final ImageView imageView = new ImageView(this.this$0.getContext());
        CommonSearchView commonSearchView = this.this$0;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(SizeUtils.b(44.0f), SizeUtils.b(44.0f));
        marginLayoutParams.setMarginStart(SizeUtils.b(8.0f));
        imageView.setLayoutParams(marginLayoutParams);
        int iB = SizeUtils.b(12.0f);
        imageView.setPadding(iB, iB, iB, iB);
        imageView.setImageResource(R.drawable.ic_back_black);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonSearchView$ivBack$2.invoke$lambda$2$lambda$1(imageView, view);
            }
        });
        commonSearchView.addView(imageView, 0);
        return imageView;
    }
}
