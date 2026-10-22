package com.huachenjie.works.page.local;

import android.text.Html;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.database.PublicWorkDatabase;
import com.huachenjie.works.database.PublicWorkDraft;
import com.huachenjie.works.external.base.BaseWorksListVM;
import com.huachenjie.works.external.bean.LocaleWorkItemBean;
import com.huachenjie.works.external.bean.WorkCoverBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/local/LocalWorksVM;", "Lcom/huachenjie/works/external/base/BaseWorksListVM;", "", "Lcom/huachenjie/works/external/bean/LocaleWorkItemBean;", "w", "", "position", "", "v", "", "Lcom/huachenjie/works/database/PublicWorkDraft;", "a", "Ljava/util/List;", "x", "()Ljava/util/List;", "y", "(Ljava/util/List;)V", "workEntityList", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nLocalWorksVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalWorksVM.kt\ncom/huachenjie/works/page/local/LocalWorksVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1549#2:63\n1620#2,2:64\n1622#2:67\n1#3:66\n*S KotlinDebug\n*F\n+ 1 LocalWorksVM.kt\ncom/huachenjie/works/page/local/LocalWorksVM\n*L\n29#1:63\n29#1:64,2\n29#1:67\n*E\n"})
public final class LocalWorksVM extends BaseWorksListVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public List<PublicWorkDraft> workEntityList;

    public final void v(int position) {
        PublicWorkDraft publicWorkDraft = x().get(position);
        x().remove(position);
        BaseViewModelExtKt.b(this, true, false, null, null, new LocalWorksVM$deleteWork$1(publicWorkDraft, this, null), 14, null);
    }

    @NotNull
    public final List<LocaleWorkItemBean> w() {
        String videoPath;
        List<PublicWorkDraft> allWorks = PublicWorkDatabase.INSTANCE.getPublicWorkDao().getAllWorks();
        y(CollectionsKt.toMutableList(allWorks));
        List<PublicWorkDraft> list = allWorks;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (PublicWorkDraft publicWorkDraft : list) {
            LocaleWorkItemBean localeWorkItemBean = new LocaleWorkItemBean();
            String title = publicWorkDraft.getTitle();
            int mediaHeight = 0;
            if (title.length() == 0) {
                title = publicWorkDraft.getContent();
            }
            localeWorkItemBean.setTitle(Html.fromHtml(title).toString());
            PubWorkMediaData videoMedia = (PubWorkMediaData) CollectionsKt.firstOrNull(publicWorkDraft.getPicList());
            if (videoMedia == null) {
                videoMedia = publicWorkDraft.getVideoMedia();
            }
            if (videoMedia == null || (videoPath = videoMedia.getPicPath()) == null) {
                videoPath = videoMedia != null ? videoMedia.getVideoPath() : null;
                if (videoPath == null) {
                    videoPath = "";
                }
            }
            String str = videoPath;
            int mediaWidth = videoMedia != null ? videoMedia.getMediaWidth() : 0;
            if (videoMedia != null) {
                mediaHeight = videoMedia.getMediaHeight();
            }
            localeWorkItemBean.setCoverImg(new WorkCoverBean(str, mediaWidth, mediaHeight, 0, 8, null));
            localeWorkItemBean.setId(publicWorkDraft.getId());
            localeWorkItemBean.setMediaPath(publicWorkDraft.getMediaPath());
            localeWorkItemBean.setAttachmentType(publicWorkDraft.getAttachmentType());
            arrayList.add(localeWorkItemBean);
        }
        return arrayList;
    }

    @NotNull
    public final List<PublicWorkDraft> x() {
        List<PublicWorkDraft> list = this.workEntityList;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("workEntityList");
        return null;
    }

    public final void y(@NotNull List<PublicWorkDraft> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.workEntityList = list;
    }
}
