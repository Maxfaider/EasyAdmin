<!DOCTYPE html>
<!--
 * A Design by GraphBerry
 * Author: Alan M.E
 * Author URL: http://graphberry.com
 * License: http://graphberry.com/pages/license
-->
<html lang="es">
    <!-- Inicio Cabecera-->
    <?php include 'app/view/html/cabecera.html'; ?>
    <!-- Fin Cabecera -->	
    <body>
	<!-- Inicio Menu reutilizable -->
        <?php include 'app/view/html/menu.html'; ?>
	<!-- Fin Menu -->
	
        <?php include 'app/view/register.php'; ?>
		
        <!-- Start home section -->
        <div id="home">
            <!-- Start cSlider -->
            <div id="da-slider" class="da-slider">
                
                <div class="triangle"></div>
                <!-- mask elemet use for masking background image -->
                <div class="mask"></div>
                <!-- All slides centred in container element -->
                <div class="container">
                    <!-- Start first slide -->
                    <div class="da-slide">
                        <h2 class="fittext2">Welcome to Easy AdminPro</h2>
                        <h4>Control de acceso remoto</h4>
                        <p>
                        Easy AdminPro es un software basado en tecnología cliente-servidor que asegura un excelente control para entornos de red.
                        Hablamos de Easy Admin Server y Easy Admin Client, dos programas que harán de la gestión de su cyber una tarea fácil.
                        </p>
                        <a href="javascript:mostrar();" class="da-link button">Regístrate</a>
                        <div class="da-img">
                            <img src="app/view/images/Slider01.png" alt="image01" width="320">
                        </div>
                    </div>
                    <!-- End first slide -->
                    <!-- Start second slide -->
                    <div class="da-slide">
                        <h2>App management</h2>
                        <h4>administre desde su dispositivo movil.</h4>
                        <p>Un app Movil que debe permitir bloquear/desbloquear a un usuario especifico.</p>
                        <a href="#" class="da-link button">Descargar App</a>
                        <div class="da-img">
                            <img src="app/view/images/Slider02.png" width="320" alt="image02">
                        </div>
                    </div>
                    <!-- End second slide -->
                    <!-- Start third slide -->
                    <div class="da-slide">
                        <h2>Easy AdminPro</h2>
                        <h4>Ofrece una interfaz de usuario muy fácil de usar.</h4>
                        <p>
                        Las ventajas clave de Easy Admin son fiabilidad, facilidad de uso, seguridad de los datos transferidos.
                        Easy AdminPro es un software de administración de equipos para negocios de café Internet totalmente gratuito. 
                        </p>
                        <a href="price" class="da-link button">Descargar aqui</a>
                        <div class="da-img">
                            <img src="app/view/images/Slider03.png" width="320" alt="image03">
                        </div>
                    </div>
                    <!-- Start third slide -->
                    <!-- Start cSlide navigation arrows -->
                    <div class="da-arrows">
                        <span class="da-arrows-prev"></span>
                        <span class="da-arrows-next"></span>
                    </div>
                    <!-- End cSlide navigation arrows -->
                </div>
            </div>
        </div>
        <!-- End home section -->
		
	<!-- Service section start -->
        <div class="section primary-section" id="service">
            <div class="container">
                <!-- Start title section -->
                <div class="title">
                    <h1>¿Qué hacemos?</h1>
                    <!-- Section's title goes here -->
                    <p>El acceso remoto a PC con EasyAdmin supone una extraordinaria elección para la optimización de procesos y la reducción de costes de una empresa. EasyAdmin puede influir de forma positiva en la productividad de toda la organización.</p>
                    <!--Simple description for section goes here. -->
                </div>
                <div class="row-fluid">
                    <div class="span4">
                        <div class="centered service">
                            <div class="circle-border zoom-in">
                                <img class="img-circle" src="app/view/images/Servicec.png" alt="service 1">
                            </div>
                            <h3>Administración de sistemas remotos</h3>
                            <p>Puede conectarse rápidamente a ordenadores remotos incluso si se encuentran en diferentes redes de área local.</p>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="centered service">
                            <div class="circle-border zoom-in">
                                <img class="img-circle" src="app/view/images/Servicep.png" alt="service 2" />
                            </div>
                            <h3>Control Remoto Multi-plataforma</h3>
                            <p>Utilice el software de EasyAdmin desde todos los principales sistemas operativos.</p>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="centered service">
                            <div class="circle-border zoom-in">
                                <img class="img-circle" src="app/view/images/serviceusq.jpg" alt="service 3">
                            </div>
                            <h3>Diseño de calidad</h3>
                            <p>Si lo que busca es simplicidad, fácil manejo, eficacia y sobre todo control sobre su cyber, entonces llegó al lugar indicado.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Service section end -->
		
		
	<!-- About us section end -->
        <div class="section secondary-section">
            <div class="triangle"></div>
            <div class="container centered">
                <p class="large-text">El software de Easy Admin le garantiza los más altos estándares en seguridad de la industria.</p>
                <a href="javascript:mostrar();" class="button">Regístrate</a>
            </div>
        </div>
		
		
        <!-- Client section start -->
        <div id="clients">
            <div class="section primary-section">
                <div class="triangle"></div>
                <div class="container">
                    <div class="title">
                        <h1>Principales Clientes</h1>
                    </div>
                    <div class="row">
                        <div class="span4">
                            <div class="testimonial">
                                <p>"I've worked too hard and too long to let anything stand in the way of my goals. I will not let my teammates down and I will not let myself down."</p>
                                <div class="whopic">
                                    <div class="arrow"></div>
                                    <img src="app/view/images/Client1.jpg" class="centered" alt="client 1">
                                    <strong>Universidad de cartagena
                                        <small>Client</small>
                                    </strong>
                                </div>
                            </div>
                        </div>
                    </div>
                    <p class="testimonial-text">
                        "Perfection is Achieved Not When There Is Nothing More to Add, But When There Is Nothing Left to Take Away"
                    </p>
                </div>
            </div>
        </div>
        <!-- Client section end -->
        
        <!-- Contact section start-->
        <div id="contact" class="contact">
            <div class="section secondary-section">
                <div class="container">
                    <div class="span9 center contact-info">
                        <p class="info-mail">Easy Admin Pro</p>
                        <p>AlanME@AMECodeTech.com.co</p>
		        <p>JoseLC@AMECodeTech.com.co</p>
                        <p>+57 313 5351 609</p>
                        <div class="title">
                            <h3>Somos Sociales</h3>
                        </div>
                    </div>
                    <div class="row-fluid centered">
                        <ul class="social">
                            <li>
                                <a href="">
                                    <span class="icon-facebook-circled"></span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="icon-twitter-circled"></span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="icon-gplus-circled"></span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Contact section end-->
		
		
        <!-- Footer section start-->
        <?php include 'app/view/html/footer.html'; ?>
        <!-- Footer section end -->
		
        
        <!-- Include javascript -->
        <?php include 'app/view/html/script.html'; ?>
        <!-- end Include javascript -->
    </body>
</html>