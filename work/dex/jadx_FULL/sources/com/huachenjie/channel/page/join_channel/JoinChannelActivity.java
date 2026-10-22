package com.huachenjie.channel.page.join_channel;

import android.net.Uri;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.byazt.hv.TTDownloadField;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.JoinChannelAdapter;
import com.huachenjie.channel.databinding.ChannelActivityJoinChannelBinding;
import com.huachenjie.channel.page.join_channel.JoinChannelActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.qrcode.QRCodeResultFragment;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fv5;
import com.zj.adlib.qa4;
import com.zj.adlib.tk0;
import com.zj.adlib.xh9;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH\u0002¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/channel/page/join_channel/JoinChannelActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityJoinChannelBinding;", "Lcom/huachenjie/channel/page/join_channel/JoinChannelModel;", "", "", "", "V", "getLayoutResID", "", "initView", "l0", "", "channelNo", "g0", "h0", "j0", BaseSearchResultFragment.SEARCH_CONTENT_KEY, bo.g, "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class JoinChannelActivity extends BaseMVVMActivity<ChannelActivityJoinChannelBinding, JoinChannelModel> {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/channel/page/join_channel/JoinChannelActivity$a", "Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment$ScanResultListener;", "Landroidx/appcompat/app/AppCompatActivity;", TTDownloadField.TT_ACTIVITY, "", "result", "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements QRCodeResultFragment.ScanResultListener {
        public a() {
        }

        @Override // com.huachenjie.common.page.qrcode.QRCodeResultFragment.ScanResultListener
        public void a(@Nullable AppCompatActivity activity, @NotNull String result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (TextUtils.isEmpty(result)) {
                fv5.a(R.string.channel_join_channel_undefine);
                return;
            }
            String queryParameter = Uri.parse(result).getQueryParameter(xh9.WEBSITE_PARAMS_CHANNEL);
            if (TextUtils.isEmpty(queryParameter)) {
                fv5.a(R.string.channel_join_channel_undefine);
                return;
            }
            JoinChannelActivity joinChannelActivity = JoinChannelActivity.this;
            Intrinsics.checkNotNull(queryParameter);
            joinChannelActivity.g0(queryParameter);
        }
    }

    public static final void i0(JoinChannelActivity joinChannelActivity, JoinChannelAdapter joinChannelAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(joinChannelActivity, "this$0");
        Intrinsics.checkNotNullParameter(joinChannelAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        joinChannelActivity.g0(joinChannelAdapter.getData().get(i).getChannelNo());
    }

    public static final boolean k0(JoinChannelActivity joinChannelActivity, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(joinChannelActivity, "this$0");
        if (i != 3) {
            return true;
        }
        joinChannelActivity.p0(textView.getText().toString());
        return true;
    }

    public static final void m0(JoinChannelActivity joinChannelActivity, View view) {
        Intrinsics.checkNotNullParameter(joinChannelActivity, "this$0");
        joinChannelActivity.finish();
    }

    public static final void n0(JoinChannelActivity joinChannelActivity, View view) {
        Intrinsics.checkNotNullParameter(joinChannelActivity, "this$0");
        com.huachenjie.common.page.qrcode.a.b(com.huachenjie.common.page.qrcode.a.f33831a, joinChannelActivity.new a(), false, 2, null);
    }

    public static final boolean o0(JoinChannelActivity joinChannelActivity) {
        Intrinsics.checkNotNullParameter(joinChannelActivity, "this$0");
        joinChannelActivity.getMBinding().f7567a.getEtSearch().requestFocus();
        qa4.c(joinChannelActivity.getMBinding().f7567a.getEtSearch());
        return false;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    public final void g0(String channelNo) {
        ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", channelNo).navigation();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_join_channel;
    }

    public final void h0() {
        MutableLiveData<JoinChannelAdapter> mutableLiveDataB = getMViewModel().B();
        final JoinChannelAdapter joinChannelAdapter = new JoinChannelAdapter();
        JoinChannelModel mViewModel = getMViewModel();
        StateLayout stateLayout = getMBinding().f7566a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
        mViewModel.o(this, stateLayout, joinChannelAdapter, false);
        getMViewModel().m(this, joinChannelAdapter, false);
        joinChannelAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.uo4
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                JoinChannelActivity.i0(this.f20115a, joinChannelAdapter, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataB.setValue(joinChannelAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        l0();
        h0();
        j0();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.zj.adlib.vo4
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                return JoinChannelActivity.o0(this.f45400a);
            }
        });
    }

    public final void j0() {
        EditText etSearch = getMBinding().f7567a.getEtSearch();
        etSearch.setInputType(2);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.to4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return JoinChannelActivity.k0(this.f44970a, textView, i, keyEvent);
            }
        });
        getMBinding().f7567a.setSearchListener(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.join_channel.JoinChannelActivity$initSearch$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                this.this$0.p0(str);
            }
        });
    }

    public final void l0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.channel_join_channel_title)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ro4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinChannelActivity.m0(this.f44494a, view);
            }
        }).setBackground(-1).setShowRightIcon(true).setRightIconResId(R.drawable.ic_common_scan).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.so4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinChannelActivity.n0(this.f44729a, view);
            }
        }));
    }

    public final void p0(String searchContent) {
        getMBinding().f7567a.getEtSearch().clearFocus();
        qa4.b(getMBinding().f7567a.getEtSearch());
        if (searchContent.length() == 0) {
            fv5.a(R.string.channel_join_channel_empty);
            return;
        }
        getMViewModel().r().setValue(4);
        getMViewModel().C().setValue(searchContent);
        getMViewModel().y();
    }
}
