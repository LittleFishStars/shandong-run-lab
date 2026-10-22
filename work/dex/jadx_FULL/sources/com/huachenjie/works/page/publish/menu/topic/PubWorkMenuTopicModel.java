package com.huachenjie.works.page.publish.menu.topic;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.bean.publish.PubWorkTopicBean;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J0\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH\u0002R#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/topic/PubWorkMenuTopicModel;", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuModel;", "", "isRefreshData", "", "w", "Lcom/huachenjie/works/bean/publish/PubWorkTopicBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "K", "", "type", "O", "", "keyWord", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "pageEntity", "N", "Landroidx/lifecycle/MutableLiveData;", "m", "Landroidx/lifecycle/MutableLiveData;", "M", "()Landroidx/lifecycle/MutableLiveData;", "hotTopicList", "n", "L", "createTopicResult", "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PubWorkMenuTopicModel extends BasePubWorkMenuModel {
    public static final int L = 1;
    public static final int M = 2;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PubWorksMenuPageEntity<PubWorkTopicBean>> hotTopicList = new MutableLiveData<>();

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PubWorkTopicBean> createTopicResult = new MutableLiveData<>();

    public final void K(@NotNull PubWorkTopicBean bean) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        BaseViewModelExtKt.b(this, true, false, null, null, new PubWorkMenuTopicModel$createTopic$1(bean, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<PubWorkTopicBean> L() {
        return this.createTopicResult;
    }

    @NotNull
    public final MutableLiveData<PubWorksMenuPageEntity<PubWorkTopicBean>> M() {
        return this.hotTopicList;
    }

    public final PubWorksMenuPageEntity<PubWorkTopicBean> N(int type, String keyWord, PubWorksMenuPageEntity<PubWorkTopicBean> pageEntity) {
        if (type == 1) {
            return pageEntity;
        }
        if (pageEntity == null) {
            pageEntity = new PubWorksMenuPageEntity<>(0, 1, null);
        }
        if ((keyWord.length() > 0) && pageEntity.getList().isEmpty()) {
            pageEntity.setList(CollectionsKt.mutableListOf(new PubWorkTopicBean[]{new PubWorkTopicBean(keyWord, null, null, true, 6, null)}));
        }
        return pageEntity;
    }

    public final void O(boolean isRefreshData, int type) {
        if (isRefreshData) {
            z(1);
            return;
        }
        if (type == 1) {
            PubWorksMenuPageEntity<PubWorkTopicBean> value = this.hotTopicList.getValue();
            if (value != null) {
                z(value.getPageNum());
                A(value.getRefreshTime());
                return;
            }
            return;
        }
        PubWorksMenuPageEntity<?> value2 = E().getValue();
        if (value2 != null) {
            z(value2.getPageNum());
            A(value2.getRefreshTime());
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        Integer value = C().getValue();
        if (value == null) {
            value = 1;
        }
        int iIntValue = value.intValue();
        O(isRefreshData, iIntValue);
        super.w(isRefreshData);
        String value2 = H().getValue();
        if (value2 == null) {
            value2 = "";
        }
        BaseViewModelExtKt.b(this, false, false, q(), null, new PubWorkMenuTopicModel$loadMoreData$1(value2, this, iIntValue, null), 11, null);
    }
}
