package com.huachenjie.works.widget.select_media;

import android.app.Activity;
import android.view.View;
import com.byazt.hv.TTDownloadField;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.utils.a;
import com.huachenjie.works.widget.select_media.SelectGridVideoDelegate;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R$\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/huachenjie/works/widget/select_media/SelectGridVideoDelegate;", "", "Lcom/huachenjie/works/widget/select_media/SelectGridMediaAdapter;", "f", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "videoData", "", "i", "", "d", "k", "j", "", "picPath", "m", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Ljava/lang/String;", "savePath", "Lcom/huachenjie/works/utils/a;", "Lcom/huachenjie/works/utils/a;", "mediaPicker", "Lcom/huachenjie/works/widget/select_media/SelectGridMediaAdapter;", "adapter", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "e", "()Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", t.d, "(Lcom/huachenjie/works/bean/publish/PubWorkMediaData;)V", "selVideoData", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lcom/huachenjie/works/utils/a;)V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSelectGridVideoDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectGridVideoDelegate.kt\ncom/huachenjie/works/widget/select_media/SelectGridVideoDelegate\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,119:1\n766#2:120\n857#2,2:121\n*S KotlinDebug\n*F\n+ 1 SelectGridVideoDelegate.kt\ncom/huachenjie/works/widget/select_media/SelectGridVideoDelegate\n*L\n117#1:120\n117#1:121,2\n*E\n"})
public final class SelectGridVideoDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Activity activity;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public PubWorkMediaData selVideoData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final a mediaPicker;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SelectGridMediaAdapter adapter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final String savePath;

    public SelectGridVideoDelegate(@NotNull Activity activity, @NotNull String str, @NotNull a aVar) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "savePath");
        Intrinsics.checkNotNullParameter(aVar, "mediaPicker");
        this.activity = activity;
        this.savePath = str;
        this.mediaPicker = aVar;
        this.adapter = new SelectGridMediaAdapter(2);
    }

    public static final void g(SelectGridMediaAdapter selectGridMediaAdapter, SelectGridVideoDelegate selectGridVideoDelegate, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(selectGridMediaAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(selectGridVideoDelegate, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (((PubWorkMediaData) selectGridMediaAdapter.getData().get(i)).getPostType() == 0) {
            selectGridVideoDelegate.k();
        }
    }

    public static final void h(final SelectGridVideoDelegate selectGridVideoDelegate, SelectGridMediaAdapter selectGridMediaAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(selectGridVideoDelegate, "this$0");
        Intrinsics.checkNotNullParameter(selectGridMediaAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == R.id.fl_container || id == R.id.bt_preview) {
            selectGridVideoDelegate.j();
            return;
        }
        if (id == R.id.bt_cover) {
            selectGridVideoDelegate.mediaPicker.p(1, true, selectGridVideoDelegate.savePath, new Function1<List<? extends PubWorkMediaData>, Unit>() { // from class: com.huachenjie.works.widget.select_media.SelectGridVideoDelegate$initAdapter$1$2$1
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
                    SelectGridVideoDelegate selectGridVideoDelegate2 = this.this$0;
                    String picPath = list.get(0).getPicPath();
                    if (picPath == null) {
                        picPath = "";
                    }
                    selectGridVideoDelegate2.m(picPath);
                }
            });
        } else if (id == R.id.bt_del) {
            selectGridMediaAdapter.setList(CollectionsKt.mutableListOf(new PubWorkMediaData[]{new PubWorkMediaData(null, null, 0, 0, 15, null)}));
            selectGridVideoDelegate.selVideoData = null;
        }
    }

    @NotNull
    public final List<PubWorkMediaData> d() {
        Iterable data = this.adapter.getData();
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            if (((PubWorkMediaData) obj).getPostType() == 2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Nullable
    /* JADX INFO: renamed from: e, reason: from getter */
    public final PubWorkMediaData getSelVideoData() {
        return this.selVideoData;
    }

    @NotNull
    public final SelectGridMediaAdapter f() {
        final SelectGridMediaAdapter selectGridMediaAdapter = this.adapter;
        selectGridMediaAdapter.setList(CollectionsKt.mutableListOf(new PubWorkMediaData[]{new PubWorkMediaData(null, null, 0, 0, 15, null)}));
        selectGridMediaAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.o48
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectGridVideoDelegate.g(selectGridMediaAdapter, this, baseQuickAdapter, view, i);
            }
        });
        selectGridMediaAdapter.addChildClickViewIds(R.id.fl_container);
        selectGridMediaAdapter.addChildClickViewIds(R.id.bt_cover);
        selectGridMediaAdapter.addChildClickViewIds(R.id.bt_preview);
        selectGridMediaAdapter.addChildClickViewIds(R.id.bt_del);
        selectGridMediaAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.p48
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectGridVideoDelegate.h(this.f18770a, selectGridMediaAdapter, baseQuickAdapter, view, i);
            }
        });
        return this.adapter;
    }

    public final void i(@Nullable PubWorkMediaData videoData) {
        this.selVideoData = videoData;
        if (videoData == null) {
            return;
        }
        SelectGridMediaAdapter selectGridMediaAdapter = this.adapter;
        selectGridMediaAdapter.removeAt(0);
        selectGridMediaAdapter.addData(videoData);
    }

    public final void j() {
        String videoPath;
        VideoPlayerActivity.Companion companion = VideoPlayerActivity.INSTANCE;
        Activity activity = this.activity;
        PubWorkMediaData pubWorkMediaData = this.selVideoData;
        if (pubWorkMediaData == null || (videoPath = pubWorkMediaData.getVideoPath()) == null) {
            videoPath = "";
        }
        companion.a(activity, videoPath);
    }

    public final void k() {
        this.mediaPicker.p(1, false, this.savePath, new Function1<List<? extends PubWorkMediaData>, Unit>() { // from class: com.huachenjie.works.widget.select_media.SelectGridVideoDelegate$selectVideo$1
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
                this.this$0.i(list.get(0));
            }
        });
    }

    public final void l(@Nullable PubWorkMediaData pubWorkMediaData) {
        this.selVideoData = pubWorkMediaData;
    }

    public final void m(String picPath) {
        SelectGridMediaAdapter selectGridMediaAdapter = this.adapter;
        PubWorkMediaData pubWorkMediaData = (PubWorkMediaData) CollectionsKt.firstOrNull(selectGridMediaAdapter.getData());
        if (pubWorkMediaData == null) {
            return;
        }
        pubWorkMediaData.setPicPath(picPath);
        selectGridMediaAdapter.notifyItemChanged(0);
    }
}
