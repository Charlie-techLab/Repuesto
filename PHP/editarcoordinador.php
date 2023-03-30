<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){
    require_once 'conexion.php';
    $idC = $_POST["idC"];
    $nombre = $_POST["nombre"];
    $apellido = $_POST["apellido"];
    $fechaNac  = $_POST["fechaNac"];
    $titulo  = $_POST["titulo"];
    $email  = $_POST["email"];
    $facultad  = $_POST["facultad"];
    $my_query = "UPDATE coordinador
    SET nombre = '".$nombre."', apellido = '".$apellido."', fechaNac = '".$fechaNac."', titulo = '".$titulo."' , email = '".$email."' , facultad = '".$facultad."'
    WHERE idC = '".$idC."'";
    $result = $mysql -> query($my_query);
    if($result == true){
        echo "\n Registro editado satisfactoriamente...";
    }else{
        echo "Error al editar registro...";
    }
}else{
    echo"Error desconocido";
}
?>