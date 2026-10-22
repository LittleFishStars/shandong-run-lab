
/* WARNING: Removing unreachable block (ram,0x00083be4) */
/* WARNING: Removing unreachable block (ram,0x000842cc) */
/* WARNING: Type propagation algorithm not settling */
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_00083560(void)

{
  uint uVar1;
  undefined8 uVar2;
  undefined1 *puVar3;
  char cVar4;
  bool bVar5;
  undefined1 in_ZR;
  bool bVar6;
  undefined1 uVar7;
  int iVar8;
  int iVar9;
  int iVar10;
  int iVar11;
  int iVar12;
  long lVar13;
  undefined8 *puVar14;
  ulong uVar15;
  long *******ppppppplVar16;
  code *pcVar17;
  long lVar18;
  long *******ppppppplVar19;
  undefined8 uVar20;
  long *plVar21;
  long lVar22;
  ulong uVar23;
  long ******pppppplVar24;
  undefined4 extraout_w8;
  long extraout_x8;
  long *******extraout_x8_00;
  undefined8 extraout_x8_01;
  long *******ppppppplVar25;
  undefined8 extraout_x8_02;
  long extraout_x8_03;
  undefined8 extraout_x9;
  undefined8 extraout_x9_00;
  ulong extraout_x9_01;
  long extraout_x9_02;
  undefined8 extraout_x10;
  ulong extraout_x11;
  ulong extraout_x11_00;
  ulong extraout_x11_01;
  ulong extraout_x12;
  undefined8 extraout_x12_00;
  undefined8 extraout_x12_01;
  ulong uVar26;
  long lVar27;
  uint uVar28;
  code *pcVar29;
  long *******ppppppplVar30;
  long unaff_x27;
  ulong uVar31;
  undefined1 auVar32 [16];
  undefined1 auStack_620 [24];
  undefined1 auStack_608 [24];
  undefined8 local_5f0 [3];
  int local_5d8 [6];
  byte local_5c0 [16];
  ulong local_5b0;
  long local_5a8 [3];
  long *******local_590 [3];
  ulong local_578 [3];
  long local_560;
  long local_558;
  undefined8 local_550;
  undefined8 uStack_548;
  long *******local_540;
  long *******local_538;
  long local_530;
  undefined8 *local_528;
  undefined8 local_520;
  undefined8 local_518;
  int local_510;
  code *local_508;
  long *******local_500;
  undefined1 *local_4f8;
  undefined1 *puStack_4f0;
  undefined1 *local_4e8;
  code *local_4e0;
  undefined *local_4d8;
  undefined8 local_4d0;
  undefined8 local_4c0;
  undefined8 uStack_4b8;
  undefined4 local_4b0;
  long local_4a8;
  long *******local_4a0;
  undefined8 local_498;
  long local_490;
  long *******local_470;
  long *******local_468;
  long *******local_460 [11];
  undefined1 local_405;
  undefined8 local_3c8;
  undefined4 local_3c0;
  undefined4 local_3bc;
  long *******local_108;
  long *******local_100;
  undefined8 local_f8;
  long *******local_f0;
  long ******local_e8;
  ulong local_e0;
  undefined8 local_c8;
  ulong local_b8;
  long local_68;
  
  FUN_000cff2c();
  FUN_000d1d30();
  local_68 = extraout_x8;
  if (DAT_000e8464 != '\0') {
    FUN_000d7000();
  }
  local_550 = 0;
  uStack_548 = 0;
  local_520 = 0;
  local_518 = 0;
  local_538 = (long *******)0x0;
  local_530 = 0;
  local_560 = _DAT_000e8a38;
  local_558 = 0;
  local_540 = (long *******)&local_538;
  local_528 = &local_520;
  FUN_00084efc(0);
  local_538 = (long *******)0x0;
  local_530 = 0;
  local_540 = (long *******)&local_538;
  FUN_00084efc(local_520);
  local_520 = 0;
  local_518 = 0;
  local_528 = &local_520;
  FUN_00084ec4(&local_558);
  FUN_000d3324(local_5c0);
  local_510 = 0;
  FUN_000ae94c();
  FUN_000a9a08();
  lVar13 = FUN_000d04c4();
  FUN_000d6ff8(lVar13,&DAT_0001a84e);
  FUN_000d1b28(local_5c0,&local_508);
  if ((bool)in_ZR) {
    cVar4 = *(char *)(lVar13 + 0xd3);
    uVar20 = FUN_000d0cc4();
    if (cVar4 == '\0') {
      FUN_000d6ff8(uVar20,&DAT_0001a857);
      lVar18 = FUN_00080e24(local_5c0,&local_508);
      if (lVar18 == 0) goto LAB_00083610;
      FUN_00084f28(&local_f0,&DAT_0001a861);
      lVar18 = FUN_00080e24(local_5c0,&local_f0);
      if (lVar18 != 0) {
        FUN_00084f28(&local_108,&DAT_0001a868);
        lVar18 = FUN_00080e24(local_5c0,&local_108);
        if (lVar18 != 0) {
          FUN_00084f28(local_578,&DAT_0001a871);
          lVar18 = FUN_00080e24(local_5c0,local_578);
          if (lVar18 != 0) {
            FUN_00084f28(local_590,&DAT_0001a877);
            lVar18 = FUN_00080e24(local_5c0,local_590);
            if (lVar18 != 0) {
              FUN_00084f28(local_5a8,&DAT_0001a881);
              lVar18 = FUN_00080e24(local_5c0,local_5a8);
              if (lVar18 == 0) {
                bVar6 = false;
              }
              else {
                FUN_00084f28(local_5d8,&DAT_0001a88b);
                FUN_000d6468();
                lVar18 = FUN_00080e24();
                if (lVar18 == 0) {
                  bVar6 = false;
                }
                else {
                  FUN_00084f28(local_5f0,&DAT_0001a894);
                  lVar18 = FUN_00080e24(local_5c0,local_5f0);
                  if (lVar18 == 0) {
                    bVar6 = false;
                  }
                  else {
                    FUN_00084f28(auStack_608,&DAT_0001a8a1);
                    lVar18 = FUN_00080e24(local_5c0,auStack_608);
                    if (lVar18 == 0) {
                      bVar6 = false;
                    }
                    else {
                      FUN_00084f28(auStack_620,&DAT_0001a8aa);
                      lVar18 = FUN_00080e24(local_5c0,auStack_620);
                      in_ZR = lVar18 == 0;
                      bVar6 = !(bool)in_ZR;
                      FUN_0004e170(auStack_620);
                    }
                    FUN_000d0124();
                  }
                  FUN_000d00b8();
                }
                FUN_000d0774();
              }
              FUN_000cffb8();
              FUN_000cfee0();
              FUN_000d0e90();
              FUN_0004e170(&local_108);
              FUN_000d6fdc();
              FUN_0004e170(&local_508);
              if (!bVar6) goto LAB_00083624;
              FUN_000d5e4c();
              FUN_0006e06c();
              FUN_000d3324(&local_f0);
              uVar20 = FUN_000af6e0();
              local_108 = (long *******)&local_100;
              local_f8 = 0;
              local_100 = (long *******)0x0;
              FUN_000d6ff8(uVar20,&DAT_0001a90e);
              lVar18 = FUN_000d57cc((ulong)local_508 & 0xff);
              FUN_000d0cc4();
              if (lVar18 == 0) {
LAB_000848a4:
                in_ZR = (int)local_f8 == 1;
                if (0 < (int)local_f8) {
                  FUN_0004ec04(local_5d8,local_108 + 4);
                }
              }
              else {
                FUN_000d2088(&local_508);
                FUN_000d87d0();
                bVar6 = false;
                do {
                  lVar27 = FUN_000d2518(_DAT_000e8a38,&local_508,0x3ff,lVar18);
                  if ((bVar6) || (lVar27 == 0)) break;
                  iVar11 = FUN_000d0cd4(local_560,&local_508);
                  if (iVar11 < 1) {
LAB_00084884:
                    iVar11 = 0;
                  }
                  else {
                    iVar12 = iVar11;
                    if (*(char *)((long)&local_508 + (ulong)(iVar11 - 1)) == '\n') {
                      *(undefined1 *)((long)&local_508 + (ulong)(iVar11 - 1)) = 0;
                      if (iVar11 < 2) goto LAB_00084884;
                      iVar12 = iVar11 + -1;
                      if (*(char *)((long)&local_508 + (ulong)(iVar11 - 2)) == '\r') {
                        *(undefined1 *)((long)&local_508 + (ulong)(iVar11 - 2)) = 0;
                        iVar12 = iVar11 + -2;
                      }
                    }
                    if ((((iVar12 < 5) || (*(char *)((long)&local_508 + (ulong)(iVar12 - 1)) != 'k')
                         ) || (*(char *)((long)&local_508 + (ulong)(iVar12 - 2)) != 'p')) ||
                       ((*(char *)((long)&local_508 + (ulong)(iVar12 - 3)) != 'a' ||
                        (*(char *)((long)&local_508 + (ulong)(iVar12 - 4)) != '.'))))
                    goto LAB_00084884;
                    pcVar29 = *(code **)(local_560 + 0xa0);
                    FUN_00084f28(local_578,&DAT_0001a868);
                    FUN_000d6eb8();
                    FUN_000d1b80(&local_508);
                    lVar27 = (*pcVar29)();
                    FUN_000d0e90();
                    if (lVar27 == 0) {
                      FUN_000d2f88(local_578);
                      iVar11 = FUN_000d178c(local_578,&DAT_00013168);
                      if (iVar11 == -1) {
LAB_00084874:
                        iVar11 = 0;
                      }
                      else {
                        FUN_000715fc(local_590,local_578,(long)iVar11,(long)(iVar12 - iVar11));
                        uVar15 = (ulong)&local_f0 | 1;
                        if (((ulong)local_f0 & 1) != 0) {
                          uVar15 = local_e0;
                        }
                        lVar27 = (**(code **)(local_560 + 0xa0))(&local_508,uVar15);
                        if (lVar27 == 0) {
LAB_00084868:
                          iVar11 = 0;
                          bVar5 = true;
                        }
                        else {
                          pcVar29 = *(code **)(local_560 + 0xa0);
                          FUN_00084f28(local_5a8,&DAT_0001a857);
                          FUN_000d0108();
                          FUN_000d65d8(&local_508);
                          lVar27 = (*pcVar29)();
                          FUN_000cffb8();
                          if (lVar27 == 0) {
                            FUN_00085bac(&local_108,local_590);
                            goto LAB_00084868;
                          }
                          FUN_000d7928(local_5d8);
                          bVar5 = false;
                          bVar6 = true;
                          iVar11 = 3;
                        }
                        FUN_000cfee0();
                        if (bVar5) goto LAB_00084874;
                      }
                      FUN_000d0e90();
                      if (iVar11 == 0) goto LAB_00084884;
                    }
                    else {
                      iVar11 = 2;
                    }
                  }
                  in_ZR = iVar11 == 3;
                } while (!(bool)in_ZR);
                FUN_000d12d4(_DAT_000e8a38,lVar18);
                if (!bVar6) goto LAB_000848a4;
              }
              FUN_000d5e4c();
              uVar15 = FUN_00085c08();
              if ((uVar15 & 1) != 0) {
                FUN_000d35f0(*(undefined8 *)(_DAT_000e8a38 + 0xf8));
              }
              FUN_000708e0(local_100);
              FUN_000d6fdc();
              FUN_000d6468();
              FUN_00070ad0();
              FUN_000d0774();
              goto LAB_00083624;
            }
            FUN_000cfee0();
          }
          FUN_000d0e90();
        }
        FUN_0004e170(&local_108);
      }
      FUN_000d6fdc();
      goto LAB_00083610;
    }
  }
  else {
LAB_00083610:
    FUN_000d0cc4();
  }
LAB_00083624:
  local_5f0[0] = 0xe1ae8;
  puVar14 = (undefined8 *)FUN_000891fc();
  uVar15 = FUN_000b4cf8(local_5f0,local_5c0,*puVar14);
  if ((uVar15 & 1) != 0) {
    local_f0 = DAT_0001a8b0;
    local_e8 = (long ******)CONCAT44(local_e8._4_4_,DAT_0001a8b8);
    FUN_00073578(&local_f0,&local_108);
    FUN_000d5b8c();
    FUN_000d42f8((ulong)local_508 & 0xff);
    uVar15 = (ulong)local_5c0 | 1;
    uVar20 = extraout_x10;
    if (!(bool)in_ZR) {
      uVar20 = extraout_x9;
    }
    if ((extraout_x11 & 1) != 0) {
      uVar15 = extraout_x12;
    }
    FUN_000cfe20(uVar20,uVar15);
    FUN_000d0cc4();
    bVar6 = false;
    goto LAB_00084434;
  }
  if (*(char *)(lVar13 + 0xf4) != '\0') {
    uVar15 = (ulong)local_5c0 | 1;
    if ((local_5c0[0] & 1) != 0) {
      uVar15 = local_5b0;
    }
    lVar13 = FUN_000d6bc4(uVar15,0);
    bVar6 = false;
    if (lVar13 != 0) {
      local_508 = Reset;
      uVar15 = FUN_000b8b3c(lVar13,s_assets_nedig_properties_000153de);
      if ((uVar15 & 1) != 0) {
        FUN_000b8d80(lVar13,s_assets_nedig_properties_000153de,&local_508);
        pcVar29 = local_508;
        FUN_000d2970();
        FUN_00085548();
        if (pcVar29 != Reset) {
          uVar15 = FUN_00084f60(&local_560,pcVar29);
          puVar14 = local_528;
          if ((uVar15 & 1) == 0) {
            bVar6 = false;
          }
          else {
            local_e0 = 0;
            local_e8 = (long ******)0x0;
            local_f0 = &local_e8;
            while (ppppppplVar16 = local_f0, puVar14 != &local_520) {
              ppppppplVar16 = &local_e8;
              if (local_f0 == &local_e8) {
LAB_00083794:
                local_108 = &local_e8;
                if (local_e8 != (long ******)0x0) {
                  local_108 = ppppppplVar16;
                  ppppppplVar16 = ppppppplVar16 + 1;
                  goto LAB_000837a4;
                }
LAB_000837c0:
                pcVar17 = (code *)FUN_000d10c8();
                local_508 = pcVar17;
                local_500 = &local_e8;
                FUN_000d331c(pcVar17 + 0x20);
                FUN_000d5724(*(undefined4 *)(puVar14 + 7),&local_f0);
                local_4f8 = (undefined1 *)CONCAT71(local_4f8._1_7_,1);
                *(undefined4 *)(pcVar17 + 0x38) = extraout_w8;
                FUN_0008557c();
                local_508 = Reset;
                FUN_0008559c(&local_508);
              }
              else {
                ppppppplVar16 = (long *******)FUN_000855c8(&local_e8);
                uVar15 = FUN_00070db4(ppppppplVar16 + 4,puVar14 + 4);
                if ((uVar15 & 1) != 0) goto LAB_00083794;
                ppppppplVar16 = (long *******)FUN_000855f8(&local_f0,&local_108,puVar14 + 4);
LAB_000837a4:
                if (*ppppppplVar16 == (long ******)0x0) goto LAB_000837c0;
              }
              FUN_000d6c5c();
            }
            while (ppppppplVar16 != &local_e8) {
              if (*(int *)(ppppppplVar16 + 7) != 0) {
                if (((ulong)ppppppplVar16[4] & 1) == 0) {
                  pppppplVar24 = (long ******)((long)ppppppplVar16 + 0x21);
                }
                else {
                  pppppplVar24 = ppppppplVar16[6];
                }
                iVar11 = FUN_000b8b6c(lVar13,pppppplVar24,&local_508);
                if ((iVar11 != 0) || (*(int *)(ppppppplVar16 + 7) != (int)local_4f8)) {
                  bVar6 = false;
                  goto LAB_000842e4;
                }
              }
              FUN_000d6c5c();
            }
            bVar6 = true;
LAB_000842e4:
            FUN_00084efc(local_e8);
          }
          FUN_000d16b4(_DAT_000e8a38,pcVar29);
          goto LAB_00084434;
        }
      }
      bVar6 = false;
    }
    goto LAB_00084434;
  }
  local_508 = FUN_000b8258;
  local_500 = (long *******)FUN_000b82b4;
  local_4e8 = &LAB_000b82ec;
  local_4e0 = FUN_000b831c;
  uVar7 = (local_5c0[0] & 1) == 0;
  uVar15 = (ulong)local_5c0 | 1;
  if (!(bool)uVar7) {
    uVar15 = local_5b0;
  }
  local_4c0 = 0;
  uStack_4b8 = 0;
  local_4f8 = &LAB_000b82cc;
  puStack_4f0 = &LAB_000b82e4;
  local_4d8 = &DAT_000b8324;
  local_4d0 = 0;
  local_4b0 = 1;
  lVar13 = FUN_000b8258(0,uVar15,5);
  local_4a8 = lVar13;
  if (lVar13 != 0) {
    lVar18 = FUN_000b8208(&local_508,lVar13,0,2);
    ppppppplVar16 = (long *******)0x0;
    if (lVar18 == 0) {
      uVar23 = FUN_000b821c(&local_508,lVar13);
      uVar15 = uVar23;
      if (0xfffe < uVar23) {
        uVar15 = 0xffff;
      }
      auVar32 = FUN_000d8780(0x404);
      if (auVar32._0_8_ != 0) {
        lVar18 = auVar32._0_8_ + -2;
        uVar31 = 4;
        do {
          if (uVar15 <= uVar31) {
LAB_000841a4:
            lVar27 = 0;
LAB_000841a8:
            FUN_000d2e3c();
            if (lVar27 == 0) {
              ppppppplVar16 = (long *******)0x0;
            }
            else {
              FUN_000d48b4(&local_508);
              lVar18 = FUN_000b8208();
              if ((lVar18 == 0) && (iVar11 = FUN_000d2634(), iVar11 == 0)) {
                iVar11 = FUN_000d2634();
                ppppppplVar16 = (long *******)0x0;
                if ((iVar11 == 0) && (local_f0 == (long *******)0x0)) {
                  iVar11 = FUN_000b7b78(&local_508,lVar13,&local_108);
                  if (iVar11 != 0) goto LAB_000841d8;
                  iVar11 = FUN_000d2634();
                  ppppppplVar19 = local_108;
                  ppppppplVar16 = (long *******)0x0;
                  if ((iVar11 == 0) && (local_f0 == (long *******)0x1)) {
                    lVar13 = FUN_000b8208(&local_508,lVar13,local_108,0);
                    if (lVar13 != 0) goto LAB_000841d8;
                    iVar11 = FUN_000d2634();
                    ppppppplVar16 = ppppppplVar19;
                    if (local_f0 != (long *******)0x6064b50 || iVar11 != 0) {
                      ppppppplVar16 = (long *******)0x0;
                    }
                  }
                }
              }
              else {
LAB_000841d8:
                ppppppplVar16 = (long *******)0x0;
              }
            }
            goto LAB_000838a4;
          }
          uVar26 = uVar31 + 0x400;
          bVar6 = uVar15 <= uVar26;
          uVar31 = uVar15;
          if (uVar26 <= uVar15) {
            uVar31 = uVar26;
          }
          FUN_000d6efc(auVar32._0_8_,auVar32._8_8_,uVar23 - uVar31);
          uVar26 = uVar31;
          if (bVar6) {
            uVar26 = 0x404;
          }
          lVar27 = FUN_000b8208();
          if (lVar27 != 0) goto LAB_000841a4;
          FUN_000d48d4(local_500,local_4d0);
          auVar32 = FUN_000d6540();
          if (auVar32._0_8_ != uVar26) goto LAB_000841a4;
          for (; 0 < (long)(uVar26 - 3); uVar26 = uVar26 - 1) {
            if ((((*(char *)(lVar18 + uVar26 + -2) == 'P') &&
                 (*(char *)(lVar18 + uVar26 + -1) == 'K')) && (*(char *)(lVar18 + uVar26) == '\x06')
                ) && (*(char *)(lVar18 + uVar26 + 1) == '\a')) {
              lVar27 = ((uVar23 - 4) - uVar31) + uVar26;
              if (lVar27 != 0) goto LAB_000841a8;
              break;
            }
          }
        } while( true );
      }
      ppppppplVar16 = (long *******)0x0;
    }
LAB_000838a4:
    lVar13 = local_4a8;
    if (ppppppplVar16 == (long *******)0x0) {
      lVar18 = FUN_000b8208(&local_508,local_4a8,0,2);
      if (lVar18 == 0) {
        uVar23 = FUN_000b821c(&local_508,lVar13);
        uVar15 = uVar23;
        if (0xfffe < uVar23) {
          uVar15 = 0xffff;
        }
        auVar32 = FUN_000d8780(0x404);
        lVar18 = auVar32._0_8_;
        if (lVar18 != 0) {
          lVar27 = lVar18 + -2;
          uVar31 = 4;
          do {
            if (uVar15 <= uVar31) {
LAB_00084388:
              ppppppplVar16 = (long *******)0x0;
LAB_0008438c:
              FUN_000d22a8();
              if (ppppppplVar16 == (long *******)0x0) break;
              iVar11 = 0;
              goto LAB_00083c1c;
            }
            uVar26 = uVar31 + 0x400;
            bVar6 = uVar15 <= uVar26;
            uVar31 = uVar15;
            if (uVar26 <= uVar15) {
              uVar31 = uVar26;
            }
            FUN_000d6efc(auVar32._0_8_,auVar32._8_8_,uVar23 - uVar31);
            uVar26 = uVar31;
            if (bVar6) {
              uVar26 = 0x404;
            }
            lVar22 = FUN_000b8208();
            if ((lVar22 != 0) ||
               (auVar32 = (*(code *)local_500)(local_4d0,lVar13,lVar18,uVar26),
               auVar32._0_8_ != uVar26)) goto LAB_00084388;
            for (; 0 < (long)(uVar26 - 3); uVar26 = uVar26 - 1) {
              if ((((*(char *)(lVar27 + uVar26 + -2) == 'P') &&
                   (*(char *)(lVar27 + uVar26 + -1) == 'K')) &&
                  (*(char *)(lVar27 + uVar26) == '\x05')) &&
                 (*(char *)(lVar27 + uVar26 + 1) == '\x06')) {
                ppppppplVar16 = (long *******)(((uVar23 - 4) - uVar31) + uVar26);
                if (ppppppplVar16 != (long *******)0x0) goto LAB_0008438c;
                break;
              }
            }
          } while( true );
        }
      }
      ppppppplVar16 = (long *******)0x0;
      iVar11 = -1;
LAB_00083c1c:
      local_3bc = 0;
      lVar13 = FUN_000b8208(&local_508,local_4a8,ppppppplVar16,0);
      iVar12 = FUN_000b7adc(&local_508,local_4a8,&local_f0);
      iVar8 = FUN_000b7c44(&local_508,local_4a8,&local_108);
      FUN_000b7c44(&local_508,local_4a8,local_578);
      FUN_000d6fbc();
      FUN_000b7c44();
      FUN_000d6fbc(local_f0);
      local_4a0 = extraout_x8_00;
      iVar9 = FUN_000b7c44();
      if (((iVar8 != 0 || iVar12 != 0) || iVar9 != 0) || lVar13 != 0) {
        iVar11 = -1;
      }
      local_590[0] = local_f0;
      iVar12 = -0x67;
      if ((local_108 == (long *******)0x0 && local_578[0] == 0) && local_f0 == local_4a0) {
        iVar12 = iVar11;
      }
      iVar11 = FUN_000b7adc(&local_508,local_4a8,&local_f0);
      local_468 = local_f0;
      iVar8 = FUN_000b7adc(&local_508,local_4a8,&local_f0);
      local_460[0] = local_f0;
      iVar9 = FUN_000b7c44(&local_508,local_4a8,&local_498);
      uVar7 = (iVar8 == 0 && iVar11 == 0) && iVar9 == 0;
      if ((iVar8 != 0 || iVar11 != 0) || iVar9 != 0) {
        iVar12 = -1;
      }
    }
    else {
      local_3bc = 1;
      lVar13 = FUN_000b8208(&local_508,local_4a8,ppppppplVar16,0);
      iVar11 = FUN_000b7adc(&local_508,local_4a8,&local_f0);
      iVar8 = FUN_000b7b78(&local_508,local_4a8,local_5d8);
      FUN_000b7c44(&local_508,local_4a8,local_5a8);
      auVar32 = FUN_000d41f4();
      FUN_000b7c44(auVar32._0_8_,auVar32._8_8_,local_5a8);
      auVar32 = FUN_000d41f4();
      FUN_000b7adc(auVar32._0_8_,auVar32._8_8_,&local_108);
      auVar32 = FUN_000d41f4();
      iVar9 = FUN_000b7adc(auVar32._0_8_,auVar32._8_8_,local_578);
      FUN_000b7b78(&local_508,local_4a8,&local_4a0);
      auVar32 = FUN_000d41f4();
      iVar10 = FUN_000b7b78(auVar32._0_8_,auVar32._8_8_,local_590);
      iVar12 = -0x67;
      if ((local_108 == (long *******)0x0 && local_578[0] == 0) && local_590[0] == local_4a0) {
        iVar12 = -(uint)(lVar13 != 0 || (((iVar8 != 0 || iVar11 != 0) || iVar9 != 0) || iVar10 != 0)
                        );
      }
      iVar11 = FUN_000b7b78(&local_508,local_4a8,&local_468);
      iVar8 = FUN_000b7b78(&local_508,local_4a8,local_460);
      uVar7 = iVar8 == 0 && iVar11 == 0;
      if (iVar8 != 0 || iVar11 != 0) {
        iVar12 = -1;
      }
      local_498 = 0;
    }
    if (iVar12 == 0) {
      lVar13 = (long)ppppppplVar16 - ((long)local_468 + (long)local_460[0]);
      uVar7 = lVar13 == 0;
      if ((long *******)((long)local_468 + (long)local_460[0]) <= ppppppplVar16) {
        local_3c8 = 0;
        local_3c0 = 0;
        local_490 = lVar13;
        local_470 = ppppppplVar16;
        lVar13 = FUN_000d8780(0x150);
        if (lVar13 == 0) goto LAB_00083da8;
        FUN_000d8760(lVar13,&local_508,0x150);
        FUN_000d85c4();
        if (local_530 != 0) {
LAB_00083d6c:
          FUN_000d87d0(&local_508,0,0x104);
          iVar11 = FUN_000d85c4();
          if (iVar11 == 0) {
            while (iVar11 = FUN_000b8168(lVar13,&local_f0,&local_508,0x104), iVar11 == 0) {
              local_405 = 0;
              iVar11 = FUN_000d0cd4(local_560,&local_508);
              uVar7 = iVar11 == 0x17;
              if ((0x16 < iVar11) &&
                 (iVar11 = (**(code **)(local_560 + 0x90))(&local_508,s_assets_00013c3e,6),
                 iVar11 == 0)) {
                pcVar29 = *(code **)(local_560 + 0x90);
                (**(code **)(_DAT_000e8a38 + 0x98))(s_nedig_properties_00014714);
                auVar32 = FUN_000d0cd4(_DAT_000e8a38,s_nedig_properties_00014714);
                FUN_000d2260(auVar32._0_8_,auVar32._8_8_,auVar32._0_8_);
                uVar20 = (*pcVar29)();
                if ((int)uVar20 == 0) {
                  if (*(long *)(lVar13 + 0x90) != 0) {
                    if (*(long *)(lVar13 + 0x140) != 0) {
                      uVar20 = FUN_000d8518();
                    }
                    auVar32 = FUN_000d8520(*(undefined8 *)(lVar13 + 0x138),uVar20,
                                           *(undefined8 *)(lVar13 + 0x60));
                    lVar18 = FUN_000b8208(auVar32._0_8_,auVar32._8_8_,
                                          extraout_x9_02 + extraout_x8_03);
                    if (lVar18 == 0) {
                      iVar12 = FUN_000b7adc(lVar13,*(undefined8 *)(lVar13 + 0x60),&local_108);
                      iVar11 = 0;
                      if (local_108 != (long *******)0x4034b50) {
                        iVar11 = -0x67;
                      }
                      uVar20 = FUN_000b7c44(lVar13,*(undefined8 *)(lVar13 + 0x60),local_578);
                      iVar8 = FUN_000d8548(uVar20,*(undefined8 *)(lVar13 + 0x60),local_590);
                      if (((int)uVar20 != 0 || iVar12 != 0) || iVar8 != 0) {
                        iVar11 = -1;
                      }
                      iVar12 = FUN_000b7c44(lVar13,*(undefined8 *)(lVar13 + 0x60),local_578);
                      if (iVar12 == 0) {
                        if (iVar11 == 0) {
                          if (local_578[0] == *(ulong *)(lVar13 + 200)) {
                            if ((local_578[0] < 0xd) &&
                               ((1L << (local_578[0] & 0x3f) & 0x1101U) != 0)) {
                              iVar11 = 0;
                            }
                            else {
                              iVar11 = -0x67;
                            }
                          }
                          else {
                            iVar11 = -0x67;
                          }
                        }
                      }
                      else {
                        iVar11 = -1;
                      }
                      iVar12 = FUN_000d355c();
                      if (iVar12 != 0) {
                        iVar11 = -1;
                      }
                      iVar12 = FUN_000b7adc(lVar13,*(undefined8 *)(lVar13 + 0x60),local_578);
                      if (iVar12 == 0) {
                        if (iVar11 == 0) {
                          if (local_578[0] == *(ulong *)(lVar13 + 0xd8)) {
                            iVar11 = 0;
                          }
                          else {
                            FUN_000d41ac();
                          }
                        }
                      }
                      else {
                        iVar11 = -1;
                      }
                      iVar12 = FUN_000d355c();
                      if (iVar12 == 0) {
                        if ((iVar11 == 0) && (local_578[0] != 0xffffffff)) {
                          if (local_578[0] == *(ulong *)(lVar13 + 0xe0)) {
                            iVar11 = 0;
                          }
                          else {
                            FUN_000d41ac();
                          }
                        }
                      }
                      else {
                        iVar11 = -1;
                      }
                      uVar20 = FUN_000d355c();
                      if ((int)uVar20 == 0) {
                        if ((iVar11 == 0) && (local_578[0] != 0xffffffff)) {
                          if (local_578[0] == *(ulong *)(lVar13 + 0xe8)) {
                            iVar11 = 0;
                          }
                          else {
                            uVar20 = FUN_000d41ac();
                          }
                        }
                      }
                      else {
                        iVar11 = -1;
                      }
                      uVar20 = FUN_000d8548(uVar20,*(undefined8 *)(lVar13 + 0x60),local_5a8);
                      if ((int)uVar20 == 0) {
                        if ((iVar11 == 0) && (iVar11 = 0, local_5a8[0] != *(long *)(lVar13 + 0xf0)))
                        {
                          iVar11 = -0x67;
                        }
                      }
                      else {
                        iVar11 = -1;
                      }
                      iVar12 = FUN_000d8548(uVar20,*(undefined8 *)(lVar13 + 0x60),local_5d8);
                      uVar7 = iVar12 == 0 && iVar11 == 0;
                      lVar18 = local_5a8[0] + *(long *)(lVar13 + 0x138) + 0x1e;
                      lVar27 = (ulong)(uint)(local_5d8[0] + (int)local_5a8[0]) + 0x1e;
                      iVar11 = local_5d8[0];
                      bVar6 = (bool)uVar7;
                    }
                    else {
                      lVar18 = 0;
                      lVar27 = 0x1e;
                      iVar11 = 0;
                      bVar6 = false;
                    }
                    if ((bVar6) && (plVar21 = (long *)FUN_000d8780(0x140), plVar21 != (long *)0x0))
                    {
                      lVar22 = FUN_000d8780(0x4000);
                      *plVar21 = lVar22;
                      plVar21[0x11] = lVar18;
                      *(int *)(plVar21 + 0x12) = iVar11;
                      plVar21[0x13] = 0;
                      *(undefined4 *)(plVar21 + 0x27) = 0;
                      if (lVar22 != 0) {
                        plVar21[0x10] = 0;
                        lVar18 = *(long *)(lVar13 + 0xd8);
                        plVar21[0x14] = 0;
                        plVar21[0x15] = 0;
                        plVar21[0x16] = lVar18;
                        lVar22 = *(long *)(lVar13 + 200);
                        plVar21[0x24] = *(long *)(lVar13 + 0x60);
                        plVar21[0x25] = lVar22;
                        FUN_000d8760(plVar21 + 0x19,lVar13,0x58);
                        lVar18 = *(long *)(lVar13 + 0x78);
                        uVar7 = lVar22 == 8;
                        plVar21[6] = 0;
                        plVar21[0x26] = lVar18;
                        if ((bool)uVar7) {
                          plVar21[1] = 0;
                          *(undefined4 *)(plVar21 + 2) = 0;
                          plVar21[10] = 0;
                          plVar21[0xb] = 0;
                          plVar21[9] = 0;
                          iVar11 = FUN_000d8e50(plVar21 + 1,0xfffffff1,s_1_2_8_000150a5,0x70);
                          if (iVar11 != 0) goto LAB_00084b90;
                          plVar21[0x10] = 8;
                        }
                        else {
                          uVar7 = lVar22 == 0xc;
                          if ((bool)uVar7) {
                            *(undefined4 *)(plVar21 + 0x27) = 1;
                          }
                        }
                        lVar18 = *(long *)(lVar13 + 0xe0);
                        plVar21[0x18] = *(long *)(lVar13 + 0xe8);
                        plVar21[0x17] = lVar18;
                        lVar18 = *(long *)(lVar13 + 0x138);
                        *(undefined4 *)(plVar21 + 2) = 0;
                        plVar21[0xf] = lVar27 + lVar18;
                        *(long **)(lVar13 + 0x140) = plVar21;
                        *(undefined4 *)(lVar13 + 0x148) = 0;
                        lVar18 = (**(code **)(_DAT_000e8a38 + 0x148))(local_b8 + 1);
                        *(undefined1 *)(lVar18 + local_b8) = 0;
                        if (lVar18 == 0) goto LAB_00084e90;
                        plVar21 = *(long **)(lVar13 + 0x140);
                        if (plVar21 == (long *)0x0) {
                          iVar11 = -0x66;
                          goto LAB_00084e70;
                        }
                        if (*plVar21 == 0) {
                          iVar11 = -100;
                          goto LAB_00084e70;
                        }
                        iVar12 = (int)local_b8;
                        if (iVar12 == 0) {
                          iVar11 = 0;
                          goto LAB_00084e70;
                        }
                        plVar21[4] = lVar18;
                        *(int *)(plVar21 + 5) = iVar12;
                        if (((ulong)plVar21[0x18] < (local_b8 & 0xffffffff)) &&
                           ((int)plVar21[0x27] == 0)) {
                          iVar12 = (int)plVar21[0x18];
                          *(int *)(plVar21 + 5) = iVar12;
                        }
                        if ((plVar21[0x17] + (ulong)*(uint *)(plVar21 + 2) < (local_b8 & 0xffffffff)
                            ) && ((int)plVar21[0x27] != 0)) {
                          iVar12 = *(uint *)(plVar21 + 2) + (int)plVar21[0x17];
                          *(int *)(plVar21 + 5) = iVar12;
                        }
                        iVar11 = 0;
                        goto joined_r0x00084c74;
                      }
LAB_00084b90:
                      FUN_000d4afc();
                    }
                  }
                  break;
                }
              }
              iVar11 = FUN_000b8178(lVar13);
              if (iVar11 != 0) break;
            }
            lVar18 = 0;
          }
          else {
            lVar18 = 0;
          }
          goto LAB_000840cc;
        }
        iVar11 = FUN_000d85c4();
        if (iVar11 == 0) {
          do {
            iVar11 = FUN_000b8168(lVar13,&local_f0,&local_508,0x100);
            if (iVar11 != 0) goto LAB_0008419c;
            iVar11 = FUN_000d0cd4(_DAT_000e8a38,&local_508);
            uVar7 = iVar11 == 1;
            if ((0 < iVar11) &&
               (uVar7 = *(char *)((long)&local_508 + (ulong)(iVar11 - 1)) == '/', !(bool)uVar7)) {
              FUN_000d2f88(&local_108);
              lVar18 = FUN_000d178c(&local_108,s_META_INF_0001331a);
              if (lVar18 == 0) {
LAB_00083f3c:
                FUN_0004e170(&local_108);
              }
              else {
                lVar18 = FUN_000d178c(&local_108,s_assets_00013c3e);
                if (lVar18 == 0) {
                  lVar18 = FUN_000d178c(&local_108,s_nedig_properties_00014714);
                  uVar7 = lVar18 == -1;
                  if (!(bool)uVar7) goto LAB_00083f3c;
                }
                FUN_0004e170(&local_108);
                uVar20 = local_c8;
                ppppppplVar19 = (long *******)FUN_000d10c8();
                ppppppplVar16 = ppppppplVar19 + 4;
                local_108 = ppppppplVar19;
                local_100 = (long *******)&local_538;
                FUN_0006e06c(ppppppplVar16,&local_508);
                *(int *)(ppppppplVar19 + 7) = (int)uVar20;
                local_f8 = CONCAT71(local_f8._1_7_,1);
                ppppppplVar19 = (long *******)&local_538;
                ppppppplVar25 = local_538;
                while (ppppppplVar25 != (long *******)0x0) {
                  while( true ) {
                    ppppppplVar30 = ppppppplVar25;
                    uVar15 = FUN_00070db4(ppppppplVar16,ppppppplVar30 + 4);
                    if ((uVar15 & 1) == 0) break;
                    ppppppplVar25 = (long *******)*ppppppplVar30;
                    ppppppplVar19 = ppppppplVar30;
                    if ((long *******)*ppppppplVar30 == (long *******)0x0) goto LAB_00083f5c;
                  }
                  uVar15 = FUN_00070db4(ppppppplVar30 + 4,ppppppplVar16);
                  if ((uVar15 & 1) == 0) break;
                  ppppppplVar19 = ppppppplVar30 + 1;
                  ppppppplVar25 = (long *******)*ppppppplVar19;
                }
LAB_00083f5c:
                if (*ppppppplVar19 == (long ******)0x0) {
                  FUN_000d4864(&local_540);
                  FUN_0008557c();
                  local_108 = (long *******)0x0;
                }
                FUN_0008559c(&local_108);
              }
            }
            iVar11 = FUN_000b8178(lVar13);
          } while (iVar11 == 0);
          goto LAB_00083d6c;
        }
        goto LAB_0008419c;
      }
    }
    (*local_4e0)(local_4d0,local_4a8);
  }
LAB_00083da8:
  local_f0 = DAT_0001a8c8;
  local_e8 = (long ******)CONCAT44(local_e8._4_4_,DAT_0001a8d0);
  FUN_00073578(&local_f0,&local_108);
  FUN_000d5b8c();
  FUN_000d4df0();
  uVar20 = 1;
  if (!(bool)uVar7) {
    uVar20 = extraout_x9_00;
  }
  uVar2 = extraout_x8_01;
  if ((extraout_x11_00 & 1) != 0) {
    uVar2 = extraout_x12_00;
  }
  FUN_000cfe20(uVar20,uVar2);
  FUN_000d0cc4();
  bVar6 = true;
  goto LAB_00084434;
joined_r0x00084c74:
  iVar8 = iVar11;
  if (iVar12 == 0) goto LAB_00084e58;
  uVar15 = (ulong)*(uint *)(plVar21 + 2);
  if (*(uint *)(plVar21 + 2) == 0) {
    uVar15 = plVar21[0x17];
    if (uVar15 == 0) {
      uVar15 = 0;
    }
    else {
      if (0x3fff < uVar15) {
        uVar15 = 0x4000;
      }
      lVar27 = FUN_000b8208(plVar21 + 0x19,plVar21[0x24],plVar21[0x26] + plVar21[0xf],0);
      if ((lVar27 != 0) ||
         (uVar23 = (*(code *)plVar21[0x1a])(plVar21[0x20],plVar21[0x24],*plVar21,uVar15),
         uVar23 != uVar15)) {
        iVar11 = -1;
        goto LAB_00084e70;
      }
      *(int *)(plVar21 + 2) = (int)uVar15;
      plVar21[1] = *plVar21;
      plVar21[0xf] = plVar21[0xf] + uVar15;
      plVar21[0x17] = plVar21[0x17] - uVar15;
    }
  }
  if ((plVar21[0x25] == 0) || ((int)plVar21[0x27] != 0)) {
    uVar28 = (uint)uVar15;
    if ((uVar28 == 0) && (plVar21[0x17] == 0)) goto LAB_00084e70;
    uVar15 = 0;
    uVar1 = *(uint *)(plVar21 + 5);
    if (uVar28 <= *(uint *)(plVar21 + 5)) {
      uVar1 = uVar28;
    }
    uVar23 = (ulong)uVar1;
    for (; uVar23 != uVar15; uVar15 = uVar15 + 1) {
      *(undefined1 *)(plVar21[4] + uVar15) = *(undefined1 *)(plVar21[1] + uVar15);
    }
    plVar21[0x14] = plVar21[0x14] + uVar23;
    lVar27 = FUN_000d8e60(plVar21[0x15],plVar21[4],uVar23);
    iVar11 = uVar1 + iVar11;
    plVar21[0x18] = plVar21[0x18] - uVar23;
    *(uint *)(plVar21 + 2) = (int)plVar21[2] - uVar1;
    *(uint *)(plVar21 + 5) = (int)plVar21[5] - uVar1;
    plVar21[4] = plVar21[4] + uVar23;
    plVar21[1] = plVar21[1] + uVar23;
    plVar21[0x15] = lVar27;
    plVar21[6] = plVar21[6] + uVar23;
  }
  else if (plVar21[0x25] != 0xc) {
    lVar22 = plVar21[6];
    lVar27 = plVar21[4];
    iVar8 = FUN_000d8e70(plVar21 + 1,2);
    if ((-1 < iVar8) && (plVar21[7] != 0)) {
      iVar8 = -3;
    }
    uVar15 = plVar21[6] - lVar22;
    plVar21[0x14] = plVar21[0x14] + uVar15;
    lVar27 = FUN_000d8e60(plVar21[0x15],lVar27,uVar15 & 0xffffffff);
    iVar11 = iVar11 + (int)uVar15;
    plVar21[0x15] = lVar27;
    plVar21[0x18] = plVar21[0x18] - uVar15;
    if (iVar8 != 0) {
      if (iVar8 == 1) goto LAB_00084e70;
      goto LAB_00084e58;
    }
  }
  iVar12 = (int)plVar21[5];
  goto joined_r0x00084c74;
LAB_00084e58:
  iVar11 = iVar8;
LAB_00084e70:
  uVar7 = local_b8 == (long)iVar11;
  if (!(bool)uVar7) {
    FUN_000d16b4(_DAT_000e8a38,lVar18);
    lVar18 = 0;
  }
LAB_00084e90:
  FUN_000d8518();
  if (lVar18 != 0) {
    FUN_00085548(lVar18,local_b8);
  }
LAB_000840cc:
  if (lVar18 == 0) {
    local_f0 = DAT_0001a8bc;
    local_e8 = (long ******)CONCAT44(local_e8._4_4_,DAT_0001a8c4);
    FUN_00073578(&local_f0,&local_108);
    FUN_0006e06c(&local_508,&local_108);
    FUN_000d4df0();
    uVar15 = (ulong)&local_508 | 1;
    if (!(bool)uVar7) {
      uVar15 = extraout_x9_01;
    }
    uVar20 = extraout_x8_02;
    if ((extraout_x11_01 & 1) != 0) {
      uVar20 = extraout_x12_01;
    }
    FUN_000cfe20(uVar15,uVar20);
    FUN_000d0cc4();
LAB_0008419c:
    bVar6 = false;
  }
  else {
    uVar15 = FUN_00084f60(&local_560,lVar18);
    if ((uVar15 & 1) == 0) {
LAB_00084404:
      bVar6 = false;
    }
    else {
      for (puVar14 = local_528; puVar14 != &local_520; puVar14 = (undefined8 *)FUN_000727e0(puVar14)
          ) {
        iVar11 = *(int *)(puVar14 + 7);
        if (iVar11 != 0) {
          if ((*(byte *)(puVar14 + 4) & 1) == 0) {
            lVar27 = (long)puVar14 + 0x21;
          }
          else {
            lVar27 = puVar14[6];
          }
          ppppppplVar16 = (long *******)FUN_000854fc(&local_540);
          if (&local_538 == (long ********)ppppppplVar16) {
            puVar14 = &DAT_0001a8e0;
          }
          else {
            if ((*(int *)(ppppppplVar16 + 7) == 0) || (iVar11 == *(int *)(ppppppplVar16 + 7)))
            goto LAB_0008413c;
            puVar14 = &DAT_0001a8d4;
          }
          local_f0 = (long *******)*puVar14;
          local_e8 = (long ******)CONCAT44(local_e8._4_4_,*(undefined4 *)(puVar14 + 1));
          FUN_00073578(&local_f0,&local_108);
          FUN_0006e06c(&local_508,&local_108);
          puVar3 = (undefined1 *)((ulong)&local_508 | 1);
          if (((ulong)local_508 & 1) != 0) {
            puVar3 = local_4f8;
          }
          FUN_000cfe20(puVar3,lVar27);
          FUN_000d0cc4();
          goto LAB_00084404;
        }
LAB_0008413c:
      }
      ppppppplVar16 = local_540;
      if (local_510 == 1) {
        for (; (long ********)ppppppplVar16 != &local_538;
            ppppppplVar16 = (long *******)FUN_000727e0(ppppppplVar16)) {
          if (((ulong)ppppppplVar16[4] & 1) == 0) {
            pppppplVar24 = (long ******)((long)ppppppplVar16 + 0x21);
          }
          else {
            pppppplVar24 = ppppppplVar16[6];
          }
          puVar14 = (undefined8 *)FUN_000854fc(&local_528);
          if (&local_520 == puVar14) {
            iVar12 = (int)local_518 - (int)local_530;
            iVar11 = -iVar12;
            if (-1 < iVar12) {
              iVar11 = iVar12;
            }
            local_f0 = DAT_0001a8ec;
            bVar6 = 10 < iVar11;
            local_e8 = (long ******)CONCAT44(local_e8._4_4_,DAT_0001a8f4);
            FUN_00073578(&local_f0,&local_108);
            FUN_0006e06c(&local_508,&local_108);
            puVar3 = (undefined1 *)((ulong)&local_508 | 1);
            if (((ulong)local_508 & 1) != 0) {
              puVar3 = local_4f8;
            }
            FUN_000cfe20(puVar3,pppppplVar24);
            FUN_000d0cc4();
            goto LAB_00084408;
          }
        }
      }
      bVar6 = true;
    }
LAB_00084408:
    FUN_000d16b4(_DAT_000e8a38,lVar18);
  }
  if (*(long *)(lVar13 + 0x140) != 0) {
    FUN_000d8518();
  }
  (**(code **)(lVar13 + 0x28))(*(undefined8 *)(lVar13 + 0x38),*(undefined8 *)(lVar13 + 0x60));
  FUN_000d2e3c();
LAB_00084434:
  FUN_000d04a4();
  if (bVar6 == false) {
    _DAT_000e93ec = 1;
  }
  FUN_00084efc(local_520);
  FUN_00084efc(local_538);
  if (local_558 != 0) {
    FUN_00084ec4(&local_558);
    thunk_FUN_000d8750(local_558);
  }
  if (*(long *)(unaff_x27 + 0x28) != local_68) {
                    /* WARNING: Subroutine does not return */
    FUN_000d8770();
  }
  FUN_000cfdf0(bVar6);
  return;
}

