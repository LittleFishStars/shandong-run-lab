package com.zj.adlib;

import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.Visitor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ud0 extends NodeTest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45116a;

    public ud0(String str) {
        this.f45116a = str;
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public void a(Visitor visitor) {
        visitor.m(this);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public boolean b() {
        return true;
    }

    public String c() {
        return this.f45116a;
    }

    public String toString() {
        return "@" + this.f45116a;
    }
}
