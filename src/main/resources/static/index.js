
function verifyUserForShape() {
    Swal.fire({
        title: "veuillez renseigner votre pseudo",
        html:  "<form class='form-group' id='form-group'>" +
            "<input name='userName' id='userName' type='text' placeholder='merci de renseigner votre pseudo' class='form-control'> <br>" +
            "<button type='button' onclick='verifyDataForShape()' class='btn btn-primary'>Submit</button>" +
            "</form>",
        showConfirmButton: false
    })
}
function verifyDataForShape() {
    const userName = document.getElementById('userName').value;
    fetch('http://localhost:8888/user', {
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
                if (userName === data.username) {
                    window.location.replace("http://localhost:8888/shapes")
                } else if (!(userName === data.username)) {
                    console.warn("vous n'avez pas accès a l'API")
                }
            })
        })
}
function redirectToShape() {
    verifyUserForShape()
}
function verifyUserForH2() {
    Swal.fire({
        title: "veuillez renseigner votre pseudo",
        html:  "<form class='form-group' id='form-group'>" +
            "<input name='userName' id='userName' type='text' placeholder='merci de renseigner votre pseudo' class='form-control'> <br>" +
            "<button type='button' onclick='verifyDataForH2()' class='btn btn-primary'>Submit</button>" +
            "</form>",
        showConfirmButton: false
    })
}
function verifyDataForH2() {
    const userName = document.getElementById('userName').value;
    fetch('http://localhost:8888/user', {
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
                if (userName === data.username) {
                    window.location.replace("http://localhost:8888/h2-console")
                } else if (!(userName === data.username)) {
                    console.warn("vous n'avez pas accès a l'API")
                }
            })
        })
}
function redirectToH2() {
    verifyUserForH2()
}
function verifyUserForCanvas() {
    Swal.fire({
        title: "veuillez renseigner votre pseudo",
        html:  "<form class='form-group' id='form-group'>" +
            "<input name='userName' id='userName' type='text' placeholder='merci de renseigner votre pseudo' class='form-control'> <br>" +
            "<button type='button' onclick='verifyDataForCanvas()' class='btn btn-primary'>Submit</button>" +
            "</form>",
        showConfirmButton: false
    })
}
function verifyDataForCanvas() {
    const userName = document.getElementById('userName').value;
    fetch('http://localhost:8888/user', {
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
            if (userName === data.username) {
                window.location.replace("http://localhost:8888/canvas")
            } else if (!(userName === data.username)) {
                console.warn("vous n'avez pas accès a l'API")
            }
        })
    })
}
function redirectToCanvas() {
    verifyUserForCanvas()
}

function createCanvas() {
    swal.fire({
        title: "Créer un canvas",
        html:  "<form class='form-group' id='form-group'>" +
                "<input name='nameCanvas' id='nameCanvas' type='text' placeholder='merci de renseigner le nom du canvas' class='form-control'> <br>" +
                "<button type='button' onclick='addCanvas()' class='btn btn-primary'>Submit</button>" +
                "</form>",
    })
}
function addCanvas() {
    const canvasName = document.getElementById('nameCanvas').value;

    fetch('http://localhost:8888/draw', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': "*/*"
        },
        body: JSON.stringify({
            "name": canvasName,
        })
    })
        .then(response => {
            console.log(response)
        })
        .catch(err => {
            console.log(err)
        })}
