package com.zj.adlib;

import com.hp.hpl.sparta.Sparta;
import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.Visitor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class zy2 extends NodeTest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46367a;

    public zy2(String str) {
        this.f46367a = Sparta.a(str);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public void a(Visitor visitor) {
        visitor.o(this);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public boolean b() {
        return false;
    }

    public String c() {
        return this.f46367a;
    }

    public String toString() {
        return this.f46367a;
    }
}
