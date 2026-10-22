package com.zj.adlib;

import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.ParseHandler;
import com.hp.hpl.sparta.ParseSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class nh2 implements ParseHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ParseSource f43523a = null;

    @Override // com.hp.hpl.sparta.ParseHandler
    public ParseSource b() {
        return this.f43523a;
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void c(vy2 vy2Var) throws ParseException {
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void characters(char[] cArr, int i, int i2) throws ParseException {
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void d(vy2 vy2Var) throws ParseException {
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void e(ParseSource parseSource) {
        this.f43523a = parseSource;
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void endDocument() throws ParseException {
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void startDocument() throws ParseException {
    }
}
