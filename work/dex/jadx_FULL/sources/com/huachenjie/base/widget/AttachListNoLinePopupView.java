package com.huachenjie.base.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.base.R;
import com.huachenjie.base.widget.AttachListNoLinePopupView;
import com.lxj.xpopup.impl.AttachListPopupView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/base/widget/AttachListNoLinePopupView;", "Lcom/lxj/xpopup/impl/AttachListPopupView;", "", "applyDarkTheme", "applyLightTheme", "onCreate", "", "index", "color", "updateItemTvColor", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", RenderCallContext.TYPE_CALLBACK, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class AttachListNoLinePopupView extends AttachListPopupView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Function0<Unit> callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttachListNoLinePopupView(@NotNull Context context) {
        super(context, 0, R.layout.base_item_attach_list_popup);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void e(AttachListNoLinePopupView attachListNoLinePopupView) {
        Intrinsics.checkNotNullParameter(attachListNoLinePopupView, "this$0");
        Function0<Unit> function0 = attachListNoLinePopupView.callback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void applyDarkTheme() {
    }

    public void applyLightTheme() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super.onCreate();
        post(new Runnable() { // from class: com.zj.adlib.mc0
            @Override // java.lang.Runnable
            public final void run() {
                AttachListNoLinePopupView.e(this.f43266a);
            }
        });
    }

    public final void updateItemTvColor(final int index, final int color) {
        this.callback = new Function0<Unit>() { // from class: com.huachenjie.base.widget.AttachListNoLinePopupView.updateItemTvColor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m234invoke();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m234invoke() {
                View view;
                TextView textView;
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ((RecyclerView) AttachListNoLinePopupView.this.findViewById(R.id.recyclerView)).findViewHolderForAdapterPosition(index);
                if (viewHolderFindViewHolderForAdapterPosition == null || (view = viewHolderFindViewHolderForAdapterPosition.itemView) == null || (textView = (TextView) view.findViewById(R.id.tv_text)) == null) {
                    return;
                }
                textView.setTextColor(color);
            }
        };
    }
}
