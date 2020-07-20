<?php

include("connection.php");

// $rid = $_REQUEST['rid'];
// $reqId = $_REQUEST['reqId'];

$select = " SELECT DISTINCT relief_camp FROM vehicle_stock WHERE vechile_id = '1' ";
if($res = mysqli_query($con,$select))
{
	while($row = mysqli_fetch_assoc($res))
	{
		$selcamp = " SELECT * FROM relief_camp WHERE id = '$row[relief_camp]' ";
		$res_camp = mysqli_query($con,$selcamp);
		$row_camp = mysqli_fetch_assoc($res_camp);
		$camp_name = $row_camp['camp_name']; 
		$latitude = $row_camp['latitude']; 
		$logitude = $row_camp['logitude']; 

		$data['data'][] = array('camp_name' => $camp_name, 'camp_id' => $row['relief_camp'], 'latitude' => $latitude, 'logitude' => $logitude );
	}

	echo json_encode($data);
}
else{
	echo "Failed";
}


?>