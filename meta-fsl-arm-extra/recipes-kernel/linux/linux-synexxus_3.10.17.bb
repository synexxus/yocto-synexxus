# Adapted from linux-imx.inc, copyright (C) 2014 Synexxus, Inc.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Synexxus boards"

SRC_URI = "git://github.com/SynexxusJReep/linux-synexxus.git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-3.10.17+yocto"
SRCBRANCH = "3.10.17"
#SRCREV = "aea7b5cf27121d9697e4b44a5ef8b7d3cd3d93ea"
#Updated dtb file on 07/18/2014
#SRCREV = "4c8e1314e4812fb27e27282fb55c9c209bc71f4d"
#4:57PM 07/18/2014
#SRCREV = "2e6e6eccb625aed281429811e4b6b17a35437f30"
#07/22/2014
#SRCREV = "6929bb69514e2758adee64eed02cf10a9f1b429c"
#07/22/2014 CONFIG_SND_IMX_SOC
# Major changes
#SRCREV = "b47541c0762c9c55beccf6c56d98db8dd1bec914"
## WORKING SRCREV = "67deb028d1e5fb8382db4d43715c35005093260d"
# PCIe Power: SRCREV = "97af25815f2904493d19bc31eab317f6f4bd001b"
# For No PCIe Power:
SRCREV = "a4521a296ea96d5aeac928a0737b887023e5b331"
DEPENDS += "lzop-native "
COMPATIBLE_MACHINE = "(mx6)"
COMPATIBLE_MACHINE = "(aristeus)"
