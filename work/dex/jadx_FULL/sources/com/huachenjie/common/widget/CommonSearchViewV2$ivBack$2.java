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
@SourceDebugExtension({"SMAP\nCommonSearchViewV2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonSearchViewV2.kt\ncom/huachenjie/common/widget/CommonSearchViewV2$ivBack$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,178:1\n177#2,2:179\n*S KotlinDebug\n*F\n+ 1 CommonSearchViewV2.kt\ncom/huachenjie/common/widget/CommonSearchViewV2$ivBack$2\n*L\n90#1:179,2\n*E\n"})
public final class CommonSearchViewV2$ivBack$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ CommonSearchViewV2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonSearchViewV2$ivBack$2(CommonSearchViewV2 commonSearchViewV2) {
        super(0);
        this.this$0 = commonSearchViewV2;
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
    public final ImageView m385invoke() {
        final ImageView imageView = new ImageView(this.this$0.getContext());
        CommonSearchViewV2 commonSearchViewV2 = this.this$0;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(SizeUtils.b(44.0f), SizeUtils.b(44.0f));
        marginLayoutParams.setMarginStart(SizeUtils.b(16.0f));
        imageView.setLayoutParams(marginLayoutParams);
        int iB = SizeUtils.b(4.0f);
        imageView.setPadding(iB, iB, iB, iB);
        imageView.setImageResource(R.drawable.base_ic_back);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonSearchViewV2$ivBack$2.invoke$lambda$2$lambda$1(imageView, view);
            }
        });
        commonSearchViewV2.addView(imageView, 0);
        return imageView;
    }
}
