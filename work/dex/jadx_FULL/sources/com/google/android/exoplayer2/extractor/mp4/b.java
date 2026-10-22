package com.google.android.exoplayer2.extractor.mp4;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.cs3;
import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {
    public static final int A = 1936683886;
    public static final int B = 1953919848;
    public static final int C = 757935405;
    public static final int D = 3;
    public static final int E = 169;
    public static final int F = 253;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30687a = 7233901;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f3019a = "MetadataUtil";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final String[] f3020a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", com.google.common.net.b.I0, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final int b = 7631467;
    public static final int c = 6516084;
    public static final int d = 6578553;
    public static final int e = 4280916;
    public static final int f = 7630703;
    public static final int g = 6384738;
    public static final int h = 6516589;
    public static final int i = 7828084;
    public static final int j = 7108978;
    public static final int k = 6776174;
    public static final int l = 1668249202;
    public static final int m = 1735291493;
    public static final int n = 6779504;
    public static final int o = 1684632427;
    public static final int p = 1953655662;
    public static final int q = 1953329263;
    public static final int r = 1668311404;
    public static final int s = 1631670868;
    public static final int t = 1936682605;
    public static final int u = 1936679276;
    public static final int v = 1936679282;
    public static final int w = 1936679265;
    public static final int x = 1936679791;
    public static final int y = 1920233063;
    public static final int z = 1885823344;

    @Nullable
    public static CommentFrame a(int i2, om6 om6Var) {
        int iO = om6Var.o();
        if (om6Var.o() == 1684108385) {
            om6Var.T(8);
            String strB = om6Var.B(iO - 16);
            return new CommentFrame("und", strB, strB);
        }
        Log.n(f3019a, "Failed to parse comment attribute: " + Atom.a(i2));
        return null;
    }

    @Nullable
    public static ApicFrame b(om6 om6Var) {
        String str;
        int iO = om6Var.o();
        if (om6Var.o() != 1684108385) {
            Log.n(f3019a, "Failed to parse cover art attribute");
            return null;
        }
        int iB = Atom.b(om6Var.o());
        if (iB == 13) {
            str = "image/jpeg";
        } else {
            str = iB == 14 ? "image/png" : null;
        }
        if (str == null) {
            Log.n(f3019a, "Unrecognized cover art flags: " + iB);
            return null;
        }
        om6Var.T(4);
        int i2 = iO - 16;
        byte[] bArr = new byte[i2];
        om6Var.k(bArr, 0, i2);
        return new ApicFrame(str, null, 3, bArr);
    }

    @Nullable
    public static Metadata.Entry c(om6 om6Var) {
        int iE = om6Var.e() + om6Var.o();
        int iO = om6Var.o();
        int i2 = (iO >> 24) & 255;
        try {
            if (i2 == 169 || i2 == 253) {
                int i3 = 16777215 & iO;
                if (i3 == 6516084) {
                    CommentFrame commentFrameA = a(iO, om6Var);
                    om6Var.S(iE);
                    return commentFrameA;
                }
                if (i3 == 7233901 || i3 == 7631467) {
                    TextInformationFrame textInformationFrameH = h(iO, "TIT2", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH;
                }
                if (i3 == 6516589 || i3 == 7828084) {
                    TextInformationFrame textInformationFrameH2 = h(iO, "TCOM", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH2;
                }
                if (i3 == 6578553) {
                    TextInformationFrame textInformationFrameH3 = h(iO, "TDRC", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH3;
                }
                if (i3 == 4280916) {
                    TextInformationFrame textInformationFrameH4 = h(iO, "TPE1", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH4;
                }
                if (i3 == 7630703) {
                    TextInformationFrame textInformationFrameH5 = h(iO, "TSSE", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH5;
                }
                if (i3 == 6384738) {
                    TextInformationFrame textInformationFrameH6 = h(iO, "TALB", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH6;
                }
                if (i3 == 7108978) {
                    TextInformationFrame textInformationFrameH7 = h(iO, "USLT", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH7;
                }
                if (i3 == 6776174) {
                    TextInformationFrame textInformationFrameH8 = h(iO, "TCON", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH8;
                }
                if (i3 == 6779504) {
                    TextInformationFrame textInformationFrameH9 = h(iO, "TIT1", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH9;
                }
            } else {
                if (iO == 1735291493) {
                    TextInformationFrame textInformationFrameG = g(om6Var);
                    om6Var.S(iE);
                    return textInformationFrameG;
                }
                if (iO == 1684632427) {
                    TextInformationFrame textInformationFrameD = d(iO, "TPOS", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameD;
                }
                if (iO == 1953655662) {
                    TextInformationFrame textInformationFrameD2 = d(iO, "TRCK", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameD2;
                }
                if (iO == 1953329263) {
                    Id3Frame id3FrameI = i(iO, "TBPM", om6Var, true, false);
                    om6Var.S(iE);
                    return id3FrameI;
                }
                if (iO == 1668311404) {
                    Id3Frame id3FrameI2 = i(iO, "TCMP", om6Var, true, true);
                    om6Var.S(iE);
                    return id3FrameI2;
                }
                if (iO == 1668249202) {
                    ApicFrame apicFrameB = b(om6Var);
                    om6Var.S(iE);
                    return apicFrameB;
                }
                if (iO == 1631670868) {
                    TextInformationFrame textInformationFrameH10 = h(iO, "TPE2", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH10;
                }
                if (iO == 1936682605) {
                    TextInformationFrame textInformationFrameH11 = h(iO, "TSOT", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH11;
                }
                if (iO == 1936679276) {
                    TextInformationFrame textInformationFrameH12 = h(iO, "TSO2", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH12;
                }
                if (iO == 1936679282) {
                    TextInformationFrame textInformationFrameH13 = h(iO, "TSOA", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH13;
                }
                if (iO == 1936679265) {
                    TextInformationFrame textInformationFrameH14 = h(iO, "TSOP", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH14;
                }
                if (iO == 1936679791) {
                    TextInformationFrame textInformationFrameH15 = h(iO, "TSOC", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH15;
                }
                if (iO == 1920233063) {
                    Id3Frame id3FrameI3 = i(iO, "ITUNESADVISORY", om6Var, false, false);
                    om6Var.S(iE);
                    return id3FrameI3;
                }
                if (iO == 1885823344) {
                    Id3Frame id3FrameI4 = i(iO, "ITUNESGAPLESS", om6Var, false, true);
                    om6Var.S(iE);
                    return id3FrameI4;
                }
                if (iO == 1936683886) {
                    TextInformationFrame textInformationFrameH16 = h(iO, "TVSHOWSORT", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH16;
                }
                if (iO == 1953919848) {
                    TextInformationFrame textInformationFrameH17 = h(iO, "TVSHOW", om6Var);
                    om6Var.S(iE);
                    return textInformationFrameH17;
                }
                if (iO == 757935405) {
                    Id3Frame id3FrameE = e(om6Var, iE);
                    om6Var.S(iE);
                    return id3FrameE;
                }
            }
            Log.b(f3019a, "Skipped unknown metadata entry: " + Atom.a(iO));
            om6Var.S(iE);
            return null;
        } catch (Throwable th) {
            om6Var.S(iE);
            throw th;
        }
    }

    @Nullable
    public static TextInformationFrame d(int i2, String str, om6 om6Var) {
        int iO = om6Var.o();
        if (om6Var.o() == 1684108385 && iO >= 22) {
            om6Var.T(10);
            int iM = om6Var.M();
            if (iM > 0) {
                String str2 = "" + iM;
                int iM2 = om6Var.M();
                if (iM2 > 0) {
                    str2 = str2 + WVNativeCallbackUtil.SEPERATER + iM2;
                }
                return new TextInformationFrame(str, null, str2);
            }
        }
        Log.n(f3019a, "Failed to parse index/count attribute: " + Atom.a(i2));
        return null;
    }

    @Nullable
    public static Id3Frame e(om6 om6Var, int i2) {
        String strB = null;
        String strB2 = null;
        int i3 = -1;
        int i4 = -1;
        while (om6Var.e() < i2) {
            int iE = om6Var.e();
            int iO = om6Var.o();
            int iO2 = om6Var.o();
            om6Var.T(4);
            if (iO2 == 1835360622) {
                strB = om6Var.B(iO - 12);
            } else if (iO2 == 1851878757) {
                strB2 = om6Var.B(iO - 12);
            } else {
                if (iO2 == 1684108385) {
                    i3 = iE;
                    i4 = iO;
                }
                om6Var.T(iO - 12);
            }
        }
        if (strB == null || strB2 == null || i3 == -1) {
            return null;
        }
        om6Var.S(i3);
        om6Var.T(16);
        return new InternalFrame(strB, strB2, om6Var.B(i4 - 16));
    }

    @Nullable
    public static MdtaMetadataEntry f(om6 om6Var, int i2, String str) {
        while (true) {
            int iE = om6Var.e();
            if (iE >= i2) {
                return null;
            }
            int iO = om6Var.o();
            if (om6Var.o() == 1684108385) {
                int iO2 = om6Var.o();
                int iO3 = om6Var.o();
                int i3 = iO - 16;
                byte[] bArr = new byte[i3];
                om6Var.k(bArr, 0, i3);
                return new MdtaMetadataEntry(str, bArr, iO3, iO2);
            }
            om6Var.S(iE + iO);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    @Nullable
    public static TextInformationFrame g(om6 om6Var) {
        String str;
        int iJ = j(om6Var);
        if (iJ > 0) {
            String[] strArr = f3020a;
            if (iJ <= strArr.length) {
                str = strArr[iJ - 1];
            } else {
                str = null;
            }
        } else {
            str = null;
        }
        if (str != null) {
            return new TextInformationFrame("TCON", null, str);
        }
        Log.n(f3019a, "Failed to parse standard genre code");
        return null;
    }

    @Nullable
    public static TextInformationFrame h(int i2, String str, om6 om6Var) {
        int iO = om6Var.o();
        if (om6Var.o() == 1684108385) {
            om6Var.T(8);
            return new TextInformationFrame(str, null, om6Var.B(iO - 16));
        }
        Log.n(f3019a, "Failed to parse text attribute: " + Atom.a(i2));
        return null;
    }

    @Nullable
    public static Id3Frame i(int i2, String str, om6 om6Var, boolean z2, boolean z3) {
        int iJ = j(om6Var);
        if (z3) {
            iJ = Math.min(1, iJ);
        }
        if (iJ >= 0) {
            return z2 ? new TextInformationFrame(str, null, Integer.toString(iJ)) : new CommentFrame("und", str, Integer.toString(iJ));
        }
        Log.n(f3019a, "Failed to parse uint8 attribute: " + Atom.a(i2));
        return null;
    }

    public static int j(om6 om6Var) {
        om6Var.T(4);
        if (om6Var.o() == 1684108385) {
            om6Var.T(8);
            return om6Var.G();
        }
        Log.n(f3019a, "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i2, cs3 cs3Var, d.b bVar) {
        if (i2 == 1 && cs3Var.a()) {
            bVar.N(cs3Var.f15885a).O(cs3Var.f15886b);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    public static void l(int i2, @Nullable Metadata metadata, @Nullable Metadata metadata2, d.b bVar, Metadata... metadataArr) {
        Metadata metadata3 = new Metadata(new Metadata.Entry[0]);
        if (i2 == 1) {
            if (metadata == null) {
                metadata = metadata3;
                break;
            }
        } else {
            if (i2 != 2 || metadata2 == null) {
                metadata = metadata3;
                break;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= metadata2.length()) {
                    metadata = metadata3;
                    break;
                }
                Metadata.Entry entry = metadata2.get(i3);
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if ("com.android.capture.fps".equals(mdtaMetadataEntry.key)) {
                        metadata = new Metadata(mdtaMetadataEntry);
                        break;
                    }
                }
                i3++;
            }
        }
        for (Metadata metadata4 : metadataArr) {
            metadata = metadata.copyWithAppendedEntriesFrom(metadata4);
        }
        if (metadata.length() > 0) {
            bVar.X(metadata);
        }
    }
}
