package com.efs.sdk.memleaksdk.monitor.shark;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.igexin.push.g.o;
import com.zj.adlib.dv9;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u008f\u0001B%\b\u0000\u0012\u0006\u0010k\u001a\u00020j\u0012\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001\u0012\u0006\u0010p\u001a\u00020o¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\u0012H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010$\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010)\u001a\u00020(H\u0016J\u0006\u0010+\u001a\u00020\u0014J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0012H\u0016J\u001f\u00101\u001a\u00020.2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0004H\u0000¢\u0006\u0004\b/\u00100J\u001f\u00105\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00122\u0006\u0010-\u001a\u000202H\u0000¢\u0006\u0004\b3\u00104J\u001f\u00109\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010-\u001a\u000206H\u0000¢\u0006\u0004\b7\u00108J\u001f\u0010=\u001a\u00020:2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010-\u001a\u000206H\u0000¢\u0006\u0004\b;\u0010<JB\u0010E\u001a\u00028\u0000\"\b\b\u0000\u0010?*\u00020>2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010-\u001a\u00020@2\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0002\bCH\u0002¢\u0006\u0004\bE\u0010FJ\u001f\u0010J\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010-\u001a\u00020GH\u0000¢\u0006\u0004\bH\u0010IJ\u001f\u0010N\u001a\u00020K2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010-\u001a\u00020GH\u0000¢\u0006\u0004\bL\u0010MJ\u001f\u0010Q\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000fH\u0000¢\u0006\u0004\bO\u0010PJ \u0010R\u001a\u00020%2\u0006\u0010)\u001a\u00020(2\u0006\u0010-\u001a\u00020@2\u0006\u0010$\u001a\u00020\u0012H\u0002R\u0014\u0010U\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR.\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020.0V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\"0]8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u001a\u0010b\u001a\u00020a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020f0\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bm\u0010TR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010TR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020t0]8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bu\u0010_R\u0016\u0010w\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010z\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\by\u0010TR\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020{0]8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010_R!\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020>0~8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0082\u0001\u001a\u00020(8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010TR\u001c\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020%0]8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010_R\u0016\u0010\u0086\u0001\u001a\u00020(8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010TR\u001d\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010]8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010_R\u0018\u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001¨\u0006\u0090\u0001"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;", "Lcom/efs/sdk/memleaksdk/monitor/shark/CloseableHeapGraph;", "", "close", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedClass;", "indexedClass", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "classDumpFields$memleaksdk_release", "(Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedClass;)Ljava/util/List;", "classDumpFields", "", "classDumpHasReferenceFields$memleaksdk_release", "(Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedClass;)Z", "classDumpHasReferenceFields", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "classDumpStaticFields$memleaksdk_release", "classDumpStaticFields", "", "classId", "", "className$memleaksdk_release", "(J)Ljava/lang/String;", "className", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", AliyunLogCommon.SubModule.RECORD, "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldValuesReader;", "createFieldValuesReader$memleaksdk_release", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;)Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldValuesReader;", "createFieldValuesReader", "fieldRecord", "fieldName$memleaksdk_release", "(JLcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;)Ljava/lang/String;", "fieldName", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "findClassByName", "objectId", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "findObjectById", "findObjectByIdOrNull", "", "objectIndex", "findObjectByIndex", "lruCacheStats", "objectExists", "indexedObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readClassDumpRecord$memleaksdk_release", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedClass;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readClassDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;", "readInstanceDumpRecord$memleaksdk_release", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "readInstanceDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedObjectArray;", "readObjectArrayByteSize$memleaksdk_release", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedObjectArray;)I", "readObjectArrayByteSize", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readObjectArrayDumpRecord$memleaksdk_release", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedObjectArray;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readObjectArrayDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "T", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject;", "Lkotlin/Function1;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "Lkotlin/ExtensionFunctionType;", "readBlock", "readObjectRecord", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject;Lkotlin/jvm/functions/Function1;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedPrimitiveArray;", "readPrimitiveArrayByteSize$memleaksdk_release", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedPrimitiveArray;)I", "readPrimitiveArrayByteSize", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readPrimitiveArrayDumpRecord$memleaksdk_release", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedPrimitiveArray;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readPrimitiveArrayDumpRecord", "staticFieldName$memleaksdk_release", "(JLcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;)Ljava/lang/String;", "staticFieldName", "wrapIndexedObject", "getClassCount", "()I", "classCount", "", "classMap", "Ljava/util/Map;", "getClassMap", "()Ljava/util/Map;", "setClassMap", "(Ljava/util/Map;)V", "Lkotlin/sequences/Sequence;", "getClasses", "()Lkotlin/sequences/Sequence;", "classes", "Lcom/efs/sdk/memleaksdk/monitor/shark/GraphContext;", "context", "Lcom/efs/sdk/memleaksdk/monitor/shark/GraphContext;", "getContext", "()Lcom/efs/sdk/memleaksdk/monitor/shark/GraphContext;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "getGcRoots", "()Ljava/util/List;", "gcRoots", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "header", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "getIdentifierByteSize", "identifierByteSize", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;", "index", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;", "getInstanceCount", "instanceCount", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "getInstances", "instances", "javaLangObjectClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "getObjectArrayCount", "objectArrayCount", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "getObjectArrays", "objectArrays", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/LruCache;", "objectCache", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/LruCache;", "getObjectCount", "objectCount", "getObjects", "objects", "getPrimitiveArrayCount", "primitiveArrayCount", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrays", "primitiveArrays", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader;", "reader", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader;", "<init>", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HprofHeapGraph implements CloseableHeapGraph {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29765a = new a(0);
    private static int i = 3000;

    @NotNull
    private final GraphContext b;
    private final cn<Long, HprofRecord.a.AbstractC0624a> c;
    private final HeapObject.b d;

    @NotNull
    private Map<Long, HprofRecord.a.AbstractC0624a.C0625a> e;
    private final HprofHeader f;
    private final RandomAccessHprofReader g;
    private final cj h;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\nH\u0002J4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\nH\u0007J&\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\nJ&\u0010\u0014\u001a\u00020\u0015*\u00020\u00182\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph$Companion;", "", "()V", "INTERNAL_LRU_CACHE_SIZE", "", "getINTERNAL_LRU_CACHE_SIZE", "()I", "setINTERNAL_LRU_CACHE_SIZE", "(I)V", "deprecatedDefaultIndexedGcRootTypes", "", "Lkotlin/reflect/KClass;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "indexHprof", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "hprof", "Lcom/efs/sdk/memleaksdk/monitor/shark/Hprof;", "proguardMapping", "Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "indexedGcRootTypes", "openHeapGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/CloseableHeapGraph;", "Lcom/efs/sdk/memleaksdk/monitor/shark/DualSourceProvider;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "Ljava/io/File;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        @NotNull
        public final CloseableHeapGraph a(@NotNull File file, @Nullable ProguardMapping proguardMapping, @NotNull Set<? extends HprofRecordTag> set) {
            Intrinsics.checkNotNullParameter(file, "$this$openHeapGraph");
            Intrinsics.checkNotNullParameter(set, "indexedGcRootTypes");
            return a(new FileSourceProvider(file), proguardMapping, set);
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @NotNull
        public final CloseableHeapGraph a(@NotNull DualSourceProvider dualSourceProvider, @Nullable ProguardMapping proguardMapping, @NotNull Set<? extends HprofRecordTag> set) {
            Intrinsics.checkNotNullParameter(dualSourceProvider, "$this$openHeapGraph");
            Intrinsics.checkNotNullParameter(set, "indexedGcRootTypes");
            n nVarA = dualSourceProvider.a();
            try {
                HprofHeader hprofHeaderA = HprofHeader.d.a(nVarA);
                CloseableKt.closeFinally(nVarA, (Throwable) null);
                return HprofIndex.f29774a.a(dualSourceProvider, hprofHeaderA, proguardMapping, set).a();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(nVarA, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$b */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;", o.f, "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;)Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class b extends Lambda implements Function1<LongObjectPair<? extends cm.b>, HeapObject.c> {
        final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef) {
            super(1);
            this.b = intRef;
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HeapObject.c invoke(@NotNull LongObjectPair<cm.b> longObjectPair) {
            Intrinsics.checkNotNullParameter(longObjectPair, o.f);
            long j = longObjectPair.first;
            cm.b bVar = longObjectPair.second;
            HprofHeapGraph hprofHeapGraph = HprofHeapGraph.this;
            Ref.IntRef intRef = this.b;
            int i = intRef.element;
            intRef.element = i + 1;
            return new HeapObject.c(hprofHeapGraph, bVar, j, i);
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$c, reason: from Kotlin metadata */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class HprofRecordReader extends Lambda implements Function1<com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader, HprofRecord.a.AbstractC0624a.C0625a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HprofRecordReader f29767a = new HprofRecordReader();

        public HprofRecordReader() {
            super(1);
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0624a.C0625a invoke(@NotNull com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader hprofRecordReader) {
            Intrinsics.checkNotNullParameter(hprofRecordReader, "$receiver");
            return hprofRecordReader.r();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$d, reason: from Kotlin metadata and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class C1392d extends Lambda implements Function1<com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader, HprofRecord.a.AbstractC0624a.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1392d f29768a = new C1392d();

        public C1392d() {
            super(1);
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0624a.b invoke(@NotNull com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader hprofRecordReader) {
            Intrinsics.checkNotNullParameter(hprofRecordReader, "$receiver");
            return hprofRecordReader.q();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$e, reason: from Kotlin metadata and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;)I", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class C1393e extends Lambda implements Function1<com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1393e f29769a = new C1393e();

        public C1393e() {
            super(1);
        }

        public final int a(@NotNull com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader hprofRecordReader) {
            Intrinsics.checkNotNullParameter(hprofRecordReader, "$receiver");
            return hprofRecordReader.G();
        }

        public /* synthetic */ Object invoke(Object obj) {
            return Integer.valueOf(a((com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader) obj));
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$f, reason: from Kotlin metadata and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class C1394f extends Lambda implements Function1<com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader, HprofRecord.a.AbstractC0624a.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1394f f29770a = new C1394f();

        public C1394f() {
            super(1);
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0624a.c invoke(@NotNull com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader hprofRecordReader) {
            Intrinsics.checkNotNullParameter(hprofRecordReader, "$receiver");
            return hprofRecordReader.t();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$g */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "T", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class g<T> extends Lambda implements Function1<com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f29771a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Function1 function1) {
            super(1);
            this.f29771a = function1;
        }

        /* JADX WARN: Incorrect return type in method signature: (Lcom/efs/sdk/memleaksdk/monitor/internal/bb;)TT; */
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0624a invoke(@NotNull com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader hprofRecordReader) {
            Intrinsics.checkNotNullParameter(hprofRecordReader, "$receiver");
            return (HprofRecord.a.AbstractC0624a) this.f29771a.invoke(hprofRecordReader);
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$h, reason: from Kotlin metadata and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;)I", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class C1395h extends Lambda implements Function1<com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1395h f29772a = new C1395h();

        public C1395h() {
            super(1);
        }

        public final int a(@NotNull com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader hprofRecordReader) {
            Intrinsics.checkNotNullParameter(hprofRecordReader, "$receiver");
            return hprofRecordReader.G();
        }

        public /* synthetic */ Object invoke(Object obj) {
            return Integer.valueOf(a((com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader) obj));
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$i, reason: from Kotlin metadata and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class C1396i extends Lambda implements Function1<com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader, HprofRecord.a.AbstractC0624a.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1396i f29773a = new C1396i();

        public C1396i() {
            super(1);
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0624a.d invoke(@NotNull com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader hprofRecordReader) {
            Intrinsics.checkNotNullParameter(hprofRecordReader, "$receiver");
            return hprofRecordReader.s();
        }
    }

    public HprofHeapGraph(@NotNull HprofHeader hprofHeader, @NotNull RandomAccessHprofReader randomAccessHprofReader, @NotNull cj cjVar) {
        Intrinsics.checkNotNullParameter(hprofHeader, "header");
        Intrinsics.checkNotNullParameter(randomAccessHprofReader, "reader");
        Intrinsics.checkNotNullParameter(cjVar, "index");
        this.f = hprofHeader;
        this.g = randomAccessHprofReader;
        this.h = cjVar;
        this.b = new GraphContext();
        this.c = new cn<>(i);
        this.d = a("java.lang.Object");
        this.e = new LinkedHashMap();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public int a() {
        return this.f.identifierByteSize;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    @NotNull
    /* JADX INFO: renamed from: b, reason: from getter */
    public GraphContext getB() {
        return this.b;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public int c() {
        return this.h.b.c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.close();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    @NotNull
    public List<GcRoot> d() {
        return this.h.c;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    @NotNull
    public Sequence<HeapObject.c> e() {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = f();
        return SequencesKt.map(this.h.a(), new b(intRef));
    }

    public int f() {
        return this.h.f29829a.c;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    @Nullable
    public HeapObject b(long j) {
        HeapObject.b bVar = this.d;
        if (bVar != null && j == bVar.getE()) {
            return this.d;
        }
        IntObjectPair<cm> intObjectPairB = this.h.b(j);
        if (intObjectPairB != null) {
            return a(intObjectPairB.first, intObjectPairB.second, j);
        }
        return null;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    @NotNull
    public HeapObject a(long j) {
        HeapObject heapObjectB = b(j);
        if (heapObjectB != null) {
            return heapObjectB;
        }
        throw new IllegalArgumentException("Object id " + j + " not found in heap dump.");
    }

    @NotNull
    public final String d(long j) {
        String strA = this.h.a(j);
        if (this.f.version == HprofVersion.ANDROID || !StringsKt.startsWith$default(strA, '[', false, 2, (Object) null)) {
            return strA;
        }
        int iLastIndexOf$default = StringsKt.lastIndexOf$default(strA, '[', 0, false, 6, (Object) null);
        int i2 = iLastIndexOf$default + 1;
        String strRepeat = StringsKt.repeat("[]", i2);
        char cCharAt = strA.charAt(i2);
        if (cCharAt == 'F') {
            return TypedValues.Custom.S_FLOAT + strRepeat;
        }
        if (cCharAt == 'L') {
            StringBuilder sb = new StringBuilder();
            String strSubstring = strA.substring(iLastIndexOf$default + 2, strA.length() - 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(strSubstring);
            sb.append(strRepeat);
            return sb.toString();
        }
        if (cCharAt == 'S') {
            return "short" + strRepeat;
        }
        if (cCharAt == 'Z') {
            return TypedValues.Custom.S_BOOLEAN + strRepeat;
        }
        if (cCharAt == 'I') {
            return "int" + strRepeat;
        }
        if (cCharAt != 'J') {
            switch (cCharAt) {
                case 'B':
                    return "byte" + strRepeat;
                case 'C':
                    return "char" + strRepeat;
                case 'D':
                    return "double" + strRepeat;
                default:
                    throw new IllegalStateException(("Unexpected type char " + cCharAt).toString());
            }
        }
        return "long" + strRepeat;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public boolean c(long j) {
        return this.h.c(j);
    }

    public final boolean c(@NotNull cm.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "indexedClass");
        return this.h.d.c(aVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:30:0x00ad  */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x00ad, please report this as an issue */
    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    @Nullable
    public HeapObject.b a(@NotNull String str) {
        int iIndexOf$default;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "className");
        if (this.f.version != HprofVersion.ANDROID && (iIndexOf$default = StringsKt.indexOf$default(str, '[', 0, false, 6, (Object) null)) != -1) {
            int length = (str.length() - iIndexOf$default) / 2;
            String strSubstring = str.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            StringBuilder sb = new StringBuilder();
            sb.append(StringsKt.repeat("[", length));
            switch (strSubstring) {
                case "double":
                    obj = 'D';
                    break;
                case "int":
                    obj = 'I';
                    break;
                case "byte":
                    obj = 'B';
                    break;
                case "char":
                    obj = 'C';
                    break;
                case "long":
                    obj = 'J';
                    break;
                case "float":
                    obj = 'F';
                    break;
                case "short":
                    obj = 'S';
                    break;
                default:
                    obj = 'L' + strSubstring + dv9.e;
                    break;
            }
            sb.append(obj);
            str = sb.toString();
        }
        Long lA = this.h.a(str);
        if (lA == null) {
            return null;
        }
        HeapObject heapObjectA = a(lA.longValue());
        if (heapObjectA != null) {
            return (HeapObject.b) heapObjectA;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.efs.sdk.memleaksdk.monitor.shark.HeapObject.HeapClass");
    }

    @NotNull
    public final List<HprofRecord.a.AbstractC0624a.C0625a.FieldRecord> b(@NotNull cm.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "indexedClass");
        return this.h.d.b(aVar);
    }

    public final int b(long j, @NotNull cm.c cVar) {
        int iIntValue;
        int iA;
        Intrinsics.checkNotNullParameter(cVar, "indexedObject");
        HprofRecord.a.AbstractC0624a.c cVar2 = (HprofRecord.a.AbstractC0624a.c) this.c.a(Long.valueOf(j));
        if (cVar2 != null) {
            iIntValue = cVar2.f29780a.length;
            iA = a();
        } else {
            long b2 = cVar.getB() + ((long) a());
            int i2 = PrimitiveType.INT.j;
            iIntValue = ((Number) this.g.a(b2 + ((long) i2), i2, C1393e.f29769a)).intValue();
            iA = a();
        }
        return iIntValue * iA;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final int b(long j, @NotNull cm.d dVar) throws NoWhenBranchMatchedException {
        int length;
        int i2;
        Intrinsics.checkNotNullParameter(dVar, "indexedObject");
        HprofRecord.a.AbstractC0624a.d dVar2 = (HprofRecord.a.AbstractC0624a.d) this.c.a(Long.valueOf(j));
        if (dVar2 != null) {
            if (dVar2 instanceof HprofRecord.a.AbstractC0624a.d.C0627a) {
                length = ((HprofRecord.a.AbstractC0624a.d.C0627a) dVar2).f29781a.length;
                i2 = PrimitiveType.BOOLEAN.j;
            } else if (dVar2 instanceof HprofRecord.a.AbstractC0624a.d.c) {
                length = ((HprofRecord.a.AbstractC0624a.d.c) dVar2).f29783a.length;
                i2 = PrimitiveType.CHAR.j;
            } else if (dVar2 instanceof HprofRecord.a.AbstractC0624a.d.e) {
                length = ((HprofRecord.a.AbstractC0624a.d.e) dVar2).f29785a.length;
                i2 = PrimitiveType.FLOAT.j;
            } else if (dVar2 instanceof HprofRecord.a.AbstractC0624a.d.C0628d) {
                length = ((HprofRecord.a.AbstractC0624a.d.C0628d) dVar2).f29784a.length;
                i2 = PrimitiveType.DOUBLE.j;
            } else if (dVar2 instanceof HprofRecord.a.AbstractC0624a.d.b) {
                length = ((HprofRecord.a.AbstractC0624a.d.b) dVar2).f29782a.length;
                i2 = PrimitiveType.BYTE.j;
            } else if (dVar2 instanceof HprofRecord.a.AbstractC0624a.d.h) {
                length = ((HprofRecord.a.AbstractC0624a.d.h) dVar2).f29788a.length;
                i2 = PrimitiveType.SHORT.j;
            } else if (dVar2 instanceof HprofRecord.a.AbstractC0624a.d.f) {
                length = ((HprofRecord.a.AbstractC0624a.d.f) dVar2).f29786a.length;
                i2 = PrimitiveType.INT.j;
            } else if (dVar2 instanceof HprofRecord.a.AbstractC0624a.d.g) {
                length = ((HprofRecord.a.AbstractC0624a.d.g) dVar2).f29787a.length;
                i2 = PrimitiveType.LONG.j;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return length * i2;
        }
        long b2 = dVar.getB() + ((long) a());
        int i3 = PrimitiveType.INT.j;
        return ((Number) this.g.a(b2 + ((long) i3), i3, C1395h.f29772a)).intValue() * dVar.c().j;
    }

    @NotNull
    public final List<HprofRecord.a.AbstractC0624a.C0625a.StaticFieldRecord> a(@NotNull cm.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "indexedClass");
        return this.h.d.a(aVar);
    }

    @NotNull
    public final String a(long j, @NotNull HprofRecord.a.AbstractC0624a.C0625a.FieldRecord fieldRecord) {
        Intrinsics.checkNotNullParameter(fieldRecord, "fieldRecord");
        return this.h.a(j, fieldRecord.nameStringId);
    }

    @NotNull
    public final String a(long j, @NotNull HprofRecord.a.AbstractC0624a.C0625a.StaticFieldRecord staticFieldRecord) {
        Intrinsics.checkNotNullParameter(staticFieldRecord, "fieldRecord");
        return this.h.a(j, staticFieldRecord.nameStringId);
    }

    @NotNull
    public final ci a(@NotNull HprofRecord.a.AbstractC0624a.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, AliyunLogCommon.SubModule.RECORD);
        return new ci(bVar, a());
    }

    @NotNull
    public final HprofRecord.a.AbstractC0624a.c a(long j, @NotNull cm.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "indexedObject");
        return (HprofRecord.a.AbstractC0624a.c) a(j, cVar, C1394f.f29770a);
    }

    @NotNull
    public final HprofRecord.a.AbstractC0624a.d a(long j, @NotNull cm.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "indexedObject");
        return (HprofRecord.a.AbstractC0624a.d) a(j, dVar, C1396i.f29773a);
    }

    @NotNull
    public final HprofRecord.a.AbstractC0624a.C0625a a(long j, @NotNull cm.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "indexedObject");
        HprofRecord.a.AbstractC0624a.C0625a c0625a = this.e.get(Long.valueOf(j));
        if (c0625a != null) {
            return c0625a;
        }
        HprofRecord.a.AbstractC0624a.C0625a c0625a2 = (HprofRecord.a.AbstractC0624a.C0625a) a(j, aVar, HprofRecordReader.f29767a);
        this.e.put(Long.valueOf(j), c0625a2);
        return c0625a2;
    }

    @NotNull
    public final HprofRecord.a.AbstractC0624a.b a(long j, @NotNull cm.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "indexedObject");
        return (HprofRecord.a.AbstractC0624a.b) a(j, bVar, C1392d.f29768a);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final <T extends HprofRecord.a.AbstractC0624a> T a(long j, cm cmVar, Function1<? super com.efs.sdk.memleaksdk.monitor.shark.HprofRecordReader, ? extends T> function1) {
        T t = (T) this.c.a(Long.valueOf(j));
        if (t != null) {
            return t;
        }
        T t2 = (T) this.g.a(cmVar.getB(), cmVar.getC(), new g(function1));
        this.c.a(Long.valueOf(j), t2);
        return t2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final HeapObject a(int i2, cm cmVar, long j) throws NoWhenBranchMatchedException {
        if (cmVar instanceof cm.a) {
            return new HeapObject.b(this, (cm.a) cmVar, j, i2);
        }
        if (cmVar instanceof cm.b) {
            return new HeapObject.c(this, (cm.b) cmVar, j, i2);
        }
        if (cmVar instanceof cm.c) {
            return new HeapObject.d(this, (cm.c) cmVar, j, i2);
        }
        if (cmVar instanceof cm.d) {
            return new HeapObject.e(this, (cm.d) cmVar, j, i2);
        }
        throw new NoWhenBranchMatchedException();
    }
}
