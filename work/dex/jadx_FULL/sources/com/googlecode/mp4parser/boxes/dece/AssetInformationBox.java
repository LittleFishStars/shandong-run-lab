package com.googlecode.mp4parser.boxes.dece;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.runtime.reflect.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class AssetInformationBox extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "ainf";
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    String apid;
    String profileVersion;

    public static class Entry {
        public String assetId;
        public String namespace;
        public String profileLevelIdc;

        public Entry(String str, String str2, String str3) {
            this.namespace = str;
            this.profileLevelIdc = str2;
            this.assetId = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.assetId.equals(entry.assetId) && this.namespace.equals(entry.namespace) && this.profileLevelIdc.equals(entry.profileLevelIdc);
        }

        public int getSize() {
            return Utf8.utf8StringLengthInBytes(this.namespace) + 3 + Utf8.utf8StringLengthInBytes(this.profileLevelIdc) + Utf8.utf8StringLengthInBytes(this.assetId);
        }

        public int hashCode() {
            return (((this.namespace.hashCode() * 31) + this.profileLevelIdc.hashCode()) * 31) + this.assetId.hashCode();
        }

        public String toString() {
            return "{namespace='" + this.namespace + "', profileLevelIdc='" + this.profileLevelIdc + "', assetId='" + this.assetId + "'}";
        }
    }

    static {
        ajc$preClinit();
    }

    public AssetInformationBox() {
        super(TYPE);
        this.apid = "";
        this.profileVersion = "0000";
    }

    private static /* synthetic */ void ajc$preClinit() {
        d dVar = new d("AssetInformationBox.java", AssetInformationBox.class);
        ajc$tjp_0 = dVar.H("method-execution", dVar.E("1", "getApid", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), 131);
        ajc$tjp_1 = dVar.H("method-execution", dVar.E("1", "setApid", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "apid", "", "void"), 135);
        ajc$tjp_2 = dVar.H("method-execution", dVar.E("1", "getProfileVersion", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), 139);
        ajc$tjp_3 = dVar.H("method-execution", dVar.E("1", "setProfileVersion", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "profileVersion", "", "void"), 143);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.profileVersion = IsoTypeReader.readString(byteBuffer, 4);
        this.apid = IsoTypeReader.readString(byteBuffer);
    }

    public String getApid() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_0, this, this));
        return this.apid;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() != 0) {
            throw new RuntimeException("Unknown ainf version " + getVersion());
        }
        byteBuffer.put(Utf8.convert(this.profileVersion), 0, 4);
        byteBuffer.put(Utf8.convert(this.apid));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.apid) + 9;
    }

    public String getProfileVersion() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_2, this, this));
        return this.profileVersion;
    }

    @DoNotParseDetail
    public boolean isHidden() {
        return (getFlags() & 1) == 1;
    }

    public void setApid(String str) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_1, this, this, str));
        this.apid = str;
    }

    @DoNotParseDetail
    public void setHidden(boolean z) {
        int flags = getFlags();
        if (isHidden() ^ z) {
            if (z) {
                setFlags(flags | 1);
            } else {
                setFlags(16777214 & flags);
            }
        }
    }

    public void setProfileVersion(String str) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_3, this, this, str));
        this.profileVersion = str;
    }
}
