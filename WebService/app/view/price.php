<!DOCTYPE html>
<!--
 * A Design by GraphBerry
 * Author: Alan M.E
 * Author URL: http://graphberry.com
 * License: http://graphberry.com/pages/license
-->
<html lang="es">
    
    <!-- Inicio Cabecera -->
    <?php include 'app/view/html/cabecera.html'; ?>
    <!-- Fin Cabecera -->
    
    <body>
       
        <!-- Inicio Menu reutilizable -->
        <?php include 'app/view/html/menu.html'; ?>
	<!-- Fin Menu -->
        
        <?php include 'app/view/register.php'; ?>
		
        <!-- Price section start -->
        <div id="price" class="section secondary-section">
            <div class="container">
                <div class="title">
                    <h1>Links de descarga</h1>
                    <p>Pueden reportar los bugs (errores), sugerencias etc. en la hoja informativa, esperamos que nos sigan apoyando.</p>
                </div>
                <div class="price-table row-fluid">
                    <div class="span4 price-column">
                        <h3>Easy AdminPro Server</h3>
                        <ul class="list">
                            <li class="price">Free</li>
                            <li><strong>Windows, Mac, Linux</strong> Setup</li>
                            <li><strong>Versión</strong> beta</li>
                        </ul>
                        <a href="product/" class="button button-ps">Descarga</a>
                    </div>
                    <div class="span4 price-column">
                        <h3>Easy AdminPro Client</h3>
                        <ul class="list">
                            <li class="price">Free</li>
                            <li><strong>Windows, Mac, Linux</strong> Setup</li>
                            <li><strong>Versión</strong> beta</li>
                        </ul>
                        <a href="product/" class="button button-ps">Descarga</a>
                    </div>
                    <div class="span4 price-column">
                        <h3>Easy AdminPro <br/>app</h3>
                        <ul class="list">
                            <li class="price">$2.99</li>
                            <li><strong>Android</strong></li>
                            <li><strong>No</strong> disponible</li>
                        </ul>
                        <a href="" class="button button-ps">Reservelo Aquí</a>
                    </div>
                </div>
                <div class="centered">
                    <p class="price-text">Versión completa resérvela aquí.</p>
                    <a href="javascript:mostrar();" class="button">Regístrate</a>
                </div>
            </div>
        </div>
        <!-- Price section end -->
		
	<!-- Newsletter section start -->
        <div class="section third-section">
            <div class="container newsletter">
                <div class="sub-section">
                    <div class="title clearfix">
                        <div class="pull-left">
                            <h3>Hoja informativa</h3>
                        </div>
                    </div>
                </div>
                <div id="success-subscribe" class="alert alert-success invisible">
                    <strong>Well done!</strong>You successfully subscribet to our newsletter.</div>
                <div class="row-fluid">
                    <div class="span5">
                        <p>Estamos disponibles en todo momento para ofrecerle recomendaciones sobre nuestras herramientas, además, si tiene cualquier consulta estaremos encantados de ayudarle.</p>
                    </div>
                    <div class="span7">
                        <form class="inline-form">
                            <input type="email" name="email" id="nlmail" class="span8" placeholder="Enter your email" required />
                            <button id="subscribe" class="button button-sp">Subscribe</button>
                        </form>
                        <div id="err-subscribe" class="error centered">Please provide valid email address.</div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Newsletter section end -->
        
        
        <!-- Footer section start -->
        <?php include 'app/view/html/footer.html'; ?>
        <!-- Footer section end -->
        
        <!-- Include javascript -->
        <?php include 'app/view/html/script.html'; ?>
    </body>
</html>