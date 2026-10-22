package com.huachenjie.works.page.share.choose_friend;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.works.R;
import com.huachenjie.works.page.share.choose_friend.ChooseFriendVM;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.dj1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", j.b, "", "Lcom/huachenjie/im/bean/FriendUserInfo;", "friendList", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "adapter", "b", "m", "friendBean", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseFriendVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChooseFriendAdapter> adapter;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<FriendUserInfo> friendBean;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/works/page/share/choose_friend/ChooseFriendVM$a", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/huachenjie/im/bean/FriendUserInfo;", "", "code", "result", "", c.f25231a, "", "onResult", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<List<? extends FriendUserInfo>> {
        public a() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        public /* bridge */ /* synthetic */ void onResult(int i, List<? extends FriendUserInfo> list, Throwable th) {
            onResult2(i, (List<FriendUserInfo>) list, th);
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(int code, @Nullable List<FriendUserInfo> result, @Nullable Throwable exception) {
            if (code == 200) {
                ChooseFriendVM.this.k(result);
                return;
            }
            ChooseFriendAdapter value = ChooseFriendVM.this.l().getValue();
            if (value != null) {
                value.p();
            }
        }
    }

    public ChooseFriendVM() {
        MutableLiveData<ChooseFriendAdapter> mutableLiveData = new MutableLiveData<>();
        this.adapter = mutableLiveData;
        this.friendBean = new MutableLiveData<>();
        mutableLiveData.setValue(new ChooseFriendAdapter());
        ChooseFriendAdapter value = mutableLiveData.getValue();
        if (value != null) {
            value.addChildClickViewIds(R.id.tv_share);
            value.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.kk1
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ChooseFriendVM.n(this.f42836a, baseQuickAdapter, view, i);
                }
            });
        }
    }

    public static final void n(ChooseFriendVM chooseFriendVM, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ChooseFriendAdapter value;
        List<FriendUserInfo> data;
        Intrinsics.checkNotNullParameter(chooseFriendVM, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        MutableLiveData<FriendUserInfo> mutableLiveData = chooseFriendVM.friendBean;
        MutableLiveData<ChooseFriendAdapter> mutableLiveData2 = chooseFriendVM.adapter;
        mutableLiveData.setValue((mutableLiveData2 == null || (value = mutableLiveData2.getValue()) == null || (data = value.getData()) == null) ? null : data.get(i));
    }

    public final void k(List<FriendUserInfo> friendList) {
        ChooseFriendAdapter value;
        ChooseFriendAdapter value2;
        if (friendList == null || friendList.isEmpty()) {
            ChooseFriendAdapter value3 = this.adapter.getValue();
            if (value3 != null) {
                value3.p();
                return;
            }
            return;
        }
        MutableLiveData<ChooseFriendAdapter> mutableLiveData = this.adapter;
        if (mutableLiveData != null && (value2 = mutableLiveData.getValue()) != null) {
            value2.l();
        }
        MutableLiveData<ChooseFriendAdapter> mutableLiveData2 = this.adapter;
        if (mutableLiveData2 == null || (value = mutableLiveData2.getValue()) == null) {
            return;
        }
        value.setList(friendList);
    }

    @NotNull
    public final MutableLiveData<ChooseFriendAdapter> l() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<FriendUserInfo> m() {
        return this.friendBean;
    }

    public final void o() {
        dj1.B(new a());
    }
}
