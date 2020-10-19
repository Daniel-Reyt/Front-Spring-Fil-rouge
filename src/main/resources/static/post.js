function addCarre() {
    Swal.fire({
        title: "Créer un carré :",
        icon: "success",
        html: "<form class='form-group' id='form-group'>" +
            "<input name='size' id='size' type='number' placeholder='merci de rentrer la taille du carré' class='form-control'> <br>" +
            "<input name='posX' id='posX' type='number' placeholder='merci de rentrer la position X du carré' class='form-control'> <br>" +
            "<input name='posY' id='posY' type='number' placeholder='merci de rentrer la position Y du carré' class='form-control'> <br>" +
            "<input name='color' id='color' type='color' placeholder='merci de rentrer la couleur du carré' class='form-control'> <br>" +
            "<button onclick='addSq()' class='btn btn-primary'>Submit</button>" +
            "</form>",
        showConfirmButton: false,
    })
}
function addSq() {
    const sizeS = document.getElementById('size').value;
    const posX = document.getElementById('posX').value;
    const posY = document.getElementById('posY').value;
    const color = document.getElementById('color').value;


    fetch('http://localhost:8888/square', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': "*/*"
        },
        body: JSON.stringify({
            "color": color,
            "posX": posX,
            "posY": posY,
            "width": sizeS,
            "shapeType": 'square'
        })
    })
        .then(response => {
            console.log(response)
        })
        .catch(err => {
            console.log(err)
        })
}
 function Rectangle() {
     Swal.fire({
         title: "Créer un Rectangle :",
         icon: "success",
         html: "<form class='form-group' id='form-group'>" +
             "<input name='longeur' id='longeur' type='number' placeholder='merci de rentrer la longeur du rectangle' class='form-control'> <br>" +
             "<input name='largeur' id='largeur' type='number' placeholder='merci de rentrer la largeur du rectangle' class='form-control'> <br>" +
             "<input name='posX' id='posX' type='number' placeholder='merci de rentrer la position X du carré' class='form-control'> <br>" +
             "<input name='posY' id='posY' type='number' placeholder='merci de rentrer la position Y du carré' class='form-control'> <br>" +
             "<input name='color' id='color' type='color' placeholder='merci de rentrer la couleur du carré' class='form-control'> <br>" +
             "<button type='button' onclick='addRec()' class='btn btn-primary'>Submit</button>" +
             "</form>",
         showConfirmButton: false,
     })
 }
 function addRec() {
     const longeurR = document.getElementById('longeur').value;
     const largeurR = document.getElementById('largeur').value;
     const posX = document.getElementById('posX').value;
     const posY = document.getElementById('posY').value;
     const color = document.getElementById('color').value;

     fetch('http://localhost:8888/rectangle', {
         method: 'POST',
         headers: {
             'Content-Type': 'application/json',
             'Accept': "*/*"
         },
         body: JSON.stringify({
             "length": longeurR,
             "width": largeurR,
             "posX": posX,
             "posY": posY,
             "color": color,
             "shapeType": 'rectangle'
         })
     })
         .then(response => {
             console.log(response)
         })
         .catch(err => {
             console.log(err)
         })
 }
//  function circle() {
//      Swal.fire({
//          title: "Créer un cercle :",
//          icon: "success",
//          html:  "<form class='form-group'>" +
//              "<input name='rayon' id='rayon' type='number' placeholder='merci de rentrer la rayon du cercle' class='form-control'> <br>" +
//              "<input name='name' id='name' type='text' placeholder='merci de rentrer le nom du cercle' class='form-control'> <br>" +
//              "<button onclick='addCir()' class='btn btn-primary'>Submit</button>" +
//              "</form>",
//          showConfirmButton: false,
//      })
//  }
//  function addCir() {
//      const rayonC = document.getElementById('rayon').value;
//      const nameC = document.getElementById('name').value;
//
//
//      fetch('http://localhost:8888/circle', {
//      method: 'POST',
//      headers: {
//          'Content-Type': 'application/json',
//          'Accept': "*/*"
//      },
//      body: JSON.stringify({
//          "rayon": rayonC,
//          "name": nameC
//      })
//  })
//      .then(response => {
//          console.log(response)
//      })
//      .catch(err => {
//          console.log(err)
//      })
//  }
// function Triangle() {
//      Swal.fire({
//          title: "Créer un triangle :",
//          icon: "success",
//          html:  "<form class='form-group'>" +
//              "<input name='sizeA' id='sizeA' type='number' placeholder='merci de rentrer la taille du côté A' class='form-control'> <br>" +
//              "<input name='sizeB' id='sizeB' type='number' placeholder='merci de rentrer la taille du côté B' class='form-control'> <br>" +
//              "<input name='sizeC' id='sizeC' type='number' placeholder='merci de rentrer la taille du côté C' class='form-control'> <br>" +
//
//              "<input name='name' id='name' type='text' placeholder='merci de rentrer le nom du triangle' class='form-control'> <br>" +
//              "<button onclick='addTri()' class='btn btn-primary'>Submit</button>" +
//              "</form>",
//      });
//  }
//  function addTri() {
//      const sizeA = document.getElementById('sizeA').value;
//      const sizeB = document.getElementById('sizeB').value;
//      const sizeC = document.getElementById('sizeC').value;
//      const nameT = document.getElementById('name').value;
//
//      fetch('http://localhost:8888/triangle', {
//          method: 'POST',
//          headers: {
//              'Content-Type': 'application/json',
//              'Accept': "*/*"
//          },
//          body: JSON.stringify({
//              "sizeA": sizeA,
//              "sizeB": sizeB,
//              "sizeC": sizeC,
//              "name": nameT
//          })
//      })
//          .then(response => {
//              console.log(response)
//          })
//          .catch(err => {
//              console.log(err)
//          })
//  }
