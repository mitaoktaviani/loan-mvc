// Get the modal
var modal = document.getElementsByClassName("myModal2");

// Get the button that opens the modal
var btn = document.getElementsByClassName("myBtn2");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close");

for (let i = 0; i < btn.length; i++) {
    btn[i].onclick = function() {
        for (let j = 0; j < modal.length; j++) {
            if (i == j) {
                modal[j].style.display = "block";
            }
        }
    }
}

for (let x = 0; x < span.length; x++) {
    span[x].onclick = function() {
        for (let y = 0; y < modal.length; y++) {
            if (x == y) {
                modal[y].style.display = "none";
            }
        }
    }

}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

