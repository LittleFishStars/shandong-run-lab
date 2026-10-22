package com.zj.adlib;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.ParseHandler;
import com.hp.hpl.sparta.ParseLog;
import com.hp.hpl.sparta.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class tm6 {
    public static Document a(String str) throws ParseException, IOException {
        return i(str.toCharArray());
    }

    public static Document b(String str, InputStream inputStream) throws ParseException, IOException {
        a aVar = new a();
        new qm6(str, inputStream, null, null, aVar);
        return aVar.a();
    }

    public static Document c(String str, InputStream inputStream, ParseLog parseLog) throws ParseException, IOException {
        a aVar = new a();
        new qm6(str, inputStream, parseLog, null, aVar);
        return aVar.a();
    }

    public static Document d(String str, InputStream inputStream, ParseLog parseLog, String str2) throws ParseException, IOException {
        a aVar = new a();
        new qm6(str, inputStream, parseLog, str2, aVar);
        return aVar.a();
    }

    public static Document e(String str, Reader reader) throws ParseException, IOException {
        a aVar = new a();
        new rm6(str, reader, (ParseLog) null, (String) null, aVar);
        return aVar.a();
    }

    public static Document f(String str, Reader reader, ParseLog parseLog) throws ParseException, IOException {
        a aVar = new a();
        new rm6(str, reader, parseLog, (String) null, aVar);
        return aVar.a();
    }

    public static Document g(String str, Reader reader, ParseLog parseLog, String str2) throws ParseException, IOException {
        a aVar = new a();
        new rm6(str, reader, parseLog, str2, aVar);
        return aVar.a();
    }

    public static Document h(byte[] bArr) throws ParseException, IOException {
        a aVar = new a();
        new qm6("file:anonymous-string", new ByteArrayInputStream(bArr), null, null, aVar);
        return aVar.a();
    }

    public static Document i(char[] cArr) throws ParseException, IOException {
        a aVar = new a();
        new rm6("file:anonymous-string", cArr, (ParseLog) null, (String) null, aVar);
        return aVar.a();
    }

    public static void j(String str, ParseHandler parseHandler) throws ParseException, IOException {
        r(str.toCharArray(), parseHandler);
    }

    public static void k(String str, InputStream inputStream, ParseHandler parseHandler) throws ParseException, IOException {
        new qm6(str, inputStream, null, null, parseHandler);
    }

    public static void l(String str, InputStream inputStream, ParseLog parseLog, ParseHandler parseHandler) throws ParseException, IOException {
        new qm6(str, inputStream, parseLog, null, parseHandler);
    }

    public static void m(String str, InputStream inputStream, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        new qm6(str, inputStream, parseLog, str2, parseHandler);
    }

    public static void n(String str, Reader reader, ParseHandler parseHandler) throws ParseException, IOException {
        new rm6(str, reader, (ParseLog) null, (String) null, parseHandler);
    }

    public static void o(String str, Reader reader, ParseLog parseLog, ParseHandler parseHandler) throws ParseException, IOException {
        new rm6(str, reader, parseLog, (String) null, parseHandler);
    }

    public static void p(String str, Reader reader, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        new rm6(str, reader, parseLog, str2, parseHandler);
    }

    public static void q(byte[] bArr, ParseHandler parseHandler) throws ParseException, IOException {
        new qm6("file:anonymous-string", new ByteArrayInputStream(bArr), null, null, parseHandler);
    }

    public static void r(char[] cArr, ParseHandler parseHandler) throws ParseException, IOException {
        new rm6("file:anonymous-string", cArr, (ParseLog) null, (String) null, parseHandler);
    }
}
