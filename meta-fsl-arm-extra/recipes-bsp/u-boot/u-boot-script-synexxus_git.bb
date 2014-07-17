LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
DEPENDS = "u-boot-mkimage-native"

SRCREV = "00d135f1dba3f9cfb78ef4f5cc162166037a3b89"
SRC_URI = "git://github.com/SynexxusJReep/u-boot-synexxus.git;branch=master"

S = "${WORKDIR}/git"

inherit deploy

do_mkimage () {

    boarddir=aristeus;

    # allow deploy to use the ${MACHINE} name to simplify things
    if [ ! -d board/synexxus/${MACHINE} ]; then
        mkdir board/synexxus/${MACHINE}
    fi
    bootscript=board/synexxus/${boarddir}/6x_bootscript-yocto.txt;
    if ! [ -f $bootscript ]; then
        bootscript=board/synexxus/${boarddir}/6x_bootscript-yocto.txt;
    fi
    echo "bootscript == $bootscript"

    upgradescript=board/synexxus/${boarddir}/6x_upgrade.txt;
    if ! [ -f $upgradescript ]; then
        upgradescript=board/synexxus/aristeus/6x_upgrade.txt;
    fi

    uboot-mkimage  -A arm -O linux -T script -C none -a 0 -e 0 \
                   -n "boot script" -d $bootscript \
                   board/synexxus/${MACHINE}/6x_bootscript

    uboot-mkimage  -A arm -O linux -T script -C none -a 0 -e 0 \
                   -n "upgrade script" -d $upgradescript \
                   board/synexxus/${MACHINE}/6x_upgrade
}

addtask mkimage after do_compile before do_install

do_deploy () {
    install -d ${DEPLOYDIR}
    install ${S}/board/synexxus/${MACHINE}/6x_bootscript \
            ${DEPLOYDIR}/6x_bootscript-${MACHINE}-${PV}-${PR}
    install ${S}/board/synexxus/${MACHINE}/6x_upgrade \
            ${DEPLOYDIR}/6x_upgrade-${MACHINE}-${PV}-${PR}

    cd ${DEPLOYDIR}
    rm -f 6x_bootscript-${MACHINE} 6x_upgrade-${MACHINE}
    ln -sf 6x_bootscript-${MACHINE}-${PV}-${PR} 6x_bootscript-${MACHINE}
    ln -sf 6x_upgrade-${MACHINE}-${PV}-${PR} 6x_upgrade-${MACHINE}
}

addtask deploy after do_install before do_build

do_compile[noexec] = "1"
do_install[noexec] = "1"
do_populate_sysroot[noexec] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(aristeus)"
