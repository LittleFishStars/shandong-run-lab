package com.huachenjie.channel.page.friend_list;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.FriendListAdapter;
import com.huachenjie.channel.bean.FriendListBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.im.bean.FriendUserInfo;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.bv9;
import com.zj.adlib.or6;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u00118\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R%\u0010 \u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u001d0\u001d0\u00118\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R(\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00118\u0006¢\u0006\f\n\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u0016R%\u0010.\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010(0(0\u00118\u0006¢\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0016¨\u00061"}, d2 = {"Lcom/huachenjie/channel/page/friend_list/FriendListViewModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", CachedContentIndex.a.e, "Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateLayout", "", "q", "s", "Lcom/huachenjie/channel/bean/FriendListBean;", "bookBean", "k", "f", "Ljava/lang/String;", "emptyPinyin", y6b.f, "noLetterPinyin", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "p", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "", "kotlin.jvm.PlatformType", "b", t.d, "layoutState", "Lcom/huachenjie/channel/adapter/FriendListAdapter;", "c", "j", "adapter", "", "Ljava/util/List;", "m", "()Ljava/util/List;", "t", "(Ljava/util/List;)V", "originFriendList", "", "d", "n", "queryResult", "e", j.b, "showLetterSearch", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class FriendListViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final String emptyPinyin = bv9.b;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final String noLetterPinyin = "|";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> layoutState = new MutableLiveData<>(4);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<FriendListAdapter> adapter = new MutableLiveData<>(new FriendListAdapter());

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public List<FriendListBean> originFriendList = new ArrayList();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> queryResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showLetterSearch = new MutableLiveData<>(Boolean.FALSE);

    public static /* synthetic */ void r(FriendListViewModel friendListViewModel, String str, StateLayout stateLayout, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        friendListViewModel.q(str, stateLayout);
    }

    @NotNull
    public final MutableLiveData<FriendListAdapter> j() {
        return this.adapter;
    }

    public final String k(FriendListBean bookBean) {
        String upperCase;
        String nickName;
        FriendUserInfo userInfo = bookBean.getUserInfo();
        String strSubstring = null;
        if (TextUtils.isEmpty(userInfo != null ? userInfo.formatNickName() : null)) {
            bookBean.setFirstLetter("#");
            return this.emptyPinyin;
        }
        FriendUserInfo userInfo2 = bookBean.getUserInfo();
        if (userInfo2 != null && (nickName = userInfo2.formatNickName()) != null) {
            strSubstring = nickName.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        String strA = or6.a(strSubstring);
        if (strA != null) {
            if (strA.length() == 0) {
                bookBean.setFirstLetter("#");
                upperCase = this.emptyPinyin;
            } else {
                char cFirst = StringsKt.first(strA);
                if (Character.isLetter(cFirst)) {
                    String strValueOf = String.valueOf(cFirst);
                    Locale locale = Locale.ROOT;
                    String upperCase2 = strValueOf.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    bookBean.setFirstLetter(upperCase2);
                    upperCase = strA.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                } else {
                    bookBean.setFirstLetter("#");
                    upperCase = this.noLetterPinyin;
                }
            }
            if (upperCase != null) {
                return upperCase;
            }
        }
        return this.emptyPinyin;
    }

    @NotNull
    public final MutableLiveData<Integer> l() {
        return this.layoutState;
    }

    @NotNull
    public final List<FriendListBean> m() {
        return this.originFriendList;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.queryResult;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.showLetterSearch;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> p() {
        return this.titleBean;
    }

    public final void q(@NotNull String key, @NotNull StateLayout stateLayout) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        Intrinsics.checkNotNullParameter(stateLayout, "stateLayout");
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.friend_list.FriendListViewModel$queryFriendList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.l().setValue(3);
                return Boolean.FALSE;
            }
        }, null, new FriendListViewModel$queryFriendList$2(this, stateLayout, key, null), 11, null);
    }

    public final void s(@NotNull String key, @NotNull StateLayout stateLayout) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        Intrinsics.checkNotNullParameter(stateLayout, "stateLayout");
        if (this.originFriendList.isEmpty()) {
            return;
        }
        if (!TextUtils.isEmpty(key)) {
            BaseViewModelExtKt.b(this, false, false, null, null, new FriendListViewModel$searchFriendList$1(this, stateLayout, key, null), 15, null);
            return;
        }
        FriendListAdapter value = this.adapter.getValue();
        if (value != null) {
            value.setList(this.originFriendList);
        }
        stateLayout.setEmptyLabel(ys8.e(R.string.common_empty_info));
        this.layoutState.setValue(Integer.valueOf(this.originFriendList.isEmpty() ? 2 : 1));
        this.showLetterSearch.setValue(Boolean.TRUE);
    }

    public final void t(@NotNull List<FriendListBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.originFriendList = list;
    }
}
