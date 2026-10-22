package com.efs.sdk.memleaksdk.monitor;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.android.arouter.utils.Consts;
import com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers;
import com.efs.sdk.memleaksdk.monitor.shark.ApplicationLeak;
import com.efs.sdk.memleaksdk.monitor.shark.HeapAnalyzer;
import com.efs.sdk.memleaksdk.monitor.shark.HeapField;
import com.efs.sdk.memleaksdk.monitor.shark.HeapGraph;
import com.efs.sdk.memleaksdk.monitor.shark.HeapObject;
import com.efs.sdk.memleaksdk.monitor.shark.HprofHeapGraph;
import com.efs.sdk.memleaksdk.monitor.shark.HprofRecordTag;
import com.efs.sdk.memleaksdk.monitor.shark.LeakTrace;
import com.efs.sdk.memleaksdk.monitor.shark.LeakTraceObject;
import com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference;
import com.efs.sdk.memleaksdk.monitor.shark.OnAnalysisProgressListener;
import com.efs.sdk.memleaksdk.monitor.shark.ProguardMapping;
import com.efs.sdk.memleaksdk.monitor.shark.aa;
import com.efs.sdk.memleaksdk.monitor.shark.ah;
import com.efs.sdk.memleaksdk.monitor.shark.e;
import com.efs.sdk.memleaksdk.monitor.shark.g;
import com.efs.sdk.memleaksdk.monitor.shark.z;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class UMonitorService extends IntentService {
    private static final String ACTIVITY_CLASS_NAME = "android.app.Activity";
    private static final String ANDROIDX_FRAGMENT_CLASS_NAME = "androidx.fragment.app.Fragment";
    private static final String CURRENT_PAGE = "CURRENT_PAGE";
    private static final String DESTROYED_FIELD_NAME = "mDestroyed";
    private static final String FD = "FD";
    private static final String FINISHED_FIELD_NAME = "mFinished";
    private static final String FRAGMENT_MANAGER_FIELD_NAME = "mFragmentManager";
    private static final String FRAGMENT_MCALLED_FIELD_NAME = "mCalled";
    public static final String HPROF_FILE = "HPROF_FILE";
    public static final String JSON_FILE = "JSON_FILE";
    private static final String MANUFACTURE = "MANUFACTURE";
    private static final String MODEL = "MODEL";
    private static final String NATIVE_FRAGMENT_CLASS_NAME = "android.app.Fragment";
    private static final String REASON = "REASON";
    public static final String RESULT_RECEIVER = "RESULT_RECEIVER";
    public static final String ROOT_PATH = "ROOT_PATH";
    private static final String SDK = "SDK";
    private static final String SUPPORT_FRAGMENT_CLASS_NAME = "androidx.fragment.app.Fragment";
    private static final String TAG = "UMonitor.Service";
    private static final String THREAD = "THREAD";
    private static final String TIME = "TIME";
    private static final String USAGE_TIME = "USAGE_TIME";
    private HeapGraph mHeapGraph;
    private final aa mLeakModel;
    private final Map<Long, String> mLeakReasonTable;
    private final Set<Long> mLeakingObjectIds;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29639a;
        int b;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public UMonitorService() {
        super("UMonitorService");
        this.mLeakModel = new aa();
        this.mLeakingObjectIds = new HashSet();
        this.mLeakReasonTable = new HashMap();
    }

    private void buildIndex(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g.b(TAG, "start analyze");
        HashSet hashSet = new HashSet();
        hashSet.add(HprofRecordTag.ROOT_JNI_GLOBAL);
        hashSet.add(HprofRecordTag.ROOT_JNI_LOCAL);
        hashSet.add(HprofRecordTag.ROOT_NATIVE_STACK);
        hashSet.add(HprofRecordTag.ROOT_STICKY_CLASS);
        hashSet.add(HprofRecordTag.ROOT_THREAD_BLOCK);
        hashSet.add(HprofRecordTag.ROOT_THREAD_OBJECT);
        this.mHeapGraph = HprofHeapGraph.f29765a.a(new File(str), (ProguardMapping) null, hashSet);
    }

    private void buildJson(Intent intent) throws Throwable {
        if (intent == null) {
            return;
        }
        final aa.c cVar = new aa.c();
        this.mLeakModel.f29641a = cVar;
        cVar.f29645a = intent.getStringExtra(THREAD);
        cVar.b = intent.getStringExtra(FD);
        cVar.e = intent.getStringExtra(SDK);
        cVar.f = intent.getStringExtra(MANUFACTURE);
        cVar.g = intent.getStringExtra(MODEL);
        cVar.j = intent.getStringExtra(USAGE_TIME);
        cVar.i = intent.getStringExtra(CURRENT_PAGE);
        cVar.k = intent.getStringExtra(TIME);
        cVar.l = intent.getStringExtra(REASON);
        File fileA = e.a(e.e());
        e.a(fileA, new e.a() { // from class: com.efs.sdk.memleaksdk.monitor.UMonitorService.1
            @Override // com.efs.sdk.memleaksdk.monitor.internal.e.a
            public boolean a(String str) {
                cVar.d.add(str);
                return true;
            }
        });
        fileA.delete();
        File fileA2 = e.a(e.d());
        e.a(fileA2, new e.a() { // from class: com.efs.sdk.memleaksdk.monitor.UMonitorService.2
            @Override // com.efs.sdk.memleaksdk.monitor.internal.e.a
            public boolean a(String str) {
                cVar.c.add(str);
                return true;
            }
        });
        fileA2.delete();
    }

    private void fillJsonFile(String str) throws Throwable {
        try {
            e.a(new File(str), this.mLeakModel.b().toString());
        } catch (Exception e) {
            g.b(TAG, "json write failed", e);
        }
    }

    private void filterLeakingObjects() {
        HeapField heapFieldB;
        HeapField heapFieldB2;
        Boolean boolA;
        HeapField heapFieldB3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        g.b(TAG, "filterLeakingObjects " + Thread.currentThread());
        HeapGraph heapGraph = this.mHeapGraph;
        if (heapGraph == null) {
            return;
        }
        HeapObject.b bVarA = heapGraph.a(ACTIVITY_CLASS_NAME);
        HeapObject.b bVarA2 = this.mHeapGraph.a("androidx.fragment.app.Fragment");
        if (bVarA2 == null && (bVarA2 = this.mHeapGraph.a(NATIVE_FRAGMENT_CLASS_NAME)) == null) {
            bVarA2 = this.mHeapGraph.a("androidx.fragment.app.Fragment");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it = this.mHeapGraph.e().iterator();
        while (it.hasNext()) {
            HeapObject.c cVar = (HeapObject.c) it.next();
            if (!cVar.f()) {
                long j = cVar.c.f29834a;
                Pair pairCreate = (Pair) linkedHashMap.get(Long.valueOf(j));
                if (pairCreate == null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = cVar.i().k().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                    }
                    pairCreate = Pair.create(Long.valueOf(arrayList.size() >= 2 ? ((HeapObject.b) arrayList.get(arrayList.size() - 2)).getE() : 0L), Long.valueOf(arrayList.size() >= 5 ? ((HeapObject.b) arrayList.get(arrayList.size() - 5)).getE() : 0L));
                    linkedHashMap.put(Long.valueOf(j), pairCreate);
                } else {
                    it = it;
                }
                if (bVarA != null && bVarA.getE() == ((Long) pairCreate.second).longValue()) {
                    HeapField heapFieldB4 = cVar.b(ACTIVITY_CLASS_NAME, DESTROYED_FIELD_NAME);
                    if (heapFieldB4 != null && (heapFieldB3 = cVar.b(ACTIVITY_CLASS_NAME, FINISHED_FIELD_NAME)) != null) {
                        Boolean boolA2 = heapFieldB4.c.a();
                        Boolean boolA3 = heapFieldB3.c.a();
                        Boolean bool = Boolean.TRUE;
                        if (boolA2 == bool || boolA3 == bool) {
                            updateClassObjectCounterMap(linkedHashMap2, j, true);
                            g.b(TAG, "activity name : " + cVar.h() + " mDestroyed:" + boolA2 + " mFinished:" + boolA3 + " objectId:" + (cVar.getE() & 4294967295L));
                            this.mLeakingObjectIds.add(Long.valueOf(cVar.getE()));
                            this.mLeakReasonTable.put(Long.valueOf(cVar.getE()), "Activity Leak");
                            StringBuilder sb = new StringBuilder();
                            sb.append(cVar.h());
                            sb.append(" objectId:");
                            sb.append(cVar.getE());
                            g.b(TAG, sb.toString());
                        }
                    }
                } else if (bVarA2 != null && bVarA2.getE() == ((Long) pairCreate.first).longValue() && (heapFieldB = cVar.b(bVarA2.f(), FRAGMENT_MANAGER_FIELD_NAME)) != null && heapFieldB.c.f() != null && (heapFieldB2 = cVar.b(bVarA2.f(), FRAGMENT_MCALLED_FIELD_NAME)) != null && (boolA = heapFieldB2.c.a()) != null) {
                    updateClassObjectCounterMap(linkedHashMap2, j, boolA.booleanValue());
                    g.b(TAG, "fragment name:" + cVar.h() + " isLeak:" + boolA);
                    if (boolA.booleanValue()) {
                        this.mLeakingObjectIds.add(Long.valueOf(cVar.getE()));
                        this.mLeakReasonTable.put(Long.valueOf(cVar.getE()), "Fragment Leak");
                        g.b(TAG, cVar.h() + " objectId:" + cVar.getE());
                    }
                }
                it = it;
                jCurrentTimeMillis = jCurrentTimeMillis;
            }
        }
        long j2 = jCurrentTimeMillis;
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            aa.a aVar = new aa.a();
            HeapObject.b bVarD = this.mHeapGraph.a(((Long) entry.getKey()).longValue()).d();
            if (bVarD != null) {
                aVar.f29642a = bVarD.f();
            }
            aVar.b = ((a) entry.getValue()).f29639a + "";
            this.mLeakModel.c.add(aVar);
            g.b(TAG, String.format(Locale.US, "class: %s, leak count:%s", aVar.f29642a, aVar.b));
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        aa.c cVar2 = this.mLeakModel.f29641a;
        if (cVar2 != null) {
            cVar2.o = ((jCurrentTimeMillis2 - j2) / 1000.0f) + "";
        }
        g.b(TAG, "filter leaking objects cost: " + ((jCurrentTimeMillis2 - j2) / 1000.0f) + "s");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private void findPathsToGcRoot() throws NoWhenBranchMatchedException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HeapAnalyzer.LeaksAndUnreachableObjects cVarA = new HeapAnalyzer(new OnAnalysisProgressListener() { // from class: com.efs.sdk.memleaksdk.monitor.UMonitorService.3
            @Override // com.efs.sdk.memleaksdk.monitor.shark.OnAnalysisProgressListener
            public void a(OnAnalysisProgressListener.b bVar) {
                g.b(UMonitorService.TAG, "heap analysis start: " + bVar.name());
            }
        }).a(new HeapAnalyzer.a(this.mHeapGraph, AndroidReferenceMatchers.b(), true, new ArrayList()), this.mLeakingObjectIds);
        g.b(TAG, "size: " + cVarA.applicationLeaks.size());
        for (ApplicationLeak applicationLeak : cVarA.applicationLeaks) {
            g.b(TAG, applicationLeak.b() + ", signature:" + applicationLeak.a() + ", trace size:" + applicationLeak.c().size());
            List<LeakTrace> listC = applicationLeak.c();
            if (!listC.isEmpty()) {
                LeakTrace leakTrace = listC.get(0);
                String str = leakTrace.f29793a.j;
                LeakTraceObject leakTraceObject = leakTrace.c;
                Set<String> set = leakTraceObject.c;
                leakTrace.c.a(String.valueOf(this.mLeakReasonTable.get(Long.valueOf(leakTraceObject.f29798a))));
                g.b(TAG, str + ", class:" + leakTrace.c.b + ", type:" + leakTrace.c.b() + ", labels:" + set + ", reason:" + leakTrace.c.e + ", objId:" + (leakTrace.c.f29798a & 4294967295L));
                aa.b bVar = new aa.b();
                bVar.c = str;
                LeakTraceObject leakTraceObject2 = leakTrace.c;
                bVar.d = leakTraceObject2.b;
                bVar.b = leakTraceObject2.e;
                bVar.e = applicationLeak.a();
                StringBuilder sb = new StringBuilder();
                sb.append("signature origin: \n");
                sb.append(applicationLeak.c().get(0).toString());
                g.b(TAG, sb.toString());
                bVar.f29643a = Integer.valueOf(applicationLeak.c().size());
                this.mLeakModel.b.add(bVar);
                for (LeakTraceReference leakTraceReference : leakTrace.b) {
                    String str2 = leakTraceReference.originObject.b;
                    String strB = leakTraceReference.b();
                    aa.b.a aVar = new aa.b.a();
                    if (strB.startsWith("[")) {
                        aVar.f29644a = "array " + str2 + ".[" + leakTraceReference.originObject.g + "]";
                    } else {
                        aVar.f29644a = str2 + Consts.DOT + strB;
                    }
                    g.a(TAG, "\t" + aVar.f29644a);
                    bVar.g.add(aVar);
                }
                aa.b.a aVar2 = new aa.b.a();
                aVar2.f29644a = leakTrace.c.b;
                bVar.f = leakTrace.c.f + "";
                bVar.g.add(aVar2);
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        aa.c cVar = this.mLeakModel.f29641a;
        if (cVar != null) {
            cVar.p = ((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000.0f) + "";
        }
        g.b(TAG, "find paths to GcRoot cost: " + ((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000.0f) + "s");
    }

    public static void startAnalysisService(Context context, String str, String str2, z zVar, UMonitorHeapResult.a aVar) {
        try {
            g.b(TAG, "startService");
            UMonitorHeapResult uMonitorHeapResult = new UMonitorHeapResult();
            uMonitorHeapResult.a(aVar);
            Intent intent = new Intent(context, (Class<?>) UMonitorService.class);
            intent.putExtra(HPROF_FILE, str);
            intent.putExtra(JSON_FILE, str2);
            intent.putExtra(ROOT_PATH, e.a().getPath());
            intent.putExtra(RESULT_RECEIVER, uMonitorHeapResult);
            File[] fileArrListFiles = new File("/proc/self/fd").listFiles();
            intent.putExtra(FD, String.valueOf(fileArrListFiles != null ? fileArrListFiles.length : 0));
            intent.putExtra(THREAD, String.valueOf(ah.e.f29649a));
            intent.putExtra(MANUFACTURE, Build.MANUFACTURER);
            intent.putExtra(SDK, String.valueOf(Build.VERSION.SDK_INT));
            intent.putExtra(MODEL, Build.MODEL);
            intent.putExtra(TIME, new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS", Locale.CHINESE).format(new Date()));
            String str3 = zVar.f29892a;
            if (str3 != null) {
                intent.putExtra(REASON, str3);
            }
            String str4 = zVar.c;
            if (str4 != null) {
                intent.putExtra(CURRENT_PAGE, str4);
            }
            String str5 = zVar.b;
            if (str5 != null) {
                intent.putExtra(USAGE_TIME, str5);
            }
            context.startService(intent);
        } catch (Throwable th) {
            g.b(TAG, "startAnalysisService", th);
        }
    }

    private a updateClassObjectCounterMap(Map<Long, a> map, long j, boolean z) {
        a aVar = map.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = new a((byte) 0);
            map.put(Long.valueOf(j), aVar);
        }
        aVar.f29639a++;
        if (z) {
            aVar.b++;
        }
        return aVar;
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra(RESULT_RECEIVER);
        try {
            String stringExtra = intent.getStringExtra(HPROF_FILE);
            String stringExtra2 = intent.getStringExtra(JSON_FILE);
            e.a(getApplicationContext(), intent.getStringExtra(ROOT_PATH));
            buildIndex(stringExtra);
            buildJson(intent);
            filterLeakingObjects();
            findPathsToGcRoot();
            if (this.mLeakModel.a()) {
                fillJsonFile(stringExtra2);
                if (resultReceiver != null) {
                    resultReceiver.send(1001, null);
                }
            } else {
                g.b(TAG, "not found leak");
                if (resultReceiver != null) {
                    resultReceiver.send(1003, null);
                }
            }
        } catch (Throwable th) {
            g.b(TAG, "onHandleIntent", th);
            if (resultReceiver != null) {
                try {
                    resultReceiver.send(1002, null);
                } catch (Throwable th2) {
                    g.b(TAG, "send result failed", th2);
                }
            }
        }
        System.exit(0);
    }
}
