package com.huachenjie.ad.util;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.huachenjie.ad.util.OAIDUtil;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.i4a;
import com.zj.adlib.r90;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0007J\b\u0010\u000b\u001a\u00020\tH\u0007R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/ad/util/OAIDUtil;", "", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "block", "e", "Lkotlin/Function1;", "", "c", "b", "", "a", "Ljava/lang/String;", "TAG", DeviceIdType.OAID, "<init>", "()V", "ad_release"}, k = 1, mv = {1, 8, 0})
public final class OAIDUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final OAIDUtil f32743a = new OAIDUtil();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String TAG = "OAIDUtil";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public static String oaid;

    @JvmStatic
    public static final boolean b() {
        String str = oaid;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = oaid;
        Intrinsics.checkNotNull(str2);
        return !new Regex("^[0\\-]*$").matches(str2);
    }

    @JvmStatic
    public static final void c(@NotNull Context context, @Nullable final Function1<? super Boolean, Unit> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        e(context, new Function0<Unit>() { // from class: com.huachenjie.ad.util.OAIDUtil$checkOaid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m184invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m184invoke() {
                Function1<Boolean, Unit> function1 = block;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(OAIDUtil.b()));
                }
            }
        });
    }

    public static /* synthetic */ void d(Context context, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        c(context, function1);
    }

    @JvmStatic
    public static final void e(@NotNull Context context, @Nullable final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strS = r90.s();
        if (strS != null) {
            oaid = strS;
        }
        try {
            MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() { // from class: com.zj.adlib.f56
                @Override // com.bun.miitmdid.interfaces.IIdentifierListener
                public final void OnSupport(boolean z, IdSupplier idSupplier) {
                    OAIDUtil.g(block, z, idSupplier);
                }
            });
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void f(Context context, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        e(context, function0);
    }

    public static final void g(Function0 function0, boolean z, IdSupplier idSupplier) {
        String oaid2 = (idSupplier == null || !idSupplier.isSupported()) ? "" : idSupplier.getOAID();
        oaid = oaid2;
        Intrinsics.checkNotNull(oaid2);
        r90.W(oaid2);
        i4a.b(TAG, "oaid: " + oaid);
        if (function0 != null) {
            function0.invoke();
        }
    }
}
