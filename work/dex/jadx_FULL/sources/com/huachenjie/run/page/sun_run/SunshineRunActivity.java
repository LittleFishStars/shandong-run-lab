package com.huachenjie.run.page.sun_run;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alipay.mobile.jsengine.NativeLibs;
import com.amap.api.maps.AMap;
import com.blankj.utilcode.util.CollectionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.huachenjie.base.aliyun.detect_face.DetectFaceFragment;
import com.huachenjie.base.aliyun.detect_face.DetectResultBean;
import com.huachenjie.base.bean.RunFaceCheckExtendBean;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.base.broadcast.detect_face.DetectFaceListener;
import com.huachenjie.base.broadcast.detect_face.DetectFaceReceiver;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.common.base.SideTextInterface;
import com.huachenjie.common.bean.ActivityRunDetailBean;
import com.huachenjie.common.bean.ActivityRunRule;
import com.huachenjie.common.bean.AlertTip;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.RunLatLng;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.location_ext.BDLocationResultHelper;
import com.huachenjie.common.receiver.NetStateReceiver;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.run_component.GeoFenceViewComponent;
import com.huachenjie.common.run_component.PauseTimerType;
import com.huachenjie.common.run_interface.RunStateChangeListener;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.VibratorUtils;
import com.huachenjie.common.widget.CustomizeViewDialog;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.FinishRunResult;
import com.huachenjie.run.bean.StartRunPageParam;
import com.huachenjie.run.bean.SunshineRunFaceCheckData;
import com.huachenjie.run.bean.SunshineRunFaceRecord;
import com.huachenjie.run.bean.SunshineRunFinishData;
import com.huachenjie.run.bean.SunshineRunServiceData;
import com.huachenjie.run.databinding.RunActivitySunshineRunBinding;
import com.huachenjie.run.dialog.FaceRecognitionTipDialog;
import com.huachenjie.run.dialog.NfcPauseTipDialog;
import com.huachenjie.run.dialog.NfcVerifyTipDialog;
import com.huachenjie.run.dialog.OnActionListener;
import com.huachenjie.run.dialog.RunFailDialog;
import com.huachenjie.run.dialog.RunPauseDialog;
import com.huachenjie.run.dialog.RunQuitConfirmDialog;
import com.huachenjie.run.dialog.ScreenLockDialog;
import com.huachenjie.run.dialog.SunRunStartAnimDialog;
import com.huachenjie.run.helper.SunshineRunNotificationHelper;
import com.huachenjie.run.page.MorePermissionActivity;
import com.huachenjie.run.page.activities_run.ActivityReadyActivity;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.activities_run.dialog.ActivityRuleDialog;
import com.huachenjie.run.page.sun_run.SunshineRunActivity;
import com.huachenjie.run.page.sun_run.success.CameraRunSuccessActivity;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity;
import com.huachenjie.run.service.BaseRunService;
import com.huachenjie.run.service.DataComponent;
import com.huachenjie.run.service.SunshineRunService;
import com.huachenjie.run.widget.RunActionButton;
import com.huachenjie.run.widget.SunshineRunGuideView;
import com.igexin.sdk.PushConsts;
import com.zj.adlib.PaceErrorBigState;
import com.zj.adlib.dw8;
import com.zj.adlib.ew;
import com.zj.adlib.f46;
import com.zj.adlib.fv5;
import com.zj.adlib.hz3;
import com.zj.adlib.il2;
import com.zj.adlib.in6;
import com.zj.adlib.jj8;
import com.zj.adlib.kl7;
import com.zj.adlib.lk0;
import com.zj.adlib.r90;
import com.zj.adlib.t26;
import com.zj.adlib.xv8;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import com.zj.adlib.zn1;
import huachenjie.sdk.map.adapter.location.model.HCJGeoFence;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.HCJMapFragment;
import huachenjie.sdk.map.adapter.map.adapter.HCJMapAdapter;
import huachenjie.sdk.map.adapter.map.callback.CaocaoOnMapLoadedListener;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolygonOptions;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0086\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0003\u0086\u0001qB\t¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J(\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J \u0010\u0015\u001a\u00020\u00072\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J \u0010%\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0002J\u001a\u0010(\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020\u0007H\u0002J\u0018\u00100\u001a\u00020\u00072\u0006\u0010*\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0002J\b\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\b\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\u0007H\u0002J\u001a\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020#H\u0002J\u0012\u0010;\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u000109H\u0002J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010:\u001a\u000209H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\b\u0010>\u001a\u00020\u0007H\u0002J\u0018\u0010A\u001a\u00020\u00072\u0006\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020!H\u0002J\u0012\u0010B\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u000109H\u0002J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010E\u001a\u00020\u0007H\u0002J\b\u0010F\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020\u0007H\u0002J\b\u0010H\u001a\u00020\u0007H\u0002J\"\u0010N\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010I2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KH\u0002J\b\u0010O\u001a\u00020\u0007H\u0002J\u0010\u0010R\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020PH\u0002J\b\u0010S\u001a\u00020\u0007H\u0002J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020PH\u0002J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010U\u001a\u00020PH\u0002J\u0010\u0010X\u001a\u00020\u00072\u0006\u0010W\u001a\u00020&H\u0002J\u001e\u0010[\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020P0K2\u0006\u0010Z\u001a\u00020#H\u0002J\b\u0010\\\u001a\u00020\u0007H\u0002J\b\u0010]\u001a\u00020\u0007H\u0002J\b\u0010^\u001a\u00020\u0007H\u0002J\b\u0010_\u001a\u00020\u0007H\u0002J\u0012\u0010b\u001a\u00020\u00182\b\u0010a\u001a\u0004\u0018\u00010`H\u0002J\u0010\u0010d\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0018H\u0002J\u0010\u0010f\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\u0018H\u0002J\u0010\u0010h\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030gH\u0002J\u0014\u0010i\u001a\u00020\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0002J\b\u0010j\u001a\u00020\u0007H\u0002J\b\u0010k\u001a\u00020\u0007H\u0002J\b\u0010l\u001a\u00020\u0007H\u0002J\b\u0010m\u001a\u00020#H\u0016J\u0014\u0010n\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J\u0012\u0010q\u001a\u00020\u00072\b\u0010p\u001a\u0004\u0018\u00010oH\u0016J\b\u0010r\u001a\u00020\u0007H\u0016J\b\u0010s\u001a\u00020\u0007H\u0016J\b\u0010t\u001a\u00020\u0007H\u0016J\u0012\u0010w\u001a\u00020\u00072\b\u0010v\u001a\u0004\u0018\u00010uH\u0016J\n\u0010x\u001a\u0004\u0018\u00010uH\u0016J\b\u0010y\u001a\u00020\u0018H\u0016J\n\u0010z\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010{\u001a\u00020#H\u0016J\u0010\u0010|\u001a\u00020\u00072\u0006\u0010p\u001a\u00020oH\u0014J\b\u0010}\u001a\u00020\u0007H\u0014J\b\u0010~\u001a\u00020\u0007H\u0014J\u0006\u0010\u007f\u001a\u00020\u0007J\t\u0010\u0080\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0081\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010\u0085\u0001\u001a\u00020\u00182\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001H\u0016R\u0019\u0010\u0088\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u008a\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u008d\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0090\u0001R\u0019\u0010\u0093\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0087\u0001R\u0019\u0010\u0096\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0098\u0001R\u0018\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u009a\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u009c\u0001R\u001a\u0010 \u0001\u001a\u00030\u009e\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u009f\u0001R\u001c\u0010£\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010¢\u0001R\u001c\u0010¦\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010¥\u0001R\u0018\u0010©\u0001\u001a\u00030§\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010¨\u0001R\u0019\u0010«\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u0087\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u00ad\u0001R\u0019\u0010°\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u0087\u0001R\u0019\u0010²\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010\u0087\u0001R\u0018\u0010³\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bx\u0010\u0087\u0001R\u0018\u0010´\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bw\u0010\u0087\u0001R\u0019\u0010¶\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u0087\u0001R\u001c\u0010¹\u0001\u001a\u0005\u0018\u00010·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010¸\u0001R \u0010¾\u0001\u001a\u00030º\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bq\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001R\u001c\u0010Á\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010À\u0001R\u001c\u0010Ä\u0001\u001a\u0005\u0018\u00010Â\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010Ã\u0001R\u001c\u0010Ç\u0001\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010Æ\u0001R\u001c\u0010Ê\u0001\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010É\u0001R\u001c\u0010Í\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010Ì\u0001R\u0019\u0010Ï\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u0095\u0001R\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010Ñ\u0001R\u001c\u0010Õ\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010Ô\u0001R\u0018\u0010Ö\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\by\u0010\u0087\u0001R\u001a\u0010Ø\u0001\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bx\u0010×\u0001R\u0018\u0010Û\u0001\u001a\u00030Ù\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010Ú\u0001¨\u0006Þ\u0001"}, d2 = {"Lcom/huachenjie/run/page/sun_run/SunshineRunActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivitySunshineRunBinding;", "Lcom/huachenjie/run/page/sun_run/SunshineRunVM;", "Lhuachenjie/sdk/map/adapter/map/callback/CaocaoOnMapLoadedListener;", "Lcom/huachenjie/base/internal/AdCancelInterface;", "Lcom/huachenjie/common/base/SideTextInterface;", "", com.alipay.sdk.m.c0.c.c, "z1", "s1", "C1", "l1", "Lcom/huachenjie/common/run_interface/RunStateChangeListener$State;", "state", "", "", "", "map", "u2", "j1", "D1", "i1", "x1", "", "locked", "k2", "y1", "q1", "p2", "Z1", "Lcom/huachenjie/common/run_component/PauseTimerType;", "type", "", "pauseLeftSecs", "", "pauseReason", "t2", "Lcom/huachenjie/run/service/DataComponent;", "dc", "c2", "k1", "pauseLeftTime", "b2", "R1", "restTotalSec", "e2", "Y1", "d2", "H1", "f2", "N1", "t1", "o2", "w1", "isHitErrCondition", "i2", "Lcom/huachenjie/run/bean/FinishRunResult;", SunshineRunSuccessActivity.t, "G1", "U1", com.igexin.push.core.g.e, "T1", SchoolActivitySuccessActivity.x, "time", "S1", "J1", "K1", "l2", "resume", "m2", "M1", "A1", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "addressInfo", "", "Lcom/huachenjie/common/bean/RunLatLng;", NativeLibs.FIELD_PATH_LIST, "r2", "u1", "Lcom/huachenjie/common/bean/TargetPoints;", "sensitivePoint", "W1", "X1", "B1", "leavingPoint", "E1", "dataComponent", "s2", "targetPoints", "index", "b1", "d1", "a2", "L1", "f1", "Landroidx/fragment/app/DialogFragment;", "fragment", "c1", "isDraw", "e1", "on", "h2", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolygonOptions;", "h1", "O1", "Q1", "q2", "n2", "getLayoutResID", "V", "Landroid/os/Bundle;", "savedInstanceState", "b", "W", "initView", "initData", "Landroid/widget/TextView;", "view", "q", "p", "s", "H", "C", "onRestoreInstanceState", "onResume", "onPause", "stopService", "onDestroy", "onMapLoaded", "finish", "Landroid/view/KeyEvent;", "event", "dispatchKeyEvent", "a", "Z", "mNeedRecover", "Lcom/huachenjie/run/bean/StartRunPageParam;", "Lcom/huachenjie/run/bean/StartRunPageParam;", SunshineRunActivity.x, "Lcom/huachenjie/common/bean/StartRunEntity;", "Lcom/huachenjie/common/bean/StartRunEntity;", "startRunEntity", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "schoolGeoFenceDetail", "c", ReadyActivity.t, "K", "I", "amapGPSLevel", "Lcom/huachenjie/common/receiver/NetStateReceiver;", "Lcom/huachenjie/common/receiver/NetStateReceiver;", "mNetStateReceiver", "Lcom/huachenjie/common/run_interface/RunStateChangeListener$State;", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "mMapAdapter", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "mMapFragment", "Lcom/zj/adlib/dw8;", "Lcom/zj/adlib/dw8;", "mRunOverlay", "Lcom/huachenjie/run/service/SunshineRunService;", "Lcom/huachenjie/run/service/SunshineRunService;", "sunshineRunService", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "detectReceiver", y6b.f, "serviceRestart", "Lcom/huachenjie/common/run_component/GeoFenceViewComponent;", "Lcom/huachenjie/common/run_component/GeoFenceViewComponent;", "mGeoFenceViewComponent", y6b.g, "isActivityRestore", "j", "serviceIsInit", "serviceInit", "mapInit", "r", "isRunPageReadyHandled", "Lcom/huachenjie/common/widget/CustomizeViewDialog;", "Lcom/huachenjie/common/widget/CustomizeViewDialog;", "gpsWeakDialog", "Landroid/os/Handler;", "Lkotlin/Lazy;", "g1", "()Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "gpsCheckRunnable", "Lcom/huachenjie/run/dialog/RunPauseDialog;", "Lcom/huachenjie/run/dialog/RunPauseDialog;", "mPauseDialog", "Lcom/huachenjie/run/dialog/RunQuitConfirmDialog;", "Lcom/huachenjie/run/dialog/RunQuitConfirmDialog;", "mQuitConfirmDialog", "Lcom/huachenjie/run/dialog/FaceRecognitionTipDialog;", "Lcom/huachenjie/run/dialog/FaceRecognitionTipDialog;", "faceRecognitionTip", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "detectFaceFragment", "L", "isShouldShowPauseState", "Lcom/huachenjie/run/dialog/NfcVerifyTipDialog;", "Lcom/huachenjie/run/dialog/NfcVerifyTipDialog;", "nfcVerifyTipDialog", "Lcom/huachenjie/run/dialog/NfcPauseTipDialog;", "Lcom/huachenjie/run/dialog/NfcPauseTipDialog;", "nfcPauseTipDialog", "isOnForeground", "Landroid/widget/TextView;", "sideTextView", "Landroid/content/ServiceConnection;", "Landroid/content/ServiceConnection;", "runServiceConnection", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSunshineRunActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunshineRunActivity.kt\ncom/huachenjie/run/page/sun_run/SunshineRunActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1718:1\n1#2:1719\n1855#3,2:1720\n1855#3,2:1722\n*S KotlinDebug\n*F\n+ 1 SunshineRunActivity.kt\ncom/huachenjie/run/page/sun_run/SunshineRunActivity\n*L\n1167#1:1720,2\n1656#1:1722,2\n*E\n"})
public final class SunshineRunActivity extends BaseMVVMActivity<RunActivitySunshineRunBinding, SunshineRunVM> implements CaocaoOnMapLoadedListener, AdCancelInterface, SideTextInterface {

    @NotNull
    public static final String t = "isRecover";

    @NotNull
    public static final String x = "startRunPageParam";

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int isShouldShowPauseState;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public DetectFaceFragment detectFaceFragment;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public GeoFenceDetail schoolGeoFenceDetail;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public StartRunEntity startRunEntity;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public NetStateReceiver mNetStateReceiver;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public GeoFenceViewComponent mGeoFenceViewComponent;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CustomizeViewDialog gpsWeakDialog;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public StartRunPageParam startRunPageParam;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public FaceRecognitionTipDialog faceRecognitionTip;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public NfcPauseTipDialog nfcPauseTipDialog;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public NfcVerifyTipDialog nfcVerifyTipDialog;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public RunPauseDialog mPauseDialog;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public RunQuitConfirmDialog mQuitConfirmDialog;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public SunshineRunService sunshineRunService;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public dw8 mRunOverlay;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public HCJMapFragment mMapFragment;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJMapAdapter mMapAdapter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Runnable gpsCheckRunnable;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean mNeedRecover;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean useCreditSword;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean serviceRestart;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public boolean isActivityRestore;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public boolean serviceIsInit;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @Nullable
    public TextView sideTextView;

    /* JADX INFO: renamed from: p, reason: collision with other field name and from kotlin metadata */
    public boolean serviceInit;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public boolean mapInit;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public boolean isRunPageReadyHandled;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int amapGPSLevel = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public RunStateChangeListener.State state = RunStateChangeListener.State.preStart;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final DetectFaceReceiver detectReceiver = new DetectFaceReceiver(new d());

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$handler$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m694invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public boolean isOnForeground = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ServiceConnection runServiceConnection = new h();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/run/page/sun_run/SunshineRunActivity$a;", "", "Landroid/view/View;", "v", "", "e", "f", "b", "d", "c", y6b.f, "a", "<init>", "(Lcom/huachenjie/run/page/sun_run/SunshineRunActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SunshineRunActivity.this.y1();
        }

        public final void b(@Nullable View v) {
            HCJMapFragment hCJMapFragment = SunshineRunActivity.this.mMapFragment;
            if (hCJMapFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
                hCJMapFragment = null;
            }
            Object real = hCJMapFragment.getMap().getReal();
            AMap aMap = real instanceof AMap ? (AMap) real : null;
            if (aMap == null) {
                return;
            }
            aMap.setMapType(aMap.getMapType() != 2 ? 2 : 1);
            r90.P(aMap.getMapType());
            SunshineRunActivity.this.p2();
        }

        public final void c(@Nullable View v) {
            SunshineRunActivity.this.M1();
        }

        public final void d(@Nullable View v) {
            SunshineRunActivity.this.startActivity(new Intent(SunshineRunActivity.this, (Class<?>) MorePermissionActivity.class));
        }

        public final void e(@Nullable View v) {
            ActivityRunDetailBean activityRunDetailBean;
            List<ActivityRunRule> ruleList;
            StartRunEntity startRunEntity = SunshineRunActivity.this.startRunEntity;
            if (startRunEntity == null || (activityRunDetailBean = startRunEntity.activityInfo) == null || (ruleList = activityRunDetailBean.getRuleList()) == null) {
                return;
            }
            ActivityRuleDialog.INSTANCE.a(ruleList).show(SunshineRunActivity.this.getSupportFragmentManager(), "ruleDialog");
        }

        public final void f(@Nullable View v) {
            DataComponent dataComponent;
            HCJAddressInfo hCJAddressInfoB1;
            int satellites = 0;
            try {
                SunshineRunService sunshineRunService = SunshineRunActivity.this.sunshineRunService;
                if (sunshineRunService != null && (dataComponent = sunshineRunService.getDataComponent()) != null && (hCJAddressInfoB1 = dataComponent.b1()) != null) {
                    satellites = hCJAddressInfoB1.getSatellites();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            fv5.b("GPS接收器得到" + satellites + "颗卫星定位\n（为了能准确记录您的跑步轨迹卫星颗数必须 >=2颗）");
        }

        public final void g(@Nullable View v) {
            SunshineRunService sunshineRunService = SunshineRunActivity.this.sunshineRunService;
            DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
            if (dataComponent == null) {
                return;
            }
            dataComponent.q2(!dataComponent.N1());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35945a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[BaseRunService.DataChangeCallBack.DataType.values().length];
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.PassedPoint.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.LocationChange.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.ClosingTargetPoint.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.FarAwayTargetPoint.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.ClosingClockPoint.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.FarAwayClockPoint.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.GeoFenceLoaded.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.EnterSchoolFence.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.LeaveSchoolFence.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.VolumeChange.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.LOCK_SCREEN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.FaceRecognitionTip.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BaseRunService.DataChangeCallBack.DataType.NfcVerification.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            f35945a = iArr;
            int[] iArr2 = new int[RunStateChangeListener.State.values().length];
            try {
                iArr2[RunStateChangeListener.State.autoPause.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[RunStateChangeListener.State.userPause.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[RunStateChangeListener.State.faceRecognition.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[RunStateChangeListener.State.nfcCheck.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[RunStateChangeListener.State.normal.ordinal()] = 5;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[RunStateChangeListener.State.finish.ordinal()] = 6;
            } catch (NoSuchFieldError unused19) {
            }
            b = iArr2;
            int[] iArr3 = new int[PauseTimerType.values().length];
            try {
                iArr3[PauseTimerType.REST.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr3[PauseTimerType.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr3[PauseTimerType.FACE_RECOGNITION.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr3[PauseTimerType.NFC_CHECK.ordinal()] = 4;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr3[PauseTimerType.SPEED_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused24) {
            }
            c = iArr3;
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"com/huachenjie/run/page/sun_run/SunshineRunActivity$d", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceListener;", "", "runRecordCode", "Lcom/huachenjie/base/bean/RunFaceCheckExtendBean;", il2.DETECT_EXTEND_BEAN, "", il2.DETECT_FACE_CHECK_INDEX, "", "b", "Lcom/huachenjie/base/aliyun/detect_face/DetectResultBean;", "result", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DetectFaceListener {
        public d() {
        }

        @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
        public void a(@NotNull DetectResultBean result) {
            Intrinsics.checkNotNullParameter(result, "result");
            SunshineRunService sunshineRunService = SunshineRunActivity.this.sunshineRunService;
            DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
            if (dataComponent == null || !Intrinsics.areEqual(dataComponent.E(), result.getRunRecordCode())) {
                return;
            }
            SunshineRunService sunshineRunService2 = SunshineRunActivity.this.sunshineRunService;
            if (sunshineRunService2 != null) {
                sunshineRunService2.stopFaceRecognition(result);
            }
            SunshineRunActivity.this.n2();
        }

        @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
        public void b(@NotNull String runRecordCode, @NotNull RunFaceCheckExtendBean extendBean, int faceCheckIndex) {
            SunshineRunService sunshineRunService;
            Intrinsics.checkNotNullParameter(runRecordCode, "runRecordCode");
            Intrinsics.checkNotNullParameter(extendBean, il2.DETECT_EXTEND_BEAN);
            SunshineRunService sunshineRunService2 = SunshineRunActivity.this.sunshineRunService;
            DataComponent dataComponent = sunshineRunService2 != null ? sunshineRunService2.getDataComponent() : null;
            if (dataComponent == null || !Intrinsics.areEqual(dataComponent.E(), runRecordCode) || (sunshineRunService = SunshineRunActivity.this.sunshineRunService) == null) {
                return;
            }
            sunshineRunService.saveFaceExtend(extendBean, faceCheckIndex);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/run/page/sun_run/SunshineRunActivity$e", "Lcom/huachenjie/run/dialog/OnActionListener;", "", "a", "onCancel", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class e implements OnActionListener {
        public e() {
        }

        @Override // com.huachenjie.run.dialog.OnActionListener
        public void a() {
            if (SunshineRunActivity.this.sunshineRunService == null) {
                return;
            }
            SunshineRunActivity.this.isShouldShowPauseState = 1;
            if (SunshineRunActivity.this.isOnForeground) {
                SunshineRunActivity.this.C1();
            }
        }

        @Override // com.huachenjie.run.dialog.OnActionListener
        public void onCancel() {
            SunshineRunActivity.this.isShouldShowPauseState = 2;
            if (SunshineRunActivity.this.isOnForeground) {
                SunshineRunActivity.this.C1();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/page/sun_run/SunshineRunActivity$f", "Ljava/lang/Runnable;", "", "run", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class f implements Runnable {

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/run/page/sun_run/SunshineRunActivity$f$a", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends DialogUtil.PositiveNegativeClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SunshineRunActivity f35949a;

            public a(SunshineRunActivity sunshineRunActivity) {
                this.f35949a = sunshineRunActivity;
            }

            @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
            public void a() {
                CustomizeViewDialog customizeViewDialog = this.f35949a.gpsWeakDialog;
                if (customizeViewDialog != null) {
                    customizeViewDialog.dismiss();
                }
                this.f35949a.gpsWeakDialog = null;
                SunshineRunActivity.j2(this.f35949a, false, 0, 2, null);
            }

            @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
            public void b() {
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SunshineRunService sunshineRunService = SunshineRunActivity.this.sunshineRunService;
            if (sunshineRunService == null) {
                return;
            }
            DataComponent dataComponent = sunshineRunService.getDataComponent();
            if (sunshineRunService.getRunState() != RunStateChangeListener.State.preStart || dataComponent.D1() || dataComponent.V0() > 1) {
                CustomizeViewDialog customizeViewDialog = SunshineRunActivity.this.gpsWeakDialog;
                if (customizeViewDialog != null && customizeViewDialog.isShowing()) {
                    CustomizeViewDialog customizeViewDialog2 = SunshineRunActivity.this.gpsWeakDialog;
                    if (customizeViewDialog2 != null) {
                        customizeViewDialog2.dismiss();
                    }
                    SunshineRunActivity.this.gpsWeakDialog = null;
                }
                SunshineRunActivity.this.g1().removeCallbacks(this);
                return;
            }
            CustomizeViewDialog customizeViewDialog3 = SunshineRunActivity.this.gpsWeakDialog;
            if ((customizeViewDialog3 == null || customizeViewDialog3.isShowing()) ? false : true) {
                CustomizeViewDialog customizeViewDialog4 = SunshineRunActivity.this.gpsWeakDialog;
                if (customizeViewDialog4 != null) {
                    customizeViewDialog4.show();
                }
            } else if (SunshineRunActivity.this.gpsWeakDialog == null) {
                SunshineRunActivity sunshineRunActivity = SunshineRunActivity.this;
                sunshineRunActivity.gpsWeakDialog = DialogUtil.i(sunshineRunActivity.getResources().getString(R.string.run_gspWeakDialogTitle), SunshineRunActivity.this.getResources().getString(R.string.run_gspWeakDialogMsg), SunshineRunActivity.this.getResources().getString(R.string.run_gspWeakDialogYes), SunshineRunActivity.this.getResources().getString(R.string.run_gspWeakDialogNo), new a(SunshineRunActivity.this)).create(SunshineRunActivity.this);
            }
            SunshineRunActivity.this.g1().postDelayed(this, 10000L);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/page/sun_run/SunshineRunActivity$g", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class g extends DialogUtil.PositiveNegativeClickListener {
        public g() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            SunshineRunService sunshineRunService = SunshineRunActivity.this.sunshineRunService;
            if (sunshineRunService == null) {
                SunshineRunActivity.this.finish();
            } else {
                sunshineRunService.finishRun(true);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/run/page/sun_run/SunshineRunActivity$h", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "", "onServiceConnected", "onServiceDisconnected", "run_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nSunshineRunActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunshineRunActivity.kt\ncom/huachenjie/run/page/sun_run/SunshineRunActivity$runServiceConnection$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1718:1\n1#2:1719\n*E\n"})
    public static final class h implements ServiceConnection {
        public h() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@Nullable ComponentName name, @Nullable IBinder service) {
            SunshineRunService service2;
            SunshineRunService.SunshineRunBinder sunshineRunBinder = service instanceof SunshineRunService.SunshineRunBinder ? (SunshineRunService.SunshineRunBinder) service : null;
            if (sunshineRunBinder == null || (service2 = sunshineRunBinder.getService()) == null) {
                return;
            }
            SunshineRunActivity.this.sunshineRunService = service2;
            DataComponent dataComponent = service2.getDataComponent();
            SunshineRunActivity.this.serviceIsInit = dataComponent.E1();
            SunshineRunFinishData sunshineRunFinishDataA = xv8.a();
            if (!SunshineRunActivity.this.serviceIsInit) {
                boolean z = (SunshineRunActivity.this.isActivityRestore || SunshineRunActivity.this.mNeedRecover || SunshineRunActivity.this.serviceRestart) ? false : true;
                SunshineRunActivity.this.serviceRestart = false;
                if (z && SunshineRunActivity.this.startRunPageParam == null) {
                    fv5.b("开始跑步失败,请稍后重试");
                    SunshineRunNotificationHelper.d().c(SunshineRunActivity.this);
                    SunshineRunActivity.this.finish();
                    return;
                } else if (!service2.initServiceData(z, SunshineRunActivity.this.startRunPageParam)) {
                    fv5.b("开始跑步失败,请稍后重试");
                    SunshineRunNotificationHelper.d().c(SunshineRunActivity.this);
                    SunshineRunActivity.this.finish();
                    return;
                }
            }
            SunshineRunActivity.o0(SunshineRunActivity.this).M().setValue(ys8.c("%s %s", dataComponent.E(), "8.7.7"));
            SunshineRunActivity.this.startRunEntity = dataComponent.s1();
            SunshineRunActivity.this.schoolGeoFenceDetail = dataComponent.q1();
            SunshineRunActivity.this.useCreditSword = dataComponent.Q1();
            SunshineRunActivity.this.amapGPSLevel = dataComponent.I0();
            SunshineRunActivity.this.q1();
            SunshineRunActivity.this.O1(dataComponent);
            SunshineRunActivity.this.p2();
            SunshineRunActivity.this.serviceInit = true;
            SunshineRunActivity.this.o2();
            SunshineRunActivity.this.l1();
            RunStateChangeListener.State runState = service2.getRunState();
            HashMap map = new HashMap();
            if (sunshineRunFinishDataA != null) {
                map.put("finishData", sunshineRunFinishDataA);
            }
            SunshineRunActivity sunshineRunActivity = SunshineRunActivity.this;
            Intrinsics.checkNotNullExpressionValue(runState, "runState");
            sunshineRunActivity.u2(runState, map);
            if (runState == RunStateChangeListener.State.normal) {
                CustomizeViewDialog customizeViewDialog = SunshineRunActivity.this.gpsWeakDialog;
                if (customizeViewDialog != null && customizeViewDialog.isShowing()) {
                    CustomizeViewDialog customizeViewDialog2 = SunshineRunActivity.this.gpsWeakDialog;
                    if (customizeViewDialog2 != null) {
                        customizeViewDialog2.dismiss();
                    }
                    SunshineRunActivity.this.gpsWeakDialog = null;
                }
                Runnable runnable = SunshineRunActivity.this.gpsCheckRunnable;
                if (runnable != null) {
                    SunshineRunActivity.this.g1().removeCallbacks(runnable);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@Nullable ComponentName name) {
            if (SunshineRunActivity.this.isFinishing()) {
                return;
            }
            SunshineRunActivity.this.serviceRestart = true;
            SunshineRunService.bindService(SunshineRunActivity.this, this);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class i implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35952a;

        public i(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35952a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35952a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35952a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/run/page/sun_run/SunshineRunActivity$j", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onShow", "onDismiss", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class j implements BaseDialogFragment.DialogFragmentListener {
        public j() {
        }

        @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
        public void onDismiss() {
            com.gyf.immersionbar.e.p3(SunshineRunActivity.this).T2(true).j3().a1();
            SunshineRunService sunshineRunService = SunshineRunActivity.this.sunshineRunService;
            if (sunshineRunService != null) {
                sunshineRunService.restoreShowFaceRecognitionTip();
                sunshineRunService.resumeRun();
            }
            SunshineRunActivity.this.detectFaceFragment = null;
        }

        @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
        public void onShow() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/run/page/sun_run/SunshineRunActivity$k", "Lcom/huachenjie/run/dialog/RunPauseDialog$OnRunActionListener;", "", "restTotalSecs", "", "a", "", "b", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class k implements RunPauseDialog.OnRunActionListener {
        public k() {
        }

        @Override // com.huachenjie.run.dialog.RunPauseDialog.OnRunActionListener
        public boolean a(int restTotalSecs) {
            return SunshineRunActivity.this.R1();
        }

        @Override // com.huachenjie.run.dialog.RunPauseDialog.OnRunActionListener
        public void b(int restTotalSecs) {
            SunshineRunActivity.this.i2(false, restTotalSecs);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/run/page/sun_run/SunshineRunActivity$l", "Lcom/huachenjie/run/dialog/RunQuitConfirmDialog$OnQuitConfirmListener;", "", "a", "", "b", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class l implements RunQuitConfirmDialog.OnQuitConfirmListener {
        public l() {
        }

        @Override // com.huachenjie.run.dialog.RunQuitConfirmDialog.OnQuitConfirmListener
        public boolean a() {
            return SunshineRunActivity.this.R1();
        }

        @Override // com.huachenjie.run.dialog.RunQuitConfirmDialog.OnQuitConfirmListener
        public void b() {
            SunshineRunActivity.j2(SunshineRunActivity.this, true, 0, 2, null);
        }
    }

    public static final void F1(SunshineRunActivity sunshineRunActivity, float f2) {
        Intrinsics.checkNotNullParameter(sunshineRunActivity, "this$0");
        HCJMapFragment hCJMapFragment = sunshineRunActivity.mMapFragment;
        HCJMapFragment hCJMapFragment2 = null;
        if (hCJMapFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            hCJMapFragment = null;
        }
        if (hCJMapFragment.getMap() != null) {
            HCJMapFragment hCJMapFragment3 = sunshineRunActivity.mMapFragment;
            if (hCJMapFragment3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            } else {
                hCJMapFragment2 = hCJMapFragment3;
            }
            hCJMapFragment2.showMyLocationMarker(f2);
        }
    }

    public static final void I1(SunshineRunActivity sunshineRunActivity) {
        DataComponent dataComponent;
        Intrinsics.checkNotNullParameter(sunshineRunActivity, "this$0");
        SunshineRunService sunshineRunService = sunshineRunActivity.sunshineRunService;
        if (sunshineRunService == null || (dataComponent = sunshineRunService.getDataComponent()) == null) {
            return;
        }
        dataComponent.V1(R.raw.run_run_plz_goto_next_p);
    }

    public static /* synthetic */ void P1(SunshineRunActivity sunshineRunActivity, DataComponent dataComponent, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            SunshineRunService sunshineRunService = sunshineRunActivity.sunshineRunService;
            dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
        }
        sunshineRunActivity.O1(dataComponent);
    }

    public static final void g2(final SunshineRunActivity sunshineRunActivity) {
        Intrinsics.checkNotNullParameter(sunshineRunActivity, "this$0");
        if (sunshineRunActivity.isFinishing() || sunshineRunActivity.isDestroyed()) {
            return;
        }
        sunshineRunActivity.getMBinding().f11623a.collapse();
        View root = sunshineRunActivity.getMBinding().getRoot();
        Intrinsics.checkNotNull(root, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) root;
        final SunshineRunGuideView sunshineRunGuideView = new SunshineRunGuideView(sunshineRunActivity, null, 0, 6, null);
        viewGroup.addView(sunshineRunGuideView, new ViewGroup.LayoutParams(-1, -1));
        sunshineRunGuideView.show(CollectionsKt.listOf(new Function0[]{new Function0<View>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showRunGuideIfNeeded$1$1
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m710invoke() {
                return this.this$0.getMBinding().f11623a.getCollapsedHeaderView();
            }
        }, new Function0<View>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showRunGuideIfNeeded$1$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m711invoke() {
                View root2 = this.this$0.getMBinding().f11616a.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "mBinding.qualifyConditions.root");
                return root2;
            }
        }, new Function0<View>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showRunGuideIfNeeded$1$3
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m712invoke() {
                RunActionButton runActionButton = this.this$0.getMBinding().f11622a;
                Intrinsics.checkNotNullExpressionValue(runActionButton, "mBinding.quitRunView");
                return runActionButton;
            }
        }}), new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showRunGuideIfNeeded$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m713invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m713invoke() {
                r90.f0();
                viewGroup.removeView(sunshineRunGuideView);
            }
        });
    }

    public static /* synthetic */ void j2(SunshineRunActivity sunshineRunActivity, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        sunshineRunActivity.i2(z, i2);
    }

    public static final void m1(SunshineRunActivity sunshineRunActivity, PauseTimerType pauseTimerType, long j2) {
        Intrinsics.checkNotNullParameter(sunshineRunActivity, "this$0");
        P1(sunshineRunActivity, null, 1, null);
    }

    public static final void n1(SunshineRunActivity sunshineRunActivity, BaseRunService.DataChangeCallBack.DataType dataType, DataComponent dataComponent) {
        Intrinsics.checkNotNullParameter(sunshineRunActivity, "this$0");
        switch (dataType == null ? -1 : c.f35945a[dataType.ordinal()]) {
            case 1:
                if (dataComponent.o1() != 30) {
                    dataComponent.V1(R.raw.run_passed_point);
                }
                Intrinsics.checkNotNullExpressionValue(dataComponent, "dataComponent1");
                sunshineRunActivity.s2(dataComponent);
                dw8 dw8Var = sunshineRunActivity.mRunOverlay;
                if (dw8Var != null) {
                    dw8Var.u0(jj8.a(100.0f));
                }
                break;
            case 2:
                List<RunLatLng> listT0 = dataComponent.T0();
                HCJAddressInfo hCJAddressInfoB1 = dataComponent.b1();
                if (hCJAddressInfoB1 != null) {
                    sunshineRunActivity.getMViewModel().I().setValue(String.valueOf(hCJAddressInfoB1.getSatellites()));
                    MutableLiveData<String> mutableLiveDataK = sunshineRunActivity.getMViewModel().k();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("A:%.2f S:%.2f", Arrays.copyOf(new Object[]{Float.valueOf(hCJAddressInfoB1.getAccuracy()), Float.valueOf(hCJAddressInfoB1.getSpeed())}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    mutableLiveDataK.setValue(str);
                    sunshineRunActivity.r2(hCJAddressInfoB1, listT0);
                }
                sunshineRunActivity.O1(dataComponent);
                break;
            case 3:
                TargetPoints targetPointsY0 = dataComponent.Y0();
                if (targetPointsY0 != null) {
                    sunshineRunActivity.W1(targetPointsY0);
                    break;
                }
                break;
            case 4:
                sunshineRunActivity.X1();
                break;
            case 5:
                TargetPoints targetPointsN0 = dataComponent.N0();
                if (targetPointsN0 != null) {
                    sunshineRunActivity.B1(targetPointsN0);
                    break;
                }
                break;
            case 6:
                TargetPoints targetPointsZ0 = dataComponent.Z0();
                if (targetPointsZ0 != null) {
                    sunshineRunActivity.E1(targetPointsZ0);
                    break;
                }
                break;
            case 7:
                List<HCJGeoFence> listR1 = dataComponent.r1();
                GeoFenceViewComponent geoFenceViewComponent = sunshineRunActivity.mGeoFenceViewComponent;
                if (geoFenceViewComponent != null) {
                    geoFenceViewComponent.c(listR1);
                }
                break;
            case 8:
                sunshineRunActivity.h2(false);
                break;
            case 9:
                sunshineRunActivity.h2(true);
                break;
            case 10:
            case 11:
                sunshineRunActivity.p2();
                break;
            case 12:
                sunshineRunActivity.Z1();
                break;
            case 13:
                sunshineRunActivity.O1(dataComponent);
                if (dataComponent.H1()) {
                    sunshineRunActivity.d1();
                }
                break;
        }
    }

    public static final /* synthetic */ SunshineRunVM o0(SunshineRunActivity sunshineRunActivity) {
        return sunshineRunActivity.getMViewModel();
    }

    public static final void o1(SunshineRunActivity sunshineRunActivity, RunStateChangeListener.State state, Map map) {
        Intrinsics.checkNotNullParameter(sunshineRunActivity, "this$0");
        if (state == RunStateChangeListener.State.normal) {
            CustomizeViewDialog customizeViewDialog = sunshineRunActivity.gpsWeakDialog;
            boolean z = false;
            if (customizeViewDialog != null && customizeViewDialog.isShowing()) {
                z = true;
            }
            if (z) {
                CustomizeViewDialog customizeViewDialog2 = sunshineRunActivity.gpsWeakDialog;
                if (customizeViewDialog2 != null) {
                    customizeViewDialog2.dismiss();
                }
                sunshineRunActivity.gpsWeakDialog = null;
            }
            Runnable runnable = sunshineRunActivity.gpsCheckRunnable;
            if (runnable != null) {
                sunshineRunActivity.g1().removeCallbacks(runnable);
            }
        }
        Intrinsics.checkNotNullExpressionValue(state, "state");
        sunshineRunActivity.u2(state, map);
    }

    public static final void p1(SunshineRunActivity sunshineRunActivity, PauseTimerType pauseTimerType, long j2) {
        DataComponent dataComponent;
        Intrinsics.checkNotNullParameter(sunshineRunActivity, "this$0");
        long j3 = j2 / 1000;
        SunshineRunService sunshineRunService = sunshineRunActivity.sunshineRunService;
        if (sunshineRunService != null && (dataComponent = sunshineRunService.getDataComponent()) != null) {
            Intrinsics.checkNotNullExpressionValue(pauseTimerType, "type");
            sunshineRunActivity.t2(pauseTimerType, j3, dataComponent.m1());
        }
        if (PauseTimerType.AUTO != pauseTimerType || j3 > 0) {
            return;
        }
        j2(sunshineRunActivity, true, 0, 2, null);
    }

    public static final void r1(SunshineRunActivity sunshineRunActivity) {
        Intrinsics.checkNotNullParameter(sunshineRunActivity, "this$0");
        sunshineRunActivity.getMBinding().f11615a.setVisibility(8);
    }

    public final void A1() {
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService != null) {
            sunshineRunService.pauseRun();
        }
    }

    public final void B1(TargetPoints sensitivePoint) {
        DataComponent dataComponent;
        if (sensitivePoint.getNfcEnable()) {
            SunshineRunService sunshineRunService = this.sunshineRunService;
            boolean z = false;
            if (sunshineRunService != null && (dataComponent = sunshineRunService.getDataComponent()) != null && dataComponent.H1()) {
                z = true;
            }
            if (z) {
                return;
            }
            a2();
        }
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public int C() {
        return zn1.a(com.huachenjie.common.R.color.color_8997A4);
    }

    public final void C1() {
        DataComponent dataComponent;
        int i2 = this.isShouldShowPauseState;
        if (i2 > 0) {
            if (1 == i2) {
                SunshineRunService sunshineRunService = this.sunshineRunService;
                if (sunshineRunService != null && (dataComponent = sunshineRunService.getDataComponent()) != null) {
                    c2(PauseTimerType.REST, dataComponent);
                }
            } else if (2 == i2) {
                k1();
            }
            this.isShouldShowPauseState = 0;
        }
    }

    public final void D1(Map<String, ? extends Object> map) {
        if (map == null) {
            return;
        }
        Object obj = map.get("finishData");
        if (obj instanceof SunshineRunFinishData) {
            SunshineRunFinishData sunshineRunFinishData = (SunshineRunFinishData) obj;
            if (!sunshineRunFinishData.isFinishSuccess()) {
                DialogUtil.B(this, "结束跑步失败", "结束跑步失败,请重新尝试开始跑步", null, "结束跑步", false, false, new g());
            } else if (sunshineRunFinishData.isDataError()) {
                finish();
            } else {
                G1(sunshineRunFinishData.getOriginData());
            }
        }
    }

    public final void E1(TargetPoints leavingPoint) {
        if (leavingPoint.getNfcEnable()) {
            d1();
        }
    }

    public final void G1(FinishRunResult finishRunResult) {
        SunshineRunServiceData sunshineRunServiceDataU1;
        Integer recheckStatus;
        boolean z = false;
        if (finishRunResult == null) {
            ToastUtils.W("结束跑步数据异常！！", new Object[0]);
            return;
        }
        if (finishRunResult.getRecheckStatus() != null && (recheckStatus = finishRunResult.getRecheckStatus()) != null && recheckStatus.intValue() == 2) {
            T1();
            return;
        }
        if (finishRunResult.getRunScene() == 10) {
            V1();
            return;
        }
        int iA = hz3.f17094a.a();
        Object objA = f46.f41591a.a(finishRunResult.getStatus(), 0);
        Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type kotlin.Int");
        if (iA != ((Integer) objA).intValue()) {
            J1(finishRunResult);
            stopService();
            return;
        }
        SunshineRunService sunshineRunService = this.sunshineRunService;
        DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
        if (dataComponent != null && (sunshineRunServiceDataU1 = dataComponent.u1()) != null && sunshineRunServiceDataU1.getSportType() == 6) {
            z = true;
        }
        if (z) {
            S1(dataComponent.S0(), dataComponent.Q0());
        } else {
            U1(finishRunResult);
        }
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    @Nullable
    public String H() {
        return null;
    }

    public final void H1() {
        if (this.isRunPageReadyHandled) {
            return;
        }
        this.isRunPageReadyHandled = true;
        s1();
        if (r90.o() != null && kl7.f42851a.d(this.startRunEntity, this.schoolGeoFenceDetail)) {
            g1().postDelayed(new Runnable() { // from class: com.zj.adlib.uv8
                @Override // java.lang.Runnable
                public final void run() {
                    SunshineRunActivity.I1(this.f45237a);
                }
            }, 200L);
        }
        f2();
    }

    public final void J1(FinishRunResult finishRunResult) {
        AlertTip alertTip;
        if (finishRunResult == null || (alertTip = finishRunResult.getAlertTip()) == null) {
            return;
        }
        RunFailDialog.Companion companion = RunFailDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        companion.a(supportFragmentManager, alertTip, new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$onShowFailDialog$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m702invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m702invoke() {
                this.this$0.finish();
            }
        }, new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$onShowFailDialog$2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m703invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m703invoke() {
                SunshineRunServiceData sunshineRunServiceDataU1;
                SunshineRunService sunshineRunService = this.this$0.sunshineRunService;
                DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
                boolean z = false;
                if (dataComponent != null && (sunshineRunServiceDataU1 = dataComponent.u1()) != null && sunshineRunServiceDataU1.getSportType() == 6) {
                    z = true;
                }
                if (z) {
                    ActivityLifecycleManager.l().f(ActivityReadyActivity.class);
                } else {
                    ActivityLifecycleManager.l().f(ReadyActivity.class);
                    ARouter.getInstance().build(RoutePathConstants.Run.j).navigation();
                }
                this.this$0.finish();
            }
        });
    }

    public final void K1(PauseTimerType type) {
        if (getSupportFragmentManager().isStateSaved()) {
            return;
        }
        try {
            l2(type);
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }

    public final void L1() {
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService != null) {
            sunshineRunService.queryNfcVerificationNow();
        }
    }

    public final void M1() {
        HCJAddressInfo hCJAddressInfoO;
        HCJMapAdapter hCJMapAdapter;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        HCJMapFragment hCJMapFragment2 = null;
        if (hCJMapFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            hCJMapFragment = null;
        }
        if (hCJMapFragment.getMap() == null || (hCJAddressInfoO = r90.o()) == null) {
            return;
        }
        if (!(!(hCJAddressInfoO.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE))) {
            hCJAddressInfoO = null;
        }
        if (hCJAddressInfoO == null || (hCJMapAdapter = this.mMapAdapter) == null) {
            return;
        }
        HCJMapFragment hCJMapFragment3 = this.mMapFragment;
        if (hCJMapFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
        } else {
            hCJMapFragment2 = hCJMapFragment3;
        }
        hCJMapFragment2.getMap().animateCamera(hCJMapAdapter.createCameraUpdateFactoryOption().changeLatLng(new HCJLatLng(hCJAddressInfoO.getLat(), hCJAddressInfoO.getLng())));
    }

    public final void N1() {
        SunshineRunService.newInstance(this, this.runServiceConnection);
    }

    public final void O1(DataComponent dc) {
        if (dc == null) {
            return;
        }
        getMBinding().f11622a.applyRunMode(dc.v1() > 0, RunActionButton.TipStyle.MAP);
        getMBinding().f11623a.bind(dc);
        getMViewModel().i(dc);
    }

    public final void Q1() {
        if (this.mNetStateReceiver == null) {
            this.mNetStateReceiver = new NetStateReceiver(getString(R.string.run_network_dis_connect_tips), 1);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        registerReceiver(this.mNetStateReceiver, intentFilter);
    }

    public final boolean R1() {
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService == null || !sunshineRunService.resumeRun()) {
            return false;
        }
        getMBinding().f11621a.onResume();
        return true;
    }

    public final void S1(long distance, long time) {
        Intent intent = new Intent(this, (Class<?>) SchoolActivitySuccessActivity.class);
        intent.putExtra(SchoolActivitySuccessActivity.x, distance);
        intent.putExtra("time", time);
        startActivity(intent);
        ActivityLifecycleManager.l().f(ActivityReadyActivity.class);
        finish();
    }

    public final void T1() {
        Intent intent = new Intent(this, (Class<?>) CameraRunSuccessActivity.class);
        intent.putExtra(CameraRunSuccessActivity.t, 2);
        startActivity(intent);
        finish();
    }

    public final void U1(FinishRunResult finishRunResult) {
        ActivityRunDetailBean activityRunDetailBean;
        SunshineRunService sunshineRunService = this.sunshineRunService;
        DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
        if (dataComponent == null) {
            return;
        }
        StartRunEntity startRunEntity = this.startRunEntity;
        long activityCode = (startRunEntity == null || (activityRunDetailBean = startRunEntity.activityInfo) == null) ? 0L : activityRunDetailBean.getActivityCode();
        Intent intent = new Intent(this, (Class<?>) SunshineRunSuccessActivity.class);
        intent.putExtra("activityCode", activityCode);
        intent.putExtra(SunshineRunSuccessActivity.y, dataComponent.J0());
        intent.putExtra("duration", dataComponent.Q0());
        intent.putExtra(SunshineRunSuccessActivity.t, finishRunResult);
        startActivity(intent);
        finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    public final void V1() {
        Intent intent = new Intent(this, (Class<?>) CameraRunSuccessActivity.class);
        intent.putExtra(CameraRunSuccessActivity.t, 1);
        startActivity(intent);
        finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        z1();
    }

    public final void W1(TargetPoints sensitivePoint) {
        dw8 dw8Var = this.mRunOverlay;
        if (dw8Var == null) {
            return;
        }
        dw8Var.r0(new HCJLatLng(sensitivePoint.getLat(), sensitivePoint.getLng()), jj8.a(100.0f));
    }

    public final void X1() {
        dw8 dw8Var = this.mRunOverlay;
        if (dw8Var != null) {
            dw8Var.x0();
        }
    }

    public final void Y1() {
        SunshineRunService sunshineRunService = this.sunshineRunService;
        DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
        if (dataComponent == null) {
            return;
        }
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(DetectFaceFragment.class.getSimpleName());
        if (fragmentFindFragmentByTag != null) {
            getSupportFragmentManager().beginTransaction().remove(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        }
        SunshineRunServiceData sunshineRunServiceDataU1 = dataComponent.u1();
        String faceImg = sunshineRunServiceDataU1.getFaceCheckData().getFaceImg();
        String str = faceImg == null ? "" : faceImg;
        int similarityValue = sunshineRunServiceDataU1.getFaceCheckData().getSimilarityValue();
        boolean faceAuth = sunshineRunServiceDataU1.getFaceCheckData().getFaceAuth();
        StartRunEntity startRunEntity = sunshineRunServiceDataU1.getStartRunEntity();
        String runRecordCode = startRunEntity != null ? startRunEntity.getRunRecordCode() : null;
        if (runRecordCode == null) {
            runRecordCode = "";
        }
        DetectFaceFragment detectFaceFragmentA = com.huachenjie.base.aliyun.detect_face.a.a(new UserFaceBean(1, str, similarityValue, faceAuth, runRecordCode, sunshineRunServiceDataU1.getFaceCheckData().getFaceTime(), (int) (sunshineRunServiceDataU1.getFaceCheckData().getFaceLeftTime() / ((long) 1000)), sunshineRunServiceDataU1.getFaceCheckData().getBodyEnable(), sunshineRunServiceDataU1.getFaceCheckData().getBodyRate(), sunshineRunServiceDataU1.getFaceCheckData().getFaceModelType(), sunshineRunServiceDataU1.getFaceCheckData().getCurrentFaceCheckIndex()));
        detectFaceFragmentA.setDialogFragmentListener(new j());
        detectFaceFragmentA.showNow(getSupportFragmentManager(), DetectFaceFragment.class.getSimpleName());
        this.detectFaceFragment = detectFaceFragmentA;
    }

    public final void Z1() {
        DataComponent dataComponent;
        if (getMBinding().f11621a.isWorking()) {
            j1();
            return;
        }
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService == null || (dataComponent = sunshineRunService.getDataComponent()) == null) {
            return;
        }
        SunshineRunServiceData sunshineRunServiceDataU1 = dataComponent.u1();
        FaceRecognitionTipDialog faceRecognitionTipDialogA = FaceRecognitionTipDialog.INSTANCE.a(sunshineRunServiceDataU1.getFaceCheckData().getFaceTime(), (int) (sunshineRunServiceDataU1.getFaceCheckData().getFaceLeftTime() / ((long) 1000)), new Function1<Integer, Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showFaceRecognitionTip$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                SunshineRunService sunshineRunService2 = this.this$0.sunshineRunService;
                if (sunshineRunService2 != null) {
                    sunshineRunService2.updateRecognitionPauseLeftTime(i2);
                }
            }
        }, new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showFaceRecognitionTip$2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m704invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m704invoke() {
                SunshineRunService sunshineRunService2 = this.this$0.sunshineRunService;
                if (sunshineRunService2 != null) {
                    sunshineRunService2.startFaceRecognition();
                }
                this.this$0.Y1();
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        faceRecognitionTipDialogA.show(supportFragmentManager, FaceRecognitionTipDialog.class.getSimpleName());
        this.faceRecognitionTip = faceRecognitionTipDialogA;
        sunshineRunService.saveFacePopData();
        n2();
    }

    public final void a2() {
        DataComponent dataComponent;
        SunshineRunServiceData sunshineRunServiceDataU1;
        NfcVerifyTipDialog nfcVerifyTipDialog = this.nfcVerifyTipDialog;
        if (nfcVerifyTipDialog != null && nfcVerifyTipDialog.isAdded()) {
            return;
        }
        NfcPauseTipDialog nfcPauseTipDialog = this.nfcPauseTipDialog;
        if (nfcPauseTipDialog != null && nfcPauseTipDialog.isAdded()) {
            return;
        }
        SunshineRunService sunshineRunService = this.sunshineRunService;
        RunStateChangeListener.State runState = sunshineRunService != null ? sunshineRunService.getRunState() : null;
        if (runState == null) {
            runState = this.state;
        }
        if (runState != RunStateChangeListener.State.normal) {
            return;
        }
        SunshineRunService sunshineRunService2 = this.sunshineRunService;
        int nfcPauseDuration = (sunshineRunService2 == null || (dataComponent = sunshineRunService2.getDataComponent()) == null || (sunshineRunServiceDataU1 = dataComponent.u1()) == null) ? 30 : sunshineRunServiceDataU1.getNfcPauseDuration();
        final int i2 = nfcPauseDuration <= 0 ? 30 : nfcPauseDuration;
        NfcVerifyTipDialog.Companion companion = NfcVerifyTipDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        this.nfcVerifyTipDialog = companion.a(supportFragmentManager, i2, new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showNfcVerifyTipIfNeeded$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m705invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m705invoke() {
                this.this$0.nfcVerifyTipDialog = null;
                this.this$0.L1();
            }
        }, new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showNfcVerifyTipIfNeeded$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m706invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m706invoke() {
                this.this$0.nfcVerifyTipDialog = null;
                SunshineRunActivity sunshineRunActivity = this.this$0;
                NfcPauseTipDialog.Companion companion2 = NfcPauseTipDialog.INSTANCE;
                FragmentManager supportFragmentManager2 = sunshineRunActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
                int i3 = i2;
                final SunshineRunActivity sunshineRunActivity2 = this.this$0;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showNfcVerifyTipIfNeeded$2.1
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m707invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m707invoke() {
                        sunshineRunActivity2.nfcPauseTipDialog = null;
                        SunshineRunService sunshineRunService3 = sunshineRunActivity2.sunshineRunService;
                        if (sunshineRunService3 != null) {
                            sunshineRunService3.stopNFCCheck();
                        }
                    }
                };
                final SunshineRunActivity sunshineRunActivity3 = this.this$0;
                sunshineRunActivity.nfcPauseTipDialog = companion2.a(supportFragmentManager2, i3, function0, new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showNfcVerifyTipIfNeeded$2.2
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m708invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m708invoke() {
                        sunshineRunActivity3.f1();
                    }
                });
                SunshineRunService sunshineRunService3 = this.this$0.sunshineRunService;
                if (sunshineRunService3 != null) {
                    sunshineRunService3.startNFCCheck();
                }
            }
        }, new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$showNfcVerifyTipIfNeeded$3
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m709invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m709invoke() {
                SunshineRunService sunshineRunService3 = this.this$0.sunshineRunService;
                if (sunshineRunService3 != null) {
                    sunshineRunService3.markPendingNfcVerificationQuery();
                }
                this.this$0.f1();
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void b(@Nullable Bundle savedInstanceState) {
        try {
            setRequestedOrientation(1);
        } catch (Throwable unused) {
        }
        il2.registerReceiver(this, this.detectReceiver);
        i1();
    }

    public final void b1(List<TargetPoints> targetPoints, int index) {
        TargetPoints targetPoints2;
        dw8 dw8Var = this.mRunOverlay;
        if (dw8Var != null) {
            int i2 = index + 1;
            dw8Var.f0(targetPoints, i2);
            if (index < 0 || i2 >= targetPoints.size()) {
                targetPoints2 = index == -1 ? targetPoints.get(0) : null;
            } else {
                targetPoints2 = targetPoints.get(i2);
            }
            if (targetPoints2 != null) {
                dw8Var.E(targetPoints2.getSort(), targetPoints2.getSimpleName(), targetPoints2.getNfcEnable());
            }
        }
    }

    public final void b2(long pauseLeftTime, int pauseReason) {
        long j2 = pauseLeftTime / 1000;
        SunshineRunService sunshineRunService = this.sunshineRunService;
        DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
        RunQuitConfirmDialog runQuitConfirmDialog = this.mQuitConfirmDialog;
        if (runQuitConfirmDialog != null && runQuitConfirmDialog.isShowing()) {
            runQuitConfirmDialog.bindRunData(dataComponent);
            if (j2 <= 0) {
                runQuitConfirmDialog.dismissAllowingStateLoss();
                this.mQuitConfirmDialog = null;
                j2(this, false, 0, 2, null);
                return;
            }
            return;
        }
        RunPauseDialog runPauseDialog = this.mPauseDialog;
        if (runPauseDialog != null && runPauseDialog.isShowing()) {
            runPauseDialog.updateLeftTime(j2);
            runPauseDialog.bindRunData(dataComponent);
            return;
        }
        RunPauseDialog runPauseDialogA = RunPauseDialog.INSTANCE.a(new k());
        runPauseDialogA.bindRunData(dataComponent);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        runPauseDialogA.showDialog(supportFragmentManager, "mPauseDialog", j2);
        this.mPauseDialog = runPauseDialogA;
        getMBinding().f11623a.collapse();
    }

    public final boolean c1(DialogFragment fragment) {
        Dialog dialog;
        Window window;
        if (fragment == null || (dialog = fragment.getDialog()) == null || !dialog.isShowing() || (window = dialog.getWindow()) == null) {
            return false;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        if (decorView.getParent() == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = decorView.getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return false;
        }
        try {
            WindowManager windowManager = window.getWindowManager();
            windowManager.removeViewImmediate(decorView);
            windowManager.addView(decorView, layoutParams2);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void c2(PauseTimerType type, DataComponent dc) {
        if (dc == null) {
            return;
        }
        int i2 = c.c[type.ordinal()];
        if (i2 == 1) {
            getMBinding().f11621a.onPause();
            b2(dc.k1(PauseTimerType.REST), dc.m1());
        } else if (i2 == 2) {
            getMBinding().f11621a.onPause();
            d2(dc.k1(PauseTimerType.AUTO) / 1000, dc.m1());
        } else {
            if (i2 != 5) {
                return;
            }
            getMViewModel().i(dc);
        }
    }

    public final void d1() {
        SunshineRunService sunshineRunService;
        NfcVerifyTipDialog nfcVerifyTipDialog = this.nfcVerifyTipDialog;
        if (nfcVerifyTipDialog != null) {
            if (!nfcVerifyTipDialog.isAdded()) {
                nfcVerifyTipDialog = null;
            }
            if (nfcVerifyTipDialog != null) {
                nfcVerifyTipDialog.dismissAllowingStateLoss();
            }
        }
        this.nfcVerifyTipDialog = null;
        NfcPauseTipDialog nfcPauseTipDialog = this.nfcPauseTipDialog;
        if (nfcPauseTipDialog != null) {
            if (!nfcPauseTipDialog.isAdded()) {
                nfcPauseTipDialog = null;
            }
            if (nfcPauseTipDialog != null) {
                nfcPauseTipDialog.dismissAllowingStateLoss();
            }
        }
        this.nfcPauseTipDialog = null;
        SunshineRunService sunshineRunService2 = this.sunshineRunService;
        if ((sunshineRunService2 != null ? sunshineRunService2.getRunState() : null) != RunStateChangeListener.State.nfcCheck || (sunshineRunService = this.sunshineRunService) == null) {
            return;
        }
        sunshineRunService.stopNFCCheck();
    }

    public final void d2(long pauseLeftTime, int pauseReason) {
        getMBinding().f11620a.setLastedDuration(pauseLeftTime, pauseReason);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    public final void e1(boolean isDraw) {
        GeoFenceViewComponent geoFenceViewComponent = this.mGeoFenceViewComponent;
        if (geoFenceViewComponent == null) {
            return;
        }
        if (isDraw) {
            geoFenceViewComponent.g();
        } else {
            geoFenceViewComponent.i();
        }
    }

    public final void e2(int restTotalSec) {
        RunQuitConfirmDialog runQuitConfirmDialog = this.mQuitConfirmDialog;
        boolean z = false;
        if (runQuitConfirmDialog != null && runQuitConfirmDialog.isShowing()) {
            z = true;
        }
        if (z) {
            return;
        }
        RunQuitConfirmDialog runQuitConfirmDialogA = RunQuitConfirmDialog.INSTANCE.a(new l());
        SunshineRunService sunshineRunService = this.sunshineRunService;
        runQuitConfirmDialogA.bindRunData(sunshineRunService != null ? sunshineRunService.getDataComponent() : null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        runQuitConfirmDialogA.showDialog(supportFragmentManager, "mQuitConfirmDialog");
        this.mQuitConfirmDialog = runQuitConfirmDialogA;
        RunPauseDialog runPauseDialog = this.mPauseDialog;
        if (runPauseDialog != null) {
            runPauseDialog.dismissAllowingStateLoss();
        }
        this.mPauseDialog = null;
    }

    public final void f1() {
        if (c1(this.detectFaceFragment)) {
            return;
        }
        c1(this.faceRecognitionTip);
    }

    public final void f2() {
        if (r90.B().booleanValue()) {
            g1().postDelayed(new Runnable() { // from class: com.zj.adlib.vv8
                @Override // java.lang.Runnable
                public final void run() {
                    SunshineRunActivity.g2(this.f45470a);
                }
            }, 300L);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        h2(false);
    }

    public final Handler g1() {
        return (Handler) this.handler.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_sunshine_run;
    }

    public final CaocaoPolygonOptions<?, ?> h1() {
        HCJMapAdapter hCJMapAdapter = this.mMapAdapter;
        if (hCJMapAdapter == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        CaocaoPolygonOptions<?, ?> caocaoPolygonOptionsCreatePolygonOptions2 = hCJMapAdapter.createPolygonOptions2();
        caocaoPolygonOptionsCreatePolygonOptions2.fillColor(Color.parseColor("#1A0BD3FF"));
        caocaoPolygonOptionsCreatePolygonOptions2.strokeColor(Color.parseColor("#FF0BD3FF"));
        caocaoPolygonOptionsCreatePolygonOptions2.strokeWidth(jj8.a(2.0f));
        Intrinsics.checkNotNullExpressionValue(caocaoPolygonOptionsCreatePolygonOptions2, "polygonOption");
        return caocaoPolygonOptionsCreatePolygonOptions2;
    }

    public final void h2(boolean on) {
        try {
            if (on) {
                VibratorUtils.c();
            } else {
                VibratorUtils.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void i1() {
        List<TargetPoints> targetPoints;
        this.mNeedRecover = getIntent().getBooleanExtra(t, false);
        StartRunPageParam startRunPageParam = (StartRunPageParam) getIntent().getParcelableExtra(x);
        this.startRunPageParam = startRunPageParam;
        if (startRunPageParam == null) {
            return;
        }
        this.startRunEntity = startRunPageParam.getStartRunEntity();
        this.schoolGeoFenceDetail = startRunPageParam.getGeoFenceDetail();
        this.useCreditSword = startRunPageParam.getUseCreditSword();
        this.amapGPSLevel = startRunPageParam.getAmapGPSLevel();
        StartRunEntity startRunEntity = this.startRunEntity;
        if (startRunEntity == null || (targetPoints = startRunEntity.getTargetPoints()) == null) {
            return;
        }
        Collections.sort(targetPoints);
    }

    public final void i2(boolean isHitErrCondition, int restTotalSec) {
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService == null || sunshineRunService.finishRun(isHitErrCondition) == 0) {
            return;
        }
        e2(restTotalSec);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        SunRunStartAnimDialog.Companion aVar = SunRunStartAnimDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        aVar.a(supportFragmentManager, new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity.initData.1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m695invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m695invoke() {
                SunshineRunActivity.this.N1();
            }
        });
        v1();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        x1();
        t1();
    }

    public final void j1() {
        FaceRecognitionTipDialog faceRecognitionTipDialog = this.faceRecognitionTip;
        boolean z = false;
        if (faceRecognitionTipDialog != null && faceRecognitionTipDialog.isAdded()) {
            z = true;
        }
        if (z) {
            FaceRecognitionTipDialog faceRecognitionTipDialog2 = this.faceRecognitionTip;
            if (faceRecognitionTipDialog2 != null) {
                faceRecognitionTipDialog2.dismissAllowingStateLoss();
            }
            this.faceRecognitionTip = null;
        }
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService != null) {
            sunshineRunService.restoreShowFaceRecognitionTip();
        }
    }

    public final void k1() {
        RunQuitConfirmDialog runQuitConfirmDialog;
        RunPauseDialog runPauseDialog;
        try {
            RunPauseDialog runPauseDialog2 = this.mPauseDialog;
            boolean z = false;
            if ((runPauseDialog2 != null && runPauseDialog2.isShowing()) && (runPauseDialog = this.mPauseDialog) != null) {
                runPauseDialog.dismissAllowingStateLoss();
            }
            this.mPauseDialog = null;
            RunQuitConfirmDialog runQuitConfirmDialog2 = this.mQuitConfirmDialog;
            if (runQuitConfirmDialog2 != null && runQuitConfirmDialog2.isShowing()) {
                z = true;
            }
            if (z && (runQuitConfirmDialog = this.mQuitConfirmDialog) != null) {
                runQuitConfirmDialog.dismissAllowingStateLoss();
            }
            this.mQuitConfirmDialog = null;
            getMBinding().f11620a.hide();
            getMBinding().f11622a.setEnabled(true);
            getMBinding().f11621a.onResume();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public final void k2(boolean locked) {
        DataComponent dataComponent;
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService != null && (dataComponent = sunshineRunService.getDataComponent()) != null) {
            dataComponent.m2(locked);
        }
        p2();
    }

    public final void l1() {
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService != null) {
            sunshineRunService.setDurationCallBack(new BaseRunService.DurationCallBack() { // from class: com.zj.adlib.pv8
                @Override // com.huachenjie.run.service.BaseRunService.DurationCallBack
                public final void a(PauseTimerType pauseTimerType, long j2) {
                    SunshineRunActivity.m1(this.f44067a, pauseTimerType, j2);
                }
            });
        }
        SunshineRunService sunshineRunService2 = this.sunshineRunService;
        if (sunshineRunService2 != null) {
            sunshineRunService2.setDataCallBack(new BaseRunService.DataChangeCallBack() { // from class: com.zj.adlib.qv8
                @Override // com.huachenjie.run.service.BaseRunService.DataChangeCallBack
                public final void a(BaseRunService.DataChangeCallBack.DataType dataType, DataComponent dataComponent) {
                    SunshineRunActivity.n1(this.f44309a, dataType, dataComponent);
                }
            });
        }
        SunshineRunService sunshineRunService3 = this.sunshineRunService;
        if (sunshineRunService3 != null) {
            sunshineRunService3.setRunStateChangeListeners(new RunStateChangeListener() { // from class: com.zj.adlib.rv8
                @Override // com.huachenjie.common.run_interface.RunStateChangeListener
                public final void b(RunStateChangeListener.State state, Map map) {
                    SunshineRunActivity.o1(this.f44544a, state, map);
                }
            });
        }
        SunshineRunService sunshineRunService4 = this.sunshineRunService;
        if (sunshineRunService4 != null) {
            sunshineRunService4.setPauseDurationCallBack(new BaseRunService.DurationCallBack() { // from class: com.zj.adlib.sv8
                @Override // com.huachenjie.run.service.BaseRunService.DurationCallBack
                public final void a(PauseTimerType pauseTimerType, long j2) {
                    SunshineRunActivity.p1(this.f44784a, pauseTimerType, j2);
                }
            });
        }
        SunshineRunService sunshineRunService5 = this.sunshineRunService;
        if (sunshineRunService5 != null) {
            sunshineRunService5.setOnNotificationModStateCB(new e());
        }
    }

    public final void l2(PauseTimerType type) {
        if (isDestroyed()) {
            return;
        }
        SunshineRunService sunshineRunService = this.sunshineRunService;
        DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
        if (dataComponent != null) {
            c2(type, dataComponent);
        }
        dw8 dw8Var = this.mRunOverlay;
        if (dw8Var != null) {
            dw8Var.v0();
        }
    }

    public final void m2() {
        k1();
        dw8 dw8Var = this.mRunOverlay;
        if (dw8Var != null) {
            dw8Var.w0();
        }
    }

    public final void n2() {
        DataComponent dataComponent;
        SunshineRunServiceData sunshineRunServiceDataU1;
        SunshineRunFaceCheckData faceCheckData;
        dw8 dw8Var = this.mRunOverlay;
        if (dw8Var == null) {
            return;
        }
        SunshineRunService sunshineRunService = this.sunshineRunService;
        List<SunshineRunFaceRecord> faceCheckRecordList = (sunshineRunService == null || (dataComponent = sunshineRunService.getDataComponent()) == null || (sunshineRunServiceDataU1 = dataComponent.u1()) == null || (faceCheckData = sunshineRunServiceDataU1.getFaceCheckData()) == null) ? null : faceCheckData.getFaceCheckRecordList();
        if (CollectionUtils.r(faceCheckRecordList) || faceCheckRecordList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SunshineRunFaceRecord sunshineRunFaceRecord : faceCheckRecordList) {
            Double checkLat = sunshineRunFaceRecord.getCheckLat();
            Double checkLng = sunshineRunFaceRecord.getCheckLng();
            if (checkLat != null && checkLng != null) {
                arrayList.add(TuplesKt.to(Boolean.valueOf(sunshineRunFaceRecord.getRunFaceUpload()), new HCJLatLng(checkLat.doubleValue(), checkLng.doubleValue())));
            }
        }
        if (CollectionUtils.r(arrayList)) {
            return;
        }
        dw8Var.l(arrayList);
    }

    public final void o2() {
        if (this.serviceInit && this.mapInit) {
            w1();
            SunshineRunService sunshineRunService = this.sunshineRunService;
            DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
            if (dataComponent == null) {
                return;
            }
            List<HCJGeoFence> listR1 = dataComponent.r1();
            GeoFenceViewComponent geoFenceViewComponent = this.mGeoFenceViewComponent;
            if (geoFenceViewComponent != null) {
                geoFenceViewComponent.c(listR1);
            }
            e1(true);
            s2(dataComponent);
            u1();
            n2();
            H1();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        il2.unregisterReceiver(this, this.detectReceiver);
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService != null) {
            sunshineRunService.setDataCallBack(null);
            sunshineRunService.setPauseDurationCallBack(null);
            sunshineRunService.setDurationCallBack(null);
            sunshineRunService.setRunStateChangeListeners(new RunStateChangeListener[0]);
        }
        stopService();
        dw8 dw8Var = this.mRunOverlay;
        if (dw8Var != null) {
            dw8Var.h0();
        }
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            if (hCJMapFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
                hCJMapFragment = null;
            }
            hCJMapFragment.clear(false);
        }
        k1();
        g1().removeCallbacksAndMessages(null);
        in6.f42394a.a();
        h2(false);
        super.onDestroy();
    }

    public void onMapLoaded() {
        this.mapInit = true;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        HCJMapFragment hCJMapFragment2 = null;
        if (hCJMapFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            hCJMapFragment = null;
        }
        GeoFenceViewComponent geoFenceViewComponent = new GeoFenceViewComponent(hCJMapFragment.getMap());
        geoFenceViewComponent.k(h1());
        getLifecycle().addObserver(geoFenceViewComponent);
        this.mGeoFenceViewComponent = geoFenceViewComponent;
        HCJMapFragment hCJMapFragment3 = this.mMapFragment;
        if (hCJMapFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            hCJMapFragment3 = null;
        }
        hCJMapFragment3.setOnOritationChangeListener(new HCJMapFragment.OrientationChangeListener() { // from class: com.zj.adlib.tv8
            public final void onOrientationChange(float f2) {
                SunshineRunActivity.F1(this.f45015a, f2);
            }
        });
        kl7 kl7Var = kl7.f42851a;
        if (kl7Var.b(this.startRunEntity) != null) {
            HCJMapFragment hCJMapFragment4 = this.mMapFragment;
            if (hCJMapFragment4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
                hCJMapFragment4 = null;
            }
            hCJMapFragment4.animateTo(kl7Var.b(this.startRunEntity), 16.0f);
        }
        o2();
        HCJMapFragment hCJMapFragment5 = this.mMapFragment;
        if (hCJMapFragment5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            hCJMapFragment5 = null;
        }
        if (hCJMapFragment5.getMap() == null) {
            return;
        }
        HCJMapFragment hCJMapFragment6 = this.mMapFragment;
        if (hCJMapFragment6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
        } else {
            hCJMapFragment2 = hCJMapFragment6;
        }
        Object real = hCJMapFragment2.getMap().getReal();
        if (real instanceof AMap) {
            ((AMap) real).setMapType(r90.j());
            p2();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        q2();
        this.isOnForeground = false;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        this.isActivityRestore = true;
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isOnForeground = true;
        Q1();
        C1();
        SunshineRunService sunshineRunService = this.sunshineRunService;
        if (sunshineRunService != null) {
            sunshineRunService.queryNfcVerificationIfNeeded();
        }
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    @Nullable
    /* JADX INFO: renamed from: p, reason: from getter */
    public TextView getSideTextView() {
        return this.sideTextView;
    }

    public final void p2() {
        HCJAddressInfo hCJAddressInfoB1;
        SunshineRunService sunshineRunService = this.sunshineRunService;
        Integer numValueOf = null;
        DataComponent dataComponent = sunshineRunService != null ? sunshineRunService.getDataComponent() : null;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            if (hCJMapFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
                hCJMapFragment = null;
            }
            HCJMap map = hCJMapFragment.getMap();
            Object real = map != null ? map.getReal() : null;
            AMap aMap = real instanceof AMap ? (AMap) real : null;
            if (aMap != null) {
                numValueOf = Integer.valueOf(aMap.getMapType());
            }
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : r90.j();
        SunshineRunVM mViewModel = getMViewModel();
        StartRunEntity startRunEntity = this.startRunEntity;
        mViewModel.R(startRunEntity != null && startRunEntity.isRunActivityFlag(), this.amapGPSLevel == 2, (dataComponent == null || (hCJAddressInfoB1 = dataComponent.b1()) == null) ? 0 : hCJAddressInfoB1.getSatellites(), dataComponent == null || !dataComponent.N1(), dataComponent != null ? dataComponent.F1() : false, iIntValue == 2);
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public void q(@Nullable TextView view) {
        this.sideTextView = view;
    }

    public final void q1() {
        getMBinding().f11615a.setVisibility(this.useCreditSword ? 0 : 8);
        g1().postDelayed(new Runnable() { // from class: com.zj.adlib.ov8
            @Override // java.lang.Runnable
            public final void run() {
                SunshineRunActivity.r1(this.f43843a);
            }
        }, 12000L);
    }

    public final void q2() {
        NetStateReceiver netStateReceiver = this.mNetStateReceiver;
        if (netStateReceiver != null) {
            unregisterReceiver(netStateReceiver);
        }
    }

    public final void r2(HCJAddressInfo addressInfo, List<? extends RunLatLng> pathList) {
        if (addressInfo != null) {
            if (addressInfo.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return;
            }
            dw8 dw8Var = this.mRunOverlay;
            if (dw8Var != null) {
                dw8Var.z0(pathList);
            }
            HCJMapFragment hCJMapFragment = this.mMapFragment;
            if (hCJMapFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
                hCJMapFragment = null;
            }
            hCJMapFragment.showMyLocationMarker(new HCJLatLng(addressInfo.getLat(), addressInfo.getLng()), -addressInfo.getDirection(), false);
        }
    }

    public final void resume() {
        m2();
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return true;
    }

    public final void s1() {
        f fVar = new f();
        this.gpsCheckRunnable = fVar;
        g1().postDelayed(fVar, 10000L);
    }

    public final void s2(DataComponent dataComponent) {
        List<TargetPoints> targetPoints = dataComponent.getTargetPoints();
        if (CollectionUtils.r(targetPoints)) {
            return;
        }
        int iD1 = dataComponent.d1();
        Intrinsics.checkNotNullExpressionValue(targetPoints, "targetPoints");
        b1(targetPoints, iD1);
    }

    public final void stopService() {
        try {
            unbindService(this.runServiceConnection);
        } catch (Exception unused) {
        }
        SunshineRunService.stopService(this);
    }

    public final void t1() {
        HCJMapAdapter hCJMapEntry = HCJMapEntry.getInstance();
        this.mMapAdapter = hCJMapEntry;
        HCJMapFragment hCJMapFragmentCreateMapFragment = hCJMapEntry.createMapFragment();
        Intrinsics.checkNotNullExpressionValue(hCJMapFragmentCreateMapFragment, "mapAdapter.createMapFragment()");
        this.mMapFragment = hCJMapFragmentCreateMapFragment;
        HCJMapFragment hCJMapFragment = null;
        if (hCJMapFragmentCreateMapFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            hCJMapFragmentCreateMapFragment = null;
        }
        hCJMapFragmentCreateMapFragment.addOnMapLoadedListener(this);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        int i2 = R.id.mapContainer;
        Fragment fragment = this.mMapFragment;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            fragment = null;
        }
        fragmentTransactionBeginTransaction.replace(i2, fragment).commit();
        HCJMapFragment hCJMapFragment2 = this.mMapFragment;
        if (hCJMapFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            hCJMapFragment2 = null;
        }
        hCJMapFragment2.setMyLocationMarkerRes(R.drawable.run_ic_my_location);
        HCJMapFragment hCJMapFragment3 = this.mMapFragment;
        if (hCJMapFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
        } else {
            hCJMapFragment = hCJMapFragment3;
        }
        hCJMapFragment.setMyLocationEnable(Boolean.TRUE);
    }

    public final void t2(PauseTimerType type, long pauseLeftSecs, int pauseReason) {
        RunPauseDialog runPauseDialog;
        NfcPauseTipDialog nfcPauseTipDialog;
        int i2 = c.c[type.ordinal()];
        if (i2 == 1) {
            RunPauseDialog runPauseDialog2 = this.mPauseDialog;
            if (!(runPauseDialog2 != null && runPauseDialog2.isShowing()) || (runPauseDialog = this.mPauseDialog) == null) {
                return;
            }
            runPauseDialog.updateLeftTime(pauseLeftSecs);
            return;
        }
        if (i2 == 2) {
            getMBinding().f11620a.setLastedDuration(pauseLeftSecs, pauseReason);
            return;
        }
        if (i2 == 3) {
            DetectFaceFragment detectFaceFragment = this.detectFaceFragment;
            if (detectFaceFragment != null) {
                detectFaceFragment.setCountdown(pauseLeftSecs);
                return;
            }
            return;
        }
        if (i2 == 4 && (nfcPauseTipDialog = this.nfcPauseTipDialog) != null) {
            if (pauseLeftSecs > 0) {
                nfcPauseTipDialog.updateLeftSeconds((int) pauseLeftSecs);
                return;
            }
            nfcPauseTipDialog.dismissAllowingStateLoss();
            this.nfcPauseTipDialog = null;
            L1();
        }
    }

    public final void u1() {
        getMBinding().f11621a.setOnTimeout(new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$initPaceErrorProps$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m696invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m696invoke() {
                DataComponent dataComponent;
                SunshineRunActivity.o0(this.this$0).j();
                t26 t26Var = t26.f44833a;
                SunshineRunActivity sunshineRunActivity = this.this$0;
                String strE = ys8.e(R.string.hcj_app_name);
                Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.hcj_app_name)");
                String strE2 = ys8.e(R.string.run_auto_stop_notification_content_speed_error_out);
                Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.run_a…_content_speed_error_out)");
                t26Var.e(sunshineRunActivity, 1236, strE, strE2, null);
                SunshineRunService sunshineRunService = this.this$0.sunshineRunService;
                if (sunshineRunService != null && (dataComponent = sunshineRunService.getDataComponent()) != null) {
                    dataComponent.o2(((long) this.this$0.getMBinding().f11621a.getTotalSecs()) * 1000, PauseTimerType.SPEED_ERROR);
                }
                SunshineRunActivity.j2(this.this$0, true, 0, 2, null);
            }
        });
    }

    public final void u2(RunStateChangeListener.State state, Map<String, ? extends Object> map) {
        if (RunStateChangeListener.State.finish == state || this.state != state) {
            this.state = state;
            switch (c.b[state.ordinal()]) {
                case 1:
                    K1(PauseTimerType.AUTO);
                    j1();
                    break;
                case 2:
                    K1(PauseTimerType.REST);
                    j1();
                    break;
                case 3:
                    K1(PauseTimerType.FACE_RECOGNITION);
                    resume();
                    break;
                case 4:
                    K1(PauseTimerType.NFC_CHECK);
                    break;
                case 5:
                    resume();
                    break;
                case 6:
                    k1();
                    j1();
                    getMBinding().f11621a.hide();
                    D1(map);
                    h2(false);
                    break;
            }
        }
    }

    public final void v1() {
        BDLocationResultHelper.g(this, new Function1<String, Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$initReceiver$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "s");
                SunshineRunActivity.o0(this.this$0).s().setValue(str);
            }
        });
    }

    public final void w1() {
        HCJAddressInfo hCJAddressInfo;
        DataComponent dataComponent;
        SunshineRunService sunshineRunService = this.sunshineRunService;
        int iO1 = (sunshineRunService == null || (dataComponent = sunshineRunService.getDataComponent()) == null) ? 0 : dataComponent.o1();
        int iA = kl7.f42851a.a(this.startRunEntity, this.schoolGeoFenceDetail);
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMapFragment");
            hCJMapFragment = null;
        }
        dw8 dw8Var = new dw8(this, hCJMapFragment.getMap(), iA, iO1);
        this.mRunOverlay = dw8Var;
        StartRunEntity startRunEntity = this.startRunEntity;
        List<TargetPoints> targetPoints = startRunEntity != null ? startRunEntity.getTargetPoints() : null;
        if (this.startRunEntity == null || CollectionUtils.r(targetPoints)) {
            HCJAddressInfo hCJAddressInfoO = r90.o();
            if (hCJAddressInfoO != null) {
                hCJAddressInfo = (hCJAddressInfoO.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) ^ true ? hCJAddressInfoO : null;
                if (hCJAddressInfo != null) {
                    dw8Var.N(new HCJLatLng(hCJAddressInfo.getLat(), hCJAddressInfo.getLng()), jj8.a(100.0f));
                    return;
                }
                return;
            }
            return;
        }
        if (targetPoints == null) {
            return;
        }
        for (TargetPoints targetPoints2 : targetPoints) {
            if (iA == 1 && targetPoints2.getType() == 1) {
                dw8Var.t(new HCJLatLng(targetPoints2.getLat(), targetPoints2.getLng()), targetPoints2.getPassStatus(), targetPoints2.getSimpleName(), targetPoints2.getNfcEnable());
            } else if (iA == 1 && targetPoints2.getType() == 2) {
                dw8Var.z(new HCJLatLng(targetPoints2.getLat(), targetPoints2.getLng()), targetPoints2.getPassStatus(), targetPoints2.getSimpleName(), targetPoints2.getNfcEnable());
            } else if (iA == 2 || iA == 3) {
                dw8Var.o(new HCJLatLng(targetPoints2.getLat(), targetPoints2.getLng()), targetPoints2.getPassStatus(), targetPoints2.getSort(), targetPoints2.getSimpleName(), targetPoints2.getNfcEnable());
            }
        }
        HCJAddressInfo hCJAddressInfoO2 = r90.o();
        if (hCJAddressInfoO2 != null) {
            hCJAddressInfo = (hCJAddressInfoO2.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) ^ true ? hCJAddressInfoO2 : null;
            if (hCJAddressInfo != null) {
                dw8Var.N(new HCJLatLng(hCJAddressInfo.getLat(), hCJAddressInfo.getLng()), jj8.a(100.0f));
            }
        }
    }

    public final void x1() {
        com.gyf.immersionbar.e.p3(this).j3().a1();
        p2();
        getMBinding().f11622a.setOnActionClick(new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$initRunViews$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m697invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m697invoke() {
                this.this$0.A1();
            }
        });
        getMBinding().f11622a.setOnActionLongPress(new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$initRunViews$2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m698invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m698invoke() {
                SunshineRunActivity.j2(this.this$0, false, 0, 2, null);
            }
        });
        getMBinding().f11623a.setOnPauseClick(new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$initRunViews$3
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m699invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m699invoke() {
                this.this$0.A1();
                this.this$0.getMBinding().f11623a.collapse();
            }
        });
        getMBinding().f11623a.setOnQuitConfirm(new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$initRunViews$4
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m700invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m700invoke() {
                SunshineRunActivity.j2(this.this$0, false, 0, 2, null);
            }
        });
    }

    public final void y1() {
        k2(true);
        ScreenLockDialog.Companion companion = ScreenLockDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        companion.a(supportFragmentManager, new Function0<Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$lockScreen$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m701invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m701invoke() {
                this.this$0.k2(false);
            }
        });
    }

    public final void z1() {
        getMViewModel().x().observe(this, new i(new Function1<PaceErrorBigState, Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$observerData$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PaceErrorBigState) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PaceErrorBigState paceErrorBigState) {
                if (paceErrorBigState.j()) {
                    this.this$0.j1();
                }
            }
        }));
        ew.k().observe(this, new i(new Function1<String, Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$observerData$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                SunshineRunActivity.o0(this.this$0).Q().setValue(str);
            }
        }));
        ew.e().observe(this, new i(new Function1<String, Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$observerData$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                SunshineRunActivity.o0(this.this$0).r().setValue(str);
            }
        }));
        getMViewModel().M().observe(this, new i(new Function1<String, Unit>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunActivity$observerData$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                TextView sideTextView;
                if ((str == null || str.length() == 0) || (sideTextView = this.this$0.getSideTextView()) == null) {
                    return;
                }
                sideTextView.setText(str);
            }
        }));
    }
}
