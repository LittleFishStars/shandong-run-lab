package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.q0;
import com.beizi.fusion.r0;
import com.beizi.fusion.wf;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LandingPageWebView extends BasicWebView {
    private boolean b;
    private List c;

    public LandingPageWebView(@NonNull Context context) {
        super(context);
        this.b = false;
    }

    private boolean b(String str) {
        List list;
        if (!TextUtils.isEmpty(str) && (list = this.c) != null && !list.isEmpty()) {
            for (String str2 : this.c) {
                if (str2 != null && !str2.isEmpty() && str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void e() {
        q0 q0Var = (q0) r0.a().b(getContext().getApplicationContext());
        if (q0Var != null) {
            this.c = q0Var.c();
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.BasicWebView
    public boolean a(String str) {
        if (str.startsWith("http")) {
            return true;
        }
        if (!this.b || b(str)) {
            return false;
        }
        BasicWebView.c cVar = this.f27028a;
        if (cVar != null) {
            cVar.a(getContext(), str, b());
            return false;
        }
        wf.a(getContext(), str);
        return false;
    }

    public void setAllowDeeplinkDirect(boolean z) {
        this.b = z;
    }

    public LandingPageWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        e();
    }

    public LandingPageWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        e();
    }

    public LandingPageWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = false;
        e();
    }
}
