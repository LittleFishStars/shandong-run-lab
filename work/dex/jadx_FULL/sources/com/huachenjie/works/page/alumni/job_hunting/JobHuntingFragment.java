package com.huachenjie.works.page.alumni.job_hunting;

import com.gyf.immersionbar.e;
import com.huachenjie.base.dsbridge_webview.DWebView;
import com.huachenjie.base.dsbridge_webview.WebContentView;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksFragmentJobHuntingBinding;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/alumni/job_hunting/JobHuntingFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentJobHuntingBinding;", "Lcom/huachenjie/works/page/alumni/job_hunting/JobHuntingVM;", "()V", "getLayoutResID", "", "getVariables", "", "initData", "", "onFragmentResume", "showDarkStatusBar", "isDarkFont", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JobHuntingFragment extends BaseMVVMFragment<WorksFragmentJobHuntingBinding, JobHuntingVM> {
    private final void showDarkStatusBar(boolean isDarkFont) {
        e.z3(this).G2(R.color.transparent).T2(isDarkFont).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_job_hunting;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, JobHuntingVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        WebContentView webContentView;
        DWebView webView;
        String str = Environment.i + "/find-job/#/pages/home/index-new";
        WorksFragmentJobHuntingBinding mBinding = getMBinding();
        if (mBinding == null || (webContentView = mBinding.f36914a) == null || (webView = webContentView.getWebView()) == null) {
            return;
        }
        webView.loadUrl(str);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentResume() {
        showDarkStatusBar(true);
    }
}
