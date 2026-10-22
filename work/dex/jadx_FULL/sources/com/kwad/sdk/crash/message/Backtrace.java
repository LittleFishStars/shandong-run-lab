package com.kwad.sdk.crash.message;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public final class Backtrace extends a implements Serializable {
    public static final int MAX_FRAME = 256;
    private static final long serialVersionUID = 3694153530505949565L;
    public List<BackTraceElement> mBacktraces = new ArrayList();
    public int mFrame;

    public final List<BackTraceElement> getBacktraces() {
        return this.mBacktraces;
    }

    public final int getFrame() {
        return this.mFrame;
    }

    public final void setBacktraces(List<BackTraceElement> list) {
        this.mBacktraces = list;
    }

    public final void setFrame(int i) {
        this.mFrame = i;
    }
}
