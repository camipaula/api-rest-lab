package edu.udla.isw; 
import org.apache.camel.builder.RouteBuilder; 
import org.apache.camel.main.Main; 

public class App extends RouteBuilder {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new App());
        main.run(args);
    }

    @Override
    public void configure() {

        // Configuración REST
        restConfiguration()
                .component("netty-http")
                .port(7760)
                .contextPath("/api")
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "API de Envíos")
                .apiProperty("api.version", "1.0.0");

        // Endpoints REST
        rest("/envios").description("Gestión de Envíos")
                .get().to("direct:listarEnvios")
                .post().to("direct:crearEnvio");

        rest("/envios/{id}")
                .get().to("direct:obtenerEnvio");

        // Rutas directas
        from("direct:listarEnvios")
                .setBody(constant("[{\"id\":\"001\",\"destinatario\":\"Juan Pérez\",\"estado\":\"En tránsito\"}]"));

        from("direct:crearEnvio")
                .log("Nuevo envío recibido: ${body}")
                .setBody(constant("{\"mensaje\":\"Envío registrado correctamente\"}"));

        from("direct:obtenerEnvio")
                .log("Consultando envío con ID: ${header.id}")
                .setBody(simple("{\"id\":\"${header.id}\",\"destinatario\":\"Cliente X\",\"estado\":\"Entregado\"}"));
    }
}