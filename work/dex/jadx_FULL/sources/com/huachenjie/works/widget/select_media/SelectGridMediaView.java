package com.huachenjie.works.widget.select_media;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.utils.a;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&B\u001b\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b%\u0010)B#\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b%\u0010,B+\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b%\u0010.J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\tJ\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010!¨\u0006/"}, d2 = {"Lcom/huachenjie/works/widget/select_media/SelectGridMediaView;", "Landroid/widget/FrameLayout;", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "", "savePath", "", "initSelectGridPicture", "", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "picList", "insertPicture", "getSelPictureList", "", "isSelectedMedia", "initSelectGridVideo", "videoData", "insertVideo", "getSelectedVideo", "getSelVideoCoverList", "Lcom/huachenjie/works/utils/a;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/Lazy;", "getRvMedia", "()Landroidx/recyclerview/widget/RecyclerView;", "rvMedia", "Lcom/huachenjie/works/widget/select_media/SelectGridPictureDelegate;", "Lcom/huachenjie/works/widget/select_media/SelectGridPictureDelegate;", "pictureDelegate", "Lcom/huachenjie/works/widget/select_media/SelectGridVideoDelegate;", "Lcom/huachenjie/works/widget/select_media/SelectGridVideoDelegate;", "videoDelegate", "Lcom/huachenjie/works/utils/a;", "mediaPicker", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSelectGridMediaView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectGridMediaView.kt\ncom/huachenjie/works/widget/select_media/SelectGridMediaView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,126:1\n1#2:127\n*E\n"})
public final class SelectGridMediaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a mediaPicker;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public SelectGridPictureDelegate pictureDelegate;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public SelectGridVideoDelegate videoDelegate;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy rvMedia;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectGridMediaView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rvMedia = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.works.widget.select_media.SelectGridMediaView$rvMedia$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecyclerView m995invoke() {
                View viewInflate = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.works_view_select_grid_media, (ViewGroup) this.this$0, false);
                this.this$0.addView(viewInflate);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                return (RecyclerView) viewInflate;
            }
        });
    }

    private final RecyclerView getRvMedia() {
        return (RecyclerView) this.rvMedia.getValue();
    }

    public final a a(FragmentActivity activity) {
        a aVar = this.mediaPicker;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(activity);
        this.mediaPicker = aVar2;
        return aVar2;
    }

    @NotNull
    public final List<PubWorkMediaData> getSelPictureList() {
        List<PubWorkMediaData> listD;
        SelectGridPictureDelegate selectGridPictureDelegate = this.pictureDelegate;
        return (selectGridPictureDelegate == null || (listD = selectGridPictureDelegate.d()) == null) ? CollectionsKt.emptyList() : listD;
    }

    @NotNull
    public final List<PubWorkMediaData> getSelVideoCoverList() {
        List<PubWorkMediaData> listD;
        SelectGridVideoDelegate selectGridVideoDelegate = this.videoDelegate;
        return (selectGridVideoDelegate == null || (listD = selectGridVideoDelegate.d()) == null) ? CollectionsKt.emptyList() : listD;
    }

    @Nullable
    public final PubWorkMediaData getSelectedVideo() {
        SelectGridVideoDelegate selectGridVideoDelegate = this.videoDelegate;
        if (selectGridVideoDelegate != null) {
            return selectGridVideoDelegate.getSelVideoData();
        }
        return null;
    }

    public final void initSelectGridPicture(@NotNull FragmentActivity activity, @NotNull String savePath) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        this.pictureDelegate = new SelectGridPictureDelegate(savePath, a(activity));
        RecyclerView rvMedia = getRvMedia();
        SelectGridPictureDelegate selectGridPictureDelegate = this.pictureDelegate;
        Intrinsics.checkNotNull(selectGridPictureDelegate);
        rvMedia.setAdapter(selectGridPictureDelegate.e());
    }

    public final void initSelectGridVideo(@NotNull FragmentActivity activity, @NotNull String savePath) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        this.videoDelegate = new SelectGridVideoDelegate(activity, savePath, a(activity));
        RecyclerView rvMedia = getRvMedia();
        SelectGridVideoDelegate selectGridVideoDelegate = this.videoDelegate;
        Intrinsics.checkNotNull(selectGridVideoDelegate);
        rvMedia.setAdapter(selectGridVideoDelegate.f());
    }

    public final void insertPicture(@Nullable List<PubWorkMediaData> picList) {
        SelectGridPictureDelegate selectGridPictureDelegate = this.pictureDelegate;
        if (selectGridPictureDelegate != null) {
            selectGridPictureDelegate.i(picList);
        }
    }

    public final void insertVideo(@Nullable PubWorkMediaData videoData) {
        SelectGridVideoDelegate selectGridVideoDelegate = this.videoDelegate;
        if (selectGridVideoDelegate != null) {
            selectGridVideoDelegate.i(videoData);
        }
    }

    public final boolean isSelectedMedia() {
        SelectGridPictureDelegate selectGridPictureDelegate = this.pictureDelegate;
        if (selectGridPictureDelegate != null) {
            Intrinsics.checkNotNull(selectGridPictureDelegate);
            return !selectGridPictureDelegate.d().isEmpty();
        }
        SelectGridVideoDelegate selectGridVideoDelegate = this.videoDelegate;
        return (selectGridVideoDelegate != null ? selectGridVideoDelegate.getSelVideoData() : null) != null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectGridMediaView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rvMedia = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.works.widget.select_media.SelectGridMediaView$rvMedia$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecyclerView m995invoke() {
                View viewInflate = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.works_view_select_grid_media, (ViewGroup) this.this$0, false);
                this.this$0.addView(viewInflate);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                return (RecyclerView) viewInflate;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectGridMediaView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rvMedia = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.works.widget.select_media.SelectGridMediaView$rvMedia$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecyclerView m995invoke() {
                View viewInflate = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.works_view_select_grid_media, (ViewGroup) this.this$0, false);
                this.this$0.addView(viewInflate);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                return (RecyclerView) viewInflate;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectGridMediaView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rvMedia = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.works.widget.select_media.SelectGridMediaView$rvMedia$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecyclerView m995invoke() {
                View viewInflate = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.works_view_select_grid_media, (ViewGroup) this.this$0, false);
                this.this$0.addView(viewInflate);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                return (RecyclerView) viewInflate;
            }
        });
    }
}
