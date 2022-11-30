
package taquilla_banco;

public class Cola {
       Nodo front;
       Nodo rear;
       
       
       
    public Cola() { 
        this.front = null;
        this.rear = null;
    }
    
  public boolean estaVacia(){
      return this.front == null;
  }
  
  public void Encolar(Cliente clt){
    Nodo newnodo = new Nodo(clt);
    if (this.estaVacia()){
        rear = front = newnodo;
    }else{
        rear.sig = newnodo; 
        rear = rear.sig;
    }
  
  } 
  
  public Nodo Desencolar(){
      if (this.estaVacia()) {
          System.out.println("No hay nadie en la cola");
          return null;
      }else{
          Nodo temp = front;
          front = front.sig;
          temp.sig = null;
          return temp;
    
      }
  }
  
  public void Encolar_prioridad(Cliente cl, boolean prior){
        if (front == null) {
            front = rear = new Nodo(cl,prior);
        }else{
            rear.sig = new Nodo(cl,prior);
            rear = rear.sig;
        }
  }
  
  
  public Nodo Desencolar_prioridad(){
    if (this.estaVacia()) {
        System.out.println("La cola está vacía");
        return null;
    }else{  
        Nodo prev = null;
        Nodo aux = front;
        while(aux != null){ 
            if (aux.prioridad){
                if(aux == front){
                    front = front.sig;
                    return aux;
                }
                prev.sig = aux.sig;
                aux.sig = null;
                return aux;
            }
            prev = aux;
            aux = aux.sig;
        }
    }
   
   System.out.println("No hay clientes prioritarios en la cola");
   return null;
  }
  

   public void Desencolar_clientes(){
       int atendidos = 0, orden = 1;
       
    if (this.estaVacia()) {
        System.out.println("No hay nadie en la cola");
    }else{
        while(!estaVacia()){
            atendidos ++;
            if(orden <= 1){
               // Pila.peek(Cola.Desencolar_prioridad());
            }else{
                //Pila.peek(Cola.Desencolar());
                    atendidos ++;
            }
            if(orden > 5){
                orden = 1;
            }
    }
  }
}
  
 public void MostrarCola(){
    if (this.estaVacia()) {
        System.out.println("No hay nadie en la cola");
    }else{  
        Nodo r = front;
        System.out.println("La cola se compone de: ");
        while (r != null){
            System.out.print(" - " + r.clt );
            r = r.sig;
        }
    }
    System.out.println();
 } 
}
