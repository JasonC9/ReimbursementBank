function sendRequest()
{
	let data={
		id:document.getElementById('id').value,
		and:document.getElementById('and').value
	}	
	
	
	fetch("aod",{
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
			alert("Password Username not match");
			console.log(data)
		}
	}
	).catch(error=>{
		console.error(error)
	});
};