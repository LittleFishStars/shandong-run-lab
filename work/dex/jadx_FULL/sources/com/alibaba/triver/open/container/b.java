package com.alibaba.triver.open.container;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.view.EmbedPageContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.triver.app.f;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f25049a;

    public b(App app, FragmentActivity fragmentActivity, int i, c cVar) {
        super(app, fragmentActivity, i);
        this.f25049a = cVar;
    }

    @Override // com.alibaba.ariver.app.view.EmbedAppContext
    public EmbedPageContext createPageContext() {
        return new a(getActivity(), this.f25049a);
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public SplashView getSplashView() {
        return new SplashView() { // from class: com.alibaba.triver.open.container.b.1
            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public boolean backPressed() {
                return false;
            }

            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public void exit(SplashView.ExitListener exitListener) {
            }

            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public SplashView.Status getStatus() {
                return null;
            }

            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public void showError(final String str, final String str2, @Nullable Map<String, String> map) {
                ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.open.container.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f25049a != null) {
                            b.this.f25049a.a(str, str2);
                        }
                    }
                });
            }

            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public void showLoading(EntryInfo entryInfo) {
            }

            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public void update(EntryInfo entryInfo) {
            }
        };
    }
}
