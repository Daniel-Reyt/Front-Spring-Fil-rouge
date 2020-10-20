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
                console.log(data)
                if (userName === "daniel") {
                    if (data.username === "daniel") {
                        window.location.replace("http://localhost:8888/shapes")
                    }
                }
                if (userName === "admin") {
                    if (data.username === "admin") {
                        window.location.replace("http://localhost:8888/shapes")
                    }
                } else {
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
                console.log(data)
                if (userName === "daniel") {
                    if (data.username === "daniel") {
                        window.location.replace("http://localhost:8888/h2-console")
                    }
                }
                if (userName === "admin") {
                    if (data.username === "admin") {
                        window.location.replace("http://localhost:8888/h2-console")
                    }
                } else {
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
            if (userName === "daniel") {
                if (data.username === "daniel") {
                    window.location.replace("http://localhost:8888/canvas")
                }
            }
            if (userName === "admin") {
                if (data.username === "admin") {
                    window.location.replace("http://localhost:8888/canvas")
                }
            } else {
                console.warn("vous n'avez pas accès a l'API")
            }
        })
    })
}
function redirectToCanvas() {
    verifyUserForCanvas()
}
