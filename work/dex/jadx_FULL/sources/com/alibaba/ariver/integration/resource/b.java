package com.alibaba.ariver.integration.resource;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends a {
    private Fragment e;
    private RVMain.a f;

    public b(RVAppRecord rVAppRecord, PrepareContext prepareContext, RVMain.a aVar) {
        super(rVAppRecord, prepareContext);
        this.f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.ariver.integration.resource.a, com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void startApp(PrepareCallbackParam prepareCallbackParam) {
        if (!this.c || this.e == null) {
            this.c = true;
            Intent intent = new Intent();
            intent.putExtra(RVConstants.EXTRA_ARIVER_START_BUNDLE, a(prepareCallbackParam));
            this.e = ((RVClientStarter) RVProxy.get(RVClientStarter.class)).createFragment(this.d.getStartContext(), this.b, intent.getExtras());
            this.b.setActivityClz(this.d.getStartContext().getClass());
            RVMain.a aVar = this.f;
            if (aVar != null) {
                aVar.a(this.e);
            }
        }
    }
}
