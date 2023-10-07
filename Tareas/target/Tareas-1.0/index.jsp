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

                                <form action="SvTarea" method="POST" >

                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                        <span class="h1 fw-bold mb-0">Tareas</span>
                                    </div>

                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Ingresa a tu cuenta</h5>

                                    <div class="form-outline mb-4">
                                        <input type="text"  name="usuarioR" class="form-control form-control-lg" />
                                        <label class="form-label" for="usuarioR">Usuario</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" name="contraseniaR" class="form-control form-control-lg" />
                                        <label class="form-label" for="contraseniaR">Contraseña</label>
                                    </div>

                                    <div class="pt-1 mb-4">
                                        <button class="btn btn-dark btn-lg btn-block" type="submit" >Iniciar sesion</button>
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
                    <form action="SvTarea" method="POST" enctype="multipart/form-data" > 
                        <!-- Input para el nombre-->
                        <div class="input-group mb-3">
                            <label class="input-group-text" for="usuario">Usuario:</label>
                            <input type="text" name ="usuario" id="usuario" class="form-control">
                        </div>    
                        <!-- Input para cedula-->
                        <div class="input-group mb-3">
                            <label class="input-group-text" for="cedula">Cedula:</label>
                            <input type="text" name ="cedula"  id="cedula" class="form-control">
                        </div> 
                        <!-- Input para contraseña-->
                        <div class="input-group mb-3">
                            <label class="input-group-text" for="contrasenia">Contraseña:</label>
                            <input type="password" name ="contrasenia" id="contrasenia" class="form-control">
                        </div>    
                        <!-- Boton para crear un nuevo usuario --> 
                        <input   type="submit" value="Crear usuario"  class ="form-control"/>
                    </form>
                </div>
            </div>
            <!-- Boton para cerrar el modal -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
<script>
    //modal para crear un nuevo usuario
    $('#exampleModal').submit(function (event) {
        event.preventDefault(); // Evitar que el formulario se envíe de forma predeterminada

        // Obtener los valores de los campos del formulario
        var usuario = $('#usuario').val();
        var cedula = $('#cedula').val();
        var contrasenia = $('#contrasenia').val();

        // Realizar una solicitud AJAX 
        $.ajax({
            url: 'SvTarea',
            method: 'POST', // Utilizar POST para enviar datos confidenciales
            data: {
                usuario: usuario,
                cedula: cedula,
                contrasenia: contrasenia
            },
            success: function (data) {

                console.log('Registro exitoso:', data);
            },
            error: function () {

                console.log('Error en el registro de usuario.');
            }
        });
    });
</script>


<%@include file="Templates/Footer.jsp" %>                                                                                        