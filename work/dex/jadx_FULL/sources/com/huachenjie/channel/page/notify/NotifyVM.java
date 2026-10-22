package com.huachenjie.channel.page.notify;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.bean.NotifyBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\nR0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/channel/page/notify/NotifyVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "m", "n", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/channel/page/notify/NotifyAdapter;", "kotlin.jvm.PlatformType", "b", "k", "adapter", "Ljava/util/LinkedHashMap;", "", "Lcom/huachenjie/channel/bean/NotifyBean;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "itemList", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nNotifyVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotifyVM.kt\ncom/huachenjie/channel/page/notify/NotifyVM\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,56:1\n215#2,2:57\n*S KotlinDebug\n*F\n+ 1 NotifyVM.kt\ncom/huachenjie/channel/page/notify/NotifyVM\n*L\n51#1:57,2\n*E\n"})
public final class NotifyVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final LinkedHashMap<Integer, NotifyBean> itemList;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<NotifyAdapter> adapter = new MutableLiveData<>(new NotifyAdapter());

    public NotifyVM() {
        LinkedHashMap<Integer, NotifyBean> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(2, new NotifyBean(2, null, false, 6, null));
        linkedHashMap.put(11, new NotifyBean(11, null, false, 6, null));
        linkedHashMap.put(9, new NotifyBean(9, null, false, 6, null));
        linkedHashMap.put(10, new NotifyBean(10, null, false, 6, null));
        linkedHashMap.put(4, new NotifyBean(4, null, false, 6, null));
        linkedHashMap.put(5, new NotifyBean(5, null, false, 6, null));
        linkedHashMap.put(6, new NotifyBean(6, null, false, 6, null));
        linkedHashMap.put(7, new NotifyBean(7, null, false, 6, null));
        this.itemList = linkedHashMap;
    }

    @NotNull
    public final MutableLiveData<NotifyAdapter> k() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> l() {
        return this.titleBean;
    }

    public final void m() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.notify.NotifyVM$requestNotifyList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.n();
                return Boolean.FALSE;
            }
        }, null, new NotifyVM$requestNotifyList$2(this, null), 11, null);
    }

    public final void n() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, NotifyBean>> it = this.itemList.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        NotifyAdapter value = this.adapter.getValue();
        if (value != null) {
            value.setList(arrayList);
        }
    }
}
