package com.getui.gtc.dyc;

import android.util.Base64;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.util.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class h implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30348a;
    private long c;
    private String d;
    private String e;
    private Map<String, String> f;

    public static h e(String str) throws Throwable {
        Throwable th;
        ObjectInputStream objectInputStream;
        try {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(SecureCryptTools.getInstance().decrypt(Base64.decode(str.getBytes(), 0))));
                try {
                    h hVar = (h) objectInputStream.readObject();
                    IOUtils.safeClose(objectInputStream);
                    return hVar;
                } catch (IOException e) {
                    e = e;
                    com.getui.gtc.dyc.a.a.a.a(e);
                    IOUtils.safeClose(objectInputStream);
                    return null;
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    com.getui.gtc.dyc.a.a.a.a(e);
                    IOUtils.safeClose(objectInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                IOUtils.safeClose(null);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            objectInputStream = null;
            com.getui.gtc.dyc.a.a.a.a(e);
            IOUtils.safeClose(objectInputStream);
            return null;
        } catch (ClassNotFoundException e4) {
            e = e4;
            objectInputStream = null;
            com.getui.gtc.dyc.a.a.a.a(e);
            IOUtils.safeClose(objectInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            IOUtils.safeClose(null);
            throw th;
        }
    }

    public String a() {
        return this.f30348a;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(String str) {
        this.f30348a = str;
    }

    public void a(Map<String, String> map) {
        this.f = map;
    }

    public long c() {
        return this.c;
    }

    public void c(String str) {
        this.e = str;
    }

    public String d() {
        return this.e;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.d;
    }

    public Map<String, String> f() {
        return this.f;
    }

    public String g() throws Throwable {
        ObjectOutputStream objectOutputStream;
        IOException e;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                try {
                    objectOutputStream.writeObject(this);
                } catch (IOException e2) {
                    e = e2;
                    com.getui.gtc.dyc.a.a.a.a(e);
                }
            } catch (Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
                IOUtils.safeClose(objectOutputStream2);
                throw th;
            }
        } catch (IOException e3) {
            objectOutputStream = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.safeClose(objectOutputStream2);
            throw th;
        }
        IOUtils.safeClose(objectOutputStream);
        return Base64.encodeToString(SecureCryptTools.getInstance().encrypt(byteArrayOutputStream.toByteArray()), 0);
    }
}
