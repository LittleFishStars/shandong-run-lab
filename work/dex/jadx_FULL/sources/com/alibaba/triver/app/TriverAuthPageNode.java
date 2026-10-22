package com.alibaba.triver.app;

import android.os.Bundle;
import android.os.Parcel;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EmbedType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverAuthPageNode extends PageNode {
    public TriverAuthPageNode(App app, String str, Bundle bundle, Bundle bundle2) {
        super(app, str, bundle, bundle2);
    }

    @Override // com.alibaba.ariver.app.PageNode
    public int generatePageId() {
        return 10000000;
    }

    @Override // com.alibaba.ariver.app.PageNode
    public void init(String str, Bundle bundle, Bundle bundle2) {
        super.init(str, bundle, bundle2);
    }

    public TriverAuthPageNode(App app, String str, Bundle bundle, Bundle bundle2, boolean z) {
        super(app, str, bundle, bundle2, z);
    }

    public TriverAuthPageNode(App app, String str, Bundle bundle, Bundle bundle2, EmbedType embedType) {
        super(app, str, bundle, bundle2, embedType);
    }

    public TriverAuthPageNode(Parcel parcel) {
        super(parcel);
    }
}
