import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        while (true) {
            System.out.println("****************************************");
            System.out.println("Bienvenido/a al Conversor de Moneda ");
            System.out.println("Ingrese el monto a convertir: ");
            double monto = lectura.nextDouble();

            System.out.println("Seleccione una opción:");
            System.out.println("1. De dólar a peso mexicano");
            System.out.println("2. De peso mexicano a dólar");
            System.out.println("3. De dólar a Real Brasileño");
            System.out.println("4. De Real Brasileño a dólar");
            System.out.println("5. De dólar a peso colombiano");
            System.out.println("6. De peso colombiano a dólar");
            System.out.println("7. Salir");

            int opcion = lectura.nextInt();

            if (opcion == 7) {
                System.out.println("¡Hasta luego!");
                System.out.println("****************************************");
                break;
            }

            String direccion = "https://v6.exchangerate-api.com/v6/8075d2d1ed4a69f3b2ac9e11/latest/USD";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica si la respuesta fue exitosa
            if (response.statusCode() == 200) {
                // Checa la respuesta JSON para obtener las tasas de cambio
                String responseBody = response.body();

                double tasaCambio = 0;
                switch (opcion) {
                    case 1:
                        tasaCambio = obtenerTasaDeCambio(responseBody, "MXN");
                        System.out.println(monto + " USD equivalen a aproximadamente " + (monto * tasaCambio) + " MXN");
                        break;
                    case 2:
                        tasaCambio = obtenerTasaDeCambio(responseBody, "MXN");
                        System.out.println(monto + " MXN equivalen a aproximadamente " + (monto / tasaCambio) + " USD");
                        break;
                    case 3:
                        tasaCambio = obtenerTasaDeCambio(responseBody, "BRL");
                        System.out.println(monto + " USD equivalen a aproximadamente " + (monto * tasaCambio) + " BRL");
                        break;
                    case 4:
                        tasaCambio = obtenerTasaDeCambio(responseBody, "BRL");
                        System.out.println(monto + " BRL equivalen a aproximadamente " + (monto / tasaCambio) + " USD");
                        break;
                    case 5:
                        tasaCambio = obtenerTasaDeCambio(responseBody, "COP");
                        System.out.println(monto + " USD equivalen a aproximadamente " + (monto * tasaCambio) + " COP");
                        break;
                    case 6:
                        tasaCambio = obtenerTasaDeCambio(responseBody, "COP");
                        System.out.println(monto + " COP equivalen a aproximadamente " + (monto / tasaCambio) + " USD");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } else {
                System.out.println("Error al obtener la respuesta de la API: " + response.statusCode());
            }
        }
    }

    private static double obtenerTasaDeCambio(String responseBody, String moneda) {
        // Encuentra la posición de la moneda en la respuesta JSON
        int posMoneda = responseBody.indexOf(moneda);
        // Encuentra la posición de la tasa de cambio
        int posTasa = responseBody.indexOf(":", posMoneda) + 1;
        // Encuentra la posición del siguiente separador
        int posComa = responseBody.indexOf(",", posTasa);
        // Extrae la tasa de cambio como una cadena y la convierte a double
        String tasaStr = responseBody.substring(posTasa, posComa).trim();
        return Double.parseDouble(tasaStr);
    }
}