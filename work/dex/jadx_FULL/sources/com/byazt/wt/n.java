package com.byazt.wt;

import com.alibaba.android.arouter.utils.Consts;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1564, 46})
public final class n implements HostnameVerifier {
    public static final n c = new n();

    private n() {
    }

    private boolean tt(String str, X509Certificate x509Certificate) {
        List<String> listC = c(x509Certificate, 7);
        int size = listC.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listC.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean ve(String str, X509Certificate x509Certificate) {
        String strC;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listC = c(x509Certificate, 2);
        int size = listC.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (c(lowerCase, listC.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (strC = new uj(x509Certificate.getSubjectX500Principal()).c("cn")) == null) {
            return false;
        }
        return c(lowerCase, strC);
    }

    public boolean c(String str, X509Certificate x509Certificate) {
        return com.byazt.kh.ve.ve(str) ? tt(str, x509Certificate) : ve(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return c(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public static List<String> c(X509Certificate x509Certificate) {
        List<String> listC = c(x509Certificate, 7);
        List<String> listC2 = c(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listC.size() + listC2.size());
        arrayList.addAll(listC);
        arrayList.addAll(listC2);
        return arrayList;
    }

    private static List<String> c(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    public boolean c(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(Consts.DOT) && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(Consts.DOT) && !str2.endsWith("..")) {
            if (!str.endsWith(Consts.DOT)) {
                str = str + '.';
            }
            if (!str2.endsWith(Consts.DOT)) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
