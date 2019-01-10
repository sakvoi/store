
function showAddress(){
	var gprovince=[];
	var gcity=[];
	var garea=[];
	var ginput=[];
	var g_pro = document.getElementById("s_p").value;
	var g_city = document.getElementById("s_c").value;
	var g_area = document.getElementById("s_a").value;
	var g_input = document.getElementById("x_address").value;
	for (var p=0;p<g_pro.length;p++) {
		gprovince.push(g_pro[p]);
	}
	gprovince.push("-")
	for(var c=0;c<g_city.length;c++){
		gcity.push(g_city[c]);
	}
	gcity.push("-");
	for (var a=0;a<g_area.length;a++) {
		garea.push(g_area[a]);
	}
	garea.push("-")
	for (var intxt=0;intxt<g_input.length;intxt++) {
		ginput.push(g_input[intxt]);
	}
	document.getElementById("p").innerHTML=gprovince.join("");
	document.getElementById("c").innerHTML=gcity.join("");
	document.getElementById("a").innerHTML=garea.join("");
	document.getElementById("xd").innerHTML=ginput.join("")
}
