function sendRequest()
{
		let data={
		amount:document.getElementById('amount').value,
		reason:document.getElementById('reason').value,
		expl:document.getElementById('explan').value
	}
	fetch("ReimbursementSubmit",{
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
			alert("NOT IN IF");
			console.log(data)
		}
	}
	).catch(error=>{
		console.error(error)
	});
}