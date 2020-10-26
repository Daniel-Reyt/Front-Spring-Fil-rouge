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
    fetch('http://10.3.1.62:8888/shapes', {
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
        fetch('http://10.3.1.62:8888/shapes', {
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

function switchCanvasTheme() {
    let body = document.querySelector("body");
    let image = document.getElementById("switchImage");

    if (body.style.backgroundColor === "white") {
        body.style.backgroundColor = "black";
        image.setAttribute("src", "https://lh3.googleusercontent.com/proxy/wLgcn1wHqufH36UOoxWHYf8wcDEl8QDESciyzadYyFWAHyy0Wwb6BfVoXlMGHOh7SXKlqrJ2wInpV7Vw6fKk28xDcqgAnPMs");
        image.setAttribute("alt", "thème sombre")
    } else if (body.style.backgroundColor === "black") {
        body.style.backgroundColor = "white";
        image.setAttribute("src", "https://static.thenounproject.com/png/595-200.png");
        image.setAttribute("alt", "thème clair")
    }
}

function switchIndexTheme() {
    let body = document.querySelector("body");
    let image = document.getElementById("switchImage");

    if (body.style.backgroundColor === "white") {
        body.style.backgroundColor = "black";
        image.setAttribute("src", "https://lh3.googleusercontent.com/proxy/wLgcn1wHqufH36UOoxWHYf8wcDEl8QDESciyzadYyFWAHyy0Wwb6BfVoXlMGHOh7SXKlqrJ2wInpV7Vw6fKk28xDcqgAnPMs");
        image.setAttribute("alt", "thème sombre")
    } else if (body.style.backgroundColor === "black") {
        body.style.backgroundColor = "white";
        image.setAttribute("src", "https://static.thenounproject.com/png/595-200.png");
        image.setAttribute("alt", "thème clair")
    }
}
