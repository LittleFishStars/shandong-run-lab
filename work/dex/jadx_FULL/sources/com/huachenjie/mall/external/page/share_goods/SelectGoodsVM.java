package com.huachenjie.mall.external.page.share_goods;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.external.bean.SelectGoodsBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bJ2\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004J4\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0002R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/huachenjie/mall/external/page/share_goods/SelectGoodsVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "type", "", "isSingleSelect", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectedList", "", "n", t.d, "code", "checked", "q", "m", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mall/external/page/share_goods/SelectGoodsAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "K", "I", "j", "()I", j.b, "(I)V", "pageNum", "f", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "refreshTime", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSelectGoodsVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectGoodsVM.kt\ncom/huachenjie/mall/external/page/share_goods/SelectGoodsVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1864#2,3:101\n*S KotlinDebug\n*F\n+ 1 SelectGoodsVM.kt\ncom/huachenjie/mall/external/page/share_goods/SelectGoodsVM\n*L\n92#1:101,3\n*E\n"})
public final class SelectGoodsVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<SelectGoodsAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    @NotNull
    public final MutableLiveData<SelectGoodsAdapter> i() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    public final void l(int type, boolean isSingleSelect, @Nullable ArrayList<String> selectedList) {
        this.pageNum++;
        m(type, isSingleSelect, selectedList);
    }

    public final void m(int type, boolean isSingleSelect, ArrayList<String> selectedList) {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.external.page.share_goods.SelectGoodsVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    SelectGoodsAdapter value = this.this$0.i().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                } else {
                    SelectGoodsVM selectGoodsVM = this.this$0;
                    selectGoodsVM.o(selectGoodsVM.getPageNum() - 1);
                }
                SelectGoodsAdapter value2 = this.this$0.i().getValue();
                if (value2 != null && (loadMoreModule = value2.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new SelectGoodsVM$queryPageList$2(type, this, selectedList, isSingleSelect, null), 11, null);
    }

    public final void n(int type, boolean isSingleSelect, @Nullable ArrayList<String> selectedList) {
        this.pageNum = 1;
        this.refreshTime = null;
        m(type, isSingleSelect, selectedList);
    }

    public final void o(int i) {
        this.pageNum = i;
    }

    public final void p(@Nullable String str) {
        this.refreshTime = str;
    }

    public final void q(@NotNull String code, boolean checked) {
        List<SelectGoodsBean> data;
        Intrinsics.checkNotNullParameter(code, "code");
        SelectGoodsAdapter value = this.adapter.getValue();
        if (value == null || (data = value.getData()) == null) {
            return;
        }
        int i = 0;
        for (Object obj : data) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SelectGoodsBean selectGoodsBean = (SelectGoodsBean) obj;
            if (Intrinsics.areEqual(selectGoodsBean.getGoodsNo(), code)) {
                selectGoodsBean.setChecked(checked);
                SelectGoodsAdapter value2 = this.adapter.getValue();
                if (value2 != null) {
                    value2.notifyItemChanged(i);
                    return;
                }
                return;
            }
            i = i2;
        }
    }
}
