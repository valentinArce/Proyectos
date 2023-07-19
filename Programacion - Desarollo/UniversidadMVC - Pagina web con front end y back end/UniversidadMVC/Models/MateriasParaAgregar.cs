using System.ComponentModel.DataAnnotations.Schema;

namespace UniversidadMVC.Models
{
    public class MateriasParaAgregar
    {
        public MateriasParaAgregar()
        {

        }

        public string Nombre { get; set; }
        public string Carrera { get; set; }

    }
}
