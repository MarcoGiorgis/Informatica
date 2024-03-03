/*
let bgimg;
let omino;
let x = 600;
let y = 250;
let currentImg;
let currentImg2;
let spostamento = 10

function preload() {
    omino = loadImage("./img/sfondo.jpg");
    bgimg = loadImage("./img/sfondo1.jpg");
    sfondo = loadImage("./img/sfondo.jpg");
    omino_morto = loadImage("./img/sfondo1.jpg");
}

function setup() {
    createCanvas(1000, 550);
    frameRate(60);
    currentImg = omino;
    currentImg2 = bgimg;
}

function draw() {
    background(currentImg2);
    currentImg.resize(300, 300);
    image(currentImg, x, y);
    ellipse(x, y, 50, 50)
    if(x == 700 || x == 0){
        spostamento = spostamento * -1;
        x += spostamento;
    } else {
        x += spostamento;
    }
    followMouse()
}

function mouseClicked() {
    let d = dist(mouseX, mouseY, x, y);
    if (d < 50) {
        if (currentImg === omino) {
            currentImg = omino_morto;
        } else {
            currentImg = omino;
        }
    }
}

function keyPressed() {
    if (key == ' ') {
        if(currentImg2 == sfondo){
            currentImg2 = bgimg
        }else{
            currentImg2 = sfondo;
        }
    }
}

function followMouse(){
    fill("red")
    ellipse(mouseX, mouseY, 20, 20);
}

let mySound;
function preload() {
  soundFormats('mp3', 'ogg');
  mySound = loadSound('./1.mp3');
}

function setup() {
  let cnv = createCanvas(100, 100);
  cnv.mousePressed(canvasPressed);
  background(220);
  text('tap here to play', 10, 20);
}

function canvasPressed() {
  // playing a sound file on a user gesture
  // is equivalent to `userStartAudio()`
  mySound.play();
}
*/

let img, img2;
let button1, button2;
let secondScreenVisible = false; // Variabile per tenere traccia dello stato della seconda schermata
let buttonsSecondScreen = []; // Array per memorizzare i bottoni della seconda schermata

function preload() {
    img = loadImage('./img/sfondo.jpg');
    img2 = loadImage("./img/sfondo1.jpg");
}

function setup() {
    createCanvas(1400, 800);

    button1 = createButton('');
    button1.position(420, 325);
    button1.size(522, 105);
    button1.style('background-color', 'rgba(0,0,0,0)');
    button1.style('border', '2px solid rgba(255,255,255,0.5)');
    button1.mousePressed(button1Pressed);

    button2 = createButton('');
    button2.position(430, 510);
    button2.size(522, 105);
    button2.style('background-color', 'rgba(0,0,0,0)');
    button2.style('border', '2px solid rgba(255,255,255,0.5)');
    button2.mousePressed(button2Pressed);
}

function draw() {
    image(img, 0, 0, width, height);

    // Mostra i bottoni della seconda schermata se la seconda schermata è visibile
    if (secondScreenVisible) {
        for (let button of buttonsSecondScreen) {
            button.show();
        }
    }
}

function button1Pressed() {
    img = img2;
    button1.hide();
    button2.hide();
    createSecondScreenButtons(); // Crea i bottoni della seconda schermata quando viene aperta
    createSecondScreenButtonsRight();
    secondScreenVisible = true; // Imposta lo stato della seconda schermata come visibile
    console.log("Button 1 Pressed");
}

function button2Pressed() {
    console.log("Button 2 Pressed");
}

function mousePressed() {
    // Ridimensiona leggermente la seconda immagine
    img2.resize(img2.width * 0.9, img2.height * 0.9);
}

// Funzione per creare i bottoni della seconda schermata
function createSecondScreenButtons() {
    for (let i = 0; i < 3; i++) {
        let button = createButton('');
        button.position(125, 221 + i * 168); // Incrementa lo spazio verticale tra i bottoni
        button.size(430, 100); // Dimensioni dei bottoni
        button.style('background-color', 'rgba(0,0,0,0)');
        button.style('border', '2px solid rgba(255,255,255,0.5)');
        buttonsSecondScreen.push(button); // Aggiungi il pulsante all'array
        button.mousePressed(() => console.log("Button " + (i + 1) + " Pressed"));
    }
}

// Funzione per creare i bottoni della seconda schermata a destra
function createSecondScreenButtonsRight() {
    for (let i = 0; i < 3; i++) {
        let button = createButton(''); // Inizia la numerazione dei pulsanti da 4
        button.position(855, 221 + i * 168); // Sposta i bottoni più a destra
        button.size(430, 100); // Dimensioni dei bottoni
        button.style('background-color', 'rgba(0,0,0,0)');
        button.style('border', '2px solid rgba(255,255,255,0.5)');
        buttonsSecondScreen.push(button); // Aggiungi il pulsante all'array
        button.mousePressed(() => console.log("Button " + (i + 4) + " Pressed"));
    }
}