<?php
session_start();

$connection = mysqli_connect("localhost","root","","selenium");
$errorM=null;
if(!$connection)
	die("Connection failded");
if(isset($_POST["nume"]))
	$nume = $_POST["nume"];
if(isset($_POST["prenume"]))
	$prenume = $_POST["prenume"];
if(isset($_POST["varsta"]))
	$varsta = $_POST["varsta"];

   if($varsta>=18)
   {
$conn=new mysqli("localhost","root","","selenium");
$query="insert into studenti (nume,prenume,varsta) values('$nume','$prenume','$varsta')";
if ($conn->query($query) === TRUE) {
    header("location:succes.php");
    
} else {
    header("location:eroare.php");
}
   }
   else {
    header("location:eroare.php");
   }
?>
