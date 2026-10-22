package com.google.android.inner_exoplayer2.extractor.mp4;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.inner_exoplayer2.metadata.Metadata;
import com.google.android.inner_exoplayer2.metadata.id3.ApicFrame;
import com.google.android.inner_exoplayer2.metadata.id3.CommentFrame;
import com.google.android.inner_exoplayer2.metadata.id3.Id3Frame;
import com.google.android.inner_exoplayer2.metadata.id3.InternalFrame;
import com.google.android.inner_exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.inner_exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.inner_exoplayer2.util.Log;
import com.google.android.inner_exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.net.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class MetadataUtil {
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int SHORT_TYPE_ALBUM = 6384738;
    private static final int SHORT_TYPE_ARTIST = 4280916;
    private static final int SHORT_TYPE_COMMENT = 6516084;
    private static final int SHORT_TYPE_COMPOSER_1 = 6516589;
    private static final int SHORT_TYPE_COMPOSER_2 = 7828084;
    private static final int SHORT_TYPE_ENCODER = 7630703;
    private static final int SHORT_TYPE_GENRE = 6776174;
    private static final int SHORT_TYPE_LYRICS = 7108978;
    private static final int SHORT_TYPE_NAME_1 = 7233901;
    private static final int SHORT_TYPE_NAME_2 = 7631467;
    private static final int SHORT_TYPE_YEAR = 6578553;

    @VisibleForTesting
    static final String[] STANDARD_GENRES = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", b.I0, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    private static final String TAG = "MetadataUtil";
    private static final int TYPE_ALBUM_ARTIST = 1631670868;
    private static final int TYPE_COMPILATION = 1668311404;
    private static final int TYPE_COVER_ART = 1668249202;
    private static final int TYPE_DISK_NUMBER = 1684632427;
    private static final int TYPE_GAPLESS_ALBUM = 1885823344;
    private static final int TYPE_GENRE = 1735291493;
    private static final int TYPE_GROUPING = 6779504;
    private static final int TYPE_INTERNAL = 757935405;
    private static final int TYPE_RATING = 1920233063;
    private static final int TYPE_SORT_ALBUM = 1936679276;
    private static final int TYPE_SORT_ALBUM_ARTIST = 1936679265;
    private static final int TYPE_SORT_ARTIST = 1936679282;
    private static final int TYPE_SORT_COMPOSER = 1936679791;
    private static final int TYPE_SORT_TRACK_NAME = 1936682605;
    private static final int TYPE_TEMPO = 1953329263;
    private static final int TYPE_TOP_BYTE_COPYRIGHT = 169;
    private static final int TYPE_TOP_BYTE_REPLACEMENT = 253;
    private static final int TYPE_TRACK_NUMBER = 1953655662;
    private static final int TYPE_TV_SHOW = 1953919848;
    private static final int TYPE_TV_SORT_SHOW = 1936683886;

    private MetadataUtil() {
    }

    @Nullable
    private static CommentFrame parseCommentAttribute(int i, ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            String nullTerminatedString = parsableByteArray.readNullTerminatedString(i2 - 16);
            return new CommentFrame("und", nullTerminatedString, nullTerminatedString);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    @Nullable
    private static ApicFrame parseCoverArt(ParsableByteArray parsableByteArray) {
        String str;
        int i = parsableByteArray.readInt();
        if (parsableByteArray.readInt() != 1684108385) {
            Log.w("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int fullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if (fullAtomFlags == 13) {
            str = "image/jpeg";
        } else {
            str = fullAtomFlags == 14 ? "image/png" : null;
        }
        if (str == null) {
            Log.w("MetadataUtil", "Unrecognized cover art flags: " + fullAtomFlags);
            return null;
        }
        parsableByteArray.skipBytes(4);
        int i2 = i - 16;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new ApicFrame(str, null, 3, bArr);
    }

    @Nullable
    public static Metadata.Entry parseIlstElement(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition() + parsableByteArray.readInt();
        int i = parsableByteArray.readInt();
        int i2 = (i >> 24) & 255;
        try {
            if (i2 == 169 || i2 == 253) {
                int i3 = 16777215 & i;
                if (i3 == 6516084) {
                    CommentFrame commentAttribute = parseCommentAttribute(i, parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return commentAttribute;
                }
                if (i3 == 7233901 || i3 == 7631467) {
                    TextInformationFrame textAttribute = parseTextAttribute(i, "TIT2", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute;
                }
                if (i3 == 6516589 || i3 == 7828084) {
                    TextInformationFrame textAttribute2 = parseTextAttribute(i, "TCOM", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute2;
                }
                if (i3 == 6578553) {
                    TextInformationFrame textAttribute3 = parseTextAttribute(i, "TDRC", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute3;
                }
                if (i3 == 4280916) {
                    TextInformationFrame textAttribute4 = parseTextAttribute(i, "TPE1", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute4;
                }
                if (i3 == 7630703) {
                    TextInformationFrame textAttribute5 = parseTextAttribute(i, "TSSE", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute5;
                }
                if (i3 == 6384738) {
                    TextInformationFrame textAttribute6 = parseTextAttribute(i, "TALB", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute6;
                }
                if (i3 == 7108978) {
                    TextInformationFrame textAttribute7 = parseTextAttribute(i, "USLT", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute7;
                }
                if (i3 == 6776174) {
                    TextInformationFrame textAttribute8 = parseTextAttribute(i, "TCON", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute8;
                }
                if (i3 == 6779504) {
                    TextInformationFrame textAttribute9 = parseTextAttribute(i, "TIT1", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute9;
                }
            } else {
                if (i == 1735291493) {
                    TextInformationFrame standardGenreAttribute = parseStandardGenreAttribute(parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return standardGenreAttribute;
                }
                if (i == 1684632427) {
                    TextInformationFrame indexAndCountAttribute = parseIndexAndCountAttribute(i, "TPOS", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return indexAndCountAttribute;
                }
                if (i == 1953655662) {
                    TextInformationFrame indexAndCountAttribute2 = parseIndexAndCountAttribute(i, "TRCK", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return indexAndCountAttribute2;
                }
                if (i == 1953329263) {
                    Id3Frame uint8Attribute = parseUint8Attribute(i, "TBPM", parsableByteArray, true, false);
                    parsableByteArray.setPosition(position);
                    return uint8Attribute;
                }
                if (i == 1668311404) {
                    Id3Frame uint8Attribute2 = parseUint8Attribute(i, "TCMP", parsableByteArray, true, true);
                    parsableByteArray.setPosition(position);
                    return uint8Attribute2;
                }
                if (i == 1668249202) {
                    ApicFrame coverArt = parseCoverArt(parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return coverArt;
                }
                if (i == 1631670868) {
                    TextInformationFrame textAttribute10 = parseTextAttribute(i, "TPE2", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute10;
                }
                if (i == 1936682605) {
                    TextInformationFrame textAttribute11 = parseTextAttribute(i, "TSOT", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute11;
                }
                if (i == 1936679276) {
                    TextInformationFrame textAttribute12 = parseTextAttribute(i, "TSO2", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute12;
                }
                if (i == 1936679282) {
                    TextInformationFrame textAttribute13 = parseTextAttribute(i, "TSOA", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute13;
                }
                if (i == 1936679265) {
                    TextInformationFrame textAttribute14 = parseTextAttribute(i, "TSOP", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute14;
                }
                if (i == 1936679791) {
                    TextInformationFrame textAttribute15 = parseTextAttribute(i, "TSOC", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute15;
                }
                if (i == 1920233063) {
                    Id3Frame uint8Attribute3 = parseUint8Attribute(i, "ITUNESADVISORY", parsableByteArray, false, false);
                    parsableByteArray.setPosition(position);
                    return uint8Attribute3;
                }
                if (i == 1885823344) {
                    Id3Frame uint8Attribute4 = parseUint8Attribute(i, "ITUNESGAPLESS", parsableByteArray, false, true);
                    parsableByteArray.setPosition(position);
                    return uint8Attribute4;
                }
                if (i == 1936683886) {
                    TextInformationFrame textAttribute16 = parseTextAttribute(i, "TVSHOWSORT", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute16;
                }
                if (i == 1953919848) {
                    TextInformationFrame textAttribute17 = parseTextAttribute(i, "TVSHOW", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute17;
                }
                if (i == 757935405) {
                    Id3Frame internalAttribute = parseInternalAttribute(parsableByteArray, position);
                    parsableByteArray.setPosition(position);
                    return internalAttribute;
                }
            }
            Log.d("MetadataUtil", "Skipped unknown metadata entry: " + Atom.getAtomTypeString(i));
            parsableByteArray.setPosition(position);
            return null;
        } catch (Throwable th) {
            parsableByteArray.setPosition(position);
            throw th;
        }
    }

    @Nullable
    private static TextInformationFrame parseIndexAndCountAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385 && i2 >= 22) {
            parsableByteArray.skipBytes(10);
            int unsignedShort = parsableByteArray.readUnsignedShort();
            if (unsignedShort > 0) {
                String str2 = "" + unsignedShort;
                int unsignedShort2 = parsableByteArray.readUnsignedShort();
                if (unsignedShort2 > 0) {
                    str2 = str2 + WVNativeCallbackUtil.SEPERATER + unsignedShort2;
                }
                return new TextInformationFrame(str, (String) null, ImmutableList.of(str2));
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    @Nullable
    private static Id3Frame parseInternalAttribute(ParsableByteArray parsableByteArray, int i) {
        String nullTerminatedString = null;
        String nullTerminatedString2 = null;
        int i2 = -1;
        int i3 = -1;
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i4 = parsableByteArray.readInt();
            int i5 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            if (i5 == 1835360622) {
                nullTerminatedString = parsableByteArray.readNullTerminatedString(i4 - 12);
            } else if (i5 == 1851878757) {
                nullTerminatedString2 = parsableByteArray.readNullTerminatedString(i4 - 12);
            } else {
                if (i5 == 1684108385) {
                    i2 = position;
                    i3 = i4;
                }
                parsableByteArray.skipBytes(i4 - 12);
            }
        }
        if (nullTerminatedString == null || nullTerminatedString2 == null || i2 == -1) {
            return null;
        }
        parsableByteArray.setPosition(i2);
        parsableByteArray.skipBytes(16);
        return new InternalFrame(nullTerminatedString, nullTerminatedString2, parsableByteArray.readNullTerminatedString(i3 - 16));
    }

    @Nullable
    public static MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(ParsableByteArray parsableByteArray, int i, String str) {
        while (true) {
            int position = parsableByteArray.getPosition();
            if (position >= i) {
                return null;
            }
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1684108385) {
                int i3 = parsableByteArray.readInt();
                int i4 = parsableByteArray.readInt();
                int i5 = i2 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                return new MdtaMetadataEntry(str, bArr, i4, i3);
            }
            parsableByteArray.setPosition(position + i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    @Nullable
    private static TextInformationFrame parseStandardGenreAttribute(ParsableByteArray parsableByteArray) {
        String str;
        int uint8AttributeValue = parseUint8AttributeValue(parsableByteArray);
        if (uint8AttributeValue > 0) {
            String[] strArr = STANDARD_GENRES;
            if (uint8AttributeValue <= strArr.length) {
                str = strArr[uint8AttributeValue - 1];
            } else {
                str = null;
            }
        } else {
            str = null;
        }
        if (str != null) {
            return new TextInformationFrame("TCON", (String) null, ImmutableList.of(str));
        }
        Log.w("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    @Nullable
    private static TextInformationFrame parseTextAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return new TextInformationFrame(str, (String) null, ImmutableList.of(parsableByteArray.readNullTerminatedString(i2 - 16)));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    @Nullable
    private static Id3Frame parseUint8Attribute(int i, String str, ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        int uint8AttributeValue = parseUint8AttributeValue(parsableByteArray);
        if (z2) {
            uint8AttributeValue = Math.min(1, uint8AttributeValue);
        }
        if (uint8AttributeValue >= 0) {
            return z ? new TextInformationFrame(str, (String) null, ImmutableList.of(Integer.toString(uint8AttributeValue))) : new CommentFrame("und", str, Integer.toString(uint8AttributeValue));
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    private static int parseUint8AttributeValue(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return parsableByteArray.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void setFormatGaplessInfo(int i, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i == 1 && gaplessInfoHolder.hasGaplessInfo()) {
            builder.setEncoderDelay(gaplessInfoHolder.encoderDelay).setEncoderPadding(gaplessInfoHolder.encoderPadding);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    public static void setFormatMetadata(int i, @Nullable Metadata metadata, @Nullable Metadata metadata2, Format.Builder builder, Metadata... metadataArr) {
        Metadata metadata3 = new Metadata(new Metadata.Entry[0]);
        if (i == 1) {
            if (metadata == null) {
                metadata = metadata3;
                break;
            }
        } else {
            if (i != 2 || metadata2 == null) {
                metadata = metadata3;
                break;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= metadata2.length()) {
                    metadata = metadata3;
                    break;
                }
                Metadata.Entry entry = metadata2.get(i2);
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if ("com.android.capture.fps".equals(mdtaMetadataEntry.key)) {
                        metadata = new Metadata(mdtaMetadataEntry);
                        break;
                    }
                }
                i2++;
            }
        }
        for (Metadata metadata4 : metadataArr) {
            metadata = metadata.copyWithAppendedEntriesFrom(metadata4);
        }
        if (metadata.length() > 0) {
            builder.setMetadata(metadata);
        }
    }
}
