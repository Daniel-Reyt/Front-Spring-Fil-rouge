function getCanvas(data) {
    const canvas = document.querySelector('canvas');
    var ctx = canvas.getContext('2d');

    ctx.fillRect(data.posX, data.posY, data.width, data.width)
    ctx.save();
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
                console.log(data.id + ' as pour taille : ' + data.width + ' cm, position x : ' + data.posX + ', pour position Y : ' + data.posY);
                getCanvas(data);
            })
        })
        .catch(err => {
            console.log(err)
        })
}
