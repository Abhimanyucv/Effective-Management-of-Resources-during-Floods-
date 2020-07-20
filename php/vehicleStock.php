<?php

include("connection.php");

// $rid = $_REQUEST['rid'];
// $reqId = $_REQUEST['reqId'];

$select = " SELECT * FROM vehicle_stock WHERE vechile_id = '1' ";
if($res = mysqli_query($con,$select))
{
	while($row = mysqli_fetch_assoc($res))
	{
		$selitem = " SELECT * FROM items WHERE id = '$row[item]' ";
		$res_item = mysqli_query($con,$selitem);
		$row_item = mysqli_fetch_assoc($res_item);
		$item_name = $row_item['item_name']; 

	/*	$selcamp = " SELECT * FROM relief_camp WHERE id = '$row[relief_camp]' ";
		$res_camp = mysqli_query($con,$selcamp);
		$row_camp = mysqli_fetch_assoc($res_camp);
		$camp_name = $row_camp['camp_name'];  */

		$data['data'][] = array('item_name' => $item_name, 'item_qty' => $row['qty']);
	}

	echo json_encode($data);
}


?>