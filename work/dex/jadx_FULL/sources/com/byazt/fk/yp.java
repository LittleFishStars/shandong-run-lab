package com.byazt.fk;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.List;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1696, 215})
public class yp implements u, Function {
    public volatile Function c;
    public volatile u tt;

    public yp(u uVar) {
        this.tt = uVar;
    }

    public yp(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.tt.getPassThroughJson();
            case 2:
                return Integer.valueOf(this.tt.getPitayaCacheSize());
            case 3:
                return Integer.valueOf(this.tt.getPitayaCode());
            case 4:
                return this.tt.getPitayaErrorMsg();
            case 5:
                return this.tt.getCacheParentDir();
            case 6:
                this.tt.setCacheParentDir((String) sparseArray.get(1));
                return null;
            case 7:
                this.tt.setVideoSkipResult(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 8:
                return Integer.valueOf(this.tt.getVideoSkipResult());
            case 9:
                return Integer.valueOf(this.tt.getPreloadSize());
            case 10:
                return Boolean.valueOf(this.tt.isAudio());
            case 11:
                this.tt.setAudio(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 12:
                return this.tt.getCid();
            case 13:
                this.tt.setCid((String) sparseArray.get(1));
                return null;
            case 14:
                return Integer.valueOf(this.tt.getWidth());
            case 15:
                this.tt.setWidth(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 16:
                return Integer.valueOf(this.tt.getHeight());
            case 17:
                this.tt.setHeight(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 18:
                return this.tt.getPlayTrackUrls();
            case 19:
                this.tt.setPlayTrackUrls((List) sparseArray.get(1));
                return null;
            case 20:
                return this.tt.getLogExtra();
            case 21:
                this.tt.setLogExtra((String) sparseArray.get(1));
                return null;
            case 22:
                return Long.valueOf(this.tt.getCurrent());
            case 23:
                this.tt.setCurrent(((Long) sparseArray.get(1)).longValue());
                return null;
            case 24:
                return Boolean.valueOf(this.tt.isQuiet());
            case 25:
                this.tt.setQuiet(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 26:
                return Long.valueOf(this.tt.getVideoSize());
            case 27:
                return Boolean.valueOf(this.tt.isPreloadAll());
            case 28:
                return this.tt.getCodeId();
            case 29:
                this.tt.setCodeId((String) sparseArray.get(1));
                return null;
            case 30:
                return Integer.valueOf(this.tt.getScene());
            case 31:
                this.tt.setScene(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 32:
                return Boolean.valueOf(this.tt.isH265());
            case 33:
                return Float.valueOf(this.tt.getPlaySpeedRatio());
            case 34:
                return this.tt.getUrl();
            case 35:
                return this.tt.getFileNameKey();
            case 36:
                return Integer.valueOf(this.tt.getPlayerType());
            case 37:
                this.tt.setPlayerType(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 38:
                this.tt.putExtra((String) sparseArray.get(1), sparseArray.get(2));
                return null;
            case 39:
                return this.tt.getExtra((String) sparseArray.get(1));
            case 40:
                return this.tt.removeExtra((String) sparseArray.get(1));
            case 41:
                return Integer.valueOf(this.tt.getConnectTimeOutMills());
            case 42:
                this.tt.setConnectTimeOutMills(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 43:
                return Integer.valueOf(this.tt.getReadTimeOutMills());
            case 44:
                this.tt.setReadTimeOutMills(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 45:
                return Integer.valueOf(this.tt.getWriteTimeOutMills());
            case 46:
                this.tt.setWriteTimeOutMills(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 47:
                return Integer.valueOf(this.tt.getSourceType());
            case 48:
                this.tt.setSourceType(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 49:
                return Integer.valueOf(this.tt.getVideoEncodeType());
            case 50:
                this.tt.setVideoEncodeType(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 51:
                n videoH264 = this.tt.getVideoH264();
                return videoH264 != null ? new a(videoH264) : videoH264;
            case 52:
                Object aVar = sparseArray.get(1);
                if (aVar != null) {
                    aVar = new a((Function) aVar);
                }
                this.tt.setVideoH264((n) aVar);
                return null;
            case 53:
                n videoH265 = this.tt.getVideoH265();
                return videoH265 != null ? new a(videoH265) : videoH265;
            case 54:
                n currentVideoInfo = this.tt.getCurrentVideoInfo();
                return currentVideoInfo != null ? new a(currentVideoInfo) : currentVideoInfo;
            case 55:
                Object aVar2 = sparseArray.get(1);
                if (aVar2 != null) {
                    aVar2 = new a((Function) aVar2);
                }
                this.tt.setVideoH265((n) aVar2);
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.fk.u
    public String getCacheParentDir() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public String getCid() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public String getCodeId() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public int getConnectTimeOutMills() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public long getCurrent() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.fk.u
    public n getCurrentVideoInfo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 54);
        ?? Apply = this.c.apply(sparseArray);
        ?? aVar = Apply;
        if (Apply != 0) {
            aVar = new a((Function) Apply);
        }
        return (n) aVar;
    }

    @Override // com.byazt.fk.u
    public Object getExtra(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        sparseArray.put(1, str);
        return this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public String getFileNameKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public int getHeight() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public String getLogExtra() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public JSONObject getPassThroughJson() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (JSONObject) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public int getPitayaCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public int getPitayaCode() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public String getPitayaErrorMsg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public float getPlaySpeedRatio() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        return ((Float) this.c.apply(sparseArray)).floatValue();
    }

    @Override // com.byazt.fk.u
    public List getPlayTrackUrls() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return (List) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public int getPlayerType() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public int getPreloadSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public int getReadTimeOutMills() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public int getScene() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public int getSourceType() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 47);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public String getUrl() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public int getVideoEncodeType() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 49);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.fk.u
    public n getVideoH264() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 51);
        ?? Apply = this.c.apply(sparseArray);
        ?? aVar = Apply;
        if (Apply != 0) {
            aVar = new a((Function) Apply);
        }
        return (n) aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.fk.u
    public n getVideoH265() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 53);
        ?? Apply = this.c.apply(sparseArray);
        ?? aVar = Apply;
        if (Apply != 0) {
            aVar = new a((Function) Apply);
        }
        return (n) aVar;
    }

    @Override // com.byazt.fk.u
    public long getVideoSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.fk.u
    public int getVideoSkipResult() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public int getWidth() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public int getWriteTimeOutMills() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 45);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.u
    public boolean isAudio() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.u
    public boolean isH265() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.u
    public boolean isPreloadAll() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.u
    public boolean isQuiet() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.u
    public void putExtra(String str, Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, str);
        sparseArray.put(2, obj);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public Object removeExtra(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, str);
        return this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setAudio(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setCacheParentDir(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setCid(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setCodeId(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setConnectTimeOutMills(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setCurrent(long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, Long.valueOf(j));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setHeight(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setLogExtra(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setPlayTrackUrls(List list) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, list);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setPlayerType(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setQuiet(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setReadTimeOutMills(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setScene(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setSourceType(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 48);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setVideoEncodeType(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 50);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setVideoH264(n nVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 52);
        if (nVar != null) {
            nVar = new a(nVar);
        }
        sparseArray.put(1, nVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setVideoH265(n nVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 55);
        if (nVar != null) {
            nVar = new a(nVar);
        }
        sparseArray.put(1, nVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setVideoSkipResult(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setWidth(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.u
    public void setWriteTimeOutMills(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 46);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }
}
