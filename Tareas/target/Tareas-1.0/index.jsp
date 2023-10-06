<%@include file="Templates/Header.jsp" %>
<section class="vh-100" style="background-color: #090333;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                                 alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form>

                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                        <span class="h1 fw-bold mb-0">Tareas</span>
                                    </div>

                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Ingresa a tu cuenta</h5>

                                    <div class="form-outline mb-4">
                                        <input type="email" id="form2Example17" class="form-control form-control-lg" />
                                        <label class="form-label" for="form2Example17">Usuario</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" id="form2Example27" class="form-control form-control-lg" />
                                        <label class="form-label" for="form2Example27">Contraseña</label>
                                    </div>

                                    <div class="pt-1 mb-4">
                                        <button class="btn btn-dark btn-lg btn-block" type="button">Iniciar sesion</button>
                                    </div>

                                    <a class="small text-muted" href="#!"></a>
                                    <p class="mb-5 pb-lg-2 " style="color: #393f81;"><a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal"
                                                                                        style="color: #393f81;" >Registrate aqui</a></p>
                                    <a href="#!" class="small text-muted">Terminos de uso.</a>
                                    <a href="#!" class="small text-muted">Politica de privacidad</a>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- ventana Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registro de nuevo usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div id="tarea-details">
                    <form action="SvPerro" method="POST" enctype="multipart/form-data" > 
                        <!-- Input para el nombre-->
                        <div class="input-group mb-3">
                            <label class="input-group-text" for="nombre">Nombre:</label>
                            <input type="text" name ="nombre" class="form-control">
                        </div>    
                        <!-- Input para cedula-->
                        <div class="input-group mb-3">
                            <label class="input-group-text" for="cedula">Cedula:</label>
                            <input type="text" name ="cedula" class="form-control">
                        </div> 
                        <!-- Input para contraseña-->
                        <div class="input-group mb-3">
                            <label class="input-group-text" for="contrasenia">Contraseña:</label>
                            <input type="password" name ="contrasenia" class="form-control">
                        </div>    
                        <!-- Boton para agregar perros --> 
                        <input type="submit" value="Crear usuario" class ="form-control"/>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
<script>

    // funcion para mostrar los datos en la ventana modal
    $('#exampleModal').on('show.bs.modal',.submit(function (event)) {
        event.preventDefault(); // Prevenir la recarga de la página
       
// Obtener los valores de los campos del formulario
    var nombre = $('#nombre').val();
    var cedula = $('#cedula').val();
    var contrasenia = $('#contrasenia').val();
        // Realiza una solicitud AJAX al servlet para obtener los detalles del perro por su nombre
        $.ajax({
        url: 'SvTarea', 
        method: 'POST', // Utiliza POST para enviar datos confidenciales
        data: {
            nombre: nombre,
            cedula: cedula,
            contrasena: contrasenia
        },
        success: function (data) {
            // Maneja la respuesta del servidor aquí (puede ser un mensaje de éxito o redirección)
            console.log('Registro exitoso:', data);
        },
        error: function () {
            // Maneja errores aquí si es necesario
            console.log('Error en el registro de usuario.');
        }
    });
});




</script>
<%@include file="Templates/Footer.jsp" %>                                                                                        