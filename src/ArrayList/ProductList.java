package ArrayList;

import java.util.ArrayList;

public class ProductList {
    private ArrayList<String> productosList=new ArrayList<>();

    // Insertar un elemento
    public void addProduct(String item)
    { productosList.add(item);}

    //Mostrar la lista de elementos
    public void printProductList(){

        System.out.println("Tenemos "+productosList.size()+" elementos en el arraylist ");
        for (int i=0;i<productosList.size();i++)
        {
            System.out.println(productosList.get(i));
        }
    }

    public void modifyProductItem(String oldItem,String newItem) {
        int index = findItem(oldItem);
        if (index >= 0) {
            modifyProductItem(index, newItem);
        }
    }
    public void modifyProductItem(int index,String newItem)
    {
        productosList.set(index,newItem);
    }


    //Eliminar un elemento
    public void removeProductItem(int index)
    {
        String item=productosList.get(index);
        productosList.remove(item);
    }
   public void removeProductItem(String item)
   {
       int index=findItem(item);
       if (index>=0){
           removeProductItem(index);
       }
   }
    // Buscar un elemento
    /*
    public String findItem(String searchItem)
    {
        int index= productosList.indexOf(searchItem);
        if (index>=0){ return (productosList.get(index));}
        return null;
    }
    */

    //Busca un elemento y devuelve su posición , si no lo encuentra devuelve -1
    public int findItem(String searchItem) {
        return productosList.indexOf(searchItem);
    }

   //Comprobar si existe un elemento si lo encuentra devuelve true sino false
    public boolean existsItem( String searchItem)
    {
        return productosList.contains(searchItem);
    }
}
