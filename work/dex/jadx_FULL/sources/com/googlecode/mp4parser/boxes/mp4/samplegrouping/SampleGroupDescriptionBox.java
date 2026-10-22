package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.common.math.c;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import com.mp4parser.iso14496.part15.StepwiseTemporalLayerEntry;
import com.mp4parser.iso14496.part15.SyncSampleEntry;
import com.mp4parser.iso14496.part15.TemporalLayerSampleGroup;
import com.mp4parser.iso14496.part15.TemporalSubLayerSampleGroup;
import com.zj.adlib.nv1;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.runtime.reflect.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SampleGroupDescriptionBox extends AbstractFullBox {
    public static final String TYPE = "sgpd";
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    private int defaultLength;
    private List<GroupEntry> groupEntries;
    private String groupingType;

    static {
        ajc$preClinit();
    }

    public SampleGroupDescriptionBox() {
        super(TYPE);
        this.groupEntries = new LinkedList();
        setVersion(1);
    }

    private static /* synthetic */ void ajc$preClinit() {
        d dVar = new d("SampleGroupDescriptionBox.java", SampleGroupDescriptionBox.class);
        ajc$tjp_0 = dVar.H("method-execution", dVar.E("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 57);
        ajc$tjp_1 = dVar.H("method-execution", dVar.E("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.String", "groupingType", "", "void"), 61);
        ajc$tjp_2 = dVar.H("method-execution", dVar.E("1", "getDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 153);
        ajc$tjp_3 = dVar.H("method-execution", dVar.E("1", "setDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 157);
        ajc$tjp_4 = dVar.H("method-execution", dVar.E("1", "getGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), 161);
        ajc$tjp_5 = dVar.H("method-execution", dVar.E("1", "setGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 165);
        ajc$tjp_6 = dVar.H("method-execution", dVar.E("1", "equals", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", j.b, "", TypedValues.Custom.S_BOOLEAN), c.f6376a);
        ajc$tjp_7 = dVar.H("method-execution", dVar.E("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED);
        ajc$tjp_8 = dVar.H("method-execution", dVar.E("1", "toString", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 199);
    }

    private GroupEntry parseGroupEntry(ByteBuffer byteBuffer, String str) {
        GroupEntry stepwiseTemporalLayerEntry;
        if (RollRecoveryEntry.TYPE.equals(str)) {
            stepwiseTemporalLayerEntry = new RollRecoveryEntry();
        } else if (RateShareEntry.TYPE.equals(str)) {
            stepwiseTemporalLayerEntry = new RateShareEntry();
        } else if (CencSampleEncryptionInformationGroupEntry.TYPE.equals(str)) {
            stepwiseTemporalLayerEntry = new CencSampleEncryptionInformationGroupEntry();
        } else if (VisualRandomAccessEntry.TYPE.equals(str)) {
            stepwiseTemporalLayerEntry = new VisualRandomAccessEntry();
        } else if (TemporalLevelEntry.TYPE.equals(str)) {
            stepwiseTemporalLayerEntry = new TemporalLevelEntry();
        } else if (NativeCallContext.CALL_MODE_SYNC.equals(str)) {
            stepwiseTemporalLayerEntry = new SyncSampleEntry();
        } else if ("tscl".equals(str)) {
            stepwiseTemporalLayerEntry = new TemporalLayerSampleGroup();
        } else if ("tsas".equals(str)) {
            stepwiseTemporalLayerEntry = new TemporalSubLayerSampleGroup();
        } else {
            stepwiseTemporalLayerEntry = "stsa".equals(str) ? new StepwiseTemporalLayerEntry() : new UnknownEntry(str);
        }
        stepwiseTemporalLayerEntry.parse(byteBuffer);
        return stepwiseTemporalLayerEntry;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() != 1) {
            throw new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        }
        this.groupingType = IsoTypeReader.read4cc(byteBuffer);
        if (getVersion() == 1) {
            this.defaultLength = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        }
        long uInt32 = IsoTypeReader.readUInt32(byteBuffer);
        while (true) {
            long j = uInt32 - 1;
            if (uInt32 <= 0) {
                return;
            }
            int iL2i = this.defaultLength;
            if (getVersion() != 1) {
                throw new RuntimeException("This should be implemented");
            }
            if (this.defaultLength == 0) {
                iL2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
            }
            int iPosition = byteBuffer.position() + iL2i;
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.limit(iL2i);
            this.groupEntries.add(parseGroupEntry(byteBufferSlice, this.groupingType));
            byteBuffer.position(iPosition);
            uInt32 = j;
        }
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_6, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SampleGroupDescriptionBox sampleGroupDescriptionBox = (SampleGroupDescriptionBox) obj;
        if (this.defaultLength != sampleGroupDescriptionBox.defaultLength) {
            return false;
        }
        List<GroupEntry> list = this.groupEntries;
        List<GroupEntry> list2 = sampleGroupDescriptionBox.groupEntries;
        return list == null ? list2 == null : list.equals(list2);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(IsoFile.fourCCtoBytes(this.groupingType));
        if (getVersion() == 1) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.defaultLength);
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.groupEntries.size());
        for (GroupEntry groupEntry : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                IsoTypeWriter.writeUInt32(byteBuffer, groupEntry.get().limit());
            }
            byteBuffer.put(groupEntry.get());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        long size = (getVersion() == 1 ? 12L : 8L) + 4;
        for (GroupEntry groupEntry : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                size += 4;
            }
            size += (long) groupEntry.size();
        }
        return size;
    }

    public int getDefaultLength() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_2, this, this));
        return this.defaultLength;
    }

    public List<GroupEntry> getGroupEntries() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_4, this, this));
        return this.groupEntries;
    }

    public String getGroupingType() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_0, this, this));
        return this.groupingType;
    }

    public int hashCode() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_7, this, this));
        int i = (this.defaultLength + 0) * 31;
        List<GroupEntry> list = this.groupEntries;
        return i + (list != null ? list.hashCode() : 0);
    }

    public void setDefaultLength(int i) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_3, this, this, nv1.k(i)));
        this.defaultLength = i;
    }

    public void setGroupEntries(List<GroupEntry> list) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_5, this, this, list));
        this.groupEntries = list;
    }

    public void setGroupingType(String str) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_1, this, this, str));
        this.groupingType = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_8, this, this));
        StringBuilder sb = new StringBuilder("SampleGroupDescriptionBox{groupingType='");
        sb.append(this.groupEntries.size() > 0 ? this.groupEntries.get(0).getType() : "????");
        sb.append('\'');
        sb.append(", defaultLength=");
        sb.append(this.defaultLength);
        sb.append(", groupEntries=");
        sb.append(this.groupEntries);
        sb.append('}');
        return sb.toString();
    }
}
