
let externalElement = document.getElementById("external");
externalElement.onclick = () => {
    externalElement.innerHTML = "External Change";
}

function externalFunc(element) {
    element.innerHTML = "External Change with onclick attribute"
}