var a = document.querySelectorAll("span");
console.log(a);

for (let index = 0; index < a.length; index++) {
  const element = a[index];
  element.addEventListener("mouseover", checkedStar, false);
  element.addEventListener("click", checkedStar, false);
  // element.addEventListener("mouseout", uncheckStar, false);
}

function checkedStar(e) {
  uncheckStar();
  let current = parseInt(e.srcElement.getAttribute("pos"));

  for (let index = 0; index < current; index++) {
    const element = a[index];
    element.className = "fa fa-star stars checked";
  }
}

function uncheckStar() {
  for (let index = 0; index < a.length; index++) {
    const element = a[index];
    element.className = "fa fa-star stars unchecked";
  }
}

function setValue(e) {
  let current = parseInt(e.srcElement.getAttribute("pos"));

  document.getElementById("value").value = current;
}

// var stars = document.getElementsByTagName("span");
a.forEach(element => {
  element.addEventListener("click", setValue, false);
});
