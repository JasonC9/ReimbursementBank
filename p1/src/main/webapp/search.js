function search()
{
	let data={
		user:document.getElementById('uname').value,
	}	
	
	
	fetch("Search",{
		method:'POST',
		headers:{'Content-Type':'application/json'},
		body:JSON.stringify(data)
	}).then((response)=>{
		console.log("got here")
		if(response.redirected)
		{
			console.log("test")
			window.location.href=response.url;
			
		}
		else
		{
			alert("Cannot find user");
			console.log(data)
		}
	}
	).catch(error=>{
		console.error(error)
	});
};