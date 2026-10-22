package com.alibaba.triver.open.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.model.ErrorInfo;
import com.alibaba.triver.kit.api.widget.Action;
import com.alibaba.triver.open.api.DowngradeEnum;
import com.alibaba.triver.open.proxy.IRouterProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TBErrorView f25092a;
    Context b;
    private Page c;

    @Override // com.alibaba.triver.kit.api.widget.Action
    public void attatchPage(Page page) {
        super.attatchPage(page);
        this.c = page;
    }

    @Override // com.alibaba.triver.kit.api.widget.Action
    public View getView(final Context context) {
        this.b = context;
        if (this.f25092a == null) {
            TBErrorView tBErrorView = new TBErrorView(context);
            this.f25092a = tBErrorView;
            tBErrorView.setBackgroundColor(Color.parseColor("#f4f4f4"));
            this.f25092a.a(TBErrorView.ButtonType.BUTTON_LEFT, "前往淘宝", new View.OnClickListener() { // from class: com.alibaba.triver.open.widget.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.c == null || e.this.c.getApp() == null) {
                        return;
                    }
                    ((IRouterProxy) RVProxy.get(IRouterProxy.class)).downgrade(context, null, e.this.c.getApp().getStartUrl(), DowngradeEnum.UNKNOWN.getKey());
                    e eVar = e.this;
                    if (eVar.b instanceof Activity) {
                        eVar.f25092a.post(new Runnable() { // from class: com.alibaba.triver.open.widget.e.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((Activity) e.this.b).finish();
                            }
                        });
                    }
                }
            });
        }
        return this.f25092a;
    }

    public void a(ErrorInfo errorInfo, boolean z) {
        TBErrorView tBErrorView = this.f25092a;
        if (tBErrorView != null) {
            tBErrorView.setError(errorInfo);
        }
    }
}
