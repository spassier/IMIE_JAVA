/**
 * 
 */
/*
 * contentType : "application/json",
 * data : JSONStringify(obj)
 */

// Call lorsque le document est pret c'est a dire après son chargement
$(function() {
	var getMethod = function(){
	$.ajax({
			url : "http://localhost:8080/TP_REST2/RestService/Personnes",
			type : "GET",
			dataType : "json"
			}
		).done(function (data) {
			console.log(data);
			
			for ( var i = 0; i < data.length; i++)
			{
				$("#table").append("<tr id=\"tr" + data[i]["id"] + "\"><td>" + data[i]["nom"] + "</td><td>" + data[i]["prenom"] + "</td><td><button type=button id=" + data[i]["id"] + ">Delete</button></td><tr>");
				var idBtn = data[i]["id"];
				$("#" + idBtn).click(function(){
					$.ajax({
						url : "http://localhost:8080/TP_REST2/RestService/Personnes/" + idBtn,
						type : "DELETE"
						}
					).done(function (data) {
						$("#tr" + idBtn).remove();
					});
				});
			}
		});
	};
	
	getMethod();
	
	// Bouton de creation d'un nouveau user
	$("#new").click(function(){
		var obj = {nom:"mar", prenom:"to"};
		
		$.ajax({
			url : "http://localhost:8080/TP_REST2/RestService/Personnes",
			contentType : "application/json",
			type : "POST",
			dataType : "json",
			data : JSON.stringify(obj)
			}
		).done(function (data) {
			console.log(data);
			
			$("#table").append("<tr><td>" + data["nom"] + "</td><td>" + data["prenom"] + "</td><td><button type=button id=" + data["id"] + ">Delete</button></td><tr>");
			var idBtn = data["id"];
			$("#" + idBtn).click(function(){
				$.ajax({
					url : "http://localhost:8080/TP_REST2/RestService/Personnes/" + idBtn,
					type : "DELETE"
					}
				).done(function (data) {
					alert("pouet");
				});
			});
		});
	});
	
});