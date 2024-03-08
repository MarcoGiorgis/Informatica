class Player {
    constructor() {
        this.width = 20;
        this.height = 20;
        this.x = 100;
        this.y = 100;
        this.xSpeed = 0; //velocità orizozntale
        this.ySpeed = 0; //velocità jump
        this.gravity = getGravity();
    }

    show() {
        fill(255, 0, 0);
        rect(this.x, this.y, this.width, this.height);
    }

    update() { //aggiorna le posizioni x e y 
        this.x += this.xSpeed;
        this.ySpeed += this.gravity;
        this.y += this.ySpeed;
        this.x = constrain(this.x, 0, width - 20); //capire
        this.y = constrain(this.y, 0, height - 70);
    }

    jump(alt) {
        this.ySpeed = alt;
    }

    setDirection(direction) {
        this.xSpeed = 5 * direction;
    }

    hits(platform) {
        return (
            this.x < platform.x + platform.width &&
            this.x + this.width > platform.x &&
            this.y < platform.y + platform.height - 20 &&
            this.y + this.height > platform.y
        );
    }

    hitsUnder(platform) {
        return (
            this.x < platform.x + platform.width &&
            this.x + this.width > platform.x &&
            this.y < platform.y + platform.height + 2 &&
            this.y + this.height > platform.y
        );
    }

    hitsSideRight(platform) {
        return (
            this.x + this.width == platform.x &&
            this.y <= platform.y + platform.height &&
            this.y + this.height > platform.y
        );
    }

    hitsSideLeft(platform) {
        return (
            this.x == platform.x + platform.width &&
            this.y < platform.y + platform.height &&
            this.y + this.height > platform.y
        );
    }
}

class Platform {
    constructor(x, y, w, h, image, type) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.image = image;
        this.type = type; //0 se è blocco normale 1 per sabbia
        this.rimossa = false; //stato rimozione blocco
    }
    getType() { return this.type }
    getStato() { return this.rimossa }
    setStato(stato) { this.rimossa = stato }

    show() {
        this.image.resize(40, 40)
        for (let k = this.x; k < this.x + this.width; k += 40) {
            for (let j = this.y; j < this.y + this.height; j += 40) {
                image(this.image, k, j);
            }
        }
    }
}

class Bot {
    constructor(x, y, limD, limS, spostamento) {
        this.x = x;
        this.y = y;
        this.dim = 20;
        this.limD = limD;
        this.limS = limS;
        this.spostamento = spostamento;
    }
    
    show() {
        fill(255, 255, 255);
        rect(this.x, this.y, this.dim, this.dim);
        if (this.x == this.limD || this.x == this.limS) {
            this.spostamento = this.spostamento * -1;
            this.x += this.spostamento;
        } else {
            this.x += this.spostamento;
        }
    }
    
    hitsBot(player) {
        return (
            (this.x >= player.x && this.x <= player.x + player.width) ||
            (this.x + this.dim >= player.x && this.x + this.dim <= player.x + player.width)
        ) && this.y == player.y;
    }
}

class Money {
    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.dim = 25;
        this.image = moneta;
    }

    show() {
        this.image.resize(this.dim, this.dim);
        image(this.image, this.x, this.y);
    }

    hitsMoney(player) {
        return (player.x >= this.x && player.x <= this.x + this.dim &&
            player.y >= this.y && player.y <= this.y + this.dim)
    }
}

class Vite {
    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.dim = 40;
        this.image = cuore;
    }
    show() {
        this.image.resize(this.dim, this.dim);
        image(this.image, this.x, this.y);
    }
}