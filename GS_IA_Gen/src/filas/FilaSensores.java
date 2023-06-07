package filas;

import entidades.RegistroSensor;

public class FilaSensores {
    private class NO {
        RegistroSensor dado;
        NO prox;
    }

    private NO ini, fim;

    public void init() {
        ini = fim = null;
    }

    public boolean isEmpty() {
        if (ini == null && fim == null)
            return true;
        else
            return false;
    }

    public void enqueue(RegistroSensor elem) {
        NO novo = new NO();
        novo.dado = elem;
        novo.prox = null;
        if (isEmpty())
            ini = novo;
        else
            fim.prox = novo;

        fim = novo;
    }

    public RegistroSensor dequeue() {
        RegistroSensor valor = ini.dado;
        ini = ini.prox;
        if (ini == null)
            fim = null;
        return valor;
    }

    public void printFila() {
        NO aux;
        int cont = 1;
        aux = ini;
        while (aux != null) {
            System.out.println("!!ALERTA!! #" + cont + ": \n" + aux.dado);
            System.out.println();
            aux = aux.prox;
            cont++;
        }
    }
}
