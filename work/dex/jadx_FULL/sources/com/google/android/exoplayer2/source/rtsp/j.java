package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30981a = "v";
    public static final String b = "o";
    public static final String c = "s";
    public static final String d = "i";
    public static final String e = "u";
    public static final String f = "e";
    public static final String g = "p";
    public static final String h = "c";
    public static final String i = "b";
    public static final String j = "t";
    public static final String k = "k";
    public static final String l = "a";
    public static final String m = "m";
    public static final String n = "r";
    public static final String o = "z";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f4428a = Pattern.compile("([a-z])=\\s?(.+)");

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Pattern f4429b = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final Pattern f4430c = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");

    public static void a(i.b bVar, MediaDescription.b bVar2) throws ParserException {
        try {
            bVar.n(bVar2.j());
        } catch (IllegalArgumentException | IllegalStateException e2) {
            throw ParserException.createForMalformedManifest(null, e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:57:0x00e9  */
    public static i b(String str) throws ParserException {
        byte b2;
        i.b bVar = new i.b();
        MediaDescription.b bVarC = null;
        for (String str2 : g.s(str)) {
            if (!"".equals(str2)) {
                Matcher matcher = f4428a.matcher(str2);
                if (!matcher.matches()) {
                    throw ParserException.createForMalformedManifest("Malformed SDP line: " + str2, null);
                }
                String str3 = (String) sb0.g(matcher.group(1));
                String str4 = (String) sb0.g(matcher.group(2));
                switch (str3.hashCode()) {
                    case 97:
                        if (str3.equals("a")) {
                            b2 = 11;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 98:
                        if (str3.equals("b")) {
                            b2 = 8;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 99:
                        if (str3.equals("c")) {
                            b2 = 7;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 100:
                    case 102:
                    case 103:
                    case 104:
                    case 106:
                    case 108:
                    case 110:
                    case 113:
                    case 119:
                    case 120:
                    case 121:
                    default:
                        b2 = -1;
                        break;
                    case 101:
                        if (str3.equals("e")) {
                            b2 = 5;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 105:
                        if (str3.equals("i")) {
                            b2 = 3;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 107:
                        if (str3.equals("k")) {
                            b2 = 10;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 109:
                        if (str3.equals("m")) {
                            b2 = 12;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 111:
                        if (str3.equals(b)) {
                            b2 = 1;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 112:
                        if (str3.equals("p")) {
                            b2 = 6;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 114:
                        if (str3.equals("r")) {
                            b2 = 13;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 115:
                        if (str3.equals("s")) {
                            b2 = 2;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 116:
                        if (str3.equals("t")) {
                            b2 = 9;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 117:
                        if (str3.equals("u")) {
                            b2 = 4;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 118:
                        if (str3.equals("v")) {
                            b2 = 0;
                        } else {
                            b2 = -1;
                        }
                        break;
                    case 122:
                        if (str3.equals(o)) {
                            b2 = com.google.common.base.a.p;
                        } else {
                            b2 = -1;
                        }
                        break;
                }
                switch (b2) {
                    case 0:
                        if (!"0".equals(str4)) {
                            throw ParserException.createForMalformedManifest(String.format("SDP version %s is not supported.", str4), null);
                        }
                        break;
                        break;
                    case 1:
                        bVar.t(str4);
                        break;
                    case 2:
                        bVar.w(str4);
                        break;
                    case 3:
                        if (bVarC == null) {
                            bVar.v(str4);
                        } else {
                            bVarC.p(str4);
                        }
                        break;
                    case 4:
                        bVar.y(Uri.parse(str4));
                        break;
                    case 5:
                        bVar.r(str4);
                        break;
                    case 6:
                        bVar.u(str4);
                        break;
                    case 7:
                        if (bVarC == null) {
                            bVar.q(str4);
                        } else {
                            bVarC.n(str4);
                        }
                        break;
                    case 8:
                        String[] strArrU1 = gj9.u1(str4, ":\\s?");
                        sb0.a(strArrU1.length == 2);
                        int i2 = Integer.parseInt(strArrU1[1]);
                        if (bVarC == null) {
                            bVar.p(i2 * 1000);
                        } else {
                            bVarC.m(i2 * 1000);
                        }
                        break;
                    case 9:
                        bVar.x(str4);
                        break;
                    case 10:
                        if (bVarC == null) {
                            bVar.s(str4);
                        } else {
                            bVarC.o(str4);
                        }
                        break;
                    case 11:
                        Matcher matcher2 = f4429b.matcher(str4);
                        if (!matcher2.matches()) {
                            throw ParserException.createForMalformedManifest("Malformed Attribute line: " + str2, null);
                        }
                        String str5 = (String) sb0.g(matcher2.group(1));
                        String strG = com.google.common.base.l.g(matcher2.group(2));
                        if (bVarC == null) {
                            bVar.m(str5, strG);
                        } else {
                            bVarC.i(str5, strG);
                        }
                        break;
                        break;
                    case 12:
                        if (bVarC != null) {
                            a(bVar, bVarC);
                        }
                        bVarC = c(str4);
                        break;
                }
            }
        }
        if (bVarC != null) {
            a(bVar, bVarC);
        }
        try {
            return bVar.o();
        } catch (IllegalArgumentException | IllegalStateException e2) {
            throw ParserException.createForMalformedManifest(null, e2);
        }
    }

    public static MediaDescription.b c(String str) throws ParserException {
        Matcher matcher = f4430c.matcher(str);
        if (!matcher.matches()) {
            throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, null);
        }
        try {
            return new MediaDescription.b((String) sb0.g(matcher.group(1)), Integer.parseInt((String) sb0.g(matcher.group(2))), (String) sb0.g(matcher.group(3)), Integer.parseInt((String) sb0.g(matcher.group(4))));
        } catch (NumberFormatException e2) {
            throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, e2);
        }
    }
}
