
void FUN_001780dc(long *param_1,int param_2,undefined4 param_3)

{
  byte bVar1;
  undefined1 *puVar2;
  uint uVar3;
  ulong uVar4;
  ulong uVar5;
  ulong uVar6;
  ulong uVar7;
  undefined1 auVar8 [16];
  long lVar9;
  undefined *puVar10;
  uint uVar11;
  bool bVar12;
  int iVar13;
  uint *puVar14;
  size_t __n;
  undefined1 uVar15;
  long lVar16;
  ulong uVar17;
  byte bVar18;
  int iVar19;
  uint uVar20;
  ulong uVar21;
  ulong uVar22;
  uint uVar23;
  ulong uVar24;
  uint uVar25;
  undefined1 *puVar26;
  long lVar27;
  undefined1 uVar28;
  void *__dest;
  undefined1 *puVar29;
  byte *pbVar30;
  ulong uVar31;
  undefined8 uVar32;
  byte local_110;
  undefined1 local_10f [7];
  ulong local_108;
  undefined1 *local_100;
  ulong local_f8;
  ulong local_f0;
  ulong local_e8;
  ulong local_e0;
  size_t local_d8;
  void *local_d0;
  byte local_c8 [8];
  ulong local_c0;
  byte *local_b8;
  byte local_b0 [16];
  undefined8 local_a0;
  byte local_98;
  byte local_97;
  ulong local_90;
  byte *local_88;
  ulong local_80;
  undefined8 local_78;
  ulong local_70;
  long local_68;
  
  lVar9 = tpidr_el0;
  local_68 = *(long *)(lVar9 + 0x28);
  FUN_0036aed4();
  FUN_0036b2a8(local_b0);
  local_80 = 0x766f66766c6b777a;
  lVar16 = 0;
  local_78 = 0x68777b6877717266;
  local_70 = CONCAT44(local_70._4_4_,0x747971);
  do {
    *(char *)((long)&local_80 + lVar16) = *(char *)((long)&local_80 + lVar16) + -3;
    lVar16 = lVar16 + 1;
  } while (lVar16 != 0x13);
  FUN_001238c4(local_c8,local_b0,&local_80);
  uVar21 = (ulong)(local_c8[0] >> 1);
  pbVar30 = (byte *)((ulong)local_c8 | 1);
  if ((local_c8[0] & 1) != 0) {
    uVar21 = local_c0;
    pbVar30 = local_b8;
  }
  puVar14 = (uint *)FUN_004780a8(0xc);
  puVar10 = PTR_DAT_00577ea0;
  lVar16 = *(long *)PTR_DAT_00577ea0;
  *(undefined8 *)puVar14 = DAT_00492888;
  puVar14[2] = 0x473b1fd4;
  lVar16 = (**(code **)(lVar16 + 0x160))(0x400);
  if (lVar16 == 0) {
    iVar19 = 0;
  }
  else {
    uVar17 = 0;
    do {
      iVar19 = 8;
      uVar31 = uVar17 & 0xffffffff;
      do {
        uVar24 = uVar31 >> 1;
        if ((uVar31 & 1) != 0) {
          uVar24 = (ulong)(*puVar14 ^ (uint)uVar24);
        }
        iVar19 = iVar19 + -1;
        uVar31 = uVar24;
      } while (iVar19 != 0);
      *(int *)(lVar16 + uVar17 * 4) = (int)uVar24;
      uVar17 = uVar17 + 1;
    } while (uVar17 != 0x100);
    if ((int)uVar21 < 1) {
      uVar23 = 0;
    }
    else {
      uVar21 = uVar21 & 0xffffffff;
      uVar23 = 0xffffffff;
      do {
        uVar21 = uVar21 - 1;
        uVar23 = (*(uint *)(lVar16 + (ulong)(uVar23 & 0xff ^ (uint)*pbVar30) * 4) ^ uVar23 >> 8) +
                 puVar14[1];
        pbVar30 = pbVar30 + 1;
      } while (uVar21 != 0);
      uVar23 = ~uVar23;
    }
    uVar20 = puVar14[2];
    (**(code **)(*(long *)puVar10 + 0x168))();
    iVar19 = uVar20 + uVar23;
  }
  FUN_00478110(puVar14);
  if (param_2 == 1) {
    iVar13 = (**(code **)(*param_1 + 0x18))(param_1,param_3);
  }
  else {
    iVar13 = (**(code **)(*param_1 + 0x20))(param_1,param_3);
  }
  local_80 = 0x65766972696b7378;
  lVar16 = 0;
  local_78 = CONCAT17(local_78._7_1_,0x7d696f656978);
  do {
    *(char *)((long)&local_80 + lVar16) = *(char *)((long)&local_80 + lVar16) + -4;
    lVar16 = lVar16 + 1;
  } while (lVar16 != 0xe);
  local_e0 = 0;
  local_d8 = 0;
  local_d0 = (void *)0x0;
  __n = strlen((char *)&local_80);
  if (0xffffffffffffffef < __n) {
                    /* WARNING: Subroutine does not return */
    FUN_0011ebc8(&local_e0);
  }
  if (__n < 0x17) {
    __dest = (void *)((ulong)&local_e0 | 1);
    local_e0 = CONCAT71(local_e0._1_7_,(char)(__n << 1));
    if (__n == 0) goto LAB_001783f4;
  }
  else {
    uVar21 = __n + 0x10 & 0xfffffffffffffff0;
    __dest = (void *)FUN_004780a8(uVar21);
    local_e0 = uVar21 | 1;
    local_d8 = __n;
    local_d0 = __dest;
  }
  memcpy(__dest,&local_80,__n);
LAB_001783f4:
  *(undefined1 *)((long)__dest + __n) = 0;
  FUN_0011eb1c(&local_110,&local_e0);
  local_80 = 0;
  local_78 = 0;
  local_70 = 0;
  FUN_0011ff98(&local_80,&DAT_00492890,0x100);
  puVar29 = (undefined1 *)((ulong)&local_110 | 1);
  bVar12 = (local_110 & 1) == 0;
  uVar21 = (ulong)(local_110 >> 1);
  if (!bVar12) {
    uVar21 = local_108;
  }
  local_f8 = 0;
  local_f0 = 0;
  local_e8 = 0;
  if (uVar21 != 0) {
    uVar21 = 0;
    bVar18 = 0x96;
    do {
      puVar26 = puVar29;
      if (!bVar12) {
        puVar26 = local_100;
      }
      bVar1 = (byte)puVar26[uVar21] >> 4 | puVar26[uVar21] << 4;
      FUN_00159f58(&local_f8,bVar1 ^ bVar18);
      uVar21 = uVar21 + 1;
      bVar12 = (local_110 & 1) == 0;
      uVar17 = (ulong)(local_110 >> 1);
      if (!bVar12) {
        uVar17 = local_108;
      }
      bVar18 = bVar1;
    } while (uVar21 < uVar17);
  }
  FUN_00130e04(&local_110,&local_f8);
  FUN_0011ff98(&local_f8,&DAT_004abd98,0);
  uVar17 = (ulong)&local_80 | 1;
  bVar12 = (local_110 & 1) == 0;
  uVar21 = (ulong)(local_110 >> 1);
  if (!bVar12) {
    uVar21 = local_108;
  }
  if (1 < uVar21) {
    uVar31 = 0;
    uVar23 = 1;
    do {
      puVar26 = local_100;
      if (bVar12) {
        puVar26 = local_10f;
      }
      puVar2 = puVar29;
      if (!bVar12) {
        puVar2 = local_100;
      }
      if ((ulong)(byte)puVar26[uVar23 - 1] == 0x5e) {
        uVar28 = 0;
      }
      else {
        uVar21 = uVar17;
        if ((local_80 & 1) != 0) {
          uVar21 = local_70;
        }
        uVar28 = *(undefined1 *)(uVar21 + (byte)puVar26[uVar23 - 1]);
      }
      if (puVar2[uVar23] == 0x5e) {
        uVar15 = 0;
      }
      else {
        uVar21 = uVar17;
        if ((local_80 & 1) != 0) {
          uVar21 = local_70;
        }
        uVar15 = *(undefined1 *)(uVar21 + (byte)puVar2[uVar23]);
      }
      FUN_00159f58(&local_f8,uVar15);
      FUN_00159f58(&local_f8,uVar28);
      uVar31 = uVar31 + 1;
      uVar23 = uVar23 + 2;
      bVar12 = (local_110 & 1) == 0;
      uVar21 = (ulong)(local_110 >> 1);
      if (!bVar12) {
        uVar21 = local_108;
      }
    } while (uVar31 < uVar21 >> 1);
  }
  if ((uVar21 & 1) != 0) {
    FUN_0011fe6c(&local_98,&local_110,uVar21 - 1,1,&local_110);
    if ((local_98 & 1) != 0) {
      bVar18 = *local_88;
      FUN_00478110();
      local_97 = bVar18;
    }
    if (local_97 == 0x5e) {
      uVar28 = 0;
    }
    else {
      if ((local_80 & 1) != 0) {
        uVar17 = local_70;
      }
      uVar28 = *(undefined1 *)(uVar17 + (uint)local_97);
    }
    FUN_00159f58(&local_f8,uVar28);
  }
  FUN_00130e04(&local_110,&local_f8);
  FUN_0011ff98(&local_f8,&DAT_004abd98,0);
  bVar12 = (local_110 & 1) == 0;
  uVar21 = (ulong)(local_110 >> 1);
  if (!bVar12) {
    uVar21 = local_108;
  }
  if (3 < uVar21) {
    uVar23 = 0;
    uVar17 = 0;
    uVar20 = iVar13 + iVar19;
    do {
      if (bVar12) {
        uVar28 = local_10f[uVar23];
        puVar26 = puVar29;
        uVar25 = (int)uVar17 << 2;
      }
      else {
        uVar28 = local_100[uVar23];
        puVar26 = local_100;
        uVar25 = uVar23;
      }
      puVar2 = puVar29;
      if (!bVar12) {
        puVar2 = local_100;
      }
      uVar25 = CONCAT13(puVar2[uVar25 | 3],
                        CONCAT12(puVar2[uVar25 | 2],CONCAT11(puVar26[uVar25 | 1],uVar28)));
      uVar20 = uVar25 ^ uVar20;
      FUN_00159f58(&local_f8,uVar20);
      FUN_00159f58(&local_f8,uVar20 >> 8);
      FUN_00159f58(&local_f8,uVar20 >> 0x10);
      FUN_00159f58(&local_f8,uVar20 >> 0x18);
      uVar17 = uVar17 + 1;
      uVar23 = uVar23 + 4;
      bVar12 = (local_110 & 1) == 0;
      uVar21 = (ulong)(local_110 >> 1);
      if (!bVar12) {
        uVar21 = local_108;
      }
      uVar20 = uVar25;
    } while (uVar17 < uVar21 >> 2);
  }
  if ((uVar21 & 3) != 0) {
    FUN_0011fe6c(&local_98,&local_110,uVar21 & 0xfffffffffffffffc,uVar21 & 3,&local_110);
    uVar21 = (ulong)(local_98 >> 1);
    pbVar30 = (byte *)((ulong)&local_98 | 1);
    if ((local_98 & 1) != 0) {
      uVar21 = local_90;
      pbVar30 = local_88;
    }
    FUN_001239d0(&local_f8,pbVar30,uVar21);
    if ((local_98 & 1) != 0) {
      FUN_00478110(local_88);
    }
  }
  if ((local_80 & 1) != 0) {
    FUN_00478110(local_70);
  }
  if ((local_110 & 1) != 0) {
    FUN_00478110(local_100);
  }
  uVar21 = (ulong)&local_f8 | 1;
  if ((local_f8 & 1) != 0) {
    uVar21 = local_e8;
  }
  lVar16 = 0;
  do {
    (&DAT_0057c970)[lVar16] = (&DAT_00492994)[lVar16];
    lVar16 = lVar16 + 1;
  } while (lVar16 != 0x48);
  uVar17 = local_f8 >> 1 & 0x7f;
  if ((local_f8 & 1) != 0) {
    uVar17 = local_f0;
  }
  lVar16 = 0;
  do {
    uVar32 = *(undefined8 *)(&DAT_004929dc + lVar16);
    *(undefined8 *)(lVar16 + 0x57c9c0) = *(undefined8 *)(&UNK_004929e4 + lVar16);
    *(undefined8 *)((long)&DAT_0057c9b8 + lVar16) = uVar32;
    lVar16 = lVar16 + 0x10;
  } while (lVar16 != 0x1000);
  lVar16 = 0;
  do {
    *(uint *)(&DAT_0057c970 + lVar16) = *(uint *)(&DAT_0057c970 + lVar16) ^ 0x78089553;
    lVar16 = lVar16 + 4;
  } while (lVar16 != 0x48);
  uVar31 = 4;
  uVar24 = uVar17;
  do {
    uVar22 = uVar31;
    uVar31 = 0;
    if (uVar22 != 0) {
      uVar31 = uVar24 / uVar22;
    }
    uVar31 = uVar24 - uVar31 * uVar22;
    uVar24 = uVar22;
  } while (uVar31 != 0);
  uVar31 = 0;
  if (uVar22 != 0) {
    uVar31 = uVar17 / uVar22;
  }
  auVar8._8_8_ = 0;
  auVar8._0_8_ = uVar31;
  lVar16 = uVar31 << 2;
  if (SUB168(auVar8 * ZEXT816(4),8) != 0) {
    lVar16 = -1;
  }
  lVar16 = thunk_FUN_004780a8(lVar16);
  if (uVar22 <= uVar17) {
    uVar24 = 0;
    uVar22 = 3;
    do {
      uVar4 = 0;
      if (uVar17 != 0) {
        uVar4 = (uVar22 - 3) / uVar17;
      }
      uVar5 = 0;
      if (uVar17 != 0) {
        uVar5 = (uVar22 - 2) / uVar17;
      }
      uVar6 = 0;
      if (uVar17 != 0) {
        uVar6 = (uVar22 - 1) / uVar17;
      }
      uVar7 = 0;
      if (uVar17 != 0) {
        uVar7 = uVar22 / uVar17;
      }
      *(uint *)(lVar16 + uVar24 * 4) =
           (uint)*(byte *)(uVar21 + ((uVar22 - 3) - uVar4 * uVar17)) << 0x18 |
           (uint)*(byte *)(uVar21 + ((uVar22 - 2) - uVar5 * uVar17)) << 0x10 |
           (uint)*(byte *)(uVar21 + ((uVar22 - 1) - uVar6 * uVar17)) << 8 |
           (uint)*(byte *)(uVar21 + (uVar22 - uVar7 * uVar17));
      uVar24 = uVar24 + 1;
      uVar22 = uVar22 + 4;
    } while (uVar24 < uVar31);
  }
  uVar21 = 0;
  do {
    uVar17 = 0;
    if (uVar31 != 0) {
      uVar17 = uVar21 / uVar31;
    }
    *(uint *)(&DAT_0057c970 + uVar21 * 4) =
         *(uint *)(&DAT_0057c970 + uVar21 * 4) ^ *(uint *)(lVar16 + (uVar21 - uVar17 * uVar31) * 4);
    uVar21 = uVar21 + 1;
  } while (uVar21 != 0x12);
  thunk_FUN_00478110();
  lVar16 = 0;
  uVar23 = 0;
  uVar20 = 0;
  do {
    lVar27 = 0;
    do {
      puVar14 = (uint *)(&DAT_0057c970 + lVar27);
      lVar27 = lVar27 + 4;
      uVar25 = *puVar14 ^ uVar20;
      uVar20 = (*(int *)(&DAT_0057cdb8 + (ulong)(uVar25 >> 0x10 & 0xff) * 4) +
                (&DAT_0057c9b8)[uVar25 >> 0x18] ^
               *(uint *)(&DAT_0057d1b8 + (ulong)(uVar25 >> 8 & 0xff) * 4)) +
               *(int *)(&DAT_0057d5b8 + (ulong)(uVar25 & 0xff) * 4) ^ uVar23;
      uVar23 = uVar25;
    } while (lVar27 != 0x40);
    lVar27 = lVar16 * 8;
    uVar21 = lVar16 << 3;
    lVar16 = lVar16 + 1;
    uVar23 = DAT_0057c9b0 ^ uVar20;
    uVar20 = DAT_0057c9b4 ^ uVar25;
    *(uint *)(&DAT_0057c970 + lVar27) = uVar20;
    *(uint *)(&DAT_0057c970 + (uVar21 | 4)) = uVar23;
    uVar11 = DAT_0057c9b4;
    uVar25 = DAT_0057c9b0;
  } while (lVar16 != 9);
  lVar16 = 0;
  do {
    lVar27 = 0;
    do {
      puVar14 = (uint *)(&DAT_0057c970 + lVar27);
      lVar27 = lVar27 + 4;
      uVar3 = *puVar14 ^ uVar20;
      uVar20 = (*(int *)(&DAT_0057cdb8 + (ulong)(uVar3 >> 0x10 & 0xff) * 4) +
                (&DAT_0057c9b8)[uVar3 >> 0x18] ^
               *(uint *)(&DAT_0057d1b8 + (ulong)(uVar3 >> 8 & 0xff) * 4)) +
               *(int *)(&DAT_0057d5b8 + (ulong)(uVar3 & 0xff) * 4) ^ uVar23;
      uVar23 = uVar3;
    } while (lVar27 != 0x40);
    uVar23 = uVar20 ^ uVar25;
    uVar20 = uVar3 ^ uVar11;
    lVar27 = lVar16 + 1;
    (&DAT_0057c9b8)[lVar16 * 2] = uVar20;
    *(uint *)((long)&DAT_0057c9b8 + (lVar16 << 3 | 4U)) = uVar23;
    lVar16 = lVar27;
  } while (lVar27 != 0x200);
  if ((local_f8 & 1) != 0) {
    FUN_00478110(local_e8);
  }
  if ((local_e0 & 1) != 0) {
    FUN_00478110(local_d0);
  }
  if ((local_c8[0] & 1) != 0) {
    FUN_00478110(local_b8);
  }
  if ((local_b0[0] & 1) != 0) {
    FUN_00478110(local_a0);
  }
  if (*(long *)(lVar9 + 0x28) == local_68) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}

