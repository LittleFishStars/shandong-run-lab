package com.aliyun.svideosdk.editor.e;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.common.struct.project.RollCaptionTrack;
import com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.editor.AliyunRollCaptionComposer;
import com.aliyun.svideosdk.editor.NativeEditor;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a implements AliyunRollCaptionComposer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeEditor f25710a;
    private int b;
    private int c;
    private CopyOnWriteArrayList<com.aliyun.svideosdk.editor.e.b> d;
    private com.aliyun.svideosdk.editor.e.c e;
    private Context h;
    private AliyunEditorProject j;
    private boolean f = false;
    private Pattern g = Pattern.compile("\\[(\\d{1,2}):(\\d{1,2}).(\\d{1,2})\\]");
    private ThreadPoolExecutor i = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0227a(this));

    /* JADX INFO: renamed from: com.aliyun.svideosdk.editor.e.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0227a implements ThreadFactory {
        public ThreadFactoryC0227a(a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("RollCaptionComposerThread");
            return thread;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            CopyOnWriteArrayList copyOnWriteArrayList = a.this.d;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
                Log.w("RollCaptionComposer", "applyDisplay REJECTED. caption list is empty!");
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            a.this.hide();
            a.this.b(false);
            Iterator it = copyOnWriteArrayList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                com.aliyun.svideosdk.editor.e.b bVar = (com.aliyun.svideosdk.editor.e.b) it.next();
                com.aliyun.svideosdk.editor.e.c cVarB = a.this.b(bVar);
                if (!new d(a.this.f25710a, bVar, a.this.b, a.this.c, e.a(a.this.h, bVar.b(), cVarB, a.this.b, a.this.c), cVarB).a()) {
                    Log.w("RollCaptionComposer", "applyDisplay. failed to attach caption:" + bVar);
                    z = false;
                    break;
                }
                i++;
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            a aVar = a.this;
            if (z) {
                aVar.f25710a.applyRollCaptionEffects();
                a.this.c();
            } else {
                aVar.hide();
            }
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            Log.i("RollCaptionComposer", String.format("applyDisplay. allAttached:%b, costMills:%d, t1:%d, t2:%d, size:%d, caption count:%d", Boolean.valueOf(z), Long.valueOf(jElapsedRealtime3 - jElapsedRealtime), Long.valueOf(jElapsedRealtime2 - jElapsedRealtime), Long.valueOf(jElapsedRealtime3 - jElapsedRealtime2), Integer.valueOf(i), Integer.valueOf(copyOnWriteArrayList.size())));
        }
    }

    public class c implements AliyunRollCaptionComposer.StyleEditor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.aliyun.svideosdk.editor.e.c f25712a;

        public c(com.aliyun.svideosdk.editor.e.c cVar) {
            this.f25712a = cVar;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c setTextColor(int i) {
            com.aliyun.svideosdk.editor.e.c cVar = this.f25712a;
            if (cVar == null) {
                return this;
            }
            cVar.a(i);
            return this;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        @Deprecated
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c setTextFont(String str) {
            com.aliyun.svideosdk.editor.e.c cVar = this.f25712a;
            if (cVar == null) {
                return this;
            }
            cVar.a(new Source(str));
            return this;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c setTextStrokeColor(int i) {
            com.aliyun.svideosdk.editor.e.c cVar = this.f25712a;
            if (cVar == null) {
                return this;
            }
            cVar.b(i);
            return this;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        public void done() {
            a.this.b(true);
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        public AliyunRollCaptionComposer.StyleEditor setDefaultTextSize(int i, int i2) {
            com.aliyun.svideosdk.editor.e.c cVar = this.f25712a;
            if (cVar == null) {
                return this;
            }
            cVar.a(i, i2);
            return this;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        public AliyunRollCaptionComposer.StyleEditor setTextFont(Source source) {
            com.aliyun.svideosdk.editor.e.c cVar = this.f25712a;
            if (cVar == null) {
                return this;
            }
            cVar.a(source);
            return this;
        }
    }

    public a(NativeEditor nativeEditor, AliyunEditorProject aliyunEditorProject) {
        this.f25710a = nativeEditor;
        this.j = aliyunEditorProject;
    }

    private long a(String str, String str2, String str3) {
        int i = Integer.parseInt(str);
        int i2 = Integer.parseInt(str2);
        int i3 = Integer.parseInt(str3) * 10;
        if (i2 >= 60) {
            Log.w("RollCaptionComposer", "时间格式不正确的项:[" + str + u15.f19942b + str2 + u15.f19942b + str3 + "]");
            i += i2 / 60;
            i2 %= 60;
        }
        return (i * 60 * 1000) + (i2 * 1000) + i3;
    }

    private RollCaptionTrackClip a(com.aliyun.svideosdk.editor.e.b bVar) {
        RollCaptionTrackClip rollCaptionTrackClip = new RollCaptionTrackClip();
        com.aliyun.svideosdk.editor.e.c cVarB = b(bVar);
        rollCaptionTrackClip.setTimelineIn(bVar.a() / 1000.0f);
        rollCaptionTrackClip.setText(bVar.b());
        rollCaptionTrackClip.setFont(cVarB.b());
        rollCaptionTrackClip.setTextColor(cVarB.c());
        rollCaptionTrackClip.setOutlineColor(cVarB.f());
        return rollCaptionTrackClip;
    }

    private com.aliyun.svideosdk.editor.e.b a(int i) {
        CopyOnWriteArrayList<com.aliyun.svideosdk.editor.e.b> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList != null && i >= 0 && i < copyOnWriteArrayList.size()) {
            return copyOnWriteArrayList.get(i);
        }
        Log.w("RollCaptionComposer", "findCaptionInfo. caption not found at index " + i);
        return null;
    }

    private com.aliyun.svideosdk.editor.e.b a(RollCaptionTrackClip rollCaptionTrackClip) {
        com.aliyun.svideosdk.editor.e.b bVar = new com.aliyun.svideosdk.editor.e.b();
        bVar.a((long) (rollCaptionTrackClip.getTimelineIn() * 1000.0f));
        bVar.a(rollCaptionTrackClip.getText());
        com.aliyun.svideosdk.editor.e.c cVar = new com.aliyun.svideosdk.editor.e.c();
        cVar.a(rollCaptionTrackClip.getTextColor());
        cVar.b(rollCaptionTrackClip.getOutlineColor());
        cVar.a(rollCaptionTrackClip.getFont());
        bVar.a(cVar);
        return bVar;
    }

    private com.aliyun.svideosdk.editor.e.b a(String str) {
        StringBuilder sb;
        Matcher matcher = this.g.matcher(str);
        if (matcher.find()) {
            long jA = a(matcher.group(1), matcher.group(2), matcher.group(3));
            String strSubstring = str.substring(matcher.end());
            if (!TextUtils.isEmpty(strSubstring)) {
                com.aliyun.svideosdk.editor.e.b bVar = new com.aliyun.svideosdk.editor.e.b();
                bVar.a(jA);
                bVar.a(strSubstring);
                Log.d("RollCaptionComposer", "成功解析字幕：" + bVar);
                return bVar;
            }
            sb = new StringBuilder();
            sb.append("字幕文本不存在:");
        } else {
            sb = new StringBuilder();
            sb.append("字幕格式不正确:");
            sb.append(str);
            str = ", 参考格式:[00:10:10]字幕内容";
        }
        sb.append(str);
        Log.w("RollCaptionComposer", sb.toString());
        return null;
    }

    private static com.aliyun.svideosdk.editor.e.c a() {
        com.aliyun.svideosdk.editor.e.c cVar = new com.aliyun.svideosdk.editor.e.c();
        cVar.a(-1);
        cVar.b(0);
        return cVar;
    }

    private boolean a(boolean z) {
        String str;
        CopyOnWriteArrayList<com.aliyun.svideosdk.editor.e.b> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            str = "applyDisplay REJECTED. caption list is empty!";
        } else {
            if (b()) {
                b bVar = new b();
                if (z) {
                    this.i.execute(bVar);
                    return true;
                }
                bVar.run();
                return true;
            }
            str = "applyDisplay REJECTED. is not dirty!";
        }
        Log.w("RollCaptionComposer", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideosdk.editor.e.c b(com.aliyun.svideosdk.editor.e.b bVar) {
        com.aliyun.svideosdk.editor.e.c cVar = this.e;
        return cVar != null ? cVar : bVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.f = z;
    }

    private boolean b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        CopyOnWriteArrayList<com.aliyun.svideosdk.editor.e.b> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(copyOnWriteArrayList.size());
        Iterator<com.aliyun.svideosdk.editor.e.b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        RollCaptionTrack rollCaptionTrack = new RollCaptionTrack();
        rollCaptionTrack.getRollCaptionTrackClips().addAll(arrayList);
        this.j.setRollCaptionTrack(rollCaptionTrack);
    }

    public void a(int i, int i2) {
        this.b = i;
        this.c = i2;
        Log.d("RollCaptionComposer", "setDisplaySize width:" + i + ", height:" + i2);
    }

    public void a(Context context) {
        this.h = context;
    }

    public void a(RollCaptionTrack rollCaptionTrack) {
        if (rollCaptionTrack == null || rollCaptionTrack.getRollCaptionTrackClips().size() == 0) {
            this.d = null;
            return;
        }
        List<RollCaptionTrackClip> rollCaptionTrackClips = rollCaptionTrack.getRollCaptionTrackClips();
        ArrayList arrayList = new ArrayList(rollCaptionTrackClips.size());
        Iterator<RollCaptionTrackClip> it = rollCaptionTrackClips.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        this.d = new CopyOnWriteArrayList<>(arrayList);
        b(true);
        a(false);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public AliyunRollCaptionComposer.StyleEditor editCaptionFamilyStyle() {
        if (this.e == null) {
            this.e = a();
        }
        return new c(this.e);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public AliyunRollCaptionComposer.StyleEditor editCaptionStyle(int i) {
        com.aliyun.svideosdk.editor.e.b bVarA = a(i);
        return new c(bVarA != null ? bVarA.c() : null);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public void hide() {
        this.f25710a.clearRollCaptions();
        b(true);
        this.j.clearRollCaptionTrack();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public void reset() {
        hide();
        this.e = null;
        this.d = null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public boolean show() {
        return a(true);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public void updateCaptionList(List<String> list) {
        if (list == null || list.size() == 0) {
            Log.w("RollCaptionComposer", "updateCaptionList invalid params, empty or null!");
            return;
        }
        Log.d("RollCaptionComposer", "updateCaptionList size=" + list.size());
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            com.aliyun.svideosdk.editor.e.b bVarA = a(it.next());
            if (bVarA != null) {
                bVarA.a(a());
                arrayList.add(bVarA);
            }
        }
        this.d = new CopyOnWriteArrayList<>(arrayList);
        b(true);
    }
}
