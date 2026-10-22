package com.huachenjie.social_contact.vm;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.SearchResultBean;
import com.zj.adlib.dj1;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import huachenjie.sdk.http.ui.HttpVmDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class SearchFriendIdVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UniverseModel f36335a = new UniverseModel();
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<String> j = new MutableLiveData<>("");
    public MutableLiveData<String> k = new MutableLiveData<>("");
    public MutableLiveData<String> l = new MutableLiveData<>("");
    public MutableLiveData<Boolean> m;
    public MutableLiveData<Boolean> n;
    public MutableLiveData<Boolean> o;
    public MutableLiveData<Boolean> p;
    public MutableLiveData<String> q;
    public MutableLiveData<String> r;
    public MutableLiveData<SearchResultBean> s;

    public class a extends DialogVMSubscriber<SearchResultBean> {

        /* JADX INFO: renamed from: com.huachenjie.social_contact.vm.SearchFriendIdVM$a$a, reason: collision with other inner class name */
        public class C0824a extends DefaultCallback<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SearchResultBean f36337a;

            public C0824a(SearchResultBean searchResultBean) {
                this.f36337a = searchResultBean;
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int i, @Nullable Boolean bool, @Nullable Throwable th) {
                if (i != 200) {
                    SearchFriendIdVM.this.j.setValue("");
                    SearchFriendIdVM.this.k.setValue("");
                    SearchFriendIdVM.this.l.setValue("");
                    SearchFriendIdVM.this.r.setValue("");
                    MutableLiveData<Boolean> mutableLiveData = SearchFriendIdVM.this.m;
                    Boolean bool2 = Boolean.FALSE;
                    mutableLiveData.setValue(bool2);
                    SearchFriendIdVM.this.n.setValue(bool2);
                    SearchFriendIdVM.this.o.setValue(bool2);
                    SearchFriendIdVM.this.p.setValue(bool2);
                    SearchFriendIdVM.this.s.setValue(this.f36337a);
                    return;
                }
                int type = this.f36337a.getType();
                if (type == 1) {
                    SearchFriendIdVM.this.j.setValue(this.f36337a.getAvatarUrl());
                    SearchFriendIdVM.this.k.setValue(this.f36337a.getAvatarFrameImgUrl());
                    SearchFriendIdVM.this.l.setValue(this.f36337a.getNickName());
                    SearchFriendIdVM.this.r.setValue("");
                    MutableLiveData<Boolean> mutableLiveData2 = SearchFriendIdVM.this.m;
                    Boolean bool3 = Boolean.TRUE;
                    mutableLiveData2.setValue(bool3);
                    SearchFriendIdVM.this.n.setValue(bool3);
                    SearchFriendIdVM.this.o.setValue(bool3);
                    SearchFriendIdVM.this.p.setValue(Boolean.FALSE);
                } else if (type == 2) {
                    SearchFriendIdVM.this.j.setValue(this.f36337a.getAvatarUrl());
                    SearchFriendIdVM.this.k.setValue(this.f36337a.getAvatarFrameImgUrl());
                    SearchFriendIdVM.this.l.setValue(this.f36337a.getNickName());
                    SearchFriendIdVM.this.r.setValue("");
                    SearchFriendIdVM.this.m.setValue(Boolean.TRUE);
                    MutableLiveData<Boolean> mutableLiveData3 = SearchFriendIdVM.this.n;
                    Boolean bool4 = Boolean.FALSE;
                    mutableLiveData3.setValue(bool4);
                    SearchFriendIdVM.this.o.setValue(bool4);
                    SearchFriendIdVM.this.p.setValue(bool4);
                } else if (type == 3) {
                    SearchFriendIdVM.this.j.setValue(this.f36337a.getAvatarUrl());
                    SearchFriendIdVM.this.k.setValue(this.f36337a.getAvatarFrameImgUrl());
                    SearchFriendIdVM.this.l.setValue(this.f36337a.getNickName());
                    SearchFriendIdVM.this.r.setValue("");
                    SearchFriendIdVM.this.m.setValue(Boolean.TRUE);
                    MutableLiveData<Boolean> mutableLiveData4 = SearchFriendIdVM.this.n;
                    Boolean bool5 = Boolean.FALSE;
                    mutableLiveData4.setValue(bool5);
                    SearchFriendIdVM.this.o.setValue(bool5);
                    SearchFriendIdVM.this.p.setValue(bool5);
                } else if (type == 4) {
                    SearchFriendIdVM.this.j.setValue(this.f36337a.getAvatarUrl());
                    SearchFriendIdVM.this.k.setValue(this.f36337a.getAvatarFrameImgUrl());
                    SearchFriendIdVM.this.l.setValue(this.f36337a.getNickName());
                    SearchFriendIdVM.this.r.setValue("");
                    MutableLiveData<Boolean> mutableLiveData5 = SearchFriendIdVM.this.m;
                    Boolean bool6 = Boolean.TRUE;
                    mutableLiveData5.setValue(bool6);
                    SearchFriendIdVM.this.n.setValue(Boolean.FALSE);
                    SearchFriendIdVM.this.o.setValue(bool6);
                    SearchFriendIdVM.this.p.setValue(bool6);
                } else {
                    SearchFriendIdVM.this.j.setValue("");
                    SearchFriendIdVM.this.k.setValue("");
                    SearchFriendIdVM.this.l.setValue("");
                    SearchFriendIdVM.this.r.setValue("");
                    MutableLiveData<Boolean> mutableLiveData6 = SearchFriendIdVM.this.m;
                    Boolean bool7 = Boolean.FALSE;
                    mutableLiveData6.setValue(bool7);
                    SearchFriendIdVM.this.n.setValue(bool7);
                    SearchFriendIdVM.this.o.setValue(bool7);
                    SearchFriendIdVM.this.p.setValue(bool7);
                }
                SearchFriendIdVM.this.s.setValue(this.f36337a);
            }
        }

        public a(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onFailed(int i, String str) {
            super.onFailed(i, str);
            SearchFriendIdVM.this.s.setValue(null);
            SearchFriendIdVM.this.j.setValue("");
            SearchFriendIdVM.this.k.setValue("");
            SearchFriendIdVM.this.l.setValue("");
            SearchFriendIdVM.this.r.setValue("");
            MutableLiveData<Boolean> mutableLiveData = SearchFriendIdVM.this.m;
            Boolean bool = Boolean.FALSE;
            mutableLiveData.setValue(bool);
            SearchFriendIdVM.this.n.setValue(bool);
            SearchFriendIdVM.this.o.setValue(bool);
            SearchFriendIdVM.this.p.setValue(bool);
        }

        public void onCCSuccess(SearchResultBean searchResultBean) {
            SearchResultBean.updateUserInfo(searchResultBean, new C0824a(searchResultBean));
        }
    }

    public class b extends DefaultCallback<Void> {
        public b() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, @Nullable Void r2, @Nullable Throwable th) {
            if (i != 200) {
                fv5.b("发送申请失败");
                return;
            }
            SearchFriendIdVM.this.r.setValue("");
            MutableLiveData<Boolean> mutableLiveData = SearchFriendIdVM.this.m;
            Boolean bool = Boolean.TRUE;
            mutableLiveData.setValue(bool);
            SearchFriendIdVM.this.n.setValue(Boolean.FALSE);
            SearchFriendIdVM.this.o.setValue(bool);
            SearchFriendIdVM.this.p.setValue(bool);
        }
    }

    public SearchFriendIdVM() {
        Boolean bool = Boolean.FALSE;
        this.m = new MutableLiveData<>(bool);
        this.n = new MutableLiveData<>(bool);
        this.o = new MutableLiveData<>(bool);
        this.p = new MutableLiveData<>(bool);
        this.q = new MutableLiveData<>("");
        this.r = new MutableLiveData<>("");
        this.s = new MutableLiveData<>();
    }

    public void h() {
        if (Boolean.TRUE.equals(this.p.getValue())) {
            return;
        }
        if (TextUtils.isEmpty(this.q.getValue())) {
            fv5.b("请输入搜索id");
        } else if (this.s.getValue() == null || TextUtils.isEmpty(this.s.getValue().getAccId())) {
            fv5.b("数据异常，请重新搜索好友");
        } else {
            dj1.f(this.s.getValue().getAccId(), this.r.getValue(), new b());
        }
    }

    public void i() {
        if (TextUtils.isEmpty(this.q.getValue())) {
            fv5.b("请输入搜索id");
        } else {
            n76.e(this, this.f36335a.C(this.q.getValue())).p5(new a(this, true));
        }
    }
}
