let isAdmin = false;

const canvas = document.querySelector('canvas');
canvas.width = 1000;
canvas.height = 600;

var ctx = canvas.getContext('2d');

function getCanvasWithSquare(data) {

    ctx.fillStyle = data.color;
    ctx.fillRect(data.posX, data.posY, data.width, data.width)
    ctx.stroke();
}
function getCanvasWithRect(data) {
    ctx.fillStyle = data.color;
    ctx.fillRect(data.posX, data.posY, data.width, data.length)
    ctx.stroke();
}
function getCanvasWithCircle(data) {
    ctx.fillStyle = data.color;
    ctx.arc(data.posX, data.posY, data.rayon, 0, 2 * Math.PI)
    ctx.fill();
}
function getCanvasWithTriangle(data) {
    ctx.beginPath();
    ctx.moveTo(data.aPosX, data.aPosY)
    ctx.lineTo(data.bPosX, data.bPosY)
    ctx.lineTo(data.cPosX, data.cPosY)
    ctx.closePath();

    ctx.lineWidth = 2;
    ctx.stroke();

    ctx.fillStyle = data.color;
    ctx.fill();
}
function getAllShape() {
    fetch('http://localhost:8888/shapes', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Accept': "*/*"
        }
    })
        .then(response => {
            return response.json();
        })
        .then(function (data) {
            data.forEach(function (data) {
                if (data.shapeType === "square") {
                    console.log(data.id + ' as pour taille : ' + data.width + ' cm, position x : ' + data.posX + ', pour position Y : ' + data.posY + ', de couleur : ' + data.color + ', son types est : ' + data.shapeType);
                    getCanvasWithSquare(data);
                }
                if (data.shapeType === "rectangle") {
                    console.log(data.id + ' as pour longueur : ' + data.width + ' cm, et pour largeur : ' + data.length + ' cm, pour position x : ' + data.posX + ', pour position Y : ' + data.posY + ', de couleur : ' + data.color + ', son types est : ' + data.shapeType);
                    getCanvasWithRect(data)
                }
                if (data.shapeType === 'circle') {
                    console.log(data.id + ' as pour rayon : ' + data.rayon + ' cm, pour position x : ' + data.posX + ', pour position Y : ' + data.posY + ', de couleur : ' + data.color + ', son types est : ' + data.shapeType)
                    getCanvasWithCircle(data)
                }
                if (data.shapeType === 'triangle') {
                    console.log(data.id + ' est de couleur : ' + data.color + ', son types est : ' + data.shapeType + "la position du point A est x : " + data.aPosX + ", y : " + data.aPosY + "la position du point B est x : " + data.bPosX + ", y : " + data.bPosY +"la position du point C est x : " + data.cPosX + ", y : " + data.cPosY)

                    getCanvasWithTriangle(data);
                }
                isAdmin = true;
            })
        })
        .catch(err => {
            console.log(err)
        })
}

function deleteAllShape() {
    if (isAdmin === true) {
        fetch('http://localhost:8888/shapes', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Accept': "*/*"
            }
        })
            .then(response => {
                return response.statusText;
                let canvas = document.querySelector('canvas');
                var ctx = canvas.getContext('2d');
                ctx.clearRect()
            })
            .catch(err => {
                console.log(err)
            })
    } else {
        console.warn("vous n'avez pas accès a cette route")
    }
}
