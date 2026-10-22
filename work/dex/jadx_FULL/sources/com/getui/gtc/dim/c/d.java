package com.getui.gtc.dim.c;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import com.kc.openset.constant.DeviceIdType;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f30319a;
    static Context b = null;
    static boolean c = false;
    public static final String d;
    private static volatile d e;

    public interface a {
        boolean a(Context context);

        String b(Context context);

        boolean c(Context context);
    }

    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f30320a;
        e b;
        private boolean c = false;
        private boolean d = false;
        private final CountDownLatch e = new CountDownLatch(1);
        private final String f;
        private final String g;
        private final String h;
        private final String i;

        public b(String str, String str2, String str3, String str4) {
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.i = str4;
        }

        public String a() {
            return null;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public boolean a(Context context) {
            if (this.d) {
                return this.c;
            }
            if (context == null || TextUtils.isEmpty(this.f)) {
                this.c = false;
            } else {
                try {
                    PackageInfo packageInfoA = com.getui.gtc.dim.e.d.a(this.f, 0);
                    if (Build.VERSION.SDK_INT >= 28) {
                        return packageInfoA.getLongVersionCode() >= 1;
                    }
                    this.c = packageInfoA.versionCode > 0;
                } catch (Throwable unused) {
                    return false;
                }
            }
            this.d = true;
            return this.c;
        }

        public int b() {
            return 1;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public String b(Context context) {
            e eVar;
            C0652d c0652d;
            e eVar2;
            if (!TextUtils.isEmpty(this.f30320a) || (eVar = this.b) == null || (c0652d = eVar.f30323a) == null) {
                return this.f30320a;
            }
            try {
                String strA = c0652d.a(d(context), e(context), a(), b());
                this.f30320a = strA;
                if (!TextUtils.isEmpty(strA) && (eVar2 = this.b) != null) {
                    context.unbindService(eVar2);
                }
            } catch (Throwable unused) {
            }
            return this.f30320a;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public boolean c(Context context) {
            if (context == null || TextUtils.isEmpty(this.f)) {
                return false;
            }
            if (this.b == null) {
                this.b = new e(this.i, this.e);
            }
            Intent intent = new Intent();
            if (TextUtils.isEmpty(this.g)) {
                intent.setPackage(this.f);
            } else {
                intent.setComponent(new ComponentName(this.f, this.g));
            }
            if (!TextUtils.isEmpty(this.h)) {
                intent.setAction(this.h);
            }
            return this.b.a(context, intent);
        }

        public String d(Context context) {
            return null;
        }

        public String e(Context context) {
            return null;
        }
    }

    public static class c implements a {
        protected static boolean b = false;
        private static String d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String[] f30321a;
        protected boolean c = false;
        private String e;
        private String f;

        public c(String str, String str2) {
            this.e = str;
            this.f = str2;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public boolean a(Context context) {
            if (this.c) {
                return b;
            }
            if (context == null) {
                return false;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                b = (packageManager == null || packageManager.resolveContentProvider(this.e, 0) == null) ? false : true;
            } catch (Throwable unused) {
                b = false;
            }
            this.c = true;
            return b;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public String b(Context context) {
            Cursor cursorQuery;
            if (TextUtils.isEmpty(d)) {
                try {
                    cursorQuery = context.getContentResolver().query(Uri.parse("content://" + this.e + WVNativeCallbackUtil.SEPERATER + this.f), null, null, this.f30321a, null);
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.moveToFirst();
                            d = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        } catch (Throwable unused) {
                            try {
                                d = null;
                                return d;
                            } finally {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            }
                        }
                    }
                    if (cursorQuery != null) {
                    }
                } catch (Throwable unused2) {
                    cursorQuery = null;
                }
            }
            return d;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean c(Context context) {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.getui.gtc.dim.c.d$d, reason: collision with other inner class name */
    public static class C0652d implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f30322a;
        private String b;

        private C0652d(IBinder iBinder, String str) {
            this.f30322a = iBinder;
            this.b = str;
        }

        public static C0652d a(IBinder iBinder, String str) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(str);
            return iInterfaceQueryLocalInterface instanceof C0652d ? (C0652d) iInterfaceQueryLocalInterface : new C0652d(iBinder, str);
        }

        public final String a(String str, String str2, String str3, int i) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken(this.b);
                    if (!TextUtils.isEmpty(str)) {
                        parcelObtain.writeString(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        parcelObtain.writeString(str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        parcelObtain.writeString(str3);
                    }
                    this.f30322a.transact(i, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception unused) {
                    return "";
                }
            } catch (Throwable unused2) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return "";
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f30322a;
        }
    }

    public static class e implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        C0652d f30323a;
        IBinder b;
        private String c;
        private CountDownLatch d;

        public e(String str, CountDownLatch countDownLatch) {
            this.c = str;
            this.d = countDownLatch;
        }

        public final boolean a(Context context, Intent intent) {
            if (context == null) {
                return false;
            }
            if (this.f30323a != null) {
                return true;
            }
            try {
                boolean zBindService = context.bindService(intent, this, 1);
                this.d.await(1L, TimeUnit.SECONDS);
                this.f30323a = C0652d.a(this.b, this.c);
                return zBindService;
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b = iBinder;
                this.d.countDown();
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            this.f30323a = null;
            this.b = null;
        }
    }

    public static class f extends b {
        public f() {
            super(a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQ="), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuU3VwcGxlbWVudGFyeURJRFNlcnZpY2U="), a("Y29tLmFzdXMubXNhLmFjdGlvbi5BQ0NFU1NfRElE"), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuSURpZEFpZGxJbnRlcmZhY2U="));
        }

        private static String a(String str) {
            return new String(Base64.decode(str, 0));
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b
        public final int b() {
            return 2;
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    public static class g extends b {
        public g() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b
        public final int b() {
            return 2;
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    public static class h extends b {
        public h() {
            super("com.huawei.hwid", null, "com.uodis.opendevice.OPENIDS_SERVICE", com.alipay.sdk.m.d.b.f25422a);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    public static class i extends b {
        final CountDownLatch c;

        public static abstract class a extends Binder implements IInterface {
            public a() {
                attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
            }

            public abstract void a(int i, Bundle bundle);

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this;
            }

            @Override // android.os.Binder
            public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    return true;
                }
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
        }

        public i() {
            super("com.hihonor.id", null, "com.hihonor.id.HnOaIdService", "com.hihonor.cloudservice.oaid.IOAIDService");
            this.c = new CountDownLatch(1);
        }

        public static boolean c() {
            try {
                PackageInfo packageInfoA = com.getui.gtc.dim.e.d.a("com.hihonor.id", 0);
                if (Build.VERSION.SDK_INT >= 28) {
                    return packageInfoA.getLongVersionCode() >= 1;
                }
                return packageInfoA.versionCode > 0;
            } catch (Throwable unused) {
            }
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final String b(Context context) {
            e eVar;
            e eVar2;
            if (!TextUtils.isEmpty(this.f30320a) || (eVar = this.b) == null || eVar.f30323a == null) {
                return this.f30320a;
            }
            try {
                IBinder iBinder = eVar.b;
                a aVar = new a() { // from class: com.getui.gtc.dim.c.d.i.1
                    @Override // com.getui.gtc.dim.c.d.i.a
                    public final void a(int i, Bundle bundle) {
                        if (i == 0 && bundle != null) {
                            i.this.f30320a = bundle.getString("oa_id_flag");
                        }
                        i.this.c.countDown();
                    }
                };
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(aVar.asBinder());
                    iBinder.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    this.c.await(1L, TimeUnit.SECONDS);
                    if (!TextUtils.isEmpty(this.f30320a) && (eVar2 = this.b) != null) {
                        context.unbindService(eVar2);
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            } catch (Throwable unused) {
            }
            return this.f30320a;
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    public static class j extends c {
        public j() {
            super("com.meizu.flyme.openidsdk", "");
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final boolean a(Context context) {
            if (super.a(context)) {
                c.b = true;
            } else {
                try {
                    Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"support"}, null);
                    if (cursorQuery == null) {
                        return false;
                    }
                    cursorQuery.moveToFirst();
                    int columnIndex = cursorQuery.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        String string = cursorQuery.getString(columnIndex);
                        if (TextUtils.isEmpty(string)) {
                            return false;
                        }
                        c.b = "0".equals(string);
                    } else {
                        c.b = false;
                    }
                } catch (Throwable unused) {
                    c.b = false;
                    return false;
                }
            }
            this.c = true;
            return c.b;
        }

        @Override // com.getui.gtc.dim.c.d.c, com.getui.gtc.dim.c.d.a
        public final String b(Context context) {
            this.f30321a = new String[]{DeviceIdType.OAID};
            return super.b(context);
        }
    }

    public static class k implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f30325a;
        private boolean b;
        private String c;

        private k() {
            this.f30325a = false;
            this.b = false;
            this.c = null;
        }

        public /* synthetic */ k(byte b) {
            this();
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean a(Context context) {
            if (this.b) {
                return this.f30325a;
            }
            if (context == null) {
                return false;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                this.f30325a = (packageManager == null || packageManager.resolveContentProvider("cn.nubia.identity", 0) == null) ? false : true;
            } catch (Throwable unused) {
                this.f30325a = false;
            }
            this.b = true;
            return this.f30325a;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final String b(Context context) {
            Bundle bundleCall;
            try {
                if (TextUtils.isEmpty(this.c)) {
                    ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
                    if (contentProviderClientAcquireContentProviderClient != null) {
                        bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                        try {
                            Class.forName("android.content.ContentProviderClient").getMethod("close", new Class[0]).invoke(contentProviderClientAcquireContentProviderClient, new Object[0]);
                        } catch (Throwable unused) {
                        }
                    } else {
                        bundleCall = null;
                    }
                    if (bundleCall == null) {
                        return this.c;
                    }
                    if (bundleCall.getInt("code", -1) == 0) {
                        this.c = bundleCall.getString("id");
                    }
                }
            } catch (Throwable unused2) {
                this.c = null;
            }
            return this.c;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean c(Context context) {
            return true;
        }
    }

    public static class l extends b {
        private String c;
        private String d;

        public l() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }

        @Override // com.getui.gtc.dim.c.d.b
        public final String a() {
            return "OUID";
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }

        @Override // com.getui.gtc.dim.c.d.b
        public final String d(Context context) {
            if (TextUtils.isEmpty(this.d)) {
                this.d = context.getPackageName();
            }
            return this.d;
        }

        @Override // com.getui.gtc.dim.c.d.b
        @SuppressLint({"PackageManagerGetSignatures"})
        public final String e(Context context) {
            if (TextUtils.isEmpty(this.c)) {
                try {
                    String strD = d(context);
                    this.d = strD;
                    Signature[] signatureArr = com.getui.gtc.dim.e.d.a(strD, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        this.c = sb.toString();
                    }
                } catch (Throwable unused) {
                }
            }
            return this.c;
        }
    }

    public static class m extends b {
        public m() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", null, com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    public static class n extends c {
        public n() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    public static class o implements a {
        private static String b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<?> f30326a = null;

        @Override // com.getui.gtc.dim.c.d.a
        @SuppressLint({"PrivateApi"})
        public final boolean a(Context context) {
            try {
                this.f30326a = Class.forName("com.android.id.impl.IdProviderImpl");
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final String b(Context context) {
            if (TextUtils.isEmpty(b)) {
                try {
                    b = String.valueOf(this.f30326a.getMethod("getOAID", Context.class).invoke(this.f30326a.newInstance(), context));
                } catch (Throwable unused) {
                    b = null;
                }
            }
            return b;
        }

        @Override // com.getui.gtc.dim.c.d.a
        public final boolean c(Context context) {
            return true;
        }
    }

    public static class p extends b {
        public p() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", null, com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean a(Context context) {
            return super.a(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ String b(Context context) {
            return super.b(context);
        }

        @Override // com.getui.gtc.dim.c.d.b, com.getui.gtc.dim.c.d.a
        public final /* bridge */ /* synthetic */ boolean c(Context context) {
            return super.c(context);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static {
        a pVar;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        d = upperCase;
        upperCase.hashCode();
        byte b2 = 0;
        byte b3 = -1;
        switch (upperCase.hashCode()) {
            case -2053026509:
                if (upperCase.equals("LENOVO")) {
                    b3 = 0;
                }
                break;
            case -1881642058:
                if (upperCase.equals("REALME")) {
                    b3 = 1;
                }
                break;
            case -1712043046:
                if (upperCase.equals("SAMSUNG")) {
                    b3 = 2;
                }
                break;
            case -1706170181:
                if (upperCase.equals("XIAOMI")) {
                    b3 = 3;
                }
                break;
            case -1134767290:
                if (upperCase.equals("BLACKSHARK")) {
                    b3 = 4;
                }
                break;
            case -602397472:
                if (upperCase.equals("ONEPLUS")) {
                    b3 = 5;
                }
                break;
            case 89198:
                if (upperCase.equals("ZUI")) {
                    b3 = 6;
                }
                break;
            case 89200:
                if (upperCase.equals("ZUK")) {
                    b3 = 7;
                }
                break;
            case 2018896:
                if (upperCase.equals("ASUS")) {
                    b3 = 8;
                }
                break;
            case 2255112:
                if (upperCase.equals("IQOO")) {
                    b3 = 9;
                }
                break;
            case 2432928:
                if (upperCase.equals("OPPO")) {
                    b3 = 10;
                }
                break;
            case 2634924:
                if (upperCase.equals("VIVO")) {
                    b3 = 11;
                }
                break;
            case 68924490:
                if (upperCase.equals("HONOR")) {
                    b3 = 12;
                }
                break;
            case 73239724:
                if (upperCase.equals("MEIZU")) {
                    b3 = 13;
                }
                break;
            case 74632627:
                if (upperCase.equals("NUBIA")) {
                    b3 = com.google.common.base.a.p;
                }
                break;
            case 77852109:
                if (upperCase.equals("REDMI")) {
                    b3 = com.google.common.base.a.q;
                }
                break;
            case 630905871:
                if (upperCase.equals("MOTOLORA")) {
                    b3 = com.google.common.base.a.r;
                }
                break;
            case 1670208650:
                if (upperCase.equals("COOLPAD")) {
                    b3 = 17;
                }
                break;
            case 1972178256:
                if (upperCase.equals("HUA_WEI")) {
                    b3 = com.google.common.base.a.u;
                }
                break;
            case 2141820391:
                if (upperCase.equals("HUAWEI")) {
                    b3 = 19;
                }
                break;
        }
        switch (b3) {
            case 0:
            case 6:
            case 7:
            case 16:
                pVar = new p();
                break;
            case 1:
            case 5:
            case 10:
                pVar = new l();
                break;
            case 2:
                pVar = new m();
                break;
            case 3:
            case 4:
            case 15:
                pVar = new o();
                break;
            case 8:
                pVar = new f();
                break;
            case 9:
            case 11:
                pVar = new n();
                break;
            case 12:
                pVar = new i();
                break;
            case 13:
                pVar = new j();
                break;
            case 14:
                pVar = new k(b2);
                break;
            case 17:
                pVar = new g();
                break;
            case 18:
            case 19:
                pVar = new h();
                break;
            default:
                pVar = null;
                break;
        }
        f30319a = pVar;
    }

    public static d a() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    public static boolean b() {
        a aVar;
        try {
            Context context = b;
            if (context == null || (aVar = f30319a) == null) {
                return false;
            }
            return aVar.a(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c() {
        a aVar;
        try {
            Context context = b;
            if (context != null && (aVar = f30319a) != null && c) {
                return aVar.b(context);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
