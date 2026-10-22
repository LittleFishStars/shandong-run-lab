package com.huachenjie.common.util.media_picker;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.R;
import com.huachenjie.common.dialog.OnItemClickListener;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ImageCompressConfig;
import com.zj.adlib.PendingSession;
import com.zj.adlib.PickedMedia;
import com.zj.adlib.VideoPickConfig;
import com.zj.adlib.af5;
import com.zj.adlib.fq6;
import com.zj.adlib.kz0;
import com.zj.adlib.p59;
import com.zj.adlib.vo6;
import com.zj.adlib.y6b;
import com.zj.adlib.zq6;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BY\b\u0000\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010C\u001a\u00020A\u0012\f\u0010G\u001a\b\u0012\u0004\u0012\u00020E0D\u0012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020E0D\u0012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\t0D\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00030D\u0012\u0006\u0010P\u001a\u00020N¢\u0006\u0004\bT\u0010UJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J2\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0016\u0010\u001a\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\u001e\u001a\u00020\u00052\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0018H\u0002J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0018H\u0002J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJB\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00182\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0007JV\u0010.\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00182\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\u0013H\u0007JD\u0010/\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\u0013H\u0007J.\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u0013H\u0007J\u0012\u00103\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0007H\u0007J\u000e\u00104\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0007J8\u00105\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u0013H\u0007J\u001d\u00106\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0013H\u0000¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010BR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020E0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020E0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010FR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\t0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010FR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00030D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010FR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010OR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010R¨\u0006V"}, d2 = {"Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "", "", "Landroid/net/Uri;", "uris", "", "k", "", "resultCode", "Landroid/content/Intent;", "data", y6b.g, "sourceUri", "Z", "Lcom/huachenjie/common/util/media_picker/b;", "request", "f", "imageMaxWidth", "imageMaxSize", "", "needCrop", "", "aspectRatioX", "aspectRatioY", "", "e", "O", "Lkotlin/Function0;", "Lcom/zj/adlib/wq6;", "block", "M", "P", "m", "code", "message", "n", "Landroid/content/ActivityNotFoundException;", c.f25231a, "fallbackMessage", j.b, t.d, "permissionMessage", "f0", "cameraMessage", "maxSelectNum", "allowGif", "X", "v", "max", "A", "maxVideoDurationSeconds", "J", "L", "G", "i", "(Ljava/util/List;)V", "success", "j", "(Z)V", y6b.f, "(ILandroid/content/Intent;)V", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/PickVisualMediaRequest;", "Landroidx/activity/result/ActivityResultLauncher;", "singleLauncher", "b", "multipleLauncher", "c", "activityResultLauncher", "d", "takePictureLauncher", "Lcom/zj/adlib/af5;", "Lcom/zj/adlib/af5;", "maxCountRef", "Lcom/zj/adlib/yn6;", "Lcom/zj/adlib/yn6;", "pending", "<init>", "(Landroid/content/Context;Lcom/huachenjie/common/util/media_picker/MediaPickerListener;Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/ActivityResultLauncher;Lcom/zj/adlib/af5;)V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMediaPicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaPicker.kt\ncom/huachenjie/common/util/media_picker/MediaPickerLauncher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,480:1\n1#2:481\n*E\n"})
public final class MediaPickerLauncher {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Context context;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<PickVisualMediaRequest> singleLauncher;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MediaPickerListener listener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final af5 maxCountRef;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public PendingSession pending;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<PickVisualMediaRequest> multipleLauncher;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> activityResultLauncher;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Uri> takePictureLauncher;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/common/util/media_picker/MediaPickerLauncher$a", "Lcom/huachenjie/common/dialog/OnItemClickListener;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f33923a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ int f8914a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f8916a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f8917a;
        public final /* synthetic */ float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ int f8918b;

        public a(String str, int i, int i2, boolean z, float f, float f2) {
            this.f8916a = str;
            this.f8914a = i;
            this.f8918b = i2;
            this.f8917a = z;
            this.f33923a = f;
            this.b = f2;
        }

        @Override // com.huachenjie.common.dialog.OnItemClickListener
        public void a() {
            MediaPickerLauncher.this.f0(this.f8916a, this.f8914a, this.f8918b, this.f8917a, this.f33923a, this.b);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/common/util/media_picker/MediaPickerLauncher$b", "Lcom/huachenjie/common/dialog/OnItemClickListener;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f33924a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ int f8919a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MediaPickerLauncher f8920a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f8921a;
        public final /* synthetic */ float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ int f8922b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ boolean f8923b;
        public final /* synthetic */ int c;

        public b(int i, MediaPickerLauncher mediaPickerLauncher, int i2, int i3, boolean z, float f, float f2, boolean z2) {
            this.f8919a = i;
            this.f8920a = mediaPickerLauncher;
            this.f8922b = i2;
            this.c = i3;
            this.f8921a = z;
            this.f33924a = f;
            this.b = f2;
            this.f8923b = z2;
        }

        @Override // com.huachenjie.common.dialog.OnItemClickListener
        public void a() {
            int i = this.f8919a;
            if (i <= 1) {
                this.f8920a.v(this.f8922b, this.c, this.f8921a, this.f33924a, this.b, this.f8923b);
            } else {
                this.f8920a.A(i, this.f8922b, this.c, this.f8923b);
            }
        }
    }

    public MediaPickerLauncher(@NotNull Context context, @NotNull MediaPickerListener mediaPickerListener, @NotNull ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncher, @NotNull ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncher2, @NotNull ActivityResultLauncher<Intent> activityResultLauncher3, @NotNull ActivityResultLauncher<Uri> activityResultLauncher4, @NotNull af5 af5Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaPickerListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        Intrinsics.checkNotNullParameter(activityResultLauncher, "singleLauncher");
        Intrinsics.checkNotNullParameter(activityResultLauncher2, "multipleLauncher");
        Intrinsics.checkNotNullParameter(activityResultLauncher3, "activityResultLauncher");
        Intrinsics.checkNotNullParameter(activityResultLauncher4, "takePictureLauncher");
        Intrinsics.checkNotNullParameter(af5Var, "maxCountRef");
        this.context = context;
        this.listener = mediaPickerListener;
        this.singleLauncher = activityResultLauncher;
        this.multipleLauncher = activityResultLauncher2;
        this.activityResultLauncher = activityResultLauncher3;
        this.takePictureLauncher = activityResultLauncher4;
        this.maxCountRef = af5Var;
        this.pending = new PendingSession(null, 0, null, null, null, null, null, null, false, 511, null);
    }

    public static /* synthetic */ void B(MediaPickerLauncher mediaPickerLauncher, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        if ((i4 & 8) != 0) {
            z = false;
        }
        mediaPickerLauncher.A(i, i2, i3, z);
    }

    public static /* synthetic */ void H(MediaPickerLauncher mediaPickerLauncher, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        mediaPickerLauncher.G(i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? false : z);
    }

    public static /* synthetic */ void K(MediaPickerLauncher mediaPickerLauncher, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        mediaPickerLauncher.J(i);
    }

    public static final void N(Function0 function0, MediaPickerLauncher mediaPickerLauncher) {
        Intrinsics.checkNotNullParameter(function0, "$block");
        Intrinsics.checkNotNullParameter(mediaPickerLauncher, "this$0");
        try {
            List<PickedMedia> list = (List) function0.invoke();
            mediaPickerLauncher.P();
            MediaPicker.f8903a.t(mediaPickerLauncher.listener, list);
        } catch (MediaPickerProcessException e) {
            mediaPickerLauncher.P();
            MediaPicker mediaPicker = MediaPicker.f8903a;
            MediaPickerListener mediaPickerListener = mediaPickerLauncher.listener;
            String message = e.getMessage();
            if (message == null) {
                message = "Media processing failed";
            }
            mediaPicker.p(mediaPickerListener, 1, message);
        }
    }

    public static /* synthetic */ void Y(MediaPickerLauncher mediaPickerLauncher, String str, int i, int i2, int i3, boolean z, float f, float f2, boolean z2, int i4, Object obj) {
        mediaPickerLauncher.X(str, (i4 & 2) != 0 ? 1 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? false : z, (i4 & 32) != 0 ? 1.0f : f, (i4 & 64) == 0 ? f2 : 1.0f, (i4 & 128) == 0 ? z2 : false);
    }

    public static /* synthetic */ void g0(MediaPickerLauncher mediaPickerLauncher, String str, int i, int i2, boolean z, float f, float f2, int i3, Object obj) {
        mediaPickerLauncher.f0(str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) == 0 ? z : false, (i3 & 16) != 0 ? 1.0f : f, (i3 & 32) == 0 ? f2 : 1.0f);
    }

    public static final void h0(MediaPickerLauncher mediaPickerLauncher, boolean z) {
        Intrinsics.checkNotNullParameter(mediaPickerLauncher, "this$0");
        if (!z) {
            mediaPickerLauncher.m();
            return;
        }
        Pair<File, Uri> pairA = fq6.f41732a.a(mediaPickerLauncher.context);
        if (pairA == null) {
            mediaPickerLauncher.n(3, "Failed to create camera output file");
            return;
        }
        File file = (File) pairA.component1();
        Uri uri = (Uri) pairA.component2();
        mediaPickerLauncher.pending.w(file);
        mediaPickerLauncher.pending.x(uri);
        try {
            mediaPickerLauncher.takePictureLauncher.launch(uri);
        } catch (ActivityNotFoundException e) {
            mediaPickerLauncher.pending.a();
            mediaPickerLauncher.o(e, "Failed to launch camera");
        }
    }

    public static /* synthetic */ void w(MediaPickerLauncher mediaPickerLauncher, int i, int i2, boolean z, float f, float f2, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            f = 1.0f;
        }
        if ((i3 & 16) != 0) {
            f2 = 1.0f;
        }
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        mediaPickerLauncher.v(i, i2, z, f, f2, z2);
    }

    @JvmOverloads
    public final void A(int max, int imageMaxWidth, int imageMaxSize, boolean allowGif) {
        l(MediaPickerRequest.INSTANCE.d(max, imageMaxWidth, imageMaxSize, allowGif));
    }

    @JvmOverloads
    public final void C(int i) {
        H(this, i, 0, 0, 0, false, 30, null);
    }

    @JvmOverloads
    public final void D(int i, int i2) {
        H(this, i, i2, 0, 0, false, 28, null);
    }

    @JvmOverloads
    public final void E(int i, int i2, int i3) {
        H(this, i, i2, i3, 0, false, 24, null);
    }

    @JvmOverloads
    public final void F(int i, int i2, int i3, int i4) {
        H(this, i, i2, i3, i4, false, 16, null);
    }

    @JvmOverloads
    public final void G(int max, int imageMaxWidth, int imageMaxSize, int maxVideoDurationSeconds, boolean allowGif) {
        l(MediaPickerRequest.INSTANCE.j(max, imageMaxWidth, imageMaxSize, maxVideoDurationSeconds, allowGif));
    }

    @JvmOverloads
    public final void I() {
        K(this, 0, 1, null);
    }

    @JvmOverloads
    public final void J(int maxVideoDurationSeconds) {
        l(MediaPickerRequest.INSTANCE.u(maxVideoDurationSeconds));
    }

    public final void L(int max) {
        l(MediaPickerRequest.INSTANCE.w(max));
    }

    public final void M(final Function0<? extends List<PickedMedia>> block) {
        MediaPicker.f8903a.r(this.listener);
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.sk5
            @Override // java.lang.Runnable
            public final void run() {
                MediaPickerLauncher.N(block, this);
            }
        });
    }

    public final void O(final List<? extends Uri> uris) {
        M(new Function0<List<? extends PickedMedia>>() { // from class: com.huachenjie.common.util.media_picker.MediaPickerLauncher$processUrisAsync$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @NotNull
            public final List<PickedMedia> invoke() {
                zq6 zq6Var = zq6.f46321a;
                Context applicationContext = this.this$0.context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                return zq6Var.h(applicationContext, uris, this.this$0.pending.t(), this.this$0.pending.p(), this.this$0.pending.u());
            }
        });
    }

    public final void P() {
        this.pending = new PendingSession(null, 0, null, null, null, null, null, null, false, 511, null);
    }

    @JvmOverloads
    public final void Q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        Y(this, str, 0, 0, 0, false, 0.0f, 0.0f, false, 254, null);
    }

    @JvmOverloads
    public final void R(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        Y(this, str, i, 0, 0, false, 0.0f, 0.0f, false, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, null);
    }

    @JvmOverloads
    public final void S(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        Y(this, str, i, i2, 0, false, 0.0f, 0.0f, false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, null);
    }

    @JvmOverloads
    public final void T(@NotNull String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        Y(this, str, i, i2, i3, false, 0.0f, 0.0f, false, 240, null);
    }

    @JvmOverloads
    public final void U(@NotNull String str, int i, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        Y(this, str, i, i2, i3, z, 0.0f, 0.0f, false, 224, null);
    }

    @JvmOverloads
    public final void V(@NotNull String str, int i, int i2, int i3, boolean z, float f) {
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        Y(this, str, i, i2, i3, z, f, 0.0f, false, 192, null);
    }

    @JvmOverloads
    public final void W(@NotNull String str, int i, int i2, int i3, boolean z, float f, float f2) {
        Intrinsics.checkNotNullParameter(str, "cameraMessage");
        Y(this, str, i, i2, i3, z, f, f2, false, 128, null);
    }

    @JvmOverloads
    public final void X(@NotNull String cameraMessage, int maxSelectNum, int imageMaxWidth, int imageMaxSize, boolean needCrop, float aspectRatioX, float aspectRatioY, boolean allowGif) {
        Intrinsics.checkNotNullParameter(cameraMessage, "cameraMessage");
        if (needCrop && maxSelectNum > 1) {
            n(1, "Crop is only supported for single image selection");
            return;
        }
        kz0.INSTANCE.a().f(this.context.getString(R.string.take_camera), new a(cameraMessage, imageMaxWidth, imageMaxSize, needCrop, aspectRatioX, aspectRatioY)).f(this.context.getString(R.string.pick_from_gallery), new b(maxSelectNum, this, imageMaxWidth, imageMaxSize, needCrop, aspectRatioX, aspectRatioY, allowGif)).g(this.context).show();
    }

    public final void Z(Uri sourceUri) {
        PickerCropHelper pickerCropHelper = PickerCropHelper.f33928a;
        Uri uriD = pickerCropHelper.d(this.context);
        if (uriD == null) {
            n(3, "Failed to create crop output file");
            return;
        }
        this.pending.y(uriD);
        this.pending.v(true);
        try {
            this.activityResultLauncher.launch(pickerCropHelper.c(this.context, sourceUri, uriD, this.pending.q()));
        } catch (ActivityNotFoundException e) {
            this.pending.y(null);
            this.pending.v(false);
            o(e, "Failed to launch image crop");
        }
    }

    @JvmOverloads
    public final void a0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "permissionMessage");
        g0(this, str, 0, 0, false, 0.0f, 0.0f, 62, null);
    }

    @JvmOverloads
    public final void b0(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "permissionMessage");
        g0(this, str, i, 0, false, 0.0f, 0.0f, 60, null);
    }

    @JvmOverloads
    public final void c0(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "permissionMessage");
        g0(this, str, i, i2, false, 0.0f, 0.0f, 56, null);
    }

    @JvmOverloads
    public final void d0(@NotNull String str, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "permissionMessage");
        g0(this, str, i, i2, z, 0.0f, 0.0f, 48, null);
    }

    public final String e(int imageMaxWidth, int imageMaxSize, boolean needCrop, float aspectRatioX, float aspectRatioY) {
        ImageCompressConfig imageCompressConfig = new ImageCompressConfig(imageMaxWidth, imageMaxSize, false);
        String strJ = imageCompressConfig.j();
        if (strJ != null) {
            return strJ;
        }
        PendingSession pendingSession = this.pending;
        this.pending = pendingSession.k((482 & 1) != 0 ? pendingSession.pickType : PickType.IMAGE, (482 & 2) != 0 ? pendingSession.maxCount : 0, (482 & 4) != 0 ? pendingSession.compress : imageCompressConfig, (482 & 8) != 0 ? pendingSession.crop : needCrop ? ImageCropConfig.INSTANCE.d(aspectRatioX, aspectRatioY) : new ImageCropConfig(false, 0.0f, 0.0f, 7, null), (482 & 16) != 0 ? pendingSession.video : new VideoPickConfig(0, 1, null), (482 & 32) != 0 ? pendingSession.cameraFile : null, (482 & 64) != 0 ? pendingSession.cameraUri : null, (482 & 128) != 0 ? pendingSession.cropDestinationUri : null, (482 & 256) != 0 ? pendingSession.awaitingCropResult : false);
        return null;
    }

    @JvmOverloads
    public final void e0(@NotNull String str, int i, int i2, boolean z, float f) {
        Intrinsics.checkNotNullParameter(str, "permissionMessage");
        g0(this, str, i, i2, z, f, 0.0f, 32, null);
    }

    public final void f(MediaPickerRequest request) {
        PendingSession pendingSession = this.pending;
        this.pending = pendingSession.k((482 & 1) != 0 ? pendingSession.pickType : request.getType(), (482 & 2) != 0 ? pendingSession.maxCount : request.j(), (482 & 4) != 0 ? pendingSession.compress : request.h(), (482 & 8) != 0 ? pendingSession.crop : request.i(), (482 & 16) != 0 ? pendingSession.video : request.k(), (482 & 32) != 0 ? pendingSession.cameraFile : null, (482 & 64) != 0 ? pendingSession.cameraUri : null, (482 & 128) != 0 ? pendingSession.cropDestinationUri : null, (482 & 256) != 0 ? pendingSession.awaitingCropResult : false);
        if (request.p()) {
            this.maxCountRef.b(request.j());
        }
    }

    @JvmOverloads
    public final void f0(@NotNull String permissionMessage, int imageMaxWidth, int imageMaxSize, boolean needCrop, float aspectRatioX, float aspectRatioY) {
        Intrinsics.checkNotNullParameter(permissionMessage, "permissionMessage");
        String strE = e(imageMaxWidth, imageMaxSize, needCrop, aspectRatioX, aspectRatioY);
        if (strE != null) {
            n(1, strE);
        } else {
            vo6.h(this.context, permissionMessage, new PermissionResultListener() { // from class: com.zj.adlib.tk5
                @Override // com.huachenjie.common.util.permission.PermissionResultListener
                public final void onResult(boolean z) {
                    MediaPickerLauncher.h0(this.f44941a, z);
                }
            });
        }
    }

    public final void g(int resultCode, @Nullable Intent data) {
        if (this.pending.m()) {
            this.pending.v(false);
            h(resultCode, data);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002b  */
    public final void h(int resultCode, Intent data) {
        String message;
        Uri uriR = this.pending.r();
        this.pending.y(null);
        if (resultCode == -1 && uriR != null) {
            O(CollectionsKt.listOf(uriR));
            return;
        }
        if (resultCode != 96) {
            m();
            return;
        }
        if (data == null) {
            message = "Image crop failed";
        } else {
            Throwable thA = com.yalantis.ucrop.a.a(data);
            message = thA != null ? thA.getMessage() : null;
            if (message == null) {
                message = "Image crop failed";
            }
        }
        n(3, message);
    }

    public final void i(@NotNull List<? extends Uri> uris) {
        Intrinsics.checkNotNullParameter(uris, "uris");
        k(uris);
    }

    public final void j(boolean success) {
        final File fileN = this.pending.n();
        Uri uriO = this.pending.o();
        this.pending.a();
        if (!success || fileN == null || !fileN.exists() || fileN.length() == 0) {
            m();
            return;
        }
        if (!this.pending.q().l()) {
            M(new Function0<List<? extends PickedMedia>>() { // from class: com.huachenjie.common.util.media_picker.MediaPickerLauncher$dispatchTakePictureResult$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @NotNull
                public final List<PickedMedia> invoke() {
                    zq6 zq6Var = zq6.f46321a;
                    Context applicationContext = this.this$0.context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    return zq6Var.f(applicationContext, CollectionsKt.listOf(fileN.getAbsolutePath()), this.this$0.pending.p());
                }
            });
            return;
        }
        if (uriO == null) {
            uriO = fq6.f41732a.f(this.context, fileN);
        }
        if (uriO == null) {
            n(3, "Failed to prepare image for crop");
        } else {
            Z(uriO);
        }
    }

    public final void k(List<? extends Uri> uris) {
        List<? extends Uri> listTake = CollectionsKt.take(uris, this.pending.s());
        if (listTake.isEmpty()) {
            m();
        } else if (this.pending.q().l() && listTake.size() == 1) {
            Z(listTake.get(0));
        } else {
            O(listTake);
        }
    }

    public final void l(@NotNull MediaPickerRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        f(request);
        String strE = request.E();
        if (strE != null) {
            n(1, strE);
            return;
        }
        PickVisualMediaRequest pickVisualMediaRequestG = fq6.f41732a.g(request);
        try {
            if (request.p()) {
                this.multipleLauncher.launch(pickVisualMediaRequestG);
            } else {
                this.singleLauncher.launch(pickVisualMediaRequestG);
            }
        } catch (ActivityNotFoundException e) {
            o(e, "Failed to launch photo picker");
        }
    }

    public final void m() {
        P();
        MediaPicker.f8903a.n(this.listener);
    }

    public final void n(int code, String message) {
        P();
        MediaPicker.f8903a.p(this.listener, code, message);
    }

    public final void o(ActivityNotFoundException exception, String fallbackMessage) {
        String message = exception.getMessage();
        if (message != null) {
            fallbackMessage = message;
        }
        n(3, fallbackMessage);
    }

    @JvmOverloads
    public final void p() {
        w(this, 0, 0, false, 0.0f, 0.0f, false, 63, null);
    }

    @JvmOverloads
    public final void q(int i) {
        w(this, i, 0, false, 0.0f, 0.0f, false, 62, null);
    }

    @JvmOverloads
    public final void r(int i, int i2) {
        w(this, i, i2, false, 0.0f, 0.0f, false, 60, null);
    }

    @JvmOverloads
    public final void s(int i, int i2, boolean z) {
        w(this, i, i2, z, 0.0f, 0.0f, false, 56, null);
    }

    @JvmOverloads
    public final void t(int i, int i2, boolean z, float f) {
        w(this, i, i2, z, f, 0.0f, false, 48, null);
    }

    @JvmOverloads
    public final void u(int i, int i2, boolean z, float f, float f2) {
        w(this, i, i2, z, f, f2, false, 32, null);
    }

    @JvmOverloads
    public final void v(int imageMaxWidth, int imageMaxSize, boolean needCrop, float aspectRatioX, float aspectRatioY, boolean allowGif) {
        l(MediaPickerRequest.INSTANCE.r(imageMaxWidth, imageMaxSize, needCrop, aspectRatioX, aspectRatioY, allowGif));
    }

    @JvmOverloads
    public final void x(int i) {
        B(this, i, 0, 0, false, 14, null);
    }

    @JvmOverloads
    public final void y(int i, int i2) {
        B(this, i, i2, 0, false, 12, null);
    }

    @JvmOverloads
    public final void z(int i, int i2, int i3) {
        B(this, i, i2, i3, false, 8, null);
    }
}
