package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.ProtectionSchemeInformationBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SchemeInformationBox;
import com.coremedia.iso.boxes.SchemeTypeBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.MemoryDataSourceImpl;
import com.googlecode.mp4parser.authoring.Edit;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.authoring.tracks.h264.H264TrackImpl;
import com.googlecode.mp4parser.authoring.tracks.h265.H265TrackImpl;
import com.googlecode.mp4parser.boxes.cenc.CencEncryptingSampleList;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.CencSampleEncryptionInformationGroupEntry;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.RangeStartMap;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import com.mp4parser.iso14496.part15.HevcConfigurationBox;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import com.mp4parser.iso23001.part7.TrackEncryptionBox;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CencEncryptingTrackImpl implements CencEncryptedTrack {
    List<CencSampleAuxiliaryDataFormat> cencSampleAuxiliaryData;
    Object configurationBox;
    UUID defaultKeyId;
    boolean dummyIvs;
    private final String encryptionAlgo;
    RangeStartMap<Integer, SecretKey> indexToKey;
    Map<UUID, SecretKey> keys;
    Map<GroupEntry, long[]> sampleGroups;
    List<Sample> samples;
    Track source;
    SampleDescriptionBox stsd;
    boolean subSampleEncryption;

    public CencEncryptingTrackImpl(Track track, UUID uuid, SecretKey secretKey, boolean z) {
        this(track, uuid, Collections.singletonMap(uuid, secretKey), null, "cenc", z);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return this.source.getCompositionTimeEntries();
    }

    @Override // com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack
    public UUID getDefaultKeyId() {
        return this.defaultKeyId;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long getDuration() {
        return this.source.getDuration();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Edit> getEdits() {
        return this.source.getEdits();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return this.source.getHandler();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getName() {
        return "enc(" + this.source.getName() + ")";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return this.source.getSampleDependencies();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized SampleDescriptionBox getSampleDescriptionBox() {
        if (this.stsd == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                this.source.getSampleDescriptionBox().getBox(Channels.newChannel(byteArrayOutputStream));
                int i = 0;
                this.stsd = (SampleDescriptionBox) new IsoFile(new MemoryDataSourceImpl(byteArrayOutputStream.toByteArray())).getBoxes().get(0);
                OriginalFormatBox originalFormatBox = new OriginalFormatBox();
                originalFormatBox.setDataFormat(this.stsd.getSampleEntry().getType());
                if (this.stsd.getSampleEntry() instanceof AudioSampleEntry) {
                    ((AudioSampleEntry) this.stsd.getSampleEntry()).setType(AudioSampleEntry.TYPE_ENCRYPTED);
                } else {
                    if (!(this.stsd.getSampleEntry() instanceof VisualSampleEntry)) {
                        throw new RuntimeException("I don't know how to cenc " + this.stsd.getSampleEntry().getType());
                    }
                    ((VisualSampleEntry) this.stsd.getSampleEntry()).setType(VisualSampleEntry.TYPE_ENCRYPTED);
                }
                ProtectionSchemeInformationBox protectionSchemeInformationBox = new ProtectionSchemeInformationBox();
                protectionSchemeInformationBox.addBox(originalFormatBox);
                SchemeTypeBox schemeTypeBox = new SchemeTypeBox();
                schemeTypeBox.setSchemeType(this.encryptionAlgo);
                schemeTypeBox.setSchemeVersion(65536);
                protectionSchemeInformationBox.addBox(schemeTypeBox);
                SchemeInformationBox schemeInformationBox = new SchemeInformationBox();
                TrackEncryptionBox trackEncryptionBox = new TrackEncryptionBox();
                trackEncryptionBox.setDefaultIvSize(this.defaultKeyId == null ? 0 : 8);
                if (this.defaultKeyId != null) {
                    i = 1;
                }
                trackEncryptionBox.setDefaultAlgorithmId(i);
                UUID uuid = this.defaultKeyId;
                if (uuid == null) {
                    uuid = new UUID(0L, 0L);
                }
                trackEncryptionBox.setDefault_KID(uuid);
                schemeInformationBox.addBox(trackEncryptionBox);
                protectionSchemeInformationBox.addBox(schemeInformationBox);
                this.stsd.getSampleEntry().addBox(protectionSchemeInformationBox);
            } catch (IOException unused) {
                throw new RuntimeException("Dumping stsd to memory failed");
            }
        }
        return this.stsd;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.source.getSampleDurations();
    }

    @Override // com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack
    public List<CencSampleAuxiliaryDataFormat> getSampleEncryptionEntries() {
        return this.cencSampleAuxiliaryData;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Map<GroupEntry, long[]> getSampleGroups() {
        return this.sampleGroups;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return new CencEncryptingSampleList(this.indexToKey, this.source.getSamples(), this.cencSampleAuxiliaryData, this.encryptionAlgo);
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return this.source.getSubsampleInformationBox();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return this.source.getSyncSamples();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.source.getTrackMetaData();
    }

    @Override // com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack
    public boolean hasSubSampleEncryption() {
        return this.subSampleEncryption;
    }

    public boolean isClearNal(ByteBuffer byteBuffer) {
        Object obj = this.configurationBox;
        if (!(obj instanceof HevcConfigurationBox)) {
            if (!(obj instanceof AvcConfigurationBox)) {
                throw new RuntimeException("Subsample encryption is activated but the CencEncryptingTrackImpl can't say if this sample is to be encrypted or not!");
            }
            int i = H264TrackImpl.getNalUnitHeader(byteBuffer.slice()).nal_unit_type;
            return (i == 19 || i == 2 || i == 3 || i == 4 || i == 20 || i == 5 || i == 1) ? false : true;
        }
        int i2 = H265TrackImpl.getNalUnitHeader(byteBuffer.slice()).nalUnitType;
        if (i2 >= 0 && i2 <= 9) {
            return false;
        }
        if (i2 < 16 || i2 > 21) {
            return i2 < 16 || i2 > 21;
        }
        return false;
    }

    public CencEncryptingTrackImpl(Track track, UUID uuid, Map<UUID, SecretKey> map, Map<CencSampleEncryptionInformationGroupEntry, long[]> map2, String str, boolean z) {
        this(track, uuid, map, map2, str, z, false);
    }

    public CencEncryptingTrackImpl(Track track, UUID uuid, Map<UUID, SecretKey> map, Map<CencSampleEncryptionInformationGroupEntry, long[]> map2, String str, boolean z, boolean z2) {
        new HashMap();
        int i = 0;
        this.subSampleEncryption = false;
        SecretKey secretKey = null;
        this.stsd = null;
        this.source = track;
        this.keys = map;
        this.defaultKeyId = uuid;
        this.dummyIvs = z;
        this.encryptionAlgo = str;
        this.sampleGroups = new HashMap();
        for (Map.Entry<GroupEntry, long[]> entry : track.getSampleGroups().entrySet()) {
            if (!(entry.getKey() instanceof CencSampleEncryptionInformationGroupEntry)) {
                this.sampleGroups.put(entry.getKey(), entry.getValue());
            }
            i = 0;
            secretKey = null;
        }
        if (map2 != null) {
            for (Map.Entry<CencSampleEncryptionInformationGroupEntry, long[]> entry2 : map2.entrySet()) {
                this.sampleGroups.put(entry2.getKey(), entry2.getValue());
            }
        }
        this.sampleGroups = new HashMap<GroupEntry, long[]>(this.sampleGroups) { // from class: com.googlecode.mp4parser.authoring.tracks.CencEncryptingTrackImpl.1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public long[] put(GroupEntry groupEntry, long[] jArr) {
                if (groupEntry instanceof CencSampleEncryptionInformationGroupEntry) {
                    throw new RuntimeException("Please supply CencSampleEncryptionInformationGroupEntries in the constructor");
                }
                return (long[]) super.put(groupEntry, jArr);
            }
        };
        this.samples = track.getSamples();
        this.cencSampleAuxiliaryData = new ArrayList();
        BigInteger bigInteger = new BigInteger("1");
        int i2 = 8;
        byte[] bArr = new byte[8];
        if (!z) {
            new SecureRandom().nextBytes(bArr);
        }
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        ArrayList arrayList = new ArrayList();
        if (map2 != null) {
            arrayList.addAll(map2.keySet());
        }
        this.indexToKey = new RangeStartMap<>();
        int lengthSizeMinusOne = -1;
        int i3 = i;
        int i4 = -1;
        while (i3 < track.getSamples().size()) {
            int i5 = i;
            int i6 = i5;
            while (i5 < arrayList.size()) {
                BigInteger bigInteger3 = bigInteger2;
                if (Arrays.binarySearch(getSampleGroups().get((GroupEntry) arrayList.get(i5)), i3) >= 0) {
                    i6 = i5 + 1;
                }
                i5++;
                bigInteger2 = bigInteger3;
                secretKey = null;
                i2 = 8;
            }
            if (i4 != i6) {
                if (i6 == 0) {
                    this.indexToKey.put(Integer.valueOf(i3), map.get(uuid));
                } else {
                    int i7 = i6 - 1;
                    if (((CencSampleEncryptionInformationGroupEntry) arrayList.get(i7)).getKid() != null) {
                        SecretKey secretKey2 = map.get(((CencSampleEncryptionInformationGroupEntry) arrayList.get(i7)).getKid());
                        if (secretKey2 != null) {
                            this.indexToKey.put(Integer.valueOf(i3), secretKey2);
                        } else {
                            throw new RuntimeException("Key " + ((CencSampleEncryptionInformationGroupEntry) arrayList.get(i7)).getKid() + " was not supplied for decryption");
                        }
                    } else {
                        this.indexToKey.put(Integer.valueOf(i3), secretKey);
                    }
                }
                i4 = i6;
            }
            i3++;
            i = 0;
        }
        Iterator<Box> it = track.getSampleDescriptionBox().getSampleEntry().getBoxes().iterator();
        while (it.hasNext()) {
            AvcConfigurationBox avcConfigurationBox = (Box) it.next();
            if (avcConfigurationBox instanceof AvcConfigurationBox) {
                this.configurationBox = avcConfigurationBox;
                this.subSampleEncryption = true;
                lengthSizeMinusOne = avcConfigurationBox.getLengthSizeMinusOne() + 1;
            }
            if (avcConfigurationBox instanceof HevcConfigurationBox) {
                this.configurationBox = avcConfigurationBox;
                this.subSampleEncryption = true;
                lengthSizeMinusOne = ((HevcConfigurationBox) avcConfigurationBox).getLengthSizeMinusOne() + 1;
            }
        }
        for (int i8 = i; i8 < this.samples.size(); i8++) {
            Sample sample = this.samples.get(i8);
            CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = new CencSampleAuxiliaryDataFormat();
            this.cencSampleAuxiliaryData.add(cencSampleAuxiliaryDataFormat);
            if (this.indexToKey.get(Integer.valueOf(i8)) != null) {
                byte[] byteArray = bigInteger2.toByteArray();
                byte[] bArr2 = new byte[i2];
                System.arraycopy(byteArray, byteArray.length - i2 > 0 ? byteArray.length - i2 : i, bArr2, 8 - byteArray.length < 0 ? i : 8 - byteArray.length, byteArray.length > i2 ? i2 : byteArray.length);
                cencSampleAuxiliaryDataFormat.iv = bArr2;
                ByteBuffer byteBuffer = (ByteBuffer) sample.asByteBuffer().rewind();
                if (this.subSampleEncryption) {
                    if (z2) {
                        CencSampleAuxiliaryDataFormat.Pair[] pairArr = new CencSampleAuxiliaryDataFormat.Pair[1];
                        pairArr[i] = cencSampleAuxiliaryDataFormat.createPair(byteBuffer.remaining(), 0L);
                        cencSampleAuxiliaryDataFormat.pairs = pairArr;
                    } else {
                        ArrayList arrayList2 = new ArrayList(5);
                        while (byteBuffer.remaining() > 0) {
                            int iL2i = CastUtils.l2i(IsoTypeReaderVariable.read(byteBuffer, lengthSizeMinusOne));
                            int i9 = iL2i + lengthSizeMinusOne;
                            int i10 = (i9 < 112 || isClearNal(byteBuffer.duplicate())) ? i9 : (i9 % 16) + 96;
                            arrayList2.add(cencSampleAuxiliaryDataFormat.createPair(i10, i9 - i10));
                            byteBuffer.position(byteBuffer.position() + iL2i);
                        }
                        cencSampleAuxiliaryDataFormat.pairs = (CencSampleAuxiliaryDataFormat.Pair[]) arrayList2.toArray(new CencSampleAuxiliaryDataFormat.Pair[arrayList2.size()]);
                    }
                }
                bigInteger2 = bigInteger2.add(bigInteger);
            }
        }
    }
}
