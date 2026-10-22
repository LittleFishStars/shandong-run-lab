package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.bp8;
import com.zj.adlib.cp8;
import com.zj.adlib.gj9;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends SimpleSubtitleDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f31022a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public static final String b = "SsaDecoder";
    public static final float c = 0.05f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f4617c = "Format:";
    public static final String d = "Style:";
    public static final String e = "Dialogue:";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f4618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final bp8 f4619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, SsaStyle> f4620a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f4621b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f4622c;

    public a() {
        this(null);
    }

    public static int m(long j, List<Long> list, List<List<Cue>> list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (list.get(size).longValue() == j) {
                return size;
            }
            if (list.get(size).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList(list2.get(i - 1)));
        return i;
    }

    public static float n(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static Cue o(String str, @Nullable SsaStyle ssaStyle, SsaStyle.b bVar, float f, float f2) {
        SpannableString spannableString = new SpannableString(str);
        Cue.b bVarA = new Cue.b().A(spannableString);
        if (ssaStyle != null) {
            if (ssaStyle.f4605a != null) {
                spannableString.setSpan(new ForegroundColorSpan(ssaStyle.f4605a.intValue()), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f4608b == 3 && ssaStyle.f4609b != null) {
                spannableString.setSpan(new BackgroundColorSpan(ssaStyle.f4609b.intValue()), 0, spannableString.length(), 33);
            }
            float f3 = ssaStyle.f31019a;
            if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                bVarA.C(f3 / f2, 1);
            }
            boolean z = ssaStyle.f4607a;
            if (z && ssaStyle.f4610b) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (ssaStyle.f4610b) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f4611c) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f4612d) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i = bVar.f4615a;
        if (i == -1) {
            i = ssaStyle != null ? ssaStyle.f4604a : -1;
        }
        bVarA.B(x(i)).x(w(i)).u(v(i));
        PointF pointF = bVar.f4616a;
        if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
            bVarA.w(n(bVarA.i()));
            bVarA.t(n(bVarA.f()), 0);
        } else {
            bVarA.w(pointF.x / f);
            bVarA.t(bVar.f4616a.y / f2, 0);
        }
        return bVarA.a();
    }

    public static Map<String, SsaStyle> t(om6 om6Var) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SsaStyle.a aVarA = null;
        while (true) {
            String strQ = om6Var.q();
            if (strQ == null || (om6Var.a() != 0 && om6Var.h() == 91)) {
                break;
            }
            if (strQ.startsWith(f4617c)) {
                aVarA = SsaStyle.a.a(strQ);
            } else if (strQ.startsWith(d)) {
                if (aVarA == null) {
                    Log.n(b, "Skipping 'Style:' line before 'Format:' line: " + strQ);
                } else {
                    SsaStyle ssaStyleB = SsaStyle.b(strQ, aVarA);
                    if (ssaStyleB != null) {
                        linkedHashMap.put(ssaStyleB.f4606a, ssaStyleB);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static long u(String str) {
        Matcher matcher = f31022a.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) gj9.k(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) gj9.k(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) gj9.k(matcher.group(3))) * 1000000) + (Long.parseLong((String) gj9.k(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    public static int v(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                Log.n(b, "Unknown alignment: " + i);
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
        }
    }

    public static int w(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                Log.n(b, "Unknown alignment: " + i);
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    @Nullable
    public static Layout.Alignment x(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                Log.n(b, "Unknown alignment: " + i);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        om6 om6Var = new om6(bArr, i);
        if (!this.f4622c) {
            r(om6Var);
        }
        q(om6Var, arrayList, arrayList2);
        return new cp8(arrayList, arrayList2);
    }

    public final void p(String str, bp8 bp8Var, List<List<Cue>> list, List<Long> list2) {
        int i;
        sb0.a(str.startsWith(e));
        String[] strArrSplit = str.substring(9).split(",", bp8Var.e);
        if (strArrSplit.length != bp8Var.e) {
            Log.n(b, "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long jU = u(strArrSplit[bp8Var.f40806a]);
        if (jU == -9223372036854775807L) {
            Log.n(b, "Skipping invalid timing: " + str);
            return;
        }
        long jU2 = u(strArrSplit[bp8Var.b]);
        if (jU2 == -9223372036854775807L) {
            Log.n(b, "Skipping invalid timing: " + str);
            return;
        }
        Map<String, SsaStyle> map = this.f4620a;
        SsaStyle ssaStyle = (map == null || (i = bp8Var.c) == -1) ? null : map.get(strArrSplit[i].trim());
        String str2 = strArrSplit[bp8Var.d];
        Cue cueO = o(SsaStyle.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), ssaStyle, SsaStyle.b.b(str2), this.f4618a, this.f4621b);
        int iM = m(jU2, list2, list);
        for (int iM2 = m(jU, list2, list); iM2 < iM; iM2++) {
            list.get(iM2).add(cueO);
        }
    }

    public final void q(om6 om6Var, List<List<Cue>> list, List<Long> list2) {
        bp8 bp8VarA = this.f4622c ? this.f4619a : null;
        while (true) {
            String strQ = om6Var.q();
            if (strQ == null) {
                return;
            }
            if (strQ.startsWith(f4617c)) {
                bp8VarA = bp8.a(strQ);
            } else if (strQ.startsWith(e)) {
                if (bp8VarA == null) {
                    Log.n(b, "Skipping dialogue line before complete format: " + strQ);
                } else {
                    p(strQ, bp8VarA, list, list2);
                }
            }
        }
    }

    public final void r(om6 om6Var) {
        while (true) {
            String strQ = om6Var.q();
            if (strQ == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strQ)) {
                s(om6Var);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strQ)) {
                this.f4620a = t(om6Var);
            } else if ("[V4 Styles]".equalsIgnoreCase(strQ)) {
                Log.h(b, "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strQ)) {
                return;
            }
        }
    }

    public final void s(om6 om6Var) {
        while (true) {
            String strQ = om6Var.q();
            if (strQ == null) {
                return;
            }
            if (om6Var.a() != 0 && om6Var.h() == 91) {
                return;
            }
            String[] strArrSplit = strQ.split(u15.f19942b);
            if (strArrSplit.length == 2) {
                String strG = com.google.common.base.a.g(strArrSplit[0].trim());
                strG.hashCode();
                if (strG.equals("playresx")) {
                    this.f4618a = Float.parseFloat(strArrSplit[1].trim());
                } else if (strG.equals("playresy")) {
                    try {
                        this.f4621b = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    public a(@Nullable List<byte[]> list) {
        super(b);
        this.f4618a = -3.4028235E38f;
        this.f4621b = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f4622c = false;
            this.f4619a = null;
            return;
        }
        this.f4622c = true;
        String strI = gj9.I(list.get(0));
        sb0.a(strI.startsWith(f4617c));
        this.f4619a = (bp8) sb0.g(bp8.a(strI));
        r(new om6(list.get(1)));
    }
}
