<?php

include("connection.php");

$vid = $_REQUEST['vid'];

$select = " SELECT items.item_name ,SUM(vehicle_stock.qty) as qty FROM vehicle_stock INNER JOIN items ON vehicle_stock.item=items.id WHERE vehicle_stock.vechile_id='$vid' GROUP BY vehicle_stock.item  ";

// echo $select;
if($res = mysqli_query($con,$select))
{
	while($row = mysqli_fetch_assoc($res))
	{
		$data['data'][] = $row;
	}

	echo json_encode($data);
}


?>