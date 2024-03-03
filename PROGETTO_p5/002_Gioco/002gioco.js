let player;
let platforms = [];
let bots = [];
let moneys = [];
let hearts = [];

let numSalti = 0; //per il doppio salto
let punteggio = 0; //punteggio monete
let vite = 4;

let colpitoRight = false
let colpitoLeft = false

let vittoria = false //gestione vittoria
let gameState = "start";
let pausatime = false

// elementi che cambiano nei diversi livelli
let xBandiera = 1200
let yBandiera = 480
let gravity = 0.5; //0.6 -> terra 0.4 -> luna 1 -> giove

let tutorial = false //per punteggio nel tutorial
let sottoFondo //gestione sound sottofondo
//bottoni
let button1, button2, backButton;
let secondScreenVisible = false;
let buttons = [];
let schermataTemporanea
let schermataIniziale
let sfondoScelto

//scelta livello per scegliere tipo di pavimento
let pavimentoSelezionato;

function preload() {
  pavimentoTerra = loadImage("./img/pavimentoTerra.png");
  pavimentoLuna = loadImage("./img/pavimentoLuna.png");
  pavimentoGiove  = loadImage("./img/pavimentoGiove.png");
  pavimentoTutorial =  loadImage("./img/pavimentoTutorial.png");
  sfondoTerra = loadImage("./img/sfondoTerra2.avif");
  sfondoLuna = loadImage("./img/sfondoLuna.avif");
  sfondoGiove = loadImage("./img/sfondoGiove.jpeg");
  bloccoTerra = loadImage("./img/bloccoTerra.png");
  bloccoLuna = loadImage("./img/bloccoLuna.png")
  bloccoGiove = loadImage("./img/bloccoGiove.png");
  bloccoTutorial = loadImage("./img/bloccoTutorial.avif");
  sabbia = loadImage("./img/sabbiaTerra.png");
  sabbiaLuna = loadImage("./img/sabbiaLuna.png");
  sabbiaGiove = loadImage("./img/sabbiaGiove.png");
  bandiera = loadImage("./img/bandiera.png");
  vittoria = loadImage("./img/vittoria.png");
  moneta = loadImage("./img/moneta.png");
  cuore = loadImage("./img/vita.png");
  pausa = loadImage("./img/pausa.png");
  prova = loadImage("./img/pausa.png");
  gameOver = loadImage("./img/gameOver.webp");
  schermataVittoria = loadImage("./img/schermataVittoria.avif");
  schermataIniziale = loadImage("./img/schermataIniziale2.png");
  schermataTutorial = loadImage("./img/schermataTutorial.png");
  schermataLivelli = loadImage("./img/schermataLivelli.png");
  
  bitFont = loadFont('./font/Micro5-Regular.ttf');

  soundFormats('mp3', 'ogg');
  soundMonete = loadSound('./sound/soundMonete.mp3');
  soundJump = loadSound('./sound/soundJump.mp3');
  soundClickMouse = loadSound('./sound/soundClickMouse.mp3');
  soundFineLivello = loadSound('./sound/soundPassaggioLivello.mp3');
  soundPerditaVita = loadSound('./sound/soundPerditaVita.mp3');
  soundMorte = loadSound('./sound/soundMorte.mp3');
  soundSottofondo = loadSound('./sound/soundSottofondo.mp3');
}

function setXbandiera(newX) { xBandiera = newX }
function setYbandiera(newY) { yBandiera = newY }
function setGravity(newGravity) { gravity = newGravity }
function getXbandiera() { return xBandiera }
function getYbandiera() { return yBandiera }
function getGravity() { return gravity }

function setup() {
  createCanvas(1250, 650);
  frameRate(80)
  background(schermataIniziale);
  schermataTemporanea = schermataIniziale;

  button1 = createButton(''); 
  button1.position(55, 380);
  button1.size(522, 170);
  button1.style('background-color', 'rgba(0,0,0,0)');
  button1.style('border', '0px');
  button1.mousePressed(button1Pressed);

  button2 = createButton('');
  button2.position(695, 380);
  button2.size(522, 170);
  button2.style('background-color', 'rgba(0,0,0,0)');
  button2.style('border', '0px');
  button2.mousePressed(button2Pressed);

  hearts.push(new Vite(1200, 20))
  hearts.push(new Vite(1160, 20))
  hearts.push(new Vite(1120, 20))

  textFont(bitFont);
  bandiera.resize(50, 50);
  pausa.resize(50, 50);
  vittoria.resize(50, 50)
}

function button1Pressed() { //seconda pagina
  soundClickMouse.play()
  schermataIniziale = schermataLivelli;
  button1.hide();
  button2.hide();
  createSecondScreenButtons(); // Crea i bottoni della seconda schermata quando viene aperta
  secondScreenVisible = true; // Imposta lo stato della seconda schermata come visibile
  draw()
}

function button2Pressed() { //schermata tutorial istruzioni
  soundClickMouse.play()
  tutorial = true
  resetGame()
  schermataIniziale = schermataVittoria;
  setUpIstruction()

  pavimentoSelezionato = pavimentoTutorial //da cambiare con pavimento tutorial
  player = new Player();
  gameState = "playing"
  draw()
  button1.hide();
  button2.hide();
  backButton = createButton('');
  backButton.position(860, 220);
  backButton.size(285, 90);
  backButton.style('background-color', 'rgba(0,0,0,0)');
  backButton.style('border', '0px');
  backButton.mousePressed(backButtonPressed);
}

function backButtonPressed() { //ritorno all'home
  soundClickMouse.play()
  resetGame()
  tutorial = false
  backButton.remove(); // Rimuovi il pulsante "Back"
  schermataIniziale = schermataTemporanea
  button1.show();
  button2.show();
  gameState = "start"; // Torna allo stato iniziale
  loop()
}

function setUpLevelTerra() {
  soundClickMouse.play()
  setUpElementsTerra()
  setGravity(0.6)
  setXbandiera(1150)
  setYbandiera(360)
  sfondoScelto = sfondoTerra
  gameState = "playing"
  pavimentoSelezionato = pavimentoTerra
  soundSottofondo.play()
  player = new Player();
  draw()
}

function setUpLevelLuna() {
  soundClickMouse.play()
  setUpElementsLuna()
  setGravity(0.4)
  setXbandiera(1200)
  setYbandiera(480)
  sfondoScelto = sfondoLuna
  gameState = "playing"
  pavimentoSelezionato = pavimentoLuna
  //soundSottofondo.play()
  player = new Player();
  draw()
}

function setUpLevelGiove() {
  soundClickMouse.play()
  setUpElementsGiove()
  setGravity(0.3)
  setXbandiera(1200)
  setYbandiera(320)
  sfondoScelto = sfondoGiove
  gameState = "playing"
  pavimentoSelezionato = pavimentoGiove
  //soundSottofondo.play()
  player = new Player();
  draw()
}

function createSecondScreenButtons() { //creazione bottoni seconda pagina
  for (let i = 0; i < 3; i++) {
    let button = createButton('');
    button.position(60 + i * 420, 285);
    button.size(300, 100); // Dimensioni dei bottoni
    button.style('background-color', 'rgba(0,0,0,0)');
    button.style('border', '0px');
    buttons.push(button); // Aggiungi il pulsante all'array
    button.mousePressed()
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

function setSoundSottoFondo(){
  soundSottofondo.play()
  sottoFondo = false
}

function draw() {
  background(schermataIniziale);
  if (secondScreenVisible) {
    for (let button of buttons) {
      button.show();
    }
  }
  if (gameState == "start") {
    background(schermataIniziale);
  } else if (gameState == "playing") {
    //if(sottoFondo == true){
      //setSoundSottoFondo()
    //}
    for (let button of buttons){
      button.hide()
    }
    if (pausatime == true) {
      breakWindows()
    } else {
      if(tutorial == false){
        background(sfondoScelto);
        image(bandiera, getXbandiera(), getYbandiera());
        image(pausa, 250, 10)
      }
      else{
        background(schermataTutorial)
      }
      for (let k = 0; k < width; k += 50) {
        pavimentoSelezionato.resize(50, 50);
        image(pavimentoSelezionato, k, 600);
      }
      for (let platform of platforms) {
        platform.show();
      }
      for (let bot of bots) {
        bot.show()
      }
      for (let money of moneys) {
        money.show()
      }
      for (let heart of hearts) {
        heart.show()
      }
      player.show();
      player.update();
      checkCollision();

      if (tutorial == false) {
        fill(255);
        textSize(50);
        text("PUNTEGGIO: " + punteggio, 35, 35);
      } else {
        fill(255);
        textSize(100);
        text("TUTORIAL - ISTRUZIONI", 50, 100);
      }
      if (vite == 1) {
        gameOverWindow()
      }
      if (vittoria == true) {
        winWindow()
        /*
        //setTimeout(() => { winWindow() }, 1500);
        gameState == "start"
        pausatime == false
        resetGame()
        setUp()
        draw()
        //setTimeout(() => { draw() }, 1500);
        */
      }
    }
  }
  followMouse()
}


function istruction() {
  background(20)
}

function followMouse() {
  fill("blue")
  ellipse(mouseX, mouseY, 10, 10);
}

function breakWindows() {
  let d = dist(mouseX, mouseY, 500, 30);
  background(sfondoTerra);
  fill(0, 150); // Opaco nero
  rect(0, 0, width, height);
  fill(255); // Testo bianco
  textSize(28);
  text("PAUSA", width / 2, height / 2);
  prova.resize(30, 30);
  image(prova, 500, 30)
  if (d < 30) {
    pausatime = false
  }
}

function gameOverWindow() {
  background(gameOver);
  fill(255);
  text("SCORE: " + punteggio, width / 2 - 50, height / 2 - 180);
  //text("Play againg: touch R")
  noLoop()
}

function winWindow() {
  background(schermataVittoria);
  fill(255)
  text("SCORE: " + punteggio, width / 2 - 50, height / 2 - 180);
  //noLoop();
}

function checkCollision() {
  for (let platform of platforms) {
    const indicePiattaforma = platforms.indexOf(platform);
    if (player.hitsUnder(platform)) {
      if (numSalti == 2) { //risoluzione bug su doppio salto
        player.ySpeed = 0;
        player.y = player.y + 1;
      } else {
        player.ySpeed = 0;
      }
    }

    if (player.hits(platform)) {
      player.ySpeed = 0; // Imposta la velocità verticale a zero
      player.y = platform.y - player.height;
      numSalti = 0;
      if (platform.getType() == 1 && !platform.getStato()) {  //per rimuovere blocco sabbia
        setTimeout(() => { platforms.splice(indicePiattaforma, 1) }, 500); //millesimi secondi 
        platform.setStato(true)
      }
    }

    if (player.hitsSideRight(platform)) {
      player.xSpeed = 0;
      colpitoRight = true
    }

    if (player.hitsSideLeft(platform)) {
      player.xSpeed = 0;
      colpitoLeft = true
    }
  }
  for (let bot of bots) {
    if (bot.hitsBot(player)) {
      soundPerditaVita.play()
      player.y = 100;
      player.x = 100
      vite -= 1;
      if (vite != 0)
        hearts.pop(hearts[-1])
    }
  }
  //collisioni con le monete
  for (let i = 0; i < moneys.length; i++) {
    let money = moneys[i];
    if (money.hitsMoney(player)) {
      soundMonete.play()
      punteggio++;
      moneys.splice(i, 1);
      i--;
    }
  }
  //morte per tocco di pavimento
  if (player.y == height - 70) {
    soundPerditaVita.play()
    player.y = 100;
    player.x = 100;
    vite--;
    if (vite != 0)
      hearts.pop(hearts[-1])
  }
  //tocco bandiera -> vittoria 
  if (player.x >= getXbandiera() && player.x <= (getXbandiera() + 50) && player.y >= getYbandiera() && player.y <= (getYbandiera() + 50)) {
    bandiera = vittoria;
    setTimeout(() => { vittoria = true }, 1500);
  }
}

function keyPressed() {
  if (key == 'a' && colpitoLeft == false) {
    colpitoRight = false
    player.setDirection(-1); // Set direzione sinistra
  } else if (key == 'd' && colpitoRight == false) {
    player.setDirection(1); // Set direzione destra
    colpitoLeft = true
  } else if (key == 'w' && numSalti < 2) {
    soundJump.play()
    colpitoRight = false
    colpitoLeft = true
    player.jump(-9);
    numSalti++;
  } else if (key == 'r') {
    resetGame()
    preload()
    setUpLevelLuna()
    draw()
  }
}

function keyReleased() {
  if (key == 'a' || key == 'd') {
    player.setDirection(0); // stoppa il movimento dell'oggetto se i tasti sono rilasciati
    colpitoLeft = false;
    colpitoRight = false;
  }
}

function mouseClicked() {
  let d = dist(mouseX, mouseY, 300, 30);
  if (d < 30) {
    pausatime = !pausatime
  }
}

function resetGame() {
  player = new Player(); platforms = []; bots = []; moneys = []; hearts = []; numSalti = 0; punteggio = 0;
  vite = 4; colpitoRight = false; colpitoLeft = false; vittoria = false; rimossaPiattaforma = false;
  win = false; restart = true
}
