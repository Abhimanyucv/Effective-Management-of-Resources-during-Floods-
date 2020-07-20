<?php

include("connection.php");

$text = $_REQUEST['text'];
// $text = "test";

$select = " SELECT * FROM cam_person WHERE person_name LIKE '%$text%' OR aadhaar LIKE '%$text%' ";
// echo $select;
if($res = mysqli_query($con,$select))
{
	while($row = mysqli_fetch_assoc($res))
	{
		$selcamp = " SELECT * FROM relief_camp WHERE id = '$row[relief_camp]' ";
		$res_camp = mysqli_query($con,$selcamp);
		$row_camp = mysqli_fetch_assoc($res_camp);
		$camp_name = $row_camp['camp_name']; 
		$location = $row_camp['location']; 

		$data['data'][] = array('id' => $row['id'], 'name' => $row['person_name'], 'camp_name' => $camp_name, 'location' => $location, 'date' => $row['date'] );
	}

	echo json_encode($data);
}
else{
	echo "Failed";
}


?>