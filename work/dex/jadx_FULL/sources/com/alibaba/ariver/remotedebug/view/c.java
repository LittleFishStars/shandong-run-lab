package com.alibaba.ariver.remotedebug.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.R;
import com.alibaba.ariver.remotedebug.core.state.RemoteDebugState;
import com.alibaba.ariver.remotedebug.extension.RemoteDebugStatePoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24398a = "c";
    private Activity c;
    private b d;
    private RemoteDebugInfoPanelView e;
    private com.alibaba.ariver.remotedebug.core.b.a g;
    private App h;
    private Dialog i;
    private boolean f = false;
    private RemoteDebugState b = RemoteDebugState.STATE_NON_REMOTE_DEBUG;

    /* JADX INFO: renamed from: com.alibaba.ariver.remotedebug.view.c$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24401a;

        static {
            int[] iArr = new int[RemoteDebugState.values().length];
            f24401a = iArr;
            try {
                iArr[RemoteDebugState.STATE_CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24401a[RemoteDebugState.STATE_CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24401a[RemoteDebugState.STATE_CONNECT_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24401a[RemoteDebugState.STATE_NETWORK_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24401a[RemoteDebugState.STATE_REMOTE_DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24401a[RemoteDebugState.STATE_HIT_BREAKPOINT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24401a[RemoteDebugState.STATE_RELEASE_BREAKPOINT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f24401a[RemoteDebugState.STATE_EXITED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public c(App app, com.alibaba.ariver.remotedebug.core.b.a aVar) {
        this.h = app;
        this.g = aVar;
    }

    private void e() {
        if (this.b != RemoteDebugState.STATE_REMOTE_DISCONNECTED) {
            RVLogger.d(f24398a, "remoteDisconnected...state error");
        } else {
            if (((RemoteDebugStatePoint) ExtensionPoint.as(RemoteDebugStatePoint.class).create()).onDisconnected(this.h)) {
                return;
            }
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.c.5
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f = true;
                    if (c.this.d == null) {
                        c.this.d = new b(c.this.c);
                        c.this.d.setActionEventListener(c.this);
                    }
                    c.this.d.setStateText(c.this.c.getResources().getString(R.string.tiny_remote_debug_connect_interrupt));
                    c.this.d.setVisibility(0);
                }
            });
        }
    }

    private void f() {
        if (this.b != RemoteDebugState.STATE_HIT_BREAKPOINT) {
            RVLogger.d(f24398a, "hitBreakpoint...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.c.6
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.d == null) {
                        c.this.d = new b(c.this.c);
                        c.this.d.setActionEventListener(c.this);
                    }
                    c.this.d.setStateText(c.this.c.getResources().getString(R.string.tiny_remote_debug_hit_break_point));
                    c.this.d.setVisibility(0);
                }
            });
        }
    }

    private void g() {
        if (this.b != RemoteDebugState.STATE_RELEASE_BREAKPOINT) {
            RVLogger.d(f24398a, "releaseBreakpoint...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.c.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.d != null) {
                        c.this.d.setVisibility(8);
                    }
                }
            });
        }
    }

    private void h() {
        if (this.b != RemoteDebugState.STATE_EXITED) {
            RVLogger.d(f24398a, "exitDebugMode...state error");
            return;
        }
        com.alibaba.ariver.remotedebug.core.b.a aVar = this.g;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void i() {
        if (this.b != RemoteDebugState.STATE_NETWORK_UNAVAILABLE) {
            RVLogger.d(f24398a, "handleNetworkUnavailable...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.c.8
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.d == null) {
                        c.this.d = new b(c.this.c);
                        c.this.d.setActionEventListener(c.this);
                    }
                    c.this.d.setStateText(c.this.c.getResources().getString(R.string.tiny_remote_debug_no_network));
                    c.this.d.setVisibility(0);
                }
            });
        }
    }

    private void j() {
        Dialog dialog = this.i;
        if (dialog != null) {
            dialog.show();
            return;
        }
        DialogPoint dialogPoint = (DialogPoint) ExtensionPoint.as(DialogPoint.class).node(this.h).create();
        Resources resources = this.c.getResources();
        CreateDialogParam createDialogParam = new CreateDialogParam(resources.getString(R.string.tiny_remote_debug_exit_dialog_title), null, resources.getString(R.string.tiny_remote_debug_exit_confirm), resources.getString(R.string.tiny_remote_debug_exit_cancel), null);
        createDialogParam.cancelable = false;
        createDialogParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.c.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (c.this.i != null) {
                    c.this.i.dismiss();
                }
            }
        };
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.c.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (c.this.i != null) {
                    c.this.a(RemoteDebugState.STATE_EXITED);
                }
            }
        };
        Dialog dialogCreateDialog = dialogPoint.createDialog(this.c, createDialogParam);
        this.i = dialogCreateDialog;
        dialogCreateDialog.show();
    }

    private void b() {
        if (this.b != RemoteDebugState.STATE_CONNECTING) {
            RVLogger.d(f24398a, "remoteDebugConnecting...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.e == null) {
                        c.this.e = new RemoteDebugInfoPanelView(c.this.c);
                        c.this.e.setActionEventListener(c.this);
                    }
                    c.this.e.a();
                }
            });
        }
    }

    private void c() {
        if (this.b != RemoteDebugState.STATE_CONNECTED) {
            RVLogger.d(f24398a, "remoteDebugConnected...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.e == null) {
                        c.this.e = new RemoteDebugInfoPanelView(c.this.c);
                        c.this.e.setActionEventListener(c.this);
                    }
                    c.this.e.b();
                }
            });
        }
    }

    private void d() {
        if (this.b != RemoteDebugState.STATE_CONNECT_FAILED) {
            RVLogger.d(f24398a, "remoteDebugConnectFailed...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.d == null) {
                        c.this.d = new b(c.this.c);
                        c.this.d.setActionEventListener(c.this);
                    }
                    c.this.d.setStateText(c.this.c.getString(R.string.tiny_remote_debug_connect_interrupt));
                    c.this.d.setVisibility(0);
                    if (c.this.e == null) {
                        c.this.e = new RemoteDebugInfoPanelView(c.this.c);
                        c.this.e.setActionEventListener(c.this);
                    }
                    c.this.e.c();
                }
            });
        }
    }

    public void a(Activity activity) {
        if (activity != null) {
            this.c = activity;
            return;
        }
        throw new NullPointerException("activity cannot be null!");
    }

    public void a(RemoteDebugState remoteDebugState) {
        RVLogger.d(f24398a, "notifyStateChanged...state:" + remoteDebugState + ", old state: " + this.b);
        if (this.b == remoteDebugState) {
        }
        this.b = remoteDebugState;
        switch (AnonymousClass2.f24401a[remoteDebugState.ordinal()]) {
            case 1:
                b();
                break;
            case 2:
                c();
                break;
            case 3:
                d();
                break;
            case 4:
                i();
                break;
            case 5:
                e();
                break;
            case 6:
                f();
                break;
            case 7:
                g();
                break;
            case 8:
                h();
                break;
        }
    }

    @Override // com.alibaba.ariver.remotedebug.view.a
    public void a() {
        if (this.f) {
            a(RemoteDebugState.STATE_EXITED);
        } else {
            j();
        }
    }
}
