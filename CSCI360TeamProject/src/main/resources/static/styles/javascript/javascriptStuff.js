function openMenu() {
    var element = document.getElementById("menuPopup")
    if(element.style.display === "none") {
        element.style.display = "block";
    }
    else {
        element.style.display = "none";
    }
}