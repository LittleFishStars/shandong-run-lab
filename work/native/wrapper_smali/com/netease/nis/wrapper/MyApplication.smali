.class public Lcom/netease/nis/wrapper/MyApplication;
.super Landroid/app/Application;


# static fields
.field public static TAG:Ljava/lang/String; = null

.field public static final VER:Ljava/lang/String; = "7.6.3_936"

.field private static a:Ljava/lang/String;

.field private static b:Ljava/lang/String;

.field private static c:Ljava/lang/String;

.field private static d:Ljava/lang/String;

.field private static e:Landroid/content/Context;

.field private static f:Z

.field private static g:I

.field private static h:Landroid/os/Handler;

.field public static mLoadShell:Z

.field public static mNeedBugrpt:Z

.field public static mNeedX86:Z

.field public static mOfficial:Z

.field private static newApp:Landroid/app/Application;

.field private static runApp:Landroid/app/Application;

.field public static strAppName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    const-string v0, "ORcVFREWFw=="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    const-string v0, "LQoZSw8WESsEBwBPHQw9SwMXAAMVKxdaKBgyFT4JHQYABwwhCw=="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/netease/nis/wrapper/MyApplication;->strAppName:Ljava/lang/String;

    const-string v0, "Kx0AFwAQEREWAwwVEA0RVQ=="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/netease/nis/wrapper/MyApplication;->a:Ljava/lang/String;

    const-string v0, "PhcbEwgXADw6BxIIBwYmOkU="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/netease/nis/wrapper/MyApplication;->b:Ljava/lang/String;

    const-string v0, "PQ0RCQ0sCScIHRE+Qw=="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/netease/nis/wrapper/MyApplication;->c:Ljava/lang/String;

    const-string v0, "Nl1COhIEDDoGHDpQ"

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/netease/nis/wrapper/MyApplication;->d:Ljava/lang/String;

    sput-object v2, Lcom/netease/nis/wrapper/MyApplication;->e:Landroid/content/Context;

    sput-object v2, Lcom/netease/nis/wrapper/MyApplication;->runApp:Landroid/app/Application;

    sput-object v2, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    sput-boolean v3, Lcom/netease/nis/wrapper/MyApplication;->mOfficial:Z

    sput-boolean v3, Lcom/netease/nis/wrapper/MyApplication;->mNeedX86:Z

    sput-boolean v1, Lcom/netease/nis/wrapper/MyApplication;->mNeedBugrpt:Z

    sput-boolean v1, Lcom/netease/nis/wrapper/MyApplication;->mLoadShell:Z

    sput-boolean v1, Lcom/netease/nis/wrapper/MyApplication;->f:Z

    sput v1, Lcom/netease/nis/wrapper/MyApplication;->g:I

    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lcom/netease/nis/wrapper/MyApplication;->h:Landroid/os/Handler;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method private static a(Landroid/content/Context;)Landroid/app/Application;
    .registers 3

    :try_start_0
    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    if-nez v0, :cond_e

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->strAppName:Ljava/lang/String;

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_11

    :cond_e
    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    :goto_10
    return-object v0

    :cond_11
    invoke-virtual {p0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    if-nez v0, :cond_1a

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    goto :goto_10

    :cond_1a
    sget-object v1, Lcom/netease/nis/wrapper/MyApplication;->strAppName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    if-eqz v0, :cond_2a

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    sput-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;
    :try_end_2a
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_2a} :catch_2d

    :cond_2a
    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    goto :goto_10

    :catch_2d
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    goto :goto_10
.end method

.method private static a()Z
    .registers 3

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->c:Ljava/lang/String;

    const-string v1, "fw=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "FQsRAAUwCiARBgoNIA0rCRgpAAYLLQ0pRQMgDSsJGCkABgstDTgMDBoRKwFO"

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "bggnDQQfCQ0LAF8="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget v2, Lcom/netease/nis/wrapper/MyApplication;->g:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    sget v1, Lcom/netease/nis/wrapper/MyApplication;->g:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_33

    if-eqz v0, :cond_33

    const/4 v0, 0x1

    :goto_32
    return v0

    :cond_33
    const/4 v0, 0x0

    goto :goto_32
.end method

.method public static native g()Z
.end method

.method public static getAppCtx()Landroid/content/Context;
    .registers 1

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->e:Landroid/content/Context;

    return-object v0
.end method

.method public static getHandler()Landroid/os/Handler;
    .registers 1

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->h:Landroid/os/Handler;

    return-object v0
.end method

.method public static getVersion()Ljava/lang/String;
    .registers 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "eUtCS1IsXH1T"

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static native l(Landroid/app/Application;)Z
.end method

.method public static loadLib(Landroid/content/Context;Ljava/lang/String;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/netease/nis/wrapper/o;->a(Landroid/content/Context;Ljava/lang/String;)V

    return-void
.end method

.method public static synchronized native declared-synchronized n0010111112(CCCCCD)V
.end method

.method public static synchronized native declared-synchronized n00102(D)V
.end method

.method public static synchronized native declared-synchronized n001022(DD)V
.end method

.method public static synchronized native declared-synchronized n0010312(Ljava/lang/Object;CD)V
.end method

.method public static synchronized native declared-synchronized n0011112(CCD)C
.end method

.method public static synchronized native declared-synchronized n001112(CD)C
.end method

.method public static synchronized native declared-synchronized n0012()D
.end method

.method public static synchronized native declared-synchronized n0012332(Ljava/lang/Object;Ljava/lang/Object;D)D
.end method

.method public static synchronized native declared-synchronized n0013()Ljava/lang/Object;
.end method

.method public static native n0110()V
.end method

.method public static native n01101(C)V
.end method

.method public static native n011011(CC)V
.end method

.method public static native n0110111(CCC)V
.end method

.method public static native n0110111111(CCCCCC)V
.end method

.method public static native n011011111131(CCCCCCLjava/lang/Object;C)V
.end method

.method public static native n0110113(CCLjava/lang/Object;)V
.end method

.method public static native n011011333(CCLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n011012(CD)V
.end method

.method public static native n0110121(CDC)V
.end method

.method public static native n01101211(CDCC)V
.end method

.method public static native n011012111(CDCCC)V
.end method

.method public static native n01101211111(CDCCCCC)V
.end method

.method public static native n011012111111(CDCCCCCC)V
.end method

.method public static native n0110122(CDD)V
.end method

.method public static native n0110123(CDLjava/lang/Object;)V
.end method

.method public static native n01101231(CDLjava/lang/Object;C)V
.end method

.method public static native n011012313(CDLjava/lang/Object;CLjava/lang/Object;)V
.end method

.method public static native n011012321111(CDLjava/lang/Object;DCCCC)V
.end method

.method public static native n01101233(CDLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n01101233311111111(CDLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CCCCCCCC)V
.end method

.method public static native n011013(CLjava/lang/Object;)V
.end method

.method public static native n0110131(CLjava/lang/Object;C)V
.end method

.method public static native n01101311(CLjava/lang/Object;CC)V
.end method

.method public static native n0110133(CLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0110133313(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)V
.end method

.method public static native n01101333333(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n01102(D)V
.end method

.method public static native n011021(DC)V
.end method

.method public static native n0110211(DCC)V
.end method

.method public static native n01102111(DCCC)V
.end method

.method public static native n011021111(DCCCC)V
.end method

.method public static native n0110211111111111(DCCCCCCCCCCC)V
.end method

.method public static native n011021113(DCCCLjava/lang/Object;)V
.end method

.method public static native n01102113(DCCLjava/lang/Object;)V
.end method

.method public static native n011021133(DCCLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0110212(DCD)V
.end method

.method public static native n011021223(DCDDLjava/lang/Object;)V
.end method

.method public static native n0110213(DCLjava/lang/Object;)V
.end method

.method public static native n01102132(DCLjava/lang/Object;D)V
.end method

.method public static native n011022(DD)V
.end method

.method public static native n0110221(DDC)V
.end method

.method public static native n01102212(DDCD)V
.end method

.method public static native n01102213(DDCLjava/lang/Object;)V
.end method

.method public static native n0110222(DDD)V
.end method

.method public static native n01102221(DDDC)V
.end method

.method public static native n01102222(DDDD)V
.end method

.method public static native n011022222(DDDDD)V
.end method

.method public static native n0110222222(DDDDDD)V
.end method

.method public static native n01102222222(DDDDDDD)V
.end method

.method public static native n0110223(DDLjava/lang/Object;)V
.end method

.method public static native n0110223333(DDLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n011023(DLjava/lang/Object;)V
.end method

.method public static native n0110231(DLjava/lang/Object;C)V
.end method

.method public static native n01102311(DLjava/lang/Object;CC)V
.end method

.method public static native n0110233(DLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n011023311(DLjava/lang/Object;Ljava/lang/Object;CC)V
.end method

.method public static native n011023323(DLjava/lang/Object;Ljava/lang/Object;DLjava/lang/Object;)V
.end method

.method public static native n0110233231(DLjava/lang/Object;Ljava/lang/Object;DLjava/lang/Object;C)V
.end method

.method public static native n01102333(DLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n01103(Ljava/lang/Object;)V
.end method

.method public static native n011031(Ljava/lang/Object;C)V
.end method

.method public static native n0110311(Ljava/lang/Object;CC)V
.end method

.method public static native n01103111(Ljava/lang/Object;CCC)V
.end method

.method public static native n0110311131(Ljava/lang/Object;CCCLjava/lang/Object;C)V
.end method

.method public static native n01103113(Ljava/lang/Object;CCLjava/lang/Object;)V
.end method

.method public static native n011031133(Ljava/lang/Object;CCLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0110312(Ljava/lang/Object;CD)V
.end method

.method public static native n0110313(Ljava/lang/Object;CLjava/lang/Object;)V
.end method

.method public static native n011031311(Ljava/lang/Object;CLjava/lang/Object;CC)V
.end method

.method public static native n011032(Ljava/lang/Object;D)V
.end method

.method public static native n0110321(Ljava/lang/Object;DC)V
.end method

.method public static native n011033(Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0110331(Ljava/lang/Object;Ljava/lang/Object;C)V
.end method

.method public static native n01103311(Ljava/lang/Object;Ljava/lang/Object;CC)V
.end method

.method public static native n011033111(Ljava/lang/Object;Ljava/lang/Object;CCC)V
.end method

.method public static native n01103313(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)V
.end method

.method public static native n011033133(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0110331333(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0110333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n01103331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)V
.end method

.method public static native n011033311(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CC)V
.end method

.method public static native n01103332(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;D)V
.end method

.method public static native n01103333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0110333313(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)V
.end method

.method public static native n011033331333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n011033333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0110333332(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;D)V
.end method

.method public static native n0110333333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n01103333331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)V
.end method

.method public static native n01103333333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n011033333333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public static native n0111()C
.end method

.method public static native n01111(C)C
.end method

.method public static native n011111(CC)C
.end method

.method public static native n0111111(CCC)C
.end method

.method public static native n01111111(CCCC)C
.end method

.method public static native n0111113(CCLjava/lang/Object;)C
.end method

.method public static native n01111133(CCLjava/lang/Object;Ljava/lang/Object;)C
.end method

.method public static native n0111113333(CCLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)C
.end method

.method public static native n0111121(CDC)C
.end method

.method public static native n0111121111311(CDCCCCLjava/lang/Object;CC)C
.end method

.method public static native n0111123(CDLjava/lang/Object;)C
.end method

.method public static native n0111131(CLjava/lang/Object;C)C
.end method

.method public static native n0111133(CLjava/lang/Object;Ljava/lang/Object;)C
.end method

.method public static native n0111133333333331111111111131111111(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CCCCCCCCCCCLjava/lang/Object;CCCCCCC)C
.end method

.method public static native n01112(D)C
.end method

.method public static native n011121(DC)C
.end method

.method public static native n0111211(DCC)C
.end method

.method public static native n01112111(DCCC)C
.end method

.method public static native n0111211111(DCCCCC)C
.end method

.method public static native n01112113(DCCLjava/lang/Object;)C
.end method

.method public static native n0111212(DCD)C
.end method

.method public static native n0111213(DCLjava/lang/Object;)C
.end method

.method public static native n011122(DD)C
.end method

.method public static native n0111221(DDC)C
.end method

.method public static native n01112211(DDCC)C
.end method

.method public static native n011122111113(DDCCCCCLjava/lang/Object;)C
.end method

.method public static native n011122131(DDCLjava/lang/Object;C)C
.end method

.method public static native n011122133(DDCLjava/lang/Object;Ljava/lang/Object;)C
.end method

.method public static native n0111221331(DDCLjava/lang/Object;Ljava/lang/Object;C)C
.end method

.method public static native n0111222(DDD)C
.end method

.method public static native n01112222(DDDD)C
.end method

.method public static native n011122222(DDDDD)C
.end method

.method public static native n0111222222(DDDDDD)C
.end method

.method public static native n01112222222(DDDDDDD)C
.end method

.method public static native n0111223(DDLjava/lang/Object;)C
.end method

.method public static native n01112231(DDLjava/lang/Object;C)C
.end method

.method public static native n01112233(DDLjava/lang/Object;Ljava/lang/Object;)C
.end method

.method public static native n011123(DLjava/lang/Object;)C
.end method

.method public static native n0111231(DLjava/lang/Object;C)C
.end method

.method public static native n01112311(DLjava/lang/Object;CC)C
.end method

.method public static native n01112313(DLjava/lang/Object;CLjava/lang/Object;)C
.end method

.method public static native n0111232(DLjava/lang/Object;D)C
.end method

.method public static native n01112322(DLjava/lang/Object;DD)C
.end method

.method public static native n0111233(DLjava/lang/Object;Ljava/lang/Object;)C
.end method

.method public static native n01112332(DLjava/lang/Object;Ljava/lang/Object;D)C
.end method

.method public static native n01113(Ljava/lang/Object;)C
.end method

.method public static native n011131(Ljava/lang/Object;C)C
.end method

.method public static native n0111311(Ljava/lang/Object;CC)C
.end method

.method public static native n01113111(Ljava/lang/Object;CCC)C
.end method

.method public static native n01113121(Ljava/lang/Object;CDC)C
.end method

.method public static native n0111313(Ljava/lang/Object;CLjava/lang/Object;)C
.end method

.method public static native n01113131311111111(Ljava/lang/Object;CLjava/lang/Object;CLjava/lang/Object;CCCCCCCC)C
.end method

.method public static native n0111313131113111(Ljava/lang/Object;CLjava/lang/Object;CLjava/lang/Object;CCCLjava/lang/Object;CCC)C
.end method

.method public static native n01113131311133111111(Ljava/lang/Object;CLjava/lang/Object;CLjava/lang/Object;CCCLjava/lang/Object;Ljava/lang/Object;CCCCCC)C
.end method

.method public static native n01113131311311311311333111(Ljava/lang/Object;CLjava/lang/Object;CLjava/lang/Object;CCLjava/lang/Object;CCLjava/lang/Object;CCLjava/lang/Object;CCLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CCC)C
.end method

.method public static native n011132(Ljava/lang/Object;D)C
.end method

.method public static native n011133(Ljava/lang/Object;Ljava/lang/Object;)C
.end method

.method public static native n0111331(Ljava/lang/Object;Ljava/lang/Object;C)C
.end method

.method public static native n0111331111(Ljava/lang/Object;Ljava/lang/Object;CCCC)C
.end method

.method public static native n01113311111(Ljava/lang/Object;Ljava/lang/Object;CCCCC)C
.end method

.method public static native n0111333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)C
.end method

.method public static native n01113331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)C
.end method

.method public static native n011133311(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CC)C
.end method

.method public static native n01113331313(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;CLjava/lang/Object;)C
.end method

.method public static native n01113333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)C
.end method

.method public static native n0112()D
.end method

.method public static native n01121(C)D
.end method

.method public static native n011211(CC)D
.end method

.method public static native n0112111(CCC)D
.end method

.method public static native n01121111(CCCC)D
.end method

.method public static native n011212(CD)D
.end method

.method public static native n0112121(CDC)D
.end method

.method public static native n0112122(CDD)D
.end method

.method public static native n01121233(CDLjava/lang/Object;Ljava/lang/Object;)D
.end method

.method public static native n011213(CLjava/lang/Object;)D
.end method

.method public static native n0112133311112(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CCCCD)D
.end method

.method public static native n01122(D)D
.end method

.method public static native n011221(DC)D
.end method

.method public static native n0112211(DCC)D
.end method

.method public static native n0112212(DCD)D
.end method

.method public static native n011221223(DCDDLjava/lang/Object;)D
.end method

.method public static native n01122131(DCLjava/lang/Object;C)D
.end method

.method public static native n011222(DD)D
.end method

.method public static native n0112221(DDC)D
.end method

.method public static native n011222113(DDCCLjava/lang/Object;)D
.end method

.method public static native n0112222(DDD)D
.end method

.method public static native n0112222111(DDDCCC)D
.end method

.method public static native n01122222(DDDD)D
.end method

.method public static native n011222222(DDDDD)D
.end method

.method public static native n0112222222(DDDDDD)D
.end method

.method public static native n01122222222(DDDDDDD)D
.end method

.method public static native n0112223(DDLjava/lang/Object;)D
.end method

.method public static native n011223(DLjava/lang/Object;)D
.end method

.method public static native n0112231(DLjava/lang/Object;C)D
.end method

.method public static native n0112232(DLjava/lang/Object;D)D
.end method

.method public static native n0112233(DLjava/lang/Object;Ljava/lang/Object;)D
.end method

.method public static native n01122331(DLjava/lang/Object;Ljava/lang/Object;C)D
.end method

.method public static native n01123(Ljava/lang/Object;)D
.end method

.method public static native n011231(Ljava/lang/Object;C)D
.end method

.method public static native n01123113(Ljava/lang/Object;CCLjava/lang/Object;)D
.end method

.method public static native n011231332(Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;D)D
.end method

.method public static native n011232(Ljava/lang/Object;D)D
.end method

.method public static native n011233(Ljava/lang/Object;Ljava/lang/Object;)D
.end method

.method public static native n0112331(Ljava/lang/Object;Ljava/lang/Object;C)D
.end method

.method public static native n011233111(Ljava/lang/Object;Ljava/lang/Object;CCC)D
.end method

.method public static native n01123312(Ljava/lang/Object;Ljava/lang/Object;CD)D
.end method

.method public static native n0112333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)D
.end method

.method public static native n01123331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)D
.end method

.method public static native n01123333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)D
.end method

.method public static native n0113()Ljava/lang/Object;
.end method

.method public static native n01131(C)Ljava/lang/Object;
.end method

.method public static native n011311(CC)Ljava/lang/Object;
.end method

.method public static native n0113111(CCC)Ljava/lang/Object;
.end method

.method public static native n011311233(CCDLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011312(CD)Ljava/lang/Object;
.end method

.method public static native n0113121(CDC)Ljava/lang/Object;
.end method

.method public static native n01131211(CDCC)Ljava/lang/Object;
.end method

.method public static native n0113121111(CDCCCC)Ljava/lang/Object;
.end method

.method public static native n011312221111133(CDDDCCCCCLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n0113123(CDLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011313(CLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n0113133(CLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n01131333(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n01132(D)Ljava/lang/Object;
.end method

.method public static native n011321(DC)Ljava/lang/Object;
.end method

.method public static native n0113211(DCC)Ljava/lang/Object;
.end method

.method public static native n011321223(DCDDLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011322(DD)Ljava/lang/Object;
.end method

.method public static native n0113221(DDC)Ljava/lang/Object;
.end method

.method public static native n01132211(DDCC)Ljava/lang/Object;
.end method

.method public static native n0113222(DDD)Ljava/lang/Object;
.end method

.method public static native n01132222(DDDD)Ljava/lang/Object;
.end method

.method public static native n011322222(DDDDD)Ljava/lang/Object;
.end method

.method public static native n0113222222(DDDDDD)Ljava/lang/Object;
.end method

.method public static native n01132222222(DDDDDDD)Ljava/lang/Object;
.end method

.method public static native n01132233(DDLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011323(DLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n0113231(DLjava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static native n01132331(DLjava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static native n011323323(DLjava/lang/Object;Ljava/lang/Object;DLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011323333111(DLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CCC)Ljava/lang/Object;
.end method

.method public static native n0113233333111(DLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CCC)Ljava/lang/Object;
.end method

.method public static native n01133(Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011331(Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static native n0113311(Ljava/lang/Object;CC)Ljava/lang/Object;
.end method

.method public static native n01133111(Ljava/lang/Object;CCC)Ljava/lang/Object;
.end method

.method public static native n011331111(Ljava/lang/Object;CCCC)Ljava/lang/Object;
.end method

.method public static native n01133112(Ljava/lang/Object;CCD)Ljava/lang/Object;
.end method

.method public static native n0113311313(Ljava/lang/Object;CCLjava/lang/Object;CLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n01133131(Ljava/lang/Object;CLjava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static native n01133133331(Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static native n011332(Ljava/lang/Object;D)Ljava/lang/Object;
.end method

.method public static native n01133211(Ljava/lang/Object;DCC)Ljava/lang/Object;
.end method

.method public static native n0113322(Ljava/lang/Object;DD)Ljava/lang/Object;
.end method

.method public static native n0113323(Ljava/lang/Object;DLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011333(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n0113331(Ljava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static native n01133311(Ljava/lang/Object;Ljava/lang/Object;CC)Ljava/lang/Object;
.end method

.method public static native n01133313(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n01133313311331123(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;CCLjava/lang/Object;Ljava/lang/Object;CCDLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n01133313331(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static native n0113333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n01133331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static native n0113333133(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n01133333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n011333331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static native n011333333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public static native n0113333331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public static needExtractSo()Z
    .registers 3

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->a:Ljava/lang/String;

    const-string v1, "fw=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "FQsRAAU2HToXFQYVIAoTRRYrBBYBCx0ABAIHXw=="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return v0
.end method

.method public static needX86So()Z
    .registers 3

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->d:Ljava/lang/String;

    const-string v1, "fw=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "FQsRAAUrXXg2GzhBESsrABA9WUVf"

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return v0
.end method


# virtual methods
.method protected attachBaseContext(Landroid/content/Context;)V
    .registers 12

    const/4 v6, 0x1

    invoke-super {p0, p1}, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    sput-object p1, Lcom/netease/nis/wrapper/MyApplication;->e:Landroid/content/Context;

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->b:Ljava/lang/String;

    const-string v2, "fw=="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    sput-boolean v0, Lcom/netease/nis/wrapper/MyApplication;->f:Z

    sget v0, Lcom/netease/nis/wrapper/MyApplication;->g:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/netease/nis/wrapper/MyApplication;->g:I

    invoke-static {}, Lcom/netease/nis/wrapper/MyApplication;->a()Z

    move-result v0

    if-eqz v0, :cond_25

    :goto_24
    return-void

    :cond_25
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v3, "FQQAEQAQDQwEBwAiHAs6AAwRPFMHKwIdC01TEysXBwwOHV8="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/netease/nis/wrapper/MyApplication;->getVersion()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "bggkFw4FDCoABjYWGhEtDU4="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-boolean v3, Lcom/netease/nis/wrapper/MyApplication;->f:Z

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    if-nez v0, :cond_18c

    sget-boolean v0, Lcom/netease/nis/wrapper/MyApplication;->mLoadShell:Z

    if-nez v0, :cond_7b

    invoke-static {}, Lcom/netease/nis/wrapper/MyApplication;->needExtractSo()Z

    move-result v0

    if-eqz v0, :cond_60

    invoke-static {p1}, Lcom/netease/nis/wrapper/plugin/c;->a(Landroid/content/Context;)V

    :cond_60
    const-string v0, "IAAHAAI="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/netease/nis/wrapper/MyApplication;->needX86So()Z

    move-result v3

    if-eqz v3, :cond_78

    invoke-static {}, Lcom/netease/nis/wrapper/MyJni;->a()Z

    move-result v3

    if-eqz v3, :cond_78

    const-string v0, "IAAHAAJeHXZT"

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_78
    :try_start_78
    invoke-static {p1, v0}, Lcom/netease/nis/wrapper/o;->a(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_7b
    .catch Ljava/lang/Exception; {:try_start_78 .. :try_end_7b} :catch_1c0

    :cond_7b
    :goto_7b
    invoke-static {p0, v1}, Lcom/netease/nis/wrapper/MyJni;->load(Landroid/app/Application;Ljava/lang/String;)Z

    invoke-static {p1}, Lcom/netease/nis/wrapper/MyJni;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_166

    sput-boolean v6, Lcom/netease/nis/wrapper/MyApplication;->mNeedBugrpt:Z

    invoke-static {}, Lcom/netease/nis/wrapper/MyApplication;->getVersion()Ljava/lang/String;

    move-result-object v0

    sget-boolean v1, Lcom/netease/nis/wrapper/a;->b:Z

    :try_start_8c
    const-string v3, "LQoZSw8WESsEBwBPHQw9Sw=="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "LBATFxEH"

    invoke-static/range {v4 .. v4}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "YBAHABNdMD0ABjYVAQQ6ABMc"

    invoke-static/range {v4 .. v4}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v4

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Class;

    const/4 v6, 0x0

    const-class v7, Landroid/content/Context;

    aput-object v7, v5, v6

    invoke-virtual {v4, v5}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v5

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-virtual {v5, v6}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    const-string v6, "PQAAMBIWFxoEEw=="

    invoke-static/range {v6 .. v6}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    const-class v9, Ljava/lang/String;

    aput-object v9, v7, v8

    invoke-virtual {v4, v6, v7}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v6

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v0, v7, v8

    invoke-virtual {v6, v5, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    if-eqz v1, :cond_133

    const-string v0, "PQAAIwgfESsXIwoTFxY="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Class;

    const/4 v6, 0x0

    const-class v7, [Ljava/lang/String;

    aput-object v7, v1, v6

    invoke-virtual {v4, v0, v1}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    if-eqz v0, :cond_133

    const/4 v1, 0x6

    new-array v1, v1, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v6, "LQoZSw8WESsEBwBPHQw9SwMXAAMVKxc="

    invoke-static/range {v6 .. v6}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v1, v4

    const/4 v4, 0x1

    const-string v6, "IgwWCwQAAC0="

    invoke-static/range {v6 .. v6}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v1, v4

    const/4 v4, 0x2

    const-string v6, "IgwWCwQUEC8XEEsSHA=="

    invoke-static/range {v6 .. v6}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v1, v4

    const/4 v4, 0x3

    const-string v6, "IgwWAQQLAycdWhYO"

    invoke-static/range {v6 .. v6}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v1, v4

    const/4 v4, 0x4

    const-string v6, "JgwaEVs="

    invoke-static/range {v6 .. v6}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v1, v4

    const/4 v4, 0x5

    const-string v6, "GQAWMwgWEgkKGwINFg=="

    invoke-static/range {v6 .. v6}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v1, v4

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v1, v4, v6

    invoke-virtual {v0, v5, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    :cond_133
    const-string v0, "YCYGBBIbLS8LEAkEAQ=="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-string v1, "JwsdEQ=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v6, Landroid/content/Context;

    aput-object v6, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-virtual {v0, v1, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    aput-object v5, v3, v4

    invoke-virtual {v1, v0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_166
    .catch Ljava/lang/Exception; {:try_start_8c .. :try_end_166} :catch_1d8

    :cond_166
    :goto_166
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "FQkbBAUuRToMGQBb"

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    sub-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p1}, Lcom/netease/nis/wrapper/MyApplication;->a(Landroid/content/Context;)Landroid/app/Application;

    move-result-object v0

    sput-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    invoke-static {p1, v0}, Lcom/netease/nis/wrapper/MyJni;->ra(Landroid/content/Context;Landroid/app/Application;)Z

    :cond_18c
    const-string v0, "IAoANRMcBy8RHQoP"

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/netease/nis/wrapper/NEDialog;->showProbation(Ljava/lang/String;)V

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->runApp:Landroid/app/Application;

    if-nez v0, :cond_19b

    sput-object p0, Lcom/netease/nis/wrapper/MyApplication;->runApp:Landroid/app/Application;

    :cond_19b
    sget-boolean v0, Lcom/netease/nis/wrapper/MyApplication;->f:Z

    if-nez v0, :cond_1a2

    invoke-static {}, Lcom/netease/nis/wrapper/MyJni;->cp()V

    :cond_1a2
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "FQQAEQAQDQwEBwAiHAs6AAwRPFMAIAFYRRUaCCtf"

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    sub-long v2, v4, v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_24

    :catch_1c0
    move-exception v3

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "FQQAEQAQDQwEBwAiHAs6AAwRPFMJIQQQFg5TADYGERUVGgogSQ=="

    invoke-static/range {v5 .. v5}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    goto/16 :goto_7b

    :catch_1d8
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "JwsdEUERECkXBBFBFhc8CgZf"

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_166
.end method

.method public createPackageContext(Ljava/lang/String;I)Landroid/content/Context;
    .registers 5

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->strAppName:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_c

    sget-boolean v0, Lcom/netease/nis/wrapper/MyApplication;->f:Z

    if-nez v0, :cond_11

    :cond_c
    invoke-super {p0, p1, p2}, Landroid/app/Application;->createPackageContext(Ljava/lang/String;I)Landroid/content/Context;

    move-result-object v0

    :goto_10
    return-object v0

    :cond_11
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "FQYGAAAHAB4EFw4AFAANChoRBAsRE0UEBAIYBCkAOgQMFl8="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "bgMYBAYAXw=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->runApp:Landroid/app/Application;

    invoke-virtual {v0}, Landroid/app/Application;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    invoke-static {v0, v1}, Lcom/netease/nis/wrapper/MyJni;->rp(Landroid/content/Context;Landroid/app/Application;)Z

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    invoke-virtual {v0}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_47

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    goto :goto_10

    :cond_47
    invoke-super {p0, p1, p2}, Landroid/app/Application;->createPackageContext(Ljava/lang/String;I)Landroid/content/Context;

    move-result-object v0

    goto :goto_10
.end method

.method public getPackageName()Ljava/lang/String;
    .registers 2

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->strAppName:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_c

    sget-boolean v0, Lcom/netease/nis/wrapper/MyApplication;->f:Z

    if-nez v0, :cond_11

    :cond_c
    invoke-super {p0}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v0

    :goto_10
    return-object v0

    :cond_11
    const-string v0, ""

    goto :goto_10
.end method

.method public native n1110()V
.end method

.method public native n11101(C)V
.end method

.method public native n111011(CC)V
.end method

.method public native n1110111(CCC)V
.end method

.method public native n11101111(CCCC)V
.end method

.method public native n1110111111(CCCCCC)V
.end method

.method public native n111011121(CCCDC)V
.end method

.method public native n111011123(CCCDLjava/lang/Object;)V
.end method

.method public native n11101113(CCCLjava/lang/Object;)V
.end method

.method public native n11101123(CCDLjava/lang/Object;)V
.end method

.method public native n1110113(CCLjava/lang/Object;)V
.end method

.method public native n111011333331(CCLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)V
.end method

.method public native n111012(CD)V
.end method

.method public native n1110121123(CDCCDLjava/lang/Object;)V
.end method

.method public native n111013(CLjava/lang/Object;)V
.end method

.method public native n1110131(CLjava/lang/Object;C)V
.end method

.method public native n1110132(CLjava/lang/Object;D)V
.end method

.method public native n1110133(CLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n111013311(CLjava/lang/Object;Ljava/lang/Object;CC)V
.end method

.method public native n1110133333(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1110133333331(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)V
.end method

.method public native n11102(D)V
.end method

.method public native n111021(DC)V
.end method

.method public native n1110211(DCC)V
.end method

.method public native n11102111(DCCC)V
.end method

.method public native n111021111(DCCCC)V
.end method

.method public native n1110211111(DCCCCC)V
.end method

.method public native n1110211111111(DCCCCCCCC)V
.end method

.method public native n111021111111111111111333(DCCCCCCCCCCCCCCCCLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n11102113(DCCLjava/lang/Object;)V
.end method

.method public native n111021131(DCCLjava/lang/Object;C)V
.end method

.method public native n1110212(DCD)V
.end method

.method public native n1110213(DCLjava/lang/Object;)V
.end method

.method public native n11102131(DCLjava/lang/Object;C)V
.end method

.method public native n111021311111(DCLjava/lang/Object;CCCCC)V
.end method

.method public native n111021311111111(DCLjava/lang/Object;CCCCCCCC)V
.end method

.method public native n1110213111111221(DCLjava/lang/Object;CCCCCCDDC)V
.end method

.method public native n111022(DD)V
.end method

.method public native n1110221(DDC)V
.end method

.method public native n11102211(DDCC)V
.end method

.method public native n1110222(DDD)V
.end method

.method public native n1110223(DDLjava/lang/Object;)V
.end method

.method public native n11102231(DDLjava/lang/Object;C)V
.end method

.method public native n11102232(DDLjava/lang/Object;D)V
.end method

.method public native n11102233(DDLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n111023(DLjava/lang/Object;)V
.end method

.method public native n1110231(DLjava/lang/Object;C)V
.end method

.method public native n111023111(DLjava/lang/Object;CCC)V
.end method

.method public native n111023113(DLjava/lang/Object;CCLjava/lang/Object;)V
.end method

.method public native n1110232(DLjava/lang/Object;D)V
.end method

.method public native n1110233(DLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n11102331(DLjava/lang/Object;Ljava/lang/Object;C)V
.end method

.method public native n111023311(DLjava/lang/Object;Ljava/lang/Object;CC)V
.end method

.method public native n1110233333(DLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n11103(Ljava/lang/Object;)V
.end method

.method public native n111031(Ljava/lang/Object;C)V
.end method

.method public native n1110311(Ljava/lang/Object;CC)V
.end method

.method public native n11103111(Ljava/lang/Object;CCC)V
.end method

.method public native n1110313(Ljava/lang/Object;CLjava/lang/Object;)V
.end method

.method public native n11103131(Ljava/lang/Object;CLjava/lang/Object;C)V
.end method

.method public native n11103133(Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n111032(Ljava/lang/Object;D)V
.end method

.method public native n1110321(Ljava/lang/Object;DC)V
.end method

.method public native n11103211(Ljava/lang/Object;DCC)V
.end method

.method public native n1110323(Ljava/lang/Object;DLjava/lang/Object;)V
.end method

.method public native n111033(Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1110331(Ljava/lang/Object;Ljava/lang/Object;C)V
.end method

.method public native n11103311(Ljava/lang/Object;Ljava/lang/Object;CC)V
.end method

.method public native n11103313(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)V
.end method

.method public native n1110332(Ljava/lang/Object;Ljava/lang/Object;D)V
.end method

.method public native n1110333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n11103331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)V
.end method

.method public native n111033313(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)V
.end method

.method public native n11103331333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n11103333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n111033332(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;D)V
.end method

.method public native n111033333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1110333331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)V
.end method

.method public native n1110333333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public native n1111()C
.end method

.method public native n11111(C)C
.end method

.method public native n111111(CC)C
.end method

.method public native n111111133(CCCLjava/lang/Object;Ljava/lang/Object;)C
.end method

.method public native n1111113(CCLjava/lang/Object;)C
.end method

.method public native n111113(CLjava/lang/Object;)C
.end method

.method public native n11111331(CLjava/lang/Object;Ljava/lang/Object;C)C
.end method

.method public native n1111133311133(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CCCLjava/lang/Object;Ljava/lang/Object;)C
.end method

.method public native n11111333111333(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CCCLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)C
.end method

.method public native n11111333331(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)C
.end method

.method public native n11112(D)C
.end method

.method public native n111121(DC)C
.end method

.method public native n1111211(DCC)C
.end method

.method public native n11112111(DCCC)C
.end method

.method public native n111121111(DCCCC)C
.end method

.method public native n1111211111(DCCCCC)C
.end method

.method public native n111121111111111(DCCCCCCCCCC)C
.end method

.method public native n1111211123(DCCCDLjava/lang/Object;)C
.end method

.method public native n111121121(DCCDC)C
.end method

.method public native n111121122(DCCDD)C
.end method

.method public native n11112122(DCDD)C
.end method

.method public native n111121221(DCDDC)C
.end method

.method public native n111121223(DCDDLjava/lang/Object;)C
.end method

.method public native n1111213(DCLjava/lang/Object;)C
.end method

.method public native n1111213122(DCLjava/lang/Object;CDD)C
.end method

.method public native n111122(DD)C
.end method

.method public native n1111221(DDC)C
.end method

.method public native n11112211(DDCC)C
.end method

.method public native n111122113(DDCCLjava/lang/Object;)C
.end method

.method public native n1111222(DDD)C
.end method

.method public native n11112221(DDDC)C
.end method

.method public native n1111223(DDLjava/lang/Object;)C
.end method

.method public native n11112232(DDLjava/lang/Object;D)C
.end method

.method public native n111123(DLjava/lang/Object;)C
.end method

.method public native n1111231(DLjava/lang/Object;C)C
.end method

.method public native n11112311(DLjava/lang/Object;CC)C
.end method

.method public native n111123111(DLjava/lang/Object;CCC)C
.end method

.method public native n1111231111111113131(DLjava/lang/Object;CCCCCCCCCLjava/lang/Object;CLjava/lang/Object;C)C
.end method

.method public native n111123111111122(DLjava/lang/Object;CCCCCCCDD)C
.end method

.method public native n11112311111112212(DLjava/lang/Object;CCCCCCCDDCD)C
.end method

.method public native n111123111111221(DLjava/lang/Object;CCCCCCDDC)C
.end method

.method public native n111123111111221311111112212(DLjava/lang/Object;CCCCCCDDCLjava/lang/Object;CCCCCCCDDCD)C
.end method

.method public native n1111231111122121(DLjava/lang/Object;CCCCCDDCDC)C
.end method

.method public native n11112311112(DLjava/lang/Object;CCCCD)C
.end method

.method public native n1111231221(DLjava/lang/Object;CDDC)C
.end method

.method public native n11112312222(DLjava/lang/Object;CDDDD)C
.end method

.method public native n1111232(DLjava/lang/Object;D)C
.end method

.method public native n11112321(DLjava/lang/Object;DC)C
.end method

.method public native n11112322(DLjava/lang/Object;DD)C
.end method

.method public native n111123221(DLjava/lang/Object;DDC)C
.end method

.method public native n111123223(DLjava/lang/Object;DDLjava/lang/Object;)C
.end method

.method public native n11112323(DLjava/lang/Object;DLjava/lang/Object;)C
.end method

.method public native n1111233(DLjava/lang/Object;Ljava/lang/Object;)C
.end method

.method public native n11112331(DLjava/lang/Object;Ljava/lang/Object;C)C
.end method

.method public native n11112331111111(DLjava/lang/Object;Ljava/lang/Object;CCCCCCC)C
.end method

.method public native n11113(Ljava/lang/Object;)C
.end method

.method public native n111131(Ljava/lang/Object;C)C
.end method

.method public native n1111311(Ljava/lang/Object;CC)C
.end method

.method public native n11113211(Ljava/lang/Object;DCC)C
.end method

.method public native n111133(Ljava/lang/Object;Ljava/lang/Object;)C
.end method

.method public native n11113311(Ljava/lang/Object;Ljava/lang/Object;CC)C
.end method

.method public native n111133111(Ljava/lang/Object;Ljava/lang/Object;CCC)C
.end method

.method public native n1111333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)C
.end method

.method public native n11113333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)C
.end method

.method public native n11113333313(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)C
.end method

.method public native n1112()D
.end method

.method public native n111211(CC)D
.end method

.method public native n111212(CD)D
.end method

.method public native n11121331111(CLjava/lang/Object;Ljava/lang/Object;CCCC)D
.end method

.method public native n1112133313(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)D
.end method

.method public native n11122(D)D
.end method

.method public native n111221(DC)D
.end method

.method public native n1112211(DCC)D
.end method

.method public native n111222(DD)D
.end method

.method public native n1112221(DDC)D
.end method

.method public native n1112223(DDLjava/lang/Object;)D
.end method

.method public native n11122231(DDLjava/lang/Object;C)D
.end method

.method public native n11122232(DDLjava/lang/Object;D)D
.end method

.method public native n1112231(DLjava/lang/Object;C)D
.end method

.method public native n1112232(DLjava/lang/Object;D)D
.end method

.method public native n11122331(DLjava/lang/Object;Ljava/lang/Object;C)D
.end method

.method public native n11123(Ljava/lang/Object;)D
.end method

.method public native n11123111(Ljava/lang/Object;CCC)D
.end method

.method public native n1112313(Ljava/lang/Object;CLjava/lang/Object;)D
.end method

.method public native n111232(Ljava/lang/Object;D)D
.end method

.method public native n11123221(Ljava/lang/Object;DDC)D
.end method

.method public native n111233(Ljava/lang/Object;Ljava/lang/Object;)D
.end method

.method public native n1112331111(Ljava/lang/Object;Ljava/lang/Object;CCCC)D
.end method

.method public native n11123313(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)D
.end method

.method public native n11123333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)D
.end method

.method public native n1113()Ljava/lang/Object;
.end method

.method public native n11131(C)Ljava/lang/Object;
.end method

.method public native n111311(CC)Ljava/lang/Object;
.end method

.method public native n11131111(CCCC)Ljava/lang/Object;
.end method

.method public native n111311113(CCCCLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11131113(CCCLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111313(CLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11131333(CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11132(D)Ljava/lang/Object;
.end method

.method public native n111321(DC)Ljava/lang/Object;
.end method

.method public native n1113211133(DCCCLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111321133(DCCLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11132121(DCDC)Ljava/lang/Object;
.end method

.method public native n11132123(DCDLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111321232(DCDLjava/lang/Object;D)Ljava/lang/Object;
.end method

.method public native n111321331(DCLjava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public native n111322(DD)Ljava/lang/Object;
.end method

.method public native n1113221(DDC)Ljava/lang/Object;
.end method

.method public native n11132211(DDCC)Ljava/lang/Object;
.end method

.method public native n11132222(DDDD)Ljava/lang/Object;
.end method

.method public native n1113223(DDLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11132232(DDLjava/lang/Object;D)Ljava/lang/Object;
.end method

.method public native n111323(DLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n1113233(DLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11132331(DLjava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public native n111323333(DLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11133(Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111331(Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public native n1113311(Ljava/lang/Object;CC)Ljava/lang/Object;
.end method

.method public native n1113311111(Ljava/lang/Object;CCCCC)Ljava/lang/Object;
.end method

.method public native n11133131(Ljava/lang/Object;CLjava/lang/Object;C)Ljava/lang/Object;
.end method

.method public native n1113313331(Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public native n111332(Ljava/lang/Object;D)Ljava/lang/Object;
.end method

.method public native n111333(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11133311(Ljava/lang/Object;Ljava/lang/Object;CC)Ljava/lang/Object;
.end method

.method public native n111333111(Ljava/lang/Object;Ljava/lang/Object;CCC)Ljava/lang/Object;
.end method

.method public native n11133313(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111333131333(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11133313331(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public native n11133313333(Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n1113333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11133331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;C)Ljava/lang/Object;
.end method

.method public native n111333313(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11133333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11133333311(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CC)Ljava/lang/Object;
.end method

.method public native n11133333313(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n111333333313(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;)Ljava/lang/Object;
.end method

.method public native n11133333333(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method

.method public onCreate()V
    .registers 7

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    invoke-static {}, Lcom/netease/nis/wrapper/MyApplication;->a()Z

    move-result v2

    if-eqz v2, :cond_e

    :goto_d
    return-void

    :cond_e
    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->runApp:Landroid/app/Application;

    if-eqz v2, :cond_1d

    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->runApp:Landroid/app/Application;

    invoke-virtual {v2}, Landroid/app/Application;->getBaseContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    invoke-static {v2, v3}, Lcom/netease/nis/wrapper/MyJni;->run(Landroid/content/Context;Landroid/app/Application;)Z

    :cond_1d
    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    if-eqz v2, :cond_61

    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    invoke-static {v2}, Lcom/netease/nis/wrapper/MyJni;->ip(Landroid/app/Application;)V

    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->newApp:Landroid/app/Application;

    invoke-virtual {v2}, Landroid/app/Application;->onCreate()V

    :goto_2b
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "FRcBCzxTEScIEV8="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long/2addr v4, v0

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/netease/nis/wrapper/MyApplication;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    sput-object v2, Lcom/netease/nis/wrapper/MyApplication;->e:Landroid/content/Context;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "FQoaJhMWBDoAKUUEHQFiRQAMDBZf"

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v0, v4, v0

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_d

    :cond_61
    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->runApp:Landroid/app/Application;

    invoke-static {v2}, Lcom/netease/nis/wrapper/MyJni;->ip(Landroid/app/Application;)V

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "FRcBCzxTKDckBBUNGgYvER0KD10LKxI1FRFTDD1FGhANH0k8EBokEQNFJxZU"

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/netease/nis/wrapper/MyApplication;->runApp:Landroid/app/Application;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_2b
.end method
