package com.huachenjie.channel.page.notify;

import androidx.p002lifecycle.MutableLiveData;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelActivityNotifyBinding;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.zj.adlib.fe9;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/channel/page/notify/NotifyFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelActivityNotifyBinding;", "Lcom/huachenjie/channel/page/notify/NotifyVM;", "()V", "getLayoutResID", "", "getVariables", "", "", "initView", "", "onFragmentResume", "showDarkStatusBar", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NotifyFragment extends BaseMVVMFragment<ChannelActivityNotifyBinding, NotifyVM> {
    private final void showDarkStatusBar() {
        e.z3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_notify;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        MutableLiveData<BindingTitleBean> mutableLiveDataL = getMViewModel().l();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            value = 0;
        }
        mutableLiveDataL.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(fe9.b.MESSAGE).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackShow(false));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentResume() {
        showDarkStatusBar();
        getMViewModel().m();
    }
}
