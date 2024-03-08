function setUpElementsTerra() {
    platforms.push(new Platform(40, 120, 40, 120, bloccoTerra, 0));
    platforms.push(new Platform(80, 200, 80, 40, bloccoTerra, 0));

    platforms.push(new Platform(240, 160, 240, 40, sabbia, 1));
    platforms.push(new Platform(440, 200, 40, 120, bloccoTerra, 0));
    moneys.push(new Money(450, 135));
    platforms.push(new Platform(320, 280, 120, 40, bloccoTerra, 0));
    bots.push(new Bot(330, 260, 320, 420, 1));
    moneys.push(new Money(410, 255));

    platforms.push(new Platform(80, 360, 40, 40, bloccoTerra, 0));
    platforms.push(new Platform(80, 400, 120, 40, bloccoTerra, 0));

    platforms.push(new Platform(200, 520, 120, 40, sabbia, 1));

    platforms.push(new Platform(440, 480, 120, 40, bloccoTerra, 0));
    platforms.push(new Platform(520, 520, 200, 40, bloccoTerra, 0));
    platforms.push(new Platform(680, 480, 120, 40, bloccoTerra, 0));
    moneys.push(new Money(570, 495));

    platforms.push(new Platform(600, 380, 120, 40, bloccoTerra, 0));
    platforms.push(new Platform(640, 280, 40, 40, bloccoTerra, 0));

    platforms.push(new Platform(760, 240, 120, 40, bloccoTerra, 0));
    bots.push(new Bot(770, 220, 760, 860, 1));
    platforms.push(new Platform(840, 280, 40, 80, bloccoTerra, 0));

    platforms.push(new Platform(640, 80, 200, 40, bloccoTerra, 0));
    platforms.push(new Platform(1090, 80, 160, 40, sabbia, 1));
    moneys.push(new Money(1100, 55));

    platforms.push(new Platform(960, 240, 40, 80, bloccoTerra, 0));
    platforms.push(new Platform(1000, 200, 80, 40, bloccoTerra, 0));
    moneys.push(new Money(1010, 175));

    platforms.push(new Platform(1080, 400, 200, 40, bloccoTerra, 0));
    platforms.push(new Platform(1210, 320, 40, 80, bloccoTerra, 0));
    platforms.push(new Platform(1080, 320, 40, 80, bloccoTerra, 0));

    platforms.push(new Platform(880, 480, 120, 40, bloccoTerra, 0));
    bots.push(new Bot(890, 460, 880, 980, 1));
    platforms.push(new Platform(960, 520, 120, 40, sabbia, 1));
    moneys.push(new Money(1010, 495));
}

function setUpElementsLuna() {
    platforms.push(new Platform(40, 120, 40, 120, bloccoLuna, 0));
    platforms.push(new Platform(80, 200, 80, 40, bloccoLuna, 0));

    platforms.push(new Platform(240, 240, 120, 40, sabbiaLuna, 1));

    platforms.push(new Platform(400, 240, 160, 40, bloccoLuna, 0));
    bots.push(new Bot(420, 220, 400, 540, 2));

    platforms.push(new Platform(520, 280, 40, 120, bloccoLuna, 0));

    platforms.push(new Platform(160, 360, 40, 40, bloccoLuna, 0));
    moneys.push(new Money(170, 335));
    platforms.push(new Platform(200, 400, 40, 40, sabbiaLuna, 1));
    //platforms.push(new Platform(240, 440, 40, 40, sabbia, 1)); //bug 
    platforms.push(new Platform(280, 480, 40, 40, bloccoLuna, 0));

    platforms.push(new Platform(360, 480, 120, 40, bloccoLuna, 0));
    bots.push(new Bot(380, 460, 360, 460, 2));
    moneys.push(new Money(450, 455));

    platforms.push(new Platform(540, 480, 80, 40, sabbiaLuna, 1));

    platforms.push(new Platform(700, 520, 40, 40, bloccoLuna, 0));
    platforms.push(new Platform(780, 520, 80, 40, bloccoLuna, 0));
    moneys.push(new Money(830, 495));

    platforms.push(new Platform(400, 80, 200, 40, bloccoLuna, 0));
    //platforms.push(new Platform(360, 0, 40, 120, bloccoLuna, 0));
    moneys.push(new Money(410, 55));
    moneys.push(new Money(450, 55));

    platforms.push(new Platform(840, 80, 200, 40, bloccoLuna, 0));
    bots.push(new Bot(850, 60, 840, 1020, 2));
    moneys.push(new Money(930, 55));

    platforms.push(new Platform(760, 0, 40, 40, bloccoLuna, 0));

    platforms.push(new Platform(680, 240, 160, 40, sabbiaLuna, 1));

    platforms.push(new Platform(800, 360, 160, 40, bloccoLuna, 0));
    bots.push(new Bot(810, 340, 800, 940, 2));
    moneys.push(new Money(810, 335));

    platforms.push(new Platform(1020, 480, 40, 40, sabbiaLuna, 1));

    platforms.push(new Platform(1060, 360, 200, 40, bloccoLuna, 0));
    bots.push(new Bot(1070, 340, 1060, 1120, 1));
    moneys.push(new Money(1070, 335));
    platforms.push(new Platform(1140, 200, 40, 160, bloccoLuna, 0));
    platforms.push(new Platform(1180, 240, 80, 40, sabbiaLuna, 1));

}

function setUpElementsGiove() {
    platforms.push(new Platform(40, 120, 40, 120, bloccoGiove, 0));
    platforms.push(new Platform(80, 200, 80, 40, bloccoGiove, 0));

    platforms.push(new Platform(200, 200, 80, 40, bloccoGiove, 0));
    platforms.push(new Platform(240, 240, 80, 40, bloccoGiove, 0));
    platforms.push(new Platform(280, 240, 40, 160, bloccoGiove, 0));
    platforms.push(new Platform(200, 200, 80, 40, bloccoGiove, 0));

    platforms.push(new Platform(240, 480, 160, 40, bloccoGiove, 0));
    platforms.push(new Platform(360, 440, 80, 40, bloccoGiove, 0));
    moneys.push(new Money(290, 455));

    platforms.push(new Platform(60, 440, 80, 40, bloccoGiove, 0));
    platforms.push(new Platform(100, 480, 40, 80, bloccoGiove, 0));
    platforms.push(new Platform(140, 520, 40, 40, sabbiaGiove, 1));

    platforms.push(new Platform(360, 140, 40, 40, bloccoGiove, 0));
    platforms.push(new Platform(400, 100, 120, 40, sabbiaGiove, 1));
    moneys.push(new Money(490, 75));

    platforms.push(new Platform(400, 280, 160, 40, bloccoGiove, 0));
    bots.push(new Bot(410, 260, 400, 540, 2.5));

    platforms.push(new Platform(560, 500, 200, 40, bloccoGiove, 0));
    moneys.push(new Money(610, 475));
    moneys.push(new Money(690, 475));
    bots.push(new Bot(570, 480, 560, 740, 2.5));

    platforms.push(new Platform(580, 180, 120, 40, bloccoGiove, 0));
    moneys.push(new Money(630, 155));

    platforms.push(new Platform(660, 340, 80, 40, bloccoGiove, 0));
    platforms.push(new Platform(700, 380, 80, 40, bloccoGiove, 0));

    platforms.push(new Platform(840, 500, 80, 40, sabbiaGiove, 1));
    platforms.push(new Platform(880, 420, 40, 40, sabbiaGiove, 1));

    platforms.push(new Platform(800, 280, 160, 40, bloccoGiove, 0));
    bots.push(new Bot(810, 260, 800, 940, 2.5));
    platforms.push(new Platform(920, 320, 80, 40, bloccoGiove, 0));
    platforms.push(new Platform(960, 360, 40, 80, bloccoGiove, 0));
    platforms.push(new Platform(1000, 440, 80, 40, sabbiaGiove, 1));

    platforms.push(new Platform(1080, 240, 40, 120, bloccoGiove, 0));
    platforms.push(new Platform(1080, 200, 80, 40, sabbiaGiove, 1));
    platforms.push(new Platform(1120, 160, 80, 40, sabbiaGiove, 1));
    moneys.push(new Money(1160, 135));
    platforms.push(new Platform(1120, 320, 40, 160, bloccoGiove, 0));

    platforms.push(new Platform(960, 160, 40, 40, bloccoGiove, 0));
    platforms.push(new Platform(880, 120, 80, 40, sabbiaGiove, 1));
    moneys.push(new Money(880, 95));

    platforms.push(new Platform(1180, 520, 80, 40, bloccoGiove, 0));
}

function setUpIstruction() {
    platforms.push(new Platform(0, 560, 1250, 40, bloccoTutorial, 0));
    platforms.push(new Platform(400, 450, 200, 40, bloccoTutorial, 0));
    platforms.push(new Platform(750, 350, 160, 40, bloccoTutorial, 0));
}
