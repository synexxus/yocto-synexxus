# Adapted from linux-imx.inc, copyright (C) 2014 Synexxus, Inc.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Synexxus boards"

SRC_URI = "git://github.com/SynexxusJReep/linux-synexxus.git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-3.10.17+yocto"
SRCBRANCH = "3.10.17"
SRCREV = "aea7b5cf27121d9697e4b44a5ef8b7d3cd3d93ea"
DEPENDS += "lzop-native "
COMPATIBLE_MACHINE = "(mx6)"
COMPATIBLE_MACHINE = "(aristeus)"
