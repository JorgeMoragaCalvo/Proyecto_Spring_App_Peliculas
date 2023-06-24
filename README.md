# dbddemo

Casos de prueba para la base de datos

PASO 1: crear clasificaciones  
{  
"codigo": "clas-01",  
"descripcion": "mayores 18"  
}  


{  
"codigo": "clas-02",  
"descripcion": "mayores 14"  
}  

Paso 1.1: Crear productora

{
  "nombre": "LionsGate"
}

{
  "nombre": "Warner Bros. Entertainment"
}

PASO 2: crear peliculas  
{
"titulo": "Espias",  
"anio": 2001,  
"descripcion": "pelicula accion",  
"duracion": "120m",  
"nombre_archivo": "espias.mp4", 
  "clasificacionEntity": {
    "idClasificacion": 1
  },
  "productoraEntity": {
    "idProductora": 1
  }
}


{  
"titulo": "Terminator",  
"anio": 2010,  
"descripcion": "pelicula accion",  
"duracion": "115m",  
"nombre_archivo": "terminator.mp4",  
    "clasificacionEntity": {  
        "idClasificacion": 1
    },
    "productoraEntity": {
	"idProductora": 2
    }  
}  


{  
"titulo": "Piel Fria",  
"anio": 2021,  
"descripcion": "pelicula drama",  
"duracion": "118m",  
"nombre_archivo": "pielfria.mp4",  
    "clasificacionEntity": {  
        "idClasificacion": 2  
    },
    "productoraEntity": {
	"idProductora": 2
    } 
}


{  
"titulo": "Piratas",  
"anio": 2005,  
"descripcion": "pelicula aventuras",  
"duracion": "120m",  
"nombre_archivo": "piratas.mp4",  
    "clasificacionEntity": {  
        "idClasificacion": 2  
    },
	"productoraEntity": {
		"idProductora": 2
	}  
}  


PASO 3: Crear Series  
{  
"titulo": "Games Of Thrones",  
"descripcion": "serie inglesa",  
"anio": 2015,  
    "clasificacionEntity": {  
        "idClasificacion": 1  
    },
	"productoraEntity": {
		"idProductora": 1
	} 
}


{  
"titulo": "Juego Calamar",  
"descripcion": "serie coreana",  
"anio": 2021,  
    "clasificacionEntity": {  
        "idClasificacion": 2
    },
	"productoraEntity": {
		"idProductora": 2
	}   
}  


PASO 4: Crear Temporada  
{  
"glosa": "Quinta Temporada",  
"anio": 2019,  
    "SerieEntity": {  
        "idSerie": 1  
    }
}  


{  
"glosa": "Primera Temporada",  
"anio": 2021,  
    "SerieEntity": {  
        "idSerie": 2  
    }  
}  


PASO 5: Crear Capitulo  
{  
"titulo": "Inicio",  
"numero": 1,  
"duracion": "45min",  
"nombre_archivo": "inicio.mp4",  
    "TemporadaEntity": {  
        "idTemporada": 2  
    }  
}  


{  
"titulo": "Juegos",  
"numero": 3,  
"duracion": "40min",  
"nombre_archivo": "juegos.mp4",  
    "TemporadaEntity": {  
        "idTemporada": 2  
    }  
}  


{
"titulo": "Winter is Coming",  
"numero": 2,  
"duracion": "42min",  
"nombre_archivo": "winter.mp4",  
    "TemporadaEntity": {  
        "idTemporada": 1  
    }  
}

Caso de prueba para TipoUsuario:

{
  "nombre": "Administrador"
}

{
  "nombre": "Usuario"
}

Caso de prueba para Usuario:

{
  "nombre": "Jorge",
  "apellido": "Moraga",
  "nombreUsuario": "jmoraga",
  "contrasena": "789456",
  "telefono": "982832417",
  "tipoUsuarioEntity": {
    "idTipoUsuario": 1
  }
}

{
  "nombre": "Nicolas",
  "apellido": "Carcamo",
  "nombreUsuario": "ncarcamo",
  "contrasena": "123456",
  "telefono": "964682483",
  "tipoUsuarioEntity": {
    "idTipoUsuario": 2
  }
}

Caso de prueba para TipoSuscripcion:

{
  "idTipoSuscripcion": 0,
  "nombre": "Mensual",
  "descripcion": "Se paga mensualmente",
  "suscripcionEntities": []
}

{
  "idTipoSuscripcion": 0,
  "nombre": "Anual",
  "descripcion": "Se paga anualmente",
  "suscripcionEntities": []
}

Caso de prueba para Suscripcion:

{
  "idSuscripcion": 0,
  "fechaInicio": "2023-06-24T03:37:54.856Z",
  "fechaFin": "2023-06-24T03:37:54.856Z",
  "numeroTarjeta": "3144356546",
  "diaFacturacion": 5,
  "tipoSuscripcionEntity": {
    "idTipoSuscripcion": 1,
    "nombre": "string",
    "descripcion": "string",
    "suscripcionEntities": [
    ]
  }
}

{
  "idSuscripcion": 0,
  "fechaInicio": "2023-06-24T03:37:54.856Z",
  "fechaFin": "2023-06-24T03:37:54.856Z",
  "numeroTarjeta": "8746879856",
  "diaFacturacion": 10,
  "tipoSuscripcionEntity": {
    "idTipoSuscripcion": 2,
    "nombre": "string",
    "descripcion": "string",
    "suscripcionEntities": [
    ]
  }
}