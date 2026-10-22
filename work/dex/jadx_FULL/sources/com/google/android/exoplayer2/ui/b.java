package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class b implements TrackNameProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f31084a;

    public b(Resources resources) {
        this.f31084a = (Resources) sb0.g(resources);
    }

    public static int i(com.google.android.exoplayer2.d dVar) {
        int iL = bp5.l(dVar.k);
        if (iL != -1) {
            return iL;
        }
        if (bp5.o(dVar.i) != null) {
            return 2;
        }
        if (bp5.c(dVar.i) != null) {
            return 1;
        }
        if (dVar.Q == -1 && dVar.R == -1) {
            return (dVar.U == -1 && dVar.V == -1) ? -1 : 1;
        }
        return 2;
    }

    @Override // com.google.android.exoplayer2.ui.TrackNameProvider
    public String a(com.google.android.exoplayer2.d dVar) {
        String strJ;
        int i = i(dVar);
        if (i == 2) {
            strJ = j(h(dVar), g(dVar), c(dVar));
        } else {
            strJ = i == 1 ? j(e(dVar), b(dVar), c(dVar)) : e(dVar);
        }
        return strJ.length() == 0 ? this.f31084a.getString(R.string.exo_track_unknown) : strJ;
    }

    public final String b(com.google.android.exoplayer2.d dVar) {
        int i = dVar.U;
        if (i == -1 || i < 1) {
            return "";
        }
        if (i == 1) {
            return this.f31084a.getString(R.string.exo_track_mono);
        }
        if (i == 2) {
            return this.f31084a.getString(R.string.exo_track_stereo);
        }
        if (i == 6 || i == 7) {
            return this.f31084a.getString(R.string.exo_track_surround_5_point_1);
        }
        return i != 8 ? this.f31084a.getString(R.string.exo_track_surround) : this.f31084a.getString(R.string.exo_track_surround_7_point_1);
    }

    public final String c(com.google.android.exoplayer2.d dVar) {
        int i = dVar.O;
        return i == -1 ? "" : this.f31084a.getString(R.string.exo_track_bitrate, Float.valueOf(i / 1000000.0f));
    }

    public final String d(com.google.android.exoplayer2.d dVar) {
        return TextUtils.isEmpty(dVar.g) ? "" : dVar.g;
    }

    public final String e(com.google.android.exoplayer2.d dVar) {
        String strJ = j(f(dVar), h(dVar));
        return TextUtils.isEmpty(strJ) ? d(dVar) : strJ;
    }

    public final String f(com.google.android.exoplayer2.d dVar) {
        String str = dVar.h;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        Locale localeForLanguageTag = gj9.f41922a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale localeA0 = gj9.a0();
        String displayName = localeForLanguageTag.getDisplayName(localeA0);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int iOffsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, iOffsetByCodePoints).toUpperCase(localeA0) + displayName.substring(iOffsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    public final String g(com.google.android.exoplayer2.d dVar) {
        int i = dVar.Q;
        int i2 = dVar.R;
        return (i == -1 || i2 == -1) ? "" : this.f31084a.getString(R.string.exo_track_resolution, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final String h(com.google.android.exoplayer2.d dVar) {
        String string = (dVar.L & 2) != 0 ? this.f31084a.getString(R.string.exo_track_role_alternate) : "";
        if ((dVar.L & 4) != 0) {
            string = j(string, this.f31084a.getString(R.string.exo_track_role_supplementary));
        }
        if ((dVar.L & 8) != 0) {
            string = j(string, this.f31084a.getString(R.string.exo_track_role_commentary));
        }
        return (dVar.L & 1088) != 0 ? j(string, this.f31084a.getString(R.string.exo_track_role_closed_captions)) : string;
    }

    public final String j(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : this.f31084a.getString(R.string.exo_item_list, string, str);
            }
        }
        return string;
    }
}
