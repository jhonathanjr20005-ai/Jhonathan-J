import Controller.ArbolBinario;

/**
 * Clase Principal - Demostración del Árbol Binario de Búsqueda
 * Ejecuta ejemplos de inserción, búsqueda y recorridos
 */
public class Estructura_Datos {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║     ÁRBOL BINARIO DE BÚSQUEDA - DEMOSTRACIÓN              ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        
        // Crear un árbol binario
        ArbolBinario arbol = new ArbolBinario();
        
        // Insertar valores
        System.out.println("▶ Insertando valores: 50, 30, 70, 20, 40, 60, 80\n");
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
        
        // Recorridos
        System.out.println("\n► RECORRIDOS DEL ÁRBOL:");
        arbol.recorridoInOrden();
        arbol.recorridoPreOrden();
        arbol.recorridoPostOrden();
        
        // Estadísticas
        System.out.println("\n► ESTADÍSTICAS:");
        System.out.println("  • Número de nodos: " + arbol.contarNodos());
        System.out.println("  • Altura del árbol: " + arbol.obtenerAltura());
        System.out.println("  • Valor mínimo: " + arbol.obtenerMinimo());
        System.out.println("  • Valor máximo: " + arbol.obtenerMaximo());
        
        // Búsqueda
        System.out.println("\n► BÚSQUEDAS:");
        int[] buscar = {40, 100, 20};
        for (int valor : buscar) {
            if (arbol.buscar(valor)) {
                System.out.println("  ✓ " + valor + " fue encontrado en el árbol");
            } else {
                System.out.println("  ✗ " + valor + " NO fue encontrado en el árbol");
            }
        }
        
        System.out.println("\n╚══════════════════════════════════════════════════════════╝");
    }
}
