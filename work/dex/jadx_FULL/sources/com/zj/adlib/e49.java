package com.zj.adlib;

import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.Visitor;
import com.hp.hpl.sparta.xpath.XPathException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class e49 extends NodeTest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e49 f41345a = new e49();

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public void a(Visitor visitor) throws XPathException {
        visitor.n(this);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public boolean b() {
        return true;
    }

    public String toString() {
        return "text()";
    }
}
