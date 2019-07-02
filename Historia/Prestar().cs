string Prestar(Libro thisLibro, Lector thisLector){
    bool exito = exito2 = false; int i = 0; string Cadena;
    
    do{
        if (Ejemplares[i].idLibro == thisLibro.id){
            if(Ejemplares[i].estado == 0){
                
            }
        }
        i++;
        if(Libros.Count() == i && exito == false)
        {
            Cadena = "libro no encontrado";
            exito = true;
        }
    }while(!exito && i <= Ejemplares.Count());
    return Cadena;

}