
package taquilla_banco;

public class Pila {
     NodoA top;
    
    void push (NodoA Clt){
        if (this.top==null){
            this.top= Clt;
        }else {
            NodoA temp = this.top;
            this.top= Clt;
            this.top.Down = temp;
        }
         }
    boolean IsEmpty (){
        return this.top== null;  
    }
    NodoA pop (){
        if (this.IsEmpty()){
            System.out.println("La pila esta vacia");
            return null;
        } else {
              NodoA aux = this.top;
              this.top = this.top.Down;
              return aux;
      }
        
     
    }
    NodoA peek(){
        if (this.IsEmpty()) {
            System.out.println("La pila esta vacia");
            return null;
        }else{
            return new NodoA(top.Clientes);
        } 
    }
}
