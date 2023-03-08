<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.*"%>
<%@page import="ModeloDao.*"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Insumos</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
        <link href="https://cdn.datatables.net/1.13.2/css/jquery.dataTables.min.css" rel="style">
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.2/js/jquery.dataTables.min.js"></script>

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- archivos CSS  tablas -->
        <link href="https://cdn.datatables.net/1.13.2/css/jquery.dataTables.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/buttons/2.3.4/css/buttons.dataTables.min.css" rel="stylesheet">

        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
    </head>

    <body>

        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="index.html" class="logo d-flex align-items-center">
                    <span class="d-none d-lg-block">Insumos</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div><!-- End Logo -->
            <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">



                    <li class="nav-item dropdown pe-3">

                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                            <span class="d-none d-md-block dropdown-toggle ps-2">Usuario</span>
                        </a><!-- End Profile Iamge Icon -->

                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">                           
                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <i class="bi bi-box-arrow-right"></i>
                                    <span>Cerrar sesion</span>
                                </a>
                            </li>

                        </ul><!-- End Profile Dropdown Items -->
                    </li><!-- End Profile Nav -->

                </ul>
            </nav><!-- End Icons Navigation -->

        </header><!-- End Header -->

        <!-- ======= Sidebar ======= -->
        <aside id="sidebar" class="sidebar">
            <ul class="sidebar-nav" id="sidebar-nav">
                <li class="nav-item">
                    <a class="nav-link collapsed" href="Controller?accion=dashboard">
                        <i class="bi bi-grid"></i>
                        <span>Clientes</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="Controller?accion=insumo">
                        <i class="bi bi-grid"></i>
                        <span>Insumo</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="Controller?accion=producto">
                        <i class="bi bi-grid"></i>
                        <span>Producto</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="Controller?accion=registro">
                        <i class="bi bi-grid"></i>
                        <span>Registro</span>
                    </a>
                </li>
                <li class="nav-item">
<!--                    <a class="nav-link collapsed" href="Controller?accion=usuario">
                        <i class="bi bi-grid"></i>
                        <span>Usuario</span>
                    </a>-->
                </li>
            </ul>
        </aside><!-- End Sidebar-->

        <main id="main" class="main">

            <div class="pagetitle">
                <h1>Clientes</h1>                
            </div><!-- End Page Title -->

            <section class="section">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="p-2">
                                    <form action="Cliente" method="post">
                                        <div class="row">
                                            <div class="col-sm-6 m-b30">
                                                <label class="form-label">Cedula</label>
                                                <input type="text" class="form-control" name="txt-cedula">
                                            </div>
                                            <div class="col-sm-6 m-b30">
                                                <label class="form-label">Nombres</label>
                                                <input type="text" class="form-control" name="txt-nombres">
                                            </div>
                                            <div class="col-sm-6 m-b30">
                                                <label class="form-label">Apellidos</label>
                                                <input type="text" class="form-control" name="txt-apellidos" >
                                            </div>                                          
                                            <div class="col-sm-6 m-b30">
                                                <label class="form-label">Direccion</label>
                                                <input type="text" class="form-control" name="txt-direccion">
                                            </div>
                                            <div class="col-sm-6 m-b30">
                                                <label class="form-label">Telefono</label>
                                                <input type="text" class="form-control" name="txt-telefono">
                                            </div>


                                            <div class="col-sm-2 m-b30">
                                                <label class="form-label"> </label>
                                                <input type="submit" class="form-control btn btn-primary" name="accion" value="Registrar">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-12">
                        <div class="card p-2">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table id="example" class="display" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th class="text-center" scope="col">#</th>
                                                <th class="text-center" scope="col">Cedula</th>
                                                <th class="text-center" scope="col">Nombres</th>
                                                <th class="text-center" scope="col">Apellidos</th>
                                                <th class="text-center" scope="col">Fecha</th>
                                                <th class="text-center" scope="col">Direccion</th>
                                                <th class="text-center" scope="col">Telefono</th>
                                                <!--<th class="text-center" scope="col">Registro</th>-->
                                                <th class="text-center" scope="col">Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                    ClienteDao daoCh = new ClienteDao();
                                                    List<CLIENTES> listCh = daoCh.listar();
                                                    Iterator<CLIENTES> iterCh = listCh.iterator();
                                                    CLIENTES ch = null;
                                                    while (iterCh.hasNext()) {
                                                        ch = iterCh.next();
                                            %>
                                            <tr>
                                                <th class="text-center" scope="row"><%= ch.getIdCliente()%></th>
                                                <td class="text-center text-uppercase"><%= ch.getCliCedula()%></td>
                                                <td class="text-center text-uppercase"><%= ch.getCliNombres()%></td>
                                                <td class="text-center text-uppercase"><%= ch.getCliApellidos()%></td>
                                                <td class="text-center text-uppercase"><%= ch.getCliFecha()%></td>
                                                <td class="text-center text-uppercase"><%= ch.getCliDireccion()%></td>
                                                <td class="text-center text-uppercase"><%= ch.getCliTelefono()%></td>
                                                <td>
                                                    <center>
                                                        <a href="Cliente?accion=editar&idCliente=<%= ch.getIdCliente()%>" class="btn btn-warning">Actualizar</a>
                                                        <a href="Cliente?accion=eliminar&idCliente=<%= ch.getIdCliente()%>" class="btn btn-danger">Eliminar</a>
                                                    </center>
                                                </td>
                                        </tr>
                                        <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </main><!-- End #main -->

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.umd.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
        <!-- PDFS -->
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.2/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.4/js/dataTables.buttons.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js" ></script>
        <script src="https://cdn.datatables.net/buttons/2.3.4/js/buttons.html5.min.js" ></script>
        <script src="https://cdn.datatables.net/buttons/2.3.4/js/buttons.print.min.js" ></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable({
                    dom: 'Bfrtip',
                    buttons: [
                        'copy', 'csv', 'excel', 'pdf', 'print'
                    ]
                });
            });
        </script>
    </body>

</html>
