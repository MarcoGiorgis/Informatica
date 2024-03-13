let player;
let platforms = [];
let bots = [];
let moneys = [];
let hearts = [];

let numSalti = 0; //per il doppio salto
let punteggio = 0; //punteggio monete
let vite = 4;

let colpitoRight = false;
let colpitoLeft = false;

let vittoriaState = false; //gestione vittoria
let vittoriaFlag = 1; //per gestione del suono dellla  vittoria
let gameOverState = false; //per pulsanti gameOver
let gameState = "start";
let pausatime = false;
let ricominciaState = false;
let tutorialState = false; //per punteggio nel tutorial

// elementi che cambiano nei diversi livelli
let xBandiera;
let yBandiera;
let gravity = 0.5; //gravità di caduta

//bottoni
let buttonStart, buttonTutorial, backButton;
let secondPageVisibile = false;
let buttons = [];
let schermataTemporanea;
let schermataIniziale;
let sfondoScelto;

//scelta livello per scegliere tipo di pavimento
let pavimentoSelezionato;

//livello selezionato
let livelloSelezionato;
//per tornare alla scelta dei livelli
let buttonBackLevelCreated = false;
//errore sulla bandiera sul restart una volta vinto un livello 
let bandieraDefault;

function preload() {
  pavimentoTerra = loadImage("./img/pavimentoTerra.png");
  pavimentoLuna = loadImage("./img/pavimentoLuna.png");
  pavimentoGiove = loadImage("./img/pavimentoGiove.png");
  pavimentoTutorial = loadImage("./img/bloccoTutorial.png");
  sfondoTerra = loadImage("./img/sfondoTerra2.avif");
  sfondoLuna = loadImage("./img/sfondoLuna.avif");
  sfondoGiove = loadImage("./img/sfondoGiove.jpeg");
  bloccoTerra = loadImage("./img/bloccoTerra.png");
  bloccoLuna = loadImage("./img/bloccoLuna.png")
  bloccoGiove = loadImage("./img/bloccoGiove.png");
  bloccoTutorial = loadImage("./img/pavimentoTutorial.png");
  sabbia = loadImage("./img/sabbiaTerra.png");
  sabbiaLuna = loadImage("./img/sabbiaLuna.png");
  sabbiaGiove = loadImage("./img/sabbiaGiove.png");
  bandiera = loadImage("./img/bandiera.png");
  vittoria = loadImage("./img/vittoria.png");
  moneta = loadImage("./img/moneta.png");
  cuore = loadImage("./img/vita.png");
  pausa = loadImage("./img/pausa.png");
  ripresa = loadImage("./img/ripresa.png");
  restart = loadImage("./img/restart.png");
  uscita = loadImage("./img/uscita.png");
  gameOver = loadImage("./img/gameOver.webp");
  backLevel = loadImage("./img/backLivelli.png");
  schermataVittoria = loadImage("./img/schermataVittoria.avif");
  schermataIniziale = loadImage("./img/schermataIniziale2.png");
  schermataTutorial = loadImage("./img/schermataTutorial.png");
  schermataLivelli = loadImage("./img/schermataLivelli.png");

  bitFont = loadFont('./font/Micro5-Regular.ttf');

  soundFormats('mp3', 'ogg');
  soundMonete = loadSound('./sound/soundMonete.mp3');
  soundJump = loadSound('./sound/soundJump.mp3');
  soundClickMouse = loadSound('./sound/soundClickMouse.mp3');
  soundPerditaVita = loadSound('./sound/soundPerditaVita.mp3');
  soundMorte = loadSound('./sound/soundMorte.mp3');
  soundSottofondo = loadSound('./sound/soundSottofondo.mp3');
  soundPassaggioLivello = loadSound('./sound/soundPassaggioLivello.mp3');
  soundStart = loadSound('./sound/soundStart.mp3');

  bandieraDefault = bandiera;
}

function setXbandiera(newX) { xBandiera = newX }
function setYbandiera(newY) { yBandiera = newY }
function setGravity(newGravity) { gravity = newGravity }
function getXbandiera() { return xBandiera }
function getYbandiera() { return yBandiera }
function getGravity() { return gravity }

function setup() {
  soundStart.play();
  createCanvas(1250, 650);
  frameRate(80);
  background(schermataIniziale);
  schermataTemporanea = schermataIniziale;

  buttonStart = createButton('');
  buttonStart.position(55, 380);
  buttonStart.size(522, 170);
  buttonStart.style('background-color', 'rgba(0,0,0,0)');
  buttonStart.style('border', '0px');
  buttonStart.mousePressed(secondPage);

  buttonTutorial = createButton('');
  buttonTutorial.position(695, 380);
  buttonTutorial.size(522, 170);
  buttonTutorial.style('background-color', 'rgba(0,0,0,0)');
  buttonTutorial.style('border', '0px');
  buttonTutorial.mousePressed(tutorialPage);

  hearts.push(new Vite(1200, 20))
  hearts.push(new Vite(1160, 20))
  hearts.push(new Vite(1120, 20))

  textFont(bitFont);
  bandiera.resize(50, 50);
  pausa.resize(50, 50);
  ripresa.resize(50, 50);
  restart.resize(50, 50);
  vittoria.resize(50, 50);
  backLevel.resize(120, 50);
}

function secondPage() { //seconda pagina
  soundClickMouse.play();
  schermataIniziale = schermataLivelli;
  buttonStart.hide();
  buttonTutorial.hide();
  secondPageButtons(); // creazione bottoni seconda schermata
  secondPageVisibile = true; // stato schermata livelli visibile
  draw();
}

function tutorialPage() { //schermata tutorial istruzioni
  soundClickMouse.play();
  tutorialState = true;
  resetGame();
  schermataIniziale = schermataVittoria;
  setUpIstruction();

  pavimentoSelezionato = pavimentoTutorial;
  player = new Player();
  gameState = "playing";
  draw();
  buttonStart.hide();
  buttonTutorial.hide();
  backButton = createButton('');
  backButton.position(860, 220);
  backButton.size(285, 90);
  backButton.style('background-color', 'rgba(0,0,0,0)');
  backButton.style('border', '0px');
  backButton.mousePressed(backButtonPressed);
}

function backButtonPressed() { //ritorno all'home dal tutorial
  soundClickMouse.play();
  resetGame();
  tutorialState = false; //stato tutorial 
  backButton.remove(); // Rimuovi il pulsante "Back"
  schermataIniziale = schermataTemporanea
  buttonStart.show();
  buttonTutorial.show();
  gameState = "start"; // Torna allo stato iniziale
  loop();
}

function setUpLevelTerra() {
  createOrRemoveBackButton();
  soundClickMouse.play();
  setUpElementsTerra();
  setGravity(0.6);
  setXbandiera(1150);
  setYbandiera(360);
  sfondoScelto = sfondoTerra;
  gameState = "playing";
  livelloSelezionato = "Terra";
  pavimentoSelezionato = pavimentoTerra;
  soundSottofondo.play();
  player = new Player();
  draw();
}

function setUpLevelLuna() {
  createOrRemoveBackButton();
  soundClickMouse.play();
  setUpElementsLuna();
  setGravity(0.4);
  setXbandiera(1200);
  setYbandiera(320);
  sfondoScelto = sfondoLuna;
  gameState = "playing";
  livelloSelezionato = "Luna";
  pavimentoSelezionato = pavimentoLuna;
  soundSottofondo.play();
  player = new Player();
  draw();
}

function setUpLevelGiove() {
  createOrRemoveBackButton();
  soundClickMouse.play();
  setUpElementsGiove();
  setGravity(0.8);
  setXbandiera(1200);
  setYbandiera(480);
  sfondoScelto = sfondoGiove;
  gameState = "playing";
  livelloSelezionato = "Giove";
  pavimentoSelezionato = pavimentoGiove;
  soundSottofondo.play();
  player = new Player();
  draw();
}

function secondPageButtons() { //creazione bottoni seconda pagina
  if (ricominciaState == true) {
    buttonBackLevel.hide();
    soundStart.play();
  }
  ricominciaState = false
  for (let i = 0; i < 3; i++) {
    let button = createButton('');
    button.position(60 + i * 420, 285);
    button.size(300, 100);
    button.style('background-color', 'rgba(0,0,0,0)');
    button.style('border', '0px');
    buttons.push(button);
    switch (i) {
      case 0:
        button.mousePressed(() => setUpLevelTerra());
        break;
      case 1:
        button.mousePressed(() => setUpLevelLuna());
        break;
      case 2:
        button.mousePressed(() => setUpLevelGiove());
        break;
    }
  }
}

function backToLevel() { //bottone nella schermata gioco per tornare al scelta dei livelli
  soundClickMouse.play();
  livelloSelezionato = "";
  ricominciaState = true;
  vittoriaState = false;
  gameState = "start";
  resetGame();
  buttonBackLevelCreated = false; // Resetta la variabile per consentire la creazione del pulsante nella prossima schermata di gioco
  draw();
  loop();
}

function createOrRemoveBackButton() { //gestione creazione e scomparsa bottone backToLevel
  if (!buttonBackLevelCreated) {
    buttonBackLevel = createButton('');
    buttonBackLevel.position(330, 22);
    buttonBackLevel.size(115, 40);
    buttonBackLevel.style('background-color', 'rgba(0,0,0,0)');
    buttonBackLevel.style('border', '0px');
    buttonBackLevel.mousePressed(backToLevel);
    buttonBackLevelCreated = true;
  }
}

function draw() {
  if (secondPageVisibile) {
    for (let button of buttons) {
      button.show();
    }
  }
  if (gameState == "start") {
    background(schermataIniziale);
  } else if (gameState == "playing") {
    soundStart.stop();
    for (let button of buttons) {
      button.hide();
    }
    if (pausatime == true) {
      breakWindows();
    } else {
      if (tutorialState == false) {
        background(sfondoScelto);
        image(bandiera, getXbandiera(), getYbandiera());
        image(pausa, 250, 10);
        image(backLevel, 320, 10);
        buttonBackLevel.show();
        createOrRemoveBackButton();
      }
      else {
        background(schermataTutorial);
      }
      for (let k = 0; k < width; k += 50) {
        pavimentoSelezionato.resize(50, 50);
        image(pavimentoSelezionato, k, 600);
      }
      for (let platform of platforms) {
        platform.show();
      }
      for (let bot of bots) {
        bot.show();
      }
      for (let money of moneys) {
        money.show();
      }
      for (let heart of hearts) {
        heart.show();
      }
      player.show();
      player.update();
      checkCollision();

      if (tutorialState == false) {
        fill(255);
        textSize(50);
        text("PUNTEGGIO: " + punteggio, 35, 35);
      } else {
        fill(255);
        textSize(100);
        text("TUTORIAL - ISTRUZIONI", 50, 100);
      }
      if (vite == 1) {
        gameOverWindow();
      }
      if (vittoriaState == true) {
        winWindow();
      }
    }
  }
  followMouse();
}

function followMouse() {
  fill("blue");
  ellipse(mouseX, mouseY, 10, 10);
}

function breakWindows() {
  background(sfondoScelto);
  fill(0, 150); // Opaco nero
  rect(0, 0, width, height);
  fill(255); // Testo bianco
  textSize(120);
  text("PAUSA", width / 2 - 120, height / 2 - 100);
  textSize(80);
  text("Punteggio Attuale: " + punteggio, width / 2 - 250, height / 2 + 50);
  image(ripresa, 480, 430);
  image(restart, 680, 430);
}

function gameOverWindow() {
  gameOverState = true;
  soundSottofondo.stop();
  uscita.resize(50, 50);
  background(gameOver);
  fill(255);
  textSize(50);
  text("SCORE: " + punteggio, width / 2 - 50, height / 2 + 150);
  image(restart, 400, 450);
  image(uscita, 820, 450);
}

function winWindow() {
  soundSottofondo.stop();
  uscita.resize(50, 50);
  bandiera = bandieraDefault;
  background(schermataVittoria);
  fill(255);
  textSize(60);
  text("SCORE: " + punteggio, width / 2 - 70, height / 2 + 80);
  image(restart, 400, 350);
  image(uscita, 830, 350);
}

function checkCollision() {
  for (let platform of platforms) {
    const indicePiattaforma = platforms.indexOf(platform);
    if (player.hitsUnder(platform)) { //collisione sotto piattaforma
      if (numSalti == 2) { //risoluzione bug su doppio salto
        player.ySpeed = 0;
        player.y = player.y + 1;
      } else {
        player.ySpeed = 0;
      }
    }

    if (player.hits(platform)) { //collisione sopra piattaforma
      player.ySpeed = 0; // Imposta la velocità verticale a zero
      player.y = platform.y - player.height;
      numSalti = 0;
      if (platform.getType() == 1 && !platform.getStato()) {  //per rimuovere blocco sabbia
        setTimeout(() => { platforms.splice(indicePiattaforma, 1) }, 500); //millesimi secondi 
        platform.setStato(true);
      }
    }

    if (player.hitsSideRight(platform)) { //collisione destra piattaforma
      player.xSpeed = 0;
      colpitoRight = true;
    }

    if (player.hitsSideLeft(platform)) { //collisione sinistra piattaforma
      player.xSpeed = 0;
      colpitoLeft = true;
    }
  }
  //collisioni con i bot
  for (let bot of bots) {
    if (bot.hitsBot(player)) {
      soundPerditaVita.play();
      player.y = 100;
      player.x = 100;
      vite -= 1;
      if (vite != 0)
        hearts.pop(hearts[-1]);
    }
  }
  //collisioni con le monete
  for (let i = 0; i < moneys.length; i++) {
    let money = moneys[i];
    if (money.hitsMoney(player)) {
      soundMonete.play();
      punteggio++;
      moneys.splice(i, 1);
      i--;
    }
  }
  //collisione con pavimento
  if (player.y == height - 70) {
    if (vite != 2)
      soundPerditaVita.play();
    else
      soundMorte.play();
    player.y = 100;
    player.x = 100;
    vite--;
    if (vite != 0)
      hearts.pop(hearts[-1]);
  }
  //collisione con bandiera 
  if (player.x >= getXbandiera() && player.x <= (getXbandiera() + 50) && player.y >= getYbandiera() && player.y <= (getYbandiera() + 50)) {
    bandiera = vittoria;
    if (vittoriaFlag == 1) {
      soundPassaggioLivello.play();
      vittoriaFlag = 0;
      setTimeout(() => { vittoriaState = true }, 1500);
    }
  }
}

function keyPressed() {
  colpitoRight = false;
  colpitoLeft = false;

  if (key == 'a' && !colpitoLeft) {
    if (!checkCollisionLateraleSinistra()) { //non è presente una collisione a sinistra
      player.setDirection(-1); // Set direzione sinistra
    }
  } else if (key == 'd' && !colpitoRight) {
    if (!checkCollisionLateraleDestra()) { //non è presente una collisione a destra
      player.setDirection(1); // Set direzione destra
    }
  } else if (key == 'w' && numSalti < 2) {
    soundJump.play();
    colpitoRight = false;
    colpitoLeft = false; 
    player.jump(-9);
    numSalti++;
  } else if (key == 'r' && tutorialState == false) {
    resetGame();
  }
}

function checkCollisionLateraleSinistra() {
  for (let platform of platforms) {
    if (player.hitsSideLeft(platform)) { 
      return true; 
    }
  }
  return false; 
}

function checkCollisionLateraleDestra() {
  for (let platform of platforms) {
    if (player.hitsSideRight(platform)) { 
      return true; 
    }
  }
  return false; 
}

function keyReleased() {
  if (key == 'a' || key == 'd') {
    player.setDirection(0); // stoppa il movimento dell'oggetto se i tasti sono rilasciati
    colpitoLeft = false;
    colpitoRight = false;
  }
}

function mouseClicked() {
  let d = dist(mouseX, mouseY, 300, 30); //pausa schermata home
  let d1 = dist(mouseX, mouseY, 480, 430); //ripresa schermata di pausa
  let d2 = dist(mouseX, mouseY, 680, 430); //restart schermata di pausa
  let d3 = dist(mouseX, mouseY, 400, 350); //restart su vittoria
  let d4 = dist(mouseX, mouseY, 830, 350); //uscita su vittoria
  let d5 = dist(mouseX, mouseY, 400, 450); //restart gameOver
  let d6 = dist(mouseX, mouseY, 820, 450); //uscita gameOver
  if (d < 50) {
    soundClickMouse.play();
    pausatime = !pausatime;
  }
  if (d1 < 50 && pausatime == true) {
    soundClickMouse.play();
    pausatime = !pausatime;
  }
  if (d2 < 50 && pausatime == true) {
    soundClickMouse.play();
    resetGame();
  }
  if (d3 < 50 && vittoriaState == true) {
    soundClickMouse.play();
    backToLevel();
  }
  if (d4 < 50 && vittoriaState == true) {
    soundClickMouse.play();
    setTimeout(() => { window.close() }, 200);
  }
  if (d5 < 50 && gameOverState == true) {
    soundClickMouse.play();
    resetGame();
  }
  if (d6 < 50 && gameOverState == true) {
    soundClickMouse.play();
    setTimeout(() => { window.close() }, 200);
  }
}

function resetGame() {
  soundSottofondo.stop();
  pausatime = false; player = new Player(); platforms = []; bots = []; moneys = []; hearts = []; numSalti = 0;
  punteggio = 0; vite = 4; colpitoRight = false; colpitoLeft = false; vittoriaState = false;
  rimossaPiattaforma = false; gameOverState = false; pausatime = false; vittoriaFlag = 1;

  if (livelloSelezionato == "Terra") {
    setUpLevelTerra();
  } else if (livelloSelezionato == "Luna") {
    setUpLevelLuna();
  } else if (livelloSelezionato == "Giove") {
    setUpLevelGiove();
  } else if (livelloSelezionato == "") {
    secondPageButtons();
  }
  hearts.push(new Vite(1200, 20));
  hearts.push(new Vite(1160, 20));
  hearts.push(new Vite(1120, 20));
  draw();
}