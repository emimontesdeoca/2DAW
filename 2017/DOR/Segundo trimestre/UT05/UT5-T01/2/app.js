function iniciar(){
    document.getElementById("a").className = "gira";
     
     document.getElementById("a").addEventListener("transitionend",() => terminar("a","b"),false);
     document.getElementById("b").addEventListener("transitionend",() => terminar("b","c"),false);
     document.getElementById("c").addEventListener("transitionend",() => terminar("c","a"),false);  
   }
   
   function terminar(div1, div2){
     document.getElementById(div1).className = "nogira";   document.getElementById(div2).className = "gira";
   }
   
   function acabar(){
     document.querySelectorAll(".contenedor>div").forEach(ele => ele.className = "nogira");
   }
   
   