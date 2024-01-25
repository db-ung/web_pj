<?php

$host = 'localhost';
$db = 'apidb';
$user = 'root';
$pass = '1234';

$conn = new mysqli($host, $user, $pass, $db);

if ($conn->connect_error) {
    print("Connection failed: " . $conn->connect_error);
} else {
    $conn->set_charset("utf8");
    echo "Connected successfully";
}
?>