package com.huachenjie.channel.page.notify.friend_apply;

import android.text.TextPaint;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.bean.FriendApplyBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.im.DefaultCallback;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.dj1;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R%\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0015\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00120\u00120\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u0019R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/huachenjie/channel/page/notify/friend_apply/FriendApplyListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "u", "s", "t", "", "position", t.d, "v", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", "r", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/channel/page/notify/friend_apply/FriendApplyListAdapter;", "c", "m", "adapter", "K", "I", "n", "()I", "w", "(I)V", "pageNum", "", "f", "Ljava/lang/String;", j.b, "()Ljava/lang/String;", "x", "(Ljava/lang/String;)V", "refreshTime", "Lkotlin/Lazy;", "p", "textContentWidth", "Landroid/text/TextPaint;", "d", "q", "()Landroid/text/TextPaint;", "textPaint", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class FriendApplyListVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<FriendApplyListAdapter> adapter = new MutableLiveData<>(new FriendApplyListAdapter());

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy textContentWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.channel.page.notify.friend_apply.FriendApplyListVM$textContentWidth$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m302invoke() {
            return Integer.valueOf(fx7.e() - jj8.a(180.0f));
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy textPaint = LazyKt.lazy(new Function0<TextPaint>() { // from class: com.huachenjie.channel.page.notify.friend_apply.FriendApplyListVM$textPaint$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextPaint m303invoke() {
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(jj8.f(12.0f));
            return textPaint;
        }
    });

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/channel/page/notify/friend_apply/FriendApplyListVM$a", "Lcom/huachenjie/im/DefaultCallback;", "Ljava/lang/Void;", "", "code", "result", "", c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33504a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f8303a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List<FriendApplyBean> f8304a;

        /* JADX INFO: renamed from: com.huachenjie.channel.page.notify.friend_apply.FriendApplyListVM$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/channel/page/notify/friend_apply/FriendApplyListVM$a$a", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/netease/nimlib/sdk/msg/model/IMMessage;", "", "code", "result", "", c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0790a extends DefaultCallback<IMMessage> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f33505a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ FriendApplyListVM f8305a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ List<FriendApplyBean> f8306a;

            public C0790a(FriendApplyListVM friendApplyListVM, List<FriendApplyBean> list, int i) {
                this.f8305a = friendApplyListVM;
                this.f8306a = list;
                this.f33505a = i;
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int code, @Nullable IMMessage result, @Nullable Throwable exception) {
                FriendApplyListAdapter value;
                this.f8305a.c();
                fv5.b("添加好友成功");
                this.f8306a.get(this.f33505a).setStatus(1);
                MutableLiveData<FriendApplyListAdapter> mutableLiveDataM = this.f8305a.m();
                if (mutableLiveDataM == null || (value = mutableLiveDataM.getValue()) == null) {
                    return;
                }
                value.notifyItemChanged(this.f33505a);
            }
        }

        public a(String str, List<FriendApplyBean> list, int i) {
            this.f8303a = str;
            this.f8304a = list;
            this.f33504a = i;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable Void result, @Nullable Throwable exception) {
            if (code != 200) {
                FriendApplyListVM.this.c();
            } else {
                dj1.M(this.f8303a, new C0790a(FriendApplyListVM.this, this.f8304a, this.f33504a));
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/channel/page/notify/friend_apply/FriendApplyListVM$b", "Lcom/huachenjie/im/DefaultCallback;", "Ljava/lang/Void;", "", "code", "result", "", c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DefaultCallback<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33506a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List<FriendApplyBean> f8308a;

        public b(List<FriendApplyBean> list, int i) {
            this.f8308a = list;
            this.f33506a = i;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable Void result, @Nullable Throwable exception) {
            FriendApplyListAdapter value;
            FriendApplyListVM.this.c();
            if (code != 200) {
                return;
            }
            this.f8308a.get(this.f33506a).setStatus(2);
            MutableLiveData<FriendApplyListAdapter> mutableLiveDataM = FriendApplyListVM.this.m();
            if (mutableLiveDataM == null || (value = mutableLiveDataM.getValue()) == null) {
                return;
            }
            value.notifyItemChanged(this.f33506a);
        }
    }

    public final void l(int position) {
        FriendApplyListAdapter value;
        List<FriendApplyBean> data;
        MutableLiveData<FriendApplyListAdapter> mutableLiveData = this.adapter;
        if (mutableLiveData == null || (value = mutableLiveData.getValue()) == null || (data = value.getData()) == null) {
            return;
        }
        boolean z = false;
        if (position >= 0 && position < data.size()) {
            z = true;
        }
        if (z) {
            g();
            String fromAccid = data.get(position).getFromAccid();
            dj1.h(fromAccid, new a(fromAccid, data, position));
        }
    }

    @NotNull
    public final MutableLiveData<FriendApplyListAdapter> m() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: o, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    public final int p() {
        return ((Number) this.textContentWidth.getValue()).intValue();
    }

    public final TextPaint q() {
        return (TextPaint) this.textPaint.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        return this.isRefreshing;
    }

    public final void s() {
        this.pageNum++;
        t();
    }

    public final void t() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.notify.friend_apply.FriendApplyListVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.r().setValue(Boolean.FALSE);
                    FriendApplyListAdapter value = this.this$0.m().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    FriendApplyListAdapter value2 = this.this$0.m().getValue();
                    if (value2 != null) {
                        value2.p();
                    }
                } else {
                    FriendApplyListVM friendApplyListVM = this.this$0;
                    friendApplyListVM.w(friendApplyListVM.getPageNum() - 1);
                }
                FriendApplyListAdapter value3 = this.this$0.m().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new FriendApplyListVM$queryPageList$2(this, null), 11, null);
    }

    public final void u() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        t();
    }

    public final void v(int position) {
        FriendApplyListAdapter value;
        List<FriendApplyBean> data;
        MutableLiveData<FriendApplyListAdapter> mutableLiveData = this.adapter;
        if (mutableLiveData == null || (value = mutableLiveData.getValue()) == null || (data = value.getData()) == null) {
            return;
        }
        boolean z = false;
        if (position >= 0 && position < data.size()) {
            z = true;
        }
        if (z) {
            g();
            dj1.J(data.get(position).getFromAccid(), new b(data, position));
        }
    }

    public final void w(int i) {
        this.pageNum = i;
    }

    public final void x(@Nullable String str) {
        this.refreshTime = str;
    }
}
