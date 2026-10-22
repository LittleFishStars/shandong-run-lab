package com.aliyun.player.source;

import com.aliyun.player.VidPlayerConfigGen;
import com.cicada.player.utils.NativeUsed;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VidSourceBase extends SourceBase {
    private List<Definition> mDefinitions;
    private List<MediaFormat> mFormats;
    private VidPlayerConfigGen mPlayConfig = null;
    private OutputType mOutputType = null;
    private Set<StreamType> mStreamTypes = null;
    private String mReAuthInfo = null;
    private ResultType mResultType = null;
    private long mAuthTimeout = 3600;

    public enum OutputType {
        oss("oss"),
        cdn("cdn");

        private String mOutputType;

        OutputType(String str) {
            this.mOutputType = str;
        }

        public String getOutputType() {
            return this.mOutputType;
        }
    }

    public enum ResultType {
        Single("Single"),
        Multiple("Multiple");

        private String mResultType;

        ResultType(String str) {
            this.mResultType = str;
        }

        public String getResultType() {
            return this.mResultType;
        }
    }

    public enum StreamType {
        video("video"),
        audio("audio");

        private String mStreamType;

        StreamType(String str) {
            this.mStreamType = str;
        }

        public String getStreamType() {
            return this.mStreamType;
        }
    }

    @NativeUsed
    public long getAuthTimeout() {
        return this.mAuthTimeout;
    }

    @NativeUsed
    public String getDefinitionStr() {
        List<Definition> list = this.mDefinitions;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<Definition> list2 = this.mDefinitions;
        Definition definition = Definition.DEFINITION_AUTO;
        if (list2.contains(definition)) {
            return definition.getName();
        }
        StringBuilder sb = new StringBuilder("");
        for (Definition definition2 : this.mDefinitions) {
            if (definition2 != null) {
                sb.append(definition2.getName());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @NativeUsed
    public String getFormatStr() {
        List<MediaFormat> list = this.mFormats;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (MediaFormat mediaFormat : this.mFormats) {
            if (mediaFormat != null) {
                sb.append(mediaFormat.getFormat());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public List<MediaFormat> getFormats() {
        return this.mFormats;
    }

    public OutputType getOutputType() {
        return this.mOutputType;
    }

    @NativeUsed
    public String getOutputTypeStr() {
        OutputType outputType = this.mOutputType;
        if (outputType == null) {
            return null;
        }
        return outputType.getOutputType();
    }

    public String getPlayConfig() {
        VidPlayerConfigGen vidPlayerConfigGen = this.mPlayConfig;
        return vidPlayerConfigGen == null ? "" : vidPlayerConfigGen.genConfig();
    }

    public String getReAuthInfo() {
        return this.mReAuthInfo;
    }

    @NativeUsed
    public String getReAuthInfoStr() {
        return this.mReAuthInfo;
    }

    public ResultType getResultType() {
        return this.mResultType;
    }

    @NativeUsed
    public String getResultTypeStr() {
        ResultType resultType = this.mResultType;
        if (resultType == null) {
            return null;
        }
        return resultType.getResultType();
    }

    public Set<StreamType> getStreamType() {
        return this.mStreamTypes;
    }

    @NativeUsed
    public String getStreamTypeStr() {
        if (this.mStreamTypes == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (StreamType streamType : this.mStreamTypes) {
            if (streamType != null) {
                sb.append(streamType.getStreamType());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public void setAuthTimeout(long j) {
        this.mAuthTimeout = j;
    }

    public void setDefinition(List<Definition> list) {
        this.mDefinitions = list;
    }

    public void setFormats(List<MediaFormat> list) {
        this.mFormats = list;
    }

    public void setOutputType(OutputType outputType) {
        this.mOutputType = outputType;
    }

    public void setPlayConfig(VidPlayerConfigGen vidPlayerConfigGen) {
        this.mPlayConfig = vidPlayerConfigGen;
    }

    public void setReAuthInfo(String str) {
        this.mReAuthInfo = str;
    }

    public void setResultType(ResultType resultType) {
        this.mResultType = resultType;
    }

    public void setStreamType(Set<StreamType> set) {
        this.mStreamTypes = set;
    }
}
