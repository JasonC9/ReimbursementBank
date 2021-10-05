function login()
{
	let data={
		user:document.getElementById('uname').value,
		pass:document.getElementById('psw').value
	}	
	
	
	fetch("StaffWelcome",{
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