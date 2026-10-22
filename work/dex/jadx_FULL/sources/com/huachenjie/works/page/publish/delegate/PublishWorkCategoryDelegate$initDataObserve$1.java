package com.huachenjie.works.page.publish.delegate;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.igexin.push.g.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", o.f, "", "Lcom/huachenjie/works/bean/RecommendWorksBean;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPublishWorkCategoryDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishWorkCategoryDelegate.kt\ncom/huachenjie/works/page/publish/delegate/PublishWorkCategoryDelegate$initDataObserve$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,92:1\n1864#2,3:93\n*S KotlinDebug\n*F\n+ 1 PublishWorkCategoryDelegate.kt\ncom/huachenjie/works/page/publish/delegate/PublishWorkCategoryDelegate$initDataObserve$1\n*L\n77#1:93,3\n*E\n"})
public final class PublishWorkCategoryDelegate$initDataObserve$1 extends Lambda implements Function1<List<? extends RecommendWorksBean>, Unit> {
    final /* synthetic */ PublishWorkCategoryDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishWorkCategoryDelegate$initDataObserve$1(PublishWorkCategoryDelegate publishWorkCategoryDelegate) {
        super(1);
        this.this$0 = publishWorkCategoryDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(SelectBoldTabLayout selectBoldTabLayout, Ref.IntRef intRef, PublishWorkCategoryDelegate publishWorkCategoryDelegate) {
        Intrinsics.checkNotNullParameter(selectBoldTabLayout, "$this_apply");
        Intrinsics.checkNotNullParameter(intRef, "$selIndex");
        Intrinsics.checkNotNullParameter(publishWorkCategoryDelegate, "this$0");
        selectBoldTabLayout.selectTab(selectBoldTabLayout.getTabAt(intRef.element));
        publishWorkCategoryDelegate.isFilterTabCallback = false;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<RecommendWorksBean>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<RecommendWorksBean> list) {
        List<RecommendWorksBean> list2 = list;
        int i = 0;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        final SelectBoldTabLayout selectBoldTabLayout = this.this$0.mBinding.f13911a;
        final PublishWorkCategoryDelegate publishWorkCategoryDelegate = this.this$0;
        publishWorkCategoryDelegate.isFilterTabCallback = true;
        final Ref.IntRef intRef = new Ref.IntRef();
        RecommendWorksBean value = publishWorkCategoryDelegate.mViewModel.y().getValue();
        String categoryNo = value != null ? value.getCategoryNo() : null;
        Intrinsics.checkNotNullExpressionValue(list, o.f);
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RecommendWorksBean recommendWorksBean = (RecommendWorksBean) obj;
            selectBoldTabLayout.addTab(selectBoldTabLayout.newTab().setText(recommendWorksBean.getCategoryName()));
            if (Intrinsics.areEqual(categoryNo, recommendWorksBean.getCategoryNo())) {
                intRef.element = i;
            }
            i = i2;
        }
        selectBoldTabLayout.setTabNormalStyle();
        selectBoldTabLayout.post(new Runnable() { // from class: com.huachenjie.works.page.publish.delegate.a
            @Override // java.lang.Runnable
            public final void run() {
                PublishWorkCategoryDelegate$initDataObserve$1.invoke$lambda$2$lambda$1(selectBoldTabLayout, intRef, publishWorkCategoryDelegate);
            }
        });
    }
}
