package com.hp.hpl.sparta;

import com.zj.adlib.l39;
import com.zj.adlib.vy2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a implements DocumentSource, ParseHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Document f32697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ParseSource f6850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public vy2 f6851a;
    public final ParseLog b;

    public a() {
        this(null);
    }

    @Override // com.hp.hpl.sparta.DocumentSource
    public Document a() {
        return this.f32697a;
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public ParseSource b() {
        return this.f6850a;
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void c(vy2 vy2Var) {
        vy2 vy2Var2 = this.f6851a;
        if (vy2Var2 == null) {
            this.f32697a.A(vy2Var);
        } else {
            vy2Var2.v(vy2Var);
        }
        this.f6851a = vy2Var;
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void characters(char[] cArr, int i, int i2) {
        vy2 vy2Var = this.f6851a;
        if (vy2Var.E() instanceof l39) {
            ((l39) vy2Var.E()).x(cArr, i, i2);
        } else {
            vy2Var.w(new l39(new String(cArr, i, i2)));
        }
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void d(vy2 vy2Var) {
        this.f6851a = this.f6851a.d();
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void e(ParseSource parseSource) {
        this.f6850a = parseSource;
        this.f32697a.B(parseSource.toString());
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void endDocument() {
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public int getLineNumber() {
        ParseSource parseSource = this.f6850a;
        if (parseSource != null) {
            return parseSource.getLineNumber();
        }
        return -1;
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public String getSystemId() {
        ParseSource parseSource = this.f6850a;
        if (parseSource != null) {
            return parseSource.getSystemId();
        }
        return null;
    }

    @Override // com.hp.hpl.sparta.ParseHandler
    public void startDocument() {
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public String toString() {
        if (this.f6850a == null) {
            return null;
        }
        return "BuildDoc: " + this.f6850a.toString();
    }

    public a(ParseLog parseLog) {
        this.f6851a = null;
        this.f32697a = new Document();
        this.f6850a = null;
        this.b = parseLog == null ? ParseSource.f6848a : parseLog;
    }
}
