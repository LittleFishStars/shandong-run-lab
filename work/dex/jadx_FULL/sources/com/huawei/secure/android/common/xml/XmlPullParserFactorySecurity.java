package com.huawei.secure.android.common.xml;

import com.zj.adlib.u6a;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class XmlPullParserFactorySecurity {
    public static u6a getInstance() throws XmlPullParserException {
        u6a u6aVarD = u6a.d();
        u6aVarD.h("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        u6aVarD.h("http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes", false);
        u6aVarD.h("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
        u6aVarD.h("http://xmlpull.org/v1/doc/features.html#validation", false);
        return u6aVarD;
    }
}
