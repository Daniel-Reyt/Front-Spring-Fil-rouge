function getCanvasWithSquare(data) {
    const canvas = document.querySelector('canvas');
    var ctx = canvas.getContext('2d');

    ctx.fillStyle = data.color;
    ctx.fillRect(data.posX, data.posY, data.width, data.width)
    ctx.stroke();
}
function getCanvasWithRect(data) {
    const canvas = document.querySelector('canvas');
    var ctx = canvas.getContext('2d');

    ctx.fillStyle = data.color;
    ctx.fillRect(data.posX, data.posY, data.width, data.length)
    ctx.stroke();
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
            })
        })
        .catch(err => {
            console.log(err)
        })
}

function deleteAllShape() {
    fetch('http://localhost:8888/shapes', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'Accept': "*/*"
        }
    })
        .then(response => {
            return response.statusText;
        })
        .catch(err => {
            console.log(err)
        })
}
