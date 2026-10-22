package com.beizi.fusion;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class fg {
    public eg a() {
        if (d()) {
            return (eg) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public ig b() {
        if (f()) {
            return (ig) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public lg c() {
        if (g()) {
            return (lg) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean d() {
        return this instanceof eg;
    }

    public boolean e() {
        return this instanceof hg;
    }

    public boolean f() {
        return this instanceof ig;
    }

    public boolean g() {
        return this instanceof lg;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            og ogVar = new og(stringWriter);
            ogVar.a(mo.LENIENT);
            lo.a(this, ogVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
