function preload() {
  gameMap = loadTable('./maps/percorso.csv', 'csv', 'header');
}

function setup() {
  createCanvas(1250, 650);
  frameRate(60)
  setupGameElements()
}

function setupGameElements() {
  cellX = 0;
  cellY = 0;

  for (let i = 0; i < gameMap.getRowCount(); i++) {
    for (let j = 0; j < gameMap.getColumnCount(); j++) {
      cellX = j * dimPiattaforma; 
      cellY = i * dimPiattaforma;

      switch (gameMap.getNum(i, j)) {
        case 7:
          contI = 1;
          contJ = 1;
          tempJ = j + 1;
          tempI = i + 1;
          while ((contJ < gameMap.getColumnCount() && gameMap.getNum(i, tempJ) == -7)) {
            contJ++;
            tempJ++;
          }
          while (contI < gameMap.getRowCount() && gameMap.getNum(tempI, j) == -7) {
            contI++;
            tempI++;
          }
          platforms.push(new Platform(cellX, cellY, contJ * dimPiattaforma, contI * dimPiattaforma));
          break;
      }
    }
  }
}
/*
+0,+0,+0,+0,+0,+0,+0,+0,+0,+0
+0,+0,+0,+0,+0,+0,+0,+0,+0,+0
+0,+0,+0,+0,+0,+0,+0,+0,+0,+0
+0,+0,+7,-7,-7,-7,-7,+0,+0,+0
+0,+0,-7,-7,-7,-7,-7,+0,+0,+0
+0,+0,-7,-7,-7,-7,-7,+0,+0,+0
+0,+0,-7,-7,-7,-7,-7,+7,-7,+0
+0,+0,-7,-7,-7,-7,-7,-7,-7,+0
+0,+0,-7,-7,-7,-7,-7,-7,-7,+0
+0,+0,+0,-7,-7,-7,-7,-7,-7,+0
+0,+0,+0,+0,+0,+0,+0,+0,+0,+0
*/