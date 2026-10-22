package com.huachenjie.run.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.triver.embed.video.video.h;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.map.RouteOverlay;
import com.huachenjie.run.widget.CheckPointView;
import com.huachenjie.run.widget.MapPointPassedView;
import com.huachenjie.run.widget.MapPointView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.jj8;
import com.zj.adlib.p59;
import com.zj.adlib.r90;
import com.zj.adlib.xj7;
import com.zj.adlib.ze1;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.adapter.HCJMapAdapter;
import huachenjie.sdk.map.adapter.map.model.CaocaoBitmapDescriptor;
import huachenjie.sdk.map.adapter.map.model.CaocaoBitmapDescriptorFactory;
import huachenjie.sdk.map.adapter.map.model.CaocaoCameraUpdate;
import huachenjie.sdk.map.adapter.map.model.CaocaoCameraUpdateFactory;
import huachenjie.sdk.map.adapter.map.model.CaocaoLatLngBounds;
import huachenjie.sdk.map.adapter.map.model.CaocaoMarker;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolyline;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolylineOptions;
import huachenjie.sdk.map.amap.ABitmapDescriptor;
import huachenjie.sdk.map.amap.AMarker;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 g2\u00020\u0001:\u0001gB9\b\u0007\u0012\u0006\u0010k\u001a\u00020f\u0012\u0010\u0010r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010l\u0012\b\b\u0002\u0010s\u001a\u00020\u0011\u0012\b\b\u0002\u0010t\u001a\u00020\u0004¢\u0006\u0006\b¹\u0001\u0010º\u0001JZ\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b0\u00062\u0006\u0010\n\u001a\u00020\u00042\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r0\u000bH\u0002JG\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b0\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JU\u0010\u0017\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0015\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018JF\u0010 \u001a\u00020\u000f2\u0012\u0010\u0019\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u001c\u0010!\u001a\u00020\u00112\u0012\u0010\u0019\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\bH\u0002J2\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0002J\n\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020%H\u0002Jf\u0010,\u001a\u00020\u000f*\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b0\u00062\u0006\u0010\u0003\u001a\u00020)2 \b\u0002\u0010+\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u000f0*2\u001c\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r0\u000bH\u0002J \u0010-\u001a\u00020\u0004*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b2\u0006\u0010\u0003\u001a\u00020)H\u0002J\u0014\u0010/\u001a\u00020\u0004*\u00020)2\u0006\u0010.\u001a\u00020)H\u0002J\u0018\u00100\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0002J\u0018\u00101\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0002J*\u00102\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u0004H\u0002J*\u00103\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u00105\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\u0006\u00104\u001a\u00020\u0004H\u0002J\"\u00106\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002J2\u00107\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u0004H\u0002JB\u0010;\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\u0006\u00109\u001a\u0002082\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002J*\u0010<\u001a\u00020\u000f*\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002J\f\u0010>\u001a\u00020\u000f*\u00020=H\u0002J0\u0010B\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\u0006\u0010?\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\u0002J\u0010\u0010D\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u001eH\u0002J\b\u0010E\u001a\u00020\u000fH\u0016J\u0014\u0010H\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030Fj\u0002`GH\u0004J\u0016\u0010K\u001a\u00020\u000f2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00020IH\u0004J\u000e\u0010M\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u0011J&\u0010R\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020\u0011J\u001a\u0010S\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010L\u001a\u00020\u0011H\u0016J\"\u0010W\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010U\u001a\u00020T2\b\b\u0002\u0010V\u001a\u00020\u0004H\u0007J\u0006\u0010X\u001a\u00020\u000fJ \u0010[\u001a\u00020\u000f2\u0018\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020Y0IJ.\u0010\\\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007J.\u0010]\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007J6\u0010^\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007J$\u0010_\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007J\u001e\u0010a\u001a\u00020\u000f2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010I2\u0006\u0010`\u001a\u00020\u0011JT\u0010e\u001a6\u0012\f\u0012\n d*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n d*\u0004\u0018\u00010\u00010\u0001\u0018\u0001 d*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010c¨\u0006\u00010c¨\u0006\u00012\u0016\u0010b\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010Fj\u0004\u0018\u0001`GH\u0004R\u001a\u0010k\u001a\u00020f8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR,\u0010r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010l8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bg\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010\"R\u0014\u0010t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010DR\u001a\u0010y\u001a\u00020u8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bg\u0010v\u001a\u0004\bw\u0010xR\u001a\u0010~\u001a\u00020z8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bg\u0010{\u001a\u0004\b|\u0010}R2\u0010\u0081\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c0\u007f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bg\u0010\u0080\u0001R)\u0010\u0084\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b0\u0082\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bg\u0010\u0083\u0001R*\u0010\u0086\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b0\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R*\u0010\u0088\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b0\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0083\u0001R*\u0010\u008a\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b0\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0083\u0001R)\u0010\u008d\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030cj\u0003`\u008b\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bg\u0010\u008c\u0001R8\u0010\u0093\u0001\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\bg\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R9\u0010\u0096\u0001\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u008e\u0001\u001a\u0006\b\u0094\u0001\u0010\u0090\u0001\"\u0006\b\u0095\u0001\u0010\u0092\u0001R*\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\bg\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R+\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0097\u0001\u001a\u0006\b\u009d\u0001\u0010\u0099\u0001\"\u0006\b\u009e\u0001\u0010\u009b\u0001R1\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010I8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u008c\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R9\u0010ª\u0001\u001a\u0013\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010cj\u0005\u0018\u0001`\u008b\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\bg\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R\u001e\u0010®\u0001\u001a\u00020T8\u0014X\u0094D¢\u0006\u000f\n\u0005\bg\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R\u001e\u0010²\u0001\u001a\u00020\u001e8\u0014X\u0094D¢\u0006\u000f\n\u0005\bg\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001RK\u0010¶\u0001\u001a6\u0012\f\u0012\n d*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n d*\u0004\u0018\u00010\u00010\u0001 d*\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010³\u0001¨\u0006\u00010³\u0001¨\u0006\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010µ\u0001R0\u0010¸\u0001\u001a\u001b\u0012\u0017\u0012\u0015\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007j\u0002`\b0\u0082\u00010I8BX\u0082\u0004¢\u0006\b\u001a\u0006\b·\u0001\u0010¡\u0001¨\u0006»\u0001"}, d2 = {"Lcom/huachenjie/run/map/RouteOverlay;", "", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", SQLiteMTAHelper.TABLE_POINT, "", "isPassed", "", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoMarker;", "Lcom/huachenjie/run/map/OverlayMarker;", "into", "nfcEnable", "Lkotlin/Function0;", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoBitmapDescriptor;", "Lcom/huachenjie/run/map/OverlayIcon;", "pendingIcon", "", "C", "", "sort", "v", "(Lhuachenjie/sdk/map/lib_base/HCJLatLng;Ljava/util/List;Ljava/lang/Integer;Z)V", RemoteMessageConst.Notification.ICON, "visible", "q", "(Lhuachenjie/sdk/map/lib_base/HCJLatLng;Lhuachenjie/sdk/map/adapter/map/model/CaocaoBitmapDescriptor;ZLjava/lang/Integer;)Lhuachenjie/sdk/map/adapter/map/model/CaocaoMarker;", RequestParameters.MARKER, "Ljava/util/ArrayList;", "Lcom/amap/api/maps/model/BitmapDescriptor;", "Lkotlin/collections/ArrayList;", "frames", "", "name", "c0", "W", "I", "isCurrentTarget", "V", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoLatLngBounds$Builder;", "j0", "builder", "U", "Lcom/huachenjie/common/bean/TargetPoints;", "Lkotlin/Function1;", "extra", "d0", "k0", "other", "l0", "m0", "J", "i0", "Y", "isPass", "K", "a0", "T", "Lcom/huachenjie/run/widget/MapPointView;", "view", "text", "R", "G", "Landroid/view/View;", "X", ze1.k, "widthDp", "heightDp", "Q", "color", "Z", "h0", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolylineOptions;", "Lcom/huachenjie/run/map/OverlayPolylineOptions;", "newRoutePolylineOptions", "", "points", "setRoute", "padding", "L", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "M", "N", "", "zoom", "animate", "o0", "B", "Lkotlin/Pair;", GoodsSpecificationPreviewActivity.z, t.d, j.o, "t", j.b, "E", "nextIndex", "f0", "options", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolyline;", "kotlin.jvm.PlatformType", "addPolyline", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lhuachenjie/sdk/map/adapter/map/HCJMap;", "Lhuachenjie/sdk/map/adapter/map/HCJMap;", "getMap", "()Lhuachenjie/sdk/map/adapter/map/HCJMap;", "setMap", "(Lhuachenjie/sdk/map/adapter/map/HCJMap;)V", "map", "clockMode", "showPassedIcon", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "getMapAdapter", "()Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "mapAdapter", "Landroid/os/Handler;", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "bounceFrameCache", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "requiredMarkers", "b", "optionalMarkers", "c", "inOrderMarkers", "d", "faceMarkers", "Lcom/huachenjie/run/map/OverlayPolyline;", "Ljava/util/List;", "polylines", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoMarker;", "getStartMarker", "()Lhuachenjie/sdk/map/adapter/map/model/CaocaoMarker;", "setStartMarker", "(Lhuachenjie/sdk/map/adapter/map/model/CaocaoMarker;)V", "startMarker", "getEndMarker", "setEndMarker", "endMarker", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "getStartPoint", "()Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "setStartPoint", "(Lhuachenjie/sdk/map/lib_base/HCJLatLng;)V", "startPoint", "getEndPoint", "setEndPoint", "endPoint", "getRoutePoints", "()Ljava/util/List;", "setRoutePoints", "(Ljava/util/List;)V", "routePoints", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolyline;", "getRoutePolyline", "()Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolyline;", "setRoutePolyline", "(Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolyline;)V", "routePolyline", "F", "getRouteWidthDp", "()F", "routeWidthDp", "Ljava/lang/String;", "getRouteColorHex", "()Ljava/lang/String;", "routeColorHex", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoCameraUpdateFactory;", "P", "()Lhuachenjie/sdk/map/adapter/map/model/CaocaoCameraUpdateFactory;", h.d, "O", "allMarkers", "<init>", "(Landroid/content/Context;Lhuachenjie/sdk/map/adapter/map/HCJMap;IZ)V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRouteOverlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouteOverlay.kt\ncom/huachenjie/run/map/RouteOverlay\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,492:1\n1855#2:493\n1855#2,2:494\n1856#2:496\n1855#2,2:497\n288#2,2:500\n1855#2,2:502\n1855#2,2:504\n1855#2,2:506\n1864#2,3:508\n1855#2,2:511\n1#3:499\n*S KotlinDebug\n*F\n+ 1 RouteOverlay.kt\ncom/huachenjie/run/map/RouteOverlay\n*L\n90#1:493\n91#1:494,2\n90#1:496\n94#1:497,2\n218#1:500,2\n361#1:502,2\n368#1:504,2\n376#1:506,2\n153#1:508,3\n233#1:511,2\n*E\n"})
public class RouteOverlay {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final Set<Integer> f12334a = SetsKt.setOf(new Integer[]{2, 3});
    public static final float b = 5.0f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f12335b = 17;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    public static final String f12336b = "inOrderSort";
    public static final float c = 130.0f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int f12337c = 18;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    public static final String f12338c = "#650AEC";
    public static final float d = 172.0f;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int f12339d = 10;
    public static final int e = 12;
    public static final int f = 56;
    public static final int g = 36;
    public static final int h = 56;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final float routeWidthDp;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final int clockMode;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Context context;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Handler mainHandler;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJMap<?, ?> map;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final HCJMapAdapter mapAdapter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CaocaoMarker<?, ?> startMarker;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CaocaoPolyline<?, ?> routePolyline;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJLatLng startPoint;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final String routeColorHex;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<CaocaoPolyline<?, ?>> polylines;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ConcurrentHashMap<String, ArrayList<BitmapDescriptor>> bounceFrameCache;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final CopyOnWriteArrayList<CaocaoMarker<?, ?>> requiredMarkers;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final boolean showPassedIcon;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CaocaoMarker<?, ?> endMarker;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJLatLng endPoint;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public List<? extends HCJLatLng> routePoints;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final CopyOnWriteArrayList<CaocaoMarker<?, ?>> optionalMarkers;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final CopyOnWriteArrayList<CaocaoMarker<?, ?>> inOrderMarkers;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final CopyOnWriteArrayList<CaocaoMarker<?, ?>> faceMarkers;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RouteOverlay(@NotNull Context context, @Nullable HCJMap<?, ?> hCJMap) {
        this(context, hCJMap, 0, false, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RouteOverlay(@NotNull Context context, @Nullable HCJMap<?, ?> hCJMap, int i) {
        this(context, hCJMap, i, false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmOverloads
    public RouteOverlay(@NotNull Context context, @Nullable HCJMap<?, ?> hCJMap, int i, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.map = hCJMap;
        this.clockMode = i;
        this.showPassedIcon = z;
        HCJMapAdapter hCJMapEntry = HCJMapEntry.getInstance();
        Intrinsics.checkNotNullExpressionValue(hCJMapEntry, "getInstance()");
        this.mapAdapter = hCJMapEntry;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.bounceFrameCache = new ConcurrentHashMap<>();
        this.requiredMarkers = new CopyOnWriteArrayList<>();
        this.optionalMarkers = new CopyOnWriteArrayList<>();
        this.inOrderMarkers = new CopyOnWriteArrayList<>();
        this.faceMarkers = new CopyOnWriteArrayList<>();
        this.polylines = new ArrayList();
        this.routeWidthDp = 5.0f;
        this.routeColorHex = f12338c;
    }

    public static /* synthetic */ void A(RouteOverlay routeOverlay, HCJLatLng hCJLatLng, boolean z, String str, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRequiredMarker");
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        routeOverlay.z(hCJLatLng, z, str, z2);
    }

    public static /* synthetic */ void F(RouteOverlay routeOverlay, int i, String str, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateNextPoint");
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        routeOverlay.E(i, str, z);
    }

    public static /* synthetic */ void H(RouteOverlay routeOverlay, MapPointView mapPointView, String str, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bind");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        routeOverlay.G(mapPointView, str, str2, z);
    }

    public static /* synthetic */ CaocaoBitmapDescriptor S(RouteOverlay routeOverlay, MapPointView mapPointView, String str, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: iconFromView");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return routeOverlay.R(mapPointView, str, str2, z);
    }

    public static /* synthetic */ CaocaoBitmapDescriptor b0(RouteOverlay routeOverlay, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: passedIcon");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return routeOverlay.a0(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e0(RouteOverlay routeOverlay, List list, TargetPoints targetPoints, Function1 function1, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refresh");
        }
        if ((i & 2) != 0) {
            function1 = new Function1<CaocaoMarker<?, ?>, Unit>() { // from class: com.huachenjie.run.map.RouteOverlay$refresh$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((CaocaoMarker<?, ?>) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull CaocaoMarker<?, ?> caocaoMarker) {
                    Intrinsics.checkNotNullParameter(caocaoMarker, o.f);
                }
            };
        }
        routeOverlay.d0(list, targetPoints, function1, function0);
    }

    public static final void g0(List list, int i, final RouteOverlay routeOverlay) {
        Intrinsics.checkNotNullParameter(routeOverlay, "this$0");
        final TargetPoints targetPoints = (TargetPoints) CollectionsKt.getOrNull(list, i);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final TargetPoints targetPoints2 = (TargetPoints) it.next();
            e0(routeOverlay, routeOverlay.optionalMarkers, targetPoints2, null, new Function0<CaocaoBitmapDescriptor<?, ?>>() { // from class: com.huachenjie.run.map.RouteOverlay$refreshCheckPoints$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Nullable
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final CaocaoBitmapDescriptor<?, ?> m628invoke() {
                    return targetPoints2.getPassStatus() ? routeOverlay.a0(targetPoints2.getNfcEnable()) : routeOverlay.Y(targetPoints2.getSimpleName(), targetPoints2.getNfcEnable());
                }
            }, 2, null);
            e0(routeOverlay, routeOverlay.requiredMarkers, targetPoints2, null, new Function0<CaocaoBitmapDescriptor<?, ?>>() { // from class: com.huachenjie.run.map.RouteOverlay$refreshCheckPoints$1$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Nullable
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final CaocaoBitmapDescriptor<?, ?> m629invoke() {
                    return targetPoints2.getPassStatus() ? routeOverlay.a0(targetPoints2.getNfcEnable()) : routeOverlay.i0(targetPoints2.getSimpleName(), targetPoints2.getNfcEnable());
                }
            }, 2, null);
            routeOverlay.d0(routeOverlay.inOrderMarkers, targetPoints2, new Function1<CaocaoMarker<?, ?>, Unit>() { // from class: com.huachenjie.run.map.RouteOverlay$refreshCheckPoints$1$1$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CaocaoMarker<?, ?>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull CaocaoMarker<?, ?> caocaoMarker) {
                    Intrinsics.checkNotNullParameter(caocaoMarker, RequestParameters.MARKER);
                    RouteOverlay routeOverlay2 = this.this$0;
                    boolean passStatus = targetPoints2.getPassStatus();
                    TargetPoints targetPoints3 = targetPoints;
                    caocaoMarker.setVisible(routeOverlay2.V(passStatus, targetPoints3 != null && this.this$0.k0(caocaoMarker, targetPoints3)));
                }
            }, new Function0<CaocaoBitmapDescriptor<?, ?>>() { // from class: com.huachenjie.run.map.RouteOverlay$refreshCheckPoints$1$1$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Nullable
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final CaocaoBitmapDescriptor<?, ?> m630invoke() {
                    if (targetPoints2.getPassStatus() && routeOverlay.showPassedIcon) {
                        return routeOverlay.a0(targetPoints2.getNfcEnable());
                    }
                    TargetPoints targetPoints3 = targetPoints;
                    if (targetPoints3 == null || !routeOverlay.l0(targetPoints2, targetPoints3)) {
                        return routeOverlay.T(targetPoints2.getSort(), targetPoints2.getSimpleName(), targetPoints2.getNfcEnable());
                    }
                    return null;
                }
            });
        }
    }

    public static final void m(List list, RouteOverlay routeOverlay) {
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(routeOverlay, "this$0");
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            boolean zBooleanValue = ((Boolean) pair.component1()).booleanValue();
            HCJLatLng hCJLatLng = (HCJLatLng) pair.component2();
            CaocaoBitmapDescriptor<?, ?> caocaoBitmapDescriptorK = routeOverlay.K(zBooleanValue);
            if (caocaoBitmapDescriptorK != null) {
                if (i < routeOverlay.faceMarkers.size()) {
                    CaocaoMarker<?, ?> caocaoMarker = routeOverlay.faceMarkers.get(i);
                    caocaoMarker.setIcon(caocaoBitmapDescriptorK);
                    caocaoMarker.setPosition(hCJLatLng);
                } else {
                    CaocaoMarker<?, ?> caocaoMarkerR = r(routeOverlay, hCJLatLng, caocaoBitmapDescriptorK, false, null, 12, null);
                    if (caocaoMarkerR != null) {
                        routeOverlay.faceMarkers.add(caocaoMarkerR);
                    }
                }
            }
            i = i2;
        }
    }

    public static /* synthetic */ void p(RouteOverlay routeOverlay, HCJLatLng hCJLatLng, boolean z, int i, String str, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addInOrderMarker");
        }
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        routeOverlay.o(hCJLatLng, z, i, str, z2);
    }

    public static /* synthetic */ void p0(RouteOverlay routeOverlay, HCJLatLng hCJLatLng, float f2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: zoomToPoint");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        routeOverlay.o0(hCJLatLng, f2, z);
    }

    public static /* synthetic */ CaocaoMarker r(RouteOverlay routeOverlay, HCJLatLng hCJLatLng, CaocaoBitmapDescriptor caocaoBitmapDescriptor, boolean z, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMarker");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        return routeOverlay.q(hCJLatLng, caocaoBitmapDescriptor, z, num);
    }

    public static /* synthetic */ void u(RouteOverlay routeOverlay, HCJLatLng hCJLatLng, boolean z, String str, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOptionalMarker");
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        routeOverlay.t(hCJLatLng, z, str, z2);
    }

    public static /* synthetic */ void w(RouteOverlay routeOverlay, HCJLatLng hCJLatLng, List list, Integer num, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPassedMarker");
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        routeOverlay.v(hCJLatLng, list, num, z);
    }

    public static final void x(RouteOverlay routeOverlay, HCJLatLng hCJLatLng, boolean z, Integer num, List list) {
        Intrinsics.checkNotNullParameter(routeOverlay, "this$0");
        Intrinsics.checkNotNullParameter(hCJLatLng, "$point");
        Intrinsics.checkNotNullParameter(list, "$into");
        CaocaoMarker caocaoMarkerR = r(routeOverlay, hCJLatLng, routeOverlay.a0(z), false, num, 4, null);
        if (caocaoMarkerR != null) {
            list.add(caocaoMarkerR);
        }
    }

    public final void B() {
        CaocaoBitmapDescriptor<?, ?> caocaoBitmapDescriptorJ;
        CaocaoBitmapDescriptor<?, ?> caocaoBitmapDescriptorM0;
        HCJLatLng hCJLatLng = this.startPoint;
        if (hCJLatLng != null && (caocaoBitmapDescriptorM0 = m0()) != null) {
            this.startMarker = r(this, hCJLatLng, caocaoBitmapDescriptorM0, false, null, 12, null);
        }
        HCJLatLng hCJLatLng2 = this.endPoint;
        if (hCJLatLng2 == null || (caocaoBitmapDescriptorJ = J()) == null) {
            return;
        }
        this.endMarker = r(this, hCJLatLng2, caocaoBitmapDescriptorJ, false, null, 12, null);
    }

    public final void C(HCJLatLng point, boolean isPassed, List<CaocaoMarker<?, ?>> into, boolean nfcEnable, Function0<? extends CaocaoBitmapDescriptor<?, ?>> pendingIcon) {
        if (point == null) {
            return;
        }
        if (isPassed) {
            w(this, point, into, null, nfcEnable, 4, null);
            return;
        }
        CaocaoMarker<?, ?> caocaoMarkerR = r(this, point, (CaocaoBitmapDescriptor) pendingIcon.invoke(), false, null, 12, null);
        if (caocaoMarkerR != null) {
            into.add(caocaoMarkerR);
        }
    }

    @JvmOverloads
    public final void D(int i, @Nullable String str) {
        F(this, i, str, false, 4, null);
    }

    @JvmOverloads
    public final void E(int sort, @Nullable String name, boolean nfcEnable) {
        ArrayList<BitmapDescriptor> arrayList;
        Object next;
        Object obj;
        CaocaoMarker<?, ?> caocaoMarker;
        if (f12334a.contains(Integer.valueOf(this.clockMode))) {
            Iterator<T> it = this.inOrderMarkers.iterator();
            do {
                arrayList = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    caocaoMarker = (CaocaoMarker) next;
                    Intrinsics.checkNotNullExpressionValue(caocaoMarker, o.f);
                }
            } while (!(W(caocaoMarker) == sort));
            CaocaoMarker<?, ?> caocaoMarker2 = (CaocaoMarker) next;
            if (caocaoMarker2 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(sort);
            sb.append('|');
            sb.append(name == null ? "" : name);
            sb.append('|');
            sb.append(nfcEnable);
            String string = sb.toString();
            ArrayList<BitmapDescriptor> arrayList2 = this.bounceFrameCache.get(string);
            if (arrayList2 == null) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.constructor-impl(I(sort, name, nfcEnable));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                ArrayList<BitmapDescriptor> arrayList3 = (ArrayList) obj;
                if (arrayList3 != null) {
                    if (!(arrayList3.size() == 10)) {
                        arrayList3 = null;
                    }
                    if (arrayList3 != null) {
                        this.bounceFrameCache.put(string, arrayList3);
                        arrayList = arrayList3;
                    }
                }
                if (arrayList == null) {
                    return;
                } else {
                    arrayList2 = arrayList;
                }
            }
            c0(caocaoMarker2, arrayList2, name, nfcEnable);
        }
    }

    public final void G(MapPointView mapPointView, String str, String str2, boolean z) {
        if (str != null) {
            mapPointView.setText(str);
        }
        if (str2 != null) {
            mapPointView.setName(str2);
        }
        mapPointView.showNFC(z);
    }

    public final ArrayList<BitmapDescriptor> I(int sort, String name, boolean nfcEnable) {
        BitmapDescriptor real;
        MapPointView mapPointView = new MapPointView(this.context, null, 0, 6, null);
        G(mapPointView, String.valueOf(sort), name, nfcEnable);
        int iA = jj8.a(130.0f);
        int iA2 = jj8.a(172.0f);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iA, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iA2, 1073741824);
        CaocaoBitmapDescriptorFactory caocaoBitmapDescriptorFactoryCreateBitmapDescriptorFactoryOption = this.mapAdapter.createBitmapDescriptorFactoryOption();
        ArrayList<BitmapDescriptor> arrayList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            mapPointView.setGuideFrame(i);
            mapPointView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            mapPointView.layout(0, 0, iA, iA2);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, iA2, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(w, h, Bitmap.Config.ARGB_8888)");
            mapPointView.draw(new Canvas(bitmapCreateBitmap));
            ABitmapDescriptor aBitmapDescriptorFromBitmap = caocaoBitmapDescriptorFactoryCreateBitmapDescriptorFactoryOption.fromBitmap(bitmapCreateBitmap);
            ABitmapDescriptor aBitmapDescriptor = aBitmapDescriptorFromBitmap instanceof ABitmapDescriptor ? aBitmapDescriptorFromBitmap : null;
            if (aBitmapDescriptor != null && (real = aBitmapDescriptor.getReal()) != null) {
                arrayList.add(real);
            }
        }
        return arrayList;
    }

    public final CaocaoBitmapDescriptor<?, ?> J() {
        return Q(Integer.valueOf(R.drawable.run_ic_end_point), 36, 36);
    }

    public final CaocaoBitmapDescriptor<?, ?> K(boolean isPass) {
        return Q(Integer.valueOf(isPass ? R.drawable.run_ic_run_face_pass : R.drawable.run_ic_run_face), 56, 56);
    }

    public final void L(int padding) {
        HCJMap<?, ?> hCJMap;
        CaocaoLatLngBounds.Builder builderJ0 = j0();
        CaocaoLatLngBounds caocaoLatLngBoundsBuild = builderJ0 != null ? builderJ0.build() : null;
        if (caocaoLatLngBoundsBuild == null || (hCJMap = this.map) == null) {
            return;
        }
        hCJMap.moveCamera(P().newLatLngBounds(caocaoLatLngBoundsBuild, padding));
    }

    public final void M(int paddingLeft, int paddingRight, int paddingTop, int paddingBottom) {
        HCJMap<?, ?> hCJMap;
        CaocaoLatLngBounds.Builder builderJ0 = j0();
        if (builderJ0 != null) {
            U(builderJ0);
            CaocaoLatLngBounds caocaoLatLngBoundsBuild = builderJ0.build();
            if (caocaoLatLngBoundsBuild == null || (hCJMap = this.map) == null) {
                return;
            }
            hCJMap.animateCamera(P().newLatLngBoundsRect(caocaoLatLngBoundsBuild, paddingLeft, paddingRight, paddingTop, paddingBottom));
        }
    }

    public void N(@Nullable HCJLatLng point, int padding) {
        HCJMap<?, ?> hCJMap;
        if (point != null) {
            if (!xj7.a(point)) {
                point = null;
            }
            if (point == null) {
                return;
            }
            CaocaoLatLngBounds.Builder builderCreateLatLngBoundsBuilder = this.mapAdapter.createLatLngBoundsBuilder();
            U(builderCreateLatLngBoundsBuilder);
            builderCreateLatLngBoundsBuilder.include(point);
            CaocaoLatLngBounds caocaoLatLngBoundsBuild = builderCreateLatLngBoundsBuilder.build();
            if (caocaoLatLngBoundsBuild == null || (hCJMap = this.map) == null) {
                return;
            }
            hCJMap.animateCamera(P().newLatLngBounds(caocaoLatLngBoundsBuild, padding));
        }
    }

    public final List<CopyOnWriteArrayList<CaocaoMarker<?, ?>>> O() {
        return CollectionsKt.listOf(new CopyOnWriteArrayList[]{this.faceMarkers, this.requiredMarkers, this.optionalMarkers, this.inOrderMarkers});
    }

    public final CaocaoCameraUpdateFactory P() {
        return this.mapAdapter.createCameraUpdateFactoryOption();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CaocaoBitmapDescriptor<?, ?> Q(Object model, int widthDp, int heightDp) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(this.mapAdapter.createBitmapDescriptorFactoryOption().fromBitmap((Bitmap) Glide.with(this.context).asBitmap().load(model).diskCacheStrategy(DiskCacheStrategy.ALL).submit(jj8.a(widthDp), jj8.a(heightDp)).get()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (CaocaoBitmapDescriptor) obj;
    }

    public final CaocaoBitmapDescriptor<?, ?> R(MapPointView view, String text, String name, boolean nfcEnable) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            G(view, text, name, nfcEnable);
            X(view);
            obj = Result.constructor-impl(this.mapAdapter.createBitmapDescriptorFactoryOption().fromView(view));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (CaocaoBitmapDescriptor) obj;
    }

    public final CaocaoBitmapDescriptor<?, ?> T(int sort, String name, boolean nfcEnable) {
        return R(new MapPointView(this.context, null, 0, 6, null), String.valueOf(sort), name, nfcEnable);
    }

    public final void U(CaocaoLatLngBounds.Builder builder) {
        Iterator it = CollectionsKt.flatten(CollectionsKt.listOf(new CopyOnWriteArrayList[]{this.requiredMarkers, this.optionalMarkers, this.inOrderMarkers})).iterator();
        while (it.hasNext()) {
            HCJLatLng position = ((CaocaoMarker) it.next()).getPosition();
            if (position != null) {
                Intrinsics.checkNotNullExpressionValue(position, "position");
                builder.include(position);
            }
        }
    }

    public final boolean V(boolean isPassed, boolean isCurrentTarget) {
        if (!isPassed) {
            int i = this.clockMode;
            if (i == 2) {
                return isCurrentTarget;
            }
            if (i != 3) {
                return false;
            }
        }
        return true;
    }

    public final int W(CaocaoMarker<?, ?> marker) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Object extra = marker.getExtra(f12336b);
            Intrinsics.checkNotNull(extra, "null cannot be cast to non-null type kotlin.Int");
            obj = Result.constructor-impl(Integer.valueOf(((Integer) extra).intValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = 0;
        }
        return ((Number) obj).intValue();
    }

    public final void X(View view) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public final CaocaoBitmapDescriptor<?, ?> Y(String name, boolean nfcEnable) {
        CheckPointView checkPointView = new CheckPointView(this.context, null, 0, 6, null);
        checkPointView.setIcon(R.drawable.run_ic_optional_point);
        return S(this, checkPointView, null, name, nfcEnable, 2, null);
    }

    public final int Z(String color) {
        Object objValueOf;
        try {
            Result.Companion companion = Result.Companion;
            objValueOf = Result.constructor-impl(Integer.valueOf(Color.parseColor(color)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objValueOf = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(objValueOf);
        if (th2 != null) {
            th2.printStackTrace();
            objValueOf = Integer.valueOf(Color.parseColor(f12338c));
        }
        return ((Number) objValueOf).intValue();
    }

    public final CaocaoBitmapDescriptor<?, ?> a0(boolean nfcEnable) {
        Object obj;
        CommonConfig commonConfigG = r90.g();
        String schoolIconImg = commonConfigG != null ? commonConfigG.getSchoolIconImg() : null;
        if (!(schoolIconImg == null || schoolIconImg.length() == 0)) {
            return Q(schoolIconImg, 56, 56);
        }
        try {
            Result.Companion companion = Result.Companion;
            MapPointPassedView mapPointPassedView = new MapPointPassedView(this.context, null, 0, 6, null);
            mapPointPassedView.showNFC(nfcEnable);
            X(mapPointPassedView);
            obj = Result.constructor-impl(this.mapAdapter.createBitmapDescriptorFactoryOption().fromView(mapPointPassedView));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        return (CaocaoBitmapDescriptor) (Result.isFailure-impl(obj) ? null : obj);
    }

    @Nullable
    public final CaocaoPolyline addPolyline(@Nullable CaocaoPolylineOptions<?, ?> options) {
        HCJMap<?, ?> hCJMap;
        CaocaoPolyline<?, ?> caocaoPolylineAddPolyline;
        if (options == null || (hCJMap = this.map) == null || (caocaoPolylineAddPolyline = hCJMap.addPolyline(options)) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(caocaoPolylineAddPolyline, "addPolyline(it)");
        this.polylines.add(caocaoPolylineAddPolyline);
        return caocaoPolylineAddPolyline;
    }

    public final void c0(CaocaoMarker<?, ?> marker, ArrayList<BitmapDescriptor> frames, String name, boolean nfcEnable) {
        AMarker aMarker = marker instanceof AMarker ? (AMarker) marker : null;
        Marker real = aMarker != null ? aMarker.getReal() : null;
        if (real == null) {
            marker.setIcon(T(W(marker), name, nfcEnable));
            return;
        }
        MarkerOptions markerOptionsIcons = real.getOptions().period(12).icons(frames);
        real.setMarkerOptions(markerOptionsIcons);
        real.setMarkerOptions(markerOptionsIcons.m158clone());
    }

    public final void d0(List<CaocaoMarker<?, ?>> list, TargetPoints targetPoints, Function1<? super CaocaoMarker<?, ?>, Unit> function1, Function0<? extends CaocaoBitmapDescriptor<?, ?>> function0) {
        for (CaocaoMarker<?, ?> caocaoMarker : list) {
            if (k0(caocaoMarker, targetPoints)) {
                CaocaoBitmapDescriptor caocaoBitmapDescriptor = (CaocaoBitmapDescriptor) function0.invoke();
                if (caocaoBitmapDescriptor != null) {
                    caocaoMarker.setIcon(caocaoBitmapDescriptor);
                }
                function1.invoke(caocaoMarker);
            }
        }
    }

    public final void f0(@Nullable final List<TargetPoints> points, final int nextIndex) {
        List<TargetPoints> list = points;
        if (list == null || list.isEmpty()) {
            return;
        }
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.vj7
            @Override // java.lang.Runnable
            public final void run() {
                RouteOverlay.g0(points, nextIndex, this);
            }
        });
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final CaocaoMarker<?, ?> getEndMarker() {
        return this.endMarker;
    }

    @Nullable
    public final HCJLatLng getEndPoint() {
        return this.endPoint;
    }

    @NotNull
    public final Handler getMainHandler() {
        return this.mainHandler;
    }

    @Nullable
    public final HCJMap<?, ?> getMap() {
        return this.map;
    }

    @NotNull
    public final HCJMapAdapter getMapAdapter() {
        return this.mapAdapter;
    }

    @NotNull
    public String getRouteColorHex() {
        return this.routeColorHex;
    }

    @Nullable
    public final List<HCJLatLng> getRoutePoints() {
        return this.routePoints;
    }

    @Nullable
    public final CaocaoPolyline<?, ?> getRoutePolyline() {
        return this.routePolyline;
    }

    public float getRouteWidthDp() {
        return this.routeWidthDp;
    }

    @Nullable
    public final CaocaoMarker<?, ?> getStartMarker() {
        return this.startMarker;
    }

    @Nullable
    public final HCJLatLng getStartPoint() {
        return this.startPoint;
    }

    public void h0() {
        CaocaoMarker<?, ?> caocaoMarker = this.startMarker;
        if (caocaoMarker != null) {
            caocaoMarker.remove();
        }
        CaocaoMarker<?, ?> caocaoMarker2 = this.endMarker;
        if (caocaoMarker2 != null) {
            caocaoMarker2.remove();
        }
        this.startMarker = null;
        this.endMarker = null;
        Iterator<T> it = O().iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) it.next();
            Iterator it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                ((CaocaoMarker) it2.next()).remove();
            }
            copyOnWriteArrayList.clear();
        }
        Iterator<T> it3 = this.polylines.iterator();
        while (it3.hasNext()) {
            ((CaocaoPolyline) it3.next()).remove();
        }
        this.polylines.clear();
        this.routePolyline = null;
        this.bounceFrameCache.clear();
        this.mainHandler.removeCallbacksAndMessages(null);
    }

    public final CaocaoBitmapDescriptor<?, ?> i0(String name, boolean nfcEnable) {
        CheckPointView checkPointView = new CheckPointView(this.context, null, 0, 6, null);
        checkPointView.setIcon(R.drawable.run_ic_required_point);
        return S(this, checkPointView, null, name, nfcEnable, 2, null);
    }

    public final CaocaoLatLngBounds.Builder j0() {
        List<? extends HCJLatLng> list = this.routePoints;
        CaocaoLatLngBounds.Builder builderCreateLatLngBoundsBuilder = null;
        if (list != null) {
            if (!(!list.isEmpty())) {
                list = null;
            }
            if (list != null) {
                builderCreateLatLngBoundsBuilder = this.mapAdapter.createLatLngBoundsBuilder();
                HCJLatLng hCJLatLng = this.startPoint;
                if (hCJLatLng != null) {
                    Intrinsics.checkNotNullExpressionValue(builderCreateLatLngBoundsBuilder, "routeBoundsBuilder$lambda$38");
                    builderCreateLatLngBoundsBuilder.include(hCJLatLng);
                }
                HCJLatLng hCJLatLng2 = this.endPoint;
                if (hCJLatLng2 != null) {
                    Intrinsics.checkNotNullExpressionValue(builderCreateLatLngBoundsBuilder, "routeBoundsBuilder$lambda$38");
                    builderCreateLatLngBoundsBuilder.include(hCJLatLng2);
                }
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    builderCreateLatLngBoundsBuilder.include((HCJLatLng) it.next());
                }
            }
        }
        return builderCreateLatLngBoundsBuilder;
    }

    public final boolean k0(CaocaoMarker<?, ?> caocaoMarker, TargetPoints targetPoints) {
        HCJLatLng position = caocaoMarker.getPosition();
        if (position != null) {
            return (Double.doubleToLongBits(position.lat) > Double.doubleToLongBits(targetPoints.getLat()) ? 1 : (Double.doubleToLongBits(position.lat) == Double.doubleToLongBits(targetPoints.getLat()) ? 0 : -1)) == 0 && (Double.doubleToLongBits(position.lng) > Double.doubleToLongBits(targetPoints.getLng()) ? 1 : (Double.doubleToLongBits(position.lng) == Double.doubleToLongBits(targetPoints.getLng()) ? 0 : -1)) == 0;
        }
        return false;
    }

    public final void l(@NotNull final List<? extends Pair<Boolean, ? extends HCJLatLng>> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.uj7
            @Override // java.lang.Runnable
            public final void run() {
                RouteOverlay.m(list, this);
            }
        });
    }

    public final boolean l0(TargetPoints targetPoints, TargetPoints targetPoints2) {
        return Double.doubleToLongBits(targetPoints.getLat()) == Double.doubleToLongBits(targetPoints2.getLat()) && Double.doubleToLongBits(targetPoints.getLng()) == Double.doubleToLongBits(targetPoints2.getLng());
    }

    public final CaocaoBitmapDescriptor<?, ?> m0() {
        return Q(Integer.valueOf(R.drawable.run_ic_start_point), 36, 36);
    }

    @JvmOverloads
    public final void n(@Nullable HCJLatLng hCJLatLng, boolean z, int i, @Nullable String str) {
        p(this, hCJLatLng, z, i, str, false, 16, null);
    }

    @JvmOverloads
    public final void n0(@NotNull HCJLatLng hCJLatLng, float f2) {
        Intrinsics.checkNotNullParameter(hCJLatLng, SQLiteMTAHelper.TABLE_POINT);
        p0(this, hCJLatLng, f2, false, 4, null);
    }

    @NotNull
    public final CaocaoPolylineOptions<?, ?> newRoutePolylineOptions() {
        CaocaoPolylineOptions<?, ?> caocaoPolylineOptionsZIndex = this.mapAdapter.createPolylineOption().color(Z(getRouteColorHex())).width(jj8.a(getRouteWidthDp())).zIndex(1.0f);
        Intrinsics.checkNotNullExpressionValue(caocaoPolylineOptionsZIndex, "mapAdapter.createPolylin…)\n            .zIndex(1f)");
        return caocaoPolylineOptionsZIndex;
    }

    @JvmOverloads
    public final void o(@Nullable HCJLatLng point, boolean isPassed, int sort, @Nullable String name, boolean nfcEnable) {
        CaocaoBitmapDescriptor<?, ?> caocaoBitmapDescriptorT;
        if (point == null || (caocaoBitmapDescriptorT = T(sort, name, nfcEnable)) == null) {
            return;
        }
        if (isPassed && this.showPassedIcon) {
            v(point, this.inOrderMarkers, Integer.valueOf(sort), nfcEnable);
            return;
        }
        CaocaoMarker<?, ?> caocaoMarkerQ = q(point, caocaoBitmapDescriptorT, V(false, sort == 1), Integer.valueOf(sort));
        if (caocaoMarkerQ != null) {
            this.inOrderMarkers.add(caocaoMarkerQ);
        }
    }

    @JvmOverloads
    public final void o0(@NotNull HCJLatLng point, float zoom, boolean animate) {
        Intrinsics.checkNotNullParameter(point, SQLiteMTAHelper.TABLE_POINT);
        CaocaoCameraUpdate caocaoCameraUpdateNewLatLngZoom = P().newLatLngZoom(point, zoom);
        HCJMap<?, ?> hCJMap = this.map;
        if (animate) {
            if (hCJMap != null) {
                hCJMap.animateCamera(caocaoCameraUpdateNewLatLngZoom);
            }
        } else if (hCJMap != null) {
            hCJMap.moveCamera(caocaoCameraUpdateNewLatLngZoom);
        }
    }

    public final CaocaoMarker<?, ?> q(HCJLatLng point, CaocaoBitmapDescriptor<?, ?> icon, boolean visible, Integer sort) {
        HCJMap<?, ?> hCJMap;
        CaocaoMarker<?, ?> caocaoMarkerAddMarker;
        if (icon == null || (hCJMap = this.map) == null || (caocaoMarkerAddMarker = hCJMap.addMarker(this.mapAdapter.createMarkerOption().position(point).icon(icon).visible(visible))) == null) {
            return null;
        }
        if (sort != null) {
            caocaoMarkerAddMarker.putExtra(f12336b, Integer.valueOf(sort.intValue()));
        }
        return caocaoMarkerAddMarker;
    }

    @JvmOverloads
    public final void s(@Nullable HCJLatLng hCJLatLng, boolean z, @Nullable String str) {
        u(this, hCJLatLng, z, str, false, 8, null);
    }

    public final void setEndMarker(@Nullable CaocaoMarker<?, ?> caocaoMarker) {
        this.endMarker = caocaoMarker;
    }

    public final void setEndPoint(@Nullable HCJLatLng hCJLatLng) {
        this.endPoint = hCJLatLng;
    }

    public final void setMap(@Nullable HCJMap<?, ?> hCJMap) {
        this.map = hCJMap;
    }

    public final void setRoute(@NotNull List<? extends HCJLatLng> points) {
        Unit unit;
        Intrinsics.checkNotNullParameter(points, "points");
        this.routePoints = points;
        CaocaoPolyline<?, ?> caocaoPolyline = this.routePolyline;
        if (caocaoPolyline != null) {
            caocaoPolyline.setPoints(points);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            CaocaoPolylineOptions<?, ?> caocaoPolylineOptionsNewRoutePolylineOptions = newRoutePolylineOptions();
            caocaoPolylineOptionsNewRoutePolylineOptions.addAll(points);
            Unit unit2 = Unit.INSTANCE;
            this.routePolyline = addPolyline(caocaoPolylineOptionsNewRoutePolylineOptions);
        }
    }

    public final void setRoutePoints(@Nullable List<? extends HCJLatLng> list) {
        this.routePoints = list;
    }

    public final void setRoutePolyline(@Nullable CaocaoPolyline<?, ?> caocaoPolyline) {
        this.routePolyline = caocaoPolyline;
    }

    public final void setStartMarker(@Nullable CaocaoMarker<?, ?> caocaoMarker) {
        this.startMarker = caocaoMarker;
    }

    public final void setStartPoint(@Nullable HCJLatLng hCJLatLng) {
        this.startPoint = hCJLatLng;
    }

    @JvmOverloads
    public final void t(@Nullable HCJLatLng point, boolean isPassed, @Nullable final String name, final boolean nfcEnable) {
        C(point, isPassed, this.optionalMarkers, nfcEnable, new Function0<CaocaoBitmapDescriptor<?, ?>>() { // from class: com.huachenjie.run.map.RouteOverlay$addOptionalMarker$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CaocaoBitmapDescriptor<?, ?> m626invoke() {
                return this.this$0.Y(name, nfcEnable);
            }
        });
    }

    public final void v(final HCJLatLng point, final List<CaocaoMarker<?, ?>> into, final Integer sort, final boolean nfcEnable) {
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.wj7
            @Override // java.lang.Runnable
            public final void run() {
                RouteOverlay.x(this.f45610a, point, nfcEnable, sort, into);
            }
        });
    }

    @JvmOverloads
    public final void y(@Nullable HCJLatLng hCJLatLng, boolean z, @Nullable String str) {
        A(this, hCJLatLng, z, str, false, 8, null);
    }

    @JvmOverloads
    public final void z(@Nullable HCJLatLng point, boolean isPassed, @Nullable final String name, final boolean nfcEnable) {
        C(point, isPassed, this.requiredMarkers, nfcEnable, new Function0<CaocaoBitmapDescriptor<?, ?>>() { // from class: com.huachenjie.run.map.RouteOverlay$addRequiredMarker$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CaocaoBitmapDescriptor<?, ?> m627invoke() {
                return this.this$0.i0(name, nfcEnable);
            }
        });
    }

    public /* synthetic */ RouteOverlay(Context context, HCJMap hCJMap, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, hCJMap, (i2 & 4) != 0 ? 3 : i, (i2 & 8) != 0 ? true : z);
    }
}
