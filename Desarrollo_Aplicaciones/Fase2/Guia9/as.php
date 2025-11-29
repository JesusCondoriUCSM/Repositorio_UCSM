<?php
// Función para listar archivos en una carpeta específica
function listar_archivos($directorio) {
    $archivos = [];
    if (is_dir($directorio)) {
        if ($dir = opendir($directorio)) {
            while (($archivo = readdir($dir)) !== false) {
                if ($archivo != '.' && $archivo != '..') {
                    $archivos[] = $archivo;
                }
            }
            closedir($dir);
        }
    }
    return $archivos;
}

// Procesamiento del formulario para mostrar el contenido del archivo seleccionado
if (isset($_POST['ver_archivo'])) {
    $especialidad = $_POST['especialidad'];
    $archivo_seleccionado = $_POST['archivo'];
    $ruta_archivo = "uploads/$especialidad/$archivo_seleccionado";

    // Verificar si el archivo existe y leer el contenido
    if (file_exists($ruta_archivo)) {
        $contenido = file_get_contents($ruta_archivo);
    } else {
        $error = "El archivo no existe.";
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ver Archivos por Especialidad</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Ver Archivos por Especialidad</h1>
    <div class="container">
        <!-- Formulario para seleccionar una especialidad y ver los archivos -->
        <form action="" method="POST">
            <label for="especialidad">Especialidad:</label>
            <select id="especialidad" name="especialidad" required onchange="this.form.submit()">
                <option value="">Seleccione una especialidad</option>
                <option value="Estadistica" <?php if (isset($_POST['especialidad']) && $_POST['especialidad'] == 'Estadistica') echo 'selected'; ?>>Estadística</option>
                <option value="DesarrolloWeb" <?php if (isset($_POST['especialidad']) && $_POST['especialidad'] == 'DesarrolloWeb') echo 'selected'; ?>>Desarrollo Web</option>
                <option value="Testing" <?php if (isset($_POST['especialidad']) && $_POST['especialidad'] == 'Testing') echo 'selected'; ?>>Testing</option>
            </select>
        </form>

        <?php
        // Mostrar lista de archivos según la especialidad seleccionada
        if (isset($_POST['especialidad'])) {
            $especialidad = $_POST['especialidad'];
            $archivos = listar_archivos("uploads/$especialidad");

            if (!empty($archivos)) {
                echo "<h2>Archivos en la carpeta $especialidad:</h2>";
                echo "<form action='' method='POST'>";
                echo "<input type='hidden' name='especialidad' value='$especialidad'>";
                echo "<select name='archivo' required>";
                foreach ($archivos as $archivo) {
                    echo "<option value='$archivo'>$archivo</option>";
                }
                echo "</select>";
                echo "<br><br><input type='submit' name='ver_archivo' value='Ver Contenido'>";
                echo "</form>";
            } else {
                echo "<p>No hay archivos en la carpeta $especialidad.</p>";
            }
        }

        // Mostrar el contenido del archivo seleccionado si existe
        if (isset($contenido)) {
            echo "<h2>Contenido de $archivo_seleccionado:</h2>";
            echo "<pre>" . htmlspecialchars($contenido) . "</pre>";
        } elseif (isset($error)) {
            echo "<p class='error'>$error</p>";
        }
        ?>
    </div>
</body>
</html>