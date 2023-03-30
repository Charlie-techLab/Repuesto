<?php
if ($_SERVER["REQUEST_METHOD"] == "GET"){
      require_once 'conexion.php' ;
      $my_query = "select * from coordinador";
      $result = $mysql->query($my_query);
      if ($mysql->affected_rows > 0) {
          $json = "{\"data\":[";
        while ($row = $result->fetch_assoc()){
            $json = $json.json_encode($row, JSON_PRETTY_PRINT);
            $json=$json.",";
        }
         $json = $json."]}";
         echo $json;
        }

$result->close();
$mysql->close();

    }

?>
