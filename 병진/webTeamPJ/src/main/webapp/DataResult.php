<?php
include './PHPDBConnect.php';

$sql = "SELECT TITLE FROM board ORDER BY date DESC LIMIT 20";
$result = $conn->query($sql);

$data = array();

if ($result === false) {
    die("Query failed: " . $conn->error);
} else {
    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $data[] = $row['TITLE'];
        }
    }
}

echo json_encode($data);

$conn->close();
?>
