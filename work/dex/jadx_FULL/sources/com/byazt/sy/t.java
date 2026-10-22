package com.byazt.sy;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 528, 66})
public class t extends com.byazt.xj.ve<InteractWebView> {
    public String c;
    public Map<String, Object> yo;

    public t(Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public InteractWebView c() {
        InteractWebView interactWebView = new InteractWebView(this.tt);
        this.n = interactWebView;
        return interactWebView;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        Map<String, Object> mapTt = this.i.tt();
        this.yo = mapTt;
        ((InteractWebView) this.n).setUGenExtraMap(mapTt);
        ((InteractWebView) this.n).setUGenContext(this.i);
        ((InteractWebView) this.n).a();
        ((InteractWebView) this.n).sp();
        JSONObject jSONObjectDa = da();
        if (jSONObjectDa != null) {
            com.byazt.nzi.c cVar = new com.byazt.nzi.c();
            cVar.c(jSONObjectDa.optInt("meta_hashcode", 0));
            ((InteractWebView) this.n).setMaterialMeta(cVar);
        }
        x();
    }

    public void x() {
        if (TextUtils.isEmpty(this.c)) {
            this.c = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
        }
        ((InteractWebView) this.n).loadUrl(this.c);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            if (TextUtils.isEmpty(this.c) || !this.c.startsWith("http")) {
                this.c = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
            } else {
                this.c = str2;
            }
        }
    }
}
