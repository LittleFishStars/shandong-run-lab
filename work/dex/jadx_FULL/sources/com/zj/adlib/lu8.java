package com.zj.adlib;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Log;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class lu8 extends SimpleSubtitleDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f43154a = 0.08f;
    public static final float b = 0.92f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f18058b = "SubripDecoder";
    public static final float c = 0.5f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f18060c = "(?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?";
    public static final String d = "\\{\\\\an[1-9]\\}";
    public static final String e = "{\\an1}";
    public static final String f = "{\\an2}";
    public static final String g = "{\\an3}";
    public static final String h = "{\\an4}";
    public static final String i = "{\\an5}";
    public static final String j = "{\\an6}";
    public static final String k = "{\\an7}";
    public static final String l = "{\\an8}";
    public static final String m = "{\\an9}";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f18061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String> f18062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f18057a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Pattern f18059b = Pattern.compile("\\{\\\\.*?\\}");

    public lu8() {
        super(f18058b);
        this.f18061a = new StringBuilder();
        this.f18062a = new ArrayList<>();
    }

    public static float n(int i2) {
        if (i2 == 0) {
            return 0.08f;
        }
        if (i2 == 1) {
            return 0.5f;
        }
        if (i2 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    public static long o(Matcher matcher, int i2) {
        String strGroup = matcher.group(i2 + 1);
        long j2 = (strGroup != null ? Long.parseLong(strGroup) * 60 * 60 * 1000 : 0L) + (Long.parseLong((String) sb0.g(matcher.group(i2 + 2))) * 60 * 1000) + (Long.parseLong((String) sb0.g(matcher.group(i2 + 3))) * 1000);
        String strGroup2 = matcher.group(i2 + 4);
        if (strGroup2 != null) {
            j2 += Long.parseLong(strGroup2);
        }
        return j2 * 1000;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i2, boolean z) {
        String str;
        ArrayList arrayList = new ArrayList();
        q25 q25Var = new q25();
        om6 om6Var = new om6(bArr, i2);
        while (true) {
            String strQ = om6Var.q();
            int i3 = 0;
            if (strQ == null) {
                break;
            }
            if (strQ.length() != 0) {
                try {
                    Integer.parseInt(strQ);
                    String strQ2 = om6Var.q();
                    if (strQ2 == null) {
                        Log.n(f18058b, "Unexpected end");
                        break;
                    }
                    Matcher matcher = f18057a.matcher(strQ2);
                    if (matcher.matches()) {
                        q25Var.a(o(matcher, 1));
                        q25Var.a(o(matcher, 6));
                        this.f18061a.setLength(0);
                        this.f18062a.clear();
                        for (String strQ3 = om6Var.q(); !TextUtils.isEmpty(strQ3); strQ3 = om6Var.q()) {
                            if (this.f18061a.length() > 0) {
                                this.f18061a.append("<br>");
                            }
                            this.f18061a.append(p(strQ3, this.f18062a));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.f18061a.toString());
                        while (true) {
                            if (i3 >= this.f18062a.size()) {
                                str = null;
                                break;
                            }
                            str = this.f18062a.get(i3);
                            if (str.matches(d)) {
                                break;
                            }
                            i3++;
                        }
                        arrayList.add(m(spannedFromHtml, str));
                        arrayList.add(Cue.f4518a);
                    } else {
                        Log.n(f18058b, "Skipping invalid timing: " + strQ2);
                    }
                } catch (NumberFormatException unused) {
                    Log.n(f18058b, "Skipping invalid index: " + strQ);
                }
            }
        }
        return new mu8((Cue[]) arrayList.toArray(new Cue[0]), q25Var.d());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x007b  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    public final Cue m(Spanned spanned, @Nullable String str) {
        byte b2;
        byte b3;
        Cue.b bVarA = new Cue.b().A(spanned);
        if (str == null) {
            return bVarA.a();
        }
        switch (str) {
            case "{\an1}":
                b2 = 0;
                break;
            case "{\an2}":
                b2 = 6;
                break;
            case "{\an3}":
                b2 = 3;
                break;
            case "{\an4}":
                b2 = 1;
                break;
            case "{\an5}":
                b2 = 7;
                break;
            case "{\an6}":
                b2 = 4;
                break;
            case "{\an7}":
                b2 = 2;
                break;
            case "{\an8}":
                b2 = 8;
                break;
            case "{\an9}":
                b2 = 5;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 == 0 || b2 == 1 || b2 == 2) {
            bVarA.x(0);
        } else if (b2 == 3 || b2 == 4 || b2 == 5) {
            bVarA.x(2);
        } else {
            bVarA.x(1);
        }
        switch (str) {
            case "{\an1}":
                b3 = 0;
                break;
            case "{\an2}":
                b3 = 1;
                break;
            case "{\an3}":
                b3 = 2;
                break;
            case "{\an4}":
                b3 = 6;
                break;
            case "{\an5}":
                b3 = 7;
                break;
            case "{\an6}":
                b3 = 8;
                break;
            case "{\an7}":
                b3 = 3;
                break;
            case "{\an8}":
                b3 = 4;
                break;
            case "{\an9}":
                b3 = 5;
                break;
            default:
                b3 = -1;
                break;
        }
        if (b3 == 0 || b3 == 1 || b3 == 2) {
            bVarA.u(2);
        } else if (b3 == 3 || b3 == 4 || b3 == 5) {
            bVarA.u(0);
        } else {
            bVarA.u(1);
        }
        return bVarA.w(n(bVarA.i())).t(n(bVarA.f()), 0).a();
    }

    public final String p(String str, ArrayList<String> arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = f18059b.matcher(strTrim);
        int i2 = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i2;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i2 += length;
        }
        return sb.toString();
    }
}
