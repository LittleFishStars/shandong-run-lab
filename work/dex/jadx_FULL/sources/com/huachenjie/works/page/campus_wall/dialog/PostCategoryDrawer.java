package com.huachenjie.works.page.campus_wall.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.gyf.immersionbar.e;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostCategoryBean;
import com.huachenjie.works.databinding.WorksItemPostCategoryDrawerBinding;
import com.huachenjie.works.page.campus_wall.dialog.PostCategoryDrawer;
import com.kuaishou.weapon.p0.t;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.DrawerPopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.zj.adlib.jj8;
import com.zj.adlib.r5a;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001,BE\u0012\u0006\u0010(\u001a\u00020'\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014¢\u0006\u0004\b)\u0010*B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002R\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R#\u0010\u001c\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR#\u0010!\u001a\n \u0018*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R#\u0010&\u001a\n \u0018*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010%¨\u0006-"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/dialog/PostCategoryDrawer;", "Lcom/lxj/xpopup/core/DrawerPopupView;", "", "getImplLayoutId", "", "onCreate", "Lcom/lxj/xpopup/core/BasePopupView;", "show", t.d, y6b.f, "j", "", "Lcom/huachenjie/works/bean/PostCategoryBean;", "a", "Ljava/util/List;", "postCategoryBeans", "", "f", "Ljava/lang/String;", "selId", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "onConfirm", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getIvClose", "()Landroid/widget/ImageView;", "ivClose", "Landroid/widget/TextView;", "b", "getTvConfirm", "()Landroid/widget/TextView;", "tvConfirm", "Landroidx/recyclerview/widget/RecyclerView;", "c", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Landroid/content/Context;)V", "CategoryAdapter", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPostCategoryDrawer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostCategoryDrawer.kt\ncom/huachenjie/works/page/campus_wall/dialog/PostCategoryDrawer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n350#2,7:149\n*S KotlinDebug\n*F\n+ 1 PostCategoryDrawer.kt\ncom/huachenjie/works/page/campus_wall/dialog/PostCategoryDrawer\n*L\n89#1:149,7\n*E\n"})
public final class PostCategoryDrawer extends DrawerPopupView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public final List<PostCategoryBean> postCategoryBeans;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy ivClose;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public final Function1<String, Unit> onConfirm;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy tvConfirm;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy recyclerView;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String selId;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J \u0010\r\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bR\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/dialog/PostCategoryDrawer$CategoryAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/PostCategoryBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemPostCategoryDrawerBinding;", "holder", "item", "", "convert", "", GoodsSpecificationPreviewActivity.z, "", "defaultIndex", "e", "index", y6b.f, "K", "I", "selIndex", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class CategoryAdapter extends BaseQuickAdapter<PostCategoryBean, BaseDataBindingHolder<WorksItemPostCategoryDrawerBinding>> {

        /* JADX INFO: renamed from: K, reason: from kotlin metadata */
        public int selIndex;

        public CategoryAdapter() {
            super(R.layout.works_item_post_category_drawer, null, 2, null);
            this.selIndex = -1;
        }

        public static /* synthetic */ void f(CategoryAdapter categoryAdapter, Collection collection, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            categoryAdapter.e(collection, i);
        }

        public final void e(@Nullable Collection<PostCategoryBean> list, int defaultIndex) {
            if (defaultIndex >= (list != null ? list.size() : 0)) {
                return;
            }
            this.selIndex = defaultIndex;
            super.setList(list);
        }

        public final void g(int index) {
            int i = this.selIndex;
            if (index == i) {
                return;
            }
            this.selIndex = index;
            notifyItemChanged(i);
            notifyItemChanged(this.selIndex);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(@NotNull BaseDataBindingHolder<WorksItemPostCategoryDrawerBinding> holder, @NotNull PostCategoryBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            WorksItemPostCategoryDrawerBinding worksItemPostCategoryDrawerBinding = (WorksItemPostCategoryDrawerBinding) holder.getDataBinding();
            if (worksItemPostCategoryDrawerBinding != null) {
                worksItemPostCategoryDrawerBinding.k(item);
                worksItemPostCategoryDrawerBinding.getRoot().setSelected(this.selIndex == holder.getAbsoluteAdapterPosition());
                worksItemPostCategoryDrawerBinding.executePendingBindings();
            }
        }
    }

    public /* synthetic */ PostCategoryDrawer(Context context, List list, String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : function1);
    }

    private final ImageView getIvClose() {
        return (ImageView) this.ivClose.getValue();
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.recyclerView.getValue();
    }

    private final TextView getTvConfirm() {
        return (TextView) this.tvConfirm.getValue();
    }

    public static final void h(PostCategoryDrawer postCategoryDrawer, View view) {
        Intrinsics.checkNotNullParameter(postCategoryDrawer, "this$0");
        postCategoryDrawer.dismiss();
    }

    public static final void i(PostCategoryDrawer postCategoryDrawer, View view) {
        Intrinsics.checkNotNullParameter(postCategoryDrawer, "this$0");
        Function1<String, Unit> function1 = postCategoryDrawer.onConfirm;
        if (function1 != null) {
            function1.invoke(postCategoryDrawer.selId);
        }
        postCategoryDrawer.dismiss();
    }

    public static final void k(PostCategoryDrawer postCategoryDrawer, CategoryAdapter categoryAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(postCategoryDrawer, "this$0");
        Intrinsics.checkNotNullParameter(categoryAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        postCategoryDrawer.selId = categoryAdapter.getItem(i).getTagCode();
        categoryAdapter.g(i);
    }

    public final void g() {
        getIvClose().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.mv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostCategoryDrawer.h(this.f43394a, view);
            }
        });
        getTvConfirm().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostCategoryDrawer.i(this.f43616a, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.works_view_post_category_drawer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        RecyclerView recyclerView = getRecyclerView();
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setFlexDirection(0);
        boolean z = true;
        flexboxLayoutManager.setFlexWrap(1);
        flexboxLayoutManager.setJustifyContent(0);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        getRecyclerView().setItemAnimator(null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PostCategoryBean(null, null, "全部", null, null, null, 59, null));
        List<PostCategoryBean> list = this.postCategoryBeans;
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (!z) {
            arrayList.addAll(this.postCategoryBeans);
        }
        Iterator it = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((PostCategoryBean) it.next()).getTagCode(), this.selId)) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i >= 0 ? i : 0;
        final CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.e(arrayList, i2);
        categoryAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.lv6
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                PostCategoryDrawer.k(this.f18093a, categoryAdapter, baseQuickAdapter, view, i3);
            }
        });
        getRecyclerView().setAdapter(categoryAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        ViewGroup.LayoutParams layoutParams = getIvClose().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((ConstraintLayout.LayoutParams) layoutParams).setMargins(0, e.H0((Activity) context) + jj8.a(14.0f), 0, 0);
    }

    public void onCreate() {
        super/*com.lxj.xpopup.core.BasePopupView*/.onCreate();
        l();
        g();
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public BasePopupView show() {
        new r5a.b(getContext()).q0(PopupPosition.Right).U(false).b0(true).r(this);
        BasePopupView basePopupViewShow = super/*com.lxj.xpopup.core.BasePopupView*/.show();
        Intrinsics.checkNotNullExpressionValue(basePopupViewShow, "super.show()");
        return basePopupViewShow;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PostCategoryDrawer(@NotNull Context context, @Nullable List<PostCategoryBean> list, @Nullable String str, @Nullable Function1<? super String, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.postCategoryBeans = list;
        this.selId = str;
        this.onConfirm = function1;
        this.ivClose = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.works.page.campus_wall.dialog.PostCategoryDrawer$ivClose$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m881invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_close);
            }
        });
        this.tvConfirm = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.works.page.campus_wall.dialog.PostCategoryDrawer$tvConfirm$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m883invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_confirm);
            }
        });
        this.recyclerView = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.works.page.campus_wall.dialog.PostCategoryDrawer$recyclerView$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecyclerView m882invoke() {
                return (RecyclerView) this.this$0.findViewById(R.id.recyclerView);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostCategoryDrawer(@NotNull Context context) {
        this(context, null, null, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
