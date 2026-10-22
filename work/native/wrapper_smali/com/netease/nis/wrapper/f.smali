.class public final Lcom/netease/nis/wrapper/f;
.super Ljava/lang/Object;


# static fields
.field public static a:Ljava/io/File; = null

.field private static final b:I = 0x1000


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const/4 v0, 0x0

    sput-object v0, Lcom/netease/nis/wrapper/f;->a:Ljava/io/File;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a()Landroid/content/pm/ApplicationInfo;
    .registers 5

    const/4 v1, 0x0

    :try_start_1
    const-string v0, "LwsQFw4aAWAEBBVPMgY6DAIMFQoxJhcRBAU="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-string v2, "LRAGFwQdEQ8GAAwXGhE3MRwXBBIB"

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Class;

    invoke-virtual {v0, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v2, v3, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    const-string v3, "IycbEA8XJD4VGAwCEhEnCho="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "LxUELA8VCg=="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    invoke-virtual {v2, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ApplicationInfo;
    :try_end_4a
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_4a} :catch_4b

    :goto_4a
    return-object v0

    :catch_4b
    move-exception v0

    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "KQAAJBEDCScGFREIHAsHCxIKQRUEJwkRAUFJRQ=="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object v0, v1

    goto :goto_4a
.end method

.method private static a(Landroid/content/pm/ApplicationInfo;)Ljava/io/File;
    .registers 4

    sget-object v0, Lcom/netease/nis/wrapper/f;->a:Ljava/io/File;

    if-nez v0, :cond_1e

    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    const-string v2, "KAwYABI="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/netease/nis/wrapper/f;->a:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_1e

    sget-object v0, Lcom/netease/nis/wrapper/f;->a:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    :cond_1e
    sget-object v0, Lcom/netease/nis/wrapper/f;->a:Ljava/io/File;

    return-object v0
.end method

.method private static a(Ljava/io/Closeable;)V
    .registers 2

    if-eqz p0, :cond_5

    :try_start_2
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_5} :catch_6

    :cond_5
    :goto_5
    return-void

    :catch_6
    move-exception v0

    goto :goto_5
.end method

.method private static a(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .registers 7

    const/4 v1, 0x0

    const/16 v0, 0x1000

    new-array v2, v0, [B

    :goto_5
    invoke-virtual {p0, v2}, Ljava/io/InputStream;->read([B)I

    move-result v3

    const/4 v0, -0x1

    if-eq v3, v0, :cond_1d

    move v0, v1

    :goto_d
    if-ge v0, v3, :cond_19

    aget-byte v4, v2, v0

    xor-int/lit8 v4, v4, 0x7f

    int-to-byte v4, v4

    aput-byte v4, v2, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_d

    :cond_19
    invoke-virtual {p1, v2, v1, v3}, Ljava/io/OutputStream;->write([BII)V

    goto :goto_5

    :cond_1d
    return-void
.end method

.method public static a(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)Z
    .registers 6

    const/4 v1, 0x1

    const-string v0, "IAAHAAI="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/netease/nis/wrapper/MyApplication;->needX86So()Z

    move-result v2

    if-eqz v2, :cond_2a

    invoke-static {}, Lcom/netease/nis/wrapper/MyJni;->a()Z

    move-result v2

    if-eqz v2, :cond_2a

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "Yx1MUw=="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_2a
    invoke-static {p0, p1}, Lcom/netease/nis/wrapper/f;->b(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)Z

    :try_start_2d
    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "DQoZFUEfCi8BOAwDAQQ8HFQ="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "bhYBBgIWFj0="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v2, 0x1

    sput-boolean v2, Lcom/netease/nis/wrapper/MyApplication;->mLoadShell:Z
    :try_end_4d
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_2d .. :try_end_4d} :catch_4f

    move v0, v1

    :goto_4e
    return v0

    :catch_4f
    move-exception v1

    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "DQoZFUEfCi8BOAwDAQQ8HFQ="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "bgMVDA0WAW5fVA=="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v1}, Ljava/lang/UnsatisfiedLinkError;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v0, 0x0

    goto :goto_4e
.end method

.method private static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .registers 9

    const/4 v3, 0x0

    const/4 v1, 0x1

    const/4 v0, 0x0

    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "PREVFxVTECAfHRVB"

    invoke-static/range {v4 .. v4}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "bgMGCgw="

    invoke-static/range {v4 .. v4}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "bhEbRQ=="

    invoke-static/range {v4 .. v4}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :try_start_2f
    new-instance v2, Ljava/util/zip/ZipFile;

    new-instance v4, Ljava/io/File;

    invoke-direct {v4, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    const/4 v5, 0x1

    invoke-direct {v2, v4, v5}, Ljava/util/zip/ZipFile;-><init>(Ljava/io/File;I)V

    invoke-virtual {v2, p1}, Ljava/util/zip/ZipFile;->getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;

    move-result-object v4

    if-nez v4, :cond_5b

    sget-object v1, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "KAwaAUEWCzoXDUU="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "KAQdCQQX"

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_5a
    .catch Ljava/io/IOException; {:try_start_2f .. :try_end_5a} :catch_78

    :goto_5a
    return v0

    :cond_5b
    :try_start_5b
    invoke-virtual {v2, v4}, Ljava/util/zip/ZipFile;->getInputStream(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    :try_end_5e
    .catch Ljava/io/FileNotFoundException; {:try_start_5b .. :try_end_5e} :catch_6f
    .catch Ljava/io/IOException; {:try_start_5b .. :try_end_5e} :catch_7a
    .catchall {:try_start_5b .. :try_end_5e} :catchall_83

    move-result-object v4

    :try_start_5f
    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, p2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V
    :try_end_64
    .catch Ljava/io/FileNotFoundException; {:try_start_5f .. :try_end_64} :catch_96
    .catch Ljava/io/IOException; {:try_start_5f .. :try_end_64} :catch_91
    .catchall {:try_start_5f .. :try_end_64} :catchall_8c

    :try_start_64
    invoke-static {v4, v2}, Lcom/netease/nis/wrapper/f;->a(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    :try_end_67
    .catch Ljava/io/FileNotFoundException; {:try_start_64 .. :try_end_67} :catch_9a
    .catch Ljava/io/IOException; {:try_start_64 .. :try_end_67} :catch_93
    .catchall {:try_start_64 .. :try_end_67} :catchall_8e

    :try_start_67
    invoke-static {v4}, Lcom/netease/nis/wrapper/f;->a(Ljava/io/Closeable;)V

    invoke-static {v2}, Lcom/netease/nis/wrapper/f;->a(Ljava/io/Closeable;)V

    move v0, v1

    goto :goto_5a

    :catch_6f
    move-exception v1

    move-object v1, v3

    :goto_71
    invoke-static {v3}, Lcom/netease/nis/wrapper/f;->a(Ljava/io/Closeable;)V

    invoke-static {v1}, Lcom/netease/nis/wrapper/f;->a(Ljava/io/Closeable;)V

    goto :goto_5a

    :catch_78
    move-exception v1

    goto :goto_5a

    :catch_7a
    move-exception v1

    move-object v4, v3

    :goto_7c
    invoke-static {v4}, Lcom/netease/nis/wrapper/f;->a(Ljava/io/Closeable;)V

    invoke-static {v3}, Lcom/netease/nis/wrapper/f;->a(Ljava/io/Closeable;)V

    goto :goto_5a

    :catchall_83
    move-exception v1

    move-object v4, v3

    :goto_85
    invoke-static {v4}, Lcom/netease/nis/wrapper/f;->a(Ljava/io/Closeable;)V

    invoke-static {v3}, Lcom/netease/nis/wrapper/f;->a(Ljava/io/Closeable;)V

    throw v1
    :try_end_8c
    .catch Ljava/io/IOException; {:try_start_67 .. :try_end_8c} :catch_78

    :catchall_8c
    move-exception v1

    goto :goto_85

    :catchall_8e
    move-exception v1

    move-object v3, v2

    goto :goto_85

    :catch_91
    move-exception v1

    goto :goto_7c

    :catch_93
    move-exception v1

    move-object v3, v2

    goto :goto_7c

    :catch_96
    move-exception v1

    move-object v1, v3

    move-object v3, v4

    goto :goto_71

    :catch_9a
    move-exception v1

    move-object v1, v2

    move-object v3, v4

    goto :goto_71
.end method

.method private static b(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)Z
    .registers 11

    const/4 v1, 0x1

    const/4 v0, 0x0

    new-instance v2, Ljava/io/File;

    iget-object v3, p1, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->lastModified()J

    move-result-wide v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1}, Lcom/netease/nis/wrapper/f;->a(Landroid/content/pm/ApplicationInfo;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "YRERCBEfDCw="

    invoke-static/range {v5 .. v5}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "YQ=="

    invoke-static/range {v6 .. v6}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v5

    if-nez v5, :cond_51

    invoke-virtual {v3}, Ljava/io/File;->mkdirs()Z

    :cond_51
    :try_start_51
    invoke-static {p0, v3}, Lcom/netease/nis/wrapper/plugin/c;->a(Ljava/lang/ClassLoader;Ljava/io/File;)V
    :try_end_54
    .catch Ljava/lang/Throwable; {:try_start_51 .. :try_end_54} :catch_60

    :goto_54
    new-instance v5, Ljava/io/File;

    invoke-direct {v5, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_67

    :goto_5f
    return v0

    :catch_60
    move-exception v5

    sget-object v6, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    goto :goto_54

    :cond_67
    invoke-virtual {v3}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v3

    if-eqz v3, :cond_7f

    array-length v6, v3

    move v2, v0

    :goto_6f
    if-ge v2, v6, :cond_7f

    aget-object v7, v3, v2

    invoke-virtual {v7}, Ljava/io/File;->isFile()Z

    move-result v8

    if-eqz v8, :cond_7c

    invoke-virtual {v7}, Ljava/io/File;->delete()Z

    :cond_7c
    add-int/lit8 v2, v2, 0x1

    goto :goto_6f

    :cond_7f
    :try_start_7f
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1}, Lcom/netease/nis/wrapper/f;->a(Landroid/content/pm/ApplicationInfo;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "YRERCBEfDCxKGAwDAEs0DAQ="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p1, Landroid/content/pm/ApplicationInfo;->nativeLibraryDir:Ljava/lang/String;

    iget-object v6, p1, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    const-string v7, "LxYHABUASmALERYEEDo+BAAGCQ=="

    invoke-static/range {v7 .. v7}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7, v2}, Lcom/netease/nis/wrapper/f;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_bf

    sget-object v6, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    invoke-static {v2, v4, v3}, Lcom/netease/nis/wrapper/plugin/c;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_bc

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    move v0, v1

    :goto_b5
    if-eqz v0, :cond_ba

    invoke-virtual {v5}, Ljava/io/File;->createNewFile()Z

    :cond_ba
    :goto_ba
    move v0, v1

    goto :goto_5f

    :cond_bc
    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    goto :goto_b5

    :cond_bf
    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;
    :try_end_c1
    .catch Ljava/lang/Exception; {:try_start_7f .. :try_end_c1} :catch_c2

    goto :goto_b5

    :catch_c2
    move-exception v0

    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    goto :goto_ba
.end method
