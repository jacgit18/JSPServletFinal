<!DOCTYPE html>
<html>
<head>
<title>MVC With DB</title>
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
</head>
<body>
	<table class="title">
		<tr>
			<th>MVC With DB</th>
		</tr>
	</table>
	<br />

	<fieldset>
		<legend>SSN Search Result</legend>
		
		<h1 style="color:green;">The SSN # is "${studentJspRef.SSN} and the rest of info is "</h1>
		
	    First Name: ${studentJspRef.fName}<br>
 		Middle Name: ${studentJspRef.mi}<br>
 		Last Name: ${studentJspRef.lName}<br>
 		
 		Birth Date: ${studentJspRef.birthDate}<br>
 		Address: ${studentJspRef.street}<br>
 		Zipcode: ${studentJspRef.zipcode}<br>

        Phone: ${studentJspRef.phone}<br>
 		Department ID: ${studentJspRef.depId}<br>
		
		
	</fieldset>

</body>
</html>

