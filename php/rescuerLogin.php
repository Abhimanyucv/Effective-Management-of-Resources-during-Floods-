<?php

include("connection.php");

$username = $_POST['username'];
$password = $_POST['password'];

$sql = "SELECT * FROM rescuer WHERE username='$username' && password='$password'";

$result = mysqli_query($con,$sql);

if(mysqli_num_rows($result) > 0)
{
	while($row = mysqli_fetch_assoc($result))
	{
		$data['data'][] = $row;
	}
	echo json_encode($data);
}
else{
echo "Failed";	
}


?>