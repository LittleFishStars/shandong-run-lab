package com.huachenjie.works.widget.select_media;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.utils.a;
import com.huachenjie.works.widget.select_media.SelectGridPictureDelegate;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/works/widget/select_media/SelectGridPictureDelegate;", "", "Lcom/huachenjie/works/widget/select_media/SelectGridMediaAdapter;", "e", "", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "picList", "", "i", "d", "j", "adapter", y6b.f, "", "a", "Ljava/lang/String;", "savePath", "Lcom/huachenjie/works/utils/a;", "Lcom/huachenjie/works/utils/a;", "mediaPicker", "Lcom/huachenjie/works/widget/select_media/SelectGridMediaAdapter;", "<init>", "(Ljava/lang/String;Lcom/huachenjie/works/utils/a;)V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSelectGridPictureDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectGridPictureDelegate.kt\ncom/huachenjie/works/widget/select_media/SelectGridPictureDelegate\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,92:1\n766#2:93\n857#2,2:94\n1549#2:96\n1620#2,3:97\n*S KotlinDebug\n*F\n+ 1 SelectGridPictureDelegate.kt\ncom/huachenjie/works/widget/select_media/SelectGridPictureDelegate\n*L\n90#1:93\n90#1:94,2\n31#1:96\n31#1:97,3\n*E\n"})
public final class SelectGridPictureDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a mediaPicker;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SelectGridMediaAdapter adapter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final String savePath;

    public SelectGridPictureDelegate(@NotNull String str, @NotNull a aVar) {
        Intrinsics.checkNotNullParameter(str, "savePath");
        Intrinsics.checkNotNullParameter(aVar, "mediaPicker");
        this.savePath = str;
        this.mediaPicker = aVar;
        this.adapter = new SelectGridMediaAdapter(1);
    }

    public static final void f(SelectGridMediaAdapter selectGridMediaAdapter, final SelectGridPictureDelegate selectGridPictureDelegate, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(selectGridMediaAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(selectGridPictureDelegate, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (((PubWorkMediaData) selectGridMediaAdapter.getData().get(i)).getPostType() == 0) {
            selectGridPictureDelegate.j();
            return;
        }
        Iterable data = selectGridMediaAdapter.getData();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
        Iterator it = data.iterator();
        while (it.hasNext()) {
            arrayList.add(((PubWorkMediaData) it.next()).getPicPath());
        }
        List mutableList = CollectionsKt.toMutableList(arrayList);
        if (((PubWorkMediaData) CollectionsKt.last(selectGridMediaAdapter.getData())).getPostType() == 0) {
            mutableList.remove(selectGridMediaAdapter.getData().size() - 1);
        }
        PicturePreviewUtil.h(selectGridMediaAdapter.getContext(), mutableList, i, new Function1<Integer, View>() { // from class: com.huachenjie.works.widget.select_media.SelectGridPictureDelegate$initAdapter$1$1$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            @Nullable
            public final View invoke(int i2) {
                return this.this$0.adapter.getViewByPosition(i2, R.id.iv_pic);
            }
        });
    }

    public static final void h(SelectGridMediaAdapter selectGridMediaAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(selectGridMediaAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != R.id.iv_del) {
            return;
        }
        selectGridMediaAdapter.removeAt(i);
        if (((PubWorkMediaData) CollectionsKt.last(selectGridMediaAdapter.getData())).getPostType() == 1) {
            selectGridMediaAdapter.addData(new PubWorkMediaData(null, null, 0, 0, 15, null));
        }
    }

    @NotNull
    public final List<PubWorkMediaData> d() {
        Iterable data = this.adapter.getData();
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            if (((PubWorkMediaData) obj).getPostType() == 1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public final SelectGridMediaAdapter e() {
        final SelectGridMediaAdapter selectGridMediaAdapter = this.adapter;
        selectGridMediaAdapter.setList(CollectionsKt.mutableListOf(new PubWorkMediaData[]{new PubWorkMediaData(null, null, 0, 0, 15, null)}));
        selectGridMediaAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.n48
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectGridPictureDelegate.f(selectGridMediaAdapter, this, baseQuickAdapter, view, i);
            }
        });
        g(selectGridMediaAdapter);
        return this.adapter;
    }

    public final void g(final SelectGridMediaAdapter adapter) {
        adapter.addChildClickViewIds(R.id.iv_del);
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.m48
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectGridPictureDelegate.h(adapter, baseQuickAdapter, view, i);
            }
        });
    }

    public final void i(@Nullable List<PubWorkMediaData> picList) {
        List<PubWorkMediaData> list = picList;
        if (list == null || list.isEmpty()) {
            return;
        }
        SelectGridMediaAdapter selectGridMediaAdapter = this.adapter;
        selectGridMediaAdapter.addData(selectGridMediaAdapter.getData().size() - 1, (Collection) list);
        if (selectGridMediaAdapter.getData().size() > 9) {
            selectGridMediaAdapter.removeAt(selectGridMediaAdapter.getData().size() - 1);
        }
    }

    public final void j() {
        a.q(this.mediaPicker, (9 - this.adapter.getData().size()) + 1, false, this.savePath, new Function1<List<? extends PubWorkMediaData>, Unit>() { // from class: com.huachenjie.works.widget.select_media.SelectGridPictureDelegate$selectPic$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<PubWorkMediaData>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull List<PubWorkMediaData> list) {
                Intrinsics.checkNotNullParameter(list, "result");
                if (list.isEmpty()) {
                    return;
                }
                this.this$0.i(list);
            }
        }, 2, null);
    }
}
