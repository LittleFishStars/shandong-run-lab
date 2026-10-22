package com.hp.hpl.sparta;

import com.zj.adlib.vy2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface ParseHandler {
    ParseSource b();

    void c(vy2 vy2Var) throws ParseException;

    void characters(char[] cArr, int i, int i2) throws ParseException;

    void d(vy2 vy2Var) throws ParseException;

    void e(ParseSource parseSource);

    void endDocument() throws ParseException;

    void startDocument() throws ParseException;
}
