require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
COMPATIBLE_MACHINE = "(aristeus)"

PROVIDES = "u-boot"

SRCREV = "09996307e4f66eaa6697875f584a15cce1541a0a"
SRC_URI = "git://github.com/SynexxusJReep/u-boot-synexxus.git;branch=master"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
