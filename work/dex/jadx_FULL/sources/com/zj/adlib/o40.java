package com.zj.adlib;

import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.Visitor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class o40 extends NodeTest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o40 f43662a = new o40();

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public void a(Visitor visitor) {
        visitor.g(this);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public boolean b() {
        return false;
    }

    public String toString() {
        return "*";
    }
}
